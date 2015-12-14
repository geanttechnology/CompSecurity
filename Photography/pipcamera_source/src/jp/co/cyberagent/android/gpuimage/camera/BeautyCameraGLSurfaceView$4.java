// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage.camera;

import ahh;

// Referenced classes of package jp.co.cyberagent.android.gpuimage.camera:
//            BeautyCameraGLSurfaceView

class a
    implements Runnable
{

    final iewRatio a;
    final BeautyCameraGLSurfaceView b;

    public void run()
    {
        ((ahh)b.mRender).a(a);
    }

    iewRatio(BeautyCameraGLSurfaceView beautycameraglsurfaceview, iewRatio iewratio)
    {
        b = beautycameraglsurfaceview;
        a = iewratio;
        super();
    }
}
