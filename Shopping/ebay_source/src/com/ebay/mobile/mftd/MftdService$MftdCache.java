// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.mftd;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

// Referenced classes of package com.ebay.mobile.mftd:
//            MftdService

private class <init>
{

    private static final String DB_NAME = "motd_cache.db";
    private static final int DB_VERSION = 1;
    private static final String MOTD_CONTENT_TYPE = "contentType";
    private static final String MOTD_MAX_NUMBER_OF_VIEWS = "maxNumOfViews";
    private static final String MOTD_MESSAGE = "message";
    private static final String MOTD_MESSAGE_ID = "id";
    private static final String MOTD_MESSAGE_TYPE = "messageType";
    private static final String MOTD_NUMBER_OF_VIEWS = "numberOfViews";
    private static final String MOTD_TABLE_NAME = "motd";
    private static final String MOTD_VALIDFROM_TIMESTAMP = "validFrom";
    private static final String MOTD_VALIDTO_TIMESTAMP = "validTo";
    private static final String SQL_CREATE_MOTD_TABLE = "CREATE TABLE motd (id INTEGER PRIMARY KEY, message TEXT, messageType TEXT, contentType TEXT, maxNumOfViews INTEGER, validFrom INTEGER, validTo INTEGER, numberOfViews INTEGER);";
    private static final String SQL_INSERT_MOTD_RECORD = "INSERT INTO motd(id,message,messageType,contentType,maxNumOfViews,validFrom,validTo,numberOfViews) VALUES(?,?,?,?,?,?,?,?)";
    private static final String SQL_PURGE_EXPIRED_MOTDS = "DELETE FROM motd WHERE validTo<?";
    private static final String SQL_UPDATE_MOTD_NUMBER_OF_VIEWS = "UPDATE motd SET numberOfViews=? WHERE id=?";
    private final String MOTD_SEARCH_COLUMNS[];
    private SQLiteDatabase db;
    private SQLiteOpenHelper helper;
    final MftdService this$0;

    private void close()
    {
        if (db == null)
        {
            return;
        }
        try
        {
            db.close();
            return;
        }
        catch (SQLException sqlexception)
        {
            Log.e("MftdService", sqlexception.toString());
        }
    }

    private int getNumberOfViews(int i)
    {
        long l1;
        long l2;
        if (db == null)
        {
            return 0;
        }
        l2 = 0L;
        l1 = l2;
        Cursor cursor = db.query("motd", MOTD_SEARCH_COLUMNS, (new StringBuilder()).append("id=").append(i).toString(), null, null, null, null);
        long l;
        l = l2;
        l1 = l2;
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_81;
        }
        l1 = l2;
        l = cursor.getLong(2);
        l1 = l;
        try
        {
            cursor.close();
        }
        catch (SQLException sqlexception)
        {
            Log.e("MftdService", sqlexception.toString());
            l = l1;
        }
        return (int)l;
    }

    private void insertMftdRecord(int i, String s, String s1, String s2, int j, long l, 
            long l1, int k)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = db;
        if (sqlitedatabase != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        SQLiteStatement sqlitestatement = db.compileStatement("INSERT INTO motd(id,message,messageType,contentType,maxNumOfViews,validFrom,validTo,numberOfViews) VALUES(?,?,?,?,?,?,?,?)");
        sqlitestatement.bindLong(1, i);
        sqlitestatement.bindString(2, s);
        sqlitestatement.bindString(3, s1);
        sqlitestatement.bindString(4, s2);
        sqlitestatement.bindLong(5, j);
        sqlitestatement.bindLong(6, l);
        sqlitestatement.bindLong(7, l1);
        sqlitestatement.bindLong(8, k);
        sqlitestatement.execute();
          goto _L1
        s;
        Log.e("MftdService", s.toString());
          goto _L1
        s;
        throw s;
        s;
        Log.e("MftdService", s.toString());
          goto _L1
    }

    private void purgeMftdExpired(long l)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = db;
        if (sqlitedatabase != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        SQLiteStatement sqlitestatement = db.compileStatement("DELETE FROM motd WHERE validTo<?");
        sqlitestatement.bindLong(1, l);
        sqlitestatement.execute();
          goto _L1
        Object obj;
        obj;
        Log.e("MftdService", ((SQLException) (obj)).toString());
          goto _L1
        obj;
        throw obj;
        obj;
        Log.e("MftdService", ((IllegalArgumentException) (obj)).toString());
          goto _L1
    }

    private void updateMftdNumOfViews(int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = db;
        if (sqlitedatabase != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        SQLiteStatement sqlitestatement = db.compileStatement("UPDATE motd SET numberOfViews=? WHERE id=?");
        sqlitestatement.bindLong(1, j);
        sqlitestatement.bindLong(2, i);
        sqlitestatement.execute();
          goto _L1
        Object obj;
        obj;
        Log.e("MftdService", ((SQLException) (obj)).toString());
          goto _L1
        obj;
        throw obj;
        obj;
        Log.e("MftdService", ((IllegalArgumentException) (obj)).toString());
          goto _L1
    }






    private orFactory(boolean flag)
    {
        this$0 = MftdService.this;
        super();
        db = null;
        MOTD_SEARCH_COLUMNS = (new String[] {
            "id", "maxNumOfViews", "numberOfViews"
        });
        helper = new SQLiteOpenHelper("motd_cache.db", null, 1, MftdService.this) {

            final MftdService.MftdCache this$1;
            final MftdService val$this$0;

            public void onCreate(SQLiteDatabase sqlitedatabase)
            {
                this;
                JVM INSTR monitorenter ;
                sqlitedatabase.execSQL("CREATE TABLE motd (id INTEGER PRIMARY KEY, message TEXT, messageType TEXT, contentType TEXT, maxNumOfViews INTEGER, validFrom INTEGER, validTo INTEGER, numberOfViews INTEGER);");
_L2:
                this;
                JVM INSTR monitorexit ;
                return;
                sqlitedatabase;
                Log.e("MftdService", sqlitedatabase.toString());
                if (true) goto _L2; else goto _L1
_L1:
                sqlitedatabase;
                throw sqlitedatabase;
            }

            public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
            {
                this;
                JVM INSTR monitorenter ;
                sqlitedatabase.execSQL("DROP TABLE IF EXISTS motd");
                onCreate(sqlitedatabase);
_L2:
                this;
                JVM INSTR monitorexit ;
                return;
                sqlitedatabase;
                Log.e("MftdService", sqlitedatabase.toString());
                if (true) goto _L2; else goto _L1
_L1:
                sqlitedatabase;
                throw sqlitedatabase;
            }

            
            {
                this$1 = MftdService.MftdCache.this;
                this$0 = mftdservice;
                super(final_context, s, cursorfactory, i);
            }
        };
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        mftdservice = helper.getReadableDatabase();
_L1:
        db = MftdService.this;
        return;
        try
        {
            mftdservice = helper.getWritableDatabase();
        }
        // Misplaced declaration of an exception variable
        catch (MftdService mftdservice)
        {
            Log.e("MftdService", toString());
            return;
        }
          goto _L1
    }

    tring(boolean flag, tring tring)
    {
        this(flag);
    }
}
