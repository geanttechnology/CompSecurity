// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;

public class ManufacturerId
    implements gu, Serializable
{

    private static final long serialVersionUID = 0x83630ffebc6c43b6L;
    private String modelNumber;

    public ManufacturerId()
    {
    }

    public String getModelNumber()
    {
        return modelNumber;
    }

    public void setModelNumber(String s)
    {
        modelNumber = s;
    }
}
