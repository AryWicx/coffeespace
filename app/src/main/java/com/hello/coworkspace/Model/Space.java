package com.hello.coworkspace.Model;

import com.google.gson.annotations.SerializedName;
public class Space {
    @SerializedName("id")
    private String id;
    @SerializedName("space_name")
    private String space_name;
    @SerializedName("space_address")
    private String space_address;
    @SerializedName("space_description")
    private String space_description;
    @SerializedName("space_hours")
    private String space_hours;
    @SerializedName("space_photo")
    private String space_photo;



    public Space() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpace_name() {
        return space_name;
    }

    public void setSpace_name(String space_name) {
        this.space_name = space_name;
    }

    public String getSpace_address() {
        return space_address;
    }

    public void setSpace_address(String space_address) {
        this.space_address = space_address;
    }

    public String getSpace_description() {
        return space_description;
    }

    public void setSpace_description(String space_description) {
        this.space_description = space_description;
    }

    public String getSpace_hours() {
        return space_hours;
    }

    public void setSpace_hours(String space_hours) {
        this.space_hours = space_hours;
    }

    public String getSpace_photo() {
        return space_photo;
    }

    public void setSpace_photo(String space_photo) {
        this.space_photo = space_photo;
    }

    public Space (String id, String space_name, String space_address, String space_description, String space_hours, String space_photo){
       this.id = id;
       this.space_name = space_name;
       this.space_address = space_address;
       this.space_description = space_description;
       this.space_hours = space_hours;
       this.space_photo = space_photo;

    }



}
