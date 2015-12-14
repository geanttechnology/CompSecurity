// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Capture;
import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            OfflineStore, ParseObject, ParseSQLiteDatabase

class val.object
    implements Continuation
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final Capture val$jsonObject;
    final ParseObject val$object;
    final Capture val$uuid;

    public Task then(Task task)
        throws Exception
    {
        val$uuid.set(task.getResult());
        task = new lineEncodingStrategy(OfflineStore.this, val$db);
        val$jsonObject.set(val$object.toRest(task));
        return task.whenFinished();
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ase()
    {
        this$0 = final_offlinestore;
        val$uuid = capture;
        val$db = parsesqlitedatabase;
        val$jsonObject = capture1;
        val$object = ParseObject.this;
        super();
    }
}
