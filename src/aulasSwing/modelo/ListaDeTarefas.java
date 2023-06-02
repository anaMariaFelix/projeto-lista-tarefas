package aulasSwing.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class ListaDeTarefas {

	private static ListaDeTarefas instancia;
	private ArrayList<Tarefa> tarefas;
	
	public ListaDeTarefas() {
		tarefas = new ArrayList<Tarefa>();
	}
//	
//	public static ListaDeTarefas obterInstancia() {
//		if (instancia == null) {
//			PersistenciaProjeto pp = new PersistenciaProjeto();
//			instancia = pp.recuperar("dados.xml");
//			if (instancia.tarefas.size() == 0)
//				popular(instancia);
//		}
//		return instancia;
//	}
//	
//	public void salvar(Tarefa t) {
//		tarefas.add(t);
//		PersistenciaProjeto pp = new PersistenciaProjeto();
//		pp.salvar(this, "dados.xml");
//	}
	
	public HashSet<String> listarTipos() {
		HashSet<String> todosOsTipos = new HashSet<String>();
		
		for(Tarefa t: tarefas) {
			todosOsTipos.add(t.getTipo());
		}
		
		return todosOsTipos;
	}
	
	public static int prazoEmDias(Date data) {
		long agora = System.currentTimeMillis();
		long deadline = data.getTime();
		
		return (int) ((deadline - agora)/(1000*60*60*24));
	}
	
	public ArrayList<Tarefa> getTodasAsTarefas(){
		return tarefas;
	}
	
	public Tarefa getTarefaById(long id) throws Exception {
		for(Tarefa t: tarefas) {
			if (t.getId() == id)
				return t;
		}
		throw new Exception("Tarefa n�o encontrada");
	}
	
	public Tarefa getTarefaByIndex(int indice) throws Exception {
		if (indice < 0 || indice >= tarefas.size())
			throw new Exception("�ndice n�o encontrado");
		
		return tarefas.get(indice);
	}
	
//	public void excluirByIndex(int indice) throws Exception {
//		if (indice < 0 || indice >= tarefas.size())
//			throw new Exception("�ndice n�o encontrado");
//		
//		tarefas.remove(indice);
//		PersistenciaProjeto pp = new PersistenciaProjeto();
//		pp.salvar(this, "dados.xml");
//	}
	
	public int getIndex(Tarefa tarefa) throws Exception {
		for(int i = 0; i < tarefas.size(); i++) {
			if (tarefa.equals(tarefas.get(i)) == true) {
				return i;
			}
		}
		throw new Exception("Tarefa n�o encontrada");
	}
	
	private static void popular(ListaDeTarefas ldt) {
		String[] titulos = {"Fazer dever", "Lavar quarto", "Pagar a conta"};
		String[] descricoes = {"Preciso resolver isso logo", "J� devia ter feito isso"};
		String[] prazos = {"31/12/2020", "01/02/2021", "13/09/2020", "07/08/2020"};
		String[] tipos = {"Contas", "Escola", "Casa", "Lazer"};
		boolean[] secreto = {true, false};
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		for(int i = 0; i < 10; i++) {
			Tarefa t = new Tarefa();
			t.setTitulo(sortear(titulos));
			t.setDescricao(sortear(descricoes));
			t.setTipo(sortear(tipos));
			try {
				t.setPrazo(sdf.parse(sortear(prazos)));
			} catch (ParseException e) {
			}
			t.setSecreto(secreto[i%2]);
			if (t.isSecreto())
				t.setSenha("12345");
			//ldt.salvar(t);
		}
	}

	private static String sortear(String[] vetor) {
		return vetor[(int)(Math.random()*vetor.length)];
	}
	
}
