// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.database;

import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import java.util.List;

public interface VideoBookmarkDAO
{

    public abstract boolean deleteBookmark(VideoBookmark videobookmark);

    public abstract VideoBookmark getLastWatchedBookmark();

    public abstract VideoBookmark getOrCreateBookmarkWithVideo(VideoFacade videofacade, Watchable watchable);

    public abstract List getRecentBookmarks();

    public abstract void saveBookmark(VideoBookmark videobookmark);

    public abstract void updateLastTrackedMilestones();
}
