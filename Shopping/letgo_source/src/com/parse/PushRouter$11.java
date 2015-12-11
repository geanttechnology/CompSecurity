// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.concurrent.Executor;

// Referenced classes of package com.parse:
//            PushRouter, ParseExecutors

static final class _cls1.val.task
    implements ct
{

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    public Void then(final cu task)
    {
        if (task.d())
        {
            ParseExecutors.main().execute(new Runnable() {

                final PushRouter._cls11 this$0;
                final cu val$task;

                public void run()
                {
                    throw new RuntimeException(task.f());
                }

            
            {
                this$0 = PushRouter._cls11.this;
                task = cu1;
                super();
            }
            });
        }
        return null;
    }

    _cls1.val.task()
    {
    }
}
