// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.mybby;

import org.json.JSONObject;

public class 
{

    private String amount;
    private String description;
    private boolean eligible;
    private String lineNumber;
    private String prodCategory;
    private String prodThumbImgURL;
    private String productModelId;
    private String productSku;
    private String quantity;

    private static  loadData(JSONObject jsonobject)
    {
          = new <init>();
        .productSku = jsonobject.optString("productSku");
        .amount = jsonobject.optString("amount");
        if (.amount != null && !.amount.equalsIgnoreCase("0"))
        {
            .lineNumber = jsonobject.optString("lineNumber");
            .description = jsonobject.optString("description");
            .quantity = jsonobject.optString("quantity");
            .prodCategory = "";
            .prodThumbImgURL = "";
            .eligible = jsonobject.optBoolean("eligible");
            return ;
        } else
        {
            return null;
        }
    }

    public String getAmount()
    {
        return amount;
    }

    public String getDescription()
    {
        return description;
    }

    public String getLineNumber()
    {
        return lineNumber;
    }

    public String getProdCategory()
    {
        return prodCategory;
    }

    public String getProdThumbImgURL()
    {
        return prodThumbImgURL;
    }

    public String getProductModelId()
    {
        return productModelId;
    }

    public String getProductSku()
    {
        return productSku;
    }

    public String getQuantity()
    {
        return quantity;
    }

    public boolean isEligible()
    {
        return eligible;
    }


    public ()
    {
    }
}
