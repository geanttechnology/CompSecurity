// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import com.amazon.gallery.foundation.utils.log.GLogger;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            ReadOnlySQLiteDatabase

class TruthDBConnectionManager
{

    private static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/TruthDBConnectionManager.getName();
    private final String databaseId;
    private SQLiteOpenHelper dbOpenHelper;
    private ReadOnlySQLiteDatabase readOnlyConn;

    TruthDBConnectionManager(Context context, String s)
    {
        databaseId = s;
        dbOpenHelper = new SQLiteOpenHelper(context, createDBName(s), null, 0x7fffffff) {

            final TruthDBConnectionManager this$0;

            public void onCreate(SQLiteDatabase sqlitedatabase)
            {
            }

            public void onOpen(SQLiteDatabase sqlitedatabase)
            {
                GLogger.i(TruthDBConnectionManager.TAG, "Connection to Truth DB opened successfully.", new Object[0]);
            }

            public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
            {
            }

            
            {
                this$0 = TruthDBConnectionManager.this;
                super(context, s, cursorfactory, i);
            }
        };
    }

    private static String createDBName(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("clouddrivephotos").append("_").append(s).append(".db");
        return stringbuilder.toString();
    }

    private SQLiteDatabase createReadOnlyDBConnection()
    {
        int i = 0;
_L2:
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = null;
        if (i >= 3)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        sqlitedatabase = dbOpenHelper.getReadableDatabase();
        return sqlitedatabase;
        SQLException sqlexception;
        sqlexception;
        GLogger.ex(TAG, "Can't instantiate database ", sqlexception);
        SystemClock.sleep(100L);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    void deleteDatabase(Context context)
    {
        tearDown();
        if (databaseId != null)
        {
            GLogger.i(TAG, "Deleting Truth DB with id = %s", new Object[] {
                databaseId
            });
            context.deleteDatabase(createDBName(databaseId));
        }
    }

    ReadOnlySQLiteDatabase initializeDBConn()
    {
        if (readOnlyConn == null)
        {
            SQLiteDatabase sqlitedatabase = createReadOnlyDBConnection();
            if (sqlitedatabase != null)
            {
                readOnlyConn = new ReadOnlySQLiteDatabase(sqlitedatabase);
            }
        }
        return readOnlyConn;
    }

    void resetDBConn()
    {
        if (readOnlyConn != null)
        {
            readOnlyConn.close();
            readOnlyConn = null;
        }
    }

    void tearDown()
    {
        resetDBConn();
        if (dbOpenHelper != null)
        {
            dbOpenHelper.close();
            dbOpenHelper = null;
        }
    }


}
