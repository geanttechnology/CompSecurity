// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseQuery, ParseCommand, Parse

class val.caching
    implements Continuation
{

    final ParseQuery this$0;
    final boolean val$caching;

    public Task then(Task task)
        throws Exception
    {
        if (val$caching)
        {
            Object obj = task.getResult();
            Parse.saveToKeyValueCache(ParseQuery.access$400(ParseQuery.this).getCacheKey(), obj.toString());
        }
        return task;
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ()
    {
        this$0 = final_parsequery;
        val$caching = Z.this;
        super();
    }
}
