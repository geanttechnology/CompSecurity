// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// Referenced classes of package com.xfinity.playerlib.model.database:
//            DefaultVideoBookmarkDAO, DefaultLiveStreamBookmarkDAO, FavoriteDAO

public class PlayNowDatabase extends SQLiteOpenHelper
{

    public PlayNowDatabase(Context context)
    {
        super(context, "playNowDB", null, 4);
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        DefaultVideoBookmarkDAO.onCreate(sqlitedatabase);
        DefaultLiveStreamBookmarkDAO.onCreate(sqlitedatabase);
        FavoriteDAO.onCreate(sqlitedatabase);
    }

    public void onOpen(SQLiteDatabase sqlitedatabase)
    {
        super.onOpen(sqlitedatabase);
        if (!sqlitedatabase.isReadOnly())
        {
            sqlitedatabase.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        DefaultVideoBookmarkDAO.onUpgrade(sqlitedatabase, i, j);
        DefaultLiveStreamBookmarkDAO.onUpgrade(sqlitedatabase, i, j);
        FavoriteDAO.onUpgrade(sqlitedatabase, i, j);
    }
}
