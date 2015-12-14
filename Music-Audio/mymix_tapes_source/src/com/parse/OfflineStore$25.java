// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.WeakHashMap;

// Referenced classes of package com.parse:
//            OfflineStore, ParseObject

class val.object
    implements Continuation
{

    final OfflineStore this$0;
    final ParseObject val$object;

    public Task then(Task task)
        throws Exception
    {
        return (Task)OfflineStore.access$500(OfflineStore.this).get(val$object);
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ()
    {
        this$0 = final_offlinestore;
        val$object = ParseObject.this;
        super();
    }
}
