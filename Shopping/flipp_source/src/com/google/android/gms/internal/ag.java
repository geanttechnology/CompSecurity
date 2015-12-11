// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            af, ej, et, ew, 
//            ez, bj

public final class ag
    implements af
{

    public ag()
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
                return ej.c();
            }
            if ("l".equalsIgnoreCase(map))
            {
                return ej.b();
            }
        }
        return -1;
    }

    public final void a(ew ew1, Map map)
    {
        String s = (String)map.get("a");
        if (s == null)
        {
            et.d("Action missing from an open GMSG.");
            return;
        }
        ez ez1 = ew1.a;
        if ("expand".equalsIgnoreCase(s))
        {
            if (ew1.d())
            {
                et.d("Cannot expand WebView that is already expanded.");
                return;
            } else
            {
                ez1.a(a(map), b(map));
                return;
            }
        }
        if ("webapp".equalsIgnoreCase(s))
        {
            ew1 = (String)map.get("u");
            if (ew1 != null)
            {
                ez1.a(a(map), b(map), ew1);
                return;
            } else
            {
                ez1.a(a(map), b(map), (String)map.get("html"), (String)map.get("baseurl"));
                return;
            }
        } else
        {
            ez1.a(new bj((String)map.get("i"), (String)map.get("u"), (String)map.get("m"), (String)map.get("p"), (String)map.get("c"), (String)map.get("f"), (String)map.get("e")));
            return;
        }
    }
}
