import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.sql.*;
import java.awt.event.*;

public class Serie_Alterar extends JFrame implements ActionListener,ItemListener {

	private Connection connection;
	
	//Variaveis!
	JLabel L1,L2,L3,L4,L5,L6,L7,L8,L9,Info;
	JButton bLogoff,bAlterar,bVoltar_inicio;
	JRadioButton byes,bno;
	JTextField tNome,tTemporadas,tEpisodios,tQual_Temporada,tQual_EP;
	JTextArea tComent,tCritica;
	ButtonGroup bg;
	
	public  Serie_Alterar() {
		
		//Frame!
		setTitle("Alterar os dados cadastrados");
		setSize(800,600);
		setLocation(100,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		L1 = new JLabel("Altere os dados arquivados da serie cadastrada");
		L1.setSize(400,20);
		L1.setLocation(300,30);
		L1.setFont(new Font("IntelliJ", Font.BOLD, 16));
		L2 = new JLabel("Nome da serie:");
		L2.setSize(100,20);
		L2.setLocation(50,80);
		L2.setFont(new Font("IntelliJ", Font.BOLD, 12));
		L3 = new JLabel("Temporadas:");
		L3.setSize(100,20);
		L3.setLocation(50,130);
		L3.setFont(new Font("IntelliJ", Font.BOLD, 12));
		L4 = new JLabel("Quantos Episódios:");
		L4.setSize(115,20);
		L4.setLocation(330,130);
		L4.setFont(new Font("IntelliJ", Font.BOLD, 12));
		L5 = new JLabel("Atualizado?");
		L5.setSize(150,20);
		L5.setLocation(555,130);
		L5.setFont(new Font("IntelliJ", Font.BOLD, 12));
		L6 = new JLabel("Está na temporada:");
		L6.setSize(200,20);
		L6.setLocation(50,180);
		L6.setFont(new Font("IntelliJ", Font.BOLD, 12));
		L7 = new JLabel("Sinopse da serie:");
		L7.setSize(200,20);
		L7.setLocation(50,250);
		L7.setFont(new Font("IntelliJ", Font.BOLD, 12));
		L8 = new JLabel("Comentários sobre a serie:");
		L8.setSize(200,20);
		L8.setLocation(50,370);
		L8.setFont(new Font("IntelliJ", Font.BOLD, 12));
		L9 = new JLabel("Está em qual Episódio:");
		L9.setSize(135,20); 
		L9.setLocation(330,180);
		L9.setFont(new Font("IntelliJ", Font.BOLD, 12));
		//Label info salvo
		//Label info salvo
		Info = new JLabel("");
		Info.setSize(300,20);
		Info.setLocation(300,480);
		Info.setFont(new Font("IntelliJ", Font.BOLD, 12));
		Info.setForeground(Color.red);
		tNome = new JTextField("");
		tNome.setSize(530,20);
		tNome.setLocation(220,80);
		tNome.setDocument(new charlimite(73));
		tNome.setFont(new Font("IntelliJ", Font.BOLD, 12));
		tTemporadas = new JTextField("");
		tTemporadas.setSize(80,20);
		tTemporadas.setLocation(220,130);
		tTemporadas.setDocument(new charlimite(5));
		tTemporadas.setFont(new Font("IntelliJ", Font.BOLD, 12));
		tEpisodios = new JTextField("");
		tEpisodios.setSize(80,20);
		tEpisodios.setLocation(465,130);
		tEpisodios.setDocument(new charlimite(5));
		tEpisodios.setFont(new Font("IntelliJ", Font.BOLD, 12));
		tQual_Temporada = new JTextField("");
		tQual_Temporada.setSize(80,20);
		tQual_Temporada.setLocation(220,180);
		tQual_Temporada.setDocument(new charlimite(5));
		tQual_Temporada.setFont(new Font("IntelliJ", Font.BOLD, 12));
		tQual_EP = new JTextField("");
		tQual_EP.setSize(80,20);
		tQual_EP.setLocation(465,180);
		tQual_EP.setDocument(new charlimite(5));
		tQual_EP.setFont(new Font("IntelliJ", Font.BOLD, 12));
		tCritica = new JTextArea("");
		tCritica.setSize(530,100);
		tCritica.setLocation(220,250);
		tCritica.setLineWrap(true);//Quebra de texto!
		tCritica.setWrapStyleWord(true);//Faz com que o texto não quebre em caracteres!
		tCritica.setDocument(new charlimite(450));//Limita a quantidade de caractere!
		tCritica.setFont(new Font("IntelliJ", Font.BOLD, 12));
		tComent = new JTextArea("");
		tComent.setSize(530,100);
		tComent.setLocation(220,370);	
		tComent.setLineWrap(true);
		tComent.setWrapStyleWord(true);
		tComent.setDocument(new charlimite(450));
		tComent.setFont(new Font("IntelliJ", Font.BOLD, 12));
		byes = new JRadioButton ("Sim",true);
		byes.setSize(50,20);
		byes.setLocation(630,130);
		bno= new JRadioButton ("Não",false);
		bno.setSize(50,20);
		bno.setLocation(690,130);
		bg = new ButtonGroup();
		bg.add(byes);
		bg.add(bno);
		
		//Botao Excluir"
		bAlterar = new JButton("Alterar");
		bAlterar.setSize(150,30); 
		bAlterar.setLocation(140,525);
		bAlterar.setBackground(new Color (248, 248, 255));
		bAlterar.setFont(new Font("IntelliJ", Font.BOLD, 12));
		bAlterar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		bAlterar.addActionListener(this);
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
		
		getContentPane().setLayout(null);
		getContentPane().add(L1);
		getContentPane().add(L2);
		getContentPane().add(L3);
		getContentPane().add(L4);
		getContentPane().add(L5);
		getContentPane().add(L6);
		getContentPane().add(L7);
		getContentPane().add(L8);
		getContentPane().add(L9);
		getContentPane().add(tNome);
		getContentPane().add(tTemporadas);
		getContentPane().add(tEpisodios);
		getContentPane().add(tQual_Temporada);
		getContentPane().add(tCritica);
		getContentPane().add(tComent);
		getContentPane().add(tQual_EP);
		getContentPane().add(byes);
		getContentPane().add(bno);
		getContentPane().add(bLogoff);
		getContentPane().add(bAlterar);
		getContentPane().add(bVoltar_inicio);
		getContentPane().add(Info);
		getContentPane().setBackground(new Color(127,255,212));
		
	}
	public static void main(String[] args) {
		new Serie_Alterar().setVisible(true);
	}

	public void itemStateChanged(ItemEvent e) {
		
	}

	//Eventos "Funcionalidade dos botões e acões"
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == bAlterar) {
			
			try {		

				Connection conexao = DriverManager.getConnection ("jdbc:mysql://localhost:3306/Schedule_Recreation", "root", "pain12345");
				PreparedStatement update = conexao.prepareStatement("UPDATE Serie SET qntd_temp = '"+tTemporadas.getText()+"' Where nome_serie like '"+tNome.getText()+"'");				
				PreparedStatement update1 = conexao.prepareStatement("UPDATE Serie SET qntd_ep = '"+tEpisodios.getText()+"' Where nome_serie like '"+tNome.getText()+"'" );			
				PreparedStatement update2 = conexao.prepareStatement("UPDATE Serie SET qual_ep = '"+tQual_EP.getText()+"'Where nome_serie like '"+tNome.getText()+"'");			
				PreparedStatement update3 = conexao.prepareStatement("UPDATE Serie SET comentarios = '"+tComent.getText()+"' Where nome_serie like '"+tNome.getText()+"'");			
				PreparedStatement update4 = conexao.prepareStatement("UPDATE Serie SET criticas = '"+tCritica.getText()+"' Where nome_serie like '"+tNome.getText()+"'");	
				PreparedStatement update5 = conexao.prepareStatement("UPDATE Serie SET qual_temp = '"+tQual_Temporada.getText()+"'Where nome_serie like '"+tNome.getText()+"'");
				update.executeUpdate();	
				update1.executeUpdate();	
				update2.executeUpdate();	
				update3.executeUpdate();	
				update4.executeUpdate();	
				update5.executeUpdate();	
				
				if(tNome.getText().equals("")) {
					
					Info.setText("Insira o nome da serie para concluir a alteração!");
				
				}
				else {
					Info.setText("Dados alterados com sucesso!");
				}
				
			}
				catch(Exception erro) {
					
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
