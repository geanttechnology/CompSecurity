// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import co.vine.android.util.SystemUtil;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.recorder:
//            BasicVineRecorder, RecordSessionVersion, RecordSession, ProgressView, 
//            BaseFinishProcessTask, RecordingFile

public abstract class RegularVineRecorder extends BasicVineRecorder
    implements android.view.View.OnTouchListener
{
    public class FinishProcessTask extends BasicVineRecorder.FinishProcessTask
    {

        final RegularVineRecorder this$0;

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            mIsHidingFinishProgressDialog = false;
            void1 = mFinishProgressDialog;
            if (void1 != null && void1.isShowing())
            {
                void1.dismiss();
            }
        }

        protected transient void onProgressUpdate(Integer ainteger[])
        {
            ProgressDialog progressdialog = mFinishProgressDialog;
            if (progressdialog != null && progressdialog.isShowing())
            {
                if (mFinishProgressDialogMessage != null && mFinishProgressDialogMessage.length > 2 && ainteger[0].intValue() >= (100 / (mFinishProgressDialogMessage.length - 1)) * mCurrentMessage)
                {
                    if (mCurrentMessage + 1 < mFinishProgressDialogMessage.length)
                    {
                        progressdialog.setMessage(mFinishProgressDialogMessage[mCurrentMessage + 1]);
                    }
                    mCurrentMessage = mCurrentMessage + 1;
                }
                progressdialog.setProgress(ainteger[0].intValue());
            }
        }

        protected volatile void onProgressUpdate(Object aobj[])
        {
            onProgressUpdate((Integer[])aobj);
        }

        public FinishProcessTask(String s, Runnable runnable, boolean flag, boolean flag1)
        {
            this$0 = RegularVineRecorder.this;
            super(RegularVineRecorder.this, s, runnable, flag, flag1);
        }
    }

    protected class OnResumeTask extends BasicVineRecorder.OnResumeTask
    {

        final RegularVineRecorder this$0;

        protected void onPostExecute(RecordingFile recordingfile)
        {
            super.onPostExecute(recordingfile);
            if (mStartProgressDialog != null && !isCancelled())
            {
                mStartProgressDialog.dismiss();
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((RecordingFile)obj);
        }

        protected transient void onProgressUpdate(CharSequence acharsequence[])
        {
            if (mStartProgressDialog != null)
            {
                if (!showDialogDelayed && !mStartProgressDialog.isShowing())
                {
                    mStartProgressDialog.show();
                }
                mStartProgressDialog.setMessage(acharsequence[0]);
            }
        }

        protected volatile void onProgressUpdate(Object aobj[])
        {
            onProgressUpdate((CharSequence[])aobj);
        }

        protected void publishFinishLastSegmentProgress()
        {
            publishProgress(new CharSequence[] {
                mFinishLastSegmentString
            });
        }

        protected void publishStartProgres()
        {
            publishProgress(new CharSequence[] {
                mStartProgressDialogMessage
            });
        }

        public OnResumeTask(View view, String s)
        {
            this$0 = RegularVineRecorder.this;
            super(RegularVineRecorder.this, view, s);
        }
    }

    protected class ResumeCameraAsyncTask extends BasicVineRecorder.ResumeCameraAsyncTask
    {

        final RegularVineRecorder this$0;

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            if (mOpenCameraDialog != null)
            {
                mOpenCameraDialog.dismiss();
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (mOpenCameraDialog != null)
            {
                mOpenCameraDialog.show();
            }
        }

        public ResumeCameraAsyncTask(boolean flag)
        {
            this$0 = RegularVineRecorder.this;
            super(RegularVineRecorder.this, flag);
        }
    }


    private static final String PREF_BOTTOM_MASK_HEIGHT = "bottomMaskHeightPx";
    protected static final float TOUCH_EDGE_BOUNDARY = 0.05F;
    public float density;
    protected int mBottomMaskId;
    protected View mBottomMaskView;
    protected int mCameraFailString;
    protected int mCameraViewResourceId;
    protected String mDeviceNotSupportedString;
    protected CharSequence mFinishLastSegmentString;
    protected ProgressDialog mFinishProgressDialog;
    protected CharSequence mFinishProgressDialogMessage[];
    private boolean mIsHidingFinishProgressDialog;
    protected ProgressDialog mOpenCameraDialog;
    protected CharSequence mOpenCameraResource;
    protected ProgressView mProgressView;
    protected int mProgressViewResourceId;
    protected int mRootLayoutId;
    protected View mRootLayoutView;
    protected Point mSize;
    protected ProgressDialog mStartProgressDialog;
    protected CharSequence mStartProgressDialogMessage;
    protected Toast mToast;
    protected int mTopMaskId;
    protected View mTopMaskView;

    public transient RegularVineRecorder(int i, Point point, Activity activity, int j, int k, int l, int i1, 
            int j1, int k1, int l1, String s, boolean flag, RecordSessionVersion recordsessionversion, CharSequence acharsequence[])
    {
        boolean flag1;
        boolean flag2;
        if (recordsessionversion == RecordSessionVersion.HW)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (recordsessionversion != RecordSessionVersion.SW_WEBM)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        super(i, activity, flag, flag1, flag2);
        mStartProgressDialogMessage = acharsequence[0];
        mFinishProgressDialogMessage = acharsequence;
        mOpenCameraResource = activity.getText(k1);
        mSize = point;
        density = activity.getResources().getDisplayMetrics().density;
        mProgressViewResourceId = j;
        mCameraViewResourceId = k;
        mRootLayoutId = l1;
        mCameraFailString = j1;
        mDeviceNotSupportedString = s;
        mTopMaskId = l;
        mBottomMaskId = i1;
    }

    public static String getBottomMaskHeightPref(boolean flag)
    {
        return (new StringBuilder()).append("bottomMaskHeightPx").append(flag).toString();
    }

    public void changeProgress(long l)
    {
        ProgressView progressview;
label0:
        {
            progressview = mProgressView;
            if (progressview != null && mSession != null)
            {
                progressview.setProgressRatio((float)l / (1.0F * (float)mSession.getConfig().maxDuration));
                if (!SystemUtil.isOnMainThread())
                {
                    break label0;
                }
                progressview.invalidate();
            }
            return;
        }
        progressview.postInvalidate();
    }

    public BaseFinishProcessTask getFinishProcessTask(String s, Runnable runnable, boolean flag, boolean flag1)
    {
        return new FinishProcessTask(s, runnable, flag, flag1);
    }

    protected Runnable getOnDeviceNotSupportedAction()
    {
        return new Runnable() {

            final RegularVineRecorder this$0;

            public void run()
            {
                mHandler.post(new Runnable() {

                    final _cls3 this$1;

                    public void run()
                    {
                        if (mActivity != null)
                        {
                            Toast.makeText(mActivity, mDeviceNotSupportedString, 0).show();
                            mActivity.finish();
                        }
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                });
            }

            
            {
                this$0 = RegularVineRecorder.this;
                super();
            }
        };
    }

    public BasicVineRecorder.OnResumeTask getOnResumeTask(View view, String s)
    {
        return new OnResumeTask(view, s);
    }

    public Point getSize()
    {
        return mSize;
    }

    protected boolean onStop()
    {
        if (mFastEncoding)
        {
            if (!mIsHidingFinishProgressDialog)
            {
                mIsHidingFinishProgressDialog = true;
                return true;
            } else
            {
                SLog.d("Stop twice? wtf.");
                return false;
            }
        }
        final ProgressDialog dialog = mFinishProgressDialog;
        if (dialog != null && !dialog.isShowing())
        {
            mActivity.runOnUiThread(new Runnable() {

                final RegularVineRecorder this$0;
                final ProgressDialog val$dialog;

                public void run()
                {
                    dialog.show();
                }

            
            {
                this$0 = RegularVineRecorder.this;
                dialog = progressdialog;
                super();
            }
            });
            return true;
        } else
        {
            SLog.d("Stop twice? wtf.");
            return false;
        }
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        boolean flag1 = true;
        this;
        JVM INSTR monitorenter ;
        int i = motionevent.getAction();
        if (mCurrentRecordingFile == null || !mEnabled) goto _L2; else goto _L1
_L1:
        boolean flag = mAutoFocusing;
        if (!flag) goto _L4; else goto _L3
_L3:
        i;
        JVM INSTR tableswitch 0 1: default 60
    //                   0 69
    //                   1 132;
           goto _L5 _L6 _L7
_L5:
        flag = flag1;
_L11:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L6:
        float f = motionevent.getAxisValue(0);
        flag = flag1;
        if (f <= 0.05F * (float)mSize.x)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (f >= 0.95F * (float)mSize.x)
        {
            continue; /* Loop/switch isn't completed */
        }
        startRelativeTime();
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        view;
        throw view;
_L7:
        endRelativeTime();
        flag = flag1;
        continue; /* Loop/switch isn't completed */
_L9:
        changeFocusTo(motionevent.getAxisValue(0), motionevent.getAxisValue(1));
        flag = flag1;
        break; /* Loop/switch isn't completed */
_L2:
        flag = false;
        break; /* Loop/switch isn't completed */
_L4:
        switch (i)
        {
        default:
            flag = flag1;
            break; /* Loop/switch isn't completed */

        case 1: // '\001'
            break;
        }
        if (true) goto _L9; else goto _L8
_L8:
        if (true) goto _L11; else goto _L10
_L10:
    }

    public void onUiPaused()
    {
        if (mCameraView != null)
        {
            mCameraView.setOnTouchListener(null);
        }
        try
        {
            if (mFinishProgressDialog != null)
            {
                mFinishProgressDialog.dismiss();
            }
            if (mStartProgressDialog != null)
            {
                mStartProgressDialog.dismiss();
            }
            if (mOpenCameraDialog != null)
            {
                mOpenCameraDialog.dismiss();
            }
        }
        catch (Exception exception)
        {
            SLog.e("It's probably detached already.", exception);
        }
        mStartProgressDialog = null;
        mFinishProgressDialog = null;
        mOpenCameraDialog = null;
        mTopMaskView = null;
        mBottomMaskView = null;
        mProgressView = null;
        mToast = null;
        super.onUiPaused();
    }

    public void onUiResumed(Activity activity, Runnable runnable, boolean flag)
    {
        super.onUiResumed(activity, runnable, flag);
        mFinishProgressDialog = new ProgressDialog(activity, 2);
        mFinishProgressDialog.setMessage(mFinishProgressDialogMessage[1]);
        mFinishProgressDialog.setMax(100);
        mFinishProgressDialog.setCancelable(false);
        mFinishProgressDialog.setIndeterminate(false);
        mFinishProgressDialog.setProgressStyle(1);
        mFinishProgressDialog.setProgressDrawable(activity.getResources().getDrawable(R.drawable.progress_horizontal));
        mStartProgressDialog = new ProgressDialog(activity, 2);
        mOpenCameraDialog = new ProgressDialog(activity, 2);
        mOpenCameraDialog.setMessage(mOpenCameraResource);
        mOpenCameraDialog.setCancelable(false);
        mRootLayoutView = activity.findViewById(mRootLayoutId);
        mCameraView = activity.findViewById(mCameraViewResourceId);
        mCameraView.setVisibility(0);
        mCameraView.setOnTouchListener(this);
        mTopMaskView = activity.findViewById(mTopMaskId);
        mBottomMaskView = activity.findViewById(mBottomMaskId);
        mProgressView = (ProgressView)activity.findViewById(mProgressViewResourceId);
        mCameraView.setOnTouchListener(this);
        mProgressView.setKeepScreenOn(true);
        mToast = Toast.makeText(activity, mCameraFailString, 0);
    }

    protected void showCameraFailedToast()
    {
        mHandler.post(new Runnable() {

            final RegularVineRecorder this$0;

            public void run()
            {
                if (mToast != null)
                {
                    mToast.show();
                }
            }

            
            {
                this$0 = RegularVineRecorder.this;
                super();
            }
        });
    }

    public void stopAndDiscardChanges(String s, Runnable runnable, boolean flag)
    {
        setDiscardChanges(true);
        mFinishProcessRunnable.run(s, flag, false);
        if (runnable != null)
        {
            runnable.run();
        }
    }


/*
    static boolean access$002(RegularVineRecorder regularvinerecorder, boolean flag)
    {
        regularvinerecorder.mIsHidingFinishProgressDialog = flag;
        return flag;
    }

*/
}
