// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import android.util.Pair;
import com.cyberlink.beautycircle.model.network.d;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.cyberlink.beautycircle.model:
//            CircleType

final class a extends l
{

    final Pair a;

    public void a()
    {
        super.a();
    }

    public void a(int i)
    {
        super.a(i);
        a(((d) (null)));
    }

    protected void a(d d1)
    {
        if (d1 != null)
        {
            CircleType.c().put(a, d1);
        }
        d1 = com.cyberlink.beautycircle.model.CircleType.d();
        d1;
        JVM INSTR monitorenter ;
        for (Iterator iterator = com.cyberlink.beautycircle.model.CircleType.d().iterator(); iterator.hasNext(); ((j)iterator.next()).d(null)) { }
        break MISSING_BLOCK_LABEL_62;
        Exception exception;
        exception;
        d1;
        JVM INSTR monitorexit ;
        throw exception;
        com.cyberlink.beautycircle.model.CircleType.d().clear();
        d1;
        JVM INSTR monitorexit ;
    }

    protected void b(Object obj)
    {
        a((d)obj);
    }

    (Pair pair)
    {
        a = pair;
        super();
    }
}
