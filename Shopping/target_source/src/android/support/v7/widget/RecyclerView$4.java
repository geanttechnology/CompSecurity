// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView

class a
    implements a
{

    final RecyclerView a;

    public int a()
    {
        return a.getChildCount();
    }

    public int a(View view)
    {
        return a.indexOfChild(view);
    }

    public void a(int i)
    {
        View view = a.getChildAt(i);
        if (view != null)
        {
            RecyclerView.b(a, view);
        }
        a.removeViewAt(i);
    }

    public void a(View view, int i)
    {
        a.addView(view, i);
        RecyclerView.a(a, view);
    }

    public void a(View view, int i, android.view.tParams tparams)
    {
        a a1 = RecyclerView.b(view);
        if (a1 != null)
        {
            if (!a1.s() && !a1.c())
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Called attach on a child which is not detached: ").append(a1).toString());
            }
            a1.m();
        }
        RecyclerView.a(a, view, i, tparams);
    }

    public a b(View view)
    {
        return RecyclerView.b(view);
    }

    public View b(int i)
    {
        return a.getChildAt(i);
    }

    public void b()
    {
        int j = a();
        for (int i = 0; i < j; i++)
        {
            RecyclerView.b(a, b(i));
        }

        a.removeAllViews();
    }

    public void c(int i)
    {
        Object obj = b(i);
        if (obj != null)
        {
            obj = RecyclerView.b(((View) (obj)));
            if (obj != null)
            {
                if (((b) (obj)).s() && !((s) (obj)).c())
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("called detach on an already detached child ").append(obj).toString());
                }
                (() (obj)).b(256);
            }
        }
        RecyclerView.a(a, i);
    }

    (RecyclerView recyclerview)
    {
        a = recyclerview;
        super();
    }
}
