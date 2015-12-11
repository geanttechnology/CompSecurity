// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.os.AsyncTask;

// Referenced classes of package com.amazon.device.ads:
//            ThreadUtils, AndroidTargetUtils

static final class val.params
    implements Runnable
{

    final Object val$params[];
    final AsyncTask val$task;

    public void run()
    {
        AndroidTargetUtils.executeAsyncTask(val$task, val$params);
    }

    tils(AsyncTask asynctask, Object aobj[])
    {
        val$task = asynctask;
        val$params = aobj;
        super();
    }
}
