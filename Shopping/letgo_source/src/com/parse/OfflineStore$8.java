// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cs;
import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            OfflineStore, ParseSQLiteDatabase

class val.select
    implements ct
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final String val$select[];
    final cs val$uuid;

    public cu then(cu cu1)
        throws Exception
    {
        val$uuid.a(cu1.e());
        cu1 = (String)val$uuid.a();
        return val$db.queryAsync("ParseObjects", val$select, "uuid = ?", new String[] {
            cu1
        });
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    base()
    {
        this$0 = final_offlinestore;
        val$uuid = cs1;
        val$db = parsesqlitedatabase;
        val$select = _5B_Ljava.lang.String_3B_.this;
        super();
    }
}
