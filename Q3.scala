object Q3 {
	def main(args : Array[String]) : Unit = {
		print("Enter the positive integer value of n : ")
		val n = scala.io.StdIn.readLine().toInt
		sumOfFirst_n_FibonacciNumber(n)
	}
	println()
	
	def sumOfFirst_n_FibonacciNumber(n: Int): Unit = {
		if (n <= 0) {
		println("Please enter a positive integer for n")
    return
  }

	var a = 0
	var b = 1
	
	print(a + ",") 
	print(b + ",") 

	for (i <- 2 until n) {
		val c = a + b
		print(c + ",")
		a = b
		b = c
	}
}

}
