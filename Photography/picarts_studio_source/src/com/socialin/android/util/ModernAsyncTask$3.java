// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// Referenced classes of package com.socialin.android.util:
//            ModernAsyncTask

final class a extends FutureTask
{

    private ModernAsyncTask a;

    protected final void done()
    {
        try
        {
            Object obj = get();
            ModernAsyncTask.access$400(a, obj);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            Log.w("AsyncTask", interruptedexception);
            return;
        }
        catch (ExecutionException executionexception)
        {
            throw new RuntimeException("An error occurred while executing doInBackground()", executionexception.getCause());
        }
        catch (CancellationException cancellationexception)
        {
            ModernAsyncTask.access$400(a, null);
        }
    }

    (ModernAsyncTask modernasynctask, Callable callable)
    {
        a = modernasynctask;
        super(callable);
    }
}
