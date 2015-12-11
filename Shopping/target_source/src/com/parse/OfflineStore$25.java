// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineStore, ParseSQLiteDatabase

class ase
    implements i
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final List val$uuids;

    public j then(j j)
        throws Exception
    {
        return OfflineStore.access$1100(OfflineStore.this, val$uuids.subList(999, val$uuids.size()), val$db);
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    ase()
    {
        this$0 = final_offlinestore;
        val$uuids = list;
        val$db = ParseSQLiteDatabase.this;
        super();
    }
}
