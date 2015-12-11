// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            fu, u

public class v
{

    private final SparseArray a = new SparseArray();
    private final fu b = new fu();

    public v()
    {
    }

    public u a(int i)
    {
        this;
        JVM INSTR monitorenter ;
        u u1 = (u)a.get(i);
        this;
        JVM INSTR monitorexit ;
        return u1;
        Exception exception;
        exception;
        throw exception;
    }

    public u a(Context context, String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (context == null) goto _L2; else goto _L1
_L1:
        boolean flag = TextUtils.isEmpty(s);
        if (!flag) goto _L3; else goto _L2
_L2:
        Object obj = null;
_L5:
        this;
        JVM INSTR monitorexit ;
        return ((u) (obj));
_L3:
        Iterator iterator = b.a(s).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_107;
            }
            obj = (u)iterator.next();
        } while (!context.equals(((u) (obj)).e()));
        context = ((Context) (obj));
_L6:
        obj = context;
        if (context == null) goto _L5; else goto _L4
_L4:
        b.b(s, context);
        b.a(s, context);
        obj = context;
          goto _L5
        context;
        throw context;
        context = null;
          goto _L6
    }

    public u a(String s)
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        boolean flag = TextUtils.isEmpty(s);
        if (!flag) goto _L2; else goto _L1
_L1:
        s = obj;
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        List list = b.a(s);
        s = obj;
        if (!list.isEmpty())
        {
            s = (u)list.get(list.size() - 1);
        }
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = b.d().iterator(); iterator.hasNext(); ((u)iterator.next()).m()) { }
        break MISSING_BLOCK_LABEL_44;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public void a(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        if (context != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Iterator iterator = b.d().iterator();
        while (iterator.hasNext()) 
        {
            u u1 = (u)iterator.next();
            if (context.equals(u1.e()))
            {
                u1.b();
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        context;
        throw context;
    }

    public void a(Context context, String s, u u1)
    {
        this;
        JVM INSTR monitorenter ;
        if (context == null) goto _L2; else goto _L1
_L1:
        boolean flag = TextUtils.isEmpty(s);
        if (!flag && u1 != null) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        a.put(u1.d(), u1);
        b.a(s, u1);
        if (true) goto _L2; else goto _L4
_L4:
        context;
        throw context;
    }

    public boolean a(String s, u u1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = TextUtils.isEmpty(s);
        if (!flag && u1 != null) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        a.remove(u1.d());
        flag = b.b(s, u1);
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
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
        Iterator iterator = b.d().iterator();
        while (iterator.hasNext()) 
        {
            u u1 = (u)iterator.next();
            if (context.equals(u1.e()))
            {
                u1.c();
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        context;
        throw context;
    }

    public void b(Context context, String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (context == null) goto _L2; else goto _L1
_L1:
        boolean flag = TextUtils.isEmpty(s);
        if (!flag) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        context = a(context, s);
        if (context == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        b.b(s, context);
        context.a();
        if (true) goto _L2; else goto _L4
_L4:
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
        Iterator iterator = b.d().iterator();
        while (iterator.hasNext()) 
        {
            u u1 = (u)iterator.next();
            if (context.equals(u1.e()))
            {
                iterator.remove();
                u1.a();
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        context;
        throw context;
    }
}
