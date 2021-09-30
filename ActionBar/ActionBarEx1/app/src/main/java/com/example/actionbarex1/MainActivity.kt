package com.example.actionbarex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * A configuração do título do aplicativo é feita no manifesto, propriedade "label", que, por sua
 * vez, usa o arquivo de recurso "string.xml", aqui alterei para "ActioBar 1
 *
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}