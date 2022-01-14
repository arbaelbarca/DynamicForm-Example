package com.example.dynamicform.utils

import com.example.dynamicform.adapter.AdapterForm
import com.example.dynamicform.listener.OnValidationBtnEnabled

class OnValidationFieldForm(val onValidationBtnEnabled: OnValidationBtnEnabled) {
    fun validationForm(adapterForm: AdapterForm) {
        var isBtnEnable = true
        val formAdapter = adapterForm.getListItem()

        for (element in formAdapter) {

            if (element.isMandatoryField == 1 && element.valueField.isEmpty()) {
                isBtnEnable = false
            }

            onValidationBtnEnabled.onBtnEnable(isBtnEnable)
        }

    }
}