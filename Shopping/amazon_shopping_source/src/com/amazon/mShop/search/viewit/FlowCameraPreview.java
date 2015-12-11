// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.Context;
import android.graphics.Canvas;
import android.hardware.Camera;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;
import java.util.List;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            FocusingCameraPreview, FSECameraActivity, ViewItScreenOverlay

public class FlowCameraPreview extends FocusingCameraPreview
{

    private FSECameraActivity mActivity;
    private List mFSEGraphicList;
    private boolean mScanningSuccess;
    private ViewItScreenOverlay mViewItScreenOverlay;

    public FlowCameraPreview(Context context)
    {
        super(context);
        mScanningSuccess = false;
        mActivity = (FSECameraActivity)context;
        setWillNotDraw(false);
        mViewItScreenOverlay = new ViewItScreenOverlay(mActivity);
    }

    public void drawGraphic(List list)
    {
        mFSEGraphicList = list;
        invalidate();
    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (getHolder() != null && getHolder().getSurfaceFrame() != null)
        {
            mViewItScreenOverlay.drawScreenOverlay(mActivity, canvas, mFSEGraphicList, this, mScanningSuccess);
        }
    }

    public void onPreviewFrame(byte abyte0[], Camera camera)
    {
        long l = SystemClock.uptimeMillis();
        if (mActivity != null)
        {
            mActivity.didReceiveFrame(abyte0, mCameraPreviewSize.height, mCameraPreviewSize.width, 1, mPreviewImageFormat, 0, 0, mRoiWidth, mRoiHeight, l);
        }
        if (mCamera != null)
        {
            mCamera.addCallbackBuffer(abyte0);
        }
_L2:
        super.onPreviewFrame(abyte0, camera);
        return;
        Exception exception;
        exception;
        Log.e("FlowCameraPreview", (new StringBuilder()).append("Error receive frame data from camera:").append(exception.getMessage()).toString());
        if (mCamera != null)
        {
            mCamera.addCallbackBuffer(abyte0);
        }
        if (true) goto _L2; else goto _L1
_L1:
        camera;
        if (mCamera != null)
        {
            mCamera.addCallbackBuffer(abyte0);
        }
        throw camera;
    }

    public void updateSteadyStatus(boolean flag)
    {
        mViewItScreenOverlay.setSteadyStatus(flag);
    }
}
