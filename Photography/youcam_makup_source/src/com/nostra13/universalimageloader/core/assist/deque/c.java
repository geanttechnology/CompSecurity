// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.assist.deque;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.nostra13.universalimageloader.core.assist.deque:
//            LinkedBlockingDeque, e

abstract class c
    implements Iterator
{

    e a;
    Object b;
    final LinkedBlockingDeque c;
    private e d;

    c(LinkedBlockingDeque linkedblockingdeque)
    {
        ReentrantLock reentrantlock;
        c = linkedblockingdeque;
        super();
        reentrantlock = linkedblockingdeque.lock;
        reentrantlock.lock();
        a = a();
        if (a != null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        linkedblockingdeque = null;
_L1:
        b = linkedblockingdeque;
        reentrantlock.unlock();
        return;
        linkedblockingdeque = ((LinkedBlockingDeque) (a.a));
          goto _L1
        linkedblockingdeque;
        reentrantlock.unlock();
        throw linkedblockingdeque;
    }

    private e b(e e1)
    {
_L6:
        e e2 = a(e1);
        if (e2 != null) goto _L2; else goto _L1
_L1:
        e e3 = null;
_L4:
        return e3;
_L2:
        e3 = e2;
        if (e2.a != null) goto _L4; else goto _L3
_L3:
        if (e2 == e1)
        {
            return a();
        }
        e1 = e2;
        if (true) goto _L6; else goto _L5
_L5:
    }

    abstract e a();

    abstract e a(e e1);

    void b()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c.lock;
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
        e e1;
        e1 = d;
        if (e1 == null)
        {
            throw new IllegalStateException();
        }
        d = null;
        reentrantlock = c.lock;
        reentrantlock.lock();
        if (e1.a != null)
        {
            c.a(e1);
        }
        reentrantlock.unlock();
        return;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }
}
