// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.HashMap;

// Referenced classes of package com.parse:
//            EventuallyPin, Parse, ParsePinningEventuallyQueue, ParseCommand, 
//            ParseObject

class this._cls1
    implements Continuation
{

    final then this$1;

    public Task then(Task task)
        throws Exception
    {
        EventuallyPin eventuallypin = (EventuallyPin)task.getResult();
        Exception exception = task.getError();
        if (exception != null)
        {
            if (5 >= Parse.getLogLevel())
            {
                Parse.logW("ParsePinningEventuallyQueue", "Unable to save command for later.", exception);
            }
            notifyTestHelper(4);
            return Task.forResult(null);
        } else
        {
            ParsePinningEventuallyQueue.access$200(_fld0).put(eventuallypin.getUUID(), tcs);
            ParsePinningEventuallyQueue.access$300(_fld0).continueWithTask(new Continuation() {

                final ParsePinningEventuallyQueue._cls5._cls1 this$2;

                public Task then(Task task1)
                    throws Exception
                {
                    notifyTestHelper(3);
                    return task1;
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$2 = ParsePinningEventuallyQueue._cls5._cls1.this;
                super();
            }
            });
            return task.makeVoid();
        }
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    l.tcs()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/ParsePinningEventuallyQueue$5

/* anonymous class */
    class ParsePinningEventuallyQueue._cls5
        implements Continuation
    {

        final ParsePinningEventuallyQueue this$0;
        final ParseCommand val$command;
        final ParseObject val$object;
        final bolts.Task.TaskCompletionSource val$tcs;

        public Task then(Task task)
            throws Exception
        {
            return EventuallyPin.pinEventuallyCommand(object, command).continueWithTask(new ParsePinningEventuallyQueue._cls5._cls1());
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$0 = final_parsepinningeventuallyqueue;
                object = parseobject;
                command = parsecommand;
                tcs = bolts.Task.TaskCompletionSource.this;
                super();
            }
    }

}
