<?php
 	require "connect1.php";
 	$query = "SELECT * FROM lichsu ";
 	$data = mysqli_query($con,$query);
 	class Lichsu{
 		function Lichsu($idlichsu,$tenlichsu,$hinhlichsu,$mota){
 				$this -> IdLichSu = $idlichsu;
				$this -> TenLichsu = $tenlichsu;
				$this -> HinhLichsu = $hinhlichsu;
				$this -> MoTa = $mota;

 		}
 	}
 	$mangsu = array();
 	while ($row = mysqli_fetch_assoc($data)){
			array_push($mangsu, new Lichsu($row['IdLichSu'],$row['TenLichsu'],$row['HinhLichsu'],$row['MoTa']));
		}
 	echo json_encode($mangsu);
?>