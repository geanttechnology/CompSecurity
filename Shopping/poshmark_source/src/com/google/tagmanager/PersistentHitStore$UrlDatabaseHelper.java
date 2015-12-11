// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.tagmanager:
//            PersistentHitStore, Log, Clock, FutureApis

class mLastDatabaseCheckTime extends SQLiteOpenHelper
{

    private boolean mBadDatabase;
    private long mLastDatabaseCheckTime;
    final PersistentHitStore this$0;

    private boolean tablePresent(String s, SQLiteDatabase sqlitedatabase)
    {
        SQLiteDatabase sqlitedatabase1;
        SQLiteDatabase sqlitedatabase2;
        Object obj;
        Object obj1;
        obj1 = null;
        obj = null;
        sqlitedatabase1 = obj;
        sqlitedatabase2 = obj1;
        String as[] = new String[1];
        as[0] = "name";
        sqlitedatabase1 = obj;
        sqlitedatabase2 = obj1;
        String as1[] = new String[1];
        as1[0] = s;
        sqlitedatabase1 = obj;
        sqlitedatabase2 = obj1;
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        sqlitedatabase1 = obj;
        sqlitedatabase2 = obj1;
        sqlitedatabase = sqlitedatabase.query("SQLITE_MASTER", as, "name=?", as1, null, null, null);
_L4:
        sqlitedatabase1 = sqlitedatabase;
        sqlitedatabase2 = sqlitedatabase;
        boolean flag = sqlitedatabase.moveToFirst();
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        return flag;
_L2:
        sqlitedatabase1 = obj;
        sqlitedatabase2 = obj1;
        sqlitedatabase = SQLiteInstrumentation.query((SQLiteDatabase)sqlitedatabase, "SQLITE_MASTER", as, "name=?", as1, null, null, null);
        if (true) goto _L4; else goto _L3
_L3:
        sqlitedatabase;
        sqlitedatabase2 = sqlitedatabase1;
        Log.w((new StringBuilder()).append("Error querying for table ").append(s).toString());
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.close();
        }
        return false;
        s;
        if (sqlitedatabase2 != null)
        {
            sqlitedatabase2.close();
        }
        throw s;
    }

    private void validateColumnsPresent(SQLiteDatabase sqlitedatabase)
    {
        Object obj;
        String as[];
        int i;
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase = sqlitedatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
        } else
        {
            sqlitedatabase = SQLiteInstrumentation.rawQuery((SQLiteDatabase)sqlitedatabase, "SELECT * FROM gtm_hits WHERE 0", null);
        }
        obj = new HashSet();
        as = sqlitedatabase.getColumnNames();
        i = 0;
_L2:
        if (i >= as.length)
        {
            break; /* Loop/switch isn't completed */
        }
        ((Set) (obj)).add(as[i]);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        sqlitedatabase.close();
        if (!((Set) (obj)).remove("hit_id") || !((Set) (obj)).remove("hit_url") || !((Set) (obj)).remove("hit_time") || !((Set) (obj)).remove("hit_first_send_time"))
        {
            throw new SQLiteException("Database column missing");
        }
        break MISSING_BLOCK_LABEL_143;
        obj;
        sqlitedatabase.close();
        throw obj;
        if (!((Set) (obj)).isEmpty())
        {
            throw new SQLiteException("Database has extra columns");
        } else
        {
            return;
        }
    }

    public SQLiteDatabase getWritableDatabase()
    {
        SQLiteDatabase sqlitedatabase;
        if (mBadDatabase && mLastDatabaseCheckTime + 0x36ee80L > PersistentHitStore.access$100(PersistentHitStore.this).currentTimeMillis())
        {
            throw new SQLiteException("Database creation failed");
        }
        sqlitedatabase = null;
        mBadDatabase = true;
        mLastDatabaseCheckTime = PersistentHitStore.access$100(PersistentHitStore.this).currentTimeMillis();
        SQLiteDatabase sqlitedatabase1 = super.getWritableDatabase();
        sqlitedatabase = sqlitedatabase1;
_L2:
        SQLiteDatabase sqlitedatabase2 = sqlitedatabase;
        if (sqlitedatabase == null)
        {
            sqlitedatabase2 = super.getWritableDatabase();
        }
        mBadDatabase = false;
        return sqlitedatabase2;
        SQLiteException sqliteexception;
        sqliteexception;
        PersistentHitStore.access$400(PersistentHitStore.this).getDatabasePath(PersistentHitStore.access$300(PersistentHitStore.this)).delete();
        if (true) goto _L2; else goto _L1
_L1:
    }

    boolean isBadDatabase()
    {
        return mBadDatabase;
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        FutureApis.setOwnerOnlyReadWrite(sqlitedatabase.getPath());
    }

    public void onOpen(SQLiteDatabase sqlitedatabase)
    {
        Object obj;
        if (android.os.baseHelper >= 15)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            obj = sqlitedatabase.rawQuery("PRAGMA journal_mode=memory", null);
        } else
        {
            obj = SQLiteInstrumentation.rawQuery((SQLiteDatabase)sqlitedatabase, "PRAGMA journal_mode=memory", null);
        }
        ((Cursor) (obj)).moveToFirst();
        ((Cursor) (obj)).close();
        if (!tablePresent("gtm_hits", sqlitedatabase))
        {
            obj = PersistentHitStore.access$500();
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                sqlitedatabase.execSQL(((String) (obj)));
                return;
            } else
            {
                SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, ((String) (obj)));
                return;
            }
        } else
        {
            validateColumnsPresent(sqlitedatabase);
            return;
        }
        sqlitedatabase;
        ((Cursor) (obj)).close();
        throw sqlitedatabase;
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
    }

    void setBadDatabase(boolean flag)
    {
        mBadDatabase = flag;
    }

    ation(Context context, String s)
    {
        this$0 = PersistentHitStore.this;
        super(context, s, null, 1);
        mLastDatabaseCheckTime = 0L;
    }
}
