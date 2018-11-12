import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.event.ListSelectionEvent;

public class Crie_conta extends JFrame implements ActionListener  {
	
	private Connection connection;
	
		//Variaveis
		JTextField usuario1;
		JLabel Crie_conta, usuario,senha,confirm_senha,Info,Info2;
		JPasswordField Sx,Sx1;
		JButton criar_conta;    

   public Crie_conta(){
	   //Frame!
	  setTitle("Schedule Recreation");
	  setSize(800,600);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setResizable(false);
	 
	  
	  //Label "Criar conta"
	  Crie_conta = new JLabel("Criar Conta");
	  Crie_conta.setLocation(300,20);	
	  Crie_conta.setSize(600,60);
	  Crie_conta.setFont(new Font("IntelliJ", Font.BOLD, 30));
	  //Label "Confirmar Senha"
	  confirm_senha = new JLabel("Confirme a senha");
	  confirm_senha.setLocation(225,280);
	  confirm_senha.setSize(200,30);
	  confirm_senha.setFont(new Font("IntelliJ", Font.BOLD, 14));
	  //Label "Usuario"
      usuario = new JLabel("Nome de Usuário ");
      usuario.setLocation(225,130);
      usuario.setSize(200,20);
      usuario.setFont(new Font("IntelliJ", Font.BOLD, 14));
    //"Informação de senha não compativel"
      Info = new JLabel("");
      Info.setLocation(225,350);
      Info.setSize(500,30);
      Info.setFont(new Font("IntelliJ", Font.BOLD, 14));
      Info.setForeground(Color.red);
    //"Informação de senha não compativel"
      Info2 = new JLabel("");
      Info2.setLocation(225,350);
      Info2.setSize(500,30);
      Info2.setFont(new Font("Intellij", Font.BOLD, 14));
      Info2.setForeground(Color.red);
      //Label "senha"
      senha = new JLabel("Senha ");
      senha.setLocation(225,200);
      senha.setSize(150,30);
      senha.setFont(new Font("IntelliJ", Font.BOLD, 14));
      //TExtFiel "Usuario"
      usuario1 = new JTextField("");
      usuario1.setSize(320,30);
      usuario1.setLocation(225,160);
      usuario1.setFont(new Font("IntelliJ", Font.BOLD, 14));
      //PasswordField "Senha"
      JPasswordField Sx = new JPasswordField();
      this.Sx = Sx ;
      Sx.setEchoChar('*');
      Sx.setSize(320,30);
      Sx.setLocation(225,230);
      Sx.addActionListener(this);
      Sx.setFont(new Font("IntelliJ", Font.BOLD, 14));
      //PasswordField "confirme Senha"
      JPasswordField Sx1 = new JPasswordField();
      this.Sx1 = Sx1 ;
      Sx1.setEchoChar('*');
      Sx1.setSize(320,30);
      Sx1.setLocation(225,320);
      Sx1.addActionListener(this);
      Sx1.setFont(new Font("IntelliJ", Font.BOLD, 14));
      //Botao "Criar Conta"
      criar_conta = new JButton("Criar sua Conta");
      criar_conta.setSize(150,30);
	  criar_conta.setLocation(300,400);
	  criar_conta.setBackground(new Color (248, 248, 255));
	  criar_conta.setFont(new Font("IntelliJ", Font.BOLD, 12));
	  criar_conta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	  criar_conta.addActionListener(this);
		
      //"Add componentes frame!"
      getContentPane().setLayout(null);
      getContentPane().add(Crie_conta);
      getContentPane().add(usuario);
      getContentPane().add(senha);
      getContentPane().add(usuario1);
      getContentPane().add(confirm_senha);
      getContentPane().add(criar_conta);
      getContentPane().add(Info);
      getContentPane().add(Info2);
      getContentPane().add(Sx);
      getContentPane().add(Sx1);
      getContentPane().setBackground(new Color(127,255,212));
   }
   
   //Main "Inicio"
   public static void main (String arg[])
   {
      new Crie_conta().setVisible(true);
   }

   
  //Inserir dados
 public static void executa_inserir (String sql){
	   
	   Connection conexao;
	try {
		conexao = DriverManager.getConnection ("jdbc:mysql://localhost:3306/Schedule_Recreation", "root", "pain12345");
		Statement st = null;
   		st = conexao.createStatement();
   		st.executeUpdate(sql);
   		
	} catch (SQLException e) {
	
		e.printStackTrace();
		}	
	}


   //Eventos "Funcionalidade dos botões e acões"
   public void actionPerformed(ActionEvent e) {
	   
	   if(Sx.getText().equals(Sx1.getText())){
		   if(!usuario1.getText().equals("") && !Sx.getText().equals("")) {
		   executa_inserir("Insert into Usuario values ('"+usuario1.getText()+"','"+Sx.getText()+"')");  
		   Password obj = new Password();
			obj.setVisible(true);
			dispose(); 		
	   }
	   else {
		   if(usuario1.getText().equals("") && Sx.getText().equals("")) {
			Info.setText(null);
		    Info2.setText("Campos Usuário e senha obrigatorios!");
		    	 
		   }  	
		   else if (Sx.getText().equals(Sx1.getText())) {
		   }   
	   	}	
	   }
	   else {
		   Info2.setText(null);
		   Info.setText("Senhas incompativeis, tente novamente!");	  
		   }
   		}
}