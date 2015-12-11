// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            an, co, ct, cw, 
//            cx, bj

public final class ao
    implements an
{

    public ao()
    {
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
                return co.av();
            }
            if ("l".equalsIgnoreCase(map))
            {
                return co.au();
            }
        }
        return -1;
    }

    public void a(cw cw1, Map map)
    {
        String s = (String)map.get("a");
        if (s == null)
        {
            ct.v("Action missing from an open GMSG.");
            return;
        }
        cx cx1 = cw1.aC();
        if ("expand".equalsIgnoreCase(s))
        {
            if (cw1.aF())
            {
                ct.v("Cannot expand WebView that is already expanded.");
                return;
            } else
            {
                cx1.a(a(map), b(map));
                return;
            }
        }
        if ("webapp".equalsIgnoreCase(s))
        {
            cw1 = (String)map.get("u");
            if (cw1 != null)
            {
                cx1.a(a(map), b(map), cw1);
                return;
            } else
            {
                cx1.a(a(map), b(map), (String)map.get("html"), (String)map.get("baseurl"));
                return;
            }
        } else
        {
            cx1.a(new bj((String)map.get("i"), (String)map.get("u"), (String)map.get("m"), (String)map.get("p"), (String)map.get("c"), (String)map.get("f"), (String)map.get("e")));
            return;
        }
    }
}
