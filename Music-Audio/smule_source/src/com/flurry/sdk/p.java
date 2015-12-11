// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

// Referenced classes of package com.flurry.sdk:
//            fu, r

public class p
{

    private final SparseArray a = new SparseArray();
    private final fu b = new fu(new WeakHashMap());

    public p()
    {
    }

    public r a(int i)
    {
        this;
        JVM INSTR monitorenter ;
        r r1 = (r)a.get(i);
        this;
        JVM INSTR monitorexit ;
        return r1;
        Exception exception;
        exception;
        throw exception;
    }

    public List a(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        if (context != null) goto _L2; else goto _L1
_L1:
        context = Collections.emptyList();
_L4:
        this;
        JVM INSTR monitorexit ;
        return context;
_L2:
        context = new ArrayList(b.a(context));
        if (true) goto _L4; else goto _L3
_L3:
        context;
        throw context;
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = b.d().iterator(); iterator.hasNext(); ((r)iterator.next()).m()) { }
        break MISSING_BLOCK_LABEL_46;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public void a(Context context, r r1)
    {
        this;
        JVM INSTR monitorenter ;
        if (context != null && r1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        a.put(r1.d(), r1);
        b.a(context, r1);
        if (true) goto _L1; else goto _L3
_L3:
        context;
        throw context;
    }

    public void b(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        if (context != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        context = b.a(context).iterator();
        while (context.hasNext()) 
        {
            ((r)context.next()).b();
        }
        if (true) goto _L1; else goto _L3
_L3:
        context;
        throw context;
    }

    public boolean b(Context context, r r1)
    {
        this;
        JVM INSTR monitorenter ;
        if (context != null && r1 != null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        a.remove(r1.d());
        flag = b.b(context, r1);
        if (true) goto _L4; else goto _L3
_L3:
        context;
        throw context;
    }

    public void c(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        if (context != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        context = b.a(context).iterator();
        while (context.hasNext()) 
        {
            ((r)context.next()).c();
        }
        if (true) goto _L1; else goto _L3
_L3:
        context;
        throw context;
    }

    public void d(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        if (context != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        context = a(context).iterator();
        while (context.hasNext()) 
        {
            ((r)context.next()).a();
        }
        if (true) goto _L1; else goto _L3
_L3:
        context;
        throw context;
    }
}
