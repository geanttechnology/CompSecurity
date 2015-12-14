// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.AttributeSet;
import bzm;
import bzn;
import bzo;
import bzp;
import cef;

// Referenced classes of package jp.co.cyberagent.android.gpuimage.camera:
//            CameraGLSurfaceView

public class PipCameraGLSurfaceView extends CameraGLSurfaceView
{

    public PipCameraGLSurfaceView(Context context)
    {
        super(context);
        setRenderer(new cef(context, mCameraHandler));
    }

    public PipCameraGLSurfaceView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setRenderer(new cef(context, mCameraHandler));
    }

    public void setBlurFactor(float f)
    {
        while (mRender == null || !(mRender instanceof cef)) 
        {
            return;
        }
        queueEvent(new bzp(this, f));
    }

    public void setPipBackGroundSize(int i, int j)
    {
        while (mRender == null || !(mRender instanceof cef)) 
        {
            return;
        }
        queueEvent(new bzo(this, i, j));
    }

    public void setPipForeBitmap(Bitmap bitmap)
    {
        while (bitmap == null || mRender == null || !(mRender instanceof cef)) 
        {
            return;
        }
        queueEvent(new bzn(this, bitmap));
    }

    public void setPipMaskBitmapInfo(Bitmap bitmap, Rect rect)
    {
        while (bitmap == null || mRender == null || !(mRender instanceof cef)) 
        {
            return;
        }
        queueEvent(new bzm(this, bitmap, rect));
    }
}
