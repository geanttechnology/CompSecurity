// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.asset;

import com.comcast.playerplatform.primetime.android.ads.PlayerAdBreakPolicies;
import com.comcast.playerplatform.primetime.android.enums.AdType;
import java.util.List;
import java.util.Map;

public class AdData
{
    public static class Builder
    {

        public Builder()
        {
        }
    }


    private final PlayerAdBreakPolicies adBreakPolicies;
    private final List adBreaks;
    private final AdType adType;
    private final String mediaId;
    private Map targetingParameters;

    public PlayerAdBreakPolicies getAdBreakPolicies()
    {
        return adBreakPolicies;
    }

    public List getAdBreaks()
    {
        return adBreaks;
    }

    public AdType getAdType()
    {
        return adType;
    }

    public String getMediaId()
    {
        return mediaId;
    }

    public Map getTargetingParameters()
    {
        return targetingParameters;
    }
}
