// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage.camera;

import ahi;
import android.graphics.Bitmap;
import android.graphics.Rect;

// Referenced classes of package jp.co.cyberagent.android.gpuimage.camera:
//            PipCameraGLSurfaceView

class b
    implements Runnable
{

    final Bitmap a;
    final Rect b;
    final PipCameraGLSurfaceView c;

    public void run()
    {
        ((ahi)c.mRender).a(a, b);
    }

    (PipCameraGLSurfaceView pipcameraglsurfaceview, Bitmap bitmap, Rect rect)
    {
        c = pipcameraglsurfaceview;
        a = bitmap;
        b = rect;
        super();
    }
}
