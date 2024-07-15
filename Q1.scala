object Q1 {
	def main(args: Array[String]): Unit = {
    val productList = getProductList
    println("\nProduct List:")
    printProductList(productList)
    println("\nTotal Products: " + getTotalProducts(productList))
   }

   def getProductList: List[String] = {
    var productList: List[String] = Nil 
    var productName: String = ""

    do {
      println("Enter product name (or 'done' to finish):")
      productName = scala.io.StdIn.readLine()
      if (productName != "done") {
        productList = productList :+ productName 
      }
    } while (productName != "done")
	
    productList
   }

   def printProductList(productList: List[String]): Unit = {
    productList.zipWithIndex.foreach { case (name, index) =>
      println((index + 1) + "." + name)
     }
   }

   def getTotalProducts(productList: List[String]): Int = {
    productList.length
  }

}

		