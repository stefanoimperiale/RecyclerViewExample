package com.word.reciclerviewex

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.word.reciclerviewex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var addButton: FloatingActionButton
    private val viewModel: ExampleItemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        addButton = binding.fab


        addButton.setOnClickListener { view ->
            val id = (Math.random() * 1000).toInt()
            val exampleItem = ExampleItem(id, "Random Title $id", "Random Description ${id}")
            viewModel.addItem(exampleItem)
            Snackbar.make(view, "Added element", Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show()
        }
    }
}