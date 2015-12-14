// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import jp.co.cyberagent.android.gpuimage.camera.PipCameraGLSurfaceView;

public class bzn
    implements Runnable
{

    final Bitmap a;
    final PipCameraGLSurfaceView b;

    public bzn(PipCameraGLSurfaceView pipcameraglsurfaceview, Bitmap bitmap)
    {
        b = pipcameraglsurfaceview;
        a = bitmap;
        super();
    }

    public void run()
    {
        ((cef)b.mRender).a(a);
    }
}
