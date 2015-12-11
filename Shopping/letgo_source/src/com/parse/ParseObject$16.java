// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseObject, ParseOperationSet, Parse, ParseEventuallyQueue

class et
    implements ct
{

    final ParseObject this$0;
    final ParseOperationSet val$operationSet;

    public cu then(cu cu1)
        throws Exception
    {
        return cu1.b(new ct() {

            final ParseObject._cls16 this$1;

            public cu then(cu cu2)
                throws Exception
            {
                return Parse.getEventuallyQueue().waitForOperationSetAndEventuallyPin(operationSet, null).j();
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$1 = ParseObject._cls16.this;
                super();
            }
        });
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    et()
    {
        this$0 = final_parseobject;
        val$operationSet = ParseOperationSet.this;
        super();
    }
}
