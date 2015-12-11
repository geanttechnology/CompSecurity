// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.c;
import com.google.android.gms.common.d;
import java.io.IOException;

// Referenced classes of package com.amazon.device.ads:
//            co, cm, cn

class br
{

    private static final String a = com/amazon/device/ads/br.getSimpleName();
    private final cn b;

    br()
    {
        new co();
        b = co.a(a);
    }

    public final bq.a a()
    {
        Object obj = cm.a().b();
        Object obj1;
        boolean flag;
        try
        {
            obj1 = AdvertisingIdClient.getAdvertisingIdInfo(((android.content.Context) (obj)));
        }
        catch (IllegalStateException illegalstateexception)
        {
            b.d("The Google Play Services Advertising Id API was called from a non-background thread.", null);
            return new bq.a();
        }
        catch (IOException ioexception)
        {
            b.d("Retrieving the Google Play Services Advertising Identifier caused an IOException.", null);
            return new bq.a();
        }
        catch (c c1)
        {
            b.b("Retrieving the Google Play Services Advertising Identifier caused a GooglePlayServicesNotAvailableException.");
            return bq.a.a();
        }
        catch (d d1)
        {
            b.b("Retrieving the Google Play Services Advertising Identifier caused a GooglePlayServicesRepairableException.");
            return new bq.a();
        }
        b.b("The Google Play Services Advertising Identifier was successfully retrieved.");
        obj = ((com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) (obj1)).getId();
        flag = ((com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) (obj1)).isLimitAdTrackingEnabled();
        obj1 = new bq.a();
        obj1.b = ((String) (obj));
        obj1.c = flag;
        return ((bq.a) (obj1));
    }

}
