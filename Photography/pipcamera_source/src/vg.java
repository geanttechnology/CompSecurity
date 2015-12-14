// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.wantu.imagerender.ImageGLSurfaceView;

public class vg
    implements Runnable
{

    final ImageGLSurfaceView a;
    private Bitmap b;

    public vg(ImageGLSurfaceView imageglsurfaceview, Bitmap bitmap)
    {
        a = imageglsurfaceview;
        super();
        b = bitmap;
    }

    public void run()
    {
        ImageGLSurfaceView.access$000(a).a(b);
        a.requestRender();
    }
}
