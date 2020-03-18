package com.nwnu.yiqing.servlet;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import  com.nwnu.yiqing.bean.Operator;
import  com.nwnu.yiqing.bean.Page;
import  com.nwnu.yiqing.bean.SearchProperty;
import  com.nwnu.yiqing.dao.yiqingDao;
import com.nwnu.yiqing.entity.Collegeadmin;
import com.nwnu.yiqing.entity.Student;
import  com.nwnu.yiqing.entity.yiqing;
import  com.nwnu.yiqing.util.StringUtil;
import javax.servlet.http.HttpServletRequest;
public class yiqingServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1028698240374315446L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method = req.getParameter("method");
		if("toStudentListView".equals(method)){
			req.getRequestDispatcher("view/studentList.jsp").forward(req, resp);
		}
		if("Addyiqing".equals(method)){
			try {
				addyiqing(req,resp);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void addyiqing(HttpServletRequest req, HttpServletResponse resp) throws IOException, ParseException {
		// TODO Auto-generated method stub
		String name = new String(req.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("name3"+name);
		String college = new String(req.getParameter("college").getBytes("ISO-8859-1"),"UTF-8");
		String class1 = new String(req.getParameter("class1").getBytes("ISO-8859-1"),"UTF-8");
		String date = new String(req.getParameter("date").getBytes("ISO-8859-1"),"UTF-8");
		String place = new String(req.getParameter("place").getBytes("ISO-8859-1"),"UTF-8");
		String wuhan = new String(req.getParameter("wuhan").getBytes("ISO-8859-1"),"UTF-8");
		String hubei = new String(req.getParameter("hubei").getBytes("ISO-8859-1"),"UTF-8");
		String wuhancontact = new String(req.getParameter("wuhancontact").getBytes("ISO-8859-1"),"UTF-8");
		String hubeicontact = new String(req.getParameter("hubeicontact").getBytes("ISO-8859-1"),"UTF-8");
		String back = new String(req.getParameter("back").getBytes("ISO-8859-1"),"UTF-8");
		String suspected = new String(req.getParameter("suspected").getBytes("ISO-8859-1"),"UTF-8");
		String confirm = new String(req.getParameter("confirm").getBytes("ISO-8859-1"),"UTF-8");
		
		resp.setCharacterEncoding("utf-8");
		Student loginedStudent = (Student)req.getSession().getAttribute("user");
		String name1=loginedStudent.getName();
		yiqing student = new yiqing();
		
		student.setName1(name);
		student.setCollege(college);
		student.setClass1(class1);
		student.setDate(date);
		student.setPlace(place);
		student.setWuhan(wuhan);
		student.setHubei(hubei);
		student.setWuhancontact(wuhancontact);
		student.setHubeicontact(hubeicontact);
		student.setBack(back);
		student.setSuspected(suspected);
		student.setConfirm(confirm);
		//student.setSn(StringUtil.generateSn("S", ""));
		yiqingDao studentDao = new yiqingDao();
		String msg = "你今天已经提交过了，不可重复提交!";
		
		//判断时间是否在每天十点以前
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
    	String now =df.format(new Date());	
    	
    	SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd ");//设置日期格式
    	String start =df2.format(new Date());
    	
    	SimpleDateFormat df3 = new SimpleDateFormat("yyyy-MM-dd ");//设置日期格式
    	String end =df3.format(new Date());
    	
		String format = "yyyy-MM-dd HH:mm";
        Date nowTime = new SimpleDateFormat(format).parse(now);
        Date startTime = new SimpleDateFormat(format).parse(start+"00:00");
        Date endTime = new SimpleDateFormat(format).parse(end+"10:00");
        System.out.println(isEffectiveDate(nowTime, startTime, endTime));
        if(isEffectiveDate(nowTime, startTime, endTime)){
        	if(studentDao.add(student)){
    			msg = "提交成功";
    		}
        }
        else {
        	    msg="请于每天十点填写！";
        }
		studentDao.closeConnection();
		resp.getWriter().write(msg);
	}
	
	
	 /**
     * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
     * 
     * @param nowTime 当前时间
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }
}

