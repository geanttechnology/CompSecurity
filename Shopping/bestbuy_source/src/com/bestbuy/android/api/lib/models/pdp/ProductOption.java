// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp;

import gu;
import java.io.Serializable;
import java.util.ArrayList;

public class ProductOption
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private ArrayList alternateProducts;
    private ArrayList contractOptions;
    private ArrayList multipleSellers;

    public ProductOption()
    {
    }

    public ArrayList getAlternateProducts()
    {
        return alternateProducts;
    }

    public ArrayList getContractOptions()
    {
        return contractOptions;
    }

    public ArrayList getMultipleSellers()
    {
        return multipleSellers;
    }

    public void setAlternateProducts(ArrayList arraylist)
    {
        alternateProducts = arraylist;
    }

    public void setContractOptions(ArrayList arraylist)
    {
        contractOptions = arraylist;
    }

    public void setMultipleSellers(ArrayList arraylist)
    {
        multipleSellers = arraylist;
    }
}
