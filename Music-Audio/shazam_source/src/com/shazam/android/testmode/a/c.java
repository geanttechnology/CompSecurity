// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.testmode.a;

import com.shazam.i.e.a;
import com.shazam.server.response.config.Provider;
import java.util.Map;

// Referenced classes of package com.shazam.android.testmode.a:
//            e

public final class c
    implements e
{

    private static final Map a;

    public c()
    {
    }

    public final Provider a()
    {
        return com.shazam.server.response.config.Provider.Builder.provider().withName("facebook").withSites(a).build();
    }

    static 
    {
        Map map = com.shazam.i.e.a.a(0);
        a = map;
        map.put("track", "210827375150_10154120385475151");
        a.put("nomatchlarge", "210827375150_10154144463805151");
    }
}
