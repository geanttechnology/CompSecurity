// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads.managers;

import com.adobe.mediacore.metadata.AdSignalingMode;
import com.adobe.mediacore.metadata.AuditudeSettings;
import com.adobe.mediacore.metadata.DefaultMetadataKeys;
import com.adobe.mediacore.metadata.Metadata;
import com.adobe.mediacore.metadata.MetadataNode;
import com.adobe.mediacore.metadata.TimedMetadata;
import com.adobe.mediacore.timeline.Timeline;
import com.comcast.playerplatform.primetime.android.primetime.PlayerTimeline;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.playerplatform.primetime.android.ads.managers:
//            BaseAdManager, DefaultAdTimeline, BaseAdTimeline

public class AuditudeAdManager extends BaseAdManager
{

    private static final Logger logger = LoggerFactory.getLogger(com/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager);
    private MetadataNode metadataNode;

    public AuditudeAdManager(String s, String s1, Metadata metadata, String s2)
    {
        timeline = new DefaultAdTimeline(this);
        createMetadata(s, s1, metadata, s2);
    }

    private void createMetadata(String s, String s1, Metadata metadata, String s2)
    {
        metadataNode = new MetadataNode();
        AuditudeSettings auditudesettings = new AuditudeSettings();
        auditudesettings.setZoneId(s);
        auditudesettings.setMediaId(s2);
        auditudesettings.setDomain(s1);
        auditudesettings.setCreativeRepackagingEnabled(true);
        auditudesettings.setValue(DefaultMetadataKeys.METADATA_KEY_ADJUST_SEEK_ENABLED.getValue(), "false");
        if (metadata != null && !metadata.isEmpty())
        {
            auditudesettings.setTargetingParameters(metadata);
        }
        metadataNode.setNode("auditude_metadata", auditudesettings);
    }

    public MetadataNode getMetadataForAdobe()
    {
        return metadataNode;
    }

    public PlayerTimeline getPlayerTimeline(Timeline timeline)
    {
label0:
        {
            PlayerTimeline playertimeline1 = auditdueTimelineMarkers;
            PlayerTimeline playertimeline = playertimeline1;
            if (playertimeline1 == null)
            {
                if (timeline != null)
                {
                    break label0;
                }
                playertimeline = new PlayerTimeline(new ArrayList());
            }
            return playertimeline;
        }
        return new PlayerTimeline(timeline.timelineMarkers());
    }

    public AdSignalingMode getSignalingMode()
    {
        return AdSignalingMode.DEFAULT;
    }

    public void mediaProgress(long l, double d, long l1, long l2, int i)
    {
        timeline.updateProgress(getAdOffset() + l);
    }

    public void onTimedMetadata(TimedMetadata timedmetadata)
    {
    }

}
