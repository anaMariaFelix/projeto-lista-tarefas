package teste;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MinhaPrimeiraJanela extends JFrame{
	public MinhaPrimeiraJanela() {
		setTitle("Minha primeira janela");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fecha a janela
		add(new JButton("Não clique aki!"));//adiciona butao
		setSize(500,500);//tamanho da janela
		setLocationRelativeTo(null);//local um a janela vai aparecer
		setLayout(null);
		setVisible(true);//deixa a janela visivel
	}
	
	public static void main(String[] args) {
		new MinhaPrimeiraJanela();
	}
}

