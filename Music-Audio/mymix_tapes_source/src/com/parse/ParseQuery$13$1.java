// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.concurrent.Callable;

// Referenced classes of package com.parse:
//            ParseQuery, Parse, ParseCallback

class this._cls1
    implements Continuation
{

    final then this$1;

    public Task then(Task task)
        throws Exception
    {
        if (task.isCancelled())
        {
            return task;
        } else
        {
            return (Task)callable.call(Policy.NETWORK_ONLY);
        }
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    l.callback()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseQuery$13

/* anonymous class */
    class ParseQuery._cls13
        implements Callable
    {

        final ParseQuery this$0;
        final ParseQuery.CallableWithCachePolicy val$callable;
        final ParseCallback val$callback;

        public Task call()
            throws Exception
        {
            if (ParseQuery.access$500(ParseQuery.this) == ParseQuery.CachePolicy.CACHE_THEN_NETWORK)
            {
                return Parse.callbackOnMainThreadAsync((Task)callable.call(ParseQuery.CachePolicy.CACHE_ONLY), callback).continueWithTask(new ParseQuery._cls13._cls1());
            } else
            {
                return (Task)callable.call(ParseQuery.access$500(ParseQuery.this));
            }
        }

        public volatile Object call()
            throws Exception
        {
            return call();
        }

            
            {
                this$0 = final_parsequery;
                callable = callablewithcachepolicy;
                callback = ParseCallback.this;
                super();
            }
    }

}
