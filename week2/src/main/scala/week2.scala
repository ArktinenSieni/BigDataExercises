/**
  * @author Matti Räty 014168475
  */


import java.util.Calendar

import org.apache.spark.{SparkConf, SparkContext}

object week2 {
  /**
   * Big Data Frameworks Exercises
   * https://courses.helsinki.fi/en/data14001/124845011
   * https://www.cs.helsinki.fi/courses/582740/2017/k/k/1
   */

  def exercise1(sc: SparkContext) = {
    /**
     * Write your Docstring here
     */

    abstract class Record extends Serializable {
      override def hashCode(): Int = super.hashCode()
    }

    case class Book(isbn: String, title: String, author: String, year: String, publisher: String) extends Record {

    }

    val bookRatingsTextFile = sc.textFile("resources/BX-dataset-fixed/BX-Book-Ratings.csv")
    val booksTextFile = sc.textFile("resources/BX-dataset-fixed/BX-Books.csv")
    val usersTextFile = sc.textFile("resources/BX-dataset-fixed/Users.csv")

    val books = booksTextFile
      .flatMap(_.split("\n"))
      .map(line => {
        val cells = line.split(";")

        try {
          new Book(cells(0), cells(1), cells(2), cells(3), cells(4))
        } catch {
          case e: Exception =>
            println("Exception when going through books: ", e.toString)
            new Book("", "", "", "", "")
        }
      })


    books.saveAsObjectFile("./results" + Calendar.getInstance().getTimeInMillis)
  }
  def exercise2(sc: SparkContext) = {
    /**
     * Write your Docstring here
     */
  }
  def exercise3(sc: SparkContext) = {
    /**
     * Write your Docstring here
     */
  }
  def exercise4(sc: SparkContext) = {
    /**
     * Write your Docstring here
     */
  }
  def exercise5(sc: SparkContext) = {
    /**
     * Write your Docstring here
     */
  }
  def exercise6(sc: SparkContext) = {
    /**
     * Write your Docstring here
     */
  }

  def main(args: Array[String]): Unit =  {
    val conf = new SparkConf().setAppName("week2").setMaster("local")
    val sc = new SparkContext(conf)
    /* Run exercise1 code */
    exercise1(sc)
    /* Run exercise2 code */
    exercise2(sc)
    /* Run exercise3 code */
    exercise3(sc)
    /* Run exercise4 code */
    exercise4(sc)
    /* Run exercise5 code */
    exercise5(sc)
    /* Run exercise6 code */
    exercise6(sc)
    /* Stop the sc */
    sc.stop()
  }

}
