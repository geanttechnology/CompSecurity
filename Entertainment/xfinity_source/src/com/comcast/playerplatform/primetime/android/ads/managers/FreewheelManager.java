// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads.managers;

import android.app.Activity;
import com.adobe.mediacore.MediaResource;
import com.adobe.mediacore.metadata.AdSignalingMode;
import com.adobe.mediacore.metadata.AdvertisingMetadata;
import com.adobe.mediacore.metadata.DefaultMetadataKeys;
import com.adobe.mediacore.metadata.MetadataNode;
import com.adobe.mediacore.metadata.TimedMetadata;
import com.adobe.mediacore.timeline.Timeline;
import com.adobe.mediacore.timeline.TimelineOperation;
import com.adobe.mediacore.timeline.advertising.Ad;
import com.adobe.mediacore.timeline.advertising.AdAsset;
import com.adobe.mediacore.timeline.advertising.AdBreak;
import com.adobe.mediacore.timeline.advertising.AdBreakPlacement;
import com.adobe.mediacore.timeline.advertising.AdClick;
import com.adobe.mediacore.timeline.advertising.PlacementInformation;
import com.comcast.playerplatform.primetime.android.ads.VideoAd;
import com.comcast.playerplatform.primetime.android.ads.VideoAdBreak;
import com.comcast.playerplatform.primetime.android.asset.Asset;
import com.comcast.playerplatform.primetime.android.asset.AssetInfo;
import com.comcast.playerplatform.primetime.android.player.Player;
import com.comcast.playerplatform.primetime.android.primetime.PlayerTimeline;
import com.comcast.playerplatform.primetime.android.util.ThreadManager;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tv.freewheel.ad.AdManager;
import tv.freewheel.ad.interfaces.IAdContext;
import tv.freewheel.ad.interfaces.IAdInstance;
import tv.freewheel.ad.interfaces.IAdManager;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.ICreativeRendition;
import tv.freewheel.ad.interfaces.ICreativeRenditionAsset;
import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.ad.interfaces.IEventListener;
import tv.freewheel.ad.interfaces.ISlot;

// Referenced classes of package com.comcast.playerplatform.primetime.android.ads.managers:
//            BaseAdManager, BaseAdTimeline

public class FreewheelManager extends BaseAdManager
{

    private static final Logger logger = LoggerFactory.getLogger(com/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager);
    private IConstants adConstants;
    private IAdContext adContext;
    private IAdManager adManager;
    private Runnable freeWheelContextRequest;
    private MetadataNode metadataNode;
    private long savedSeekValue;
    private SettableFuture timelineOperations;

    FreewheelManager(Activity activity)
    {
        savedSeekValue = -1L;
        freeWheelContextRequest = new Runnable() {

            final FreewheelManager this$0;

            public void run()
            {
                adContext.addEventListener(adConstants.EVENT_REQUEST_COMPLETE(), new IEventListener() {

                    final _cls1 this$1;

                    public void run(IEvent ievent)
                    {
                        Vector vector = new Vector();
                        String s = ievent.getType();
                        ievent = ievent.getData().get(adConstants.INFO_KEY_SUCCESS()).toString();
                        if (adConstants.EVENT_REQUEST_COMPLETE().equals(s) && Boolean.valueOf(ievent).booleanValue())
                        {
                            ievent = processAdSlots();
                            FreewheelManager.logger.debug("Freewheel ad request completed successfully");
                        } else
                        {
                            FreewheelManager.logger.debug("Freewheel ad request failed. Playing main content.");
                            ievent = vector;
                        }
                        timelineOperations.set(ievent);
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
                adContext.submitRequest(3D);
            }

            
            {
                this$0 = FreewheelManager.this;
                super();
            }
        };
        adManager = AdManager.getInstance(activity.getApplicationContext());
        adManager.setServer("http://7468.v.fwmrm.net/");
        adManager.setNetwork(0x5df08);
        adContext = adManager.newContext();
        adConstants = adContext.getConstants();
        adContext.setProfile("384776:comcast_android_test", null, null, null);
        adContext.setSiteSection("xtvtest_android_section", random(), 0, adConstants.ID_TYPE_CUSTOM(), 0);
        adContext.setActivity(activity);
        metadataNode = new MetadataNode();
        activity = new AdvertisingMetadata();
        activity.setSignalingMode(AdSignalingMode.DEFAULT);
        activity.setValue(DefaultMetadataKeys.METADATA_KEY_ADJUST_SEEK_ENABLED.getValue(), "true");
        metadataNode.setNode("FREEWHEEL_AD_KEY", activity);
    }

    private TimelineOperation getTimelineOperation(ISlot islot, com.adobe.mediacore.timeline.advertising.PlacementInformation.Type type)
    {
        Vector vector = new Vector();
        IAdInstance iadinstance = (IAdInstance)islot.getAdInstances().get(0);
        Object obj = MediaResource.createFromUrl(iadinstance.getActiveCreativeRendition().getPrimaryCreativRenditionAsset().getURL(), null);
        long l = (long)iadinstance.getDuration() * 1000L;
        long l1 = (long)islot.getTimePosition() * 1000L;
        obj = new AdAsset(iadinstance.getAdId(), l, ((MediaResource) (obj)), new AdClick("", "", ""), null);
        vector.add(Ad.createCustomAdMarker(com.adobe.mediacore.MediaResource.Type.HLS, l, iadinstance.getAdId(), ((AdAsset) (obj))));
        obj = new VideoAd();
        ((VideoAd) (obj)).setStartTime(l1);
        ((VideoAd) (obj)).setDuration(l);
        ((VideoAd) (obj)).setId(String.valueOf(iadinstance.getAdId()));
        obj = new VideoAdBreak(((VideoAd) (obj)));
        ((VideoAdBreak) (obj)).setId(String.valueOf(iadinstance.getAdId()));
        timeline.addAd(((VideoAdBreak) (obj)));
        type = new PlacementInformation(type, com.adobe.mediacore.timeline.advertising.PlacementInformation.Mode.INSERT, l1, l);
        return new AdBreakPlacement(AdBreak.createAdBreak(vector, l1, 0L, islot.getCustomId()), type);
    }

    private Vector processAdSlots()
    {
        Vector vector = new Vector();
        Iterator iterator = adContext.getSlotsByTimePositionClass(adConstants.TIME_POSITION_CLASS_PREROLL()).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ISlot islot = (ISlot)iterator.next();
            if (islot.getAdInstances() != null && islot.getAdInstances().size() > 0)
            {
                vector.add(getTimelineOperation(islot, com.adobe.mediacore.timeline.advertising.PlacementInformation.Type.PRE_ROLL));
            }
        } while (true);
        iterator = adContext.getSlotsByTimePositionClass(adConstants.TIME_POSITION_CLASS_MIDROLL()).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ISlot islot1 = (ISlot)iterator.next();
            if (islot1.getAdInstances() != null && islot1.getAdInstances().size() > 0)
            {
                vector.add(getTimelineOperation(islot1, com.adobe.mediacore.timeline.advertising.PlacementInformation.Type.MID_ROLL));
            }
        } while (true);
        iterator = adContext.getSlotsByTimePositionClass(adConstants.TIME_POSITION_CLASS_POSTROLL()).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ISlot islot2 = (ISlot)iterator.next();
            if (islot2.getAdInstances() != null && islot2.getAdInstances().size() > 0)
            {
                vector.add(getTimelineOperation(islot2, com.adobe.mediacore.timeline.advertising.PlacementInformation.Type.POST_ROLL));
            }
        } while (true);
        return vector;
    }

    private int random()
    {
        return (int)Math.floor(Math.random() * 2147483647D);
    }

    public Vector getAdProposals()
    {
        timelineOperations = SettableFuture.create();
        double d = (double)player.getDuration() / 1000D;
        String s = player.getCurrentChannel().getAssetInfo().getAssetId();
        adContext.setVideoAsset(s, d, null, adConstants.VIDEO_ASSET_AUTO_PLAY_TYPE_ATTENDED(), random(), 0, adConstants.ID_TYPE_CUSTOM(), 0, adConstants.VIDEO_ASSET_DURATION_TYPE_EXACT());
        ThreadManager.getInstance().executeOnUIThread(freeWheelContextRequest);
        Vector vector = (Vector)timelineOperations.get(5L, TimeUnit.SECONDS);
        return vector;
        Object obj;
        obj;
        logger.error((new StringBuilder()).append("Freewheel ad operation failed. ").append(((InterruptedException) (obj)).getMessage()).toString());
_L2:
        return null;
        obj;
        logger.error((new StringBuilder()).append("Freewheel ad operation failed. ").append(((ExecutionException) (obj)).getMessage()).toString());
        continue; /* Loop/switch isn't completed */
        obj;
        logger.error((new StringBuilder()).append("Freewheel ad operation timeout. ").append(((TimeoutException) (obj)).getMessage()).toString());
        if (true) goto _L2; else goto _L1
_L1:
    }

    public MetadataNode getMetadataForAdobe()
    {
        return metadataNode;
    }

    public PlayerTimeline getPlayerTimeline(Timeline timeline)
    {
        return new PlayerTimeline(timeline.timelineMarkers());
    }

    public AdSignalingMode getSignalingMode()
    {
        return AdSignalingMode.DEFAULT;
    }

    public void onTimedMetadata(TimedMetadata timedmetadata)
    {
    }

    public void setAdContext(IAdContext iadcontext)
    {
        adContext = iadcontext;
    }

    public void triggerAdBreakComplete(VideoAdBreak videoadbreak)
    {
        super.triggerAdBreakComplete(videoadbreak);
        if (savedSeekValue > 0L && player != null && !seekingOutOfAd)
        {
            player.setPosition(savedSeekValue, true);
        }
        savedSeekValue = -1L;
    }






}
