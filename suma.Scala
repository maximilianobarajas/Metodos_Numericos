object suma{
	def main(args: Array[String])={
    println("La suma por la derecha es: "+ suma_der())
    println("La suma por la izquierda es: " + suma_izq())
    println("La suma de doble precision es: " + suma_doble_precis())
	}
	def suma_der(): Float={
		var suma:Float =0.000f
        var i: Float =1f
		while(i<=5000){
			  val termino: Float=1/(i*i)
              suma=suma+termino
		      i=i+1
		}
		return suma
	}
	def suma_izq(): Float={
		var suma: Float = 0.000f
		var i: Float =1f
		while(i<=5000){
			val termino: Float=1/(i*i)
			suma=termino+suma
			i=i+1
		}
		return suma
	}
	def suma_doble_precis(): Double={
		var suma: Double=0.0
		var i: Double =1
		while(i<=5000){
			val termino: Double=1/(i*i)
			suma=suma+termino
			i=i+1
		}
		return suma
	}
}