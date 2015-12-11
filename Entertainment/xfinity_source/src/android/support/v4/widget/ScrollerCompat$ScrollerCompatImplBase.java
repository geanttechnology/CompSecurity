// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.widget.Scroller;

// Referenced classes of package android.support.v4.widget:
//            ScrollerCompat

static class 
    implements 
{

    public void abortAnimation(Object obj)
    {
        ((Scroller)obj).abortAnimation();
    }

    public boolean computeScrollOffset(Object obj)
    {
        return ((Scroller)obj).computeScrollOffset();
    }

    public int getCurrX(Object obj)
    {
        return ((Scroller)obj).getCurrX();
    }

    public int getCurrY(Object obj)
    {
        return ((Scroller)obj).getCurrY();
    }

    public int getFinalX(Object obj)
    {
        return ((Scroller)obj).getFinalX();
    }

    public int getFinalY(Object obj)
    {
        return ((Scroller)obj).getFinalY();
    }

    public boolean isFinished(Object obj)
    {
        return ((Scroller)obj).isFinished();
    }

    public void startScroll(Object obj, int i, int j, int k, int l, int i1)
    {
        ((Scroller)obj).startScroll(i, j, k, l, i1);
    }

    ()
    {
    }
}
