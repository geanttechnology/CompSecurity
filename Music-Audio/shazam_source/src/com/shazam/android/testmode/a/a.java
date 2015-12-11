// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.testmode.a;

import com.shazam.server.response.config.Provider;
import java.util.Map;

// Referenced classes of package com.shazam.android.testmode.a:
//            e

public final class a
    implements e
{

    private static final Map a;

    public a()
    {
    }

    public final Provider a()
    {
        return com.shazam.server.response.config.Provider.Builder.provider().withName("adcolony").withSites(a).withProviderKey("appb00006dc1a2448049c").build();
    }

    static 
    {
        Map map = com.shazam.i.e.a.a(0);
        a = map;
        map.put("newsfeed", "vz66f05ee8873f4b7787");
        a.put("track", "vz66f05ee8873f4b7787");
    }
}
