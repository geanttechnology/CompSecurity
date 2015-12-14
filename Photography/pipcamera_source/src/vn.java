// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.piprender.PipFreeStyleImageGLSurfaceView;

public class vn
    implements Runnable
{

    final PipFreeStyleImageGLSurfaceView a;

    private vn(PipFreeStyleImageGLSurfaceView pipfreestyleimageglsurfaceview)
    {
        a = pipfreestyleimageglsurfaceview;
        super();
    }

    public vn(PipFreeStyleImageGLSurfaceView pipfreestyleimageglsurfaceview, com.wantu.piprender.PipFreeStyleImageGLSurfaceView._cls1 _pcls1)
    {
        this(pipfreestyleimageglsurfaceview);
    }

    public void run()
    {
        a.requestRender();
    }
}
