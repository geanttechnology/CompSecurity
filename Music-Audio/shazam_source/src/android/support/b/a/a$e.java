// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.b.a;

import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

// Referenced classes of package android.support.b.a:
//            a

private static final class a
{

    final WeakReference a;
    EGL10 b;
    EGLDisplay c;
    EGLSurface d;
    EGLConfig e;
    EGLContext f;

    public static void a(String s, int i)
    {
        throw new RuntimeException(b(s, i));
    }

    public static String b(String s, int i)
    {
        return (new StringBuilder()).append(s).append(" failed: ").append(i).toString();
    }

    final void a()
    {
        if (d != null && d != EGL10.EGL_NO_SURFACE)
        {
            b.eglMakeCurrent(c, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            a a1 = (a)a.get();
            if (a1 != null)
            {
                android.support.b.a.a.d(a1).destroySurface(b, c, d);
            }
            d = null;
        }
    }

    public nce(WeakReference weakreference)
    {
        a = weakreference;
    }
}
