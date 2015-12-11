// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.Context;
import android.os.Build;
import com.amazon.mShop.net.CookieBridge;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.pushnotification.NotificationProvider;
import com.amazon.mShop.pushnotification.PushNotificationManager;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.services.mShop.KiangApplicationInformation;
import com.amazon.rio.j2me.client.services.mShop.KiangApplicationState;
import com.amazon.rio.j2me.client.services.mShop.KiangDeviceUniqueId;
import com.amazon.rio.j2me.client.services.mShop.KiangPushInformation;
import com.amazon.rio.j2me.client.services.mShop.KiangSecurity;

// Referenced classes of package com.amazon.mShop.util:
//            AttributionUtils, Util

public class DeviceUtils
{

    public static String APPLICATOIN_IDENTIFIER = "AmazonShopping";
    public static String OS_IDENTIFIER_ANDROID = "Android";
    public static String UNIQUE_DEVICE_ID = "UDID";

    public DeviceUtils()
    {
    }

    public static KiangDeviceUniqueId getDeviceUniqueId(Context context)
    {
        context = new KiangDeviceUniqueId();
        String s = AndroidPlatform.getInstance().getDeviceId();
        context.setType(UNIQUE_DEVICE_ID);
        context.setValue(s);
        return context;
    }

    public static KiangApplicationInformation getKiangAppInfomation(Context context)
    {
        KiangApplicationInformation kiangapplicationinformation = new KiangApplicationInformation();
        String s = CookieBridge.getUbidCookie(context);
        String s2 = (new StringBuilder()).append(Build.MANUFACTURER).append(" ").append(Build.MODEL).toString();
        String s3 = com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationVersion();
        String s1 = AttributionUtils.getAssociatesTag(context);
        if (s == null)
        {
            s = "";
        }
        if (s1 == null)
        {
            s1 = "";
        }
        kiangapplicationinformation.setUbid(s);
        kiangapplicationinformation.setHardwareIdentifier(s2);
        kiangapplicationinformation.setOsIdentifier(OS_IDENTIFIER_ANDROID);
        kiangapplicationinformation.setOsVersion(android.os.Build.VERSION.RELEASE);
        kiangapplicationinformation.setApplicationIdentifier(APPLICATOIN_IDENTIFIER);
        kiangapplicationinformation.setApplicationVersion(s3);
        kiangapplicationinformation.setAssociateTag(s1);
        kiangapplicationinformation.setDeviceUniqueId(getDeviceUniqueId(context));
        return kiangapplicationinformation;
    }

    public static KiangApplicationState getKiangApplicationState(Context context)
    {
        KiangApplicationState kiangapplicationstate = new KiangApplicationState();
        kiangapplicationstate.setApplicationInstallId(com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("applicationInstallId"));
        kiangapplicationstate.setApplicationInformation(getKiangAppInfomation(context));
        kiangapplicationstate.setApplicationInstanceInformation(null);
        kiangapplicationstate.setPushInformation(getKiangPushInformation());
        return kiangapplicationstate;
    }

    public static KiangPushInformation getKiangPushInformation()
    {
        KiangPushInformation kiangpushinformation = new KiangPushInformation();
        Object obj = null;
        Object obj1 = null;
        String s1 = obj;
        String s = obj1;
        if (PushNotificationManager.getInstance() != null)
        {
            s1 = obj;
            s = obj1;
            if (PushNotificationManager.getInstance().getNotificationProvider() != null)
            {
                s1 = PushNotificationManager.getInstance().getNotificationProvider().getProviderName();
                s = PushNotificationManager.getInstance().getNotificationProvider().getCurrentMShopRegistrationToken();
            }
        }
        if (Util.isEmpty(s1) || Util.isEmpty(s))
        {
            return null;
        } else
        {
            kiangpushinformation.setProvider(s1);
            kiangpushinformation.setSecret(s);
            return kiangpushinformation;
        }
    }

    public static KiangSecurity getKiangSecurity()
    {
        return null;
    }

}
