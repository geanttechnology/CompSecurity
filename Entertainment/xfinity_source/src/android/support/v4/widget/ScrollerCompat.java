// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.widget.Scroller;

// Referenced classes of package android.support.v4.widget:
//            ScrollerCompatGingerbread

public class ScrollerCompat
{
    static interface ScrollerCompatImpl
    {

        public abstract void abortAnimation(Object obj);

        public abstract boolean computeScrollOffset(Object obj);

        public abstract int getCurrX(Object obj);

        public abstract int getCurrY(Object obj);

        public abstract int getFinalX(Object obj);

        public abstract int getFinalY(Object obj);

        public abstract boolean isFinished(Object obj);

        public abstract void startScroll(Object obj, int i, int j, int k, int l, int i1);
    }

    static class ScrollerCompatImplBase
        implements ScrollerCompatImpl
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

        ScrollerCompatImplBase()
        {
        }
    }

    static class ScrollerCompatImplGingerbread
        implements ScrollerCompatImpl
    {

        public void abortAnimation(Object obj)
        {
            ScrollerCompatGingerbread.abortAnimation(obj);
        }

        public boolean computeScrollOffset(Object obj)
        {
            return ScrollerCompatGingerbread.computeScrollOffset(obj);
        }

        public int getCurrX(Object obj)
        {
            return ScrollerCompatGingerbread.getCurrX(obj);
        }

        public int getCurrY(Object obj)
        {
            return ScrollerCompatGingerbread.getCurrY(obj);
        }

        public int getFinalX(Object obj)
        {
            return ScrollerCompatGingerbread.getFinalX(obj);
        }

        public int getFinalY(Object obj)
        {
            return ScrollerCompatGingerbread.getFinalY(obj);
        }

        public boolean isFinished(Object obj)
        {
            return ScrollerCompatGingerbread.isFinished(obj);
        }

        public void startScroll(Object obj, int i, int j, int k, int l, int i1)
        {
            ScrollerCompatGingerbread.startScroll(obj, i, j, k, l, i1);
        }

        ScrollerCompatImplGingerbread()
        {
        }
    }

    static class ScrollerCompatImplIcs extends ScrollerCompatImplGingerbread
    {

        ScrollerCompatImplIcs()
        {
        }
    }


    static final ScrollerCompatImpl IMPL;
    Object mScroller;

    public void abortAnimation()
    {
        IMPL.abortAnimation(mScroller);
    }

    public boolean computeScrollOffset()
    {
        return IMPL.computeScrollOffset(mScroller);
    }

    public int getCurrX()
    {
        return IMPL.getCurrX(mScroller);
    }

    public int getCurrY()
    {
        return IMPL.getCurrY(mScroller);
    }

    public int getFinalX()
    {
        return IMPL.getFinalX(mScroller);
    }

    public int getFinalY()
    {
        return IMPL.getFinalY(mScroller);
    }

    public boolean isFinished()
    {
        return IMPL.isFinished(mScroller);
    }

    public void startScroll(int i, int j, int k, int l, int i1)
    {
        IMPL.startScroll(mScroller, i, j, k, l, i1);
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 14)
        {
            IMPL = new ScrollerCompatImplIcs();
        } else
        if (i >= 9)
        {
            IMPL = new ScrollerCompatImplGingerbread();
        } else
        {
            IMPL = new ScrollerCompatImplBase();
        }
    }
}
