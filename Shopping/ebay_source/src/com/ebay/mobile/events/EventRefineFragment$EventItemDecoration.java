// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.events;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.List;

// Referenced classes of package com.ebay.mobile.events:
//            EventRefineFragment

protected class ation extends com.ebay.mobile.common.ation
{

    final EventRefineFragment this$0;

    public void onDrawOver(Canvas canvas, RecyclerView recyclerview, android.support.v7.widget.on on)
    {
        int j = recyclerview.getWidth();
        int k = recyclerview.getChildCount();
        int i = 0;
        while (i < k) 
        {
            if (!((com.ebay.mobile.common.ation)EventRefineFragment.access$2900(EventRefineFragment.this).refinements.get(i) instanceof er.refinements))
            {
                on = recyclerview.getChildAt(i);
                android.support.v7.widget.on on1 = (android.support.v7.widget.refinements)on.getLayoutParams();
                int l = on.getBottom() + on1.refinements;
                int i1 = divider.getIntrinsicHeight();
                divider.setBounds(0, l, j, l + i1);
                divider.draw(canvas);
            }
            i++;
        }
    }

    public er(Context context)
    {
        this$0 = EventRefineFragment.this;
        super(context);
    }
}
