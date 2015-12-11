// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ad.d;

import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class b extends android.support.v7.widget.RecyclerView.l
{

    private final List a = new ArrayList();

    public transient b(android.support.v7.widget.RecyclerView.l al[])
    {
        Collections.addAll(a, al);
    }

    public final void a(RecyclerView recyclerview, int i)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((android.support.v7.widget.RecyclerView.l)iterator.next()).a(recyclerview, i)) { }
    }

    public final void a(RecyclerView recyclerview, int i, int j)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((android.support.v7.widget.RecyclerView.l)iterator.next()).a(recyclerview, i, j)) { }
    }
}
