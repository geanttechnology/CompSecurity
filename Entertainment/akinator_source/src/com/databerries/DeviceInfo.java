// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.databerries;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

// Referenced classes of package com.databerries:
//            Protocol, DataBerries

class DeviceInfo extends Application
{

    private static final String LimitId = "LimitAdTrackingEnabled";
    private static com.google.android.gms.ads.identifier.AdvertisingIdClient.Info adInfo;
    private static String advertiserId = null;
    private static String key = null;
    private static Protocol protocol;

    DeviceInfo()
    {
    }

    static void findAdInfo(Context context, DataBerries databerries)
    {
        (new Thread(new Runnable(context, databerries) {

            final Context val$context;
            final DataBerries val$dataBerries;

            public void run()
            {
label0:
                {
                    DeviceInfo.adInfo = DeviceInfo.getIdInfoInThread(context);
                    if (DeviceInfo.adInfo != null)
                    {
                        if (DeviceInfo.adInfo.isLimitAdTrackingEnabled())
                        {
                            break label0;
                        }
                        DeviceInfo.setAdvertiserId(DeviceInfo.adInfo.getId());
                        dataBerries.adInfoCallback();
                    }
                    return;
                }
                DeviceInfo.setAdvertiserId("LimitAdTrackingEnabled");
            }

            
            {
                context = context1;
                dataBerries = databerries;
                super();
            }
        })).start();
    }

    static String getAdvertiserId()
    {
        return advertiserId;
    }

    protected static int getAndroidAPILevel()
    {
        return android.os.Build.VERSION.SDK_INT;
    }

    static String getAndroidVersion()
    {
        return android.os.Build.VERSION.RELEASE;
    }

    private static com.google.android.gms.ads.identifier.AdvertisingIdClient.Info getIdInfoInThread(Context context)
    {
        context = AdvertisingIdClient.getAdvertisingIdInfo(context);
        return context;
        context;
        context.printStackTrace();
        return null;
        context;
_L2:
        Log.d("DataBerriesDeviceInfo", "An issue occurred while trying to use Google Play Services.");
        Log.d("DataBerriesDeviceInfo", Log.getStackTraceString(context));
        return null;
        context;
        continue; /* Loop/switch isn't completed */
        context;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static String getKey()
    {
        return key;
    }

    static Protocol getProtocol()
    {
        return protocol;
    }

    static boolean hasAdvertiserId()
    {
        return advertiserId != null;
    }

    private static void setAdvertiserId(String s)
    {
        advertiserId = s;
    }

    static void setKey(String s)
    {
        key = s;
    }

    static void setProtocol(Protocol protocol1)
    {
        protocol = protocol1;
    }

    static 
    {
        protocol = Protocol.HTTP;
    }



/*
    static com.google.android.gms.ads.identifier.AdvertisingIdClient.Info access$002(com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info)
    {
        adInfo = info;
        return info;
    }

*/


}
