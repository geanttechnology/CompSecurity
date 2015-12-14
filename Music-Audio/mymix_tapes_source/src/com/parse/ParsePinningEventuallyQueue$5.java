// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.HashMap;

// Referenced classes of package com.parse:
//            ParsePinningEventuallyQueue, EventuallyPin, ParseCommand, ParseObject, 
//            Parse

class val.tcs
    implements Continuation
{

    final ParsePinningEventuallyQueue this$0;
    final ParseCommand val$command;
    final ParseObject val$object;
    final bolts.e val$tcs;

    public Task then(Task task)
        throws Exception
    {
        return EventuallyPin.pinEventuallyCommand(val$object, val$command).continueWithTask(new Continuation() {

            final ParsePinningEventuallyQueue._cls5 this$1;

            public Task then(Task task1)
                throws Exception
            {
                EventuallyPin eventuallypin = (EventuallyPin)task1.getResult();
                Exception exception = task1.getError();
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
                    ParsePinningEventuallyQueue.access$200(this$0).put(eventuallypin.getUUID(), tcs);
                    ParsePinningEventuallyQueue.access$300(this$0).continueWithTask(new Continuation() {

                        final _cls1 this$2;

                        public Task then(Task task)
                            throws Exception
                        {
                            notifyTestHelper(3);
                            return task;
                        }

                        public volatile Object then(Task task)
                            throws Exception
                        {
                            return then(task);
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    });
                    return task1.makeVoid();
                }
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$1 = ParsePinningEventuallyQueue._cls5.this;
                super();
            }
        });
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    _cls1.this._cls1()
    {
        this$0 = final_parsepinningeventuallyqueue;
        val$object = parseobject;
        val$command = parsecommand;
        val$tcs = bolts.e._cls5.val.tcs.this;
        super();
    }
}
