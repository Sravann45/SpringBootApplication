<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC tutorial - Home JSP</title>

</head>

<body>
<script type="text/javascript">
function OnSubmitForm()
{
   var userid = document.getElementById("userid").value;
   document.userform.action="/"+userid;
   return true;
}
</script>
    <h1>Hello World!</h1>
    <h4>Message- </h4><span>${message}</span>
    <form name="userform" method="post" onsubmit="return OnSubmitForm();">         
          User ID: <input type="text" id="userid" name="userid">                        
         <input type="submit" value="Submit">
    </form>
</body>