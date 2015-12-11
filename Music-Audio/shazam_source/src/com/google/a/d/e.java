// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.d;

import com.google.a.a.g;
import com.google.a.a.m;
import com.google.a.b.b;
import com.google.a.b.c;
import com.google.a.c.ar;
import com.google.a.c.bd;
import com.google.a.c.v;
import com.google.a.g.a.q;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.google.a.d:
//            b, i, f, h, 
//            d, j

public class e
{
    static final class a
    {

        final Object a;
        final f b;

        public a(Object obj, f f1)
        {
            a = g.a(obj);
            b = (f)g.a(f1);
        }
    }

    private static final class b
        implements i
    {

        private final Logger a;

        public final void handleException(Throwable throwable, h h1)
        {
            Logger logger = a;
            Level level = Level.SEVERE;
            String s = String.valueOf(String.valueOf(h1.a));
            h1 = String.valueOf(String.valueOf(h1.b));
            logger.log(level, (new StringBuilder(s.length() + 30 + h1.length())).append("Could not dispatch event: ").append(s).append(" to ").append(h1).toString(), throwable.getCause());
        }

        public b(String s)
        {
            String s1 = String.valueOf(String.valueOf(com/google/a/d/e.getName()));
            s = String.valueOf(String.valueOf((String)g.a(s)));
            a = Logger.getLogger((new StringBuilder(s1.length() + 1 + s.length())).append(s1).append(".").append(s).toString());
        }
    }


    private static final com.google.a.b.e flattenHierarchyCache = com.google.a.b.b.a().b().a(new c() {

        public final Object a(Object obj)
        {
            return com.google.a.f.c.a((Class)obj).b().d();
        }

    });
    private final ThreadLocal eventsToDispatch;
    private final j finder;
    private final ThreadLocal isDispatching;
    private i subscriberExceptionHandler;
    private final bd subscribersByType;
    private final ReadWriteLock subscribersByTypeLock;

    public e()
    {
        this("default");
    }

    public e(i k)
    {
        subscribersByType = v.l();
        subscribersByTypeLock = new ReentrantReadWriteLock();
        finder = new com.google.a.d.b();
        eventsToDispatch = new ThreadLocal() {

            final e a;

            protected final Object initialValue()
            {
                return new LinkedList();
            }

            
            {
                a = e.this;
                super();
            }
        };
        isDispatching = new ThreadLocal() {

            final e a;

            protected final Object initialValue()
            {
                return Boolean.valueOf(false);
            }

            
            {
                a = e.this;
                super();
            }
        };
        subscriberExceptionHandler = (i)g.a(k);
    }

    public e(String s)
    {
        this(((i) (new b(s))));
    }

    void dispatch(Object obj, f f1)
    {
        try
        {
            f1.a(obj);
            return;
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            try
            {
                subscriberExceptionHandler.handleException(invocationtargetexception.getCause(), new h(this, obj, f1.a, f1.b));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Logger.getLogger(com/google/a/d/e.getName()).log(Level.SEVERE, String.format("Exception %s thrown while handling exception: %s", new Object[] {
                    obj, invocationtargetexception.getCause()
                }), ((Throwable) (obj)));
            }
        }
    }

    void dispatchQueuedEvents()
    {
        if (((Boolean)isDispatching.get()).booleanValue())
        {
            return;
        }
        isDispatching.set(Boolean.valueOf(true));
        Queue queue = (Queue)eventsToDispatch.get();
_L1:
        a a1 = (a)queue.poll();
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        dispatch(a1.a, a1.b);
          goto _L1
        Exception exception;
        exception;
        isDispatching.remove();
        eventsToDispatch.remove();
        throw exception;
        isDispatching.remove();
        eventsToDispatch.remove();
        return;
    }

    void enqueueEvent(Object obj, f f1)
    {
        ((Queue)eventsToDispatch.get()).offer(new a(obj, f1));
    }

    Set flattenHierarchy(Class class1)
    {
        try
        {
            class1 = (Set)flattenHierarchyCache.b(class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw m.a(class1.getCause());
        }
        return class1;
    }

    public void post(Object obj)
    {
        Iterator iterator;
        boolean flag;
        iterator = flattenHierarchy(obj.getClass()).iterator();
        flag = false;
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj1;
        obj1 = (Class)iterator.next();
        subscribersByTypeLock.readLock().lock();
        obj1 = subscribersByType.b(obj1);
        if (((Set) (obj1)).isEmpty())
        {
            continue; /* Loop/switch isn't completed */
        }
        boolean flag1 = true;
        obj1 = ((Set) (obj1)).iterator();
_L4:
        flag = flag1;
        if (!((Iterator) (obj1)).hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        enqueueEvent(obj, (f)((Iterator) (obj1)).next());
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        subscribersByTypeLock.readLock().unlock();
        throw obj;
        subscribersByTypeLock.readLock().unlock();
          goto _L5
_L2:
        if (!flag && !(obj instanceof d))
        {
            post(new d(this, obj));
        }
        dispatchQueuedEvents();
        return;
    }

    public void register(Object obj)
    {
        obj = finder.a(obj);
        subscribersByTypeLock.writeLock().lock();
        subscribersByType.a(((ar) (obj)));
        subscribersByTypeLock.writeLock().unlock();
        return;
        obj;
        subscribersByTypeLock.writeLock().unlock();
        throw obj;
    }

    public void unregister(Object obj)
    {
        Iterator iterator = finder.a(obj).i().entrySet().iterator();
_L2:
        Object obj1;
        Object obj2;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = (java.util.Map.Entry)iterator.next();
        obj1 = (Class)((java.util.Map.Entry) (obj2)).getKey();
        obj2 = (Collection)((java.util.Map.Entry) (obj2)).getValue();
        subscribersByTypeLock.writeLock().lock();
        obj1 = subscribersByType.b(obj1);
        if (!((Set) (obj1)).containsAll(((Collection) (obj2))))
        {
            obj = String.valueOf(String.valueOf(obj));
            throw new IllegalArgumentException((new StringBuilder(((String) (obj)).length() + 65)).append("missing event subscriber for an annotated method. Is ").append(((String) (obj))).append(" registered?").toString());
        }
        break MISSING_BLOCK_LABEL_171;
        obj;
        subscribersByTypeLock.writeLock().unlock();
        throw obj;
        ((Set) (obj1)).removeAll(((Collection) (obj2)));
        subscribersByTypeLock.writeLock().unlock();
        if (true) goto _L2; else goto _L1
_L1:
    }

}
