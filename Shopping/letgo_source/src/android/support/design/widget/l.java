// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.view.View;

// Referenced classes of package android.support.design.widget:
//            m, CoordinatorLayout

class l extends CoordinatorLayout.a
{

    private m a;
    private int b;
    private int c;

    public boolean a(int i)
    {
        if (a != null)
        {
            return a.a(i);
        } else
        {
            b = i;
            return false;
        }
    }

    public boolean a(CoordinatorLayout coordinatorlayout, View view, int i)
    {
        coordinatorlayout.a(view, i);
        if (a == null)
        {
            a = new m(view);
        }
        a.a();
        if (b != 0)
        {
            a.a(b);
            b = 0;
        }
        if (c != 0)
        {
            a.b(c);
            c = 0;
        }
        return true;
    }

    public int b()
    {
        if (a != null)
        {
            return a.b();
        } else
        {
            return 0;
        }
    }
}
