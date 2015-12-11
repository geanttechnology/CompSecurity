// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Map;

// Referenced classes of package android.support.v7:
//            aat, ls, lt, ado, 
//            adn

class acl extends aat
{

    private static final String a;
    private static final String b;
    private static final String c;

    public acl()
    {
        super(a, new String[0]);
    }

    public lv.a a(Map map)
    {
        Object obj;
        obj = (lv.a)map.get(b);
        map = (lv.a)map.get(c);
        if (obj == null || obj == ado.f() || map == null || map == ado.f()) goto _L2; else goto _L1
_L1:
        obj = ado.b(((lv.a) (obj)));
        map = ado.b(map);
        if (obj == ado.d() || map == ado.d()) goto _L2; else goto _L3
_L3:
        double d;
        double d1;
        d1 = ((adn) (obj)).doubleValue();
        d = map.doubleValue();
        if (d1 > d) goto _L2; else goto _L4
_L4:
        return ado.e(Long.valueOf(Math.round((d - d1) * Math.random() + d1)));
_L2:
        d = 2147483647D;
        d1 = 0.0D;
        if (true) goto _L4; else goto _L5
_L5:
    }

    public boolean a()
    {
        return false;
    }

    static 
    {
        a = ls.w.toString();
        b = lt.bF.toString();
        c = lt.bD.toString();
    }
}
