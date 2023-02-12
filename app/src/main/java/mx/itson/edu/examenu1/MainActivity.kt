package mx.itson.edu.examenu1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var gradosC: EditText
    lateinit var gradosF: EditText
    lateinit var gradosK: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gradosC = findViewById(R.id.etC)
        gradosF = findViewById(R.id.etF)
        gradosK = findViewById(R.id.etK)

        val btnConvertirC: Button = findViewById(R.id.btnGC)
        val btnConvertirF: Button = findViewById(R.id.btnGF)
        val btnConvertirK: Button = findViewById(R.id.btnGK)

        //Convierte a Celsius
        btnConvertirC.setOnClickListener {
            try {
                if(gradosK.text.toString().trim().equals("")){
                    //Convierte desde Farenheit
                    val formattedNumber="%.2f".format(convertirFaC(gradosF.text.toString().toDouble()))
                    gradosC.setText(formattedNumber)
                } else if(gradosF.text.toString().trim().equals("")){
                    //Convierte desde Kelvin
                    val formattedNumber ="%.2f".format(convertirKaC(gradosK.text.toString().toDouble()))
                    gradosC.setText(formattedNumber)
                }
            }catch (e: java.lang.Exception){
                println(e)
            }
        }

        //Convierte a Farenheit
        btnConvertirF.setOnClickListener {
            try {
                if (gradosK.text.toString().trim().equals("")){
                    //Convierte desde celsius
                    val formattedNumber="%.2f".format(convertirCaF(gradosC.text.toString().toDouble()))
                    gradosF.setText(formattedNumber)
                } else if (gradosC.text.toString().trim().equals("")){
                    //Convierte desde Kelvin
                    val formattedNumber="%.2f".format(convertirKaF(gradosK.text.toString().toDouble()))
                    gradosF.setText(formattedNumber)
                }
            } catch (e: java.lang.Exception){
                println(e)
            }
        }

        //Convierte a Kelvin
        btnConvertirK.setOnClickListener {
            try{
                if(gradosF.text.toString().trim().equals("")){
                    //Convierte desde Celsius
                    val formattedNumber ="%.2f".format(convertirCaK(gradosC.text.toString().toDouble()))
                    gradosK.setText(formattedNumber)
                } else if (gradosC.text.toString().trim().equals("")){
                    //Convierte desde Farenheit
                    val formattedNumber ="%.2f".format(convertirFaK(gradosF.text.toString().toDouble()))
                    gradosK.setText(formattedNumber)
                }
            } catch (e: java.lang.Exception){
                println(e)
            }
        }
    }

    //Conversiones desde Celsius
    fun convertirCaF(gradosC: Double):Double{
        var gradosF:Double = (gradosC*9/5)+32
        return gradosF
    }
    fun convertirCaK(gradosC: Double):Double{
        var gradosK : Double = gradosC + 273.15
        return gradosK
    }

    //Conversiones desde Farenheit
    fun convertirFaC (gradosF:Double):Double{
        var gradosC: Double = (gradosF-32)*5/9
        return gradosC
    }
    fun convertirFaK (gradosF:Double):Double{
        var gradosK: Double = ((5*(gradosF-32))/9) + 273.15
        return  gradosK
    }

    //Conversiones desde Kelvin
    fun convertirKaC(gradosK:Double):Double{
        var gradosC: Double = gradosK - 273.15
        return gradosC
    }
    fun convertirKaF(gradosK: Double): Double{
        var gradosF:Double = ((9*(gradosK-273.15))/5)+32
        return gradosF
    }
}