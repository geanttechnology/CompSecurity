// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import jp.co.cyberagent.android.gpuimage.camera.BeautyCameraGLSurfaceView;

public class byv
    implements Runnable
{

    final jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio a;
    final BeautyCameraGLSurfaceView b;

    public byv(BeautyCameraGLSurfaceView beautycameraglsurfaceview, jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio enumpreviewratio)
    {
        b = beautycameraglsurfaceview;
        a = enumpreviewratio;
        super();
    }

    public void run()
    {
        ((cee)b.mRender).a(a);
    }
}
