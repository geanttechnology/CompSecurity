// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.f.a;

import com.target.mothership.b;
import com.target.mothership.services.n;
import java.util.Map;

// Referenced classes of package com.target.mothership.services.f.a:
//            b, c

public class a extends com.target.mothership.services.f.a.b
{

    public static final String APP_VERSION = "appVersion";
    public static final String AUTHORIZATION_HEADER_KEY = "Authorization";
    public static final String BEARER = "Bearer ";

    public a(com.target.mothership.services.f.b.a a1)
    {
        super(a1);
    }

    private Map a(Map map)
    {
        Object obj = map;
        if (map == null)
        {
            obj = new android.support.v4.f.a();
        }
        ((Map) (obj)).put("appVersion", b.a().i().a());
        return ((Map) (obj));
    }

    protected b.b a(c c, n n, Map map, Map map1, Map map2)
    {
        return super.a(c, n, map, a(map1), map2);
    }

    protected b.b a(c c, n n, Map map, Map map1, Map map2, String s)
    {
        if (map2 == null)
        {
            map2 = new android.support.v4.f.a();
        }
        map2.put("Authorization", (new StringBuilder()).append("Bearer ").append(s).toString());
        return super.a(c, n, map, a(map1), map2);
    }
}
