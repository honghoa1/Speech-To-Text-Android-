<?php
	$hostname = "localhost";
	$username = "root";
	$password = "19981998a";
	$databasesename = "Vietha";


	$con = mysqli_connect($hostname,$username,$password,$databasesename);

	mysqli_query($con,"SET NAMES 'utf8'");
?>