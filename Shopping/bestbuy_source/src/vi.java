// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.internal.do;
import com.google.android.gms.internal.gu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public final class vi
    implements vd
{

    private final ve a;
    private final ahl b;

    public vi(ve ve1, ahl ahl1)
    {
        a = ve1;
        b = ahl1;
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
                return abq.c();
            }
            if ("l".equalsIgnoreCase(map))
            {
                return abq.b();
            }
        }
        return -1;
    }

    public void a(gu gu1, Map map)
    {
        String s = (String)map.get("a");
        if (s == null)
        {
            acb.e("Action missing from an open GMSG.");
        } else
        {
            if (b != null && !b.b())
            {
                b.a((String)map.get("u"));
                return;
            }
            ace ace1 = gu1.f();
            if ("expand".equalsIgnoreCase(s))
            {
                if (gu1.j())
                {
                    acb.e("Cannot expand WebView that is already expanded.");
                    return;
                } else
                {
                    ace1.a(a(map), b(map));
                    return;
                }
            }
            if ("webapp".equalsIgnoreCase(s))
            {
                gu1 = (String)map.get("u");
                if (gu1 != null)
                {
                    ace1.a(a(map), b(map), gu1);
                    return;
                } else
                {
                    ace1.a(a(map), b(map), (String)map.get("html"), (String)map.get("baseurl"));
                    return;
                }
            }
            if ("in_app_purchase".equalsIgnoreCase(s))
            {
                gu1 = (String)map.get("product_id");
                map = (String)map.get("report_urls");
                if (a != null)
                {
                    if (map != null && !map.isEmpty())
                    {
                        map = map.split(" ");
                        a.a(gu1, new ArrayList(Arrays.asList(map)));
                        return;
                    } else
                    {
                        a.a(gu1, new ArrayList());
                        return;
                    }
                }
            } else
            {
                ace1.a(new do((String)map.get("i"), (String)map.get("u"), (String)map.get("m"), (String)map.get("p"), (String)map.get("c"), (String)map.get("f"), (String)map.get("e")));
                return;
            }
        }
    }
}
