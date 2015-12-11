// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.Map;

// Referenced classes of package com.tapjoy.internal:
//            cg, bu, gd, ga

public abstract class hb extends cg
{

    public hb()
    {
    }

    protected Object a(bu bu1)
    {
        bu1.t();
        return null;
    }

    public final volatile Object b()
    {
        return bi.a.b;
    }

    public final String d()
    {
        return "application/json";
    }

    public Map e()
    {
        Map map = super.e();
        gd gd1 = gd.a();
        map.put("sdk_ver", (new StringBuilder()).append(gd1.d()).append("/Android").toString());
        map.put("api_key", gd1.c());
        if (ga.a)
        {
            map.put("debug", Boolean.valueOf(true));
        }
        return map;
    }

    protected Object f()
    {
        Object obj;
        try
        {
            obj = super.f();
        }
        catch (Exception exception)
        {
            throw exception;
        }
        return obj;
    }
}
