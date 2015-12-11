// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.support.v4.view.ah;
import android.view.View;

class m
{

    private final View a;
    private int b;
    private int c;
    private int d;
    private int e;

    public m(View view)
    {
        a = view;
    }

    private void c()
    {
        if (android.os.Build.VERSION.SDK_INT == 22)
        {
            ah.b(a, d);
            ah.a(a, e);
            return;
        } else
        {
            ah.d(a, d - a.getTop() - b);
            ah.e(a, e - a.getLeft() - c);
            return;
        }
    }

    public void a()
    {
        b = a.getTop();
        c = a.getLeft();
        c();
    }

    public boolean a(int i)
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

    public int b()
    {
        return d;
    }

    public boolean b(int i)
    {
        if (e != i)
        {
            e = i;
            c();
            return true;
        } else
        {
            return false;
        }
    }
}
