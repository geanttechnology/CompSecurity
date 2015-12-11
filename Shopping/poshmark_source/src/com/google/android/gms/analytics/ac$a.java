// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.analytics:
//            ac, aa, i, p

class uj extends SQLiteOpenHelper
{

    final ac uh;
    private boolean ui;
    private long uj;

    private void a(SQLiteDatabase sqlitedatabase)
    {
        Cursor cursor;
        HashSet hashset;
        String as[];
        int j;
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            cursor = sqlitedatabase.rawQuery("SELECT * FROM hits2 WHERE 0", null);
        } else
        {
            cursor = SQLiteInstrumentation.rawQuery((SQLiteDatabase)sqlitedatabase, "SELECT * FROM hits2 WHERE 0", null);
        }
        hashset = new HashSet();
        as = cursor.getColumnNames();
        j = 0;
_L2:
        if (j >= as.length)
        {
            break; /* Loop/switch isn't completed */
        }
        hashset.add(as[j]);
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        cursor.close();
        if (!hashset.remove("hit_id") || !hashset.remove("hit_url") || !hashset.remove("hit_string") || !hashset.remove("hit_time"))
        {
            throw new SQLiteException("Database column missing");
        }
        break MISSING_BLOCK_LABEL_146;
        sqlitedatabase;
        cursor.close();
        throw sqlitedatabase;
label0:
        {
            boolean flag;
            if (!hashset.remove("hit_app_id"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!hashset.isEmpty())
            {
                throw new SQLiteException("Database has extra columns");
            }
            if (flag)
            {
                if (sqlitedatabase instanceof SQLiteDatabase)
                {
                    break label0;
                }
                sqlitedatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
            }
            return;
        }
        SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "ALTER TABLE hits2 ADD COLUMN hit_app_id");
        return;
    }

    private boolean a(String s, SQLiteDatabase sqlitedatabase)
    {
        Object obj = null;
        String as[] = new String[1];
        as[0] = "name";
        String as1[] = new String[1];
        as1[0] = s;
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        sqlitedatabase = sqlitedatabase.query("SQLITE_MASTER", as, "name=?", as1, null, null, null);
_L1:
        boolean flag = sqlitedatabase.moveToFirst();
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        return flag;
        sqlitedatabase = SQLiteInstrumentation.query((SQLiteDatabase)sqlitedatabase, "SQLITE_MASTER", as, "name=?", as1, null, null, null);
          goto _L1
        sqlitedatabase;
        sqlitedatabase = null;
_L5:
        aa.w((new StringBuilder()).append("Error querying for table ").append(s).toString());
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        return false;
        s;
        sqlitedatabase = obj;
_L3:
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        throw s;
        s;
        continue; /* Loop/switch isn't completed */
        s;
        if (true) goto _L3; else goto _L2
_L2:
        SQLiteException sqliteexception;
        sqliteexception;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public SQLiteDatabase getWritableDatabase()
    {
        SQLiteDatabase sqlitedatabase;
        if (ui && uj + 0x36ee80L > ac.a(uh).currentTimeMillis())
        {
            throw new SQLiteException("Database creation failed");
        }
        sqlitedatabase = null;
        ui = true;
        uj = ac.a(uh).currentTimeMillis();
        SQLiteDatabase sqlitedatabase1 = super.getWritableDatabase();
        sqlitedatabase = sqlitedatabase1;
_L2:
        SQLiteDatabase sqlitedatabase2 = sqlitedatabase;
        if (sqlitedatabase == null)
        {
            sqlitedatabase2 = super.getWritableDatabase();
        }
        ui = false;
        return sqlitedatabase2;
        SQLiteException sqliteexception;
        sqliteexception;
        ac.c(uh).getDatabasePath(ac.b(uh)).delete();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        p.B(sqlitedatabase.getPath());
    }

    public void onOpen(SQLiteDatabase sqlitedatabase)
    {
        Object obj;
        if (android.os..VERSION.SDK_INT >= 15)
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
        if (!a("hits2", sqlitedatabase))
        {
            obj = ac.cr();
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
            a(sqlitedatabase);
            return;
        }
        sqlitedatabase;
        ((Cursor) (obj)).close();
        throw sqlitedatabase;
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int j, int k)
    {
    }

    orFactory(ac ac1, Context context, String s)
    {
        uh = ac1;
        super(context, s, null, 1);
        uj = 0L;
    }
}
