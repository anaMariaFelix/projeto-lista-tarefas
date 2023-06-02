package telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JanelaPadrao extends JFrame{
	private JButton botaoEsquerdo;
	private JButton botaoDireito;
	
	public JanelaPadrao(String titulo,String cabecalho) {
		setTitle(titulo);
		setSize(400,400);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		adicionarTitulo(cabecalho);
		adionarBotoes();
		adicionarMenur();
		
		
	}
	//tudo para um unico titulo JLabel
	private void adicionarTitulo(String titulo) {
		ImageIcon icone = new ImageIcon("icones/ifpb.png"); //coloca um icone
		JLabel lbTitulo = new JLabel(titulo,icone,JLabel.CENTER);
		lbTitulo.setBounds(0, 20, 400, 50);                    //local e tamanho do texto
		lbTitulo.setFont(new Font("Arial",Font.BOLD,20));      //fonte do texto, pode ser qualquer fonte
		//lbTitulo.setHorizontalAlignment(JLabel.CENTER);      //alinha o texto no centro
		lbTitulo.setForeground(Color.green);                   //cor do texto
		lbTitulo.setBackground(Color.gray);                    //cor do fundo do texto ajuda a perceber se o texto esta no canto certo
		lbTitulo.setOpaque(true);                              //deixa o funto vizivel ajuda a perceber se o texto esta no canto certo
		lbTitulo.setToolTipText("esse projeto foi desenvolvido para fins academicos");//dica: quando mause passa por cima do texto essa frase aparece   
		add(lbTitulo);
	}
	
	public class ouvinteMenu implements ActionListener{
		private JFrame janela;
		
		public ouvinteMenu(JFrame janela) {
			this.janela = janela;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String opcao = e.getActionCommand();//retorna o totulo do botao clicado
			
			
			switch (opcao) {
			case "Listar":
				if(!(janela instanceof JanelaListarTarefa)) {
					dispose();//fecha a janela atual
					new JanelaListarTarefa();
				}
				break;
			
			case"Novo":
				if(!(janela instanceof JanelaNovaTarefa)) {
					dispose();//fecha a janela atual
					new JanelaNovaTarefa();
				}
				break;
				
			case"Sair":
				dispose();//fecha a janela atual
				break;
				
			}
			
		}
		
	}
	
	public JButton getBotaoEsquerdo() {
		return botaoEsquerdo;
	}

	public void setBotaoEsquerdo(JButton botaoEsquerdo) {
		this.botaoEsquerdo = botaoEsquerdo;
	}

	public JButton getBotaoDireito() {
		return botaoDireito;
	}

	public void setBotaoDireito(JButton botaoDireito) {
		this.botaoDireito = botaoDireito;
	}

	
	//JButton criar os botoes 
	private void adionarBotoes() {
		 ImageIcon icone = new ImageIcon("C:/Usersanasi/OneDrive/Documentos/workspace-eclipse/aulasSwing/icones/salve-.png"); //coloca um icone
		 botaoEsquerdo = new JButton("BT esquerdo",icone);
		 //botaoEsquerdo.setIcon(icone);
		 add(botaoEsquerdo);
		 botaoEsquerdo.setBounds(34, 300, 130, 30);
		 botaoDireito = new JButton("BT Direito");
		 botaoDireito.setBounds(215, 300, 130, 30);
		 add(botaoDireito);
		 
		 //pode colocar icones tbm nos botes so estanciar uma imageIcone e passas o caminho do icone e nome dele
	}
	
	private void adicionarMenur() {
		JMenuBar barraDeMenu = new JMenuBar();//cria uma barra de menu
		setJMenuBar(barraDeMenu);//barra de menu dessa janela
		
		ouvinteMenu ouvinteDoMenu = new ouvinteMenu(this);
		
		JMenu menuOpcoes = new JMenu("opções");//representa uma opçao no menu, o nome do menu
		menuOpcoes.setMnemonic('o');//setMnemonic cria uma tecla de atalho para a opcao apertando "alt" e aletra que foi definida como padaro
		barraDeMenu.add(menuOpcoes);//adicionou ele ao menu
		
		JMenuItem itemListar = new JMenuItem("Listar");//jmetuItem são as opcoes que existem dentro do menu
		itemListar.setMnemonic('l');
		itemListar.addActionListener(ouvinteDoMenu);//o item listar vai ser ouvido pelo ouvinte
		itemListar.setIcon(new ImageIcon("icones/lista2.png"));
		menuOpcoes.add(itemListar);
		
		JMenuItem itemNovo = new JMenuItem("Novo");
		itemNovo.setMnemonic('n');
		itemNovo.addActionListener(ouvinteDoMenu);
		itemNovo.setIcon(new ImageIcon("icones/novo.png"));
		menuOpcoes.add(itemNovo);
		
		JMenuItem itemSair = new JMenuItem("Sair");
		itemSair.setMnemonic('s');
		itemSair.addActionListener(ouvinteDoMenu);
		itemSair.setIcon(new ImageIcon("icones/sair.png"));
		menuOpcoes.add(itemSair);
		
	}

}
