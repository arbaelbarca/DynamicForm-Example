package com.example.dynamicform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dynamicform.adapter.AdapterForm
import com.example.dynamicform.databinding.ActivityMainBinding
import com.example.dynamicform.listener.OnValidationBtnEnabled
import com.example.dynamicform.listener.OnValidationField
import com.example.dynamicform.model.ModelForm
import com.example.dynamicform.utils.OnValidationFieldForm

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var adapterForm: AdapterForm? = null
    var isEnableBtnMandatory = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initial()
    }

    private fun initial() {
        initListForm()
    }

    private fun initListForm() {
        val mutableListForm: MutableList<ModelForm> = arrayListOf()
        mutableListForm.addAll(
            listOf(
                ModelForm(
                    "Form 1",
                    "",
                    0,
                    1
                ),
                ModelForm(
                    "Form 2",
                    "",
                    1,
                    1
                ),
                ModelForm(
                    "Form 3",
                    "",
                    1,
                    1
                )
            )
        )

        initAdapter(mutableListForm)
    }

    private fun initAdapter(mutableListForm: MutableList<ModelForm>) {
        adapterForm = AdapterForm(mutableListForm, object : OnValidationField {
            override fun validationField(textField: String, modelForm: ModelForm) {
                OnValidationFieldForm(object : OnValidationBtnEnabled {
                    override fun onBtnEnable(isBtnEnable: Boolean) {
                        checkBtnEnable(isBtnEnable)
                    }
                }).validationForm(adapterForm!!)
            }
        })

        binding.rvListForm.apply {
            adapter = adapterForm
            layoutManager = LinearLayoutManager(this@MainActivity)
            hasFixedSize()
        }
    }

    private fun checkBtnEnable(btnEnable: Boolean) {
        println("respon Enbled $btnEnable")
        binding.btnSubmitForm.isEnabled = btnEnable
    }
}