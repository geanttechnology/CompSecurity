// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.callbacks;

import android.view.View;
import com.groupon.adapter.widget.FilterableWidgetListAdapter;
import com.groupon.db.models.DealSummary;

public interface OnDealDetailsWidgetsEventListener
{

    public abstract void onCabWidgetClick(View view, DealSummary dealsummary);

    public abstract void onCabWidgetPageSelected(DealSummary dealsummary, int i);

    public abstract void onCabWidgetsInitialized(FilterableWidgetListAdapter filterablewidgetlistadapter);

    public abstract void onCavWidgetClick(View view, DealSummary dealsummary);

    public abstract void onCavWidgetPageSelected(DealSummary dealsummary, int i);

    public abstract void onCavWidgetsInitialized(FilterableWidgetListAdapter filterablewidgetlistadapter);
}
