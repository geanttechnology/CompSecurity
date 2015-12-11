// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.amazon.identity.auth.device.framework.AESCipher;
import com.amazon.identity.auth.device.framework.SQLTable;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.io.File;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            LocalDataStorageV2, LocalKeyValueStore

static class mkeyValueStore extends SQLiteOpenHelper
{

    private final LocalKeyValueStore mkeyValueStore;

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        MAPLog.i(LocalDataStorageV2.access$000(), "Creating LocalDataStorageV2 Database");
        MAPLog.i(LocalDataStorageV2.access$000(), "Creating Accounts table in LocalDataStorageV2 database");
        sqlitedatabase.execSQL((new SQLTable("accounts")).addColumn("_id", "INTEGER PRIMARY KEY AUTOINCREMENT").addColumn("directed_id", "TEXT UNIQUE NOT NULL").addColumn("display_name", "TEXT NOT NULL").toString());
        MAPLog.i(LocalDataStorageV2.access$000(), "Creating AccountData table in LocalDataStorageV2 database");
        sqlitedatabase.execSQL((new SQLTable("account_data")).addColumn("_id", "INTEGER PRIMARY KEY AUTOINCREMENT").addColumn("account_data_directed_id", "TEXT NOT NULL").addColumn("account_data_key", "TEXT NOT NULL").addColumn("account_data_value", "BLOB").addConstraint(String.format("UNIQUE(%s,%s)", new Object[] {
            "account_data_directed_id", "account_data_key"
        })).toString());
        MAPLog.i(LocalDataStorageV2.access$000(), "Creating DeviceData table in LocalDataStorageV2 database");
        sqlitedatabase.execSQL((new SQLTable("device_data")).addColumn("_id", "INTEGER PRIMARY KEY AUTOINCREMENT").addColumn("device_data_namespace", "TEXT NOT NULL").addColumn("device_data_key", "TEXT NOT NULL").addColumn("device_data_value", "BLOB").addConstraint(String.format("UNIQUE(%s,%s)", new Object[] {
            "device_data_namespace", "device_data_key"
        })).toString());
        mkeyValueStore.setValue("com.amazon.identity.auth.device.storage.LocalOnlySQLDB.encrypt.key", AESCipher.generateAesSecureStorageKey());
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
        MAPLog.e(LocalDataStorageV2.access$000(), String.format("Cannot upgrade from version %d to %d", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j)
        }));
        throw new IllegalStateException(String.format("Cannot upgrade from version %d to %d", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j)
        }));
    }

    public Y(Context context, String s, LocalKeyValueStore localkeyvaluestore)
    {
        super(context, (new StringBuilder()).append(s).append(".db").toString(), null, 1);
        MAPLog.i(LocalDataStorageV2.access$000(), "Constructing LocalDataStorageDBHelper");
        context = context.getDatabasePath((new StringBuilder()).append(s).append(".db").toString());
        MAPLog.i(LocalDataStorageV2.access$000(), (new StringBuilder("Database ")).append(s).append(".db exists: ").append(context.exists()).toString());
        mkeyValueStore = localkeyvaluestore;
    }
}
