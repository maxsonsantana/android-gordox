package maxson.com.br.gordox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.core.widget.doAfterTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
        Log.w("Lifecycle", "Create - Estou criando a tela")
    }

    private fun setListeners() {
        alturaEDT?.doAfterTextChanged { text ->
            //Toast.makeText(this, text.toString(), Toast.LENGTH_LONG).show()
        }
        pesoEDT?.doOnTextChanged { text, _, _, _ ->
            //titleTXT?.text = text.toString()
        }
        calcularBTN.setOnClickListener {
            calcularIMC(pesoEDT.text.toString(), alturaEDT.text.toString())
        }
    }

    private fun calcularIMC(peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        if(peso != null && altura != null) {
            val imc = peso / (altura * altura)
            titleTXT.text = "IMC: $imc"
        }
    }

/*
    override fun onStart() {
        super.onStart()
        Log.w("Lyfecycle","Start - Deixei a tela visível para você")
    }

    override fun onResume() {
        super.onResume()
        Log.w("Lyfecycle","Resume - Agora você pode interagir com a tela")
    }

    override fun onPause() {
        super.onPause()
        Log.w("Lyfecycle","Pause - A tela perdeu o foco, você não pode mais interagir")
    }

    override fun onStop() {
        super.onStop()
        Log.w("Lyfecycle","Stop - A tela não está mais visível, porém ainda existe...")
    }

    override fun onRestart() {
        super.onRestart()
        Log.w("Lyfecycle","\nRestart - A tela está retomando o foco...")
    }

    override fun onDestroy() {
        Log.w("Lyfecycle","\nDestroy - Oh No!! The Screen foi destruída!!")
        super.onDestroy()
    }
 */

}