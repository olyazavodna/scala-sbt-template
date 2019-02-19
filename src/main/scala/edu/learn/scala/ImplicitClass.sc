
class SqlStatementBuilder {

  var text = ""

  def select(columns: String*): SqlStatementBuilder = {
    text += s"select ${columns mkString ", "}"
    this
  }

  def where(condition: String): SqlStatementBuilder = {
    text += s" where ${condition}"
    this
  }

  def and(condition: String): SqlStatementBuilder = {
    text += s" and ${condition}"
    this
  }

  override def toString: String = text
}


val integer = 1
integer.isWhole()


val builder = new SqlStatementBuilder
val selection: SqlStatementBuilder = builder
  .select("col1, col2")
  .where("col1=1")
    .and("col2=2")


class SqlStatementBuilderSyntax(builder: SqlStatementBuilder) {

  def or(condition: String): SqlStatementBuilder = {
    builder.text += s" or ${condition}"
    builder
  }
}

implicit def toSyntax(builder: SqlStatementBuilder): SqlStatementBuilderSyntax =
  new SqlStatementBuilderSyntax(builder)


selection.or("col2=1000")
