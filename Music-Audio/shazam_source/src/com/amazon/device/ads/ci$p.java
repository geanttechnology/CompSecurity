// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.Locale;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            ci, cd, f, h, 
//            cl, cr, dq, bp, 
//            cn

private static final class b extends b
{

    private final ci b;

    public final JSONObject a()
    {
        ci ci1 = b;
        boolean flag = cd.a(null, "allowOrientationChange", false);
        String s = cd.a(null, "forceOrientation", null);
        if (ci1.g.a.u() && !ci1.g.d())
        {
            h h1 = ci1.g.a;
            if (!h1.G)
            {
                h1.G = true;
                h1.f.a(ae);
            }
        }
        ci1.c.a = Boolean.valueOf(flag);
        if (!dq.a(s))
        {
            try
            {
                bp bp1 = bp.valueOf(s.toUpperCase(Locale.US));
                ci1.c.b = bp1;
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                ci1.a.c((new StringBuilder("Not a valid orientation to force:")).append(s).toString(), null);
            }
        }
        ci1.g();
        return null;
    }

    public ception(ci ci1)
    {
        super("SetOrientationProperties");
        b = ci1;
    }
}
