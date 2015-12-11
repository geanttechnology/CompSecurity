// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a;

import com.a.a.b;
import com.a.a.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.a:
//            e

public final class d
{

    private final String a;
    private final String b;
    private String c;
    private final String d;
    private HashMap e;
    private HashMap f;

    public d(String s, String s1, String s2)
    {
        d = s;
        a = s1;
        b = s2;
        e = new HashMap();
        f = new HashMap();
    }

    public final String a()
    {
        return a;
    }

    public final void a(b b1, g g1)
    {
        this;
        JVM INSTR monitorenter ;
        f.put(b1, g1);
        this;
        JVM INSTR monitorexit ;
        return;
        b1;
        throw b1;
    }

    public final void a(e e1, String s)
    {
        this;
        JVM INSTR monitorenter ;
        e.put(e1, s);
        this;
        JVM INSTR monitorexit ;
        return;
        e1;
        throw e1;
    }

    public final void a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        c = s;
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public final String b()
    {
        return b;
    }

    public final String c()
    {
        return c;
    }

    public final String d()
    {
        this;
        JVM INSTR monitorenter ;
        String s = d;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public final HashMap e()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        obj = new HashMap();
        ((HashMap) (obj)).put(e.l.a(), a);
        ((HashMap) (obj)).put(e.m.a(), b);
        e e1;
        for (Iterator iterator = e.keySet().iterator(); iterator.hasNext(); ((HashMap) (obj)).put(e1.a(), e.get(e1)))
        {
            e1 = (e)iterator.next();
        }

        break MISSING_BLOCK_LABEL_97;
        obj;
        throw obj;
        StringBuilder stringbuilder;
        if (f.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_240;
        }
        stringbuilder = new StringBuilder("{");
        b b1;
        for (Iterator iterator1 = f.keySet().iterator(); iterator1.hasNext(); stringbuilder.append((new StringBuilder("\"")).append(b1.a()).append("\":\"").append(((g)f.get(b1)).a()).append("\", ").toString()))
        {
            b1 = (b)iterator1.next();
        }

        stringbuilder.replace(stringbuilder.length() - 2, stringbuilder.length() - 1, "}");
        ((HashMap) (obj)).put(e.k.a(), stringbuilder.toString());
        this;
        JVM INSTR monitorexit ;
        return ((HashMap) (obj));
    }
}
