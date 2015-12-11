// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.f.a;

import android.support.v4.f.a;
import com.target.mothership.b;
import com.target.mothership.services.n;
import com.target.mothership.util.o;
import java.util.Map;
import java.util.UUID;

// Referenced classes of package com.target.mothership.services.f.a:
//            b, c

public class e extends com.target.mothership.services.f.a.b
{

    private static final String AUTHORIZATION_KEY_HEADER = "Authorization";
    private static final String REDSKY_KEY_PREFIX = "redsky-api-key=";
    private static final String UNKNOWN_DEVICE_ID = "Unknown";
    private static final String X_DEVICE_ID_HEADER = "X-DEVICE-ID";
    private static final String X_REQUEST_ID_HEADER = "X-REQUEST-ID";
    private final String X_CLIENT_DEVICE_MODEL_HEADER = "X-DEVICE-MODEL";
    private final String X_CLIENT_PLATFORM_HEADER = "X-CLIENT-PLATFORM";
    private final String X_CLIENT_PLATFORM_HEADER_VALUE = "android";
    private final String X_CLIENT_VERSION_HEADER = "X-CLIENT-VERSION";

    public e(com.target.mothership.services.f.b.a a1)
    {
        super(a1);
    }

    private Map a()
    {
        a a1 = new a();
        a1.put("X-REQUEST-ID", c());
        a1.put("X-DEVICE-ID", d());
        a1.put("Authorization", b());
        a1.put("X-CLIENT-PLATFORM", "android");
        a1.put("X-CLIENT-VERSION", com.target.mothership.b.a().i().a());
        a1.put("X-DEVICE-MODEL", com.target.mothership.b.a().i().b());
        return a1;
    }

    private String b()
    {
        StringBuilder stringbuilder = new StringBuilder("redsky-api-key=");
        String s = com.target.mothership.b.a().c();
        if (o.g(s))
        {
            stringbuilder.append(s);
        }
        return stringbuilder.toString();
    }

    private String c()
    {
        return UUID.randomUUID().toString();
    }

    private String d()
    {
        String s1 = com.target.mothership.b.a().j();
        String s = s1;
        if (!o.g(s1))
        {
            s = "Unknown";
        }
        return s;
    }

    protected b.b a(c c1, n n, Map map, Map map1, Map map2)
    {
        Map map3 = a();
        if (map2 != null)
        {
            map3.putAll(map2);
        }
        return super.a(c1, n, map, map1, map3);
    }
}
