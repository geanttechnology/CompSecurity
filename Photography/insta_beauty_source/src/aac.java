// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.fotoable.comlib.util.UgentAsyncTask;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class aac extends FutureTask
{

    final UgentAsyncTask a;

    public aac(UgentAsyncTask ugentasynctask, Callable callable)
    {
        a = ugentasynctask;
        super(callable);
    }

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
}
