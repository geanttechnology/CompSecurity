// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseUser

class >
    implements Continuation
{

    final ParseUser this$0;

    public Task then(final Task fetchAsyncTask)
        throws Exception
    {
        Task task = fetchAsyncTask;
        if (isCurrentUser())
        {
            ParseUser.access$000(ParseUser.this);
            task = ParseUser.access$100(ParseUser.this).continueWithTask(new Continuation() {

                final ParseUser._cls2 this$1;
                final Task val$fetchAsyncTask;

                public Task then(Task task1)
                    throws Exception
                {
                    return fetchAsyncTask;
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$1 = ParseUser._cls2.this;
                fetchAsyncTask = task;
                super();
            }
            });
        }
        return task;
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    >()
    {
        this$0 = ParseUser.this;
        super();
    }
}
