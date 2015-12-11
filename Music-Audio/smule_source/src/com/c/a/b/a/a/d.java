// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.b.a.a;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.c.a.b.a.a:
//            a, g, f

public class d extends AbstractQueue
    implements a, Serializable
{

    transient g a;
    transient g b;
    final ReentrantLock c;
    private transient int d;
    private final int e;
    private final Condition f;
    private final Condition g;

    public d()
    {
        this(0x7fffffff);
    }

    public d(int i)
    {
        c = new ReentrantLock();
        f = c.newCondition();
        g = c.newCondition();
        if (i <= 0)
        {
            throw new IllegalArgumentException();
        } else
        {
            e = i;
            return;
        }
    }

    private boolean b(g g1)
    {
        if (d >= e)
        {
            return false;
        }
        g g2 = a;
        g1.c = g2;
        a = g1;
        if (b == null)
        {
            b = g1;
        } else
        {
            g2.b = g1;
        }
        d = d + 1;
        f.signal();
        return true;
    }

    private boolean c(g g1)
    {
        if (d >= e)
        {
            return false;
        }
        g g2 = b;
        g1.b = g2;
        b = g1;
        if (a == null)
        {
            a = g1;
        } else
        {
            g2.c = g1;
        }
        d = d + 1;
        f.signal();
        return true;
    }

    private Object f()
    {
        g g1 = a;
        if (g1 == null)
        {
            return null;
        }
        g g2 = g1.c;
        Object obj = g1.a;
        g1.a = null;
        g1.c = g1;
        a = g2;
        if (g2 == null)
        {
            b = null;
        } else
        {
            g2.b = null;
        }
        d = d - 1;
        g.signal();
        return obj;
    }

    private Object g()
    {
        g g1 = b;
        if (g1 == null)
        {
            return null;
        }
        g g2 = g1.b;
        Object obj = g1.a;
        g1.a = null;
        g1.b = g1;
        b = g2;
        if (g2 == null)
        {
            a = null;
        } else
        {
            g2.c = null;
        }
        d = d - 1;
        g.signal();
        return obj;
    }

    public Object a()
    {
        Object obj = b();
        if (obj == null)
        {
            throw new NoSuchElementException();
        } else
        {
            return obj;
        }
    }

    public Object a(long l, TimeUnit timeunit)
    {
        l = timeunit.toNanos(l);
        timeunit = c;
        timeunit.lockInterruptibly();
_L2:
        Object obj = f();
        if (obj != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (l <= 0L)
        {
            timeunit.unlock();
            return null;
        }
        l = f.awaitNanos(l);
        if (true) goto _L2; else goto _L1
_L1:
        timeunit.unlock();
        return obj;
        Exception exception;
        exception;
        timeunit.unlock();
        throw exception;
    }

    void a(g g1)
    {
        g g2 = g1.b;
        g g3 = g1.c;
        if (g2 == null)
        {
            f();
            return;
        }
        if (g3 == null)
        {
            g();
            return;
        } else
        {
            g2.c = g3;
            g3.b = g2;
            g1.a = null;
            d = d - 1;
            g.signal();
            return;
        }
    }

    public void a(Object obj)
    {
        if (!c(obj))
        {
            throw new IllegalStateException("Deque full");
        } else
        {
            return;
        }
    }

    public boolean a(Object obj, long l, TimeUnit timeunit)
    {
        if (obj == null)
        {
            throw new NullPointerException();
        }
        obj = new g(obj);
        l = timeunit.toNanos(l);
        timeunit = c;
        timeunit.lockInterruptibly();
_L2:
        boolean flag = c(((g) (obj)));
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        if (l <= 0L)
        {
            timeunit.unlock();
            return false;
        }
        l = g.awaitNanos(l);
        if (true) goto _L2; else goto _L1
_L1:
        timeunit.unlock();
        return true;
        obj;
        timeunit.unlock();
        throw obj;
    }

    public boolean add(Object obj)
    {
        a(obj);
        return true;
    }

    public Object b()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
        Object obj = f();
        reentrantlock.unlock();
        return obj;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public boolean b(Object obj)
    {
        g g1;
        if (obj == null)
        {
            throw new NullPointerException();
        }
        g1 = new g(obj);
        obj = c;
        ((ReentrantLock) (obj)).lock();
        boolean flag = b(g1);
        ((ReentrantLock) (obj)).unlock();
        return flag;
        Exception exception;
        exception;
        ((ReentrantLock) (obj)).unlock();
        throw exception;
    }

    public Object c()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
_L1:
        Object obj = f();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        f.await();
          goto _L1
        obj;
        reentrantlock.unlock();
        throw obj;
        reentrantlock.unlock();
        return obj;
    }

    public boolean c(Object obj)
    {
        g g1;
        if (obj == null)
        {
            throw new NullPointerException();
        }
        g1 = new g(obj);
        obj = c;
        ((ReentrantLock) (obj)).lock();
        boolean flag = c(g1);
        ((ReentrantLock) (obj)).unlock();
        return flag;
        Exception exception;
        exception;
        ((ReentrantLock) (obj)).unlock();
        throw exception;
    }

    public void clear()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
        g g1 = a;
_L2:
        if (g1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        g g2;
        g1.a = null;
        g2 = g1.c;
        g1.b = null;
        g1.c = null;
        g1 = g2;
        if (true) goto _L2; else goto _L1
_L1:
        b = null;
        a = null;
        d = 0;
        g.signalAll();
        reentrantlock.unlock();
        return;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public boolean contains(Object obj)
    {
        ReentrantLock reentrantlock;
        if (obj == null)
        {
            return false;
        }
        reentrantlock = c;
        reentrantlock.lock();
        g g1 = a;
_L2:
        if (g1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        boolean flag = obj.equals(g1.a);
        if (flag)
        {
            reentrantlock.unlock();
            return true;
        }
        g1 = g1.c;
        if (true) goto _L2; else goto _L1
_L1:
        reentrantlock.unlock();
        return false;
        obj;
        reentrantlock.unlock();
        throw obj;
    }

    public Object d()
    {
        Object obj = e();
        if (obj == null)
        {
            throw new NoSuchElementException();
        } else
        {
            return obj;
        }
    }

    public void d(Object obj)
    {
        g g1;
        if (obj == null)
        {
            throw new NullPointerException();
        }
        g1 = new g(obj);
        obj = c;
        ((ReentrantLock) (obj)).lock();
        for (; !c(g1); g.await()) { }
        break MISSING_BLOCK_LABEL_57;
        Exception exception;
        exception;
        ((ReentrantLock) (obj)).unlock();
        throw exception;
        ((ReentrantLock) (obj)).unlock();
        return;
    }

    public int drainTo(Collection collection)
    {
        return drainTo(collection, 0x7fffffff);
    }

    public int drainTo(Collection collection, int i)
    {
        ReentrantLock reentrantlock;
        if (collection == null)
        {
            throw new NullPointerException();
        }
        if (collection == this)
        {
            throw new IllegalArgumentException();
        }
        reentrantlock = c;
        reentrantlock.lock();
        int j = Math.min(i, d);
        i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        collection.add(a.a);
        f();
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        reentrantlock.unlock();
        return j;
        collection;
        reentrantlock.unlock();
        throw collection;
    }

    public Object e()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
        Object obj = a;
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        reentrantlock.unlock();
        return obj;
_L2:
        obj = a.a;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public boolean e(Object obj)
    {
        ReentrantLock reentrantlock;
        if (obj == null)
        {
            return false;
        }
        reentrantlock = c;
        reentrantlock.lock();
        g g1 = a;
_L2:
        if (g1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!obj.equals(g1.a))
        {
            break MISSING_BLOCK_LABEL_46;
        }
        a(g1);
        reentrantlock.unlock();
        return true;
        g1 = g1.c;
        if (true) goto _L2; else goto _L1
_L1:
        reentrantlock.unlock();
        return false;
        obj;
        reentrantlock.unlock();
        throw obj;
    }

    public Object element()
    {
        return d();
    }

    public Iterator iterator()
    {
        return new f(this);
    }

    public boolean offer(Object obj)
    {
        return c(obj);
    }

    public boolean offer(Object obj, long l, TimeUnit timeunit)
    {
        return a(obj, l, timeunit);
    }

    public Object peek()
    {
        return e();
    }

    public Object poll()
    {
        return b();
    }

    public Object poll(long l, TimeUnit timeunit)
    {
        return a(l, timeunit);
    }

    public void put(Object obj)
    {
        d(obj);
    }

    public int remainingCapacity()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
        int i;
        int j;
        i = e;
        j = d;
        reentrantlock.unlock();
        return i - j;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public Object remove()
    {
        return a();
    }

    public boolean remove(Object obj)
    {
        return e(obj);
    }

    public int size()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
        int i = d;
        reentrantlock.unlock();
        return i;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public Object take()
    {
        return c();
    }

    public Object[] toArray()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
        Object aobj[] = new Object[d];
        int i = 0;
        g g1 = a;
_L2:
        if (g1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        aobj[i] = g1.a;
        g1 = g1.c;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        reentrantlock.unlock();
        return aobj;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public Object[] toArray(Object aobj[])
    {
        Object aobj1[];
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
        aobj1 = aobj;
        if (aobj.length < d)
        {
            aobj1 = (Object[])(Object[])Array.newInstance(((Object) (aobj)).getClass().getComponentType(), d);
        }
        int i = 0;
        aobj = a;
_L2:
        if (aobj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        aobj1[i] = ((g) (aobj)).a;
        aobj = ((g) (aobj)).c;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (aobj1.length > i)
        {
            aobj1[i] = null;
        }
        reentrantlock.unlock();
        return aobj1;
        aobj;
        reentrantlock.unlock();
        throw aobj;
    }

    public String toString()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
        Object obj = a;
        if (obj == null)
        {
            reentrantlock.unlock();
            return "[]";
        }
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder();
        stringbuilder.append('[');
_L1:
        Object obj2 = ((g) (obj)).a;
        Object obj1;
        obj1 = obj2;
        if (obj2 == this)
        {
            obj1 = "(this Collection)";
        }
        stringbuilder.append(obj1);
        obj = ((g) (obj)).c;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        obj = stringbuilder.append(']').toString();
        reentrantlock.unlock();
        return ((String) (obj));
        stringbuilder.append(',').append(' ');
          goto _L1
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }
}
