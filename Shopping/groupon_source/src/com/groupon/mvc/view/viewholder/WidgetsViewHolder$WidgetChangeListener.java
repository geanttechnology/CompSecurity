// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import com.groupon.adapter.WidgetOnDealDetailsPagerAdapter;
import com.groupon.adapter.widget.WidgetPart;
import java.util.List;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            WidgetsViewHolder

private class <init> extends android.support.v4.view.istener
{

    final WidgetsViewHolder this$0;

    public void onPageSelected(int i)
    {
        Object obj = (WidgetPart)WidgetsViewHolder.access$200(WidgetsViewHolder.this).getItem(i);
        int l = i - 1;
        com.groupon.db.models.DealSummary dealsummary = ((WidgetPart) (obj)).getDealSummary();
        int j = i;
        obj = dealsummary;
        int k = j;
        if (l == 0)
        {
            obj = dealsummary;
            k = j;
            if (!WidgetsViewHolder.access$100(WidgetsViewHolder.this).contains(Integer.valueOf(l)))
            {
                obj = ((WidgetPart)WidgetsViewHolder.access$200(WidgetsViewHolder.this).getItem(l)).getDealSummary();
                k = l;
                WidgetsViewHolder.access$100(WidgetsViewHolder.this).add(Integer.valueOf(l));
            }
        }
        if (!WidgetsViewHolder.access$100(WidgetsViewHolder.this).contains(Integer.valueOf(i)))
        {
            WidgetsViewHolder.access$100(WidgetsViewHolder.this).add(Integer.valueOf(i));
        }
        onWidgetPageSelected(((com.groupon.db.models.DealSummary) (obj)), k);
    }

    private ()
    {
        this$0 = WidgetsViewHolder.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
