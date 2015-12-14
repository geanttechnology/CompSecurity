// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import myobfuscated.f.m;
import myobfuscated.q.b;
import myobfuscated.q.c;

final class al
    implements b, c
{

    private final List a;
    private final android.support.v4.util.Pools.Pool b;
    private int c;
    private Priority d;
    private c e;
    private List f;

    al(List list, android.support.v4.util.Pools.Pool pool)
    {
        b = pool;
        m.a(list);
        a = list;
        c = 0;
    }

    private void e()
    {
        if (c < a.size() - 1)
        {
            c = c + 1;
            a(d, e);
            return;
        } else
        {
            e.a(new GlideException("Fetch failed", new ArrayList(f)));
            return;
        }
    }

    public final void a()
    {
        b.release(f);
        f = null;
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((b)iterator.next()).a()) { }
    }

    public final void a(Priority priority, c c1)
    {
        d = priority;
        e = c1;
        f = (List)b.acquire();
        ((b)a.get(c)).a(priority, this);
    }

    public final void a(Exception exception)
    {
        f.add(exception);
        e();
    }

    public final void a(Object obj)
    {
        if (obj != null)
        {
            e.a(obj);
            return;
        } else
        {
            e();
            return;
        }
    }

    public final void b()
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((b)iterator.next()).b()) { }
    }

    public final DataSource c()
    {
        return ((b)a.get(0)).c();
    }

    public final Class d()
    {
        return ((b)a.get(0)).d();
    }
}
