// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView;

public class bza
    implements Runnable
{

    final bzl a;
    final CameraGLSurfaceView b;

    public bza(CameraGLSurfaceView cameraglsurfaceview, bzl bzl)
    {
        b = cameraglsurfaceview;
        a = bzl;
        super();
    }

    public void run()
    {
        b.mRender.a(a);
    }
}
