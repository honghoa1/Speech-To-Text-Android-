<?php
 	require "connect1.php";
 	$query = "SELECT quangcao.Id,quangcao.Hinhanh,quangcao.Noidung,quangcao.Idlichsu,lichsu.TenLichsu,lichsu.HinhLichsu FROM `lichsu` INNER JOIN quangcao ON quangcao.Idlichsu = lichsu.IdLichSu WHERE quangcao.Idlichsu = lichsu.IdLichSu";
 	$data = mysqli_query($con,$query);
 	class Quangcao{
 		function Quangcao($idquangcao,$hinhanh,$noidung,$idlichsu,$tenlichsu,$hinhlichsu){
 			$this -> IdQuangCao = $idquangcao;
 			$this -> Hinhanh = $hinhanh;
 			$this -> Noidung = $noidung;
 			$this -> IdLichSu = $idlichsu;
 			$this -> TenLichsu = $tenlichsu;
 			$this -> HinhLichsu = $hinhlichsu;

 		}
 	}
 	$mangquangcao = array();
 	while ($row = mysqli_fetch_assoc($data)){
 		array_push($mangquangcao, new Quangcao($row['Id'],$row['Hinhanh'],$row['Noidung'],
 			$row['Idlichsu'],$row['TenLichsu'],$row['HinhLichsu']));
 		
 	}
 	echo json_encode($mangquangcao);
?>