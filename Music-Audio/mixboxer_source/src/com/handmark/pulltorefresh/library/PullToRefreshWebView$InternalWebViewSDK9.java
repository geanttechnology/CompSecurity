// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.webkit.WebView;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            PullToRefreshWebView, OverscrollHelper

final class this._cls0 extends WebView
{

    static final int OVERSCROLL_FUZZY_THRESHOLD = 2;
    static final float OVERSCROLL_SCALE_FACTOR = 1.5F;
    final PullToRefreshWebView this$0;

    private int getScrollRange()
    {
        float f = ((WebView)mRefreshableView).getContentHeight();
        return (int)Math.max(0.0F, FloatMath.floor(((WebView)mRefreshableView).getScale() * f) - (float)(getHeight() - getPaddingBottom() - getPaddingTop()));
    }

    protected final boolean overScrollBy(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, boolean flag)
    {
        boolean flag1 = super.overScrollBy(i, j, k, l, i1, j1, k1, l1, flag);
        OverscrollHelper.overScrollBy(PullToRefreshWebView.this, i, k, j, l, getScrollRange(), 2, 1.5F, flag);
        return flag1;
    }

    public Q(Context context, AttributeSet attributeset)
    {
        this$0 = PullToRefreshWebView.this;
        super(context, attributeset);
    }
}
