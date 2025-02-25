package ir.hajkarami.volumecalculator

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyCustomAdapter(context: Context, shapeArrayList: ArrayList<Shape>) :
    ArrayAdapter<Shape>(context, R.layout.grid_item_layout, shapeArrayList) {

    private class MyViewHolder(view: View) {
        val shapeImage: ImageView = view.findViewById(R.id.imageView)
        val shapeText: TextView = view.findViewById(R.id.titleTextView)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val viewHolder: MyViewHolder
        val view: View

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.grid_item_layout, parent, false)
            viewHolder = MyViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = convertView.tag as MyViewHolder
        }

        val shape: Shape? = getItem(position)
        shape?.let {
            viewHolder.shapeText.text = it.name
            viewHolder.shapeImage.setImageResource(it.image)
        }

        return view
    }
}
