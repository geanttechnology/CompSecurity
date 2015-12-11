// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.database;

import android.database.Cursor;
import com.xfinity.playerlib.bookmarks.LiveStreamBookmark;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import java.util.Date;

// Referenced classes of package com.xfinity.playerlib.model.database:
//            DefaultLiveStreamBookmarkDAO

private class createdTime extends LiveStreamBookmark
{

    private long dbId;
    final DefaultLiveStreamBookmarkDAO this$0;
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

    public (Cursor cursor)
    {
        boolean flag1 = true;
        this$0 = DefaultLiveStreamBookmarkDAO.this;
        super();
        dbId = -1L;
        userKey = null;
        dbId = cursor.getLong(cursor.getColumnIndex("_id"));
        userKey = cursor.getString(cursor.getColumnIndex("user_key"));
        streamId = cursor.getString(cursor.getColumnIndex("stream_id"));
        artworkUrl = cursor.getString(cursor.getColumnIndex("artwork_url"));
        title = cursor.getString(cursor.getColumnIndex("title"));
        position = cursor.getInt(cursor.getColumnIndex("position"));
        duration = cursor.getInt(cursor.getColumnIndex("duration"));
        companyId = cursor.getInt(cursor.getColumnIndex("network_id"));
        long l;
        boolean flag;
        if (cursor.getInt(cursor.getColumnIndex("is_adult_content")) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isAdultContent = flag;
        if (cursor.getInt(cursor.getColumnIndex("is_favorite")) > 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        isFavorite = flag;
        l = cursor.getLong(cursor.getColumnIndex("expiration_date"));
        if (l > 0L)
        {
            try
            {
                expirationDate = new Date(l);
            }
            // Misplaced declaration of an exception variable
            catch (DefaultLiveStreamBookmarkDAO defaultlivestreambookmarkdao) { }
        }
        l = cursor.getLong(cursor.getColumnIndex("timestamp"));
        if (l > 0L)
        {
            timestamp = new Date(l);
        }
        l = cursor.getLong(cursor.getColumnIndex("created"));
        if (l > 0L)
        {
            createdTime = new Date(l);
        }
        return;
    }

    public createdTime(HalLiveStream hallivestream)
    {
        this$0 = DefaultLiveStreamBookmarkDAO.this;
        super();
        dbId = -1L;
        userKey = null;
        userKey = getUserKey();
        streamId = hallivestream.getStreamId();
        artworkUrl = hallivestream.getArtworkLink();
        title = hallivestream.getTitle();
        isAdultContent = hallivestream.isAdultContent();
        createdTime = new Date();
    }
}
