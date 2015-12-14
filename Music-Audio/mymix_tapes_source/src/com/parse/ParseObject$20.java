// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseObject, OfflineStore

class val.store
    implements Continuation
{

    final ParseObject this$0;
    final OfflineStore val$store;

    public Task then(Task task)
        throws Exception
    {
        return val$store.fetchLocallyAsync(ParseObject.this).makeVoid();
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ()
    {
        this$0 = final_parseobject;
        val$store = OfflineStore.this;
        super();
    }
}
