// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage.camera;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLSurfaceView;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import bxv;
import bza;
import bzb;
import bzc;
import bzd;
import bze;
import bzf;
import bzg;
import bzh;
import bzi;
import bzj;
import bzk;
import bzl;
import bzq;
import bzv;
import ced;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CameraGLSurfaceView extends GLSurfaceView
    implements android.graphics.SurfaceTexture.OnFrameAvailableListener
{

    private static final float MAX_EXPOSURE_COMPENSATION = 1.5F;
    public static final int MAX_FPS_ALLOW = 25;
    public static final int MAX_PREVIEW_HEIGHT = 1080;
    public static final int MAX_PREVIEW_WIDTH = 1440;
    public static final int MAX_VIDEO_HEIGHT = 600;
    public static final int MAX_VIDEO_WIDTH = 800;
    public static final int MID_PREVIEW_HEIGHT = 720;
    public static final int MID_PREVIEW_WIDTH = 960;
    private static final float MIN_EXPOSURE_COMPENSATION = 0.2F;
    public static final int MIN_FPS_ALLOW = 10;
    public static final int MIN_LIGHT_QUANTITY = 10;
    public static final int MIN_PREVIEW_HEIGHT = 480;
    public static final int MIN_PREVIEW_WIDTH = 640;
    public static final int MIN_VIDEO_HEIGHT = 480;
    public static final int MIN_VIDEO_WIDTH = 640;
    private static final String TAG = "CameraGLSurfaceView";
    public static final Executor mCameraThreadExecutor = Executors.newSingleThreadExecutor();
    private final String CameraFacingSharedPrefStr;
    private final String FirstOpenSharedPrefStr;
    private final String PreviewSizeSharedPrefStr;
    protected ArrayList flashLightList;
    public boolean isFrontFacing;
    public WeakReference mCallbackWeakRef;
    protected Camera mCamera;
    protected EnumCameraCaptureState mCameraCaptureState;
    private boolean mCameraConfiged;
    protected bzk mCameraHandler;
    public int mCameraPreviewHeight;
    public int mCameraPreviewWidth;
    protected Context mContext;
    protected android.hardware.Camera.CameraInfo mCurCameraInfo;
    private int mDesiredPreviewHeight;
    private int mDesiredPreviewWidth;
    private boolean mIsPreviewSaved;
    protected boolean mIsSwitchCamera;
    protected boolean mIsTakingPhoto;
    public ced mRender;
    private int mScreenHeight;
    private int mScreenWidth;
    protected boolean mSoundOn;
    public int mSurfaceContainerHeight;
    public int mSurfaceContainerWidth;
    protected boolean mUseAutoFocus;
    protected android.hardware.Camera.Size takePicSize;

    public CameraGLSurfaceView(Context context)
    {
        super(context);
        PreviewSizeSharedPrefStr = "PreviewSize";
        CameraFacingSharedPrefStr = "CameraFacing";
        FirstOpenSharedPrefStr = "FirstOpen";
        mDesiredPreviewWidth = 960;
        mDesiredPreviewHeight = 720;
        mIsPreviewSaved = false;
        mSurfaceContainerWidth = 640;
        mSurfaceContainerHeight = 640;
        mUseAutoFocus = false;
        isFrontFacing = true;
        mCameraCaptureState = EnumCameraCaptureState.STATE_TAKE_PHOTO;
        mCallbackWeakRef = null;
        flashLightList = new ArrayList();
        mIsSwitchCamera = false;
        mSoundOn = true;
        mIsTakingPhoto = false;
        mCameraHandler = null;
        mCameraConfiged = false;
        mContext = context;
        setDebugFlags(3);
        mCameraHandler = new bzk(this);
        initGLContext();
    }

    public CameraGLSurfaceView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        PreviewSizeSharedPrefStr = "PreviewSize";
        CameraFacingSharedPrefStr = "CameraFacing";
        FirstOpenSharedPrefStr = "FirstOpen";
        mDesiredPreviewWidth = 960;
        mDesiredPreviewHeight = 720;
        mIsPreviewSaved = false;
        mSurfaceContainerWidth = 640;
        mSurfaceContainerHeight = 640;
        mUseAutoFocus = false;
        isFrontFacing = true;
        mCameraCaptureState = EnumCameraCaptureState.STATE_TAKE_PHOTO;
        mCallbackWeakRef = null;
        flashLightList = new ArrayList();
        mIsSwitchCamera = false;
        mSoundOn = true;
        mIsTakingPhoto = false;
        mCameraHandler = null;
        mCameraConfiged = false;
        Log.e("ClassNotFound Test", "CameraGLSurfaceView super() finish");
        mContext = context;
        setDebugFlags(3);
        mCameraHandler = new bzk(this);
        initGLContext();
        Log.e("ClassNotFound Test", "CameraGLSurfaceView initGLContext() finish");
    }

    private void getDesiredPreviewSize()
    {
        int i = mScreenWidth * mScreenHeight;
        if (i <= 0x4b000)
        {
            mDesiredPreviewWidth = 640;
            mDesiredPreviewHeight = 480;
        } else
        if (i >= 0x17bb00)
        {
            mDesiredPreviewWidth = 1440;
            mDesiredPreviewHeight = 1080;
        } else
        {
            mDesiredPreviewWidth = 960;
            mDesiredPreviewHeight = 720;
        }
        Log.e("CameraGLSurfaceView", (new StringBuilder()).append("mDesiredPreviewWidth = ").append(mDesiredPreviewWidth).append(", mDesiredPreviewHeight = ").append(mDesiredPreviewHeight).toString());
    }

    private void initCameraFacing()
    {
        if (mContext == null)
        {
            return;
        } else
        {
            isFrontFacing = mContext.getSharedPreferences("CameraFacing", 0).getBoolean("isFrontFacing", isFrontFacing);
            return;
        }
    }

    private void initGLContext()
    {
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 0, 0);
        getHolder().setFormat(1);
    }

    private void releaseCamera()
    {
        Object obj1;
        if (mCamera != null && mCameraHandler != null)
        {
            synchronized (mCameraHandler.a)
            {
                Log.e("CameraGLSurfaceView", "release Camera");
                mCamera.stopPreview();
                mCamera.setPreviewTexture(null);
                mCamera.setPreviewCallback(null);
                mCamera.release();
                mCameraConfiged = false;
                mCamera = null;
            }
            return;
        } else
        {
            return;
        }
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj1;
        ((Exception) (obj1)).printStackTrace();
        if (mCallbackWeakRef != null && mCallbackWeakRef.get() != null)
        {
            ((bzl)mCallbackWeakRef.get()).a("release camera failed", ((Exception) (obj1)));
        }
        mCamera = null;
        return;
        obj1;
        throw obj1;
    }

    private void saveCameraFacing()
    {
        if (mContext == null)
        {
            return;
        } else
        {
            android.content.SharedPreferences.Editor editor = mContext.getSharedPreferences("CameraFacing", 0).edit();
            editor.putBoolean("isFrontFacing", isFrontFacing);
            editor.commit();
            return;
        }
    }

    public static void setBestExposure(android.hardware.Camera.Parameters parameters, boolean flag)
    {
        int i = parameters.getMinExposureCompensation();
        int j = parameters.getMaxExposureCompensation();
        float f1 = parameters.getExposureCompensationStep();
        if ((i != 0 || j != 0) && f1 > 0.0F)
        {
            float f;
            int k;
            if (flag)
            {
                f = 0.2F;
            } else
            {
                f = 1.5F;
            }
            k = Math.round(f / f1);
            f = f1 * (float)k;
            i = Math.max(Math.min(k, j), i);
            if (parameters.getExposureCompensation() == i)
            {
                Log.i("CameraGLSurfaceView", (new StringBuilder()).append("Exposure compensation already set to ").append(i).append(" / ").append(f).toString());
                return;
            } else
            {
                Log.i("CameraGLSurfaceView", (new StringBuilder()).append("Setting exposure compensation to ").append(i).append(" / ").append(f).toString());
                parameters.setExposureCompensation(i);
                return;
            }
        } else
        {
            Log.i("CameraGLSurfaceView", "Camera does not support exposure compensation");
            return;
        }
    }

    public boolean adjustPreviewForFps(boolean flag)
    {
        boolean flag1 = true;
        if (!flag) goto _L2; else goto _L1
_L1:
        mDesiredPreviewHeight;
        JVM INSTR lookupswitch 3: default 44
    //                   480: 56
    //                   720: 75
    //                   1080: 94;
           goto _L3 _L4 _L5 _L6
_L3:
        flag = false;
_L7:
        if (flag)
        {
            savePreviewSize();
        }
        return flag;
_L4:
        mDesiredPreviewHeight = 720;
        mDesiredPreviewWidth = 960;
        flag = flag1;
        continue; /* Loop/switch isn't completed */
_L5:
        mDesiredPreviewHeight = 1080;
        mDesiredPreviewWidth = 1440;
        flag = flag1;
        continue; /* Loop/switch isn't completed */
_L6:
        flag = false;
        if (true) goto _L7; else goto _L2
_L2:
        switch (mDesiredPreviewHeight)
        {
        default:
            flag = false;
            break;

        case 1080: 
            mDesiredPreviewHeight = 720;
            mDesiredPreviewWidth = 960;
            flag = flag1;
            break;

        case 720: 
            mDesiredPreviewHeight = 480;
            mDesiredPreviewWidth = 640;
            flag = flag1;
            break;

        case 480: 
            flag = false;
            break;
        }
        if (true) goto _L7; else goto _L8
_L8:
    }

    public Camera getCamera()
    {
        return mCamera;
    }

    public bzl getCameraCallback()
    {
        if (mCallbackWeakRef != null)
        {
            return (bzl)mCallbackWeakRef.get();
        } else
        {
            return null;
        }
    }

    public android.hardware.Camera.CameraInfo getCameraInfo()
    {
        return mCurCameraInfo;
    }

    public EnumCameraCaptureState getCaptureState()
    {
        return mCameraCaptureState;
    }

    public int getDesiredHeight()
    {
        return mDesiredPreviewHeight;
    }

    public int getDesiredWidth()
    {
        return mDesiredPreviewWidth;
    }

    protected void getExPreviewSize()
    {
        if (mContext == null)
        {
            return;
        } else
        {
            SharedPreferences sharedpreferences = mContext.getSharedPreferences("PreviewSize", 0);
            mDesiredPreviewWidth = sharedpreferences.getInt("Width", 0);
            mDesiredPreviewHeight = sharedpreferences.getInt("Height", 0);
            mIsPreviewSaved = sharedpreferences.getBoolean("PreViewSaved", false);
            return;
        }
    }

    public ArrayList getFlashLightList()
    {
        return flashLightList;
    }

    public boolean getIsTakingPhoto()
    {
        return mIsTakingPhoto;
    }

    public int getPreviewHeight()
    {
        return mCameraPreviewHeight;
    }

    public int getPreviewWidth()
    {
        return mCameraPreviewWidth;
    }

    public ced getRender()
    {
        return mRender;
    }

    protected android.hardware.Camera.ShutterCallback getShuttercallack()
    {
        if (mSoundOn)
        {
            return new bzi(this);
        } else
        {
            return null;
        }
    }

    public android.hardware.Camera.Size getTakePicSize()
    {
        return takePicSize;
    }

    public void initCamFlashModes()
    {
        android.hardware.Camera.Parameters parameters;
        if (mCallbackWeakRef == null)
        {
            return;
        }
        flashLightList.clear();
        if (mCamera == null && mCallbackWeakRef != null && mCallbackWeakRef.get() != null)
        {
            ((bzl)mCallbackWeakRef.get()).c();
            return;
        }
        parameters = mCamera.getParameters();
        if (parameters == null)
        {
            ((bzl)mCallbackWeakRef.get()).c();
            Log.e("CameraGLSurfaceView", "camera getParameters return null");
            return;
        }
        if (parameters.getSupportedFlashModes() == null)
        {
            ((bzl)mCallbackWeakRef.get()).c();
            Log.e("CameraGLSurfaceView", "camera getSupportedFlashModes return null");
            return;
        }
        if (parameters.getSupportedFlashModes().contains("off"))
        {
            flashLightList.add("off");
        }
        if (mCameraCaptureState != EnumCameraCaptureState.STATE_CONTINUOUS_PHOTO && mCameraCaptureState != EnumCameraCaptureState.STATE_TAKE_PHOTO) goto _L2; else goto _L1
_L1:
        if (parameters.getSupportedFlashModes().contains("on"))
        {
            flashLightList.add("on");
        }
        if (parameters.getSupportedFlashModes().contains("auto"))
        {
            flashLightList.add("auto");
        }
_L4:
        ((bzl)mCallbackWeakRef.get()).c();
        return;
_L2:
        if (parameters.getSupportedFlashModes().contains("torch"))
        {
            flashLightList.add("torch");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void initCameraPara(int i, int j, EnumCameraCaptureState enumcameracapturestate, EnumPreviewRatio enumpreviewratio)
    {
        initCameraPreviewSize(i, j);
        mCameraCaptureState = enumcameracapturestate;
    }

    public void initCameraPreviewSize(int i, int j)
    {
        getExPreviewSize();
        if (mIsPreviewSaved)
        {
            return;
        } else
        {
            mScreenWidth = i;
            mScreenHeight = j;
            getDesiredPreviewSize();
            return;
        }
    }

    public boolean isFrontFacing()
    {
        return isFrontFacing;
    }

    public void onCameraSetUp(Camera camera, Executor executor)
    {
        bzq bzq1 = new bzq();
        bzq1.a(this, camera, executor);
        mRender.a(bzq1);
    }

    public void onFrameAvailable(SurfaceTexture surfacetexture)
    {
        requestRender();
    }

    public void openCamera(int i, int j, int k)
    {
        boolean flag;
        boolean flag1;
        flag1 = true;
        flag = true;
        if (mCamera == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        SystemClock.sleep(100L);
        mCurCameraInfo = new android.hardware.Camera.CameraInfo();
        Log.e("CameraGLSurfaceView", "camera open start");
        j = Camera.getNumberOfCameras();
        if (j != 1) goto _L4; else goto _L3
_L3:
        Camera.getCameraInfo(0, mCurCameraInfo);
        if (mCameraHandler != null)
        {
            synchronized (mCameraHandler.a)
            {
                mCamera = Camera.open(0);
            }
        }
        if (mCurCameraInfo.facing != 1)
        {
            flag = false;
        }
        isFrontFacing = flag;
_L6:
        if (mCamera == null)
        {
            if (mCallbackWeakRef != null && mCallbackWeakRef.get() != null)
            {
                ((bzl)mCallbackWeakRef.get()).a("camera open failed", null);
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_436;
        exception2;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception2;
        }
        catch (Exception exception)
        {
            if (mCallbackWeakRef != null && mCallbackWeakRef.get() != null)
            {
                ((bzl)mCallbackWeakRef.get()).a("camera open failed", exception);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        i = 0;
_L8:
        if (i >= j) goto _L6; else goto _L5
_L5:
        try
        {
            Camera.getCameraInfo(i, mCurCameraInfo);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            if (mCallbackWeakRef != null && mCallbackWeakRef.get() != null)
            {
                ((bzl)mCallbackWeakRef.get()).a((new StringBuilder()).append("camera getinfo ").append(String.valueOf(i)).toString(), ((Exception) (obj1)));
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (mCurCameraInfo.facing != k)
        {
            break MISSING_BLOCK_LABEL_429;
        }
        Log.e("CameraGLSurfaceView", (new StringBuilder()).append("camera open:").append(i).toString());
        synchronized (mCameraHandler.a)
        {
            mCamera = Camera.open(i);
        }
        if (k == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        isFrontFacing = flag;
          goto _L6
_L7:
        try
        {
            throw exception3;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
        if (mCallbackWeakRef != null && mCallbackWeakRef.get() != null)
        {
            ((bzl)mCallbackWeakRef.get()).a((new StringBuilder()).append("camera open failed ").append(String.valueOf(i)).toString(), ((Exception) (obj1)));
            return;
        }
        continue; /* Loop/switch isn't completed */
        exception3;
        obj1;
        JVM INSTR monitorexit ;
          goto _L7
        i++;
          goto _L8
        setCameraParam(mDesiredPreviewWidth, mDesiredPreviewHeight);
        initCamFlashModes();
        onCameraSetUp(mCamera, mCameraThreadExecutor);
        return;
        Exception exception1;
        exception1;
        if (mCallbackWeakRef != null && mCallbackWeakRef.get() != null)
        {
            ((bzl)mCallbackWeakRef.get()).a("camera setparams failed", exception1);
            return;
        }
        if (true) goto _L1; else goto _L9
_L9:
    }

    public void pauseAll()
    {
        stopCamera();
    }

    public void restartCamera()
    {
        mIsTakingPhoto = false;
        releaseCamera();
        queueEvent(new bzb(this));
        onPause();
        if (isFrontFacing)
        {
            openCamera(mDesiredPreviewWidth, mDesiredPreviewHeight, 1);
        } else
        {
            openCamera(mDesiredPreviewWidth, mDesiredPreviewHeight, 0);
        }
        if (mCamera == null)
        {
            return;
        } else
        {
            onResume();
            return;
        }
    }

    public void restartCameraPreview()
    {
        if (mCamera != null && mCameraHandler != null)
        {
            synchronized (mCameraHandler.a)
            {
                mCamera.startPreview();
                mIsTakingPhoto = false;
            }
            return;
        } else
        {
            return;
        }
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void resumeAll()
    {
        if (isFrontFacing)
        {
            openCamera(mDesiredPreviewWidth, mDesiredPreviewHeight, 1);
        } else
        {
            openCamera(mDesiredPreviewWidth, mDesiredPreviewHeight, 0);
        }
        if (mCamera == null)
        {
            return;
        } else
        {
            onResume();
            queueEvent(new bze(this));
            return;
        }
    }

    protected void savePreviewSize()
    {
        if (mContext == null)
        {
            return;
        } else
        {
            android.content.SharedPreferences.Editor editor = mContext.getSharedPreferences("PreviewSize", 0).edit();
            editor.putInt("Width", mDesiredPreviewWidth);
            editor.putInt("Height", mDesiredPreviewHeight);
            editor.putBoolean("PreViewSaved", true);
            editor.commit();
            return;
        }
    }

    public void setCameraCallBack(bzl bzl1)
    {
        mCallbackWeakRef = new WeakReference(bzl1);
        if (mRender == null)
        {
            return;
        } else
        {
            queueEvent(new bza(this, bzl1));
            return;
        }
    }

    public void setCameraFlashlight(String s)
    {
        if (mCamera == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        android.hardware.Camera.Parameters parameters = mCamera.getParameters();
        parameters.setFlashMode(s);
        mCamera.setParameters(parameters);
        return;
        s;
    }

    public void setCameraOrientation(Context context, android.hardware.Camera.Parameters parameters, int i)
    {
        android.hardware.Camera.CameraInfo camerainfo;
        boolean flag;
        flag = false;
        camerainfo = new android.hardware.Camera.CameraInfo();
        Camera.getCameraInfo(i, camerainfo);
        i = ((flag) ? 1 : 0);
        ((Activity)context).getWindowManager().getDefaultDisplay().getRotation();
        JVM INSTR tableswitch 0 3: default 68
    //                   0 71
    //                   1 91
    //                   2 97
    //                   3 104;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i = ((flag) ? 1 : 0);
_L7:
        parameters.setRotation(((camerainfo.orientation - i) + 360) % 360);
        return;
_L3:
        i = 90;
        continue; /* Loop/switch isn't completed */
_L4:
        i = 180;
        continue; /* Loop/switch isn't completed */
_L5:
        i = 270;
        if (true) goto _L7; else goto _L6
_L6:
    }

    protected void setCameraParam(int i, int j)
    {
        while (mCamera == null || mCameraConfiged) 
        {
            return;
        }
        android.hardware.Camera.Parameters parameters = mCamera.getParameters();
        if (mUseAutoFocus && android.os.Build.VERSION.SDK_INT >= 14 && parameters.getSupportedFocusModes() != null && parameters.getSupportedFocusModes().contains("continuous-picture"))
        {
            parameters.setFocusMode("continuous-picture");
        }
        if (parameters.getSupportedWhiteBalance() != null && parameters.getSupportedWhiteBalance().contains("auto"))
        {
            parameters.setWhiteBalance("auto");
            Log.d("CameraGLSurfaceView", "white balance auto");
        }
        if (parameters.getSupportedFlashModes() != null && parameters.getSupportedFlashModes().contains("auto"))
        {
            parameters.setFlashMode("auto");
            Log.d("CameraGLSurfaceView", "flash mode auto");
        }
        if (parameters.getSupportedSceneModes() != null && parameters.getSupportedSceneModes().contains("auto"))
        {
            parameters.setSceneMode("auto");
            Log.d("CameraGLSurfaceView", "scene mode auto");
        }
        android.hardware.Camera.Size size = bzv.a(parameters.getSupportedPreviewSizes(), i, j);
        parameters.setPreviewSize(size.width, size.height);
        mCameraPreviewWidth = size.width;
        mCameraPreviewHeight = size.height;
        Log.e("CameraGLSurfaceView", (new StringBuilder()).append("previewSize width=").append(size.width).append(", height=").append(size.height).toString());
        queueEvent(new bzh(this));
        float f = bxv.a(mContext);
        if (f < 0.7F)
        {
            takePicSize = bzv.a(parameters.getSupportedPictureSizes(), i, j);
        } else
        if (f > 0.7F && f < 1.7F)
        {
            takePicSize = bzv.a(parameters.getSupportedPictureSizes(), i * 2, j * 2);
        } else
        if (f > 1.7F)
        {
            takePicSize = bzv.a(parameters.getSupportedPictureSizes(), i * 3, j * 3);
        }
        if (mCameraCaptureState == EnumCameraCaptureState.STATE_CONTINUOUS_PHOTO)
        {
            if ((double)f < 1.5D)
            {
                takePicSize = bzv.a(parameters.getSupportedPictureSizes(), i, j);
            } else
            {
                takePicSize = bzv.a(parameters.getSupportedPictureSizes(), (int)((double)i * 1.5D), (int)((double)j * 1.5D));
            }
        }
        if (takePicSize != null)
        {
            String s = "";
            for (i = 0; i < parameters.getSupportedPictureSizes().size(); i++)
            {
                android.hardware.Camera.Size size1 = (android.hardware.Camera.Size)parameters.getSupportedPictureSizes().get(i);
                s = (new StringBuilder()).append(s).append("  picsize").append(i).append(":").append(size1.width).append(",").append(size1.height).toString();
            }

            parameters.setPictureSize(takePicSize.width, takePicSize.height);
        }
        mCamera.setParameters(parameters);
        mCameraConfiged = true;
    }

    public void setCameraParamSafe(int i, int j)
    {
        setCameraParam(i, j);
_L1:
        return;
        Exception exception;
        exception;
        if (mCallbackWeakRef != null && mCallbackWeakRef.get() != null)
        {
            ((bzl)mCallbackWeakRef.get()).a("camera setparams failed", exception);
            return;
        }
          goto _L1
    }

    public void setCaptureState(EnumCameraCaptureState enumcameracapturestate)
    {
        mCameraCaptureState = enumcameracapturestate;
    }

    public void setDesiredPreviewSize(int i, int j)
    {
        mDesiredPreviewWidth = i;
        mDesiredPreviewWidth = j;
    }

    public void setIsSwitchCamera(boolean flag)
    {
        mIsSwitchCamera = flag;
    }

    public void setIsTakingPhoto(boolean flag)
    {
        mIsTakingPhoto = flag;
    }

    public void setRenderer(android.opengl.GLSurfaceView.Renderer renderer)
    {
        super.setRenderer(renderer);
        setRenderMode(0);
        mRender = (ced)renderer;
    }

    public void setScreenSize(int i, int j)
    {
        mScreenWidth = i;
        mScreenHeight = j;
    }

    public void setSoundOn(boolean flag)
    {
        mSoundOn = flag;
    }

    public void setSurfaceContainerSize(int i, int j)
    {
        mSurfaceContainerWidth = i;
        mSurfaceContainerHeight = j;
        if (mRender == null)
        {
            return;
        } else
        {
            queueEvent(new bzc(this, i, j));
            return;
        }
    }

    public void setUseAutoFocus(boolean flag)
    {
        mUseAutoFocus = flag;
    }

    public void startCamera()
    {
        if (isFrontFacing)
        {
            openCamera(mDesiredPreviewWidth, mDesiredPreviewHeight, 1);
        } else
        {
            openCamera(mDesiredPreviewWidth, mDesiredPreviewHeight, 0);
        }
        if (mCamera == null)
        {
            return;
        } else
        {
            onResume();
            return;
        }
    }

    public void startPreview()
    {
        if (mCamera != null)
        {
            synchronized (mCameraHandler.a)
            {
                mCamera.startPreview();
            }
            return;
        } else
        {
            return;
        }
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void stopCamera()
    {
        releaseCamera();
        saveCameraFacing();
        queueEvent(new bzd(this));
        onPause();
    }

    public void stopPreview()
    {
        if (mCamera != null)
        {
            synchronized (mCameraHandler.a)
            {
                mCamera.stopPreview();
            }
            return;
        } else
        {
            return;
        }
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void switchCamera()
    {
        mIsSwitchCamera = true;
        releaseCamera();
        queueEvent(new bzf(this));
        onPause();
        boolean flag;
        if (!isFrontFacing)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isFrontFacing = flag;
        if (isFrontFacing)
        {
            openCamera(mDesiredPreviewWidth, mDesiredPreviewHeight, 1);
        } else
        {
            openCamera(mDesiredPreviewWidth, mDesiredPreviewHeight, 0);
        }
        if (mCamera == null)
        {
            return;
        } else
        {
            onResume();
            queueEvent(new bzg(this));
            return;
        }
    }

    public void takePhoto()
    {
        while (mIsTakingPhoto || mCamera == null) 
        {
            return;
        }
        if (mCallbackWeakRef != null && mCallbackWeakRef.get() != null)
        {
            ((bzl)mCallbackWeakRef.get()).b(isFrontFacing);
        }
        mIsTakingPhoto = true;
        try
        {
            android.hardware.Camera.ShutterCallback shuttercallback = getShuttercallack();
            mCamera.takePicture(shuttercallback, null, null, new bzj(this));
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        restartCameraPreview();
    }


    private class EnumCameraCaptureState extends Enum
    {

        private static final EnumCameraCaptureState $VALUES[];
        public static final EnumCameraCaptureState STATE_CONTINOUS_RECORD;
        public static final EnumCameraCaptureState STATE_CONTINUOUS_PHOTO;
        public static final EnumCameraCaptureState STATE_PREPARE_CONTINOUS_RECORD;
        public static final EnumCameraCaptureState STATE_PREPARE_SEPERATE_RECORD;
        public static final EnumCameraCaptureState STATE_SEPERATE_RECORD;
        public static final EnumCameraCaptureState STATE_TAKE_PHOTO;

        public static EnumCameraCaptureState valueOf(String s)
        {
            return (EnumCameraCaptureState)Enum.valueOf(jp/co/cyberagent/android/gpuimage/camera/CameraGLSurfaceView$EnumCameraCaptureState, s);
        }

        public static EnumCameraCaptureState[] values()
        {
            return (EnumCameraCaptureState[])$VALUES.clone();
        }

        static 
        {
            STATE_TAKE_PHOTO = new EnumCameraCaptureState("STATE_TAKE_PHOTO", 0);
            STATE_CONTINUOUS_PHOTO = new EnumCameraCaptureState("STATE_CONTINUOUS_PHOTO", 1);
            STATE_PREPARE_CONTINOUS_RECORD = new EnumCameraCaptureState("STATE_PREPARE_CONTINOUS_RECORD", 2);
            STATE_PREPARE_SEPERATE_RECORD = new EnumCameraCaptureState("STATE_PREPARE_SEPERATE_RECORD", 3);
            STATE_CONTINOUS_RECORD = new EnumCameraCaptureState("STATE_CONTINOUS_RECORD", 4);
            STATE_SEPERATE_RECORD = new EnumCameraCaptureState("STATE_SEPERATE_RECORD", 5);
            $VALUES = (new EnumCameraCaptureState[] {
                STATE_TAKE_PHOTO, STATE_CONTINUOUS_PHOTO, STATE_PREPARE_CONTINOUS_RECORD, STATE_PREPARE_SEPERATE_RECORD, STATE_CONTINOUS_RECORD, STATE_SEPERATE_RECORD
            });
        }

        private EnumCameraCaptureState(String s, int i)
        {
            super(s, i);
        }
    }

}
