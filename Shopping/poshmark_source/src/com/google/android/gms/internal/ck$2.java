// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            ar, ck, da, dd, 
//            cs

class oB
    implements ar
{

    final ck oB;

    public void a(dd dd1, Map map)
    {
        Object obj = ck.a(oB);
        obj;
        JVM INSTR monitorenter ;
        String s1 = (String)map.get("url");
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        da.w("URL missing in loadAdUrl GMSG.");
        obj;
        JVM INSTR monitorexit ;
        return;
        String s = s1;
        if (s1.contains("%40mediation_adapters%40"))
        {
            s = s1.replaceAll("%40mediation_adapters%40", cs.b(dd1.getContext(), (String)map.get("check_adapters"), ck.b(oB)));
            da.v((new StringBuilder()).append("Ad request URL modified to ").append(s).toString());
        }
        ck.a(oB, s);
        ck.a(oB).notify();
        obj;
        JVM INSTR monitorexit ;
        return;
        dd1;
        obj;
        JVM INSTR monitorexit ;
        throw dd1;
    }

    (ck ck1)
    {
        oB = ck1;
        super();
    }
}
