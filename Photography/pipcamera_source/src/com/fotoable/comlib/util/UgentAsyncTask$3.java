// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.comlib.util;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// Referenced classes of package com.fotoable.comlib.util:
//            UgentAsyncTask

class a extends FutureTask
{

    final UgentAsyncTask a;

    protected void done()
    {
        try
        {
            UgentAsyncTask.b(a, get());
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            Log.w("UgentAsyncTask", interruptedexception);
            return;
        }
        catch (ExecutionException executionexception)
        {
            throw new RuntimeException("An error occured while executing doInBackground()", executionexception.getCause());
        }
        catch (CancellationException cancellationexception)
        {
            UgentAsyncTask.b(a, null);
        }
    }

    (UgentAsyncTask ugentasynctask, Callable callable)
    {
        a = ugentasynctask;
        super(callable);
    }
}
