// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class sw
{

    private final Object a = new Object();
    private int b;
    private List c;

    public sw()
    {
        c = new LinkedList();
    }

    public sv a()
    {
        sv sv1;
label0:
        {
            sv1 = null;
            synchronized (a)
            {
                if (c.size() != 0)
                {
                    break label0;
                }
                acb.a("Queue empty");
            }
            return null;
        }
        if (c.size() < 2)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        int i = 0x80000000;
        Iterator iterator = c.iterator();
_L1:
        sv sv2;
        int j;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_101;
        }
        sv2 = (sv)iterator.next();
        j = sv2.g();
        if (j > i)
        {
            sv1 = sv2;
            i = j;
        }
          goto _L1
        c.remove(sv1);
        obj;
        JVM INSTR monitorexit ;
        return sv1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        exception = (sv)c.get(0);
        exception.c();
        obj;
        JVM INSTR monitorexit ;
        return exception;
    }

    public boolean a(sv sv1)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (c.contains(sv1))
        {
            return true;
        }
        obj;
        JVM INSTR monitorexit ;
        return false;
        sv1;
        obj;
        JVM INSTR monitorexit ;
        throw sv1;
    }

    public boolean b(sv sv1)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = c.iterator();
_L2:
        sv sv2;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_73;
            }
            sv2 = (sv)iterator.next();
        } while (sv1 == sv2);
        if (!sv2.b().equals(sv1.b())) goto _L2; else goto _L1
_L1:
        c.remove(sv1);
        obj;
        JVM INSTR monitorexit ;
        return true;
        obj;
        JVM INSTR monitorexit ;
        return false;
        sv1;
        obj;
        JVM INSTR monitorexit ;
        throw sv1;
    }

    public void c(sv sv1)
    {
        synchronized (a)
        {
            if (c.size() >= 10)
            {
                acb.a((new StringBuilder()).append("Queue is full, current size = ").append(c.size()).toString());
                c.remove(0);
            }
            int i = b;
            b = i + 1;
            sv1.a(i);
            c.add(sv1);
        }
        return;
        sv1;
        obj;
        JVM INSTR monitorexit ;
        throw sv1;
    }
}
