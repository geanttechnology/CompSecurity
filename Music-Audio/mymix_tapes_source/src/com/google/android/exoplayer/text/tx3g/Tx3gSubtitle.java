// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.tx3g;

import com.google.android.exoplayer.text.Cue;
import com.google.android.exoplayer.text.Subtitle;
import com.google.android.exoplayer.util.Assertions;
import java.util.Collections;
import java.util.List;

final class Tx3gSubtitle
    implements Subtitle
{

    private final List cues;
    private final long startTimeUs;

    public Tx3gSubtitle(long l, Cue cue)
    {
        startTimeUs = l;
        cues = Collections.singletonList(cue);
    }

    public List getCues(long l)
    {
        if (l >= startTimeUs)
        {
            return cues;
        } else
        {
            return Collections.emptyList();
        }
    }

    public long getEventTime(int i)
    {
        boolean flag;
        if (i == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        return startTimeUs;
    }

    public int getEventTimeCount()
    {
        return 1;
    }

    public long getLastEventTime()
    {
        return startTimeUs;
    }

    public int getNextEventTimeIndex(long l)
    {
        return l >= startTimeUs ? -1 : 0;
    }

    public long getStartTime()
    {
        return startTimeUs;
    }
}
