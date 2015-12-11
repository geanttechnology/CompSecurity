// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.summariesNpriceBlock;

import gu;
import java.io.Serializable;

public class Manufacturer
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String modelNumber;

    public Manufacturer()
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
