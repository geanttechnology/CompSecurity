// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.primetime;

import com.adobe.mediacore.timeline.Timeline;
import com.adobe.mediacore.timeline.TimelineMarker;
import com.comcast.playerplatform.primetime.android.ads.VideoAdBreak;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

// Referenced classes of package com.comcast.playerplatform.primetime.android.primetime:
//            TimelineMarker

public class PlayerTimeline
    implements Timeline
{

    Vector markers;

    public PlayerTimeline(Iterator iterator)
    {
        markers = new Vector();
        if (iterator != null)
        {
            TimelineMarker timelinemarker;
            for (; iterator.hasNext(); markers.add(new com.comcast.playerplatform.primetime.android.primetime.TimelineMarker(timelinemarker.getTime(), timelinemarker.getDuration())))
            {
                timelinemarker = (TimelineMarker)iterator.next();
            }

        }
    }

    public PlayerTimeline(List list)
    {
        markers = new Vector();
        if (list != null)
        {
            VideoAdBreak videoadbreak;
            for (list = list.iterator(); list.hasNext(); markers.add(new com.comcast.playerplatform.primetime.android.primetime.TimelineMarker(videoadbreak.getStartTime(), videoadbreak.getDuration())))
            {
                videoadbreak = (VideoAdBreak)list.next();
            }

        }
    }

    public Iterator timelineMarkers()
    {
        return markers.iterator();
    }
}
