package send;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QueryString
 */
@WebServlet(description = "값전달 연습", urlPatterns = { "/QueryString" })
public class QueryString extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String vclass = request.getParameter("class");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		
		out.println("<html><head></head><body>");
		out.println("당신이 입력한 정보(get방식)입니다.<br> 아 이 디 : <b>");
		out.println("id+<br>");
		out.println("비밀번호 : " + pw);
		out.println(id);
		out.println("</b><br> 이름 : <b>");
		out.println(name);
		out.println("</b><br> 구분 : <b>");
		out.println(vclass);
		out.println("</b><br> 전화번호 : <b>");
		out.println(phone1);
		out.println("-");
		out.println(phone2);
		out.println("-");
		out.println(phone3);
		out.println("</b><br><a href='javascript:history.go(-1)'>다시</a>");
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");  // post방식으로 한글값 전달한 경우에 인코딩 처리		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String vclass = request.getParameter("class");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		
		out.println("<html><head></head><body>");
		out.println("당신이 입력한 정보(post방식)입니다.<br> 아 이 디 : <b>");
		out.println(id+"<br>");
		out.println("비밀번호 : " + pw);
		out.println("</b><br> 이름 : <b>");
		out.println(name);
		out.println("</b><br> 구분 : <b>");
		out.println(vclass);
		out.println("</b><br> 전화번호 : <b>");
		out.println(phone1);
		out.println("-");
		out.println(phone2);
		out.println("-");
		out.println(phone3);
		out.println("</b><br><a href='javascript:history.go(-1)'>다시</a>");
		out.println("</body></html>");
		out.close();
		
		QueryDTO dto = new QueryDTO();
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		dto.setVclass(vclass);
		dto.setPhone(phone1+"-"+phone2+"-"+phone3);
		
		QueryDAO dao = QueryDAO.getInstance();
		int result = dao.insert(dto);
		if(result == 1) System.out.println("회원가입 성공");
		
		
	}

}
