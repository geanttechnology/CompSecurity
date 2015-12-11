// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;


// Referenced classes of package com.tapjoy:
//            TapjoyConnectCore, TapjoyGpsHelper, TapjoyLog

final class a
    implements Runnable
{

    final TapjoyConnectCore a;

    public final void run()
    {
        TapjoyConnectCore.b(a).loadAdvertisingId();
        if (TapjoyConnectCore.b(a).isGooglePlayServicesAvailable() && TapjoyConnectCore.b(a).isGooglePlayManifestConfigured())
        {
            TapjoyConnectCore.b = TapjoyConnectCore.b(a).getDeviceGooglePlayServicesVersion();
            TapjoyConnectCore.a = TapjoyConnectCore.b(a).getPackagedGooglePlayServicesVersion();
        }
        if (TapjoyConnectCore.b(a).isAdIdAvailable())
        {
            TapjoyConnectCore.d = TapjoyConnectCore.b(a).isAdTrackingEnabled();
            TapjoyConnectCore.c = TapjoyConnectCore.b(a).getAdvertisingId();
        }
        if (TapjoyConnectCore.a())
        {
            TapjoyLog.i("TapjoyConnect", "Disabling persistent IDs. Do this only if you are not using Tapjoy to manage currency.");
        }
        a.completeConnectCall();
    }

    (TapjoyConnectCore tapjoyconnectcore)
    {
        a = tapjoyconnectcore;
        super();
    }
}
