
fun main(args: Array<String>) {
    val myUrl : String = "https://touhidapps.com/api/user_data.php?page=1"
    val myApiCall : MyApiCall = MyApiCall()


    myApiCall.getData(myUrl,myOutput = {
        println(it)
    }, myOutputError = {
        println(it)
    })

    Thread.sleep(5000)

}