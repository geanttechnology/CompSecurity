// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.HashMap;

// Referenced classes of package com.parse:
//            Parse, PLog, ParsePinningEventuallyQueue, EventuallyPin

class this._cls1
    implements ct
{

    final then this$1;

    public cu then(cu cu1)
        throws Exception
    {
        Exception exception = cu1.f();
        android.support.v7.llyPin llypin;
        if (exception != null)
        {
            if (exception instanceof Exception)
            {
                return cu1.j();
            }
            if (6 >= Parse.getLogLevel())
            {
                PLog.e("ParsePinningEventuallyQueue", "Failed to run command.", exception);
            }
            notifyTestHelper(2, exception);
        } else
        {
            notifyTestHelper(1);
        }
        llypin = (android.support.v7.er)ParsePinningEventuallyQueue.access$200(_fld0).remove(eventuallyPin.getUUID());
        if (llypin != null)
        {
            if (exception != null)
            {
                llypin.llyPin(exception);
            } else
            {
                llypin.llyPin(cu1.e());
            }
        }
        return cu1.j();
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    l.eventuallyPin()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/ParsePinningEventuallyQueue$10

/* anonymous class */
    class ParsePinningEventuallyQueue._cls10
        implements ct
    {

        final ParsePinningEventuallyQueue this$0;
        final EventuallyPin val$eventuallyPin;

        public cu then(cu cu1)
            throws Exception
        {
            return waitForOperationSetAndEventuallyPin(null, eventuallyPin).b(new ParsePinningEventuallyQueue._cls10._cls1());
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$0 = final_parsepinningeventuallyqueue;
                eventuallyPin = EventuallyPin.this;
                super();
            }
    }

}
