// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            af, dw, et, ew

final class dx
    implements af
{

    final dw a;

    dx(dw dw1)
    {
        a = dw1;
        super();
    }

    public final void a(ew ew, Map map)
    {
        synchronized (a.a)
        {
            String s = (String)map.get("type");
            map = (String)map.get("errors");
            et.d((new StringBuilder("Invalid ")).append(s).append(" request error: ").append(map).toString());
            a.d = 1;
            a.a.notify();
        }
        return;
        map;
        ew;
        JVM INSTR monitorexit ;
        throw map;
    }
}
