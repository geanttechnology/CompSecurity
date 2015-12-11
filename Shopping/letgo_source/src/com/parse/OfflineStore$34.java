// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

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
    final cs val$uuid;

    public cu then(cu cu)
        throws Exception
    {
        cu = (String)val$uuid.a();
        return val$db.deleteAsync("ParseObjects", "uuid=?", new String[] {
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
        val$uuid = cs1;
        val$db = ParseSQLiteDatabase.this;
        super();
    }
}
