// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import com.google.android.gms.ads.internal.c;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.Map;

// Referenced classes of package com.google.android.gms.b:
//            ca, cj

public class ba
{

    private final cj a;
    private final boolean b;
    private final String c;

    public ba(cj cj1, Map map)
    {
        a = cj1;
        c = (String)map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange"))
        {
            b = Boolean.parseBoolean((String)map.get("allowOrientationChange"));
            return;
        } else
        {
            b = true;
            return;
        }
    }

    public void a()
    {
        if (a == null)
        {
            com.google.android.gms.ads.internal.util.client.b.e("AdWebView is null");
            return;
        }
        int i;
        if ("portrait".equalsIgnoreCase(c))
        {
            i = com.google.android.gms.ads.internal.c.e().b();
        } else
        if ("landscape".equalsIgnoreCase(c))
        {
            i = com.google.android.gms.ads.internal.c.e().a();
        } else
        if (b)
        {
            i = -1;
        } else
        {
            i = com.google.android.gms.ads.internal.c.e().c();
        }
        a.setRequestedOrientation(i);
    }
}
