// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage.camera;

import ahg;

// Referenced classes of package jp.co.cyberagent.android.gpuimage.camera:
//            CameraGLSurfaceView

class b
    implements Runnable
{

    final int a;
    final int b;
    final CameraGLSurfaceView c;

    public void run()
    {
        c.mRender.b(a, b);
    }

    (CameraGLSurfaceView cameraglsurfaceview, int i, int j)
    {
        c = cameraglsurfaceview;
        a = i;
        b = j;
        super();
    }
}
