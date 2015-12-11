// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.content.Intent;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            ci, cd, f, cn, 
//            ea, dz, dq, aw, 
//            AdActivity, by, h, ah

private static final class b extends b
{

    private final ci b;

    public final JSONObject a()
    {
        Object obj = b;
        String s = cd.a(null, "url", null);
        if (!((ci) (obj)).g.c())
        {
            ((ci) (obj)).a("Unable to open a URL while the ad is not visible", "open");
            return null;
        }
        ((ci) (obj)).a.b((new StringBuilder("Opening URL ")).append(s).toString(), null);
        if (ea.a(s))
        {
            String s1 = dz.b(s);
            if ("http".equals(s1) || "https".equals(s1))
            {
                b b1 = new <init>();
                b1.c = ((ci) (obj)).g.b();
                b1.e = true;
                b1.d = s;
                if (b1.c == null)
                {
                    throw new IllegalArgumentException("Context must not be null");
                }
                if (dq.b(b1.d))
                {
                    throw new IllegalArgumentException("Url must not be null or white space");
                }
                if (!b1.b.b())
                {
                    b1.a.d("Could not load application assets, failed to open URI: %s", new Object[] {
                        b1.d
                    });
                    return null;
                } else
                {
                    obj = new Intent(b1.c, com/amazon/device/ads/AdActivity);
                    ((Intent) (obj)).putExtra("adapter", com/amazon/device/ads/by.getName());
                    ((Intent) (obj)).putExtra("extra_url", b1.d);
                    ((Intent) (obj)).putExtra("extra_open_btn", b1.e);
                    ((Intent) (obj)).addFlags(0x10000000);
                    b1.c.startActivity(((Intent) (obj)));
                    return null;
                }
            } else
            {
                ((ci) (obj)).g.a.i.a(s, false, null);
                return null;
            }
        } else
        {
            s = (new StringBuilder("URL ")).append(s).append(" is not a valid URL").toString();
            ((ci) (obj)).a.b(s, null);
            ((ci) (obj)).a(s, "open");
            return null;
        }
    }

    public ivity(ci ci1)
    {
        super("Open");
        b = ci1;
    }
}
