// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import java.util.HashMap;

// Referenced classes of package com.amazon.device.ads:
//            AmazonOOHybridAdBridge, AdvertisingIdentifier, InternalAdRegistration, IInternalAdRegistration, 
//            DeviceInfo

public static class 
{

    protected static  getAmazonOOHybridAdBridgeInfo()
    {
        return new <init>();
    }

    public final HashMap getAppInfo()
    {
        HashMap hashmap;
label0:
        {
            hashmap = new HashMap();
            <init> <init>1 = (new AdvertisingIdentifier()).getAdvertisingIdentifierInfo();
            if (<init>1.())
            {
                hashmap.put("stableIdentityServiceId", <init>1.());
                if (!<init>1.r())
                {
                    break label0;
                }
                hashmap.put("advertisingIdentifier", <init>1.r());
                hashmap.put("advertisingTrackingEnabled", Boolean.valueOf(<init>1.d()));
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
        (new d()).d(context).d(s).d();
    }

    public void openInAppBrowserWithExternalBrowserButton(Context context, String s)
    {
        (new d()).d(context).d(s).erButton().erButton();
    }

    private ()
    {
    }
}
