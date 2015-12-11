// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

// Referenced classes of package com.flurry.sdk:
//            dg, el, dl, es, 
//            dw

public class di
{

    private static final String a = com/flurry/sdk/di.getSimpleName();
    private static di b;
    private final Map c = new HashMap();
    private final Map d = new WeakHashMap();
    private final Object e = new Object();
    private dg f;

    private di()
    {
    }

    public static di a()
    {
        com/flurry/sdk/di;
        JVM INSTR monitorenter ;
        di di1;
        if (b == null)
        {
            b = new di();
        }
        di1 = b;
        com/flurry/sdk/di;
        JVM INSTR monitorexit ;
        return di1;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        dg dg1 = (dg)d.remove(context);
        if (dg1 != null) goto _L2; else goto _L1
_L1:
        el.d(a, (new StringBuilder()).append("Session cannot be ended, session not found for context: ").append(context).toString());
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        dg1.c(context);
        if (true) goto _L4; else goto _L3
_L3:
        context;
        throw context;
    }

    public void a(Context context, String s)
    {
        this;
        JVM INSTR monitorenter ;
        dg dg1;
        dl.a(context);
        es.a().b();
        dw.a().b();
        dg1 = (dg)d.get(context);
        if (dg1 == null) goto _L2; else goto _L1
_L1:
        el.d(a, (new StringBuilder()).append("Session already started with context: ").append(context).append(" count:").append(dg1.g()).toString());
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!c.containsKey(s))
        {
            break; /* Loop/switch isn't completed */
        }
        s = (dg)c.get(s);
_L5:
        d.put(context, s);
        a(((dg) (s)));
        s.b(context);
        if (true) goto _L4; else goto _L3
        context;
        throw context;
_L3:
        dg1 = new dg(s);
        c.put(s, dg1);
        dg1.a(context);
        s = dg1;
          goto _L5
    }

    public void a(dg dg1)
    {
        synchronized (e)
        {
            f = dg1;
        }
        return;
        dg1;
        obj;
        JVM INSTR monitorexit ;
        throw dg1;
    }

    public void a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (c.containsKey(s)) goto _L2; else goto _L1
_L1:
        el.a(6, a, "Ended session is not in the session map! Maybe it was already destroyed.");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        dg dg1 = c();
        if (dg1 == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        if (TextUtils.equals(dg1.j(), s))
        {
            a(((dg) (null)));
        }
        c.remove(s);
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public int b()
    {
        this;
        JVM INSTR monitorenter ;
        int i = d.size();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public dg c()
    {
        dg dg1;
        synchronized (e)
        {
            dg1 = f;
        }
        return dg1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void d()
    {
        this;
        JVM INSTR monitorenter ;
        java.util.Map.Entry entry;
        for (Iterator iterator = d.entrySet().iterator(); iterator.hasNext(); ((dg)entry.getValue()).c((Context)entry.getKey()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        break MISSING_BLOCK_LABEL_65;
        Exception exception;
        exception;
        throw exception;
        d.clear();
        for (Iterator iterator1 = (new ArrayList(c.values())).iterator(); iterator1.hasNext(); ((dg)iterator1.next()).c()) { }
        c.clear();
        a(((dg) (null)));
        this;
        JVM INSTR monitorexit ;
    }

}
