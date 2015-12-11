// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.j.a.d.e;
import com.j.a.g.o;

public class k extends android.support.v7.widget.RecyclerView.k
{

    android.support.v7.widget.RecyclerView.k a;
    private int b;
    private int c;

    public k(android.support.v7.widget.RecyclerView.k k1)
    {
        b = -1;
        c = -1;
        a = k1;
    }

    public void a(RecyclerView recyclerview, int i)
    {
        if (a != null)
        {
            a.a(recyclerview, i);
        }
    }

    public void a(RecyclerView recyclerview, int i, int j)
    {
        int l = -1;
        int i1;
        android.support.v7.widget.RecyclerView.h h = recyclerview.getLayoutManager();
        if (!(h instanceof LinearLayoutManager))
        {
            break MISSING_BLOCK_LABEL_103;
        }
        i1 = ((LinearLayoutManager)h).i();
        l = ((LinearLayoutManager)h).j();
_L3:
        if (e.e().i() && (b != i1 || c != l))
        {
            b = i1;
            c = l;
            o.c(recyclerview);
        }
_L2:
        if (a != null)
        {
            a.a(recyclerview, i, j);
        }
        return;
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
        i1 = -1;
          goto _L3
    }
}
