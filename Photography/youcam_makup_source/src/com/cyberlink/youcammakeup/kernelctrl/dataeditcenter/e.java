// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter;

import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter:
//            f, g, DevelopSetting

public class e
{

    private ConcurrentHashMap a;

    public e()
    {
        a = new ConcurrentHashMap();
    }

    public static e a()
    {
        return f.a();
    }

    public DevelopSetting a(Long long1, Boolean boolean1)
    {
        if (long1 == null)
        {
            return null;
        }
        if (!a.containsKey(long1))
        {
            a.put(long1, new g(long1));
        }
        return ((g)a.get(long1)).a(boolean1.booleanValue());
    }

    public void a(long l)
    {
        if (!a.containsKey(Long.valueOf(l)))
        {
            a.put(Long.valueOf(l), new g(Long.valueOf(l)));
        }
        ((g)a.get(Long.valueOf(l))).b();
    }
}
