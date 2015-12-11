// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.os.AsyncTask;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.recorder:
//            BasicVineRecorder, RecordController, CameraSetting

protected class mSwitchCamera extends AsyncTask
{

    private final boolean mSwitchCamera;
    final BasicVineRecorder this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        boolean flag;
        flag = true;
        if (!canSwitchCamera() && (mVideoController.isRecording() || mSwitchCamera))
        {
            break MISSING_BLOCK_LABEL_140;
        }
        System.gc();
        if (!mSwitchCamera)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        avoid = BasicVineRecorder.this;
        if (mFrontFacing)
        {
            flag = false;
        }
        avoid.mFrontFacing = flag;
        if (!mVideoController.openDefaultCamera(mFrontFacing, true))
        {
            break MISSING_BLOCK_LABEL_123;
        }
        avoid = mVideoController.getCameraSetting();
        if (avoid == null)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        mCurrentFrameRate = ((CameraSetting) (avoid)).frameRate;
        start("Switch camera", false, true);
        break MISSING_BLOCK_LABEL_140;
        try
        {
            showCameraFailedToast();
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            SLog.e("Error on cancel camera switching.", avoid);
        }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        mIsSwitchingCamera = false;
    }

    protected void onPreExecute()
    {
        mIsSwitchingCamera = true;
    }

    public (boolean flag)
    {
        this$0 = BasicVineRecorder.this;
        super();
        mSwitchCamera = flag;
    }
}
