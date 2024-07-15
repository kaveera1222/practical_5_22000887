object Q2 {

	case class Book(title: String, author: String, isbn: String)

	val library: Set[Book] = Set( // Initial set with three books
		Book("The Lord of the Rings", "J.R.R. Tolkien", "9780261102694"),
		Book("Pride and Prejudice", "Jane Austen", "9780140439516"),
		Book("Clean Code", "Robert C. Martin", "9780136669900")
	)

	def addBook(book: Book): Unit = {
		if (library.exists(_.isbn == book.isbn)) {
      println(s"Book '<span class="math-inline">\{book\.title\}' already exists in the library\."\)
\} else \{
library \= library \+ book
println\(s"Book '</span>{book.title}' added successfully!")
    }
  }

  def removeBook(isbn: String): Unit = {
    val bookToRemove = library.find(_.isbn == isbn)
    bookToRemove match {
      case Some(book) =>
        library = library - book
        println(s"Book '${book.title}' removed successfully!")
      case None => println("Book not found in the library.")
    }
  }

  def checkBookExists(isbn: String): Boolean = {
    library.exists(_.isbn == isbn)
  }

  def displayLibrary(): Unit = {
    if (library.isEmpty) {
      println("Library is empty!")
    } else {
      println("\nCurrent Library Collection:")
      library.foreach { book =>
        println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
      }
    }
  }

  def searchBookByTitle(title: String): Unit = {
    val searchResult = library.find(_.title.toLowerCase.contains(title.toLowerCase))
    searchResult match {
      case Some(book) => println(s"\nBook Found:\nTitle: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
      case None => println(s"Book with title '$title' not found.")
    }
  }

  def displayBooksByAuthor(author: String): Unit = {
    val authorBooks = library.filter(_.author == author)
    if (authorBooks.isEmpty) {
      println(s"No books found by author '$author'.")
    } else {
      println(s"\nBooks by Author '$author':")
      authorBooks.foreach { book =>
        println(s"Title: ${book.title}, ISBN: ${book.isbn}")
      }
    }
  }

  def main(args: Array[String]): Unit = {
    var choice: Int = 0
    do {
      println("\nLibrary Management System")
      println("1. Add Book")
      println("2. Remove Book")
      println("3. Check if Book Exists")
      println("4. Display Library Collection")
      println("5. Search Book by Title")
      println("6. Display Books by Author")
      println("7. Exit")
      println("Enter your choice:")

      try {
        choice = scala.io.StdIn.readInt()
      } catch {
        case _: NumberFormatException => println("Invalid input. Please enter a number.")
        choice = 0
      }

      choice match {
        case 1 =>
          val newBookTitle = scala.io.StdIn.readLine("Enter book title: ")
          val newBookAuthor = scala.io.StdIn.readLine("Enter book author: ")
          val newBookIsbn = scala.io.StdIn.readLine("Enter book ISBN: ")
          val newBook = Book(newBookTitle, newBookAuthor, newBookIsbn)
          addBook(newBook)
        case 2 =>
          val isbn = scala.io.StdIn.readLine("Enter ISBN of the book to remove: ")
          removeBook(isbn)
        case 3 =>
          val isbn = scala.io.StdIn.readLine("Enter ISBN of the book to check: ")
          val exists = checkBookExists(isbn)
          println(if (exists) "Book exists in the library." else "Book does not exist in the library.")
        case 4 => displayLibrary()
		}
}