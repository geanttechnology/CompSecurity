// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a;

import com.g.b.z;
import java.util.LinkedHashSet;
import java.util.Set;

public final class j
{

    private final Set a = new LinkedHashSet();

    public j()
    {
    }

    public final void a(z z)
    {
        this;
        JVM INSTR monitorenter ;
        a.add(z);
        this;
        JVM INSTR monitorexit ;
        return;
        z;
        throw z;
    }

    public final void b(z z)
    {
        this;
        JVM INSTR monitorenter ;
        a.remove(z);
        this;
        JVM INSTR monitorexit ;
        return;
        z;
        throw z;
    }

    public final boolean c(z z)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a.contains(z);
        this;
        JVM INSTR monitorexit ;
        return flag;
        z;
        throw z;
    }
}
