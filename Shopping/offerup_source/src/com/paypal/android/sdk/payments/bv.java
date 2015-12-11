// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.a;
import com.paypal.android.sdk.bb;
import com.paypal.android.sdk.bf;
import com.paypal.android.sdk.cq;
import com.paypal.android.sdk.dd;
import com.paypal.android.sdk.dz;
import com.paypal.android.sdk.ea;
import com.paypal.android.sdk.ez;
import java.util.Map;

// Referenced classes of package com.paypal.android.sdk.payments:
//            bw, bj, PayPalService

final class bv extends bw
{

    public bv(PayPalService paypalservice)
    {
        super(new bj(paypalservice));
    }

    protected final String a()
    {
        return "msdk";
    }

    protected final void a(String s, Map map)
    {
        if (!b().a().a.b())
        {
            b().a().a = new ez();
        }
        map.put("v49", s);
        map.put("v51", b().c().d().d());
        map.put("v52", (new StringBuilder()).append(dz.a).append(" ").append(dz.c).toString());
        map.put("v53", dz.d);
        map.put("clid", b().b());
        map.put("apid", (new StringBuilder()).append(b().c().d().c()).append("|").append(s).append("|").append(b().f()).toString());
        s = new bf(b().a().a.a(), map);
        b().a(s);
    }

    protected final void a(Map map, ea ea1, String s, String s1)
    {
        map.put("g", b().e());
        map.put("vers", (new StringBuilder()).append(dz.a).append(":").append(b().d()).append(":").toString());
        map.put("srce", "msdk");
        map.put("sv", "mobile");
        map.put("bchn", "msdk");
        map.put("adte", "FALSE");
        map.put("bzsr", "mobile");
        if (dd.c(s))
        {
            map.put("calc", s);
        }
        if (dd.c(s1))
        {
            map.put("prid", s1);
        }
        if (ea1.b())
        {
            ea1 = "cl";
        } else
        {
            ea1 = "im";
        }
        map.put("e", ea1);
    }
}
