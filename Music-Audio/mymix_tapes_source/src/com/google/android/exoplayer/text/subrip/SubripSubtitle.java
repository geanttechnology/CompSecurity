// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.subrip;

import com.google.android.exoplayer.text.Cue;
import com.google.android.exoplayer.text.Subtitle;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Util;
import java.util.Collections;
import java.util.List;

final class SubripSubtitle
    implements Subtitle
{

    private final long cueTimesUs[];
    private final Cue cues[];
    private final long startTimeUs;

    public SubripSubtitle(long l, Cue acue[], long al[])
    {
        startTimeUs = l;
        cues = acue;
        cueTimesUs = al;
    }

    public List getCues(long l)
    {
        int i = Util.binarySearchFloor(cueTimesUs, l, true, false);
        if (i == -1 || i % 2 == 1)
        {
            return Collections.emptyList();
        } else
        {
            return Collections.singletonList(cues[i / 2]);
        }
    }

    public long getEventTime(int i)
    {
        boolean flag1 = true;
        boolean flag;
        if (i >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        if (i < cueTimesUs.length)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        return cueTimesUs[i];
    }

    public int getEventTimeCount()
    {
        return cueTimesUs.length;
    }

    public long getLastEventTime()
    {
        if (getEventTimeCount() == 0)
        {
            return -1L;
        } else
        {
            return cueTimesUs[cueTimesUs.length - 1];
        }
    }

    public int getNextEventTimeIndex(long l)
    {
        int i = Util.binarySearchCeil(cueTimesUs, l, false, false);
        if (i < cueTimesUs.length)
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
