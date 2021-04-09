package com.hana.popup.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResponseModel {

    @SerializedName("versionChecker")
    public List<PopDetails> resultItems = new ArrayList<>();

    public List<PopDetails> getResultItems() {
        return resultItems;
    }
}
