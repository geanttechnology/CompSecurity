// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.bookmarks;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.bookmarks:
//            Bookmark

public class LiveStreamBookmark extends Bookmark
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/bookmarks/LiveStreamBookmark);
    public String artworkUrl;
    protected Date createdTime;
    public boolean isAdultContent;
    public boolean isFavorite;
    public String streamId;

    public LiveStreamBookmark()
    {
        createdTime = null;
    }

    public String getArtworkUrl()
    {
        return artworkUrl;
    }

    public Date getCreatedTime()
    {
        return createdTime;
    }

    public String getStreamId()
    {
        return streamId;
    }

    public boolean isAdultContent()
    {
        return isAdultContent;
    }

    public boolean isFavorite()
    {
        return isFavorite;
    }

    public void setAdultContent(boolean flag)
    {
        isAdultContent = flag;
    }

    public void setCreatedTime(Date date)
    {
        createdTime = date;
    }

    public void setIsFavorite(boolean flag)
    {
        isFavorite = flag;
    }

}
