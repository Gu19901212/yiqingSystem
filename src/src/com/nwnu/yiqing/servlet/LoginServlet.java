package com.nwnu.yiqing.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
/**
 * ��¼
 */
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.formula.functions.T;

import com.nwnu.yiqing.bean.Operator;
import com.nwnu.yiqing.bean.Page;
import com.nwnu.yiqing.bean.SearchProperty;
import com.nwnu.yiqing.config.BaseConfig;
import com.nwnu.yiqing.dao.StudentDao;
import com.nwnu.yiqing.dao.CollegeadminDao;
import com.nwnu.yiqing.dao.SchoolOfficeDao;
import com.nwnu.yiqing.entity.Student;
import com.nwnu.yiqing.entity.Collegeadmin;
import com.nwnu.yiqing.entity.SchoolOffice;
import com.nwnu.yiqing.util.StringUtil;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5870852067427524781L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String vcode = req.getParameter("vcode");
		String msg = "success";
		if(StringUtil.isEmpty(name)){
			msg = "用户名不能为空!";
		}
		if(StringUtil.isEmpty(password)){
			msg = "密码不能为空!";
		}
		if(StringUtil.isEmpty(vcode)){
			msg = "验证码不能为空!";
		}
		if("success".equals(msg)){
			Object loginCpacha = req.getSession().getAttribute("loginCpacha");
			if(loginCpacha == null){
				msg = "session已过期，请刷新页面后重试！";
			}else{
				if(!vcode.toUpperCase().equals(loginCpacha.toString().toUpperCase())){
					msg = "验证码错误";
				}
			}
			
		}
		if("success".equals(msg)){
			String typeString = req.getParameter("type");
			try {
				int type = Integer.parseInt(typeString);
				if(type == 1){
					//��������Ա�û�
					SchoolOfficeDao adminDao = new SchoolOfficeDao();
					SchoolOffice admin = adminDao.getAdmin(name);
					adminDao.closeConnection();
					if(admin == null){
						msg = "不存在该用户！";
					}
					if(admin != null){
						if(!password.equals(admin.getPassword())){
							msg = "密码错误！";
						}else{
								req.getSession().setAttribute("user", admin);
								req.getSession().setAttribute("userType", type);
						}
					}
				}else if(type == 2){
					//ѧ����¼
					StudentDao studentDao = new StudentDao();
					Page<Student> page = new Page<Student>(1, 10);
					page.getSearchProperties().add(new SearchProperty("name", name, Operator.EQ));
					Page<Student> studentPage = studentDao.findList(page);
					studentDao.closeConnection();
					if(studentPage.getConten().size() == 0){
						msg = "不存在该用户！";
					}else{
						Student student = studentPage.getConten().get(0);
						if(!password.equals(student.getPassword())){
							msg = "密码错误！";
						}else{
							req.getSession().setAttribute("user", student);
							req.getSession().setAttribute("userType", type);
						}
					}
					
				}else if(type == 3){
					//�޹ܵ�¼
					CollegeadminDao collegeDao = new CollegeadminDao();
					Page<Collegeadmin> page = new Page<Collegeadmin>(1, 10);
					page.getSearchProperties().add(new SearchProperty("name", name, Operator.EQ));
					page = collegeDao.findList(page);
					collegeDao.closeConnection();
					if(page.getConten().size() == 0){
						msg = "不存在该用户！";
					}else{
						Collegeadmin college = page.getConten().get(0);
						if(!password.equals(college.getPassword())){
							msg = "密码错误！";
						}else{
							req.getSession().setAttribute("user", college);
							req.getSession().setAttribute("userType", type);
						}
					}
				}else{
					msg = "用户类型错误";
				}
			} catch (Exception e) {
				// TODO: handle exception
				msg = "用户类型错误";
			}
		}
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(msg);
	}
}
