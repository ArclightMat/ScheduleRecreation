import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.sql.*;

import java.awt.event.*;
public class Filme_Inserir extends JFrame implements ActionListener,ItemListener {
	
	private Connection connection;

	//Variaveis!
	JLabel L1,L2,L3,L4,L5,L6,L7,L8,Info;
	JButton bLogoff,bSalvar,bVoltar_inicio;
	JRadioButton byes,bno;
	JTextField tNome,tDiretor,tProdutor,tDuracao;
	JTextArea tComent,tCritica;
	ButtonGroup bg;
	
	public  Filme_Inserir() {
		
		//Frame!
		setTitle("Cadastro de dados");
		setSize(800,600);
		setLocation(100,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		//Label Titulo
		L1 = new JLabel("Cadastre os dados do filme que deseja arquivar");
		L1.setSize(400,20);
		L1.setLocation(300,30);
		L1.setFont(new Font("IntelliJ", Font.BOLD, 16));
		//Label nome do fime
		L2 = new JLabel("Nome do Filme:");
		L2.setSize(100,20);
		L2.setLocation(50,80);
		L2.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//Label nome diretor
		L3 = new JLabel("Nome do Diretor:");
		L3.setSize(100,20);
		L3.setLocation(50,130);
		L3.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//Label nome produtor
		L4 = new JLabel("Nome do Produtor:");
		L4.setSize(115,20);
		L4.setLocation(440,130);
		L4.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//Label sequencia
		L5 = new JLabel("Filme tem sequência?");
		L5.setSize(150,20);
		L5.setLocation(440,180);
		L5.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//Label duraçao
		L6 = new JLabel("Tempo de Duração:");
		L6.setSize(200,20);
		L6.setLocation(50,180);
		L6.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//Label sinopse
		L7 = new JLabel("Sinopse do Filme:");
		L7.setSize(200,20);
		L7.setLocation(50,250);
		L7.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//Label comentarios
		L8 = new JLabel("Comentários sobre o Filme:");
		L8.setSize(200,20);
		L8.setLocation(50,370);
		L8.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//Label info salvo
		Info = new JLabel("");
		Info.setSize(200,20);
		Info.setLocation(330,480);
		Info.setFont(new Font("IntelliJ", Font.BOLD, 12));
		Info.setForeground(Color.red);
		//TextField nome
		tNome = new JTextField("");
		tNome.setSize(530,20);
		tNome.setLocation(220,80);
		tNome.setDocument(new charlimite(73));
		tNome.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//TextField diretor
		tDiretor = new JTextField("");
		tDiretor.setSize(200,20);
		tDiretor.setLocation(220,130);
		tDiretor.setDocument(new charlimite(27));
		tDiretor.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//TextField produtor
		tProdutor = new JTextField("");
		tProdutor.setSize(200,20);
		tProdutor.setLocation(550,130);
		tProdutor.setDocument(new charlimite(27));
		tProdutor.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//TextField duraçao
		tDuracao = new JTextField(""); 
		tDuracao.setSize(80,20);
		tDuracao.setLocation(220,180);
		tDuracao.setDocument(new charlimite(5));
		tDuracao.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//TextArea Critica
		tCritica = new JTextArea("");
		tCritica.setSize(530,100);
		tCritica.setLocation(220,250);
		tCritica.setLineWrap(true);//Quebra de texto!
		tCritica.setWrapStyleWord(true);//Faz com que o texto não quebre em caracteres!
		tCritica.setDocument(new charlimite(450));//Limita a quantidade de caractere!
		tCritica.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//TextArea comentarios
		tComent = new JTextArea("");
		tComent.setSize(530,100);
		tComent.setLocation(220,370);	
		tComent.setLineWrap(true);
		tComent.setWrapStyleWord(true);
		tComent.setDocument(new charlimite(450));
		tComent.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//sequencia
		byes = new JRadioButton ("Sim",true);
		byes.setSize(50,20);
		byes.setLocation(600,180);
		bno= new JRadioButton ("Não",false);
		bno.setSize(50,20);
		bno.setLocation(660,180);
		bg = new ButtonGroup();
		bg.add(byes);
		bg.add(bno);
		//Botao Inserirr"
		bSalvar = new JButton("Salvar");
		bSalvar.setSize(150,30); 
		bSalvar.setLocation(140,525);
		bSalvar.setBackground(new Color (248, 248, 255));
		bSalvar.setFont(new Font("IntelliJ", Font.BOLD, 12));
		bSalvar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		bSalvar.addActionListener(this);
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
		
		//"Add componentes frame!"
		getContentPane().setLayout(null);
		getContentPane().add(L1);
		getContentPane().add(L2);
		getContentPane().add(L3);
		getContentPane().add(L4);
		getContentPane().add(L5);
		getContentPane().add(L6);
		getContentPane().add(L7);
		getContentPane().add(L8);
		getContentPane().add(tNome);
		getContentPane().add(tDiretor);
		getContentPane().add(tProdutor);
		getContentPane().add(tDuracao);
		getContentPane().add(tCritica);
		getContentPane().add(tComent);
		getContentPane().add(byes);
		getContentPane().add(bno);
		getContentPane().add(bLogoff);
		getContentPane().add(bSalvar);
		getContentPane().add(bVoltar_inicio);
		getContentPane().add(Info);
		getContentPane().setBackground(new Color(127,255,212));	
	}
	
	//Main "Inicio"
	public static void main(String[] args) {
		new Filme_Inserir().setVisible(true);
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
	
 //
	public void itemStateChanged(ItemEvent e) {
		
	}

	//Eventos "Funcionalidade dos botões e acões"
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bSalvar) {
			executa_inserir("Insert into Filme values ('"+tNome.getText()+"','"+tDiretor.getText()+"','"+tProdutor.getText()+"','"+tDuracao.getText()+"','"+tComent.getText()+"','"+tCritica.getText()+"')");
			Info.setText("Cadastrado Salvo com Sucesso!");
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
