// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.deals;

import java.util.ArrayList;
import java.util.Map;

public class StoreDeals
{

    private ArrayList categories;
    private Map deals;

    public StoreDeals()
    {
    }

    public ArrayList getCategories()
    {
        return categories;
    }

    public Map getDeals()
    {
        return deals;
    }

    public void setCategories(ArrayList arraylist)
    {
        categories = arraylist;
    }

    public void setDeals(Map map)
    {
        deals = map;
    }
}
