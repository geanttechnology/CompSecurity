// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.text.subrip;

import java.util.Collections;
import java.util.List;
import shared_presage.com.google.android.exoplayer.text.Cue;
import shared_presage.com.google.android.exoplayer.text.Subtitle;
import shared_presage.com.google.android.exoplayer.util.Assertions;
import shared_presage.com.google.android.exoplayer.util.Util;

final class a
    implements Subtitle
{

    private final long a;
    private final Cue b[];
    private final long c[];

    public a(long l, Cue acue[], long al[])
    {
        a = l;
        b = acue;
        c = al;
    }

    public final List getCues(long l)
    {
        int i = Util.binarySearchFloor(c, l, true, false);
        if (i == -1 || i % 2 == 1)
        {
            return Collections.emptyList();
        } else
        {
            return Collections.singletonList(b[i / 2]);
        }
    }

    public final long getEventTime(int i)
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
        if (i < c.length)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        return c[i];
    }

    public final int getEventTimeCount()
    {
        return c.length;
    }

    public final long getLastEventTime()
    {
        if (getEventTimeCount() == 0)
        {
            return -1L;
        } else
        {
            return c[c.length - 1];
        }
    }

    public final int getNextEventTimeIndex(long l)
    {
        int i = Util.binarySearchCeil(c, l, false, false);
        if (i < c.length)
        {
            return i;
        } else
        {
            return -1;
        }
    }

    public final long getStartTime()
    {
        return a;
    }
}
