// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class cci extends byh
{

    private cdn A;
    private cdn B;
    private float C;
    private final float D[] = {
        -1F, 1.0F, 1.0F, 1.0F, -1F, -1F, 1.0F, -1F
    };
    private final int E;
    private final int F;
    private final float G;
    private final float H[] = {
        -1F, -1.333333F, 1.0F, -1.333333F, -1F, 1.333333F, 1.0F, 1.333333F
    };
    private Rect I;
    private Bitmap J;
    private int K;
    private Rect L;
    private Bitmap M;
    private int N;
    private int O[] = {
        -1
    };
    private int P[] = {
        -1
    };
    private int Q[] = {
        -1
    };
    private int R[] = {
        -1
    };
    private int S[] = {
        -1
    };
    private int T[] = {
        -1
    };
    private int U[] = {
        -1
    };
    private int V[] = {
        -1
    };
    public final Object a;
    FloatBuffer b;
    FloatBuffer c;
    float d[];
    float e[];
    FloatBuffer f;
    FloatBuffer g;
    protected int w;
    protected int x;
    private cdn y;
    private cdn z;

    public cci()
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        C = 1.0F;
        a = new Object();
        E = 480;
        F = 480;
        G = 0.75F;
        I = null;
        J = null;
        K = -1;
        L = null;
        M = null;
        N = -1;
        d = new float[8];
        e = new float[8];
        f = null;
        g = null;
        w = 0;
        x = 0;
        j();
    }

    public cci(float f1)
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        C = 1.0F;
        a = new Object();
        E = 480;
        F = 480;
        G = 0.75F;
        I = null;
        J = null;
        K = -1;
        L = null;
        M = null;
        N = -1;
        d = new float[8];
        e = new float[8];
        f = null;
        g = null;
        w = 0;
        x = 0;
        b(f1);
        j();
    }

    static int a(cci cci1, int i)
    {
        cci1.N = i;
        return i;
    }

    static Bitmap a(cci cci1)
    {
        return cci1.M;
    }

    private Rect a(Rect rect, float f1)
    {
        rect = new Rect(rect);
        if ((float)(rect.width() / rect.height()) > f1)
        {
            rect.inset(0, (int)(-(((float)rect.width() / f1 - (float)rect.height()) / 2.0F)));
            return rect;
        } else
        {
            rect.inset((int)(-(((float)rect.height() * f1 - (float)rect.width()) / 2.0F)), 0);
            return rect;
        }
    }

    static void a(int i, int i1, int ai[], int ai1[])
    {
        if (ai1[0] != -1)
        {
            GLES20.glDeleteTextures(1, ai1, 0);
            ai1[0] = -1;
        }
        if (ai[0] != -1)
        {
            GLES20.glDeleteFramebuffers(1, ai, 0);
            ai[0] = -1;
        }
        GLES20.glGenFramebuffers(1, ai, 0);
        GLES20.glBindFramebuffer(36160, ai[0]);
        GLES20.glGenTextures(1, ai1, 0);
        GLES20.glBindTexture(3553, ai1[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6408, i, i1, 0, 6408, 5121, null);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, ai1[0], 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    private void a(Rect rect, Rect rect1, float af[])
    {
        if (af == null)
        {
            return;
        } else
        {
            rect = new RectF(rect);
            Matrix matrix = new Matrix();
            matrix.setScale(2.0F / (float)rect1.width(), 2.0F / (float)rect1.height());
            matrix.mapRect(rect);
            matrix = new Matrix();
            matrix.setTranslate(-((float)rect1.width() / 2.0F + (float)rect1.left) / ((float)rect1.width() / 2.0F), -((float)rect1.height() / 2.0F + (float)rect1.top) / ((float)rect1.height() / 2.0F));
            matrix.mapRect(rect);
            af[0] = ((RectF) (rect)).left;
            af[1] = -((RectF) (rect)).top;
            af[2] = ((RectF) (rect)).right;
            af[3] = -((RectF) (rect)).top;
            af[4] = ((RectF) (rect)).left;
            af[5] = -((RectF) (rect)).bottom;
            af[6] = ((RectF) (rect)).right;
            af[7] = -((RectF) (rect)).bottom;
            return;
        }
    }

    static int b(cci cci1)
    {
        return cci1.N;
    }

    static int b(cci cci1, int i)
    {
        cci1.K = i;
        return i;
    }

    static Bitmap c(cci cci1)
    {
        return cci1.J;
    }

    private void c(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        y.a();
        GLES20.glBindFramebuffer(36160, S[0]);
        GLES20.glViewport(0, 0, 480, 480);
        GLES20.glClearColor(0.3F, 0.3F, 0.3F, 1.0F);
        GLES20.glClear(16384);
        if (i != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(y.b("inputImageTexture"), 0);
        }
        c.position(0);
        GLES20.glEnableVertexAttribArray(y.a("position"));
        GLES20.glVertexAttribPointer(y.a("position"), 2, 5126, false, 0, c);
        floatbuffer1.position(0);
        GLES20.glEnableVertexAttribArray(y.a("inputTextureCoordinate"));
        GLES20.glVertexAttribPointer(y.a("inputTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(y.a("position"));
        GLES20.glDisableVertexAttribArray(y.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
    }

    static int d(cci cci1)
    {
        return cci1.K;
    }

    private void d(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        y.a();
        GLES20.glBindFramebuffer(36160, O[0]);
        GLES20.glViewport(0, 0, 480, 480);
        GLES20.glClearColor(0.3F, 0.3F, 0.3F, 1.0F);
        GLES20.glClear(16384);
        if (i != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(y.b("inputImageTexture"), 0);
        }
        f.position(0);
        GLES20.glEnableVertexAttribArray(y.a("position"));
        GLES20.glVertexAttribPointer(y.a("position"), 2, 5126, false, 0, f);
        floatbuffer1.position(0);
        GLES20.glEnableVertexAttribArray(y.a("inputTextureCoordinate"));
        GLES20.glVertexAttribPointer(y.a("inputTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(y.a("position"));
        GLES20.glDisableVertexAttribArray(y.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
    }

    private void e(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        z.a();
        GLES20.glBindFramebuffer(36160, U[0]);
        GLES20.glViewport(0, 0, 480, 480);
        GLES20.glClearColor(0.5F, 0.5F, 0.5F, 1.0F);
        GLES20.glClear(16384);
        if (i != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, T[0]);
            GLES20.glUniform1i(z.b("inputImageTexture"), 0);
        }
        floatbuffer.position(0);
        GLES20.glEnableVertexAttribArray(z.a("position"));
        GLES20.glVertexAttribPointer(z.a("position"), 2, 5126, false, 0, floatbuffer);
        floatbuffer1.position(0);
        GLES20.glEnableVertexAttribArray(z.a("inputTextureCoordinate"));
        GLES20.glVertexAttribPointer(z.a("inputTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
        GLES20.glUniform1f(z.b("step_w"), (C * 2.5F) / 480F);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(z.a("position"));
        GLES20.glDisableVertexAttribArray(z.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
        A.a();
        GLES20.glBindFramebuffer(36160, S[0]);
        GLES20.glViewport(0, 0, 480, 480);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16384);
        floatbuffer.position(0);
        GLES20.glEnableVertexAttribArray(A.a("position"));
        GLES20.glVertexAttribPointer(A.a("position"), 2, 5126, false, 0, floatbuffer);
        floatbuffer1.position(0);
        GLES20.glEnableVertexAttribArray(A.a("inputTextureCoordinate"));
        GLES20.glVertexAttribPointer(A.a("inputTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
        if (V[0] != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, V[0]);
            GLES20.glUniform1i(A.b("inputImageTexture"), 0);
        }
        GLES20.glUniform1f(A.b("step_h"), (C * 2.5F) / 480F);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(A.a("position"));
        GLES20.glDisableVertexAttribArray(A.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
    }

    private void j()
    {
        b = ByteBuffer.allocateDirect(D.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        b.put(D).position(0);
        c = ByteBuffer.allocateDirect(H.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        c.put(H).position(0);
    }

    private void k()
    {
        Rect rect = new Rect(I);
        Rect rect1 = new Rect(L);
        a(a(rect1, 0.75F), rect1, e);
        f = ByteBuffer.allocateDirect(e.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        f.put(e).position(0);
        a(rect1, rect, d);
        g = ByteBuffer.allocateDirect(d.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        g.put(d).position(0);
    }

    private void l()
    {
        m();
    }

    private void m()
    {
        if (M == null)
        {
            return;
        } else
        {
            a(new ccj(this));
            return;
        }
    }

    private void n()
    {
        if (N != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                N
            }, 0);
            N = -1;
        }
        if (K != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                K
            }, 0);
            K = -1;
        }
    }

    private void o()
    {
        if (O[0] >= 0)
        {
            GLES20.glDeleteFramebuffers(1, O, 0);
            O[0] = -1;
        }
        if (Q[0] >= 0)
        {
            GLES20.glDeleteFramebuffers(1, Q, 0);
            Q[0] = -1;
        }
        if (S[0] >= 0)
        {
            GLES20.glDeleteFramebuffers(1, S, 0);
            S[0] = -1;
        }
        if (U[0] >= 0)
        {
            GLES20.glDeleteFramebuffers(1, U, 0);
            U[0] = -1;
        }
        if (O[0] != -1)
        {
            GLES20.glDeleteTextures(1, O, 0);
            O[0] = -1;
        }
        if (R[0] != -1)
        {
            GLES20.glDeleteTextures(1, R, 0);
            R[0] = -1;
        }
        if (T[0] != -1)
        {
            GLES20.glDeleteTextures(1, T, 0);
            T[0] = -1;
        }
        if (V[0] != -1)
        {
            GLES20.glDeleteTextures(1, V, 0);
            V[0] = -1;
        }
    }

    public void a()
    {
        super.a();
    }

    public void a(float f1)
    {
        u = f1;
    }

    public void a(int i, int i1)
    {
        super.a(i, i1);
        while (i == 0 || i1 == 0 || w == i && x == i1) 
        {
            return;
        }
        w = i;
        x = i1;
        o();
        a(480, 480, O, P);
        a(x, w, Q, R);
        a(480, 480, S, T);
        a(480, 480, U, V);
    }

    public void a(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        h();
        if (p)
        {
            c(i, floatbuffer, floatbuffer1);
            e(T[0], floatbuffer, floatbuffer1);
            d(i, floatbuffer, floatbuffer1);
            y.a();
            GLES20.glBindFramebuffer(36160, Q[0]);
            GLES20.glViewport(0, 0, x, w);
            if (T[0] != -1)
            {
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, T[0]);
                GLES20.glUniform1i(y.b("inputImageTexture"), 0);
            }
            floatbuffer.position(0);
            GLES20.glEnableVertexAttribArray(y.a("position"));
            GLES20.glVertexAttribPointer(y.a("position"), 2, 5126, false, 0, floatbuffer);
            floatbuffer1.position(0);
            GLES20.glEnableVertexAttribArray(y.a("inputTextureCoordinate"));
            GLES20.glVertexAttribPointer(y.a("inputTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(y.a("position"));
            GLES20.glDisableVertexAttribArray(y.a("inputTextureCoordinate"));
            GLES20.glBindTexture(3553, 0);
            GLES20.glUseProgram(0);
            if (N != -1)
            {
                B.a();
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, P[0]);
                GLES20.glUniform1i(B.b("inputImageTexture"), 0);
                GLES20.glActiveTexture(33985);
                GLES20.glBindTexture(3553, N);
                GLES20.glUniform1i(B.b("inputImageTextureMask"), 1);
                GLES20.glEnable(3042);
                GLES20.glBlendFunc(770, 771);
                g.position(0);
                GLES20.glEnableVertexAttribArray(B.a("position"));
                GLES20.glVertexAttribPointer(B.a("position"), 2, 5126, false, 0, g);
                floatbuffer1.position(0);
                GLES20.glEnableVertexAttribArray(B.a("inputTextureCoordinate"));
                GLES20.glVertexAttribPointer(B.a("inputTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
                GLES20.glDrawArrays(5, 0, 4);
                GLES20.glDisableVertexAttribArray(B.a("position"));
                GLES20.glDisableVertexAttribArray(B.a("inputTextureCoordinate"));
                GLES20.glBindTexture(3553, 0);
                GLES20.glDisable(3042);
                GLES20.glUseProgram(0);
            }
            if (K != -1)
            {
                y.a();
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, K);
                GLES20.glUniform1i(y.b("inputImageTexture"), 0);
                GLES20.glEnable(3042);
                GLES20.glBlendFunc(1, 771);
                b.position(0);
                GLES20.glEnableVertexAttribArray(y.a("position"));
                GLES20.glVertexAttribPointer(y.a("position"), 2, 5126, false, 0, b);
                floatbuffer1.position(0);
                GLES20.glEnableVertexAttribArray(y.a("inputTextureCoordinate"));
                GLES20.glVertexAttribPointer(y.a("inputTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
                GLES20.glDrawArrays(5, 0, 4);
                GLES20.glDisableVertexAttribArray(y.a("position"));
                GLES20.glDisableVertexAttribArray(y.a("inputTextureCoordinate"));
                GLES20.glBindTexture(3553, 0);
                GLES20.glDisable(3042);
                GLES20.glUseProgram(0);
                return;
            }
        }
    }

    public void a(Bitmap bitmap, Rect rect, Bitmap bitmap1, Rect rect1)
    {
        n();
        J = bitmap;
        I = rect;
        M = bitmap1;
        L = rect1;
        k();
    }

    public void b(float f1)
    {
        if (f1 > 0.1F) goto _L2; else goto _L1
_L1:
        float f2 = 0.1F;
_L4:
        C = f2;
        return;
_L2:
        f2 = f1;
        if (f1 >= 5F)
        {
            f2 = 5F;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void b(int i, int i1)
    {
        while (n == i && o == i1 || i == 0 || i1 == 0) 
        {
            return;
        }
        n = i;
        o = i1;
    }

    public void c()
    {
        super.c();
        y = new cdn("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        z = new cdn("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "uniform sampler2D inputImageTexture; \nuniform highp float step_w; \nvarying highp vec2 textureCoordinate;\n \nvoid main() \n{ \n lowp int halfValue = 4; \n lowp vec4 sum1 = vec4(0.0); \n lowp vec4 t1 = texture2D(inputImageTexture, textureCoordinate + vec2(float(halfValue)*step_w, 0.0)); \n lowp vec4 t2 = texture2D(inputImageTexture, textureCoordinate + vec2(float(halfValue - 1)*step_w, 0.0)); \n lowp vec4 t3 = texture2D(inputImageTexture, textureCoordinate + vec2(float(halfValue - 2)*step_w, 0.0)); \n lowp vec4 t4 = texture2D(inputImageTexture, textureCoordinate + vec2(float(halfValue - 3)*step_w, 0.0)); \n lowp vec4 t5 = texture2D(inputImageTexture, textureCoordinate + vec2(float(halfValue - 4)*step_w, 0.0)); \n lowp vec4 t6 = texture2D(inputImageTexture, textureCoordinate + vec2(float(halfValue - 5)*step_w, 0.0)); \n lowp vec4 t7 = texture2D(inputImageTexture, textureCoordinate + vec2(float(halfValue - 6)*step_w, 0.0)); \n lowp vec4 t8 = texture2D(inputImageTexture, textureCoordinate + vec2(float(halfValue - 7)*step_w, 0.0)); \n lowp vec4 t9 = texture2D(inputImageTexture, textureCoordinate + vec2(float(halfValue - 8)*step_w, 0.0)); \n sum1 += t1*0.0394232; \n sum1 += t2*0.0779794; \n sum1 += t3*0.126999; \n sum1 += t4*0.170303; \n sum1 += t5*0.170591; \n sum1 += t6*0.170303; \n sum1 += t7*0.126999; \n sum1 += t8*0.0779794; \n sum1 += t9*0.0394232; \n gl_FragColor = sum1; \n} \n");
        A = new cdn("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "uniform sampler2D inputImageTexture; \nuniform highp float step_h; \nvarying highp vec2 textureCoordinate;\n \nvoid main() \n{ \n lowp int halfValue = 4; \n lowp vec4 sum1 = vec4(0.0); \n lowp vec4 t1 = texture2D(inputImageTexture, textureCoordinate + vec2(0.0, float(halfValue)*step_h)); \n lowp vec4 t2 = texture2D(inputImageTexture, textureCoordinate + vec2(0.0, float(halfValue - 1)*step_h)); \n lowp vec4 t3 = texture2D(inputImageTexture, textureCoordinate + vec2(0.0, float(halfValue - 2)*step_h)); \n lowp vec4 t4 = texture2D(inputImageTexture, textureCoordinate + vec2(0.0, float(halfValue - 3)*step_h)); \n lowp vec4 t5 = texture2D(inputImageTexture, textureCoordinate + vec2(0.0, float(halfValue - 4)*step_h)); \n lowp vec4 t6 = texture2D(inputImageTexture, textureCoordinate + vec2(0.0, float(halfValue - 5)*step_h)); \n lowp vec4 t7 = texture2D(inputImageTexture, textureCoordinate + vec2(0.0, float(halfValue - 6)*step_h)); \n lowp vec4 t8 = texture2D(inputImageTexture, textureCoordinate + vec2(0.0, float(halfValue - 7)*step_h)); \n lowp vec4 t9 = texture2D(inputImageTexture, textureCoordinate + vec2(0.0, float(halfValue - 8)*step_h)); \n sum1 += t1*0.0394232; \n sum1 += t2*0.0779794; \n sum1 += t3*0.126999; \n sum1 += t4*0.170303; \n sum1 += t5*0.170591; \n sum1 += t6*0.170303; \n sum1 += t7*0.126999; \n sum1 += t8*0.0779794; \n sum1 += t9*0.0394232; \n gl_FragColor = sum1; \n} \n");
        B = new cdn("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "uniform sampler2D inputImageTexture; \nuniform sampler2D inputImageTextureMask; \nvarying highp vec2 textureCoordinate;\n \nvoid main() \n{ \n\tlowp vec4 c = texture2D(inputImageTexture, textureCoordinate); \n   c.a = texture2D(inputImageTextureMask, textureCoordinate).a; \n\tgl_FragColor = c; \n} \n");
        l();
    }

    public void d()
    {
        super.d();
        n();
        y.a(true);
        z.a(true);
        A.a(true);
        B.a(true);
        o();
    }

    public int f()
    {
        return R[0];
    }
}
