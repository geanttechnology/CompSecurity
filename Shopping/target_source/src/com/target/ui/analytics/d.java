// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics;

import java.util.Map;

// Referenced classes of package com.target.ui.analytics:
//            h

public class d
{

    public static long a(h h1)
    {
        if (h1 == null || !h1.b())
        {
            return -1L;
        } else
        {
            return System.currentTimeMillis() - h1.c();
        }
    }

    public static void a(Map map, Object obj, Object obj1)
    {
        if (obj1 != null)
        {
            map.put(obj, obj1);
        }
    }
}
