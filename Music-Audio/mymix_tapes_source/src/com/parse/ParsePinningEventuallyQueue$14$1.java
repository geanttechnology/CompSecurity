// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.parse:
//            EventuallyPin, ParsePinningEventuallyQueue

class this._cls1
    implements Continuation
{

    final then this$1;

    public Task then(Task task)
        throws Exception
    {
        return EventuallyPin.findAllPinned().onSuccessTask(new Continuation() {

            final ParsePinningEventuallyQueue._cls14._cls1 this$2;

            public Task then(Task task1)
                throws Exception
            {
                Object obj = (List)task1.getResult();
                task1 = new ArrayList();
                for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); task1.add(((EventuallyPin)((Iterator) (obj)).next()).unpinInBackground("_eventuallyPin"))) { }
                return Task.whenAll(task1);
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$2 = ParsePinningEventuallyQueue._cls14._cls1.this;
                super();
            }
        });
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/ParsePinningEventuallyQueue$14

/* anonymous class */
    class ParsePinningEventuallyQueue._cls14
        implements Continuation
    {

        final ParsePinningEventuallyQueue this$0;

        public Task then(Task task)
            throws Exception
        {
            return task.continueWithTask(new ParsePinningEventuallyQueue._cls14._cls1());
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                super();
            }
    }

}
