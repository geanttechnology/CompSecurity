// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.log;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;

// Referenced classes of package com.socialin.android.apiv3.log:
//            EventLoggingService

final class a
    implements Runnable
{

    private EventLoggingService a;

    public final void run()
    {
        try
        {
            EventLoggingService.access$702(a, AdvertisingIdClient.getAdvertisingIdInfo(a.getApplicationContext()).getId());
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    ient.Info(EventLoggingService eventloggingservice)
    {
        a = eventloggingservice;
        super();
    }
}
