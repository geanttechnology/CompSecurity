// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.trend;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.List;

// Referenced classes of package com.ebay.mobile.trend:
//            TrendTopicAdapter

private class <init> extends android.support.v7.widget.t>
{

    final TrendTopicAdapter this$0;

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerview, android.support.v7.widget.t> t>)
    {
        int j = recyclerview.getChildAdapterPosition(view);
        view = TrendTopicAdapter.access$100(TrendTopicAdapter.this);
        int i;
        if (TrendTopicAdapter.isTablet)
        {
            i = 0x7f09007a;
        } else
        {
            i = 0x7f090149;
        }
        i = view.getDimensionPixelSize(i);
        if (j == TrendTopicAdapter.access$200(TrendTopicAdapter.this).size() - 1)
        {
            rect.bottom = i;
        }
        if (j == 0)
        {
            rect.top = i;
        }
    }

    private ()
    {
        this$0 = TrendTopicAdapter.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
