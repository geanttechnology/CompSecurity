// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.support.v4.view.bi;
import android.view.View;

final class ca
{

    private final View a;
    private int b;
    private int c;
    private int d;
    private int e;

    public ca(View view)
    {
        a = view;
    }

    private static void a(View view)
    {
        float f = bi.m(view);
        bi.a(view, 1.0F + f);
        bi.a(view, f);
    }

    private void c()
    {
        bi.d(a, d - (a.getTop() - b));
        bi.e(a, e - (a.getLeft() - c));
        if (android.os.Build.VERSION.SDK_INT < 23)
        {
            a(a);
            android.view.ViewParent viewparent = a.getParent();
            if (viewparent instanceof View)
            {
                a((View)viewparent);
            }
        }
    }

    public final void a()
    {
        b = a.getTop();
        c = a.getLeft();
        c();
    }

    public final boolean a(int i)
    {
        if (d != i)
        {
            d = i;
            c();
            return true;
        } else
        {
            return false;
        }
    }

    public final int b()
    {
        return d;
    }
}
