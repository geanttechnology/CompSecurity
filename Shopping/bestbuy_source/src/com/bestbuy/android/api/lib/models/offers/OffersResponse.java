// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.offers;

import java.util.ArrayList;

public class OffersResponse
{

    private String cursor;
    private ArrayList offers;

    public OffersResponse()
    {
        offers = null;
    }

    public String getCursor()
    {
        return cursor;
    }

    public ArrayList getOffers()
    {
        return offers;
    }

    public void setCursor(String s)
    {
        cursor = s;
    }

    public void setOffers(ArrayList arraylist)
    {
        offers = arraylist;
    }
}
