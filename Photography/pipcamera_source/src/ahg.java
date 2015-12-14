// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES20;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import jp.co.cyberagent.android.gpuimage.Rotation;

public abstract class ahg
    implements android.opengl.GLSurfaceView.Renderer
{

    protected final float A[] = {
        1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F
    };
    protected float B[] = {
        -1F, 1.0F, 1.0F, 1.0F, -1F, -1F, 1.0F, -1F
    };
    protected boolean C;
    protected long D;
    protected int E;
    protected boolean F;
    private boolean G;
    protected final float a[] = new float[16];
    protected int b;
    protected int c;
    protected int d;
    protected int e;
    protected int f;
    protected SurfaceTexture g;
    protected aev h;
    protected WeakReference i;
    protected aet j;
    protected boolean k;
    protected int l;
    protected int m;
    protected int n;
    protected int o;
    protected final FloatBuffer p;
    protected final FloatBuffer q;
    protected boolean r;
    int s[] = {
        0
    };
    protected int t[] = {
        0, 0, 0, 0
    };
    protected Rotation u;
    protected boolean v;
    protected boolean w;
    protected final float x[] = {
        -1F, -1F, 1.0F, -1F, -1F, 1.0F, 1.0F, 1.0F
    };
    protected final float y[] = {
        0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F
    };
    protected final float z[] = {
        1.0F, 1.0F, -1F, 1.0F, 1.0F, -1F, -1F, -1F
    };

    public ahg(aet aet1)
    {
        g = null;
        h = null;
        i = null;
        j = null;
        r = true;
        u = Rotation.ROTATION_90;
        v = false;
        w = true;
        C = true;
        D = 0L;
        E = 0;
        G = false;
        F = false;
        Log.e("ClassNotFound Test", "BaseSurfaceRenderer start");
        b = -1;
        k = false;
        m = -1;
        l = -1;
        j = aet1;
        p = ByteBuffer.allocateDirect(x.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        p.put(x).position(0);
        q = ByteBuffer.allocateDirect(aes.d.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        q.put(aes.d).position(0);
        Log.e("ClassNotFound Test", "BaseSurfaceRenderer finish");
    }

    private void g()
    {
        c = agv.a("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        if (c == 0)
        {
            throw new RuntimeException("Unable to create program");
        } else
        {
            d = GLES20.glGetAttribLocation(c, "position");
            agv.b(d, "position");
            e = GLES20.glGetAttribLocation(c, "inputTextureCoordinate");
            agv.b(e, "inputTextureCoordinate");
            f = GLES20.glGetUniformLocation(c, "inputImageTexture");
            agv.b(f, "inputImageTexture");
            return;
        }
    }

    protected abstract void a();

    protected void a(float f1)
    {
        int i1;
        int j1;
        int k1;
        int l1;
        if ((float)o / (float)n > f1)
        {
            j1 = n;
            i1 = (int)((float)j1 * f1);
        } else
        {
            i1 = o;
            j1 = (int)((float)i1 / f1);
        }
        k1 = (int)((float)(n - j1) / 2.0F);
        l1 = (int)((float)(o - i1) / 2.0F);
        t[0] = k1;
        t[1] = l1;
        t[2] = j1;
        t[3] = i1;
    }

    protected abstract void a(float f1, float f2);

    public void a(int i1, int j1)
    {
        l = i1;
        m = j1;
        k = true;
    }

    public void a(aeu aeu1)
    {
        if (aeu1 != null)
        {
            i = new WeakReference(aeu1);
        }
    }

    public void a(aev aev1)
    {
        h = aev1;
        if (aev1 != null && g != null)
        {
            aev1.a(this);
        }
    }

    public void a(Camera camera)
    {
        if (camera == null)
        {
            return;
        }
        synchronized (j.a)
        {
            camera.setPreviewTexture(g);
            camera.startPreview();
        }
        return;
        camera;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw camera;
        }
        // Misplaced declaration of an exception variable
        catch (Camera camera)
        {
            Log.e("BaseSurfaceRenderer", camera.toString());
            Crashlytics.logException(camera);
            camera.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Camera camera)
        {
            Log.e("BaseSurfaceRenderer", camera.toString());
        }
        Crashlytics.logException(camera);
        camera.printStackTrace();
        return;
    }

    public void a(boolean flag)
    {
        r = flag;
    }

    public int b()
    {
        return b;
    }

    public void b(int i1, int j1)
    {
        n = i1;
        o = j1;
    }

    public void b(boolean flag)
    {
        r = flag;
        if (i != null && i.get() != null)
        {
            ((aeu)i.get()).g();
        }
    }

    public void c()
    {
        if (g != null)
        {
            synchronized (j.a)
            {
                g.release();
                g = null;
            }
        }
        if (c > 0)
        {
            GLES20.glDeleteProgram(c);
            c = -1;
        }
        m = -1;
        l = -1;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public SurfaceTexture d()
    {
        return g;
    }

    protected void e()
    {
        if (G)
        {
            if (D == 0L)
            {
                D = System.currentTimeMillis();
            }
            if (System.currentTimeMillis() - D > 1000L)
            {
                j.sendMessage(j.obtainMessage(1, E, 0));
                Log.e("CameraGLSurfaceView", (new StringBuilder()).append("mFPSCount = ").append(E).toString());
                G = false;
                D = 0L;
                E = 0;
            }
            E = E + 1;
        }
    }

    protected void f()
    {
        G = true;
    }

    public void onDrawFrame(GL10 gl10)
    {
        F = false;
        try
        {
            g.updateTexImage();
        }
        // Misplaced declaration of an exception variable
        catch (GL10 gl10)
        {
            Log.e("BaseSurfaceRenderer", "IllegalStateException, updateTexImage failed", gl10);
            F = true;
            Crashlytics.logException(gl10);
            return;
        }
        if (k)
        {
            a();
            a(l, m);
            k = false;
        }
        if (l <= 0 || m <= 0)
        {
            Log.i("BaseSurfaceRenderer", "Drawing before incoming texture size set; skipping");
            F = true;
            return;
        }
        g.getTransformMatrix(a);
        if (C)
        {
            f();
            C = false;
        }
        e();
    }

    public void onSurfaceChanged(GL10 gl10, int i1, int j1)
    {
        GLES20.glViewport(0, 0, i1, j1);
        if (j != null)
        {
            j.sendMessage(j.obtainMessage(0, j1, i1));
        }
        Log.e("BaseSurfaceRenderer", (new StringBuilder()).append("captureactivity ").append(i1).append(", ").append(j1).toString());
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eglconfig)
    {
        b = agv.a();
        g = new SurfaceTexture(b);
        if (h != null)
        {
            h.a(this);
        }
        g();
    }
}
