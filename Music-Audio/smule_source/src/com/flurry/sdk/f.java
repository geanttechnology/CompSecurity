// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package com.flurry.sdk:
//            gd

public class f
{

    private static f a;
    private static final String b = com/flurry/sdk/f.getSimpleName();
    private final TreeMap c = new TreeMap();

    public f()
    {
    }

    public static f a()
    {
        com/flurry/sdk/f;
        JVM INSTR monitorenter ;
        f f1;
        if (a == null)
        {
            a = new f();
        }
        f1 = a;
        com/flurry/sdk/f;
        JVM INSTR monitorexit ;
        return f1;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(String s, int i)
    {
        TreeMap treemap = c;
        treemap;
        JVM INSTR monitorenter ;
        Integer integer;
        TreeMap treemap1;
        integer = (Integer)c.get(s);
        treemap1 = c;
        int j;
        j = i;
        if (integer == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        j = i + integer.intValue();
        treemap1.put(s, Integer.valueOf(j));
        treemap;
        JVM INSTR monitorexit ;
        return;
        s;
        treemap;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void b()
    {
        gd.a(3, b, "========== PRINT COUNTERS ==========");
        TreeMap treemap = c;
        treemap;
        JVM INSTR monitorenter ;
        java.util.Map.Entry entry;
        for (Iterator iterator = c.entrySet().iterator(); iterator.hasNext(); gd.a(3, b, (new StringBuilder()).append((String)entry.getKey()).append(" ").append(entry.getValue()).toString()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        break MISSING_BLOCK_LABEL_99;
        Exception exception;
        exception;
        treemap;
        JVM INSTR monitorexit ;
        throw exception;
        treemap;
        JVM INSTR monitorexit ;
        gd.a(3, b, "========== END PRINT COUNTERS ==========");
        return;
    }

}
