// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.http;

import android.content.DialogInterface;
import com.groupon.util.AbstractRetryAsyncTask;

// Referenced classes of package com.groupon.http:
//            RetryQueue

class AsyncTask
    implements android.content.ce.OnClickListener
{

    final RetryQueue this$0;
    final AbstractRetryAsyncTask val$t;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        val$t.onUserCancelRetry();
        synchronized (RetryQueue.this)
        {
            RetryQueue.access$000(RetryQueue.this);
        }
        return;
        exception;
        dialoginterface;
        JVM INSTR monitorexit ;
        throw exception;
    }

    AsyncTask()
    {
        this$0 = final_retryqueue;
        val$t = AbstractRetryAsyncTask.this;
        super();
    }
}
