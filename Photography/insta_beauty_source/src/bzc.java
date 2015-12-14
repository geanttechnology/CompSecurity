// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView;

public class bzc
    implements Runnable
{

    final int a;
    final int b;
    final CameraGLSurfaceView c;

    public bzc(CameraGLSurfaceView cameraglsurfaceview, int i, int j)
    {
        c = cameraglsurfaceview;
        a = i;
        b = j;
        super();
    }

    public void run()
    {
        c.mRender.b(a, b);
    }
}
