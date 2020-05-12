package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.ILivroDao;
import dao.LivroDao;
import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import entidade.Livro;
import entidade.Usuario;


@ManagedBean(name = "LivroBean")
@SessionScoped

public class LivroBean {

	
	private String txtLivro;
	//private String txtSenha;

	private List<Livro> listaLivros;
	private Livro livro; // Objeto para cadastro
	private String msgCadastroLivro;
	
	private ILivroDao livroDAO;

	/**
	 * Construtor, que vai inicializar a lista de usuarios
	 */
	public LivroBean() {
		this.listaLivros = new ArrayList<Livro>();
		this.livro = new Livro();
		this.livroDAO = new LivroDao();
	}


	/**
	 * Metodo responsavel por criar um novo livro na lista
	 */
	public String criarLivro() {

		Livro novo = new Livro();
		
		novo.setIsbn(this.livro.getIsbn());
		novo.setNome(this.livro.getNome());
		novo.setAutor(this.livro.getAutor());
		novo.setDescricao(this.livro.getDescricao());

		boolean achou = false;
		
		this.listaLivros = this.livroDAO.listarTodos();
		
		for (Livro livroPesquisa : listaLivros) {
			if (livroPesquisa.getIsbn().equals(this.livro.getIsbn())) {
				achou = true;
			}
		}
		
		if(achou) {
			FacesContext.getCurrentInstance()
				.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Livro já existe!!!"));
			return "livro.xhtml";
		}else {
//			this.listaLivros.add(novo);
			this.livroDAO.inserir(novo);
			
			this.livro = new Livro();
			return "livro.xhtml";
		}
		
	}

	public String getTxtUsuario() {
		return txtLivro;
	}

	public void setTxtLivro(String txtLivro) {
		this.txtLivro = txtLivro;
	}

	

	

	public List<Livro> getListaLivros() {
		return listaLivros;
	}

	public void setListaLivros(List<Livro> listaLivros) {
		this.listaLivros = listaLivros;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String getMsgCadastroLivro() {
		return msgCadastroLivro;
	}

	public void setMsgCadastroLivro(String msgCadastroLivro) {
		this.msgCadastroLivro = msgCadastroLivro;
	}


}
