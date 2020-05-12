package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import entidade.Usuario;

@ManagedBean(name = "LoginBean")
@SessionScoped
public class LoginBean {

	private String txtUsuario;
	private String txtSenha;

	private List<Usuario> listaUsuarios;
	private Usuario usuario; // Objeto para cadastro
	private String msgCadastroUsuario;
	
	private UsuarioDAO usuarioDAO;

	/**
	 * Construtor, que vai inicializar a lista de usuarios
	 */
	public LoginBean() {
		this.listaUsuarios = new ArrayList<Usuario>();
		this.usuario = new Usuario();
		this.usuarioDAO = new UsuarioDAOImpl();
	}

	/**
	 * Metodo responsavel por validar o usuario no login
	 */
	public String entrar() {

		boolean achou = false;

		this.listaUsuarios = this.usuarioDAO.listarTodos();
		
		for (Usuario usuarioPesquisa : listaUsuarios) {

			if (usuarioPesquisa.getCpf().equals(this.txtUsuario) && usuarioPesquisa.getSenha().equals(this.txtSenha)) {

				achou = true;
			}
		}

		if (achou) {
			return "livro.xhtml";
		} else {
			return "login.xhtml";
		}

	}

	/**
	 * Metodo responsavel por criar um novo usuario na lista
	 */
	public void criarUsuario() {

		Usuario novo = new Usuario();

		novo.setNome(this.usuario.getNome());
		novo.setCpf(this.usuario.getCpf());
		novo.setSenha(this.usuario.getSenha());

		boolean achou = false;
		
		this.listaUsuarios = this.usuarioDAO.listarTodos();
		
		for (Usuario usuarioPesquisa : listaUsuarios) {
			if (usuarioPesquisa.getCpf().equals(this.usuario.getCpf())) {
				achou = true;
			}
		}
		
		if(achou) {
			FacesContext.getCurrentInstance()
				.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Usuario já existe!!!"));
		}else {
//			this.listaUsuarios.add(novo);
			this.usuarioDAO.inserir(novo);
			
			this.usuario = new Usuario();	
		}
	}

	public String getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(String txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public String getTxtSenha() {
		return txtSenha;
	}

	public void setTxtSenha(String txtSenha) {
		this.txtSenha = txtSenha;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getMsgCadastroUsuario() {
		return msgCadastroUsuario;
	}

	public void setMsgCadastroUsuario(String msgCadastroUsuario) {
		this.msgCadastroUsuario = msgCadastroUsuario;
	}

}
