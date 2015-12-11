// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.a;
import com.google.android.gms.ads.internal.c;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

// Referenced classes of package com.google.android.gms.b:
//            ai, az, ca, cj, 
//            ck, aj, bz

public final class an
    implements ai
{

    private final aj a;
    private final a b;
    private final az c;

    public an(aj aj1, a a1, az az1)
    {
        a = aj1;
        b = a1;
        c = az1;
    }

    private void a(boolean flag)
    {
        if (c != null)
        {
            c.a(flag);
        }
    }

    private static boolean a(Map map)
    {
        return "1".equals(map.get("custom_close"));
    }

    private static int b(Map map)
    {
        map = (String)map.get("o");
        if (map != null)
        {
            if ("p".equalsIgnoreCase(map))
            {
                return com.google.android.gms.ads.internal.c.e().b();
            }
            if ("l".equalsIgnoreCase(map))
            {
                return com.google.android.gms.ads.internal.c.e().a();
            }
            if ("c".equalsIgnoreCase(map))
            {
                return com.google.android.gms.ads.internal.c.e().c();
            }
        }
        return -1;
    }

    public void a(cj cj1, Map map)
    {
        String s = (String)map.get("a");
        if (s == null)
        {
            com.google.android.gms.ads.internal.util.client.b.e("Action missing from an open GMSG.");
        } else
        {
            if (b != null && !b.a())
            {
                b.a((String)map.get("u"));
                return;
            }
            ck ck1 = cj1.h();
            if ("expand".equalsIgnoreCase(s))
            {
                if (cj1.l())
                {
                    com.google.android.gms.ads.internal.util.client.b.e("Cannot expand WebView that is already expanded.");
                    return;
                } else
                {
                    a(false);
                    ck1.a(a(map), b(map));
                    return;
                }
            }
            if ("webapp".equalsIgnoreCase(s))
            {
                cj1 = (String)map.get("u");
                a(false);
                if (cj1 != null)
                {
                    ck1.a(a(map), b(map), cj1);
                    return;
                } else
                {
                    ck1.a(a(map), b(map), (String)map.get("html"), (String)map.get("baseurl"));
                    return;
                }
            }
            if ("in_app_purchase".equalsIgnoreCase(s))
            {
                cj1 = (String)map.get("product_id");
                map = (String)map.get("report_urls");
                if (a != null)
                {
                    if (map != null && !map.isEmpty())
                    {
                        map = map.split(" ");
                        a.a(cj1, new ArrayList(Arrays.asList(map)));
                        return;
                    } else
                    {
                        a.a(cj1, new ArrayList());
                        return;
                    }
                }
            } else
            {
                a(true);
                cj1.j();
                String s1 = (String)map.get("u");
                if (!TextUtils.isEmpty(s1))
                {
                    cj1 = com.google.android.gms.ads.internal.c.c().a(cj1, s1);
                } else
                {
                    cj1 = s1;
                }
                ck1.a(new AdLauncherIntentInfoParcel((String)map.get("i"), cj1, (String)map.get("m"), (String)map.get("p"), (String)map.get("c"), (String)map.get("f"), (String)map.get("e")));
                return;
            }
        }
    }
}
