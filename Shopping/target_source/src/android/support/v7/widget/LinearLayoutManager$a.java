// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;

// Referenced classes of package android.support.v7.widget:
//            LinearLayoutManager, x

class d
{

    int a;
    int b;
    boolean c;
    final LinearLayoutManager d;

    void a()
    {
        a = -1;
        b = 0x80000000;
        c = false;
    }

    public void a(View view)
    {
        if (c)
        {
            b = d.mOrientationHelper.b(view) + d.mOrientationHelper.b();
        } else
        {
            b = d.mOrientationHelper.a(view);
        }
        a = d.d(view);
    }

    public boolean a(View view, d d1)
    {
        d d2 = (d)view.getLayoutParams();
        if (!d2.d() && d2.d() >= 0 && d2.d() < d1.d())
        {
            a(view);
            return true;
        } else
        {
            return false;
        }
    }

    void b()
    {
        int i;
        if (c)
        {
            i = d.mOrientationHelper.d();
        } else
        {
            i = d.mOrientationHelper.c();
        }
        b = i;
    }

    public String toString()
    {
        return (new StringBuilder()).append("AnchorInfo{mPosition=").append(a).append(", mCoordinate=").append(b).append(", mLayoutFromEnd=").append(c).append('}').toString();
    }

    (LinearLayoutManager linearlayoutmanager)
    {
        d = linearlayoutmanager;
        super();
    }
}
