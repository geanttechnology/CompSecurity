// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;


public class MarketRatePrice
{

    public String currencyCode;
    public int net;
    public int tax;

    public MarketRatePrice()
    {
        net = 0;
        currencyCode = "";
        tax = 0;
    }
}
