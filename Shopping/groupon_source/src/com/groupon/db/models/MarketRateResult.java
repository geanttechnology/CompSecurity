// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.groupon.db.models:
//            Address, MarketRatePrice, Price, Image

public class MarketRateResult
{

    protected Address address;
    public String announcementTitle;
    protected MarketRatePrice avgMinPrice;
    public double bucksPercentage;
    public String channel;
    public String derivedAddressCity;
    public String derivedAddressCountry;
    public double derivedAddressLat;
    public double derivedAddressLng;
    public String derivedAddressState;
    public String derivedAvgMinPriceCurrencyCode;
    public int derivedAvgMinPriceNet;
    public int derivedAvgMinPriceTax;
    public int derivedDisplayValueAmount;
    public String derivedDisplayValueCurrencyCode;
    public String derivedDisplayValueFormattedAmount;
    public String derivedImageUrl;
    public double discountPercentage;
    protected Price displayValue;
    public boolean hasRaO;
    public double hotelRating;
    protected List images;
    public Date modificationDate;
    public Long primaryKey;
    public String productType;
    public String remoteId;
    public String source;
    public String title;
    public String uuid;

    public MarketRateResult()
    {
        title = "";
        source = "";
        productType = "";
        announcementTitle = "";
        discountPercentage = 0.0D;
        hotelRating = 0.0D;
        bucksPercentage = 0.0D;
        hasRaO = false;
        derivedDisplayValueAmount = 0;
        derivedDisplayValueCurrencyCode = "";
        derivedDisplayValueFormattedAmount = "";
        derivedAvgMinPriceNet = 0;
        derivedAvgMinPriceCurrencyCode = "";
        derivedAvgMinPriceTax = 0;
        derivedAddressCity = "";
        derivedAddressState = "";
        derivedAddressCountry = "";
        derivedAddressLat = 0.0D;
        derivedAddressLng = 0.0D;
        derivedImageUrl = "";
        address = new Address();
        avgMinPrice = new MarketRatePrice();
        displayValue = new Price();
        images = new ArrayList();
    }

    public void afterJsonDeserializationPostProcessor()
    {
        if (address != null)
        {
            derivedAddressCity = address.city;
            derivedAddressState = address.state;
            derivedAddressCountry = address.country;
            derivedAddressLat = address.lat;
            derivedAddressLng = address.lng;
        }
        if (displayValue != null)
        {
            derivedDisplayValueAmount = displayValue.amount;
            derivedDisplayValueCurrencyCode = displayValue.currencyCode;
            derivedDisplayValueFormattedAmount = displayValue.formattedAmount;
        }
        if (avgMinPrice != null)
        {
            derivedAvgMinPriceCurrencyCode = avgMinPrice.currencyCode;
            derivedAvgMinPriceNet = avgMinPrice.net;
            derivedAvgMinPriceTax = avgMinPrice.tax;
        }
        if (images != null && !images.isEmpty())
        {
            derivedImageUrl = (new StringBuilder()).append(((Image)images.get(0)).url).append("t954x610.jpg").toString();
        }
    }
}
