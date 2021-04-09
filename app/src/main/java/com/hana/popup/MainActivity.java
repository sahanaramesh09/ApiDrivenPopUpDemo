package com.hana.popup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hana.popup.Model.PopDetails;
import com.hana.popup.Model.ResponseModel;
import com.hana.popup.appconfig.BaseHelper;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String BASE_URL = BaseHelper.BASE_URL_POPUP;

    Retrofit retrofit;
    String backUpLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiCall apicall = retrofit.create(ApiCall.class);

        Call<ResponseModel> call = apicall.getPopDetails();
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                List<PopDetails> popDetails= response.body().resultItems;

                for(PopDetails popDetail: popDetails){
                    String showEmergencyPopUp = popDetail.getShowEmergencyPopUp();
                    if(showEmergencyPopUp.equalsIgnoreCase("yes")){
                        backUpLink = popDetail.getBackUpAppLink();
                        System.out.println("@@@@@backuplink: "+ backUpLink);
                        openPopUpWindow();
                    }
                }

            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });

        //openPopUpWindow();
    }


    /**
     * Pop up on Strike
     */
    private void openPopUpWindow() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        View mView = getLayoutInflater().inflate(R.layout.activity_popup, null);
        Button mAgree = mView.findViewById(R.id.btAgree);

        mBuilder.setTitle("Attention Users!");
        mBuilder.setMessage("Please download our new app for continued watching of channels.");
        mBuilder.setView(mView);

        final AlertDialog mDialog = mBuilder.create();
        mDialog.show();

        mAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse(backUpLink));
                startActivity(viewIntent);
            }
        });
    }



}



