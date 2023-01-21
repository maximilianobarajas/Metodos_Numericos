package main

import (
	"fmt"
	"math"
)

func dot(a []float64, b []float64) float64 {
	var dotprod float64 = 0
	for i := 0; i < len(a); i++ {
		dotprod = dotprod + a[i]*b[i]
	}
	return dotprod
}
func Error(A [][]float64, x []float64, b []float64) []float64 {
	Ax_b := make([]float64, len(x))
	for i := 0; i < len(A); i++ {
		Ax_b[i] = dot(A[i], x) - b[i]
	}
	return Ax_b
}
func cerca(a []float64, b []float64, atol float64, rtol float64) bool {
	//absolute(a - b) <= (atol + rtol * absolute(b))
	var con bool = true
	for i := 0; i < len(a); i++ {
		con = con && math.Abs(a[i]-b[i]) <= (atol+rtol*math.Abs(b[i]))
	}
	return con
}
func main() {
	var limit float64 = 1000
	A := [][]float64{{10, -1, 2, 0}, {-1, 11, -1, 3}, {2, -1, 10, -1}, {0, 3, -1, 8}}
	fmt.Println(A)
	b := []float64{6, 25, -11, 15}
	fmt.Println(b)
	fmt.Println("El sistema de ecuaciones es: ")
	for i := 0; i < len(A); i++ {
		for j := 0; j < len(A); j++ {
			if j < len(A)-1 {
				fmt.Print("(", A[i][j], ")", "x", j+1, "+")
			} else {
				fmt.Print("(", A[i][j], ")", "x", j+1)
			}
		}
		fmt.Println("=", b[i])
	}
	x := make([]float64, len(A))
	var cuenta float64 = 0
	for cuenta < limit {
		if cuenta != 0 {
			fmt.Println("Iteracion ", cuenta, x)
		}
		x_nueva := make([]float64, len(A))
		for i := 0; i < len(A); i++ {
			s1 := dot(A[i][0:i], x[0:i])
			s2 := dot(A[i][i+1:], x[i+1:])
			x_nueva[i] = (b[i] - s1 - s2) / A[i][i]
			if i != 0 {
				if x_nueva[i] == x_nueva[i-1] {
					break
				}
			}
		}
		if cerca(x, x_nueva, math.Pow10(-10), 0) {
			break
		}
		copy(x, x_nueva)
		cuenta++
	}
	fmt.Println("El mejor valor encontrado para las variables es:")
	fmt.Println(x)
	fmt.Println("El error es: ", Error(A, x, b))
}
