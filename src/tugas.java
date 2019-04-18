

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class tugas
 */
@WebServlet("/")
public class tugas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tugas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject json = new JSONObject();
        String foo = request.getParameter("foo");
        String bar = request.getParameter("bar");
        String quote = request.getParameter("quote");
        String filename = "/quotes.txt";
        ArrayList<String> list = new ArrayList<String>();
        ServletContext context = getServletContext();
        InputStream is = context.getResourceAsStream(filename);
        if (is != null) {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            String text;
            while ((text = reader.readLine()) != null) {
                list.add(text);
            }
        }
		Random r = new Random();
		int index = r.nextInt(((list.size() - 1) - 0) + 1) + 0;
        if(foo != null) {
        	json.put("foo",foo);
        }
        if(bar != null) {
        	json.put("bar",bar);
        }
        if(quote != null) {
        	json.put("quote",list.get(index));
        }
		response.getWriter().print(json);
	}

}
