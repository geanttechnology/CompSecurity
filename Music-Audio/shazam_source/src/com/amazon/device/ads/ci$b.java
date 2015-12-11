// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            ci, f, h, d

private static final class b extends b
{

    private final ci b;

    public final JSONObject a()
    {
        ci ci1 = b;
        if (!ci1.g.a.j.a())
        {
            ci1.a("Unable to close ad in its current state.", "close");
        }
        return null;
    }

    public (ci ci1)
    {
        super("Close");
        b = ci1;
    }
}
