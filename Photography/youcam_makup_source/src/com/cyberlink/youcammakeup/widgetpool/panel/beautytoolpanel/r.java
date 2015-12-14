// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.animation.Animator;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.g;
import com.cyberlink.youcammakeup.activity.k;
import com.cyberlink.youcammakeup.clflurry.YMKFeatures;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.q;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.database.more.i.e;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierTaskInfo;
import com.cyberlink.youcammakeup.kernelctrl.VenusHelper;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.u;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.ap;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.SkuTemplateUtils;
import com.cyberlink.youcammakeup.utility.aq;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.utility.az;
import com.cyberlink.youcammakeup.utility.ch;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.common.ai;
import com.cyberlink.youcammakeup.widgetpool.panel.a;
import com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            o, k, BeautyToolPanel, n, 
//            q

public class r extends com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.o
    implements g, k, ap, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.k
{

    public static String r = "WigToolPanelMenu";
    final aq s = new aq() {

        final r a;

        public void a(Exception exception)
        {
            m.e(r.r, exception.toString());
            if (a.m == null)
            {
                return;
            } else
            {
                Globals.d(new Runnable(this) {

                    final _cls4 a;

                    public void run()
                    {
                        if (a.a.m != null)
                        {
                            a.a.m.b(null);
                        }
                    }

            
            {
                a = _pcls4;
                super();
            }
                });
                return;
            }
        }

        public volatile void a(Object obj)
        {
            a((String)obj);
        }

        public void a(String s1)
        {
            if (a.m == null)
            {
                return;
            } else
            {
                Globals.d(new Runnable(this) {

                    final _cls4 a;

                    public void run()
                    {
                        if (a.a.m != null)
                        {
                            a.a.m.b(null);
                        }
                        r r1 = a.a;
                        boolean flag;
                        if (!"default_original_wig".equals(StatusManager.j().e()))
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.r.a(r1, flag);
                    }

            
            {
                a = _pcls4;
                super();
            }
                });
                return;
            }
        }

            
            {
                a = r.this;
                super();
            }
    };
    private boolean t;
    private boolean u;

    public r()
    {
        t = false;
        u = false;
    }

    private void a(BeautyMode beautymode)
    {
        Object obj = null;
        class _cls8
        {

            static final int a[];

            static 
            {
                a = new int[BeautyMode.values().length];
                try
                {
                    a[BeautyMode.x.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel._cls8.a[beautymode.ordinal()];
        JVM INSTR tableswitch 1 1: default 28
    //                   1 70;
           goto _L1 _L2
_L1:
        beautymode = obj;
_L4:
        if (beautymode != null)
        {
            StatusManager.j().b(beautymode);
            beautymode = new BeautifierTaskInfo(false);
            beautymode.a(r, com.cyberlink.youcammakeup.kernelctrl.BeautifierTaskInfo.ResultBufferType.b);
            MotionControlHelper.e().a(beautymode, true);
        }
        return;
_L2:
        beautymode = "default_original_wig";
        if (true) goto _L4; else goto _L3
_L3:
    }

    static void a(r r1, boolean flag)
    {
        r1.e(flag);
    }

    static boolean b(r r1, boolean flag)
    {
        r1.t = flag;
        return flag;
    }

    static boolean c(r r1, boolean flag)
    {
        r1.u = flag;
        return flag;
    }

    private void e(boolean flag)
    {
        if (m != null)
        {
            m.d(flag);
        }
    }

    private void j()
    {
    }

    private void k()
    {
        Globals.d().i().b(Globals.d().t());
    }

    protected void a()
    {
        Object obj4 = null;
        k = Globals.d().t();
        b = (ImageView)g.findViewById(0x7f0c064b);
        c = (ImageView)g.findViewById(0x7f0c064c);
        d = (TextView)g.findViewById(0x7f0c064e);
        e = g.findViewById(0x7f0c064d);
        o = false;
        k();
        Globals.d().i().b(true);
        i l = StatusManager.j().d();
        Object obj = StatusManager.j().s();
        float f1 = m.J();
        Object obj2 = MotionControlHelper.e();
        ((MotionControlHelper) (obj2)).R();
        ((MotionControlHelper) (obj2)).S();
        ((MotionControlHelper) (obj2)).U();
        ((MotionControlHelper) (obj2)).X();
        StatusManager.j().a(this);
        k.a(this);
        q = true;
        MotionControlHelper.e().m();
        boolean flag;
        if (l != null && l.u() != null && l.u().e() != null)
        {
            obj = l.u().b();
            obj2 = l.u().c();
            f1 = l.u().g();
            boolean flag1 = l.u().i();
            boolean flag3 = l.u().j();
            q = true;
            MotionControlHelper.e().a(((String) (obj)), ((String) (obj2)));
            MotionControlHelper.e().a(flag1, 0);
            MotionControlHelper.e().c(((String) (obj)), flag3);
            StatusManager.j().y();
            flag = true;
        } else
        if (f != null)
        {
            obj2 = SkuTemplateUtils.e(com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(f.b(), f.a()).d());
            flag = false;
            obj = null;
        } else
        {
            obj2 = PanelDataCenter.a().a(((BeautyMode) (obj)), 1);
            flag = false;
            obj = null;
        }
        a = PanelDataCenter.a().i(((String) (obj2)));
        if (a == null)
        {
            q = false;
        } else
        {
            StatusManager.j().c(((String) (obj2)));
            Object obj3 = a.i();
            ((n)m).a(a, true);
            float f3;
            boolean flag2;
            if (f != null)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            d(flag2);
            Globals.d().j().d(((List) (obj3)));
            if (k != null)
            {
                k.a(Boolean.valueOf(false), Boolean.valueOf(false));
                k.a(this);
                k.a(this);
                k.a(Boolean.valueOf(true), 100F - f1, 100F, 0.0F);
                if (m != null)
                {
                    m.a(100F - f1, 0.0F, 0.0F, true, false);
                }
            }
            obj3 = obj;
            if (obj == null)
            {
                obj3 = StatusManager.j().e();
            }
            f3 = f1;
            if (obj3 != null)
            {
                a("default_original_wig", ((String) (obj3)));
                f3 = f1;
                if (!flag)
                {
                    Object obj1 = PanelDataCenter.a().b(((String) (obj3)), ((String) (obj2)));
                    f3 = f1;
                    if (((List) (obj1)).size() > 0)
                    {
                        float f2;
                        BeautyToolPanel beautytoolpanel;
                        d d1;
                        if (((Integer)((List) (obj1)).get(0)).intValue() > 0)
                        {
                            f2 = ((Integer)((List) (obj1)).get(0)).intValue();
                        } else
                        {
                            f2 = m.J();
                        }
                        f3 = f2;
                    }
                }
            }
            if (m != null)
            {
                m.a(false, false, ((String) (obj3)), null);
                if (f != null)
                {
                    d1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(f.b(), f.a());
                    beautytoolpanel = m;
                    obj1 = obj4;
                    if (d1 != null)
                    {
                        obj1 = d1.d();
                    }
                    beautytoolpanel.a(((String) (obj1)), ((String) (obj3)));
                }
            }
            p = f3;
            if (k != null)
            {
                k.a((int)f3);
            }
            if (m != null)
            {
                m.a("Apply", Boolean.valueOf(true));
            }
            MotionControlHelper.e().j(false);
            com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c.h().m();
            com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c.h().a(false);
            VenusHelper.a().g();
            MotionControlHelper.e().c(true);
            MotionControlHelper.e().l(false);
            if (k != null)
            {
                k.q(true);
            }
            h = g.findViewById(0x7f0c064a);
            if (h != null)
            {
                h.setOnClickListener(new android.view.View.OnClickListener() {

                    final r a;

                    public void onClick(View view)
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
                                    obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(b.a.f.b(), b.a.f.a()).d();
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
                    }

            
            {
                a = r.this;
                super();
            }
                });
                h.setClickable(false);
            }
            e.setVisibility(4);
            if (!q)
            {
                c(((String) (obj2)));
                return;
            }
        }
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.status.StatusManager.WigWarpState wigwarpstate)
    {
        if (wigwarpstate == com.cyberlink.youcammakeup.kernelctrl.status.StatusManager.WigWarpState.c)
        {
            t = true;
            int l = MotionControlHelper.e().T().b();
            MotionControlHelper.e().a(true, l + 1);
            StatusManager.j().a(null, Boolean.valueOf(true), Boolean.valueOf(false), Boolean.valueOf(true), null);
        }
    }

    public void a(az az1)
    {
        f = az1;
    }

    public void a(a a1)
    {
label0:
        {
            m = (BeautyToolPanel)a1;
            if (m != null)
            {
                if (StatusManager.j().s() != BeautyMode.x)
                {
                    break label0;
                }
                MotionControlHelper.e().a(s);
            }
            return;
        }
        m.b(null);
    }

    public void a(String s1)
    {
    }

    public void a(String s1, String s2)
    {
        if (m == null || !(m instanceof com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.q))
        {
            return;
        }
        if (k != null)
        {
            k.W();
            if (s2.equalsIgnoreCase("default_original_wig"))
            {
                a(false);
            } else
            {
                if (s1 != null && s1.equalsIgnoreCase(s2))
                {
                    if (m.m() != 0)
                    {
                        a(true);
                    } else
                    {
                        a(false);
                    }
                } else
                {
                    a(true);
                }
                m.g(s2);
            }
        }
        m.a(false, false, s2, s1);
    }

    public void a(String s1, boolean flag)
    {
        MotionControlHelper.e().c(true);
        MotionControlHelper motioncontrolhelper = MotionControlHelper.e();
        com.cyberlink.youcammakeup.jniproxy.bi bi;
        if (VenusHelper.a().e() == null)
        {
            bi = null;
        } else
        {
            bi = com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c.h().f();
        }
        motioncontrolhelper.a(bi);
        com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c.h().m();
        VenusHelper.a().g();
        if (s1 == "default_original_wig")
        {
            com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c.h().o();
            if (m != null)
            {
                m.h(false);
            }
        }
        s1 = MotionControlHelper.e().T();
        StatusManager.j().a(null, null, null, Boolean.valueOf(s1.a()), null);
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
            (new AsyncTask(s1, afloat) {

                MotionControlHelper a;
                PanelDataCenter b;
                aw c;
                int d;
                int e;
                final String f;
                final Float g[];
                final r h;

                protected transient Boolean a(Void avoid[])
                {
                    a.t();
                    c = b.i(f);
                    if (c == null)
                    {
                        return Boolean.valueOf(false);
                    }
                    StatusManager.j().c(f);
                    h.d(f);
                    List list = c.i();
                    float f1;
                    if (g.length > 0)
                    {
                        f1 = g[0].floatValue();
                    } else
                    {
                        f1 = a.a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a);
                    }
                    d = (int)f1;
                    if (list.size() == 0)
                    {
                        return Boolean.valueOf(false);
                    }
                    if (h.m.d() != null)
                    {
                        Object obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a("wig", h.m.d()).l();
                        avoid = new ArrayList();
                        for (obj = ((Collection) (obj)).iterator(); ((Iterator) (obj)).hasNext(); avoid.add(((e)((Iterator) (obj)).next()).a())) { }
                        if (avoid.size() > 0)
                        {
                            String s2 = StatusManager.j().e();
                            e = avoid.indexOf(s2);
                            if (s2 != null && e > -1)
                            {
                                avoid = s2;
                            } else
                            {
                                e = 0;
                                String s3 = (String)avoid.get(e);
                                avoid = s3;
                                if (s3 != null)
                                {
                                    avoid = s3;
                                    if (!s3.equals(""))
                                    {
                                        avoid = s3;
                                        if (!s3.equals(s2))
                                        {
                                            StatusManager.j().b(s3);
                                            MotionControlHelper.e().t();
                                            MotionControlHelper.e().a(true);
                                            avoid = s3;
                                        }
                                    }
                                }
                            }
                            if (g.length == 0)
                            {
                                avoid = b.b(avoid, f);
                                if (avoid.size() > 0)
                                {
                                    float f2;
                                    if (((Integer)avoid.get(0)).intValue() > 0)
                                    {
                                        f2 = ((Integer)avoid.get(0)).intValue();
                                    } else
                                    {
                                        f2 = h.m.J();
                                    }
                                    d = (int)f2;
                                }
                            }
                        } else
                        {
                            int l;
                            if (g.length == 0 && ((at)list.get(0)).d() != 0)
                            {
                                l = ((at)list.get(0)).d();
                            } else
                            {
                                l = d;
                            }
                            d = l;
                        }
                    } else
                    {
                        avoid = StatusManager.j().e();
                        int i1;
                        if (h.m.i(avoid) && PanelDataCenter.d(avoid))
                        {
                            i1 = 1;
                        } else
                        {
                            i1 = 0;
                        }
                        if (i1 != 0)
                        {
                            i1 = 0;
                        } else
                        {
                            i1 = -1;
                        }
                        e = i1;
                    }
                    if (e == -1 && h.m != null && (h.m instanceof com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.q))
                    {
                        if (h.f != null)
                        {
                            avoid = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(h.f.b(), h.f.a()).d();
                        } else
                        {
                            avoid = null;
                        }
                        StatusManager.j().b(((com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.q)h.m).j(avoid));
                    }
                    avoid = new ArrayList();
                    avoid.add(Integer.valueOf(d));
                    a.d(list);
                    a.c(avoid);
                    a.z();
                    a.a(StatusManager.j().e(), f);
                    return Boolean.valueOf(true);
                }

                protected void a(Boolean boolean1)
                {
                    if (!boolean1.booleanValue())
                    {
                        if (h.k != null)
                        {
                            Globals.d().i().h(h.k);
                        }
                        return;
                    } else
                    {
                        h.m.d(StatusManager.j().e());
                        h.m.a(false, null);
                        h.m.b(false);
                        h.m.a(100 - d);
                        ((n)h.m).a(c);
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
                    if (h.k != null)
                    {
                        Globals.d().i().b(h.k);
                    }
                }

            
            {
                h = r.this;
                f = s1;
                g = afloat;
                super();
                e = -1;
            }
            }).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
            return;
        }
    }

    public void a(boolean flag)
    {
        if (m != null)
        {
            m.h(flag);
        }
    }

    public boolean a(View view)
    {
        if (!t)
        {
            return false;
        } else
        {
            view = new Runnable() {

                final r a;

                public void run()
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.r.b(a, false);
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.r.c(a, true);
                    VenusHelper.a().i();
                    int l = MotionControlHelper.e().T().b() - 1;
                    boolean flag;
                    if (l >= 1)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    MotionControlHelper.e().a(flag, l);
                    StatusManager.j().a(null, Boolean.valueOf(false), Boolean.valueOf(true), Boolean.valueOf(flag), null);
                    a.k.a(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c);
                }

            
            {
                a = r.this;
                super();
            }
            };
            g.post(view);
            return true;
        }
    }

    protected void b()
    {
    }

    public boolean b(View view)
    {
        if (!u)
        {
            return false;
        } else
        {
            view = new Runnable() {

                final r a;

                public void run()
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.r.c(a, false);
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.r.b(a, true);
                    VenusHelper.a().j();
                    int l = MotionControlHelper.e().T().b() + 1;
                    boolean flag;
                    if (l >= 1)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    MotionControlHelper.e().a(flag, l);
                    StatusManager.j().a(null, Boolean.valueOf(true), Boolean.valueOf(false), Boolean.valueOf(flag), null);
                    a.k.a(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c);
                }

            
            {
                a = r.this;
                super();
            }
            };
            g.post(view);
            return true;
        }
    }

    protected void c()
    {
        if (k == null)
        {
            return;
        }
        BeautyMode beautymode = StatusManager.j().s();
        k.j(true);
        MotionControlHelper motioncontrolhelper = MotionControlHelper.e();
        motioncontrolhelper.k(false);
        motioncontrolhelper.j(true);
        motioncontrolhelper.l(false);
        k.a(new com.cyberlink.youcammakeup.activity.c() {

            final r a;

            public void a()
            {
                a.k.b(this);
                a.i();
            }

            
            {
                a = r.this;
                super();
            }
        });
        BeautifierTaskInfo beautifiertaskinfo = new BeautifierTaskInfo(false);
        beautifiertaskinfo.a(r, com.cyberlink.youcammakeup.kernelctrl.BeautifierTaskInfo.ResultBufferType.b);
        if (!MotionControlHelper.e().a(beautifiertaskinfo, true))
        {
            a(beautymode);
        }
        motioncontrolhelper.k(true);
        motioncontrolhelper.j(false);
    }

    protected void c(String s1)
    {
        StatusManager.j().c(s1);
        if (m != null && (m instanceof n))
        {
            m.a(f, null);
            s1 = StatusManager.j().s();
            s1 = m.c(s1);
            m.d(s1);
            ((n)m).a(a);
            m.a(false, false, s1, null);
            m.b(s1, null);
        }
    }

    public boolean c(View view)
    {
        view = new Runnable() {

            final r a;

            public void run()
            {
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.r.c(a, false);
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.r.b(a, false);
                VenusHelper.a().k();
                MotionControlHelper.e().a(false, 0);
                StatusManager.j().a(null, Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), null);
                a.k.a(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c);
            }

            
            {
                a = r.this;
                super();
            }
        };
        g.post(view);
        return true;
    }

    public void e(String s1)
    {
        MotionControlHelper motioncontrolhelper = MotionControlHelper.e();
        motioncontrolhelper.l(s1);
        motioncontrolhelper.m(s1);
        motioncontrolhelper.p(s1);
        motioncontrolhelper.n(s1);
    }

    public void f()
    {
        g();
    }

    protected void g()
    {
        j();
        StatusManager.j().c(null);
        if (k != null)
        {
            k.b(this);
        }
        o = false;
        p = -1F;
        if (k != null)
        {
            k.q(false);
            k.a(null);
        }
        com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c.h().m();
        VenusHelper.a().g();
        MotionControlHelper.e().c(true);
        StatusManager.j().b(this);
        k = null;
    }

    public boolean h()
    {
        boolean flag = false;
        if (k != null)
        {
            k.i(false);
        }
        if (q)
        {
            if (a != null)
            {
                Object obj = a.i();
                MotionControlHelper.e().d(((List) (obj)));
                obj = new ArrayList();
                ((List) (obj)).add(Integer.valueOf(100 - m.K()));
                MotionControlHelper.e().c(((List) (obj)));
                MotionControlHelper.e().A();
            }
            q = false;
            flag = true;
        }
        return flag;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        g = layoutinflater.inflate(0x7f030165, viewgroup, false);
        return g;
    }

    public void onDestroyView()
    {
        g();
        super.onDestroyView();
    }

}
