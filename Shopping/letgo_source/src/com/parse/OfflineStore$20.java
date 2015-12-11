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

    public cu then(cu cu1)
        throws Exception
    {
        cu1 = (String)cu1.e();
        if (cu1 == null)
        {
            return cu.a(null);
        } else
        {
            return OfflineStore.access$1000(OfflineStore.this, cu1, val$db);
        }
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ase()
    {
        this$0 = final_offlinestore;
        val$db = ParseSQLiteDatabase.this;
        super();
    }
}
