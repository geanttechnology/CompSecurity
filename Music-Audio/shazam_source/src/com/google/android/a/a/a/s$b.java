// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.a.a.a;

import java.util.ArrayList;

// Referenced classes of package com.google.android.a.a.a:
//            s

protected abstract class a
{

    Object a;
    final s b;

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = a;
        this;
        JVM INSTR monitorexit ;
        a(obj);
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected abstract void a(Object obj);

    public (s s1, Object obj)
    {
        b = s.this;
        super();
        a = Object.this;
        synchronized (f)
        {
            f.add(this);
        }
        return;
        s1;
        Object.this;
        JVM INSTR monitorexit ;
        throw s.this;
    }
}
