// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.util.Log;
import android.view.View;

// Referenced classes of package android.support.v7.widget:
//            be, RecyclerView, bf, au

public abstract class bd
{

    private final be a = new be();
    int g;
    RecyclerView h;
    au i;
    boolean j;
    boolean k;
    View l;

    public bd()
    {
        g = -1;
    }

    static void a(bd bd1, int i1, int j1)
    {
        if (!bd1.k || bd1.g == -1)
        {
            bd1.b();
        }
        bd1.j = false;
        if (bd1.l != null)
        {
            if (RecyclerView.c(bd1.l) == bd1.g)
            {
                View view = bd1.l;
                bf bf2 = bd1.h.m;
                bd1.a(view, bd1.a);
                be.a(bd1.a, bd1.h);
                bd1.b();
            } else
            {
                Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                bd1.l = null;
            }
        }
        if (bd1.k)
        {
            bf bf1 = bd1.h.m;
            bd1.a(i1, j1, bd1.a);
            be.a(bd1.a, bd1.h);
        }
    }

    protected abstract void a();

    protected abstract void a(int i1, int j1, be be1);

    protected abstract void a(View view, be be1);

    protected final void b()
    {
        if (!k)
        {
            return;
        } else
        {
            a();
            h.m.a = -1;
            l = null;
            g = -1;
            j = false;
            k = false;
            au.a(i, this);
            i = null;
            h = null;
            return;
        }
    }
}
