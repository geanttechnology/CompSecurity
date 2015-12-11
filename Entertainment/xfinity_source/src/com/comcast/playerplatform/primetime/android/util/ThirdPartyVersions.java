// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.util;

import com.adobe.mediacore.Version;
import com.disney.datg.videoplatforms.sdk.media.Configuration;
import com.espn.androidplayersdk.datamanager.ESPNPlayerSdk;
import java.util.HashMap;
import java.util.Map;

public class ThirdPartyVersions
{

    public ThirdPartyVersions()
    {
    }

    public static String getAdobeVersion()
    {
        return Version.getVersion();
    }

    public static String getDisneyVersion()
    {
        return Configuration.version;
    }

    public static String getEspnVersion()
    {
        return ESPNPlayerSdk.SDK_VERSION;
    }

    public static Map getThirdPartyVersions()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("ESPN", ESPNPlayerSdk.SDK_VERSION);
        hashmap.put("Disney", Configuration.version);
        hashmap.put("Adobe", Version.getVersion());
        return hashmap;
    }
}
