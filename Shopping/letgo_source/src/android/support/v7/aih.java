// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package android.support.v7:
//            ajv, ahx, ajt, ahv, 
//            aig, ajc, aji, aiw, 
//            aja, aib, ajh, aia, 
//            aht, aid, ajd, ajj, 
//            ajf

public class aih
{
    private static class a
        implements ThreadFactory
    {

        private static final AtomicInteger a = new AtomicInteger(1);
        private final ThreadGroup b = Thread.currentThread().getThreadGroup();
        private final AtomicInteger c = new AtomicInteger(1);
        private final String d;
        private final int e;

        public Thread newThread(Runnable runnable)
        {
            runnable = new Thread(b, runnable, (new StringBuilder()).append(d).append(c.getAndIncrement()).toString(), 0L);
            if (runnable.isDaemon())
            {
                runnable.setDaemon(false);
            }
            runnable.setPriority(e);
            return runnable;
        }


        a(int i, String s)
        {
            e = i;
            d = (new StringBuilder()).append(s).append(a.getAndIncrement()).append("-thread-").toString();
        }
    }


    public static aht a(Context context, aia aia, long l, int i)
    {
        File file;
        Object obj;
        file = b(context);
        if (l <= 0L && i <= 0)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        obj = ajv.b(context);
        obj = new ahx(((File) (obj)), file, aia, l, i);
        return ((aht) (obj));
        IOException ioexception;
        ioexception;
        ajt.a(ioexception);
        return new ahv(ajv.a(context), file, aia);
    }

    public static aid a(int i)
    {
        int j = i;
        if (i == 0)
        {
            j = (int)(Runtime.getRuntime().maxMemory() / 8L);
        }
        return new aig(j);
    }

    public static ajd a(boolean flag)
    {
        return new ajc(flag);
    }

    public static ajj a(Context context)
    {
        return new aji(context);
    }

    public static Executor a()
    {
        return Executors.newCachedThreadPool(a(5, "uil-pool-d-"));
    }

    public static Executor a(int i, int j, aiw aiw1)
    {
        boolean flag;
        if (aiw1 == aiw.b)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            aiw1 = new aja();
        } else
        {
            aiw1 = new LinkedBlockingQueue();
        }
        aiw1 = (BlockingQueue)aiw1;
        return new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, aiw1, a(j, "uil-pool-"));
    }

    private static ThreadFactory a(int i, String s)
    {
        return new a(i, s);
    }

    public static aia b()
    {
        return new aib();
    }

    private static File b(Context context)
    {
        context = ajv.a(context, false);
        File file = new File(context, "uil-images");
        if (file.exists() || file.mkdir())
        {
            context = file;
        }
        return context;
    }

    public static ajf c()
    {
        return new ajh();
    }
}
