// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            ci, cd, db

private static final class b extends b
{

    private final ci b;

    public final JSONObject a()
    {
        ci ci1 = b;
        int i = cd.a(null, "width", 0);
        int j = cd.a(null, "height", 0);
        int k = cd.a(null, "offsetX", 0);
        int l = cd.a(null, "offsetY", 0);
        String s = cd.a(null, "customClosePosition", null);
        boolean flag = cd.a(null, "allowOffscreen", false);
        if (ci1.e == null)
        {
            ci1.e = new db();
        }
        db db1 = ci1.e;
        Boolean boolean1 = Boolean.valueOf(flag);
        if (boolean1 != null)
        {
            cd.b(db1.a, "allowOffscreen", boolean1.booleanValue());
        }
        db1 = ci1.e;
        if (s != null)
        {
            cd.b(db1.a, "customClosePosition", s);
        }
        cd.b(ci1.e.a, "width", i);
        cd.b(ci1.e.a, "height", j);
        cd.b(ci1.e.a, "offsetX", k);
        cd.b(ci1.e.a, "offsetY", l);
        return null;
    }

    public (ci ci1)
    {
        super("SetResizeProperties");
        b = ci1;
    }
}
