// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import jp.co.cyberagent.android.gpuimage.camera.BeautyCameraGLSurfaceView;

public class byx
    implements Runnable
{

    final float a;
    final BeautyCameraGLSurfaceView b;

    public byx(BeautyCameraGLSurfaceView beautycameraglsurfaceview, float f)
    {
        b = beautycameraglsurfaceview;
        a = f;
        super();
    }

    public void run()
    {
        ((cee)b.mRender).c(a);
    }
}
