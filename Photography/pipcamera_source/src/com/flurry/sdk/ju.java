// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            kg

public class ju
{

    private static ju a;
    private static final String b = com/flurry/sdk/ju.getSimpleName();
    private static final HashMap c = new HashMap();

    public ju()
    {
    }

    public static ju a()
    {
        com/flurry/sdk/ju;
        JVM INSTR monitorenter ;
        ju ju1;
        if (a == null)
        {
            a = new ju();
        }
        ju1 = a;
        com/flurry/sdk/ju;
        JVM INSTR monitorexit ;
        return ju1;
        Exception exception;
        exception;
        throw exception;
    }

    public static void b()
    {
        com/flurry/sdk/ju;
        JVM INSTR monitorenter ;
        a = null;
        com/flurry/sdk/ju;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(String s, String s1, Map map)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        obj = map;
        if (map != null)
        {
            break MISSING_BLOCK_LABEL_18;
        }
        obj = new HashMap();
        if (((Map) (obj)).size() < 10) goto _L2; else goto _L1
_L1:
        kg.e(b, (new StringBuilder()).append("MaxOriginParams exceeded: ").append(((Map) (obj)).size()).toString());
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        ((Map) (obj)).put("flurryOriginVersion", s1);
        synchronized (c)
        {
            if (c.size() < 10 || c.containsKey(s))
            {
                break MISSING_BLOCK_LABEL_147;
            }
            kg.e(b, (new StringBuilder()).append("MaxOrigins exceeded: ").append(c.size()).toString());
        }
          goto _L3
        s;
        s1;
        JVM INSTR monitorexit ;
        throw s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        c.put(s, obj);
        s1;
        JVM INSTR monitorexit ;
          goto _L3
    }

    public HashMap c()
    {
        this;
        JVM INSTR monitorenter ;
        HashMap hashmap1;
        synchronized (c)
        {
            hashmap1 = new HashMap(c);
        }
        this;
        JVM INSTR monitorexit ;
        return hashmap1;
        exception1;
        hashmap;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
