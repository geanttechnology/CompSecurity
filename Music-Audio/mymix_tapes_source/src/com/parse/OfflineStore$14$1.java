// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseSQLiteDatabase, OfflineStore, ParseObject

class e
    implements Continuation
{

    final then this$1;
    final ParseSQLiteDatabase val$db;

    public Task then(Task task)
        throws Exception
    {
        val$db.close();
        return task;
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    e()
    {
        this$1 = final_e;
        val$db = ParseSQLiteDatabase.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineStore$14

/* anonymous class */
    class OfflineStore._cls14
        implements Continuation
    {

        final OfflineStore this$0;
        final ParseObject val$object;

        public Task then(Task task)
            throws Exception
        {
            task = (ParseSQLiteDatabase)task.getResult();
            return fetchLocallyAsync(object, task).continueWithTask(task. new OfflineStore._cls14._cls1());
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$0 = final_offlinestore;
                object = ParseObject.this;
                super();
            }
    }

}
