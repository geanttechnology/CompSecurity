// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import com.google.android.gms.ads.internal.c;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.Map;

// Referenced classes of package com.google.android.gms.b:
//            ai, aq, ap, cj

public class as
    implements ai
{

    public as()
    {
    }

    public void a(cj cj, Map map)
    {
        aq aq1 = c.k();
        if (map.containsKey("abort"))
        {
            if (!aq1.a(cj))
            {
                b.e("Precache abort but no preload task running.");
            }
            return;
        }
        map = (String)map.get("src");
        if (map == null)
        {
            b.e("Precache video action is missing the src parameter.");
            return;
        }
        if (aq1.b(cj))
        {
            b.e("Precache task already running.");
            return;
        } else
        {
            (new ap(cj, map)).b();
            return;
        }
    }
}
