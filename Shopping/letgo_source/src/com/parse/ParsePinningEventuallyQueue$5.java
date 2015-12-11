// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.HashMap;

// Referenced classes of package com.parse:
//            ParsePinningEventuallyQueue, EventuallyPin, ParseRESTCommand, ParseObject, 
//            Parse, PLog

class val.tcs
    implements ct
{

    final ParsePinningEventuallyQueue this$0;
    final ParseRESTCommand val$command;
    final ParseObject val$object;
    final android.support.v7.elper val$tcs;

    public cu then(cu cu1)
        throws Exception
    {
        return EventuallyPin.pinEventuallyCommand(val$object, val$command).b(new ct() {

            final ParsePinningEventuallyQueue._cls5 this$1;

            public cu then(cu cu2)
                throws Exception
            {
                EventuallyPin eventuallypin = (EventuallyPin)cu2.e();
                Exception exception = cu2.f();
                if (exception != null)
                {
                    if (5 >= Parse.getLogLevel())
                    {
                        PLog.w("ParsePinningEventuallyQueue", "Unable to save command for later.", exception);
                    }
                    notifyTestHelper(4);
                    return cu.a(null);
                } else
                {
                    ParsePinningEventuallyQueue.access$200(this$0).put(eventuallypin.getUUID(), tcs);
                    ParsePinningEventuallyQueue.access$300(this$0).b(new ct() {

                        final _cls1 this$2;

                        public cu then(cu cu1)
                            throws Exception
                        {
                            notifyTestHelper(3);
                            return cu1;
                        }

                        public volatile Object then(cu cu1)
                            throws Exception
                        {
                            return then(cu1);
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    });
                    return cu2.j();
                }
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$1 = ParsePinningEventuallyQueue._cls5.this;
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
        val$object = parseobject;
        val$command = parserestcommand;
        val$tcs = android.support.v7.nd.this;
        super();
    }
}
