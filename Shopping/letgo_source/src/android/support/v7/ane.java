// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package android.support.v7:
//            and

public class ane extends PriorityBlockingQueue
{

    final Queue a = new LinkedList();
    private final ReentrantLock b = new ReentrantLock();

    public ane()
    {
    }

    public and a()
        throws InterruptedException
    {
        return b(0, null, null);
    }

    and a(int i, Long long1, TimeUnit timeunit)
        throws InterruptedException
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return (and)super.take();

        case 1: // '\001'
            return (and)super.peek();

        case 2: // '\002'
            return (and)super.poll();

        case 3: // '\003'
            return (and)super.poll(long1.longValue(), timeunit);
        }
    }

    public and a(long l, TimeUnit timeunit)
        throws InterruptedException
    {
        return b(3, Long.valueOf(l), timeunit);
    }

    boolean a(int i, and and1)
    {
        b.lock();
        if (i != 1)
        {
            break MISSING_BLOCK_LABEL_18;
        }
        super.remove(and1);
        boolean flag = a.offer(and1);
        b.unlock();
        return flag;
        and1;
        b.unlock();
        throw and1;
    }

    boolean a(and and1)
    {
        return and1.areDependenciesMet();
    }

    Object[] a(Object aobj[], Object aobj1[])
    {
        int i = aobj.length;
        int j = aobj1.length;
        Object aobj2[] = (Object[])(Object[])Array.newInstance(((Object) (aobj)).getClass().getComponentType(), i + j);
        System.arraycopy(((Object) (aobj)), 0, ((Object) (aobj2)), 0, i);
        System.arraycopy(((Object) (aobj1)), 0, ((Object) (aobj2)), i, j);
        return aobj2;
    }

    public and b()
    {
        and and1;
        try
        {
            and1 = b(1, null, null);
        }
        catch (InterruptedException interruptedexception)
        {
            return null;
        }
        return and1;
    }

    and b(int i, Long long1, TimeUnit timeunit)
        throws InterruptedException
    {
        do
        {
            and and1 = a(i, long1, timeunit);
            if (and1 == null || a(and1))
            {
                return and1;
            }
            a(i, and1);
        } while (true);
    }

    public and c()
    {
        and and1;
        try
        {
            and1 = b(2, null, null);
        }
        catch (InterruptedException interruptedexception)
        {
            return null;
        }
        return and1;
    }

    public void clear()
    {
        b.lock();
        a.clear();
        super.clear();
        b.unlock();
        return;
        Exception exception;
        exception;
        b.unlock();
        throw exception;
    }

    public boolean contains(Object obj)
    {
        b.lock();
        if (super.contains(obj)) goto _L2; else goto _L1
_L1:
        boolean flag = a.contains(obj);
        if (!flag) goto _L3; else goto _L2
_L2:
        flag = true;
_L5:
        b.unlock();
        return flag;
_L3:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        obj;
        b.unlock();
        throw obj;
    }

    public void d()
    {
        b.lock();
        Iterator iterator = a.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            and and1 = (and)iterator.next();
            if (a(and1))
            {
                super.offer(and1);
                iterator.remove();
            }
        } while (true);
        break MISSING_BLOCK_LABEL_69;
        Exception exception;
        exception;
        b.unlock();
        throw exception;
        b.unlock();
        return;
    }

    public int drainTo(Collection collection)
    {
        int i;
        int j;
        b.lock();
        i = super.drainTo(collection);
        j = a.size();
        for (; !a.isEmpty(); collection.add(a.poll())) { }
        break MISSING_BLOCK_LABEL_64;
        collection;
        b.unlock();
        throw collection;
        b.unlock();
        return i + j;
    }

    public int drainTo(Collection collection, int i)
    {
        int j;
        b.lock();
        j = super.drainTo(collection, i);
_L2:
        if (a.isEmpty() || j > i)
        {
            break; /* Loop/switch isn't completed */
        }
        collection.add(a.poll());
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        b.unlock();
        return j;
        collection;
        b.unlock();
        throw collection;
    }

    public Object peek()
    {
        return b();
    }

    public Object poll()
    {
        return c();
    }

    public Object poll(long l, TimeUnit timeunit)
        throws InterruptedException
    {
        return a(l, timeunit);
    }

    public boolean remove(Object obj)
    {
        b.lock();
        if (super.remove(obj)) goto _L2; else goto _L1
_L1:
        boolean flag = a.remove(obj);
        if (!flag) goto _L3; else goto _L2
_L2:
        flag = true;
_L5:
        b.unlock();
        return flag;
_L3:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        obj;
        b.unlock();
        throw obj;
    }

    public boolean removeAll(Collection collection)
    {
        boolean flag;
        boolean flag1;
        b.lock();
        flag = super.removeAll(collection);
        flag1 = a.removeAll(collection);
        b.unlock();
        return flag | flag1;
        collection;
        b.unlock();
        throw collection;
    }

    public int size()
    {
        int i;
        int j;
        b.lock();
        i = a.size();
        j = super.size();
        b.unlock();
        return i + j;
        Exception exception;
        exception;
        b.unlock();
        throw exception;
    }

    public Object take()
        throws InterruptedException
    {
        return a();
    }

    public Object[] toArray()
    {
        Object aobj[];
        b.lock();
        aobj = a(super.toArray(), a.toArray());
        b.unlock();
        return aobj;
        Exception exception;
        exception;
        b.unlock();
        throw exception;
    }

    public Object[] toArray(Object aobj[])
    {
        b.lock();
        aobj = a(super.toArray(aobj), a.toArray(aobj));
        b.unlock();
        return aobj;
        aobj;
        b.unlock();
        throw aobj;
    }
}
