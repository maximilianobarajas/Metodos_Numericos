import scala.math._
import scala.util.control.Breaks._
object newton_rhapson{
	def main(args: Array[String])={
      println(newton_rhapson(2,0.001,0.001,1000))
	}
	def funcion_objetivo(x: Double): Double={
		return x*x -2
	}
	def derivada_objetivo(x: Double): Double={
		return 2*x
	}
	def newton_rhapson(xoriginal: Double, tol: Double, e: Double, N: Int): Double={
		var x1=0.0;
		var x0=xoriginal
		var i=0;
		var limite=1000;
		while(i< limite){
			var y=funcion_objetivo(x0)
			var yprima=derivada_objetivo(x0)
			if(abs(yprima)<e){
				break
			}
			x1=x0-y/yprima
			if(abs(x1-x0)<=tol){
				return x1
			}
			x0=x1
			i=i+1
		}
		return x1
	}
}