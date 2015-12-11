// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            ci, f, h, cd

private static final class b extends b
{

    private final ci b;

    public final JSONObject a()
    {
        JSONObject jsonobject = new JSONObject();
        String s;
        if (b.g.a.u())
        {
            s = "interstitial";
        } else
        {
            s = "inline";
        }
        cd.b(jsonobject, "placementType", s);
        return jsonobject;
    }

    public (ci ci1)
    {
        super("GetPlacementType");
        b = ci1;
    }
}
