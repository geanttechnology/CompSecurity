// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads.managers;

import com.adobe.mediacore.metadata.AdSignalingMode;
import com.adobe.mediacore.metadata.DefaultMetadataKeys;
import com.adobe.mediacore.metadata.MetadataNode;
import com.adobe.mediacore.metadata.TimedMetadata;
import com.adobe.mediacore.timeline.Timeline;
import com.adobe.mediacore.utils.TimeRange;
import com.adobe.mediacore.utils.TimeRangeCollection;
import com.comcast.playerplatform.primetime.android.ads.VideoAd;
import com.comcast.playerplatform.primetime.android.ads.VideoAdBreak;
import com.comcast.playerplatform.primetime.android.primetime.PlayerTimeline;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.comcast.playerplatform.primetime.android.ads.managers:
//            BaseAdManager, DefaultAdTimeline, BaseAdTimeline

public class C3Manager extends BaseAdManager
{

    private MetadataNode metadataNode;

    public C3Manager(List list)
    {
        timeline = new DefaultAdTimeline(this);
        timeline.setAdList(list);
        metadataNode = new MetadataNode();
        TimeRangeCollection timerangecollection = new TimeRangeCollection(com.adobe.mediacore.utils.TimeRangeCollection.Type.MARK_RANGES);
        for (list = list.iterator(); list.hasNext();)
        {
            Iterator iterator = ((VideoAdBreak)list.next()).getVideoAdsList().iterator();
            while (iterator.hasNext()) 
            {
                VideoAd videoad = (VideoAd)iterator.next();
                timerangecollection.addTimeRange(TimeRange.createRange(videoad.getStartTime(), videoad.getDuration()));
            }
        }

        list = new MetadataNode();
        metadataNode.setNode(DefaultMetadataKeys.CUSTOM_AD_MARKERS_METADATA_KEY.getValue(), (MetadataNode)timerangecollection.toMetadata(list));
    }

    public MetadataNode getMetadataForAdobe()
    {
        return metadataNode;
    }

    public PlayerTimeline getPlayerTimeline(Timeline timeline)
    {
        return new PlayerTimeline(this.timeline.getAdList());
    }

    public AdSignalingMode getSignalingMode()
    {
        return AdSignalingMode.CUSTOM_TIME_RANGES;
    }

    public void mediaProgress(long l, double d, long l1, long l2, int i)
    {
        timeline.updateProgress(l);
    }

    public void onTimedMetadata(TimedMetadata timedmetadata)
    {
    }
}
