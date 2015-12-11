// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import com.edisonwang.android.slog.FormattingTuple;
import com.edisonwang.android.slog.MessageFormatter;

// Referenced classes of package co.vine.android.util:
//            SeekInfoManager

public static class maxLoops
{

    public final int durationPadded;
    public final int maxLoops;
    public long startTime;

    public int getLoopsLeft()
    {
        return maxLoops - (int)Math.floor((System.currentTimeMillis() - startTime) / (long)durationPadded);
    }

    public String getLoopsLeftForDisplay()
    {
        return String.valueOf(getLoopsLeft());
    }

    public int getSeekTime()
    {
        if (!isExpired())
        {
            return (int)(System.currentTimeMillis() - startTime) % durationPadded;
        } else
        {
            return -1;
        }
    }

    public boolean hasLoopLimit()
    {
        return this != SeekInfoManager.NO_LOOP_LIMIT;
    }

    public boolean isExpired()
    {
        return hasLoopLimit() && getLoopsLeft() <= 0;
    }

    public String toString()
    {
        return MessageFormatter.format("Start time: {}, durationPadded {}, maxLoops{}, loopsLeft {}.", new Object[] {
            Long.valueOf(startTime), Integer.valueOf(durationPadded), Integer.valueOf(maxLoops), Integer.valueOf(getLoopsLeft())
        }).getMessage();
    }

    public (long l, int i, int j)
    {
        startTime = l;
        durationPadded = i;
        maxLoops = j;
    }
}
