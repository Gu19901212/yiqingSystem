<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%request.setCharacterEncoding("utf-8");%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>学生列表</title>
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="easyui/css/demo.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/js/validateExtends.js"></script>
	<script type="text/javascript">
</script>
</head>
<body>
<center>
				<form action="yiqingServlet?method=Addyiqing"  method="post"> 
				
						<h1>学生疫情填报</h1>
						<div class="input">
							<span>姓名<label style="color:red;">*</label></span>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="text" name="name"  required="required"  value="${user.name}" readonly="true"> 
						</div>
						
						</br>
						
						<div class="input">
							<span>学院 <label style="color:red;">*</label></span>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="text" name="college" placeholder="请输入学院" required="required"> 
						</div>
						
						</br>
						
						<div class="input">
							<span>班级<label style="color:red;">*</label></span>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input  type="text" name="class1" placeholder="请输入班级"> 
						</div>
						
						</br>
						
						<div class="input">
							<span>日期<label style="color:red;">*</label></span>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<!-- 获取系统时间 -->
							<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                            <jsp:useBean id="now" class="java.util.Date" />
                            <fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" var="currentdate" />

                             <input type="text" name="date" value="${currentdate}" readonly="true"/>
						</div>
						
						</br>
						
						<div class="input">
							<span>现所在地（精确到市）<label style="color:red;">*</label></span>
							
							<input type="text" name="place" placeholder="请输入地址"> 
						</div>
						
						</br>
						
					<div>
						<span>是否武汉籍<label style="color:red;">*</label></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="wuhan" value="是" /> 是
						&nbsp;&nbsp;&nbsp;
						<input type="radio" name="wuhan" value="否" /> 否			
					</div>
					
					</br>
					
					<div>
						<span>是否湖北籍<label style="color:red;">*</label></span>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="hubei" value="是" /> 是
						&nbsp;&nbsp;&nbsp;
						<input type="radio" name="hubei" value="否" /> 否			
					</div>
					
					</br>
				
					<div>
						<span>是否接触过武汉人员<label style="color:red;">*</label></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="wuhancontact" value="是" /> 是
						&nbsp;&nbsp;&nbsp;
						<input type="radio" name="wuhancontact" value="否" /> 否			
					</div>
					
					</br>
					
					<div>
						<span>是否接触过湖北人员<label style="color:red;">*</label></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="hubeicontact" value="是" /> 是
						&nbsp;&nbsp;&nbsp;
						<input type="radio" name="hubeicontact" value="否" /> 否			
					</div>
					
					</br>
					
					<div>
						<span>是否已返回学校<label style="color:red;">*</label></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="back" value="是" /> 是
						&nbsp;&nbsp;&nbsp;
						<input type="radio" name="back" value="否" /> 否			
					</div>
					
					</br>
					
					<div>
						<span>是否为疑似患者<label style="color:red;">*</label></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="suspected" value="是" /> 是
						&nbsp;&nbsp;&nbsp;
						<input type="radio" name="suspected" value="否" /> 否			
					</div>
					
					</br>
					
					<div>
						<span>是否为确诊患者<label style="color:red;">*</label></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="confirm" value="是" /> 是
						&nbsp;&nbsp;&nbsp;
						<input type="radio" name="confirm" value="否" /> 否
									
					</div>
					
					</br>
					   <input type="submit" value="提交" ">
				</form>
				</table>
	</center>
	
</body>
</html>