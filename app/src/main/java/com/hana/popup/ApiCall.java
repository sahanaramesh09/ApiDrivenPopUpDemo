package com.hana.popup;
import com.hana.popup.Model.ResponseModel;
import com.hana.popup.appconfig.BaseHelper;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCall {
    @GET(BaseHelper.POPUP_ENDPOINT)
    Call<ResponseModel> getPopDetails();
}
