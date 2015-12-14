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

    static final String FAIL_COUNT = "u_fail_count";
    static final String RECEIPT_ID = "u_receipt_id";
    static final String RESPONSE_STATUS = "u_response_status";
    static final String TABLE_NAME = "uploads_table";
    static final String TABLE_SQL = "CREATE TABLE IF NOT EXISTS uploads_table( u_id INTEGER PRIMARY KEY AUTOINCREMENT, u_receipt_id INTEGER NOT NULL UNIQUE, u_response_status INTEGER NOT NULL, u_fail_count INTEGER NOT NULL DEFAULT 1, FOREIGN KEY(u_receipt_id) REFERENCES receipts_table(r_id) ON DELETE CASCADE);";
    static final String UPLOAD_ID = "u_id";

    ()
    {
    }
}
