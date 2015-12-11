// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.HashMap;

// Referenced classes of package com.parse:
//            ParsePinningEventuallyQueue, EventuallyPin, Parse, PLog

class val.eventuallyPin
    implements ct
{

    final ParsePinningEventuallyQueue this$0;
    final EventuallyPin val$eventuallyPin;

    public cu then(cu cu1)
        throws Exception
    {
        return waitForOperationSetAndEventuallyPin(null, val$eventuallyPin).b(new ct() {

            final ParsePinningEventuallyQueue._cls10 this$1;

            public cu then(cu cu2)
                throws Exception
            {
                Exception exception = cu2.f();
                android.support.v7.cu.a a;
                if (exception != null)
                {
                    if (exception instanceof ParsePinningEventuallyQueue.PauseException)
                    {
                        return cu2.j();
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
                a = (android.support.v7.cu.a)ParsePinningEventuallyQueue.access$200(this$0).remove(eventuallyPin.getUUID());
                if (a != null)
                {
                    if (exception != null)
                    {
                        a.b(exception);
                    } else
                    {
                        a.b(cu2.e());
                    }
                }
                return cu2.j();
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$1 = ParsePinningEventuallyQueue._cls10.this;
                super();
            }
        });
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    _cls1.this._cls1()
    {
        this$0 = final_parsepinningeventuallyqueue;
        val$eventuallyPin = EventuallyPin.this;
        super();
    }
}
