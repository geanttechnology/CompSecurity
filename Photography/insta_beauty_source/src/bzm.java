// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.Rect;
import jp.co.cyberagent.android.gpuimage.camera.PipCameraGLSurfaceView;

public class bzm
    implements Runnable
{

    final Bitmap a;
    final Rect b;
    final PipCameraGLSurfaceView c;

    public bzm(PipCameraGLSurfaceView pipcameraglsurfaceview, Bitmap bitmap, Rect rect)
    {
        c = pipcameraglsurfaceview;
        a = bitmap;
        b = rect;
        super();
    }

    public void run()
    {
        ((cef)c.mRender).a(a, b);
    }
}
