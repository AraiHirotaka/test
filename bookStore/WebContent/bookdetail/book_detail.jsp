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
     <body>
     <!-- サイトTOPへのLink先を記入  -->
		<A Href="./../Top.jsp"><input TYPE="button" value="Back to TopPage" > </A>
     <h3>書籍詳細ページ</h3>
		  <img 　src="a.jpg"Border="0" Width="300" Height="300" title="新井のページへ" />
		  <h3>商品名:XXXXXXXX</h3>
		  <h3>価格:XXXXXXXX　　</h3>
		  <h3>ISBN：XXXXXXXX</h3>
		  <h3>著書名：XXXXXXXX</h3>
		  <h3></h3>
		  
		  <form>
			<INPUT TYPE="button" VALUE="Add To Cart" 　onclick=alert('カートに追加されました')>
</form>

		  
		  
		
     

     </body>
</html>