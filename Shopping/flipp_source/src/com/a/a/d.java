// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import com.a.a.a.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Callable;

// Referenced classes of package com.a.a:
//            c, b

final class d
    implements Callable
{

    final c a;

    d(c c1)
    {
        a = c1;
        super();
    }

    private Void a()
    {
        ArrayList arraylist = new ArrayList(2);
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        ListIterator listiterator = c.a(a).listIterator(c.a(a).size());
        int i = 0;
_L6:
        if (!listiterator.hasPrevious()) goto _L2; else goto _L1
_L1:
        b b1 = (b)listiterator.previous();
        if (!b1.a()) goto _L4; else goto _L3
_L3:
        long l = c.b(a);
        Exception exception;
        boolean flag;
        if (b1.c() && System.nanoTime() - b1.d() > l)
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L5
_L4:
        listiterator.remove();
        arraylist.add(b1);
        if (arraylist.size() != 2) goto _L6; else goto _L2
_L2:
        listiterator = c.a(a).listIterator(c.a(a).size());
_L10:
        if (!listiterator.hasPrevious() || i <= c.c(a)) goto _L8; else goto _L7
_L7:
        b1 = (b)listiterator.previous();
        if (!b1.c()) goto _L10; else goto _L9
_L9:
        arraylist.add(b1);
        listiterator.remove();
        i--;
          goto _L10
_L12:
        if (!b1.c()) goto _L6; else goto _L11
_L11:
        i++;
          goto _L6
_L8:
        obj;
        JVM INSTR monitorexit ;
        for (obj = arraylist.iterator(); ((Iterator) (obj)).hasNext(); u.a((b)((Iterator) (obj)).next())) { }
        break MISSING_BLOCK_LABEL_271;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        return null;
_L5:
        if (!flag) goto _L12; else goto _L4
    }

    public final Object call()
    {
        return a();
    }
}
