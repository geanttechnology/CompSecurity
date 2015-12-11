// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseObject, TaskQueue

class this._cls0
    implements i
{

    final ParseObject this$0;

    public j then(final j sessionToken)
        throws Exception
    {
        sessionToken = (String)sessionToken.e();
        return taskQueue.enqueue(new i() {

            final ParseObject._cls27 this$1;
            final String val$sessionToken;

            public j then(j j1)
                throws Exception
            {
                return fetchAsync(sessionToken, j1);
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$1 = ParseObject._cls27.this;
                sessionToken = s;
                super();
            }
        });
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    _cls1.val.sessionToken()
    {
        this$0 = ParseObject.this;
        super();
    }
}
