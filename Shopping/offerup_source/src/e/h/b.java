// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.h;

import android.support.v4.e.a;
import e.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class b
    implements k
{

    private Set a;
    private volatile boolean b;

    public b()
    {
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
        if (b)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        if (a == null)
        {
            a = new HashSet(4);
        }
        a.add(k1);
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
            break MISSING_BLOCK_LABEL_55;
        }
        this;
        JVM INSTR monitorenter ;
        if (!b && a != null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        boolean flag = a.remove(k1);
        this;
        JVM INSTR monitorexit ;
        if (flag)
        {
            k1.b();
            return;
        }
        break MISSING_BLOCK_LABEL_55;
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
