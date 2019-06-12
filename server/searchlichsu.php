<?php
	require "connect1.php";

		class Vietha {
			function Vietha($idlichsu,$tenlichsu,$hinhlichsu,$mota){
				$this -> IdLichSu = $idlichsu;
				$this -> TenLichsu = $tenlichsu;
				$this -> HinhLichsu = $hinhlichsu;
				$this -> MoTa = $mota;
			}
		}

	$manglichsu = array();


	$query = "SELECT * FROM lichsu";
		$data = mysqli_query($con,$query);
		while ($row = mysqli_fetch_assoc($data)){
			array_push($manglichsu, new Vietha($row['IdLichSu'],$row['TenLichsu'],$row['HinhLichsu'],$row['MoTa']));
		}

		echo json_encode($manglichsu) ;
	


?>