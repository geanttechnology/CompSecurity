// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.SponsorConsultActivity;
import com.cyberlink.youcammakeup.activity.WebViewerExActivity;
import com.cyberlink.youcammakeup.clflurry.YMKApplyEvent;
import com.cyberlink.youcammakeup.clflurry.YMKClicksLipsCartEvent;
import com.cyberlink.youcammakeup.clflurry.YMKFeatures;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.i;
import com.cyberlink.youcammakeup.clflurry.n;
import com.cyberlink.youcammakeup.clflurry.s;
import com.cyberlink.youcammakeup.clflurry.w;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.database.more.i.e;
import com.cyberlink.youcammakeup.flurry.PopularityOfWigColorEvent;
import com.cyberlink.youcammakeup.flurry.PopularityOfWigPatternEvent;
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
import com.cyberlink.youcammakeup.widgetpool.common.a.j;
import com.perfectcorp.utility.u;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            n, r, k

public class q extends com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.n
{

    public q()
    {
    }

    private boolean a(String s1, List list)
    {
label0:
        {
            if (s1 == null)
            {
                return false;
            }
            if (list == null)
            {
                break label0;
            }
            list = list.iterator();
            aw aw1;
            do
            {
                if (!list.hasNext())
                {
                    break label0;
                }
                aw1 = (aw)list.next();
            } while (aw1 == null || aw1.a() == null || !aw1.a().equalsIgnoreCase(s1));
            return true;
        }
        return false;
    }

    protected void F()
    {
        if (!E())
        {
            a(C);
        } else
        {
            Object obj = h.b().a(p, o);
            e e1;
            if (obj != null)
            {
                obj = ((d) (obj)).d();
            } else
            {
                obj = null;
            }
            e1 = h.b().a(p, ((String) (obj)), StatusManager.j().e());
            if (e1 != null)
            {
                if (obj != null && !((String) (obj)).isEmpty())
                {
                    b.a(new s(((String) (obj)), e1.a(), "purchase"));
                    b.a(new YMKClicksLipsCartEvent(((String) (obj)), e1.a()));
                }
                Object obj1 = new u(e1.c().toString());
                ((u) (obj1)).a("SourceType", "feature_room");
                ((u) (obj1)).a("SkuGuid", obj);
                ((u) (obj1)).a("SkuItemGuid", e1.a());
                try
                {
                    obj = Uri.parse(((u) (obj1)).c());
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                    return;
                }
                obj1 = ((Uri) (obj)).getScheme();
                if (obj1 != null && ((String) (obj1)).equalsIgnoreCase(getActivity().getString(0x7f070742)))
                {
                    startActivity(new Intent("android.intent.action.VIEW", ((Uri) (obj))));
                    return;
                } else
                {
                    Intent intent = new Intent(getActivity(), com/cyberlink/youcammakeup/activity/WebViewerExActivity);
                    intent.putExtra("RedirectUrl", e1.c().toString());
                    startActivity(intent);
                    return;
                }
            }
        }
    }

    protected void G()
    {
        if (!E())
        {
            a(D);
        } else
        {
            Object obj = h.b().a(p, o);
            e e1;
            if (obj != null)
            {
                obj = ((d) (obj)).d();
            } else
            {
                obj = null;
            }
            e1 = h.b().a(p, ((String) (obj)), StatusManager.j().e());
            if (e1 != null)
            {
                if (obj != null && !((String) (obj)).isEmpty())
                {
                    b.a(new s(((String) (obj)), e1.a(), "purchase"));
                    b.a(new YMKClicksLipsCartEvent(((String) (obj)), e1.a()));
                }
                u u1 = new u(e1.b().toString());
                u1.a("SourceType", "feature_room");
                u1.a("SkuGuid", obj);
                u1.a("SkuItemGuid", e1.a());
                try
                {
                    obj = Uri.parse(u1.c());
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                    return;
                }
                if (((Uri) (obj)).getScheme().equalsIgnoreCase(getActivity().getString(0x7f070742)))
                {
                    startActivity(new Intent("android.intent.action.VIEW", ((Uri) (obj))));
                    return;
                } else
                {
                    Intent intent = new Intent(getActivity(), com/cyberlink/youcammakeup/activity/WebViewerExActivity);
                    intent.putExtra("RedirectUrl", e1.b().toString());
                    startActivity(intent);
                    return;
                }
            }
        }
    }

    protected void H()
    {
        Object obj1 = null;
        if (!E())
        {
            a(E);
        } else
        {
            Object obj = h.b().a(p, o);
            e e1;
            if (obj != null)
            {
                obj = ((d) (obj)).d();
            } else
            {
                obj = null;
            }
            e1 = h.b().a(p, ((String) (obj)), StatusManager.j().e());
            if (e1 != null)
            {
                obj1 = e1.a();
            }
            obj1 = new com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl(p, ((String) (obj)), ((String) (obj1)), StatusManager.j().e());
            if (obj1 != null)
            {
                String s1 = ((com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl) (obj1)).type;
                obj = ((com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl) (obj1)).skuGuid;
                String s2 = ((com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl) (obj1)).itemGuid;
                b.a(new i(s1, ((String) (obj)), s2));
                b.a(new w(SkuTemplateUtils.i(s1), ((String) (obj)), s2));
                b.a(new s(((String) (obj)), s2, "more_info"));
            }
            if (e1 != null)
            {
                u u1 = new u(e1.d().toString());
                u1.a("SourceType", "feature_room");
                u1.a("SkuGuid", obj);
                u1.a("SkuItemGuid", e1.a());
                try
                {
                    obj = Uri.parse(u1.c());
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                    return;
                }
                if (((Uri) (obj)).getScheme().equalsIgnoreCase(getActivity().getString(0x7f070742)))
                {
                    startActivity(new Intent("android.intent.action.VIEW", ((Uri) (obj))));
                    return;
                } else
                {
                    Intent intent = new Intent(getActivity(), com/cyberlink/youcammakeup/activity/SponsorConsultActivity);
                    intent.putExtra("URL_CONTENT", ((java.io.Serializable) (obj1)));
                    startActivity(intent);
                    return;
                }
            }
        }
    }

    protected String a(String s1, v v1, String s2)
    {
        if (v1 != null && v1.a() != null)
        {
            return v1.a();
        }
        if (s1 != null)
        {
            v1 = PanelDataCenter.a().a(s1, null);
            if (v1.size() > 0)
            {
                return (String)v1.get(0);
            }
        }
        return j(s1);
    }

    protected void a()
    {
        c = new r();
        e = new j();
        e.a(c);
        e.a(0x7f0300f6);
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
        String as[];
        Object obj2;
        if (a1.f() == null)
        {
            a1 = new com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i();
        } else
        {
            a1 = new com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i(a1.f().g());
        }
        obj = StatusManager.j().g();
        obj2 = PanelDataCenter.a().i(((String) (obj))).i();
        obj = MotionControlHelper.e().D();
        obj1 = StatusManager.j().s();
        b.a(new n(YMKFeatures.a(((com.cyberlink.youcammakeup.utility.BeautyMode) (obj1)))));
        a1.a(((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.u) (obj)));
        as = new String[((List) (obj2)).size()];
        for (int l = 0; l < ((List) (obj2)).size(); l++)
        {
            as[l] = ((at)((List) (obj2)).get(l)).i();
        }

        obj2 = new YMKApplyEvent(YMKApplyEvent.a(((com.cyberlink.youcammakeup.utility.BeautyMode) (obj1))));
        YMKApplyEvent.a(YMKApplyEvent.a(((com.cyberlink.youcammakeup.utility.BeautyMode) (obj1))), ((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r) (obj)), ((YMKApplyEvent) (obj2)));
        b.a(((YMKApplyEvent) (obj2)).e());
        b.a(new n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.x));
        obj1 = YMKApplyEvent.b(as);
        String s1 = ((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.u) (obj)).b();
        float f = ((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.u) (obj)).g();
        com.cyberlink.youcammakeup.flurry.a.a(new PopularityOfWigPatternEvent(s1));
        com.cyberlink.youcammakeup.flurry.a.a(new PopularityOfWigColorEvent(((String) (obj1)), 100F - f));
        a1.a(false);
        StatusManager.j().a(a1);
    }

    public transient void a(String s1, boolean flag, Float afloat[])
    {
        Object obj1;
        obj1 = null;
        StatusManager.j().b(s1);
        break MISSING_BLOCK_LABEL_10;
        while (true) 
        {
            do
            {
                return;
            } while (c == null || b == null || m);
label0:
            {
label1:
                {
                    Object obj2 = StatusManager.j().s();
                    if (s1 == null)
                    {
                        break label0;
                    }
                    Object obj = PanelDataCenter.a().m(s1);
                    float f;
                    if (o == null)
                    {
                        int l;
                        int i1;
                        if (s1.equals("default_original_wig"))
                        {
                            obj = PanelDataCenter.a().a(((com.cyberlink.youcammakeup.utility.BeautyMode) (obj2)), 1);
                        } else
                        {
                            obj = MotionControlHelper.e().k(s1);
                        }
                        obj = PanelDataCenter.a().i(((String) (obj)));
                    } else
                    {
                        if (e != null)
                        {
                            e.a();
                        }
                        String s2 = StatusManager.j().g();
                        if (a(s2, ((List) (obj))))
                        {
                            obj = PanelDataCenter.a().i(s2);
                        } else
                        if (obj != null && ((List) (obj)).size() > 0)
                        {
                            obj = (aw)((List) (obj)).get(0);
                        } else
                        {
                            obj = null;
                        }
                    }
                    obj2 = h.b().a(p, o);
                    if (obj2 != null)
                    {
                        obj1 = ((d) (obj2)).d();
                    }
                    a(((String) (obj1)), s1);
                    if (obj == null)
                    {
                        break label0;
                    }
                    StatusManager.j().c(((aw) (obj)).a());
                    a(((aw) (obj)), true);
                    Globals.d().j().d(((aw) (obj)).i());
                    obj1 = ((aw) (obj)).i();
                    if (((List) (obj1)).size() > 0)
                    {
                        MotionControlHelper.e().a((at)((List) (obj1)).get(0));
                    }
                    if (afloat.length > 0)
                    {
                        f = afloat[0].floatValue();
                    } else
                    {
                        f = 100 - K();
                    }
                    i1 = (int)f;
                    if (afloat != null)
                    {
                        l = i1;
                        if (afloat.length != 0)
                        {
                            break label1;
                        }
                    }
                    afloat = PanelDataCenter.a().b(s1, ((aw) (obj)).a());
                    l = i1;
                    if (afloat.size() > 0)
                    {
                        if (((Integer)afloat.get(0)).intValue() > 0)
                        {
                            f = ((Integer)afloat.get(0)).intValue();
                        } else
                        {
                            f = J();
                        }
                        l = (int)f;
                    }
                }
                afloat = new ArrayList();
                afloat.add(Integer.valueOf(l));
                Globals.d().j().c(afloat);
                a(100 - ((Integer)afloat.get(0)).intValue());
            }
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
            final q b;

            public void run()
            {
                b.a(a);
                Object obj = StatusManager.j().s();
                Object obj1;
                Object obj2;
                az az1;
                String s1;
                if (b.o != null)
                {
                    b.s.put(b.o, MotionControlHelper.e().M());
                } else
                {
                    b.t = MotionControlHelper.e().M();
                }
                if (a != null)
                {
                    az1 = new az(a, b.p);
                    s1 = h.b().a(b.p, a).d();
                    obj = (v)b.s.get(a);
                    aw aw1;
                    if (obj != null)
                    {
                        obj1 = ((v) (obj)).c();
                        float f = ((v) (obj)).b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a).intValue();
                        Float afloat[] = {
                            Float.valueOf(f)
                        };
                        obj2 = obj;
                        obj = afloat;
                    } else
                    {
                        obj1 = SkuTemplateUtils.d(s1);
                        if (obj1 != null)
                        {
                            obj1 = ((aw) (obj1)).a();
                        } else
                        {
                            obj1 = null;
                        }
                        obj2 = obj;
                        obj = new Float[0];
                    }
                } else
                {
                    obj2 = b.t;
                    if (obj2 == null || obj2 != null && ((v) (obj2)).a() != null && ((v) (obj2)).a().equals("default_original_wig"))
                    {
                        obj1 = PanelDataCenter.a().a(((com.cyberlink.youcammakeup.utility.BeautyMode) (obj)), 1);
                    } else
                    {
                        obj1 = MotionControlHelper.e().k(((v) (obj2)).a());
                    }
                    if (obj2 != null)
                    {
                        obj = new Float[1];
                        obj[0] = Float.valueOf(((v) (obj2)).b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a).intValue());
                    } else
                    {
                        obj = new Float[1];
                        obj[0] = Float.valueOf(b.J());
                    }
                    az1 = null;
                    s1 = null;
                }
                aw1 = PanelDataCenter.a().i(((String) (obj1)));
                StatusManager.j().c(((String) (obj1)));
                obj1 = b.a(s1, ((v) (obj2)), ((String) (obj1)));
                b.a(az1, null);
                b.d(((String) (obj1)));
                b.a(a, false);
                b.a(aw1, az1);
                if (obj1 != null && !((String) (obj1)).equals(StatusManager.j().e()))
                {
                    StatusManager.j().b(((String) (obj1)));
                    MotionControlHelper.e().t();
                    MotionControlHelper.e().a(true);
                }
                StatusManager.j().a(((String) (obj1)), false, ((Float []) (obj)));
                obj = new Runnable(this) {

                    final _cls1 a;

                    public void run()
                    {
                        a.b.a(false, false, StatusManager.j().e(), null);
                        a.b.b(StatusManager.j().e(), null);
                        a.b.g(null);
                    }

            
            {
                a = _pcls1;
                super();
            }
                };
                b.a.post(((Runnable) (obj)));
            }

            
            {
                b = q.this;
                a = long1;
                super();
            }
        };
        a.post(long1);
    }

    public String j(String s1)
    {
        Object obj;
label0:
        {
            obj = StatusManager.j().s();
            e e1 = null;
            List list = PanelDataCenter.a().a(((com.cyberlink.youcammakeup.utility.BeautyMode) (obj)));
            obj = e1;
            if (list != null)
            {
                obj = e1;
                if (list.size() > 0)
                {
                    obj = e1;
                    if (s1 == null)
                    {
                        obj = "default_original_wig";
                    }
                }
            }
            if (obj != null || s1 == null)
            {
                break label0;
            }
            s1 = h.b().a(p, h.b().c(s1)).l().iterator();
            do
            {
                if (!s1.hasNext())
                {
                    break label0;
                }
                e1 = (e)s1.next();
            } while (e1 == null || PanelDataCenter.a().p(e1.a()) == null);
            return e1.a();
        }
        return ((String) (obj));
    }

    protected void o()
    {
        long l = StatusManager.j().l();
        Object obj = StatusManager.j().g(l);
        if (obj != null)
        {
            if ((obj = ((com.cyberlink.youcammakeup.kernelctrl.status.d) (obj)).e()) != null)
            {
                v v1 = ((a) (obj)).f();
                com.cyberlink.youcammakeup.utility.BeautyMode beautymode = StatusManager.j().s();
                Object obj1;
                if (v1 != null && v1.a() != null)
                {
                    obj = v1.c();
                    obj = PanelDataCenter.a().i(((String) (obj)));
                    Long long1 = h.b().c(((aw) (obj)).k());
                    obj1 = v1.a();
                    if (!a(long1, o) || v1.a() != StatusManager.j().e())
                    {
                        StatusManager.j().b(v1.a());
                        a(long1);
                        a(long1, true);
                        com.cyberlink.youcammakeup.widgetpool.common.a.d d1 = e;
                        if (long1 != null)
                        {
                            obj = new az(o, p);
                        } else
                        {
                            obj = null;
                        }
                        d1.a(((az) (obj)));
                        e.a();
                        a(beautymode);
                        b(long1);
                        obj = h.b().a(p, o);
                        if (obj != null)
                        {
                            obj = ((d) (obj)).d();
                        } else
                        {
                            obj = null;
                        }
                        a(((String) (obj)), v1.a());
                    }
                    obj = obj1;
                } else
                {
                    obj1 = PanelDataCenter.a().a(beautymode);
                    if (obj1 != null && ((List) (obj1)).size() > 0)
                    {
                        obj = (String)((List) (obj1)).get(0);
                        StatusManager.j().b((String)((List) (obj1)).get(0));
                    } else
                    {
                        obj = null;
                    }
                }
                if (o != null)
                {
                    obj1 = new az(o, p);
                } else
                {
                    obj1 = null;
                }
                a(((az) (obj1)), null);
                if (obj != null)
                {
                    d(((String) (obj)));
                    a(false, false, ((String) (obj)), null);
                    b(((String) (obj)), null);
                    return;
                }
            }
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        a = layoutinflater.inflate(0x7f03017c, viewgroup, false);
        d(StatusManager.j().s());
        return a;
    }
}
