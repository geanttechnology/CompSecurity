// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Locale;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory;

public class ahi extends ahg
{

    private Context G;
    private float H;
    private Bitmap I;
    private Bitmap J;
    private String K;
    private String L;
    private Rect M;
    private int N;
    private int O;
    private boolean P;
    private final FloatBuffer Q;
    private final FloatBuffer R;
    private agc S;
    private agg T;

    public ahi(Context context, aet aet)
    {
        super(aet);
        H = 1.0F;
        I = null;
        J = null;
        K = null;
        L = null;
        N = 612;
        O = 612;
        P = false;
        S = null;
        T = null;
        G = context;
        Q = ByteBuffer.allocateDirect(x.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        Q.put(x).position(0);
        R = ByteBuffer.allocateDirect(aes.d.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        R.put(aes.d).position(0);
    }

    private void a(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        GLES20.glBindFramebuffer(36160, s[0]);
        GLES20.glUseProgram(c);
        GLES20.glViewport(t[0], t[1], t[2], t[3]);
        GLES20.glClearColor(1.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16384);
        floatbuffer.position(0);
        GLES20.glVertexAttribPointer(d, 2, 5126, false, 0, floatbuffer);
        GLES20.glEnableVertexAttribArray(d);
        floatbuffer1.position(0);
        GLES20.glVertexAttribPointer(e, 2, 5126, false, 0, floatbuffer1);
        GLES20.glEnableVertexAttribArray(e);
        if (i != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(f, 0);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(d);
        GLES20.glDisableVertexAttribArray(e);
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
    }

    protected void a()
    {
        if (S != null)
        {
            S.a(l, m);
        }
        if (T != null)
        {
            T.a(l, m);
        }
    }

    protected void a(float f, float f1)
    {
        if (f == 0.0F || f1 == 0.0F)
        {
            return;
        } else
        {
            float af[] = aes.a(y, u);
            p.clear();
            p.put(x).position(0);
            q.clear();
            q.put(af).position(0);
            return;
        }
    }

    public void a(Bitmap bitmap)
    {
        I = bitmap;
        P = true;
    }

    public void a(Bitmap bitmap, Rect rect)
    {
        J = bitmap;
        M = rect;
        P = true;
    }

    public void b(float f)
    {
        H = f;
    }

    public void c()
    {
        super.c();
        if (S != null)
        {
            synchronized (S.p)
            {
                if (I != null)
                {
                    I.recycle();
                    I = null;
                }
                if (J != null)
                {
                    J.recycle();
                    J = null;
                }
            }
            S.e();
            S = null;
        }
        if (T != null)
        {
            T.e();
            T = null;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void c(int i, int j)
    {
        N = i;
        O = j;
    }

    public String g()
    {
        if (G == null)
        {
            return "";
        } else
        {
            return G.getResources().getConfiguration().locale.getLanguage();
        }
    }

    public void onDrawFrame(GL10 gl10)
    {
        super.onDrawFrame(gl10);
        if (!super.F)
        {
            GLES20.glGetIntegerv(36006, s, 0);
            GLES20.glGetIntegerv(2978, t, 0);
            if (T != null)
            {
                T.a(a);
                T.a(b, p, q);
            }
            if (S != null)
            {
                if (P)
                {
                    S.b(H);
                    S.a(I, new Rect(0, 0, N, O), J, M);
                    S.a();
                    P = false;
                }
                S.a(T.d(), Q, R);
                a(1.0F);
                a(S.d(), Q, R);
                return;
            }
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i, int j)
    {
        super.onSurfaceChanged(gl10, i, j);
        if (S != null)
        {
            S.b(i, j);
        }
        if (T != null)
        {
            T.b(i, j);
        }
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eglconfig)
    {
        super.onSurfaceCreated(gl10, eglconfig);
        if (S == null)
        {
            S = new agc(H);
            S.a(aeh.a(G, "pipFrame/bottle.png"), new Rect(0, 0, 612, 612), aeh.a(G, "pipFrame/bottle_mask.png"), new Rect(59, 30, 335, 612));
            S.a();
        }
        if (T == null)
        {
            T = (agg)GPUImageBeautyFilterFactory.a(G, jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SOFTEN);
            T.a();
            T.b(0.0F);
            T.c(true);
            T.a(g());
        }
    }
}
