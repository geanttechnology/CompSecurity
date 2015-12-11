// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParsePinningEventuallyQueue

class val.tcs
    implements ct
{

    final ParsePinningEventuallyQueue this$0;
    final android.support.v7.tAsync val$tcs;

    public cu then(cu cu1)
        throws Exception
    {
        return pendingCountAsync(cu1).b(new ct() {

            final ParsePinningEventuallyQueue._cls2 this$1;

            public cu then(cu cu2)
                throws Exception
            {
                int i = ((Integer)cu2.e()).intValue();
                tcs.b(Integer.valueOf(i));
                return cu.a(null);
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$1 = ParsePinningEventuallyQueue._cls2.this;
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
        val$tcs = android.support.v7..this;
        super();
    }
}
