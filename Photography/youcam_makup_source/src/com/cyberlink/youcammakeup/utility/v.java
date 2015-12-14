// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

final class v
{

    EGL10 a;
    EGLDisplay b;
    EGLSurface c;
    EGLContext d;

    v()
    {
        b = EGL10.EGL_NO_DISPLAY;
        c = EGL10.EGL_NO_SURFACE;
        d = EGL10.EGL_NO_CONTEXT;
        a = (EGL10)EGLContext.getEGL();
        b = EGL10.EGL_NO_DISPLAY;
        c = EGL10.EGL_NO_SURFACE;
        d = EGL10.EGL_NO_CONTEXT;
        b = a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (b == EGL10.EGL_NO_DISPLAY)
        {
            throw new RuntimeException();
        }
        int ai[] = new int[2];
        if (!a.eglInitialize(b, ai))
        {
            throw new RuntimeException();
        }
        ai = new int[15];
        int[] _tmp = ai;
        ai[0] = 12325;
        ai[1] = 0;
        ai[2] = 12326;
        ai[3] = 0;
        ai[4] = 12324;
        ai[5] = 8;
        ai[6] = 12323;
        ai[7] = 8;
        ai[8] = 12322;
        ai[9] = 8;
        ai[10] = 12321;
        ai[11] = 8;
        ai[12] = 12352;
        ai[13] = 4;
        ai[14] = 12344;
        int ai1[] = new int[1];
        if (!a.eglChooseConfig(b, ai, null, 0, ai1))
        {
            throw new RuntimeException();
        }
        int i = ai1[0];
        EGLConfig aeglconfig[] = new EGLConfig[i];
        if (!a.eglChooseConfig(b, ai, aeglconfig, i, ai1))
        {
            throw new RuntimeException();
        }
        EGLConfig eglconfig = aeglconfig[0];
        d = a.eglCreateContext(b, eglconfig, EGL10.EGL_NO_CONTEXT, new int[] {
            12440, 2, 12344
        });
        if (d == EGL10.EGL_NO_CONTEXT)
        {
            throw new RuntimeException();
        }
        c = a.eglCreatePbufferSurface(b, eglconfig, new int[] {
            12375, 1, 12374, 1, 12344
        });
        if (c == EGL10.EGL_NO_SURFACE)
        {
            throw new RuntimeException();
        }
        if (!a.eglMakeCurrent(b, c, c, d))
        {
            throw new RuntimeException();
        } else
        {
            return;
        }
    }

    void a()
    {
        if (c != EGL10.EGL_NO_SURFACE)
        {
            a.eglDestroySurface(b, c);
        }
        if (d != EGL10.EGL_NO_CONTEXT)
        {
            a.eglDestroyContext(b, d);
        }
        if (b != EGL10.EGL_NO_DISPLAY)
        {
            a.eglTerminate(b);
        }
    }
}
