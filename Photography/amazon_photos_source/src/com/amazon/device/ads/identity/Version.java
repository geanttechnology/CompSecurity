// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;


class Version
{

    private static String buildVersion = "5.5.40";
    private static String devBuild = "(DEV)";
    private static String prefixVersion = "amznAdSDK-android-identity-";
    private static String sdkVersion = null;
    private static String userAgentPrefixVersion = "AmazonAdSDK-Android/";
    private static String userAgentSDKVersion = null;

    public static String getSDKVersion()
    {
        if (sdkVersion != null) goto _L2; else goto _L1
_L1:
        String s1;
        StringBuilder stringbuilder;
        stringbuilder = (new StringBuilder()).append(prefixVersion);
        s1 = buildVersion;
        if (s1 != null && !s1.equals("")) goto _L4; else goto _L3
_L3:
        String s = devBuild;
_L6:
        sdkVersion = stringbuilder.append(s).toString();
_L2:
        return sdkVersion;
_L4:
        s = s1;
        if (s1.endsWith("x"))
        {
            s = (new StringBuilder()).append(s1).append(devBuild).toString();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

}
