// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;

import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;
import com.comcast.cim.cmasl.utils.container.Option;
import com.xfinity.playerlib.bookmarks.LiveStreamBookmark;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.model.database.LiveStreamBookmarkDAO;
import com.xfinity.playerlib.model.database.VideoBookmarkDAO;
import java.util.Date;

// Referenced classes of package com.xfinity.playerlib.view.featured:
//            FeaturedFragment

class ask extends NonCachingBaseTask
{

    final FeaturedFragment this$0;

    public Option execute()
    {
        Object obj = videoBookmarkDAO.getLastWatchedBookmark();
        LiveStreamBookmark livestreambookmark = liveStreamBookmarkDAO.getLastWatchedBookmark();
        if (obj == null || livestreambookmark != null && ((VideoBookmark) (obj)).getTimestamp().compareTo(livestreambookmark.getTimestamp()) <= 0)
        {
            obj = livestreambookmark;
        }
        return new Option(obj);
    }

    public volatile Object execute()
    {
        return execute();
    }

    DAO()
    {
        this$0 = FeaturedFragment.this;
        super();
    }
}
