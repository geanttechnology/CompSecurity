// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import java.util.Map;

// Referenced classes of package com.google.android.gms.tagmanager:
//            aj, di, dh

class cf extends aj
{

    private static final String ID;
    private static final String Wa;
    private static final String Wb;

    public cf()
    {
        super(ID, new String[0]);
    }

    public boolean iy()
    {
        return false;
    }

    public com.google.android.gms.internal.d.a u(Map map)
    {
        Object obj;
        obj = (com.google.android.gms.internal.d.a)map.get(Wa);
        map = (com.google.android.gms.internal.d.a)map.get(Wb);
        if (obj == null || obj == di.ku() || map == null || map == di.ku()) goto _L2; else goto _L1
_L1:
        obj = di.k(((com.google.android.gms.internal.d.a) (obj)));
        map = di.k(map);
        if (obj == di.ks() || map == di.ks()) goto _L2; else goto _L3
_L3:
        double d;
        double d1;
        d1 = ((dh) (obj)).doubleValue();
        d = map.doubleValue();
        if (d1 > d) goto _L2; else goto _L4
_L4:
        return di.r(Long.valueOf(Math.round((d - d1) * Math.random() + d1)));
_L2:
        d = 2147483647D;
        d1 = 0.0D;
        if (true) goto _L4; else goto _L5
_L5:
    }

    static 
    {
        ID = a.Z.toString();
        Wa = b.dl.toString();
        Wb = b.dk.toString();
    }
}
