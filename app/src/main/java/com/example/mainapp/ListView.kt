package com.example.mainapp

import android.content.Context
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.mainapp.databinding.ActivityListViewBinding

class ListView : AppCompatActivity() {
    lateinit var binding: ActivityListViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var arrayList:ArrayList<Data> = ArrayList()

        arrayList.add(Data("zero","zeroaudio"))
        arrayList.add(Data("one","oneaudio"))
        arrayList.add(Data("two","twoaudio"))
        arrayList.add(Data("three","threeaudio"))
        arrayList.add(Data("four","fouraudio"))
        arrayList.add(Data("five","fiveaudio"))
        arrayList.add(Data("six","sixaudio"))
        arrayList.add(Data("seven","sevenaudio"))
        arrayList.add(Data("eight","eightaudio"))
        arrayList.add(Data("nine","nineaudio"))
        arrayList.add(Data("ten","tenaudio"))

        var adapter:Number_Adapter = Number_Adapter(this,arrayList)
        binding.listView1.adapter = adapter
    }
}
class Number_Adapter : BaseAdapter {
    var arrayList:ArrayList<Data> = ArrayList()
    var context:Context? = null
    constructor(context: Context,arrayList: ArrayList<Data>){
        this.arrayList = arrayList
        this.context = context
    }
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(p0: Int): Any {
       return arrayList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view:View
        var inflater:LayoutInflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val holder:viewHolder
        if(p1 == null)
        {
            view = inflater.inflate(R.layout.list_layout,p2,false)
            holder = viewHolder()
            holder.text = view.findViewById(R.id.textView)
            holder.image = view.findViewById(R.id.imageView)
            view.tag = holder
        }else{
            view = p1
            holder = p1.tag as viewHolder
        }
        val textValue = holder.text
        textValue?.text = arrayList[p0].textNumber
        val imageValue = holder.image
        var mediaplayer:MediaPlayer?
        imageValue?.setOnClickListener{
            mediaplayer = MediaPlayer.create(
                context,context?.resources!!.getIdentifier(arrayList[p0].audioNumber,"raw",context?.packageName))
            mediaplayer?.start()
        }
        return view
    }
    private class viewHolder{
        var text:TextView? = null
        var image:ImageView? = null
    }

}