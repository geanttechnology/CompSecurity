// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.piprender.PipFreeStyleImageGLSurfaceView;

public class vo
    implements Runnable
{

    float a;
    final PipFreeStyleImageGLSurfaceView b;

    public vo(PipFreeStyleImageGLSurfaceView pipfreestyleimageglsurfaceview, float f)
    {
        b = pipfreestyleimageglsurfaceview;
        super();
        a = f;
    }

    public void run()
    {
        PipFreeStyleImageGLSurfaceView.access$000(b).a(a);
        b.requestRender();
    }
}
