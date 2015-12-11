// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.Log;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            CameraPreview

public class FocusingCameraPreview extends CameraPreview
{

    private String mFocusMode;
    private boolean mFocusing;
    private int mFramesTilNextFocus;
    private Date mLastFocus;
    private boolean mSupportsContinuousFocus;

    public FocusingCameraPreview(Context context)
    {
        super(context);
        mFocusMode = "auto";
        mSupportsContinuousFocus = false;
    }

    private void checkFocus()
    {
        if (!mSupportsContinuousFocus && !mFocusing)
        {
            int i = mFramesTilNextFocus - 1;
            mFramesTilNextFocus = i;
            if (i < 0 && (mLastFocus == null || (new Date()).getTime() - mLastFocus.getTime() > 3000L))
            {
                focus();
            }
        }
    }

    private void focus()
    {
        if (mCamera == null)
        {
            return;
        }
        mFocusing = true;
        try
        {
            if (mSupportsContinuousFocus)
            {
                android.hardware.Camera.Parameters parameters = mCamera.getParameters();
                parameters.setFocusMode(mFocusMode);
                mCamera.setParameters(parameters);
            }
            mCamera.autoFocus(new android.hardware.Camera.AutoFocusCallback() {

                final FocusingCameraPreview this$0;

                public void onAutoFocus(boolean flag, Camera camera)
                {
                    if (mCamera != null)
                    {
                        mFocusing = false;
                        mFramesTilNextFocus = 3;
                        mLastFocus = new Date();
                        if (mSupportsContinuousFocus)
                        {
                            try
                            {
                                mCamera.cancelAutoFocus();
                                camera = mCamera.getParameters();
                                camera.setFocusMode("continuous-picture");
                                mCamera.setParameters(camera);
                                setFocusArea();
                                return;
                            }
                            // Misplaced declaration of an exception variable
                            catch (Camera camera)
                            {
                                Log.e("FocusingCameraPreview", (new StringBuilder()).append("Error to set continuse-picture after autoFocus:").append(camera.getMessage()).toString());
                            }
                            return;
                        }
                    }
                }

            
            {
                this$0 = FocusingCameraPreview.this;
                super();
            }
            });
            return;
        }
        catch (Exception exception)
        {
            Log.e("FocusingCameraPreview", (new StringBuilder()).append("Error autoFocus:").append(exception.getMessage()).toString());
        }
        mFocusing = false;
    }

    private void setFocusArea()
    {
        android.hardware.Camera.Parameters parameters;
        parameters = mCamera.getParameters();
        if (android.os.Build.VERSION.SDK_INT < 14 || parameters.getMaxNumFocusAreas() <= 0)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        ArrayList arraylist = new ArrayList();
        arraylist.add(new android.hardware.Camera.Area(new Rect(-150, -250, 150, 250), 1000));
        parameters.setFocusAreas(arraylist);
        mCamera.setParameters(parameters);
        return;
        Exception exception;
        exception;
        parameters.setFocusAreas(null);
        return;
    }

    public void focusOnClick()
    {
        if (!mFocusing)
        {
            focus();
        }
    }

    public void onPreviewFrame(byte abyte0[], Camera camera)
    {
        super.onPreviewFrame(abyte0, camera);
        checkFocus();
    }

    protected void startPreview()
    {
        if (mCamera == null)
        {
            return;
        }
        android.hardware.Camera.Parameters parameters = mCamera.getParameters();
        Object obj = parameters.getSupportedFocusModes();
        if (obj != null)
        {
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                String s = (String)((Iterator) (obj)).next();
                if (s.equals("continuous-picture"))
                {
                    mSupportsContinuousFocus = true;
                }
                if (s.equals("macro"))
                {
                    mFocusMode = "macro";
                }
            } while (true);
        }
        if (mSupportsContinuousFocus)
        {
            setFocusArea();
            parameters.setFocusMode("continuous-picture");
            mCamera.setParameters(parameters);
        }
        mFocusing = false;
        mLastFocus = null;
        mFramesTilNextFocus = 0;
        super.startPreview();
    }


/*
    static boolean access$002(FocusingCameraPreview focusingcamerapreview, boolean flag)
    {
        focusingcamerapreview.mFocusing = flag;
        return flag;
    }

*/


/*
    static int access$102(FocusingCameraPreview focusingcamerapreview, int i)
    {
        focusingcamerapreview.mFramesTilNextFocus = i;
        return i;
    }

*/


/*
    static Date access$202(FocusingCameraPreview focusingcamerapreview, Date date)
    {
        focusingcamerapreview.mLastFocus = date;
        return date;
    }

*/


}
