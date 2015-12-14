// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.ArrayList;

// Referenced classes of package com.parse:
//            ParsePinningEventuallyQueue, EventuallyPin

class this._cls1
    implements Continuation
{

    final then this$1;

    public Task then(Task task)
        throws Exception
    {
        ParsePinningEventuallyQueue.access$600(_fld0).remove(uuid);
        return task;
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    l.uuid()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/ParsePinningEventuallyQueue$9

/* anonymous class */
    class ParsePinningEventuallyQueue._cls9
        implements Continuation
    {

        final ParsePinningEventuallyQueue this$0;
        final EventuallyPin val$eventuallyPin;
        final String val$uuid;

        public Task then(Task task)
            throws Exception
        {
            return ParsePinningEventuallyQueue.access$700(ParsePinningEventuallyQueue.this, eventuallyPin, task).continueWithTask(new ParsePinningEventuallyQueue._cls9._cls1());
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$0 = final_parsepinningeventuallyqueue;
                eventuallyPin = eventuallypin;
                uuid = String.this;
                super();
            }
    }

}
