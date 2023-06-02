package teste;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ExemploJFrame {
	public static void main(String[] args) {
		JFrame janela = new JFrame("Minha primeira janela");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fecha a janela
		janela.add(new JButton("Não clique aki!"));//adiciona butao
		janela.setSize(500,500);//tamanho da janela
		janela.setLocationRelativeTo(null);//local um a janela vai aparecer
		janela.setVisible(true);//deixa a janela visivel
	
	}
}
