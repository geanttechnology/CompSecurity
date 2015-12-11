// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.impl.ads.protocol.v13;

import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.android.impl.ads.protocol.v13:
//            AdViewType, NativeAdInfo, ScreenOrientationType

public class AdUnit
{

    public List adFrames;
    public String adSpace;
    public AdViewType adViewType;
    public String adomain;
    public Map clientSideRtbPayload;
    public long closableTimeMillis15SecOrLess;
    public long closableTimeMillisLongerThan15Sec;
    public int combinable;
    public long expiration;
    public List frequencyCapResponseInfoList;
    public String groupId;
    public NativeAdInfo nativeAdInfo;
    public int preCacheAdSkippableTimeLimitMillis;
    public boolean preRender;
    public long preRenderTimeoutMillis;
    public long price;
    public boolean renderTime;
    public boolean rewardable;
    public ScreenOrientationType screenOrientation;
    public boolean supportMRAID;
    public boolean videoAutoPlay;
    public int videoPctCompletionForMoreInfo;
    public int videoPctCompletionForReward;
    public long viewabilityDurationMillis;
    public int viewabilityPercentVisible;

    public AdUnit()
    {
    }
}
