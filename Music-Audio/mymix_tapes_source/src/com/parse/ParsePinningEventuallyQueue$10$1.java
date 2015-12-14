// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.HashMap;

// Referenced classes of package com.parse:
//            Parse, ParsePinningEventuallyQueue, EventuallyPin

class this._cls1
    implements Continuation
{

    final then this$1;

    public Task then(Task task)
        throws Exception
    {
        Exception exception = task.getError();
        bolts._cls0._cls1 _lcls1;
        if (exception != null)
        {
            if (exception instanceof Exception)
            {
                return task.makeVoid();
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
        _lcls1 = (bolts.otifyTestHelper)ParsePinningEventuallyQueue.access$200(_fld0).remove(eventuallyPin.getUUID());
        if (_lcls1 != null)
        {
            if (exception != null)
            {
                _lcls1.r(exception);
            } else
            {
                _lcls1.lt(task.getResult());
            }
        }
        return task.makeVoid();
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    l.eventuallyPin()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/ParsePinningEventuallyQueue$10

/* anonymous class */
    class ParsePinningEventuallyQueue._cls10
        implements Continuation
    {

        final ParsePinningEventuallyQueue this$0;
        final EventuallyPin val$eventuallyPin;

        public Task then(Task task)
            throws Exception
        {
            return waitForOperationSetAndEventuallyPin(null, eventuallyPin).continueWithTask(new ParsePinningEventuallyQueue._cls10._cls1());
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$0 = final_parsepinningeventuallyqueue;
                eventuallyPin = EventuallyPin.this;
                super();
            }
    }

}
