// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Locale;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import jp.co.cyberagent.android.gpuimage.Rotation;
import jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory;

public class ahh extends ahg
{

    public aha G;
    IntBuffer H;
    final int I = 256;
    final int J = 5;
    final int K = 5;
    boolean L;
    private Context M;
    private final FloatBuffer N;
    private final FloatBuffer O;
    private float P;
    private float Q;
    private boolean R;
    private agu S;
    private agg T;
    private aeo U;
    private jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE V;
    private jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE W;
    private jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState X;
    private jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio Y;
    private int Z;
    private int aa;
    private int ab;
    private int ac;
    private boolean ad;

    public ahh(Context context, aet aet)
    {
        super(aet);
        P = 1.0F;
        Q = 0.7F;
        R = false;
        S = null;
        T = null;
        U = null;
        V = null;
        W = null;
        X = jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_TAKE_PHOTO;
        Y = jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio.Ratio_none;
        H = null;
        L = false;
        ab = 0;
        ac = 0;
        ad = true;
        Log.e("ClassNotFound Test", "BeautyCameraSurfaceRenderer super() finish");
        M = context;
        N = ByteBuffer.allocateDirect(x.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        N.put(x).position(0);
        O = ByteBuffer.allocateDirect(aes.d.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        O.put(aes.d).position(0);
        W = null;
        V = null;
        Log.e("ClassNotFound Test", "BeautyCameraSurfaceRenderer finish");
    }

    private void a(int j, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        GLES20.glBindFramebuffer(36160, s[0]);
        GLES20.glViewport(t[0], t[1], t[2], t[3]);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16384);
        S.a();
        floatbuffer.position(0);
        GLES20.glVertexAttribPointer(S.a("position"), 2, 5126, false, 0, floatbuffer);
        GLES20.glEnableVertexAttribArray(S.a("position"));
        floatbuffer = ByteBuffer.allocateDirect(32);
        floatbuffer.order(ByteOrder.nativeOrder());
        floatbuffer = floatbuffer.asFloatBuffer();
        floatbuffer.put(floatbuffer1);
        floatbuffer.position(0);
        GLES20.glVertexAttribPointer(S.a("inputTextureCoordinate"), 2, 5126, false, 0, floatbuffer);
        GLES20.glEnableVertexAttribArray(S.a("inputTextureCoordinate"));
        if (j != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, j);
            GLES20.glUniform1i(S.b("inputImageTexture"), 0);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(S.a("position"));
        GLES20.glDisableVertexAttribArray(S.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
    }

    private void b(int j, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        GLES20.glBindFramebuffer(36160, s[0]);
        GLES20.glViewport(t[0], t[1], t[2], t[3]);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16384);
        S.a();
        d = S.a("position");
        e = S.a("inputTextureCoordinate");
        floatbuffer.position(0);
        GLES20.glVertexAttribPointer(d, 2, 5126, false, 0, floatbuffer);
        GLES20.glEnableVertexAttribArray(d);
        floatbuffer1.position(0);
        GLES20.glVertexAttribPointer(e, 2, 5126, false, 0, floatbuffer1);
        GLES20.glEnableVertexAttribArray(e);
        if (j != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, j);
            GLES20.glUniform1i(S.b("inputImageTexture"), 0);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(d);
        GLES20.glDisableVertexAttribArray(e);
        GLES20.glBindTexture(3553, 0);
    }

    private void b(jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio enumpreviewratio)
    {
        float f;
        int j;
        int k;
        int l;
        int i1;
        if (enumpreviewratio == jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio.Ratio_one2one)
        {
            f = 1.0F;
        } else
        if (enumpreviewratio == jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio.Ratio_four2three)
        {
            f = 1.333333F;
        } else
        {
            f = (float)o / (float)n;
        }
        if ((float)o / (float)n > f)
        {
            k = n;
            j = (int)(f * (float)k);
        } else
        {
            j = o;
            k = (int)((float)j / f);
        }
        l = (int)((float)(n - k) / 2.0F);
        i1 = (int)((float)(o - j) / 2.0F);
        t[0] = l;
        t[1] = i1;
        t[2] = k;
        t[3] = j;
    }

    private boolean i()
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            ActivityManager activitymanager = (ActivityManager)M.getSystemService("activity");
            android.app.ActivityManager.MemoryInfo memoryinfo = new android.app.ActivityManager.MemoryInfo();
            activitymanager.getMemoryInfo(memoryinfo);
            return (float)memoryinfo.totalMem / 1.073742E+09F > 1.0F;
        } else
        {
            return false;
        }
    }

    protected void a()
    {
        if (U != null)
        {
            U.a(l, m);
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
        }
        float af[];
        float af1[];
        if (r)
        {
            af = x;
        } else
        {
            af = z;
        }
        af1 = aes.a(u, v, w);
        p.clear();
        p.put(af).position(0);
        q.clear();
        q.put(af1).position(0);
    }

    public void a(Rotation rotation, boolean flag, boolean flag1)
    {
        v = flag;
        w = flag1;
        u = rotation;
        a(l, m);
    }

    public void a(jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState enumcameracapturestate)
    {
        X = enumcameracapturestate;
    }

    public void a(jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio enumpreviewratio)
    {
        Y = enumpreviewratio;
    }

    public void a(jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE beautycam_filter_type)
    {
        W = beautycam_filter_type;
    }

    public void b(float f)
    {
        Q = f;
    }

    public void c()
    {
        super.c();
        if (U != null)
        {
            U.e();
            U = null;
        }
        if (T != null)
        {
            T.e();
            T = null;
        }
        if (S != null)
        {
            S.a(true);
        }
    }

    public void c(float f)
    {
        P = f;
    }

    public void c(boolean flag)
    {
        R = flag;
    }

    public String g()
    {
        if (M == null)
        {
            return "";
        } else
        {
            return M.getResources().getConfiguration().locale.getLanguage();
        }
    }

    public FloatBuffer h()
    {
        if (o == 0 || n == 0)
        {
            return null;
        }
        float f;
        Object obj;
        float af[];
        int j;
        int k;
        if (Y == jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio.Ratio_one2one)
        {
            f = 1.0F;
        } else
        {
            f = 1.333333F;
        }
        af = new float[8];
        float[] _tmp = af;
        af[0] = 0.0F;
        af[1] = 0.0F;
        af[2] = 1.0F;
        af[3] = 0.0F;
        af[4] = 0.0F;
        af[5] = 1.0F;
        af[6] = 1.0F;
        af[7] = 1.0F;
        j = m;
        k = l;
        if ((float)k / (float)j < f)
        {
            f = (float)(j - (int)((float)k / f)) / (float)(j * 2);
            obj = new float[8];
            obj[0] = af[0] + f;
            obj[1] = af[1];
            obj[2] = af[2] - f;
            obj[3] = af[3];
            obj[4] = af[4] + f;
            obj[5] = af[5];
            obj[6] = af[6] - f;
            obj[7] = af[7];
        } else
        {
            f = (float)(k - (int)(f * (float)j)) / (float)(k * 2);
            obj = new float[8];
            obj[0] = af[0];
            obj[1] = af[1] + f;
            obj[2] = af[2];
            obj[3] = af[3] + f;
            obj[4] = af[4];
            obj[5] = af[5] - f;
            obj[6] = af[6];
            obj[7] = af[7] - f;
        }
        obj = FloatBuffer.wrap(((float []) (obj)));
        ((FloatBuffer) (obj)).position(0);
        return ((FloatBuffer) (obj));
    }

    public void onDrawFrame(GL10 gl10)
    {
        super.onDrawFrame(gl10);
        break MISSING_BLOCK_LABEL_5;
        this;
        JVM INSTR monitorenter ;
        if (G == null)
        {
            break MISSING_BLOCK_LABEL_415;
        }
        agw.a().a(S);
        agw.a().a(N);
        if (gl10 == null)
        {
            break MISSING_BLOCK_LABEL_415;
        }
        gl10 = new ahf(p, q, gl10.d(), l, m);
        G.a(gl10, Y);
        this;
        JVM INSTR monitorexit ;
        return;
        gl10;
        this;
        JVM INSTR monitorexit ;
        throw gl10;
    }

    public void onSurfaceChanged(GL10 gl10, int j, int k)
    {
        super.onSurfaceChanged(gl10, j, k);
        Z = j;
        aa = k;
        if (U != null)
        {
            U.b(j, k);
        }
        if (T != null)
        {
            T.b(j, k);
        }
        Log.e("BeautyCameraSurfaceRenderer", (new StringBuilder()).append("captureactivity ").append(j).append(", ").append(k).toString());
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eglconfig)
    {
        super.onSurfaceCreated(gl10, eglconfig);
        if (U == null && V != null)
        {
            U = GPUImageBeautyFilterFactory.a(M, V);
            U.a();
            U.a(true);
            U.a(P);
        }
        if (T == null)
        {
            T = (agg)GPUImageBeautyFilterFactory.a(M, jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE.BEAUTYCAM_FILTER_SOFTEN);
            T.a();
            T.b(Q);
            T.b(R);
            T.c(true);
            T.a(g());
        }
        S = new agu("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        if (!i())
        {
            L = true;
        }
    }
}
