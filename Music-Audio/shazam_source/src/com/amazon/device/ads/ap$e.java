// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            ap, cd

private static final class b extends b
{

    private final ap b;

    public final JSONObject a()
    {
        JSONObject jsonobject = new JSONObject();
        cd.b(jsonobject, "sdkVersion", ap.e());
        return jsonobject;
    }

    protected (ap ap1)
    {
        super("GetSDKVersion");
        b = ap1;
    }
}
