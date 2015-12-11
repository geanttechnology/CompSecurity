// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.util.Date;

public class SnapGroceryDetail
{

    public String almostSoldOut;
    public String bonusOffer;
    public String cashBack;
    public String cashBackInteger;
    public String cashBackPrefix;
    public String cashBackSuffix;
    public String channel;
    public int column;
    public Date dateSoldOut;
    public String imgPath;
    public String instructions;
    public boolean isPlaceHolder;
    public Date modificationDate;
    public String offerDetails;
    public String offerTerms;
    public Long primaryKey;
    public String productDetails;
    public String productName;
    public String quantityAllowed;
    public String remoteId;
    public int row;
    public String type;

    public SnapGroceryDetail()
    {
        productName = "";
        offerDetails = "";
        offerTerms = "";
        cashBack = "";
        quantityAllowed = "";
        imgPath = "";
        bonusOffer = "";
        cashBackPrefix = "";
        cashBackSuffix = "";
        cashBackInteger = "";
        dateSoldOut = null;
        almostSoldOut = "";
        type = "";
        productDetails = "";
        instructions = "";
        row = 0;
        column = 0;
        isPlaceHolder = false;
    }

    public void afterJsonDeserializationPostProcessor()
    {
        if (cashBackPrefix == null)
        {
            cashBackPrefix = "";
        }
        if (cashBack == null)
        {
            cashBack = "";
        }
        if (cashBack == "")
        {
            cashBack = "0.00";
        }
        if (cashBackSuffix == null)
        {
            cashBackSuffix = "";
        }
        if (productName == null)
        {
            productName = "";
        }
    }
}
