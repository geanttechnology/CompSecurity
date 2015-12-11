// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.conviva;

import java.util.HashMap;
import java.util.Map;

public class ConvivaContentInfo
{

    public String assetName;
    public int defaultReportingBitrateKbps;
    public String defaultReportingCdnName;
    public String defaultReportingResource;
    public String deviceId;
    public String deviceType;
    public String frameworkName;
    public String frameworkVersion;
    public Boolean isLive;
    public String playerName;
    public String pluginName;
    public String pluginVersion;
    public String streamUrl;
    public Map tags;
    public String viewerId;

    public ConvivaContentInfo(String s, Map map)
    {
        assetName = null;
        defaultReportingBitrateKbps = -1;
        defaultReportingCdnName = "OTHER";
        defaultReportingResource = null;
        frameworkName = null;
        frameworkVersion = null;
        pluginName = null;
        pluginVersion = null;
        viewerId = null;
        deviceId = null;
        deviceType = null;
        playerName = null;
        streamUrl = null;
        isLive = Boolean.valueOf(false);
        assetName = s;
        tags = map;
        if (map == null)
        {
            new HashMap();
        }
    }
}
