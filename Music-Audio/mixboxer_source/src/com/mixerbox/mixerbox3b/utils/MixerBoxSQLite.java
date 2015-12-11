// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.classes.SongItem;
import java.util.ArrayList;

public class MixerBoxSQLite extends SQLiteOpenHelper
{

    private static final String DATABASE_NAME = "mixerboxdb.db";
    private static final int DATABASE_VERSION = 4;
    public static final String TB_NAME_MY_PLAYLIST = "tableMyPlaylist";
    public static final String TB_NAME_PLAYLIST = "tablePlaylist";
    public static final String TB_NAME_PUSHED_PLAYLIST = "tablePushedPlaylist";
    public static final String TB_NAME_SONG = "tableSong";
    private SQLiteDatabase db;

    public MixerBoxSQLite(Context context)
    {
        super(context, "mixerboxdb.db", null, 4);
        db = getWritableDatabase();
    }

    public long addMyPlaylist(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            int i)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("MB_ID", s);
        contentvalues.put("NAME", s1);
        contentvalues.put("OWNER_ID", s2);
        contentvalues.put("OWNER_NAME", s3);
        contentvalues.put("ITEM_COUNT", s4);
        contentvalues.put("SUBS_COUNT", s5);
        contentvalues.put("COVER", s6);
        contentvalues.put("TYPE", Integer.valueOf(i));
        return db.insert("tableMyPlaylist", null, contentvalues);
    }

    public void addPlaylist(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            int i, boolean flag)
    {
        if (!db.isOpen() || db.rawQuery((new StringBuilder()).append("SELECT * FROM tablePlaylist WHERE MB_ID=").append(s).toString(), null).getCount() != 0)
        {
            return;
        }
        int j = 0;
        if (flag)
        {
            j = 1;
        }
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("MB_ID", s);
        contentvalues.put("NAME", s1);
        contentvalues.put("OWNER_ID", s2);
        contentvalues.put("OWNER_NAME", s3);
        contentvalues.put("ITEM_COUNT", s4);
        contentvalues.put("SUBS_COUNT", s5);
        contentvalues.put("COVER", s6);
        contentvalues.put("TYPE", Integer.valueOf(i));
        contentvalues.put("ISALBUM", Integer.valueOf(j));
        db.insert("tablePlaylist", null, contentvalues);
    }

    public void addSong(String s, String s1, String s2, String s3, int i, int j, String s4)
    {
        if (db.isOpen())
        {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("PID", s);
            contentvalues.put("NAME", s1);
            contentvalues.put("TIME", s2);
            contentvalues.put("YT_ID", s3);
            contentvalues.put("ORDERS", Integer.valueOf(getSongCount(s)));
            contentvalues.put("SOURCE", Integer.valueOf(j));
            contentvalues.put("THUMBNAIL", s4);
            db.insert("tableSong", null, contentvalues);
        }
    }

    public void batchEnd()
    {
        db.setTransactionSuccessful();
        db.endTransaction();
    }

    public void batchStart()
    {
        db.beginTransaction();
    }

    public void checkHistory(String s)
    {
        if (db.isOpen())
        {
            s = db.rawQuery((new StringBuilder()).append("SELECT * FROM tableSong WHERE PID=\"PLAYLISTHISTORYID\" AND YT_ID=\"").append(s).append("\"").toString(), null);
            if (s.getCount() > 0)
            {
                s.moveToFirst();
                db.delete("tableSong", (new StringBuilder()).append("_ID=").append(s.getString(0)).toString(), null);
            }
            s.close();
        }
    }

    public void closeDb()
    {
        db.close();
    }

    public void deleteHistory()
    {
        if (db.isOpen())
        {
            Cursor cursor = db.rawQuery("SELECT * FROM tableSong WHERE PID=\"PLAYLISTHISTORYID\"", null);
            cursor.moveToFirst();
            db.delete("tableSong", (new StringBuilder()).append("_ID=").append(cursor.getString(0)).toString(), null);
            cursor.close();
        }
    }

    public int deleteMyPlaylist(String s)
    {
        Cursor cursor = getSong(s);
        int j = cursor.getCount();
        cursor.moveToFirst();
        for (int i = 0; i < j; i++)
        {
            deleteSong(cursor.getString(1), cursor.getString(4), cursor.getString(0));
            cursor.moveToNext();
        }

        cursor.close();
        return db.delete("tableMyPlaylist", (new StringBuilder()).append("_ID=").append(s).toString(), null);
    }

    public int deletePlaylist(String s)
    {
        return db.delete("tablePlaylist", (new StringBuilder()).append("MB_ID=").append(s).toString(), null);
    }

    public int deleteSong(String s, String s1, String s2)
    {
        return db.delete("tableSong", (new StringBuilder()).append("PID=\"").append(s).append("\" AND YT_ID=\"").append(s1).append("\" AND _ID=").append(s2).toString(), null);
    }

    public boolean getHasPushed(String s)
    {
        if (db.isOpen())
        {
            s = db.rawQuery((new StringBuilder()).append("SELECT * FROM tablePushedPlaylist WHERE PID=\"").append(s).append("\"").toString(), null);
            int i = s.getCount();
            s.close();
            if (i > 0)
            {
                return true;
            }
        }
        return false;
    }

    public String getLastHistory()
    {
        if (db.isOpen())
        {
            Cursor cursor = db.rawQuery("SELECT * FROM tableSong WHERE PID=\"PLAYLISTHISTORYID\"", null);
            if (cursor.getCount() > 0)
            {
                cursor.moveToLast();
                String s = cursor.getString(4);
                cursor.close();
                return s;
            } else
            {
                cursor.close();
                return "";
            }
        } else
        {
            return "";
        }
    }

    public PlaylistItem getLastPushed()
    {
        Cursor cursor = db.rawQuery("SELECT * FROM tablePushedPlaylist", null);
        if (cursor.getCount() <= 0)
        {
            cursor.close();
            return null;
        } else
        {
            cursor.moveToLast();
            String s = cursor.getString(1);
            String s1 = cursor.getString(2);
            String s2 = cursor.getString(3);
            String s3 = cursor.getString(4);
            String s4 = cursor.getString(5);
            String s5 = cursor.getString(6);
            String s6 = cursor.getString(7);
            cursor.close();
            return new PlaylistItem(s, s1, s2, s3, s4, s5, s6, 3, true);
        }
    }

    public Cursor getMyPlaylist()
    {
        return db.rawQuery("SELECT * FROM tableMyPlaylist", null);
    }

    public int getMyPlaylistCount()
    {
        if (db.isOpen())
        {
            Cursor cursor = db.rawQuery("SELECT * FROM tableMyPlaylist", null);
            int i = cursor.getCount();
            cursor.close();
            return i;
        } else
        {
            return 0;
        }
    }

    public Cursor getPlaylist()
    {
        return db.rawQuery("SELECT * FROM tablePlaylist", null);
    }

    public int getPlaylistCount()
    {
        if (db.isOpen())
        {
            Cursor cursor = db.rawQuery("SELECT * FROM tablePlaylist", null);
            int i = cursor.getCount();
            cursor.close();
            return i;
        } else
        {
            return 0;
        }
    }

    public String getPlaylistCover(String s)
    {
        if (db.isOpen())
        {
            s = db.rawQuery((new StringBuilder()).append("SELECT * FROM tableSong WHERE PID=\"").append(s).append("\"").toString(), null);
            if (s.getCount() <= 0)
            {
                return "";
            } else
            {
                s.moveToLast();
                String s1 = (new StringBuilder()).append("http://i.ytimg.com/vi/").append(s.getString(4)).append("/mqdefault.jpg").toString();
                s.close();
                return s1;
            }
        } else
        {
            return "";
        }
    }

    public Cursor getShouldAddPlaylist()
    {
        return db.rawQuery("SELECT * FROM tablePlaylist WHERE TYPE=2", null);
    }

    public Cursor getSong(String s)
    {
        return db.rawQuery((new StringBuilder()).append("SELECT * FROM tableSong WHERE PID=\"").append(s).append("\" ORDER BY ORDERS").toString(), null);
    }

    public int getSongCount(String s)
    {
        if (db.isOpen())
        {
            s = db.rawQuery((new StringBuilder()).append("SELECT * FROM tableSong WHERE PID=\"").append(s).append("\"").toString(), null);
            int i = s.getCount();
            s.close();
            return i;
        } else
        {
            return 0;
        }
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS tablePlaylist (_ID INTEGER PRIMARY KEY,MB_ID VARCHAR,NAME VARCHAR, OWNER_ID VARCHAR, OWNER_NAME VARCHAR,ITEM_COUNT VARCHAR, SUBS_COUNT VARCHAR, COVER VARCHAR, TYPE INTEGER, ISALBUM INTEGER DEFAULT 0 )");
        sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS tableMyPlaylist (_ID INTEGER PRIMARY KEY,MB_ID VARCHAR,NAME VARCHAR, OWNER_ID VARCHAR, OWNER_NAME VARCHAR,ITEM_COUNT VARCHAR, SUBS_COUNT VARCHAR, COVER VARCHAR, TYPE INTEGER )");
        sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS tableSong (_ID INTEGER PRIMARY KEY,PID VARCHAR, NAME VARCHAR, TIME VARCHAR, YT_ID VARCHAR, ORDERS INTEGER, SOURCE INTEGER, THUMBNAIL VARCHAR )");
        sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS tablePushedPlaylist (_ID INTEGER PRIMARY KEY,PID VARCHAR,NAME VARCHAR, OWNER_ID VARCHAR, OWNER_NAME VARCHAR,ITEM_COUNT VARCHAR, SUBS_COUNT VARCHAR, COVER VARCHAR, TYPE INTEGER )");
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        if (j == 3 && i <= 2)
        {
            sqlitedatabase.execSQL("ALTER TABLE tablePlaylist ADD COLUMN ISALBUM INTEGER DEFAULT 0");
        }
        if (j == 4 && i <= 3)
        {
            sqlitedatabase.execSQL("ALTER TABLE tableSong ADD COLUMN SOURCE INTEGER DEFAULT 1");
            sqlitedatabase.execSQL("ALTER TABLE tableSong ADD COLUMN THUMBNAIL VARCHAR DEFAULT ''");
        }
        onCreate(sqlitedatabase);
    }

    public void putHasPushed(String s, String s1, String s2, String s3, String s4, String s5, String s6)
    {
        if (!db.isOpen() || db.rawQuery((new StringBuilder()).append("SELECT * FROM tablePushedPlaylist WHERE PID=\"").append(s).append("\"").toString(), null).getCount() != 0)
        {
            return;
        } else
        {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("PID", s);
            contentvalues.put("NAME", s1);
            contentvalues.put("OWNER_ID", s2);
            contentvalues.put("OWNER_NAME", s3);
            contentvalues.put("ITEM_COUNT", s4);
            contentvalues.put("SUBS_COUNT", s5);
            contentvalues.put("COVER", s6);
            contentvalues.put("TYPE", Integer.valueOf(3));
            db.insert("tablePushedPlaylist", null, contentvalues);
            return;
        }
    }

    public void reorderMyPlaylist(String s, ArrayList arraylist)
    {
        for (int i = arraylist.size() - 1; i >= 0; i--)
        {
            Cursor cursor = db.rawQuery((new StringBuilder()).append("SELECT * FROM tableSong WHERE PID=\"").append(s).append("\" AND YT_ID=\"").append(((SongItem)arraylist.get(i)).getSongYtId()).append("\" AND _ID=").append(((SongItem)arraylist.get(i)).getSongId()).toString(), null);
            if (cursor.getCount() > 0)
            {
                cursor.moveToFirst();
                ContentValues contentvalues = new ContentValues();
                contentvalues.put("ORDERS", String.valueOf(arraylist.size() - i - 1));
                db.update("tableSong", contentvalues, (new StringBuilder()).append("_ID=").append(cursor.getString(0)).toString(), null);
            }
            cursor.close();
        }

    }

    public void updateMyPlaylist(String s, String s1)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("NAME", s1);
        db.update("tableMyPlaylist", contentvalues, (new StringBuilder()).append("_ID=").append(s).toString(), null);
    }
}
