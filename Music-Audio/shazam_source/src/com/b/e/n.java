// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.e;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.b.e:
//            w

public final class n
{

    protected SharedPreferences a;
    protected final HashMap b;
    protected final HashSet c;
    protected final Object d;
    protected final Object e;
    protected long f;
    protected boolean g;
    private final Runnable h;

    public n(Context context)
    {
        this(context, "cSPrefs");
    }

    private n(Context context, String s)
    {
        b = new HashMap();
        c = new HashSet();
        d = new Object();
        e = new Object();
        f = -1L;
        g = false;
        h = new w(this);
        a(context, s);
    }

    private void a(Context context, String s)
    {
        Object obj = e;
        obj;
        JVM INSTR monitorenter ;
        Object obj1 = d;
        obj1;
        JVM INSTR monitorenter ;
        a = context.getSharedPreferences(s, 0);
        context = a.getAll().entrySet().iterator();
        do
        {
            if (!context.hasNext())
            {
                break;
            }
            s = (java.util.Map.Entry)context.next();
            if (s.getValue() instanceof String)
            {
                b.put(s.getKey(), (String)s.getValue());
            }
        } while (true);
        break MISSING_BLOCK_LABEL_114;
        context;
        obj1;
        JVM INSTR monitorexit ;
        throw context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
        g = true;
        obj1;
        JVM INSTR monitorexit ;
        obj;
        JVM INSTR monitorexit ;
    }

    private void d()
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        if (g)
        {
            if (f >= 0L)
            {
                break MISSING_BLOCK_LABEL_51;
            }
            f = System.currentTimeMillis() + 300L;
            (new Thread(h)).start();
        }
_L2:
        return;
        f = System.currentTimeMillis() + 300L;
        d.notify();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final Boolean a(String s)
    {
        synchronized (e)
        {
            if (g)
            {
                boolean flag = b.containsKey(s);
                return Boolean.valueOf(flag);
            }
        }
        return Boolean.valueOf(false);
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    protected final void a()
    {
_L2:
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        long l = f - System.currentTimeMillis();
        if (l > 0L)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        try
        {
            d.wait(l);
        }
        catch (InterruptedException interruptedexception) { }
        obj;
        JVM INSTR monitorexit ;
        if (true) goto _L2; else goto _L1
_L1:
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a(String s, String s1)
    {
        Object obj = e;
        obj;
        JVM INSTR monitorenter ;
        String s2;
        if (!g)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        s2 = (String)b.get(s);
        if (!b.containsKey(s))
        {
            break MISSING_BLOCK_LABEL_62;
        }
        if (s2 == s1)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        if (s1 == null || s2 == null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        if (s2.equals(s1))
        {
            break MISSING_BLOCK_LABEL_85;
        }
        b.put(s, s1);
        c.add(s);
        d();
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public final String b(String s)
    {
        Object obj = e;
        obj;
        JVM INSTR monitorenter ;
        if (!g || !a(s).booleanValue())
        {
            break MISSING_BLOCK_LABEL_41;
        }
        s = (String)b.get(s);
        return s;
        obj;
        JVM INSTR monitorexit ;
        return "";
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    protected final void b()
    {
        Object obj = e;
        obj;
        JVM INSTR monitorenter ;
        synchronized (d)
        {
            f = -1L;
        }
        Iterator iterator;
        obj1 = a.edit();
        iterator = c.iterator();
_L1:
        String s;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_119;
            }
            s = (String)iterator.next();
            if (!b.containsKey(s))
            {
                break MISSING_BLOCK_LABEL_107;
            }
            ((android.content.SharedPreferences.Editor) (obj1)).putString(s, (String)b.get(s));
        } while (true);
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
        ((android.content.SharedPreferences.Editor) (obj1)).remove(s);
          goto _L1
        ((android.content.SharedPreferences.Editor) (obj1)).commit();
        c.clear();
        obj;
        JVM INSTR monitorexit ;
    }

    public final void c()
    {
        Object obj = e;
        obj;
        JVM INSTR monitorenter ;
        g = false;
_L1:
        long l = f;
        Exception exception;
label0:
        {
            if (l < 0L)
            {
                break label0;
            }
            try
            {
                e.wait(100L);
            }
            catch (InterruptedException interruptedexception) { }
            finally { }
        }
          goto _L1
        obj;
        JVM INSTR monitorexit ;
        return;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void c(String s)
    {
        synchronized (e)
        {
            if (g && a(s).booleanValue())
            {
                b.remove(s);
                c.add(s);
                d();
            }
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }
}
