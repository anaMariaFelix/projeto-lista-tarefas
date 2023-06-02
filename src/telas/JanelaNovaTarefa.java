package telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;

import aulasSwing.modelo.ListaDeTarefas;
import projeto.ouvintes.OuvinteDoBotaoSalvarNovaTarefa;

public class JanelaNovaTarefa extends JanelaPadrao {
	
	private JTextField fTitulo;
	private JFormattedTextField tfDedLine;
	private JTextField tfDias;
	private JPasswordField pfSenha;
	private JTextArea tfDescricao;
	private JComboBox<String> cbTipos;
	private JCheckBox cbNovo;
	private JTextField tfTipo;
	private JRadioButton  rbPublico;
	private JRadioButton  rbPrivado;

	

	//para conseguir acessar as informacoes dos campos
	//todos eles precisam ser atributos da minha janela
	
	

	public JanelaNovaTarefa() {
		super("Nova janela","TO DO LIST");
		adicionarLabel();
		adicionarCombo();
		adicionarTexteFilds();
		adicionarCheckBox();
		adicionarRadioButtons();
		configurarBotoes();
		setVisible(true);

	}
	
	public JFormattedTextField getTfDedLine() {
		return tfDedLine;
	}

	public JTextField getTfDias() {
		return tfDias;
	}

	public JPasswordField getPfSenha() {
		return pfSenha;
	}

	public JTextArea getTfDescricao() {
		return tfDescricao;
	}

	
	public JTextField getfTitulo() {
		return fTitulo;
	}
	public JComboBox<String> getCbTipos() {
		return cbTipos;
	}
	public JCheckBox getCbNovo() {
		return cbNovo;
	}
	public JTextField getTfTipo() {
		return tfTipo;
	}

	public JRadioButton getRbPublico() {
		return rbPublico;
	}

	public JRadioButton getRbPrivado() {
		return rbPrivado;
	}
	//classe do ouvinte 
	//criada para ter acesso ao campo de titulo
	//em java é posivel colocar uma classe dentro de outra
	//como o ouvinte ja esta dentro da propria classe ele consegue ter acessos as coisas sem precisar de um atributo 
	//diferente do ouvinte externo que precisaria de um atributo para acessar as coisas
	private class OuvinteDoTitulo implements KeyListener{

		//esse metodo é chamado quando componente que o objeto tiver ouvindo dentro dele o botao dentro do cam
		@Override
		public void keyPressed(KeyEvent e) {
			char c = e.getKeyChar();
			if(!Character.isLetter(c) && c != ' ') {
				fTitulo.setBackground(Color.RED);//coloca o campo todo vermelho sempre que uma tecla que n seja um letra for toca
			}else {
				fTitulo.setBackground(Color.GREEN);
			}
		}

		//é chamado quando o botao que esta sento apertado for soltado
		@Override
		public void keyReleased(KeyEvent e) {
			fTitulo.setBackground(Color.WHITE);//quando o botao e solto o campo volta a ficar branco
			
		}
		
		//chamado quando o botao ja foi apertado e soltado, quando as coisas sao digitadas
		@Override
		public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar(); //retorna o caracter da tecla que foi precionada
			
			if(!Character.isLetter(c) && c != ' ') {//Character.isLetter verifica se oq foi digitado é uma letra
				e.consume();//ignora a letra digitada
				//esse if é para que so seja posivel digitar letras dentro do campo
				//se o usuario digitar qualquer coisa que n seja letra ele n é aceito e nem visivel no campo
			}	
		}
		
		
	}
	

	
	//outro titulo
	public void adicionarLabel(){
		JLabel lb = new JLabel("TITULO");
		lb.setBounds(30, 75, 45, 30);	
		lb.setBackground(Color.cyan);
		lb.setOpaque(true);
		add(lb);
		
		JLabel lbDeadline = new JLabel("Deadline");
		lbDeadline.setBounds(30, 175, 49, 30);
		add(lbDeadline);
		
		JLabel lbDias = new JLabel("dias");
		lbDias.setBounds(305, 175, 30, 30);
		add(lbDias);
	}
	
	//JTextField adiciona um campo que o usuario pode digital algo
	private void adicionarTexteFilds() {
		fTitulo = new JTextField();
		fTitulo.setBounds(79, 75, 265, 30);
		fTitulo.setFont(new Font("Courier new",Font.ITALIC,11));//fonte do texto que o uduario digita e o tamenho
		//tffild.setEnabled(false);        //deixta o campo de texto inacessivel
		
		OuvinteDoTitulo ouvinte = new OuvinteDoTitulo();//estancia um ouvinteDoTitulo aki pq é pra ele ouvir esse campo
		fTitulo.addKeyListener(ouvinte);//o campo passa a ser ouvido pelo ouvinte
		add(fTitulo);
		
		try {
			MaskFormatter mascaraDeData = new MaskFormatter("##/##/####");//mascara que formata o campo de texto # representa um numero inteiro
			tfDedLine = new JFormattedTextField(mascaraDeData);//campo especil do JTextFild formatado para conter um texto dentro
			tfDedLine.setBounds(90, 175, 150, 30);
			tfDedLine.setHorizontalAlignment(JLabel.CENTER);//alinha as barras do componente no centro
			add(tfDedLine);
		} catch (ParseException e) {
		
		}
		
		
		tfDedLine.addFocusListener(new FocusListener() {//esse ouvite de foco e invocado sempre que um componente recebe um foco ou perde um foco
			
			@Override
			public void focusLost(FocusEvent e) {//quando o campo perde o foco ele ezeculta esse metodo
				String valorAtual = tfDedLine.getText();//pega o valor atual do tfdedline
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");//verifica se é uma data valida
				try {
					Date dataValida = sdf.parse(valorAtual);//converte de string para date
					int prazoEmDias = ListaDeTarefas.prazoEmDias(dataValida);
					tfDias.setText(prazoEmDias+"");
				} catch (ParseException e1) {
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				System.out.println("foco");
				
				
			}
		});
		
		tfDias = new JTextField();
		tfDias.setEnabled(false);
		tfDias.setBounds(250,175,50,30);
		add(tfDias);
		
		
		tfDescricao = new JTextArea();//e um campo que suporta multiplas linhas(testo)
		tfDescricao.setText("Descrição: ");//palavra que aparece dentro do campo
		JScrollPane painel = new JScrollPane(tfDescricao);// JScrollPane é uma barra de rolagem que aparece quando o texto n cabe mas no campo
		painel.setBounds(30, 110, 317, 55);
		tfDescricao.setLineWrap(true);//quando o texto n cabe mas na linha ele quebra o texto para a proxima linha
		tfDescricao.setWrapStyleWord(true);//quebra o texto tbm para a proxima linha mas ele coloca a palavra completa na proxima linha
		add(painel);
		
		
		//ouvinte anonimo para quando o campo receber foco o "descriçao " que esta dentro dele saia
		tfDescricao.addFocusListener(new FocusListener() {// FocusListener verifica se o campo recebel foco 
			
			@Override
			public void focusLost(FocusEvent e) {//quando perde o foco
				JTextArea tf = (JTextArea) e.getSource();
				String texto = tf.getText();
				
				if(texto.trim().equals("")) {//nesse metodo quando o campo perde o foco se(if) ele tiver vazio ele volta a ter a palvra "descrição " dentro dele
					tf.setText("Descrição: ");
					tf.repaint();
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {//quando ganha foco
				JTextArea tf = (JTextArea) e.getSource();//pega o jtextArea
				String texto = tf.getText();
				
				if(texto.equals("Descrição: ")) {//se for igual quando ele receber foco ai ele atualiza para barnco(sem nada)
					tf.setText("");//passa a ser vazio
					tf.repaint();//atualiza
				}
			}
		});
		
		pfSenha = new JPasswordField();//usado para senhas e loguin e um campo que não permite ver oq esta sendo digitado 
		pfSenha.setBounds(215, 260, 130, 30);
		pfSenha.setEnabled(false);//conportamento padrao dele e inacessivel so vai ser acessivel quando um radio button for escolhido
		add(pfSenha);
		
		tfTipo = new JTextField();
		tfTipo.setBounds(214, 210, 130, 30);
		if(cbTipos.getItemCount() != 0) {//getItemCount verifica se tem itens
			tfTipo.setEnabled(false);//inacesivel
		}
		add(tfTipo);
	}

	
	private void configurarBotoes() {
		JButton btEsquerdo = getBotaoEsquerdo();
		
		OuvinteDoBotaoSalvarNovaTarefa ouvinte = new OuvinteDoBotaoSalvarNovaTarefa(this);//esse this representa a janela que esta sendo criada ou seja a janela atual
		
		btEsquerdo.addActionListener(ouvinte);//conecta o botao com a classe ouvinte, e o ouvinte passa a ouvir o botao, e quando o botao for clicado a ação escrita no metodo da clase vai ser execultada
		btEsquerdo.setText("salvar");
		btEsquerdo.setIcon(new ImageIcon("icones/salvar.png"));
		
		JButton btDireito = getBotaoDireito();
		btDireito.setText("Limpar campos");
		btDireito.addMouseListener(new MouseListener() {//botao direto tem um ouvinte do tipo mouseLister e como é uma interface é obrigado a implementar todos os seus metodos
			//ouvinte anonimo
			//o codigo do ouvite anonimo so existe no canto ele foi feito para utilizar em outro canto teria que copiar e colar oq seia uma desvantagem
			//esse mes codigo poderia esta em um ouvinte interno ou externo
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				getBotaoDireito().setBackground(Color.YELLOW);
				
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				getBotaoDireito().setBackground(null);
				
			}
			
		});
		btDireito.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new JanelaNovaTarefa();
				
			}
		});
	}
	
	public void adicionarCombo() {
		//ListaDeTarefas listaDeTarefas = ListaDeTarefas.obterInstancia();
//		HastSet<String> sacoDeStrings = listarDeTarefas.lisarTipos();
//		if(sacoDeStrings.size() > 0){
//			String[] arrayDeTipos = new String[sacosDeString.size()];
//			int i = 0;
//			for(String s: sacosDeStrings) {
//				arrayDeTipos[i++];
//			}
//	    }
		// não consigo usar essas linhas que estao comentadas pq n tenho a classe persistencia
		String[] titulos = {"Fazer dever", "Lavar quarto", "Pagar a conta"};//JComBox e um campo com opcoes para o usuario escolher uma
		cbTipos = new JComboBox<String>(titulos);
		cbTipos.setBounds(30, 210, 125, 30);
		add(cbTipos);
	}
	
	private class ouvinteDoCheckBox implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(cbNovo.isSelected()) {//if cbnovo tiver selecionado(isSelected
				cbTipos.setEnabled(false);
				tfTipo.setEnabled(true);//desabilita o campo
			}else {
				tfTipo.setEnabled(false);//desabilita o campo
				cbTipos.setEnabled(true);
			}
			
		}
		
	}
	public void adicionarCheckBox() {
		cbNovo = new JCheckBox("Novo",false);//campinho que pode ser marcado
		cbNovo.setBounds(160,210, 55, 30);
		if(cbTipos.getItemCount() == 0) {
			cbNovo.setSelected(true);
			cbNovo.setEnabled(false);
		}
		cbNovo.addActionListener(new ouvinteDoCheckBox());
		add(cbNovo);
	}
	
	
	private class OuvinteRadioButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
//			if(rbPublico.isSelected()) {
//				pfSenha.setEnabled(false);
//			}else {
//				pfSenha.setEnabled(true);
//			}
			pfSenha.setEnabled(rbPrivado.isSelected());//isselected verifca se ele esta selecionado
			pfSenha.repaint();//atualiza
		}
		
	}
	public void adicionarRadioButtons() {
		OuvinteRadioButton ouvinte = new OuvinteRadioButton();
		
		rbPublico = new JRadioButton("Publico",false);
		rbPublico.setBounds(30, 245, 70, 30);
		rbPublico.addActionListener(ouvinte);
		
		
		
		rbPrivado = new JRadioButton("Privado",true);
		rbPrivado.setBounds(110, 245, 70, 30);
		rbPrivado.addActionListener(ouvinte);
		add(rbPrivado);
		add(rbPublico);
		
		ButtonGroup bg = new ButtonGroup();//nao deixa marca os dois raidios button ao msm tempo apenas um deles
		bg.add(rbPrivado);
		bg.add(rbPublico);
		
	}
}
