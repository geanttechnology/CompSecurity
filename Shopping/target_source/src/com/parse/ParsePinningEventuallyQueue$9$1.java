// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.ArrayList;

// Referenced classes of package com.parse:
//            ParsePinningEventuallyQueue, EventuallyPin

class this._cls1
    implements i
{

    final then this$1;

    public j then(j j)
        throws Exception
    {
        ParsePinningEventuallyQueue.access$600(_fld0).remove(uuid);
        return j;
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    l.uuid()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/ParsePinningEventuallyQueue$9

/* anonymous class */
    class ParsePinningEventuallyQueue._cls9
        implements i
    {

        final ParsePinningEventuallyQueue this$0;
        final EventuallyPin val$eventuallyPin;
        final String val$uuid;

        public j then(j j1)
            throws Exception
        {
            return ParsePinningEventuallyQueue.access$700(ParsePinningEventuallyQueue.this, eventuallyPin, j1).b(new ParsePinningEventuallyQueue._cls9._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = final_parsepinningeventuallyqueue;
                eventuallyPin = eventuallypin;
                uuid = String.this;
                super();
            }
    }

}
