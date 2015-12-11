// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.sighting;

import com.gimbal.internal.c.c;
import com.gimbal.internal.proximity.core.c.g;
import com.gimbal.internal.proximity.core.c.j;
import com.gimbal.internal.proximity.core.sighting.a.a;
import com.gimbal.internal.proximity.core.sighting.a.b;

// Referenced classes of package com.gimbal.internal.proximity.core.sighting:
//            c, Sighting

public class d
    implements com.gimbal.internal.proximity.core.sighting.c
{

    private static final com.gimbal.a.a a = c.e(com/gimbal/internal/proximity/core/sighting/d.getSimpleName());
    private static d b;

    private d()
    {
    }

    public static d a()
    {
        com/gimbal/internal/proximity/core/sighting/d;
        JVM INSTR monitorenter ;
        d d1;
        if (b == null)
        {
            b = new d();
        }
        d1 = b;
        com/gimbal/internal/proximity/core/sighting/d;
        JVM INSTR monitorexit ;
        return d1;
        Exception exception;
        exception;
        throw exception;
    }

    public final Sighting a(j j1, int i)
    {
        Object obj = g.a(c.a(j1.a));
        if (((String) (obj)).equalsIgnoreCase(c.c(com.gimbal.internal.proximity.core.c.d.a)))
        {
            obj = new a();
        } else
        if (((String) (obj)).equalsIgnoreCase(c.c(com.gimbal.internal.proximity.core.c.d.c)))
        {
            obj = new b();
        } else
        if (((String) (obj)).equalsIgnoreCase(c.c(com.gimbal.internal.proximity.core.c.d.f)))
        {
            obj = new com.gimbal.internal.proximity.core.sighting.a.d();
        } else
        {
            obj = new com.gimbal.internal.proximity.core.sighting.a.c();
        }
        return ((com.gimbal.internal.proximity.core.sighting.c) (obj)).a(j1, i);
    }

}
