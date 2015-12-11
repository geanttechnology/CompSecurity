// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.photo;

import android.content.Context;
import android.content.res.Resources;
import android.hardware.Camera;
import android.os.SystemClock;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.amazon.mShop.TitleProvider;
import com.amazon.mShop.util.CameraUtils;
import com.amazon.mShop.util.JpegUtils;
import com.amazon.mShop.util.Util;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package com.amazon.mShop.photo:
//            PhotoCaptureActivity

public class PhotoCaptureView extends LinearLayout
    implements android.view.SurfaceHolder.Callback, TitleProvider
{
    private class MyOrientationListener extends OrientationEventListener
    {

        final PhotoCaptureView this$0;

        public void onOrientationChanged(int i)
        {
            if (i != -1)
            {
                mLastKnownOrientation = i;
            }
        }

        public MyOrientationListener(PhotoCaptureActivity photocaptureactivity)
        {
            this$0 = PhotoCaptureView.this;
            super(photocaptureactivity);
        }
    }

    private class MyPictureCallbackJpeg
        implements android.hardware.Camera.PictureCallback
    {

        final PhotoCaptureView this$0;

        public void onPictureTaken(byte abyte0[], Camera camera)
        {
            mPhotoCaptureActivity.handlePhotoTaken(abyte0, mLastKnownOrientation);
        }

        private MyPictureCallbackJpeg()
        {
            this$0 = PhotoCaptureView.this;
            super();
        }

    }


    private Camera mCamera;
    private ImageButton mCancelButton;
    private boolean mIsCameraAutoFocusing;
    private boolean mIsPreviewRunning;
    private int mLastKnownOrientation;
    private long mLastTimeCameraClicked;
    private final MyOrientationListener mOrientationListener;
    private final PhotoCaptureActivity mPhotoCaptureActivity;
    private boolean mPhotoTaken;
    private SurfaceView mSurfaceView;
    private ImageButton mTakeButton;

    public PhotoCaptureView(PhotoCaptureActivity photocaptureactivity)
    {
        super(photocaptureactivity);
        mIsCameraAutoFocusing = false;
        mPhotoTaken = false;
        mLastTimeCameraClicked = -1L;
        mPhotoCaptureActivity = photocaptureactivity;
        LayoutInflater.from(photocaptureactivity).inflate(com.amazon.mShop.android.lib.R.layout.photo_capture_view, this, true);
        FrameLayout framelayout = (FrameLayout)findViewById(com.amazon.mShop.android.lib.R.id.photo_capture_frame);
        inflateMoreView(framelayout);
        LayoutInflater.from(photocaptureactivity).inflate(com.amazon.mShop.android.lib.R.layout.photo_capture_button_layout, framelayout);
        mCancelButton = (ImageButton)findViewById(com.amazon.mShop.android.lib.R.id.photo_capture_cancel);
        mCancelButton.setOnClickListener(new android.view.View.OnClickListener() {

            final PhotoCaptureView this$0;

            public void onClick(View view)
            {
                if (!view.isInTouchMode())
                {
                    doCancelPhoto();
                }
            }

            
            {
                this$0 = PhotoCaptureView.this;
                super();
            }
        });
        mCancelButton.setOnTouchListener(new android.view.View.OnTouchListener() {

            final PhotoCaptureView this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 1)
                {
                    doCancelPhoto();
                }
                return false;
            }

            
            {
                this$0 = PhotoCaptureView.this;
                super();
            }
        });
        mTakeButton = (ImageButton)findViewById(com.amazon.mShop.android.lib.R.id.photo_capture_take);
        mTakeButton.setOnClickListener(new android.view.View.OnClickListener() {

            final PhotoCaptureView this$0;

            public void onClick(View view)
            {
                if (!view.isInTouchMode() && isCameraButtonClickable())
                {
                    doAutoFocus(true);
                }
            }

            
            {
                this$0 = PhotoCaptureView.this;
                super();
            }
        });
        mTakeButton.setOnTouchListener(new android.view.View.OnTouchListener() {

            final PhotoCaptureView this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 1 && isCameraButtonClickable())
                {
                    doAutoFocus(true);
                }
                return false;
            }

            
            {
                this$0 = PhotoCaptureView.this;
                super();
            }
        });
        mTakeButton.requestFocus();
        mSurfaceView = (SurfaceView)findViewById(com.amazon.mShop.android.lib.R.id.photo_capture_preview);
        mSurfaceView.getHolder().setType(3);
        mSurfaceView.getHolder().addCallback(this);
        mLastKnownOrientation = -1;
        mOrientationListener = new MyOrientationListener(photocaptureactivity);
        mOrientationListener.enable();
    }

    private void doCancelPhoto()
    {
        mOrientationListener.disable();
        mPhotoCaptureActivity.handleCancelPhoto();
    }

    private boolean isCameraButtonClickable()
    {
        long l = SystemClock.elapsedRealtime();
        boolean flag;
        if (l - mLastTimeCameraClicked <= 1000L)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        mLastTimeCameraClicked = l;
        return flag;
    }

    void doAutoFocus(final boolean needTakePhotoAfterAutoFocus)
    {
        if (mCamera != null && !mIsCameraAutoFocusing)
        {
            mIsCameraAutoFocusing = true;
            mCamera.autoFocus(new android.hardware.Camera.AutoFocusCallback() {

                final PhotoCaptureView this$0;
                final boolean val$needTakePhotoAfterAutoFocus;

                public void onAutoFocus(boolean flag, Camera camera)
                {
                    mIsCameraAutoFocusing = false;
                    if (needTakePhotoAfterAutoFocus)
                    {
                        doTakePhoto();
                    }
                }

            
            {
                this$0 = PhotoCaptureView.this;
                needTakePhotoAfterAutoFocus = flag;
                super();
            }
            });
        }
    }

    void doTakePhoto()
    {
        if (mCamera != null && !mPhotoTaken)
        {
            mPhotoTaken = true;
            mOrientationListener.disable();
            mSurfaceView.setBackgroundColor(0xff000000);
            mCamera.takePicture(null, null, new MyPictureCallbackJpeg());
            mTakeButton.setEnabled(false);
        }
    }

    public volatile CharSequence getTitle()
    {
        return getTitle();
    }

    public String getTitle()
    {
        return getResources().getString(com.amazon.mShop.android.lib.R.string.photo_capture_view_title);
    }

    protected View inflateMoreView(FrameLayout framelayout)
    {
        return null;
    }

    void release()
    {
        if (mIsPreviewRunning)
        {
            if (mCamera != null)
            {
                mCamera.stopPreview();
            }
            mIsPreviewRunning = false;
        }
        if (mCamera != null)
        {
            mCamera.release();
            mCamera = null;
        }
        mOrientationListener.disable();
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
        if (mCamera == null)
        {
            Log.w("PhotoCaptureView", "Surface changed but no current camera!");
            return;
        }
        if (mIsPreviewRunning)
        {
            mCamera.stopPreview();
            mIsPreviewRunning = false;
        }
        try
        {
            mCamera.setPreviewDisplay(surfaceholder);
        }
        // Misplaced declaration of an exception variable
        catch (SurfaceHolder surfaceholder)
        {
            Log.e("PhotoCaptureView", "surfaceChanged: Failed with IOException", surfaceholder);
        }
        mCamera.startPreview();
        mIsPreviewRunning = true;
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        try
        {
            mCamera = Camera.open();
        }
        // Misplaced declaration of an exception variable
        catch (SurfaceHolder surfaceholder)
        {
            Log.e("PhotoCaptureView", (new StringBuilder()).append("Cannot open camera : ").append(surfaceholder).toString());
            mCamera = null;
        }
        if (mCamera == null)
        {
            surfaceholder = Toast.makeText(mPhotoCaptureActivity, com.amazon.mShop.android.lib.R.string.unavailablity_lack_rare_camera, 1);
            surfaceholder.setGravity(17, 0, 0);
            surfaceholder.show();
            doCancelPhoto();
            return;
        }
        surfaceholder = mCamera.getParameters();
        String s = surfaceholder.get("picture-format-values");
        if (!Util.isEmpty(s) && s.contains("jpeg"))
        {
            surfaceholder.setPictureFormat(256);
        }
        if (Integer.parseInt(android.os.Build.VERSION.SDK) < 5)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        Object obj;
        Method method;
        obj = android/hardware/Camera$Parameters.getField("FLASH_MODE_AUTO");
        method = android/hardware/Camera$Parameters.getMethod("setFlashMode", new Class[] {
            java/lang/String
        });
        int ai[];
        int i;
        int j;
        if (method != null && obj != null)
        {
            try
            {
                method.invoke(surfaceholder, new Object[] {
                    ((Field) (obj)).get(null).toString()
                });
            }
            catch (SecurityException securityexception)
            {
                Log.i("PhotoCaptureView", "Something wrong(SecurityException) setting flashMode", securityexception);
            }
            catch (NoSuchMethodException nosuchmethodexception)
            {
                Log.i("PhotoCaptureView", "Something wrong(NoSuchMethodException) setting flashMode", nosuchmethodexception);
            }
            catch (NoSuchFieldException nosuchfieldexception)
            {
                Log.i("PhotoCaptureView", "Something wrong(NoSuchFieldException) setting flashMode", nosuchfieldexception);
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                Log.i("PhotoCaptureView", "Something wrong(IllegalArgumentException) setting flashMode", illegalargumentexception);
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                Log.i("PhotoCaptureView", "Something wrong(IllegalAccessException) setting flashMode", illegalaccessexception);
            }
            catch (InvocationTargetException invocationtargetexception)
            {
                Log.i("PhotoCaptureView", "Something wrong(InvocationTargetException) setting flashMode", invocationtargetexception);
            }
        }
        obj = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
        i = ((Display) (obj)).getWidth();
        j = ((Display) (obj)).getHeight();
        obj = CameraUtils.getBestMatchedSize(surfaceholder.getSupportedPreviewSizes(), i, j, false);
        if (obj != null)
        {
            surfaceholder.setPreviewSize(((android.hardware.Camera.Size) (obj)).width, ((android.hardware.Camera.Size) (obj)).height);
        }
        ai = JpegUtils.computeWidthAndHeightForMyRawJpegImage();
        ai = CameraUtils.getBestMatchedSize(surfaceholder.getSupportedPictureSizes(), ai[0], ai[1], true);
        if (ai != null)
        {
            surfaceholder.setPictureSize(((android.hardware.Camera.Size) (ai)).width, ((android.hardware.Camera.Size) (ai)).height);
        }
        try
        {
            mCamera.setParameters(surfaceholder);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SurfaceHolder surfaceholder)
        {
            Log.w("PhotoCaptureView", "Camera parameters setting is invalid or not supported!");
        }
        return;
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        release();
    }




/*
    static boolean access$202(PhotoCaptureView photocaptureview, boolean flag)
    {
        photocaptureview.mIsCameraAutoFocusing = flag;
        return flag;
    }

*/



/*
    static int access$402(PhotoCaptureView photocaptureview, int i)
    {
        photocaptureview.mLastKnownOrientation = i;
        return i;
    }

*/

}
