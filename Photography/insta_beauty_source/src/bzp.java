// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import jp.co.cyberagent.android.gpuimage.camera.PipCameraGLSurfaceView;

public class bzp
    implements Runnable
{

    final float a;
    final PipCameraGLSurfaceView b;

    public bzp(PipCameraGLSurfaceView pipcameraglsurfaceview, float f)
    {
        b = pipcameraglsurfaceview;
        a = f;
        super();
    }

    public void run()
    {
        ((cef)b.mRender).b(a);
    }
}
