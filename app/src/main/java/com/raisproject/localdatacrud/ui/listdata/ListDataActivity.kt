package com.raisproject.localdatacrud.ui.listdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.raisproject.localdatacrud.R
import com.raisproject.localdatacrud.data.model.Data
import com.raisproject.localdatacrud.databinding.ActivityListDataBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListDataActivity : AppCompatActivity() {

    private val viewModel: ListViewModel by viewModels()
//    lateinit var data: Data

    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityListDataBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        viewModel.saveData(data)

        val dataAdapter = DataAdapter()

        binding.apply {
            rvListData.apply {
                adapter = dataAdapter
                layoutManager = LinearLayoutManager(this@ListDataActivity)
                setHasFixedSize(true)
            }


        }
    }
}