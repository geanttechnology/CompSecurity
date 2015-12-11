// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads.managers;

import android.net.Uri;
import com.adobe.mediacore.metadata.AdSignalingMode;
import com.adobe.mediacore.metadata.Metadata;
import com.adobe.mediacore.metadata.MetadataNode;
import com.adobe.mediacore.metadata.TimedMetadata;
import com.adobe.mediacore.timeline.Timeline;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.playerplatform.primetime.android.ads.PlacementEvent;
import com.comcast.playerplatform.primetime.android.ads.PlacementStatusEvent;
import com.comcast.playerplatform.primetime.android.ads.VideoAd;
import com.comcast.playerplatform.primetime.android.ads.VideoAdBreak;
import com.comcast.playerplatform.primetime.android.asset.Asset;
import com.comcast.playerplatform.primetime.android.asset.AssetInfo;
import com.comcast.playerplatform.primetime.android.player.Player;
import com.comcast.playerplatform.primetime.android.primetime.PlayerTimeline;
import com.comcast.playerplatform.primetime.android.util.ConfigurationHelper;
import com.comcast.playerplatform.util.android.MoneyTrace;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.playerplatform.primetime.android.ads.managers:
//            BaseAdManager, ManifestManipulatorTimeline, PSNDispatcher, BaseAdTimeline

public class ManafestManipulatorManager extends BaseAdManager
{

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ");
    private static final Logger logger = LoggerFactory.getLogger(com/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager);
    private String deviceId;
    private PSNDispatcher dispatcher;
    private boolean endAllSent;
    private boolean endSent;
    private boolean fistQuartileSent;
    private boolean isFirstProgress;
    private String partnerId;
    protected boolean playerIsReady;
    private boolean secondQuartileSent;
    private boolean thirdQuartileSent;

    public ManafestManipulatorManager(String s, HttpClient httpclient, MoneyTrace moneytrace)
    {
        isFirstProgress = true;
        playerIsReady = false;
        timeline = new ManifestManipulatorTimeline(this);
        deviceId = s;
        partnerId = (new ConfigurationHelper()).getPartnerId();
        createMetadataNode();
        dispatcher = new PSNDispatcher(httpclient, moneytrace);
    }

    private void createMetadataNode()
    {
        endAllSent = false;
        resetQuartiles();
    }

    private String getTimestamp()
    {
        Date date = new Date();
        dateFormat.setTimeZone(TimeZone.getDefault());
        return dateFormat.format(date);
    }

    private boolean isAdCue(TimedMetadata timedmetadata)
    {
        return timedmetadata.getName().equals("#EXT-X-CUE");
    }

    private boolean isAdRestriction(TimedMetadata timedmetadata)
    {
        return timedmetadata.getName().equals("#EXT-X-TRICKMODE-RESTRICTION");
    }

    private void resetQuartiles()
    {
        fistQuartileSent = false;
        secondQuartileSent = false;
        thirdQuartileSent = false;
        isFirstProgress = true;
        endSent = false;
    }

    private void sendPSN(com.comcast.playerplatform.primetime.android.ads.PlacementStatusEvent.Type type, VideoAd videoad)
    {
        String s;
        long l;
        l = 0L;
        s = "";
        if (type == com.comcast.playerplatform.primetime.android.ads.PlacementStatusEvent.Type.END_ALL) goto _L2; else goto _L1
_L1:
        long l1 = videoad.getDuration() - videoad.getSecondsRemaining();
        if (l1 >= 1000L) goto _L4; else goto _L3
_L3:
        l = 0L;
_L6:
        s = videoad.getId();
_L2:
        dispatcher.dispatchPSN(new PlacementStatusEvent(s, l, deviceId, null, null, null, null, getTimestamp(), type));
        return;
_L4:
        l = l1;
        if (l1 > videoad.getDuration() - 1000L)
        {
            l = videoad.getDuration();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public Player clearPlayer()
    {
        VideoAd videoad = timeline.getCurrentAd();
        if (videoad != null && !endSent)
        {
            sendPSN(com.comcast.playerplatform.primetime.android.ads.PlacementStatusEvent.Type.END, videoad);
            endSent = true;
        }
        if (!endAllSent)
        {
            sendPSN(com.comcast.playerplatform.primetime.android.ads.PlacementStatusEvent.Type.END_ALL, videoad);
            endAllSent = true;
        }
        return super.clearPlayer();
    }

    public MetadataNode getMetadataForAdobe()
    {
        return null;
    }

    public PlayerTimeline getPlayerTimeline(Timeline timeline)
    {
        return new PlayerTimeline(this.timeline.getAdList());
    }

    public AdSignalingMode getSignalingMode()
    {
        return AdSignalingMode.MANIFEST_CUES;
    }

    public void mediaEnded()
    {
        timeline.streamComplete();
    }

    public void mediaOpened(String s, String s1, List list, List list1, List list2, long l, 
            long l1, long l2, double d, boolean flag)
    {
        l = getSeekAdjustment(player.getCurrentPosition(), 0L, false);
        if (l != 0L)
        {
            player.setPosition(l, true);
        }
        playerIsReady = true;
    }

    public void mediaProgress(long l, double d, long l1, long l2, int i)
    {
        if (playerIsReady)
        {
            timeline.updateProgress(l);
        }
    }

    public void onSeekComplete(long l)
    {
        if (playerIsReady)
        {
            timeline.onSeekEnd(l);
        }
    }

    public void onSeekStart()
    {
        if (playerIsReady)
        {
            timeline.onSeekStart(player.getCurrentPosition());
        }
    }

    public void onTimedMetadata(TimedMetadata timedmetadata)
    {
        Logger logger1 = logger;
        StringBuilder stringbuilder = (new StringBuilder()).append("onTimedMetadata:").append(timedmetadata.getName()).append(":");
        String s;
        if (timedmetadata.getMetadata().containsKey("ID"))
        {
            s = timedmetadata.getMetadata().getValue("ID");
        } else
        {
            s = "";
        }
        logger1.debug(stringbuilder.append(s).toString());
        if (isAdRestriction(timedmetadata))
        {
            s = timedmetadata.getMetadata().getValue("ADID");
            String s2 = timedmetadata.getMetadata().getValue("MODE");
            timedmetadata = timedmetadata.getMetadata().getValue("LIMIT");
            timeline.createAdRestriction(s, s2, timedmetadata);
        } else
        if (isAdCue(timedmetadata))
        {
            String s1 = timedmetadata.getMetadata().getValue("ID");
            long l = (long)(Float.parseFloat(timedmetadata.getMetadata().getValue("DURATION")) * 1000F);
            long l1 = timedmetadata.getTime();
            timeline.createAdBreak(s1, Long.valueOf(l1), l);
            return;
        }
    }

    public void triggerAdBreakComplete(VideoAdBreak videoadbreak)
    {
        super.triggerAdBreakComplete(videoadbreak);
    }

    public void triggerAdBreakStart(VideoAdBreak videoadbreak, VideoAd videoad)
    {
        super.triggerAdBreakStart(videoadbreak, videoad);
    }

    public void triggerAdComplete(VideoAdBreak videoadbreak, VideoAd videoad)
    {
        super.triggerAdComplete(videoadbreak, videoad);
        if (!endSent)
        {
            sendPSN(com.comcast.playerplatform.primetime.android.ads.PlacementStatusEvent.Type.END, videoad);
            endSent = true;
        }
    }

    public void triggerAdProgress(VideoAdBreak videoadbreak, VideoAd videoad, int i, long l)
    {
        this;
        JVM INSTR monitorenter ;
        super.triggerAdProgress(videoadbreak, videoad, i, l);
        i = videoad.getAdProgressPercent();
        if (!isFirstProgress) goto _L2; else goto _L1
_L1:
        if (i <= 75) goto _L4; else goto _L3
_L3:
        fistQuartileSent = true;
        secondQuartileSent = true;
        thirdQuartileSent = true;
_L9:
        isFirstProgress = false;
_L2:
        if (fistQuartileSent || i <= 25) goto _L6; else goto _L5
_L5:
        sendPSN(com.comcast.playerplatform.primetime.android.ads.PlacementStatusEvent.Type.FIRST_QUARTILE, videoad);
        fistQuartileSent = true;
_L13:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        if (i <= 50) goto _L8; else goto _L7
_L7:
        fistQuartileSent = true;
        secondQuartileSent = true;
          goto _L9
        videoadbreak;
        throw videoadbreak;
_L8:
        if (i <= 25) goto _L9; else goto _L10
_L10:
        fistQuartileSent = true;
          goto _L9
_L6:
        if (secondQuartileSent || i <= 50) goto _L12; else goto _L11
_L11:
        sendPSN(com.comcast.playerplatform.primetime.android.ads.PlacementStatusEvent.Type.SECOND_QUARTILE, videoad);
        secondQuartileSent = true;
          goto _L13
_L12:
        if (thirdQuartileSent || i <= 75) goto _L13; else goto _L14
_L14:
        sendPSN(com.comcast.playerplatform.primetime.android.ads.PlacementStatusEvent.Type.THIRD_QUARTILE, videoad);
        thirdQuartileSent = true;
          goto _L13
    }

    public void triggerAdStart(VideoAdBreak videoadbreak, VideoAd videoad)
    {
        super.triggerAdStart(videoadbreak, videoad);
        resetQuartiles();
        sendPSN(com.comcast.playerplatform.primetime.android.ads.PlacementStatusEvent.Type.START, videoad);
    }

    public Uri updateUriWithQueryParams(Uri uri, Asset asset, String s)
    {
        android.net.Uri.Builder builder;
        String s1;
        s1 = uri.getAuthority();
        builder = uri.buildUpon();
        deviceId = s;
        builder.authority(s1.replace("ccr", "mm"));
        builder.appendQueryParameter("sid", PlacementEvent.refreshSessionUUID());
        builder.appendQueryParameter("dtz", getTimestamp());
        builder.appendQueryParameter("DeviceId", deviceId);
        builder.appendQueryParameter("PartnerId", (new StringBuilder()).append("private:").append(partnerId).toString());
        builder.appendQueryParameter("ProviderId", asset.getAssetInfo().getProviderId());
        builder.appendQueryParameter("AssetId", asset.getAssetInfo().getAssetId());
        builder.appendQueryParameter("StreamType", "VOD_T6");
        uri = builder;
_L2:
        return uri.build();
        asset;
        uri = uri.buildUpon();
        if (true) goto _L2; else goto _L1
_L1:
    }

}
