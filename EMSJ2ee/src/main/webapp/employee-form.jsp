<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Employee</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
	<form action="${pageContext.request.contextPath}/EC" method="post">
	 <div class="form-group">
    		<label for="txtempid">Employee ID</label>
    		<input type="text" class="form-control" id="txtempid" name="eid" placeholder="Enter EID">
    </div>
     <div class="form-group">
    		<label for="txtempname">Employee Name</label>
    		<input type="text" class="form-control" id="txtempname" name="ename" placeholder="Enter EName">
    </div>
     <div class="form-group">
    		<label for="txtempdept">Department</label>
    		<input type="text" class="form-control" id="txtempdept" name="dept" placeholder="Enter Dept">
    </div>
    <button type="submit" class="btn btn-primary">Add Employee</button>
  	</form>
	</div>
</body>
</html>