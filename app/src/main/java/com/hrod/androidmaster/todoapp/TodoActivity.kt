package com.hrod.androidmaster.todoapp

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.hrod.androidmaster.R
import com.hrod.androidmaster.todoapp.TaskCategory.*

class TodoActivity : AppCompatActivity() {

    private val categories = listOf(
        Business,
        Personal,
        Other
    )

    private val tasks = mutableListOf(
        Task("prueba", Business),
        Task("perosnña", Personal),
        Task("otro", Other)
    )

    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

    private  lateinit var rvTasks: RecyclerView
    private lateinit var taskAdapter:TaskAdapter

    private lateinit var fabAddTask: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_todo)
        initComponent()
        initUI()
        initListeners()
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }

    private fun initComponent(){
        rvCategories = findViewById(R.id.rvCategory)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun initUI(){
        categoriesAdapter = CategoriesAdapter(categories){updateCategories(it)}
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        taskAdapter = TaskAdapter(tasks){ onItemsSelected(it)}
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = taskAdapter
    }

    private fun initListeners(){
        fabAddTask.setOnClickListener{
            showDialog()
        }
    }

    private fun showDialog(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)

        val btnAddTask:Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)


        btnAddTask.setOnClickListener{
            val currentTask = etTask.text.toString()
            if(currentTask.isNotEmpty()) {
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: TaskCategory = when (selectedRadioButton.text) {
                    getString(R.string.todo_dialog_category_business) -> Business
                    getString(R.string.todo_dialog_category_personal) -> Personal
                    else -> Other
                }

                tasks.add(Task(currentTask, currentCategory))
                updateTasks()
                dialog.hide()
            }
        }

        dialog.show()
    }

    private fun updateCategories(position: Int){
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateTasks()
    }

    private fun updateTasks (){
        val selectedCategories : List<TaskCategory> = categories.filter { it.isSelected }

        val newTasks = tasks.filter { selectedCategories.contains(it.category) }
        taskAdapter.tasks = newTasks
        taskAdapter.notifyDataSetChanged()
    }

    private fun onItemsSelected(position : Int){
        tasks[position].isSelected = !tasks[position].isSelected
        updateTasks()
    }
}