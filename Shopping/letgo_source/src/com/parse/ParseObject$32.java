// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseObject, TaskQueue

class this._cls0
    implements ct
{

    final ParseObject this$0;

    public cu then(final cu sessionToken)
        throws Exception
    {
        sessionToken = (String)sessionToken.e();
        return taskQueue.enqueue(new ct() {

            final ParseObject._cls32 this$1;
            final String val$sessionToken;

            public cu then(cu cu1)
                throws Exception
            {
                return ParseObject.access$1100(this$0, sessionToken, cu1);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$1 = ParseObject._cls32.this;
                sessionToken = s;
                super();
            }
        });
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    _cls1.val.sessionToken()
    {
        this$0 = ParseObject.this;
        super();
    }
}
