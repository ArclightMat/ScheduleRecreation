import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Serie_Excluir extends JFrame implements ActionListener,ItemListener {

	private Connection connection;
	
	//Variavel
		JLabel L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11,L12,L13,L14,L15,Info;
		JButton bExcluir,bLogoff,bVoltar_inicio;
		JRadioButton byes,bno;
		JTextField tNome;
		ButtonGroup bg;
	
	
	public  Serie_Excluir() {
		
		//Frame!
		setTitle("Excluir os dados cadastrados");
		setSize(800,600);
		setLocation(100,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		//Label excluir
		L1 = new JLabel("Excluir os dados arquivados da serie cadastrada");
		L1.setSize(400,20);
		L1.setLocation(300,30);
		L1.setFont(new Font("IntelliJ", Font.BOLD, 16));
		//Label nome serie
		L2 = new JLabel("Nome da serie:");
		L2.setSize(100,20);
		L2.setLocation(50,80);
		L2.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//Label Temporadas
		L3 = new JLabel("Temporadas:");
		L3.setSize(100,20);
		L3.setLocation(50,130);
		L3.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//Label qnts ep
		L4 = new JLabel("Quantos Episódios:");
		L4.setSize(115,20);
		L4.setLocation(330,130);
		L4.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//att
		L5 = new JLabel("Atualizado?");
		L5.setSize(150,20);
		L5.setLocation(555,130);
		L5.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//Label qual temp
		L6 = new JLabel("Está na temporada:");
		L6.setSize(200,20);
		L6.setLocation(50,180);
		L6.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//Label sinopse
		L7 = new JLabel("Sinopse da serie:");
		L7.setSize(200,20);
		L7.setLocation(50,250);
		L7.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//Label coments
		L8 = new JLabel("Comentários sobre a serie:");
		L8.setSize(200,20);
		L8.setLocation(50,370);
		L8.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//Label qual ep
		L9 = new JLabel("Está em qual Episódio:");
		L9.setSize(135,20); 
		L9.setLocation(330,180);
		L9.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//temp
		L10 = new JLabel ("");
		L10.setSize(80,20);
		L10.setLocation(220,130);
		L10.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//qts ep
		L11 = new JLabel ("");
		L11.setSize(80,20);
		L11.setLocation(465,130);
		L11.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//qual temp
		L12 = new JLabel ("");
		L12.setSize(80,20);
		L12.setLocation(220,180);
		L12.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//sinopse
		L13 = new JLabel ("");
		L13.setSize(80,20);
		L13.setLocation(465,180);
		L13.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//coments
		L14 = new JLabel ("");
		L14.setSize(530,20);
		L14.setLocation(220,250);
		L14.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//qual ep
		L15 = new JLabel ("");
		L15.setSize(530,20);
		L15.setLocation(220,370);	
		L15.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//nome
		tNome = new JTextField("");
		tNome.setSize(530,20);
		tNome.setLocation(220,80);
		tNome.setDocument(new charlimite(73));
		tNome.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//Label info salvo
		Info = new JLabel("");
		Info.setSize(300,20);
		Info.setLocation(300,480);
		Info.setFont(new Font("Intellij", Font.BOLD, 12));
		Info.setForeground(Color.red);
		//botao
		byes = new JRadioButton ("Sim",true);
		byes.setSize(50,20);
		byes.setLocation(600,180);
		bno= new JRadioButton ("Não",false);
		bno.setSize(50,20);
		bno.setLocation(660,180);
		bg = new ButtonGroup();
		bg.add(byes);
		bg.add(bno);
		//Botao Excluir"
		bExcluir = new JButton("Excluir");
		bExcluir.setSize(150,30); 
		bExcluir.setLocation(140,525);
		bExcluir.setBackground(new Color (248, 248, 255));
		bExcluir.setFont(new Font("IntelliJ", Font.BOLD, 12));
		bExcluir.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		bExcluir.addActionListener(this);
		//botao logoff
		bLogoff = new JButton("Fazer Logoff");
		bLogoff.setSize(150,30);
		bLogoff.setLocation(500,525);
		bLogoff.setFont(new Font("IntelliJ", Font.BOLD, 12));
		bLogoff.setBackground(new Color (248, 248, 255));
		bLogoff.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		bLogoff.addActionListener(this);
		//botao voltar menu
		bVoltar_inicio = new JButton("Voltar ao menu");
		bVoltar_inicio.setSize(150,30);
		bVoltar_inicio.setLocation(320,525);
		bVoltar_inicio.setFont(new Font("IntelliJ", Font.BOLD, 12));
		bVoltar_inicio.setBackground(new Color (248, 248, 255));
		bVoltar_inicio.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		bVoltar_inicio.addActionListener(this);
							
							
		//Add Componentes do Frame!
		getContentPane().setLayout(null);
		getContentPane().add(L1);
		getContentPane().add(L2);
		getContentPane().add(L3);
		getContentPane().add(L4);
		getContentPane().add(L5);
		getContentPane().add(L7);
		getContentPane().add(L8);
		getContentPane().add(tNome);
		getContentPane().add(L10);
		getContentPane().add(L11);
		getContentPane().add(L12);
		getContentPane().add(L13);
		getContentPane().add(L14);
		getContentPane().add(L15);
		getContentPane().add(byes);
		getContentPane().add(bno);
		getContentPane().add(Info);
		getContentPane().add(bLogoff);
		getContentPane().add(bVoltar_inicio);
		getContentPane().add(bExcluir); ;
		getContentPane().setBackground(new Color(127,255,212));
	}

	//Main "Inicio"
	public static void main(String[] args) {
		new Serie_Excluir().setVisible(true);
	}

	//
	public void itemStateChanged(ItemEvent e) {
		
	}

			//Eventos "Funcionalidade dos botões e acões"
			public void actionPerformed(ActionEvent e) {

			try {		
					String sql = "select * from Serie where nome_serie like '"+tNome.getText()+"'";
					Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/Schedule_Recreation", "root", "pain12345");
					PreparedStatement select = con.prepareStatement(sql);
					ResultSet resultado = select.executeQuery(sql);
			while(resultado.next()) {
					L10.setText(resultado.getString("qntd_temp"));
					L11.setText(resultado.getString("qntd_ep"));
					L12.setText(resultado.getString("qual_temp"));
					L13.setText(resultado.getString("qual_ep"));
					L14.setText(resultado.getString("comentarios"));
					L15.setText(resultado.getString("criticas"));
		}
	}

			catch (SQLException e1) {
	e1.printStackTrace();

}
		if(e.getSource() == bExcluir) {
	 		try 
	 {
	 			Connection conexao = DriverManager.getConnection ("jdbc:mysql://localhost:3306/Schedule_Recreation", "root", "pain12345");
	 			PreparedStatement update = conexao.prepareStatement("Delete from Serie where nome_serie like '"+tNome.getText()+"'");
	 			update.executeUpdate();			
	 }
	 
	 			catch(Exception erro) {}
			   
	 	if(tNome.getText().equals("")) {
	 			Info.setText("Insira a serie para realizar a exclusão!");
		}
	
  		else if(L10.getText().equals("")) {
		
				Info.setText("Serie não encontrado no Banco de dados!");
  	}
  		else {
  				Info.setText("Serie excluido com sucesso!");
		   		
 		}
 	}   		
 		else if(e.getSource() == bVoltar_inicio) {
 			Menu obj = new Menu();
			obj.setVisible(true);
			dispose(); 
		}
		else if(e.getSource() == bLogoff) {
			Password obj = new Password ();
			obj.setVisible(true);
			dispose();
		}
		
	}
		//Limita a quantidade de caracteres!
	public class charlimite extends PlainDocument{
	    private int tamanhoMax = 10;
	         
	    public charlimite(int tamanhoMax){
	        this.tamanhoMax = tamanhoMax;
	    }
	    @Override
	    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
	 
	            if (str == null) return;  
	                    
	             String stringAntiga = getText (0, getLength() );  
	             int tamanhoNovo = stringAntiga.length() + str.length(); 
	                        
	             if (tamanhoNovo <= tamanhoMax) {  
	                 super.insertString(offset, str , attr);  
	             } else {    
	                 super.insertString(offset, "", attr); 
	             }  
	    }
	}
}
