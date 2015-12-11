// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import com.google.android.gms.ads.internal.util.client.b;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.b:
//            j

public class k
{

    private final Object a;
    private int b;
    private List c;

    public boolean a(j j1)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (c.contains(j1))
        {
            return true;
        }
        obj;
        JVM INSTR monitorexit ;
        return false;
        j1;
        obj;
        JVM INSTR monitorexit ;
        throw j1;
    }

    public boolean b(j j1)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = c.iterator();
_L2:
        j j2;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_68;
            }
            j2 = (j)iterator.next();
        } while (j1 == j2);
        if (!j2.b().equals(j1.b())) goto _L2; else goto _L1
_L1:
        iterator.remove();
        obj;
        JVM INSTR monitorexit ;
        return true;
        obj;
        JVM INSTR monitorexit ;
        return false;
        j1;
        obj;
        JVM INSTR monitorexit ;
        throw j1;
    }

    public void c(j j1)
    {
        synchronized (a)
        {
            if (c.size() >= 10)
            {
                com.google.android.gms.ads.internal.util.client.b.a((new StringBuilder()).append("Queue is full, current size = ").append(c.size()).toString());
                c.remove(0);
            }
            int i = b;
            b = i + 1;
            j1.a(i);
            c.add(j1);
        }
        return;
        j1;
        obj;
        JVM INSTR monitorexit ;
        throw j1;
    }
}
