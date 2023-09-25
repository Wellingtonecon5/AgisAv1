package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Curso;

public interface ICursoDao {
	
	public String insereCurso (Curso c)    throws SQLException, ClassNotFoundException;
	public String atualizaCurso (Curso c)  throws SQLException, ClassNotFoundException;
	public String excluiCurso (Curso c)    throws SQLException, ClassNotFoundException;
	public Curso consultaCurso (Curso c)   throws SQLException, ClassNotFoundException;
	public List<Curso> consultaCurso()  throws SQLException, ClassNotFoundException;

}
