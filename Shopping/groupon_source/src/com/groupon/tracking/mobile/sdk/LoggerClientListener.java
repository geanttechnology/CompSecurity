// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.sdk;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;
import com.groupon.tracking.mobile.EventLogHeader;
import com.groupon.tracking.mobile.MobileDeviceHeader;
import com.groupon.tracking.mobile.internal.ByteCountedOutputStream;
import java.io.IOException;

// Referenced classes of package com.groupon.tracking.mobile.sdk:
//            DeviceSettings

public class LoggerClientListener
    implements com.groupon.tracking.mobile.internal.LogClient.ClientListener
{

    private static final String packageNum = "PACKAGE_NUM";
    private static final String preferencesName = "NST_LOG";
    private Application application;
    private Integer sdkVersion;
    private DeviceSettings settings;

    public LoggerClientListener()
    {
    }

    public String getCountryCode()
    {
        return settings.getCountryCode();
    }

    public int getNextPackageNumber()
    {
        return application.getSharedPreferences("NST_LOG", 0).getInt("PACKAGE_NUM", 0);
    }

    public void onLogCreate(long l, String s, ByteCountedOutputStream bytecountedoutputstream)
        throws IOException
    {
        Log.d(com/groupon/tracking/mobile/sdk/LoggerClientListener.getName(), "Writing header");
        s = new EventLogHeader();
        s.version = sdkVersion.intValue();
        s.timestamp = l;
        bytecountedoutputstream.write(s.pack());
        s = new MobileDeviceHeader();
        s.platform = settings.getPlatform();
        s.appVersion = settings.getVersion();
        s.clientID = settings.getClientID();
        s.deviceID = settings.getDeviceID();
        s.bcookie = settings.getBcookie();
        s.userAgent = settings.getUserAgent();
        s.locale = settings.getLocale();
        s.countryCode = getCountryCode();
        s.userPermalink = settings.getUserPermalink();
        s.idfa = settings.getAdvertisingId();
        s.consumerId = settings.getConsumerId();
        bytecountedoutputstream.write(s.pack());
        s = application.getSharedPreferences("NST_LOG", 0);
        int i = s.getInt("PACKAGE_NUM", 0);
        Log.d(com/groupon/tracking/mobile/sdk/LoggerClientListener.getSimpleName(), (new StringBuilder()).append("package number").append(i).toString());
        s.edit().putInt("PACKAGE_NUM", i + 1).apply();
    }
}
