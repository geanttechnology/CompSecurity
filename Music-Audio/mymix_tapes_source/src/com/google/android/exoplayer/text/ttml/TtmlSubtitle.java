// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.ttml;

import com.google.android.exoplayer.text.Cue;
import com.google.android.exoplayer.text.Subtitle;
import com.google.android.exoplayer.util.Util;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.text.ttml:
//            TtmlNode

public final class TtmlSubtitle
    implements Subtitle
{

    private final long eventTimesUs[];
    private final TtmlNode root;
    private final long startTimeUs;

    public TtmlSubtitle(TtmlNode ttmlnode, long l)
    {
        root = ttmlnode;
        startTimeUs = l;
        eventTimesUs = ttmlnode.getEventTimesUs();
    }

    public List getCues(long l)
    {
        CharSequence charsequence = root.getText(l - startTimeUs);
        if (charsequence == null)
        {
            return Collections.emptyList();
        } else
        {
            return Collections.singletonList(new Cue(charsequence));
        }
    }

    public long getEventTime(int i)
    {
        return eventTimesUs[i] + startTimeUs;
    }

    public int getEventTimeCount()
    {
        return eventTimesUs.length;
    }

    public long getLastEventTime()
    {
        long l;
        if (eventTimesUs.length == 0)
        {
            l = -1L;
        } else
        {
            l = eventTimesUs[eventTimesUs.length - 1];
        }
        return l + startTimeUs;
    }

    public int getNextEventTimeIndex(long l)
    {
        int i = Util.binarySearchCeil(eventTimesUs, l - startTimeUs, false, false);
        if (i < eventTimesUs.length)
        {
            return i;
        } else
        {
            return -1;
        }
    }

    public long getStartTime()
    {
        return startTimeUs;
    }
}
