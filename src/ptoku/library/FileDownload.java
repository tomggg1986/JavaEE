package ptoku.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownload
 */
@WebServlet(description = "create download file", urlPatterns = { "/download" })
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public FileDownload() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	byte[] bufor = readFile("C:\\Users\\Tomek\\Pictures\\image.bmp");
    	response.setContentType("image/bmp");
    	response.setContentLength(bufor.length);
    	response.addHeader("Content-Disposition", "attachment; filename=image.bmp");
    	OutputStream os = response.getOutputStream();
    	os.write(bufor);
    	os.flush();
	
    }
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private byte[] readFile(String fileName) throws IOException{
		File f = new File(fileName);
		long size = f.length();
		byte[] image = new byte[(int) size];
		FileInputStream fis = new FileInputStream(f);
		fis.read(image);
		return image;
	}

}
