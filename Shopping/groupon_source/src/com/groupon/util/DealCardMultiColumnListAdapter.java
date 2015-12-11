// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.os.SystemClock;
import android.view.View;
import android.widget.ListAdapter;
import com.groupon.adapter.widget.WidgetPart;
import com.groupon.db.models.DealSummary;

// Referenced classes of package com.groupon.util:
//            MultiColumnListAdapter

public class DealCardMultiColumnListAdapter extends MultiColumnListAdapter
{

    private static final int CLICK_THRESHOLD_MILLIS = 1500;
    private long lastClickMillis;

    public DealCardMultiColumnListAdapter(ListAdapter listadapter, int i)
    {
        super(listadapter, i);
    }

    private void triggerOnClick(int i, View view)
    {
        Object obj = getWrappedAdapter().getItem(i);
        if (obj instanceof DealSummary)
        {
            onDealCardClicked(i, view, (DealSummary)obj);
        } else
        if (obj instanceof WidgetPart)
        {
            obj = (WidgetPart)obj;
            if (((WidgetPart) (obj)).getType() == 1)
            {
                onWidgetDealCardClicked(view, ((WidgetPart) (obj)).getDealSummary());
                return;
            }
            if (((WidgetPart) (obj)).getType() == 6)
            {
                obj = ((WidgetPart) (obj)).getDealSummary();
                onDealCardClicked(((DealSummary) (obj)).getIntAttr("ns:DealOffset").intValue(), view, ((DealSummary) (obj)));
                return;
            }
        }
    }

    protected void onClick(int i, View view)
    {
        long l = SystemClock.elapsedRealtime();
        if (l - lastClickMillis > 1500L)
        {
            triggerOnClick(i, view);
        }
        lastClickMillis = l;
    }

    public void onDealCardClicked(int i, View view, DealSummary dealsummary)
    {
    }

    public void onWidgetDealCardClicked(View view, DealSummary dealsummary)
    {
    }
}
