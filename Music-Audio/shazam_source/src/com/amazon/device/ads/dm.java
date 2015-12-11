// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            df, cd, ck, cl, 
//            cm, cz, bc, dq

final class dm extends df
{

    private static final ck.a d;

    public dm()
    {
        super.a = d;
        a("SISUpdateDeviceInfoRequest");
        super.b = "/update_dev_info";
    }

    public final void a(JSONObject jsonobject)
    {
        String s = cd.a(jsonobject, "adId", "");
        if (cd.a(jsonobject, "idChanged", false))
        {
            ck.a().b.a(ck.a.L);
        }
        if (s.length() > 0)
        {
            jsonobject = cm.a().c;
            cz.a(s, super.c);
        }
    }

    public final dy.b d()
    {
        String s = bc.a().a("debug.adid", super.c.d());
        dy.b b = super.d();
        if (!dq.a(s))
        {
            b.a("adId", s);
        }
        return b;
    }

    static 
    {
        d = ck.a.N;
    }
}
