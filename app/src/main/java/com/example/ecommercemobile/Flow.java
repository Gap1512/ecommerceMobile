package com.example.ecommercemobile;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class Flow {
    public Boolean login;
    public Boolean admin;
    public String email;

    public Flow(){
        login=false;
        admin=false;
        email="";
    }

    public void OnClick(View v, Activity activity){
        Class destiny = MainActivity.class;
        //if(v == activity.findViewById(R.id.homebt)) destiny = MainActivity.class;
        if(v == activity.findViewById(R.id.showProductsbt)) destiny = ShowProducts.class;
        if(v == activity.findViewById(R.id.loginPagebt)) destiny = Login.class;
        if(v == activity.findViewById(R.id.createAccountPagebt)) destiny = CreateAccount.class;
        if(v == activity.findViewById(R.id.productsManagerbt)) destiny = ProductsManager.class;
        if(v == activity.findViewById(R.id.usersManagerbt)) destiny = UserManager.class;
        if(v == activity.findViewById(R.id.brandsManagerbt)) destiny = BrandsManager.class;
        if(v == activity.findViewById(R.id.newProductbt)) destiny = ProductRegister.class;
        if(v == activity.findViewById(R.id.newBrandbt)) destiny = BrandsRegister.class;
        if(v == activity.findViewById(R.id.newbt)) destiny = MainActivity.class;
        if(v == activity.findViewById(R.id.cartbt)) destiny = Cart.class;
        if(v == activity.findViewById(R.id.loginbt)) {login = true;}
        if(v == activity.findViewById(R.id.loginAdminbt)) {login = true; admin = true;}
        if(v == activity.findViewById(R.id.createAccountbt)) {login = true;}
        if(v == activity.findViewById(R.id.createAdminAccount)) {login = true; admin = true;}

        if (activity.getClass() != destiny) {
            Intent intent = new Intent(activity, destiny);
            //intent.putExtra("LOGIN",login);
            //intent.putExtra("ADMIN",admin);
            //intent.putExtra("EMAIL",email);
            activity.startActivity(intent);
        }
    }
}
