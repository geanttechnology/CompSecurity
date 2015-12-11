// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.services.do;

import io.presage.services.if.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class a
{

    protected int a;
    protected boolean b;
    private Map c;
    private List d;

    public a(int i)
    {
        a = 50;
        b = false;
        c = new HashMap();
        d = new CopyOnWriteArrayList();
        a = i;
    }

    public final void a()
    {
        d.clear();
        d = new CopyOnWriteArrayList();
        b = false;
    }

    public final void b()
    {
        d.clear();
    }

    public final boolean c()
    {
        return !d.isEmpty();
    }

    public final Map d()
    {
        return c;
    }

    public final List e()
    {
        return d;
    }

    public final boolean f()
    {
        return b;
    }

    public final List g()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = d.iterator(); iterator.hasNext(); arraylist.add(((e)iterator.next()).d())) { }
        return arraylist;
    }

    public final void h()
    {
        c.clear();
        d.clear();
    }
}
