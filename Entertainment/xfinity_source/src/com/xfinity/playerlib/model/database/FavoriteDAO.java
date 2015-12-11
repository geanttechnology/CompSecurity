// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.model.user.PlayNowUser;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.model.database:
//            PlayNowDatabase

public class FavoriteDAO
{

    private SQLiteDatabase db;
    private PlayNowUserManager userManager;

    public FavoriteDAO(PlayNowDatabase playnowdatabase, PlayNowUserManager playnowusermanager)
    {
        db = playnowdatabase.getWritableDatabase();
        userManager = playnowusermanager;
    }

    public static void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("create table favorite (_id integer primary key autoincrement, merlin_id integer, namespace text, title text, user_name text, is_adult integer,created integer)");
    }

    public static void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
    }

    public long addFavorite(VideoFavorite videofavorite)
    {
        if (videofavorite == null)
        {
            return -1L;
        }
        MerlinId merlinid = videofavorite.getMerlinId();
        ContentValues contentvalues = new ContentValues();
        if (merlinid == null || merlinid.getSimpleId().longValue() <= 0L)
        {
            throw new IllegalArgumentException("Illegal merlinId");
        }
        contentvalues.put("merlin_id", merlinid.getSimpleId());
        contentvalues.put("namespace", merlinid.getNamespace().name());
        contentvalues.put("title", videofavorite.getTitle());
        contentvalues.put("user_name", ((PlayNowUser)userManager.getUser()).getUserName());
        int i;
        if (videofavorite.isAdultContent())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        contentvalues.put("is_adult", Integer.valueOf(i));
        contentvalues.put("created", Long.valueOf(System.currentTimeMillis()));
        return db.insert("favorite", null, contentvalues);
    }

    public boolean deleteFavorite(VideoFavorite videofavorite)
    {
        if (videofavorite == null)
        {
            return false;
        }
        videofavorite = videofavorite.getMerlinId();
        boolean flag;
        if (db.delete("favorite", "user_name=? and namespace=? and merlin_id=?", new String[] {
    ((PlayNowUser)userManager.getUser()).getUserName(), videofavorite.getNamespace().name(), Long.toString(videofavorite.getSimpleId().longValue())
}) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    public List getAllFavorite()
    {
        Object obj;
        ArrayList arraylist;
        if (((PlayerUserSettings)userManager.getUserSettings()).getWantsAdultContent())
        {
            obj = "select * from favorite where user_name=? order by _id desc";
        } else
        {
            obj = "select * from favorite where user_name=? and is_adult = 0 order by _id desc";
        }
        obj = db.rawQuery(((String) (obj)), new String[] {
            ((PlayNowUser)userManager.getUser()).getUserName()
        });
        arraylist = new ArrayList();
        while (((Cursor) (obj)).moveToNext()) 
        {
            MerlinId merlinid = new MerlinId(com.xfinity.playerlib.model.MerlinId.Namespace.valueOf(((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("namespace"))), Long.valueOf(((Cursor) (obj)).getLong(((Cursor) (obj)).getColumnIndex("merlin_id"))));
            String s = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("title"));
            boolean flag;
            if (((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndex("is_adult")) > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            arraylist.add(new VideoFavorite(merlinid, s, flag, new Date(((Cursor) (obj)).getLong(((Cursor) (obj)).getColumnIndex("created")))));
        }
        return arraylist;
    }

    public boolean isInFavorite(VideoFavorite videofavorite)
    {
        videofavorite = videofavorite.getMerlinId();
        return db.rawQuery("select * from favorite where user_name=? and namespace=? and merlin_id=?", new String[] {
            ((PlayNowUser)userManager.getUser()).getUserName(), videofavorite.getNamespace().name(), Long.toString(videofavorite.getSimpleId().longValue())
        }).moveToFirst();
    }
}
