<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <title>Index Company Tree Example page</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="themes/default/style.min.css" />
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <!-- Custom styles for this template -->
    <link href="css/starter-template.css" rel="stylesheet">

</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
            </button>
            <a class="navbar-brand" href="#">Company Tree Example</a>
        </div>
    </div>
</nav>

<div class="container">

    <div class="starter-template">
        <h1>Company Tree</h1>
        <h5>Name  <----->  Earn  <----->  Earn+ChildEarn</h5>
        <div id="jstree"></div>
    </div>

</div><!-- /.container -->

<script src="js/jquery-2.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jstree.min.js"></script>
<script src="js/app.js"></script>
</body>
</html>