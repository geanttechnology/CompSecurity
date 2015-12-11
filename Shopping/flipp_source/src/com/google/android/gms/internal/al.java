// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            et, ao, an, at, 
//            ar, bz, er, am, 
//            bn

public final class al
{

    final Object a = new Object();
    boolean b;
    ar c;
    private final bz d;
    private final bn e;
    private final Context f;
    private final ao g;

    public al(Context context, bz bz1, bn bn, ao ao1)
    {
        b = false;
        f = context;
        d = bz1;
        e = bn;
        g = ao1;
    }

    public final at a(long l)
    {
        Iterator iterator;
        et.a("Starting mediation.");
        iterator = g.a.iterator();
_L4:
        an an1;
        Iterator iterator1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_233;
        }
        an1 = (an)iterator.next();
        et.b((new StringBuilder("Trying mediation network: ")).append(an1.b).toString());
        iterator1 = an1.c.iterator();
_L2:
        String s;
label0:
        {
            if (!iterator1.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            s = (String)iterator1.next();
            at at1;
            synchronized (a)
            {
                if (!b)
                {
                    break label0;
                }
                at1 = new at(-1);
            }
            return at1;
        }
        c = new ar(f, s, e, g, an1, d.c, d.d, d.k);
        obj;
        JVM INSTR monitorexit ;
        obj = c.a(l);
        if (((at) (obj)).a == 0)
        {
            et.a("Adapter succeeded.");
            return ((at) (obj));
        }
        break MISSING_BLOCK_LABEL_207;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (((at) (obj)).c != null)
        {
            er.a.post(new am(this, ((at) (obj))));
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (true) goto _L4; else goto _L3
_L3:
        return new at(1);
    }
}
