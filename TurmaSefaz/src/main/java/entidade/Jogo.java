package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="JOGO")
public class Jogo {

	@Id
	@Column(name="ID", nullable = false)
	@GeneratedValue(generator = "S_JOGO")
	@SequenceGenerator(name = "S_JOGO", sequenceName = "S_JOGO", allocationSize = 1)
	private Long id;
	
	@Column(name="NOME", nullable = false)
	private String nome;
	
	@Column(name="GENERO", nullable = false)
	private String genero;
	
	@ManyToOne
	@JoinColumn(name = "nome_plataforma", referencedColumnName = "nome", nullable = false)
	private Plataforma plataforma;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;

	}

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
