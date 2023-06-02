package testesaula;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MinhaPrimeiraJanelaAula extends JFrame{
	public MinhaPrimeiraJanelaAula(String titulo) {
		setTitle(titulo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fecha a janela
		setSize(400,200);//tamanho da janela
		setLayout(null);//apaga o gerenciador de layout
		setResizable(false);
		botao();
		adicionarRotulo();
		setVisible(true);//deixa janela visivel

	}
	
	public void botao() {
		JButton botao = new JButton("clique em mim");//coloca botao na tela
		botao.setBounds(45, 90, 300, 30);//dimencoes do botao
		add(botao);//cria botao 
		
	}
	
	public void adicionarRotulo() {
		JLabel rotulo = new JLabel("Primeiro botao",JLabel.CENTER);
		rotulo.setBackground(Color.blue);
		rotulo.setToolTipText("Primeiro programa feito em sala");
		rotulo.setOpaque(true);
		rotulo.setBounds(0,10,400,30);
		add(rotulo);
		
	}

}
