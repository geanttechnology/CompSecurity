// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.text.tx3g;

import java.util.Collections;
import java.util.List;
import shared_presage.com.google.android.exoplayer.text.Cue;
import shared_presage.com.google.android.exoplayer.text.Subtitle;
import shared_presage.com.google.android.exoplayer.util.Assertions;

final class a
    implements Subtitle
{

    private final long a;
    private final List b;

    public a(long l, Cue cue)
    {
        a = l;
        b = Collections.singletonList(cue);
    }

    public final List getCues(long l)
    {
        if (l >= a)
        {
            return b;
        } else
        {
            return Collections.emptyList();
        }
    }

    public final long getEventTime(int i)
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
        return a;
    }

    public final int getEventTimeCount()
    {
        return 1;
    }

    public final long getLastEventTime()
    {
        return a;
    }

    public final int getNextEventTimeIndex(long l)
    {
        return l >= a ? -1 : 0;
    }

    public final long getStartTime()
    {
        return a;
    }
}
