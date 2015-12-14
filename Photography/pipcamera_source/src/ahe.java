// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.nio.FloatBuffer;

public final class ahe
    implements Runnable
{

    private final Object a;
    private EGLContext b;
    private boolean c;
    private Object d;
    private int e;
    private int f;
    private long g;
    private FloatBuffer h;
    private FloatBuffer i;
    private jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private ahb r;
    private ahc s;
    private ahd t;

    private final void d()
    {
        e();
        r = new ahb(b, false, c);
        s = r.a(d);
        s.a();
        t = new ahd();
        d = null;
        a.notifyAll();
    }

    private final void e()
    {
        if (s != null)
        {
            s.c();
            s = null;
        }
        if (t != null)
        {
            t.a();
            t = null;
        }
        if (r != null)
        {
            r.a();
            r = null;
        }
    }

    public final void a()
    {
label0:
        {
            synchronized (a)
            {
                if (!l)
                {
                    break label0;
                }
            }
            return;
        }
        l = true;
        a.notifyAll();
        try
        {
            a.wait();
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

    public final void a(int i1, ahf ahf1, jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio enumpreviewratio, long l1)
    {
label0:
        {
            synchronized (a)
            {
                if (!l)
                {
                    break label0;
                }
            }
            return;
        }
        e = i1;
        f = ahf1.c;
        p = ahf1.d;
        q = ahf1.e;
        j = enumpreviewratio;
        h = ahf1.a;
        i = ahf1.b;
        g = l1;
        m = m + 1;
        a.notifyAll();
        obj;
        JVM INSTR monitorexit ;
        return;
        ahf1;
        obj;
        JVM INSTR monitorexit ;
        throw ahf1;
    }

    public final void a(ahf ahf1, jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio enumpreviewratio, long l1)
    {
        a(e, ahf1, enumpreviewratio, l1);
    }

    public final void a(EGLContext eglcontext, int i1, Object obj, int j1, int k1, boolean flag)
    {
label0:
        {
            if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture) && !(obj instanceof SurfaceHolder))
            {
                throw new RuntimeException((new StringBuilder()).append("unsupported window type:").append(obj).toString());
            }
            synchronized (a)
            {
                if (!l)
                {
                    break label0;
                }
            }
            return;
        }
        b = eglcontext;
        e = i1;
        d = obj;
        c = flag;
        k = true;
        n = j1;
        o = k1;
        a.notifyAll();
        try
        {
            a.wait();
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

    public void b()
    {
        agw.a().b[0] = 0;
        agw.a().b[1] = 0;
        agw.a().b[2] = n;
        agw.a().b[3] = o;
    }

    public FloatBuffer c()
    {
        float f1;
        Object obj;
        float af[];
        int i1;
        int j1;
        if (j == jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio.Ratio_one2one)
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
        i1 = q;
        j1 = p;
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
        synchronized (a)
        {
            l = false;
            k = false;
            m = 0;
            a.notifyAll();
        }
_L5:
        obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (!l) goto _L2; else goto _L1
_L1:
        synchronized (a)
        {
            l = true;
            e();
            a.notifyAll();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        if (k)
        {
            k = false;
            d();
        }
        boolean flag;
        if (m > 0)
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
        m = m - 1;
        obj;
        JVM INSTR monitorexit ;
        Exception exception1;
        if (flag)
        {
            if (r != null && e >= 0)
            {
                s.a();
                obj = c();
                b();
                agw.a().a(f, h, ((FloatBuffer) (obj)));
                s.b();
            }
        } else
        {
            synchronized (a)
            {
                a.wait();
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
