import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.event.*;
import java.sql.*;
public class Filme_Consultar extends JFrame implements ActionListener {
	
	private Connection connection;

	//Variaveis!
	JLabel L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11,L12,Info;
	JButton bConsultar,bLogoff,bVoltar_inicio;
	JRadioButton byes,bno;
	JTextField tNome;
	JTextArea tCritica,tComent;
	ButtonGroup bg;
	
	public  Filme_Consultar() {
		
		//Frame!
		setTitle("Consultar os dados cadastrados");
		setSize(800,600);
		setLocation(100,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		//Label "Conlsultar dados"
		L1 = new JLabel("Consulte os dados arquivados do filme cadastrado");
		L1.setSize(400,20);
		L1.setLocation(300,30);
		L1.setFont(new Font("IntelliJ", Font.BOLD, 16));
		//Label "nome do filme"
		L2 = new JLabel("Nome do Filme:");
		L2.setSize(100,20);
		L2.setLocation(50,80);
		L2.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//Label "nome diretor"
		L3 = new JLabel("Nome do Diretor:");
		L3.setSize(100,20);
		L3.setLocation(50,130);
		L3.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//Label "Nome da produtora"
		L4 = new JLabel("Nome da Produtora:");
		L4.setSize(115,20);
		L4.setLocation(440,130);
		L4.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//Label "tem sequencia"
		L5 = new JLabel("Filme tem sequência?");
		L5.setSize(150,20);
		L5.setLocation(440,180);
		L5.setFont(new Font("IntelliJ", Font.BOLD, 12));
		// Label "tempo de duração"
		L6 = new JLabel("Tempo de Duração:");
		L6.setSize(200,20);
		L6.setLocation(50,180);
		L6.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//Label "sinopse"
		L7 = new JLabel("Sinopse do Filme:");
		L7.setSize(200,20);
		L7.setLocation(50,250);
		L7.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//Label "Comentarios"
		L8 = new JLabel("Comentários sobre o Filme:");
		L8.setSize(200,20);
		L8.setLocation(50,370);
		L8.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//Label info salvo
		Info = new JLabel("");
		Info.setSize(300,20);
		Info.setLocation(300,480);
		Info.setFont(new Font("IntelliJ", Font.BOLD, 12));
		Info.setForeground(Color.red);
		//TExtField "nome do filme"
		tNome = new JTextField("");
		tNome.setSize(530,20);
		tNome.setLocation(220,80);
		tNome.setDocument(new charlimite(73));
		//"nome diretor"
		L10 = new JLabel("");
		L10.setSize(200,20);
		L10.setLocation(220,130);
		//"Nome da produtora"
		L11 = new JLabel("");
		L11.setSize(200,20);
		L11.setLocation(560,130);
		//"tempo de duração"
		L12 = new JLabel("");
		L12.setSize(80,20);
		L12.setLocation(220,180);
		tCritica = new JTextArea("");
		tCritica.setSize(530,100);
		tCritica.setLocation(220,250);
		tCritica.setLineWrap(true);//Quebra de texto!
		tCritica.setWrapStyleWord(true);//Faz com que o texto não quebre em caracteres!
		tCritica.setDocument(new charlimite(450));//Limita a quantidade de caractere!
		tCritica.setFont(new Font("IntelliJ", Font.BOLD, 12));
		tCritica.setBackground(new Color(127,255,212));
		//TextArea comentario
		tComent = new JTextArea("");
		tComent.setSize(530,100);
		tComent.setLocation(220,370);	
		tComent.setLineWrap(true);
		tComent.setWrapStyleWord(true);
		tComent.setDocument(new charlimite(450));
		tComent.setFont(new Font("IntelliJ", Font.BOLD, 12));
		tComent.setBackground(new Color(127,255,212));
		//Botão "tem sequencia"
		byes = new JRadioButton ("Sim",true);
		byes.setSize(50,20);
		byes.setLocation(600,180);
		bno= new JRadioButton ("Não",false);
		bno.setSize(50,20);
		bno.setLocation(660,180);
		bg = new ButtonGroup();
		bg.add(byes);
		bg.add(bno);
		//Botao Consultar"
		bConsultar = new JButton("Consultar");
		bConsultar.setSize(150,30); 
		bConsultar.setLocation(140,525);
		bConsultar.setBackground(new Color (248, 248, 255));
		bConsultar.setFont(new Font("IntelliJ", Font.BOLD, 12));
		bConsultar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		bConsultar.addActionListener(this);
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
		getContentPane().add(L6);
		getContentPane().add(L7);
		getContentPane().add(L8);
		getContentPane().add(tNome);
		getContentPane().add(L10);
		getContentPane().add(L11);
		getContentPane().add(L12);
		getContentPane().add(tComent);
		getContentPane().add(tCritica);
		getContentPane().add(Info);
		getContentPane().add(byes);
		getContentPane().add(bno);
		getContentPane().add(bLogoff);
		getContentPane().add(bVoltar_inicio);
		getContentPane().add(bConsultar); 
		getContentPane().setBackground(new Color(127,255,212));
	}
	
	 //Main "Inicio"
	public static void main(String[] args) {
		new Filme_Consultar().setVisible(true);
	}
	
	//Eventos "Funcionalidade dos botões e acões"
	public void actionPerformed(ActionEvent e) {
		
		 if(e.getSource() == bConsultar) {
		
			   Connection conexao;
			try {
				
				String sql = "select * from Filme where nome_filme like '"+tNome.getText()+"'";
				Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/Schedule_Recreation", "root", "pain12345");
				PreparedStatement select = con.prepareStatement(sql);
				ResultSet resultado = select.executeQuery(sql);
			
		while(resultado.next()) {
				L10.setText(resultado.getString("nome_diretor"));
				L11.setText(resultado.getString("nome_produtor"));
				L12.setText(resultado.getString("temp_duracao"));
				tComent.setText(resultado.getString("comentarios"));
				tCritica.setText(resultado.getString("criticas"));
				}
		   		if(tNome.getText().equals("")) {
		   				Info.setText("Insira o filme para realizar a consulta!");
		   		}
		   		else if(L10.getText().equals("")) {
		   			
		   			Info.setText("Filme não encontrado no Banco de dados!");
		   		}
		   		else {
		   			Info.setText("Consulta realizada com sucesso!");
		   		}
		   	}
		   		catch (SQLException e1) {
				e1.printStackTrace();
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
