// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            an, cg, ct, cw, 
//            cl

class hO
    implements an
{

    final cg hO;

    public void a(cw cw1, Map map)
    {
        Object obj = cg.a(hO);
        obj;
        JVM INSTR monitorenter ;
        String s1 = (String)map.get("url");
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        ct.v("URL missing in loadAdUrl GMSG.");
        obj;
        JVM INSTR monitorexit ;
        return;
        String s = s1;
        if (s1.contains("%40mediation_adapters%40"))
        {
            s = s1.replaceAll("%40mediation_adapters%40", cl.b(cw1.getContext(), (String)map.get("check_adapters"), cg.b(hO)));
            ct.u((new StringBuilder()).append("Ad request URL modified to ").append(s).toString());
        }
        cg.a(hO, s);
        cg.a(hO).notify();
        obj;
        JVM INSTR monitorexit ;
        return;
        cw1;
        obj;
        JVM INSTR monitorexit ;
        throw cw1;
    }

    (cg cg1)
    {
        hO = cg1;
        super();
    }
}
