// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage.camera;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import bys;
import byt;
import byu;
import byv;
import byw;
import byx;
import byy;
import byz;
import cee;
import jp.co.cyberagent.android.gpuimage.Rotation;

// Referenced classes of package jp.co.cyberagent.android.gpuimage.camera:
//            CameraGLSurfaceView

public class BeautyCameraGLSurfaceView extends CameraGLSurfaceView
{

    private CameraGLSurfaceView.EnumPreviewRatio mEnumPreviewRatio;
    android.hardware.Camera.AutoFocusCallback mFocusCallback;
    public int mVideoHeight;
    public int mVideoWidth;

    public BeautyCameraGLSurfaceView(Context context)
    {
        super(context);
        mEnumPreviewRatio = CameraGLSurfaceView.EnumPreviewRatio.Ratio_none;
        mVideoWidth = 800;
        mVideoHeight = 600;
        mFocusCallback = new byz(this);
        setRenderer(new cee(context, mCameraHandler));
    }

    public BeautyCameraGLSurfaceView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mEnumPreviewRatio = CameraGLSurfaceView.EnumPreviewRatio.Ratio_none;
        mVideoWidth = 800;
        mVideoHeight = 600;
        mFocusCallback = new byz(this);
        setRenderer(new cee(context, mCameraHandler));
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
        if (mRender instanceof cee)
        {
            queueEvent(new byu(this, enumcameracapturestate));
        }
    }

    public void setFilterLevel(float f)
    {
        if (mRender instanceof cee)
        {
            queueEvent(new byx(this, f));
        }
    }

    public void setFilterType(jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE beautycam_filter_type)
    {
        if (mRender instanceof cee)
        {
            queueEvent(new byy(this, beautycam_filter_type));
        }
    }

    public void setPreviewRatio(CameraGLSurfaceView.EnumPreviewRatio enumpreviewratio)
    {
        mEnumPreviewRatio = enumpreviewratio;
        if (mRender instanceof cee)
        {
            queueEvent(new byv(this, enumpreviewratio));
        }
    }

    public void setRotation(Rotation rotation, boolean flag, boolean flag1)
    {
        if ((mRender instanceof cee) && (mRender instanceof cee))
        {
            queueEvent(new bys(this, rotation));
        }
    }

    public void setSoftVirtualOpen(boolean flag)
    {
        if (mRender instanceof cee)
        {
            queueEvent(new byw(this, flag));
        }
    }

    public void setSoftenLevel(float f)
    {
        if (mRender instanceof cee)
        {
            queueEvent(new byt(this, f));
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
