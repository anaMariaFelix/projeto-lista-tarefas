package projeto.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import aulasSwing.modelo.Tarefa;
import telas.JanelaListarTarefa;
import telas.JanelaNovaTarefa;
//ouvinte externo
//é possivel usar esse ouvinte em outras classes que tenham algo referente ao ouvinte em comun
public class OuvinteDoBotaoSalvarNovaTarefa implements ActionListener{
	private JanelaNovaTarefa janela;
	private DateFormat formatadoDate;
	
	public OuvinteDoBotaoSalvarNovaTarefa(JanelaNovaTarefa janela) {
		this.janela = janela;
		//esse metodo foi criado apara recber uma janela, para que 
		//a caixa do que informa que o botao foi clicado apareça no centro dela
		
	}
	
	//como a classe implementa de ActionListener ela tem que codificar esse metodo
	public void actionPerformed(ActionEvent clique) {
		//esse metodo faz oq eu quero que aconteça quando um botao for clicado
		String titulo = janela.getfTitulo().getText();
		String descricao = janela.getTfDescricao().getText();
		String senha = new String(janela.getPfSenha().getPassword());//deveria ter sido usado o gettext 
		//mais para o caso de senha ele n é mas recomendado dai usa o getPassword mas ele retorna um array de char, por esse motiver teve que estanciar uma new String e colocar tudo dentro isso tem o msm resultado que o gettext 
		
		String dedlineString = janela.getTfDedLine().getText();//o dedlineString chega como string mas ele tem que ser do tipo date, por isso cria uma variavel do tipo dete para receber ela
		SimpleDateFormat formatadorDate = new SimpleDateFormat("dd/MM/yyyy");
		Date dedlineDate = null;
		
		try {
			dedlineDate = formatadorDate.parse(dedlineString);
		} catch (ParseException e) {	
		} 
		
		Tarefa t = new Tarefa();
		t.setTitulo(titulo);
		t.setDescricao(descricao);
		t.setPrazo(dedlineDate);
		t.setSecreto(janela.getRbPrivado().isSelected());//se o privado tiver maracdo entao e secreto
		if(janela.getRbPrivado().isSelected()) {//se tiver marcado entao t.setsenha recebe a senha
			t.setSenha(senha);
		}
		
		
		String tipo = null;//pega o intem que foi escolhido pelo usuario no jcombobox
		if(janela.getCbNovo().isSelected()) {
			tipo =(String) janela.getCbTipos().getSelectedItem();
		}
		t.setTipo(tipo);
		
		//ListaDeTarefas listaDeTarefas = ListaDeTarefas.obterInstancia();
		//listaDeTarefas.salvar(t);
		
		janela.dispose();
		JOptionPane.showMessageDialog(janela, "Tarefa salva com sucesso");
		new JanelaListarTarefa();
		//long instanteClique = clique.getWhen();// me diz quando aconteceu o cliqu
		//String comandoAcao = clique.getActionCommand(); //diz qual o rotulo do texto do butao
		//JButton botao = (JButton) clique.getSource(); //recupera um botao
		
		//caso eu crie um ouvinte para varios comandos o getActionCommand e o getSorce perdmite diferenciar a ação de um botao do outro
		
	}

}
