package com.example.dynamicform.listener

import com.example.dynamicform.model.ModelForm

interface OnValidationField {
    fun validationField(textField: String, modelForm: ModelForm)
}