// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.upstream;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import shared_presage.com.google.android.exoplayer.util.Assertions;
import shared_presage.com.google.android.exoplayer.util.TraceUtil;
import shared_presage.com.google.android.exoplayer.util.Util;

public final class Loader
{
    public static interface Callback
    {

        public abstract void onLoadCanceled(Loadable loadable);

        public abstract void onLoadCompleted(Loadable loadable);

        public abstract void onLoadError(Loadable loadable, IOException ioexception);
    }

    public static interface Loadable
    {

        public abstract void cancelLoad();

        public abstract boolean isLoadCanceled();

        public abstract void load();
    }

    public static final class UnexpectedLoaderException extends IOException
    {

        public UnexpectedLoaderException(Exception exception)
        {
            super((new StringBuilder("Unexpected ")).append(exception.getClass().getSimpleName()).append(": ").append(exception.getMessage()).toString(), exception);
        }
    }

    private final class a extends Handler
        implements Runnable
    {

        final Loader a;
        private final Loadable b;
        private final Callback c;
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
            a.loading = false;
            a.currentTask = null;
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
                obtainMessage(1, new UnexpectedLoaderException(exception)).sendToTarget();
                return;
            }
            catch (Error error)
            {
                Log.e("LoadTask", "Unexpected error loading stream", error);
                obtainMessage(2, error).sendToTarget();
                throw error;
            }
        }

        public a(Looper looper, Loadable loadable, Callback callback)
        {
            a = Loader.this;
            super(looper);
            b = loadable;
            c = callback;
        }
    }


    private static final int MSG_END_OF_SOURCE = 0;
    private static final int MSG_FATAL_ERROR = 2;
    private static final int MSG_IO_EXCEPTION = 1;
    private a currentTask;
    private final ExecutorService downloadExecutorService;
    private boolean loading;

    public Loader(String s)
    {
        downloadExecutorService = Util.newSingleThreadExecutor(s);
    }

    public final void cancelLoading()
    {
        Assertions.checkState(loading);
        currentTask.a();
    }

    public final boolean isLoading()
    {
        return loading;
    }

    public final void release()
    {
        if (loading)
        {
            cancelLoading();
        }
        downloadExecutorService.shutdown();
    }

    public final void startLoading(Looper looper, Loadable loadable, Callback callback)
    {
        boolean flag;
        if (!loading)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        loading = true;
        currentTask = new a(looper, loadable, callback);
        downloadExecutorService.submit(currentTask);
    }

    public final void startLoading(Loadable loadable, Callback callback)
    {
        Looper looper = Looper.myLooper();
        boolean flag;
        if (looper != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        startLoading(looper, loadable, callback);
    }


/*
    static boolean access$002(Loader loader, boolean flag)
    {
        loader.loading = flag;
        return flag;
    }

*/


/*
    static a access$102(Loader loader, a a)
    {
        loader.currentTask = a;
        return a;
    }

*/
}
