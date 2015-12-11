// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseObject, ParseOperationSet

class et
    implements ct
{

    final ParseObject this$0;
    final ParseOperationSet val$operations;

    public cu then(final cu saveTask)
        throws Exception
    {
        te te = (te)saveTask.e();
        return handleSaveResultAsync(te, val$operations).b(new ct() {

            final ParseObject._cls13 this$1;
            final cu val$saveTask;

            public cu then(cu cu1)
                throws Exception
            {
                if (cu1.d() || cu1.c())
                {
                    return cu1;
                } else
                {
                    return saveTask.j();
                }
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$1 = ParseObject._cls13.this;
                saveTask = cu1;
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
        val$operations = ParseOperationSet.this;
        super();
    }
}
