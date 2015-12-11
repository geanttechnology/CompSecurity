// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;

public class Properties
    implements gu, Serializable
{

    private static final long serialVersionUID = 0x35ecfcd0e4532a8dL;
    private String contractCondition;
    private String format;
    private String freeShippingCode;

    public Properties()
    {
    }

    public String getContractCondition()
    {
        return contractCondition;
    }

    public String getFormat()
    {
        return format;
    }

    public String getFreeShippingCode()
    {
        return freeShippingCode;
    }

    public void setContractCondition(String s)
    {
        contractCondition = s;
    }

    public void setFormat(String s)
    {
        format = s;
    }

    public void setFreeShippingCode(String s)
    {
        freeShippingCode = s;
    }
}
