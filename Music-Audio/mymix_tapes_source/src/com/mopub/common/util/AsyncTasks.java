// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.util;

import android.os.AsyncTask;
import com.mopub.common.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AsyncTasks
{

    private static Executor sExecutor;

    public AsyncTasks()
    {
    }

    private static void init()
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            sExecutor = AsyncTask.THREAD_POOL_EXECUTOR;
            return;
        } else
        {
            sExecutor = Executors.newSingleThreadExecutor();
            return;
        }
    }

    public static transient void safeExecuteOnExecutor(AsyncTask asynctask, Object aobj[])
    {
        Preconditions.checkNotNull(asynctask, "Unable to execute null AsyncTask.");
        Preconditions.checkUiThread("AsyncTask must be executed on the main thread");
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            asynctask.executeOnExecutor(sExecutor, aobj);
            return;
        } else
        {
            asynctask.execute(aobj);
            return;
        }
    }

    public static void setExecutor(Executor executor)
    {
        sExecutor = executor;
    }

    static 
    {
        init();
    }
}
