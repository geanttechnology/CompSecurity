// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.ArrayList;

// Referenced classes of package com.parse:
//            ParsePinningEventuallyQueue, EventuallyPin

class val.uuid
    implements ct
{

    final ParsePinningEventuallyQueue this$0;
    final EventuallyPin val$eventuallyPin;
    final String val$uuid;

    public cu then(cu cu1)
        throws Exception
    {
        return ParsePinningEventuallyQueue.access$700(ParsePinningEventuallyQueue.this, val$eventuallyPin, cu1).b(new ct() {

            final ParsePinningEventuallyQueue._cls9 this$1;

            public cu then(cu cu2)
                throws Exception
            {
                ParsePinningEventuallyQueue.access$600(this$0).remove(uuid);
                return cu2;
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$1 = ParsePinningEventuallyQueue._cls9.this;
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
        val$eventuallyPin = eventuallypin;
        val$uuid = String.this;
        super();
    }
}
