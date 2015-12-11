// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.d;

import android.support.v4.e.a;
import e.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p
    implements k
{

    private LinkedList a;
    private volatile boolean b;

    public p()
    {
    }

    public p(k k1)
    {
        a = new LinkedList();
        a.add(k1);
    }

    public transient p(k ak[])
    {
        a = new LinkedList(Arrays.asList(ak));
    }

    public final void a(k k1)
    {
        if (k1.c())
        {
            return;
        }
        if (b) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        LinkedList linkedlist1;
        if (b)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        linkedlist1 = a;
        LinkedList linkedlist;
        linkedlist = linkedlist1;
        if (linkedlist1 != null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        linkedlist = new LinkedList();
        a = linkedlist;
        linkedlist.add(k1);
        this;
        JVM INSTR monitorexit ;
        return;
        k1;
        this;
        JVM INSTR monitorexit ;
        throw k1;
        this;
        JVM INSTR monitorexit ;
_L2:
        k1.b();
        return;
    }

    public final void b()
    {
        Object obj;
        obj = null;
        if (b)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        this;
        JVM INSTR monitorenter ;
        if (!b)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj1;
        b = true;
        obj1 = a;
        a = null;
        this;
        JVM INSTR monitorexit ;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        for (obj1 = ((Collection) (obj1)).iterator(); ((Iterator) (obj1)).hasNext();)
        {
            k k1 = (k)((Iterator) (obj1)).next();
            try
            {
                k1.b();
            }
            catch (Throwable throwable)
            {
                if (obj == null)
                {
                    obj = new ArrayList();
                }
                ((List) (obj)).add(throwable);
            }
        }

        break MISSING_BLOCK_LABEL_106;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        android.support.v4.e.a.a(((List) (obj)));
        return;
    }

    public final void b(k k1)
    {
        if (b)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        this;
        JVM INSTR monitorenter ;
        LinkedList linkedlist = a;
        if (!b && linkedlist != null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        boolean flag = linkedlist.remove(k1);
        this;
        JVM INSTR monitorexit ;
        if (flag)
        {
            k1.b();
            return;
        }
        break MISSING_BLOCK_LABEL_52;
        k1;
        this;
        JVM INSTR monitorexit ;
        throw k1;
    }

    public final boolean c()
    {
        return b;
    }
}
