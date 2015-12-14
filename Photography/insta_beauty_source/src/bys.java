// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import jp.co.cyberagent.android.gpuimage.Rotation;
import jp.co.cyberagent.android.gpuimage.camera.BeautyCameraGLSurfaceView;

public class bys
    implements Runnable
{

    final Rotation a;
    final BeautyCameraGLSurfaceView b;

    public bys(BeautyCameraGLSurfaceView beautycameraglsurfaceview, Rotation rotation)
    {
        b = beautycameraglsurfaceview;
        a = rotation;
        super();
    }

    public void run()
    {
        ((cee)b.mRender).a(a, true, false);
    }
}
