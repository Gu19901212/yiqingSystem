package com.nwnu.yiqing.servlet;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.nwnu.yiqing.bean.Operator;
import com.nwnu.yiqing.bean.Page;
import com.nwnu.yiqing.bean.SearchProperty;
import com.nwnu.yiqing.dao.CollegeadminDao;
import com.nwnu.yiqing.dao.StudentDao;
import com.nwnu.yiqing.entity.Collegeadmin;
import com.nwnu.yiqing.entity.Student;
import com.nwnu.yiqing.util.StringUtil;




public class CollegeadminServlet extends HttpServlet {

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
		if("toinformationListView".equals(method)){
			req.getRequestDispatcher("view/informationList.jsp").forward(req, resp);
		}
		if("check".equals(method)){//各学院负责人查看本学院学生信息
			check(req,resp);
		}
		
	}

	private void check(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		int pageNumber = Integer.parseInt(req.getParameter("page"));
		int pageSize = Integer.parseInt(req.getParameter("rows"));
		String college = req.getParameter("confirm");
		if(StringUtil.isEmpty(college)){
			college = "";
		}
		Map<String, Object> ret = new HashMap<String, Object>();
		StudentDao dao = new StudentDao();
		Page<Student> page = new Page<Student>(pageNumber, pageSize);
		Collegeadmin loginedStudent = (Collegeadmin)req.getSession().getAttribute("user");
		page.getSearchProperties().add(new SearchProperty("college", loginedStudent.getCollege(), Operator.EQ));
		Page<Student> findList = dao.findList(page);
		ret.put("rows", findList.getConten());
		ret.put("total", findList.getTotal());
				
		dao.closeConnection();
		resp.setCharacterEncoding("utf-8");
		try {
			resp.getWriter().write(JSONObject.fromObject(ret).toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
