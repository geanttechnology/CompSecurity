// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.app.Activity;
import android.graphics.Point;
import android.os.Handler;
import android.view.View;
import co.vine.android.VineNotSupportedException;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.recorder:
//            RegularVineRecorder, CameraSetting, ProgressView, RecordController, 
//            RecordSessionVersion, BaseFinishProcessTask

public class InlineVineRecorder extends RegularVineRecorder
{
    public class InlineFinishProcessTask extends BasicVineRecorder.FinishProcessTask
    {

        final InlineVineRecorder this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            SLog.d("Finishing Inline");
            return super.doInBackground(avoid);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            SLog.d("Finishing Inline postExec");
            mProcessingListener.onProcessingFinish();
            mStopping = false;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            SLog.d("Finishing Inline preExec");
            mProcessingListener.onProcessingStart();
        }

        protected transient void onProgressUpdate(Integer ainteger[])
        {
            if (mFinishProgressView != null)
            {
                mFinishProgressView.setProgressRatio((float)ainteger[0].intValue() / 100F);
            }
        }

        protected volatile void onProgressUpdate(Object aobj[])
        {
            onProgressUpdate((Integer[])aobj);
        }

        public InlineFinishProcessTask(String s, Runnable runnable, boolean flag, boolean flag1)
        {
            this$0 = InlineVineRecorder.this;
            super(InlineVineRecorder.this, s, runnable, flag, flag1);
        }
    }

    public static interface ProcessingListener
    {

        public abstract void onProcessingFinish();

        public abstract void onProcessingStart();
    }


    private static long DELAY_WAIT_FOR_EXPOSURE = 350L;
    public static final boolean METHOD_TRACING = false;
    public static long startnanos = 0L;
    private boolean mCameraSuccessfullyOpened;
    private ProgressView mFinishProgressView;
    private final int mFinishProgressViewResourceId;
    private final int mPaddingSize;
    private ProcessingListener mProcessingListener;
    private Runnable mStartRelativeTimeRunnable;
    private boolean mStarted;
    private boolean mStopping;

    public transient InlineVineRecorder(RecordSessionVersion recordsessionversion, Point point, Activity activity, ProcessingListener processinglistener, int i, int j, int k, 
            int l, int i1, int j1, int k1, int l1, int i2, String s, 
            CharSequence acharsequence[])
    {
        super(66, point, activity, j, l, i1, j1, k1, l1, i2, s, true, recordsessionversion, acharsequence);
        mCameraSuccessfullyOpened = false;
        mStopping = false;
        mStartRelativeTimeRunnable = new Runnable() {

            final InlineVineRecorder this$0;

            public void run()
            {
                startRelativeTime();
            }

            
            {
                this$0 = InlineVineRecorder.this;
                super();
            }
        };
        mProcessingListener = processinglistener;
        mPaddingSize = i;
        mFinishProgressViewResourceId = k;
    }

    protected void adjustBoundaries(final CameraSetting topMaskParams)
    {
        if (mActivity != null && topMaskParams != null)
        {
            float f = (float)topMaskParams.originalW / (float)topMaskParams.originalH;
            int i = mSize.x - mPaddingSize * 2;
            int j = (int)((float)i * f);
            if (mTopMaskView != null && mBottomMaskView != null)
            {
                int k = mBottomMaskView.getMeasuredHeight();
                int l = mRootLayoutView.getMeasuredHeight();
                int i1 = mSize.x;
                topMaskParams = (android.widget.RelativeLayout.LayoutParams)mTopMaskView.getLayoutParams();
                topMaskParams.height = l - k - i1;
                final android.widget.RelativeLayout.LayoutParams cameraViewParams = (android.widget.RelativeLayout.LayoutParams)mCameraView.getLayoutParams();
                cameraViewParams.width = i;
                cameraViewParams.height = j;
                cameraViewParams.leftMargin = mPaddingSize;
                mActivity.runOnUiThread(new Runnable() {

                    final InlineVineRecorder this$0;
                    final android.widget.RelativeLayout.LayoutParams val$cameraViewParams;
                    final android.widget.RelativeLayout.LayoutParams val$topMaskParams;

                    public void run()
                    {
                        View view = mTopMaskView;
                        if (view != null)
                        {
                            view.setLayoutParams(topMaskParams);
                        }
                        view = mCameraView;
                        if (view != null)
                        {
                            view.setLayoutParams(cameraViewParams);
                        }
                    }

            
            {
                this$0 = InlineVineRecorder.this;
                topMaskParams = layoutparams;
                cameraViewParams = layoutparams1;
                super();
            }
                });
            }
        }
    }

    public void cancelStartCallback()
    {
        mHandler.removeCallbacks(mStartRelativeTimeRunnable);
    }

    public BaseFinishProcessTask getFinishProcessTask(String s, Runnable runnable, boolean flag, boolean flag1)
    {
        return new InlineFinishProcessTask(s, runnable, flag, flag1);
    }

    public BasicVineRecorder.OnResumeTask getOnResumeTask(View view, String s)
    {
        return new RegularVineRecorder.OnResumeTask(null, s) {

            final InlineVineRecorder this$0;

            protected boolean onMakingSureCameraReady(RecordController recordcontroller)
            {
                return mCameraSuccessfullyOpened;
            }

            
            {
                this$0 = InlineVineRecorder.this;
                super(InlineVineRecorder.this, view, s);
            }
        };
    }

    public void onProgressMaxReached()
    {
        finish("progressMaxReached");
    }

    protected boolean onStop()
    {
        boolean flag;
        if (!mStopping)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mStopping = true;
        return flag;
    }

    public void onUiPaused()
    {
        super.onUiPaused();
        mStopping = false;
    }

    public void onUiResumed(Activity activity, Runnable runnable, boolean flag)
    {
        super.onUiResumed(activity, runnable, flag);
        mFinishProgressView = (ProgressView)activity.findViewById(mFinishProgressViewResourceId);
        if (!flag)
        {
            onResume("UI Resume", false);
        }
    }

    public void openCamera()
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (mVideoController == null) goto _L2; else goto _L1
_L1:
        if (mVideoController.openDefaultCamera(mFrontFacing, false)) goto _L4; else goto _L3
_L3:
        flag = flag1;
        if (!mVideoController.isCameraReady()) goto _L2; else goto _L4
_L2:
        try
        {
            mCameraSuccessfullyOpened = flag;
            return;
        }
        catch (VineNotSupportedException vinenotsupportedexception)
        {
            onDeviceNotSupported(vinenotsupportedexception);
        }
        return;
_L4:
        flag = true;
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void receivedFirstFrameAfterStartingPreview()
    {
        if (mStarted && mCurrentSegment == null)
        {
            long l = System.nanoTime();
            SLog.b("inline launch time: {}ms", Long.valueOf((l - startnanos) / 0xf4240L));
            startnanos = l;
            mStarted = false;
            mHandler.postDelayed(mStartRelativeTimeRunnable, DELAY_WAIT_FOR_EXPOSURE);
        }
    }

    public void setStarted(boolean flag)
    {
        mStarted = flag;
    }

    public void stopRecording(boolean flag)
    {
        cancelStartCallback();
        if (mCurrentSegment != null)
        {
            endRelativeTime();
        }
        if (flag && mVideoController != null)
        {
            mVideoController.stop(true, true);
        }
    }





/*
    static boolean access$202(InlineVineRecorder inlinevinerecorder, boolean flag)
    {
        inlinevinerecorder.mStopping = flag;
        return flag;
    }

*/

}
