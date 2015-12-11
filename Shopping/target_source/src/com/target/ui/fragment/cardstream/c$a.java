// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream;

import com.target.a.a.b;
import com.target.ui.fragment.cardstream.c.a;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.cardstream:
//            c

private class <init>
{

    private static final int FIRST_LOAD_POLLING_COUNT = 10;
    private boolean hasFirstLoadCompleted;
    private boolean shouldBlock;
    final c this$0;

    private void a(long l)
    {
        try
        {
            com.target.a.a.b.d("CardDataSource", "Blocking card stream load...");
            Thread.sleep(l);
            com.target.a.a.b.d("CardDataSource", "...card stream load unblocked.");
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            com.target.a.a.b.b("CardDataSource", "Interrupted while sleeping: ", interruptedexception);
        }
    }

    private void c()
    {
        hasFirstLoadCompleted = true;
        shouldBlock = true;
        com.target.a.a.b.c("CardDataSource", (new StringBuilder()).append("onFirstCardLoad() running with an interval of ").append(200L).append("ms").toString());
        int i = 0;
        do
        {
            if (i > 10 || e())
            {
                return;
            }
            a(200L);
            i++;
        } while (true);
    }

    private void d()
    {
        com.target.a.a.b.c("CardDataSource", "onSubsequentLoad() running");
        if (!shouldBlock)
        {
            shouldBlock = true;
            return;
        } else
        {
            a(2000L);
            return;
        }
    }

    private boolean e()
    {
        boolean flag = false;
        Iterator iterator = a(c.this).iterator();
        int i;
        int j;
        for (i = 0; iterator.hasNext(); i = j)
        {
            a a1 = (a)iterator.next();
            boolean flag1 = a1.g();
            j = i;
            if (flag1)
            {
                j = i + 1;
            }
            com.target.a.a.b.d("CardDataSource", (new StringBuilder()).append("Checking dataSource ").append(a1).append(", isLoaded:").append(flag1).toString());
        }

        if (i == a(c.this).size())
        {
            flag = true;
        }
        return flag;
    }

    void a()
    {
        this;
        JVM INSTR monitorenter ;
        if (hasFirstLoadCompleted) goto _L2; else goto _L1
_L1:
        c();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        d();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    void b()
    {
        shouldBlock = false;
    }

    private ()
    {
        this$0 = c.this;
        super();
        hasFirstLoadCompleted = false;
        shouldBlock = true;
    }

    shouldBlock(shouldBlock shouldblock)
    {
        this();
    }
}
