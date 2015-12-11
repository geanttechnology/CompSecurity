// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            OverscrollHelper, PullToRefreshScrollView

final class this._cls0 extends ScrollView
{

    final PullToRefreshScrollView this$0;

    private int getScrollRange()
    {
        int i = 0;
        if (getChildCount() > 0)
        {
            i = Math.max(0, getChildAt(0).getHeight() - (getHeight() - getPaddingBottom() - getPaddingTop()));
        }
        return i;
    }

    protected final boolean overScrollBy(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, boolean flag)
    {
        boolean flag1 = super.overScrollBy(i, j, k, l, i1, j1, k1, l1, flag);
        OverscrollHelper.overScrollBy(PullToRefreshScrollView.this, i, k, j, l, getScrollRange(), flag);
        return flag1;
    }

    public (Context context, AttributeSet attributeset)
    {
        this$0 = PullToRefreshScrollView.this;
        super(context, attributeset);
    }
}
