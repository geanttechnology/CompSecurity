// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

// Referenced classes of package android.support.v4.view:
//            av, be

class aw extends av
{

    aw()
    {
    }

    public final void a(View view, int j, int k, int l, int i1)
    {
        be.a(view, j, k, l, i1);
    }

    public final void a(View view, Runnable runnable)
    {
        be.a(view, runnable);
    }

    public final void a(View view, Runnable runnable, long l)
    {
        be.a(view, runnable, l);
    }

    public void c(View view, int j)
    {
        int k = j;
        if (j == 4)
        {
            k = 2;
        }
        be.a(view, k);
    }

    public final boolean c(View view)
    {
        return be.a(view);
    }

    public final void d(View view)
    {
        be.b(view);
    }

    public final int e(View view)
    {
        return be.c(view);
    }

    public final ViewParent i(View view)
    {
        return be.d(view);
    }

    public final int m(View view)
    {
        return be.e(view);
    }

    public final int n(View view)
    {
        return be.f(view);
    }

    public final boolean p(View view)
    {
        return be.g(view);
    }
}
