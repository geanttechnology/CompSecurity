// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.amazon.identity.auth.device.framework.SQLTable;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            LocalDataStorage

static class  extends SQLiteOpenHelper
{

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        MAPLog.i(LocalDataStorage.access$000(), "Creating Local DataStore");
        sqlitedatabase.execSQL((new SQLTable("accounts")).addColumn("_id", "INTEGER PRIMARY KEY AUTOINCREMENT").addColumn("directed_id", "TEXT UNIQUE NOT NULL").addColumn("display_name", "TEXT UNIQUE").addColumn("account_timestamp", "INTEGER NOT NULL").addColumn("account_deleted", "INTEGER NOT NULL").addColumn("account_dirty", "INTEGER NOT NULL").toString());
        sqlitedatabase.execSQL((new SQLTable("userdata")).addColumn("_id", "INTEGER PRIMARY KEY AUTOINCREMENT").addColumn("userdata_account_id", "TEXT NOT NULL").addColumn("userdata_key", "TEXT NOT NULL").addColumn("userdata_value", "TEXT").addColumn("userdata_timestamp", "INTEGER NOT NULL").addColumn("userdata_deleted", "INTEGER NOT NULL").addColumn("userdata_dirty", "INTEGER NOT NULL").addConstraint(String.format("UNIQUE(%s,%s)", new Object[] {
            "userdata_account_id", "userdata_key"
        })).toString());
        sqlitedatabase.execSQL((new SQLTable("tokens")).addColumn("_id", "INTEGER PRIMARY KEY AUTOINCREMENT").addColumn("token_account_id", "TEXT NOT NULL").addColumn("token_key", "TEXT NOT NULL").addColumn("token_value", "TEXT").addColumn("token_timestamp", "INTEGER NOT NULL").addColumn("token_deleted", "INTEGER NOT NULL").addColumn("token_dirty", "INTEGER NOT NULL").addConstraint(String.format("UNIQUE(%s,%s)", new Object[] {
            "token_account_id", "token_key"
        })).toString());
        sqlitedatabase.execSQL((new SQLTable("device_data")).addColumn("_id", "INTEGER PRIMARY KEY AUTOINCREMENT").addColumn("device_data_namespace", "TEXT NOT NULL").addColumn("device_data_key", "TEXT NOT NULL").addColumn("device_data_value", "TEXT").addColumn("device_data_timestamp", "INTEGER NOT NULL").addColumn("device_data_deleted", "INTEGER NOT NULL").addColumn("device_data_dirty", "INTEGER NOT NULL").addConstraint(String.format("UNIQUE(%s,%s)", new Object[] {
            "device_data_namespace", "device_data_key"
        })).toString());
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
        throw new IllegalStateException(String.format("Cannot upgrade from version %d to %d", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j)
        }));
    }

    public (Context context, String s, int i)
    {
        super(context, (new StringBuilder()).append(s).append(".db").toString(), null, i);
    }
}
