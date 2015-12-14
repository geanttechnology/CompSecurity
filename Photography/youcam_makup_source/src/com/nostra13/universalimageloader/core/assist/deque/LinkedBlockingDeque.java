// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.assist.deque;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.nostra13.universalimageloader.core.assist.deque:
//            a, e, d

public class LinkedBlockingDeque extends AbstractQueue
    implements a, Serializable
{

    private static final long serialVersionUID = 0xfa9ddc6ce257fe26L;
    transient e a;
    transient e b;
    private transient int c;
    private final int capacity;
    final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    public LinkedBlockingDeque()
    {
        this(0x7fffffff);
    }

    public LinkedBlockingDeque(int i)
    {
        lock = new ReentrantLock();
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
        if (i <= 0)
        {
            throw new IllegalArgumentException();
        } else
        {
            capacity = i;
            return;
        }
    }

    private boolean b(e e1)
    {
        if (c >= capacity)
        {
            return false;
        }
        e e2 = a;
        e1.c = e2;
        a = e1;
        if (b == null)
        {
            b = e1;
        } else
        {
            e2.b = e1;
        }
        c = c + 1;
        notEmpty.signal();
        return true;
    }

    private boolean c(e e1)
    {
        if (c >= capacity)
        {
            return false;
        }
        e e2 = b;
        e1.b = e2;
        b = e1;
        if (a == null)
        {
            a = e1;
        } else
        {
            e2.c = e1;
        }
        c = c + 1;
        notEmpty.signal();
        return true;
    }

    private Object f()
    {
        e e1 = a;
        if (e1 == null)
        {
            return null;
        }
        e e2 = e1.c;
        Object obj = e1.a;
        e1.a = null;
        e1.c = e1;
        a = e2;
        if (e2 == null)
        {
            b = null;
        } else
        {
            e2.b = null;
        }
        c = c - 1;
        notFull.signal();
        return obj;
    }

    private Object g()
    {
        e e1 = b;
        if (e1 == null)
        {
            return null;
        }
        e e2 = e1.b;
        Object obj = e1.a;
        e1.a = null;
        e1.b = e1;
        b = e2;
        if (e2 == null)
        {
            a = null;
        } else
        {
            e2.c = null;
        }
        c = c - 1;
        notFull.signal();
        return obj;
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        objectinputstream.defaultReadObject();
        c = 0;
        a = null;
        b = null;
        do
        {
            Object obj = objectinputstream.readObject();
            if (obj == null)
            {
                return;
            }
            add(obj);
        } while (true);
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        ReentrantLock reentrantlock;
        reentrantlock = lock;
        reentrantlock.lock();
        e e1;
        objectoutputstream.defaultWriteObject();
        e1 = a;
_L1:
        if (e1 == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        objectoutputstream.writeObject(e1.a);
        e1 = e1.c;
          goto _L1
        objectoutputstream.writeObject(null);
        reentrantlock.unlock();
        return;
        objectoutputstream;
        reentrantlock.unlock();
        throw objectoutputstream;
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
        timeunit = lock;
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
        l = notEmpty.awaitNanos(l);
        if (true) goto _L2; else goto _L1
_L1:
        timeunit.unlock();
        return obj;
        Exception exception;
        exception;
        timeunit.unlock();
        throw exception;
    }

    void a(e e1)
    {
        e e2 = e1.b;
        e e3 = e1.c;
        if (e2 == null)
        {
            f();
            return;
        }
        if (e3 == null)
        {
            g();
            return;
        } else
        {
            e2.c = e3;
            e3.b = e2;
            e1.a = null;
            c = c - 1;
            notFull.signal();
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
        obj = new e(obj);
        l = timeunit.toNanos(l);
        timeunit = lock;
        timeunit.lockInterruptibly();
_L2:
        boolean flag = c(((e) (obj)));
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        if (l <= 0L)
        {
            timeunit.unlock();
            return false;
        }
        l = notFull.awaitNanos(l);
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
        reentrantlock = lock;
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
        e e1;
        if (obj == null)
        {
            throw new NullPointerException();
        }
        e1 = new e(obj);
        obj = lock;
        ((ReentrantLock) (obj)).lock();
        boolean flag = b(e1);
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
        reentrantlock = lock;
        reentrantlock.lock();
_L1:
        Object obj = f();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        notEmpty.await();
          goto _L1
        obj;
        reentrantlock.unlock();
        throw obj;
        reentrantlock.unlock();
        return obj;
    }

    public boolean c(Object obj)
    {
        e e1;
        if (obj == null)
        {
            throw new NullPointerException();
        }
        e1 = new e(obj);
        obj = lock;
        ((ReentrantLock) (obj)).lock();
        boolean flag = c(e1);
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
        reentrantlock = lock;
        reentrantlock.lock();
        e e1 = a;
_L2:
        if (e1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        e e2;
        e1.a = null;
        e2 = e1.c;
        e1.b = null;
        e1.c = null;
        e1 = e2;
        if (true) goto _L2; else goto _L1
_L1:
        b = null;
        a = null;
        c = 0;
        notFull.signalAll();
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
        reentrantlock = lock;
        reentrantlock.lock();
        e e1 = a;
_L2:
        if (e1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        boolean flag = obj.equals(e1.a);
        if (flag)
        {
            reentrantlock.unlock();
            return true;
        }
        e1 = e1.c;
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
        e e1;
        if (obj == null)
        {
            throw new NullPointerException();
        }
        e1 = new e(obj);
        obj = lock;
        ((ReentrantLock) (obj)).lock();
        for (; !c(e1); notFull.await()) { }
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
        reentrantlock = lock;
        reentrantlock.lock();
        int j = Math.min(i, c);
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
        reentrantlock = lock;
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
        reentrantlock = lock;
        reentrantlock.lock();
        e e1 = a;
_L2:
        if (e1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!obj.equals(e1.a))
        {
            break MISSING_BLOCK_LABEL_46;
        }
        a(e1);
        reentrantlock.unlock();
        return true;
        e1 = e1.c;
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
        return new d(this);
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
        reentrantlock = lock;
        reentrantlock.lock();
        int i;
        int j;
        i = capacity;
        j = c;
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
        reentrantlock = lock;
        reentrantlock.lock();
        int i = c;
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
        reentrantlock = lock;
        reentrantlock.lock();
        Object aobj[] = new Object[c];
        int i = 0;
        e e1 = a;
_L2:
        if (e1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        aobj[i] = e1.a;
        e1 = e1.c;
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
        reentrantlock = lock;
        reentrantlock.lock();
        aobj1 = aobj;
        if (aobj.length < c)
        {
            aobj1 = (Object[])(Object[])Array.newInstance(((Object) (aobj)).getClass().getComponentType(), c);
        }
        int i = 0;
        aobj = a;
_L2:
        if (aobj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        aobj1[i] = ((e) (aobj)).a;
        aobj = ((e) (aobj)).c;
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
        reentrantlock = lock;
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
        Object obj2 = ((e) (obj)).a;
        Object obj1;
        obj1 = obj2;
        if (obj2 == this)
        {
            obj1 = "(this Collection)";
        }
        stringbuilder.append(obj1);
        obj = ((e) (obj)).c;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_95;
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
