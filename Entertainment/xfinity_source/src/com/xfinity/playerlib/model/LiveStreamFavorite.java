// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model;

import com.xfinity.playerlib.bookmarks.LiveStreamBookmark;

// Referenced classes of package com.xfinity.playerlib.model:
//            Favorite

public class LiveStreamFavorite extends Favorite
{

    private String artworkUrl;
    private String streamId;

    public LiveStreamFavorite(LiveStreamBookmark livestreambookmark)
    {
        super(livestreambookmark.getTitle(), livestreambookmark.isAdultContent(), livestreambookmark.getCreatedTime());
        streamId = livestreambookmark.getStreamId();
        artworkUrl = livestreambookmark.artworkUrl;
    }

    public String getArtworkUrl()
    {
        return artworkUrl;
    }

    public String getStreamId()
    {
        return streamId;
    }
}
