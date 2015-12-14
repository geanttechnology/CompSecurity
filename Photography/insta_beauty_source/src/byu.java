// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import jp.co.cyberagent.android.gpuimage.camera.BeautyCameraGLSurfaceView;

public class byu
    implements Runnable
{

    final jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState a;
    final BeautyCameraGLSurfaceView b;

    public byu(BeautyCameraGLSurfaceView beautycameraglsurfaceview, jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState enumcameracapturestate)
    {
        b = beautycameraglsurfaceview;
        a = enumcameracapturestate;
        super();
    }

    public void run()
    {
        ((cee)b.mRender).a(a);
    }
}
