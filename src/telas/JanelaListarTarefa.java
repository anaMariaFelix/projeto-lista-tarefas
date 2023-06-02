package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import aulasSwing.modelo.ListaDeTarefas;
import aulasSwing.modelo.Tarefa;
import projeto.ouvintes.OuvinteDoBotaoSalvarNovaTarefa;

public class JanelaListarTarefa extends JanelaPadrao {
	private JTable tabela;

	public JanelaListarTarefa() {
		super("Listar tarefas", "Lista de tarefas");
		adicionarTabela();
		configurarBotoes();
		setVisible(true);
	}

	public JTable getTabela() {
		return tabela;
	}

	private void configurarBotoes() {
		JButton btEsquerdo = getBotaoEsquerdo();

		btEsquerdo.setText("Detalhar");
		// btEsquerdo.setIcon(new ImageIcon("icones/salvar.png"));
		btEsquerdo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {// quando detalhar for clicado ele execulta esse metodo
				int linhaSelecionada = tabela.getSelectedRow();// esse metodo retorna o indice da linha selecionada na
																// tabela

				if (linhaSelecionada == -1) {// verifica se tem alguma linha selecionada
					JOptionPane.showMessageDialog(null, "Selecione uma linha");// se n tiver exibe essa mensagem

				} else {// se tiver e vai pegar a tarefa que esta naquela linha
//					ListaDeTarefas listaDeTarefas = ListaDeTarefas.ObterInstancia();
//					
//					try {
//						Tarefa t = listaDeTarefas.getTarefaByIndex(linhaSelecionada);//pega a tarefa que representa a linha selecionada
//					
//						String senhaInformada;
//						if(t.isSecreto()) {//verifica se tem uma senha
//							senhaInformada = JOptionPane.showInputDialog("Informe a senha da tarefa");
//						}
//						
//						if((!t.isSecreto())||(t.isSecreto() && t.getSenha().equals(senhaInformada))) {
//							JOptionPane.showMessageDialog(null, t.toString());
//						}else {
//							JOptionPane.showMessageDialog(null, "Você não tem altorização");
//						}
//					
//					}catch(Exception erro) {
//						JOptionPane.showMessageDialog(null,erro.getMessage());
//					}
					// mais uma vez tive que comentar pq n tenho o resto do codigo
				}
			}
		});

		JButton btDireito = getBotaoDireito();
		btDireito.setText("Excluir");
		// btDireito.setIcon(new ImageIcon("icones/salvar.png"));
		btDireito.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = tabela.getSelectedRow();// esse metodo retorna o indice da linha selecionada na
																// tabela

				if (linhaSelecionada == -1) {// verifica se tem alguma linha selecionada
					JOptionPane.showMessageDialog(null, "Selecione uma linha");// se n tiver exibe essa mensagem

				} else {
					int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que quer excluir?", "Remover",
							JOptionPane.YES_NO_OPTION);

					if (resposta == JOptionPane.YES_OPTION) {
						try {
							// exclusao da persistencia
							// ListaDeTarefas listaDeTarefas = ListaDeTarefas.ObterInstancia();
							// listaDeTarefas.excluirByIndex(LinhaSelecionada);//essa linha de codigo remove
							// a linha da persistencia

							// exclusao da interface
							DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();// tem que recuper o modelo																	// defaulttablemodel
							modelo.removeRow(linhaSelecionada);// ai remove a linha selecionada
							tabela.repaint();// atualiza a tabela(interface)

						} catch (Exception erro) {
							JOptionPane.showMessageDialog(null, erro.getMessage());
						}
					}
				}

			}
		});

	}

	private void adicionarTabela() {
		// definir as linhas
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Titulo");// adiciona colunas
		modelo.addColumn("DefLine");
		modelo.addColumn("Dias");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		// definir as linhas
		// ListaDeTarefas listaDeTarefas = ListaDeTarefas.ObterInstancia();
		// ArrayList<Tarefa> todasAsTarefas = listaDeTarefas.getTodasAsTarefas();

//		for(Tarefas t: todasAsTarefas) {
//			Object[] linha = new Object[3];
//			linha[0] = t.getTitulo();
//			Date prazo = t.getPrazo();
//			linha[1] = sdf.format(Prazo);
//			linha[2] = ListaDeTarefas.prazoEmDias(prazo);
//			modelo.addRow(linha);//adiciona alinha
//		}
		// pelo que eu entendi para preencher a tabela usasse um for que vai colocar
		// todas as suas linhas e colunas eu n utilizei pq faltam coisas no meu codigo
		Object[] linha = new Object[3];
		linha[0] = "casamento";
		linha[1] = "09/09/1997";
		linha[2] = "10";
		modelo.addRow(linha);// adiciona alinha

//esses codigos estao comentados pq n tenho o restante das classes

		tabela = new JTable(modelo);
		JScrollPane painelTabela = new JScrollPane(tabela);// esse JScrollPane serve para criar uma barra de rolagem na
															// tabela, mas se n quiser so n usar ele e no lugar que tem
															// a sua variavel de controle coloca a da tabela
		painelTabela.setBounds(30, 90, 320, 190);
		add(painelTabela);
	}
}
