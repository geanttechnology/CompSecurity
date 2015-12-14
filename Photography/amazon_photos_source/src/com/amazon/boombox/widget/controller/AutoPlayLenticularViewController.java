// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.boombox.widget.controller;

import android.os.Handler;
import com.amazon.boombox.widget.LenticularView;

// Referenced classes of package com.amazon.boombox.widget.controller:
//            LenticularViewController

public class AutoPlayLenticularViewController
    implements LenticularViewController
{
    private class AdvanceFrameRunnable
        implements Runnable
    {

        final AutoPlayLenticularViewController this$0;

        private void advanceFrame()
        {
            if (mLenticularView != null)
            {
                <no variable> = 
// JavaClassFileOutputException: get_constant: invalid tag

        public void run()
        {
            advanceFrame();
            mHandler.postDelayed(mAdvanceFrameRunnable, 600L);
        }

        private AdvanceFrameRunnable()
        {
            this$0 = AutoPlayLenticularViewController.this;
            super();
        }

    }


    private AdvanceFrameRunnable mAdvanceFrameRunnable;
    private Handler mHandler;
    private boolean mIsPlaying;
    private LenticularView mLenticularView;
    private int mTotalRunTime;

    public AutoPlayLenticularViewController()
    {
        mIsPlaying = false;
        mTotalRunTime = 0;
    }

    public void setView(LenticularView lenticularview)
    {
        mLenticularView = lenticularview;
    }

    public void start()
    {
        mHandler = new Handler();
        if (mAdvanceFrameRunnable == null)
        {
            mAdvanceFrameRunnable = new AdvanceFrameRunnable();
        }
        mHandler.post(mAdvanceFrameRunnable);
        mIsPlaying = true;
    }

    public void stop()
    {
        if (!mIsPlaying)
        {
            return;
        }
        if (mHandler != null)
        {
            mHandler.removeCallbacks(mAdvanceFrameRunnable);
        }
        mIsPlaying = false;
        mTotalRunTime = 0;
    }






/*
    static int access$412(AutoPlayLenticularViewController autoplaylenticularviewcontroller, int i)
    {
        i = autoplaylenticularviewcontroller.mTotalRunTime + i;
        autoplaylenticularviewcontroller.mTotalRunTime = i;
        return i;
    }

*/
}
