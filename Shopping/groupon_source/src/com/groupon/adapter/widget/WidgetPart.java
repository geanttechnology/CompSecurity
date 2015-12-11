// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter.widget;

import com.groupon.db.models.DealSummary;
import com.groupon.db.models.WidgetSummary;

public class WidgetPart
{

    public static final int DEAL_SUMMARY = 1;
    public static final int SMALL_DEAL_CARD_LIST = 3;
    public static final int SMUGGLED_DEAL = 6;
    public static final int TRACKING_HEADER = 5;
    public static final int WIDGET_IMAGE_SUMMARY = 2;
    public static final int WIDGET_SUMMARY = 0;
    private DealSummary dealSummary;
    private boolean firstPosition;
    private boolean lastPosition;
    private int type;
    private WidgetSummary widgetSummary;

    public WidgetPart(DealSummary dealsummary)
    {
        lastPosition = false;
        firstPosition = false;
        dealSummary = dealsummary;
        type = 1;
    }

    public WidgetPart(DealSummary dealsummary, int i, boolean flag)
    {
        lastPosition = false;
        firstPosition = false;
        dealSummary = dealsummary;
        type = i;
        lastPosition = flag;
    }

    public WidgetPart(DealSummary dealsummary, int i, boolean flag, boolean flag1)
    {
        lastPosition = false;
        firstPosition = false;
        dealSummary = dealsummary;
        type = i;
        lastPosition = flag;
        firstPosition = flag1;
    }

    public WidgetPart(WidgetSummary widgetsummary)
    {
        lastPosition = false;
        firstPosition = false;
        widgetSummary = widgetsummary;
        type = 0;
    }

    public WidgetPart(WidgetSummary widgetsummary, int i)
    {
        lastPosition = false;
        firstPosition = false;
        widgetSummary = widgetsummary;
        type = i;
    }

    public DealSummary getDealSummary()
    {
        return dealSummary;
    }

    public int getType()
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
