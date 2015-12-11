// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.conversiontracking;

import android.util.Log;
import java.util.List;

// Referenced classes of package com.google.ads.conversiontracking:
//            h, g, j, i

public class a
    implements Runnable
{

    protected long a;
    final h b;

    private void a()
    {
        if (a == 0L)
        {
            a = 1000L;
            return;
        } else
        {
            a = Math.min(a * 2L, 60000L);
            return;
        }
    }

    public void run()
    {
        h.b(b, true);
_L2:
        Object obj = h.a(b);
        obj;
        JVM INSTR monitorenter ;
        for (; h.f(b).isEmpty(); h.a(b).wait())
        {
            h.a(b, false);
        }

        break MISSING_BLOCK_LABEL_80;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.w("GoogleConversionReporter", "Dispatch thread is interrupted.");
        }
        h.b(b, false);
        return;
        g g1;
        h.a(b, true);
        g1 = (g)h.f(b).remove(0);
        obj;
        JVM INSTR monitorexit ;
        if (g1 == null) goto _L2; else goto _L1
_L1:
label0:
        {
            if (j.a(h.c(b), g1.e, g1.f, g1.b))
            {
                break label0;
            }
            h.e(b).a(g1);
        }
          goto _L2
        int k = b.a(g1);
        if (k != 2)
        {
            break MISSING_BLOCK_LABEL_184;
        }
        h.e(b).a(g1);
        a = 0L;
          goto _L2
        if (k != 0)
        {
            break MISSING_BLOCK_LABEL_213;
        }
        h.e(b).c(g1);
        a();
        Thread.sleep(a);
          goto _L2
        h.e(b).c(g1);
        a = 0L;
          goto _L2
    }

    public (h h1)
    {
        b = h1;
        super();
        a = 0L;
    }
}
