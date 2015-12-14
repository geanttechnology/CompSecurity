// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.HashMap;

// Referenced classes of package com.parse:
//            ParsePinningEventuallyQueue, EventuallyPin, Parse

class val.eventuallyPin
    implements Continuation
{

    final ParsePinningEventuallyQueue this$0;
    final EventuallyPin val$eventuallyPin;

    public Task then(Task task)
        throws Exception
    {
        return waitForOperationSetAndEventuallyPin(null, val$eventuallyPin).continueWithTask(new Continuation() {

            final ParsePinningEventuallyQueue._cls10 this$1;

            public Task then(Task task1)
                throws Exception
            {
                Exception exception = task1.getError();
                bolts.Task.TaskCompletionSource taskcompletionsource;
                if (exception != null)
                {
                    if (exception instanceof ParsePinningEventuallyQueue.PauseException)
                    {
                        return task1.makeVoid();
                    }
                    if (6 >= Parse.getLogLevel())
                    {
                        Parse.logE("ParsePinningEventuallyQueue", "Failed to run command.", exception);
                    }
                    notifyTestHelper(2);
                } else
                {
                    notifyTestHelper(1);
                }
                taskcompletionsource = (bolts.Task.TaskCompletionSource)ParsePinningEventuallyQueue.access$200(this$0).remove(eventuallyPin.getUUID());
                if (taskcompletionsource != null)
                {
                    if (exception != null)
                    {
                        taskcompletionsource.setError(exception);
                    } else
                    {
                        taskcompletionsource.setResult(task1.getResult());
                    }
                }
                return task1.makeVoid();
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$1 = ParsePinningEventuallyQueue._cls10.this;
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
        val$eventuallyPin = EventuallyPin.this;
        super();
    }
}
