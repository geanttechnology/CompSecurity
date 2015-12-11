// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            OfflineStore, ParsePin, ParseSQLiteDatabase

class ase
    implements i
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;

    public j then(j j1)
        throws Exception
    {
        if (j1.d())
        {
            return j1.j();
        } else
        {
            j1 = (ParsePin)j1.e();
            return OfflineStore.access$2000(OfflineStore.this, j1, val$db);
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
