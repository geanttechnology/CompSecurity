// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.os.Handler;

// Referenced classes of package co.vine.android.recorder:
//            ProgressTimer, BasicVineRecorder

public static class mThresholdMs
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
        final BasicVineRecorder controller = mController;
        do
        {
label0:
            {
                if (run)
                {
                    long l = System.currentTimeMillis();
                    long l1 = controller.getCurrentDuration();
                    mThresholdMs mthresholdms;
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
                        controller.postProgressUpdate(mProgress);
                    }
                    if (!hasNotifiedThreshold && controller.isRecordingSegment() && mProgress >= mThresholdMs)
                    {
                        hasNotifiedThreshold = true;
                        mHandler.post(new Runnable() {

                            final ProgressTimer.ProgressTimerRunnable this$0;
                            final BasicVineRecorder val$controller;

                            public void run()
                            {
                                controller.onProgressThresholdReached();
                            }

            
            {
                this$0 = ProgressTimer.ProgressTimerRunnable.this;
                controller = basicvinerecorder;
                super();
            }
                        });
                    }
                    mthresholdms = mController.getConfig();
                    if (mthresholdms == null || mProgress < mthresholdms.ration)
                    {
                        break label0;
                    }
                    mHandler.post(new Runnable() {

                        final ProgressTimer.ProgressTimerRunnable this$0;
                        final BasicVineRecorder val$controller;

                        public void run()
                        {
                            controller.onProgressMaxReached();
                        }

            
            {
                this$0 = ProgressTimer.ProgressTimerRunnable.this;
                controller = basicvinerecorder;
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

    public _cls2.val.controller(BasicVineRecorder basicvinerecorder, Handler handler, int i)
    {
        mProgress = -1;
        run = true;
        mController = basicvinerecorder;
        mHandler = handler;
        mThresholdMs = i;
    }
}
