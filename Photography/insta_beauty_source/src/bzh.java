// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView;

public class bzh
    implements Runnable
{

    final CameraGLSurfaceView a;

    public bzh(CameraGLSurfaceView cameraglsurfaceview)
    {
        a = cameraglsurfaceview;
        super();
    }

    public void run()
    {
        a.mRender.a(a.isFrontFacing);
        a.mRender.a(a.mCameraPreviewWidth, a.mCameraPreviewHeight);
    }
}
