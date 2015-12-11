// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.utils;

import java.util.Date;

public class RecordTimer
{

    private Date lastDate;
    private boolean paused;
    private long record;

    public RecordTimer()
    {
        lastDate = new Date();
        record = 0L;
        paused = false;
    }

    public void pause()
    {
        if (paused)
        {
            return;
        } else
        {
            record = lastDate.getTime();
            lastDate = new Date();
            record = lastDate.getTime() - record;
            paused = true;
            return;
        }
    }

    public void resume()
    {
        if (paused)
        {
            lastDate = new Date();
            paused = false;
        }
    }

    public long tick()
    {
        long l;
        if (paused)
        {
            l = record;
            record = 0L;
        } else
        {
            l = lastDate.getTime();
            lastDate = new Date();
            l = (lastDate.getTime() - l) + record;
            record = 0L;
        }
        return l / 1000L;
    }
}
