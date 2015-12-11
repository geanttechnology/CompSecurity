// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import com.google.android.gms.d.e;
import com.google.android.gms.d.f;
import java.util.Map;

// Referenced classes of package com.google.android.gms.e:
//            o, cj, ci

final class bg extends o
{

    private static final String b;
    private static final String c;
    private static final String d;

    public bg()
    {
        super(b, new String[0]);
    }

    public final com.google.android.gms.d.h.a a(Map map)
    {
        Object obj;
        obj = (com.google.android.gms.d.h.a)map.get(c);
        map = (com.google.android.gms.d.h.a)map.get(d);
        if (obj == null || obj == com.google.android.gms.e.cj.f() || map == null || map == com.google.android.gms.e.cj.f()) goto _L2; else goto _L1
_L1:
        obj = cj.b(((com.google.android.gms.d.h.a) (obj)));
        map = cj.b(map);
        if (obj == cj.d() || map == cj.d()) goto _L2; else goto _L3
_L3:
        double d1;
        double d2;
        d2 = ((ci) (obj)).doubleValue();
        d1 = map.doubleValue();
        if (d2 > d1) goto _L2; else goto _L4
_L4:
        return cj.a(Long.valueOf(Math.round((d1 - d2) * Math.random() + d2)));
_L2:
        d1 = 2147483647D;
        d2 = 0.0D;
        if (true) goto _L4; else goto _L5
_L5:
    }

    public final boolean a()
    {
        return false;
    }

    static 
    {
        b = e.w.toString();
        c = f.bF.toString();
        d = f.bD.toString();
    }
}
