// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

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

    public cu then(cu cu)
        throws Exception
    {
        cu = val$key;
        return val$db.rawQueryAsync("SELECT uuid FROM Dependencies WHERE key=? AND uuid IN ( SELECT uuid FROM Dependencies GROUP BY uuid HAVING COUNT(uuid)=1)", new String[] {
            cu
        });
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
        val$db = ParseSQLiteDatabase.this;
        super();
    }
}
