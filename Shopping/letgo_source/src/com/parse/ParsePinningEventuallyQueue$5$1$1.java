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

class this._cls2
    implements ct
{

    final then this$2;

    public cu then(cu cu)
        throws Exception
    {
        notifyTestHelper(3);
        return cu;
    }

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    tcs()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/parse/ParsePinningEventuallyQueue$5

/* anonymous class */
    class ParsePinningEventuallyQueue._cls5
        implements ct
    {

        final ParsePinningEventuallyQueue this$0;
        final ParseRESTCommand val$command;
        final ParseObject val$object;
        final android.support.v7.cu.a val$tcs;

        public cu then(cu cu1)
            throws Exception
        {
            return EventuallyPin.pinEventuallyCommand(object, command).b(new ParsePinningEventuallyQueue._cls5._cls1());
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$0 = final_parsepinningeventuallyqueue;
                object = parseobject;
                command = parserestcommand;
                tcs = android.support.v7.cu.a.this;
                super();
            }
    }


    // Unreferenced inner class com/parse/ParsePinningEventuallyQueue$5$1

/* anonymous class */
    class ParsePinningEventuallyQueue._cls5._cls1
        implements ct
    {

        final ParsePinningEventuallyQueue._cls5 this$1;

        public cu then(cu cu1)
            throws Exception
        {
            EventuallyPin eventuallypin = (EventuallyPin)cu1.e();
            Exception exception = cu1.f();
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
                ParsePinningEventuallyQueue.access$300(this$0).b(new ParsePinningEventuallyQueue._cls5._cls1._cls1());
                return cu1.j();
            }
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$1 = ParsePinningEventuallyQueue._cls5.this;
                super();
            }
    }

}
