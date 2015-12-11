// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.utils.executor;

import android.os.AsyncTask;

public class V11ExecutorHelper
{

    public V11ExecutorHelper()
    {
    }

    public static void executeOnExecutor(AsyncTask asynctask)
    {
        asynctask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[] {
            (Void)null
        });
    }
}
