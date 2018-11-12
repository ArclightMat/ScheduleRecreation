import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.sql.*;

public class Password extends JFrame implements ActionListener  {
   private Connection connection;
	
	//Variaveis!
   	int controla;
		JTextField usuario1;
		JLabel login, usuario,senha,Info;
		JPasswordField Sx;
		JButton Fazer_login,criar_conta;    
		
   public Password(){
	  
	  //Frame!
	  setTitle("Schedule Recreation");
	  setSize(800,600);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setResizable(false);
	  
	  //Label "Login"
	  login = new JLabel("Fazer Login");
	  login.setLocation(300,20);	
	  login.setSize(600,60);
	  login.setFont(new Font("IntelliJ", Font.BOLD, 30));
	  //Label "Usuário"
      usuario = new JLabel("Usuário ");
      usuario.setLocation(225,130);
      usuario.setSize(100,20);
      usuario.setFont(new Font("IntelliJ", Font.BOLD, 14));
      //Label "Senha"
      senha = new JLabel("Senha ");
      senha.setLocation(225,200);
      senha.setSize(150,30);
      senha.setFont(new Font("IntelliJ", Font.BOLD, 14));
    //"Informação de senha não compativel"
      Info = new JLabel("");
      Info.setLocation(225,280);
      Info.setSize(500,20);
      Info.setForeground(Color.red);
      Info.setFont(new Font("IntelliJ", Font.BOLD, 14));
      //TextField "Usuário"
      usuario1 = new JTextField("");
      usuario1.setSize(320,30);
      usuario1.setLocation(225,160);
      usuario1.setFont(new Font("IntelliJ", Font.BOLD, 14));
      //PasswprdField "Senha"
      JPasswordField Sx = new JPasswordField();
      this.Sx = Sx ;
      Sx.setEchoChar('*');
      Sx.setSize(320,30);
      Sx.setLocation(225,230);
      Sx.addActionListener(this);
      Sx.setFont(new Font("IntelliJ", Font.BOLD, 14));
      //Botão "Criar Conta"
      criar_conta = new JButton("Criar sua Conta");
      criar_conta.setSize(150,30);
	  criar_conta.setLocation(300,400);
	  criar_conta.setBackground(new Color (248, 248, 255));
	  criar_conta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	  criar_conta.addActionListener(this);
	 //Botão "Fazer Login"
	  Fazer_login = new JButton("Fazer login");
	  Fazer_login.setSize(150,30);
	  Fazer_login.setLocation(300,340);
	  Fazer_login.setBackground(new Color (248, 248, 255));
	  Fazer_login.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	  Fazer_login.addActionListener(this); 
      
	  //Add Componentes do Frame!
      getContentPane().setLayout(null);
      getContentPane().add(login);
      getContentPane().add(usuario);
      getContentPane().add(senha);
      getContentPane().add(usuario1);
      getContentPane().add(Info);
      getContentPane().add(Fazer_login);
      getContentPane().add(criar_conta);
      getContentPane().setBackground(new Color(127,255,212));
      getContentPane().add(Sx);
   }
   
   //Main "Inicio"
   public static void main (String arg[])
   {
      new Password().setVisible(true);
   }
   
   //Eventos "Funcionalidade dos botões e acões"
   public void actionPerformed(ActionEvent e)
   {
	 if (e.getSource() == criar_conta) {
		
		 Crie_conta obj = new Crie_conta();
			obj.setVisible(true);
			dispose();  
	 }
	 
   else {
	   try
       {

        String sql = "select * from usuario where nome_usuario like '"+usuario1.getText()+"' and password_usuario like '"+ Sx.getText() +"'";
        Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/Schedule_Recreation", "root", "pain12345");
		PreparedStatement select = con.prepareStatement(sql);
		ResultSet resultado = select.executeQuery();

           if(resultado.first())
           {
               new Menu().setVisible(true);
               dispose();
               }
           else{
        	   Info.setText("Usuário ou Senha Incorreto!");
              }

           }
               catch (SQLException erro)
               {
         JOptionPane.showMessageDialog(null, "Problemas de conexão com a base de dados");

       }
         }
     }
}
	