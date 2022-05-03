package com.nicootech.rabinhoodconstraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_image.*


class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        addAnimationOperations()
    }

    private fun addAnimationOperations() {
        var set = false
        val constraint1 = ConstraintSet()
        constraint1.clone(mainroot)
        val constraint2 = ConstraintSet()
        constraint2.clone(this, R.layout.activity_image_alt)


        findViewById<Button>(R.id.button).setOnClickListener{
                TransitionManager.beginDelayedTransition(mainroot)
                val constraint = if(set) constraint1 else constraint2
                constraint.applyTo(mainroot)
                set = !set
        }

    }
}

