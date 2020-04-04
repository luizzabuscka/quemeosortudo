package com.fiap.quemeosortudo

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val names = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btAdd.setOnClickListener {
            val name = etName.text.toString()

            if (name.isEmpty()) {
                Toast.makeText(this@MainActivity,
                    getString(R.string.toast_insert_name),
                    Toast.LENGTH_LONG).show()
            } else {
                names.add(name)
            }

            updateList()
            etName.setText("")
        }

        btSort.setOnClickListener {
            sort()
        }

        updateList()
    }

    private fun updateList() {
        if (names.isEmpty()) {
            tvEmptyList.visibility = View.VISIBLE
            rvNames.visibility = View.INVISIBLE
        } else {
            tvEmptyList.visibility = View.INVISIBLE
            rvNames.visibility = View.VISIBLE
        }

        val namesAdapter = NamesAdapter(names)
        rvNames.adapter = namesAdapter
    }

    private fun sort() {
        val name = names.random()

        AlertDialog
            .Builder(this@MainActivity)
            .setTitle("O sortudo da vez é:")
            .setMessage(name)
            .setNeutralButton("Fechar") {
                    dialog: DialogInterface, _: Int ->
                dialog.dismiss()
            }
            .show()
    }
}
