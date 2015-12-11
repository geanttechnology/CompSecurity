// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;
import java.util.List;

public class DealsOfTheDay
    implements gu, Serializable
{

    private static final long serialVersionUID = 0x4491408a35d16e76L;
    private List dealsOfTheDay;

    public DealsOfTheDay()
    {
    }

    public List getDealsOfTheDay()
    {
        return dealsOfTheDay;
    }

    public void setDealsOfTheDay(List list)
    {
        dealsOfTheDay = list;
    }
}
