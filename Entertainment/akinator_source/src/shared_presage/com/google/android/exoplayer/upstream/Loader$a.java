// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.upstream;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.io.IOException;
import shared_presage.com.google.android.exoplayer.util.Assertions;
import shared_presage.com.google.android.exoplayer.util.TraceUtil;

// Referenced classes of package shared_presage.com.google.android.exoplayer.upstream:
//            Loader

private final class c extends Handler
    implements Runnable
{

    final Loader a;
    private final adable b;
    private final llback c;
    private volatile Thread d;

    public final void a()
    {
        b.cancelLoad();
        if (d != null)
        {
            d.interrupt();
        }
    }

    public final void handleMessage(Message message)
    {
        if (message.what == 2)
        {
            throw (Error)message.obj;
        }
        Loader.access$002(a, false);
        Loader.access$102(a, null);
        if (b.isLoadCanceled())
        {
            c.onLoadCanceled(b);
            return;
        }
        switch (message.what)
        {
        default:
            return;

        case 0: // '\0'
            c.onLoadCompleted(b);
            return;

        case 1: // '\001'
            c.onLoadError(b, (IOException)message.obj);
            break;
        }
    }

    public final void run()
    {
        try
        {
            d = Thread.currentThread();
            if (!b.isLoadCanceled())
            {
                TraceUtil.beginSection((new StringBuilder()).append(b.getClass().getSimpleName()).append(".load()").toString());
                b.load();
                TraceUtil.endSection();
            }
            sendEmptyMessage(0);
            return;
        }
        catch (IOException ioexception)
        {
            obtainMessage(1, ioexception).sendToTarget();
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            Assertions.checkState(b.isLoadCanceled());
            sendEmptyMessage(0);
            return;
        }
        catch (Exception exception)
        {
            Log.e("LoadTask", "Unexpected exception loading stream", exception);
            obtainMessage(1, new expectedLoaderException(exception)).sendToTarget();
            return;
        }
        catch (Error error)
        {
            Log.e("LoadTask", "Unexpected error loading stream", error);
            obtainMessage(2, error).sendToTarget();
            throw error;
        }
    }

    public llback(Loader loader, Looper looper, adable adable, llback llback)
    {
        a = loader;
        super(looper);
        b = adable;
        c = llback;
    }
}
