// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview.scrollerproxy;

import android.content.Context;
import android.widget.Scroller;

// Referenced classes of package uk.co.senab.photoview.scrollerproxy:
//            ScrollerProxy

public class PreGingerScroller extends ScrollerProxy
{

    private final Scroller mScroller;

    public PreGingerScroller(Context context)
    {
        mScroller = new Scroller(context);
    }

    public boolean computeScrollOffset()
    {
        return mScroller.computeScrollOffset();
    }

    public void fling(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2, int j2)
    {
        mScroller.fling(i, j, k, l, i1, j1, k1, l1);
    }

    public void forceFinished(boolean flag)
    {
        mScroller.forceFinished(flag);
    }

    public int getCurrX()
    {
        return mScroller.getCurrX();
    }

    public int getCurrY()
    {
        return mScroller.getCurrY();
    }

    public boolean isFinished()
    {
        return mScroller.isFinished();
    }
}
