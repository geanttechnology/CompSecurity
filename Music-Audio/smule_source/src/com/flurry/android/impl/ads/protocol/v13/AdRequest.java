// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.impl.ads.protocol.v13;

import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.android.impl.ads.protocol.v13:
//            AdViewContainer, AdViewType, Location, NativeAdConfiguration, 
//            TargetingOverride

public class AdRequest
{

    public List adReportedIds;
    public String adSpaceName;
    public boolean adTrackingEnabled;
    public AdViewContainer adViewContainer;
    public AdViewType adViewType;
    public String agentVersion;
    public String apiKey;
    public String appBundleId;
    public String bCookie;
    public List bcat;
    public List bindings;
    public boolean canDoSKAppStore;
    public Map clientSideRtbPayload;
    public String devicePlatform;
    public List frequencyCapRequestInfoList;
    public Map keywords;
    public String locale;
    public Location location;
    public NativeAdConfiguration nativeAdConfiguration;
    public int networkStatus;
    public List origins;
    public String osVersion;
    public String preferredLanguage;
    public boolean renderTime;
    public long requestTime;
    public boolean sendConfiguration;
    public long sessionId;
    public List streamInfoList;
    public TargetingOverride targetingOverride;
    public boolean testDevice;
    public String timezone;
    public String userAgent;

    public AdRequest()
    {
    }
}
