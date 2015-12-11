// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
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
        return EventuallyPin.findAllPinned().b(new ct() {

            final ParsePinningEventuallyQueue._cls3 this$1;

            public cu then(cu cu2)
                throws Exception
            {
                return cu.a(Integer.valueOf(((List)cu2.e()).size()));
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$1 = ParsePinningEventuallyQueue._cls3.this;
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
        this$0 = ParsePinningEventuallyQueue.this;
        super();
    }
}
