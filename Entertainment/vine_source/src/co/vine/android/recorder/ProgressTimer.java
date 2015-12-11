// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.os.Handler;

// Referenced classes of package co.vine.android.recorder:
//            BasicVineRecorder

public class ProgressTimer
{
    public static class ProgressTimerRunnable
        implements Runnable
    {

        private boolean hasNotifiedThreshold;
        private final BasicVineRecorder mController;
        private final Handler mHandler;
        private int mProgress;
        private final int mThresholdMs;
        public volatile boolean run;

        private void exec()
            throws InterruptedException
        {
            BasicVineRecorder basicvinerecorder = mController;
            do
            {
label0:
                {
                    if (run)
                    {
                        long l = System.currentTimeMillis();
                        long l1 = basicvinerecorder.getCurrentDuration();
                        RecordConfigUtils.RecordConfig recordconfig;
                        int i;
                        if (l1 < 0L)
                        {
                            i = (int)(l1 + l);
                        } else
                        {
                            i = (int)l1;
                        }
                        if (i != mProgress)
                        {
                            mProgress = i;
                            basicvinerecorder.postProgressUpdate(mProgress);
                        }
                        if (!hasNotifiedThreshold && basicvinerecorder.isRecordingSegment() && mProgress >= mThresholdMs)
                        {
                            hasNotifiedThreshold = true;
                            mHandler.post(basicvinerecorder. new Runnable() {

                                final ProgressTimerRunnable this$0;
                                final BasicVineRecorder val$controller;

                                public void run()
                                {
                                    controller.onProgressThresholdReached();
                                }

            
            {
                this$0 = final_progresstimerrunnable;
                controller = BasicVineRecorder.this;
                super();
            }
                            });
                        }
                        recordconfig = mController.getConfig();
                        if (recordconfig == null || mProgress < recordconfig.maxDuration)
                        {
                            break label0;
                        }
                        mHandler.post(basicvinerecorder. new Runnable() {

                            final ProgressTimerRunnable this$0;
                            final BasicVineRecorder val$controller;

                            public void run()
                            {
                                controller.onProgressMaxReached();
                            }

            
            {
                this$0 = final_progresstimerrunnable;
                controller = BasicVineRecorder.this;
                super();
            }
                        });
                    }
                    return;
                }
                Thread.sleep(35L);
            } while (true);
        }

        public void run()
        {
            try
            {
                exec();
                return;
            }
            catch (InterruptedException interruptedexception)
            {
                return;
            }
        }

        public ProgressTimerRunnable(BasicVineRecorder basicvinerecorder, Handler handler, int i)
        {
            mProgress = -1;
            run = true;
            mController = basicvinerecorder;
            mHandler = handler;
            mThresholdMs = i;
        }
    }


    private static final int INTERVAL = 35;
    private final ProgressTimerRunnable mTask;
    private final Thread mTaskThread;

    public ProgressTimer(BasicVineRecorder basicvinerecorder, Handler handler, int i)
    {
        mTask = new ProgressTimerRunnable(basicvinerecorder, handler, i);
        mTaskThread = new Thread(mTask);
    }

    public void release()
    {
        mTask.run = false;
        mTaskThread.interrupt();
    }

    public void start()
    {
        mTaskThread.start();
    }
}
