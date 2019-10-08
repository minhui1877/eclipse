package kenservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kensample.BeanDaoTest;
import kensample.EmpBean;

/**
 * Servlet implementation class UseBeanServlet
 */
@WebServlet("/usebean")
public class UseBeanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String paramId = request.getParameter("paramId");
		
		String paramAge1 = request.getParameter("paramAge1");
		String paramAge2 = request.getParameter("paramAge2");
		
		String result = null;
		
		if(paramId != null && !paramId.equals("")) {
			
			result = idSearch(paramId);
					
		}
		else if(paramAge1 != null && !paramAge1.equals("") && 
				paramAge2 != null && !paramAge2.contentEquals("")) {
			
			result = ageSearch(paramAge1, paramAge2);
			
		}else {
			result = "検索条件を入力してください";
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-trantional.dtd\">");
		
		out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
		out.println("<meta http-equiv=\"Content-style-Type\" content=\"text/css\" />");
		out.println("<style type=\"text/css\">");
		out.println("th{background-color:#FF9900}");
		out.println("</style>");
		out.println("<title>検索結果</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>検索結果</h1>");
		out.println("<p>" + result + "</p>");
		out.println("<p><a href=\"beanSearch.html\">検索ページへ戻る</a></p>");
		out.println("</body>");
		out.println("</html>");
		out.close();

		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	private String idSearch(String paramId) {
		
		String result = null;
		BeanDaoTest daoTest = null;
		
		try {
			int empId = Integer.parseInt(paramId);
			daoTest = new BeanDaoTest();
			
			EmpBean bean = daoTest.getEmpDataById(empId);
			
			if(bean == null) {
				result = "該当者はいません";
				
			}else {
				result = "<table border=\"1\" summary=\"検索結果をまとめた表\">";
				result += "<tr><th>ID</th><th>名前</th><th>住所</th><th>年齢</th><th>E-MAIL</th></tr>";
				result += "<tr>";
				result += "<td>" + bean.getId() + "</td>";
				result += "<td>" + bean.getName() + "</td>";
				result += "<td>" + bean.getAddress() + "</td>";
				result += "<td>" + bean.getAge() + "</td>";
				result += "<td>" + bean.getMail() + "</td>";
				result += "</tr>";
				result += "</table>";	
				
			}
		}catch(NumberFormatException e) {
			result = "数値を入力してください";
            e.printStackTrace();
			
		}catch (SQLException e) {
			result = "JDBCのエラーです。";
			e.printStackTrace();
			
		}catch (Exception e) {
			result = "エラーです。";
			e.printStackTrace();
		}finally {
			
			if(daoTest != null) {
				daoTest.close();
			}
		}
		return result;
		
	}
		

	private String ageSearch(String paramAge1, String paramAge2) {
		//検索結果
		String result = null;
		BeanDaoTest daoTest = null;
		
		try {
			int age1 = Integer.parseInt(paramAge1);
			int age2 = Integer.parseInt(paramAge2);
			
			daoTest = new BeanDaoTest();
			
			ArrayList<EmpBean>empData = daoTest.getEmpDataByAge(age1, age2);
			
			if(empData == null || empData.isEmpty()) {
				result = "<p>該当者はいません</p>";
			}else {
				result = "<table border=\"1\"summary=\"検索結果をまとめた表\">";
				result += "<tr><th>ID</th><th>名前</th><th>住所</th><th>年齢</th><th>E-MAIL</th>";
				
				for(EmpBean bean : empData) {
					result += "<tr>";
					result += "<td>" + bean.getId() + "</td>";
					result += "<td>" + bean.getName() + "</td>";
					result += "<td>" + bean.getAddress() + "</td>";
					result += "<td>" + bean.getAge() + "</td>";
					result += "<td>" + bean.getMail() + "</td>";
					result += "</tr>";
				}
				result += "</table>";
	}

		}catch (NumberFormatException e) {
			result = "数値を入力してください";
			e.printStackTrace();
			
		}catch (SQLException e) {
			result = "JDBCのエラーです。";
			e.printStackTrace();
			
		}catch (Exception e) {
			result = "エラーです。";
			e.printStackTrace();
		}finally {
			//
			if(daoTest != null) {
				daoTest.close();
		}
		}
		
		
		return result;
		
		
	}

}
	

