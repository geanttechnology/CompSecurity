// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;
import java.util.List;

public class GroupedDeal
    implements gu, Serializable
{

    private static final long serialVersionUID = 0x7cf94052b17acd2eL;
    private List offers;
    private String offersWide;
    private String widgetType;

    public GroupedDeal()
    {
    }

    public List getOffers()
    {
        return offers;
    }

    public String getOffersWide()
    {
        return offersWide;
    }

    public String getWidgetType()
    {
        return widgetType;
    }

    public void setOffers(List list)
    {
        offers = list;
    }

    public void setOffersWide(String s)
    {
        offersWide = s;
    }

    public void setWidgetType(String s)
    {
        widgetType = s;
    }
}
