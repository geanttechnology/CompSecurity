// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseSQLiteDatabase, OfflineStore, ParsePin, ParseQuery, 
//            ParseUser

class se
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

    se()
    {
        this$1 = final_se;
        val$db = ParseSQLiteDatabase.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineStore$5

/* anonymous class */
    class OfflineStore._cls5
        implements Continuation
    {

        final OfflineStore this$0;
        final boolean val$ignoreACLs;
        final boolean val$includeIsDeletingEventually;
        final boolean val$isCount;
        final ParsePin val$pin;
        final ParseQuery val$query;
        final ParseUser val$user;

        public Task then(Task task)
            throws Exception
        {
            task = (ParseSQLiteDatabase)task.getResult();
            return findAsync(query, user, pin, isCount, includeIsDeletingEventually, ignoreACLs, task).continueWithTask(task. new OfflineStore._cls5._cls1());
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$0 = final_offlinestore;
                query = parsequery;
                user = parseuser;
                pin = parsepin;
                isCount = flag;
                includeIsDeletingEventually = flag1;
                ignoreACLs = Z.this;
                super();
            }
    }

}
