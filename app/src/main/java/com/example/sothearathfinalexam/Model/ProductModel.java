package com.example.sothearathfinalexam.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class ProductModel {

    @Expose
    @SerializedName("categoryName")
    private String categoryname;
    @Expose
    @SerializedName("categoryId")
    private String categoryid;
    @Expose
    @SerializedName("totalView")
    private String totalview;
    @Expose
    @SerializedName("averageRate")
    private String averagerate;
    @Expose
    @SerializedName("totalRate")
    private String totalrate;
    @Expose
    @SerializedName("imageUrl")
    private String imageurl;
    @Expose
    @SerializedName("price")
    private String price;
    @Expose
    @SerializedName("description")
    private String description;
    @Expose
    @SerializedName("code")
    private String code;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("id")
    private String id;

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getTotalview() {
        return totalview;
    }

    public void setTotalview(String totalview) {
        this.totalview = totalview;
    }

    public String getAveragerate() {
        return averagerate;
    }

    public void setAveragerate(String averagerate) {
        this.averagerate = averagerate;
    }

    public String getTotalrate() {
        return totalrate;
    }

    public void setTotalrate(String totalrate) {
        this.totalrate = totalrate;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
