// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.apls;

import android.content.Context;
import com.ebay.nautilus.domain.analytics.DeviceInfoUtil;
import java.util.Locale;

public final class AplsClientInfo
{

    public final String appBuildIdentifier;
    public final String appVersion;
    public final String carrier;
    public final String clientType;
    public final String config;
    public final String countryCode;
    public String deviceGuid;
    public final String environment;
    public final String globalId;
    public final String localeIdentifier;
    public final String mrollp;
    public final String network;
    public final String networkSubType;
    public final String osName;
    public final String osVersion;
    public final String platform;
    public final int rolloutThreshold;
    public final String sessionGuid;
    public final int siteId;
    public final String userId;
    public final String userLanguage;

    public AplsClientInfo(Context context, String s, String s1, String s2, String s3, int i, String s4, 
            String s5, String s6, String s7, String s8, String s9, String s10, String s11, 
            String s12, String s13, int j, String s14)
    {
        sessionGuid = s;
        network = DeviceInfoUtil.getNetworkType(context);
        networkSubType = DeviceInfoUtil.getMobileNetworkType(context);
        environment = s1;
        clientType = s2;
        globalId = s3;
        siteId = i;
        osName = s4;
        osVersion = s5;
        platform = s6;
        appVersion = s7;
        appBuildIdentifier = s8;
        localeIdentifier = s9;
        userLanguage = s10;
        userId = s11;
        carrier = s12;
        countryCode = s13;
        rolloutThreshold = j;
        mrollp = String.format(Locale.US, "%.2f", new Object[] {
            Float.valueOf(j)
        });
        config = s14;
    }

    public void setDeviceGuid(String s)
    {
        deviceGuid = s;
    }
}
