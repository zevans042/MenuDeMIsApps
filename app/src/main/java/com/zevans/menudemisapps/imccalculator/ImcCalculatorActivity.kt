package com.zevans.menudemisapps.imccalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.zevans.menudemisapps.R

class ImcCalculatorActivity : AppCompatActivity() {


    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = false

    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
       initListeners()
        initUI()

    }

    private fun initListeners() {
      viewMale.setOnClickListener { setGenderColor() }
        viewFemale.setOnClickListener { setGenderColor() }
    }

    private fun changeGender(){
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor(){
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))

    }



    private fun getBackgroundColor(isSelectedComponet:Boolean):Int{


        val colorReference = if(isSelectedComponet){
            R.color.background_component_selected
        }else{
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)

    }


    private fun initComponents(){
          viewMale = findViewById(R.id.viewMale)
          viewFemale = findViewById(R.id.viewFemale)
    }
    private fun initUI(){

        setGenderColor()

    }

}