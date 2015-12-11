// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.g.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.j.a.g.a:
//            b, c, f, e, 
//            g, a

public class d
{

    private final List a = new ArrayList();
    private final Object b = new Object();
    private Object c;
    private b d;
    private boolean e;
    private Exception f;

    public d()
    {
        d = b.d;
        e = false;
    }

    static d a(d d1)
    {
        return d1.e();
    }

    private void a(b b1, Object obj, Exception exception)
    {
label0:
        {
            ArrayList arraylist = new ArrayList(a);
            synchronized (b)
            {
                if (e)
                {
                    break label0;
                }
                a.clear();
                d = b1;
                f = exception;
                e = true;
                c = obj;
            }
            for (obj = arraylist.iterator(); ((Iterator) (obj)).hasNext(); a((c)((Iterator) (obj)).next(), b1)) { }
            break MISSING_BLOCK_LABEL_105;
        }
        obj1;
        JVM INSTR monitorexit ;
        return;
        b1;
        obj1;
        JVM INSTR monitorexit ;
        throw b1;
    }

    private void a(c c1, b b1)
    {
        switch (f.a[b1.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            c1.a(c);
            c1.b();
            return;

        case 2: // '\002'
            c1.a(f);
            c1.a();
            c1.b(f);
            c1.d();
            return;

        case 3: // '\003'
            c1.c();
            break;
        }
        c1.b(f);
        c1.d();
    }

    private d e()
    {
        return this;
    }

    public c a(c c1)
    {
        if (e)
        {
            a(c1, d);
            return c1;
        } else
        {
            a.add(c1);
            return c1;
        }
    }

    public void a()
    {
        a(b.a, null, null);
    }

    public void a(int i)
    {
        a(((c) (new e(this, g.a().schedule(new a(this), i, TimeUnit.MILLISECONDS)))));
    }

    void a(Exception exception)
    {
        a(b.b, null, exception);
    }

    public void b()
    {
        a(b.c, null, null);
    }

    public boolean c()
    {
        return d == b.a;
    }

    public b d()
    {
        return d;
    }
}
