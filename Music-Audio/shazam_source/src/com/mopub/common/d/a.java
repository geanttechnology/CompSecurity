// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.d;

import android.os.AsyncTask;
import android.os.Looper;
import com.mopub.common.m;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class a
{

    private static Executor a;

    public static transient void a(AsyncTask asynctask, Object aobj[])
    {
        m.a(asynctask, "Unable to execute null AsyncTask.");
        if (!Looper.getMainLooper().equals(Looper.myLooper()))
        {
            throw new IllegalStateException(m.a("AsyncTask must be executed on the main thread", new Object[] {
                ""
            }));
        }
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            asynctask.executeOnExecutor(a, aobj);
            return;
        } else
        {
            asynctask.execute(aobj);
            return;
        }
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            a = AsyncTask.THREAD_POOL_EXECUTOR;
        } else
        {
            a = Executors.newSingleThreadExecutor();
        }
    }
}
