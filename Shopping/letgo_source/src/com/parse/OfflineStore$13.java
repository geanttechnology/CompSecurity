// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.ContentValues;
import android.support.v7.cs;
import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            OfflineStore, ParseSQLiteDatabase

class ase
    implements ct
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final String val$key;
    final cs val$uuidCapture;

    public cu then(cu cu)
        throws Exception
    {
        cu = new ContentValues();
        cu.put("key", val$key);
        cu.put("uuid", (String)val$uuidCapture.a());
        return val$db.insertWithOnConflict("Dependencies", cu, 4);
    }

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    ase()
    {
        this$0 = final_offlinestore;
        val$key = s;
        val$uuidCapture = cs1;
        val$db = ParseSQLiteDatabase.this;
        super();
    }
}
