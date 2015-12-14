// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JobScheduler
{
    public static interface JobRunnable
    {

        public abstract void run(EncodedImage encodedimage, boolean flag);
    }

    static class JobStartExecutorSupplier
    {

        private static ScheduledExecutorService sJobStarterExecutor;

        static ScheduledExecutorService get()
        {
            if (sJobStarterExecutor == null)
            {
                sJobStarterExecutor = Executors.newSingleThreadScheduledExecutor();
            }
            return sJobStarterExecutor;
        }

        JobStartExecutorSupplier()
        {
        }
    }

    static final class JobState extends Enum
    {

        private static final JobState $VALUES[];
        public static final JobState IDLE;
        public static final JobState QUEUED;
        public static final JobState RUNNING;
        public static final JobState RUNNING_AND_PENDING;

        public static JobState valueOf(String s)
        {
            return (JobState)Enum.valueOf(com/facebook/imagepipeline/producers/JobScheduler$JobState, s);
        }

        public static JobState[] values()
        {
            return (JobState[])$VALUES.clone();
        }

        static 
        {
            IDLE = new JobState("IDLE", 0);
            QUEUED = new JobState("QUEUED", 1);
            RUNNING = new JobState("RUNNING", 2);
            RUNNING_AND_PENDING = new JobState("RUNNING_AND_PENDING", 3);
            $VALUES = (new JobState[] {
                IDLE, QUEUED, RUNNING, RUNNING_AND_PENDING
            });
        }

        private JobState(String s, int i)
        {
            super(s, i);
        }
    }


    static final String QUEUE_TIME_KEY = "queueTime";
    private final Runnable mDoJobRunnable = new Runnable() {

        final JobScheduler this$0;

        public void run()
        {
            doJob();
        }

            
            {
                this$0 = JobScheduler.this;
                super();
            }
    };
    EncodedImage mEncodedImage;
    private final Executor mExecutor;
    boolean mIsLast;
    private final JobRunnable mJobRunnable;
    long mJobStartTime;
    JobState mJobState;
    long mJobSubmitTime;
    private final int mMinimumJobIntervalMs;
    private final Runnable mSubmitJobRunnable = new Runnable() {

        final JobScheduler this$0;

        public void run()
        {
            submitJob();
        }

            
            {
                this$0 = JobScheduler.this;
                super();
            }
    };

    public JobScheduler(Executor executor, JobRunnable jobrunnable, int i)
    {
        mExecutor = executor;
        mJobRunnable = jobrunnable;
        mMinimumJobIntervalMs = i;
        mEncodedImage = null;
        mIsLast = false;
        mJobState = JobState.IDLE;
        mJobSubmitTime = 0L;
        mJobStartTime = 0L;
    }

    private void doJob()
    {
        long l = SystemClock.uptimeMillis();
        this;
        JVM INSTR monitorenter ;
        Object obj;
        boolean flag;
        obj = mEncodedImage;
        flag = mIsLast;
        mEncodedImage = null;
        mIsLast = false;
        mJobState = JobState.RUNNING;
        mJobStartTime = l;
        this;
        JVM INSTR monitorexit ;
        if (shouldProcess(((EncodedImage) (obj)), flag))
        {
            mJobRunnable.run(((EncodedImage) (obj)), flag);
        }
        EncodedImage.closeSafely(((EncodedImage) (obj)));
        onJobFinished();
        return;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        Exception exception;
        exception;
        EncodedImage.closeSafely(((EncodedImage) (obj)));
        onJobFinished();
        throw exception;
    }

    private void enqueueJob(long l)
    {
        if (l > 0L)
        {
            JobStartExecutorSupplier.get().schedule(mSubmitJobRunnable, l, TimeUnit.MILLISECONDS);
            return;
        } else
        {
            mSubmitJobRunnable.run();
            return;
        }
    }

    private void onJobFinished()
    {
        long l;
        long l1;
        l1 = SystemClock.uptimeMillis();
        l = 0L;
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        if (mJobState != JobState.RUNNING_AND_PENDING)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        l = Math.max(mJobStartTime + (long)mMinimumJobIntervalMs, l1);
        flag = true;
        mJobSubmitTime = l1;
        mJobState = JobState.QUEUED;
_L1:
        this;
        JVM INSTR monitorexit ;
        if (flag)
        {
            enqueueJob(l - l1);
        }
        return;
        mJobState = JobState.IDLE;
          goto _L1
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static boolean shouldProcess(EncodedImage encodedimage, boolean flag)
    {
        return flag || EncodedImage.isValid(encodedimage);
    }

    private void submitJob()
    {
        mExecutor.execute(mDoJobRunnable);
    }

    public void clearJob()
    {
        this;
        JVM INSTR monitorenter ;
        EncodedImage encodedimage;
        encodedimage = mEncodedImage;
        mEncodedImage = null;
        mIsLast = false;
        this;
        JVM INSTR monitorexit ;
        EncodedImage.closeSafely(encodedimage);
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public long getQueuedTime()
    {
        this;
        JVM INSTR monitorenter ;
        long l;
        long l1;
        l = mJobStartTime;
        l1 = mJobSubmitTime;
        this;
        JVM INSTR monitorexit ;
        return l - l1;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean scheduleJob()
    {
        long l1;
        long l2;
        l2 = SystemClock.uptimeMillis();
        l1 = 0L;
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        if (shouldProcess(mEncodedImage, mIsLast))
        {
            break MISSING_BLOCK_LABEL_30;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        boolean flag;
        long l;
        flag = flag1;
        l = l1;
        static class _cls3
        {

            static final int $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[];

            static 
            {
                $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState = new int[JobState.values().length];
                try
                {
                    $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[JobState.IDLE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[JobState.QUEUED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[JobState.RUNNING.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[JobState.RUNNING_AND_PENDING.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls3..SwitchMap.com.facebook.imagepipeline.producers.JobScheduler.JobState[mJobState.ordinal()];
        JVM INSTR tableswitch 1 3: default 145
    //                   1 89
    //                   2 72
    //                   3 129;
           goto _L1 _L2 _L3 _L4
_L3:
        this;
        JVM INSTR monitorexit ;
        if (flag)
        {
            enqueueJob(l - l2);
        }
        return true;
_L2:
        l = Math.max(mJobStartTime + (long)mMinimumJobIntervalMs, l2);
        flag = true;
        mJobSubmitTime = l2;
        mJobState = JobState.QUEUED;
          goto _L3
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L4:
        mJobState = JobState.RUNNING_AND_PENDING;
        flag = flag1;
        l = l1;
          goto _L3
_L1:
        flag = flag1;
        l = l1;
          goto _L3
    }

    public boolean updateJob(EncodedImage encodedimage, boolean flag)
    {
        if (!shouldProcess(encodedimage, flag))
        {
            return false;
        }
        this;
        JVM INSTR monitorenter ;
        EncodedImage encodedimage1;
        encodedimage1 = mEncodedImage;
        mEncodedImage = EncodedImage.cloneOrNull(encodedimage);
        mIsLast = flag;
        this;
        JVM INSTR monitorexit ;
        EncodedImage.closeSafely(encodedimage1);
        return true;
        encodedimage;
        this;
        JVM INSTR monitorexit ;
        throw encodedimage;
    }


}
