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

    final float a;
    final BeautyCameraGLSurfaceView b;

    public void run()
    {
        ((ahh)b.mRender).b(a);
    }

    (BeautyCameraGLSurfaceView beautycameraglsurfaceview, float f)
    {
        b = beautycameraglsurfaceview;
        a = f;
        super();
    }
}
