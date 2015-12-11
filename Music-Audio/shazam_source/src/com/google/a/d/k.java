// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.d;

import java.lang.reflect.Method;

// Referenced classes of package com.google.a.d:
//            f

final class k extends f
{

    public k(Object obj, Method method)
    {
        super(obj, method);
    }

    public final void a(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        super.a(obj);
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
    }
}
