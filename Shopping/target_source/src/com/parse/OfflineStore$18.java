// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            OfflineStore, ParseSQLiteDatabase

class ase
    implements i
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;

    public j then(j j1)
        throws Exception
    {
        j1 = (String)j1.e();
        if (j1 == null)
        {
            return null;
        } else
        {
            return OfflineStore.access$1000(OfflineStore.this, j1, val$db);
        }
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ase()
    {
        this$0 = final_offlinestore;
        val$db = ParseSQLiteDatabase.this;
        super();
    }
}
