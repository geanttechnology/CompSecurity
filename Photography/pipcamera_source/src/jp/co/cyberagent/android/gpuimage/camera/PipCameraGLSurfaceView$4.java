// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage.camera;

import ahi;

// Referenced classes of package jp.co.cyberagent.android.gpuimage.camera:
//            PipCameraGLSurfaceView

class a
    implements Runnable
{

    final float a;
    final PipCameraGLSurfaceView b;

    public void run()
    {
        ((ahi)b.mRender).b(a);
    }

    (PipCameraGLSurfaceView pipcameraglsurfaceview, float f)
    {
        b = pipcameraglsurfaceview;
        a = f;
        super();
    }
}
