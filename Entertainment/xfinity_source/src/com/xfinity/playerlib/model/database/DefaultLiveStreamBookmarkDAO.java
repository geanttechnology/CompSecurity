// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.xfinity.playerlib.bookmarks.LiveStreamBookmark;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import com.xfinity.playerlib.model.user.PlayNowUser;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.database:
//            LiveStreamBookmarkDAO, PlayNowDatabase

public class DefaultLiveStreamBookmarkDAO
    implements LiveStreamBookmarkDAO
{
    private class SQLiteBookmark extends LiveStreamBookmark
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

        public SQLiteBookmark(Cursor cursor)
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

        public SQLiteBookmark(HalLiveStream hallivestream)
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


    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO);
    private SQLiteDatabase db;
    private PlayNowDatabase playNowDB;
    private PlayNowUserManager userManager;

    public DefaultLiveStreamBookmarkDAO(PlayNowDatabase playnowdatabase, PlayNowUserManager playnowusermanager)
    {
        playNowDB = playnowdatabase;
        userManager = playnowusermanager;
        db = playNowDB.getWritableDatabase();
    }

    private LiveStreamBookmark getBookmarkWithId(Long long1)
    {
        Cursor cursor;
        Object obj;
        Object obj1;
        obj = null;
        cursor = null;
        obj1 = playNowDB.getReadableDatabase();
        obj1 = ((SQLiteDatabase) (obj1)).rawQuery("SELECT * FROM live_stream_bookmark WHERE _id = ? AND user_key = ?;", new String[] {
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
        sqlitedatabase.execSQL("CREATE TABLE live_stream_bookmark (_id INTEGER PRIMARY KEY AUTOINCREMENT, user_key TEXT NOT NULL, stream_id INTEGER, network_id INTEGER, is_favorite INTEGER, is_adult_content INTEGER, title TEXT, artwork_url TEXT, position INTEGER, duration INTEGER, expiration_date INTEGER, created INTEGER, timestamp INTEGER);");
    }

    public static void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        if (i < 2)
        {
            onCreate(sqlitedatabase);
        }
    }

    public LiveStreamBookmark addFavorite(HalLiveStream hallivestream)
    {
        hallivestream = getOrCreateBookmarkWithLiveStream(hallivestream, false);
        if (hallivestream != null)
        {
            hallivestream.setCreatedTime(new Date());
            hallivestream.setIsFavorite(true);
            saveBookmark(hallivestream, false);
        }
        return hallivestream;
    }

    public boolean deleteBookmark(LiveStreamBookmark livestreambookmark)
    {
        if (!(livestreambookmark instanceof SQLiteBookmark))
        {
            throw new IllegalArgumentException("Bookmark not an instance of SQLiteBookmark");
        }
        livestreambookmark = (SQLiteBookmark)livestreambookmark;
        if (livestreambookmark.getDbId() == -1L)
        {
            throw new SQLiteException("Bookmark has no SQLite ID (It's not in the database)");
        }
        if (playNowDB.getWritableDatabase().delete("live_stream_bookmark", (new StringBuilder()).append("_id=").append(livestreambookmark.getDbId()).toString(), null) <= 0)
        {
            throw new SQLiteException("Could not delete any rows from the database");
        } else
        {
            return true;
        }
    }

    public boolean deleteFavorite(String s)
    {
label0:
        {
            boolean flag = false;
            s = getBookmarkByStreamId(s);
            if (s != null)
            {
                if (s.getTimestamp() == null)
                {
                    break label0;
                }
                s.setIsFavorite(false);
                flag = saveBookmark(s, false);
            }
            return flag;
        }
        return deleteBookmark(s);
    }

    public void finalize()
    {
        db.close();
    }

    public LiveStreamBookmark getBookmarkByStreamId(String s)
    {
        Cursor cursor;
        Object obj;
        obj = null;
        cursor = null;
        Cursor cursor1 = db.rawQuery("SELECT * FROM live_stream_bookmark WHERE stream_id = ? AND user_key = ?;", new String[] {
            s, getUserKey()
        });
        s = obj;
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        s = obj;
        cursor = cursor1;
        if (cursor1.getCount() <= 0)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        cursor = cursor1;
        cursor1.moveToFirst();
        cursor = cursor1;
        s = new SQLiteBookmark(cursor1);
        if (cursor1 != null)
        {
            cursor1.close();
        }
        return s;
        s;
        if (cursor != null)
        {
            cursor.close();
        }
        throw s;
    }

    public Map getBookmarks()
    {
        Object obj;
        HashMap hashmap;
        obj = null;
        hashmap = new HashMap();
        Object obj1 = db.rawQuery("SELECT * FROM live_stream_bookmark WHERE user_key = ?;", new String[] {
            getUserKey()
        });
_L2:
        obj = obj1;
        if (!((Cursor) (obj1)).moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        SQLiteBookmark sqlitebookmark = new SQLiteBookmark(((Cursor) (obj1)));
        obj = obj1;
        hashmap.put(sqlitebookmark.getStreamId(), sqlitebookmark);
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
        return hashmap;
    }

    public List getFavorites()
    {
        Object obj;
        ArrayList arraylist;
        obj = null;
        arraylist = new ArrayList();
        Object obj1 = db.rawQuery("SELECT * FROM live_stream_bookmark WHERE is_favorite = ? AND user_key = ?;", new String[] {
            "1", getUserKey()
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

    public LiveStreamBookmark getLastWatchedBookmark()
    {
        Cursor cursor;
        Object obj;
        obj = null;
        cursor = null;
        Cursor cursor1 = db.rawQuery("SELECT * FROM live_stream_bookmark WHERE timestamp IS NOT NULL AND user_key = ? ORDER BY timestamp DESC LIMIT 1", new String[] {
            getUserKey()
        });
        LiveStreamBookmark livestreambookmark;
        livestreambookmark = obj;
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        livestreambookmark = obj;
        cursor = cursor1;
        if (cursor1.getCount() <= 0)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        cursor = cursor1;
        cursor1.moveToFirst();
        cursor = cursor1;
        livestreambookmark = getBookmarkWithId(Long.valueOf(cursor1.getLong(cursor1.getColumnIndex("_id"))));
        if (cursor1 != null)
        {
            cursor1.close();
        }
        return livestreambookmark;
        Exception exception;
        exception;
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
    }

    public LiveStreamBookmark getOrCreateBookmarkWithLiveStream(HalLiveStream hallivestream, boolean flag)
    {
        SQLiteBookmark sqlitebookmark = (SQLiteBookmark)getBookmarkByStreamId(hallivestream.getStreamId());
        if (sqlitebookmark == null)
        {
            hallivestream = new SQLiteBookmark(hallivestream);
            flag = saveBookmark(hallivestream, flag);
            LOG.info("Successfully upgraded legacy bookmark");
        } else
        {
            flag = saveBookmark(sqlitebookmark, flag);
            hallivestream = sqlitebookmark;
        }
        if (flag)
        {
            return hallivestream;
        } else
        {
            return null;
        }
    }

    public List getRecentBookmarks()
    {
        Object obj;
        ArrayList arraylist;
        obj = null;
        arraylist = new ArrayList();
        Object obj1 = db.rawQuery("SELECT * FROM live_stream_bookmark WHERE timestamp IS NOT NULL AND user_key = ?;", new String[] {
            getUserKey()
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

    public boolean removeHistoryItem(LiveStreamBookmark livestreambookmark)
    {
        if (livestreambookmark.isFavorite())
        {
            livestreambookmark.setTimestamp(null);
            return saveBookmark(livestreambookmark, false);
        } else
        {
            return deleteBookmark(livestreambookmark);
        }
    }

    public boolean saveBookmark(LiveStreamBookmark livestreambookmark, boolean flag)
    {
        if (!(livestreambookmark instanceof SQLiteBookmark))
        {
            throw new IllegalArgumentException("Bookmark not an instance of SQLiteBookmark");
        }
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("user_key", getUserKey());
        contentvalues.put("stream_id", livestreambookmark.getStreamId());
        contentvalues.put("network_id", Long.valueOf(livestreambookmark.getCompanyId()));
        contentvalues.put("title", livestreambookmark.getTitle());
        contentvalues.put("artwork_url", livestreambookmark.getArtworkUrl());
        contentvalues.put("position", Integer.valueOf(livestreambookmark.getPosition()));
        contentvalues.put("duration", Integer.valueOf(livestreambookmark.getDuration()));
        Date date;
        int i;
        if (livestreambookmark.isFavorite())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        contentvalues.put("is_favorite", Integer.valueOf(i));
        if (livestreambookmark.isAdultContent())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        contentvalues.put("is_adult_content", Integer.valueOf(i));
        date = livestreambookmark.getExpirationDate();
        if (date != null)
        {
            contentvalues.put("expiration_date", Long.valueOf(date.getTime()));
        } else
        {
            contentvalues.putNull("expiration_date");
        }
        date = livestreambookmark.getCreatedTime();
        if (date != null)
        {
            contentvalues.put("created", Long.valueOf(date.getTime()));
        } else
        {
            contentvalues.put("created", Long.valueOf((new Date()).getTime()));
        }
        if (flag)
        {
            contentvalues.put("timestamp", Long.valueOf((new Date()).getTime()));
        } else
        if (livestreambookmark.getTimestamp() != null)
        {
            contentvalues.put("timestamp", Long.valueOf(livestreambookmark.getTimestamp().getTime()));
        }
        if (((SQLiteBookmark)livestreambookmark).getDbId() != -1L)
        {
            return db.update("live_stream_bookmark", contentvalues, "stream_id = ?", new String[] {
                livestreambookmark.getStreamId()
            }) == 1;
        }
        long l = db.insert("live_stream_bookmark", null, contentvalues);
        if (l != -1L)
        {
            ((SQLiteBookmark)livestreambookmark).setDbId(l);
            ((SQLiteBookmark)livestreambookmark).setUserKey(getUserKey());
            return true;
        } else
        {
            return false;
        }
    }

}
