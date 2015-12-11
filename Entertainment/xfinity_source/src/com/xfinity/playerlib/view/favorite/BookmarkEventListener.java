// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.favorite;

import com.xfinity.playerlib.bookmarks.LiveStreamBookmark;

public interface BookmarkEventListener
{

    public abstract void onLiveStreamBookmarkAdded(LiveStreamBookmark livestreambookmark);

    public abstract void onLiveStreamBookmarkDeleted(String s);
}
