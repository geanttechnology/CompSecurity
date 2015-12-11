// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models.product;


public class ApiSendProduct
{

    private String address;
    private String category;
    private String city;
    private String countryCode;
    private String currency;
    private String description;
    private String images;
    private String languageCode;
    private String latitude;
    private String longitude;
    private String name;
    private String price;
    private String userId;
    private String zipCode;

    public ApiSendProduct(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10, String s11, String s12, String s13)
    {
        name = s;
        category = s1;
        languageCode = s2;
        userId = s3;
        description = s4;
        price = s5;
        currency = s6;
        latitude = s7;
        longitude = s8;
        countryCode = s9;
        city = s10;
        address = s11;
        zipCode = s12;
        images = s13;
    }

    public String getAddress()
    {
        return address;
    }

    public String getCategory()
    {
        return category;
    }

    public String getCity()
    {
        return city;
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    public String getCurrency()
    {
        return currency;
    }

    public String getDescription()
    {
        return description;
    }

    public String getImages()
    {
        return images;
    }

    public String getLanguageCode()
    {
        return languageCode;
    }

    public String getLatitude()
    {
        return latitude;
    }

    public String getLongitude()
    {
        return longitude;
    }

    public String getName()
    {
        return name;
    }

    public String getPrice()
    {
        return price;
    }

    public String getUserId()
    {
        return userId;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public void setAddress(String s)
    {
        address = s;
    }

    public void setCategory(String s)
    {
        category = s;
    }

    public void setCity(String s)
    {
        city = s;
    }

    public void setCountryCode(String s)
    {
        countryCode = s;
    }

    public void setCurrency(String s)
    {
        currency = s;
    }

    public void setDescription(String s)
    {
        description = s;
    }

    public void setImages(String s)
    {
        images = s;
    }

    public void setLanguageCode(String s)
    {
        languageCode = s;
    }

    public void setLatitude(String s)
    {
        latitude = s;
    }

    public void setLongitude(String s)
    {
        longitude = s;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setPrice(String s)
    {
        price = s;
    }

    public void setUserId(String s)
    {
        userId = s;
    }

    public void setZipCode(String s)
    {
        zipCode = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ApiSendProduct{name='").append(name).append('\'').append(", category='").append(category).append('\'').append(", languageCode='").append(languageCode).append('\'').append(", userId='").append(userId).append('\'').append(", description='").append(description).append('\'').append(", price='").append(price).append('\'').append(", currency='").append(currency).append('\'').append(", latitude='").append(latitude).append('\'').append(", longitude='").append(longitude).append('\'').append(", countryCode='").append(countryCode).append('\'').append(", city='").append(city).append('\'').append(", address='").append(address).append('\'').append(", zipCode='").append(zipCode).append('\'').append(", images='").append(images).append('\'').append('}').toString();
    }
}
