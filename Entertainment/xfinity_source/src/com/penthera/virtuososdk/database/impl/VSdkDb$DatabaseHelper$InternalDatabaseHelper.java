// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.database.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// Referenced classes of package com.penthera.virtuososdk.database.impl:
//            VSdkDb, VirtuosoSDKCursorFactory

private static class Y extends SQLiteOpenHelper
{

    private void createFragmentTable(SQLiteDatabase sqlitedatabase)
    {
        com.penthera.virtuososdk.utility.elper(VSdkDb.access$0(), "Creating fragment table");
        sqlitedatabase.execSQL("CREATE TABLE fragment (_id INTEGER PRIMARY KEY AUTOINCREMENT, parentUuid TEXT, assetUrl TEXT, expectedSize INTEGER, currentSize INTEGER, filePath TEXT, errorType INTEGER, creationTime INTEGER, modifyTime INTEGER, completeTime INTEGER, pending BOOLEAN DEFAULT 1 );");
    }

    private void createProviderTable(SQLiteDatabase sqlitedatabase)
    {
        com.penthera.virtuososdk.utility.elper(VSdkDb.access$0(), "Creating Provider table");
        sqlitedatabase.execSQL("CREATE TABLE providers (_id INTEGER PRIMARY KEY AUTOINCREMENT, provider TEXT UNIQUE NOT NULL );");
    }

    void createCatalogTable(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE catalog (_id TEXT PRIMARY KEY, accessWindow INTEGER DEFAULT 0, contentRating TEXT, userRating INTEGER DEFAULT 1, catalogExpiry INTEGER DEFAULT 0, completeTime INTEGER DEFAULT 0, creationTime INTEGER DEFAULT 0, modifyTime INTEGER DEFAULT 0, desc TEXT, downloadEnabled BOOLEAN DEFAULT 1, downloadExpiry INTEGER DEFAULT 0, duration INTEGER DEFAULT 0, expiryDate INTEGER DEFAULT 0, genre TEXT, featured BOOLEAN DEFAULT 0, title TEXT, type INTEGER DEFAULT 0, popular BOOLEAN DEFAULT 0, contentUrl TEXT, contentSize INTEGER DEFAULT 0, thumbnail TEXT, image TEXT, category TEXT, parent TEXT, streamUrl TEXT, viewedTime INTEGER DEFAULT 0, filePath TEXT, errorType INTEGER DEFAULT -1, fileUuid TEXT, network TEXT);");
    }

    void createFileTable(SQLiteDatabase sqlitedatabase)
    {
        com.penthera.virtuososdk.utility.elper(VSdkDb.access$0(), "Creating file table");
        sqlitedatabase.execSQL("CREATE TABLE file (_id INTEGER PRIMARY KEY AUTOINCREMENT, uuid TEXT UNIQUE, parentUuid TEXT, assetUrl TEXT, description TEXT, expectedSize INTEGER, currentSize INTEGER, filePath TEXT, errorType INTEGER, assetId TEXT, mimeType TEXT, fileHash TEXT, errorCount INTEGER, creationTime INTEGER, modifyTime INTEGER, completeTime INTEGER, pending BOOLEAN DEFAULT 1, addedToQueue BOOLEAN DEFAULT 0, clientAuthority TEXT, hlsFragmentCompletedCount INTEGER DEFAULT 0, hlsFragmentCount INTEGER DEFAULT 0, contentType INTEGER, contentState INTEGER DEFAULT 0, hashState BLOB );");
    }

    void createNetworkTable(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE network (_id TEXT PRIMARY KEY, network_name TEXT, network_image_url TEXT, network_image_thumbnail_url TEXT);");
    }

    void createRegistryTable(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE registry (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT UNIQUE, value TEXT );");
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        performRecUpgrade(sqlitedatabase, 0, 9);
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        com.penthera.virtuososdk.utility.elper(VSdkDb.access$0(), (new StringBuilder("Upgrading database from version ")).append(i).append(" to ").append(j).toString());
        performRecUpgrade(sqlitedatabase, i, j);
    }

    int performRecUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        if (j != 9999 && i != 9999) goto _L2; else goto _L1
_L1:
        int k;
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS file");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS registry");
        onCreate(sqlitedatabase);
        k = j;
_L4:
        return k;
_L2:
        if (i > j)
        {
            throw new RuntimeException("Invalid Upgrade - Old version cannot be greater than the new version");
        }
        k = i;
        if (i == j) goto _L4; else goto _L3
_L3:
        i;
        JVM INSTR tableswitch 0 9: default 116
    //                   0 124
    //                   1 124
    //                   2 124
    //                   3 196
    //                   4 294
    //                   5 340
    //                   6 357
    //                   7 374
    //                   8 392
    //                   9 404;
           goto _L5 _L6 _L6 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L5:
        return performRecUpgrade(sqlitedatabase, i, j);
_L6:
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS file");
        createFileTable(sqlitedatabase);
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS registry");
        createRegistryTable(sqlitedatabase);
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS fragment");
        createFragmentTable(sqlitedatabase);
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS catalog");
        createCatalogTable(sqlitedatabase);
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS providers");
        createProviderTable(sqlitedatabase);
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS network");
        createNetworkTable(sqlitedatabase);
        i = 9;
        continue; /* Loop/switch isn't completed */
_L7:
        sqlitedatabase.execSQL("ALTER TABLE file ADD addedToQueue BOOLEAN DEFAULT 0");
        sqlitedatabase.execSQL("ALTER TABLE file ADD contentType INTEGER");
        sqlitedatabase.execSQL("ALTER TABLE file ADD parentUuid TEXT");
        sqlitedatabase.execSQL("ALTER TABLE file ADD completeTime INTEGER");
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("contentType", Integer.valueOf(1));
        sqlitedatabase.update("file", contentvalues, null, null);
        if (false)
        {
            throw new NullPointerException();
        }
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS fragment");
        createFragmentTable(sqlitedatabase);
        i = 4;
        continue; /* Loop/switch isn't completed */
        sqlitedatabase;
        if (false)
        {
            throw new NullPointerException();
        } else
        {
            throw sqlitedatabase;
        }
_L8:
        createProviderTable(sqlitedatabase);
        sqlitedatabase.execSQL("ALTER TABLE file ADD clientAuthority TEXT");
        ContentValues contentvalues1 = new ContentValues();
        contentvalues1.put("clientAuthority", VSdkDb.access$1());
        sqlitedatabase.update("file", contentvalues1, null, null);
        i = 5;
        continue; /* Loop/switch isn't completed */
_L9:
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS catalog");
        createCatalogTable(sqlitedatabase);
        i = 6;
        continue; /* Loop/switch isn't completed */
_L10:
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS event");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS network");
        createNetworkTable(sqlitedatabase);
_L11:
        sqlitedatabase.execSQL("ALTER TABLE file ADD hlsFragmentCompletedCount INTEGER DEFAULT 0");
        sqlitedatabase.execSQL("ALTER TABLE file ADD hlsFragmentCount INTEGER DEFAULT 0");
        i = 8;
        continue; /* Loop/switch isn't completed */
_L12:
        sqlitedatabase.execSQL("ALTER TABLE file ADD contentState INTEGER DEFAULT 0");
        i = 9;
        continue; /* Loop/switch isn't completed */
_L13:
        i = 9;
        if (true) goto _L5; else goto _L14
_L14:
    }

    Y(Context context)
    {
        super(context, "virtuososdk.db", new VirtuosoSDKCursorFactory(), 9);
    }
}
