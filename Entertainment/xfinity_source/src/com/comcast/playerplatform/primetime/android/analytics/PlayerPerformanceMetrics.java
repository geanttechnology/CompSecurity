// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.analytics;

import com.adobe.mediacore.qos.LoadInfo;
import com.comcast.playerplatform.analytics.java.AnalyticsProvider;
import com.comcast.playerplatform.analytics.java.xmessage.messages.PerformanceMessage;
import com.comcast.playerplatform.primetime.android.asset.Asset;

public class PlayerPerformanceMetrics
    implements com.adobe.mediacore.MediaPlayer.QOSEventListener
{

    private Asset asset;
    private boolean initialBufferFillSent;
    private long initialBufferStart;
    private boolean initialFragmentTimeSent;

    public PlayerPerformanceMetrics()
    {
    }

    private void sendPerformanceMetric(String s, long l)
    {
        AnalyticsProvider.getInstance().buildMessage(new PerformanceMessage(System.currentTimeMillis(), s, l, asset.buildXuaAsset()));
    }

    public void onBufferComplete()
    {
        if (!initialBufferFillSent && initialBufferStart != 0L)
        {
            sendPerformanceMetric("InitialBufferFillTime", System.currentTimeMillis() - initialBufferStart);
            initialBufferFillSent = true;
        }
    }

    public void onBufferStart()
    {
        if (!initialBufferFillSent)
        {
            initialBufferStart = System.currentTimeMillis();
        }
    }

    public void onLoadInfo(LoadInfo loadinfo)
    {
        long l = loadinfo.getDownloadDuration();
        if (loadinfo.getType() == com.adobe.mediacore.qos.LoadInfo.Type.MANIFEST)
        {
            sendPerformanceMetric("ManifestDownloadTime", l);
        } else
        if (loadinfo.getType() == com.adobe.mediacore.qos.LoadInfo.Type.FRAGMENT && !initialFragmentTimeSent)
        {
            sendPerformanceMetric("InitialFragmentRequestDownloadTime", l);
            initialFragmentTimeSent = true;
            return;
        }
    }

    public void onOperationFailed(com.adobe.mediacore.MediaPlayerNotification.Warning warning)
    {
    }

    public void onSeekComplete(long l)
    {
    }

    public void onSeekStart()
    {
    }

    public void reset()
    {
        initialBufferStart = 0L;
        initialBufferFillSent = false;
        initialFragmentTimeSent = false;
    }

    public void setAsset(Asset asset1)
    {
        reset();
        asset = asset1;
    }
}
