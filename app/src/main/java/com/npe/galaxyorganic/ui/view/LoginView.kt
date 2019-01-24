package com.npe.galaxyorganic.ui.view

import android.content.Intent
import android.support.v4.app.FragmentActivity
import com.facebook.AccessToken
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.npe.galaxyorganic.ui.model.datum.DatumLoginModel

interface LoginView {
    interface LoginUserView {
        fun showLoading()
        fun hideLoaidng()
        fun successLogin(idUser: Int)
        fun failedLogin(message: String?)
        fun startActivityForResult(signInIntent: Intent)
    }

    interface AccountUser {
        fun dataUser()
    }

    interface LoginGoogleView {
        fun loginFrom(from : String)
        fun setLoginDB()
        fun getDataUserDB(userDataDB: ArrayList<DatumLoginModel>)
        fun idUser(id: String)
        fun getIdUser(): Int
        //facebook
        fun initFB()
        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent)
        fun onButtonClicked(activity: FragmentActivity?)
        fun handleFacebookToken(
            accessToken: AccessToken?,
            activity: FragmentActivity?
        )
        //google
        fun configureGoogle(
            default_web_client_id: String,
            requireActivity: FragmentActivity
        )
        fun firebaseAuthWithGoogle(account: GoogleSignInAccount?)
        fun loginGoogle()
        fun SignOut()
        fun revokeAccess()
    }
}