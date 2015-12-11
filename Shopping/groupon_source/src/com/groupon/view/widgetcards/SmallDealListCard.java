// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.widgetcards;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.groupon.db.models.DealSummary;
import com.groupon.util.GeoPoint;
import com.groupon.view.DealSetCallbacks;

// Referenced classes of package com.groupon.view.widgetcards:
//            DealWidgetCard

public class SmallDealListCard extends DealWidgetCard
{

    public SmallDealListCard(Context context)
    {
        super(context, 0x7f030204);
    }

    public void setInfo(DealSummary dealsummary, boolean flag, boolean flag1, DealSetCallbacks dealsetcallbacks, GeoPoint geopoint)
    {
        super.setInfo(dealsummary, dealsetcallbacks, geopoint);
        int j = getResources().getDimensionPixelSize(0x7f0b021f);
        dealsummary = findViewById(0x7f10052a);
        if (dealsummary != null)
        {
            int k = dealsummary.getPaddingLeft();
            int i;
            int l;
            if (flag1)
            {
                i = j;
            } else
            {
                i = dealsummary.getPaddingTop();
            }
            l = dealsummary.getPaddingRight();
            if (!flag)
            {
                j = dealsummary.getPaddingBottom();
            }
            dealsummary.setPadding(k, i, l, j);
        }
    }
}
