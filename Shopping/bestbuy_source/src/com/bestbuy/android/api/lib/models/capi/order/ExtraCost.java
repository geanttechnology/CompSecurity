// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.order;


public class ExtraCost
{

    private double amount;
    private String description;
    private String type;

    public ExtraCost()
    {
    }

    public double getAmount()
    {
        return amount;
    }

    public String getDescription()
    {
        return description;
    }

    public String getType()
    {
        return type;
    }

    public ExtraCost loadData(String s, String s1, double d)
    {
        ExtraCost extracost = new ExtraCost();
        extracost.type = s;
        extracost.description = s1;
        extracost.amount = d;
        return extracost;
    }
}
