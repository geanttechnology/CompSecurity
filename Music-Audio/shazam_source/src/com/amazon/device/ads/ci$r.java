// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            ci, cd, f, cu

private static final class b extends b
{

    private final ci b;

    public final JSONObject a()
    {
        ci ci1 = b;
        String s = cd.a(null, "url", null);
        cu cu1 = ci1.b;
        if (!cu.a(ci1.g.b(), "android.permission.WRITE_EXTERNAL_STORAGE"))
        {
            ci1.a("Picture could not be stored because permission was denied.", "storePicture");
            return null;
        } else
        {
            ci1.i.a(new <init>(ci1, s), a, b);
            return null;
        }
    }

    public (ci ci1)
    {
        super("StorePicture");
        b = ci1;
    }
}
