import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Menu extends JFrame implements ActionListener,ListSelectionListener  {
	
	//Variaveis!
	JMenuBar bmenu;
	JMenu mLivro,mSerie,mFilme;
	JMenuItem cLivro,aLivro,eLivro,iLivro,cSerie,aSerie,eSerie,iSerie,cFilme,aFilme,eFilme,iFilme;   
	JLabel Castrado, La,descricao,pesquisar;
	DefaultListModel lista ;
	JList opcao;
	JPanel P1, P2 ;
	ImageIcon Img;
	JTextField pesquisa;
	
	public Menu() {
		
		//Frame!
		setTitle("Schedule Recreation");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		//Label "Pesquisar"
		pesquisar= new JLabel("Pesquisar:");
		pesquisar.setSize(150,20);
		pesquisar.setLocation(20,20);
	    //Label "Ultimos cadastros" nome da lista!
		Castrado = new JLabel("Ultimos dados cadastrados");
		Castrado.setSize(300,20);
		Castrado.setLocation(20,70);
		Castrado.setFont(new Font("IntelliJ", Font.BOLD, 12));
	    //possivelmente sairá
	     descricao = new JLabel("");
	     descricao.setSize(500,20);
	     descricao.setLocation(220,480);
		//TextField "pesquisar"
	     pesquisa = new JTextField("");
		 pesquisa.setSize(660,20);
	     pesquisa.setLocation(90,20);
		//Mostra imagem
		 Img = new ImageIcon(" ");
		 La = new JLabel(Img);
	     La.setLocation(20,10);
	     La.setVisible(true);
	     //Lista de sugestões de filmes
		 lista = new DefaultListModel();
		 lista.addElement("Game of Thrones");
		 lista.addElement("It a coisa");
		 lista.addElement("Deadpool");
		 lista.addElement("Star wars");
		 lista.addElement("Supernatural");
		 lista.addElement("Sherlock");
		 lista.addElement("Senhor dos aneis");
		 lista.addElement("Harry Potter");
		 lista.addElement("Fragmentado");
		 lista.addElement("Good Doctor");
		 lista.addElement("Demolidor");
		 lista.addElement("Vingadores");
		 lista.addElement("O iluminado");
		 lista.addElement("Carrie a estranha");
		 lista.addElement("O Lobo de Wall Street");
		 lista.addElement("De volta para o futuro");
		 lista.addElement("Lethal Weapon");
		 lista.addElement("Kidding");
		//Lista
		 opcao = new JList(lista);
		 opcao.setSize(140,355);
		 opcao.setLocation(5,10);
		 opcao.setBackground(new Color(255,250,250));
		 opcao.addListSelectionListener(this);
		//panel	
		 P1 = new JPanel();
		 P1.setBounds(20,100,160,370);
		 P1.setBackground(new Color	(255,250,250));
		 P1.setBorder(BorderFactory.createLineBorder(Color.black,1));
		 P1.setLayout(null);
		 P1.add(opcao);
		//panel
		 P2 = new JPanel();
		 P2.setBounds(220,100,530,370);
		 P2.setBackground(new Color(255,250,250));
	 	 P2.add(La,BorderLayout.CENTER);
		    	   
		//Cria a barra de menu e implementa no frame!
		JMenuBar bmenu = new JMenuBar();
		setJMenuBar(bmenu);	
		bmenu.setBackground(new Color(248, 248, 255));
		bmenu.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//Cria e aciniona drop down na barra de menu! 
		mLivro = new JMenu ("Livro");
		mSerie = new JMenu ("Serie");
		mFilme = new JMenu ("Filme");
		bmenu.add(mLivro);
		bmenu.add(mSerie);
		bmenu.add(mFilme);
		
		//Cria e adciona itens do menu!
		//Opção Livro!
		iLivro = new JMenuItem("Cadastrar o livro");
		iLivro.addActionListener(this);
		cLivro = new JMenuItem("Consultar os dados cadastrados");
		cLivro.addActionListener(this);
		aLivro = new JMenuItem("Alterar os dados cadastrados");
		aLivro.addActionListener(this);
		eLivro = new JMenuItem("Excluir os dados cadastrados");
		eLivro.addActionListener(this);
		mLivro.add(iLivro);
		mLivro.add(cLivro);
		mLivro.add(aLivro);
		mLivro.add(eLivro);
		//Opção Serie!
	    iSerie = new JMenuItem("Cadastrar a serie");
		iSerie.addActionListener(this);
	    cSerie = new JMenuItem("Consultar os dados cadastrados");
	    cSerie.addActionListener(this);
	    aSerie = new JMenuItem("Alterar os dados cadastrados");
	    aSerie.addActionListener(this);	   
        eSerie = new JMenuItem("Excluir os dados cadastrados");
        eSerie.addActionListener(this);
		mSerie.add(iSerie);
		mSerie.add(cSerie);
		mSerie.add(aSerie);
		mSerie.add(eSerie);
		//Opção Filme!
		iFilme = new JMenuItem("Cadastrar o filme");
		iFilme.addActionListener(this);
		cFilme = new JMenuItem("Consultar os dados cadastrados");
		cFilme.addActionListener(this);
		aFilme = new JMenuItem("Alterar os dados cadastrados");
		aFilme.addActionListener(this);
		eFilme = new JMenuItem("Excluir os dados cadastrados");
		eFilme.addActionListener(this);
		mFilme.add(iFilme);
		mFilme.add(cFilme);
		mFilme.add(aFilme);
		mFilme.add(eFilme);
		
		//Add Componentes do Frame!
		getContentPane().setLayout(null);
		getContentPane().add(Castrado);
		getContentPane().add(P1);
		getContentPane().add(P2);
		getContentPane().add(descricao);
		getContentPane().add(pesquisa);
		getContentPane().add(pesquisar);
		getContentPane().setBackground(new Color(127,255,212));
	}

	 //Main "Inicio"
	public static void main(String[] args) {
		new Menu().setVisible(true);

		}
	
	//Eventos "Funcionalidade lista"
	public void valueChanged(ListSelectionEvent e) 
 	{
 	   if(opcao.getSelectedValue().equals("Game of Thrones"))
 	   {	
 	      Img = new ImageIcon("C:\\Users\\Mathe\\eclipse-workspace\\Schedule Recreation\\src\\Image\\Game of Thrones.png");
 	      La.setIcon(Img);
 	      descricao.setText("Game of Thrones é uma série de livros de fantasia épica, escrita por George R. R. Martin."); 
 	   }
 	  if(opcao.getSelectedValue().equals("It a coisa"))
	   {	
	      Img = new ImageIcon("C:\\Users\\Mathe\\eclipse-workspace\\Schedule Recreation\\src\\Image\\it.png");
	      La.setIcon(Img);
	      descricao.setText("It a coisa é um livro de terror e aventura, escrito por Stephen king."); 
	   }
 	 if(opcao.getSelectedValue().equals("Deadpool"))
	   {
	      Img = new ImageIcon("C:\\Users\\Mathe\\eclipse-workspace\\Schedule Recreation\\src\\Image\\Deadpool.png");
	      descricao.setText("Wade Wilson é um ex-agente especial que passou a trabalhar como mercenário."); 
	      La.setIcon(Img);
	   }
 	   if(opcao.getSelectedValue().equals("Star wars"))
 	   {
 	      Img = new ImageIcon("C:\\Users\\Mathe\\eclipse-workspace\\Schedule Recreation\\src\\Image\\starwars.png");
 	      descricao.setText("Star Wars é uma franquia space opera criada pelo cineasta George Lucas."); 
 	      La.setIcon(Img);
 	   }
 	   if(opcao.getSelectedValue().equals("Supernatural"))
 	   {
 	      Img = new ImageIcon("C:\\Users\\Mathe\\eclipse-workspace\\Schedule Recreation\\src\\Image\\Supernatural.png");
 	      descricao.setText("Os irmãos Sam e Dean Winchester encaram cenários sinistros caçando monstros.");
 	      La.setIcon(Img);
 	   }
 	   if(opcao.getSelectedValue().equals("Sherlock"))
 	   {
 	      Img = new ImageIcon("C:\\Users\\Mathe\\eclipse-workspace\\Schedule Recreation\\src\\Image\\Sherlock.png");
 	      descricao.setText("Sherlock Holmes sempre foi um homem moderno, o mundo é que envelheceu. ");
 	      La.setIcon(Img);
 	   }
 	   if(opcao.getSelectedValue().equals("Senhor dos aneis"))
 	   {
 	      Img = new ImageIcon("C:\\Users\\Mathe\\eclipse-workspace\\Schedule Recreation\\src\\Image\\The_Lord_of_the_Rings_Logo.png");
 	      descricao.setText("O Senhor dos Anéis é uma trilogia com base na obra-prima de J. R. R. Tolkien. ");
 	      La.setIcon(Img);
 	   }
 	  if(opcao.getSelectedValue().equals("Harry Potter"))
	   {
	      Img = new ImageIcon("C:\\Users\\Mathe\\eclipse-workspace\\Schedule Recreation\\src\\Image\\harrypotter.png");
	      descricao.setText("Harry Potter é uma série de sete romances de fantasia escrita por  J. K. Rowling.");
	      La.setIcon(Img);
	   }
 	 if(opcao.getSelectedValue().equals("Fragmentado"))
	   {
	      Img = new ImageIcon("C:\\Users\\Mathe\\eclipse-workspace\\Schedule Recreation\\src\\Image\\split.png");
	      descricao.setText("Kevin possui 23 personalidades distintas e consegue alterná-las com o pensamento.");
	      La.setIcon(Img);
	   }
 	 if(opcao.getSelectedValue().equals("Vingadores"))
	   {
	      Img = new ImageIcon("C:\\Users\\Mathe\\eclipse-workspace\\Schedule Recreation\\src\\Image\\Vingadores.png");
	      descricao.setText("Os Vingadores são um grupo de super-heróis de história em quadrinhos da Marvel.");
	      La.setIcon(Img);
	   }
 	 if(opcao.getSelectedValue().equals("Demolidor"))
	   {
	      Img = new ImageIcon("C:\\Users\\Mathe\\eclipse-workspace\\Schedule Recreation\\src\\Image\\demolidor.png");
	      descricao.setText("Matt Murdock ficou  cego quando adolescente e obteu superpoderes sensoriais.");
	      La.setIcon(Img);
	   }
 	 if(opcao.getSelectedValue().equals("Good Doctor"))
	   {
	      Img = new ImageIcon("C:\\Users\\Mathe\\eclipse-workspace\\Schedule Recreation\\src\\Image\\TheGoodDoctor.png");
	      descricao.setText("Shaun Murphy tem síndrome de Savant se junta à unidade cirúrgica de um hospital. ");
	      La.setIcon(Img);
	   }
 	 if(opcao.getSelectedValue().equals("O iluminado"))
	   {
	      Img = new ImageIcon("C:\\Users\\Mathe\\eclipse-workspace\\Schedule Recreation\\src\\Image\\o iluminado.png");
	      descricao.setText("Livro de Suspense escrito por Stephen king. ");
	      La.setIcon(Img);
	   }
 	if(opcao.getSelectedValue().equals("Carrie a estranha"))
	   {
	      Img = new ImageIcon("C:\\Users\\Mathe\\eclipse-workspace\\Schedule Recreation\\src\\Image\\carrie3.png");
	      descricao.setText("Livro de Suspense escrito por Stephen king. ");
	      La.setIcon(Img);
	   }
 	if(opcao.getSelectedValue().equals("O Lobo de Wall Street"))
	   {
	      Img = new ImageIcon("C:\\Users\\Mathe\\eclipse-workspace\\Schedule Recreation\\src\\Image\\O-LOBO-DE-WALL-STREET.png");
	      descricao.setText("Jordan Belfort corretor da bolsa de valores, enriquecendo de forma rápidar e ilegal. ");
	      La.setIcon(Img);
	   }
 	if(opcao.getSelectedValue().equals("De volta para o futuro"))
	   {
	      Img = new ImageIcon("C:\\Users\\Mathe\\eclipse-workspace\\Schedule Recreation\\src\\Image\\De-Volta-para-o-Futuro.png");
	      descricao.setText("Marty McFly, adolescente de uma pequena cidade, é transportado para a década 50. ");
	      La.setIcon(Img);
	   }
 	if(opcao.getSelectedValue().equals("Lethal Weapon"))
	   {
	      Img = new ImageIcon("C:\\Users\\Mathe\\eclipse-workspace\\Schedule Recreation\\src\\Image\\lethal-weapon.png");
	      descricao.setText("Dupla de policiais Riggs e Murtaugh em sua luta contra o crime na Los Angeles.");
	      La.setIcon(Img);
	   }
 	if(opcao.getSelectedValue().equals("Kidding"))
	   {
	      Img = new ImageIcon("C:\\Users\\Mathe\\eclipse-workspace\\Schedule Recreation\\src\\Image\\kidding.png");
	      descricao.setText("Kidding é uma série de televisão de drama criada por Dave Holstein.");
	      La.setIcon(Img);
	   }
 	}   
	
	//Eventos "Funcionalidade dos botões e acões"
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == iLivro) {
			Livro_Inserir obj = new Livro_Inserir();
			obj.setVisible(true);
			dispose(); 
		}
		else if (e.getSource() == cLivro) {
			Livro_Consultar obj = new Livro_Consultar();
			obj.setVisible(true);
			dispose(); 
		}
		else if(e.getSource() == eLivro) {
			Livro_Excluir obj = new Livro_Excluir();
			obj.setVisible(true);
			dispose(); 
		}
		else if(e.getSource() == aLivro) {
			Livro_Alterar obj = new Livro_Alterar();
			obj.setVisible(true);
			dispose(); 
		}
		else if(e.getSource() == iSerie) {
			Serie_Inserir obj = new Serie_Inserir();
			obj.setVisible(true);
			dispose(); 		
		}
		else if(e.getSource() == cSerie) {
			Serie_Consultar obj = new Serie_Consultar(); 
			obj.setVisible(true);
			dispose(); 		
		}
		else if(e.getSource() == eSerie) {
			Serie_Excluir obj = new Serie_Excluir();
			obj.setVisible(true);
			dispose(); 		
		}
		else if(e.getSource() == aSerie) {
			Serie_Alterar obj = new Serie_Alterar();
			obj.setVisible(true);
			dispose(); 		
		}
		else if(e.getSource() == iFilme) {
			Filme_Inserir obj = new Filme_Inserir();
			obj.setVisible(true);
			dispose(); 		
		}
		else if(e.getSource() == cFilme) {
			Filme_Consultar obj = new Filme_Consultar();
			obj.setVisible(true);
			dispose(); 		
		}
		else if(e.getSource() == eFilme) {
			Filme_Excluir obj = new Filme_Excluir();
			obj.setVisible(true);
			dispose(); 		
		}
		else if(e.getSource() == aFilme) {
			Filme_Alterar obj = new Filme_Alterar();
			obj.setVisible(true);
			dispose(); 		
		}

	}
	
}
