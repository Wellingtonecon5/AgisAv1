package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import model.Curso;

public class CursoDao implements ICursoDao {
	
	private GenericDao gDao;

	public CursoDao(GenericDao gDao){
		this.gDao = gDao;
	}

	@Override
	public String insereCurso(Curso cu) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "INSERT INTO curso VALUES (?,?,?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, cu.getCodigo());
		ps.setString(2, cu.getNome());
		ps.setFloat (3, cu.getNotaenade());
		ps.setFloat (4, cu.getHorario());
		ps.setInt (5, cu.getCodigo());
		ps.setFloat (6, cu.getHorario());
		ps.setString(7, cu.getSigla());
		ps.setInt(8, cu.getAluno().getCpf());
		ps.execute();
		ps.close();
		c.close();
		
		return "Curso Inserido com Sucesso";
	}

	@Override
	public String atualizaCurso(Curso cu) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "UPDATE curso SET nome = ?, horario =?, sigla = ? WHERE codigo = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(4, cu.getCodigo());
		ps.setString(1, cu.getNome());
		ps.setFloat (5, cu.getNotaenade());
		ps.setFloat (2, cu.getHorario());
		ps.setString(3, cu.getSigla());
		ps.execute();
		ps.close();
		c.close();
		
		return "Curso Atualizado com Sucesso";
	}

	@Override
	public String excluiCurso(Curso cu) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "DELETE curso  WHERE codigo = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, cu.getCodigo());
		ps.execute();
		ps.close();
		c.close();
		
		return "Curso Excluido com Sucesso";
	}

	@Override
	public Curso consultaCurso(Curso cu) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT a.cpf, a.nome, cu.nome, cu.codigo, cu.sigla, cu.horario");
		sql.append("FROM curso cu, aluno a");
		sql.append("WHERE cu.nome = a.nome");
		sql.append("AND cu.codigo = ?");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ps.setInt(1, cu.getCodigo());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Aluno a = new Aluno();
			a.setCpf(rs.getInt("cpf"));
			a.setNome(rs.getNString("nome"));

			cu.setCodigo(rs.getInt("codigo"));
			cu.setNome(rs.getString("nome"));
			cu.setSigla(rs.getString("sigla"));
			cu.setAluno(a);
			}
		rs.close();
		ps.close();
		c.close();
		
		return cu;
	}

	@Override
	public List<Curso> consultaCurso() throws SQLException, ClassNotFoundException {
		List<Curso> curso = new ArrayList<Curso>();
		
		
		Connection c = gDao.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT a.cpf, a.nome, cu.nome, cu.codigo, cu.sigla, cu.horario");
		sql.append("FROM curso cu, aluno a");
		sql.append("WHERE cu.nome = a.nome");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Aluno a = new Aluno();
			a.setCpf(rs.getInt("cpf"));
			a.setNome(rs.getNString("nome"));

			Curso cu = new Curso();
			cu.setCodigo(rs.getInt("codigo"));
			cu.setNome(rs.getString("nome"));
			cu.setSigla(rs.getString("sigla"));
			cu.setAluno(a);
			
			curso.add(cu);
			
			}
		
		rs.close();
		ps.close();
		c.close();
		
		return curso;
	}
	
	

}
