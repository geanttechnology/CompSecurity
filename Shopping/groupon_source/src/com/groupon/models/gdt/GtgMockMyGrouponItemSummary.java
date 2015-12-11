// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.gdt;

import com.groupon.db.models.mygroupons.MyGrouponItemSummary;

public class GtgMockMyGrouponItemSummary extends MyGrouponItemSummary
{

    public static final String GTG_MOCK_My_GROUPON_ITEM_SUMMARY_REMOTE_ID = "gtg_mock_my_groupon_item_summary_remote_id";
    private int numberOfOrders;

    public GtgMockMyGrouponItemSummary(int i)
    {
        remoteId = "gtg_mock_my_groupon_item_summary_remote_id";
        numberOfOrders = i;
    }

    public int getNumberOfOrders()
    {
        return numberOfOrders;
    }

    public void setNumberOfOrders(int i)
    {
        numberOfOrders = i;
    }

    public void setSubtitle(String s)
    {
        subTitle = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }
}
