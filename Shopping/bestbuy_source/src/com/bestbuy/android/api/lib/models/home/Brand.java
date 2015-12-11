// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;

public class Brand
    implements gu, Serializable
{

    private static final long serialVersionUID = 0xac813a53b95540feL;
    private String brand;

    public Brand()
    {
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String s)
    {
        brand = s;
    }
}
