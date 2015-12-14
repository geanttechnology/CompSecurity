// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage.camera;

import ahg;

// Referenced classes of package jp.co.cyberagent.android.gpuimage.camera:
//            CameraGLSurfaceView

class a
    implements Runnable
{

    final CameraGLSurfaceView a;

    public void run()
    {
        a.mRender.c();
    }

    (CameraGLSurfaceView cameraglsurfaceview)
    {
        a = cameraglsurfaceview;
        super();
    }
}
