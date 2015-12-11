// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.HashMap;

// Referenced classes of package com.parse:
//            EventuallyPin, Parse, PLog, ParsePinningEventuallyQueue, 
//            ParseRESTCommand, ParseObject

class this._cls1
    implements i
{

    final then this$1;

    public j then(j j1)
        throws Exception
    {
        EventuallyPin eventuallypin = (EventuallyPin)j1.e();
        Exception exception = j1.f();
        if (exception != null)
        {
            if (5 >= Parse.getLogLevel())
            {
                PLog.w("ParsePinningEventuallyQueue", "Unable to save command for later.", exception);
            }
            notifyTestHelper(4);
            return j.a(null);
        } else
        {
            ParsePinningEventuallyQueue.access$200(_fld0).put(eventuallypin.getUUID(), tcs);
            ParsePinningEventuallyQueue.access$300(_fld0).b(new i() {

                final ParsePinningEventuallyQueue._cls5._cls1 this$2;

                public j then(j j2)
                    throws Exception
                {
                    notifyTestHelper(3);
                    return j2;
                }

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

            
            {
                this$2 = ParsePinningEventuallyQueue._cls5._cls1.this;
                super();
            }
            });
            return j1.j();
        }
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    l.tcs()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/ParsePinningEventuallyQueue$5

/* anonymous class */
    class ParsePinningEventuallyQueue._cls5
        implements i
    {

        final ParsePinningEventuallyQueue this$0;
        final ParseRESTCommand val$command;
        final ParseObject val$object;
        final a.j.a val$tcs;

        public j then(j j1)
            throws Exception
        {
            return EventuallyPin.pinEventuallyCommand(object, command).b(new ParsePinningEventuallyQueue._cls5._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = final_parsepinningeventuallyqueue;
                object = parseobject;
                command = parserestcommand;
                tcs = a.j.a.this;
                super();
            }
    }

}
