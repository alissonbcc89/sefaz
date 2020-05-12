package dao;

import java.util.List;

import entidade.Livro;
import entidade.Usuario;

public interface ILivroDao {
	
public void inserir(Livro livro);
	
	public void alterar(Livro livro);

	public void remover(Livro livro);

	public Livro pesquisar(String isbn);

	public List<Livro> listarTodos();


}
