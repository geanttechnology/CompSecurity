// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.analytics;

import android.content.Context;
import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.comcast.playerplatform.primetime.android.util.FragmentInfo;
import com.comcast.playerplatform.primetime.android.util.LogFactory;
import com.comcast.playerplatform.primetime.android.util.PlayerLogger;

// Referenced classes of package com.comcast.playerplatform.primetime.android.analytics:
//            PlayerAnalytics

public class NullAnalyticsHandler
    implements PlayerAnalytics
{

    private PlayerLogger logger;

    public NullAnalyticsHandler()
    {
        logger = LogFactory.getInstance().getLogger();
    }

    private void log(String s)
    {
        logger.d("[com.comcast.playerplatform.primetime.analytics]::PlayerAnalytics", (new StringBuilder()).append("Analytics not configured for event: ").append(s).toString());
    }

    public void adProgress(int i, AbstractXuaAsset abstractxuaasset)
    {
        log("triggerAdProgress");
    }

    public void bitrateChanged(long l, AbstractXuaAsset abstractxuaasset)
    {
        log("bitrateChanged");
    }

    public void error(String s, String s1, String s2, AbstractXuaAsset abstractxuaasset)
    {
        log("error");
    }

    public void fragmentWarning(int i, int j, int k, String s, AbstractXuaAsset abstractxuaasset)
    {
        log("fragmentWarning");
    }

    public void heartBeat(Long long1, Long long2, Integer integer, String s, String s1, Long long3, AbstractXuaAsset abstractxuaasset, 
            FragmentInfo fragmentinfo)
    {
        log("heartBeat");
    }

    public void mediaEnded(AbstractXuaAsset abstractxuaasset)
    {
        log("mediaEnded");
    }

    public void mediaFailed(String s, long l, String s1, String s2, AbstractXuaAsset abstractxuaasset)
    {
        log("mediaFailed");
    }

    public void mediaInfo(int i, String s, AbstractXuaAsset abstractxuaasset)
    {
        log("mediaInfo");
    }

    public void mediaOpened(String s, long l, Long long1, AbstractXuaAsset abstractxuaasset)
    {
        log("mediaOpened");
    }

    public void openingMedia(String s, AbstractXuaAsset abstractxuaasset)
    {
        log("openingMedia");
    }

    public void playStateChanged(PlayerStatus playerstatus, AbstractXuaAsset abstractxuaasset)
    {
        log("playStateChanged");
    }

    public void playStateChanged(String s, AbstractXuaAsset abstractxuaasset)
    {
        log("playStateChanged");
    }

    public void pluginInitialized(Context context)
    {
        log("pluginInitialized");
    }

    public void retryAttempt(String s, String s1, String s2, int i, AbstractXuaAsset abstractxuaasset)
    {
        error(s, s1, s2, abstractxuaasset);
    }

    public void scrubEnded(int i, AbstractXuaAsset abstractxuaasset)
    {
        log("scrubEnded");
    }

    public void scrubStarted(int i, AbstractXuaAsset abstractxuaasset)
    {
        log("scrubStarted");
    }

    public void trickPlay(int i, String s, AbstractXuaAsset abstractxuaasset)
    {
        log("trickPlay");
    }
}
