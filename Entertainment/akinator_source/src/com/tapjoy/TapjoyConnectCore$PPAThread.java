// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import java.util.Map;

// Referenced classes of package com.tapjoy:
//            TapjoyConnectCore, TapjoyURLConnection, TapjoyHttpURLResponse

public class b
    implements Runnable
{

    final TapjoyConnectCore a;
    private Map b;

    public void run()
    {
        TapjoyHttpURLResponse tapjoyhttpurlresponse = TapjoyConnectCore.d().getResponseFromURL((new StringBuilder()).append(TapjoyConnectCore.getHostURL()).append("api/connect/v3.json?").toString(), null, null, b);
        if (tapjoyhttpurlresponse.response != null)
        {
            TapjoyConnectCore tapjoyconnectcore = a;
            TapjoyConnectCore.c(tapjoyhttpurlresponse.response);
        }
    }

    public (TapjoyConnectCore tapjoyconnectcore, Map map)
    {
        a = tapjoyconnectcore;
        super();
        b = map;
    }
}
