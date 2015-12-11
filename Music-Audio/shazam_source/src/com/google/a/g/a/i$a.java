// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.g.a;

import com.google.a.a.g;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

// Referenced classes of package com.google.a.g.a:
//            a, i, c, j, 
//            r

private static final class <init> extends a
    implements Runnable
{

    private c b;
    private j c;
    private volatile j d;

    static j a(<init> <init>1)
    {
        <init>1.d = null;
        return null;
    }

    private static void a(Future future, boolean flag)
    {
        if (future != null)
        {
            future.cancel(flag);
        }
    }

    public final boolean cancel(boolean flag)
    {
        if (super.cancel(flag))
        {
            a(c, flag);
            a(d, flag);
            return true;
        } else
        {
            return false;
        }
    }

    public final void run()
    {
        Object obj = r.a(c);
        obj = (j)g.a(b.a(obj), "AsyncFunction may not return null.");
        d = ((j) (obj));
        if (!isCancelled())
        {
            break MISSING_BLOCK_LABEL_108;
        }
        ((j) (obj)).cancel(super.a.d());
        d = null;
        b = null;
        c = null;
        return;
        obj;
        cancel(false);
        b = null;
        c = null;
        return;
        obj;
        a(((ExecutionException) (obj)).getCause());
        b = null;
        c = null;
        return;
        ((j) (obj)).a(new Runnable(((j) (obj))) {

            final j a;
            final i.a b;

            public final void run()
            {
                b.a(r.a(a));
                i.a.a(b);
                return;
                Object obj2;
                obj2;
                b.cancel(false);
                i.a.a(b);
                return;
                obj2;
                b.a(((ExecutionException) (obj2)).getCause());
                i.a.a(b);
                return;
                obj2;
                i.a.a(b);
                throw obj2;
            }

            
            {
                b = i.a.this;
                a = j1;
                super();
            }
        }, a);
        b = null;
        c = null;
        return;
        Object obj1;
        obj1;
        a(((UndeclaredThrowableException) (obj1)).getCause());
        b = null;
        c = null;
        return;
        obj1;
        a(((Throwable) (obj1)));
        b = null;
        c = null;
        return;
        obj1;
        b = null;
        c = null;
        throw obj1;
    }

    private t>(c c1, j j1)
    {
        b = (c)g.a(c1);
        c = (j)g.a(j1);
    }

    c(c c1, j j1, byte byte0)
    {
        this(c1, j1);
    }
}
