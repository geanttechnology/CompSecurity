// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import android.content.Context;
import com.conviva.LivePass;
import com.espn.androidplayersdk.utilities.Utils;
import java.util.Map;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            EPSDKPrefs, DataManager, DeviceData

public class ESPNPlayerSdk
{

    public static String DEVICE_OPTION_KEY = "device_key";
    protected static boolean IS_QA = false;
    public static String SDKTAG = "EspnSDK";
    public static String SDK_VERSION = "1.3.0";
    protected static String SDK_VERSION_FOR_API = "1.0.3";
    public static Context mCtx;

    public ESPNPlayerSdk()
    {
    }

    public static void init(Context context, String s)
    {
        init(context, s, null);
    }

    public static void init(Context context, String s, Map map)
    {
        mCtx = context;
        EPSDKPrefs.ctx = context;
        (new EPSDKPrefs()).putField("logging", "loggingLevel", "6");
        (new EPSDKPrefs()).putField("startSession", "affiliate", s);
        if (EPSDKPrefs.shouldOverwriteAffiliateID())
        {
            (new EPSDKPrefs()).putField("analytics", "affiliateId", s);
        }
        (new DataManager()).initializeDataFactory(context);
        if (EPSDKPrefs.getUUID().isEmpty())
        {
            (new EPSDKPrefs()).putField("config", "uuid", android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id"));
        }
        if (map != null && map.containsKey(DEVICE_OPTION_KEY))
        {
            DeviceData.overrideDeviceType((String)map.get(DEVICE_OPTION_KEY));
            return;
        } else
        {
            DeviceData.getDeviceType();
            return;
        }
    }

    public static void setIsQA(boolean flag)
    {
        IS_QA = flag;
    }

    public static void setLogginglevel(int i)
    {
        (new EPSDKPrefs()).putField("logging", "loggingLevel", Integer.toString(i));
        if (i != 6)
        {
            try
            {
                Logger.setLogLevel(2);
                LivePass.toggleTraces(Boolean.valueOf(true));
                return;
            }
            catch (Exception exception)
            {
                (new EPSDKPrefs()).putField("logging", "loggingLevel", "1");
            }
            break MISSING_BLOCK_LABEL_66;
        }
        Logger.setLogLevel(6);
        LivePass.toggleTraces(Boolean.valueOf(false));
        return;
        Utils.sdkLog("Unable to set Logging level. Defaulting to Verbose", 5, null);
        return;
    }

    public static void unInit()
    {
        (new DataManager()).deinitializeDataFactory();
    }

}
