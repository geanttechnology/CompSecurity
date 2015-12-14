// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            OfflineStore, ParseQuery, ParseSQLiteDatabase

class base
    implements Continuation
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final boolean val$includeIsDeletingEventually;
    final ParseQuery val$query;

    public Task then(Task task)
        throws Exception
    {
        String s = (String)task.getResult();
        task = "className=? AND key=?";
        if (!val$includeIsDeletingEventually)
        {
            task = (new StringBuilder()).append("className=? AND key=?").append(" AND isDeletingEventually=0").toString();
        }
        String s1 = val$query.getClassName();
        return val$db.queryAsync("ParseObjects A  INNER JOIN Dependencies B  ON A.uuid=B.uuid", new String[] {
            "A.uuid"
        }, task, new String[] {
            s1, s
        });
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    base()
    {
        this$0 = final_offlinestore;
        val$includeIsDeletingEventually = flag;
        val$query = parsequery;
        val$db = ParseSQLiteDatabase.this;
        super();
    }
}
