// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            OfflineStore, ParseSQLiteDatabase, ParseObject

class val.object
    implements Continuation
{

    final OfflineStore this$0;
    final ParseObject val$object;

    public Task then(final Task db)
        throws Exception
    {
        db = (ParseSQLiteDatabase)db.getResult();
        return fetchLocallyAsync(val$object, db).continueWithTask(new Continuation() {

            final OfflineStore._cls14 this$1;
            final ParseSQLiteDatabase val$db;

            public Task then(Task task)
                throws Exception
            {
                db.close();
                return task;
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$1 = OfflineStore._cls14.this;
                db = parsesqlitedatabase;
                super();
            }
        });
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    _cls1.val.db()
    {
        this$0 = final_offlinestore;
        val$object = ParseObject.this;
        super();
    }
}
