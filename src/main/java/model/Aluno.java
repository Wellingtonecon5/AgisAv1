package model;

public class Aluno {
	
	private String nome;
	private String nomesocial;
	private int cpf;
    private int ra;
    private String instituicaoconclusao;
    private int datanascimento;
    private int ano;
    private int dataconclusao;
    private int anolimite;
    private int semestrelimite;
    private int telefone;
    private String emailpessoal;
    private String emailcorporativo;
    private int potuacao;
    private int posicao;
    private int anoingresso;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomesocial() {
		return nomesocial;
	}
	public void setNomesocial(String nomesocial) {
		this.nomesocial = nomesocial;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getRa() {
		return ra;
	}
	public void setRa(int ra) {
		this.ra = ra;
	}
	public String getInstituicaoconclusao() {
		return instituicaoconclusao;
	}
	public void setInstituicaoconclusao(String instituicaoconclusao) {
		this.instituicaoconclusao = instituicaoconclusao;
	}
	public int getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(int datanascimento) {
		this.datanascimento = datanascimento;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getDataconclusao() {
		return dataconclusao;
	}
	public void setDataconclusao(int dataconclusao) {
		this.dataconclusao = dataconclusao;
	}
	public int getAnolimite() {
		return anolimite;
	}
	public void setAnolimite(int anolimite) {
		this.anolimite = anolimite;
	}
	public int getSemestrelimite() {
		return semestrelimite;
	}
	public void setSemestrelimite(int semestrelimite) {
		this.semestrelimite = semestrelimite;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public String getEmailpessoal() {
		return emailpessoal;
	}
	public void setEmailpessoal(String emailpessoal) {
		this.emailpessoal = emailpessoal;
	}
	public String getEmailcorporativo() {
		return emailcorporativo;
	}
	public void setEmailcorporativo(String emailcorporativo) {
		this.emailcorporativo = emailcorporativo;
	}
	public int getPotuacao() {
		return potuacao;
	}
	public void setPotuacao(int potuacao) {
		this.potuacao = potuacao;
	}
	public int getPosicao() {
		return posicao;
	}
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	public int getAnoingresso() {
		return anoingresso;
	}
	public void setAnoingresso(int anoingresso) {
		this.anoingresso = anoingresso;
	}
	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", nomesocial=" + nomesocial + ", cpf=" + cpf + ", ra=" + ra
				+ ", instituicaoconclusao=" + instituicaoconclusao + ", datanascimento=" + datanascimento + ", ano="
				+ ano + ", dataconclusao=" + dataconclusao + ", anolimite=" + anolimite + ", semestrelimite="
				+ semestrelimite + ", telefone=" + telefone + ", emailpessoal=" + emailpessoal + ", emailcorporativo="
				+ emailcorporativo + ", potuacao=" + potuacao + ", posicao=" + posicao + ", anoingresso=" + anoingresso
				+ ", getNome()=" + getNome() + ", getNomesocial()=" + getNomesocial() + ", getCpf()=" + getCpf()
				+ ", getRa()=" + getRa() + ", getInstituicaoconclusao()=" + getInstituicaoconclusao()
				+ ", getDatanascimento()=" + getDatanascimento() + ", getAno()=" + getAno() + ", getDataconclusao()="
				+ getDataconclusao() + ", getAnolimite()=" + getAnolimite() + ", getSemestrelimite()="
				+ getSemestrelimite() + ", getTelefone()=" + getTelefone() + ", getEmailpessoal()=" + getEmailpessoal()
				+ ", getEmailcorporativo()=" + getEmailcorporativo() + ", getPotuacao()=" + getPotuacao()
				+ ", getPosicao()=" + getPosicao() + ", getAnoingresso()=" + getAnoingresso() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
    
    
    
}


