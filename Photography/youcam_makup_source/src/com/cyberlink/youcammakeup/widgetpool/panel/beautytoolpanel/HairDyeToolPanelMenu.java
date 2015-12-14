// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.animation.Animator;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.c;
import com.cyberlink.youcammakeup.clflurry.YMKFeatures;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.kernelctrl.HairDyeBrushHandler;
import com.cyberlink.youcammakeup.kernelctrl.VenusHelper;
import com.cyberlink.youcammakeup.kernelctrl.ah;
import com.cyberlink.youcammakeup.kernelctrl.aq;
import com.cyberlink.youcammakeup.kernelctrl.c.d;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.q;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.PanZoomViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ae;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.IntroDialogUtils;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.SkuTemplateUtils;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.utility.az;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.utility.ch;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            o, BeautyToolPanel, n

public class HairDyeToolPanelMenu extends com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.o
{

    private View A;
    private View B;
    private boolean C;
    private android.view.View.OnClickListener D;
    private aq E;
    private aq F;
    private HairDyeMode r;
    private HairDyeBrushHandler s;
    private View t;
    private View u;
    private View v;
    private View w;
    private View x;
    private View y;
    private View z;

    public HairDyeToolPanelMenu()
    {
        r = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeMode.a;
        C = true;
        D = new android.view.View.OnClickListener() {

            final HairDyeToolPanelMenu a;

            public void onClick(View view)
            {
                a.a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeMode.b);
                view = StatusManager.j().s();
                boolean flag;
                if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeToolPanelMenu.b(a) == com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeMode.b)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view = IntroDialogUtils.a(view, false, flag);
                IntroDialogUtils.a(a.getFragmentManager(), null, null, view, false);
                VenusHelper.a().a(null);
            }

            
            {
                a = HairDyeToolPanelMenu.this;
                super();
            }
        };
        E = new aq() {

            final HairDyeToolPanelMenu a;

            public void a(Integer integer)
            {
            }

            public void a(Object obj)
            {
                if (obj != null && (obj instanceof aw))
                {
                    obj = (aw)obj;
                    a.a(((aw) (obj)).a(), new Float[0]);
                }
            }

            public void a(Void void1)
            {
            }

            public void b(Object obj)
            {
                a((Integer)obj);
            }

            public void c(Object obj)
            {
                a((Void)obj);
            }

            
            {
                a = HairDyeToolPanelMenu.this;
                super();
            }
        };
        F = new aq() {

            final HairDyeToolPanelMenu a;

            public void a(Integer integer)
            {
            }

            public void a(Object obj)
            {
                MotionControlHelper.e().a(null, true);
            }

            public void a(Void void1)
            {
            }

            public void b(Object obj)
            {
                a((Integer)obj);
            }

            public void c(Object obj)
            {
                a((Void)obj);
            }

            
            {
                a = HairDyeToolPanelMenu.this;
                super();
            }
        };
    }

    static aq a(HairDyeToolPanelMenu hairdyetoolpanelmenu)
    {
        return hairdyetoolpanelmenu.E;
    }

    private void a(int i1)
    {
        p();
        HairDyeBrushHandler.a().a(Integer.valueOf(i1), true);
        if (i1 != HairDyeBrushHandler.a[0]) goto _L2; else goto _L1
_L1:
        if (x != null)
        {
            x.setSelected(true);
        }
_L4:
        return;
_L2:
        if (i1 != HairDyeBrushHandler.a[1])
        {
            break; /* Loop/switch isn't completed */
        }
        if (y != null)
        {
            y.setSelected(true);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (i1 != HairDyeBrushHandler.a[2])
        {
            break; /* Loop/switch isn't completed */
        }
        if (z != null)
        {
            z.setSelected(true);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
        if (i1 != HairDyeBrushHandler.a[3])
        {
            continue; /* Loop/switch isn't completed */
        }
        if (A == null) goto _L4; else goto _L6
_L6:
        A.setSelected(true);
        return;
        if (i1 != HairDyeBrushHandler.a[4] || B == null) goto _L4; else goto _L7
_L7:
        B.setSelected(true);
        return;
    }

    static void a(HairDyeToolPanelMenu hairdyetoolpanelmenu, int i1)
    {
        hairdyetoolpanelmenu.a(i1);
    }

    static void a(HairDyeToolPanelMenu hairdyetoolpanelmenu, String s1)
    {
        hairdyetoolpanelmenu.e(s1);
    }

    private void a(Boolean boolean1)
    {
        d d1 = Globals.d().i;
        if (boolean1.booleanValue())
        {
            d1.a(null, ah.a);
            HairDyeBrushHandler.a().d();
            return;
        } else
        {
            d1.a(null, PanZoomViewer.L);
            HairDyeBrushHandler.a().e();
            return;
        }
    }

    static HairDyeMode b(HairDyeToolPanelMenu hairdyetoolpanelmenu)
    {
        return hairdyetoolpanelmenu.r;
    }

    static View c(HairDyeToolPanelMenu hairdyetoolpanelmenu)
    {
        return hairdyetoolpanelmenu.u;
    }

    static View d(HairDyeToolPanelMenu hairdyetoolpanelmenu)
    {
        return hairdyetoolpanelmenu.v;
    }

    static aq e(HairDyeToolPanelMenu hairdyetoolpanelmenu)
    {
        return hairdyetoolpanelmenu.F;
    }

    private void e(String s1)
    {
        if (s1 == null || k == null || m == null)
        {
            return;
        }
        if ("default_original_hair_dye".equalsIgnoreCase(s1))
        {
            k.w(false);
            m.i(false);
        } else
        {
            k.w(true);
            m.i(true);
        }
        m.g(null);
    }

    private void o()
    {
        Object obj = getActivity();
        ImageViewer imageviewer;
        if (obj != null)
        {
            if ((imageviewer = (ImageViewer)getActivity().findViewById(0x7f0c0720)) != null)
            {
                obj = AnimationUtils.loadAnimation(((android.content.Context) (obj)), 0x7f04001a);
                imageviewer.setAnimation(((Animation) (obj)));
                ((Animation) (obj)).startNow();
                return;
            }
        }
    }

    private void p()
    {
        if (x != null)
        {
            x.setSelected(false);
        }
        if (y != null)
        {
            y.setSelected(false);
        }
        if (z != null)
        {
            z.setSelected(false);
        }
        if (A != null)
        {
            A.setSelected(false);
        }
        if (B != null)
        {
            B.setSelected(false);
        }
    }

    protected void a()
    {
        k = Globals.d().t();
        b = (ImageView)g.findViewById(0x7f0c064b);
        c = (ImageView)g.findViewById(0x7f0c064c);
        d = (TextView)g.findViewById(0x7f0c064e);
        e = g.findViewById(0x7f0c064d);
        Object obj = StatusManager.j().s();
        i i1 = StatusManager.j().d();
        float f = m.J();
        float f1 = m.L();
        q = true;
        r = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeMode.a;
        MotionControlHelper.e().k(false);
        String s1;
        if (i1 != null && i1.C() != null && i1.C().c() != null)
        {
            s1 = i1.C().c();
            f = i1.C().a();
            f1 = i1.C().g();
            if (s1.equals(MotionControlHelper.e().J().c()))
            {
                MotionControlHelper.e().r(false);
            }
        } else
        if (this.f != null)
        {
            s1 = SkuTemplateUtils.e(com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(this.f.b(), this.f.a()).d());
        } else
        {
            s1 = "default_original_hair_dye";
        }
        if (s1 == null)
        {
            bo.d(((BeautyMode) (obj)));
        }
        a = PanelDataCenter.a().i(s1);
        obj = (new StringBuilder()).append("HairDyeToolPanelMenu initValue, BeautyMode = ").append(String.valueOf(obj)).append(" , bNeedApply = ").append(q).append(" , default palette = ").append(String.valueOf(s1)).toString();
        Globals.d().e(((String) (obj)));
        if (a == null)
        {
            q = false;
            return;
        }
        obj = a.i();
        ((n)m).a(a, true);
        boolean flag;
        if (this.f != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d(flag);
        Globals.d().j().d(((List) (obj)));
        if (k != null)
        {
            k.a(this);
            k.a(this);
        }
        p = f;
        m.a(p, f1, 0.0F, true, false);
        h = g.findViewById(0x7f0c064a);
        if (h != null)
        {
            h.setOnClickListener(new android.view.View.OnClickListener() {

                final HairDyeToolPanelMenu a;

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
                                    obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(b.a.f.b(), b.a.f.a()).d();
                                }
                                com.cyberlink.youcammakeup.clflurry.b.a(new com.cyberlink.youcammakeup.clflurry.q(((String) (obj)), YMKFeatures.a(StatusManager.j().s())));
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
                a = HairDyeToolPanelMenu.this;
                super();
            }
            });
        }
        if (!q)
        {
            c(s1);
        }
        o = false;
        e(s1);
    }

    public void a(ae ae, int i1)
    {
    }

    void a(HairDyeMode hairdyemode)
    {
        class _cls8
        {

            static final int a[];

            static 
            {
                a = new int[HairDyeMode.values().length];
                try
                {
                    a[com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeMode.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeMode.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel._cls8.a[hairdyemode.ordinal()])
        {
        default:
            r = hairdyemode;
            a(true);
            return;

        case 1: // '\001'
            r = hairdyemode;
            a(Boolean.valueOf(false));
            m();
            if (m != null)
            {
                m.m(false);
                m.a(0);
            }
            e(a.a());
            if (k != null)
            {
                k.d(0);
                k.a(0, 8, 8, 8, 8, 8, 8, 8);
            }
            StatusManager.j().a(Boolean.valueOf(true));
            o();
            a(true);
            return;

        case 2: // '\002'
            r = hairdyemode;
            a(Boolean.valueOf(true));
            break;
        }
        if (m != null)
        {
            m.m(true);
            m.a(8);
            m.i(false);
        }
        l();
        if (k != null)
        {
            hairdyemode = k.ad();
            if (hairdyemode != null)
            {
                hairdyemode.setVisibility(8);
            }
            k.d(8);
            k.a(8, 8, 8, 8, 8, 8, 8, 8);
        }
        o();
        a(true);
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
            Object obj = StatusManager.j().s();
            StringBuilder stringbuilder = (new StringBuilder()).append("HairDyeToolPanelMenu changePalette, BeautyMode = ");
            if (obj == null)
            {
                obj = "null";
            }
            stringbuilder = stringbuilder.append(obj).append(" , palette = ");
            if (s1 != null)
            {
                obj = s1;
            } else
            {
                obj = "null";
            }
            obj = stringbuilder.append(((String) (obj))).toString();
            Globals.d().e(((String) (obj)));
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
                    final HairDyeToolPanelMenu h;

                    protected transient Boolean a(Void avoid[])
                    {
                        a.t();
                        c = b.i(f);
                        if (c == null)
                        {
                            return Boolean.valueOf(false);
                        }
                        if (!"default_original_hair_dye".equalsIgnoreCase(f) && MotionControlHelper.e().ay())
                        {
                            VenusHelper.a().a(c, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeToolPanelMenu.a(h));
                            return Boolean.valueOf(false);
                        }
                        h.a = c;
                        StatusManager.j().c(f);
                        h.d(f);
                        d = (int)a.a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a);
                        avoid = c.i();
                        float f1;
                        int i1;
                        if (avoid != null && avoid.size() > 0)
                        {
                            i1 = ((at)avoid.get(0)).d();
                        } else
                        {
                            i1 = 0;
                        }
                        if (g.length > 0)
                        {
                            f1 = g[0].floatValue();
                        } else
                        if (i1 > 0)
                        {
                            f1 = i1;
                        } else
                        {
                            f1 = a.w();
                        }
                        e = (int)f1;
                        if (!"default_original_hair_dye".equalsIgnoreCase(f) && avoid.size() == 0)
                        {
                            return Boolean.valueOf(false);
                        } else
                        {
                            ArrayList arraylist = new ArrayList();
                            arraylist.add(Integer.valueOf(d));
                            a.d(avoid);
                            a.a(e);
                            a.c(arraylist);
                            a.a(null, true);
                            return Boolean.valueOf(true);
                        }
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
                            h.m.a(false, null);
                            h.m.b(false);
                            h.m.a(d);
                            h.m.b(e);
                            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeToolPanelMenu.a(h, f);
                            ((n)h.m).a(c);
                            return;
                        }
                    }

                    protected Object doInBackground(Object aobj[])
                    {
                        return a((Void[])aobj);
                    }

                    protected void onPostExecute(Object obj1)
                    {
                        a((Boolean)obj1);
                    }

                    protected void onPreExecute()
                    {
                        a = MotionControlHelper.e();
                        b = PanelDataCenter.a();
                    }

            
            {
                h = HairDyeToolPanelMenu.this;
                f = s1;
                g = afloat;
                super();
            }
                }).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
                return;
            }
        }
    }

    public void a(boolean flag)
    {
        C = flag;
    }

    protected void b()
    {
        if (k != null)
        {
            View view = k.ad();
            if (view != null)
            {
                view.setOnClickListener(D);
            }
            s = HairDyeBrushHandler.a();
            s.a(this);
            s.b();
        }
    }

    protected void c()
    {
        if (k == null)
        {
            return;
        }
        if (q)
        {
            q = false;
            k.i(false);
            k.a(new c() {

                final HairDyeToolPanelMenu a;

                public void a()
                {
                    if (a.k != null)
                    {
                        a.k.b(this);
                    }
                    a.i();
                }

            
            {
                a = HairDyeToolPanelMenu.this;
                super();
            }
            });
            a(a.a(), new Float[0]);
            return;
        }
        Object obj = StatusManager.j().g(StatusManager.j().l());
        if (obj != null)
        {
            obj = ((com.cyberlink.youcammakeup.kernelctrl.status.d) (obj)).e();
            if (obj != null)
            {
                ((a) (obj)).a(MotionControlHelper.e().M());
            }
        }
        StatusManager.j().y();
        i();
    }

    protected void c(String s1)
    {
        StatusManager.j().c(s1);
        ((n)m).a(a);
        e(s1);
    }

    protected void d()
    {
    }

    protected void d(String s1)
    {
    }

    protected void g()
    {
        Object obj = StatusManager.j().s();
        StringBuilder stringbuilder = (new StringBuilder()).append("HairDyeToolPanelMenu unInitValue, BeautyMode = ");
        if (obj == null)
        {
            obj = "null";
        }
        stringbuilder = stringbuilder.append(obj).append(" , palette = ");
        if (a != null && a.a() != null)
        {
            obj = a.a();
        } else
        {
            obj = "null";
        }
        obj = stringbuilder.append(((String) (obj))).toString();
        Globals.d().e(((String) (obj)));
        super.g();
        StatusManager.j().c(null);
    }

    protected void h()
    {
        if (a != null)
        {
            e(a.a());
        }
    }

    public void j()
    {
        if (StatusManager.j().s() == BeautyMode.y && m != null && m.N() != null)
        {
            m.N().performClick();
        }
    }

    public HairDyeMode k()
    {
        return r;
    }

    public void l()
    {
        if (StatusManager.j().s() == BeautyMode.y && m != null)
        {
            View view = m.M();
            if (view != null)
            {
                t = view.findViewById(0x7f0c0646);
                u = view.findViewById(0x7f0c0647);
                v = view.findViewById(0x7f0c0648);
                w = view.findViewById(0x7f0c0649);
                x = view.findViewById(0x7f0c0641);
                y = view.findViewById(0x7f0c0642);
                z = view.findViewById(0x7f0c0643);
                A = view.findViewById(0x7f0c0644);
                B = view.findViewById(0x7f0c0645);
                if (t != null)
                {
                    t.setOnClickListener(new android.view.View.OnClickListener() {

                        final HairDyeToolPanelMenu a;

                        public void onClick(View view1)
                        {
                            if (!a.n())
                            {
                                return;
                            }
                            if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeToolPanelMenu.c(a) != null)
                            {
                                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeToolPanelMenu.c(a).setSelected(false);
                            }
                            if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeToolPanelMenu.d(a) != null)
                            {
                                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeToolPanelMenu.d(a).setSelected(false);
                            }
                            a.a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeMode.a);
                            VenusHelper.a().a(true, false, HairDyeToolPanelMenu.e(a));
                        }

            
            {
                a = HairDyeToolPanelMenu.this;
                super();
            }
                    });
                }
                if (u != null)
                {
                    u.setOnClickListener(new android.view.View.OnClickListener() {

                        final HairDyeToolPanelMenu a;

                        public void onClick(View view1)
                        {
                            if (a.n())
                            {
                                HairDyeBrushHandler.a().a(com.cyberlink.youcammakeup.kernelctrl.HairDyeBrushHandler.BrushMode.a);
                                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeToolPanelMenu.c(a).setSelected(true);
                                if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeToolPanelMenu.d(a) != null)
                                {
                                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeToolPanelMenu.d(a).setSelected(false);
                                    return;
                                }
                            }
                        }

            
            {
                a = HairDyeToolPanelMenu.this;
                super();
            }
                    });
                }
                if (v != null)
                {
                    v.setOnClickListener(new android.view.View.OnClickListener() {

                        final HairDyeToolPanelMenu a;

                        public void onClick(View view1)
                        {
                            if (a.n())
                            {
                                HairDyeBrushHandler.a().a(com.cyberlink.youcammakeup.kernelctrl.HairDyeBrushHandler.BrushMode.b);
                                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeToolPanelMenu.d(a).setSelected(true);
                                if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeToolPanelMenu.c(a) != null)
                                {
                                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeToolPanelMenu.c(a).setSelected(false);
                                    return;
                                }
                            }
                        }

            
            {
                a = HairDyeToolPanelMenu.this;
                super();
            }
                    });
                }
                if (w != null)
                {
                    w.setOnClickListener(new android.view.View.OnClickListener() {

                        final HairDyeToolPanelMenu a;

                        public void onClick(View view1)
                        {
                            if (!a.n())
                            {
                                return;
                            }
                            if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeToolPanelMenu.c(a) != null)
                            {
                                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeToolPanelMenu.c(a).setSelected(false);
                            }
                            if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeToolPanelMenu.d(a) != null)
                            {
                                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeToolPanelMenu.d(a).setSelected(false);
                            }
                            a.a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeMode.a);
                        }

            
            {
                a = HairDyeToolPanelMenu.this;
                super();
            }
                    });
                }
                if (x != null)
                {
                    x.setOnClickListener(new android.view.View.OnClickListener() {

                        final HairDyeToolPanelMenu a;

                        public void onClick(View view1)
                        {
                            if (!a.n())
                            {
                                return;
                            } else
                            {
                                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeToolPanelMenu.a(a, HairDyeBrushHandler.a[0]);
                                return;
                            }
                        }

            
            {
                a = HairDyeToolPanelMenu.this;
                super();
            }
                    });
                }
                if (y != null)
                {
                    y.setOnClickListener(new android.view.View.OnClickListener() {

                        final HairDyeToolPanelMenu a;

                        public void onClick(View view1)
                        {
                            if (!a.n())
                            {
                                return;
                            } else
                            {
                                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeToolPanelMenu.a(a, HairDyeBrushHandler.a[1]);
                                return;
                            }
                        }

            
            {
                a = HairDyeToolPanelMenu.this;
                super();
            }
                    });
                }
                if (z != null)
                {
                    z.setOnClickListener(new android.view.View.OnClickListener() {

                        final HairDyeToolPanelMenu a;

                        public void onClick(View view1)
                        {
                            if (!a.n())
                            {
                                return;
                            } else
                            {
                                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeToolPanelMenu.a(a, HairDyeBrushHandler.a[2]);
                                return;
                            }
                        }

            
            {
                a = HairDyeToolPanelMenu.this;
                super();
            }
                    });
                }
                if (A != null)
                {
                    A.setOnClickListener(new android.view.View.OnClickListener() {

                        final HairDyeToolPanelMenu a;

                        public void onClick(View view1)
                        {
                            if (!a.n())
                            {
                                return;
                            } else
                            {
                                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeToolPanelMenu.a(a, HairDyeBrushHandler.a[3]);
                                return;
                            }
                        }

            
            {
                a = HairDyeToolPanelMenu.this;
                super();
            }
                    });
                }
                if (B != null)
                {
                    B.setOnClickListener(new android.view.View.OnClickListener() {

                        final HairDyeToolPanelMenu a;

                        public void onClick(View view1)
                        {
                            if (!a.n())
                            {
                                return;
                            } else
                            {
                                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeToolPanelMenu.a(a, HairDyeBrushHandler.a[4]);
                                return;
                            }
                        }

            
            {
                a = HairDyeToolPanelMenu.this;
                super();
            }
                    });
                }
                u.performClick();
                a(HairDyeBrushHandler.a[2]);
                return;
            }
        }
    }

    public void m()
    {
        HairDyeBrushHandler.a().a(Integer.valueOf(HairDyeBrushHandler.a[2]), false);
        p();
        if (t != null)
        {
            t.setOnClickListener(null);
        }
        if (u != null)
        {
            u.setOnClickListener(null);
        }
        if (v != null)
        {
            v.setOnClickListener(null);
        }
        if (w != null)
        {
            w.setOnClickListener(null);
        }
        if (x != null)
        {
            x.setOnClickListener(null);
        }
        if (y != null)
        {
            y.setOnClickListener(null);
        }
        if (z != null)
        {
            z.setOnClickListener(null);
        }
        if (A != null)
        {
            A.setOnClickListener(null);
        }
        if (B != null)
        {
            B.setOnClickListener(null);
        }
    }

    public boolean n()
    {
        return C;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        g = layoutinflater.inflate(0x7f030164, viewgroup, false);
        return g;
    }

    private class HairDyeMode extends Enum
    {

        public static final HairDyeMode a;
        public static final HairDyeMode b;
        private static final HairDyeMode c[];

        public static HairDyeMode valueOf(String s1)
        {
            return (HairDyeMode)Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/HairDyeToolPanelMenu$HairDyeMode, s1);
        }

        public static HairDyeMode[] values()
        {
            return (HairDyeMode[])c.clone();
        }

        static 
        {
            a = new HairDyeMode("Normal", 0);
            b = new HairDyeMode("FineTune", 1);
            c = (new HairDyeMode[] {
                a, b
            });
        }

        private HairDyeMode(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
