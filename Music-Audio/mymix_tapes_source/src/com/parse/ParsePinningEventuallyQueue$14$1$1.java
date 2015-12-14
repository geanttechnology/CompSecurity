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

class this._cls2
    implements Continuation
{

    final then this$2;

    public Task then(Task task)
        throws Exception
    {
        Object obj = (List)task.getResult();
        task = new ArrayList();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); task.add(((EventuallyPin)((Iterator) (obj)).next()).unpinInBackground("_eventuallyPin"))) { }
        return Task.whenAll(task);
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ._cls0()
    {
        this$2 = this._cls2.this;
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


    // Unreferenced inner class com/parse/ParsePinningEventuallyQueue$14$1

/* anonymous class */
    class ParsePinningEventuallyQueue._cls14._cls1
        implements Continuation
    {

        final ParsePinningEventuallyQueue._cls14 this$1;

        public Task then(Task task)
            throws Exception
        {
            return EventuallyPin.findAllPinned().onSuccessTask(new ParsePinningEventuallyQueue._cls14._cls1._cls1());
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$1 = ParsePinningEventuallyQueue._cls14.this;
                super();
            }
    }

}
