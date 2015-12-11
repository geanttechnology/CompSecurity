// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package android.support.v7:
//            aiy

public class ajb extends AbstractQueue
    implements aiy, Serializable
{
    private abstract class a
        implements Iterator
    {

        c a;
        Object b;
        final ajb c;
        private c d;

        private c b(c c1)
        {
_L6:
            c c2 = a(c1);
            if (c2 != null) goto _L2; else goto _L1
_L1:
            c c3 = null;
_L4:
            return c3;
_L2:
            c3 = c2;
            if (c2.a != null) goto _L4; else goto _L3
_L3:
            if (c2 == c1)
            {
                return a();
            }
            c1 = c2;
            if (true) goto _L6; else goto _L5
_L5:
        }

        abstract c a();

        abstract c a(c c1);

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
            c c1;
            c1 = d;
            if (c1 == null)
            {
                throw new IllegalStateException();
            }
            d = null;
            reentrantlock = c.c;
            reentrantlock.lock();
            if (c1.a != null)
            {
                c.a(c1);
            }
            reentrantlock.unlock();
            return;
            Exception exception;
            exception;
            reentrantlock.unlock();
            throw exception;
        }

        a()
        {
            ReentrantLock reentrantlock;
            c = ajb.this;
            super();
            reentrantlock = ajb.this.c;
            reentrantlock.lock();
            a = a();
            if (a != null)
            {
                break MISSING_BLOCK_LABEL_45;
            }
            ajb1 = null;
_L1:
            b = ajb.this;
            reentrantlock.unlock();
            return;
            ajb1 = ((ajb) (a.a));
              goto _L1
            ajb1;
            reentrantlock.unlock();
            throw ajb.this;
        }
    }

    private class b extends a
    {

        final ajb d;

        c a()
        {
            return d.a;
        }

        c a(c c1)
        {
            return c1.c;
        }

        private b()
        {
            d = ajb.this;
            super();
        }

    }

    static final class c
    {

        Object a;
        c b;
        c c;

        c(Object obj)
        {
            a = obj;
        }
    }


    transient c a;
    transient c b;
    final ReentrantLock c;
    private transient int d;
    private final int e;
    private final Condition f;
    private final Condition g;

    public ajb()
    {
        this(0x7fffffff);
    }

    public ajb(int i)
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

    private boolean b(c c1)
    {
        if (d >= e)
        {
            return false;
        }
        c c2 = a;
        c1.c = c2;
        a = c1;
        if (b == null)
        {
            b = c1;
        } else
        {
            c2.b = c1;
        }
        d = d + 1;
        f.signal();
        return true;
    }

    private boolean c(c c1)
    {
        if (d >= e)
        {
            return false;
        }
        c c2 = b;
        c1.b = c2;
        b = c1;
        if (a == null)
        {
            a = c1;
        } else
        {
            c2.c = c1;
        }
        d = d + 1;
        f.signal();
        return true;
    }

    private Object f()
    {
        c c1 = a;
        if (c1 == null)
        {
            return null;
        }
        c c2 = c1.c;
        Object obj = c1.a;
        c1.a = null;
        c1.c = c1;
        a = c2;
        if (c2 == null)
        {
            b = null;
        } else
        {
            c2.b = null;
        }
        d = d - 1;
        g.signal();
        return obj;
    }

    private Object g()
    {
        c c1 = b;
        if (c1 == null)
        {
            return null;
        }
        c c2 = c1.b;
        Object obj = c1.a;
        c1.a = null;
        c1.b = c1;
        b = c2;
        if (c2 == null)
        {
            a = null;
        } else
        {
            c2.c = null;
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
        throws InterruptedException
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

    void a(c c1)
    {
        c c2 = c1.b;
        c c3 = c1.c;
        if (c2 == null)
        {
            f();
            return;
        }
        if (c3 == null)
        {
            g();
            return;
        } else
        {
            c2.c = c3;
            c3.b = c2;
            c1.a = null;
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
        throws InterruptedException
    {
        if (obj == null)
        {
            throw new NullPointerException();
        }
        obj = new c(obj);
        l = timeunit.toNanos(l);
        timeunit = c;
        timeunit.lockInterruptibly();
_L2:
        boolean flag = c(((c) (obj)));
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
        c c1;
        if (obj == null)
        {
            throw new NullPointerException();
        }
        c1 = new c(obj);
        obj = c;
        ((ReentrantLock) (obj)).lock();
        boolean flag = b(c1);
        ((ReentrantLock) (obj)).unlock();
        return flag;
        Exception exception;
        exception;
        ((ReentrantLock) (obj)).unlock();
        throw exception;
    }

    public Object c()
        throws InterruptedException
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
        c c1;
        if (obj == null)
        {
            throw new NullPointerException();
        }
        c1 = new c(obj);
        obj = c;
        ((ReentrantLock) (obj)).lock();
        boolean flag = c(c1);
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
        c c1 = a;
_L2:
        if (c1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        c c2;
        c1.a = null;
        c2 = c1.c;
        c1.b = null;
        c1.c = null;
        c1 = c2;
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
        c c1 = a;
_L2:
        if (c1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        boolean flag = obj.equals(c1.a);
        if (flag)
        {
            reentrantlock.unlock();
            return true;
        }
        c1 = c1.c;
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
        throws InterruptedException
    {
        c c1;
        if (obj == null)
        {
            throw new NullPointerException();
        }
        c1 = new c(obj);
        obj = c;
        ((ReentrantLock) (obj)).lock();
        for (; !c(c1); g.await()) { }
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
        c c1 = a;
_L2:
        if (c1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!obj.equals(c1.a))
        {
            break MISSING_BLOCK_LABEL_46;
        }
        a(c1);
        reentrantlock.unlock();
        return true;
        c1 = c1.c;
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
        return new b();
    }

    public boolean offer(Object obj)
    {
        return c(obj);
    }

    public boolean offer(Object obj, long l, TimeUnit timeunit)
        throws InterruptedException
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
        throws InterruptedException
    {
        return a(l, timeunit);
    }

    public void put(Object obj)
        throws InterruptedException
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
        throws InterruptedException
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
        c c1 = a;
_L2:
        if (c1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        aobj[i] = c1.a;
        c1 = c1.c;
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
        aobj1[i] = ((c) (aobj)).a;
        aobj = ((c) (aobj)).c;
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
        Object obj2 = ((c) (obj)).a;
        Object obj1;
        obj1 = obj2;
        if (obj2 == this)
        {
            obj1 = "(this Collection)";
        }
        stringbuilder.append(obj1);
        obj = ((c) (obj)).c;
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
