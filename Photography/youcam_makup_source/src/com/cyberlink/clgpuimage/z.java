// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import com.cyberlink.clgpuimage.a.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

// Referenced classes of package com.cyberlink.clgpuimage:
//            u, Rotation, p, q, 
//            ac, aa, af, ab

public class z
    implements android.graphics.SurfaceTexture.OnFrameAvailableListener, android.opengl.GLSurfaceView.Renderer
{

    private static int F = 36197;
    public static final float a[] = {
        -1F, 1.0F, 1.0F, 1.0F, -1F, -1F, 1.0F, -1F
    };
    public static int b[] = new int[4];
    public static int c[] = new int[4];
    private Rotation A;
    private boolean B;
    private boolean C;
    private GPUImage.ScaleType D;
    private boolean E;
    private aa G;
    private ac H;
    private ab I;
    private EGLContext J;
    private EGLDisplay K;
    private EGLConfig L;
    private int M;
    private int N;
    private ByteBuffer O;
    private ByteBuffer P;
    private boolean Q;
    private int R[];
    private int S[];
    private u T;
    private int U;
    private int V;
    private long W;
    private boolean X;
    private final int Y = 3;
    private int Z;
    private float aa[] = {
        0.0F, 0.0F, 0.0F, 0.0F
    };
    public final Object d = new Object();
    private GLSurfaceView e;
    private u f;
    private p g;
    private q h;
    private Object i;
    private Object j;
    private int k;
    private SurfaceTexture l;
    private int m;
    private final FloatBuffer n;
    private final FloatBuffer o;
    private final FloatBuffer p;
    private final FloatBuffer q;
    private float r[];
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private final Queue y = new ConcurrentLinkedQueue();
    private final Queue z = new ConcurrentLinkedQueue();

    public z(u u1)
    {
        i = new Object();
        j = null;
        k = -1;
        l = null;
        r = new float[16];
        w = 0;
        x = 0;
        D = GPUImage.ScaleType.b;
        E = false;
        G = null;
        H = null;
        I = null;
        J = EGL10.EGL_NO_CONTEXT;
        K = null;
        L = null;
        M = -1;
        N = -1;
        O = null;
        P = null;
        Q = false;
        R = null;
        S = null;
        T = null;
        U = 0;
        V = 0;
        W = System.nanoTime();
        X = false;
        Z = 3;
        f = u1;
        if (f != null)
        {
            f.a(D);
            f.c(w, x);
        }
        n = ByteBuffer.allocateDirect(a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        n.put(a).position(0);
        o = ByteBuffer.allocateDirect(a.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        a(com.cyberlink.clgpuimage.Rotation.a, false, false);
        g = new p();
        h = new q();
        p = ByteBuffer.allocateDirect(a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        p.put(a).position(0);
        q = ByteBuffer.allocateDirect(a.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        q.put(a.a).position(0);
        R = null;
        S = null;
        T = null;
        U = 0;
    }

    private float a(float f1, float f2)
    {
        if (f1 == 0.0F)
        {
            return f2;
        } else
        {
            return 1.0F - f2;
        }
    }

    static int a(z z1, int i1)
    {
        z1.u = i1;
        return i1;
    }

    static u a(z z1, u u1)
    {
        z1.f = u1;
        return u1;
    }

    private void a(int i1, int j1)
    {
        R = new int[2];
        S = new int[2];
        GLES20.glGenFramebuffers(2, R, 0);
        GLES20.glGenTextures(2, S, 0);
        for (int k1 = 0; k1 < 2; k1++)
        {
            GLES20.glBindTexture(3553, S[k1]);
            GLES20.glTexImage2D(3553, 0, 6408, i1, j1, 0, 6408, 5121, null);
            GLES20.glTexParameterf(3553, 10240, 9729F);
            GLES20.glTexParameterf(3553, 10241, 9729F);
            GLES20.glTexParameterf(3553, 10242, 33071F);
            GLES20.glTexParameterf(3553, 10243, 33071F);
            GLES20.glBindFramebuffer(36160, R[k1]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, S[k1], 0);
        }

        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    private void a(int i1, int j1, int k1, FloatBuffer floatbuffer, FloatBuffer floatbuffer1, FloatBuffer floatbuffer2)
    {
        IntBuffer intbuffer = IntBuffer.allocate(1024);
        GLES20.glGetIntegerv(36006, intbuffer);
        IntBuffer intbuffer1 = IntBuffer.allocate(4);
        GLES20.glGetIntegerv(2978, intbuffer1);
        GLES20.glBindFramebuffer(36160, k1);
        GLES20.glClearColor(aa[0], aa[1], aa[2], aa[3]);
        GLES20.glClear(16384);
        f.b(i1, floatbuffer1, floatbuffer2);
        GLES20.glFlush();
        GLES20.glBindFramebuffer(36160, intbuffer.get(0));
        GLES20.glClear(16384);
        GLES20.glViewport(intbuffer1.get(0), intbuffer1.get(1), intbuffer1.get(2), intbuffer1.get(3));
        T.b(j1, n, floatbuffer);
        GLES20.glFlush();
    }

    static void a(z z1)
    {
        z1.k();
    }

    private void a(Queue queue)
    {
        queue;
        JVM INSTR monitorenter ;
_L1:
        Runnable runnable = (Runnable)queue.poll();
        if (runnable == null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        runnable.run();
          goto _L1
        Exception exception;
        exception;
        queue;
        JVM INSTR monitorexit ;
        throw exception;
        queue;
        JVM INSTR monitorexit ;
    }

    static int b(z z1, int i1)
    {
        z1.v = i1;
        return i1;
    }

    static u b(z z1)
    {
        return z1.f;
    }

    static int c(z z1, int i1)
    {
        z1.M = i1;
        return i1;
    }

    static GPUImage.ScaleType c(z z1)
    {
        return z1.D;
    }

    static int d(z z1, int i1)
    {
        z1.N = i1;
        return i1;
    }

    static Rotation d(z z1)
    {
        return z1.A;
    }

    static int e(z z1)
    {
        return z1.v;
    }

    static int e(z z1, int i1)
    {
        z1.k = i1;
        return i1;
    }

    static int f(z z1)
    {
        return z1.u;
    }

    static int g(z z1)
    {
        return z1.s;
    }

    private void g()
    {
        k = -1;
    }

    static int h(z z1)
    {
        return z1.t;
    }

    private void h()
    {
        if (S != null)
        {
            GLES20.glDeleteTextures(S.length, S, 0);
            S = null;
        }
        if (R != null)
        {
            GLES20.glDeleteFramebuffers(R.length, R, 0);
            R = null;
        }
    }

    static int i(z z1)
    {
        return z1.M;
    }

    private void i()
    {
        GLES20.glClearColor(aa[0], aa[1], aa[2], aa[3]);
        GLES20.glClear(16640);
        if (H != null)
        {
            H.a();
        }
        a(y);
        if (D != GPUImage.ScaleType.c && D != GPUImage.ScaleType.d) goto _L2; else goto _L1
_L1:
        if (l != null)
        {
            l.updateTexImage();
            l.getTransformMatrix(r);
            g.b(g.f(), r);
            if (G != null && android.os.Build.VERSION.SDK_INT >= 14)
            {
                G.a(l.getTimestamp());
            }
            GLES20.glViewport(c[0], c[1], c[2], c[3]);
            k = g.a(m, n, o);
            GLES20.glViewport(b[0], b[1], b[2], b[3]);
            f.b(k, p, q);
        }
_L4:
        a(z);
        if (H != null)
        {
            GLES20.glFinish();
            H.b();
        }
        return;
_L2:
        if (D == GPUImage.ScaleType.e)
        {
            synchronized (i)
            {
                M = com.cyberlink.clgpuimage.af.a(O, u, v, M);
                N = af.b(P, u, v, N);
            }
            if (M != -1 && N != -1)
            {
                GLES20.glViewport(c[0], c[1], c[2], c[3]);
                k = h.a(M, N, n, o);
                GLES20.glViewport(b[0], b[1], b[2], b[3]);
                f.b(k, p, q);
            }
        } else
        if (k != -1)
        {
            if (Q)
            {
                if (U == 0)
                {
                    a(k, S[0], R[0], q, n, o);
                    U = U + 1;
                } else
                {
                    if (U % 2 != 0)
                    {
                        a(S[0], S[1], R[1], q, n, q);
                    } else
                    {
                        a(S[1], S[0], R[0], q, n, q);
                    }
                    U = U + 1;
                }
            } else
            {
                f.b(k, n, o);
            }
        }
        continue; /* Loop/switch isn't completed */
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    static int j(z z1)
    {
        return z1.N;
    }

    private void j()
    {
        a(new Runnable() {

            final z a;

            public void run()
            {
                if (z.c(a) != GPUImage.ScaleType.c && z.c(a) != GPUImage.ScaleType.e) goto _L2; else goto _L1
_L1:
                if (z.d(a) != Rotation.d && z.d(a) != Rotation.b) goto _L4; else goto _L3
_L3:
                if (z.b(a) != null)
                {
                    z.b(a).a(z.e(a), z.f(a));
                }
_L5:
                z.o(a);
                return;
_L4:
                if (z.b(a) != null)
                {
                    z.b(a).a(z.f(a), z.e(a));
                }
                if (true) goto _L5; else goto _L2
_L2:
                if (z.c(a) == GPUImage.ScaleType.d)
                {
                    int i1 = Math.min(z.f(a), z.e(a));
                    if (z.b(a) != null)
                    {
                        z.b(a).a(i1, i1);
                    }
                    z.o(a);
                    return;
                }
                if (z.b(a) != null)
                {
                    z.b(a).a(z.g(a), z.h(a));
                    z.b(a).c(z.l(a), z.m(a));
                }
                GLES20.glViewport(0, 0, z.g(a), z.h(a));
                return;
            }

            
            {
                a = z.this;
                super();
            }
        });
    }

    static q k(z z1)
    {
        return z1.h;
    }

    private void k()
    {
        float f4 = s;
        float f3 = t;
        float f2 = u;
        float f1 = v;
        if (A == Rotation.d || A == Rotation.b)
        {
            f2 = v;
            f1 = u;
        }
        float f5 = Math.min(f4 / f2, f3 / f1);
        int i1 = Math.round(f2 * f5);
        int j1 = Math.round(f1 * f5);
        f1 = (float)i1 / f4;
        f2 = (float)j1 / f3;
        float af2[] = a;
        float af1[];
        if (D == GPUImage.ScaleType.b || D == com.cyberlink.clgpuimage.GPUImage.ScaleType.a || D == GPUImage.ScaleType.f || D == GPUImage.ScaleType.g || D == GPUImage.ScaleType.e)
        {
            Rotation rotation = A;
            boolean flag1 = B;
            float af3[];
            boolean flag;
            if (!C)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            af1 = com.cyberlink.clgpuimage.a.a.a(rotation, flag1, flag);
        } else
        {
            af1 = com.cyberlink.clgpuimage.a.a.a(com.cyberlink.clgpuimage.Rotation.a, B, C);
        }
        if (D == GPUImage.ScaleType.b)
        {
            f1 = (1.0F - 1.0F / f1) / 2.0F;
            f2 = (1.0F - 1.0F / f2) / 2.0F;
            af3 = (new float[] {
                a(af1[0], f1), a(af1[1], f2), a(af1[2], f1), a(af1[3], f2), a(af1[4], f1), a(af1[5], f2), a(af1[6], f1), a(af1[7], f2)
            });
            af1 = af2;
            af2 = af3;
        } else
        if (D == com.cyberlink.clgpuimage.GPUImage.ScaleType.a)
        {
            float af4[] = new float[8];
            af4[0] = a[0] * f1;
            af4[1] = a[1] * f2;
            af4[2] = a[2] * f1;
            af4[3] = a[3] * f2;
            af4[4] = a[4] * f1;
            af4[5] = a[5] * f2;
            af4[6] = a[6] * f1;
            af4[7] = a[7] * f2;
            af2 = af1;
            af1 = af4;
        } else
        {
            l();
            if (D == GPUImage.ScaleType.d)
            {
                float af5[] = m();
                af2 = af1;
                af1 = af5;
            } else
            {
                float af6[] = af2;
                af2 = af1;
                af1 = af6;
            }
        }
        n.clear();
        n.put(af1).position(0);
        o.clear();
        o.put(af2).position(0);
    }

    static int l(z z1)
    {
        return z1.w;
    }

    private void l()
    {
        int i1;
        int j1;
        if (A == Rotation.d || A == Rotation.b)
        {
            i1 = v;
            j1 = u;
        } else
        {
            i1 = u;
            j1 = v;
        }
        if (D == GPUImage.ScaleType.d)
        {
            j1 = Math.min(u, v);
            i1 = j1;
        }
        GLES20.glViewport(0, 0, i1, j1);
        if (f != null)
        {
            f.a(i1, j1);
        }
        if (g != null)
        {
            g.a(i1, j1);
        }
        if (h != null)
        {
            h.a(i1, j1);
        }
        if ((float)s / (float)t > (float)i1 / (float)j1)
        {
            b[1] = 0;
            b[3] = t;
            float f1 = (float)i1 / (float)j1;
            int k1 = t / 2;
            int i2 = s / 2;
            b[0] = i2 - (int)((float)k1 * f1);
            b[2] = (int)(f1 * (float)t);
        } else
        {
            b[0] = 0;
            b[2] = s;
            float f2 = (float)j1 / (float)i1;
            int l1 = t / 2;
            int j2 = s / 2;
            b[1] = l1 - (int)((float)j2 * f2);
            b[3] = (int)(f2 * (float)s);
        }
        c[0] = 0;
        c[1] = 0;
        c[2] = i1;
        c[3] = j1;
    }

    static int m(z z1)
    {
        return z1.x;
    }

    private float[] m()
    {
        float f1;
        float f2;
        int i1;
        int j1;
        int k1;
        if (A == Rotation.b || A == Rotation.d)
        {
            j1 = v;
            i1 = u;
        } else
        {
            j1 = u;
            i1 = v;
        }
        k1 = Math.min(u, v);
        f1 = (float)k1 / (float)j1;
        f2 = (float)k1 / (float)i1;
        if (f1 < f2)
        {
            f2 /= f1;
            f1 = 1.0F;
        } else
        if (f1 > f2)
        {
            f1 /= f2;
            f2 = 1.0F;
        } else
        {
            f1 = 1.0F;
            f2 = 1.0F;
        }
        return (new float[] {
            -1F * f2, 1.0F * f1, 1.0F * f2, 1.0F * f1, -1F * f2, -1F * f1, f2 * 1.0F, f1 * -1F
        });
    }

    static int n(z z1)
    {
        return z1.k;
    }

    static void o(z z1)
    {
        z1.l();
    }

    public EGLContext a()
    {
        return J;
    }

    public void a(Bitmap bitmap, boolean flag)
    {
        if (bitmap == null)
        {
            return;
        } else
        {
            a(new Runnable(bitmap, flag) {

                final Bitmap a;
                final boolean b;
                final z c;

                public void run()
                {
                    Bitmap bitmap1 = null;
                    if (a.getWidth() % 2 == 1)
                    {
                        bitmap1 = Bitmap.createScaledBitmap(a, a.getWidth() + 1, a.getHeight(), false);
                    }
                    z z1 = c;
                    Bitmap bitmap2;
                    if (bitmap1 != null)
                    {
                        bitmap2 = bitmap1;
                    } else
                    {
                        bitmap2 = a;
                    }
                    z.e(z1, com.cyberlink.clgpuimage.af.a(bitmap2, z.n(c), b));
                    if (bitmap1 != null)
                    {
                        bitmap1.recycle();
                    }
                    com.cyberlink.clgpuimage.z.a(c, a.getWidth());
                    z.b(c, a.getHeight());
                    com.cyberlink.clgpuimage.z.a(c);
                }

            
            {
                c = z.this;
                a = bitmap;
                b = flag;
                super();
            }
            });
            return;
        }
    }

    public void a(GLSurfaceView glsurfaceview)
    {
        e = glsurfaceview;
    }

    public void a(GPUImage.ScaleType scaletype)
    {
        D = scaletype;
        if (f != null)
        {
            f.a(D);
        }
        j();
    }

    public void a(Rotation rotation)
    {
        A = rotation;
        a(new Runnable() {

            final z a;

            public void run()
            {
                com.cyberlink.clgpuimage.z.a(a);
            }

            
            {
                a = z.this;
                super();
            }
        });
    }

    public void a(Rotation rotation, boolean flag, boolean flag1)
    {
        B = flag;
        C = flag1;
        a(rotation);
    }

    public void a(aa aa1)
    {
        G = aa1;
    }

    public void a(ab ab1)
    {
        if (ab1 != null)
        {
            X = true;
            Z = 3;
            I = ab1;
            return;
        } else
        {
            X = false;
            I = null;
            return;
        }
    }

    public void a(u u1)
    {
        a(new Runnable(u1) {

            final u a;
            final z b;

            public void run()
            {
                u u2 = z.b(b);
                com.cyberlink.clgpuimage.z.a(b, a);
                if (u2 != null)
                {
                    u2.h();
                }
                z.b(b).g();
                z.b(b).a(z.c(b));
                GLES20.glUseProgram(z.b(b).l());
                if (z.c(b) == GPUImage.ScaleType.c || z.c(b) == GPUImage.ScaleType.e)
                {
                    if (z.d(b) == Rotation.d || z.d(b) == Rotation.b)
                    {
                        z.b(b).a(z.e(b), z.f(b));
                        return;
                    } else
                    {
                        z.b(b).a(z.f(b), z.e(b));
                        return;
                    }
                }
                if (z.c(b) == GPUImage.ScaleType.d)
                {
                    int i1 = Math.min(z.f(b), z.e(b));
                    z.b(b).a(i1, i1);
                    return;
                } else
                {
                    z.b(b).a(z.g(b), z.h(b));
                    z.b(b).c(z.l(b), z.m(b));
                    return;
                }
            }

            
            {
                b = z.this;
                a = u1;
                super();
            }
        });
    }

    public void a(Object obj)
    {
        j = obj;
    }

    protected void a(Runnable runnable)
    {
        y.add(runnable);
    }

    public void a(byte abyte0[], int i1, int j1)
    {
        synchronized (i)
        {
            if (O == null || u != i1 || v != j1)
            {
                O = ByteBuffer.allocate(i1 * j1);
                P = ByteBuffer.allocate((i1 * j1) / 2);
                u = i1;
                v = j1;
                a(new Runnable() {

                    final z a;

                    public void run()
                    {
                        if (z.i(a) != -1)
                        {
                            GLES20.glDeleteTextures(1, new int[] {
                                z.i(a)
                            }, 0);
                            z.c(a, -1);
                        }
                        if (z.j(a) != -1)
                        {
                            GLES20.glDeleteTextures(1, new int[] {
                                z.j(a)
                            }, 0);
                            z.d(a, -1);
                        }
                        z.k(a).b(z.f(a), z.e(a));
                        com.cyberlink.clgpuimage.z.a(a);
                    }

            
            {
                a = z.this;
                super();
            }
                });
            }
            O.clear();
            O.put(abyte0, 0, i1 * j1);
            O.position(0);
            P.clear();
            P.put(abyte0, i1 * j1, (i1 * j1) / 2);
            P.position(0);
        }
        e.requestRender();
        return;
        abyte0;
        obj;
        JVM INSTR monitorexit ;
        throw abyte0;
    }

    public void b()
    {
        a(new Runnable() {

            final z a;

            public void run()
            {
                GLES20.glDeleteTextures(1, new int[] {
                    z.n(a)
                }, 0);
                z.e(a, -1);
            }

            
            {
                a = z.this;
                super();
            }
        });
    }

    protected int c()
    {
        return s;
    }

    protected int d()
    {
        return t;
    }

    public boolean e()
    {
        return B;
    }

    public boolean f()
    {
        return C;
    }

    public void onDrawFrame(GL10 gl10)
    {
        if (j != null)
        {
            synchronized (j)
            {
                i();
            }
        } else
        {
            i();
        }
        if (X)
        {
            if (Z > 0)
            {
                Z = Z - 1;
                if (Z == 0)
                {
                    W = System.nanoTime();
                    V = 0;
                }
            } else
            {
                V = V + 1;
                if (V % 10 == 0)
                {
                    long l1 = System.nanoTime();
                    double d1 = (((double)(l1 - W) / 1000000000D) * 1000D) / (double)V;
                    if (I != null)
                    {
                        I.a((float)(1000D / d1));
                    }
                    V = 0;
                    W = l1;
                    return;
                }
            }
        }
        return;
        exception;
        gl10;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onFrameAvailable(SurfaceTexture surfacetexture)
    {
        e.requestRender();
    }

    public void onSurfaceChanged(GL10 gl10, int i1, int j1)
    {
        s = i1;
        t = j1;
        GLES20.glViewport(0, 0, i1, j1);
        GLES20.glUseProgram(f.l());
        f.a(s, t);
        f.c(w, x);
        if (Q)
        {
            if (R != null)
            {
                h();
            }
            a(i1, j1);
            T.a(s, t);
            T.c(w, x);
        }
        k();
        synchronized (d)
        {
            d.notifyAll();
        }
        return;
        exception;
        gl10;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eglconfig)
    {
        g();
        gl10 = (EGL10)EGLContext.getEGL();
        J = gl10.eglGetCurrentContext();
        K = gl10.eglGetCurrentDisplay();
        L = eglconfig;
        GLES20.glDisable(2929);
        f.g();
        g.g();
        h.g();
        gl10 = new int[1];
        GLES20.glGenTextures(1, gl10, 0);
        m = gl10[0];
        l = new SurfaceTexture(m);
        l.setOnFrameAvailableListener(this);
        GLES20.glBindTexture(F, m);
        GLES20.glTexParameterf(F, 10241, 9728F);
        GLES20.glTexParameterf(F, 10240, 9729F);
        GLES20.glTexParameteri(F, 10242, 33071);
        GLES20.glTexParameteri(F, 10243, 33071);
        GLES20.glBindTexture(F, 0);
        if (Q)
        {
            T = new u();
            T.g();
        }
    }

}
