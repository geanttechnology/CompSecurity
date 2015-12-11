// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.google.android.speech.callback.Callback;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public final class czr
    implements Closeable
{

    public final ExecutorService a;
    public Future b;
    public final Runnable c;
    private final czu d;
    private final czq e;
    private final dab f;
    private final dah g;
    private daa h;
    private final Runnable i;

    public czr(Callback callback, czq czq1, dab dab1, dah dah1)
    {
        this(callback, czq1, dab1, dah1, ((ExecutorService) (a.b("NetworkRunner", false))));
    }

    private czr(Callback callback, czq czq1, dab dab1, dah dah1, ExecutorService executorservice)
    {
        c = new czs(this);
        i = new czt(this);
        d = new czu(callback, czq1);
        e = czq1;
        f = dab1;
        g = dah1;
        a = executorservice;
    }

    static daa a(czr czr1, daa daa1)
    {
        czr1.h = null;
        return null;
    }

    private static void a()
    {
        if (Thread.currentThread().isInterrupted())
        {
            throw new InterruptedException();
        } else
        {
            return;
        }
    }

    static void a(czr czr1)
    {
        czr1.e.onConnectionStarted();
        czr1.h = czr1.f.a();
        a();
        exe exe = czr1.g.next();
        czr1.h.a(czr1.d, exe);
        czr1.e.onConnectionFinished();
        a();
_L1:
        exe exe1 = czr1.g.next();
        if (exe1 == null)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        a();
        czr1.h.a(exe1);
        czr1.e.onDataSent();
          goto _L1
        Object obj;
        obj;
        czr1.d.a(new dam("Error in network recognizer: ", ((Throwable) (obj))));
        czr1.e.onError();
        emp.a(czr1.h);
        czr1.h = null;
        emp.a(czr1.g);
        return;
        czr1.e.onDataComplete();
        emp.a(czr1.g);
        return;
        obj;
        emp.a(czr1.g);
        return;
        obj;
        emp.a(czr1.g);
        throw obj;
    }

    static daa b(czr czr1)
    {
        return czr1.h;
    }

    public final void close()
    {
        d.a = true;
        Future future;
        if (b != null)
        {
            b.cancel(true);
            future = b;
            b = null;
        } else
        {
            future = null;
        }
        if (future == null)
        {
            if (!a.isShutdown())
            {
                f.b(a.shutdownNow().isEmpty());
            }
            return;
        } else
        {
            a.execute(i);
            a.shutdown();
            return;
        }
    }

    public final void finalize()
    {
        if (h != null)
        {
            Log.e("VS.NetworkRecognitionRunner", (new StringBuilder("Recognition runner not closed, connection: ")).append(h).toString());
            emp.a(h);
        }
        super.finalize();
    }
}
