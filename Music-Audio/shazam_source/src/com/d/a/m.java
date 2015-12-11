// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.d.a:
//            z

final class m
{

    int a;
    private LinkedHashMap b;

    m()
    {
        a = 100;
        b = new z(this, (int)Math.ceil(133.33332824707031D) + 1);
    }

    final int a()
    {
        this;
        JVM INSTR monitorenter ;
        int i = b.size();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    final Object a(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        obj = b.get(obj);
        this;
        JVM INSTR monitorexit ;
        return obj;
        obj;
        throw obj;
    }

    final void a(Object obj, Object obj1)
    {
        this;
        JVM INSTR monitorenter ;
        b.put(obj, obj1);
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

    final List b()
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist = new ArrayList(b.entrySet());
        this;
        JVM INSTR monitorexit ;
        return arraylist;
        Exception exception;
        exception;
        throw exception;
    }

    final Set c()
    {
        this;
        JVM INSTR monitorenter ;
        Set set = b.keySet();
        this;
        JVM INSTR monitorexit ;
        return set;
        Exception exception;
        exception;
        throw exception;
    }
}
