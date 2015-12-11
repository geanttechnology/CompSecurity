// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

// Referenced classes of package android.support.v7:
//            akb, ake, aka, ajz, 
//            ajy

public class ajx
{
    static class a
    {

        final Object a;
        final ajz b;

        public a(Object obj, ajz ajz1)
        {
            a = obj;
            b = ajz1;
        }
    }


    private final ConcurrentMap a;
    private final ConcurrentMap b;
    private final String c;
    private final ake d;
    private final akb e;
    private final ThreadLocal f;
    private final ThreadLocal g;
    private final Map h;

    public ajx()
    {
        this("default");
    }

    public ajx(ake ake1, String s)
    {
        this(ake1, s, akb.a);
    }

    ajx(ake ake1, String s, akb akb1)
    {
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
        f = new ThreadLocal() {

            final ajx a;

            protected ConcurrentLinkedQueue a()
            {
                return new ConcurrentLinkedQueue();
            }

            protected Object initialValue()
            {
                return a();
            }

            
            {
                a = ajx.this;
                super();
            }
        };
        g = new ThreadLocal() {

            final ajx a;

            protected Boolean a()
            {
                return Boolean.valueOf(false);
            }

            protected Object initialValue()
            {
                return a();
            }

            
            {
                a = ajx.this;
                super();
            }
        };
        h = new HashMap();
        d = ake1;
        c = s;
        e = akb1;
    }

    public ajx(String s)
    {
        this(ake.b, s);
    }

    private void a(ajz ajz1, aka aka1)
    {
        Object obj = null;
        Object obj1 = aka1.c();
        aka1 = ((aka) (obj1));
_L1:
        InvocationTargetException invocationtargetexception;
        if (aka1 == null)
        {
            return;
        } else
        {
            b(aka1, ajz1);
            return;
        }
        invocationtargetexception;
        a((new StringBuilder()).append("Producer ").append(aka1).append(" threw an exception.").toString(), invocationtargetexception);
        aka1 = obj;
          goto _L1
    }

    private static void a(String s, InvocationTargetException invocationtargetexception)
    {
        Throwable throwable = invocationtargetexception.getCause();
        if (throwable != null)
        {
            throw new RuntimeException((new StringBuilder()).append(s).append(": ").append(throwable.getMessage()).toString(), throwable);
        } else
        {
            throw new RuntimeException((new StringBuilder()).append(s).append(": ").append(invocationtargetexception.getMessage()).toString(), invocationtargetexception);
        }
    }

    private Set d(Class class1)
    {
        LinkedList linkedlist = new LinkedList();
        HashSet hashset = new HashSet();
        linkedlist.add(class1);
        do
        {
            if (linkedlist.isEmpty())
            {
                break;
            }
            class1 = (Class)linkedlist.remove(0);
            hashset.add(class1);
            class1 = class1.getSuperclass();
            if (class1 != null)
            {
                linkedlist.add(class1);
            }
        } while (true);
        return hashset;
    }

    aka a(Class class1)
    {
        return (aka)b.get(class1);
    }

    protected void a()
    {
        if (((Boolean)g.get()).booleanValue())
        {
            return;
        }
        g.set(Boolean.valueOf(true));
_L2:
        a a1 = (a)((ConcurrentLinkedQueue)f.get()).poll();
        if (a1 == null)
        {
            g.set(Boolean.valueOf(false));
            return;
        }
        if (!a1.b.a()) goto _L2; else goto _L1
_L1:
        b(a1.a, a1.b);
          goto _L2
        Exception exception;
        exception;
        g.set(Boolean.valueOf(false));
        throw exception;
    }

    public void a(Object obj)
    {
        if (obj == null)
        {
            throw new NullPointerException("Event to post must not be null.");
        }
        d.a(this);
        Iterator iterator = c(obj.getClass()).iterator();
        boolean flag;
        boolean flag1;
label0:
        for (flag1 = false; iterator.hasNext(); flag1 = flag)
        {
            Object obj1 = b((Class)iterator.next());
            flag = flag1;
            if (obj1 == null)
            {
                continue;
            }
            flag = flag1;
            if (((Set) (obj1)).isEmpty())
            {
                continue;
            }
            flag1 = true;
            obj1 = ((Set) (obj1)).iterator();
            do
            {
                flag = flag1;
                if (!((Iterator) (obj1)).hasNext())
                {
                    continue label0;
                }
                a(obj, (ajz)((Iterator) (obj1)).next());
            } while (true);
        }

        if (!flag1 && !(obj instanceof ajy))
        {
            a(new ajy(this, obj));
        }
        a();
    }

    protected void a(Object obj, ajz ajz1)
    {
        ((ConcurrentLinkedQueue)f.get()).offer(new a(obj, ajz1));
    }

    Set b(Class class1)
    {
        return (Set)a.get(class1);
    }

    public void b(Object obj)
    {
        if (obj == null)
        {
            throw new NullPointerException("Object to register must not be null.");
        }
        d.a(this);
        Map map = e.a(obj);
        Iterator iterator = map.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj3 = (Class)iterator.next();
            aka aka1 = (aka)map.get(obj3);
            aka aka2 = (aka)b.putIfAbsent(obj3, aka1);
            if (aka2 != null)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Producer method for type ").append(obj3).append(" found on type ").append(aka1.a.getClass()).append(", but already registered by type ").append(aka2.a.getClass()).append(".").toString());
            }
            obj3 = (Set)a.get(obj3);
            if (obj3 != null && !((Set) (obj3)).isEmpty())
            {
                obj3 = ((Set) (obj3)).iterator();
                while (((Iterator) (obj3)).hasNext()) 
                {
                    a((ajz)((Iterator) (obj3)).next(), aka1);
                }
            }
        } while (true);
        Map map1 = e.b(obj);
        for (Iterator iterator1 = map1.keySet().iterator(); iterator1.hasNext();)
        {
            Class class1 = (Class)iterator1.next();
            Set set = (Set)a.get(class1);
            obj = set;
            if (set == null)
            {
                CopyOnWriteArraySet copyonwritearrayset = new CopyOnWriteArraySet();
                Set set1 = (Set)a.putIfAbsent(class1, copyonwritearrayset);
                obj = set1;
                if (set1 == null)
                {
                    obj = copyonwritearrayset;
                }
            }
            if (!((Set) (obj)).addAll((Set)map1.get(class1)))
            {
                throw new IllegalArgumentException("Object already registered.");
            }
        }

        obj = map1.entrySet().iterator();
_L2:
        Object obj1;
        Object obj2;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_501;
            }
            obj2 = (java.util.Map.Entry)((Iterator) (obj)).next();
            obj1 = (Class)((java.util.Map.Entry) (obj2)).getKey();
            obj1 = (aka)b.get(obj1);
        } while (obj1 == null || !((aka) (obj1)).a());
        obj2 = ((Set)((java.util.Map.Entry) (obj2)).getValue()).iterator();
_L4:
        if (!((Iterator) (obj2)).hasNext()) goto _L2; else goto _L1
_L1:
        ajz ajz1 = (ajz)((Iterator) (obj2)).next();
        if (!((aka) (obj1)).a()) goto _L2; else goto _L3
_L3:
        if (ajz1.a())
        {
            a(ajz1, ((aka) (obj1)));
        }
          goto _L4
    }

    protected void b(Object obj, ajz ajz1)
    {
        try
        {
            ajz1.a(obj);
            return;
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            a((new StringBuilder()).append("Could not dispatch event: ").append(obj.getClass()).append(" to handler ").append(ajz1).toString(), invocationtargetexception);
        }
    }

    Set c(Class class1)
    {
        Set set1 = (Set)h.get(class1);
        Set set = set1;
        if (set1 == null)
        {
            set = d(class1);
            h.put(class1, set);
        }
        return set;
    }

    public void c(Object obj)
    {
        if (obj == null)
        {
            throw new NullPointerException("Object to unregister must not be null.");
        }
        d.a(this);
        Class class1;
        for (Iterator iterator = e.a(obj).entrySet().iterator(); iterator.hasNext(); ((aka)b.remove(class1)).b())
        {
            Object obj2 = (java.util.Map.Entry)iterator.next();
            class1 = (Class)((java.util.Map.Entry) (obj2)).getKey();
            aka aka1 = a(class1);
            obj2 = (aka)((java.util.Map.Entry) (obj2)).getValue();
            if (obj2 == null || !((aka) (obj2)).equals(aka1))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Missing event producer for an annotated method. Is ").append(obj.getClass()).append(" registered?").toString());
            }
        }

        Set set;
        Object obj1;
label0:
        for (Iterator iterator1 = e.b(obj).entrySet().iterator(); iterator1.hasNext(); set.removeAll(((Collection) (obj1))))
        {
            obj1 = (java.util.Map.Entry)iterator1.next();
            set = b((Class)((java.util.Map.Entry) (obj1)).getKey());
            obj1 = (Collection)((java.util.Map.Entry) (obj1)).getValue();
            if (set == null || !set.containsAll(((Collection) (obj1))))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Missing event handler for an annotated method. Is ").append(obj.getClass()).append(" registered?").toString());
            }
            Iterator iterator2 = set.iterator();
            do
            {
                if (!iterator2.hasNext())
                {
                    continue label0;
                }
                ajz ajz1 = (ajz)iterator2.next();
                if (((Collection) (obj1)).contains(ajz1))
                {
                    ajz1.b();
                }
            } while (true);
        }

    }

    public String toString()
    {
        return (new StringBuilder()).append("[Bus \"").append(c).append("\"]").toString();
    }
}
