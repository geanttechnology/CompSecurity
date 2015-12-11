// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.e;

import com.shazam.android.aq.c;
import com.shazam.android.j.o;
import com.shazam.server.response.config.AmpApis;
import com.shazam.server.response.config.AmpBeacon;
import com.shazam.server.response.config.AmpConfig;
import java.util.Map;

// Referenced classes of package com.shazam.android.j.e:
//            b

public final class a
    implements b
{

    private final c a;
    private final o b;

    public a(c c1, o o1)
    {
        a = c1;
        b = o1;
    }

    public final String a()
    {
        Object obj = a.a();
        if (((AmpConfig) (obj)).isEmpty())
        {
            return b.a("https://beacon.shazam.com/shazam/{appversion}/xx/XX/android/unconfigured/beacon/{inid}/");
        }
        String s = ((AmpConfig) (obj)).getAmpApis().getAmpBeacon().getBeaconHref();
        o o1 = b;
        obj = s;
        if (com.shazam.b.e.a.a(s))
        {
            obj = "https://beacon.shazam.com/shazam/{appversion}/xx/XX/android/unconfigured/beacon/{inid}/";
        }
        return o1.a(((String) (obj)));
    }

    public final Map b()
    {
        return a.a().getAmpApis().getAmpBeacon().getParams();
    }
}
