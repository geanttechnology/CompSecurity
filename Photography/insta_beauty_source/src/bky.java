// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.imagerender.ImageGLSurfaceView;

public class bky
    implements Runnable
{

    final ImageGLSurfaceView a;
    private String b;

    public bky(ImageGLSurfaceView imageglsurfaceview, String s)
    {
        a = imageglsurfaceview;
        super();
        b = s;
    }

    public void run()
    {
        ImageGLSurfaceView.access$000(a).b(b);
        a.requestRender();
    }
}
