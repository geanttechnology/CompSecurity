// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.parse:
//            ParsePinningEventuallyQueue, EventuallyPin

class this._cls0
    implements ct
{

    final ParsePinningEventuallyQueue this$0;

    public cu then(cu cu1)
        throws Exception
    {
        EventuallyPin eventuallypin;
        for (Iterator iterator = ((List)cu1.e()).iterator(); iterator.hasNext(); ParsePinningEventuallyQueue.access$500(ParsePinningEventuallyQueue.this, eventuallypin))
        {
            eventuallypin = (EventuallyPin)iterator.next();
        }

        return cu1.j();
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ()
    {
        this$0 = ParsePinningEventuallyQueue.this;
        super();
    }
}
