// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.config;

import com.comcast.cim.config.CALConfiguration;
import java.net.URI;
import java.util.List;

public abstract class PlayerConfiguration
    implements CALConfiguration
{

    private long CONSECUTIVE_TIME_IN_PLAYER_BEFORE_RATINGS_PROMPT;
    protected String CONSUMABLES_HYPERMEDIA_SERVICES_URL;
    protected URI EDITORIAL_COVERS_URI;
    protected URI EDITORIAL_VIDEO_URI;
    protected String TVE_HYPERMEDIA_SERVICES_URL;
    protected String XIP_URI;

    public PlayerConfiguration()
    {
        CONSECUTIVE_TIME_IN_PLAYER_BEFORE_RATINGS_PROMPT = 0xdbba0L;
    }

    public String getConsumablesHypermediaUrl()
    {
        return CONSUMABLES_HYPERMEDIA_SERVICES_URL;
    }

    public long getDataRevalidationIntervalInMillis()
    {
        return 0xdbba0L;
    }

    public PlayerConfiguration getDeveloperConfiguration()
    {
        return null;
    }

    public URI getEditorialCoversUri()
    {
        return EDITORIAL_COVERS_URI;
    }

    public URI getEditorialVideoUri()
    {
        return EDITORIAL_VIDEO_URI;
    }

    public String getEntityThumbnailUri()
    {
        return "http://xfinitytv.comcast.net/api/entity/thumbnail";
    }

    public abstract List getFlyinMenuOptions();

    public int getHypermediaRevalidationInterval()
    {
        return 0x5265c00;
    }

    public long getMinVersionCheckRevalidationIntervalInMillis()
    {
        return 0x5265c00L;
    }

    public String getRobotoFamilyName()
    {
        return "roboto";
    }

    public String getSplunkAppName()
    {
        return "androidplayer";
    }

    public long getTimeElapsedWithoutLeavingThePlayerBeforeRatingsPrompt()
    {
        return CONSECUTIVE_TIME_IN_PLAYER_BEFORE_RATINGS_PROMPT;
    }

    public String getTveHypermediaUrl()
    {
        return TVE_HYPERMEDIA_SERVICES_URL;
    }

    public String getUserAgentPrefix()
    {
        return "XfinityTVPlayer";
    }

    public String getXfinitySansFamilyName()
    {
        return "xfinitysans";
    }

    public String getXipUri()
    {
        return XIP_URI;
    }

    public boolean isDarkStreamsEnabled()
    {
        return false;
    }

    public boolean isDeveloperModeAllowed()
    {
        return false;
    }

    public boolean isDeveloperModeEnabled()
    {
        return false;
    }

    public void setDarkStreamsEnabled(Boolean boolean1)
    {
        throw new IllegalStateException("Developer options not available for non-developer builds");
    }

    public void setDeveloperConfiguration(PlayerConfiguration playerconfiguration)
    {
        throw new IllegalStateException("Developer mode not available for non-developer builds");
    }

    public void setDeveloperModeEnabled(boolean flag)
    {
        throw new IllegalStateException("Developer mode not available for non-developer builds");
    }

    public abstract boolean shouldSuppressNetworkLogos();
}
