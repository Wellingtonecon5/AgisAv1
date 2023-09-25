package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;

public class AlunoDao implements IAlunoDao {
	
	private GenericDao gDao;

	public AlunoDao(GenericDao gDao){
		this.gDao = gDao;
	}

	@Override
	public String insereAluno(Aluno a) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "INSERT INTO aluno VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, a.getNome());
		ps.setString(2, a.getNomesocial());
		ps.setInt(3, a.getCpf());
		ps.setInt(4, a.getRa());
		ps.setString(5, a.getInstituicaoconclusao());
		ps.setInt(6, a.getDatanascimento());
		ps.setInt(7, a.getAno());
		ps.setInt(8, a.getDataconclusao());
		ps.setInt(9, a.getAnolimite());
		ps.setInt(10, a.getSemestrelimite());
		ps.setInt(11, a.getTelefone());
		ps.setString(12, a.getEmailpessoal());
		ps.setString(13, a.getEmailcorporativo());
		ps.setInt(14, a.getPotuacao());
		ps.setInt(15, a.getPosicao());
		ps.setInt(16, a.getAnoingresso());
		ps.execute();
		ps.close();
		c.close();
		
		return "Aluno Inserido com Sucesso";
	}

	@Override
	public String atualizaAluno(Aluno a) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "UPDATE aluno SET cpf = ? WHERE cpf = ? ";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(3, a.getNome());
		ps.setString(2, a.getNomesocial());
		ps.setInt(1, a.getCpf());
		ps.setInt(4, a.getRa());
		ps.setString(5, a.getInstituicaoconclusao());
		ps.setInt(6, a.getDatanascimento());
		ps.setInt(7, a.getAno());
		ps.setInt(8, a.getDataconclusao());
		ps.setInt(9, a.getAnolimite());
		ps.setInt(10, a.getSemestrelimite());
		ps.setInt(11, a.getTelefone());
		ps.setString(12, a.getEmailpessoal());
		ps.setString(13, a.getEmailcorporativo());
		ps.setInt(14, a.getPotuacao());
		ps.setInt(15, a.getPosicao());
		ps.setInt(16, a.getAnoingresso());
		ps.execute();
		ps.close();
		c.close();
		
		return "Aluno Atualizado com Sucesso";
	}
	

	@Override
	public String excluiAluno(Aluno a) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "DELETE aluno WHERE cpf = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, a.getCpf());
		ps.execute();
		ps.close();
		c.close();
		
		return "Aluno Inserido com Sucesso";
	}

	@Override
	public Aluno consultaAluno(Aluno a) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "SELECT cpf, nome FROM aluno WHERE cpf = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, a.getCpf());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			a.setCpf(rs.getInt("cpf"));
			a.setNome(rs.getString("nome"));
		}
		rs.close();
		ps.close();
		c.close();

		return a;
	}

	@Override
	public List<Aluno> consultaAluno() throws SQLException, ClassNotFoundException {
			List<Aluno> alunos = new ArrayList<Aluno>();

		Connection c = gDao.getConnection();
		String sql = "SELECT cpf, nome FROM aluno";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Aluno a = new Aluno();
			a.setCpf(rs.getInt("cpf"));
			a.setNome(rs.getString("nome"));
			
			alunos.add(a);
			
		}
		rs.close();
		ps.close();
		c.close();

		return alunos;

	}
}
