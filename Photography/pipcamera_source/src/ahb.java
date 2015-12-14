// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.util.Log;

public class ahb
{

    private EGLConfig a;
    private EGLContext b;
    private EGLDisplay c;
    private EGLContext d;

    public ahb(EGLContext eglcontext, boolean flag, boolean flag1)
    {
        a = null;
        b = EGL14.EGL_NO_CONTEXT;
        c = EGL14.EGL_NO_DISPLAY;
        d = EGL14.EGL_NO_CONTEXT;
        a(eglcontext, flag, flag1);
    }

    private EGLConfig a(boolean flag, boolean flag1)
    {
        int ai[] = new int[17];
        int[] _tmp = ai;
        ai[0] = 12352;
        ai[1] = 4;
        ai[2] = 12324;
        ai[3] = 8;
        ai[4] = 12323;
        ai[5] = 8;
        ai[6] = 12322;
        ai[7] = 8;
        ai[8] = 12321;
        ai[9] = 8;
        ai[10] = 12344;
        ai[11] = 12344;
        ai[12] = 12344;
        ai[13] = 12344;
        ai[14] = 12344;
        ai[15] = 12344;
        ai[16] = 12344;
        byte byte0 = 10;
        if (flag)
        {
            ai[10] = 12325;
            byte0 = 12;
            ai[11] = 16;
        }
        int j = byte0;
        if (flag1)
        {
            j = byte0;
            if (android.os.Build.VERSION.SDK_INT >= 18)
            {
                int k = byte0 + 1;
                ai[byte0] = 12610;
                j = k + 1;
                ai[k] = 1;
            }
        }
        for (int i = ai.length - 1; i >= j; i--)
        {
            ai[i] = 12344;
        }

        EGLConfig aeglconfig[] = new EGLConfig[1];
        int ai1[] = new int[1];
        if (!EGL14.eglChooseConfig(c, ai, 0, aeglconfig, 0, aeglconfig.length, ai1, 0))
        {
            Log.w("EGLBase", "unable to find RGBA8888 /  EGLConfig");
            return null;
        } else
        {
            return aeglconfig[0];
        }
    }

    private EGLContext a(EGLContext eglcontext)
    {
        eglcontext = EGL14.eglCreateContext(c, a, eglcontext, new int[] {
            12440, 2, 12344
        }, 0);
        a("eglCreateContext");
        return eglcontext;
    }

    static EGLSurface a(ahb ahb1, Object obj)
    {
        return ahb1.b(obj);
    }

    static void a(ahb ahb1)
    {
        ahb1.b();
    }

    private void a(EGLContext eglcontext, boolean flag, boolean flag1)
    {
        if (c != EGL14.EGL_NO_DISPLAY)
        {
            throw new RuntimeException("EGL already set up");
        }
        c = EGL14.eglGetDisplay(0);
        if (c == EGL14.EGL_NO_DISPLAY)
        {
            throw new RuntimeException("eglGetDisplay failed");
        }
        int ai[] = new int[2];
        if (!EGL14.eglInitialize(c, ai, 0, ai, 1))
        {
            c = null;
            throw new RuntimeException("eglInitialize failed");
        }
        if (eglcontext == null)
        {
            eglcontext = EGL14.EGL_NO_CONTEXT;
        }
        if (b == EGL14.EGL_NO_CONTEXT)
        {
            a = a(flag, flag1);
            if (a == null)
            {
                throw new RuntimeException("chooseConfig failed");
            }
            b = a(eglcontext);
        }
        eglcontext = new int[1];
        EGL14.eglQueryContext(c, b, 12440, eglcontext, 0);
        b();
    }

    private void a(String s)
    {
        int i = EGL14.eglGetError();
        if (i != 12288)
        {
            throw new RuntimeException((new StringBuilder()).append(s).append(": EGL error: 0x").append(Integer.toHexString(i)).toString());
        } else
        {
            return;
        }
    }

    static boolean a(ahb ahb1, EGLSurface eglsurface)
    {
        return ahb1.a(eglsurface);
    }

    private boolean a(EGLSurface eglsurface)
    {
        if (c != null);
        if (eglsurface == null || eglsurface == EGL14.EGL_NO_SURFACE)
        {
            if (EGL14.eglGetError() == 12299)
            {
                Log.e("EGLBase", "makeCurrent:returned EGL_BAD_NATIVE_WINDOW.");
            }
            return false;
        }
        if (!EGL14.eglMakeCurrent(c, eglsurface, eglsurface, b))
        {
            Log.w("EGLBase", (new StringBuilder()).append("eglMakeCurrent:").append(EGL14.eglGetError()).toString());
            return false;
        } else
        {
            return true;
        }
    }

    static int b(ahb ahb1, EGLSurface eglsurface)
    {
        return ahb1.b(eglsurface);
    }

    private int b(EGLSurface eglsurface)
    {
        if (!EGL14.eglSwapBuffers(c, eglsurface))
        {
            return EGL14.eglGetError();
        } else
        {
            return 12288;
        }
    }

    private EGLSurface b(Object obj)
    {
        try
        {
            obj = EGL14.eglCreateWindowSurface(c, a, obj, new int[] {
                12344
            }, 0);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e("EGLBase", "eglCreateWindowSurface", ((Throwable) (obj)));
            return null;
        }
        return ((EGLSurface) (obj));
    }

    private void b()
    {
        if (!EGL14.eglMakeCurrent(c, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT))
        {
            Log.w("TAG", (new StringBuilder()).append("makeDefault").append(EGL14.eglGetError()).toString());
        }
    }

    private void c()
    {
        if (!EGL14.eglDestroyContext(c, b))
        {
            Log.e("destroyContext", (new StringBuilder()).append("display:").append(c).append(" context: ").append(b).toString());
            Log.e("EGLBase", (new StringBuilder()).append("eglDestroyContex:").append(EGL14.eglGetError()).toString());
        }
        b = EGL14.EGL_NO_CONTEXT;
        if (d != EGL14.EGL_NO_CONTEXT)
        {
            if (!EGL14.eglDestroyContext(c, d))
            {
                Log.e("destroyContext", (new StringBuilder()).append("display:").append(c).append(" context: ").append(d).toString());
                Log.e("EGLBase", (new StringBuilder()).append("eglDestroyContex:").append(EGL14.eglGetError()).toString());
            }
            d = EGL14.EGL_NO_CONTEXT;
        }
    }

    static void c(ahb ahb1, EGLSurface eglsurface)
    {
        ahb1.c(eglsurface);
    }

    private void c(EGLSurface eglsurface)
    {
        if (eglsurface != EGL14.EGL_NO_SURFACE)
        {
            EGL14.eglMakeCurrent(c, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroySurface(c, eglsurface);
        }
        eglsurface = EGL14.EGL_NO_SURFACE;
    }

    public int a(EGLSurface eglsurface, int i)
    {
        int ai[] = new int[1];
        EGL14.eglQuerySurface(c, eglsurface, i, ai, 0);
        return ai[0];
    }

    public ahc a(Object obj)
    {
        obj = new ahc(this, obj);
        ((ahc) (obj)).a();
        return ((ahc) (obj));
    }

    public void a()
    {
        if (c != EGL14.EGL_NO_DISPLAY)
        {
            c();
            EGL14.eglTerminate(c);
            EGL14.eglReleaseThread();
        }
        c = EGL14.EGL_NO_DISPLAY;
        b = EGL14.EGL_NO_CONTEXT;
    }
}
