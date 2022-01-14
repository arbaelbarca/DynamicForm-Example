package com.example.dynamicform.adapter

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dynamicform.databinding.LayoutItemFormBinding
import com.example.dynamicform.listener.OnValidationField
import com.example.dynamicform.model.ModelForm

class AdapterForm(
    val mutableList: List<ModelForm>,
    val onValidationField: OnValidationField
) :
    RecyclerView.Adapter<AdapterForm.MyHolder>() {
    class MyHolder(val view: LayoutItemFormBinding) : RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            LayoutItemFormBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    fun getListItem(): List<ModelForm> {
        return mutableList
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val modelForm = mutableList[position]
        holder.view.apply {
            tvItemLabelForm.text = modelForm.titleField

            if (modelForm.isShowField == 0) {
                llItemForm.visibility = View.GONE
            }

            edItemForm.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    val getText = p0.toString()
                    mutableList[holder.adapterPosition].valueField = getText
                    onValidationField.validationField(getText, modelForm)
                }

                override fun afterTextChanged(p0: Editable?) {
                }

            })
        }

    }

    override fun getItemCount(): Int {
        return mutableList.size

    }
}