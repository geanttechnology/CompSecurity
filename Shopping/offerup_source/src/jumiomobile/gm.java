// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.app.Activity;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.os.Vibrator;
import android.view.OrientationEventListener;
import android.view.TextureView;
import android.view.Window;
import com.jumio.commons.camera.ImageData;
import com.jumio.mobile.sdk.environment.Environment;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.custom.NetverifyCustomSDKInterface;
import com.jumio.netverify.sdk.custom.NetverifyCustomScanView;
import com.jumio.netverify.sdk.custom.NetverifyCustomScanViewInterface;
import com.jumio.netverify.sdk.custom.NetverifyDocumentPart;

// Referenced classes of package jumiomobile:
//            ii, s, hv, ao, 
//            v, cw, q, g, 
//            id, hp, mf, gn, 
//            ht, gq, go, gp, 
//            gr, mt, l, hq, 
//            by

public abstract class gm
    implements ii, s
{

    protected mt a;
    protected g b;
    protected l c;
    protected ao d;
    protected OrientationEventListener e;
    protected boolean f;
    protected hq g;
    protected hp h;
    protected id i;
    protected boolean j;
    protected ImageData k;
    protected int l;
    protected ModelTemplate m;
    protected NetverifyDocumentPart n;
    protected NetverifyCustomSDKInterface o;
    protected NetverifyCustomScanViewInterface p;
    protected boolean q;
    protected final Object r = new Object();
    protected hv s;

    public gm(ModelTemplate modeltemplate, NetverifyDocumentPart netverifydocumentpart, NetverifyCustomSDKInterface netverifycustomsdkinterface)
    {
        f = false;
        g = null;
        h = null;
        i = null;
        j = false;
        k = null;
        l = 0;
        n = null;
        q = false;
        s = hv.a;
        m = modeltemplate;
        n = netverifydocumentpart;
        o = netverifycustomsdkinterface;
        d = new ao(modeltemplate.a, v.a);
        k = new ImageData();
        Environment.loadJniInterfaceLib();
        Environment.loadJniImageQualityLib();
        jumiomobile.q.a(new cw());
        modeltemplate.a.getWindow().setFlags(0x1000000, 0x1000000);
        l = (int)System.currentTimeMillis();
    }

    public void A()
    {
        d.j();
    }

    public void a()
    {
    }

    public void a(float f1)
    {
        synchronized (r)
        {
            b.a(k);
            b.d(true);
        }
        k.a(f1);
        e.disable();
        try
        {
            ((Vibrator)m.a.getSystemService("vibrator")).vibrate(100L);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    public void a(Bitmap bitmap, float f1, Runnable runnable)
    {
        i.d();
        c();
    }

    public void a(Bitmap bitmap, Bitmap bitmap1, boolean flag)
    {
    }

    public void a(NetverifyCustomScanView netverifycustomscanview, hq hq, hp hp1, NetverifyCustomScanViewInterface netverifycustomscanviewinterface, boolean flag)
    {
        g = hq;
        h = hp1;
        p = netverifycustomscanviewinterface;
        j = flag;
        if (h == hp.a)
        {
            h = hp.b;
        }
        s = hv.c;
        netverifycustomscanview.removeAllViews();
        mf.a(netverifycustomscanview, m.H);
        d.e();
        b = new g((TextureView)netverifycustomscanview.findViewById(mf.T), this, d, m.M);
        e = new gn(this, m.a, 1);
    }

    public void a(Runnable runnable)
    {
        m.a.runOnUiThread(runnable);
    }

    public void a(String s1)
    {
    }

    public void a(Throwable throwable)
    {
        a(ht.n);
    }

    public void a(by by)
    {
        if (s == hv.a)
        {
            return;
        }
        synchronized (r)
        {
            if (b != null)
            {
                b.a(by);
            }
        }
        return;
        by;
        obj;
        JVM INSTR monitorexit ;
        throw by;
    }

    public void a(l l1)
    {
        c = l1;
        i.a(l1);
        i.e();
        e.enable();
        f = true;
    }

    public void a(boolean flag)
    {
        p.onNetverifyCameraAvailable();
    }

    public void a(boolean flag, boolean flag1)
    {
        a(((Runnable) (new gq(this, flag, flag1))));
    }

    public void a(byte abyte0[])
    {
        if (!j)
        {
            return;
        } else
        {
            abyte0 = jumiomobile.q.a(abyte0, d.f(), c, true);
            a(((Bitmap) (abyte0)), ((Bitmap) (abyte0)), true);
            return;
        }
    }

    public boolean a(ht ht1)
    {
        v();
        a(((Runnable) (new go(this, ht1))));
        return true;
    }

    public void b()
    {
        m.J = g;
    }

    public void b(boolean flag)
    {
        synchronized (r)
        {
            if (b != null)
            {
                b.b(flag);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void c()
    {
        a(new gp(this));
    }

    public void c(boolean flag)
    {
        q = flag;
        a(new gr(this));
    }

    public void d()
    {
        i = id.a(m.a, m, d, this, a, b, g, h);
    }

    public void e()
    {
        if (s == hv.b || s == hv.e)
        {
            return;
        }
        synchronized (r)
        {
            b.k();
        }
        if (i != null)
        {
            i.c();
        }
        if (f)
        {
            e.enable();
        }
        s = hv.d;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void f()
    {
        s = hv.a;
        e.disable();
        synchronized (r)
        {
            b.d(true);
        }
        if (i != null)
        {
            i.d();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void g()
    {
        if (s == hv.d)
        {
            f();
        }
        s = hv.b;
        if (i != null)
        {
            i.b();
        }
        synchronized (r)
        {
            b.d(false);
            b.m();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean h()
    {
        boolean flag = false;
        if (s == hv.a)
        {
            return false;
        }
        synchronized (r)
        {
            if (b != null)
            {
                flag = b.b();
            }
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean i()
    {
        boolean flag = false;
        if (s == hv.a)
        {
            return false;
        }
        synchronized (r)
        {
            if (b != null)
            {
                flag = b.d();
            }
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void j()
    {
        if (s == hv.a)
        {
            return;
        }
        synchronized (r)
        {
            if (b != null)
            {
                b.h();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void k()
    {
        if (s == hv.a)
        {
            return;
        }
        synchronized (r)
        {
            if (b != null)
            {
                b.i();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean l()
    {
        boolean flag = false;
        if (s == hv.a)
        {
            return false;
        }
        synchronized (r)
        {
            if (b != null)
            {
                flag = b.g();
            }
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean m()
    {
        boolean flag = false;
        if (s == hv.a)
        {
            return false;
        }
        synchronized (r)
        {
            if (b != null)
            {
                flag = b.c();
            }
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void n()
    {
        if (s == hv.a)
        {
            return;
        }
        synchronized (r)
        {
            if (b != null)
            {
                break MISSING_BLOCK_LABEL_33;
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        mt mt1;
        boolean flag;
        flag = b.c();
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        mt1 = a;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mt1.setIsFrontCam(flag);
        b.n();
        obj;
        JVM INSTR monitorexit ;
    }

    public boolean o()
    {
        if (s == hv.a)
        {
            return false;
        } else
        {
            return i.g();
        }
    }

    public void onPreviewFrame(byte abyte0[], Camera camera)
    {
        synchronized (r)
        {
            if (!b.e())
            {
                i.a(abyte0);
            }
            b.l();
        }
        return;
        abyte0;
        camera;
        JVM INSTR monitorexit ;
        throw abyte0;
    }

    public void p()
    {
        while (s == hv.a || !i.g()) 
        {
            return;
        }
        i.h();
    }

    public boolean q()
    {
        return d.c();
    }

    public boolean r()
    {
        return d.g();
    }

    public hq s()
    {
        return g;
    }

    public void t()
    {
        i.d();
    }

    public void u()
    {
        i.c();
    }

    public void v()
    {
        s = hv.e;
        synchronized (r)
        {
            b.d(true);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean w()
    {
        return q;
    }

    public mt x()
    {
        return a;
    }

    public id y()
    {
        return i;
    }

    public void z()
    {
        d.k();
    }
}
