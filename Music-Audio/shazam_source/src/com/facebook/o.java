// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.os.Handler;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.facebook:
//            GraphRequest

public final class o extends AbstractList
{
    public static interface a
    {

        public abstract void a();
    }

    public static interface b
        extends a
    {
    }


    private static AtomicInteger g = new AtomicInteger();
    Handler a;
    List b;
    int c;
    final String d;
    List e;
    String f;

    public o()
    {
        b = new ArrayList();
        c = 0;
        d = Integer.valueOf(g.incrementAndGet()).toString();
        e = new ArrayList();
        b = new ArrayList();
    }

    public o(Collection collection)
    {
        b = new ArrayList();
        c = 0;
        d = Integer.valueOf(g.incrementAndGet()).toString();
        e = new ArrayList();
        b = new ArrayList(collection);
    }

    public transient o(GraphRequest agraphrequest[])
    {
        b = new ArrayList();
        c = 0;
        d = Integer.valueOf(g.incrementAndGet()).toString();
        e = new ArrayList();
        b = Arrays.asList(agraphrequest);
    }

    public final GraphRequest a(int i)
    {
        return (GraphRequest)b.get(i);
    }

    public final volatile void add(int i, Object obj)
    {
        obj = (GraphRequest)obj;
        b.add(i, obj);
    }

    public final volatile boolean add(Object obj)
    {
        obj = (GraphRequest)obj;
        return b.add(obj);
    }

    public final void clear()
    {
        b.clear();
    }

    public final Object get(int i)
    {
        return a(i);
    }

    public final volatile Object remove(int i)
    {
        return (GraphRequest)b.remove(i);
    }

    public final volatile Object set(int i, Object obj)
    {
        obj = (GraphRequest)obj;
        return (GraphRequest)b.set(i, obj);
    }

    public final int size()
    {
        return b.size();
    }

}
