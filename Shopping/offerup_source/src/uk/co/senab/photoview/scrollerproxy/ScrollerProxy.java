// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview.scrollerproxy;

import android.content.Context;

// Referenced classes of package uk.co.senab.photoview.scrollerproxy:
//            PreGingerScroller, GingerScroller, IcsScroller

public abstract class ScrollerProxy
{

    public ScrollerProxy()
    {
    }

    public static ScrollerProxy getScroller(Context context)
    {
        if (android.os.Build.VERSION.SDK_INT < 9)
        {
            return new PreGingerScroller(context);
        }
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            return new GingerScroller(context);
        } else
        {
            return new IcsScroller(context);
        }
    }

    public abstract boolean computeScrollOffset();

    public abstract void fling(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2, int j2);

    public abstract void forceFinished(boolean flag);

    public abstract int getCurrX();

    public abstract int getCurrY();

    public abstract boolean isFinished();
}
