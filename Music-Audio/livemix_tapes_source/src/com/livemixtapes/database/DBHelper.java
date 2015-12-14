// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.livemixtapes.Utils;
import com.livemixtapes.console;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper
{

    public static final String ALL_MIXTAPE_TABLE_NAME = "all_mixtapes";
    public static final String DATABASE_NAME = "Mixtape.db";
    private static final int DATABASE_VERSION = 6;
    public static final String DAY_MIXTAPE_TABLE_NAME = "day_mixtapes";
    public static final String DOWNLOAD_COLUMN_DURATION = "duration";
    public static final String DOWNLOAD_COLUMN_ID = "id";
    public static final String DOWNLOAD_COLUMN_IS_DOWNLOADED = "isDownloaded";
    public static final String DOWNLOAD_COLUMN_MIXTAPE_ID = "albumId";
    public static final String DOWNLOAD_COLUMN_MIXTAPE_IMAGE = "albumImage";
    public static final String DOWNLOAD_COLUMN_MIXTAPE_NAME = "albumName";
    public static final String DOWNLOAD_COLUMN_TRACK_ID = "trackId";
    public static final String DOWNLOAD_COLUMN_TRACK_NAME = "trackName";
    public static final String DOWNLOAD_TABLE_NAME = "downloads";
    public static final String FAVORITES_COLUMN_ID = "id";
    public static final String FAVORITES_COLUMN_MIXTAPE_ID = "mixtapeId";
    public static final String FAVORITES_COLUMN_MIXTAPE_IMAGE = "mixtapeImage";
    public static final String FAVORITES_COLUMN_MIXTAPE_NAME = "mixtapeName";
    public static final String FAVORITES_TABLE_NAME = "favorites";
    public static final String MIXTAPE_COLUMN_ARTIST = "artist";
    public static final String MIXTAPE_COLUMN_COVER = "cover";
    public static final String MIXTAPE_COLUMN_DJ = "DJ";
    public static final String MIXTAPE_COLUMN_FEATURED = "featured";
    public static final String MIXTAPE_COLUMN_ID = "id";
    public static final String MIXTAPE_COLUMN_MIXTAPE_ID = "mixtapeId";
    public static final String MIXTAPE_COLUMN_RELEASEDDATE = "releasedate";
    public static final String MIXTAPE_COLUMN_SCORE = "score";
    public static final String MIXTAPE_COLUMN_SHARE_TEXT = "sharetext";
    public static final String MIXTAPE_COLUMN_THUMBNAIL = "thumbnail";
    public static final String MIXTAPE_COLUMN_TITLE = "title";
    public static final String MIXTAPE_COLUMN_VIEWS = "views";
    public static final String MIXTAPE_TABLE_NAME = "mixtape";
    public static final String PUSH_TABLE_NAME = "push";
    public static final String TRACKS_COLUMN_DOWNLOAD_URL = "downloadUrl";
    public static final String TRACKS_COLUMN_DURATION = "duration";
    public static final String TRACKS_COLUMN_ID = "id";
    public static final String TRACKS_COLUMN_MIXTAPE_ID = "mixtapeId";
    public static final String TRACKS_COLUMN_SHARE_TEXT = "shareText";
    public static final String TRACKS_COLUMN_TITLE = "title";
    public static final String TRACKS_COLUMN_TRACK_ID = "trackId";
    public static final String TRACKS_TABLE_NAME = "tracks";
    public static final String UNRELEASED_MIXTAPE_TABLE_NAME = "unreleased_mixtapes";
    public static final String WEEK_MIXTAPE_TABLE_NAME = "week_mixtapes";
    public static DBHelper instance = null;
    private SQLiteDatabase dbReader;
    private SQLiteDatabase dbWriter;

    public DBHelper(Context context)
    {
        super(context, "Mixtape.db", null, 6);
        dbWriter = getWritableDatabase();
        dbReader = getReadableDatabase();
    }

    public static DBHelper sharedInstance(Context context)
    {
        if (instance == null)
        {
            instance = new DBHelper(context);
        }
        return instance;
    }

    public boolean checkIfTrackDownloaded(String s)
    {
        s = (new StringBuilder("select * from downloads where trackId = '")).append(s).append("'").toString();
        s = dbReader.rawQuery(s, null);
        if (s.getCount() <= 0)
        {
            s.close();
            return false;
        } else
        {
            s.close();
            return true;
        }
    }

    public void clearMixtapeTable(String s)
    {
        dbWriter.delete(s, null, null);
    }

    public void clearTracksTable()
    {
        dbWriter.delete("tracks", null, null);
    }

    public int deleteDownload(String s)
    {
        return dbWriter.delete("downloads", (new StringBuilder("trackId='")).append(s).append("'").toString(), null);
    }

    public int deleteDownloadsAlbum(Context context, String s)
    {
        Cursor cursor = dbWriter.rawQuery((new StringBuilder("select * from downloads where albumId = '")).append(s).append("'").toString(), null);
        cursor.moveToFirst();
        do
        {
            if (cursor.isAfterLast())
            {
                cursor.close();
                return dbWriter.delete("downloads", (new StringBuilder("albumId='")).append(s).append("'").toString(), null);
            }
            File file = Utils.getLivemixtapesFolder(context, cursor.getString(cursor.getColumnIndex("trackId")));
            if (file.exists())
            {
                file.delete();
            }
            cursor.moveToNext();
        } while (true);
    }

    public void finalize()
    {
        dbWriter.close();
        dbReader.close();
    }

    public ArrayList getAllMixtapeData(String s)
    {
        ArrayList arraylist = new ArrayList();
        s = dbReader.rawQuery((new StringBuilder("select * from ")).append(s).toString(), null);
        s.moveToFirst();
        do
        {
            if (s.isAfterLast())
            {
                s.close();
                return arraylist;
            }
            HashMap hashmap = new HashMap();
            String s1 = s.getString(s.getColumnIndex("mixtapeId"));
            hashmap.put("id", s1);
            hashmap.put("title", s.getString(s.getColumnIndex("title")));
            hashmap.put("artist", s.getString(s.getColumnIndex("artist")));
            hashmap.put("thumbnail", s.getString(s.getColumnIndex("thumbnail")));
            hashmap.put("DJ", s.getString(s.getColumnIndex("DJ")));
            hashmap.put("views", s.getString(s.getColumnIndex("views")));
            hashmap.put("score", s.getString(s.getColumnIndex("score")));
            hashmap.put("cover", s.getString(s.getColumnIndex("cover")));
            hashmap.put("sharetext", s.getString(s.getColumnIndex("sharetext")));
            hashmap.put("releasedate", s.getString(s.getColumnIndex("releasedate")));
            hashmap.put("featured", s.getString(s.getColumnIndex("featured")));
            hashmap.put("tracks", getTracksOfMixtape(s1));
            arraylist.add(hashmap);
            s.moveToNext();
        } while (true);
    }

    public ArrayList getAllTracksData()
    {
        ArrayList arraylist = new ArrayList();
        Cursor cursor = dbReader.rawQuery("select * from tracks", null);
        cursor.moveToFirst();
        do
        {
            if (cursor.isAfterLast())
            {
                cursor.close();
                return arraylist;
            }
            arraylist.add(cursor.getString(cursor.getColumnIndex("title")));
            cursor.moveToNext();
        } while (true);
    }

    public ArrayList getDownloads()
    {
        ArrayList arraylist = new ArrayList();
        Cursor cursor = dbReader.rawQuery("select * from downloads where isDownloaded=1", null);
        cursor.moveToFirst();
        do
        {
            if (cursor.isAfterLast())
            {
                cursor.close();
                return arraylist;
            }
            HashMap hashmap = new HashMap();
            hashmap.put("title", (new StringBuilder(String.valueOf(cursor.getString(cursor.getColumnIndex("trackName"))))).append(" - ").append(cursor.getString(cursor.getColumnIndex("albumName"))).toString());
            hashmap.put("image", cursor.getString(cursor.getColumnIndex("albumImage")));
            hashmap.put("duration", (new StringBuilder(String.valueOf(cursor.getInt(cursor.getColumnIndex("duration"))))).toString());
            arraylist.add(hashmap);
            cursor.moveToNext();
        } while (true);
    }

    public ArrayList getDownloadsGroupedByAlbum()
    {
        ArrayList arraylist = new ArrayList();
        Cursor cursor = dbReader.rawQuery("select albumId, albumName, albumImage, sum(duration), count(albumId) from downloads where isDownloaded=1 group by albumId", null);
        cursor.moveToFirst();
        do
        {
            if (cursor.isAfterLast())
            {
                cursor.close();
                return arraylist;
            }
            HashMap hashmap = new HashMap();
            hashmap.put("title", cursor.getString(cursor.getColumnIndex("albumName")));
            hashmap.put("image", cursor.getString(cursor.getColumnIndex("albumImage")));
            hashmap.put("duration", (new StringBuilder(String.valueOf(cursor.getInt(3)))).toString());
            hashmap.put("count", (new StringBuilder(String.valueOf(cursor.getInt(4)))).toString());
            hashmap.put("albumId", cursor.getString(0));
            arraylist.add(hashmap);
            cursor.moveToNext();
        } while (true);
    }

    public ArrayList getIncompleteDownloads()
    {
        ArrayList arraylist = new ArrayList();
        Cursor cursor = dbReader.rawQuery("select * from downloads where isDownloaded=0", null);
        cursor.moveToFirst();
        do
        {
            if (cursor.isAfterLast())
            {
                cursor.close();
                return arraylist;
            }
            HashMap hashmap = new HashMap();
            hashmap.put("track_id", cursor.getString(cursor.getColumnIndex("trackId")));
            hashmap.put("mixtape_id", cursor.getString(cursor.getColumnIndex("albumId")));
            hashmap.put("title", (new StringBuilder(String.valueOf(cursor.getString(cursor.getColumnIndex("trackName"))))).append(" - ").append(cursor.getString(cursor.getColumnIndex("albumName"))).toString());
            hashmap.put("image", cursor.getString(cursor.getColumnIndex("albumImage")));
            hashmap.put("duration", (new StringBuilder(String.valueOf(cursor.getInt(cursor.getColumnIndex("duration"))))).toString());
            arraylist.add(hashmap);
            cursor.moveToNext();
        } while (true);
    }

    public Cursor getMixtapeData(int i)
    {
        return dbReader.rawQuery((new StringBuilder("select * from mixtape where id=")).append(i).toString(), null);
    }

    public ArrayList getTracksOfMixtape(String s)
    {
        ArrayList arraylist = new ArrayList();
        s = dbReader.query("tracks", null, (new StringBuilder("mixtapeId='")).append(s).append("'").toString(), null, null, null, null);
        s.moveToFirst();
        do
        {
            if (s.isAfterLast())
            {
                return arraylist;
            }
            HashMap hashmap = new HashMap();
            hashmap.put("track_id", s.getString(s.getColumnIndex("trackId")));
            hashmap.put("track_title", s.getString(s.getColumnIndex("title")));
            hashmap.put("track_duration", s.getString(s.getColumnIndex("duration")));
            hashmap.put("download_url", s.getString(s.getColumnIndex("downloadUrl")));
            hashmap.put("track_sharetext", s.getString(s.getColumnIndex("shareText")));
            arraylist.add(hashmap);
            s.moveToNext();
        } while (true);
    }

    public boolean insertDownload(String s, String s1, String s2, String s3, String s4, String s5, int i)
    {
        console.log(new Object[] {
            (new StringBuilder("INSERT CALLED: ")).append(s).toString()
        });
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("trackId", s);
        contentvalues.put("trackName", s1);
        contentvalues.put("albumId", s2);
        contentvalues.put("albumName", s3);
        contentvalues.put("albumImage", s4);
        contentvalues.put("duration", Integer.valueOf(Integer.parseInt(s5)));
        contentvalues.put("isDownloaded", Integer.valueOf(i));
        dbWriter.insertOrThrow("downloads", null, contentvalues);
        return true;
    }

    public boolean insertFavorite(String s, String s1, String s2)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("mixtapeId", s);
        contentvalues.put("mixtapeName", s1);
        contentvalues.put("mixtapeImage", s2);
        dbWriter.insert("favorites", null, contentvalues);
        return true;
    }

    public boolean insertMixtape(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10, String s11)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("mixtapeId", s1);
        contentvalues.put("title", s2);
        contentvalues.put("artist", s3);
        contentvalues.put("thumbnail", s4);
        contentvalues.put("DJ", s5);
        contentvalues.put("views", s6);
        contentvalues.put("cover", s7);
        contentvalues.put("score", s8);
        contentvalues.put("sharetext", s9);
        contentvalues.put("releasedate", s10);
        contentvalues.put("featured", s11);
        try
        {
            dbWriter.insertOrThrow(s, null, contentvalues);
            dbWriter.replaceOrThrow("mixtape", null, contentvalues);
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        return true;
    }

    public boolean insertPush(Integer integer, String s, String s1, String s2)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("id", integer);
        contentvalues.put("device_token", s);
        contentvalues.put("device_id", s1);
        contentvalues.put("device_description", s2);
        dbWriter.insert("push", null, contentvalues);
        return true;
    }

    public boolean insertTrack(String s, String s1, String s2, String s3, String s4, String s5)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("mixtapeId", s);
        contentvalues.put("trackId", s1);
        contentvalues.put("title", s2);
        contentvalues.put("duration", s3);
        contentvalues.put("downloadUrl", s4);
        contentvalues.put("shareText", s5);
        dbWriter.replaceOrThrow("tracks", null, contentvalues);
        return true;
    }

    public int markDownloadComplete(String s)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("isDownloaded", Integer.valueOf(1));
        return dbWriter.update("downloads", contentvalues, (new StringBuilder("trackId='")).append(s).append("'").toString(), null);
    }

    public int mixtapeCount(String s)
    {
        s = dbReader.rawQuery((new StringBuilder("select id from ")).append(s).toString(), null);
        int i = s.getCount();
        s.close();
        return i;
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("create table mixtape (id integer primary key, mixtapeId text UNIQUE, title text, artist text, thumbnail text, DJ text, views text, cover text, score text, sharetext text, releasedate text, featured text)");
        sqlitedatabase.execSQL("create table all_mixtapes (id integer primary key, mixtapeId text, title text, artist text, thumbnail text, DJ text, views text, cover text, score text, sharetext text, releasedate text, featured text)");
        sqlitedatabase.execSQL("create table week_mixtapes (id integer primary key, mixtapeId text, title text, artist text, thumbnail text, DJ text, views text, cover text, score text, sharetext text, releasedate text, featured text)");
        sqlitedatabase.execSQL("create table day_mixtapes (id integer primary key, mixtapeId text, title text, artist text, thumbnail text, DJ text, views text, cover text, score text, sharetext text, releasedate text, featured text)");
        sqlitedatabase.execSQL("create table unreleased_mixtapes (id integer primary key, mixtapeId text, title text, artist text, thumbnail text, DJ text, views text, cover text, score text, sharetext text, releasedate text, featured text)");
        sqlitedatabase.execSQL("create table tracks (id integer primary key, mixtapeId text, trackId text UNIQUE, title text, duration text, downloadUrl text, shareText text)");
        sqlitedatabase.execSQL("create table downloads (id integer primary key, trackId text, trackName text, albumId text, albumName text, albumImage text, duration integer, isDownloaded integer)");
        sqlitedatabase.execSQL("create table favorites (id integer primary key, mixtapeId text, mixtapeName text, mixtapeImage text)");
        sqlitedatabase.execSQL("create table push (id integer primary key, device_token text, device_id text, device_description text)");
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS mixtape");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS all_mixtapes");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS week_mixtapes");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS day_mixtapes");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS unreleased_mixtapes");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS push");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS tracks");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS downloads");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS favorites");
        onCreate(sqlitedatabase);
    }

}
