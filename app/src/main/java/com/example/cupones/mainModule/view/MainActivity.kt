package com.example.cupones.mainModule.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.cupones.BR
import com.example.cupones.R
import com.example.cupones.common.utils.hidenKeybord
import com.example.cupones.databinding.ActivityMainBinding
import com.example.cupones.mainModule.viewModel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        setUpViewModel()
        setUpObservers()

    }

    private fun setUpViewModel() {
        val viewMode: MainViewModel by viewModels()
        mBinding.lifecycleOwner = this
        mBinding.setVariable(BR.viewModel, viewMode)

    }

    private fun setUpObservers() {

        mBinding.viewModel?.let {
            it.cupon.observe(this@MainActivity) { cupon ->

                mBinding.isActive = cupon != null && cupon.isActive
            }
            it.getSnackBarMsg().observe(this@MainActivity) { msg ->
                Snackbar.make(mBinding.root, msg, Snackbar.LENGTH_LONG).show()

            }
            it.getIsHidenKeyboard().observe(this@MainActivity){ isHide ->
                if(isHide) hidenKeybord(this@MainActivity, mBinding.root )
            }
        }


    }


}