// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.bookmarks;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Bookmark
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/bookmarks/Bookmark);
    public long companyId;
    protected int duration;
    protected Date expirationDate;
    public long networkId;
    protected int position;
    protected Date timestamp;
    protected String title;

    public Bookmark()
    {
        title = null;
        position = -1;
        duration = -1;
        expirationDate = null;
        timestamp = null;
    }

    public long getCompanyId()
    {
        return companyId;
    }

    public int getDuration()
    {
        return duration;
    }

    public Date getExpirationDate()
    {
        return expirationDate;
    }

    public long getNetworkId()
    {
        return networkId;
    }

    public int getPercentWatched()
    {
        if (duration == 0)
        {
            return 0;
        } else
        {
            return (int)(((double)position / (double)duration) * 100D);
        }
    }

    public int getPosition()
    {
        return position;
    }

    public Date getTimestamp()
    {
        return timestamp;
    }

    public String getTitle()
    {
        return title;
    }

    public boolean isFinished()
    {
        return (double)position > 0.97999999999999998D * (double)duration;
    }

    public void setDuration(int i)
    {
        duration = i;
    }

    public void setPosition(int i)
    {
        position = i;
    }

    public void setTimestamp(Date date)
    {
        timestamp = date;
    }

}
