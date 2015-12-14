// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseQuery, ParsePin, OfflineStore, ParseUser

class val.ignoreACLs
    implements Continuation
{

    final ParseQuery this$0;
    final boolean val$ignoreACLs;
    final boolean val$includeIsDeletingEventually;
    final OfflineStore val$store;
    final ParseUser val$user;

    public Task then(Task task)
        throws Exception
    {
        task = (ParsePin)task.getResult();
        return val$store.countAsync(ParseQuery.this, val$user, task, val$includeIsDeletingEventually, val$ignoreACLs);
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ()
    {
        this$0 = final_parsequery;
        val$store = offlinestore;
        val$user = parseuser;
        val$includeIsDeletingEventually = flag;
        val$ignoreACLs = Z.this;
        super();
    }
}
