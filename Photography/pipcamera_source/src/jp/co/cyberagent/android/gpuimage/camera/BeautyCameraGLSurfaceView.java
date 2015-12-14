// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage.camera;

import ahh;
import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import jp.co.cyberagent.android.gpuimage.Rotation;

// Referenced classes of package jp.co.cyberagent.android.gpuimage.camera:
//            CameraGLSurfaceView

public class BeautyCameraGLSurfaceView extends CameraGLSurfaceView
{

    private CameraGLSurfaceView.EnumPreviewRatio mEnumPreviewRatio;
    android.hardware.Camera.AutoFocusCallback mFocusCallback = new android.hardware.Camera.AutoFocusCallback() {

        final BeautyCameraGLSurfaceView a;

        public void onAutoFocus(boolean flag, Camera camera)
        {
            if (!flag);
        }

            
            {
                a = BeautyCameraGLSurfaceView.this;
                super();
            }
    };
    public int mVideoHeight;
    public int mVideoWidth;

    public BeautyCameraGLSurfaceView(Context context)
    {
        super(context);
        mEnumPreviewRatio = CameraGLSurfaceView.EnumPreviewRatio.Ratio_none;
        mVideoWidth = 800;
        mVideoHeight = 600;
        setRenderer(new ahh(context, mCameraHandler));
    }

    public BeautyCameraGLSurfaceView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mEnumPreviewRatio = CameraGLSurfaceView.EnumPreviewRatio.Ratio_none;
        mVideoWidth = 800;
        mVideoHeight = 600;
        setRenderer(new ahh(context, mCameraHandler));
        Log.e("ClassNotFound Test", "BeautyCameraGLSurfaceView setRenderer() finish");
    }

    public CameraGLSurfaceView.EnumCameraCaptureState getCaptureState()
    {
        return super.getCaptureState();
    }

    public CameraGLSurfaceView.EnumPreviewRatio getPreviewRatio()
    {
        return mEnumPreviewRatio;
    }

    public void resumeAll()
    {
        super.resumeAll();
        updateVideoSize(mEnumPreviewRatio);
    }

    public void setCaptureState(CameraGLSurfaceView.EnumCameraCaptureState enumcameracapturestate)
    {
        super.setCaptureState(enumcameracapturestate);
        if (mRender instanceof ahh)
        {
            queueEvent(new Runnable(enumcameracapturestate) {

                final CameraGLSurfaceView.EnumCameraCaptureState a;
                final BeautyCameraGLSurfaceView b;

                public void run()
                {
                    ((ahh)b.mRender).a(a);
                }

            
            {
                b = BeautyCameraGLSurfaceView.this;
                a = enumcameracapturestate;
                super();
            }
            });
        }
    }

    public void setFilterLevel(float f)
    {
        if (mRender instanceof ahh)
        {
            queueEvent(new Runnable(f) {

                final float a;
                final BeautyCameraGLSurfaceView b;

                public void run()
                {
                    ((ahh)b.mRender).c(a);
                }

            
            {
                b = BeautyCameraGLSurfaceView.this;
                a = f;
                super();
            }
            });
        }
    }

    public void setFilterType(jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE beautycam_filter_type)
    {
        if (mRender instanceof ahh)
        {
            queueEvent(new Runnable(beautycam_filter_type) {

                final jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE a;
                final BeautyCameraGLSurfaceView b;

                public void run()
                {
                    try
                    {
                        ((ahh)b.mRender).a(a);
                        return;
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                        Crashlytics.logException(exception);
                        return;
                    }
                }

            
            {
                b = BeautyCameraGLSurfaceView.this;
                a = beautycam_filter_type;
                super();
            }
            });
        }
    }

    public void setPreviewRatio(CameraGLSurfaceView.EnumPreviewRatio enumpreviewratio)
    {
        mEnumPreviewRatio = enumpreviewratio;
        if (mRender instanceof ahh)
        {
            queueEvent(new Runnable(enumpreviewratio) {

                final CameraGLSurfaceView.EnumPreviewRatio a;
                final BeautyCameraGLSurfaceView b;

                public void run()
                {
                    ((ahh)b.mRender).a(a);
                }

            
            {
                b = BeautyCameraGLSurfaceView.this;
                a = enumpreviewratio;
                super();
            }
            });
        }
    }

    public void setRotation(Rotation rotation, boolean flag, boolean flag1)
    {
        if ((mRender instanceof ahh) && (mRender instanceof ahh))
        {
            queueEvent(new Runnable(rotation) {

                final Rotation a;
                final BeautyCameraGLSurfaceView b;

                public void run()
                {
                    ((ahh)b.mRender).a(a, true, false);
                }

            
            {
                b = BeautyCameraGLSurfaceView.this;
                a = rotation;
                super();
            }
            });
        }
    }

    public void setSoftVirtualOpen(boolean flag)
    {
        if (mRender instanceof ahh)
        {
            queueEvent(new Runnable(flag) {

                final boolean a;
                final BeautyCameraGLSurfaceView b;

                public void run()
                {
                    ((ahh)b.mRender).c(a);
                }

            
            {
                b = BeautyCameraGLSurfaceView.this;
                a = flag;
                super();
            }
            });
        }
    }

    public void setSoftenLevel(float f)
    {
        if (mRender instanceof ahh)
        {
            queueEvent(new Runnable(f) {

                final float a;
                final BeautyCameraGLSurfaceView b;

                public void run()
                {
                    ((ahh)b.mRender).b(a);
                }

            
            {
                b = BeautyCameraGLSurfaceView.this;
                a = f;
                super();
            }
            });
        }
    }

    public void updateVideoSize(CameraGLSurfaceView.EnumPreviewRatio enumpreviewratio)
    {
        mVideoWidth = mCameraPreviewWidth;
        mVideoHeight = mCameraPreviewHeight;
        if (enumpreviewratio == CameraGLSurfaceView.EnumPreviewRatio.Ratio_one2one)
        {
            mVideoWidth = mVideoHeight;
        }
    }
}
