// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.android.widget;

import android.widget.Scroller;

// Referenced classes of package com.twitter.android.widget:
//            RefreshableListView

private class this._cls0
    implements Runnable
{

    private static final int AUTO_SCROLL_DURATION = 450;
    private int mLastY;
    final RefreshableListView this$0;

    public void run()
    {
        if (!isMode(10))
        {
            return;
        }
        Scroller scroller = mScroller;
        boolean flag;
        int i;
        int j;
        if (scroller.timePassed() < 450 && scroller.computeScrollOffset())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            i = scroller.getCurrY();
        } else
        {
            i = scroller.getFinalY();
        }
        j = mLastY;
        mLastY = i;
        offsetChildrenTopAndBottom(j - i);
        invalidate();
        requestLastChildLayout();
        if (flag)
        {
            post(this);
            return;
        }
        unsetMode(8);
        if (isMode(32))
        {
            setSelectionFromTop(0, i);
            return;
        } else
        {
            detach();
            return;
        }
    }

    void scroll(int i)
    {
        mLastY = 0;
        setMode(8);
        mScroller.abortAnimation();
        mScroller.startScroll(0, 0, 0, i, 450);
        post(this);
    }

    ()
    {
        this$0 = RefreshableListView.this;
        super();
    }
}
