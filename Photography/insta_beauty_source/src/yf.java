// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.widget.OverScroller;

class yf extends ye
{

    private OverScroller a;

    public yf(Context context)
    {
        a = new OverScroller(context);
    }

    public void a(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2, int j2)
    {
        a.fling(i, j, k, l, i1, j1, k1, l1, i2, j2);
    }

    public void a(boolean flag)
    {
        a.forceFinished(flag);
    }

    public boolean a()
    {
        return a.computeScrollOffset();
    }

    public int b()
    {
        return a.getCurrX();
    }

    public int c()
    {
        return a.getCurrY();
    }
}
