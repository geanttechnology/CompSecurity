// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.concurrent.Executor;

// Referenced classes of package com.parse:
//            ParseException, ParseCallback2, ParseTaskUtils, ParseExecutors

class val.task
    implements Runnable
{

    final val.task this$0;
    final cu val$task;

    public void run()
    {
        Object obj = val$task.f();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        if (!(obj instanceof ParseException))
        {
            obj = new ParseException(((Throwable) (obj)));
        }
        callback.done(val$task.e(), (ParseException)obj);
        if (val$task.c())
        {
            tcs.k();
            return;
        }
        if (val$task.d())
        {
            tcs.k(val$task.f());
            return;
        } else
        {
            tcs.k(val$task.e());
            return;
        }
        Exception exception;
        exception;
        if (val$task.c())
        {
            tcs.k();
        } else
        if (val$task.d())
        {
            tcs.k(val$task.f());
        } else
        {
            tcs.k(val$task.e());
        }
        throw exception;
    }

    l.callback()
    {
        this$0 = final_callback;
        val$task = cu.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseTaskUtils$2

/* anonymous class */
    static final class ParseTaskUtils._cls2
        implements ct
    {

        final ParseCallback2 val$callback;
        final boolean val$reportCancellation;
        final android.support.v7.cu.a val$tcs;

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

        public Void then(cu cu1)
            throws Exception
        {
            if (cu1.c() && !reportCancellation)
            {
                tcs.c();
                return null;
            } else
            {
                ParseExecutors.main().execute(cu1. new ParseTaskUtils._cls2._cls1());
                return null;
            }
        }

            
            {
                reportCancellation = flag;
                tcs = a;
                callback = parsecallback2;
                super();
            }
    }

}
