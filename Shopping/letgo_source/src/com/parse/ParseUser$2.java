// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseUser

class >
    implements ct
{

    final ParseUser this$0;

    public cu then(final cu fetchAsyncTask)
        throws Exception
    {
        cu cu1 = fetchAsyncTask;
        if (isCurrentUser())
        {
            ParseUser.access$100(ParseUser.this);
            cu1 = ParseUser.access$200(ParseUser.this).b(new ct() {

                final ParseUser._cls2 this$1;
                final cu val$fetchAsyncTask;

                public cu then(cu cu2)
                    throws Exception
                {
                    return fetchAsyncTask;
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$1 = ParseUser._cls2.this;
                fetchAsyncTask = cu1;
                super();
            }
            });
        }
        return cu1;
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    >()
    {
        this$0 = ParseUser.this;
        super();
    }
}
