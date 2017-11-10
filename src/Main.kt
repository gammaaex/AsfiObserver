import java.util.*

fun main(args: Array<String>) {
    val sqlManager = SQLManager("//Users/admin/Library/Application Support/Vivaldi/Default/History")
    var record : List<urls>
    var titleList = ArrayList<String>()
    var previousString = ""

    while (true){
        record = sqlManager.getAllRecord()

        record.mapTo(titleList) { it.title }

        val reverseList = titleList
        Collections.reverse(reverseList)

        var counter = 0
        var tweetString = "asfiが直近にアクセスしたページ\n---------------------------\n"

        for (title in reverseList) {
            if(title == "") continue

            if(counter + title.length < 140){
                counter += title.length
                tweetString += title + "\n"
            }else{
                break
            }
        }

        if (previousString != tweetString){
            previousString = tweetString
            System.out.printf(tweetString)
//        HttpClient().executePost("http://localhost:8080",tweetString)
        }

        Thread.sleep(5000)
    }
}