// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.smule.android.c.aa;
import com.smule.pianoandroid.data.model.Listing;
import com.smule.pianoandroid.data.model.OwnedProduct;
import com.smule.pianoandroid.data.model.Product;
import com.smule.pianoandroid.data.model.Resource;
import com.smule.pianoandroid.data.model.ScoreInfo;
import com.smule.pianoandroid.data.model.Section;
import com.smule.pianoandroid.data.model.SectionListingLink;
import com.smule.pianoandroid.data.model.SongProgress;
import com.smule.pianoandroid.data.model.StoreFrontItem;
import java.sql.SQLException;

public class b extends OrmLiteSqliteOpenHelper
{

    public static String a = com/smule/pianoandroid/data/db/b.getName();

    public b(Context context)
    {
        super(context, "magic.db", null, 18, 0x7f05002a);
    }

    public static void a(Context context)
    {
        context = (b)OpenHelperManager.getHelper(context, com/smule/pianoandroid/data/db/b);
        try
        {
            TableUtils.clearTable(context.getConnectionSource(), com/smule/pianoandroid/data/model/ScoreInfo);
            TableUtils.clearTable(context.getConnectionSource(), com/smule/pianoandroid/data/model/SongProgress);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            aa.b(a, "error clearing ScoreInfo table");
        }
    }

    public void close()
    {
        super.close();
    }

    public void onCreate(SQLiteDatabase sqlitedatabase, ConnectionSource connectionsource)
    {
        try
        {
            aa.c(com/smule/pianoandroid/data/db/b.getName(), "onCreate");
            TableUtils.createTable(connectionsource, com/smule/pianoandroid/data/model/Product);
            TableUtils.createTable(connectionsource, com/smule/pianoandroid/data/model/Listing);
            TableUtils.createTable(connectionsource, com/smule/pianoandroid/data/model/Resource);
            TableUtils.createTable(connectionsource, com/smule/pianoandroid/data/model/ScoreInfo);
            TableUtils.createTable(connectionsource, com/smule/pianoandroid/data/model/StoreFrontItem);
            TableUtils.createTable(connectionsource, com/smule/pianoandroid/data/model/OwnedProduct);
            TableUtils.createTable(connectionsource, com/smule/pianoandroid/data/model/SongProgress);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase)
        {
            aa.b(com/smule/pianoandroid/data/db/b.getName(), "Can't create database", sqlitedatabase);
        }
        throw new RuntimeException(sqlitedatabase);
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, ConnectionSource connectionsource, int i, int j)
    {
        try
        {
            aa.c(com/smule/pianoandroid/data/db/b.getName(), (new StringBuilder()).append("onUpgrade. Old version : ").append(i).append(", new version : ").append(j).toString());
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase)
        {
            aa.b(com/smule/pianoandroid/data/db/b.getName(), "error upgrading databases!", sqlitedatabase);
            throw new RuntimeException(sqlitedatabase);
        }
        if (i > 12 || j <= 12)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        getDao(com/smule/pianoandroid/data/model/Product).executeRaw("ALTER TABLE `Product` ADD COLUMN etag String", new String[0]);
        if (i > 13 || j <= 13)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        getDao(com/smule/pianoandroid/data/model/Product).executeRaw("ALTER TABLE `Product` ADD COLUMN product_page_url String", new String[0]);
        if (i > 14 || j <= 14)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        TableUtils.createTable(connectionsource, com/smule/pianoandroid/data/model/SongProgress);
        getDao(com/smule/pianoandroid/data/model/ScoreInfo).executeRaw("ALTER TABLE `SCORE_INFO` ADD COLUMN synced Boolean", new String[0]);
        if (i > 15 || j <= 15)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        getDao(com/smule/pianoandroid/data/model/Listing).executeRaw("ALTER TABLE `Listing` ADD COLUMN subscriber_only Boolean", new String[0]);
        if (i > 16 || j <= 16)
        {
            break MISSING_BLOCK_LABEL_237;
        }
        sqlitedatabase = getDao(com/smule/pianoandroid/data/model/Resource);
        sqlitedatabase.delete(sqlitedatabase.queryForEq("name", "meta"));
        TableUtils.dropTable(connectionsource, com/smule/pianoandroid/data/model/Section, true);
        TableUtils.dropTable(connectionsource, com/smule/pianoandroid/data/model/SectionListingLink, true);
        TableUtils.dropTable(connectionsource, com/smule/pianoandroid/data/model/StoreFrontItem, true);
        TableUtils.createTable(connectionsource, com/smule/pianoandroid/data/model/StoreFrontItem);
        if (i > 17 || j <= 17)
        {
            break MISSING_BLOCK_LABEL_301;
        }
        getDao(com/smule/pianoandroid/data/model/Listing).executeRaw("ALTER TABLE `Listing` ADD COLUMN sku String", new String[0]);
        sqlitedatabase = getDao(com/smule/pianoandroid/data/model/ScoreInfo);
        sqlitedatabase.executeRaw("ALTER TABLE `score_info` ADD COLUMN song_id String", new String[0]);
        sqlitedatabase.executeRaw("UPDATE `score_info` SET song_id = (SELECT uid FROM `product` WHERE `product`._id = `score_info`.song)", new String[0]);
    }

}
