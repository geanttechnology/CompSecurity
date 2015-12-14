// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.imagerender.ImageGLSurfaceView;

public class bkw
    implements Runnable
{

    final ImageGLSurfaceView a;

    public bkw(ImageGLSurfaceView imageglsurfaceview)
    {
        a = imageglsurfaceview;
        super();
    }

    public void run()
    {
        ImageGLSurfaceView.access$000(a).a();
    }
}
