// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.concurrent.Executor;

// Referenced classes of package com.parse:
//            PushRouter, ParseExecutors

class val.task
    implements Runnable
{

    final val.task this$0;
    final cu val$task;

    public void run()
    {
        throw new RuntimeException(val$task.f());
    }

    tor()
    {
        this$0 = final_tor;
        val$task = cu.this;
        super();
    }

    // Unreferenced inner class com/parse/PushRouter$11

/* anonymous class */
    static final class PushRouter._cls11
        implements ct
    {

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

        public Void then(cu cu1)
        {
            if (cu1.d())
            {
                ParseExecutors.main().execute(cu1. new PushRouter._cls11._cls1());
            }
            return null;
        }

    }

}
