// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.support.v4.view.bi;

// Referenced classes of package android.support.v4.widget:
//            a, b

final class c
    implements Runnable
{

    private a a;

    private c(a a1)
    {
        a = a1;
        super();
    }

    c(a a1, byte byte0)
    {
        this(a1);
    }

    public final void run()
    {
        if (!android.support.v4.widget.a.a(a))
        {
            return;
        }
        if (android.support.v4.widget.a.b(a))
        {
            android.support.v4.widget.a.a(a, false);
            android.support.v4.widget.a.c(a).a();
        }
        b b1 = android.support.v4.widget.a.c(a);
        if (b1.c() || !android.support.v4.widget.a.d(a))
        {
            android.support.v4.widget.a.b(a, false);
            return;
        }
        if (android.support.v4.widget.a.e(a))
        {
            android.support.v4.widget.a.c(a, false);
            android.support.v4.widget.a.f(a);
        }
        b1.d();
        int i = b1.g();
        a.a(i);
        bi.a(android.support.v4.widget.a.g(a), this);
    }
}
