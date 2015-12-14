// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.cyberlink.youcammakeup.Globals;
import com.pf.common.utility.m;

public class h extends SQLiteOpenHelper
{

    public h(Context context)
    {
        super(context, "pht.sqlite", null, 1);
    }

    private void a(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE Image (_id INTEGER PRIMARY KEY AUTOINCREMENT,CaptureTime BIGINT,Orientation INTEGER,PresetCommand TEXT,FileID BIGINT,Rating INTEGER,FileType TEXT,FileHeight INTEGER,FileWidth INTEGER,RawSDKMode INTEGER,Temperature TEXT,RefreshModifiedTime BIGINT,ShareTo INTEGER,ThumbOrientation INTEGER,OriginalColorSpace INTEGER,SourceOrientation INTEGER,HistorySettingsID INTEGER);ALTER TABLE Image AUTO_INCREMENT = 128;");
        sqlitedatabase.execSQL("CREATE TABLE ImageDevelopHistoryStep (_id INTEGER PRIMARY KEY,HasDevelopAdjustments INTEGER,IsBlackWhite INTEGER,ImageID INTEGER,Formating TEXT,Name TEXT,RelValueString TEXT,TEXT TEXT,ValueString TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE ImageCache (_id INTEGER PRIMARY KEY,ImageID INTEGER,Level INTEGER,DataPath TEXT,FileWidth INTEGER,FileHeight INTEGER);");
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.beginTransaction();
        m.c("database.DatabaseOpenHelper", "creating schema");
        a(sqlitedatabase);
        sqlitedatabase.setTransactionSuccessful();
        m.c("database.DatabaseOpenHelper", "end transaction");
        sqlitedatabase.endTransaction();
        return;
        Object obj;
        obj;
        m.e("database.DatabaseOpenHelper", (new StringBuilder()).append("Exception: ").append(((Exception) (obj)).getMessage()).toString());
        m.c("database.DatabaseOpenHelper", "end transaction");
        sqlitedatabase.endTransaction();
        return;
        obj;
        m.c("database.DatabaseOpenHelper", "end transaction");
        sqlitedatabase.endTransaction();
        throw obj;
    }

    public void onDowngrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        m.d("database.DatabaseOpenHelper", (new StringBuilder()).append("Downgrading database from version ").append(i).append(" to ").append(j).append(", which will destroy all old data").toString());
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS Image");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS ImageDevelopHistoryStep");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS ImageCache");
        m.e("database.DatabaseOpenHelper", "Downgrading done.");
        onCreate(sqlitedatabase);
    }

    public void onOpen(SQLiteDatabase sqlitedatabase)
    {
        m.c("database.DatabaseOpenHelper", "Open database");
        super.onOpen(sqlitedatabase);
        if (Globals.X())
        {
            return;
        } else
        {
            sqlitedatabase.rawQuery("PRAGMA synchronous = OFF;", null).close();
            sqlitedatabase.rawQuery("PRAGMA temp_store = MEMORY;", null).close();
            sqlitedatabase.rawQuery("PRAGMA cache_size = 20000;", null).close();
            return;
        }
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        m.d("database.DatabaseOpenHelper", (new StringBuilder()).append("Upgrading database from version ").append(i).append(" to ").append(j).append(", which will destroy all old data").toString());
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS Image");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS ImageDevelopHistoryStep");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS ImageCache");
        m.d("database.DatabaseOpenHelper", "Upgrading done.");
        onCreate(sqlitedatabase);
    }
}
