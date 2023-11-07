<!DOCTYPE html>
<!-- Coding by CodingNepal || www.codingnepalweb.com -->
<html lang="es">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!-- Boxicons CSS -->
<link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css"
	rel="stylesheet" />
<title>RESTAURANTE - CARBÓN BLANCO</title>
<link rel="shortcut icon" href="img/logocolegio.png">
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<!-- navbar -->
	<nav class="navbar">
		<div class="logo_item">
			<i class="bx bx-menu" id="sidebarOpen"></i> <img src=""
				alt="">CARBON BLANCO
		</div>

		<div class="search_bar">
			<input type="text" placeholder="Search" />
		</div>

		<div class="navbar_content">
			<i class="bi bi-grid"></i> <i class='bx bx-sun' id="darkLight"></i> <i
				class='bx bx-bell'></i> <img src="img/profile.jpg" alt=""
				class="profile" />
		</div>
	</nav>

	<!-- sidebar -->
	<nav class="sidebar">
		<div class="menu_content">
			<ul class="menu_items">
				<div class="menu_title menu_dahsboard"></div>
				<!-- duplicate or remove this li tag if you want to add or remove navlink with submenu -->
				<!-- start -->
					<li class="item"><a href="index.jsp" class="nav_link"> <span
						class="navlink_icon"> <i class="bx bxs-magic-wand"></i>
					</span> <span class="navlink">BIENVENIDOS</span>
				</a></li>
				<!-- end -->

				<!-- duplicate this li tag if you want to add or remove  navlink with submenu -->
				<!-- start -->
<!-- 				<li class="item"> -->
<!-- 					<div href="#" class="nav_link submenu_item"> -->
<!-- 						<span class="navlink_icon"> <i class="bx bx-grid-alt"></i> -->
<!-- 						</span> <span class="navlink">Overview</span> <i -->
<!-- 							class="bx bx-chevron-right arrow-left"></i> -->
<!-- 					</div> -->

<!-- 					<ul class="menu_items submenu"> -->
<!-- 						<a href="#" class="nav_link sublink">Nav Sub Link</a> -->
<!-- 						<a href="#" class="nav_link sublink">Nav Sub Link</a> -->
<!-- 						<a href="#" class="nav_link sublink">Nav Sub Link</a> -->
<!-- 						<a href="#" class="nav_link sublink">Nav Sub Link</a> -->
<!-- 					</ul> -->
<!-- 				</li> -->
				<!-- end -->
			</ul>

			<ul class="menu_items">
				<div class="menu_title menu_editor"></div>
				<!-- duplicate these li tag if you want to add or remove navlink only -->
				<!-- Start -->
<!-- 				<li class="item"><a href="#" class="nav_link"> <span -->
<!-- 						class="navlink_icon"> <i class="bx bxs-magic-wand"></i> -->
<!-- 					</span> <span class="navlink">Tuition</span> -->
<!-- 				</a></li> -->
				<!-- End -->

				<li class="item"><a href="client.jsp" class="nav_link"> <span
						class="navlink_icon"> <i class="bx bx-loader-circle"></i>
					</span> <span class="navlink">CLIENTES</span>
				</a></li>
				<li class="item"><a href="mozos.jsp" class="nav_link"> <span
						class="navlink_icon"> <i class="bx bx-filter"></i>
					</span> <span class="navlink">MOZOS</span>
				</a></li>
				<li class="item"><a href="categoria.jsp" class="nav_link"> <span
						class="navlink_icon"> <i class="bx bx-cloud-upload"></i>
					</span> <span class="navlink">CATEGORIAS</span>
				</a></li>
			</ul>
			<ul class="menu_items">
				<div class="menu_title menu_setting"></div>
				<li class="item"><a href="activity.jsp" class="nav_link"> <span
						class="navlink_icon"> <i class="bx bx-flag"></i>
					</span> <span class="navlink">RESERVAS</span>
				</a></li>

				<li class="item"><a href="#" class="nav_link"> <span
						class="navlink_icon"> <i class="bx bx-cog"></i>
					</span> <span class="navlink">PEDIDO</span>
				</a></li>
				
				<li class="item"><a href="#" class="nav_link"> <span
						class="navlink_icon"> <i class="bx bx-cog"></i>
					</span> <span class="navlink">COCINA</span>
				</a></li>
				
			</ul>

			<!-- Sidebar Open / Close -->
			<div class="bottom_content">
				<div class="bottom expand_sidebar">
					<span> EXPANDIR</span> <i class='bx bx-log-in'></i>
				</div>
				<div class="bottom collapse_sidebar">
					<span> OCULTAR</span> <i class='bx bx-log-out'></i>
				</div>
			</div>
		</div>
	</nav>
	<!-- JavaScript -->
	<script src="js/script.js"></script>
</body>
</html>
