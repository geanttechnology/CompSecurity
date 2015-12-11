// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.concurrent.Callable;

// Referenced classes of package com.parse:
//            ParseQuery, ParseUser

class 
    implements Callable
{

    final ParseQuery this$0;
    final ate val$state;

    public cu call()
        throws Exception
    {
        return getUserAsync(val$state).d(new ct() {

            final ParseQuery._cls3 this$1;

            public cu then(cu cu1)
                throws Exception
            {
                cu1 = (ParseUser)cu1.e();
                return findAsync(state, cu1, ParseQuery.access$1900(this$0).a());
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$1 = ParseQuery._cls3.this;
                super();
            }
        });
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    ate()
    {
        this$0 = final_parsequery;
        val$state = ate.this;
        super();
    }
}
