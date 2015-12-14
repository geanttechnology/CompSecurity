// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import com.perfectcorp.model.Model;
import java.util.ArrayList;

public class Product extends Model
{

    public String brandName;
    public int commentCount;
    public String description;
    public String displayTitle;
    public String extPID;
    public String imgOriginal;
    public String imgThumbnail;
    public boolean isCommented;
    public long productId;
    public String productName;
    public String productStoreLink;
    public float rating;
    public String recommendedPrice;
    public String recommendedPriceCurrency;
    public String recommendedStore;
    public String trialOnYCMakeUp;
    public ArrayList typeName;

    public Product()
    {
    }

    public Long b_()
    {
        return Long.valueOf(productId);
    }
}
