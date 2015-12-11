// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import twitter4j.conf.Configuration;

// Referenced classes of package twitter4j:
//            Dispatcher, Logger

final class DispatcherImpl
    implements Dispatcher
{

    private static final long SHUTDOWN_TIME = 5000L;
    private static final Logger logger = Logger.getLogger(twitter4j/DispatcherImpl);
    private final ExecutorService executorService;

    public DispatcherImpl(final Configuration conf)
    {
        executorService = Executors.newFixedThreadPool(conf.getAsyncNumThreads(), new ThreadFactory() {

            int count;
            final DispatcherImpl this$0;
            final Configuration val$conf;

            public Thread newThread(Runnable runnable)
            {
                runnable = new Thread(runnable);
                int i = count;
                count = i + 1;
                runnable.setName(String.format("Twitter4J Async Dispatcher[%d]", new Object[] {
                    Integer.valueOf(i)
                }));
                runnable.setDaemon(conf.isDaemonEnabled());
                return runnable;
            }

            
            {
                this$0 = DispatcherImpl.this;
                conf = configuration;
                super();
                count = 0;
            }
        });
        Runtime.getRuntime().addShutdownHook(new Thread() {

            final DispatcherImpl this$0;

            public void run()
            {
                executorService.shutdown();
            }

            
            {
                this$0 = DispatcherImpl.this;
                super();
            }
        });
    }

    public void invokeLater(Runnable runnable)
    {
        this;
        JVM INSTR monitorenter ;
        executorService.execute(runnable);
        this;
        JVM INSTR monitorexit ;
        return;
        runnable;
        throw runnable;
    }

    public void shutdown()
    {
        this;
        JVM INSTR monitorenter ;
        executorService.shutdown();
        if (!executorService.awaitTermination(5000L, TimeUnit.MILLISECONDS))
        {
            executorService.shutdownNow();
        }
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        logger.warn(((InterruptedException) (obj)).getMessage());
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        throw obj;
    }


}
