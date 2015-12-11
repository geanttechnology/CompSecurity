// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.util;

import java.util.Map;

// Referenced classes of package com.comcast.playerplatform.primetime.android.util:
//            ThirdPartyVersions

public class PlayerPlatformVersion
{

    public PlayerPlatformVersion()
    {
    }

    public static String getAdobeVersion()
    {
        return ThirdPartyVersions.getAdobeVersion();
    }

    public static String getDisneyVersion()
    {
        return ThirdPartyVersions.getDisneyVersion();
    }

    public static String getEspnVersion()
    {
        return ThirdPartyVersions.getEspnVersion();
    }

    public static String getPlayerPlatformVersion()
    {
        return "3.4.2.4";
    }

    public static Map getThirdPartyVersions()
    {
        return ThirdPartyVersions.getThirdPartyVersions();
    }
}
