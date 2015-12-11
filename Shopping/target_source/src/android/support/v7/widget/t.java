// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;

class t
{

    int a;
    int b;
    int c;
    int d;
    int e;

    t()
    {
        e = 0;
    }

    View a(RecyclerView.m m)
    {
        m = m.c(b);
        b = b + c;
        return m;
    }

    boolean a(RecyclerView.q q)
    {
        return b >= 0 && b < q.e();
    }
}
