// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.device.ads:
//            MobileAdsLoggerFactory, MobileAdsLogger, AndroidTargetUtils

class ThreadUtils
{
    public static class BackgroundThreadRunner extends ThreadExecutor
    {

        public BackgroundThreadRunner(ThreadVerify threadverify)
        {
            super(threadverify, new ThreadPoolScheduler());
        }
    }

    public static final class ExecutionStyle extends Enum
    {

        private static final ExecutionStyle $VALUES[];
        public static final ExecutionStyle RUN_ASAP;
        public static final ExecutionStyle SCHEDULE;

        public static ExecutionStyle valueOf(String s)
        {
            return (ExecutionStyle)Enum.valueOf(com/amazon/device/ads/ThreadUtils$ExecutionStyle, s);
        }

        public static ExecutionStyle[] values()
        {
            return (ExecutionStyle[])$VALUES.clone();
        }

        static 
        {
            RUN_ASAP = new ExecutionStyle("RUN_ASAP", 0);
            SCHEDULE = new ExecutionStyle("SCHEDULE", 1);
            $VALUES = (new ExecutionStyle[] {
                RUN_ASAP, SCHEDULE
            });
        }

        private ExecutionStyle(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ExecutionThread extends Enum
    {

        private static final ExecutionThread $VALUES[];
        public static final ExecutionThread BACKGROUND_THREAD;
        public static final ExecutionThread MAIN_THREAD;

        public static ExecutionThread valueOf(String s)
        {
            return (ExecutionThread)Enum.valueOf(com/amazon/device/ads/ThreadUtils$ExecutionThread, s);
        }

        public static ExecutionThread[] values()
        {
            return (ExecutionThread[])$VALUES.clone();
        }

        static 
        {
            MAIN_THREAD = new ExecutionThread("MAIN_THREAD", 0);
            BACKGROUND_THREAD = new ExecutionThread("BACKGROUND_THREAD", 1);
            $VALUES = (new ExecutionThread[] {
                MAIN_THREAD, BACKGROUND_THREAD
            });
        }

        private ExecutionThread(String s, int i)
        {
            super(s, i);
        }
    }

    public static class MainThreadRunner extends ThreadExecutor
    {

        public MainThreadRunner(ThreadVerify threadverify)
        {
            super(threadverify, new MainThreadScheduler());
        }
    }

    public static class MainThreadScheduler extends RunnableExecutor
    {

        public void execute(Runnable runnable)
        {
            (new Handler(Looper.getMainLooper())).post(runnable);
        }

        public MainThreadScheduler()
        {
            super(ExecutionStyle.SCHEDULE, ExecutionThread.MAIN_THREAD);
        }
    }

    static abstract class MobileAdsAsyncTask extends AsyncTask
    {

        protected transient abstract Object doInBackground(Object aobj[]);

        protected void onPostExecute(Object obj)
        {
            super.onPostExecute(obj);
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        MobileAdsAsyncTask()
        {
        }
    }

    public static abstract class RunnableExecutor
    {

        private final ExecutionStyle executionStyle;
        private final ExecutionThread executionThread;

        public abstract void execute(Runnable runnable);

        public ExecutionStyle getExecutionStyle()
        {
            return executionStyle;
        }

        public ExecutionThread getExecutionThread()
        {
            return executionThread;
        }


        public RunnableExecutor(ExecutionStyle executionstyle, ExecutionThread executionthread)
        {
            executionStyle = executionstyle;
            executionThread = executionthread;
        }
    }

    public static class SingleThreadScheduler extends RunnableExecutor
    {

        private ExecutorService executorService;

        public void execute(Runnable runnable)
        {
            executorService.submit(runnable);
        }

        public SingleThreadScheduler()
        {
            super(ExecutionStyle.SCHEDULE, ExecutionThread.BACKGROUND_THREAD);
            executorService = Executors.newSingleThreadExecutor();
        }
    }

    public static class ThreadExecutor extends RunnableExecutor
    {

        private final RunnableExecutor threadScheduler;
        private final ThreadVerify threadVerify;

        public void execute(Runnable runnable)
        {
            static class _cls1
            {

                static final int $SwitchMap$com$amazon$device$ads$ThreadUtils$ExecutionThread[];

                static 
                {
                    $SwitchMap$com$amazon$device$ads$ThreadUtils$ExecutionThread = new int[ExecutionThread.values().length];
                    try
                    {
                        $SwitchMap$com$amazon$device$ads$ThreadUtils$ExecutionThread[ExecutionThread.MAIN_THREAD.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$amazon$device$ads$ThreadUtils$ExecutionThread[ExecutionThread.BACKGROUND_THREAD.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls1..SwitchMap.com.amazon.device.ads.ThreadUtils.ExecutionThread[threadScheduler.getExecutionThread().ordinal()];
            JVM INSTR tableswitch 1 2: default 36
        //                       1 51
        //                       2 71;
               goto _L1 _L2 _L3
_L3:
            break MISSING_BLOCK_LABEL_71;
_L1:
            boolean flag = false;
_L4:
            if (flag)
            {
                threadScheduler.execute(runnable);
                return;
            } else
            {
                runnable.run();
                return;
            }
_L2:
            if (!threadVerify.isOnMainThread())
            {
                flag = true;
            } else
            {
                flag = false;
            }
              goto _L4
            flag = threadVerify.isOnMainThread();
              goto _L4
        }

        public ThreadExecutor(ThreadVerify threadverify, RunnableExecutor runnableexecutor)
        {
            super(ExecutionStyle.RUN_ASAP, runnableexecutor.executionThread);
            threadVerify = threadverify;
            threadScheduler = runnableexecutor;
        }
    }

    public static class ThreadPoolScheduler extends RunnableExecutor
    {

        private static final int keepAliveTimeSeconds = 30;
        private static final int maxNumberThreads = 3;
        private static final int numberThreads = 1;
        private final ExecutorService executorService;

        public void execute(Runnable runnable)
        {
            executorService.submit(runnable);
        }

        public ThreadPoolScheduler()
        {
            super(ExecutionStyle.SCHEDULE, ExecutionThread.BACKGROUND_THREAD);
            executorService = new ThreadPoolExecutor(1, 3, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        }
    }

    public static class ThreadRunner
    {

        private static final String LOGTAG = com/amazon/device/ads/ThreadUtils$ThreadRunner.getSimpleName();
        private final HashMap executors;
        private final MobileAdsLogger logger;

        public void execute(Runnable runnable, ExecutionStyle executionstyle, ExecutionThread executionthread)
        {
            Object obj = (HashMap)executors.get(executionstyle);
            if (obj == null)
            {
                logger.e("No executor available for %s execution style.", new Object[] {
                    executionstyle
                });
                return;
            }
            obj = (RunnableExecutor)((HashMap) (obj)).get(executionthread);
            if (obj == null)
            {
                logger.e("No executor available for %s execution style on % execution thread.", new Object[] {
                    executionstyle, executionthread
                });
            }
            ((RunnableExecutor) (obj)).execute(runnable);
        }

        public transient void executeAsyncTask(ExecutionStyle executionstyle, ExecutionThread executionthread, final MobileAdsAsyncTask task, Object aobj[])
        {
            ThreadUtils.threadRunner.execute(((_cls1) (aobj)). new Runnable() {

                final ThreadRunner this$0;
                final Object val$params[];
                final MobileAdsAsyncTask val$task;

                public void run()
                {
                    AndroidTargetUtils.executeAsyncTask(task, params);
                }

            
            {
                this$0 = final_threadrunner;
                task = mobileadsasynctask;
                params = _5B_Ljava.lang.Object_3B_.this;
                super();
            }
            }, executionstyle, executionthread);
        }

        public transient void executeAsyncTask(MobileAdsAsyncTask mobileadsasynctask, Object aobj[])
        {
            executeAsyncTask(ExecutionStyle.RUN_ASAP, ExecutionThread.MAIN_THREAD, mobileadsasynctask, aobj);
        }

        public ThreadRunner withExecutor(RunnableExecutor runnableexecutor)
        {
            HashMap hashmap1 = (HashMap)executors.get(runnableexecutor.getExecutionStyle());
            HashMap hashmap = hashmap1;
            if (hashmap1 == null)
            {
                hashmap = new HashMap();
                executors.put(runnableexecutor.getExecutionStyle(), hashmap);
            }
            hashmap.put(runnableexecutor.getExecutionThread(), runnableexecutor);
            return this;
        }


        ThreadRunner()
        {
            this(new MobileAdsLoggerFactory());
            ThreadVerify threadverify = new ThreadVerify();
            withExecutor(new ThreadPoolScheduler());
            withExecutor(new BackgroundThreadRunner(threadverify));
            withExecutor(new MainThreadScheduler());
            withExecutor(new MainThreadRunner(threadverify));
        }

        ThreadRunner(MobileAdsLoggerFactory mobileadsloggerfactory)
        {
            executors = new HashMap();
            logger = mobileadsloggerfactory.createMobileAdsLogger(LOGTAG);
        }
    }

    static class ThreadVerify
    {

        private static ThreadVerify instance = new ThreadVerify();

        static ThreadVerify getInstance()
        {
            return instance;
        }

        boolean isOnMainThread()
        {
            return Looper.getMainLooper().getThread() == Thread.currentThread();
        }


        ThreadVerify()
        {
        }
    }


    private static ThreadRunner threadRunner = new ThreadRunner();

    ThreadUtils()
    {
    }

    public static final transient void executeAsyncTask(MobileAdsAsyncTask mobileadsasynctask, Object aobj[])
    {
        threadRunner.executeAsyncTask(ExecutionStyle.RUN_ASAP, ExecutionThread.MAIN_THREAD, mobileadsasynctask, aobj);
    }

    public static final transient void executeAsyncTask(ThreadRunner threadrunner, ExecutionStyle executionstyle, ExecutionThread executionthread, MobileAdsAsyncTask mobileadsasynctask, Object aobj[])
    {
        threadrunner.executeAsyncTask(executionstyle, executionthread, mobileadsasynctask, aobj);
    }

    public static void executeOnMainThread(Runnable runnable)
    {
        executeOnMainThread(runnable, threadRunner);
    }

    public static void executeOnMainThread(Runnable runnable, ThreadRunner threadrunner)
    {
        threadrunner.execute(runnable, ExecutionStyle.RUN_ASAP, ExecutionThread.MAIN_THREAD);
    }

    public static void executeRunnableWithThreadCheck(Runnable runnable)
    {
        executeRunnableWithThreadCheck(runnable, threadRunner);
    }

    public static void executeRunnableWithThreadCheck(Runnable runnable, ThreadRunner threadrunner)
    {
        threadrunner.execute(runnable, ExecutionStyle.RUN_ASAP, ExecutionThread.BACKGROUND_THREAD);
    }

    public static ThreadRunner getThreadRunner()
    {
        return threadRunner;
    }

    public static boolean isOnMainThread()
    {
        return ThreadVerify.getInstance().isOnMainThread();
    }

    public static void scheduleOnMainThread(Runnable runnable)
    {
        scheduleOnMainThread(runnable, threadRunner);
    }

    public static void scheduleOnMainThread(Runnable runnable, ThreadRunner threadrunner)
    {
        threadrunner.execute(runnable, ExecutionStyle.SCHEDULE, ExecutionThread.MAIN_THREAD);
    }

    public static void scheduleRunnable(Runnable runnable)
    {
        scheduleRunnable(runnable, threadRunner);
    }

    public static void scheduleRunnable(Runnable runnable, ThreadRunner threadrunner)
    {
        threadrunner.execute(runnable, ExecutionStyle.SCHEDULE, ExecutionThread.BACKGROUND_THREAD);
    }

    static void setThreadRunner(ThreadRunner threadrunner)
    {
        threadRunner = threadrunner;
    }


}
