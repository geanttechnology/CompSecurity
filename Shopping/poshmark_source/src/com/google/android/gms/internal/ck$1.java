// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            ar, ck, da, dd

class oB
    implements ar
{

    final ck oB;

    public void a(dd dd, Map map)
    {
        synchronized (ck.a(oB))
        {
            String s = (String)map.get("type");
            map = (String)map.get("errors");
            da.w((new StringBuilder()).append("Invalid ").append(s).append(" request error: ").append(map).toString());
            ck.a(oB, 1);
            ck.a(oB).notify();
        }
        return;
        map;
        dd;
        JVM INSTR monitorexit ;
        throw map;
    }

    (ck ck1)
    {
        oB = ck1;
        super();
    }
}
