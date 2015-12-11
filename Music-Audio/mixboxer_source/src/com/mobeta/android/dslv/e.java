// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.os.SystemClock;

// Referenced classes of package com.mobeta.android.dslv:
//            DragSortListView

class e
    implements Runnable
{

    protected long a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private boolean h;
    private DragSortListView i;

    public e(DragSortListView dragsortlistview, float f1, int j)
    {
        i = dragsortlistview;
        super();
        c = f1;
        b = j;
        f1 = 1.0F / (c * 2.0F * (1.0F - c));
        g = f1;
        d = f1;
        e = c / ((c - 1.0F) * 2.0F);
        f = 1.0F / (1.0F - c);
    }

    public void a()
    {
    }

    public void a(float f1)
    {
    }

    public void b()
    {
    }

    public final void c()
    {
        a = SystemClock.uptimeMillis();
        h = false;
        a();
        i.post(this);
    }

    public final void d()
    {
        h = true;
    }

    public void run()
    {
        if (h)
        {
            return;
        }
        float f1 = (float)(SystemClock.uptimeMillis() - a) / b;
        if (f1 >= 1.0F)
        {
            a(1.0F);
            b();
            return;
        }
        if (f1 < c)
        {
            f1 *= d * f1;
        } else
        if (f1 < 1.0F - c)
        {
            float f2 = e;
            f1 = f1 * f + f2;
        } else
        {
            f1 = 1.0F - (f1 - 1.0F) * (g * (f1 - 1.0F));
        }
        a(f1);
        i.post(this);
    }
}
