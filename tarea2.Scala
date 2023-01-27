object tarea2{
	def main(args: Array[String])={
      println(suma_tarea2(0.0001))
      println(suma_tarea2(0.00001))
      println(suma_tarea2(0.000001))
	}
	def suma_tarea2(x: Double): Double={
        var i: Int =1
        var suma: Double=x
        while(i<=10000){
          suma=suma+x
          i=i+1
        }
        return suma
	}
}