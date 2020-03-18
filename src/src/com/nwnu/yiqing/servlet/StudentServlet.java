package com.nwnu.yiqing.servlet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import  com.nwnu.yiqing.bean.Operator;
import  com.nwnu.yiqing.bean.Page;
import  com.nwnu.yiqing.bean.SearchProperty;
import  com.nwnu.yiqing.dao.StudentDao;
import com.nwnu.yiqing.dao.yiqingDao;
import com.nwnu.yiqing.entity.Collegeadmin;
import  com.nwnu.yiqing.entity.Student;
import com.nwnu.yiqing.entity.yiqing;
import  com.nwnu.yiqing.util.StringUtil;

public class StudentServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5553783024898694511L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method = req.getParameter("method");
		if("toAdminListView".equals(method)){
			req.getRequestDispatcher("view/adminList.jsp").forward(req, resp);
		}
		if("AdminList".equals(method)){
			getStudentList(req,resp);
		}
		if("submitdata".equals(method)){
			addState(req,resp);
		}
	}


	private void getStudentList(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		int pageNumber = Integer.parseInt(req.getParameter("page"));
		int pageSize = Integer.parseInt(req.getParameter("rows"));
		String college = req.getParameter("college");
		if(StringUtil.isEmpty(college)){
			college = "";
		}
		Map<String, Object> ret = new HashMap<String, Object>();
		yiqingDao adminDao = new yiqingDao();
		Page<yiqing> page = new Page<yiqing>(pageNumber, pageSize);
		//获取当前登录用户信息
		Collegeadmin loginedStudent = (Collegeadmin)req.getSession().getAttribute("user");
		page.getSearchProperties().add(new SearchProperty("college", loginedStudent.getCollege(), Operator.EQ));
		Page<yiqing> findList = adminDao.findList(page);
		ret.put("rows", findList.getConten());
		ret.put("total", findList.getTotal());
		adminDao.closeConnection();
		resp.setCharacterEncoding("utf-8");
		try {
			resp.getWriter().write(JSONObject.fromObject(ret).toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addState(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
				
				//String state = req.getParameter("output");
				//yiqing change = new yiqing();
				//change.setState(state);
				yiqingDao studentDao = new yiqingDao();
				String msg = "fail";
				Collegeadmin loginedStudent = (Collegeadmin)req.getSession().getAttribute("user");
				String college=loginedStudent.getCollege();
				System.out.println("学院："+college);
				if(studentDao.updateyiqing(college)){
					msg = "sucess！";
				}
				studentDao.closeConnection();
				try {
					resp.getWriter().write(msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}
	
	
}
