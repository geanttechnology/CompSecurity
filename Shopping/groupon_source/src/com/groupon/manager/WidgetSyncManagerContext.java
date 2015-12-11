// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import com.groupon.db.models.WidgetSummary;

public class WidgetSyncManagerContext
{

    private WidgetSummary currentlyParsedWidgetSummary;
    private int dealCount;
    private int widgetCount;

    public WidgetSyncManagerContext()
    {
    }

    public WidgetSummary getCurrentlyParsedWidgetSummary()
    {
        return currentlyParsedWidgetSummary;
    }

    public int getDealCount()
    {
        return dealCount;
    }

    public int getWidgetCount()
    {
        return widgetCount;
    }

    public void incDealCount()
    {
        dealCount = dealCount + 1;
    }

    public void incWidgetCount()
    {
        widgetCount = widgetCount + 1;
    }

    public void setCurrentlyParsedWidgetSummary(WidgetSummary widgetsummary)
    {
        currentlyParsedWidgetSummary = widgetsummary;
    }

    public void setDealCount(int i)
    {
        dealCount = i;
    }

    public void setWidgetCount(int i)
    {
        widgetCount = i;
    }
}
