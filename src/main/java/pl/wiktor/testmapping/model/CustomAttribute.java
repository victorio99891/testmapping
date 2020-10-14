package pl.wiktor.testmapping.model;


import com.google.gson.annotations.SerializedName;

public class CustomAttribute {


    @SerializedName(value = "key")
    public String key;

    @SerializedName(value = "value")
    public String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
