// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.nio.FloatBuffer;

public final class ceb
    implements Runnable
{

    public boolean a;
    private final Object b = new Object();
    private EGLContext c;
    private boolean d;
    private Object e;
    private int f;
    private int g;
    private long h;
    private FloatBuffer i;
    private FloatBuffer j;
    private jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private cdy s;
    private cdz t;
    private cea u;

    public ceb()
    {
        f = -1;
        a = true;
        i = null;
        j = null;
    }

    public static final ceb a(String s1)
    {
        ceb ceb1 = new ceb();
        Object obj = ceb1.b;
        obj;
        JVM INSTR monitorenter ;
        if (TextUtils.isEmpty(s1))
        {
            s1 = "RenderHandler";
        }
        (new Thread(ceb1, s1)).start();
        try
        {
            ceb1.b.wait();
        }
        // Misplaced declaration of an exception variable
        catch (String s1) { }
        return ceb1;
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
    }

    private final void d()
    {
        e();
        s = new cdy(c, false, d);
        t = s.a(e);
        t.a();
        u = new cea();
        e = null;
        b.notifyAll();
    }

    private final void e()
    {
        if (t != null)
        {
            t.c();
            t = null;
        }
        if (u != null)
        {
            u.a();
            u = null;
        }
        if (s != null)
        {
            s.a();
            s = null;
        }
    }

    public final void a()
    {
label0:
        {
            synchronized (b)
            {
                if (!m)
                {
                    break label0;
                }
            }
            return;
        }
        m = true;
        b.notifyAll();
        try
        {
            b.wait();
        }
        catch (InterruptedException interruptedexception) { }
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a(int i1, cec cec1, jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio enumpreviewratio, long l1)
    {
label0:
        {
            synchronized (b)
            {
                if (!m)
                {
                    break label0;
                }
            }
            return;
        }
        f = i1;
        g = cec1.c;
        q = cec1.d;
        r = cec1.e;
        k = enumpreviewratio;
        i = cec1.a;
        j = cec1.b;
        h = l1;
        n = n + 1;
        b.notifyAll();
        obj;
        JVM INSTR monitorexit ;
        return;
        cec1;
        obj;
        JVM INSTR monitorexit ;
        throw cec1;
    }

    public final void a(EGLContext eglcontext, int i1, Object obj, int j1, int k1, boolean flag)
    {
label0:
        {
            if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture) && !(obj instanceof SurfaceHolder))
            {
                throw new RuntimeException((new StringBuilder()).append("unsupported window type:").append(obj).toString());
            }
            synchronized (b)
            {
                if (!m)
                {
                    break label0;
                }
            }
            return;
        }
        c = eglcontext;
        f = i1;
        e = obj;
        d = flag;
        l = true;
        o = j1;
        p = k1;
        b.notifyAll();
        try
        {
            b.wait();
        }
        // Misplaced declaration of an exception variable
        catch (EGLContext eglcontext) { }
        obj1;
        JVM INSTR monitorexit ;
        return;
        eglcontext;
        obj1;
        JVM INSTR monitorexit ;
        throw eglcontext;
    }

    public final void a(cec cec1, jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio enumpreviewratio, long l1)
    {
        a(f, cec1, enumpreviewratio, l1);
    }

    public void b()
    {
        cdp.a().b[0] = 0;
        cdp.a().b[1] = 0;
        cdp.a().b[2] = o;
        cdp.a().b[3] = p;
    }

    public FloatBuffer c()
    {
        float f1;
        Object obj;
        float af[];
        int i1;
        int j1;
        if (k == jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio.Ratio_one2one)
        {
            f1 = 1.0F;
        } else
        {
            f1 = 1.333333F;
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
        i1 = r;
        j1 = q;
        if ((float)j1 / (float)i1 < f1)
        {
            f1 = (float)(i1 - (int)((float)j1 / f1)) / (float)(i1 * 2);
            obj = new float[8];
            obj[0] = af[0] + f1;
            obj[1] = af[1];
            obj[2] = af[2] - f1;
            obj[3] = af[3];
            obj[4] = af[4] + f1;
            obj[5] = af[5];
            obj[6] = af[6] - f1;
            obj[7] = af[7];
        } else
        {
            f1 = (float)(j1 - (int)(f1 * (float)i1)) / (float)(j1 * 2);
            obj = new float[8];
            obj[0] = af[0];
            obj[1] = af[1] + f1;
            obj[2] = af[2];
            obj[3] = af[3] + f1;
            obj[4] = af[4];
            obj[5] = af[5] - f1;
            obj[6] = af[6];
            obj[7] = af[7] - f1;
        }
        obj = FloatBuffer.wrap(((float []) (obj)));
        ((FloatBuffer) (obj)).position(0);
        return ((FloatBuffer) (obj));
    }

    public final void run()
    {
        synchronized (b)
        {
            m = false;
            l = false;
            n = 0;
            b.notifyAll();
        }
_L5:
        obj = b;
        obj;
        JVM INSTR monitorenter ;
        if (!m) goto _L2; else goto _L1
_L1:
        synchronized (b)
        {
            m = true;
            e();
            b.notifyAll();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        if (l)
        {
            l = false;
            d();
        }
        boolean flag;
        if (n > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        n = n - 1;
        obj;
        JVM INSTR monitorexit ;
        Exception exception1;
        if (flag)
        {
            if (s != null && f >= 0)
            {
                t.a();
                obj = c();
                b();
                cdp.a().a(g, i, ((FloatBuffer) (obj)));
                t.b();
            }
        } else
        {
            synchronized (b)
            {
                b.wait();
            }
        }
        continue; /* Loop/switch isn't completed */
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        JVM INSTR monitorenter ;
        exception2;
        obj;
        JVM INSTR monitorexit ;
        throw exception2;
        InterruptedException interruptedexception;
        interruptedexception;
        obj;
        JVM INSTR monitorexit ;
        if (true) goto _L1; else goto _L3
_L3:
        exception3;
        obj;
        JVM INSTR monitorexit ;
        throw exception3;
        if (true) goto _L5; else goto _L4
_L4:
    }
}
