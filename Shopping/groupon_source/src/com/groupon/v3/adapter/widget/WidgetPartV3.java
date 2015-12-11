// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.widget;

import com.groupon.db.models.DealSummary;
import com.groupon.db.models.WidgetSummary;
import com.groupon.v3.loader.DataTypes;

public class WidgetPartV3
{

    protected DealSummary dealSummary;
    protected boolean firstPosition;
    protected boolean lastPosition;
    protected DataTypes type;
    protected WidgetSummary widgetSummary;

    public WidgetPartV3(DealSummary dealsummary)
    {
        lastPosition = false;
        firstPosition = false;
        dealSummary = dealsummary;
        type = DataTypes.DEAL_SUMMARY;
    }

    public WidgetPartV3(DealSummary dealsummary, DataTypes datatypes, boolean flag)
    {
        lastPosition = false;
        firstPosition = false;
        dealSummary = dealsummary;
        type = datatypes;
        lastPosition = flag;
    }

    public WidgetPartV3(DealSummary dealsummary, DataTypes datatypes, boolean flag, boolean flag1)
    {
        lastPosition = false;
        firstPosition = false;
        dealSummary = dealsummary;
        type = datatypes;
        lastPosition = flag;
        firstPosition = flag1;
    }

    public WidgetPartV3(WidgetSummary widgetsummary)
    {
        lastPosition = false;
        firstPosition = false;
        widgetSummary = widgetsummary;
        type = DataTypes.WIDGET_SUMMARY;
    }

    public WidgetPartV3(WidgetSummary widgetsummary, DataTypes datatypes)
    {
        lastPosition = false;
        firstPosition = false;
        widgetSummary = widgetsummary;
        type = datatypes;
    }

    public DealSummary getDealSummary()
    {
        return dealSummary;
    }

    public DataTypes getType()
    {
        return type;
    }

    public WidgetSummary getWidgetSummary()
    {
        return widgetSummary;
    }

    public boolean isFirstPosition()
    {
        return firstPosition;
    }

    public boolean isLastPosition()
    {
        return lastPosition;
    }
}
