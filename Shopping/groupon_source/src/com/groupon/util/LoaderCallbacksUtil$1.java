// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.DialogInterface;
import com.groupon.db.events.DialogCallbackEvent;
import com.squareup.otto.Bus;
import commonlib.manager.SyncManager;

// Referenced classes of package com.groupon.util:
//            LoaderCallbacksUtil, Function2

static final class val.globalBus
    implements android.content.kListener
{

    final Exception val$e;
    final Bus val$globalBus;
    final SyncManager val$syncManager;
    final Function2 val$taskCanceled;
    final Runnable val$taskToRetry;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        val$syncManager.clearRetryTasks();
        if (val$taskCanceled != null)
        {
            val$taskCanceled.execute(val$taskToRetry, val$e);
        }
        val$globalBus.post(new DialogCallbackEvent("negative_click"));
    }

    nt(SyncManager syncmanager, Function2 function2, Runnable runnable, Exception exception, Bus bus)
    {
        val$syncManager = syncmanager;
        val$taskCanceled = function2;
        val$taskToRetry = runnable;
        val$e = exception;
        val$globalBus = bus;
        super();
    }
}
