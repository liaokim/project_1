<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page import="P4_MessageBoard.model.*"%>
<%@ page import="java.util.*"%>
<%
	MsgService msgSvc = new MsgService();
	List<MsgVO> list = msgSvc.getAll();
	pageContext.setAttribute("list",list);

	// 	List<MsgVO> list2 = msgSvc.getAll();
// 	pageContext.setAttribute("list2",list2);

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ALL message</title>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Modern Business - Start Bootstrap Template</title>
    <!-- Bootstrap Core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../css/modern-business.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<script type="text/javascript">


	function ShowReply(x){
		var ta = document.getElementById(String(x)).value;
// 		alert("ta = " + ta);
		
		var theDIV = document.getElementById("div"+String(x));
		var txtP = document.createTextNode("我等著你出現~~~"+ta);
		theDIV.appendChild(txtP);
		
	}
</script>

    

</head>

<body>
 <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                 <a class="navbar-brand" href="../index.jsp">下一站，幸福</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
<!--                         <a href="P0_login/login.jsp">登入</a> -->
                        <a href="#myModal" data-toggle="modal" data-target="#myModal">登入</a>
                    </li>
<!--                     <li> -->
<!--                         <a href="services.html">Services</a> -->
<!--                     </li>                    -->
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">路徑規劃 <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="../P2_route/route_plan.jsp">路經規劃</a>
                            </li>
                            <li>
                                <a href="portfolio-2-col.html">2 Column Portfolio</a>
                            </li>
                            <li>
                                <a href="portfolio-3-col.html">3 Column Portfolio</a>
                            </li>
                            <li>
                                <a href="portfolio-4-col.html">4 Column Portfolio</a>
                            </li>
                            <li>
                                <a href="portfolio-item.html">Single Portfolio Item</a>
                            </li>
                        </ul>
                    </li>
                     <li>
                        <a href="showALL.jsp">留言板</a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Portfolio <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="../portfolio-1-col.html">1 Column Portfolio</a>
                            </li>
                            <li>
                                <a href="../portfolio-2-col.html">2 Column Portfolio</a>
                            </li>
                            <li>
                                <a href="../portfolio-3-col.html">3 Column Portfolio</a>
                            </li>
                            <li>
                                <a href="../portfolio-4-col.html">4 Column Portfolio</a>
                            </li>
                            <li>
                                <a href="../ortfolio-item.html">Single Portfolio Item</a>
                            </li>
                        </ul>
                    </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Blog <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="../P3_TravelDiary/blog_all.jsp">所有文章</a>
                            </li>
                            <li>
                                <a href="../P3_TravelDiary/blog_editor.jsp">發表新文章</a>
                            </li>
                            <li>
                                <a href="../P3_TravelDiary/blog_manage.jsp">管理我的文章</a>
                            </li>
                        </ul>
                    </li>

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Other Pages <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="../full-width.html">Full Width Page</a>
                            </li>
                            <li>
                                <a href="../sidebar.html">Sidebar Page</a>
                            </li>
                            <li>
                                <a href="../faq.html">FAQ</a>
                            </li>
                            <li>
                                <a href="../404.html">404</a>
                            </li>
                            <li>
                                <a href="../pricing.html">Pricing Table</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Header Carousel -->
    <header id="myCarousel" class="carousel slide">
        <!-- Indicators -->
        <ol class="carousel-indicators">
<!--             <li data-target="#myCarousel" data-slide-to="0" class="active"></li> -->
<!--             <li data-target="#myCarousel" data-slide-to="1"></li> -->
<!--             <li data-target="#myCarousel" data-slide-to="2"></li> -->
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <div class="item active">
                <div class="fill" style="background-image:url('../Images/E_Changhong Bridge_01.bmp');"></div>
                <div class="carousel-caption">
                    <h2>Caption 1</h2>
                </div>
            </div>
            <div class="item">
                <div class="fill" style="background-image:url('../Images/E_Changhong Bridge_02.bmp');"></div>
                <div class="carousel-caption">
                    <h2>Caption 2</h2>
                </div>
            </div>
            <div class="item">
                <div class="fill" style="background-image:url('../Images/E_Changhong Bridge_03.bmp');"></div>
                <div class="carousel-caption">
                    <h2>Caption 3</h2>
                </div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="icon-next"></span>
        </a>
    </header>

	<%-- 老師的blog參考 --%>
	
	<h3>${myinfo}，來留言喔~~</h3>
	<blockquote>麥克風測試~~~~~~~</blockquote>

	<%-- 	<form action="<c:url value="/blog.jsp" />" method="post"> --%>
	<form action="<c:url value="leave_msg.do" />" method="post">
		<blockquote>
			<p>帳號:<input type="text" name="vmember_loginID" value="${myinfo}"><br>	</p>
			<p>標題:<input type="text" name="vtitle" value="台南超好吃"><br></p>
				我有話要說...<br>
			<textarea rows="5" cols="80" name="vcontent"></textarea>
			<input type="submit" value="送出">
		</blockquote>
	</form>


	<h3>全部留言結果</h3>
<%-- 	<%=list.size() %> --%>
	<blockquote>
		<hr width="100%">
		
		<c:forEach var="list" items="${list}">
			<c:if test="${list.replyfrom == '0'}">
			
				<div id = div${list.messageNum}>
			<h4>
				<span>第${list.messageNum}筆</span>

				<span style="font-weight: bolder; color: blue;">${list.member_loginID}</span>&nbsp&nbsp${list.title}&nbsp&nbsp&nbsp&nbsp
				<span style="font-size: 8px; color: silver;">${list.build_time}</span>
			</h4>

			<blockquote>
				<blockquote>
					<h4>${list.content}</h4>
								
					
					<form action="reply.do" method="post">
<!-- 					<textarea rows="3" cols="20" name="vcontent2" id="vcontent2"></textarea> -->
						<textarea rows="3" cols="20" id="${list.messageNum}" name="vcontent${list.messageNum}"></textarea>
						
<%-- 					<input type="button"  onclick="ShowReply(${list.messageNum})" value="try it"> --%>
						<input type="submit" value="回覆" onclick="ShowReply(${list.messageNum})"> 
						<input type="hidden" name="action" value="vcontent${list.messageNum}">
						<input type="hidden" name="forwho" value="${list.messageNum}">
						<input type="hidden" name="forwhah" value="${list.title}">
						<input type="hidden" name="nowuser" value="${myinfo}">
					</form>
				
				<%
					MsgService msgSvc2 = new MsgService();
					List<MsgVO> list2 = msgSvc2.getAll();	
					pageContext.setAttribute("list2",list2);
				%>
					<c:forEach var="list2" items="${list2}">
						<c:if test="${list2.replyfrom == list.messageNum}">
						<blockquote>
							<h4 style="color:red"><span style="font-weight: bolder; color: blue;">${list2.member_loginID}:</span>${list2.content}</h4>
							&nbsp&nbsp${list2.title}&nbsp&nbsp&nbsp&nbsp
							<span style="font-size: 8px; color: silver;">${list2.build_time}</span>
						</blockquote>
						</c:if>
				    </c:forEach>
				</blockquote>
			</blockquote>
			
			
			</div>
			
		<hr>	
		</c:if>
		</c:forEach>
		
	</blockquote>


<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script>!window.jQuery && document.write("<script src='Scripts/jquery-2.1.1.min.js'><\/script>")</script>
<script>
   //使用$要注意有可能會跟別的函式庫發生衝突ex prototype.js
   (function($){
	   //jQuery的程式碼寫在這裡
	   $('h1').css('color','red');	   
	   
	   $('.nav .dropdown').hover(function() {
	        $(this).addClass('open');
	    }, function() {
	        $(this).removeClass('open');
	    });
		
	   
   })(jQuery);
   
</script>



</body>
</html>