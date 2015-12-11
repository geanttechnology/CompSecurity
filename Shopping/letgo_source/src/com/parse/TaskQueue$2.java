// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            TaskQueue

static final class >
    implements ct
{

    final cu val$toAwait;

    public cu then(final cu task)
        throws Exception
    {
        return val$toAwait.b(new ct() {

            final TaskQueue._cls2 this$0;
            final cu val$task;

            public cu then(cu cu1)
                throws Exception
            {
                return task;
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = TaskQueue._cls2.this;
                task = cu1;
                super();
            }
        });
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    >(cu cu1)
    {
        val$toAwait = cu1;
        super();
    }
}
