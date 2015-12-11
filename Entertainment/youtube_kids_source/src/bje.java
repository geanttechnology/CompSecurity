// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class bje
{

    public static final Object a = new Object();
    private static final Map b = new HashMap();
    private final Executor c;
    private bmi d;
    private final Map e;
    private final Map f;
    private final ReadWriteLock g;

    private bje(Executor executor)
    {
        c = (Executor)b.a(executor);
        e = new HashMap();
        f = new HashMap();
        g = new ReentrantReadWriteLock();
    }

    public bje(Executor executor, bmi bmi1)
    {
        this(executor);
        d = (bmi)b.a(bmi1);
    }

    private bji a(Object obj, Class class1, Object obj1, bjh bjh)
    {
        obj1 = new bji(obj, class1, obj1, bjh);
        g.writeLock().lock();
        a.a(e, class1, obj1);
        a.a(f, new bmy(obj), obj1);
        g.writeLock().unlock();
        a(class1, new bjl(((bji) (obj1))), true);
        return ((bji) (obj1));
        obj;
        g.writeLock().unlock();
        throw obj;
    }

    private Set a(Class class1)
    {
        this;
        JVM INSTR monitorenter ;
        if (b.containsKey(class1)) goto _L2; else goto _L1
_L1:
        Method amethod[];
        int j;
        amethod = class1.getDeclaredMethods();
        j = amethod.length;
        int i = 0;
_L7:
        if (i >= j) goto _L2; else goto _L3
_L3:
        Method method = amethod[i];
        if (!method.isAnnotationPresent(bjm)) goto _L5; else goto _L4
_L4:
        Class class2;
        boolean flag;
        if (method.getParameterTypes().length == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.a(flag, "Event handler methods can only take a single event argument.");
        class2 = method.getParameterTypes()[0];
        a.a(b, class1, new bjg(class2, method));
          goto _L5
_L2:
        class1 = a.a(b, class1);
        this;
        JVM INSTR monitorexit ;
        return class1;
        class1;
        throw class1;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    static ReadWriteLock a(bje bje1)
    {
        return bje1.g;
    }

    private void a(Object obj, Object obj1, boolean flag)
    {
        boolean flag1;
        if (d != null && (obj1 instanceof bjn))
        {
            if (((bjn)obj1).a != 0L)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag1)
            {
                ((bjn)obj1).a(d.b());
            }
        }
        obj = new bjf(this, obj1, obj);
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1 && flag)
        {
            ((Runnable) (obj)).run();
            return;
        } else
        {
            c.execute(((Runnable) (obj)));
            return;
        }
    }

    private void a(Collection collection)
    {
        Object obj;
        obj = new HashMap();
        g.writeLock().lock();
        collection = collection.iterator();
_L4:
        bji bji1;
        Class class1;
        Object obj1;
        boolean flag;
        if (!collection.hasNext())
        {
            break MISSING_BLOCK_LABEL_153;
        }
        bji1 = (bji)collection.next();
        class1 = bji1.b;
        flag = a.b(e, class1, bji1);
        obj1 = bji1.a.get();
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        a.b(f, new bmy(obj1), bji1);
_L2:
        if (!flag) goto _L4; else goto _L3
_L3:
        if (e.containsKey(class1)) goto _L4; else goto _L5
_L5:
        ((Map) (obj)).put(class1, new bjk());
          goto _L4
        collection;
        g.writeLock().unlock();
        throw collection;
        g.writeLock().unlock();
        for (collection = ((Map) (obj)).entrySet().iterator(); collection.hasNext(); a(((java.util.Map.Entry) (obj)).getKey(), ((java.util.Map.Entry) (obj)).getValue(), true))
        {
            obj = (java.util.Map.Entry)collection.next();
        }

        return;
    }

    static Map b(bje bje1)
    {
        return bje1.e;
    }

    public final bji a(Object obj, Class class1, bjh bjh)
    {
        return a(obj, class1, a, bjh);
    }

    public final void a(Object obj)
    {
        a(obj, obj.getClass());
    }

    public final void a(Object obj, Class class1)
    {
        Object obj1;
        boolean flag;
        flag = true;
        obj1 = a;
        b.a(class1.isAssignableFrom(obj.getClass()), "clazz must be a superclass of target");
        g.writeLock().lock();
        Object obj2 = a(class1);
        if (((Set) (obj2)).isEmpty())
        {
            flag = false;
        }
        b.a(flag, String.format("Class %s does not contain any methods annotated with @Subscribe", new Object[] {
            class1.getSimpleName()
        }));
        for (class1 = ((Set) (obj2)).iterator(); class1.hasNext(); a(obj, ((bjg) (obj2)).a, obj1, ((bjh) (new bjj(obj, ((bjg) (obj2)).b)))))
        {
            obj2 = (bjg)class1.next();
        }

        break MISSING_BLOCK_LABEL_151;
        obj;
        g.writeLock().unlock();
        throw obj;
        g.writeLock().unlock();
        return;
    }

    public final transient void a(bji abji[])
    {
        a(((Collection) (Arrays.asList(abji))));
    }

    public final void b(Object obj)
    {
        g.writeLock().lock();
        a(Collections.unmodifiableSet(new HashSet(a.a(f, new bmy(obj)))));
        g.writeLock().unlock();
        return;
        obj;
        g.writeLock().unlock();
        throw obj;
    }

    public final void c(Object obj)
    {
        a(a, obj, true);
    }

    public final void d(Object obj)
    {
        a(a, obj, false);
    }

}
