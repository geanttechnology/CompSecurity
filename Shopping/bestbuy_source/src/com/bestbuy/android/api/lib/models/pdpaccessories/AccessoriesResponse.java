// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpaccessories;

import gu;
import java.io.Serializable;
import java.util.ArrayList;

public class AccessoriesResponse
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private ArrayList includedItems;
    private String productType;
    private ArrayList requiredAccessories;
    private ArrayList suggestedAccessories;

    public AccessoriesResponse()
    {
    }

    public ArrayList getIncludedItems()
    {
        return includedItems;
    }

    public String getProductType()
    {
        return productType;
    }

    public ArrayList getRequiredAccessories()
    {
        return requiredAccessories;
    }

    public ArrayList getSuggestedAccessories()
    {
        return suggestedAccessories;
    }

    public void setIncludedItems(ArrayList arraylist)
    {
        includedItems = arraylist;
    }

    public void setProductType(String s)
    {
        productType = s;
    }

    public void setRequiredAccessories(ArrayList arraylist)
    {
        requiredAccessories = arraylist;
    }

    public void setSuggestedAccessories(ArrayList arraylist)
    {
        suggestedAccessories = arraylist;
    }
}
