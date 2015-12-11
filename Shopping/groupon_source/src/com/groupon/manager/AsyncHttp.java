// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import com.groupon.http.synchronous.SyncHttp;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

class AsyncHttp
{

    private static ExecutorService executor = Executors.newSingleThreadExecutor();
    private FutureTask futureTask;
    private SyncHttp syncHttp;

    public AsyncHttp(Context context, Class class1, String s, Object aobj[])
    {
        syncHttp = new SyncHttp(context, class1, s, aobj);
        futureTask = new FutureTask(new Callable() {

            final AsyncHttp this$0;

            public Object call()
                throws Exception
            {
                return syncHttp.call();
            }

            
            {
                this$0 = AsyncHttp.this;
                super();
            }
        });
    }

    public AsyncHttp execute()
    {
        executor.execute(futureTask);
        return this;
    }

    public Object get()
        throws ExecutionException, InterruptedException
    {
        return futureTask.get();
    }

    public Object[] getParams()
    {
        return syncHttp.nvps();
    }


}
