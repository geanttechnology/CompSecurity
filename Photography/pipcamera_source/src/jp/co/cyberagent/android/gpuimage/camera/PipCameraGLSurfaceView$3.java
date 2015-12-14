// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage.camera;

import ahi;

// Referenced classes of package jp.co.cyberagent.android.gpuimage.camera:
//            PipCameraGLSurfaceView

class b
    implements Runnable
{

    final int a;
    final int b;
    final PipCameraGLSurfaceView c;

    public void run()
    {
        ((ahi)c.mRender).c(a, b);
    }

    (PipCameraGLSurfaceView pipcameraglsurfaceview, int i, int j)
    {
        c = pipcameraglsurfaceview;
        a = i;
        b = j;
        super();
    }
}
