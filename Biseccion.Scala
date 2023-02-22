import scala.util.control.Breaks._
object Biseccion {
    def main(args: Array[String]) = {
        var maximo=10000
        var a=1.0
        var b=2.0
        var n=1
        var tol=0.001
        while(n<=maximo){
            var c=(a+b)/2
            if(funcion_objetivo(c)==0||(b-a)<tol){
         		println(c)
         		break
         	}
            n=n+1
            if((funcion_objetivo(c)<0 && funcion_objetivo(a)<0)|| (funcion_objetivo(c)>0 && funcion_objetivo(a) >0)){
                a=c
            }
            else{
    			b=c
    		}
         }
    }
    def funcion_objetivo(x: Double): Double={
         return (x*x*x - x -2)
    }
}
