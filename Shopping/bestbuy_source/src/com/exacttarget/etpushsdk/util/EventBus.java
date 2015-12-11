// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.exacttarget.etpushsdk.util:
//            m

public class EventBus
{

    private static final EventBus a = new EventBus();
    private List b;
    private Map c;
    private Map d;

    private EventBus()
    {
        b = new ArrayList();
        c = new HashMap();
        d = new HashMap();
    }

    public static EventBus getDefault()
    {
        return getInstance();
    }

    public static EventBus getInstance()
    {
        return a;
    }

    public Object a(Class class1)
    {
        return d.get(class1.getName());
    }

    public void a(Object obj)
    {
        if (obj == null)
        {
            m.c("~!EventBus", "Null Object passed to EventBus.post()");
            return;
        }
        m.a("~!EventBus", String.format("post(%s event)", new Object[] {
            obj.getClass().getSimpleName()
        }));
        "~!EventBus";
        JVM INSTR monitorenter ;
        Object obj1 = (List)c.get(obj.getClass().getName());
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_183;
        }
        obj1 = ((List) (obj1)).iterator();
_L1:
        a a1;
        if (!((Iterator) (obj1)).hasNext())
        {
            break MISSING_BLOCK_LABEL_183;
        }
        a1 = (a)((Iterator) (obj1)).next();
        m.a("~!EventBus", String.format("Invoking %s.%s() with %s", new Object[] {
            a1.a.getClass().getName(), a1.b.getName(), obj.getClass().getSimpleName()
        }));
        a1.b.invoke(a1.a, new Object[] {
            obj
        });
          goto _L1
        Throwable throwable;
        throwable;
        m.c("~!EventBus", throwable.getMessage(), throwable);
          goto _L1
        obj;
        "~!EventBus";
        JVM INSTR monitorexit ;
        throw obj;
        "~!EventBus";
        JVM INSTR monitorexit ;
    }

    public void b(Object obj)
    {
        if (obj == null)
        {
            m.c("~!EventBus", "Null Object passed to EventBus.postSticky()");
            return;
        } else
        {
            m.a("~!EventBus", String.format("postSticky(%s event)", new Object[] {
                obj.getClass().getSimpleName()
            }));
            a(obj);
            d.put(obj.getClass().getName(), obj);
            return;
        }
    }

    public void register(Object obj)
    {
        m.a("~!EventBus", String.format("Registering %s with ET EventBus", new Object[] {
            obj.getClass().getCanonicalName()
        }));
        "~!EventBus";
        JVM INSTR monitorenter ;
        if (b.contains(obj)) goto _L2; else goto _L1
_L1:
        Method amethod[];
        int j;
        b.add(obj);
        amethod = obj.getClass().getMethods();
        j = amethod.length;
        int i = 0;
_L3:
        Method method;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        method = amethod[i];
        String s;
        Object obj1;
        if (!method.getName().startsWith("onEvent"))
        {
            break MISSING_BLOCK_LABEL_251;
        }
        s = method.getParameterTypes()[0].getName();
        if (!c.containsKey(s))
        {
            c.put(s, new ArrayList());
        }
        ((List)c.get(s)).add(new a(obj, method, null));
        if (!d.containsKey(s))
        {
            break MISSING_BLOCK_LABEL_251;
        }
        obj1 = d.get(s);
        m.a("~!EventBus", String.format("Invoking %s.%s() with %s", new Object[] {
            obj.getClass().getName(), method.getName(), s.getClass().getSimpleName()
        }));
        method.invoke(obj, new Object[] {
            obj1
        });
_L4:
        i++;
        if (true) goto _L3; else goto _L2
        Throwable throwable;
        throwable;
        m.c("~!EventBus", throwable.getMessage(), throwable);
          goto _L4
        obj;
        "~!EventBus";
        JVM INSTR monitorexit ;
        throw obj;
_L2:
        "~!EventBus";
        JVM INSTR monitorexit ;
    }

    public void unregister(Object obj)
    {
        m.a("~!EventBus", String.format("Unregistering %s with ET EventBus", new Object[] {
            obj.getClass().getCanonicalName()
        }));
        "~!EventBus";
        JVM INSTR monitorenter ;
        if (!b.contains(obj)) goto _L2; else goto _L1
_L1:
        Method amethod[];
        int j;
        b.remove(obj);
        amethod = obj.getClass().getMethods();
        j = amethod.length;
        int i = 0;
_L6:
        if (i >= j) goto _L2; else goto _L3
_L3:
        Object obj1 = amethod[i];
        ArrayList arraylist;
        if (((Method) (obj1)).getName().startsWith("onEvent"))
        {
            obj1 = ((Method) (obj1)).getParameterTypes()[0].getName();
            if (c.containsKey(obj1))
            {
                obj1 = (List)c.get(obj1);
                arraylist = new ArrayList();
                Iterator iterator = ((List) (obj1)).iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    a a1 = (a)iterator.next();
                    if (a1.a.equals(obj))
                    {
                        arraylist.add(a1);
                    }
                } while (true);
                break MISSING_BLOCK_LABEL_198;
            }
        }
          goto _L4
        obj;
        "~!EventBus";
        JVM INSTR monitorexit ;
        throw obj;
        ((List) (obj1)).removeAll(arraylist);
          goto _L4
_L2:
        "~!EventBus";
        JVM INSTR monitorexit ;
        return;
_L4:
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }


    private class a
    {

        public Object a;
        public Method b;
        final EventBus c;

        private a(Object obj, Method method)
        {
            c = EventBus.this;
            super();
            a = obj;
            b = method;
        }

        a(Object obj, Method method, _cls1 _pcls1)
        {
            this(obj, method);
        }
    }

}
