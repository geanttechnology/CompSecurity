// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            ci, f, h, db, 
//            aj, do

private static final class b extends b
{

    private final ci b;

    public final JSONObject a()
    {
        ci ci1 = b;
        if (ci1.g.a.u())
        {
            ci1.a("Unable to resize an interstitial ad placement.", "resize");
        } else
        if (ci1.g.d())
        {
            ci1.a("Unable to resize while expanded.", "resize");
        } else
        if (!ci1.g.c())
        {
            ci1.a("Unable to resize ad while it is not visible.", "resize");
        } else
        if (ci1.e == null)
        {
            ci1.a("Resize properties must be set before calling resize.", "resize");
        } else
        if (ci1.e.a() < 50 || ci1.e.b() < 50)
        {
            ci1.a("Resize width and height must be at least 50 dp in order to fit the close button.", "resize");
        } else
        {
            db db1 = ci1.e;
            int j = db1.a();
            int i = db1.b();
            Object obj = ci1.h;
            j = aj.b(j);
            obj = ci1.h;
            obj = new do(j, aj.b(i));
            ci1.i.a(new <init>(ci1, db1, ((do) (obj))), a, a);
        }
        return null;
    }

    public (ci ci1)
    {
        super("Resize");
        b = ci1;
    }
}
