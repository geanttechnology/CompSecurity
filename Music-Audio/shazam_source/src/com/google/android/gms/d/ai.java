// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.ads.internal.util.client.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.google.android.gms.d:
//            ah

public final class ai
{

    final Object a = new Object();
    int b;
    List c;

    public ai()
    {
        c = new LinkedList();
    }

    public final ah a()
    {
        ah ah1;
label0:
        {
            ah1 = null;
            synchronized (a)
            {
                if (c.size() != 0)
                {
                    break label0;
                }
                com.google.android.gms.ads.internal.util.client.b.a(3);
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
        ah ah2;
        int j;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_101;
        }
        ah2 = (ah)iterator.next();
        j = ah2.e;
        if (j > i)
        {
            ah1 = ah2;
            i = j;
        }
          goto _L1
        c.remove(ah1);
        obj1;
        JVM INSTR monitorexit ;
        return ah1;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
        ah2 = (ah)c.get(0);
        synchronized (ah2.a)
        {
            ah2.e = ah2.e - 100;
        }
        obj1;
        JVM INSTR monitorexit ;
        return ah2;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    public final boolean a(ah ah1)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (c.contains(ah1))
        {
            return true;
        }
        obj;
        JVM INSTR monitorexit ;
        return false;
        ah1;
        obj;
        JVM INSTR monitorexit ;
        throw ah1;
    }

    public final boolean b(ah ah1)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = c.iterator();
_L2:
        ah ah2;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_68;
            }
            ah2 = (ah)iterator.next();
        } while (ah1 == ah2);
        if (!ah2.f.equals(ah1.f)) goto _L2; else goto _L1
_L1:
        iterator.remove();
        obj;
        JVM INSTR monitorexit ;
        return true;
        obj;
        JVM INSTR monitorexit ;
        return false;
        ah1;
        obj;
        JVM INSTR monitorexit ;
        throw ah1;
    }
}
