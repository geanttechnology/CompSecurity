// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            ci, cd, f, h, 
//            bi, dq, ea, ah

private static final class b extends b
{

    private final ci b;

    public final JSONObject a()
    {
        Object obj = b;
        String s = cd.a(null, "url", null);
        if (((ci) (obj)).g.a.u())
        {
            ((ci) (obj)).a("Unable to expand an interstitial ad placement", "expand");
            return null;
        }
        if (((ci) (obj)).g.d())
        {
            ((ci) (obj)).a("Unable to expand while expanded.", "expand");
            return null;
        }
        if (!((ci) (obj)).g.c())
        {
            ((ci) (obj)).a("Unable to expand ad while it is not visible.", "expand");
            return null;
        }
        if (((ci) (obj)).d.a < 50 || ((ci) (obj)).d.b < 50)
        {
            ((ci) (obj)).a("Expand size is too small, must leave room for close.", "expand");
            return null;
        }
        bi bi1 = ((ci) (obj)).d;
        if (!dq.b(s))
        {
            if (ea.a(s))
            {
                f f1 = ((ci) (obj)).g;
                obj = new <init>(((ci) (obj)), bi1);
                f1.a.i.a(s, true, ((cx) (obj)));
                return null;
            } else
            {
                ((ci) (obj)).a("Unable to expand with invalid URL.", "expand");
                return null;
            }
        } else
        {
            ((ci) (obj)).a(bi1, null);
            return null;
        }
    }

    public (ci ci1)
    {
        super("Expand");
        b = ci1;
    }
}
