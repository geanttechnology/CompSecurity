// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.clflurry.YMKApplyEvent;
import com.cyberlink.youcammakeup.clflurry.YMKFeatures;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.n;
import com.cyberlink.youcammakeup.flurry.PopularityOfEyeBrowColorEvent;
import com.cyberlink.youcammakeup.flurry.PopularityOfEyeBrowPatternEvent;
import com.cyberlink.youcammakeup.jniproxy.y;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.s;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.SkuTemplateUtils;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.utility.az;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.common.a.d;
import com.cyberlink.youcammakeup.widgetpool.common.a.j;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            n, i, k, BeautyToolPanelItemAdapter

public class h extends com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.n
{

    public h()
    {
    }

    protected r a(i l, BeautyMode beautymode)
    {
        return l.a();
    }

    protected void a()
    {
        c = new com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.i();
        e = new j();
        e.a(c);
        e.a(0x7f0300f5);
        FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
        fragmenttransaction.replace(0x7f0c0661, (Fragment)c);
        fragmenttransaction.replace(0x7f0c065f, e);
        f = (ViewGroup)a.findViewById(0x7f0c065f);
        c.a(this);
        if (n && o != null)
        {
            e.a(new az(o, p));
            c.a(new az(o, p));
        }
        fragmenttransaction.commitAllowingStateLoss();
    }

    protected void a(a a1)
    {
        String s1;
        Object obj;
        Object obj1;
        BeautyMode beautymode;
        String as[];
        int l;
        int j1;
        if (a1.f() == null)
        {
            a1 = new i();
        } else
        {
            a1 = new i(a1.f().g());
        }
        s1 = StatusManager.j().e();
        obj1 = StatusManager.j().g();
        j1 = (int)MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a);
        l = (int)MotionControlHelper.e().w();
        obj = PanelDataCenter.a().i(((String) (obj1))).i();
        obj1 = new s(s1, ((String) (obj1)), ((List) (obj)), j1, l);
        beautymode = StatusManager.j().s();
        com.cyberlink.youcammakeup.clflurry.b.a(new n(YMKFeatures.a(beautymode)));
        a1.a(((s) (obj1)));
        as = new String[((List) (obj)).size()];
        for (int i1 = 0; i1 < ((List) (obj)).size(); i1++)
        {
            as[i1] = ((at)((List) (obj)).get(i1)).i();
        }

        obj = new YMKApplyEvent(YMKApplyEvent.a(beautymode));
        YMKApplyEvent.a(YMKApplyEvent.a(beautymode), ((r) (obj1)), ((YMKApplyEvent) (obj)));
        com.cyberlink.youcammakeup.clflurry.b.a(((YMKApplyEvent) (obj)).e());
        com.cyberlink.youcammakeup.flurry.a.a(new PopularityOfEyeBrowPatternEvent(s1));
        com.cyberlink.youcammakeup.flurry.a.a(new PopularityOfEyeBrowColorEvent(YMKApplyEvent.b(as), j1));
        a1.a(false);
        StatusManager.j().a(a1);
    }

    protected void a(com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl skutryiturl)
    {
        int l = 0;
        if (skutryiturl != null)
        {
            BeautyMode beautymode = StatusManager.j().s();
            BeautyMode beautymode1 = SkuTemplateUtils.h(skutryiturl.type);
            Object obj = PanelDataCenter.a().i(skutryiturl.itemGuid);
            if (beautymode == beautymode1 && obj != null)
            {
                String s1 = ((aw) (obj)).a();
                String s2 = a(skutryiturl.skuGuid, null, s1);
                skutryiturl = StatusManager.j().d();
                if (skutryiturl == null)
                {
                    skutryiturl = new i();
                }
                obj = ((aw) (obj)).i();
                List list = PanelDataCenter.a().b(s2, s1);
                if (list.size() > 0)
                {
                    l = ((Integer)list.get(0)).intValue();
                }
                int i1 = (int)L();
                if (skutryiturl.a() == null)
                {
                    if (h != null)
                    {
                        l = c(s2);
                        if (l >= 0)
                        {
                            i.a(l, true);
                            i.a(h.getView(l, null, i), l, -1L);
                            i.post(new Runnable(l) {

                                final int a;
                                final h b;

                                public void run()
                                {
                                    b.i.c(a);
                                }

            
            {
                b = h.this;
                a = l;
                super();
            }
                            });
                            return;
                        }
                    } else
                    {
                        skutryiturl.a(new s(s2, s1, ((List) (obj)), l, i1));
                        StatusManager.j().a(skutryiturl);
                        return;
                    }
                }
            }
        }
    }

    public transient void a(String s1, boolean flag, Float afloat[])
    {
        StatusManager.j().b(s1);
        break MISSING_BLOCK_LABEL_7;
        if (c != null && b != null && !m)
        {
            a(s1, o);
            a(StatusManager.j().s(), s1);
            if (c != null)
            {
                c.a(s1, flag);
            }
            if (MotionControlHelper.e().A())
            {
                b.j(true);
                if (!Globals.d().i().a())
                {
                    k();
                    return;
                }
            } else
            {
                l();
                return;
            }
        }
        return;
    }

    protected void b(a a1)
    {
        if (a1.f() == null)
        {
            a1 = new i();
        } else
        {
            a1 = new i(a1.f().g());
        }
        if (a1 != null)
        {
            s s1 = a1.a();
            if (s1 != null && s1.b() != null)
            {
                StatusManager.j().b(s1.b());
                com.cyberlink.youcammakeup.kernelctrl.j.a().e();
            }
        }
        StatusManager.j().a(a1);
    }

    public void i()
    {
        long l = StatusManager.j().l();
        a a1;
        if (b.p())
        {
            a1 = b.r();
        } else
        {
            a1 = StatusManager.j().f(l);
        }
        MotionControlHelper.e().c(a1);
        super.i();
    }

    protected void o()
    {
        super.o();
        if (b != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        long l = StatusManager.j().l();
        MotionControlHelper.e().t();
        obj = StatusManager.j().g(l);
        if (obj == null) goto _L1; else goto _L3
_L3:
        Object obj1 = ((com.cyberlink.youcammakeup.kernelctrl.status.d) (obj)).e();
        if (obj1 == null) goto _L1; else goto _L4
_L4:
        obj = ((a) (obj1)).f().a();
        if (obj == null) goto _L1; else goto _L5
_L5:
        if (!((String) (obj)).equals("Eyebrow_general")) goto _L7; else goto _L6
_L6:
        MotionControlHelper.e().a(((String) (obj)), ((a) (obj1)).a());
        MotionControlHelper.e().b(((String) (obj)), ((a) (obj1)).b());
        MotionControlHelper.e().g();
_L9:
        com.cyberlink.youcammakeup.kernelctrl.j.a().e();
        return;
_L7:
        List list = ((a) (obj1)).d();
        if (list != null && list.get(((a) (obj1)).e) != null && ((ar)list.get(((a) (obj1)).e)).c != null)
        {
            obj1 = ((ar)list.get(((a) (obj1)).e)).c;
            MotionControlHelper.e().a(((String) (obj)), ((y) (obj1)).b());
            MotionControlHelper.e().b(((String) (obj)), ((y) (obj1)).c());
        }
        if (true) goto _L9; else goto _L8
_L8:
    }
}
