import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.StandardCharsets

class HttpClient {
    fun executeGet(url: String) {
        println("===== HTTP GET Start =====")
        try {
            val url = URL(url)

            var connection: HttpURLConnection? = null

            try {
                connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "GET"

                if (connection.responseCode == HttpURLConnection.HTTP_OK) {
                    InputStreamReader(connection.inputStream,
                            StandardCharsets.UTF_8).use { isr ->
                        BufferedReader(isr).use { reader ->
                            var line = reader.readLine()
                            while (line != null) {
                                println(line)
                            }
                        }
                    }
                }
            } finally {
                if (connection != null) {
                    connection.disconnect()
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        println("===== HTTP GET End =====")
    }

    fun executePost(url: String,body: String) {
        println("===== HTTP POST Start =====")
        try {
            val url = URL(url)

            var connection: HttpURLConnection? = null

            try {
                connection = url.openConnection() as HttpURLConnection
                connection.doOutput = true
                connection.requestMethod = "POST"

                val writer = BufferedWriter(OutputStreamWriter(connection.outputStream,
                        StandardCharsets.UTF_8))

                writer.write(body)
//                writer.write("POST Body")
//                writer.write("\r\n")
//                writer.write("Hello Http Server!!")
//                writer.write("\r\n")
                writer.flush()

                if (connection.responseCode == HttpURLConnection.HTTP_OK) {
                    InputStreamReader(connection.inputStream,
                            StandardCharsets.UTF_8).use { isr ->
                        BufferedReader(isr).use { reader ->
                            var line = reader.readLine()
                            while (line != null) {
                                println(line)
                            }
                        }
                    }
                }
            } finally {
                if (connection != null) {
                    connection.disconnect()
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        println("===== HTTP POST End =====")
    }
}