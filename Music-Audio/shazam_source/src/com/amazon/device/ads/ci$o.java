// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            ci, cd, bi

private static final class b extends b
{

    private final ci b;

    public final JSONObject a()
    {
        ci ci1 = b;
        int i = cd.a(null, "width", 0);
        int j = cd.a(null, "height", 0);
        boolean flag = cd.a(null, "useCustomClose", false);
        ci1.d.a = i;
        ci1.d.b = j;
        ci1.a(flag);
        return null;
    }

    public (ci ci1)
    {
        super("SetExpandProperties");
        b = ci1;
    }
}
