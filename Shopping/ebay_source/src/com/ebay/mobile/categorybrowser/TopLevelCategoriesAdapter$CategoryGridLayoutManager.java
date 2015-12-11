// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.categorybrowser;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;

// Referenced classes of package com.ebay.mobile.categorybrowser:
//            TopLevelCategoriesAdapter

protected static final class GridSmoothScroller.this._cls0 extends GridLayoutManager
{
    private class GridSmoothScroller extends LinearSmoothScroller
    {

        final TopLevelCategoriesAdapter.CategoryGridLayoutManager this$0;

        public PointF computeScrollVectorForPosition(int i)
        {
            return LinearLayoutManager.this.computeScrollVectorForPosition(i);
        }

        protected int getVerticalSnapPreference()
        {
            return -1;
        }

        public GridSmoothScroller(Context context)
        {
            this$0 = TopLevelCategoriesAdapter.CategoryGridLayoutManager.this;
            super(context);
        }
    }


    public void smoothScrollToPosition(RecyclerView recyclerview, android.support.v7.widget.nager nager, int i)
    {
        recyclerview = new GridSmoothScroller(recyclerview.getContext());
        recyclerview.setTargetPosition(i);
        startSmoothScroll(recyclerview);
    }


    protected GridSmoothScroller.this._cls0(Context context, int i)
    {
        super(context, i);
    }
}
