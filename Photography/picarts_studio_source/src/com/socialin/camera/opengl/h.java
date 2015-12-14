// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.opengl;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.util.c;
import com.socialin.picsin.camera.CameraMainActivity;
import com.socialin.picsin.camera.view.ColorSplashForegroundView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import myobfuscated.az.b;
import myobfuscated.dd.a;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.camera.opengl:
//            a, ac, ad, e, 
//            z, x, p, q, 
//            n, b

public final class h
    implements android.opengl.GLSurfaceView.Renderer, a
{

    private ReentrantLock A;
    private Activity B;
    private int C;
    private int D;
    private int E;
    private float F[];
    private float G[];
    private float H[];
    private int I;
    private int J;
    private int K;
    private int L;
    private float M;
    private int N;
    private FloatBuffer O;
    private boolean P;
    private boolean Q;
    private Bitmap R;
    private Object S;
    private boolean T;
    private ByteBuffer U;
    private boolean V;
    private int W;
    private int X;
    private int Y;
    private float Z;
    public com.socialin.camera.opengl.a a;
    private int aa;
    private float ab[];
    private int ac;
    public int b;
    public boolean c;
    ByteBuffer d;
    boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public FloatBuffer j;
    public int k;
    public int l;
    public float m[] = {
        0.0F, 0.625F, 0.9375F, 0.625F, 0.0F, 0.0F, 0.9375F, 0.0F
    };
    public boolean n;
    public ByteBuffer o;
    public int p;
    public int q;
    public int r;
    public int s;
    ByteBuffer t;
    public boolean u;
    public int v;
    public long w;
    public ColorSplashForegroundView x;
    public boolean y;
    boolean z;

    public h(Activity activity, com.socialin.camera.opengl.a a1)
    {
        A = new ReentrantLock();
        b = 0;
        F = new float[16];
        G = new float[16];
        H = new float[16];
        c = false;
        M = 100F;
        e = false;
        f = false;
        g = false;
        h = false;
        i = false;
        N = 6407;
        P = false;
        Q = false;
        S = new Object();
        T = false;
        U = null;
        V = false;
        W = 256;
        X = 256;
        Y = 256;
        k = 0;
        l = 0;
        Z = 1.0F;
        aa = -1;
        n = false;
        o = null;
        s = 0;
        t = null;
        u = false;
        v = 0;
        y = false;
        z = false;
        w = System.currentTimeMillis();
        B = activity;
        a = a1;
        a1 = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(a1);
        C = ((DisplayMetrics) (a1)).widthPixels;
        D = ((DisplayMetrics) (a1)).heightPixels;
    }

    static ColorSplashForegroundView a(h h1)
    {
        return h1.x;
    }

    public static FloatBuffer a(float af[])
    {
        Object obj = ByteBuffer.allocateDirect(af.length * 4);
        ((ByteBuffer) (obj)).order(ByteOrder.nativeOrder());
        obj = ((ByteBuffer) (obj)).asFloatBuffer();
        ((FloatBuffer) (obj)).put(af);
        ((FloatBuffer) (obj)).rewind();
        return ((FloatBuffer) (obj));
    }

    public final ReentrantLock a()
    {
        return A;
    }

    public final void a(int i1)
    {
        i1;
        JVM INSTR tableswitch 6407 6409: default 28
    //                   6407 49
    //                   6408 28
    //                   6409 49;
           goto _L1 _L2 _L1 _L2
_L1:
        N = 6407;
_L4:
        if (i1 != N)
        {
            V = false;
        }
        return;
_L2:
        N = i1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(int i1, int j1, int k1)
    {
        boolean flag;
        if (i1 != 0)
        {
            if ((-i1 & i1) == i1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            return;
        }
        W = i1;
        Y = k1;
        X = j1;
        if (!u)
        {
            m = (new float[] {
                0.0F, (float)k1 / (float)i1, (float)j1 / (float)i1, (float)k1 / (float)i1, 0.0F, 0.0F, (float)j1 / (float)i1, 0.0F
            });
        } else
        if (v == 180)
        {
            m = (new float[] {
                0.0F, 0.0F, (float)j1 / (float)i1, 0.0F, 0.0F, (float)k1 / (float)i1, (float)j1 / (float)i1, (float)k1 / (float)i1
            });
        } else
        {
            m = (new float[] {
                (float)j1 / (float)i1, (float)k1 / (float)i1, 0.0F, (float)k1 / (float)i1, (float)j1 / (float)i1, 0.0F, 0.0F, 0.0F
            });
        }
        j = a(m);
        V = false;
    }

    public final void a(ByteBuffer bytebuffer)
    {
        if (bytebuffer != null)
        {
            U = bytebuffer;
            P = true;
        }
    }

    public final Bitmap b()
    {
        E = 1;
        Object obj = S;
        obj;
        JVM INSTR monitorenter ;
        T = false;
        Q = true;
_L1:
        if (T)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        P = true;
        ((CameraMainActivity)B).d();
        try
        {
            S.wait();
        }
        catch (InterruptedException interruptedexception) { }
          goto _L1
        obj;
        JVM INSTR monitorexit ;
        return R;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean c()
    {
        return a != null && a.c == 0;
    }

    public final void onDrawFrame(GL10 gl10)
    {
        while (y || e) 
        {
            return;
        }
        z = true;
        GLES20.glClear(16640);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        int i1 = a.a();
        K = GLES20.glGetAttribLocation(i1, "aPosition");
        myobfuscated.f.m.i("glGetAttribLocation aPosition");
        L = GLES20.glGetAttribLocation(i1, "aTextureCoord");
        myobfuscated.f.m.i("glGetAttribLocation aTextureCoord");
        J = GLES20.glGetUniformLocation(i1, "uMVPMatrix");
        myobfuscated.f.m.i("glGetUniformLocation uMVPMatrix");
        I = GLES20.glGetUniformLocation(i1, "sTexture");
        myobfuscated.f.m.i("glGetUniformLocation sTexture");
        GLES20.glUseProgram(a.a());
        myobfuscated.f.m.i("glUseProgram");
        if (U == null)
        {
            z = false;
            return;
        }
        GLES20.glActiveTexture(33984);
        if (n) goto _L2; else goto _L1
_L1:
        GLES20.glBindTexture(3553, aa);
        if (!P) goto _L4; else goto _L3
_L3:
        A.lock();
        if (V) goto _L6; else goto _L5
_L5:
        if (t != null)
        {
            ImageOpCommon.freeNativeBuffer(t);
            t = null;
        }
        N;
        JVM INSTR tableswitch 6407 6409: default 236
    //                   6407 243
    //                   6408 236
    //                   6409 798;
           goto _L7 _L8 _L7 _L9
_L7:
        N = 6407;
_L8:
        t = ImageOpCommon.allocNativeBuffer(W * W * 3);
_L21:
        if (t != null)
        {
            t.rewind();
        }
        GLES20.glTexImage2D(3553, 0, N, W, W, 0, N, 5121, t);
        myobfuscated.f.m.i("glTexImage2D");
        V = true;
_L6:
        GLES20.glTexSubImage2D(3553, 0, 0, 0, X, Y, N, 5121, U);
        myobfuscated.f.m.i("glTexSubImage2D");
        A.unlock();
        GLES20.glTexParameterf(3553, 10241, 9729F);
        GLES20.glTexParameterf(3553, 10240, 9729F);
        P = false;
_L4:
        if (B != null)
        {
            ((CameraMainActivity)B).c(false);
        }
_L22:
        com.socialin.camera.opengl.a a1;
        GLES20.glUniform1i(I, 0);
        a1 = a;
        a1.c;
        JVM INSTR lookupswitch 6: default 484
    //                   4: 999
    //                   11: 1707
    //                   12: 2361
    //                   17: 3015
    //                   18: 3669
    //                   21: 4323;
           goto _L10 _L11 _L12 _L13 _L14 _L15 _L16
_L10:
        int i2;
        O.rewind();
        GLES20.glVertexAttribPointer(K, 3, 5126, false, 12, O);
        myobfuscated.f.m.i("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(K);
        myobfuscated.f.m.i("glEnableVertexAttribArray maPositionHandle");
        j.rewind();
        Object obj;
        Object obj1;
        Canvas canvas;
        Paint paint;
        int j1;
        int j2;
        int l2;
        int i3;
        if (!n)
        {
            GLES20.glVertexAttribPointer(L, 2, 5126, false, 8, j);
            myobfuscated.f.m.i("glVertexAttribPointer maTextureHandle");
        } else
        {
            GLES20.glVertexAttribPointer(L, 2, 5126, false, 0, j);
            myobfuscated.f.m.i("glVertexAttribPointer maTextureHandle");
        }
        GLES20.glEnableVertexAttribArray(L);
        myobfuscated.f.m.i("glEnableVertexAttribArray maTextureHandle");
        Matrix.multiplyMM(F, 0, G, 0, H, 0);
        GLES20.glUniformMatrix4fv(J, 1, false, F, 0);
        if (n)
        {
            GLES20.glUniform1f(GLES20.glGetUniformLocation(a.a(), "scaleFactor"), (float)q / (float)X);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(a.a(), "textureSize"), p);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(a.a(), "textureWidth"), q);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(a.a(), "textureHeight"), r);
        } else
        {
            GLES20.glUniform1f(GLES20.glGetUniformLocation(a.a(), "scaleFactor"), 1.0F);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(a.a(), "textureSize"), W);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(a.a(), "textureWidth"), X);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(a.a(), "textureHeight"), Y);
        }
        gl10 = a;
        gl10 = (ac)((com.socialin.camera.opengl.a) (gl10)).b.get(Integer.valueOf(((com.socialin.camera.opengl.a) (gl10)).c));
        ((ac) (gl10)).b.a(((ac) (gl10)).a);
        GLES20.glDrawArrays(5, 0, 4);
        myobfuscated.f.m.i("glDrawArrays");
        if (!Q) goto _L18; else goto _L17
_L17:
        Q = false;
        E;
        JVM INSTR tableswitch 1 1: default 792
    //                   1 4909;
           goto _L19 _L20
_L19:
        z = false;
        return;
_L9:
        t = ImageOpCommon.allocNativeBuffer(W * W);
          goto _L21
_L2:
        s = s + 1;
        GLES20.glBindTexture(3553, ac);
        if (s == 1)
        {
            if (t != null)
            {
                ImageOpCommon.freeNativeBuffer(t);
                t = null;
            }
            t = ImageOpCommon.allocNativeBuffer(p * p * 4);
            t.rewind();
            GLES20.glTexImage2D(3553, 0, 6408, p, p, 0, 6408, 5121, t);
            GLES20.glTexSubImage2D(3553, 0, 0, 0, q, r, 6408, 5121, o);
            GLES20.glTexParameterf(3553, 10241, 9729F);
            GLES20.glTexParameterf(3553, 10240, 9729F);
            GLES20.glTexParameteri(3553, 10242, 10497);
            GLES20.glTexParameteri(3553, 10243, 10497);
        }
          goto _L22
_L11:
        if (a1.t == -1)
        {
            gl10 = new int[1];
            GLES20.glGenTextures(1, gl10, 0);
            a1.t = gl10[0];
        }
        obj1 = a1.f;
        j2 = ((ac)a1.b.get(Integer.valueOf(a1.c))).a;
        l2 = a1.t;
        j1 = a1.u;
        if (!a1.v || ((e) (obj1)).f == null || ((e) (obj1)).g == null) goto _L24; else goto _L23
_L23:
        if (((e) (obj1)).f == null) goto _L26; else goto _L25
_L25:
        gl10 = new android.graphics.BitmapFactory.Options();
        gl10.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
        gl10 = com.socialin.android.util.c.a(((e) (obj1)).f, gl10);
        if (gl10 != null && !gl10.isRecycled()) goto _L28; else goto _L27
_L27:
        obj1.f = null;
        obj1.g = null;
        ((e) (obj1)).a(0);
        i2 = 10;
_L29:
        a1.u = i2;
        if (a1.u > 0)
        {
            a1.v = false;
        }
          goto _L10
_L28:
        obj1.c = gl10.getWidth();
        obj1.d = gl10.getHeight();
        i2 = gl10.getRowBytes();
        i3 = gl10.getHeight();
        i2 *= i3;
_L66:
        if (gl10 != null && (!gl10.isMutable() || i2 != ((e) (obj1)).c * ((e) (obj1)).d * 4))
        {
            Log.e("ex", "!bm.isMutable() || pixelCount!=texture2Width*texture2Height*4");
            obj = com.socialin.android.util.c.a(((e) (obj1)).c, ((e) (obj1)).d, android.graphics.Bitmap.Config.ARGB_8888);
            canvas = new Canvas(((Bitmap) (obj)));
            paint = new Paint();
            paint.setFilterBitmap(true);
            paint.setDither(true);
            canvas.drawBitmap(gl10, 0.0F, 0.0F, paint);
            gl10.recycle();
            gl10 = ((GL10) (obj));
        }
        if (com.socialin.camera.opengl.a.B(((e) (obj1)).h) >= 0 && ((e) (obj1)).f != null)
        {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, com.socialin.camera.opengl.a.B(((e) (obj1)).h));
        }
        if (((e) (obj1)).f != null || gl10 != null && (gl10.getWidth() > j1 || gl10.getHeight() > j1))
        {
            j1 = 1024;
            if (gl10 != null)
            {
                j1 = myobfuscated.f.m.a(Math.max(gl10.getWidth(), gl10.getHeight()));
            }
            obj = ImageOpCommon.allocNativeBuffer(j1 * j1 * 4);
            ((ByteBuffer) (obj)).position(0);
            GLES20.glTexImage2D(3553, 0, 6408, j1, j1, 0, 6408, 5121, ((java.nio.Buffer) (obj)));
            GLES20.glTexParameterf(3553, 10241, 9729F);
            GLES20.glTexParameterf(3553, 10240, 9729F);
            GLES20.glTexParameteri(3553, 10242, 10497);
            GLES20.glTexParameteri(3553, 10243, 10497);
            myobfuscated.f.m.i("glTexImage2D");
            ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj)));
        }
        if (gl10 != null)
        {
            obj = ImageOpCommon.allocNativeBuffer(gl10.getWidth() * gl10.getHeight() * 4);
            ((ByteBuffer) (obj)).position(0);
            gl10.copyPixelsToBuffer(((java.nio.Buffer) (obj)));
            ((ByteBuffer) (obj)).position(0);
            GLES20.glTexSubImage2D(3553, 0, 0, 0, gl10.getWidth(), gl10.getHeight(), 6408, 5121, ((java.nio.Buffer) (obj)));
            myobfuscated.f.m.i("glTexSubImage2D");
            ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj)));
            if (!gl10.isRecycled())
            {
                gl10.recycle();
            }
        }
_L24:
        i2 = j1;
        if (l2 >= 0)
        {
            i2 = j1;
            if (((e) (obj1)).f != null)
            {
                GLES20.glActiveTexture(33985);
                GLES20.glBindTexture(3553, com.socialin.camera.opengl.a.B(((e) (obj1)).h));
                GLES20.glUniform1i(GLES20.glGetUniformLocation(j2, "sTexture2"), 1);
                GLES20.glUniform1f(GLES20.glGetUniformLocation(j2, "texture2Size"), j1);
                GLES20.glUniform1f(GLES20.glGetUniformLocation(j2, "texture2Width"), ((e) (obj1)).c);
                GLES20.glUniform1f(GLES20.glGetUniformLocation(j2, "texture2Height"), ((e) (obj1)).d);
                i2 = j1;
            }
        }
          goto _L29
_L12:
        if (a1.t == -1)
        {
            gl10 = new int[1];
            GLES20.glGenTextures(1, gl10, 0);
            a1.t = gl10[0];
        }
        if (a1.k == null) goto _L10; else goto _L30
_L30:
        obj1 = a1.k;
        gl10 = a1.a;
        j2 = ((ac)a1.b.get(Integer.valueOf(a1.c))).a;
        l2 = a1.t;
        j1 = a1.u;
        if (!a1.v) goto _L32; else goto _L31
_L31:
        i2 = 0;
        if (((z) (obj1)).c == null) goto _L34; else goto _L33
_L33:
        gl10 = myobfuscated.az.b.a(gl10, "sinEnc", ((z) (obj1)).c, 0, 0, true);
        if (gl10 != null && !gl10.isRecycled()) goto _L36; else goto _L35
_L35:
        i2 = 10;
_L37:
        a1.u = i2;
        if (a1.u > 0)
        {
            a1.v = false;
        }
          goto _L10
_L36:
        obj1.a = gl10.getWidth();
        obj1.b = gl10.getHeight();
        i2 = gl10.getRowBytes();
        i3 = gl10.getHeight();
        i2 *= i3;
_L65:
        if (gl10 != null && (!gl10.isMutable() || i2 != ((z) (obj1)).a * ((z) (obj1)).b * 4))
        {
            obj = com.socialin.android.util.c.a(((z) (obj1)).a, ((z) (obj1)).b, android.graphics.Bitmap.Config.ARGB_8888);
            canvas = new Canvas(((Bitmap) (obj)));
            paint = new Paint();
            paint.setFilterBitmap(true);
            paint.setDither(true);
            canvas.drawBitmap(gl10, 0.0F, 0.0F, paint);
            gl10.recycle();
            gl10 = ((GL10) (obj));
        }
        if (l2 >= 0 && ((z) (obj1)).c != null)
        {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, l2);
        }
        if (((z) (obj1)).c != null || gl10 != null && (gl10.getWidth() > j1 || gl10.getHeight() > j1))
        {
            j1 = 1024;
            if (gl10 != null)
            {
                j1 = myobfuscated.f.m.a(Math.max(gl10.getWidth(), gl10.getHeight()));
            }
            obj = ImageOpCommon.allocNativeBuffer(j1 * j1 * 4);
            ((ByteBuffer) (obj)).position(0);
            GLES20.glTexImage2D(3553, 0, 6408, j1, j1, 0, 6408, 5121, ((java.nio.Buffer) (obj)));
            GLES20.glTexParameterf(3553, 10241, 9729F);
            GLES20.glTexParameterf(3553, 10240, 9729F);
            GLES20.glTexParameteri(3553, 10242, 10497);
            GLES20.glTexParameteri(3553, 10243, 10497);
            myobfuscated.f.m.i("glTexImage2D");
            ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj)));
        }
        if (gl10 != null)
        {
            obj = ImageOpCommon.allocNativeBuffer(gl10.getWidth() * gl10.getHeight() * 4);
            ((ByteBuffer) (obj)).position(0);
            gl10.copyPixelsToBuffer(((java.nio.Buffer) (obj)));
            ((ByteBuffer) (obj)).position(0);
            GLES20.glTexSubImage2D(3553, 0, 0, 0, gl10.getWidth(), gl10.getHeight(), 6408, 5121, ((java.nio.Buffer) (obj)));
            myobfuscated.f.m.i("glTexSubImage2D");
            ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj)));
            if (!gl10.isRecycled())
            {
                gl10.recycle();
            }
        }
_L32:
        i2 = j1;
        if (l2 >= 0)
        {
            i2 = j1;
            if (((z) (obj1)).c != null)
            {
                GLES20.glActiveTexture(33985);
                GLES20.glBindTexture(3553, l2);
                GLES20.glUniform1i(GLES20.glGetUniformLocation(j2, "sTexture2"), 1);
                GLES20.glUniform1f(GLES20.glGetUniformLocation(j2, "texture2Size"), j1);
                GLES20.glUniform1f(GLES20.glGetUniformLocation(j2, "texture2Width"), ((z) (obj1)).a);
                GLES20.glUniform1f(GLES20.glGetUniformLocation(j2, "texture2Height"), ((z) (obj1)).b);
                i2 = j1;
            }
        }
          goto _L37
_L13:
        if (a1.t == -1)
        {
            gl10 = new int[1];
            GLES20.glGenTextures(1, gl10, 0);
            a1.t = gl10[0];
        }
        if (a1.l == null) goto _L10; else goto _L38
_L38:
        obj1 = a1.l;
        gl10 = a1.a;
        j2 = ((ac)a1.b.get(Integer.valueOf(a1.c))).a;
        l2 = a1.t;
        j1 = a1.u;
        if (!a1.v) goto _L40; else goto _L39
_L39:
        i2 = 0;
        if (((x) (obj1)).c == null) goto _L42; else goto _L41
_L41:
        gl10 = myobfuscated.az.b.a(gl10, "sinEnc", ((x) (obj1)).c, 0, 0, true);
        if (gl10 != null && !gl10.isRecycled()) goto _L44; else goto _L43
_L43:
        i2 = 10;
_L45:
        a1.u = i2;
        if (a1.u > 0)
        {
            a1.v = false;
        }
          goto _L10
_L44:
        obj1.a = gl10.getWidth();
        obj1.b = gl10.getHeight();
        i2 = gl10.getRowBytes();
        i3 = gl10.getHeight();
        i2 *= i3;
_L64:
        if (gl10 != null && (!gl10.isMutable() || i2 != ((x) (obj1)).a * ((x) (obj1)).b * 4))
        {
            obj = com.socialin.android.util.c.a(((x) (obj1)).a, ((x) (obj1)).b, android.graphics.Bitmap.Config.ARGB_8888);
            canvas = new Canvas(((Bitmap) (obj)));
            paint = new Paint();
            paint.setFilterBitmap(true);
            paint.setDither(true);
            canvas.drawBitmap(gl10, 0.0F, 0.0F, paint);
            gl10.recycle();
            gl10 = ((GL10) (obj));
        }
        if (l2 >= 0 && ((x) (obj1)).c != null)
        {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, l2);
        }
        if (((x) (obj1)).c != null || gl10 != null && (gl10.getWidth() > j1 || gl10.getHeight() > j1))
        {
            j1 = 1024;
            if (gl10 != null)
            {
                j1 = myobfuscated.f.m.a(Math.max(gl10.getWidth(), gl10.getHeight()));
            }
            obj = ImageOpCommon.allocNativeBuffer(j1 * j1 * 4);
            ((ByteBuffer) (obj)).position(0);
            GLES20.glTexImage2D(3553, 0, 6408, j1, j1, 0, 6408, 5121, ((java.nio.Buffer) (obj)));
            GLES20.glTexParameterf(3553, 10241, 9729F);
            GLES20.glTexParameterf(3553, 10240, 9729F);
            GLES20.glTexParameteri(3553, 10242, 10497);
            GLES20.glTexParameteri(3553, 10243, 10497);
            myobfuscated.f.m.i("glTexImage2D");
            ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj)));
        }
        if (gl10 != null)
        {
            obj = ImageOpCommon.allocNativeBuffer(gl10.getWidth() * gl10.getHeight() * 4);
            ((ByteBuffer) (obj)).position(0);
            gl10.copyPixelsToBuffer(((java.nio.Buffer) (obj)));
            ((ByteBuffer) (obj)).position(0);
            GLES20.glTexSubImage2D(3553, 0, 0, 0, gl10.getWidth(), gl10.getHeight(), 6408, 5121, ((java.nio.Buffer) (obj)));
            myobfuscated.f.m.i("glTexSubImage2D");
            ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj)));
            if (!gl10.isRecycled())
            {
                gl10.recycle();
            }
        }
_L40:
        i2 = j1;
        if (l2 >= 0)
        {
            i2 = j1;
            if (((x) (obj1)).c != null)
            {
                GLES20.glActiveTexture(33985);
                GLES20.glBindTexture(3553, l2);
                GLES20.glUniform1i(GLES20.glGetUniformLocation(j2, "sTexture2"), 1);
                GLES20.glUniform1f(GLES20.glGetUniformLocation(j2, "texture2Size"), j1);
                GLES20.glUniform1f(GLES20.glGetUniformLocation(j2, "texture2Width"), ((x) (obj1)).a);
                GLES20.glUniform1f(GLES20.glGetUniformLocation(j2, "texture2Height"), ((x) (obj1)).b);
                i2 = j1;
            }
        }
          goto _L45
_L14:
        if (a1.t == -1)
        {
            gl10 = new int[1];
            GLES20.glGenTextures(1, gl10, 0);
            a1.t = gl10[0];
        }
        if (a1.m == null) goto _L10; else goto _L46
_L46:
        obj1 = a1.m;
        gl10 = a1.a;
        j2 = ((ac)a1.b.get(Integer.valueOf(a1.c))).a;
        l2 = a1.t;
        j1 = a1.u;
        if (!a1.v) goto _L48; else goto _L47
_L47:
        i2 = 0;
        if (((p) (obj1)).c == null) goto _L50; else goto _L49
_L49:
        gl10 = myobfuscated.az.b.a(gl10, "sinEnc", ((p) (obj1)).c, 0, 0, true);
        if (gl10 != null && !gl10.isRecycled()) goto _L52; else goto _L51
_L51:
        i2 = 10;
_L53:
        a1.u = i2;
        if (a1.u > 0)
        {
            a1.v = false;
        }
          goto _L10
_L52:
        obj1.a = gl10.getWidth();
        obj1.b = gl10.getHeight();
        i2 = gl10.getRowBytes();
        i3 = gl10.getHeight();
        i2 *= i3;
_L63:
        if (gl10 != null && (!gl10.isMutable() || i2 != ((p) (obj1)).a * ((p) (obj1)).b * 4))
        {
            obj = com.socialin.android.util.c.a(((p) (obj1)).a, ((p) (obj1)).b, android.graphics.Bitmap.Config.ARGB_8888);
            canvas = new Canvas(((Bitmap) (obj)));
            paint = new Paint();
            paint.setFilterBitmap(true);
            paint.setDither(true);
            canvas.drawBitmap(gl10, 0.0F, 0.0F, paint);
            gl10.recycle();
            gl10 = ((GL10) (obj));
        }
        if (l2 >= 0 && ((p) (obj1)).c != null)
        {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, l2);
        }
        if (((p) (obj1)).c != null || gl10 != null && (gl10.getWidth() > j1 || gl10.getHeight() > j1))
        {
            j1 = 1024;
            if (gl10 != null)
            {
                j1 = myobfuscated.f.m.a(Math.max(gl10.getWidth(), gl10.getHeight()));
            }
            obj = ImageOpCommon.allocNativeBuffer(j1 * j1 * 4);
            ((ByteBuffer) (obj)).position(0);
            GLES20.glTexImage2D(3553, 0, 6408, j1, j1, 0, 6408, 5121, ((java.nio.Buffer) (obj)));
            GLES20.glTexParameterf(3553, 10241, 9729F);
            GLES20.glTexParameterf(3553, 10240, 9729F);
            GLES20.glTexParameteri(3553, 10242, 10497);
            GLES20.glTexParameteri(3553, 10243, 10497);
            myobfuscated.f.m.i("glTexImage2D");
            ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj)));
        }
        if (gl10 != null)
        {
            obj = ImageOpCommon.allocNativeBuffer(gl10.getWidth() * gl10.getHeight() * 4);
            ((ByteBuffer) (obj)).position(0);
            gl10.copyPixelsToBuffer(((java.nio.Buffer) (obj)));
            ((ByteBuffer) (obj)).position(0);
            GLES20.glTexSubImage2D(3553, 0, 0, 0, gl10.getWidth(), gl10.getHeight(), 6408, 5121, ((java.nio.Buffer) (obj)));
            myobfuscated.f.m.i("glTexSubImage2D");
            ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj)));
            if (!gl10.isRecycled())
            {
                gl10.recycle();
            }
        }
_L48:
        i2 = j1;
        if (l2 >= 0)
        {
            i2 = j1;
            if (((p) (obj1)).c != null)
            {
                GLES20.glActiveTexture(33985);
                GLES20.glBindTexture(3553, l2);
                GLES20.glUniform1i(GLES20.glGetUniformLocation(j2, "sTexture2"), 1);
                GLES20.glUniform1f(GLES20.glGetUniformLocation(j2, "texture2Size"), j1);
                GLES20.glUniform1f(GLES20.glGetUniformLocation(j2, "texture2Width"), ((p) (obj1)).a);
                GLES20.glUniform1f(GLES20.glGetUniformLocation(j2, "texture2Height"), ((p) (obj1)).b);
                i2 = j1;
            }
        }
          goto _L53
_L15:
        if (a1.t == -1)
        {
            gl10 = new int[1];
            GLES20.glGenTextures(1, gl10, 0);
            a1.t = gl10[0];
        }
        if (a1.n == null) goto _L10; else goto _L54
_L54:
        obj1 = a1.n;
        gl10 = a1.a;
        j2 = ((ac)a1.b.get(Integer.valueOf(a1.c))).a;
        l2 = a1.t;
        j1 = a1.u;
        if (!a1.v) goto _L56; else goto _L55
_L55:
        i2 = 0;
        if (((q) (obj1)).f == null) goto _L58; else goto _L57
_L57:
        gl10 = myobfuscated.az.b.a(gl10, "sinEnc", ((q) (obj1)).f, 0, 0, true);
        if (gl10 != null && !gl10.isRecycled()) goto _L60; else goto _L59
_L59:
        i2 = 10;
_L61:
        a1.u = i2;
        if (a1.u > 0)
        {
            a1.v = false;
        }
          goto _L10
_L60:
        obj1.d = gl10.getWidth();
        obj1.e = gl10.getHeight();
        i2 = gl10.getRowBytes();
        i3 = gl10.getHeight();
        i2 *= i3;
_L62:
        if (gl10 != null && (!gl10.isMutable() || i2 != ((q) (obj1)).d * ((q) (obj1)).e * 4))
        {
            obj = com.socialin.android.util.c.a(((q) (obj1)).d, ((q) (obj1)).e, android.graphics.Bitmap.Config.ARGB_8888);
            canvas = new Canvas(((Bitmap) (obj)));
            paint = new Paint();
            paint.setFilterBitmap(true);
            paint.setDither(true);
            canvas.drawBitmap(gl10, 0.0F, 0.0F, paint);
            gl10.recycle();
            gl10 = ((GL10) (obj));
        }
        if (l2 >= 0 && ((q) (obj1)).f != null)
        {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, l2);
        }
        if (((q) (obj1)).f != null || gl10 != null && (gl10.getWidth() > j1 || gl10.getHeight() > j1))
        {
            j1 = 1024;
            if (gl10 != null)
            {
                j1 = myobfuscated.f.m.a(Math.max(gl10.getWidth(), gl10.getHeight()));
            }
            obj = ImageOpCommon.allocNativeBuffer(j1 * j1 * 4);
            ((ByteBuffer) (obj)).position(0);
            GLES20.glTexImage2D(3553, 0, 6408, j1, j1, 0, 6408, 5121, ((java.nio.Buffer) (obj)));
            GLES20.glTexParameterf(3553, 10241, 9729F);
            GLES20.glTexParameterf(3553, 10240, 9729F);
            GLES20.glTexParameteri(3553, 10242, 10497);
            GLES20.glTexParameteri(3553, 10243, 10497);
            myobfuscated.f.m.i("glTexImage2D");
            ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj)));
        }
        if (gl10 != null)
        {
            obj = ImageOpCommon.allocNativeBuffer(gl10.getWidth() * gl10.getHeight() * 4);
            ((ByteBuffer) (obj)).position(0);
            gl10.copyPixelsToBuffer(((java.nio.Buffer) (obj)));
            ((ByteBuffer) (obj)).position(0);
            GLES20.glTexSubImage2D(3553, 0, 0, 0, gl10.getWidth(), gl10.getHeight(), 6408, 5121, ((java.nio.Buffer) (obj)));
            myobfuscated.f.m.i("glTexSubImage2D");
            ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj)));
            if (!gl10.isRecycled())
            {
                gl10.recycle();
            }
        }
_L56:
        i2 = j1;
        if (l2 >= 0)
        {
            i2 = j1;
            if (((q) (obj1)).f != null)
            {
                GLES20.glActiveTexture(33985);
                GLES20.glBindTexture(3553, l2);
                GLES20.glUniform1i(GLES20.glGetUniformLocation(j2, "sTexture2"), 1);
                GLES20.glUniform1f(GLES20.glGetUniformLocation(j2, "texture2Size"), j1);
                GLES20.glUniform1f(GLES20.glGetUniformLocation(j2, "texture2Width"), ((q) (obj1)).d);
                GLES20.glUniform1f(GLES20.glGetUniformLocation(j2, "texture2Height"), ((q) (obj1)).e);
                i2 = j1;
            }
        }
          goto _L61
_L16:
        if (a1.t == -1)
        {
            gl10 = new int[1];
            GLES20.glGenTextures(1, gl10, 0);
            a1.t = gl10[0];
        }
        if (a1.p != null)
        {
            if (a1.v)
            {
                gl10 = a1.p;
                j2 = ((ac)a1.b.get(Integer.valueOf(a1.c))).a;
                l2 = a1.t;
                i2 = a1.u;
                j1 = i2;
                if (a1.v)
                {
                    j1 = i2;
                    if (((n) (gl10)).i != null)
                    {
                        if (l2 >= 0)
                        {
                            GLES20.glActiveTexture(33985);
                            GLES20.glBindTexture(3553, l2);
                        }
                        j1 = myobfuscated.f.m.a(Math.max(((n) (gl10)).g, ((n) (gl10)).h));
                        obj = ImageOpCommon.allocNativeBuffer(j1 * j1 * 4);
                        ((ByteBuffer) (obj)).position(0);
                        GLES20.glTexImage2D(3553, 0, 6408, j1, j1, 0, 6408, 5121, ((java.nio.Buffer) (obj)));
                        GLES20.glTexParameterf(3553, 10241, 9729F);
                        GLES20.glTexParameterf(3553, 10240, 9729F);
                        GLES20.glTexParameteri(3553, 10242, 10497);
                        GLES20.glTexParameteri(3553, 10243, 10497);
                        myobfuscated.f.m.i("glTexImage2D");
                        ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj)));
                        GLES20.glTexSubImage2D(3553, 0, 0, 0, ((n) (gl10)).g, ((n) (gl10)).h, 6408, 5121, ((n) (gl10)).i);
                        myobfuscated.f.m.i("glTexSubImage2D");
                    }
                }
                if (l2 >= 0 && ((n) (gl10)).i != null)
                {
                    GLES20.glActiveTexture(33985);
                    GLES20.glBindTexture(3553, l2);
                    GLES20.glUniform1i(GLES20.glGetUniformLocation(j2, "sTexture2"), 1);
                    GLES20.glUniform1f(GLES20.glGetUniformLocation(j2, "texture2Size"), j1);
                    GLES20.glUniform1f(GLES20.glGetUniformLocation(j2, "texture2Width"), ((n) (gl10)).g);
                    GLES20.glUniform1f(GLES20.glGetUniformLocation(j2, "texture2Height"), ((n) (gl10)).h);
                }
                a1.u = j1;
                if (a1.u > 0)
                {
                    a1.v = false;
                }
            } else
            {
                gl10 = a1.p;
                j1 = ((ac)a1.b.get(Integer.valueOf(a1.c))).a;
                if (((n) (gl10)).f && ((n) (gl10)).d != null && j1 >= 0)
                {
                    GLES20.glUniform1f(GLES20.glGetUniformLocation(j1, "texture2Size"), 0.0F);
                    GLES20.glUniform1f(GLES20.glGetUniformLocation(j1, "texture2Width"), 0.0F);
                    GLES20.glUniform1f(GLES20.glGetUniformLocation(j1, "texture2Height"), 0.0F);
                    gl10.f = false;
                }
            }
        }
          goto _L10
_L20:
        if (d != null)
        {
            ImageOpCommon.freeNativeBuffer(d);
            d = null;
        }
        d = ImageOpCommon.allocNativeBuffer(k * l * 4);
        GLES20.glReadPixels(0, 0, k, l, 6408, 5121, d);
        d.rewind();
        ImageOpCommon.reverseBitmap(d, k, l);
        d.rewind();
        R = com.socialin.android.util.c.a(k, l, android.graphics.Bitmap.Config.ARGB_8888);
        if (R != null)
        {
            R.copyPixelsFromBuffer(d);
        }
        T = true;
        P = false;
        synchronized (S)
        {
            S.notifyAll();
        }
          goto _L19
        exception;
        gl10;
        JVM INSTR monitorexit ;
        throw exception;
_L18:
        if (c)
        {
            if (x != null)
            {
                gl10 = x;
                Point point = new Point(0, 0);
                point.x = (int)((ColorSplashForegroundView) (gl10)).a.x;
                point.y = (int)((ColorSplashForegroundView) (gl10)).a.y;
                if (((ColorSplashForegroundView) (gl10)).b != null)
                {
                    i2 = ((ColorSplashForegroundView) (gl10)).b.k;
                    int k1 = ((ColorSplashForegroundView) (gl10)).b.l;
                    i2 = (int)((((ColorSplashForegroundView) (gl10)).c - (float)i2) / 2.0F);
                    k1 = (int)((((ColorSplashForegroundView) (gl10)).d - (float)k1) / 2.0F);
                    point.x = point.x - i2;
                    point.y = point.y - k1;
                }
                i2 = point.x;
                int k2 = point.y;
                gl10 = ImageOpCommon.allocNativeBuffer(4L);
                float f1;
                int l1;
                if (i2 < 0)
                {
                    l1 = 0;
                } else
                {
                    l1 = i2;
                    if (i2 >= k)
                    {
                        l1 = k - 1;
                    }
                }
                if (k2 < 0)
                {
                    i2 = 0;
                } else
                {
                    i2 = k2;
                    if (k2 >= l)
                    {
                        i2 = l - 1;
                    }
                }
                GLES20.glReadPixels(l1, l - 1 - i2, 1, 1, 6408, 5121, gl10);
                l1 = ImageOpCommon.getPixel(gl10, 0);
                ImageOpCommon.freeNativeBuffer(gl10);
                i2 = Color.argb(Color.alpha(l1), Color.blue(l1), Color.green(l1), Color.red(l1));
                x.setSelectedColor(i2);
                if (B != null)
                {
                    B.runOnUiThread(new Runnable() {

                        private h a;

                        public final void run()
                        {
                            if (com.socialin.camera.opengl.h.a(a) != null)
                            {
                                com.socialin.camera.opengl.h.a(a).a();
                            }
                        }

            
            {
                a = h.this;
                super();
            }
                    });
                }
                gl10 = a;
                f1 = (float)ImageOpCommon.RGBTOHCL(Color.blue(l1), Color.green(l1), Color.red(l1));
                ((com.socialin.camera.opengl.a) (gl10)).e.a(i2, f1, false);
            }
        } else
        if (n)
        {
            if (s == 2)
            {
                s = 0;
                n = false;
                o.rewind();
                GLES20.glReadPixels(0, 0, q, r, 6408, 5121, o);
                o.rewind();
                ImageOpCommon.reverseBitmap(o, q, r);
                gl10 = com.socialin.android.util.c.a(q, r, android.graphics.Bitmap.Config.ARGB_8888);
                o.rewind();
                if (o.capacity() == q * r * 4)
                {
                    gl10.copyPixelsFromBuffer(o);
                }
                ImageOpCommon.freeNativeBuffer(o);
                o = null;
                CameraMainActivity cameramainactivity = (CameraMainActivity)B;
                cameramainactivity.runOnUiThread(new com.socialin.picsin.camera.CameraMainActivity._cls25(cameramainactivity, gl10, b));
            } else
            {
                ((CameraMainActivity)B).d();
            }
        }
          goto _L19
_L58:
        gl10 = null;
          goto _L62
_L50:
        gl10 = null;
          goto _L63
_L42:
        gl10 = null;
          goto _L64
_L34:
        gl10 = null;
          goto _L65
_L26:
        gl10 = null;
        i2 = 0;
          goto _L66
    }

    public final void onSurfaceChanged(GL10 gl10, int i1, int j1)
    {
        if (!y) goto _L2; else goto _L1
_L1:
        return;
_L2:
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glViewport(0, 0, i1, j1);
        Z = (float)i1 / (float)j1;
        G = new float[16];
        H = new float[16];
        Matrix.setLookAtM(H, 0, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 5F, 0.0F, 1.0F, 0.0F);
        Matrix.orthoM(G, 0, -100F * Z, 100F * Z, -100F, 100F, 1.0F, -1F);
        Matrix.setIdentityM(H, 0);
        ab = (new float[] {
            -100F * Z, -100F, -1F, 100F * Z, -100F, -1F, -100F * Z, 100F, -1F, 100F * Z, 
            100F, -1F
        });
        O = a(ab);
        if (n)
        {
            break MISSING_BLOCK_LABEL_651;
        }
        l = j1;
        k = i1;
        if (d != null)
        {
            ImageOpCommon.freeNativeBuffer(d);
            d = null;
        }
        d = ImageOpCommon.allocNativeBuffer(k * l * 4);
        V = false;
        int l1 = C;
        int k1 = D;
        l1 = (int)((float)l1 * (M / 100F));
        k1 = (int)((float)k1 * (M / 100F));
        float f1 = (float)l1 / (float)X;
        float f2 = (float)k1 / (float)Y;
        if (f1 >= f2)
        {
            f1 = f2;
        }
        gl10 = new Point((int)((float)X * f1 - 1.0F), (int)(f1 * (float)Y - 1.0F));
        if (((Point) (gl10)).x != i1 || ((Point) (gl10)).y != j1) goto _L4; else goto _L3
_L3:
        if (f) goto _L6; else goto _L5
_L5:
        gl10 = (CameraMainActivity)B;
        gl10.runOnUiThread(new com.socialin.picsin.camera.CameraMainActivity._cls24(gl10));
        if (a == null) goto _L8; else goto _L7
_L7:
        gl10 = a;
        ((com.socialin.camera.opengl.a) (gl10)).c;
        JVM INSTR lookupswitch 6: default 496
    //                   4: 536
    //                   11: 561
    //                   12: 561
    //                   17: 561
    //                   18: 561
    //                   21: 569;
           goto _L8 _L9 _L10 _L10 _L10 _L10 _L11
_L8:
        f = true;
_L6:
        if (B != null)
        {
            gl10 = (CameraMainActivity)B;
            gl10.runOnUiThread(new com.socialin.picsin.camera.CameraMainActivity._cls34(gl10));
            return;
        }
          goto _L1
_L9:
        if (((com.socialin.camera.opengl.a) (gl10)).f != null && ((com.socialin.camera.opengl.a) (gl10)).f.e != 0)
        {
            gl10.v = true;
        }
          goto _L8
_L10:
        gl10.v = true;
          goto _L8
_L11:
        if (((com.socialin.camera.opengl.a) (gl10)).p != null && ((com.socialin.camera.opengl.a) (gl10)).p.i != null)
        {
            gl10.v = true;
        }
          goto _L8
_L4:
        gl10 = new android.widget.LinearLayout.LayoutParams(((Point) (gl10)).x, ((Point) (gl10)).y);
        gl10.gravity = 17;
        CameraMainActivity cameramainactivity = (CameraMainActivity)B;
        if (!cameramainactivity.isFinishing())
        {
            cameramainactivity.runOnUiThread(new com.socialin.picsin.camera.CameraMainActivity._cls22(cameramainactivity, gl10));
        }
          goto _L6
        gl10 = new int[1];
        GLES20.glGenTextures(1, gl10, 0);
        ac = gl10[0];
        GLES20.glBindTexture(3553, ac);
          goto _L6
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eglconfig)
    {
        h = true;
        if (!y)
        {
            f = false;
            gl10 = a;
            ((ac)((com.socialin.camera.opengl.a) (gl10)).b.get(Integer.valueOf(0))).a(((com.socialin.camera.opengl.a) (gl10)).a);
            if (((com.socialin.camera.opengl.a) (gl10)).y == null || !((com.socialin.camera.opengl.a) (gl10)).y.y)
            {
                ((ac)((com.socialin.camera.opengl.a) (gl10)).b.get(Integer.valueOf(1))).a(((com.socialin.camera.opengl.a) (gl10)).a);
                if (((com.socialin.camera.opengl.a) (gl10)).y == null || !((com.socialin.camera.opengl.a) (gl10)).y.y)
                {
                    ((ac)((com.socialin.camera.opengl.a) (gl10)).b.get(Integer.valueOf(2))).a(((com.socialin.camera.opengl.a) (gl10)).a);
                    if (((com.socialin.camera.opengl.a) (gl10)).y == null || !((com.socialin.camera.opengl.a) (gl10)).y.y)
                    {
                        ((ac)((com.socialin.camera.opengl.a) (gl10)).b.get(Integer.valueOf(3))).a(((com.socialin.camera.opengl.a) (gl10)).a);
                        if (((com.socialin.camera.opengl.a) (gl10)).y == null || !((com.socialin.camera.opengl.a) (gl10)).y.y)
                        {
                            ((ac)((com.socialin.camera.opengl.a) (gl10)).b.get(Integer.valueOf(4))).a(((com.socialin.camera.opengl.a) (gl10)).a);
                            if (((com.socialin.camera.opengl.a) (gl10)).y == null || !((com.socialin.camera.opengl.a) (gl10)).y.y)
                            {
                                ((ac)((com.socialin.camera.opengl.a) (gl10)).b.get(Integer.valueOf(5))).a(((com.socialin.camera.opengl.a) (gl10)).a);
                                if (((com.socialin.camera.opengl.a) (gl10)).y == null || !((com.socialin.camera.opengl.a) (gl10)).y.y)
                                {
                                    ((ac)((com.socialin.camera.opengl.a) (gl10)).b.get(Integer.valueOf(7))).a(((com.socialin.camera.opengl.a) (gl10)).a);
                                    if (((com.socialin.camera.opengl.a) (gl10)).y == null || !((com.socialin.camera.opengl.a) (gl10)).y.y)
                                    {
                                        ((ac)((com.socialin.camera.opengl.a) (gl10)).b.get(Integer.valueOf(8))).a(((com.socialin.camera.opengl.a) (gl10)).a);
                                        if (((com.socialin.camera.opengl.a) (gl10)).y == null || !((com.socialin.camera.opengl.a) (gl10)).y.y)
                                        {
                                            ((ac)((com.socialin.camera.opengl.a) (gl10)).b.get(Integer.valueOf(9))).a(((com.socialin.camera.opengl.a) (gl10)).a);
                                            if (((com.socialin.camera.opengl.a) (gl10)).y == null || !((com.socialin.camera.opengl.a) (gl10)).y.y)
                                            {
                                                ((ac)((com.socialin.camera.opengl.a) (gl10)).b.get(Integer.valueOf(10))).a(((com.socialin.camera.opengl.a) (gl10)).a);
                                                if (((com.socialin.camera.opengl.a) (gl10)).y == null || !((com.socialin.camera.opengl.a) (gl10)).y.y)
                                                {
                                                    ((ac)((com.socialin.camera.opengl.a) (gl10)).b.get(Integer.valueOf(11))).a(((com.socialin.camera.opengl.a) (gl10)).a);
                                                    if (((com.socialin.camera.opengl.a) (gl10)).y == null || !((com.socialin.camera.opengl.a) (gl10)).y.y)
                                                    {
                                                        ((ac)((com.socialin.camera.opengl.a) (gl10)).b.get(Integer.valueOf(12))).a(((com.socialin.camera.opengl.a) (gl10)).a);
                                                        if (((com.socialin.camera.opengl.a) (gl10)).y == null || !((com.socialin.camera.opengl.a) (gl10)).y.y)
                                                        {
                                                            ((ac)((com.socialin.camera.opengl.a) (gl10)).b.get(Integer.valueOf(13))).a(((com.socialin.camera.opengl.a) (gl10)).a);
                                                            if (((com.socialin.camera.opengl.a) (gl10)).y == null || !((com.socialin.camera.opengl.a) (gl10)).y.y)
                                                            {
                                                                ((ac)((com.socialin.camera.opengl.a) (gl10)).b.get(Integer.valueOf(14))).a(((com.socialin.camera.opengl.a) (gl10)).a);
                                                                if (((com.socialin.camera.opengl.a) (gl10)).y == null || !((com.socialin.camera.opengl.a) (gl10)).y.y)
                                                                {
                                                                    ((ac)((com.socialin.camera.opengl.a) (gl10)).b.get(Integer.valueOf(15))).a(((com.socialin.camera.opengl.a) (gl10)).a);
                                                                    if (((com.socialin.camera.opengl.a) (gl10)).y == null || !((com.socialin.camera.opengl.a) (gl10)).y.y)
                                                                    {
                                                                        ((ac)((com.socialin.camera.opengl.a) (gl10)).b.get(Integer.valueOf(16))).a(((com.socialin.camera.opengl.a) (gl10)).a);
                                                                        if (((com.socialin.camera.opengl.a) (gl10)).y == null || !((com.socialin.camera.opengl.a) (gl10)).y.y)
                                                                        {
                                                                            ((ac)((com.socialin.camera.opengl.a) (gl10)).b.get(Integer.valueOf(17))).a(((com.socialin.camera.opengl.a) (gl10)).a);
                                                                            if (((com.socialin.camera.opengl.a) (gl10)).y == null || !((com.socialin.camera.opengl.a) (gl10)).y.y)
                                                                            {
                                                                                ((ac)((com.socialin.camera.opengl.a) (gl10)).b.get(Integer.valueOf(18))).a(((com.socialin.camera.opengl.a) (gl10)).a);
                                                                                if (((com.socialin.camera.opengl.a) (gl10)).y == null || !((com.socialin.camera.opengl.a) (gl10)).y.y)
                                                                                {
                                                                                    ((ac)((com.socialin.camera.opengl.a) (gl10)).b.get(Integer.valueOf(19))).a(((com.socialin.camera.opengl.a) (gl10)).a);
                                                                                    if (((com.socialin.camera.opengl.a) (gl10)).y == null || !((com.socialin.camera.opengl.a) (gl10)).y.y)
                                                                                    {
                                                                                        ((ac)((com.socialin.camera.opengl.a) (gl10)).b.get(Integer.valueOf(20))).a(((com.socialin.camera.opengl.a) (gl10)).a);
                                                                                        if (((com.socialin.camera.opengl.a) (gl10)).y == null || !((com.socialin.camera.opengl.a) (gl10)).y.y)
                                                                                        {
                                                                                            ((ac)((com.socialin.camera.opengl.a) (gl10)).b.get(Integer.valueOf(21))).a(((com.socialin.camera.opengl.a) (gl10)).a);
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (!y)
            {
                gl10 = a;
                gl10.t = -1;
                gl10.u = -1;
                gl10.v = false;
                GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
                gl10 = new int[1];
                if (aa > 0)
                {
                    gl10[0] = aa;
                    GLES20.glDeleteTextures(1, gl10, 0);
                }
                GLES20.glGenTextures(1, gl10, 0);
                aa = gl10[0];
                j = a(m);
                GLES20.glBindTexture(3553, aa);
                Matrix.setLookAtM(H, 0, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 5F, 0.0F, 1.0F, 0.0F);
                V = false;
                return;
            }
        }
    }
}
