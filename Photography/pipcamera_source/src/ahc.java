// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class ahc
{

    private final ahb a;
    private EGLSurface b;
    private final int c;
    private final int d;

    ahc(ahb ahb1, Object obj)
    {
        b = EGL14.EGL_NO_SURFACE;
        if (!(obj instanceof SurfaceView) && !(obj instanceof Surface) && !(obj instanceof SurfaceHolder) && !(obj instanceof SurfaceTexture))
        {
            throw new IllegalArgumentException("unsupported surface");
        } else
        {
            a = ahb1;
            b = ahb.a(a, obj);
            c = a.a(b, 12375);
            d = a.a(b, 12374);
            return;
        }
    }

    public void a()
    {
        ahb.a(a, b);
    }

    public void b()
    {
        ahb.b(a, b);
    }

    public void c()
    {
        ahb.a(a);
        ahb.c(a, b);
        b = EGL14.EGL_NO_SURFACE;
    }
}
