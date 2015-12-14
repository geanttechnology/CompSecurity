// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.receipt;

import android.provider.BaseColumns;

// Referenced classes of package com.aviary.android.feather.receipt:
//            ReceiptProvider

static class 
    implements BaseColumns
{

    static final String ITEM_IS_FREE = "r_is_free";
    static final String ITEM_JSON = "r_json";
    static final String RECEIPT_ID = "r_id";
    static final String TABLE_NAME = "receipts_table";
    static final String TABLE_SQL = "CREATE TABLE IF NOT EXISTS receipts_table( r_id INTEGER PRIMARY KEY AUTOINCREMENT, r_json BLOB NOT NULL, r_is_free INTEGER NOT NULL DEFAULT 1 )";

    ()
    {
    }
}
