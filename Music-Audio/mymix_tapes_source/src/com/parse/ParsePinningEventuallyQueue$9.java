// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.ArrayList;

// Referenced classes of package com.parse:
//            ParsePinningEventuallyQueue, EventuallyPin

class val.uuid
    implements Continuation
{

    final ParsePinningEventuallyQueue this$0;
    final EventuallyPin val$eventuallyPin;
    final String val$uuid;

    public Task then(Task task)
        throws Exception
    {
        return ParsePinningEventuallyQueue.access$700(ParsePinningEventuallyQueue.this, val$eventuallyPin, task).continueWithTask(new Continuation() {

            final ParsePinningEventuallyQueue._cls9 this$1;

            public Task then(Task task1)
                throws Exception
            {
                ParsePinningEventuallyQueue.access$600(this$0).remove(uuid);
                return task1;
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$1 = ParsePinningEventuallyQueue._cls9.this;
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
        val$eventuallyPin = eventuallypin;
        val$uuid = String.this;
        super();
    }
}
