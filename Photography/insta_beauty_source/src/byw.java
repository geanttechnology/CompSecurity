// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import jp.co.cyberagent.android.gpuimage.camera.BeautyCameraGLSurfaceView;

public class byw
    implements Runnable
{

    final boolean a;
    final BeautyCameraGLSurfaceView b;

    public byw(BeautyCameraGLSurfaceView beautycameraglsurfaceview, boolean flag)
    {
        b = beautycameraglsurfaceview;
        a = flag;
        super();
    }

    public void run()
    {
        ((cee)b.mRender).c(a);
    }
}
