// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.imagerender.ImageGLSurfaceView;

public class vc
    implements Runnable
{

    final ImageGLSurfaceView a;
    private String b;

    public vc(ImageGLSurfaceView imageglsurfaceview, String s)
    {
        a = imageglsurfaceview;
        super();
        b = s;
    }

    public void run()
    {
        ImageGLSurfaceView.access$000(a).a(b);
        a.requestRender();
    }
}
