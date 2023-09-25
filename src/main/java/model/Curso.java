package model;

public class Curso {
	
	private int codigo;
	private String nome;
	private float notaenade;
	private float horario;
	private String sigla;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getNotaenade() {
		return notaenade;
	}
	public void setNotaenade(float notaenade) {
		this.notaenade = notaenade;
	}
	public float getHorario() {
		return horario;
	}
	public void setHorario(float horario) {
		this.horario = horario;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	private Aluno aluno;


	@Override
	public String toString() {
		return "Curso [codigo=" + codigo + ", nome=" + nome + ", notaenade=" + notaenade + ", horario=" + horario
				+ ", sigla=" + sigla + ", aluno=" + aluno + "]";
	}
	
}

	

