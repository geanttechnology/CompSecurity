// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto.response;

import com.offerup.android.dto.Item;
import java.util.ArrayList;

public class RateTransactionData
{

    private Item item;
    private ArrayList users;

    public RateTransactionData()
    {
    }

    public Item getItem()
    {
        return item;
    }

    public ArrayList getListOfInterestedBuyers()
    {
        return users;
    }
}
