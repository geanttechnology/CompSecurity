// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.SponsorConsultActivity;
import com.cyberlink.youcammakeup.activity.WebViewerExActivity;
import com.cyberlink.youcammakeup.clflurry.YMKApplyEvent;
import com.cyberlink.youcammakeup.clflurry.YMKClicksLipsCartEvent;
import com.cyberlink.youcammakeup.clflurry.YMKFeatures;
import com.cyberlink.youcammakeup.clflurry.af;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.i;
import com.cyberlink.youcammakeup.clflurry.s;
import com.cyberlink.youcammakeup.clflurry.w;
import com.cyberlink.youcammakeup.database.more.i.e;
import com.cyberlink.youcammakeup.flurry.PopularityOfBlushColorEvent;
import com.cyberlink.youcammakeup.flurry.PopularityOfBlushPatternEvent;
import com.cyberlink.youcammakeup.flurry.PopularityOfEyeLashColorEvent;
import com.cyberlink.youcammakeup.flurry.PopularityOfEyeLashPatternEvent;
import com.cyberlink.youcammakeup.flurry.PopularityOfEyeLinerColorEvent;
import com.cyberlink.youcammakeup.flurry.PopularityOfEyeLinerPatternEvent;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.DownloadUseUtils;
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
import com.cyberlink.youcammakeup.widgetpool.dialogs.ah;
import com.perfectcorp.utility.u;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            BeautyToolPanel, o, k, BeautyToolPanelItemAdapter, 
//            b

public class n extends BeautyToolPanel
{

    public n()
    {
    }

    protected void F()
    {
        if (!E())
        {
            a(C);
        } else
        {
            Object obj = PanelDataCenter.a().i(StatusManager.j().g());
            if (obj != null)
            {
                Object obj1 = ((aw) (obj)).k();
                obj = h.b().a(p, ((String) (obj1)), ((aw) (obj)).a());
                if (obj != null)
                {
                    if (obj1 != null && !((String) (obj1)).isEmpty())
                    {
                        com.cyberlink.youcammakeup.clflurry.b.a(new s(((String) (obj1)), ((e) (obj)).a(), "purchase"));
                        com.cyberlink.youcammakeup.clflurry.b.a(new YMKClicksLipsCartEvent(((String) (obj1)), ((e) (obj)).a()));
                    }
                    Object obj2 = new u(((e) (obj)).c().toString());
                    ((u) (obj2)).a("SourceType", "feature_room");
                    ((u) (obj2)).a("SkuGuid", obj1);
                    ((u) (obj2)).a("SkuItemGuid", ((e) (obj)).a());
                    try
                    {
                        obj1 = Uri.parse(((u) (obj2)).c());
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        ((Exception) (obj)).printStackTrace();
                        return;
                    }
                    obj2 = ((Uri) (obj1)).getScheme();
                    if (obj2 != null && ((String) (obj2)).equalsIgnoreCase(getActivity().getString(0x7f070742)))
                    {
                        startActivity(new Intent("android.intent.action.VIEW", ((Uri) (obj1))));
                        return;
                    } else
                    {
                        Intent intent = new Intent(getActivity(), com/cyberlink/youcammakeup/activity/WebViewerExActivity);
                        intent.putExtra("RedirectUrl", ((e) (obj)).c().toString());
                        startActivity(intent);
                        return;
                    }
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
            Object obj = PanelDataCenter.a().i(StatusManager.j().g());
            if (obj != null)
            {
                Object obj1 = ((aw) (obj)).k();
                obj = h.b().a(p, ((String) (obj1)), ((aw) (obj)).a());
                if (obj != null)
                {
                    if (obj1 != null && !((String) (obj1)).isEmpty())
                    {
                        com.cyberlink.youcammakeup.clflurry.b.a(new s(((String) (obj1)), ((e) (obj)).a(), "purchase"));
                        com.cyberlink.youcammakeup.clflurry.b.a(new YMKClicksLipsCartEvent(((String) (obj1)), ((e) (obj)).a()));
                    }
                    u u1 = new u(((e) (obj)).b().toString());
                    u1.a("SourceType", "feature_room");
                    u1.a("SkuGuid", obj1);
                    u1.a("SkuItemGuid", ((e) (obj)).a());
                    try
                    {
                        obj1 = Uri.parse(u1.c());
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        ((Exception) (obj)).printStackTrace();
                        return;
                    }
                    if (((Uri) (obj1)).getScheme().equalsIgnoreCase(getActivity().getString(0x7f070742)))
                    {
                        startActivity(new Intent("android.intent.action.VIEW", ((Uri) (obj1))));
                        return;
                    } else
                    {
                        Intent intent = new Intent(getActivity(), com/cyberlink/youcammakeup/activity/WebViewerExActivity);
                        intent.putExtra("RedirectUrl", ((e) (obj)).b().toString());
                        startActivity(intent);
                        return;
                    }
                }
            }
        }
    }

    protected void H()
    {
        Object obj2 = null;
        if (!E())
        {
            a(E);
        } else
        {
            Object obj = PanelDataCenter.a().i(StatusManager.j().g());
            if (obj != null)
            {
                com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl skutryiturl = new com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl(p, ((aw) (obj)).k(), ((aw) (obj)).a(), null);
                Object obj1;
                e e1;
                if (skutryiturl != null)
                {
                    String s1 = skutryiturl.type;
                    obj = skutryiturl.skuGuid;
                    obj1 = skutryiturl.itemGuid;
                    com.cyberlink.youcammakeup.clflurry.b.a(new i(s1, ((String) (obj)), ((String) (obj1))));
                    com.cyberlink.youcammakeup.clflurry.b.a(new w(SkuTemplateUtils.i(s1), ((String) (obj)), ((String) (obj1))));
                    com.cyberlink.youcammakeup.clflurry.b.a(new s(((String) (obj)), ((String) (obj1)), "more_info"));
                } else
                {
                    obj1 = null;
                    obj = null;
                }
                e1 = obj2;
                if (obj != null)
                {
                    e1 = obj2;
                    if (obj1 != null)
                    {
                        e1 = h.b().a(p, ((String) (obj)), ((String) (obj1)));
                    }
                }
                if (e1 != null)
                {
                    obj1 = new u(e1.d().toString());
                    ((u) (obj1)).a("SourceType", "feature_room");
                    ((u) (obj1)).a("SkuGuid", obj);
                    ((u) (obj1)).a("SkuItemGuid", e1.a());
                    try
                    {
                        obj = Uri.parse(((u) (obj1)).c());
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        ((Exception) (obj)).printStackTrace();
                        return;
                    }
                    obj1 = ((Uri) (obj)).getScheme();
                    if (obj1 != null && ((String) (obj1)).equalsIgnoreCase(getActivity().getString(0x7f070742)))
                    {
                        startActivity(new Intent("android.intent.action.VIEW", ((Uri) (obj))));
                        return;
                    } else
                    {
                        obj = new Intent(getActivity(), com/cyberlink/youcammakeup/activity/SponsorConsultActivity);
                        ((Intent) (obj)).putExtra("URL_CONTENT", skutryiturl);
                        startActivity(((Intent) (obj)));
                        return;
                    }
                }
            }
        }
    }

    protected r a(com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i l, BeautyMode beautymode)
    {
        return l.a(beautymode);
    }

    protected String a(String s1, v v1, String s2)
    {
        if (v1 != null && v1.a() != null)
        {
            return v1.a();
        }
        if (s1 != null)
        {
            s1 = PanelDataCenter.a().a(s2, null);
            if (s1.size() > 0)
            {
                return (String)s1.get(0);
            }
        }
        return g();
    }

    protected void a()
    {
        c = new com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.o();
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
        float f;
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        String as[];
        StringBuilder stringbuilder;
        int l;
        if (a1.f() == null)
        {
            a1 = new com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i();
        } else
        {
            a1 = new com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i(a1.f().g());
        }
        obj1 = StatusManager.j().e();
        obj2 = StatusManager.j().g();
        l = (int)MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a);
        obj3 = PanelDataCenter.a().i(((String) (obj2)));
        obj = StatusManager.j().s();
        stringbuilder = (new StringBuilder()).append("MultiColorToolPanel configPostApply, BeautyMode = ");
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
        if (obj2 != null)
        {
            obj = obj2;
        } else
        {
            obj = "null";
        }
        obj = stringbuilder.append(((String) (obj))).append(" save my look show me again = ").append(ah.b).toString();
        Globals.d().e(((String) (obj)));
        obj3 = ((aw) (obj3)).i();
        obj = new r(((String) (obj1)), ((String) (obj2)), null, ((List) (obj3)), l);
        obj1 = StatusManager.j().s();
        com.cyberlink.youcammakeup.clflurry.b.a(new com.cyberlink.youcammakeup.clflurry.n(YMKFeatures.a(((BeautyMode) (obj1)))));
        a1.a(((BeautyMode) (obj1)), ((r) (obj)));
        as = new String[((List) (obj3)).size()];
        for (int i1 = 0; i1 < ((List) (obj3)).size(); i1++)
        {
            as[i1] = ((at)((List) (obj3)).get(i1)).i();
        }

        as = YMKApplyEvent.b(as);
        obj3 = ((r) (obj)).b();
        f = ((r) (obj)).g();
        if (obj1 != BeautyMode.a) goto _L2; else goto _L1
_L1:
        com.cyberlink.youcammakeup.flurry.a.a(new PopularityOfBlushPatternEvent(((String) (obj3))));
        com.cyberlink.youcammakeup.flurry.a.a(new PopularityOfBlushColorEvent(as, f));
_L4:
        as = new YMKApplyEvent(YMKApplyEvent.a(((BeautyMode) (obj1))));
        YMKApplyEvent.a(YMKApplyEvent.a(((BeautyMode) (obj1))), ((r) (obj)), as);
        com.cyberlink.youcammakeup.clflurry.b.a(as.e());
        a1.a(false);
        StatusManager.j().a(a1);
        return;
_L2:
        if (obj1 == BeautyMode.m)
        {
            com.cyberlink.youcammakeup.flurry.a.a(new PopularityOfEyeLashPatternEvent(((String) (obj3))));
            com.cyberlink.youcammakeup.flurry.a.a(new PopularityOfEyeLashColorEvent(as, f));
        } else
        if (obj1 == BeautyMode.l)
        {
            com.cyberlink.youcammakeup.flurry.a.a(new PopularityOfEyeLinerPatternEvent(((String) (obj3))));
            com.cyberlink.youcammakeup.flurry.a.a(new PopularityOfEyeLinerColorEvent(as, f));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void a(com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl skutryiturl)
    {
        int l = 0;
        if (skutryiturl != null)
        {
            BeautyMode beautymode1 = StatusManager.j().s();
            BeautyMode beautymode = SkuTemplateUtils.h(skutryiturl.type);
            Object obj = PanelDataCenter.a().i(skutryiturl.itemGuid);
            if (beautymode1 == beautymode && obj != null)
            {
                String s1 = ((aw) (obj)).a();
                String s2 = a(skutryiturl.skuGuid, null, s1);
                skutryiturl = StatusManager.j().d();
                if (skutryiturl == null)
                {
                    skutryiturl = new com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i();
                }
                obj = ((aw) (obj)).i();
                List list = PanelDataCenter.a().b(s2, s1);
                if (list.size() > 0)
                {
                    l = ((Integer)list.get(0)).intValue();
                }
                if (skutryiturl.a(beautymode) == null)
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
                                final n b;

                                public void run()
                                {
                                    b.i.c(a);
                                }

            
            {
                b = n.this;
                a = l;
                super();
            }
                            });
                            return;
                        }
                    } else
                    {
                        skutryiturl.a(beautymode, new r(s2, s1, null, ((List) (obj)), l));
                        StatusManager.j().a(skutryiturl);
                        return;
                    }
                }
            }
        }
    }

    public void a(aw aw1)
    {
        a(p, aw1.k(), aw1.a());
    }

    protected void a(aw aw1, az az1)
    {
        if (e != null)
        {
            e.a(az1);
            e.a();
            if (aw1 != null)
            {
                a(aw1, true);
                return;
            }
        }
    }

    public void a(aw aw1, boolean flag)
    {
        ((j)e).a(aw1, flag);
        a(false, ((com.cyberlink.youcammakeup.utility.ch) (null)));
    }

    protected void a(Long long1)
    {
        BeautyMode beautymode = StatusManager.j().s();
        h h1 = h.b();
        if (long1 != null)
        {
            com.cyberlink.youcammakeup.database.more.i.d d1 = h1.a(p, long1);
            b(long1);
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b b2 = (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b)c;
            b2.a(d, SkuTemplateUtils.a(d1.d(), p));
            b2.b(h1.s(p, d1.d()));
            b2.a(beautymode, long1);
            com.cyberlink.youcammakeup.clflurry.b.a(new af(d1.d(), YMKFeatures.a(beautymode)));
            return;
        } else
        {
            b(null);
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b b1 = (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b)c;
            b1.a(BitmapFactory.decodeResource(getResources(), 0x7f02088f));
            b1.b(getActivity().getString(0x7f0703cf));
            b1.a(beautymode, long1);
            com.cyberlink.youcammakeup.clflurry.b.a(new af(null, YMKFeatures.a(beautymode)));
            return;
        }
    }

    protected void b(a a1)
    {
        super.b(a1);
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
            final n b;

            public void run()
            {
                Object obj1 = null;
                b.a(a);
                BeautyMode beautymode = StatusManager.j().s();
                Object obj;
                Object obj2;
                Object obj3;
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
                    obj3 = new az(a, b.p);
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
                        obj2 = SkuTemplateUtils.d(s1);
                        if (obj2 != null)
                        {
                            obj1 = ((aw) (obj2)).a();
                        }
                        obj2 = obj;
                        obj = new Float[0];
                    }
                } else
                {
                    obj2 = b.t;
                    Object obj4;
                    if (obj2 != null)
                    {
                        obj1 = new Float[1];
                        obj1[0] = Float.valueOf(((v) (obj2)).b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a).intValue());
                    } else
                    {
                        obj1 = new Float[1];
                        obj1[0] = Float.valueOf(b.J());
                    }
                    if (obj2 == null)
                    {
                        if (PanelDataCenter.a().a(beautymode, 1) != null)
                        {
                            obj = PanelDataCenter.a().a(beautymode, 1);
                        } else
                        {
                            obj = PanelDataCenter.a().a(beautymode, 2);
                        }
                    } else
                    {
                        obj = ((v) (obj2)).c();
                    }
                    s1 = null;
                    obj4 = null;
                    obj3 = obj;
                    obj = obj1;
                    obj1 = obj3;
                    obj3 = obj4;
                }
                aw1 = PanelDataCenter.a().i(((String) (obj1)));
                obj2 = b.a(s1, ((v) (obj2)), ((String) (obj1)));
                b.a(a, false);
                b.a(aw1, ((az) (obj3)));
                if (obj2 != null && !((String) (obj2)).equals(StatusManager.j().e()))
                {
                    StatusManager.j().b(((String) (obj2)));
                    MotionControlHelper.e().t();
                    MotionControlHelper.e().a(true);
                    b.a(beautymode, ((String) (obj2)));
                }
                b.c.a(((String) (obj1)), ((Float []) (obj)));
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
                b = n.this;
                a = long1;
                super();
            }
        };
        a.post(long1);
    }

    protected void d(BeautyMode beautymode)
    {
        Object obj1;
        h h1;
        obj1 = null;
        s = new HashMap();
        p = SkuTemplateUtils.a(beautymode);
        if (p.length() == 0)
        {
            return;
        }
        h1 = h.b();
        r = h1.b(p);
        if (r.size() <= 0) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj2;
        obj2 = SkuTemplateUtils.a(getActivity());
        String s1;
        try
        {
            obj = new Random();
            obj = (Long)r.get(((Random) (obj)).nextInt(r.size() - 1));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = (Long)r.get(0);
        }
        if (obj2 == null) goto _L4; else goto _L3
_L3:
        s1 = ((com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl) (obj2)).type;
        if (p.equals(s1))
        {
            obj = h1.c(((com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl) (obj2)).skuGuid);
        }
_L8:
        n = true;
_L6:
        obj2 = StatusManager.j().d();
        if (!n || obj2 == null)
        {
            a(((Long) (obj)), false);
            return;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (DownloadUseUtils.a(getActivity()) != null)
        {
            obj = null;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        n = false;
        obj = a.findViewById(0x7f0c0678);
        obj2 = a.findViewById(0x7f0c0661);
        if (obj != null)
        {
            ((View) (obj)).setVisibility(8);
        }
        if (obj2 != null)
        {
            ((View) (obj2)).setVisibility(8);
        }
        obj = null;
        if (true) goto _L6; else goto _L5
_L5:
        beautymode = a(((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i) (obj2)), beautymode);
        if (beautymode == null)
        {
            a(((Long) (obj)), false);
            return;
        }
        beautymode = beautymode.c();
        beautymode = PanelDataCenter.a().i(beautymode);
        if (beautymode != null)
        {
            beautymode = beautymode.k();
        } else
        {
            beautymode = null;
        }
        obj = h1.b(p, beautymode);
        beautymode = obj1;
        if (obj != null)
        {
            beautymode = obj1;
            if (r.contains(Long.valueOf(((com.cyberlink.youcammakeup.database.more.i.d) (obj)).a())))
            {
                beautymode = Long.valueOf(((com.cyberlink.youcammakeup.database.more.i.d) (obj)).a());
            }
        }
        a(beautymode, false);
        return;
        if (true) goto _L8; else goto _L7
_L7:
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
                BeautyMode beautymode = StatusManager.j().s();
                if (v1 != null && v1.a() != null)
                {
                    String s1 = v1.c();
                    Object obj1 = PanelDataCenter.a().i(s1);
                    Long long1 = h.b().c(((aw) (obj1)).k());
                    if (!a(long1, o))
                    {
                        a(long1);
                        a(long1, true);
                        d d1 = e;
                        if (long1 != null)
                        {
                            obj1 = new az(o, p);
                        } else
                        {
                            obj1 = null;
                        }
                        d1.a(((az) (obj1)));
                        e.a();
                        a(beautymode);
                        b(long1);
                        if (long1 != null)
                        {
                            obj1 = s1;
                        } else
                        {
                            obj1 = null;
                        }
                        b(((String) (obj1)));
                    }
                    if (long1 != null)
                    {
                        obj1 = new az(o, p);
                    } else
                    {
                        obj1 = null;
                    }
                    if (long1 == null)
                    {
                        s1 = null;
                    }
                    a(((az) (obj1)), s1);
                    a(beautymode, v1.a());
                    StatusManager.j().b(v1.a());
                } else
                {
                    List list = PanelDataCenter.a().a(beautymode);
                    if (list != null && list.size() > 0)
                    {
                        StatusManager.j().b((String)list.get(0));
                    }
                    a(((az) (null)), ((String) (null)));
                }
                d(v1.a());
                return;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        a = layoutinflater.inflate(0x7f030175, viewgroup, false);
        d(StatusManager.j().s());
        return a;
    }
}
