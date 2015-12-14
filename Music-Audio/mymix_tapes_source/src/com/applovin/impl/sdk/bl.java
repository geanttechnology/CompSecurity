// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.applovin.impl.sdk:
//            AppLovinAdImpl

public class bl
{

    private static bl d;
    private final Map a = new HashMap(1);
    private final Map b = new HashMap(1);
    private final Object c = new Object();

    private bl()
    {
    }

    public static bl a()
    {
        com/applovin/impl/sdk/bl;
        JVM INSTR monitorenter ;
        bl bl1;
        if (d == null)
        {
            d = new bl();
        }
        bl1 = d;
        com/applovin/impl/sdk/bl;
        JVM INSTR monitorexit ;
        return bl1;
        Exception exception;
        exception;
        throw exception;
    }

    public Map a(AppLovinAd applovinad)
    {
        Object obj = (AppLovinAdImpl)applovinad;
        synchronized (c)
        {
            obj = (Map)b.remove(obj);
        }
        return ((Map) (obj));
        exception;
        applovinad;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(AppLovinAd applovinad, String s)
    {
        AppLovinAdImpl applovinadimpl = (AppLovinAdImpl)applovinad;
        synchronized (c)
        {
            a.put(applovinadimpl, s);
        }
        return;
        s;
        applovinad;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void a(AppLovinAd applovinad, Map map)
    {
        AppLovinAdImpl applovinadimpl = (AppLovinAdImpl)applovinad;
        synchronized (c)
        {
            b.put(applovinadimpl, map);
        }
        return;
        map;
        applovinad;
        JVM INSTR monitorexit ;
        throw map;
    }

    public String b(AppLovinAd applovinad)
    {
        Object obj = (AppLovinAdImpl)applovinad;
        synchronized (c)
        {
            obj = (String)a.remove(obj);
        }
        return ((String) (obj));
        exception;
        applovinad;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
