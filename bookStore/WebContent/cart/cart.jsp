<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8>
		<meta http-equiv="x-ua-compatible" content="ie=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!--  <link href="https://fonts.googleapis.com/earlyaccess/notosansjapanese.css" rel="stylesheet" /> -->
		<link href="https://fonts.googleapis.com/css?family=Mogra" rel="stylesheet">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/detailstyle.css">
		<title>CART</title>
	</head>
	
	<body>
		<form>
			<INPUT TYPE="button" VALUE="Back to TopPage"onClick="window.location.href='Top.jsp'">
		</form>
			<h1>CART</h1>
			<div class="img_left">
				<img src="a.jpg" Border="0" Width="140" Height="100" title="" />
				<h4>book</h4>
				<h4>$22.00</h4>
			<br>
			<div class="img_left">
				<img src="a.jpg" Border="0" Width="140" Height="100" title="" />
				<h4>book</h4>
				<h4>$20.00</h4>
			<br>
			<hr size="2" width="20%" align="left">
				<h4>subtotal</h4>
				<h4>$22.00</h4>
				<h4>$20.00</h4>
			<hr size="2" width="20%" align="left">
				<h4>total</h4>
				<h4>$42.00</h4>
			<hr size="2" width="20%" align="left">
			<br>
	</body>

<form>
	<INPUT TYPE="button" VALUE="Purchase"onClick="window.location.href='決算.jsp'">
</form>

</html>