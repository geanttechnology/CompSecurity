// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            an, cg, ct, cw

class hO
    implements an
{

    final cg hO;

    public void a(cw cw, Map map)
    {
        synchronized (cg.a(hO))
        {
            String s = (String)map.get("type");
            map = (String)map.get("errors");
            ct.v((new StringBuilder()).append("Invalid ").append(s).append(" request error: ").append(map).toString());
            cg.a(hO, 1);
            cg.a(hO).notify();
        }
        return;
        map;
        cw;
        JVM INSTR monitorexit ;
        throw map;
    }

    (cg cg1)
    {
        hO = cg1;
        super();
    }
}
