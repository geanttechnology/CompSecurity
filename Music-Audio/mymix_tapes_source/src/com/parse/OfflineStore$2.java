// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            OfflineStore

class val.newUUID
    implements Continuation
{

    final OfflineStore this$0;
    final String val$newUUID;
    final bolts.tionSource val$tcs;

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public Void then(Task task)
        throws Exception
    {
        val$tcs.setResult(val$newUUID);
        return null;
    }

    Source()
    {
        this$0 = final_offlinestore;
        val$tcs = tionsource;
        val$newUUID = String.this;
        super();
    }
}
