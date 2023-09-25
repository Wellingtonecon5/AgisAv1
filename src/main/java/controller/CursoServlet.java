package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Aluno;
import model.Curso;
import persistence.AlunoDao;
import persistence.CursoDao;
import persistence.GenericDao;
import persistence.IAlunoDao;
import persistence.ICursoDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/curso")
public class CursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CursoServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GenericDao gDao = new GenericDao();
		IAlunoDao aDao = new AlunoDao(gDao);
		String erro = "";
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		
		try {
			alunos = aDao.consultaAluno();
		}catch (ClassNotFoundException | SQLException e) {
			erro = e.getMessage();
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher("curso.jsp");
			request.setAttribute("alunos", alunos);
			request.setAttribute("erro", erro);
			rd.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codigo = request.getParameter("codigo");
		String nome = request.getParameter("nome");
		String notaenade = request.getParameter("notaenade");
		String horario = request.getParameter("horario");
		String sigla = request.getParameter("sigla");
		String botao = request.getParameter("botao");
		
		Curso c = new Curso();
		Aluno a = new Aluno();
	     
		GenericDao gDao = new GenericDao();
		ICursoDao cDao = new CursoDao(gDao);
		IAlunoDao aDao = new AlunoDao(gDao);
		String saida ="";
		String erro = "";
		List<Aluno> alunos = new ArrayList<Aluno>();
		List<Curso> cursos = new ArrayList<Curso>();
	
		try {
			if(botao.equals("Listar")){
			cursos = cDao.consultaCurso();
		}
			if(botao.equals("Inserir")){
			c = valido(codigo, nome, notaenade, horario, sigla, botao, erro);
			saida = cDao.insereCurso(c);
			c = new Curso();
		}
		
			if(botao.equals("Atualizar")){
				c = valido(codigo, nome, notaenade, horario, sigla, botao, erro);
				saida = cDao.atualizaCurso(c);
				c = new Curso();
	}
		
			if(botao.equals("Excluir")){
				c = valido(codigo, nome, notaenade, horario, sigla, botao, erro);
				saida = cDao.excluiCurso(c);
				c = new Curso();
	}
		
			if(botao.equals("Buscar")){
				c = valido(codigo, nome, notaenade, horario, sigla, botao, erro);
				c = cDao.consultaCurso(c);
				a = c.getAluno();
	}
		} catch(SQLException | ClassNotFoundException | IOException e){
		  erro = e.getMessage();
		} finally {
				try {
					cursos = cDao.consultaCurso();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				

		RequestDispatcher rd = request.getRequestDispatcher("curso.jsp");
		request.setAttribute("curso", c);
		request.setAttribute("curso", cursos);
		request.setAttribute("erro", erro);
		request.setAttribute("saida", saida);
		request.setAttribute("alunos" , alunos);
		rd.forward(request, response);
		    }
		}
		   				
	private Curso valido (String codigo, String nome, String aluno, String notaenade, String horario, String sigla, String botao)
			throws IOException {
			    Curso c = new Curso();
			    Aluno a = new Aluno();

				if(botao.equals("Inserir")){
					if(codigo.equals("") || nome.equals("") || aluno.equals("") || notaenade.equals("") || horario.equals("") || sigla.equals(""))
				throw new IOException("Preencher os campos");
					}else {
				a.setCpf(Integer.parseInt(aluno));

				c.setCodigo(Integer.parseInt(codigo));
				c.setNome(nome);
				c.setNotaenade(Float.parseFloat(notaenade));
				c.setHorario(Integer.parseInt(horario));
				c.setSigla(sigla);
				c.setAluno(a);

				}
		
				if(botao.equals("Atualizar")){
					if(codigo.equals("") || nome.equals("") || aluno.equals("") || notaenade.equals("") || horario.equals("") || sigla.equals(""))
				throw new IOException("Preencher os campos");
				}else {
					
				a.setCpf(Integer.parseInt(aluno));

				c.setCodigo(Integer.parseInt(codigo));
				c.setNome(nome);
				c.setNotaenade(Float.parseFloat(notaenade));
				c.setHorario(Integer.parseInt(horario));
				c.setSigla(sigla);
				c.setAluno(a);

					}
		    
				if(botao.equals("Excluir")){
					if(codigo.equals("") )
						throw new IOException("Preencher com o codigo");
					}else {
					c.setCodigo(Integer.parseInt(codigo));
					
	}
				if(botao.equals("Buscar")){
					if(codigo.equals("") )
				throw new IOException("Preencher os campos");
			}else {
				
				c.setCodigo(Integer.parseInt(codigo));
				
          }
				return c;
	}
}