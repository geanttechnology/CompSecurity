// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.gpu;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.socialin.android.photo.imgop.ImageOpCommon;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import myobfuscated.av.b;
import myobfuscated.aw.d;
import myobfuscated.m.a;

// Referenced classes of package com.photo.gpu:
//            j, Rotation

public final class e
    implements android.opengl.GLSurfaceView.Renderer
{

    public static final float a[] = {
        -1F, -1F, 1.0F, -1F, -1F, 1.0F, 1.0F, 1.0F
    };
    public final Object b = new Object();
    int c;
    int d;
    boolean e;
    boolean f;
    b g;
    public a h;
    private float i;
    private float j;
    private d k;
    private int l;
    private final FloatBuffer m;
    private final ByteBuffer n = ImageOpCommon.allocNativeBuffer(32L);
    private final FloatBuffer o;
    private final ByteBuffer p = ImageOpCommon.allocNativeBuffer(32L);
    private int q;
    private int r;
    private final ConcurrentLinkedQueue s = new ConcurrentLinkedQueue();
    private final ConcurrentLinkedQueue t = new ConcurrentLinkedQueue();
    private Rotation u;

    public e(d d1)
    {
        i = 1.0F;
        j = 1.0F;
        l = -1;
        g = null;
        k = d1;
        m = n.order(ByteOrder.nativeOrder()).asFloatBuffer();
        m.put(a).position(0);
        d1 = com.photo.gpu.j.a;
        o = p.order(ByteOrder.nativeOrder()).asFloatBuffer();
        a(Rotation.NORMAL, false, false);
    }

    static int a(e e1, int i1)
    {
        e1.l = i1;
        return i1;
    }

    static d a(e e1)
    {
        return e1.k;
    }

    static d a(e e1, d d1)
    {
        e1.k = d1;
        return d1;
    }

    private static void a(Queue queue)
    {
        queue;
        JVM INSTR monitorenter ;
        for (; !queue.isEmpty(); ((Runnable)queue.poll()).run()) { }
        break MISSING_BLOCK_LABEL_33;
        Exception exception;
        exception;
        queue;
        JVM INSTR monitorexit ;
        throw exception;
        queue;
        JVM INSTR monitorexit ;
    }

    static int b(e e1)
    {
        return e1.c;
    }

    static int b(e e1, int i1)
    {
        e1.q = i1;
        return i1;
    }

    static int c(e e1)
    {
        return e1.d;
    }

    static int c(e e1, int i1)
    {
        e1.r = i1;
        return i1;
    }

    private void c()
    {
        float f1;
        float f2;
        float f3;
        float f4;
        f3 = c;
        f4 = d;
        f2 = q;
        f1 = r;
        if (u == Rotation.ROTATION_270 || u == Rotation.ROTATION_90)
        {
            f2 = r;
            f1 = q;
        }
        float f5 = Math.min(f3 / f2, f4 / f1);
        f2 = Math.round(f2 * f5);
        f1 = Math.round(f1 * f5);
        if (g != null)
        {
            float f6 = (f3 - f2) / 2.0F;
            float f7 = (f4 - f1) / 2.0F;
            g.a(f6, f7, f6 + f2, f7 + f1);
        }
        i = 1.0F;
        j = 1.0F;
        if (f2 == f3) goto _L2; else goto _L1
_L1:
        i = f2 / f3;
_L4:
        float af[] = com.photo.gpu.j.a(u, e, f);
        d();
        o.clear();
        o.put(af).position(0);
        return;
_L2:
        if (f1 != f4)
        {
            j = f1 / f4;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static int d(e e1)
    {
        return e1.l;
    }

    private void d()
    {
        float f1 = 1.0F;
        float f2 = -1F;
        float f3;
        float f4;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        if (g != null && g.f)
        {
            RectF rectf = g.b;
            RectF rectf1 = g.c;
            f2 = ((rectf1.centerX() - rectf.centerX()) / rectf.width()) * 2.0F;
            f1 = (-(rectf1.centerY() - rectf.centerY()) / rectf.height()) * 2.0F;
            float f5 = rectf1.width() / rectf.width();
            f4 = -1F * f5 + f2;
            f3 = 1.0F * f5 + f2;
            f2 = -1F * f5 + f1;
            f1 = 1.0F * f5 + f1;
        } else
        {
            f3 = 1.0F;
            f4 = -1F;
        }
        f6 = i;
        f7 = j;
        f8 = i;
        f9 = j;
        f10 = i;
        f11 = j;
        f12 = i;
        f13 = j;
        m.clear();
        m.put(new float[] {
            f6 * f4, f7 * f2, f8 * f3, f2 * f9, f4 * f10, f11 * f1, f3 * f12, f1 * f13
        }).position(0);
    }

    static void e(e e1)
    {
        e1.c();
    }

    static void f(e e1)
    {
        e1.d();
    }

    public final void a()
    {
        b(new Runnable() {

            private e a;

            public final void run()
            {
                GLES20.glDeleteTextures(1, new int[] {
                    com.photo.gpu.e.d(a)
                }, 0);
                com.photo.gpu.e.a(a, -1);
            }

            
            {
                a = e.this;
                super();
            }
        });
    }

    public final void a(Bitmap bitmap)
    {
        if (bitmap == null)
        {
            return;
        } else
        {
            b(new Runnable(bitmap, false) {

                private Bitmap a;
                private boolean b;
                private e c;

                public final void run()
                {
                    e e1 = c;
                    Bitmap bitmap1 = a;
                    int i1 = com.photo.gpu.e.d(c);
                    boolean flag = b;
                    int ai[] = new int[1];
                    if (i1 == -1)
                    {
                        GLES20.glGenTextures(1, ai, 0);
                        GLES20.glBindTexture(3553, ai[0]);
                        GLES20.glTexParameterf(3553, 10240, 9729F);
                        GLES20.glTexParameterf(3553, 10241, 9729F);
                        GLES20.glTexParameterf(3553, 10242, 33071F);
                        GLES20.glTexParameterf(3553, 10243, 33071F);
                        GLUtils.texImage2D(3553, 0, bitmap1, 0);
                    } else
                    {
                        GLES20.glBindTexture(3553, i1);
                        GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap1);
                        ai[0] = i1;
                    }
                    if (flag)
                    {
                        bitmap1.recycle();
                    }
                    com.photo.gpu.e.a(e1, ai[0]);
                    com.photo.gpu.e.b(c, a.getWidth());
                    e.c(c, a.getHeight());
                    e.e(c);
                }

            
            {
                c = e.this;
                a = bitmap;
                b = false;
                super();
            }
            });
            return;
        }
    }

    public final void a(Rotation rotation, boolean flag, boolean flag1)
    {
        e = flag;
        f = flag1;
        u = rotation;
        c();
    }

    public final void a(d d1)
    {
        b(new Runnable(d1) {

            private d a;
            private e b;

            public final void run()
            {
                d d2 = com.photo.gpu.e.a(b);
                com.photo.gpu.e.a(b, a);
                if (d2 != null)
                {
                    d2.d();
                }
                com.photo.gpu.e.a(b).c();
                GLES20.glUseProgram(com.photo.gpu.e.a(b).a);
                com.photo.gpu.e.a(b).a(com.photo.gpu.e.b(b), e.c(b));
            }

            
            {
                b = e.this;
                a = d1;
                super();
            }
        });
    }

    final boolean a(Runnable runnable)
    {
        boolean flag;
        synchronized (s)
        {
            flag = s.isEmpty();
        }
        if (flag)
        {
            b(runnable);
            return true;
        } else
        {
            return false;
        }
        runnable;
        concurrentlinkedqueue;
        JVM INSTR monitorexit ;
        throw runnable;
    }

    public final void b()
    {
        if (n != null)
        {
            ImageOpCommon.freeNativeBuffer(n);
        }
        if (p != null)
        {
            ImageOpCommon.freeNativeBuffer(p);
        }
    }

    protected final void b(Runnable runnable)
    {
        synchronized (s)
        {
            s.add(runnable);
        }
        return;
        runnable;
        concurrentlinkedqueue;
        JVM INSTR monitorexit ;
        throw runnable;
    }

    protected final void c(Runnable runnable)
    {
        synchronized (t)
        {
            t.add(runnable);
        }
        return;
        runnable;
        concurrentlinkedqueue;
        JVM INSTR monitorexit ;
        throw runnable;
    }

    public final void onDrawFrame(GL10 gl10)
    {
        GLES20.glClear(16640);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        a(s);
        k.a(l, m, o);
        a(t);
    }

    public final void onSurfaceChanged(GL10 gl10, int i1, int j1)
    {
        c = i1;
        d = j1;
        if (g != null)
        {
            gl10 = g;
            float f1 = i1;
            float f2 = j1;
            ((b) (gl10)).e.set(0.0F, 0.0F, f1, f2);
            g.a(0.0F, 0.0F, i1, j1);
        }
        GLES20.glViewport(0, 0, i1, j1);
        GLES20.glUseProgram(k.a);
        k.a(i1, j1);
        c();
        synchronized (b)
        {
            b.notifyAll();
        }
        return;
        exception;
        gl10;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eglconfig)
    {
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glDisable(2929);
        k.c();
    }


    // Unreferenced inner class com/photo/gpu/e$4

/* anonymous class */
    final class _cls4
        implements Runnable
    {

        private e a;

        public final void run()
        {
            e.f(a);
        }

            
            {
                a = e.this;
                super();
            }
    }

}
