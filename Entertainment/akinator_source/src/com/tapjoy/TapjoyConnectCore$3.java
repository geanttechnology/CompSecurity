// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;


// Referenced classes of package com.tapjoy:
//            TapjoyConnectCore, TapjoyLog, TapjoyURLConnection, TapjoyHttpURLResponse

static final class e
    implements Runnable
{

    public final void run()
    {
        TapjoyLog.i("TapjoyConnect", "setUserID...");
        TapjoyHttpURLResponse tapjoyhttpurlresponse = TapjoyConnectCore.d().getResponseFromURL((new StringBuilder()).append(TapjoyConnectCore.getHostURL()).append("set_publisher_user_id?").toString(), TapjoyConnectCore.getURLParams());
        if (tapjoyhttpurlresponse.response != null)
        {
            TapjoyConnectCore.b(tapjoyhttpurlresponse.response);
            TapjoyLog.i("TapjoyConnect", "setUserID successful...");
        }
    }

    e()
    {
    }
}
