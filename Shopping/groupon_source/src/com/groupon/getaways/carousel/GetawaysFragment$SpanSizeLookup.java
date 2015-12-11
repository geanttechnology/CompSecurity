// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.carousel;

import android.support.v7.widget.GridLayoutManager;

// Referenced classes of package com.groupon.getaways.carousel:
//            GetawaysFragment, EndlessRecyclerViewAdapter, GetawaysRecyclerViewAdapter

private class <init> extends android.support.v7.widget.
{

    private final GridLayoutManager layoutManager;
    final GetawaysFragment this$0;

    public int getSpanSize(int i)
    {
        if (GetawaysFragment.access$1700(GetawaysFragment.this).isProgressView(i) || GetawaysFragment.access$2200(GetawaysFragment.this).isWidget(i))
        {
            return layoutManager.getSpanCount();
        } else
        {
            return 1;
        }
    }

    private (GridLayoutManager gridlayoutmanager)
    {
        this$0 = GetawaysFragment.this;
        super();
        layoutManager = gridlayoutmanager;
    }

    layoutManager(GridLayoutManager gridlayoutmanager, layoutManager layoutmanager)
    {
        this(gridlayoutmanager);
    }
}
