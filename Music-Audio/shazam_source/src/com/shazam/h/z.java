// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h;

import com.shazam.android.analytics.orbit.OrbitErrorAnalytics;
import java.net.URL;

// Referenced classes of package com.shazam.h:
//            x, o

public final class z
    implements x
{

    private final OrbitErrorAnalytics b;

    public z(OrbitErrorAnalytics orbiterroranalytics)
    {
        b = orbiterroranalytics;
    }

    public final void onConnecting(URL url)
    {
    }

    public final void onRequestSent(URL url, byte abyte0[])
    {
    }

    public final void onResponseReceived(URL url, o o1)
    {
        int i = o1.a;
        if (i >= 300 && i != 304)
        {
            b.sendBadServerResponse(url.toString(), i);
        }
    }
}
