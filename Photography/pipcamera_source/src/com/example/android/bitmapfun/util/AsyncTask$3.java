// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.example.android.bitmapfun.util;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// Referenced classes of package com.example.android.bitmapfun.util:
//            AsyncTask

class a extends FutureTask
{

    final AsyncTask a;

    protected void done()
    {
        try
        {
            AsyncTask.b(a, get());
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            return;
        }
        catch (ExecutionException executionexception)
        {
            throw new RuntimeException("An error occured while executing doInBackground()", executionexception.getCause());
        }
        catch (CancellationException cancellationexception)
        {
            AsyncTask.b(a, null);
        }
    }

    (AsyncTask asynctask, Callable callable)
    {
        a = asynctask;
        super(callable);
    }
}
