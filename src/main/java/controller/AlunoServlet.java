package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Aluno;
import persistence.AlunoDao;
import persistence.GenericDao;
import persistence.IAlunoDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/aluno")
public class AlunoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlunoServlet() {
        super();
      
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String ra = request.getParameter("ra");
		String datanasc = request.getParameter("datanasc");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String emailpessoal = request.getParameter("emailcorporativo");
		String dataconclusao = request.getParameter("dataconclusao");
		String nomeinstituicao = request.getParameter("nomeinstituicao");
		String pontuacao = request.getParameter("pontuacao");
		String anoingresso = request.getParameter("anoingresso");
		String semestreingresso = request.getParameter("semestreingresso");
		String semestrelimite = request.getParameter("semestrelimite");
		String botao = request.getParameter("botao");
		
		Aluno a = new Aluno();
		
		GenericDao gDao = new GenericDao();
		IAlunoDao aDao = new AlunoDao(gDao);
		String erro = "";
		String saida = "";
		List<Aluno> alunos = new ArrayList<Aluno>();
	
		
		try{
			
				if(botao.equals("Listar")){
					alunos = aDao.consultaAluno();
				}
				if(botao.equals("Inserir")){
					a = valido(cpf, nome, botao, saida);
					saida = aDao.insereAluno(a);
					a = new Aluno();
				}
				if(botao.equals("Atualizar")){
					a = valido(cpf, nome, botao, saida);
					saida = aDao.atualizaAluno(a);
					a = new Aluno();
				}
				if(botao.equals("Excluir")){
					a = valido(cpf, nome, botao, saida);
					saida = aDao.excluiAluno(a);
					a = new Aluno();
				}
				if(botao.equals("Buscar")) {
					a = valido(cpf, nome, botao, saida);
					a = aDao.consultaAluno(a);
				}
				
		}catch(SQLException | ClassNotFoundException | IOException e) {
				erro = e.getMessage();
		   }finally {
			RequestDispatcher rd = request.getRequestDispatcher("aluno.jsp");
			request.setAttribute("aluno", a);
			request.setAttribute("aluno" , alunos);
			request.setAttribute("erro", erro);
			rd.forward(request , response);
		   }
	
	}
	
	private Aluno valido(String nome, String cpf, String email, String botao) throws IOException{
		Aluno a = new Aluno();

		if(botao.equals("Inserir")){
		 if (cpf.equals("") || nome.equals("")){
		    throw new IOException("Preencha com o Nome e Cpf");
		}else{
		  a.setCpf(Integer.parseInt(cpf));
		  a.setNome(nome);

		      }
		}
		
		if(botao.equals("Atualizar")){
			 if (cpf.equals("") || nome.equals("")){
			    throw new IOException("Preencha com o Nome e Cpf");
			}else{
			  a.setCpf(Integer.parseInt(cpf));
			  a.setNome(nome);

			      }
			}
		if(botao.equals("Excluir")){
			 if (cpf.equals("") || nome.equals("")){
			    throw new IOException("Preencha com o Nome e Cpf");
			}else{
			  a.setCpf(Integer.parseInt(cpf));
			  a.setNome(nome);

			      }

		      }
		
		if(botao.equals("Buscar")){
			 if (cpf.equals("") || nome.equals("")){
			    throw new IOException("Preencha com o Nome e Cpf");
			}else{
			  a.setCpf(Integer.parseInt(cpf));
			  a.setNome(nome);
					}
			 }
			return a;
	       }
	}
