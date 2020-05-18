import utils._
import scala.io.Source

object Appl{
  
  def countMaxLoginLen(logins: List[String]): Int = {
    val longest = logins.reduceLeft(
      (a, b) => if (a.length > b.length) a else b
    )
    longest.length
  }


  def main(args: Array[String]) = {
      if (args.length < 3){
        println("Not enough arguments - there should be three arguments:\n  the first is the name of a file with logins, \n  the second is the name of a file where generated passwords are written to and \n  the third is the length of passwords")
        System.exit(1)
      }
      
      val logins = args(0)
      val passwords = args(1)
      val passwordLen = args(2).toInt

      val outFile = new java.io.PrintWriter(passwords)
    
      try {
        val loginLines = Source.fromFile(logins).getLines.toList
        val maxLoginLen = countMaxLoginLen(loginLines)
        for (login <- loginLines){
         outFile.println(login + ": " + " " * (maxLoginLen - login.length + 3) + PasswordGen.nextPassword(passwordLen))
        }
      }
      catch {
        case ex: java.io.FileNotFoundException =>
          println(ex.getMessage)
      }

      outFile.close

    }
}
