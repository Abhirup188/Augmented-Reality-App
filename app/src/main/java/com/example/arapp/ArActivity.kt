package com.example.arapp

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.ar.core.HitResult
import com.google.ar.core.Plane
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.MaterialFactory
import com.google.ar.sceneform.rendering.ShapeFactory
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode
import com.google.ar.sceneform.rendering.Color as ArColor

class ArActivity : AppCompatActivity() {
    private lateinit var arFragment: ArFragment
    private var selectedColor: Int = Color.RED

    private var isDrillPlaced = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ar)

        selectedColor = intent.getIntExtra("color", Color.RED)
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 0)
        }

        arFragment = supportFragmentManager.findFragmentById(R.id.arFragment) as ArFragment

        arFragment.setOnTapArPlaneListener { hitResult: HitResult, plane: Plane, _ ->
            if(!isDrillPlaced){
                placeCube(hitResult)
                isDrillPlaced = true
            }
        }
    }

    private fun placeCube(hitResult: HitResult) {
        MaterialFactory.makeOpaqueWithColor(this, ArColor(selectedColor))
            .thenAccept { material ->
                val cube = ShapeFactory.makeCube(
                    com.google.ar.sceneform.math.Vector3(0.1f, 0.1f, 0.1f),
                    com.google.ar.sceneform.math.Vector3(0f, 0.1f, 0f),
                    material
                )

                val anchorNode = AnchorNode(hitResult.createAnchor())
                anchorNode.setParent(arFragment.arSceneView.scene)

                val cubeNode = TransformableNode(arFragment.transformationSystem)
                cubeNode.setParent(anchorNode)
                cubeNode.renderable = cube
                cubeNode.select()
            }
    }
}
