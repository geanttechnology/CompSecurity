// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.database;

import com.xfinity.playerlib.bookmarks.LiveStreamBookmark;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import java.util.List;
import java.util.Map;

public interface LiveStreamBookmarkDAO
{

    public abstract LiveStreamBookmark addFavorite(HalLiveStream hallivestream);

    public abstract boolean deleteFavorite(String s);

    public abstract Map getBookmarks();

    public abstract List getFavorites();

    public abstract LiveStreamBookmark getLastWatchedBookmark();

    public abstract LiveStreamBookmark getOrCreateBookmarkWithLiveStream(HalLiveStream hallivestream, boolean flag);

    public abstract List getRecentBookmarks();

    public abstract boolean removeHistoryItem(LiveStreamBookmark livestreambookmark);

    public abstract boolean saveBookmark(LiveStreamBookmark livestreambookmark, boolean flag);
}
