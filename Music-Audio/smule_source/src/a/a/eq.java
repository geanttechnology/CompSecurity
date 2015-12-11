// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

// Referenced classes of package a.a:
//            ck, cj, er, ez

public final class eq
{

    List a;
    final Set b;
    final Set c;
    private Executor d;

    public eq(Executor executor)
    {
        this(executor, ((List) (new LinkedList())), ((List) (new LinkedList())));
    }

    private eq(Executor executor, List list, List list1)
    {
        a = new LinkedList();
        b = new HashSet();
        c = new HashSet();
        d = executor;
        a(list);
        b(list1);
    }

    public final void a(cj cj1)
    {
        a(cj1, ck.e);
    }

    public final void a(cj cj1, ck ck1)
    {
        if (cj1.b)
        {
            return;
        } else
        {
            cj1.b = true;
            cj1.c = ck1;
            d.execute(new er(this, cj1, (byte)0));
            return;
        }
    }

    public final void a(ez ez)
    {
        synchronized (a)
        {
            a.add(ez);
        }
    }

    public final void a(List list)
    {
        synchronized (b)
        {
            b.addAll(list);
            b.remove(null);
        }
    }

    public final void b(List list)
    {
        synchronized (c)
        {
            c.addAll(list);
            c.remove(null);
        }
    }
}
