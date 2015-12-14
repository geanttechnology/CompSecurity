// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            OfflineStore, ParseSQLiteDatabase, ParsePin, ParseQuery, 
//            ParseUser

class val.ignoreACLs
    implements Continuation
{

    final OfflineStore this$0;
    final boolean val$ignoreACLs;
    final boolean val$includeIsDeletingEventually;
    final boolean val$isCount;
    final ParsePin val$pin;
    final ParseQuery val$query;
    final ParseUser val$user;

    public Task then(final Task db)
        throws Exception
    {
        db = (ParseSQLiteDatabase)db.getResult();
        return findAsync(val$query, val$user, val$pin, val$isCount, val$includeIsDeletingEventually, val$ignoreACLs, db).continueWithTask(new Continuation() {

            final OfflineStore._cls5 this$1;
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
                this$1 = OfflineStore._cls5.this;
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
        val$query = parsequery;
        val$user = parseuser;
        val$pin = parsepin;
        val$isCount = flag;
        val$includeIsDeletingEventually = flag1;
        val$ignoreACLs = Z.this;
        super();
    }
}
