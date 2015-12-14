// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.concurrent.Callable;

// Referenced classes of package com.parse:
//            ParseQuery, Parse, ParseCallback

class val.callback
    implements Callable
{

    final ParseQuery this$0;
    final lableWithCachePolicy val$callable;
    final ParseCallback val$callback;

    public Task call()
        throws Exception
    {
        if (ParseQuery.access$500(ParseQuery.this) == hePolicy.CACHE_THEN_NETWORK)
        {
            return Parse.callbackOnMainThreadAsync((Task)val$callable.call(hePolicy.CACHE_ONLY), val$callback).continueWithTask(new Continuation() {

                final ParseQuery._cls13 this$1;

                public Task then(Task task)
                    throws Exception
                {
                    if (task.isCancelled())
                    {
                        return task;
                    } else
                    {
                        return (Task)callable.call(ParseQuery.CachePolicy.NETWORK_ONLY);
                    }
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$1 = ParseQuery._cls13.this;
                super();
            }
            });
        } else
        {
            return (Task)val$callable.call(ParseQuery.access$500(ParseQuery.this));
        }
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    lableWithCachePolicy()
    {
        this$0 = final_parsequery;
        val$callable = lablewithcachepolicy;
        val$callback = ParseCallback.this;
        super();
    }
}
