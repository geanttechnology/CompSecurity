// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            df, cd, cm, cz

class dg extends df
{

    private static final String d = com/amazon/device/ads/dg.getSimpleName();
    private static final ck.a e;

    public dg()
    {
        super.a = e;
        a(d);
        super.b = "/generate_did";
    }

    public final void a(JSONObject jsonobject)
    {
        jsonobject = cd.a(jsonobject, "adId", "");
        if (jsonobject.length() > 0)
        {
            cz cz1 = cm.a().c;
            cz.a(jsonobject, super.c);
        }
    }

    static 
    {
        e = ck.a.M;
    }
}
