// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.xfinity.playerlib.bookmarks.BookmarkId;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.consumable.SeriesWatchableInfo;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.consumable.hal.HalNetworkProvider;
import com.xfinity.playerlib.model.user.PlayNowUser;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.tracking.VideoMilestone;
import com.xfinity.playerlib.view.videoplay.VideoTracker;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.database:
//            VideoBookmarkDAO, PlayNowDatabase

public class DefaultVideoBookmarkDAO
    implements VideoBookmarkDAO
{
    private class SQLiteBookmark extends VideoBookmark
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

        public SQLiteBookmark(Cursor cursor)
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
            for (defaultvideobookmarkdao = getCategoriesForBookmark(Long.valueOf(dbId)).iterator(); hasNext(); addCategory((com.xfinity.playerlib.bookmarks.VideoBookmark.BookmarkCategory)next())) { }
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

        public SQLiteBookmark(VideoFacade videofacade, Watchable watchable)
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
            position = videoTracker.getPosition(videofacade.getVideoId());
            duration = videofacade.getDurationInSeconds() * 1000;
            timestamp = new Date();
            lastTrackedMilestone = VideoMilestone.NOT_STARTED;
            addCategory(com.xfinity.playerlib.bookmarks.VideoBookmark.BookmarkCategory.CATEGORY_RESUMEPOINT);
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


    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO);
    private SQLiteDatabase db;
    private PlayNowDatabase playNowDB;
    private PlayNowUserManager userManager;
    private VideoTracker videoTracker;

    public DefaultVideoBookmarkDAO(PlayNowDatabase playnowdatabase, PlayNowUserManager playnowusermanager, VideoTracker videotracker)
    {
        playNowDB = playnowdatabase;
        userManager = playnowusermanager;
        videoTracker = videotracker;
        db = playNowDB.getWritableDatabase();
    }

    private VideoBookmark getBookmarkByBookmarkId(BookmarkId bookmarkid)
    {
        Cursor cursor;
        Object obj;
        obj = null;
        cursor = null;
        Cursor cursor1 = db.rawQuery("SELECT * FROM bookmark WHERE merlin_id = ? AND video_id = ? AND ( company_id = ? OR network_id = ? ) AND user_key = ? ORDER BY timestamp DESC LIMIT 1", new String[] {
            bookmarkid.getProgramId().toString(), Long.toString(bookmarkid.getVideoId()), Long.toString(bookmarkid.getCompanyId()), Long.toString(bookmarkid.getNetworkId()), getUserKey()
        });
        bookmarkid = obj;
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        bookmarkid = obj;
        cursor = cursor1;
        if (cursor1.getCount() <= 0)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        cursor = cursor1;
        cursor1.moveToFirst();
        cursor = cursor1;
        bookmarkid = new SQLiteBookmark(cursor1);
        if (cursor1 != null)
        {
            cursor1.close();
        }
        return bookmarkid;
        bookmarkid;
        if (cursor != null)
        {
            cursor.close();
        }
        throw bookmarkid;
    }

    private VideoBookmark getBookmarkWithId(Long long1)
    {
        Cursor cursor;
        Object obj;
        Object obj1;
        obj = null;
        cursor = null;
        obj1 = playNowDB.getReadableDatabase();
        obj1 = ((SQLiteDatabase) (obj1)).rawQuery("SELECT * FROM bookmark WHERE _id = ? AND user_key = ?;", new String[] {
            long1.toString(), getUserKey()
        });
        long1 = obj;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        long1 = obj;
        cursor = ((Cursor) (obj1));
        if (((Cursor) (obj1)).getCount() <= 0)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        cursor = ((Cursor) (obj1));
        ((Cursor) (obj1)).moveToFirst();
        cursor = ((Cursor) (obj1));
        long1 = new SQLiteBookmark(((Cursor) (obj1)));
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        return long1;
        long1;
        if (cursor != null)
        {
            cursor.close();
        }
        throw long1;
    }

    private List getCategoriesForBookmark(Long long1)
    {
        Long long2;
        ArrayList arraylist;
        Object obj;
        arraylist = new ArrayList();
        long2 = null;
        obj = playNowDB.getReadableDatabase();
        long1 = ((SQLiteDatabase) (obj)).rawQuery("SELECT category_name FROM bookmark_category WHERE bookmark_id = ?;", new String[] {
            long1.toString()
        });
        if (long1 == null)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        long2 = long1;
        if (long1.getCount() <= 0)
        {
            break MISSING_BLOCK_LABEL_117;
        }
_L2:
        long2 = long1;
        if (!long1.moveToNext())
        {
            break MISSING_BLOCK_LABEL_117;
        }
        long2 = long1;
        obj = long1.getString(long1.getColumnIndex("category_name"));
        if (obj == null) goto _L2; else goto _L1
_L1:
        long2 = long1;
        arraylist.add(com.xfinity.playerlib.bookmarks.VideoBookmark.BookmarkCategory.valueOf(((String) (obj))));
          goto _L2
        long1;
        if (long2 != null)
        {
            long2.close();
        }
        throw long1;
        if (long1 != null)
        {
            long1.close();
        }
        return arraylist;
    }

    private String getUserKey()
    {
        PlayNowUser playnowuser = (PlayNowUser)userManager.getUser();
        if (playnowuser != null)
        {
            return playnowuser.getUserName();
        } else
        {
            return null;
        }
    }

    public static void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE bookmark (_id INTEGER PRIMARY KEY AUTOINCREMENT, user_key TEXT NOT NULL, parent_merlin_id TEXT, merlin_id TEXT, video_id INTEGER, network_id INTEGER, company_id INTEGER, title TEXT, position INTEGER, duration INTEGER, expiration_date INTEGER, timestamp INTEGER, season_info INTEGER, episode_info INTEGER,last_tracked_milestone INTEGER);");
        sqlitedatabase.execSQL("CREATE TABLE bookmark_category (_id INTEGER PRIMARY KEY AUTOINCREMENT, bookmark_id INTEGER NOT NULL, category_name TEXT NOT NULL, FOREIGN KEY(bookmark_id) REFERENCES bookmark(_id) ON DELETE CASCADE);");
    }

    public static void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        if (i <= 2)
        {
            sqlitedatabase.execSQL("ALTER TABLE bookmark ADD COLUMN last_tracked_milestone INTEGER DEFAULT 0");
        }
        if (i <= 3)
        {
            sqlitedatabase.execSQL("ALTER TABLE bookmark ADD COLUMN company_id INTEGER DEFAULT 0");
        }
    }

    public boolean deleteBookmark(VideoBookmark videobookmark)
    {
        if (!(videobookmark instanceof SQLiteBookmark))
        {
            throw new IllegalArgumentException("VideoBookmark not an instance of SQLiteBookmark");
        }
        videobookmark = (SQLiteBookmark)videobookmark;
        if (videobookmark.getDbId() == -1L)
        {
            throw new SQLiteException("VideoBookmark has no SQLite ID (It's not in the database)");
        }
        if (playNowDB.getWritableDatabase().delete("bookmark", (new StringBuilder()).append("_id=").append(videobookmark.getDbId()).toString(), null) <= 0)
        {
            throw new SQLiteException("Could not delete any rows from the database");
        } else
        {
            return false;
        }
    }

    public void finalize()
    {
        db.close();
    }

    public VideoBookmark getLastWatchedBookmark()
    {
        Cursor cursor;
        Object obj;
        obj = null;
        cursor = null;
        Cursor cursor1 = db.rawQuery("SELECT bk.* FROM bookmark bk WHERE bk.user_key = ? AND EXISTS ( SELECT cat.* FROM bookmark_category cat WHERE bk._id = cat.bookmark_id AND cat.category_name = ?) AND (expiration_date > ? OR expiration_date IS NULL) ORDER BY timestamp DESC", new String[] {
            getUserKey(), com.xfinity.playerlib.bookmarks.VideoBookmark.BookmarkCategory.CATEGORY_RECENT.toString(), Long.toString((new Date()).getTime())
        });
        VideoBookmark videobookmark;
        videobookmark = obj;
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        videobookmark = obj;
        cursor = cursor1;
        if (cursor1.getCount() <= 0)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        cursor = cursor1;
        cursor1.moveToFirst();
        cursor = cursor1;
        videobookmark = getBookmarkWithId(Long.valueOf(cursor1.getLong(cursor1.getColumnIndex("_id"))));
        if (cursor1 != null)
        {
            cursor1.close();
        }
        return videobookmark;
        Exception exception;
        exception;
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
    }

    public VideoBookmark getOrCreateBookmarkWithVideo(VideoFacade videofacade, Watchable watchable)
    {
        Object obj = (SQLiteBookmark)getBookmarkByBookmarkId(new BookmarkId(videofacade));
        SQLiteBookmark sqlitebookmark = ((SQLiteBookmark) (obj));
        if (obj == null)
        {
            sqlitebookmark = ((SQLiteBookmark) (obj));
            if (watchable.getSeriesInfoIfApplicable() != null)
            {
                sqlitebookmark = ((SQLiteBookmark) (obj));
                if (watchable.getSeriesInfoIfApplicable().getSeasonNumber().intValue() == -1)
                {
                    obj = (SQLiteBookmark)getBookmarkByBookmarkId(new BookmarkId(videofacade.getParentMerlinIdIfApplicable(), videofacade.getNetworkInfo().getNetworkId(), videofacade.getNetworkInfo().getCompanyId(), videofacade.getVideoId()));
                    sqlitebookmark = ((SQLiteBookmark) (obj));
                    if (obj != null)
                    {
                        sqlitebookmark = ((SQLiteBookmark) (obj));
                        if (((SQLiteBookmark) (obj)).updateLegacyNonEpisodeBookmarkWithConsumable(videofacade))
                        {
                            LOG.info("Successfully upgraded legacy non-episode bookmark");
                            sqlitebookmark = ((SQLiteBookmark) (obj));
                        }
                    }
                }
            }
        }
        if (sqlitebookmark == null)
        {
            videofacade = new SQLiteBookmark(videofacade, watchable);
            obj = videofacade;
            if (videofacade.getPosition() >= 0)
            {
                saveBookmark(videofacade);
                LOG.info("Successfully upgraded legacy bookmark");
                obj = videofacade;
            }
        } else
        {
            obj = sqlitebookmark;
            if (sqlitebookmark.updateWithConsumable(videofacade, watchable))
            {
                saveBookmark(sqlitebookmark);
                return sqlitebookmark;
            }
        }
        return ((VideoBookmark) (obj));
    }

    public List getRecentBookmarks()
    {
        Object obj;
        ArrayList arraylist;
        obj = null;
        arraylist = new ArrayList();
        Object obj1 = db.rawQuery("SELECT bk.* FROM bookmark bk WHERE bk.user_key = ? AND EXISTS ( SELECT cat.* FROM bookmark_category cat WHERE bk._id = cat.bookmark_id AND cat.category_name = ?) AND (expiration_date > ? OR expiration_date IS NULL) ORDER BY timestamp DESC", new String[] {
            getUserKey(), com.xfinity.playerlib.bookmarks.VideoBookmark.BookmarkCategory.CATEGORY_RECENT.toString(), Long.toString((new Date()).getTime())
        });
_L2:
        obj = obj1;
        if (!((Cursor) (obj1)).moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        arraylist.add(new SQLiteBookmark(((Cursor) (obj1))));
        if (true) goto _L2; else goto _L1
        obj1;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw obj1;
_L1:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        return arraylist;
    }

    public List getResumePointBookmarks()
    {
        Object obj;
        ArrayList arraylist;
        obj = null;
        arraylist = new ArrayList();
        Object obj1 = db.rawQuery("SELECT bk.* FROM bookmark bk WHERE bk.user_key = ? AND EXISTS ( SELECT cat.* FROM bookmark_category cat WHERE bk._id = cat.bookmark_id AND cat.category_name = ?) AND (expiration_date > ? OR expiration_date IS NULL) ORDER BY timestamp DESC", new String[] {
            getUserKey(), com.xfinity.playerlib.bookmarks.VideoBookmark.BookmarkCategory.CATEGORY_RESUMEPOINT.toString(), Long.toString((new Date()).getTime())
        });
_L2:
        obj = obj1;
        if (!((Cursor) (obj1)).moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        arraylist.add(new SQLiteBookmark(((Cursor) (obj1))));
        if (true) goto _L2; else goto _L1
        obj1;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw obj1;
_L1:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        return arraylist;
    }

    public void saveBookmark(VideoBookmark videobookmark)
    {
        if (!(videobookmark instanceof SQLiteBookmark))
        {
            throw new IllegalArgumentException("VideoBookmark not an instance of SQLiteBookmark");
        }
        Object obj = (SQLiteBookmark)videobookmark;
        if (((SQLiteBookmark) (obj)).getDbId() != -1L)
        {
            deleteBookmark(((VideoBookmark) (obj)));
        }
        if (videobookmark.getCategories().size() == 0)
        {
            throw new IllegalStateException("VideoBookmark has no categories associated with it");
        }
        obj = new ContentValues();
        ((ContentValues) (obj)).put("user_key", getUserKey());
        Date date;
        long l;
        if (videobookmark.getParentMerlinIdIfApplicable() != null)
        {
            ((ContentValues) (obj)).put("parent_merlin_id", videobookmark.getParentMerlinIdIfApplicable().toString());
        } else
        {
            ((ContentValues) (obj)).putNull("parent_merlin_id");
        }
        if (videobookmark.getMerlinId() != null)
        {
            ((ContentValues) (obj)).put("merlin_id", videobookmark.getMerlinId().toString());
        } else
        {
            ((ContentValues) (obj)).putNull("merlin_id");
        }
        ((ContentValues) (obj)).put("video_id", Long.valueOf(videobookmark.getVideoId()));
        ((ContentValues) (obj)).put("company_id", Long.valueOf(videobookmark.getCompanyId()));
        ((ContentValues) (obj)).put("title", videobookmark.getTitle());
        ((ContentValues) (obj)).put("position", Integer.valueOf(videobookmark.getPosition()));
        ((ContentValues) (obj)).put("duration", Integer.valueOf(videobookmark.getDuration()));
        ((ContentValues) (obj)).put("season_info", Integer.valueOf(videobookmark.getSeasonNumber()));
        ((ContentValues) (obj)).put("episode_info", Integer.valueOf(videobookmark.getEpisodeNumber()));
        ((ContentValues) (obj)).put("last_tracked_milestone", Integer.valueOf(videobookmark.getLastTrackedMilestone().ordinal()));
        date = videobookmark.getExpirationDate();
        if (date != null)
        {
            ((ContentValues) (obj)).put("expiration_date", Long.valueOf(date.getTime()));
        } else
        {
            ((ContentValues) (obj)).putNull("expiration_date");
        }
        ((ContentValues) (obj)).put("timestamp", Long.valueOf((new Date()).getTime()));
        l = db.insert("bookmark", null, ((ContentValues) (obj)));
        if (l != -1L)
        {
            ((SQLiteBookmark)videobookmark).setDbId(l);
            ((SQLiteBookmark)videobookmark).setUserKey(getUserKey());
            ContentValues contentvalues;
            for (obj = videobookmark.getCategories().iterator(); ((Iterator) (obj)).hasNext(); db.insert("bookmark_category", null, contentvalues))
            {
                com.xfinity.playerlib.bookmarks.VideoBookmark.BookmarkCategory bookmarkcategory = (com.xfinity.playerlib.bookmarks.VideoBookmark.BookmarkCategory)((Iterator) (obj)).next();
                contentvalues = new ContentValues();
                contentvalues.put("bookmark_id", Long.valueOf(((SQLiteBookmark)videobookmark).getDbId()));
                contentvalues.put("category_name", bookmarkcategory.toString());
            }

        }
    }

    public void updateLastTrackedMilestones()
    {
        Iterator iterator = getResumePointBookmarks().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            VideoBookmark videobookmark = (VideoBookmark)iterator.next();
            int i = videobookmark.getPosition();
            VideoMilestone videomilestone = videobookmark.getLastTrackedMilestone();
            VideoMilestone videomilestone1 = VideoMilestone.decodePosition(i, videobookmark.getDuration());
            if (videomilestone != videomilestone1)
            {
                videobookmark.setLastTrackedMilestone(videomilestone1);
                saveBookmark(videobookmark);
            }
        } while (true);
    }



}
