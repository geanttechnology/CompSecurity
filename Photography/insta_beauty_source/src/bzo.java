// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import jp.co.cyberagent.android.gpuimage.camera.PipCameraGLSurfaceView;

public class bzo
    implements Runnable
{

    final int a;
    final int b;
    final PipCameraGLSurfaceView c;

    public bzo(PipCameraGLSurfaceView pipcameraglsurfaceview, int i, int j)
    {
        c = pipcameraglsurfaceview;
        a = i;
        b = j;
        super();
    }

    public void run()
    {
        ((cef)c.mRender).c(a, b);
    }
}
