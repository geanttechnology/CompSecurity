// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage.camera;

import ahi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.AttributeSet;

// Referenced classes of package jp.co.cyberagent.android.gpuimage.camera:
//            CameraGLSurfaceView

public class PipCameraGLSurfaceView extends CameraGLSurfaceView
{

    public PipCameraGLSurfaceView(Context context)
    {
        super(context);
        setRenderer(new ahi(context, mCameraHandler));
    }

    public PipCameraGLSurfaceView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setRenderer(new ahi(context, mCameraHandler));
    }

    public void setBlurFactor(float f)
    {
        while (mRender == null || !(mRender instanceof ahi)) 
        {
            return;
        }
        queueEvent(new Runnable(f) {

            final float a;
            final PipCameraGLSurfaceView b;

            public void run()
            {
                ((ahi)b.mRender).b(a);
            }

            
            {
                b = PipCameraGLSurfaceView.this;
                a = f;
                super();
            }
        });
    }

    public void setPipBackGroundSize(int i, int j)
    {
        while (mRender == null || !(mRender instanceof ahi)) 
        {
            return;
        }
        queueEvent(new Runnable(i, j) {

            final int a;
            final int b;
            final PipCameraGLSurfaceView c;

            public void run()
            {
                ((ahi)c.mRender).c(a, b);
            }

            
            {
                c = PipCameraGLSurfaceView.this;
                a = i;
                b = j;
                super();
            }
        });
    }

    public void setPipForeBitmap(Bitmap bitmap)
    {
        while (bitmap == null || mRender == null || !(mRender instanceof ahi)) 
        {
            return;
        }
        queueEvent(new Runnable(bitmap) {

            final Bitmap a;
            final PipCameraGLSurfaceView b;

            public void run()
            {
                ((ahi)b.mRender).a(a);
            }

            
            {
                b = PipCameraGLSurfaceView.this;
                a = bitmap;
                super();
            }
        });
    }

    public void setPipMaskBitmapInfo(Bitmap bitmap, Rect rect)
    {
        while (bitmap == null || mRender == null || !(mRender instanceof ahi)) 
        {
            return;
        }
        queueEvent(new Runnable(bitmap, rect) {

            final Bitmap a;
            final Rect b;
            final PipCameraGLSurfaceView c;

            public void run()
            {
                ((ahi)c.mRender).a(a, b);
            }

            
            {
                c = PipCameraGLSurfaceView.this;
                a = bitmap;
                b = rect;
                super();
            }
        });
    }
}
