// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            ci, f, h, cv, 
//            do

private static final class b extends b
{

    private final ci b;

    public final JSONObject a()
    {
        ci ci1 = b;
        if (ci1.g.a.t() == null)
        {
            ci1.a("Current position is unavailable because the ad has not yet been displayed.", "getCurrentPosition");
            return (new cv(new do(0, 0), 0, 0)).a();
        } else
        {
            return ci1.g.a.t().a();
        }
    }

    public (ci ci1)
    {
        super("GetCurrentPosition");
        b = ci1;
    }
}
