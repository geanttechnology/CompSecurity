// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.HashMap;

// Referenced classes of package com.parse:
//            ParsePinningEventuallyQueue, EventuallyPin, Parse, PLog

class val.eventuallyPin
    implements i
{

    final ParsePinningEventuallyQueue this$0;
    final EventuallyPin val$eventuallyPin;

    public j then(j j1)
        throws Exception
    {
        return waitForOperationSetAndEventuallyPin(null, val$eventuallyPin).b(new i() {

            final ParsePinningEventuallyQueue._cls10 this$1;

            public j then(j j2)
                throws Exception
            {
                Exception exception = j2.f();
                a.j.a a;
                if (exception != null)
                {
                    if (exception instanceof ParsePinningEventuallyQueue.PauseException)
                    {
                        return j2.j();
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
                a = (a.j.a)ParsePinningEventuallyQueue.access$200(this$0).remove(eventuallyPin.getUUID());
                if (a != null)
                {
                    if (exception != null)
                    {
                        a.b(exception);
                    } else
                    {
                        a.b(j2.e());
                    }
                }
                return j2.j();
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$1 = ParsePinningEventuallyQueue._cls10.this;
                super();
            }
        });
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    _cls1.this._cls1()
    {
        this$0 = final_parsepinningeventuallyqueue;
        val$eventuallyPin = EventuallyPin.this;
        super();
    }
}
