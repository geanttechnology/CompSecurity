// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.View;
import co.vine.android.VineNotSupportedException;
import co.vine.android.util.CrashUtil;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.recorder:
//            BasicVineRecorder, RecordController, CameraSetting, ReusableHashAsyncTask, 
//            RecordSession, RecordingFile

protected abstract class mTag extends AsyncTask
{

    public boolean isRunning;
    protected final View mClicker;
    protected long mStartTime;
    protected final String mTag;
    public boolean showDialogDelayed;
    final BasicVineRecorder this$0;

    protected transient RecordingFile doInBackground(Void avoid[])
    {
        RecordController recordcontroller;
        CrashUtil.log("OnResume task started from {}.", new Object[] {
            mTag
        });
        recordcontroller = mVideoController;
        if (recordcontroller != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if (recordcontroller.wasEncodingThreadRunning())
        {
            publishFinishLastSegmentProgress();
            boolean flag;
            try
            {
                recordcontroller.finishLastIfNeeded();
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                CrashUtil.logException(avoid, "Failed to finish last one.", new Object[0]);
            }
            publishStartProgres();
        }
        stopProgressTimer();
        if (!canKeepRecording())
        {
            break MISSING_BLOCK_LABEL_315;
        }
        CrashUtil.log("Async open camera");
        try
        {
            if (!onMakingSureCameraReady(recordcontroller))
            {
                continue; /* Loop/switch isn't completed */
            }
            avoid = recordcontroller.getCameraSetting();
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            onDeviceNotSupported(avoid);
            return null;
        }
        if (avoid == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        mCurrentFrameRate = ((CameraSetting) (avoid)).frameRate;
        if (mHashTask != null)
        {
            mHashTask.reset();
        }
        startProgressTimer();
        CrashUtil.log("Open camera successful: {} fps.", new Object[] {
            Integer.valueOf(mCurrentFrameRate)
        });
        if (mSession == null) goto _L1; else goto _L3
_L3:
        avoid = mSession.getConfig();
_L7:
        if (recordcontroller == null || avoid == null) goto _L1; else goto _L4
_L4:
        if (mCurrentDuration >= (long)((ion) (avoid)).maxDuration || recordcontroller.isAudioReady()) goto _L1; else goto _L5
_L5:
        SLog.d((new StringBuilder()).append("Wait for audio to be ready. ").append(this).toString());
        flag = isCancelled();
        if (flag) goto _L1; else goto _L6
_L6:
        try
        {
            Thread.sleep(100L);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[]) { }
        if (mSession == null)
        {
            break MISSING_BLOCK_LABEL_283;
        }
        avoid = mSession.getConfig();
_L8:
        recordcontroller = mVideoController;
          goto _L7
        avoid = null;
          goto _L8
        if (isCancelled()) goto _L1; else goto _L9
_L9:
        showCameraFailedToast();
        return null;
        avoid = mActivity;
        if (mHashTask != null && mHashTask.isComplete() && avoid != null)
        {
            avoid.finish();
            return null;
        }
        if (mHashTask != null && mHashTask.getComputedFile() != null)
        {
            return mHashTask.getComputedFile();
        } else
        {
            startHashTask(false);
            return null;
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected boolean onMakingSureCameraReady(RecordController recordcontroller)
        throws VineNotSupportedException
    {
        return recordcontroller.openDefaultCamera(mFrontFacing, false);
    }

    protected void onPostExecute(RecordingFile recordingfile)
    {
        isRunning = false;
        if (mClicker != null)
        {
            mClicker.setEnabled(true);
        }
        if (recordingfile != null)
        {
            mHashTask.resumeAll();
        }
        long l = System.currentTimeMillis() - mStartTime;
        if (l > BasicVineRecorder.sTimeTaken)
        {
            BasicVineRecorder.sTimeTaken = l;
        }
        SLog.d("OnResumeTask took {}ms.", Long.valueOf(l));
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((RecordingFile)obj);
    }

    protected void onPreExecute()
    {
        mStartTime = System.currentTimeMillis();
        if (mClicker != null)
        {
            mClicker.setEnabled(false);
        }
        if (canKeepRecording() && !mVideoController.isRecordingStarted() && !isCancelled())
        {
            try
            {
                if (showDialogDelayed)
                {
                    isRunning = true;
                }
            }
            catch (android.view. ) { }
        }
        SLog.d("OnResume PreExecute took {}ms.", Long.valueOf(System.currentTimeMillis() - mStartTime));
    }

    protected abstract void publishFinishLastSegmentProgress();

    protected abstract void publishStartProgres();

    public (View view, String s)
    {
        this$0 = BasicVineRecorder.this;
        super();
        mClicker = view;
        mTag = s;
    }
}
