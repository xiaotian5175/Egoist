package Servlet;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadsServlet
 */
@WebServlet("/Download.do")
public class DownloadsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InputStream is = new FileInputStream("C:\\Users\\hasee\\a\\。。。.txt");
		BufferedInputStream bs = new BufferedInputStream(is);
		byte[] file = new byte[bs.available()];
		bs.read(file,0,bs.available());
		bs.close();
		
		response.setHeader("Content-Disposition","attachment; filename="+"。。。.txt");
		response.setContentType("application/octet-stream");
		
		ServletOutputStream stream  =  response.getOutputStream();
		stream.write(file);
		stream.flush();
		stream.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
