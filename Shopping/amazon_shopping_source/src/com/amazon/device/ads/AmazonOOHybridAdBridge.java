// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import java.util.HashMap;

// Referenced classes of package com.amazon.device.ads:
//            Settings, InternalAdRegistration, IInternalAdRegistration, AdvertisingIdentifier, 
//            DeviceInfo

public class AmazonOOHybridAdBridge
{
    public static class AmazonOOHybridAdBridgeInfo
    {

        protected static AmazonOOHybridAdBridgeInfo getAmazonOOHybridAdBridgeInfo()
        {
            return new AmazonOOHybridAdBridgeInfo();
        }

        public final HashMap getAppInfo()
        {
            HashMap hashmap;
label0:
            {
                hashmap = new HashMap();
                AdvertisingIdentifier.Info info = (new AdvertisingIdentifier()).getAdvertisingIdentifierInfo();
                if (info.canDo())
                {
                    hashmap.put("stableIdentityServiceId", info.getSISDeviceIdentifier());
                    if (!info.hasAdvertisingIdentifier())
                    {
                        break label0;
                    }
                    hashmap.put("advertisingIdentifier", info.getAdvertisingIdentifier());
                    hashmap.put("advertisingTrackingEnabled", Boolean.valueOf(info.isLimitAdTrackingEnabled()));
                }
                return hashmap;
            }
            DeviceInfo deviceinfo = InternalAdRegistration.getInstance().getDeviceInfo();
            hashmap.put("advertisingIdentifier", deviceinfo.getUdid());
            hashmap.put("advertisingIdentifierMD5", deviceinfo.getUdidMd5());
            hashmap.put("advertisingIdentifierSHA1", deviceinfo.getUdidSha1());
            hashmap.put("advertisingTrackingEnabled", Boolean.valueOf(true));
            return hashmap;
        }

        public void openInAppBrowser(Context context, String s)
        {
            (new MraidBrowser.MraidBrowserBuilder()).withContext(context).withUrl(s).show();
        }

        public void openInAppBrowserWithExternalBrowserButton(Context context, String s)
        {
            (new MraidBrowser.MraidBrowserBuilder()).withContext(context).withUrl(s).withExternalBrowserButton().show();
        }

        private AmazonOOHybridAdBridgeInfo()
        {
        }
    }

    public static interface AmazonOOHybridAdBridgeListener
    {

        public abstract void onHybridAdBridgeInfoReceived(AmazonOOHybridAdBridgeInfo amazonoohybridadbridgeinfo);
    }

    private static class AmazonOOHybridAdBridgeSettingsListener
        implements Settings.SettingsListener
    {

        private final AmazonOOHybridAdBridgeListener listener;

        public void settingsLoaded()
        {
            listener.onHybridAdBridgeInfoReceived(AmazonOOHybridAdBridgeInfo.getAmazonOOHybridAdBridgeInfo());
        }

        public AmazonOOHybridAdBridgeSettingsListener(AmazonOOHybridAdBridgeListener amazonoohybridadbridgelistener)
        {
            listener = amazonoohybridadbridgelistener;
        }
    }


    public static final String APP_INFO_ADVERTISING_IDENTIFIER_KEY = "advertisingIdentifier";
    public static final String APP_INFO_ADVERTISING_IDENTIFIER_MD5_KEY = "advertisingIdentifierMD5";
    public static final String APP_INFO_ADVERTISING_IDENTIFIER_SHA1_KEY = "advertisingIdentifierSHA1";
    public static final String APP_INFO_ADVERTISING_TRACKING_ENABLED_KEY = "advertisingTrackingEnabled";
    public static final String APP_INFO_STABLE_IDENTITY_SERVICE_ID_KEY = "stableIdentityServiceId";

    public AmazonOOHybridAdBridge()
    {
    }

    public static final void listenForHybridAdBridgeInfo(AmazonOOHybridAdBridgeListener amazonoohybridadbridgelistener)
    {
        Settings.getInstance().listenForSettings(new AmazonOOHybridAdBridgeSettingsListener(amazonoohybridadbridgelistener));
    }

    public static final void prepareHybridAdBridgeInfo(Context context)
    {
        InternalAdRegistration.getInstance().contextReceived(context);
    }

    public static final void prepareHybridAdBridgeInfo(Context context, AmazonOOHybridAdBridgeListener amazonoohybridadbridgelistener)
    {
        prepareHybridAdBridgeInfo(context);
        listenForHybridAdBridgeInfo(amazonoohybridadbridgelistener);
    }
}
