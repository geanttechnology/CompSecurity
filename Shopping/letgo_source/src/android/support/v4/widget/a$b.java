// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.support.v4.view.ah;

// Referenced classes of package android.support.v4.widget:
//            a

private class <init>
    implements Runnable
{

    final a a;

    public void run()
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
        <init> <init>1 = android.support.v4.widget.a.c(a);
        if (<init>1.c() || !android.support.v4.widget.a.d(a))
        {
            android.support.v4.widget.a.b(a, false);
            return;
        }
        if (android.support.v4.widget.a.e(a))
        {
            android.support.v4.widget.a.c(a, false);
            android.support.v4.widget.a.f(a);
        }
        <init>1.d();
        int i = <init>1.g();
        int j = <init>1.h();
        a.a(i, j);
        ah.a(android.support.v4.widget.a.g(a), this);
    }

    private (a a1)
    {
        a = a1;
        super();
    }

    a(a a1, a a2)
    {
        this(a1);
    }
}
