// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.animation.Animator;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.c;
import com.cyberlink.youcammakeup.activity.k;
import com.cyberlink.youcammakeup.clflurry.YMKFeatures;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierTaskInfo;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.q;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ae;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.kernelctrl.status.x;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.SkuTemplateUtils;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.az;
import com.cyberlink.youcammakeup.utility.ba;
import com.cyberlink.youcammakeup.utility.ch;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            e, k, BeautyToolPanel

public class b extends e
    implements k, x, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.k
{

    protected ImageView b;
    protected ImageView c;
    protected TextView d;
    protected View e;
    protected az f;

    public b()
    {
    }

    protected void a()
    {
        boolean flag = true;
        k = Globals.d().t();
        b = (ImageView)g.findViewById(0x7f0c064b);
        c = (ImageView)g.findViewById(0x7f0c064c);
        d = (TextView)g.findViewById(0x7f0c064e);
        e = g.findViewById(0x7f0c064d);
        i j = StatusManager.j().d();
        BeautyMode beautymode = StatusManager.j().s();
        new at(0);
        float f1 = m.J();
        float f4 = m.L();
        q = true;
        MotionControlHelper.e().m();
        float f2;
        float f3;
        Object obj;
        Object obj1;
        if (f != null)
        {
            ba ba1 = SkuTemplateUtils.c(h.b().a(f.b(), f.a()).d());
            f2 = f1;
            obj = ba1;
            if (ba1 != null)
            {
                f2 = f1;
                obj = ba1;
                if (ba1.d() != 0)
                {
                    f2 = ba1.d();
                    obj = ba1;
                }
            }
        } else
        {
            obj = PanelDataCenter.a().c(beautymode);
            if (beautymode == BeautyMode.r)
            {
                obj = MotionControlHelper.a(PanelDataCenter.a().d(beautymode), ((at) (obj)));
                f2 = f1;
            } else
            {
                f2 = f1;
                if (beautymode == BeautyMode.y)
                {
                    obj = new com.cyberlink.youcammakeup.widgetpool.common.a.k(0);
                    f2 = f1;
                }
            }
        }
        f1 = f2;
        obj1 = obj;
        f3 = f4;
        if (j != null)
        {
            if (beautymode == BeautyMode.b && j.i() != null && j.i().e() != null)
            {
                obj1 = j.i().e();
                f1 = j.i().g();
                q = a(BeautyMode.b, j);
                f3 = f4;
            } else
            if (beautymode == BeautyMode.y && j.C() != null && j.C().e() != null)
            {
                obj = j.C().e();
                f2 = j.C().a();
                f4 = j.C().g();
                f1 = f2;
                obj1 = obj;
                f3 = f4;
                if (((at) (obj)).equals(MotionControlHelper.e().J().e()))
                {
                    MotionControlHelper.e().r(false);
                    f1 = f2;
                    obj1 = obj;
                    f3 = f4;
                }
            } else
            {
                f1 = f2;
                obj1 = obj;
                f3 = f4;
                if (beautymode == BeautyMode.t)
                {
                    f1 = f2;
                    obj1 = obj;
                    f3 = f4;
                    if (j.d() != null)
                    {
                        f1 = j.d().b();
                        obj1 = j.d().c();
                        q = false;
                        f3 = f4;
                    }
                }
            }
        }
        m.a(((at) (obj1)), true);
        m.a(((at) (obj1)), StatusManager.j().e());
        n = ((at) (obj1));
        Globals.d().j().a(((at) (obj1)));
        if (k != null)
        {
            k.a(this);
            k.a(this);
        }
        p = f1;
        if (beautymode == BeautyMode.y)
        {
            m.a(p, f3, 0.0F, true, false);
        } else
        if (beautymode == BeautyMode.t)
        {
            m.a(8);
            if ("default_original_double_eyelid".equalsIgnoreCase(StatusManager.j().e()))
            {
                flag = false;
            }
            m.a(p, f3, 0.0F, flag, false);
        } else
        {
            m.a(p, f3, 0.0F, true, false);
        }
        h = g.findViewById(0x7f0c064a);
        if (h != null)
        {
            h.setOnClickListener(new android.view.View.OnClickListener() {

                final b a;

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
                                obj = h.b().a(b.a.f.b(), b.a.f.a()).d();
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
                }

            
            {
                a = b.this;
                super();
            }
            });
        }
        o = false;
        if (beautymode == BeautyMode.r || beautymode == BeautyMode.s)
        {
            MotionControlHelper.e().a(f3);
        }
        if (beautymode == BeautyMode.s)
        {
            m.a(false, false, StatusManager.j().e(), null);
            m.b(StatusManager.j().e(), null);
        }
    }

    public void a(Bitmap bitmap)
    {
        if (b != null)
        {
            b.setImageBitmap(bitmap);
        }
    }

    public void a(ag ag1, String s)
    {
        if (b != null)
        {
            ag1.a(s, b);
        }
    }

    public void a(ae ae, int j)
    {
        while (ae == null || StatusManager.j().s() != BeautyMode.s) 
        {
            return;
        }
        ae = MotionControlHelper.e();
        switch (j)
        {
        default:
            return;

        case 0: // '\0'
            ae.a(0.0F, true, new BeautifierTaskInfo(false));
            break;
        }
    }

    public void a(BeautyMode beautymode, Long long1)
    {
        boolean flag;
        boolean flag1;
label0:
        {
            flag1 = false;
            if (h == null)
            {
                return;
            }
            boolean flag2 = true;
            if (!BeautyMode.d(beautymode))
            {
                flag = flag2;
                if (beautymode != BeautyMode.x)
                {
                    break label0;
                }
            }
            flag = flag2;
            if (long1 == null)
            {
                flag = false;
            }
        }
        beautymode = h;
        int j;
        if (flag)
        {
            j = ((flag1) ? 1 : 0);
        } else
        {
            j = 8;
        }
        beautymode.setVisibility(j);
    }

    public void a(at at1)
    {
        if (!(at1 instanceof ba))
        {
            super.a(at1);
            return;
        }
        String s = ((ba)at1).o();
        if (s == null || s.equals(StatusManager.j().e()))
        {
            super.a(at1);
            return;
        } else
        {
            p = -1F;
            MotionControlHelper.e().a(at1);
            StatusManager.j().a(s, false, new Float[0]);
            n = at1;
            return;
        }
    }

    public void a(az az1)
    {
        super.a(az1);
        f = az1;
    }

    public void a(String s, String s1)
    {
        if (m != null)
        {
            BeautyMode beautymode = StatusManager.j().s();
            if (beautymode == BeautyMode.s)
            {
                m.a(false, false, s1, s);
                m.b(s1, s);
                return;
            }
            if (beautymode == BeautyMode.t)
            {
                if (s1 != null && s1.equalsIgnoreCase("default_original_double_eyelid"))
                {
                    m.h(false);
                    return;
                } else
                {
                    m.h(true);
                    return;
                }
            }
        }
    }

    protected boolean a(BeautyMode beautymode, i j)
    {
        Object obj;
        int l;
        int i1;
        long l1 = StatusManager.j().l();
        if (k.p())
        {
            obj = k.r();
        } else
        {
            obj = StatusManager.j().f(Long.valueOf(l1).longValue());
        }
        break MISSING_BLOCK_LABEL_26;
_L3:
        if (l < j.size() && ((at)j.get(l)).equals(beautymode.get(l))) goto _L2; else goto _L1
_L1:
        if (i1 == j.size())
        {
            l = 1;
        } else
        {
            l = 0;
        }
_L5:
        if (l != 0)
        {
            return false;
        }
        do
        {
            return true;
        } while (obj == null || ((a) (obj)).f() == null || ((a) (obj)).f().g() == null || ((a) (obj)).f().g().a(beautymode) == null);
        obj = ((a) (obj)).f().g();
        j = j.a(beautymode);
        beautymode = ((i) (obj)).a(beautymode);
        j = j.f();
        beautymode = beautymode.f();
        if (j == null || beautymode == null || j.size() != beautymode.size())
        {
            break MISSING_BLOCK_LABEL_218;
        }
        l = 0;
        i1 = 0;
          goto _L3
_L2:
        i1++;
        l++;
          goto _L3
        l = 0;
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected void b()
    {
        if (StatusManager.j().s() == BeautyMode.s)
        {
            StatusManager.j().a(this);
        }
    }

    public void b(String s)
    {
        if (d != null)
        {
            d.setText(s);
        }
        if (c != null)
        {
            c.setVisibility(8);
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

                final b a;

                public void a()
                {
                    if (a.k != null)
                    {
                        a.k.b(this);
                    }
                    a.i();
                }

            
            {
                a = b.this;
                super();
            }
            });
            if (n instanceof ba)
            {
                String s = ((ba)n).o();
                if (s != null && !s.equals(StatusManager.j().e()))
                {
                    StatusManager.j().b(s);
                    MotionControlHelper.e().t();
                    MotionControlHelper.e().a(true);
                    if (m != null)
                    {
                        m.a(StatusManager.j().s(), s);
                    }
                }
            }
            a(n);
            return;
        }
        Object obj = (EditViewActivity)getActivity();
        boolean flag;
        if (obj != null)
        {
            flag = ((EditViewActivity) (obj)).A();
        } else
        {
            flag = false;
        }
        if (flag)
        {
            obj = StatusManager.j().j(StatusManager.j().l());
        } else
        {
            obj = StatusManager.j().g(StatusManager.j().l());
        }
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

    public void c(boolean flag)
    {
        if (h != null)
        {
            h.setSelected(flag);
        }
    }

    protected void d()
    {
        if (k != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        BeautyMode beautymode = StatusManager.j().s();
        long l = StatusManager.j().l();
        MotionControlHelper.e().t();
        Object obj = (EditViewActivity)getActivity();
        at at1;
        v v1;
        boolean flag;
        if (obj != null)
        {
            flag = ((EditViewActivity) (obj)).A();
        } else
        {
            flag = false;
        }
        if (flag)
        {
            obj = StatusManager.j().j(l);
        } else
        {
            obj = StatusManager.j().g(l);
        }
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj = ((com.cyberlink.youcammakeup.kernelctrl.status.d) (obj)).e();
        if (obj == null) goto _L4; else goto _L5
_L5:
        v1 = ((a) (obj)).f();
        if (v1 == null || v1.a() == null) goto _L7; else goto _L6
_L6:
        if (m != null)
        {
            m.a(v1.b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a).intValue());
        }
        obj = new ArrayList();
        ((List) (obj)).add(v1.b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a));
        MotionControlHelper.e().c(((List) (obj)));
        at1 = v1.a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a);
        if (beautymode == BeautyMode.r || beautymode == BeautyMode.s)
        {
            if (m != null)
            {
                m.b(v1.d().intValue());
            }
            MotionControlHelper.e().a(v1.d().intValue());
            obj = at1;
        } else
        {
            obj = at1;
            if (beautymode == BeautyMode.t)
            {
                obj = at1;
                if (m != null)
                {
                    if (v1.a().equalsIgnoreCase("default_original_double_eyelid"))
                    {
                        m.h(false);
                        obj = at1;
                    } else
                    {
                        m.h(true);
                        obj = at1;
                    }
                }
            }
        }
_L8:
        if (obj != null)
        {
            Globals.d().j().a(((at) (obj)));
            n = ((at) (obj));
            if (m != null)
            {
                m.a(((at) (obj)), true);
                m.a(((at) (obj)), v1.a());
            }
        }
        if (beautymode == BeautyMode.r)
        {
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
            break MISSING_BLOCK_LABEL_597;
        }
_L4:
        if (true) goto _L1; else goto _L7
_L7:
label0:
        {
            if (v1 == null || beautymode != BeautyMode.b)
            {
                break label0;
            }
            if (m != null)
            {
                m.a(v1.b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a).intValue());
            }
            obj = new ArrayList();
            ((List) (obj)).add(v1.b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a));
            MotionControlHelper.e().c(((List) (obj)));
            obj = v1.a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a);
        }
          goto _L8
        if (m != null)
        {
            m.a(0.0F);
        }
        obj = new ArrayList();
        ((List) (obj)).add(Integer.valueOf(0));
        MotionControlHelper.e().c(((List) (obj)));
        at1 = PanelDataCenter.a().c(beautymode);
        if (beautymode == BeautyMode.r) goto _L10; else goto _L9
_L9:
        obj = at1;
        if (beautymode != BeautyMode.s) goto _L8; else goto _L10
_L10:
        if (m != null)
        {
            m.b(0.0F);
        }
        MotionControlHelper.e().a(0.0F);
        obj = at1;
          goto _L8
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

    public void d(boolean flag)
    {
        if (e == null)
        {
            return;
        }
        View view = e;
        int j;
        if (flag)
        {
            j = 0;
        } else
        {
            j = 8;
        }
        view.setVisibility(j);
    }

    protected void g()
    {
        if (StatusManager.j().s() == BeautyMode.s)
        {
            StatusManager.j().b(this);
        }
        super.g();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        g = layoutinflater.inflate(0x7f030164, viewgroup, false);
        return g;
    }
}
