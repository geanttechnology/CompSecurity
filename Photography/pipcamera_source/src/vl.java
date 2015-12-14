// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.piprender.PipFreeStyleImageGLSurfaceView;

public class vl
    implements Runnable
{

    final PipFreeStyleImageGLSurfaceView a;
    private String b;

    public vl(PipFreeStyleImageGLSurfaceView pipfreestyleimageglsurfaceview, String s)
    {
        a = pipfreestyleimageglsurfaceview;
        super();
        b = s;
    }

    public void run()
    {
        PipFreeStyleImageGLSurfaceView.access$000(a).a(b);
        a.requestRender();
    }
}
