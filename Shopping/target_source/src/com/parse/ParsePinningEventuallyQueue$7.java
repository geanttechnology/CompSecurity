// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.parse:
//            ParsePinningEventuallyQueue, EventuallyPin

class this._cls0
    implements i
{

    final ParsePinningEventuallyQueue this$0;

    public j then(j j1)
        throws Exception
    {
        EventuallyPin eventuallypin;
        for (Iterator iterator = ((List)j1.e()).iterator(); iterator.hasNext(); ParsePinningEventuallyQueue.access$500(ParsePinningEventuallyQueue.this, eventuallypin))
        {
            eventuallypin = (EventuallyPin)iterator.next();
        }

        return j1.j();
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ()
    {
        this$0 = ParsePinningEventuallyQueue.this;
        super();
    }
}
