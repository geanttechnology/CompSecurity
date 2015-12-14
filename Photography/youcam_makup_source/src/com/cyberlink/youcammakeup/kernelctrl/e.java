// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.jniproxy.UIBeautifierCacheMode;
import com.cyberlink.youcammakeup.jniproxy.bi;
import com.cyberlink.youcammakeup.jniproxy.bk;
import com.cyberlink.youcammakeup.jniproxy.bl;
import com.cyberlink.youcammakeup.jniproxy.c;
import com.cyberlink.youcammakeup.jniproxy.f;
import com.cyberlink.youcammakeup.jniproxy.u;
import com.cyberlink.youcammakeup.jniproxy.y;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.b;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.d;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            BeautifierTaskInfo, BeautifierManager, t, VenusHelper, 
//            f

class e extends AsyncTask
{

    BeautifierTaskInfo a;
    final BeautifierManager b;

    public e(BeautifierManager beautifiermanager, BeautifierTaskInfo beautifiertaskinfo)
    {
        b = beautifiermanager;
        super();
        a = null;
        a = new BeautifierTaskInfo(beautifiertaskinfo);
    }

    protected transient Boolean a(d ad[])
    {
        boolean flag1;
        Object obj1;
        Object obj3;
        Object obj5;
        Object obj7;
        y y1;
        long l;
        boolean flag4;
        if (ad[0].b.b() != UIBeautifierCacheMode.a.a())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        synchronized (b)
        {
            com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.a(b, true);
        }
        if (com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.d(b) != null) goto _L2; else goto _L1
_L1:
        l = StatusManager.j().l();
        obj = StatusManager.j().c(l);
        boolean flag;
        boolean flag2;
        boolean flag3;
        boolean flag5;
        if (obj != null && ((com.cyberlink.youcammakeup.kernelctrl.status.d) (obj)).e() != null && ((com.cyberlink.youcammakeup.kernelctrl.status.d) (obj)).e().c() != null)
        {
            obj = com.cyberlink.youcammakeup.kernelctrl.t.a((new StringBuilder()).append(StatusManager.j().I()).append("/").append(((com.cyberlink.youcammakeup.kernelctrl.status.d) (obj)).e().c()).toString(), Boolean.valueOf(false));
        } else
        {
            obj = null;
        }
        obj1 = obj;
        if (obj == null)
        {
            obj = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.e.a().a(Long.valueOf(l), Boolean.valueOf(true));
            obj1 = ViewEngine.a().a(l, 1.0D, ((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.DevelopSetting) (obj)), null);
        }
        obj = StatusManager.j().s();
        obj3 = (new StringBuilder()).append("BeautifierManager BeautifierTask doInbackground imageID = ").append(l).append(", BeautyMode = ");
        if (obj == null)
        {
            obj = "null";
        }
        obj = ((StringBuilder) (obj3)).append(obj).append(", buffer wrapper is null = ");
        if (obj1 == null)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        obj = ((StringBuilder) (obj)).append(flag3).toString();
        Globals.d().e(((String) (obj)));
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        JVM INSTR monitorenter ;
_L4:
        synchronized (b)
        {
            com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.a(b, new ImageBufferWrapper());
            com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.d(b).a(((ImageBufferWrapper) (obj1)));
            com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.b(b, new ImageBufferWrapper());
            BeautifierManager.e(b).a(((ImageBufferWrapper) (obj1)));
        }
        ((ImageBufferWrapper) (obj1)).m();
_L7:
        obj1 = com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.d(b).j();
        obj3 = BeautifierManager.e(b).j();
        if (!BeautifierManager.i(b).get() || !flag1)
        {
            obj = ad[0].a.b();
            flag4 = true & com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.b(b).a(((com.cyberlink.youcammakeup.jniproxy.d) (obj1)), ((com.cyberlink.youcammakeup.jniproxy.d) (obj3)), ad[0].a);
            obj1 = ad[0].a.b();
            if (!((y) (obj)).b(((y) (obj1))))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag2 = flag;
            obj = obj1;
            flag3 = flag4;
            if (flag)
            {
                ad[0].b.a(ad[0].b.c(), ((y) (obj1)));
                flag2 = flag;
                obj = obj1;
                flag3 = flag4;
                if (flag1)
                {
                    com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.a(b, ((y) (obj1)));
                    flag3 = flag4;
                    obj = obj1;
                    flag2 = flag;
                }
            }
        } else
        {
            flag2 = false;
            obj = null;
            flag3 = true;
        }
        synchronized (b)
        {
            if (com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.f(b) != null)
            {
                com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.f(b).m();
            }
            com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.c(b, new ImageBufferWrapper());
            com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.f(b).a(BeautifierManager.e(b));
        }
        obj5 = com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.f(b).j();
        if (BeautifierManager.i(b).get() && BeautifierManager.j(b) != null && !ad[0].b.f())
        {
            ad[0].b.a(ad[0].b.c(), BeautifierManager.j(b));
        }
        flag4 = ad[0].b.l();
        if (ad[0].b() || BeautifierManager.i(b).get())
        {
            if (BeautifierManager.k(b).get())
            {
                obj2 = new bk();
                ((bk) (obj2)).a(ad[0].b.c(), ad[0].b.d());
                com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.c(b).a(((com.cyberlink.youcammakeup.jniproxy.d) (obj3)), ((com.cyberlink.youcammakeup.jniproxy.d) (obj5)), ((bk) (obj2)));
                BeautifierManager.k(b).set(false);
            }
            obj7 = ad[0].b.d();
            flag3 &= com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.c(b).a(((com.cyberlink.youcammakeup.jniproxy.d) (obj3)), ((com.cyberlink.youcammakeup.jniproxy.d) (obj5)), ad[0].b);
            obj2 = ad[0].b.d();
            if (BeautifierManager.j(b) != null && !BeautifierManager.j(b).b(((y) (obj2))))
            {
                com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.a(b, ((y) (obj2)));
            }
            if (!((y) (obj7)).b(((y) (obj2))))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (ad[0].b.e())
            {
                com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.a(b, ad[0].b.g());
            }
            if (ad[0].b.k() && ad[0].b.j() != null)
            {
                obj3 = new bl();
                ad[0].b.a(((bl) (obj3)));
                if (obj3 != null)
                {
                    com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a().a(((bl) (obj3)));
                    if (flag4)
                    {
                        obj3 = new bi();
                        ad[0].b.b(((bi) (obj3)));
                        com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a().a(((bi) (obj3)));
                    }
                    com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a().d();
                }
            }
            ((com.cyberlink.youcammakeup.jniproxy.d) (obj5)).d();
        } else
        {
            obj2 = null;
            flag = false;
        }
        obj3 = ad[0].c.a();
        if (obj3 != null && ((b) (obj3)).a)
        {
            obj5 = ad[0].b.c();
            obj7 = ad[0].b.d();
            com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a().a(((b) (obj3)), ((com.cyberlink.youcammakeup.jniproxy.ai) (obj5)), ((y) (obj7)));
        } else
        {
            com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a().o();
        }
        obj3 = ad[0].c.b();
        if (obj3 != null && ((b) (obj3)).a)
        {
            obj5 = ad[0].b.c();
            obj7 = ad[0].b.d();
            com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a().b(((b) (obj3)), ((com.cyberlink.youcammakeup.jniproxy.ai) (obj5)), ((y) (obj7)));
        } else
        {
            com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a().s();
        }
        obj3 = ad[0].c.c();
        if (obj3 != null && ((b) (obj3)).a)
        {
            obj5 = ad[0].b.c();
            obj7 = ad[0].b.d();
            com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a().c(((b) (obj3)), ((com.cyberlink.youcammakeup.jniproxy.ai) (obj5)), ((y) (obj7)));
        } else
        {
            com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a().w();
        }
        obj3 = ad[0].c.d();
        obj5 = ad[0].c.e();
        if (obj3 != null && obj5 != null && (((b) (obj3)).a || ((b) (obj5)).a))
        {
            obj7 = ad[0].b.c();
            y1 = ad[0].b.d();
            com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a().a(((b) (obj3)), ((b) (obj5)), ((com.cyberlink.youcammakeup.jniproxy.ai) (obj7)), y1);
        } else
        {
            com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a().B();
            com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a().C();
        }
        synchronized (b)
        {
            if (BeautifierManager.g(b) != null)
            {
                BeautifierManager.g(b).m();
            }
            com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.d(b, new ImageBufferWrapper());
            BeautifierManager.g(b).a(com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.f(b));
        }
        if (ad[0].c.f())
        {
            obj5 = ad[0].c.a();
            if (obj5 != null && ((b) (obj5)).a)
            {
                obj4 = Bitmap.createBitmap((int)BeautifierManager.g(b).b(), (int)BeautifierManager.g(b).c(), android.graphics.Bitmap.Config.ARGB_8888);
                BeautifierManager.g(b).c(((Bitmap) (obj4)));
                com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.d.a(((Bitmap) (obj4)), com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a().m(), ((b) (obj5)));
                synchronized (b)
                {
                    if (BeautifierManager.g(b) != null)
                    {
                        BeautifierManager.g(b).m();
                    }
                    com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.d(b, new ImageBufferWrapper());
                    BeautifierManager.g(b).a(((Bitmap) (obj4)));
                }
                ((Bitmap) (obj4)).recycle();
            }
        }
        if (ad[0].c.f())
        {
            obj6 = ad[0].c.b();
            if (obj6 != null && ((b) (obj6)).a)
            {
                obj4 = Bitmap.createBitmap((int)BeautifierManager.g(b).b(), (int)BeautifierManager.g(b).c(), android.graphics.Bitmap.Config.ARGB_8888);
                BeautifierManager.g(b).c(((Bitmap) (obj4)));
                com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.d.a(((Bitmap) (obj4)), com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a().q(), ((b) (obj6)));
                synchronized (b)
                {
                    if (BeautifierManager.g(b) != null)
                    {
                        BeautifierManager.g(b).m();
                    }
                    com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.d(b, new ImageBufferWrapper());
                    BeautifierManager.g(b).a(((Bitmap) (obj4)));
                }
                ((Bitmap) (obj4)).recycle();
            }
        }
        if (ad[0].c.f())
        {
            obj6 = ad[0].c.c();
            if (obj6 != null && ((b) (obj6)).a)
            {
                obj4 = Bitmap.createBitmap((int)BeautifierManager.g(b).b(), (int)BeautifierManager.g(b).c(), android.graphics.Bitmap.Config.ARGB_8888);
                BeautifierManager.g(b).c(((Bitmap) (obj4)));
                com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.d.a(((Bitmap) (obj4)), com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a().u(), ((b) (obj6)));
                synchronized (b)
                {
                    if (BeautifierManager.g(b) != null)
                    {
                        BeautifierManager.g(b).m();
                    }
                    com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.d(b, new ImageBufferWrapper());
                    BeautifierManager.g(b).a(((Bitmap) (obj4)));
                }
                ((Bitmap) (obj4)).recycle();
            }
        }
        if (ad[0].c.f())
        {
            obj6 = ad[0].c.d();
            if (obj6 != null && ((b) (obj6)).a)
            {
                obj4 = Bitmap.createBitmap((int)BeautifierManager.g(b).b(), (int)BeautifierManager.g(b).c(), android.graphics.Bitmap.Config.ARGB_8888);
                BeautifierManager.g(b).c(((Bitmap) (obj4)));
                com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.d.a(((Bitmap) (obj4)), com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a().x(), ((b) (obj6)));
                synchronized (b)
                {
                    if (BeautifierManager.g(b) != null)
                    {
                        BeautifierManager.g(b).m();
                    }
                    com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.d(b, new ImageBufferWrapper());
                    BeautifierManager.g(b).a(((Bitmap) (obj4)));
                }
                ((Bitmap) (obj4)).recycle();
            }
            obj4 = ad[0].c.e();
            if (obj4 != null && ((b) (obj4)).a)
            {
                ad = Bitmap.createBitmap((int)BeautifierManager.g(b).b(), (int)BeautifierManager.g(b).c(), android.graphics.Bitmap.Config.ARGB_8888);
                BeautifierManager.g(b).c(ad);
                com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.d.a(ad, com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a().y(), ((b) (obj4)));
                synchronized (b)
                {
                    if (BeautifierManager.g(b) != null)
                    {
                        BeautifierManager.g(b).m();
                    }
                    com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.d(b, new ImageBufferWrapper());
                    BeautifierManager.g(b).a(ad);
                }
                ad.recycle();
            }
        }
        if (!BeautifierManager.i(b).get())
        {
            if (flag1)
            {
                BeautifierManager.i(b).set(true);
            }
        } else
        if (!flag1)
        {
            BeautifierManager.i(b).set(false);
            com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.a(b, null);
        }
_L8:
        if (flag)
        {
            StatusManager.j().a(((y) (obj2)), false);
            flag5 = flag3;
        } else
        {
            flag5 = flag3;
            if (flag2)
            {
                StatusManager.j().a(((y) (obj)), false);
                flag5 = flag3;
            }
        }
_L6:
        com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.a(b, a);
        synchronized (b)
        {
            com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.a(b, false);
        }
        return Boolean.valueOf(flag5);
        ad;
        obj;
        JVM INSTR monitorexit ;
        throw ad;
        ad;
        m.e("BeautifierManager", (new StringBuilder()).append("BeautifierTask error. e=").append(ad.toString()).toString());
        obj;
        JVM INSTR monitorexit ;
        flag5 = false;
        if (true) goto _L6; else goto _L5
_L5:
        ad;
        obj;
        JVM INSTR monitorexit ;
        throw ad;
_L2:
        if (BeautifierManager.h(b).get() && (!BeautifierManager.i(b).get() || !flag1))
        {
            BeautifierManager.e(b).a(com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.d(b));
            BeautifierManager.h(b).set(false);
        }
          goto _L7
        ad;
        obj2;
        JVM INSTR monitorexit ;
        throw ad;
        ad;
        obj4;
        JVM INSTR monitorexit ;
        throw ad;
        ad;
        obj6;
        JVM INSTR monitorexit ;
        throw ad;
        ad;
        obj6;
        JVM INSTR monitorexit ;
        throw ad;
        ad;
        obj6;
        JVM INSTR monitorexit ;
        throw ad;
        ad;
        obj6;
        JVM INSTR monitorexit ;
        throw ad;
        ad;
        obj4;
        JVM INSTR monitorexit ;
        throw ad;
        obj;
        ad;
        JVM INSTR monitorexit ;
        throw obj;
          goto _L8
    }

    protected void a(Boolean boolean1)
    {
        int i = 0;
        BeautifierManager beautifiermanager = b;
        beautifiermanager;
        JVM INSTR monitorenter ;
        int j;
        if (!BeautifierManager.l(b) && a.b())
        {
            b.b(true);
        }
        a.a(boolean1.booleanValue());
        boolean1 = (com.cyberlink.youcammakeup.kernelctrl.f[])com.cyberlink.youcammakeup.kernelctrl.BeautifierManager.m(b).toArray(new com.cyberlink.youcammakeup.kernelctrl.f[0]);
        j = boolean1.length;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        boolean1[i].a(a);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        beautifiermanager;
        JVM INSTR monitorexit ;
        return;
        boolean1;
        beautifiermanager;
        JVM INSTR monitorexit ;
        throw boolean1;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((d[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }
}
