package com.example.amazonui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.amazonui.adapter.EssentialAdapter
import com.example.amazonui.model.Essential


class MainActivity : AppCompatActivity() {

    lateinit var rv_essential:RecyclerView
    lateinit var ll_fashion:LinearLayout
    lateinit var ll_popular:LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {

        ll_fashion = findViewById(R.id.ll_fashion)
        ll_popular = findViewById(R.id.ll_popular)
        rv_essential = findViewById(R.id.rv_essential)

        val manager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_essential.layoutManager = manager

        refreshAdapter(getEssentials())

        setLinearHeight(ll_fashion)
        setLinearHeight(ll_popular)
    }

    private fun refreshAdapter(items: ArrayList<Essential>) {
        val adapter = EssentialAdapter(this,items)
        rv_essential!!.adapter = adapter

    }

    private fun setLinearHeight(layout: LinearLayout) {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val widthPixels =displayMetrics.widthPixels

        val params:ViewGroup.LayoutParams = layout.layoutParams
        params.height = widthPixels
        layout.layoutParams = params
    }

    private fun getEssentials(): ArrayList<Essential> {

        val essentials:ArrayList<Essential> = ArrayList()
        essentials.add(Essential("Camera pro",R.drawable.image_camera1))
        essentials.add(Essential("Camera plus",R.drawable.image_camera2))
        essentials.add(Essential("Camera pro 7",R.drawable.image_camera4))
        essentials.add(Essential("Camera proMax",R.drawable.image_woman_sneaker))
        essentials.add(Essential("Camera pro",R.drawable.image_woman_sneaker2))
        essentials.add(Essential("Camera plus",R.drawable.image_woman_sneaker3))
        essentials.add(Essential("Camera pro 7",R.drawable.image_woman_sneaker4))
        essentials.add(Essential("Camera proMax",R.drawable.image_woman_sneaker))

        return essentials
    }
}