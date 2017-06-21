<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<!--  
	  <head>
          <meta charset=UTF-8>
          <meta http-equiv="x-ua-compatible" content="ie=edge">
		  <meta name="viewport" content="width=device-width, initial-scale=1.0">
   		  <link href="https://fonts.googleapis.com/css?family=Alex+Brush" rel="stylesheet"> 
   		  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/topstyle.css">
          <title>TopPage</title>
          
           <h3>Site Menu</h3>
        <ul>
          <li><a href="#">TOP</a></li>
          <li><a href="./cart/cart.jsp">Cart</a></li>
          <li><a href="#">Account Sign up OR Sign in</a></li>

        </ul>
          
     </head>
  
	-->
	

      <jsp:include page="header.jsp">
		<jsp:param name="title" value="Menu" />
	</jsp:include>
     <body>
     
      <jsp:include page="page-head.jsp">
		<jsp:param name="title" value="Serch" />
	</jsp:include>
     <body>
     
     
     <h1>Hey!! What kind of book are you looking for?</h1>
     
     
     <div id="base">
  		<div id="wrap">
    		<div id="contents">
      			<div id="c_pad">
     
		<div class="box2">
          <h3>Arai's Photo album1</h3>
		  <div class="img_left"><A Href=".\bookdetail\book_detail.jsp"><img src="a.jpg"Border="0" Width="140" Height="100" title="詳細情報" /> </A></div>
		  asshole.<br />
		  <br />
	    </div>
	    
	   
	    <div class="box2">
	     <h3>Arai's Photo album2</h3>
		  <div class="img_left"><A Href=".\bookdetail\book_detail.jsp"><img src="a.jpg"Border="0" Width="140" Height="100" title="詳細情報" /> </A></div>
		  asshole.<br />
		  <br />
	    </div>
	    
	    
	    <div class="box2">
	     <h3>Arai's Photo album3</h3>
		  <div class="img_left"><A Href=".\bookdetail\book_detail.jsp"><img src="a.jpg"Border="0" Width="140" Height="100" title="詳細情報" /> </A></div>
		  asshole.<br />
		  <br />
	    </div>
	    
	    <div class="box2">
	     <h3>Arai's Photo album4</h3>
		  <div class="img_left"><A Href=".\bookdetail\book_detail.jsp"><img src="a.jpg"Border="0" Width="140" Height="100" title="詳細情報" /> </A></div>
		  asshole.<br />
		  <br />
	    </div>
	
      </div>
       </div>
        </div>
         </div>
           

     </body>
</html>