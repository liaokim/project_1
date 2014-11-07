<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <%@ include file="../platform/include_start.jsp" %>

<head>
    <%int today = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)-1;%>
<style type="text/css">
        table {
            border-right: 1.5px solid #F00;
            border-bottom:1.5px solid #F00;
            
        }
        
         td {
            border-left: 1.5px solid #F00;
            border-top:1.5px solid #F00;
        }
      
		.viewimge{
			width:150px;
			height:150px;
		}
		
		#gallery { float: left; width: 65%; min-height: 12em;}
		.gallery.custom-state-active { background: #eee; }
		  .gallery li { float: left; width: 200px; padding: 0.4em; margin: 0 0.4em 0.4em 0; text-align: center; }
		  .gallery li h5 { margin: 0 0 0.4em; cursor: move;}
		  .gallery li a { float: right; }
		  .gallery li a.ui-icon-zoomin { float: left; }
		  .gallery li img { width: 100%; cursor: move; }
		 
		#route { float: right; width: 32%; min-height: 18em; padding: 1%; }
		#route h4 { line-height: 16px; margin: 0 0 0.4em; }
		#route h4 .ui-icon { float: left; }
		#route .gallery h5 { display: none; }
		
		#mainDiv{
			overflow:auto;
		}  


    </style>
   
	<link rel="stylesheet" href="../Styles/jquery-ui.min.css"> <!-- 蕙齊link-->
  

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
                                <a href="route_plan.jsp">路經規劃</a>
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
                        <a href="../P4_MessageBoard/showALL.jsp">留言板</a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Blog <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="../blog-home-1.html">Blog Home 1</a>
                            </li>
                            <li>
                                <a href="../blog-home-2.html">Blog Home 2</a>
                            </li>
                            <li>
                                <a href="../blog-post.html">Blog Post</a>
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

<!-- ******************************************************************* -->
 
    <img src = "images/02.gif" /> 欲選擇其他地區
	<select  id="sel1">
		<option value="北部" id="N">北部</option>
  		<option value="中部" id="C">中部</option>
  		<option value="南部" id="S">南部</option>
  		<option value="東部" id="E">東部</option>
	</select>
	<!-- 放抓到的area值 -->
	<input type="text" id="resp" value="${area}" hidden/>
	<input type="text" id="respPath" value="${path}" hidden/>
	
	<div id="mainDiv" class="ui-widget ui-helper-clearfix">
	<ul id="gallery" class="gallery ui-helper-reset ui-helper-clearfix">
	<!-- <li class="ui-widget-content ui-corner-tr"> -->
	<!--     <h5 class="ui-widget-header">七分窯</h5> -->
	<%--   	<img src='${pageContext.servletContext.contextPath}/GetImageServlet' alt="七分窯" width="150" height="150"> --%>
	<!--   	<a href="images/high_tatras.jpg" title="景點描述" class="ui-icon ui-icon-zoomin">景點描述</a> -->
	<!--     <a href="link/to/trash/script/when/we/have/js/off" title="加入行程" class="ui-icon ui-icon-image">加入行程</a> -->
	<!--   </li> -->
	<!--   <li class="ui-widget-content ui-corner-tr"> -->
	<!--     <h5 class="ui-widget-header">七分窯</h5> -->
	<%--   	<img src='${pageContext.servletContext.contextPath}/GetImageServlet' alt="七分窯" width="150" height="150"> --%>
	<!--   	<a href="images/high_tatras.jpg" title="景點描述" class="ui-icon ui-icon-zoomin">景點描述</a> -->
	<!--     <a href="link/to/trash/script/when/we/have/js/off" title="加入行程" class="ui-icon ui-icon-image">加入行程</a> -->
	<!--   </li>   -->
	<!--   <li class="ui-widget-content ui-corner-tr"> -->
	<!--     <h5 class="ui-widget-header">七分窯</h5> -->
	<%--   	<img src='${pageContext.servletContext.contextPath}/GetImageServlet' alt="七分窯" width="150" height="150"> --%>
	<!--   	<a href="images/high_tatras.jpg" title="景點描述" class="ui-icon ui-icon-zoomin">景點描述</a> -->
	<!--     <a href="link/to/trash/script/when/we/have/js/off" title="加入行程" class="ui-icon ui-icon-image">加入行程</a> -->
	<!--   </li>     -->
	</ul>

<div id="route" class="ui-widget-content ui-state-default">
 
<h4 class="ui-widget-header"><span class="ui-icon ui-icon-image">Route</span> Route</h4>
</div>

</div>

<!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script> -->
<script>!window.jQuery && document.write("<script src='../Script/jquery-2.1.1.min.js'><\/script>")</script>
<script src='../Script/jquery-ui.js'></script>	
<script>

        (function ($) {      	
        	var respPath="";
         	$(window).load(function() {
	        	var area = $("#resp").val();
	        	respPath = $("#respPath").val();
	        	if(area=="北部"){$("#N").prop("selected",true);}
	        	if(area=="南部"){$("#S").prop("selected",true);}
	        	if(area=="東部"){$("#E").prop("selected",true);}
	        	if(area=="中部"){$("#C").prop("selected",true);}
	        	show(area);
			});
        	
        	$('#sel1').change(function(){
    		 	area = $(this).val();
    		 	show(area);
    		});
        	
        	function show(area){        		
	        	$('#gallery').empty();//clear images in maindiv
	        	var url = "viewnameServlet";
	        	$.getJSON(url, {'area':area,'action':'GetAllByArea'}, function(datas){
	        		$.each(datas,function(i,item){
	           			//i->index
	           			//item -> item
	           			//console.log(item.viewID);
	           			//console.log(item.viewname);
	           			//var namelable = $('<lable></lable>').text(item.viewname);
	           			var namehead = $('<h5></h5>').text(item.viewname).addClass("ui-widget-header");
	           			
	           			
	           			//get img
	            			var imgarea="E_";
	
	           			switch(area){
	           				case "北部":
	           					imgarea="N_";
	           					break;
	           				case "中部":
	           					imgarea="C_";
	           					break;
	           				case "南部":
	           					imgarea="S_";
	           					break;
	           				case "東部":
	           					imgarea="E_";
	           					break;
	           			}
	           			
	           			var imgs = $('<img></img>').attr("src",'http://localhost:8081/'+respPath+'/GetImageServlet?id='+imgarea+ item.viewID + '_01')
	           									   .addClass("viewimge")
	           									   .attr("alt",item.viewname);
	           			var viewimg = $(imgs).attr("src");
	           			//alert(viewimg);
	           			var alinkdesc = $('<a></a>').attr("title", "景點描述")
	           										.attr("href",viewimg)			//check pic
													.addClass("ui-icon ui-icon-zoomin")
													.text("景點描述");
	           			
	           			var alinkaddroute = $('<a></a>').attr("title", "加入行程")
													.addClass("ui-icon ui-icon-image")
													.attr("href",'#')
													.text("加入行程");
	           			
	           			var idli = $('<li></li>').attr("id", item.viewID)
	           										.append(namehead)
	           										.append(imgs)
	           										.append(alinkdesc)
	           										.append(alinkaddroute)
	           										.addClass("ui-widget-content ui-corner-tr")
	           										.draggable({
	           								             cancel: "a.ui-icon", // clicking an icon won't initiate dragging
	           								             revert: "invalid", // when not dropped, the item will revert back to its initial position
	           								             containment: "document",
	           								             helper: "clone",
	           								             cursor: "move"
	           								            })
	           								        .click(function click(event){
	           								        		var $item = $( this ),
	           							                	$target = $( event.target );
	           							              		//alert("click");//debug
	           							              		if ( $target.is( "a.ui-icon-image" ) ) {
	           							                		deleteImage( $item );
	           							              		} else if ( $target.is( "a.ui-icon-zoomin" ) ) {
	           							                		viewLargerImage( $target );
	           							              		} else if ( $target.is( "a.ui-icon-refresh" ) ) {
	           							            	  		recycleImage( $item );
	           							              		}
	           							         		     return false;
	           								        });
	           										
	           			
	           			
	           			var ul = $('#gallery').append(idli);
	           			//$('#mainDiv').append(ul);
	            	});
	            });
        	};//end of area button click
        	
        	
        	// there's the gallery and the RouteDiv
            var $gallery = $( "#gallery" ),
              $route = $( "#route" );
         
            // let the gallery items be draggable
//             $( "li", $gallery ).draggable({
//              cancel: "a.ui-icon", // clicking an icon won't initiate dragging
//              revert: "invalid", // when not dropped, the item will revert back to its initial position
//              containment: "document",
//              helper: "clone",
//              cursor: "move"
//             });
            
         
            // let the Route be droppable, accepting the gallery items
            $route.droppable({
              accept: "#gallery > li",
              activeClass: "ui-state-highlight",
              drop: function( event, ui ) {
                deleteImage( ui.draggable );
              }
            });
         
            // let the gallery be droppable as well, accepting items from the trash
            $gallery.droppable({
              accept: "#route li",
              activeClass: "custom-state-active",
              drop: function( event, ui ) {
                recycleImage( ui.draggable );
              }
            });
         
            // image deletion function
            var recycle_icon = "<a href='#' title='移除景點' class='ui-icon ui-icon-refresh'>移除景點</a>";
            function deleteImage( $item ) {
              $item.fadeOut(function() {
                var $list = $( "ul", $route ).length ?
                  $( "ul", $route ) :
                  $( "<ul class='gallery ui-helper-reset'/>" ).appendTo( $route );
                
                  console.log($item);
                $item.find( "a.ui-icon-image" ).remove();
                $item.append( recycle_icon ).appendTo( $list ).fadeIn(function() {
                	
                  $item
                    .animate({ width: "100px" })
                    .find( "img" )
                      .animate({ height: "100px" });
                });
              });
            }
         
            // image recycle function
            var trash_icon = "<a href='#' title='Delete this image' class='ui-icon ui-icon-image'>Delete image</a>";
            function recycleImage( $item ) {
              $item.fadeOut(function() {
                $item
                  .find( "a.ui-icon-refresh" )
                    .remove()
                  .end()
                  .css( "width", "200px")
                  .append( trash_icon )
                  .find( "img" )
                    .css( "height", "150px" )
                  .end()
                  .appendTo( $gallery )
                  .fadeIn();
              });
            }
         
            // image preview function, demonstrating the ui.dialog used as a modal window
            function viewLargerImage( $link ) {
              var src = $link.attr( "href" ),
                title = $link.siblings( "img" ).attr( "alt" ),
                $modal = $( "img[src$='" + src + "']" );
              
         
              if ( $modal.length ) {
            	  alert("if");
                $modal.dialog( "open" );
              } else {
            	  alert("else");
                var img = $( "<img alt='" + title + "' width='384' height='288' style='display: none; padding: 8px;' />" )
                  .attr( "src", src ).appendTo( "body" );
                setTimeout(function() {
                  img.dialog({
                    title: title,
                    width: 400,
                    modal: true
                  });
                }, 1 );
              }
            }
         
            // resolve the icons behavior with event delegation
//             $( "ul.gallery > li" ).click(function( event ) {
//               var $item = $( this ),
//                 $target = $( event.target );
//               alert("click111");
//               if ( $target.is( "a.ui-icon-image" ) ) {
//                 deleteImage( $item );
//               } else if ( $target.is( "a.ui-icon-zoomin" ) ) {
//                 viewLargerImage( $target );
//               } else if ( $target.is( "a.ui-icon-refresh" ) ) {
//             	  //alert("here");
//                 recycleImage( $item );
//               }
         
//               return false;
//             });
            
//             function click(event){
//             	var $item = $( this ),
//                 $target = $( event.target );
//               alert("click");
//               if ( $target.is( "a.ui-icon-image" ) ) {
//                 deleteImage( $item );
//               } else if ( $target.is( "a.ui-icon-zoomin" ) ) {
//                 viewLargerImage( $target );
//               } else if ( $target.is( "a.ui-icon-refresh" ) ) {
//             	  //alert("here");
//                 recycleImage( $item );
//               }
         
//               return false;
//             }
        	
        	
        	
        })(jQuery);
        
    </script>
</body>
</html>