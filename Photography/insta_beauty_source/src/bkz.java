// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.imagerender.ImageGLSurfaceView;

public class bkz
    implements Runnable
{

    final ImageGLSurfaceView a;
    private float b;

    public bkz(ImageGLSurfaceView imageglsurfaceview, float f)
    {
        a = imageglsurfaceview;
        super();
        b = f;
    }

    public void run()
    {
        ImageGLSurfaceView.access$000(a).a(b);
        a.requestRender();
    }
}
