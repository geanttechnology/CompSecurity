// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.receipt;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// Referenced classes of package com.aviary.android.feather.receipt:
//            ReceiptProvider

private static final class  extends SQLiteOpenHelper
{

    private static final String DATABASE_NAME = "receipts";
    private static final int DATABASE_VERSION = 1;

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        ReceiptProvider.logger.("onCreate");
        ReceiptProvider.logger.("CREATE TABLE IF NOT EXISTS receipts_table( r_id INTEGER PRIMARY KEY AUTOINCREMENT, r_json BLOB NOT NULL, r_is_free INTEGER NOT NULL DEFAULT 1 )");
        ReceiptProvider.logger.("CREATE TABLE IF NOT EXISTS uploads_table( u_id INTEGER PRIMARY KEY AUTOINCREMENT, u_receipt_id INTEGER NOT NULL UNIQUE, u_response_status INTEGER NOT NULL, u_fail_count INTEGER NOT NULL DEFAULT 1, FOREIGN KEY(u_receipt_id) REFERENCES receipts_table(r_id) ON DELETE CASCADE);");
        sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS receipts_table( r_id INTEGER PRIMARY KEY AUTOINCREMENT, r_json BLOB NOT NULL, r_is_free INTEGER NOT NULL DEFAULT 1 )");
        sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS uploads_table( u_id INTEGER PRIMARY KEY AUTOINCREMENT, u_receipt_id INTEGER NOT NULL UNIQUE, u_response_status INTEGER NOT NULL, u_fail_count INTEGER NOT NULL DEFAULT 1, FOREIGN KEY(u_receipt_id) REFERENCES receipts_table(r_id) ON DELETE CASCADE);");
    }

    public void onOpen(SQLiteDatabase sqlitedatabase)
    {
        super.onOpen(sqlitedatabase);
        ReceiptProvider.logger.("onOpen");
        if (!sqlitedatabase.isReadOnly())
        {
            ReceiptProvider.logger.("onConfigure");
            sqlitedatabase.execSQL("PRAGMA foreign_keys = ON;");
            sqlitedatabase.execSQL("PRAGMA encoding=\"UTF-8\";");
        }
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        ReceiptProvider.logger.("onUpgrade");
    }

    public (Context context)
    {
        super(context, "receipts", null, 1);
    }
}
