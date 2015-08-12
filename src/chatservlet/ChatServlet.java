package chatservlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet(name = "ChatServlet", urlPatterns = "/ChatServlet")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChatServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("进来get了");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("进来post了");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		try {
			// String jsondata =
			// "{\"DishType\" : {\"id\" : \"1\",\"name\" : \"推荐\",\"Dish\" : [ {\"id\" : \"1\",\"name\" : \"青菜\"}, {\"id\" : \"2\",\"name\" : \"白菜\"}]}}";
			// JSONObject jsonObj = JSONObject.fromObject(jsondata);
			JSONObject jsonObj1 = JSONObject.fromObject(readjson(request));
			response.getWriter().print(jsonObj1);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected JSONObject readjson(HttpServletRequest request) throws Exception {
		JSONObject jsonobjects = new JSONObject();
		try {
			JSONArray ja = new JSONArray();
			Map parametermap = request.getParameterMap();
			// 通过循环遍历的方式获得key和value并set到jsonobject中
			Iterator paiter = parametermap.keySet().iterator();
			while (paiter.hasNext()) {
				String key = paiter.next().toString();
				System.out.println(key);
				String[] values = (String[]) parametermap.get(key);
				System.out.println(values.length);
				JSONObject jsonobject = new JSONObject();
				for (int i = 0; i < values.length; i++)
					jsonobject.accumulate(key, values[i]);
				ja.add(jsonobject);
			}
			jsonobjects.put("member", ja);
			System.out.println(jsonobjects.toString());
		}
		catch (Exception e) {
			System.out.println("获取json数据出错，错误信息如下：nt" + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return jsonobjects;
	}

}
