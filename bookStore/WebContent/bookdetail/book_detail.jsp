<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
     <head>
          <meta charset=UTF-8>
          <meta http-equiv="x-ua-compatible" content="ie=edge">
		  <meta name="viewport" content="width=device-width, initial-scale=1.0">
   	<!--  <link href="https://fonts.googleapis.com/earlyaccess/notosansjapanese.css" rel="stylesheet" /> -->
   		  <link href="https://fonts.googleapis.com/css?family=Mogra" rel="stylesheet">
   		  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/detailstyle.css">
          <title>BookDetailPage</title>
     </head>
     
     <jsp:include page="../header.jsp">
		<jsp:param name="title" value="Menu" />
	</jsp:include>
     <body>
     <!-- サイトTOPへのLink先を記入  -->
		<A Href="./../Top.jsp"><input TYPE="button" value="Back to TopPage" > </A>
     <h3>書籍詳細ページ</h3>
		  <img src="a.jpg"Border="0" Width="300" Height="300" title="新井のページへ" />
		  <h31>商品名:XXXXXXXX</h31><br><br>
		  <h31>価格:XXXXXXXX　　</h31><br><br>
		  <h31>書籍コード：XXXXXX</h31><br><br>
		  <h31>著者名：XXXXXXXX</h31><br><br><br>
		  
		  <form>
			<INPUT TYPE="button" VALUE="Add To Cart" onclick=alert('カートに追加されました')>
</form>

		  
		  
		
     

     </body>
</html>