// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.b.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

public class android.support.b.a.a extends TextureView
    implements android.view.TextureView.SurfaceTextureListener, android.view.View.OnLayoutChangeListener
{
    private abstract class a
        implements android.opengl.GLSurfaceView.EGLConfigChooser
    {

        protected final int a[];
        final android.support.b.a.a b;

        abstract EGLConfig a(EGL10 egl10, EGLDisplay egldisplay, EGLConfig aeglconfig[]);

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay egldisplay)
        {
            int ai[] = new int[1];
            if (!egl10.eglChooseConfig(egldisplay, a, null, 0, ai))
            {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i1 = ai[0];
            if (i1 <= 0)
            {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig aeglconfig[] = new EGLConfig[i1];
            if (!egl10.eglChooseConfig(egldisplay, a, aeglconfig, i1, ai))
            {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            egl10 = a(egl10, egldisplay, aeglconfig);
            if (egl10 == null)
            {
                throw new IllegalArgumentException("No config chosen");
            } else
            {
                return egl10;
            }
        }

        public a(int ai[])
        {
            b = android.support.b.a.a.this;
            super();
            if (android.support.b.a.a.a(b) == 2 || android.support.b.a.a.a(b) == 3)
            {
                a1 = new int[15];
                System.arraycopy(ai, 0, android.support.b.a.a.this, 0, 12);
                android.support.b.a.a.this[12] = 12352;
                if (android.support.b.a.a.a(b) == 2)
                {
                    android.support.b.a.a.this[13] = 4;
                } else
                {
                    android.support.b.a.a.this[13] = 64;
                }
                android.support.b.a.a.this[14] = 12344;
                ai = android.support.b.a.a.this;
            }
            a = ai;
        }
    }

    private class b extends a
    {

        protected final int c = 8;
        protected final int d = 8;
        protected final int e = 8;
        protected final int f = 8;
        protected final int g;
        protected final int h = 0;
        final android.support.b.a.a i;
        private final int j[] = new int[1];

        private int a(EGL10 egl10, EGLDisplay egldisplay, EGLConfig eglconfig, int i1)
        {
            int j1 = 0;
            if (egl10.eglGetConfigAttrib(egldisplay, eglconfig, i1, j))
            {
                j1 = j[0];
            }
            return j1;
        }

        public final EGLConfig a(EGL10 egl10, EGLDisplay egldisplay, EGLConfig aeglconfig[])
        {
            int j1 = aeglconfig.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                EGLConfig eglconfig = aeglconfig[i1];
                int k1 = a(egl10, egldisplay, eglconfig, 12325);
                int l1 = a(egl10, egldisplay, eglconfig, 12326);
                if (k1 < g || l1 < h)
                {
                    continue;
                }
                k1 = a(egl10, egldisplay, eglconfig, 12324);
                l1 = a(egl10, egldisplay, eglconfig, 12323);
                int i2 = a(egl10, egldisplay, eglconfig, 12322);
                int j2 = a(egl10, egldisplay, eglconfig, 12321);
                if (k1 == c && l1 == d && i2 == e && j2 == f)
                {
                    return eglconfig;
                }
            }

            return null;
        }

        public b(int i1)
        {
            i = android.support.b.a.a.this;
            super(new int[] {
                12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, i1, 
                12326, 0, 12344
            });
            g = i1;
        }
    }

    private final class c
        implements android.opengl.GLSurfaceView.EGLContextFactory
    {

        final android.support.b.a.a a;
        private final int b;

        public final EGLContext createContext(EGL10 egl10, EGLDisplay egldisplay, EGLConfig eglconfig)
        {
            int ai[] = new int[3];
            ai[0] = 12440;
            ai[1] = android.support.b.a.a.a(a);
            ai[2] = 12344;
            EGLContext eglcontext = EGL10.EGL_NO_CONTEXT;
            if (android.support.b.a.a.a(a) == 0)
            {
                ai = null;
            }
            return egl10.eglCreateContext(egldisplay, eglconfig, eglcontext, ai);
        }

        public final void destroyContext(EGL10 egl10, EGLDisplay egldisplay, EGLContext eglcontext)
        {
            if (!egl10.eglDestroyContext(egldisplay, eglcontext))
            {
                Log.e("DefaultContextFactory", (new StringBuilder("display:")).append(egldisplay).append(" context: ").append(eglcontext).toString());
                e.a("eglDestroyContex", egl10.eglGetError());
            }
        }

        private c()
        {
            a = android.support.b.a.a.this;
            super();
            b = 12440;
        }

        c(byte byte0)
        {
            this();
        }
    }

    private static final class d
        implements android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
    {

        public final EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay egldisplay, EGLConfig eglconfig, Object obj)
        {
            try
            {
                egl10 = egl10.eglCreateWindowSurface(egldisplay, eglconfig, obj, null);
            }
            // Misplaced declaration of an exception variable
            catch (EGL10 egl10)
            {
                Log.e("GLTextureView", "eglCreateWindowSurface", egl10);
                return null;
            }
            return egl10;
        }

        public final void destroySurface(EGL10 egl10, EGLDisplay egldisplay, EGLSurface eglsurface)
        {
            egl10.eglDestroySurface(egldisplay, eglsurface);
        }

        private d()
        {
        }

        d(byte byte0)
        {
            this();
        }
    }

    private static final class e
    {

        final WeakReference a;
        EGL10 b;
        EGLDisplay c;
        EGLSurface d;
        EGLConfig e;
        EGLContext f;

        public static void a(String s, int i1)
        {
            throw new RuntimeException(b(s, i1));
        }

        public static String b(String s, int i1)
        {
            return (new StringBuilder()).append(s).append(" failed: ").append(i1).toString();
        }

        final void a()
        {
            if (d != null && d != EGL10.EGL_NO_SURFACE)
            {
                b.eglMakeCurrent(c, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                android.support.b.a.a a1 = (android.support.b.a.a)a.get();
                if (a1 != null)
                {
                    android.support.b.a.a.d(a1).destroySurface(b, c, d);
                }
                d = null;
            }
        }

        public e(WeakReference weakreference)
        {
            a = weakreference;
        }
    }

    static final class f extends Thread
    {

        boolean a;
        boolean b;
        boolean c;
        boolean d;
        boolean e;
        boolean f;
        boolean g;
        boolean h;
        int i;
        int j;
        int k;
        boolean l;
        boolean m;
        boolean n;
        private boolean o;
        private boolean p;
        private boolean q;
        private final ArrayList r = new ArrayList();
        private e s;
        private final WeakReference t;

        static boolean a(f f1)
        {
            f1.a = true;
            return true;
        }

        private void d()
        {
            if (g)
            {
                g = false;
                s.a();
            }
        }

        private void e()
        {
            if (f)
            {
                e e1 = s;
                if (e1.f != null)
                {
                    android.support.b.a.a a1 = (android.support.b.a.a)e1.a.get();
                    if (a1 != null)
                    {
                        android.support.b.a.a.c(a1).destroyContext(e1.b, e1.c, e1.f);
                    }
                    e1.f = null;
                }
                if (e1.c != null)
                {
                    e1.b.eglTerminate(e1.c);
                    e1.c = null;
                }
                f = false;
                android.support.b.a.a.c().b(this);
            }
        }

        private void f()
        {
            int i1;
            int j1;
            int k1;
            int l1;
            int i2;
            int j2;
            int k2;
            int l2;
            int i3;
            int j3;
            s = new e(t);
            f = false;
            g = false;
            k1 = 0;
            l1 = 0;
            obj3 = null;
            obj = null;
            l2 = 0;
            i2 = 0;
            j1 = 0;
            k2 = 0;
            i3 = 0;
            i1 = 0;
            j2 = 0;
            j3 = 0;
_L5:
            g g1 = android.support.b.a.a.c();
            g1;
            JVM INSTR monitorenter ;
            int j4 = i2;
_L27:
            if (!o)
            {
                break MISSING_BLOCK_LABEL_100;
            }
            g1;
            JVM INSTR monitorexit ;
            synchronized (android.support.b.a.a.c())
            {
                d();
                e();
            }
            return;
            obj3;
            obj;
            JVM INSTR monitorexit ;
            throw obj3;
            if (r.isEmpty()) goto _L2; else goto _L1
_L1:
            obj = (Runnable)r.remove(0);
            int k3 = l1;
            i2 = j3;
            l1 = j2;
            j3 = k1;
            k1 = j4;
            j2 = k2;
            k2 = j3;
            j3 = l2;
            l2 = k3;
_L25:
            g1;
            JVM INSTR monitorexit ;
            if (obj == null) goto _L4; else goto _L3
_L3:
            ((Runnable) (obj)).run();
            int l3 = l2;
            obj = null;
            l2 = j3;
            j3 = k1;
            j4 = j2;
            j2 = l1;
            boolean flag = i2;
            k1 = k2;
            l1 = l3;
            i2 = j3;
            k2 = j4;
            j3 = ((flag) ? 1 : 0);
              goto _L5
_L2:
            boolean flag1 = false;
            if (c != b)
            {
                flag1 = b;
                c = b;
                android.support.b.a.a.c().notifyAll();
            }
            i2 = k1;
            if (!q)
            {
                break MISSING_BLOCK_LABEL_280;
            }
            d();
            e();
            q = false;
            i2 = 1;
            int i4;
            i4 = k2;
            if (k2 == 0)
            {
                break MISSING_BLOCK_LABEL_300;
            }
            d();
            e();
            i4 = 0;
            if (!flag1)
            {
                break MISSING_BLOCK_LABEL_316;
            }
            if (g)
            {
                d();
            }
            if (!flag1) goto _L7; else goto _L6
_L6:
            if (!f) goto _L7; else goto _L8
_L8:
            Object obj5 = (android.support.b.a.a)t.get();
            if (obj5 == null) goto _L10; else goto _L9
_L9:
            if (!android.support.b.a.a.f(((android.support.b.a.a) (obj5)))) goto _L10; else goto _L11
_L11:
            k1 = 1;
_L63:
            if (k1 != 0) goto _L7; else goto _L12
_L12:
            e();
_L7:
            if (!d && !e)
            {
                if (g)
                {
                    d();
                }
                e = true;
                p = false;
                android.support.b.a.a.c().notifyAll();
            }
            if (d && e)
            {
                e = false;
                android.support.b.a.a.c().notifyAll();
            }
            k2 = l1;
            if (l1 == 0)
            {
                break MISSING_BLOCK_LABEL_457;
            }
            j4 = 0;
            k2 = 0;
            m = true;
            android.support.b.a.a.c().notifyAll();
            int k4;
            int i5;
            int j5;
            int k5;
            k1 = i2;
            k5 = j2;
            j5 = l2;
            i5 = i3;
            k4 = j3;
            if (!a()) goto _L14; else goto _L13
_L13:
            k1 = i2;
            l1 = j3;
            if (f) goto _L16; else goto _L15
_L15:
            if (i2 == 0) goto _L18; else goto _L17
_L17:
            k1 = 0;
            l1 = j3;
_L16:
            if (!f || g) goto _L20; else goto _L19
_L19:
            g = true;
            i3 = 1;
            j2 = 1;
            i2 = 1;
_L62:
            if (!g) goto _L22; else goto _L21
_L21:
            if (!n) goto _L24; else goto _L23
_L23:
            l2 = 1;
            j2 = i;
            j1 = j;
            i3 = 1;
            i1 = 1;
            n = false;
_L61:
            l = false;
            android.support.b.a.a.c().notifyAll();
            k4 = i3;
            j4 = l1;
            l1 = l2;
            l2 = k2;
            i3 = i1;
            j3 = i2;
            i1 = j1;
            j1 = j2;
            k2 = k1;
            k1 = k4;
            j2 = i4;
            i2 = j4;
              goto _L25
_L18:
            obj5 = android.support.b.a.a.c();
            if (((g) (obj5)).a == this || ((g) (obj5)).a == null)
            {
                obj5.a = this;
                obj5.notifyAll();
            }
            obj5 = s;
            obj5.b = (EGL10)EGLContext.getEGL();
            obj5.c = ((e) (obj5)).b.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (((e) (obj5)).c == EGL10.EGL_NO_DISPLAY)
            {
                throw new RuntimeException("eglGetDisplay failed");
            }
            break MISSING_BLOCK_LABEL_764;
            Object obj1;
            obj1;
            android.support.b.a.a.c().b(this);
            throw obj1;
            obj1;
            g1;
            JVM INSTR monitorexit ;
            throw obj1;
            obj3;
            synchronized (android.support.b.a.a.c())
            {
                d();
                e();
            }
            throw obj3;
            android.support.b.a.a a1;
            int ai[] = new int[2];
            if (!((e) (obj5)).b.eglInitialize(((e) (obj5)).c, ai))
            {
                throw new RuntimeException("eglInitialize failed");
            }
            a1 = (android.support.b.a.a)((e) (obj5)).a.get();
            if (a1 != null)
            {
                break MISSING_BLOCK_LABEL_896;
            }
            obj5.e = null;
            obj5.f = null;
_L26:
            if (((e) (obj5)).f == null || ((e) (obj5)).f == EGL10.EGL_NO_CONTEXT)
            {
                obj5.f = null;
                e.a("createContext", ((e) (obj5)).b.eglGetError());
            }
            obj5.d = null;
            f = true;
            l1 = 1;
            android.support.b.a.a.c().notifyAll();
            k1 = i2;
              goto _L16
            obj5.e = android.support.b.a.a.b(a1).chooseConfig(((e) (obj5)).b, ((e) (obj5)).c);
            obj5.f = android.support.b.a.a.c(a1).createContext(((e) (obj5)).b, ((e) (obj5)).c, ((e) (obj5)).e);
              goto _L26
_L22:
            k4 = l1;
            i5 = i3;
            j5 = i2;
            k5 = j2;
_L14:
            android.support.b.a.a.c().wait();
            l1 = k2;
            j2 = k5;
            k2 = i4;
            l2 = j5;
            i3 = i5;
            j3 = k4;
              goto _L27
_L4:
            if (i3 == 0) goto _L29; else goto _L28
_L28:
            obj4 = s;
            if (((e) (obj4)).b == null)
            {
                throw new RuntimeException("egl not initialized");
            }
            if (((e) (obj4)).c == null)
            {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (((e) (obj4)).e == null)
            {
                throw new RuntimeException("mEglConfig not initialized");
            }
            ((e) (obj4)).a();
            obj5 = (android.support.b.a.a)((e) (obj4)).a.get();
            if (obj5 == null) goto _L31; else goto _L30
_L30:
            obj4.d = android.support.b.a.a.d(((android.support.b.a.a) (obj5))).createWindowSurface(((e) (obj4)).b, ((e) (obj4)).c, ((e) (obj4)).e, ((android.support.b.a.a) (obj5)).getSurfaceTexture());
_L55:
            if (((e) (obj4)).d != null && ((e) (obj4)).d != EGL10.EGL_NO_SURFACE) goto _L33; else goto _L32
_L32:
            if (((e) (obj4)).b.eglGetError() == 12299)
            {
                Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
            }
              goto _L34
_L56:
            if (i4 == 0) goto _L36; else goto _L35
_L35:
            synchronized (android.support.b.a.a.c())
            {
                h = true;
                android.support.b.a.a.c().notifyAll();
            }
            i3 = 0;
_L29:
            if (j3 == 0) goto _L38; else goto _L37
_L37:
            obj3 = s;
            obj4 = ((e) (obj3)).f.getGL();
            obj3 = (android.support.b.a.a)((e) (obj3)).a.get();
            if (obj3 == null) goto _L40; else goto _L39
_L39:
            if ((android.support.b.a.a.e(((android.support.b.a.a) (obj3))) & 3) == 0) goto _L40; else goto _L41
_L41:
            j3 = 0;
            if ((android.support.b.a.a.e(((android.support.b.a.a) (obj3))) & 1) != 0)
            {
                j3 = 1;
            }
            if ((android.support.b.a.a.e(((android.support.b.a.a) (obj3))) & 2) == 0) goto _L43; else goto _L42
_L42:
            obj3 = new h();
_L58:
            obj3 = GLDebugHelper.wrap(((javax.microedition.khronos.opengles.GL) (obj4)), j3, ((Writer) (obj3)));
_L59:
            obj3 = (GL10)obj3;
            i4 = 0;
_L60:
            j3 = i2;
            if (i2 == 0) goto _L45; else goto _L44
_L44:
            obj4 = (android.support.b.a.a)t.get();
            if (obj4 == null) goto _L47; else goto _L46
_L46:
            android.support.b.a.a.g(((android.support.b.a.a) (obj4))).onSurfaceCreated(((GL10) (obj3)), s.e);
              goto _L47
_L45:
            i2 = l1;
            if (l1 == 0) goto _L49; else goto _L48
_L48:
            obj4 = (android.support.b.a.a)t.get();
            if (obj4 == null) goto _L51; else goto _L50
_L50:
            android.support.b.a.a.g(((android.support.b.a.a) (obj4))).onSurfaceChanged(((GL10) (obj3)), j1, i1);
              goto _L51
_L49:
            obj4 = (android.support.b.a.a)t.get();
            if (obj4 == null)
            {
                break MISSING_BLOCK_LABEL_1403;
            }
            if (android.support.b.a.a.a == null || android.support.b.a.a.a.intValue() != 2)
            {
                android.support.b.a.a.g(((android.support.b.a.a) (obj4))).onDrawFrame(((GL10) (obj3)));
            }
            obj4 = s;
            if (((e) (obj4)).b.eglSwapBuffers(((e) (obj4)).c, ((e) (obj4)).d)) goto _L53; else goto _L52
_L52:
            j4 = ((e) (obj4)).b.eglGetError();
              goto _L54
_L64:
            e.b("eglSwapBuffers", j4);
            synchronized (android.support.b.a.a.c())
            {
                p = true;
                android.support.b.a.a.c().notifyAll();
            }
            l1 = j2;
_L57:
            int l4;
            if (k1 != 0)
            {
                j2 = 1;
            } else
            {
                j2 = l2;
            }
            j4 = k1;
            l2 = i4;
            i4 = i2;
            l4 = l1;
            l1 = j2;
            k1 = k2;
            i2 = j4;
            j2 = i4;
            k2 = l4;
              goto _L5
_L31:
            obj4.d = null;
              goto _L55
_L33:
            if (((e) (obj4)).b.eglMakeCurrent(((e) (obj4)).c, ((e) (obj4)).d, ((e) (obj4)).d, ((e) (obj4)).f))
            {
                break MISSING_BLOCK_LABEL_1579;
            }
            e.b("eglMakeCurrent", ((e) (obj4)).b.eglGetError());
            i4 = 0;
              goto _L56
            i4 = 1;
              goto _L56
            obj2;
            obj4;
            JVM INSTR monitorexit ;
            throw obj2;
_L36:
            synchronized (android.support.b.a.a.c())
            {
                h = true;
                p = true;
                android.support.b.a.a.c().notifyAll();
            }
            i4 = l2;
            l2 = j3;
            j3 = k1;
            j4 = j2;
            j2 = l1;
            l4 = i2;
            k1 = k2;
            l1 = i4;
            i2 = j3;
            k2 = j4;
            j3 = l4;
              goto _L5
            obj2;
            obj4;
            JVM INSTR monitorexit ;
            throw obj2;
_L53:
            j4 = 12288;
              goto _L54
_L65:
            l1 = 1;
              goto _L57
            obj2;
            obj4;
            JVM INSTR monitorexit ;
            throw obj2;
            obj3;
            obj2;
            JVM INSTR monitorexit ;
            throw obj3;
_L43:
            obj3 = null;
              goto _L58
_L40:
            obj3 = obj4;
              goto _L59
_L38:
            i4 = j3;
              goto _L60
_L24:
            j3 = i3;
            i3 = j4;
            l2 = j2;
            j2 = j1;
            j1 = i1;
            i1 = j3;
              goto _L61
_L20:
            i2 = l2;
              goto _L62
_L10:
            k1 = 0;
              goto _L63
_L34:
            i4 = 0;
              goto _L56
_L47:
            j3 = 0;
              goto _L45
_L51:
            i2 = 0;
              goto _L49
_L54:
            l1 = j2;
            j4;
            JVM INSTR lookupswitch 2: default 1808
        //                       12288: 1474
        //                       12302: 1674;
               goto _L64 _L57 _L65
        }

        final boolean a()
        {
            return !c && d && !p && i > 0 && j > 0 && (l || k == 1);
        }

        public final int b()
        {
            int i1;
            synchronized (android.support.b.a.a.c())
            {
                i1 = k;
            }
            return i1;
            exception;
            g1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public final void c()
        {
            g g1 = android.support.b.a.a.c();
            g1;
            JVM INSTR monitorenter ;
            o = true;
            android.support.b.a.a.c().notifyAll();
_L1:
            boolean flag = a;
            if (flag)
            {
                break MISSING_BLOCK_LABEL_50;
            }
            android.support.b.a.a.c().wait();
              goto _L1
            Object obj;
            obj;
            Thread.currentThread().interrupt();
              goto _L1
            obj;
            g1;
            JVM INSTR monitorexit ;
            throw obj;
            g1;
            JVM INSTR monitorexit ;
        }

        public final void run()
        {
            Exception exception;
            setName((new StringBuilder("GLThread ")).append(getId()).toString());
            try
            {
                f();
            }
            catch (InterruptedException interruptedexception)
            {
                android.support.b.a.a.c().a(this);
                return;
            }
            finally
            {
                android.support.b.a.a.c().a(this);
            }
            android.support.b.a.a.c().a(this);
            return;
            throw exception;
        }

        f(WeakReference weakreference)
        {
            int i1 = 1;
            super();
            n = true;
            i = 0;
            j = 0;
            l = true;
            if (android.support.b.a.a.a != null)
            {
                i1 = android.support.b.a.a.a.intValue();
            }
            k = i1;
            t = weakreference;
        }
    }

    private static final class g
    {

        f a;

        public final void a(f f1)
        {
            this;
            JVM INSTR monitorenter ;
            f.a(f1);
            if (a == f1)
            {
                a = null;
            }
            notifyAll();
            this;
            JVM INSTR monitorexit ;
            return;
            f1;
            throw f1;
        }

        public final void b(f f1)
        {
            if (a == f1)
            {
                a = null;
            }
            notifyAll();
        }

        private g()
        {
        }

        g(byte byte0)
        {
            this();
        }
    }

    static final class h extends Writer
    {

        private final StringBuilder a = new StringBuilder();

        private void a()
        {
            if (a.length() > 0)
            {
                a.delete(0, a.length());
            }
        }

        public final void close()
        {
            a();
        }

        public final void flush()
        {
            a();
        }

        public final void write(char ac[], int i1, int j1)
        {
            int k1 = 0;
            while (k1 < j1) 
            {
                char c1 = ac[i1 + k1];
                if (c1 == '\n')
                {
                    a();
                } else
                {
                    a.append(c1);
                }
                k1++;
            }
        }

        h()
        {
        }
    }

    private final class i extends b
    {

        final android.support.b.a.a j;

        public i(boolean flag)
        {
            j = android.support.b.a.a.this;
            byte byte0;
            if (flag)
            {
                byte0 = 16;
            } else
            {
                byte0 = 0;
            }
            super(byte0);
        }
    }


    public static Integer a;
    private static final g b = new g((byte)0);
    private final WeakReference c = new WeakReference(this);
    private f d;
    private android.opengl.GLSurfaceView.Renderer e;
    private boolean f;
    private android.opengl.GLSurfaceView.EGLConfigChooser g;
    private android.opengl.GLSurfaceView.EGLContextFactory h;
    private android.opengl.GLSurfaceView.EGLWindowSurfaceFactory i;
    private int j;
    private int k;
    private boolean l;

    public android.support.b.a.a(Context context)
    {
        super(context);
        setSurfaceTextureListener(this);
        addOnLayoutChangeListener(this);
    }

    static int a(android.support.b.a.a a1)
    {
        return a1.k;
    }

    static android.opengl.GLSurfaceView.EGLConfigChooser b(android.support.b.a.a a1)
    {
        return a1.g;
    }

    static android.opengl.GLSurfaceView.EGLContextFactory c(android.support.b.a.a a1)
    {
        return a1.h;
    }

    static g c()
    {
        return b;
    }

    static android.opengl.GLSurfaceView.EGLWindowSurfaceFactory d(android.support.b.a.a a1)
    {
        return a1.i;
    }

    private void d()
    {
        if (d != null)
        {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        } else
        {
            return;
        }
    }

    static int e(android.support.b.a.a a1)
    {
        return a1.j;
    }

    static boolean f(android.support.b.a.a a1)
    {
        return a1.l;
    }

    static android.opengl.GLSurfaceView.Renderer g(android.support.b.a.a a1)
    {
        return a1.e;
    }

    public void a()
    {
        if (d == null) goto _L2; else goto _L1
_L1:
        f f1 = d;
        g g1 = b;
        g1;
        JVM INSTR monitorenter ;
        f1.b = true;
        b.notifyAll();
_L3:
        boolean flag;
        if (f1.a)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        flag = f1.c;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        b.wait();
          goto _L3
        InterruptedException interruptedexception;
        interruptedexception;
        Thread.currentThread().interrupt();
          goto _L3
        Exception exception;
        exception;
        g1;
        JVM INSTR monitorexit ;
        throw exception;
        g1;
        JVM INSTR monitorexit ;
_L2:
    }

    public void b()
    {
        if (d == null) goto _L2; else goto _L1
_L1:
        f f1 = d;
        g g1 = b;
        g1;
        JVM INSTR monitorenter ;
        f1.b = false;
        f1.l = true;
        f1.m = false;
        b.notifyAll();
_L3:
        boolean flag;
        if (f1.a || !f1.c)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        flag = f1.m;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        b.wait();
          goto _L3
        InterruptedException interruptedexception;
        interruptedexception;
        Thread.currentThread().interrupt();
          goto _L3
        Exception exception;
        exception;
        g1;
        JVM INSTR monitorexit ;
        throw exception;
        g1;
        JVM INSTR monitorexit ;
_L2:
    }

    protected void finalize()
    {
        if (d != null)
        {
            d.c();
        }
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public int getDebugFlags()
    {
        return j;
    }

    public boolean getPreserveEGLContextOnPause()
    {
        return l;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (f && e != null)
        {
            int i1;
            if (d != null)
            {
                i1 = d.b();
            } else
            {
                i1 = 1;
            }
            d = new f(c);
            if (i1 != 1)
            {
                f f1 = d;
                if (a != null)
                {
                    i1 = a.intValue();
                }
                if (i1 < 0 || i1 > 1)
                {
                    throw new IllegalArgumentException("renderMode");
                }
                synchronized (b)
                {
                    f1.k = i1;
                    b.notifyAll();
                }
            }
            d.start();
        }
        f = false;
        return;
        exception;
        g1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void onDetachedFromWindow()
    {
        if (d != null)
        {
            d.c();
        }
        f = true;
        super.onDetachedFromWindow();
    }

    public void onLayoutChange(View view, int i1, int j1, int k1, int l1, int i2, int j2, 
            int k2, int l2)
    {
        onSurfaceTextureSizeChanged(getSurfaceTexture(), k1 - i1, l1 - j1);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfacetexture, int i1, int j1)
    {
        if (d == null) goto _L2; else goto _L1
_L1:
        f f1 = d;
        surfacetexture = b;
        surfacetexture;
        JVM INSTR monitorenter ;
        f1.d = true;
        f1.h = false;
        b.notifyAll();
_L3:
        boolean flag;
        if (!f1.e || f1.h)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        flag = f1.a;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        b.wait();
          goto _L3
        InterruptedException interruptedexception;
        interruptedexception;
        Thread.currentThread().interrupt();
          goto _L3
        Exception exception;
        exception;
        surfacetexture;
        JVM INSTR monitorexit ;
        throw exception;
        surfacetexture;
        JVM INSTR monitorexit ;
_L2:
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfacetexture)
    {
        if (d == null) goto _L2; else goto _L1
_L1:
        f f1 = d;
        surfacetexture = b;
        surfacetexture;
        JVM INSTR monitorenter ;
        f1.d = false;
        b.notifyAll();
_L3:
        boolean flag;
        if (f1.e)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        flag = f1.a;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        b.wait();
          goto _L3
        InterruptedException interruptedexception;
        interruptedexception;
        Thread.currentThread().interrupt();
          goto _L3
        Exception exception;
        exception;
        surfacetexture;
        JVM INSTR monitorexit ;
        throw exception;
        surfacetexture;
        JVM INSTR monitorexit ;
_L2:
        return false;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfacetexture, int i1, int j1)
    {
        if (d == null) goto _L2; else goto _L1
_L1:
        f f1 = d;
        surfacetexture = b;
        surfacetexture;
        JVM INSTR monitorenter ;
        f1.i = i1;
        f1.j = j1;
        f1.n = true;
        f1.l = true;
        f1.m = false;
        b.notifyAll();
_L10:
        if (f1.a || f1.c || f1.m) goto _L4; else goto _L3
_L3:
        if (!f1.f || !f1.g) goto _L6; else goto _L5
_L5:
        boolean flag = f1.a();
        if (!flag) goto _L6; else goto _L7
_L7:
        i1 = 1;
_L8:
        Exception exception;
        if (i1 == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        try
        {
            b.wait();
            continue; /* Loop/switch isn't completed */
        }
        catch (InterruptedException interruptedexception) { }
        finally { }
        Thread.currentThread().interrupt();
        continue; /* Loop/switch isn't completed */
        surfacetexture;
        JVM INSTR monitorexit ;
        throw exception;
_L6:
        i1 = 0;
        if (true) goto _L8; else goto _L4
_L4:
        surfacetexture;
        JVM INSTR monitorexit ;
_L2:
        return;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfacetexture)
    {
    }

    public void setDebugFlags(int i1)
    {
        j = i1;
    }

    public void setEGLConfigChooser(android.opengl.GLSurfaceView.EGLConfigChooser eglconfigchooser)
    {
        d();
        g = eglconfigchooser;
    }

    public void setEGLContextClientVersion(int i1)
    {
        d();
        k = i1;
    }

    public void setEGLWindowSurfaceFactory(android.opengl.GLSurfaceView.EGLWindowSurfaceFactory eglwindowsurfacefactory)
    {
        d();
        i = eglwindowsurfacefactory;
    }

    public void setPreserveEGLContextOnPause(boolean flag)
    {
        l = flag;
    }

    public void setRenderer(android.opengl.GLSurfaceView.Renderer renderer)
    {
        d();
        if (g == null)
        {
            g = new i(true);
        }
        if (h == null)
        {
            h = new c((byte)0);
        }
        if (i == null)
        {
            i = new d((byte)0);
        }
        e = renderer;
        d = new f(c);
        d.start();
    }

}
