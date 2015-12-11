// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
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
        return EventuallyPin.findAllPinned().b(new i() {

            final ParsePinningEventuallyQueue._cls3 this$1;

            public j then(j j2)
                throws Exception
            {
                return j.a(Integer.valueOf(((List)j2.e()).size()));
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$1 = ParsePinningEventuallyQueue._cls3.this;
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
        this$0 = ParsePinningEventuallyQueue.this;
        super();
    }
}
