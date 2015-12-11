// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.database;

import android.database.Cursor;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.consumable.SeriesWatchableInfo;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.consumable.hal.HalNetworkProvider;
import com.xfinity.playerlib.tracking.VideoMilestone;
import com.xfinity.playerlib.view.videoplay.VideoTracker;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.model.database:
//            DefaultVideoBookmarkDAO

private class episodeNumber extends VideoBookmark
{

    private long dbId;
    final DefaultVideoBookmarkDAO this$0;
    private String userKey;

    public long getDbId()
    {
        return dbId;
    }

    public String getUserKey()
    {
        return userKey;
    }

    public void setDbId(long l)
    {
        dbId = l;
    }

    public void setUserKey(String s)
    {
        userKey = s;
    }

    public Q(Cursor cursor)
    {
        this$0 = DefaultVideoBookmarkDAO.this;
        super();
        dbId = -1L;
        userKey = null;
        dbId = cursor.getLong(cursor.getColumnIndex("_id"));
        userKey = cursor.getString(cursor.getColumnIndex("user_key"));
        String s = cursor.getString(cursor.getColumnIndex("parent_merlin_id"));
        if (s != null)
        {
            parentMerlinId = new MerlinId(s);
        }
        if (cursor.getString(cursor.getColumnIndex("merlin_id")) != null)
        {
            merlinId = new MerlinId(cursor.getString(cursor.getColumnIndex("merlin_id")));
        }
        videoId = cursor.getLong(cursor.getColumnIndex("video_id"));
        title = cursor.getString(cursor.getColumnIndex("title"));
        position = cursor.getInt(cursor.getColumnIndex("position"));
        duration = cursor.getInt(cursor.getColumnIndex("duration"));
        networkId = cursor.getLong(cursor.getColumnIndex("network_id"));
        companyId = cursor.getLong(cursor.getColumnIndex("company_id"));
        seasonNumber = cursor.getInt(cursor.getColumnIndex("season_info"));
        episodeNumber = cursor.getInt(cursor.getColumnIndex("episode_info"));
        lastTrackedMilestone = VideoMilestone.fromInt(cursor.getInt(cursor.getColumnIndex("last_tracked_milestone")));
        for (defaultvideobookmarkdao = DefaultVideoBookmarkDAO.access$000(DefaultVideoBookmarkDAO.this, Long.valueOf(dbId)).iterator(); hasNext(); addCategory((com.xfinity.playerlib.bookmarks.mark.addCategory)next())) { }
        long l = cursor.getLong(cursor.getColumnIndex("expiration_date"));
        if (l > 0L)
        {
            try
            {
                expirationDate = new Date(l);
            }
            // Misplaced declaration of an exception variable
            catch (DefaultVideoBookmarkDAO defaultvideobookmarkdao) { }
        }
        l = cursor.getLong(cursor.getColumnIndex("timestamp"));
        if (l > 0L)
        {
            timestamp = new Date(l);
        }
        return;
    }

    public timestamp(VideoFacade videofacade, Watchable watchable)
    {
        this$0 = DefaultVideoBookmarkDAO.this;
        super();
        dbId = -1L;
        userKey = null;
        userKey = getUserKey();
        merlinId = videofacade.getProgramId();
        parentMerlinId = videofacade.getParentMerlinIdIfApplicable();
        videoId = videofacade.getVideoId();
        companyId = videofacade.getNetworkInfo().getCompanyId();
        title = watchable.getTitle();
        expirationDate = videofacade.getExpirationDate();
        position = DefaultVideoBookmarkDAO.access$100(DefaultVideoBookmarkDAO.this).getPosition(videofacade.getVideoId());
        duration = videofacade.getDurationInSeconds() * 1000;
        timestamp = new Date();
        lastTrackedMilestone = VideoMilestone.NOT_STARTED;
        addCategory(com.xfinity.playerlib.bookmarks._RESUMEPOINT);
        defaultvideobookmarkdao = watchable.getSeriesInfoIfApplicable();
        if (DefaultVideoBookmarkDAO.this != null)
        {
            int i;
            if (getSeasonNumber() != null)
            {
                i = getSeasonNumber().intValue();
            } else
            {
                i = seasonNumber;
            }
            seasonNumber = i;
            if (getEpisodeNumber() != null)
            {
                i = getEpisodeNumber().intValue();
            } else
            {
                i = episodeNumber;
            }
            episodeNumber = i;
        }
    }
}
