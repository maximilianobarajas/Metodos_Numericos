import scala.math._
import scala.util.control.Breaks._
object punto_fijo {
	def main(args: Array[String])={
		punto_fijo(2,0.00001,100)
	}
	def funcion_objetivo(x: Double): Double={
		return (x*x*x + x*x -1)
	}
	def funcion_modificada(x: Double): Double={
		return (1/sqrt(1+x))
	}
	def punto_fijo(xoriginal: Double, e: Double, N: Int)={
		var x0=xoriginal
		var paso = 1
		var bandera =1
		var con = true
		var x1=0.0
		while(con){
			x1=funcion_modificada(x0)
			x0=x1
			paso=paso+1
			if(paso>N){
				bandera=0
				break
			}
			con= abs(funcion_objetivo(x1))>e
		}
		if(bandera==1){
			println(x1)
		}
		else{
			print("No converge")
		}
	}
}
