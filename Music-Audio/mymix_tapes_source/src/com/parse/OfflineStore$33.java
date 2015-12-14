// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineStore, ParseSQLiteDatabase

class ase
    implements Continuation
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final List val$uuids;

    public Task then(Task task)
        throws Exception
    {
        return OfflineStore.access$1100(OfflineStore.this, val$uuids.subList(999, val$uuids.size()), val$db);
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ase()
    {
        this$0 = final_offlinestore;
        val$uuids = list;
        val$db = ParseSQLiteDatabase.this;
        super();
    }
}
