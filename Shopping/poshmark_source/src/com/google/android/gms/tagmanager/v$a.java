// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.tagmanager:
//            v, bh, ak

class sorFactory extends SQLiteOpenHelper
{

    final v UJ;

    private void a(SQLiteDatabase sqlitedatabase)
    {
        Object obj;
        String as[];
        int i;
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase = sqlitedatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
        } else
        {
            sqlitedatabase = SQLiteInstrumentation.rawQuery((SQLiteDatabase)sqlitedatabase, "SELECT * FROM datalayer WHERE 0", null);
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
        if (!((Set) (obj)).remove("key") || !((Set) (obj)).remove("value") || !((Set) (obj)).remove("ID") || !((Set) (obj)).remove("expires"))
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
        bh.w((new StringBuilder()).append("Error querying for table ").append(s).toString());
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
        SQLiteDatabase sqlitedatabase = null;
        SQLiteDatabase sqlitedatabase1 = super.getWritableDatabase();
        sqlitedatabase = sqlitedatabase1;
_L2:
        SQLiteDatabase sqlitedatabase2 = sqlitedatabase;
        if (sqlitedatabase == null)
        {
            sqlitedatabase2 = super.getWritableDatabase();
        }
        return sqlitedatabase2;
        SQLiteException sqliteexception;
        sqliteexception;
        v.b(UJ).getDatabasePath("google_tagmanager.db").delete();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        ak.B(sqlitedatabase.getPath());
    }

    public void onOpen(SQLiteDatabase sqlitedatabase)
    {
        Object obj;
        if (android.os.d.VERSION.SDK_INT >= 15)
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
        if (!a("datalayer", sqlitedatabase))
        {
            obj = v.iX();
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

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
    }

    sorFactory(v v1, Context context, String s)
    {
        UJ = v1;
        super(context, s, null, 1);
    }
}
