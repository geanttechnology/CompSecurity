// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.animation.Animator;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.clflurry.YMKFeatures;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.q;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.s;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.j;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ae;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.SkuTemplateUtils;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.utility.az;
import com.cyberlink.youcammakeup.utility.ch;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            o, BeautyToolPanel, n

public class i extends com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.o
{

    public i()
    {
    }

    protected void a()
    {
        this.k = Globals.d().t();
        b = (ImageView)g.findViewById(0x7f0c064b);
        c = (ImageView)g.findViewById(0x7f0c064c);
        d = (TextView)g.findViewById(0x7f0c064e);
        e = g.findViewById(0x7f0c064d);
        Object obj1 = StatusManager.j().s();
        com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i k = StatusManager.j().d();
        float f = m.J();
        float f1 = m.L();
        q = true;
        long l = StatusManager.j().l();
        Object obj;
        if (this.k.p())
        {
            obj = this.k.r();
        } else
        {
            obj = StatusManager.j().f(l);
        }
        MotionControlHelper.e().a(((a) (obj)));
        MotionControlHelper.e().a(this.f, f);
        j.a().e();
        if (k != null && k.a() != null && k.a().c() != null)
        {
            obj = k.a().c();
            f = k.a().g();
            f1 = k.a().a();
            q = a(((BeautyMode) (obj1)), k);
        } else
        if (this.f != null)
        {
            obj = SkuTemplateUtils.e(h.b().a(this.f.b(), this.f.a()).d());
        } else
        {
            obj = PanelDataCenter.a().a(((BeautyMode) (obj1)), 1);
        }
        a = PanelDataCenter.a().i(((String) (obj)));
        if (a == null)
        {
            q = false;
            return;
        }
        obj1 = a.i();
        ((n)m).a(a, true);
        Globals.d().j().d(((List) (obj1)));
        boolean flag;
        if (this.f != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d(flag);
        if (this.k != null)
        {
            this.k.a(this);
            this.k.a(this);
        }
        p = f;
        m.a(p, f1, 0.0F, true, true);
        obj1 = new ArrayList();
        ((List) (obj1)).add(Integer.valueOf((int)p));
        Globals.d().j().c(((List) (obj1)));
        Globals.d().j().a(f1);
        h = g.findViewById(0x7f0c064a);
        if (h != null)
        {
            h.setOnClickListener(new android.view.View.OnClickListener() {

                final i a;

                public void onClick(View view)
                {
                    if (a.o)
                    {
                        return;
                    } else
                    {
                        view.setClickable(false);
                        view = new Runnable(this, new ch(this, view) {

                            final View a;
                            final _cls1 b;

                            public void onAnimationEnd(Animator animator)
                            {
                                a.setClickable(true);
                            }

            
            {
                b = _pcls1;
                a = view;
                super();
            }
                        }) {

                            final ch a;
                            final _cls1 b;

                            public void run()
                            {
                                Object obj = null;
                                if (b.a.f != null)
                                {
                                    obj = h.b().a(b.a.f.b(), b.a.f.a()).d();
                                }
                                com.cyberlink.youcammakeup.clflurry.b.a(new q(((String) (obj)), YMKFeatures.a(StatusManager.j().s())));
                                obj = b.a.m;
                                boolean flag;
                                if (b.a.m.q() != 0)
                                {
                                    flag = true;
                                } else
                                {
                                    flag = false;
                                }
                                ((BeautyToolPanel) (obj)).a(flag, a);
                            }

            
            {
                b = _pcls1;
                a = ch;
                super();
            }
                        };
                        a.h.post(view);
                        return;
                    }
                }

            
            {
                a = i.this;
                super();
            }
            });
        }
        if (!q)
        {
            StatusManager.j().c(((String) (obj)));
            BeautyToolPanel beautytoolpanel = m;
            if (this.f != null)
            {
                obj = a.a();
            } else
            {
                obj = null;
            }
            beautytoolpanel.b(((String) (obj)));
            m.d(StatusManager.j().e());
            ((n)m).a(a);
        }
        o = false;
    }

    public void a(ae ae, int k)
    {
    }

    public transient void a(String s1, Float afloat[])
    {
        if (s1 == null || k == null)
        {
            if (k != null)
            {
                Globals.d().i().h(k);
            }
        } else
        {
            if (m.d() != null)
            {
                m.a(f, s1);
            } else
            {
                m.a(null, null);
            }
            if (s1.equals(StatusManager.j().g()))
            {
                m.b(false);
                m.a(false, null);
                if (k != null)
                {
                    Globals.d().i().h(k);
                    return;
                }
            } else
            {
                (new AsyncTask(s1) {

                    MotionControlHelper a;
                    PanelDataCenter b;
                    aw c;
                    int d;
                    final String e;
                    final i f;

                    protected transient Boolean a(Void avoid[])
                    {
                        a.t();
                        c = b.i(e);
                        if (c == null)
                        {
                            return Boolean.valueOf(false);
                        }
                        StatusManager.j().c(e);
                        avoid = c.i();
                        if (avoid.size() == 0)
                        {
                            return Boolean.valueOf(false);
                        }
                        if (f.m.d() == null) goto _L2; else goto _L1
_L1:
                        Object obj = b.a(e, null);
                        if (((List) (obj)).size() <= 0) goto _L4; else goto _L3
_L3:
                        String s3;
                        s3 = StatusManager.j().e();
                        d = ((List) (obj)).indexOf(s3);
                        if (s3 == null || d <= -1) goto _L5; else goto _L4
_L4:
                        if (d == -1)
                        {
                            StatusManager.j().b(f.m.g());
                        }
                        a.a((at)avoid.get(0));
                        return Boolean.valueOf(true);
_L5:
                        d = 0;
                        obj = (String)((List) (obj)).get(d);
                        if (obj != null && !((String) (obj)).equals("") && !((String) (obj)).equals(StatusManager.j().e()))
                        {
                            StatusManager.j().b(((String) (obj)));
                            MotionControlHelper.e().t();
                            MotionControlHelper.e().a(true);
                        }
                        continue; /* Loop/switch isn't completed */
_L2:
                        String s2 = StatusManager.j().e();
                        int k;
                        if (f.m.i(s2) && PanelDataCenter.d(s2))
                        {
                            k = 1;
                        } else
                        {
                            k = 0;
                        }
                        if (k != 0)
                        {
                            k = 0;
                        } else
                        {
                            k = -1;
                        }
                        d = k;
                        if (true) goto _L4; else goto _L6
_L6:
                    }

                    protected void a(Boolean boolean1)
                    {
                        if (!boolean1.booleanValue())
                        {
                            if (f.k != null)
                            {
                                Globals.d().i().h(f.k);
                            }
                            return;
                        } else
                        {
                            f.m.a(StatusManager.j().e(), f.m.d());
                            a.a(null, true);
                            f.m.d(StatusManager.j().e());
                            f.m.a(false, null);
                            f.m.b(false);
                            ((n)f.m).a(c);
                            return;
                        }
                    }

                    protected Object doInBackground(Object aobj[])
                    {
                        return a((Void[])aobj);
                    }

                    protected void onPostExecute(Object obj)
                    {
                        a((Boolean)obj);
                    }

                    protected void onPreExecute()
                    {
                        a = MotionControlHelper.e();
                        b = PanelDataCenter.a();
                    }

            
            {
                f = i.this;
                e = s1;
                super();
                d = -1;
            }
                }).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
                return;
            }
        }
    }

    protected boolean a(BeautyMode beautymode, com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i k)
    {
        long l = StatusManager.j().l();
        if (this.k.p())
        {
            beautymode = this.k.r();
        } else
        {
            beautymode = StatusManager.j().f(Long.valueOf(l).longValue());
        }
        break MISSING_BLOCK_LABEL_26;
        if (beautymode != null && beautymode.f() != null && beautymode.f().g() != null && beautymode.f().g().a() != null)
        {
            beautymode = beautymode.f().g();
            Object obj = k.a();
            Object obj1 = beautymode.a();
            beautymode = ((s) (obj)).b();
            k = ((s) (obj1)).b();
            obj = ((s) (obj)).c();
            obj1 = ((s) (obj1)).c();
            if ((obj == null || ((String) (obj)).equals(obj1)) && (beautymode == null || beautymode.equals(k)))
            {
                return false;
            }
        }
        return true;
    }

    protected void b()
    {
    }

    protected void d()
    {
        if (k != null)
        {
            long l = StatusManager.j().l();
            MotionControlHelper.e().t();
            Object obj = StatusManager.j().g(l);
            if (obj != null)
            {
                obj = ((com.cyberlink.youcammakeup.kernelctrl.status.d) (obj)).e();
                if (obj != null)
                {
                    v v1 = ((a) (obj)).f();
                    if (v1.c() != null)
                    {
                        obj = PanelDataCenter.a().i(v1.c());
                    } else
                    {
                        obj = null;
                    }
                    if (obj != null)
                    {
                        Object obj1 = ((aw) (obj)).i();
                        Globals.d().j().d(((List) (obj1)));
                        obj1 = (n)m;
                        ((n) (obj1)).a(((aw) (obj)), true);
                        ((n) (obj1)).a(((aw) (obj)));
                        a = ((aw) (obj));
                        StatusManager.j().c(((aw) (obj)).a());
                    }
                    if (v1 != null)
                    {
                        m.a(v1.b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a).intValue());
                        obj = new ArrayList();
                        ((List) (obj)).add(v1.b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a));
                        MotionControlHelper.e().c(((List) (obj)));
                        m.b(v1.d().intValue());
                        MotionControlHelper.e().a(v1.d().intValue());
                    }
                    obj = StatusManager.j().e();
                    if (obj != null && ((String) (obj)).equals("Eyebrow_general"))
                    {
                        if (m != null && m.d() != null)
                        {
                            MotionControlHelper.e().a("Eyebrow_general_sku", MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a), MotionControlHelper.e().w());
                            return;
                        } else
                        {
                            MotionControlHelper.e().a("Eyebrow_general", MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a), MotionControlHelper.e().w());
                            return;
                        }
                    }
                    if (m != null && m.d() != null)
                    {
                        MotionControlHelper.e().a("Eyebrow_others_sku", MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a), MotionControlHelper.e().w());
                        return;
                    } else
                    {
                        MotionControlHelper.e().a("Eyebrow_others", MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a), MotionControlHelper.e().w());
                        return;
                    }
                }
            }
        }
    }

    protected void g()
    {
        super.g();
    }
}
