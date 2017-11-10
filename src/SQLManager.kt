import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import java.sql.Connection
import kotlin.collections.ArrayList

class SQLManager(dbPath : String) {

    private val dbPath = dbPath

    fun getAllRecord(): List<urls> {
        var connection: Connection? = null
        var statement: Statement? = null
        var resultSet: ResultSet? = null
        var recordList =  ArrayList<urls>()

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath)
            statement = connection?.createStatement()
            resultSet = statement?.executeQuery("select * from " + "urls")
            while(resultSet?.next() == true) {
                recordList.add(getUrlsRecord(resultSet))
            }
        } finally {
            resultSet?.close()
            statement?.close()
            connection?.close()
        }

        return recordList
    }

    private fun getTermsRecord (resultSet: ResultSet) : keyword_search_terms{
            return keyword_search_terms (
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            )
    }

    private fun getUrlsRecord (resultSet: ResultSet) : urls{
        return urls(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getInt(4),
                resultSet.getInt(5),
                resultSet.getInt(6),
                resultSet.getInt(7)
        )
    }

}