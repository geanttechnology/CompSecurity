// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.mftd;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

// Referenced classes of package com.ebay.mobile.mftd:
//            MftdService

class Factory extends SQLiteOpenHelper
{

    final onCreate this$1;
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

    Factory(String s, android.database.sqlite.tory tory, int i, MftdService mftdservice)
    {
        this$1 = final_factory;
        val$this$0 = mftdservice;
        super(Context.this, s, tory, i);
    }
}
