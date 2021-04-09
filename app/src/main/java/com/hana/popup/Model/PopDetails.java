package com.hana.popup.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PopDetails {

    @SerializedName("fileName")
    @Expose
    private String fileName;
    @SerializedName("fileVersion")
    @Expose
    private String fileVersion;
    @SerializedName("adFrequency")
    @Expose
    private String adFrequency;
    @SerializedName("showEmergencyPopUp")
    @Expose
    private String showEmergencyPopUp;
    @SerializedName("backUpAppLink")
    @Expose
    private String backUpAppLink;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileVersion() {
        return fileVersion;
    }

    public void setFileVersion(String fileVersion) {
        this.fileVersion = fileVersion;
    }

    public String getAdFrequency() {
        return adFrequency;
    }

    public void setAdFrequency(String adFrequency) {
        this.adFrequency = adFrequency;
    }

    public String getShowEmergencyPopUp() {
        return showEmergencyPopUp;
    }

    public void setShowEmergencyPopUp(String showEmergencyPopUp) {
        this.showEmergencyPopUp = showEmergencyPopUp;
    }

    public String getBackUpAppLink() {
        return backUpAppLink;
    }

    public void setBackUpAppLink(String backUpAppLink) {
        this.backUpAppLink = backUpAppLink;
    }

}