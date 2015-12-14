// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView;

public class bzf
    implements Runnable
{

    final CameraGLSurfaceView a;

    public bzf(CameraGLSurfaceView cameraglsurfaceview)
    {
        a = cameraglsurfaceview;
        super();
    }

    public void run()
    {
        a.mRender.c();
    }
}
