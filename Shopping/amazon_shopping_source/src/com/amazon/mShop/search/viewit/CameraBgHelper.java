// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.a9.cameralibrary.CameraErrorReason;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.util.Util;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            FSECameraActivity, CameraThread, FlowCameraPreview, ViewItPhotoCaptureView

public class CameraBgHelper
{

    public static Object sCameraSyncObject = new Object();
    private FSECameraActivity mActivity;
    private Camera mCamera;
    private int mCameraScreenMarginLeft;
    private CameraThread mCameraThread;
    private FlowCameraPreview mPreview;
    private FrameLayout mPreviewLayout;

    public CameraBgHelper(FSECameraActivity fsecameraactivity)
    {
        mCamera = null;
        mCameraScreenMarginLeft = 0;
        mActivity = fsecameraactivity;
        mPreviewLayout = mActivity.getCameraFrameLayout();
    }

    public static int getActivityOrientation(AmazonActivity amazonactivity)
    {
        switch (getOrientation(amazonactivity))
        {
        default:
            return 1;

        case 0: // '\0'
            return 0;

        case 90: // 'Z'
            return 1;

        case 180: 
            return 8;

        case 270: 
            return 9;
        }
    }

    public static int getOrientation(Context context)
    {
        context = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        context.getOrientation();
        JVM INSTR tableswitch 1 3: default 44
    //                   1 84
    //                   2 91
    //                   3 100;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_100;
_L1:
        char c;
        boolean flag;
        c = 'Z';
        flag = true;
_L5:
        boolean flag1;
        int i;
        if (context.getHeight() > context.getWidth())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        i = c;
        if (flag1 != flag)
        {
            i = (c + 270) % 360;
        }
        return i;
_L2:
        c = '\0';
        flag = false;
          goto _L5
_L3:
        c = '\u010E';
        flag = true;
          goto _L5
        c = '\264';
        flag = false;
          goto _L5
    }

    private boolean openCamera()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (mCamera == null)
        {
            mCameraThread = new CameraThread();
            mCameraThread.start();
            mCameraThread.openCamera();
            try
            {
                mCameraThread.openAwait(10L, TimeUnit.SECONDS);
            }
            catch (InterruptedException interruptedexception) { }
            mCamera = mCameraThread.getCamera();
            if (mCamera == null)
            {
                mActivity.handleCameraError(CameraErrorReason.CAMERA_OBJECT_NULL, "");
            }
            flag = flag1;
            if (mCamera != null)
            {
                flag = true;
            }
        }
        return flag;
    }

    public static void setCameraParameters(Camera camera, android.hardware.Camera.Size size, android.hardware.Camera.PreviewCallback previewcallback)
    {
        android.hardware.Camera.Parameters parameters;
        Object obj;
        parameters = camera.getParameters();
        parameters.setPreviewSize(size.width, size.height);
        parameters.setPreviewFormat(17);
        parameters.setFlashMode("off");
        if (android.os.Build.VERSION.SDK_INT < 9)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        obj = parameters.getSupportedPreviewFpsRange();
        if (Util.isEmpty(((java.util.Collection) (obj))))
        {
            break MISSING_BLOCK_LABEL_121;
        }
        obj = ((List) (obj)).iterator();
        int ai[];
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_121;
            }
            ai = (int[])((Iterator) (obj)).next();
        } while (ai.length != 2 || ai[0] != 30000 || ai[1] != 30000);
        parameters.setPreviewFpsRange(ai[0], ai[1]);
        if (android.os.Build.VERSION.SDK_INT >= 14 && Build.MODEL.equals("Nexus 4"))
        {
            parameters.setRecordingHint(true);
        }
        camera.setParameters(parameters);
        PixelFormat pixelformat = new PixelFormat();
        PixelFormat.getPixelFormatInfo(parameters.getPreviewFormat(), pixelformat);
        int i = (size.width * size.height * pixelformat.bitsPerPixel) / 8;
        camera.addCallbackBuffer(new byte[i]);
        camera.addCallbackBuffer(new byte[i]);
        camera.setPreviewCallbackWithBuffer(previewcallback);
        return;
        camera;
        Log.e("CameraBgHelper", (new StringBuilder()).append("Error set camera parameters, parameter is invalid or not supported:").append(camera.getMessage()).toString());
        return;
    }

    public Point adjustSurfaceSize(FSECameraActivity fsecameraactivity, double d, int i)
    {
        double d1;
        double d2;
        int j;
        boolean flag;
        int k;
        int l;
        int i1;
        boolean flag1;
label0:
        {
            if (i % 180 == 90)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            fsecameraactivity = fsecameraactivity.getWindowManager().getDefaultDisplay();
            if (android.os.Build.VERSION.SDK_INT >= 13)
            {
                Point point = new Point();
                fsecameraactivity.getSize(point);
                j = point.x;
                i = point.y;
            } else
            {
                j = fsecameraactivity.getWidth();
                i = fsecameraactivity.getHeight();
            }
            flag1 = false;
            d2 = (double)j / (double)i;
            if (d2 >= 1.0D || d <= 1.0D)
            {
                d1 = d;
                if (d2 <= 1.0D)
                {
                    break label0;
                }
                d1 = d;
                if (d >= 1.0D)
                {
                    break label0;
                }
            }
            d1 = 1.0D / d;
        }
        if (d2 > d1)
        {
            i1 = (int)((double)j / d1);
            k = j;
            l = ((flag1) ? 1 : 0);
        } else
        if (d2 < d1)
        {
            int j1 = (int)((double)i * d1);
            l = ((flag1) ? 1 : 0);
            i1 = i;
            k = j1;
            if (flag)
            {
                l = j - j1;
                i1 = i;
                k = j1;
            }
        } else
        {
            l = ((flag1) ? 1 : 0);
            i1 = i;
            k = j;
            if (d2 == d1)
            {
                l = ((flag1) ? 1 : 0);
                i1 = i;
                k = j;
            }
        }
        fsecameraactivity = (android.widget.FrameLayout.LayoutParams)mPreviewLayout.getLayoutParams();
        fsecameraactivity.width = k;
        fsecameraactivity.height = i1;
        fsecameraactivity.topMargin = 0;
        fsecameraactivity.leftMargin = l;
        mCameraScreenMarginLeft = l;
        mPreviewLayout.setLayoutParams(fsecameraactivity);
        if (flag)
        {
            return new Point(i1, k);
        } else
        {
            return new Point(k, i1);
        }
    }

    public void drawScanningGraphic(List list)
    {
        if (mPreview != null)
        {
            mPreview.drawGraphic(list);
        }
    }

    public void focusOnClick()
    {
        if (mPreview != null)
        {
            mPreview.focusOnClick();
        }
    }

    public int getCameraScreenMarginLeft()
    {
        return mCameraScreenMarginLeft;
    }

    public boolean isCameraFlashModeOff()
    {
        if (mCamera != null)
        {
            return "off".equals(mCamera.getParameters().getFlashMode());
        } else
        {
            return true;
        }
    }

    public boolean isSupportedFlashTorchMode()
    {
        if (mCamera != null)
        {
            List list = mCamera.getParameters().getSupportedFlashModes();
            if (!Util.isEmpty(list) && list.contains("torch"))
            {
                return true;
            }
        }
        return false;
    }

    public void pause()
    {
        if (mPreview != null)
        {
            mPreview.setIsCameraPaused(true);
            mPreview.stopPreview();
        }
    }

    public boolean setCameraFlashMode(String s)
    {
        if (mCamera == null || Util.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_89;
        }
        android.hardware.Camera.Parameters parameters = mCamera.getParameters();
        List list = parameters.getSupportedFlashModes();
        if (Util.isEmpty(list) || !list.contains(s))
        {
            break MISSING_BLOCK_LABEL_89;
        }
        parameters.setFlashMode(s);
        mCamera.setParameters(parameters);
        return true;
        s;
        Log.e("CameraBgHelper", (new StringBuilder()).append("Camera parameter is invalid or not supported:").append(s.getMessage()).toString());
        return false;
    }

    public void start(int i, int j)
    {
        if (openCamera())
        {
            mPreview = new FlowCameraPreview(mActivity);
            mPreview.setCamera(mCamera);
            mPreview.setIsCameraPaused(false);
            mPreview.setMinHeight(i);
            mPreview.setMaxHeight(j);
            mPreviewLayout.addView(mPreview);
        }
        if (!mActivity.mIsBarcodeScanOnly)
        {
            mActivity.getPhotoCaptureView().updateFlashModeButtonVisibility();
        }
    }

    public void stop()
    {
        if (mCamera != null)
        {
            try
            {
                mCameraThread.releaseCamera();
                mCameraThread.releaseAwait(5L, TimeUnit.SECONDS);
            }
            catch (Exception exception)
            {
                Log.e("CameraBgHelper", (new StringBuilder()).append("Error release camera: ").append(exception.getMessage()).toString());
            }
            mCamera = null;
            if (mPreview != null)
            {
                mPreview.setCamera(null);
            }
        }
        if (mPreview != null && mPreviewLayout != null)
        {
            mPreview.setIsCameraPaused(true);
            mPreviewLayout.removeView(mPreview);
            mPreview = null;
        }
    }

    public boolean switchCameraFlashMode()
    {
        if (mCamera != null)
        {
            if (isCameraFlashModeOff())
            {
                return setCameraFlashMode("torch");
            } else
            {
                return setCameraFlashMode("off");
            }
        } else
        {
            return false;
        }
    }

    public void unpause()
    {
        if (mPreview != null)
        {
            mPreview.setIsCameraPaused(false);
            mPreview.startPreview();
        }
    }

    public void updateSteadyStatus(boolean flag)
    {
        if (mPreview != null)
        {
            mPreview.updateSteadyStatus(flag);
            mPreview.invalidate();
        }
    }

}
