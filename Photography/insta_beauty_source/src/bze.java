// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView;

public class bze
    implements Runnable
{

    final CameraGLSurfaceView a;

    public bze(CameraGLSurfaceView cameraglsurfaceview)
    {
        a = cameraglsurfaceview;
        super();
    }

    public void run()
    {
        a.mRender.b(a.mSurfaceContainerWidth, a.mSurfaceContainerHeight);
        a.mRender.b(a.isFrontFacing);
    }
}
