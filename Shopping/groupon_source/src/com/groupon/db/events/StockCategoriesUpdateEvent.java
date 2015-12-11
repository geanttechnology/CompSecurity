// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.events;

import commonlib.loader.event.UpdateEvent;

public class StockCategoriesUpdateEvent extends UpdateEvent
{

    private String dealId;
    private String optionId;

    public StockCategoriesUpdateEvent(String s, String s1)
    {
        dealId = s;
        optionId = s1;
    }

    public String getDealId()
    {
        return dealId;
    }

    public String getOptionId()
    {
        return optionId;
    }

    public void setDealId(String s)
    {
        dealId = s;
    }

    public void setOptionId(String s)
    {
        optionId = s;
    }
}
