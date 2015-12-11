// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.b.a.a;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.c.a.b.a.a:
//            d, g

abstract class e
    implements Iterator
{

    g a;
    Object b;
    final d c;
    private g d;

    e(d d1)
    {
        ReentrantLock reentrantlock;
        c = d1;
        super();
        reentrantlock = d1.c;
        reentrantlock.lock();
        a = a();
        if (a != null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        d1 = null;
_L1:
        b = d1;
        reentrantlock.unlock();
        return;
        d1 = ((d) (a.a));
          goto _L1
        d1;
        reentrantlock.unlock();
        throw d1;
    }

    private g b(g g1)
    {
_L6:
        g g2 = a(g1);
        if (g2 != null) goto _L2; else goto _L1
_L1:
        g g3 = null;
_L4:
        return g3;
_L2:
        g3 = g2;
        if (g2.a != null) goto _L4; else goto _L3
_L3:
        if (g2 == g1)
        {
            return a();
        }
        g1 = g2;
        if (true) goto _L6; else goto _L5
_L5:
    }

    abstract g a();

    abstract g a(g g1);

    void b()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c.c;
        reentrantlock.lock();
        a = b(a);
        if (a != null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        Object obj = null;
_L1:
        b = obj;
        reentrantlock.unlock();
        return;
        obj = a.a;
          goto _L1
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public boolean hasNext()
    {
        return a != null;
    }

    public Object next()
    {
        if (a == null)
        {
            throw new NoSuchElementException();
        } else
        {
            d = a;
            Object obj = b;
            b();
            return obj;
        }
    }

    public void remove()
    {
        ReentrantLock reentrantlock;
        g g1;
        g1 = d;
        if (g1 == null)
        {
            throw new IllegalStateException();
        }
        d = null;
        reentrantlock = c.c;
        reentrantlock.lock();
        if (g1.a != null)
        {
            c.a(g1);
        }
        reentrantlock.unlock();
        return;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }
}
