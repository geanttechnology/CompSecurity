// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.summariesNpriceBlock;

import gu;
import java.io.Serializable;

public class Brand
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String brand;
    private String label;
    private String publisher;
    private String studio;
    private String vendor;

    public Brand()
    {
    }

    public String getBrand()
    {
        return brand;
    }

    public String getLabel()
    {
        return label;
    }

    public String getPublisher()
    {
        return publisher;
    }

    public String getStudio()
    {
        return studio;
    }

    public String getVendor()
    {
        return vendor;
    }

    public void setBrand(String s)
    {
        brand = s;
    }

    public void setLabel(String s)
    {
        label = s;
    }

    public void setPublisher(String s)
    {
        publisher = s;
    }

    public void setStudio(String s)
    {
        studio = s;
    }

    public void setVendor(String s)
    {
        vendor = s;
    }
}
