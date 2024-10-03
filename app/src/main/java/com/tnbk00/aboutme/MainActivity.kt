package com.tnbk00.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tnbk00.aboutme.ui.theme.AboutMeTheme
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.tnbk00.aboutme.databinding.ActivityMainBinding


class MainActivity : ComponentActivity() {
    private lateinit var  binding: ActivityMainBinding
    private val myName: MyName = MyName("Daniel Tickell")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }

    }
    private fun addNickname(view: View) {
        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()

            invalidateAll()
            binding.nicknameEdit.visibility = View.GONE
            binding.doneButton.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE
        }

        val inm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}

