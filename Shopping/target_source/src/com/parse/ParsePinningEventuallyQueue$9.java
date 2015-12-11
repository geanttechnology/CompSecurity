// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.ArrayList;

// Referenced classes of package com.parse:
//            ParsePinningEventuallyQueue, EventuallyPin

class val.uuid
    implements i
{

    final ParsePinningEventuallyQueue this$0;
    final EventuallyPin val$eventuallyPin;
    final String val$uuid;

    public j then(j j1)
        throws Exception
    {
        return ParsePinningEventuallyQueue.access$700(ParsePinningEventuallyQueue.this, val$eventuallyPin, j1).b(new i() {

            final ParsePinningEventuallyQueue._cls9 this$1;

            public j then(j j2)
                throws Exception
            {
                ParsePinningEventuallyQueue.access$600(this$0).remove(uuid);
                return j2;
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$1 = ParsePinningEventuallyQueue._cls9.this;
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
        val$eventuallyPin = eventuallypin;
        val$uuid = String.this;
        super();
    }
}
