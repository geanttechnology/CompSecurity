// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.clflurry.YMKApplyEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.n;
import com.cyberlink.youcammakeup.flurry.PopularityOfHairDyeColorEvent;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.q;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.SkuTemplateUtils;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.utility.az;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.common.a.d;
import com.cyberlink.youcammakeup.widgetpool.dialogs.ah;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            n, HairDyeToolPanelMenu, k

public class j extends com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.n
{

    public j()
    {
    }

    protected void a()
    {
        c = new HairDyeToolPanelMenu();
        e = new com.cyberlink.youcammakeup.widgetpool.common.a.j();
        e.a(c);
        e.a(0x7f0300f5);
        e.a("assets://makeup/wig/texture_hair_frame.png");
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
        Object obj;
        Object obj1;
        String s;
        String as[];
        aw aw1;
        StringBuilder stringbuilder;
        int l;
        int j1;
        if (a1.f() == null)
        {
            a1 = new i();
        } else
        {
            a1 = new i(a1.f().g());
        }
        obj1 = StatusManager.j().e();
        s = StatusManager.j().g();
        l = (int)MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a);
        j1 = (int)MotionControlHelper.e().w();
        aw1 = PanelDataCenter.a().i(s);
        obj = StatusManager.j().s();
        stringbuilder = (new StringBuilder()).append("HairDyeToolPanel configPostApply, BeautyMode = ");
        if (obj == null)
        {
            obj = "null";
        }
        stringbuilder = stringbuilder.append(obj).append(" , pattern = ");
        if (obj1 != null)
        {
            obj = obj1;
        } else
        {
            obj = "null";
        }
        stringbuilder = stringbuilder.append(((String) (obj))).append(" , palette = ");
        if (s != null)
        {
            obj = s;
        } else
        {
            obj = "null";
        }
        obj = stringbuilder.append(((String) (obj))).append(" save my look show me again = ").append(ah.b).toString();
        Globals.d().e(((String) (obj)));
        obj = aw1.i();
        obj1 = new q(new r(((String) (obj1)), s, null, ((List) (obj)), j1), l);
        a1.a(((q) (obj1)));
        as = new String[((List) (obj)).size()];
        for (int i1 = 0; i1 < ((List) (obj)).size(); i1++)
        {
            as[i1] = ((at)((List) (obj)).get(i1)).i();
        }

        com.cyberlink.youcammakeup.clflurry.b.a(new n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.y));
        if (obj1 != null && ((q) (obj1)).e() != null)
        {
            com.cyberlink.youcammakeup.flurry.a.a(new PopularityOfHairDyeColorEvent(((q) (obj1)).e().i(), ((q) (obj1)).a(), ((q) (obj1)).g()));
        }
        obj = new YMKApplyEvent(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.A);
        YMKApplyEvent.a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.A, ((r) (obj1)), ((YMKApplyEvent) (obj)));
        com.cyberlink.youcammakeup.clflurry.b.a(((YMKApplyEvent) (obj)).e());
        a1.a(false);
        StatusManager.j().a(a1);
    }

    public void b()
    {
        if (b != null)
        {
            b.w(false);
        }
        super.b();
    }

    public void c()
    {
        if (b != null)
        {
            b.w(false);
        }
        super.c();
    }

    protected void c(Long long1)
    {
        if (long1 == o || long1 != null && long1.equals(o))
        {
            if (b != null)
            {
                Globals.d().i().h(b);
            }
            return;
        }
        if (b != null)
        {
            Globals.d().i().b(b);
        }
        long1 = new Runnable(long1) {

            final Long a;
            final j b;

            public void run()
            {
                b.a(a);
                StatusManager.j().s();
                Object obj;
                Object obj1;
                Object obj2;
                if (b.o != null)
                {
                    b.s.put(b.o, MotionControlHelper.e().M());
                } else
                {
                    b.t = MotionControlHelper.e().M();
                }
                if (a != null)
                {
                    obj1 = new az(a, b.p);
                    obj = h.b().a(b.p, a).d();
                    obj2 = (v)b.s.get(a);
                    aw aw1;
                    if (obj2 != null)
                    {
                        obj = ((v) (obj2)).c();
                        Float afloat[] = {
                            Float.valueOf(((v) (obj2)).d().intValue())
                        };
                        obj2 = obj1;
                        obj1 = obj;
                        obj = afloat;
                    } else
                    {
                        obj = SkuTemplateUtils.d(((String) (obj)));
                        Object obj3;
                        if (obj != null)
                        {
                            obj = ((aw) (obj)).a();
                        } else
                        {
                            obj = null;
                        }
                        obj2 = obj;
                        obj = new Float[0];
                        obj3 = obj1;
                        obj1 = obj2;
                        obj2 = obj3;
                    }
                } else
                {
                    obj1 = b.t;
                    if (obj1 != null)
                    {
                        obj = new Float[1];
                        obj[0] = Float.valueOf(((v) (obj1)).d().intValue());
                    } else
                    {
                        obj = new Float[1];
                        obj[0] = Float.valueOf(b.L());
                    }
                    if (obj1 == null)
                    {
                        obj1 = "default_original_hair_dye";
                    } else
                    {
                        obj1 = ((v) (obj1)).c();
                    }
                    obj2 = null;
                }
                aw1 = PanelDataCenter.a().i(((String) (obj1)));
                b.a(a, false);
                b.a(aw1, ((az) (obj2)));
                b.c.a(((String) (obj1)), ((Float []) (obj)));
            }

            
            {
                b = j.this;
                a = long1;
                super();
            }
        };
        a.post(long1);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        a = layoutinflater.inflate(0x7f030179, viewgroup, false);
        d(StatusManager.j().s());
        return a;
    }
}
