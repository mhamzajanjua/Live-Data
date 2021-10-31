package android.com.livedata

import android.com.livedata.databinding.ActivityMain2Binding
import android.com.livedata.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private lateinit var mainViewModel : MainViewModeWithArray
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this).get(MainViewModeWithArray::class.java)

//        mainViewModel.loadFruits()

        mainViewModel.getFruits().observe(this, { fruitList ->
            val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                android.R.id.text1,fruitList)
            binding.listView.adapter = adapter
        })

        binding.btnAdd.setOnClickListener {
            mainViewModel.addFruit()
        }
    }
}