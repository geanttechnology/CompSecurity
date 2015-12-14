// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.t;

// Referenced classes of package com.cyberlink.beautycircle.model.database:
//            Contract

public class c extends SQLiteOpenHelper
{

    public c(Context context)
    {
        super(context, "beautycircle.sqlite", null, 2);
    }

    private void a(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL(Contract.Posts.CREATE_TABLE_COMMAND);
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.beginTransaction();
        e.c(new Object[] {
            "creating schema"
        });
        a(sqlitedatabase);
        sqlitedatabase.setTransactionSuccessful();
        e.c(new Object[] {
            "end transaction"
        });
        sqlitedatabase.endTransaction();
        return;
        Object obj;
        obj;
        e.e(new Object[] {
            (new StringBuilder()).append("Exception: ").append(((Exception) (obj)).getMessage()).toString()
        });
        e.c(new Object[] {
            "end transaction"
        });
        sqlitedatabase.endTransaction();
        return;
        obj;
        e.c(new Object[] {
            "end transaction"
        });
        sqlitedatabase.endTransaction();
        throw obj;
    }

    public void onDowngrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        e.e(new Object[] {
            (new StringBuilder()).append("Downgrading database from version ").append(i).append(" to ").append(j).append(", which will destroy all old data").toString()
        });
        sqlitedatabase.execSQL((new StringBuilder()).append("DROP TABLE IF EXISTS ").append(Contract.Posts.TABLE_NAME).toString());
        e.e(new Object[] {
            "Downgrading done."
        });
        onCreate(sqlitedatabase);
    }

    public void onOpen(SQLiteDatabase sqlitedatabase)
    {
        e.c(new Object[] {
            "Open database"
        });
        super.onOpen(sqlitedatabase);
        if (t.e())
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
        e.b(new Object[] {
            (new StringBuilder()).append("Upgrading database from version ").append(i).append(" to ").append(j).append(", which will destroy all old data").toString()
        });
        sqlitedatabase.execSQL((new StringBuilder()).append("DROP TABLE IF EXISTS ").append(Contract.Posts.TABLE_NAME).toString());
        e.b(new Object[] {
            "Upgrading done."
        });
        onCreate(sqlitedatabase);
    }
}
