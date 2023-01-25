import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MyApiCall {


    fun getData(myUrl:String, myOutput : (String) -> Unit, myOutputError : (String) -> Unit) {

        GlobalScope.launch(Dispatchers.IO) {
            (URL(myUrl).openConnection() as HttpsURLConnection).apply {
                if(responseCode == 200) {
                    val inputSystem = inputStream
                    val inputStreamReader = InputStreamReader(inputSystem, "UTF-8")

                    myOutput(inputStreamReader.readText())

                    inputStreamReader.close()
                    inputSystem.close()
                } else {
                    myOutputError("Failed Connection")
                    //binding.baseCurrency.text = "Failed Connection"
                }
            }


        }


    }
}