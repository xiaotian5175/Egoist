package Servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/upload.do")
@MultipartConfig(
		fileSizeThreshold = 5_242_880,
maxFileSize = 20_971_520L,
maxRequestSize = 41_943_040L
		)


public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UploadServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part filePart = request.getPart("file");
		InputStream inputStream = filePart.getInputStream();
		OutputStream outputStream = new FileOutputStream("C:\\Users\\hasee\\a\\"+filePart.getSubmittedFileName());
		
		int read;
		final byte[] bytes = new byte[1024];
		while((read = inputStream.read(bytes)) !=-1) {
			outputStream.write(bytes,0,read);
		}
		System.out.println(filePart.getSubmittedFileName());
		outputStream.flush();
		outputStream.close();
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
