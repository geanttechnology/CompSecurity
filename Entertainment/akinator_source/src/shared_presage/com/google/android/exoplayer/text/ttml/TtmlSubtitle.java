// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.text.ttml;

import java.util.Collections;
import java.util.List;
import shared_presage.com.google.android.exoplayer.text.Cue;
import shared_presage.com.google.android.exoplayer.text.Subtitle;
import shared_presage.com.google.android.exoplayer.util.Util;

// Referenced classes of package shared_presage.com.google.android.exoplayer.text.ttml:
//            a

public final class TtmlSubtitle
    implements Subtitle
{

    private final long eventTimesUs[];
    private final a root;
    private final long startTimeUs;

    public TtmlSubtitle(a a1, long l)
    {
        root = a1;
        startTimeUs = l;
        eventTimesUs = a1.a();
    }

    public final List getCues(long l)
    {
        CharSequence charsequence = root.a(l - startTimeUs);
        if (charsequence == null)
        {
            return Collections.emptyList();
        } else
        {
            return Collections.singletonList(new Cue(charsequence));
        }
    }

    public final long getEventTime(int i)
    {
        return eventTimesUs[i] + startTimeUs;
    }

    public final int getEventTimeCount()
    {
        return eventTimesUs.length;
    }

    public final long getLastEventTime()
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

    public final int getNextEventTimeIndex(long l)
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

    public final long getStartTime()
    {
        return startTimeUs;
    }
}
