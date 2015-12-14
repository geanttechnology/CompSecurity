// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.MediaCodec;
import android.opengl.EGLContext;
import android.view.Surface;

public class aha extends agx
{

    protected static int k[] = {
        0x7f000789
    };
    private final int l;
    private final int m;
    private ahe n;
    private Surface o;

    public void a(EGLContext eglcontext, int i)
    {
        n.a(eglcontext, i, o, l, m, true);
    }

    public boolean a()
    {
        boolean flag = super.a();
        if (flag)
        {
            n.a(null, null, f());
        }
        return flag;
    }

    public boolean a(ahf ahf, jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio enumpreviewratio)
    {
        boolean flag = super.a();
        if (flag)
        {
            n.a(ahf, enumpreviewratio, f());
        }
        return flag;
    }

    protected void c()
    {
        if (o != null)
        {
            o.release();
            o = null;
        }
        if (n != null)
        {
            n.a();
            n = null;
        }
        super.c();
    }

    protected void d()
    {
        h.signalEndOfInputStream();
        e = true;
    }

}
