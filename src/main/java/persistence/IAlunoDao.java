package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Aluno;

public interface IAlunoDao {
	
	public String insereAluno (Aluno a)    throws SQLException, ClassNotFoundException;
	public String atualizaAluno (Aluno a)  throws SQLException, ClassNotFoundException;
	public String excluiAluno (Aluno a)    throws SQLException, ClassNotFoundException;
	public Aluno consultaAluno (Aluno a)   throws SQLException, ClassNotFoundException;
	public List<Aluno> consultaAluno()     throws SQLException, ClassNotFoundException;

}
