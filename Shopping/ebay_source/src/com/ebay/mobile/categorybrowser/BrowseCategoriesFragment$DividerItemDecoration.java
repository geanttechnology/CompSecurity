// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.categorybrowser;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.ebay.mobile.common.view.ViewHolder;

// Referenced classes of package com.ebay.mobile.categorybrowser:
//            BrowseCategoriesFragment

public static class separatorLeftPadding extends android.support.v7.widget.ation
{

    private static final int DIVIDER_HEIGHT = 2;
    private final int childSeparatorColor;
    private final int navigationSeparatorColor;
    private final int separatorLeftPadding;

    public void onDrawOver(Canvas canvas, RecyclerView recyclerview, android.support.v7.widget.ation ation)
    {
        if (recyclerview.getLayoutManager() instanceof LinearLayoutManager)
        {
            break MISSING_BLOCK_LABEL_10;
        } else
        {
            throw new IllegalStateException("DividerItemDecoration can only be used with a LinearLayoutManager.");
        }
_L2:
        int i;
        int j;
        int k;
        int l;
        while (i > l) 
        {
            do
            {
                return;
            } while (((LinearLayoutManager)recyclerview.getLayoutManager()).getOrientation() != 1 || recyclerview.getItemAnimator().ation());
            j = recyclerview.getPaddingLeft();
            k = recyclerview.getWidth() - recyclerview.getPaddingRight();
            ation = (LinearLayoutManager)recyclerview.getLayoutManager();
            i = ation.findFirstVisibleItemPosition();
            l = ation.findLastVisibleItemPosition();
            i = Math.max(i, 1);
        }
        ation = recyclerview.findViewHolderForLayoutPosition(i);
        if (ation instanceof ViewHolder)
        {
            break; /* Loop/switch isn't completed */
        }
_L4:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        Object obj;
        int i1;
        int j1;
        obj = ((android.support.v7.widget.) (ation)).;
        android.support.v7.widget.ation ation1 = (android.support.v7.widget.)((View) (obj)).getLayoutParams();
        ation = new Paint();
        i1 = ((View) (obj)).getTop() - ation1. - 2;
        j1 = ((View) (obj)).getTop();
        obj = recyclerview.findViewHolderForLayoutPosition(i - 1);
        if (obj == null) goto _L4; else goto _L3
_L3:
        switch (((android.support.v7.widget.) (obj)).())
        {
        default:
            ation.setColor(childSeparatorColor);
            canvas.drawRect(j, i1, k, j1, ation);
            break;

        case 3: // '\003'
        case 4: // '\004'
            ation.setColor(navigationSeparatorColor);
            canvas.drawRect(j, i1, separatorLeftPadding - 1, j1, ation);
            ation.setColor(childSeparatorColor);
            canvas.drawRect(separatorLeftPadding + j, i1, k, j1, ation);
            break;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public (Context context)
    {
        context = context.getResources();
        childSeparatorColor = context.getColor(0x7f0d00d2);
        navigationSeparatorColor = context.getColor(0x106000b);
        separatorLeftPadding = context.getDimensionPixelSize(0x7f09010b);
    }
}
