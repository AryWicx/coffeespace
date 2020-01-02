package com.hello.coworkspace.Model;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class GetSpace {
    @SerializedName("status")
    String status;
    @SerializedName("values")
    List<Space> listSpace;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Space> getListSpace() {
        return listSpace;
    }

    public void setListSpace(List<Space> listSpace) {
        this.listSpace = listSpace;
    }
}
