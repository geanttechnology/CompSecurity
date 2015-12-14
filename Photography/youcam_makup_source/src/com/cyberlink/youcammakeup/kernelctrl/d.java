// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.jniproxy.UIBeautifierCacheMode;
import com.cyberlink.youcammakeup.jniproxy.aa;
import com.cyberlink.youcammakeup.jniproxy.ab;
import com.cyberlink.youcammakeup.jniproxy.ac;
import com.cyberlink.youcammakeup.jniproxy.ad;
import com.cyberlink.youcammakeup.jniproxy.af;
import com.cyberlink.youcammakeup.jniproxy.ag;
import com.cyberlink.youcammakeup.jniproxy.ah;
import com.cyberlink.youcammakeup.jniproxy.ai;
import com.cyberlink.youcammakeup.jniproxy.ak;
import com.cyberlink.youcammakeup.jniproxy.bi;
import com.cyberlink.youcammakeup.jniproxy.bk;
import com.cyberlink.youcammakeup.jniproxy.c;
import com.cyberlink.youcammakeup.jniproxy.f;
import com.cyberlink.youcammakeup.jniproxy.u;
import com.cyberlink.youcammakeup.jniproxy.y;
import com.cyberlink.youcammakeup.jniproxy.z;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.b;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.e;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.utility.o;
import com.pf.common.utility.m;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            t, BeautifierManager, z, VenusHelper, 
//            BeautifierTaskInfo, f

class d extends AsyncTask
{

    BeautifierTaskInfo a;
    final BeautifierManager b;
    private Throwable c;

    public d(BeautifierManager beautifiermanager, BeautifierTaskInfo beautifiertaskinfo)
    {
        b = beautifiermanager;
        super();
        a = null;
        a = beautifiertaskinfo;
    }

    private aa a(aa aa1, float f1, float f2)
    {
        aa1.b().a(aa1.b().b() * f1);
        aa1.b().b(aa1.b().c() * f2);
        return aa1;
    }

    private ab a(ab ab1, float f1, float f2)
    {
        ab ab2 = new ab();
        ab2.b().a(ab1.b().b() * f1);
        ab2.b().b(ab1.b().c() * f2);
        ab2.c().a(ab1.c().b() * f1);
        ab2.c().b(ab1.c().c() * f2);
        return ab2;
    }

    private ac a(ac ac1, float f1, float f2)
    {
        ac1.f().a(ac1.f().b() * f1);
        ac1.f().b(ac1.f().c() * f2);
        ac1.b().a(ac1.b().b() * f1);
        ac1.b().b(ac1.b().c() * f2);
        ac1.c().a(ac1.c().b() * f1);
        ac1.c().b(ac1.c().c() * f2);
        ac1.d().a(ac1.d().b() * f1);
        ac1.d().b(ac1.d().c() * f2);
        ac1.e().a(ac1.e().b() * f1);
        ac1.e().b(ac1.e().c() * f2);
        return ac1;
    }

    private ad a(ad ad1, float f1, float f2)
    {
        ad1.c().a(ad1.c().b() * f1);
        ad1.c().b(ad1.c().c() * f2);
        ad1.b().a(ad1.b().b() * f1);
        ad1.b().b(ad1.b().c() * f2);
        ad1.d().a(ad1.d().b() * f1);
        ad1.d().b(ad1.d().c() * f2);
        return ad1;
    }

    private af a(af af1, float f1, float f2)
    {
        af1.b().a(af1.b().b() * f1);
        af1.b().b(af1.b().c() * f2);
        af1.e().a(af1.e().b() * f1);
        af1.e().b(af1.e().c() * f2);
        af1.c().a(af1.c().b() * f1);
        af1.c().b(af1.c().c() * f2);
        af1.h().a(af1.h().b() * f1);
        af1.h().b(af1.h().c() * f2);
        af1.i().a(af1.i().b() * f1);
        af1.i().b(af1.i().c() * f2);
        af1.j().a(af1.j().b() * f1);
        af1.j().b(af1.j().c() * f2);
        af1.k().a(af1.k().b() * f1);
        af1.k().b(af1.k().c() * f2);
        af1.d().a(af1.d().b() * f1);
        af1.d().b(af1.d().c() * f2);
        af1.f().a(af1.f().b() * f1);
        af1.f().b(af1.f().c() * f2);
        af1.g().a(af1.g().b() * f1);
        af1.g().b(af1.g().c() * f2);
        af1.q().a(af1.q().b() * f1);
        af1.q().b(af1.q().c() * f2);
        af1.p().a(af1.p().b() * f1);
        af1.p().b(af1.p().c() * f2);
        af1.o().a(af1.o().b() * f1);
        af1.o().b(af1.o().c() * f2);
        af1.n().a(af1.n().b() * f1);
        af1.n().b(af1.n().c() * f2);
        af1.m().a(af1.m().b() * f1);
        af1.m().b(af1.m().c() * f2);
        af1.l().a(af1.l().b() * f1);
        af1.l().b(af1.l().c() * f2);
        return af1;
    }

    private ag a(ag ag1, float f1, float f2)
    {
        ag1.c().a(ag1.c().b() * f1);
        ag1.c().b(ag1.c().c() * f2);
        ag1.e().a(ag1.e().b() * f1);
        ag1.e().b(ag1.e().c() * f2);
        ag1.b().a(ag1.b().b() * f1);
        ag1.b().b(ag1.b().c() * f2);
        ag1.d().a(ag1.d().b() * f1);
        ag1.d().b(ag1.d().c() * f2);
        ag1.f().a(ag1.f().b() * f1);
        ag1.f().b(ag1.f().c() * f2);
        return ag1;
    }

    private ak a(ak ak1, float f1, float f2)
    {
        ak1.b().a(ak1.b().b() * f1);
        ak1.b().b(ak1.b().c() * f2);
        ak1.c().a(ak1.c().b() * f1);
        ak1.c().b(ak1.c().c() * f2);
        return ak1;
    }

    private z a(z z1, float f1, float f2)
    {
        z1.b().a(z1.b().b() * f1);
        z1.b().b(z1.b().c() * f2);
        z1.d().a(z1.d().b() * f1);
        z1.d().b(z1.d().c() * f2);
        z1.c().a(z1.c().b() * f1);
        z1.c().b(z1.c().c() * f2);
        z1.e().a(z1.e().b() * f1);
        z1.e().b(z1.e().c() * f2);
        return z1;
    }

    private ImageBufferWrapper a(long l)
    {
        Object obj = StatusManager.j().c(l).e();
        String s = "";
        if (obj != null)
        {
            s = (new StringBuilder()).append(StatusManager.j().J()).append("/").append(((a) (obj)).g()).toString();
        }
        obj = new File(s);
        if (((File) (obj)).exists() && ((File) (obj)).isFile())
        {
            return com.cyberlink.youcammakeup.kernelctrl.t.a(s, Boolean.valueOf(false));
        } else
        {
            return ViewEngine.a().d(l);
        }
    }

    private void a(ai ai1)
    {
        long l = BeautifierManager.d(b).b();
        long l1 = BeautifierManager.d(b).c();
        long l2 = BeautifierManager.n(b).b();
        long l3 = BeautifierManager.n(b).c();
        float f1 = (float)l2 / (float)l;
        float f2 = (float)l3 / (float)l1;
        ai1.a((int)((float)ai1.b() * f1));
        ai1.b((int)((float)ai1.c() * f2));
        ai1.c((int)(f1 * (float)ai1.d()));
        ai1.d((int)((float)ai1.e() * f2));
    }

    private void a(y y1)
    {
        long l = BeautifierManager.d(b).b();
        long l1 = BeautifierManager.d(b).c();
        long l2 = BeautifierManager.n(b).b();
        long l3 = BeautifierManager.n(b).c();
        float f1 = (float)l2 / (float)l;
        float f2 = (float)l3 / (float)l1;
        y1.a(a(y1.d(), f1, f2));
        y1.b(a(y1.e(), f1, f2));
        y1.a(a(y1.j(), f1, f2));
        y1.a(a(y1.k(), f1, f2));
        y1.a(a(y1.h(), f1, f2));
        y1.b(a(y1.i(), f1, f2));
        y1.a(a(y1.l(), f1, f2));
        y1.a(a(y1.f(), f1, f2));
        y1.b(a(y1.g(), f1, f2));
        y1.a(a(y1.b(), f1, f2));
        y1.b(a(y1.c(), f1, f2));
        y1.a(a(y1.m(), f1, f2));
    }

    protected transient Boolean a(com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.d ad1[])
    {
        Object obj2 = null;
        z.l();
        if (ad1[0].b.b() == UIBeautifierCacheMode.a.a());
        synchronized (b)
        {
            com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.a(b, true);
            com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.b(b, true);
        }
        if (BeautifierManager.d(b) != null) goto _L2; else goto _L1
_L1:
        com.cyberlink.youcammakeup.kernelctrl.status.d d1;
        long l;
        l = StatusManager.j().l();
        d1 = StatusManager.j().c(l);
        obj = obj2;
        if (d1 == null)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        obj = obj2;
        if (d1.e() == null)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        obj = obj2;
        if (d1.e().c() != null)
        {
            obj = com.cyberlink.youcammakeup.kernelctrl.t.a((new StringBuilder()).append(StatusManager.j().I()).append("/").append(d1.e().c()).toString(), Boolean.valueOf(false));
        }
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        obj = e.a().a(Long.valueOf(l), Boolean.valueOf(true));
        obj = ViewEngine.a().a(l, 1.0D, ((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.DevelopSetting) (obj)), null);
        obj2 = b;
        obj2;
        JVM INSTR monitorenter ;
        com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.a(b, new ImageBufferWrapper());
        BeautifierManager.d(b).a(((ImageBufferWrapper) (obj)));
_L3:
        ((ImageBufferWrapper) (obj)).m();
_L2:
        if (BeautifierManager.d(b) == null)
        {
            synchronized (b)
            {
                com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.a(b, false);
                com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.b(b, false);
            }
            return Boolean.valueOf(false);
        }
        break MISSING_BLOCK_LABEL_352;
        ad1;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw ad1;
        }
        // Misplaced declaration of an exception variable
        catch (com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.d ad1[])
        {
            c = ad1;
        }
        return Boolean.valueOf(false);
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        m.e("BeautifierManager", (new StringBuilder()).append("BeautifierTask error. e=").append(illegalargumentexception.toString()).toString());
          goto _L3
        ad1;
        obj2;
        JVM INSTR monitorexit ;
        throw ad1;
        exception;
        ad1;
        JVM INSTR monitorexit ;
        throw exception;
        if (BeautifierManager.n(b) != null)
        {
            BeautifierManager.n(b).m();
            com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.e(b, null);
        }
        if (com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.o(b) != null)
        {
            com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.o(b).m();
            com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.f(b, null);
        }
        obj2 = a(StatusManager.j().l());
        if (obj2 != null)
        {
            break MISSING_BLOCK_LABEL_468;
        }
        synchronized (b)
        {
            com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.a(b, false);
            com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.b(b, false);
        }
        return Boolean.valueOf(false);
        exception1;
        ad1;
        JVM INSTR monitorexit ;
        throw exception1;
        synchronized (b)
        {
            com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.e(b, new ImageBufferWrapper());
            BeautifierManager.n(b).a(((ImageBufferWrapper) (obj2)));
            com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.f(b, new ImageBufferWrapper());
            com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.o(b).a(((ImageBufferWrapper) (obj2)));
        }
        float f1;
        boolean flag1;
        ((ImageBufferWrapper) (obj2)).m();
        obj2 = BeautifierManager.n(b).j();
        obj1 = com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.o(b).j();
        long l1 = BeautifierManager.d(b).b();
        long l2 = BeautifierManager.d(b).c();
        long l3 = BeautifierManager.n(b).b();
        long l4 = BeautifierManager.n(b).c();
        f1 = (float)l3 / (float)l1;
        float f2 = (float)l4 / (float)l2;
        Object obj4 = new y(ad1[0].a.b());
        a(((y) (obj4)));
        ad1[0].a.a(((y) (obj4)));
        obj4 = new y(ad1[0].b.d());
        a(((y) (obj4)));
        ai ai1 = new ai(ad1[0].b.c());
        a(ai1);
        ad1[0].b.a(ai1, ((y) (obj4)));
        if (ad1[0].b.n())
        {
            int i = ad1[0].b.p();
            float f3 = ad1[0].b.q();
            int j = ad1[0].b.r();
            obj4 = ad1[0].b.o();
            com.cyberlink.youcammakeup.jniproxy.ae ae = ad1[0].b.s();
            com.cyberlink.youcammakeup.jniproxy.ae ae1 = ad1[0].b.t();
            ad1[0].b.a(i, f3, (int)((float)j * f1), ((com.cyberlink.youcammakeup.jniproxy.s) (obj4)), ae, ae1);
        }
        if (ad1[0].b.k())
        {
            obj4 = new bi();
            ad1[0].b.m();
            ad1[0].b.b(((bi) (obj4)));
            ((bi) (obj4)).a(((bi) (obj4)).b() * f1);
            ad1[0].b.a(((bi) (obj4)));
        }
        if (ad1[0].b.u())
        {
            z z1 = new z();
            obj4 = new z();
            ad1[0].b.a(z1, ((z) (obj4)));
            z1 = a(z1, f1, f2);
            obj4 = a(((z) (obj4)), f1, f2);
            ad1[0].b.b(z1, ((z) (obj4)));
        }
        if (ad1[0].b.v())
        {
            com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a().a(Float.valueOf(f1), Float.valueOf(f2));
        }
        obj4 = ad1[0].a.b();
        flag1 = com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.b(b).a(((com.cyberlink.youcammakeup.jniproxy.d) (obj2)), ((com.cyberlink.youcammakeup.jniproxy.d) (obj1)), ad1[0].a) & true;
        if (((y) (obj4)).b(ad1[0].a.b()));
        if (BeautifierManager.n(b) != null)
        {
            BeautifierManager.n(b).n();
            com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.e(b, null);
        }
        synchronized (b)
        {
            if (BeautifierManager.p(b) != null)
            {
                BeautifierManager.p(b).m();
            }
            BeautifierManager.g(b, new ImageBufferWrapper());
            BeautifierManager.p(b).a(com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.o(b));
        }
        obj3 = BeautifierManager.p(b).j();
        if (ad1[0].b())
        {
            break MISSING_BLOCK_LABEL_1181;
        }
        boolean flag = flag1;
        if (!BeautifierManager.i(b).get())
        {
            break MISSING_BLOCK_LABEL_1212;
        }
        flag = flag1 & com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.c(b).a(((com.cyberlink.youcammakeup.jniproxy.d) (obj1)), ((com.cyberlink.youcammakeup.jniproxy.d) (obj3)), ad1[0].b);
        ((com.cyberlink.youcammakeup.jniproxy.d) (obj3)).d();
        if (com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.o(b) != null)
        {
            com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.o(b).n();
            com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.f(b, null);
        }
        synchronized (b)
        {
            if (BeautifierManager.q(b) != null)
            {
                BeautifierManager.q(b).m();
            }
            BeautifierManager.h(b, new ImageBufferWrapper());
            BeautifierManager.q(b).a(BeautifierManager.p(b));
        }
        if (BeautifierManager.p(b) != null)
        {
            BeautifierManager.p(b).n();
            BeautifierManager.g(b, null);
        }
        if (!ad1[0].c.f())
        {
            break MISSING_BLOCK_LABEL_1511;
        }
        obj3 = ad1[0].c.a();
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_1511;
        }
        if (!((b) (obj3)).a)
        {
            break MISSING_BLOCK_LABEL_1511;
        }
        ((b) (obj3)).j.a(((b) (obj3)).j.b() * f1);
        obj1 = Bitmap.createBitmap((int)BeautifierManager.q(b).b(), (int)BeautifierManager.q(b).c(), android.graphics.Bitmap.Config.ARGB_8888);
        BeautifierManager.q(b).c(((Bitmap) (obj1)));
        com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.d.a(((Bitmap) (obj1)), com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a().m(), ((b) (obj3)));
        synchronized (b)
        {
            if (BeautifierManager.q(b) != null)
            {
                BeautifierManager.q(b).m();
            }
            BeautifierManager.h(b, new ImageBufferWrapper());
            BeautifierManager.q(b).a(((Bitmap) (obj1)));
        }
        ((Bitmap) (obj1)).recycle();
        if (!ad1[0].c.f())
        {
            break MISSING_BLOCK_LABEL_1686;
        }
        obj3 = ad1[0].c.b();
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_1686;
        }
        if (!((b) (obj3)).a)
        {
            break MISSING_BLOCK_LABEL_1686;
        }
        ((b) (obj3)).j.a(((b) (obj3)).j.b() * f1);
        obj1 = Bitmap.createBitmap((int)BeautifierManager.q(b).b(), (int)BeautifierManager.q(b).c(), android.graphics.Bitmap.Config.ARGB_8888);
        BeautifierManager.q(b).c(((Bitmap) (obj1)));
        com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.d.a(((Bitmap) (obj1)), com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a().q(), ((b) (obj3)));
        synchronized (b)
        {
            if (BeautifierManager.q(b) != null)
            {
                BeautifierManager.q(b).m();
            }
            BeautifierManager.h(b, new ImageBufferWrapper());
            BeautifierManager.q(b).a(((Bitmap) (obj1)));
        }
        ((Bitmap) (obj1)).recycle();
        if (!ad1[0].c.f())
        {
            break MISSING_BLOCK_LABEL_1861;
        }
        obj3 = ad1[0].c.c();
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_1861;
        }
        if (!((b) (obj3)).a)
        {
            break MISSING_BLOCK_LABEL_1861;
        }
        ((b) (obj3)).j.a(((b) (obj3)).j.b() * f1);
        obj1 = Bitmap.createBitmap((int)BeautifierManager.q(b).b(), (int)BeautifierManager.q(b).c(), android.graphics.Bitmap.Config.ARGB_8888);
        BeautifierManager.q(b).c(((Bitmap) (obj1)));
        com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.d.a(((Bitmap) (obj1)), com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a().u(), ((b) (obj3)));
        synchronized (b)
        {
            if (BeautifierManager.q(b) != null)
            {
                BeautifierManager.q(b).m();
            }
            BeautifierManager.h(b, new ImageBufferWrapper());
            BeautifierManager.q(b).a(((Bitmap) (obj1)));
        }
        ((Bitmap) (obj1)).recycle();
        if (!ad1[0].c.f())
        {
            break MISSING_BLOCK_LABEL_2220;
        }
        obj3 = ad1[0].c.d();
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_2036;
        }
        if (!((b) (obj3)).a)
        {
            break MISSING_BLOCK_LABEL_2036;
        }
        ((b) (obj3)).j.a(((b) (obj3)).j.b() * f1);
        obj1 = Bitmap.createBitmap((int)BeautifierManager.q(b).b(), (int)BeautifierManager.q(b).c(), android.graphics.Bitmap.Config.ARGB_8888);
        BeautifierManager.q(b).c(((Bitmap) (obj1)));
        com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.d.a(((Bitmap) (obj1)), com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a().x(), ((b) (obj3)));
        synchronized (b)
        {
            if (BeautifierManager.q(b) != null)
            {
                BeautifierManager.q(b).m();
            }
            BeautifierManager.h(b, new ImageBufferWrapper());
            BeautifierManager.q(b).a(((Bitmap) (obj1)));
        }
        ((Bitmap) (obj1)).recycle();
        obj3 = ad1[0].c.e();
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_2199;
        }
        if (!((b) (obj3)).a)
        {
            break MISSING_BLOCK_LABEL_2199;
        }
        ((b) (obj3)).j.a(((b) (obj3)).j.b() * f1);
        obj1 = Bitmap.createBitmap((int)BeautifierManager.q(b).b(), (int)BeautifierManager.q(b).c(), android.graphics.Bitmap.Config.ARGB_8888);
        BeautifierManager.q(b).c(((Bitmap) (obj1)));
        com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.d.a(((Bitmap) (obj1)), com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a().y(), ((b) (obj3)));
        synchronized (b)
        {
            if (BeautifierManager.q(b) != null)
            {
                BeautifierManager.q(b).m();
            }
            BeautifierManager.h(b, new ImageBufferWrapper());
            BeautifierManager.q(b).a(((Bitmap) (obj1)));
        }
        ((Bitmap) (obj1)).recycle();
        if (ad1[0].b.v())
        {
            com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a().a(true, false, null);
        }
        synchronized (b)
        {
            com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.a(b, false);
            com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.b(b, false);
        }
        System.gc();
        com.cyberlink.youcammakeup.kernelctrl.z.m();
        return Boolean.valueOf(flag);
        ad1;
        obj1;
        JVM INSTR monitorexit ;
        throw ad1;
        ad1;
        obj3;
        JVM INSTR monitorexit ;
        throw ad1;
        ad1;
        obj1;
        JVM INSTR monitorexit ;
        throw ad1;
        ad1;
        obj3;
        JVM INSTR monitorexit ;
        throw ad1;
        ad1;
        obj3;
        JVM INSTR monitorexit ;
        throw ad1;
        ad1;
        obj3;
        JVM INSTR monitorexit ;
        throw ad1;
        ad1;
        obj3;
        JVM INSTR monitorexit ;
        throw ad1;
        ad1;
        obj3;
        JVM INSTR monitorexit ;
        throw ad1;
        exception2;
        ad1;
        JVM INSTR monitorexit ;
        throw exception2;
    }

    protected void a(Boolean boolean1)
    {
        if (c != null)
        {
            c.printStackTrace();
            if (Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.o) != null)
            {
                Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.o).runOnUiThread(new Runnable() {

                    final d a;

                    public void run()
                    {
                        o.a(Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.o));
                        (new com.cyberlink.youcammakeup.widgetpool.dialogs.aa(Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.o))).show();
                    }

            
            {
                a = d.this;
                super();
            }
                });
            }
        }
        BeautifierTaskInfo beautifiertaskinfo = new BeautifierTaskInfo(a);
        beautifiertaskinfo.a(boolean1.booleanValue());
        if (BeautifierManager.r(b) != null)
        {
            BeautifierManager.r(b).a(beautifiertaskinfo);
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.d[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }
}
