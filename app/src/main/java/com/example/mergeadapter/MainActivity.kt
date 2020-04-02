package com.example.mergeadapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.MergeAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val oneAdapterOne = RecyclerViewAdapterOne(Task.tasks())
        val oneAdapterTwo = RecyclerViewAdapterTwo(Task.tasks())
        val mergeAdapter = MergeAdapter(oneAdapterOne, oneAdapterTwo)
        recyclerView.adapter = mergeAdapter

    }
}


class RecyclerViewAdapterOne(private var dataSet: List<Task>) :
    RecyclerView.Adapter<RecyclerViewAdapterOne.ViewHolderOne>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolderOne {
        return ViewHolderOne(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_card,
                parent,
                false
            )
        )
    }


    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolderOne, position: Int) {
        holder.title.text = dataSet[position].taskName
    }

    class ViewHolderOne(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
    }

}

class RecyclerViewAdapterTwo(private var dataSet: List<Task>) :
    RecyclerView.Adapter<RecyclerViewAdapterTwo.ViewHolderTwo>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolderTwo {
        return ViewHolderTwo(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout,
                parent,
                false
            )
        )
    }


    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolderTwo, position: Int) {
        holder.title.text = dataSet[position].taskName
    }

    class ViewHolderTwo(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
    }

}

class Task(val taskName: String) {
    companion object {
        fun tasks(): List<Task> {
            val tasks = ArrayList<Task>()
            tasks.add(Task("Read book"))
            tasks.add(Task("Clean room"))
            return tasks;
        }
    }
}