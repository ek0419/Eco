package com.example.eco

import androidx.fragment.app.Fragment

/**
Created by Omy on 20,julio,2020
 */
open class BaseFragment : Fragment() {


   open fun  onBackPressed(): Boolean {
        return false
    }
}