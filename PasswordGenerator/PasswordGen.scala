package utils{
  object PasswordGen{
    private def allowedChars = (('0' to '9') ++ ('A' to 'Z') ++ ('a' to 'z')).toArray ++ Array('-', '.', '_')
    private def length = allowedChars.length
    private def nextChar() = {
      allowedChars(util.Random.nextInt(length))
    }
    def nextPassword(passwordLen: Int) = {
      val password = new StringBuilder(passwordLen)
      for (i <- 1 to passwordLen)
        password += nextChar()
      password.toString
    }
  }
}

