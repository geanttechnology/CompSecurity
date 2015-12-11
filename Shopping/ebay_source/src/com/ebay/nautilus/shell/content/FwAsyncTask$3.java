// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.content;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.ebay.nautilus.shell.content:
//            FwAsyncTask

class mparableFutureTask extends mparableFutureTask
{

    final FwAsyncTask this$0;

    protected void done()
    {
        try
        {
            Object obj = get();
            FwAsyncTask.access$400(FwAsyncTask.this, obj);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            Log.w("AsyncTask", interruptedexception);
            return;
        }
        catch (ExecutionException executionexception)
        {
            throw new RuntimeException("An error occured while executing doInBackground()", executionexception.getCause());
        }
        catch (CancellationException cancellationexception)
        {
            FwAsyncTask.access$400(FwAsyncTask.this, null);
        }
        catch (Throwable throwable)
        {
            throw new RuntimeException("An error occured while executing doInBackground()", throwable);
        }
    }

    mparableFutureTask(Callable callable, int i)
    {
        this$0 = FwAsyncTask.this;
        super(callable, i);
    }
}
