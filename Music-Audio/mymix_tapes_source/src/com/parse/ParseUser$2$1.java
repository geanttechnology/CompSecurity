// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseUser

class val.fetchAsyncTask
    implements Continuation
{

    final then this$1;
    final Task val$fetchAsyncTask;

    public Task then(Task task)
        throws Exception
    {
        return val$fetchAsyncTask;
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$fetchAsyncTask = Task.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseUser$2

/* anonymous class */
    class ParseUser._cls2
        implements Continuation
    {

        final ParseUser this$0;

        public Task then(Task task)
            throws Exception
        {
            Task task1 = task;
            if (isCurrentUser())
            {
                ParseUser.access$000(ParseUser.this);
                task1 = ParseUser.access$100(ParseUser.this).continueWithTask(task. new ParseUser._cls2._cls1());
            }
            return task1;
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$0 = ParseUser.this;
                super();
            }
    }

}
