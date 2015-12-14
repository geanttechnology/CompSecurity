// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.wantu.piprender.PipFreeStyleImageGLSurfaceView;

public class vp
    implements Runnable
{

    final PipFreeStyleImageGLSurfaceView a;
    private Bitmap b;

    public vp(PipFreeStyleImageGLSurfaceView pipfreestyleimageglsurfaceview, Bitmap bitmap)
    {
        a = pipfreestyleimageglsurfaceview;
        super();
        b = bitmap;
    }

    public void run()
    {
        PipFreeStyleImageGLSurfaceView.access$000(a).a(b);
        a.requestRender();
    }
}
