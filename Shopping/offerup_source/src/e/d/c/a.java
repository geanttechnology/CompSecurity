// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.c;

import e.d.d.h;
import e.g;
import e.k;
import java.util.concurrent.TimeUnit;

// Referenced classes of package e.d.c:
//            c, b, d

public final class a extends g
{

    static final int a;
    private static final h b;
    private c c;

    public a()
    {
        c = new c();
    }

    static h b()
    {
        return b;
    }

    public final e.h a()
    {
        return new b(c.a());
    }

    public final k a(e.c.a a1)
    {
        return c.a().b(a1, -1L, TimeUnit.NANOSECONDS);
    }

    static 
    {
        int i;
label0:
        {
            b = new h("RxComputationThreadPool-");
            int j = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
            int k = Runtime.getRuntime().availableProcessors();
            if (j > 0)
            {
                i = j;
                if (j <= k)
                {
                    break label0;
                }
            }
            i = k;
        }
        a = i;
    }
}
