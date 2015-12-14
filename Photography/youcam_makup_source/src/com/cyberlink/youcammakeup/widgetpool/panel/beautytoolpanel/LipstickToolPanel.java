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
import android.view.ViewPropertyAnimator;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.YMKApplyEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.l;
import com.cyberlink.youcammakeup.clflurry.n;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.utility.az;
import com.cyberlink.youcammakeup.utility.ch;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.common.a.d;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            n, k, l, m

public class LipstickToolPanel extends com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.n
{

    private View G;
    private View H;
    private View I;
    private LipStickColorMode J;
    private v K;
    private v L;
    private final android.view.View.OnClickListener M = new android.view.View.OnClickListener() {

        final LipstickToolPanel a;

        public void onClick(View view)
        {
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.LipstickToolPanel.a(a, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.LipStickColorMode.a);
        }

            
            {
                a = LipstickToolPanel.this;
                super();
            }
    };
    private final android.view.View.OnClickListener N = new android.view.View.OnClickListener() {

        final LipstickToolPanel a;

        public void onClick(View view)
        {
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.LipstickToolPanel.a(a, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.LipStickColorMode.b);
        }

            
            {
                a = LipstickToolPanel.this;
                super();
            }
    };

    public LipstickToolPanel()
    {
        G = null;
        H = null;
        I = null;
        J = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.LipStickColorMode.a;
        K = null;
        L = null;
    }

    private void W()
    {
        boolean flag1 = true;
        if (G != null && H != null)
        {
            View view = G;
            boolean flag;
            if (J == com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.LipStickColorMode.a)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.setSelected(flag);
            view = H;
            if (J == com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.LipStickColorMode.b)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            view.setSelected(flag);
        }
    }

    private void a(LipStickColorMode lipstickcolormode)
    {
        if (J != lipstickcolormode)
        {
            b(lipstickcolormode);
            W();
            if (e != null)
            {
                e.a();
            }
            BeautyMode beautymode = StatusManager.j().s();
            Float afloat[];
            Object obj;
            if (lipstickcolormode == com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.LipStickColorMode.a)
            {
                L = MotionControlHelper.e().M();
                obj = K;
            } else
            {
                K = MotionControlHelper.e().M();
                obj = L;
            }
            if (obj != null)
            {
                afloat = (new Float[] {
                    Float.valueOf(((v) (obj)).b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a).intValue())
                });
            } else
            {
                afloat = (new Float[] {
                    Float.valueOf(J())
                });
            }
            if (obj == null)
            {
                if (lipstickcolormode == com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.LipStickColorMode.b && PanelDataCenter.a().a(beautymode, 2) != null)
                {
                    lipstickcolormode = PanelDataCenter.a().a(beautymode, 2);
                } else
                {
                    lipstickcolormode = PanelDataCenter.a().a(beautymode, 1);
                }
            } else
            {
                lipstickcolormode = ((v) (obj)).c();
            }
            obj = PanelDataCenter.a().i(lipstickcolormode);
            if (obj != null)
            {
                if (c != null)
                {
                    c.a(lipstickcolormode, afloat);
                }
                a(((aw) (obj)), true);
                return;
            }
        }
    }

    static void a(LipstickToolPanel lipsticktoolpanel, LipStickColorMode lipstickcolormode)
    {
        lipsticktoolpanel.a(lipstickcolormode);
    }

    private void b(LipStickColorMode lipstickcolormode)
    {
        J = lipstickcolormode;
        if (J != LipStickColorMode.c && e != null && (e instanceof com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.l))
        {
            lipstickcolormode = (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.l)e;
            boolean flag;
            if (J == com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.LipStickColorMode.b)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            lipstickcolormode.c(flag);
        }
    }

    float J()
    {
        return 50F;
    }

    public void U()
    {
        G = a.findViewById(0x7f0c0689);
        H = a.findViewById(0x7f0c068a);
        I = a.findViewById(0x7f0c0683);
        if (G != null)
        {
            G.setOnClickListener(M);
        }
        if (H != null)
        {
            H.setOnClickListener(N);
        }
        W();
    }

    public void V()
    {
        if (I != null)
        {
            boolean flag;
            if (o == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                if (I.getVisibility() != 0)
                {
                    I.setVisibility(0);
                    I.setAlpha(0.0F);
                    I.animate().alpha(1.0F);
                    return;
                }
            } else
            {
                I.setVisibility(8);
                return;
            }
        }
    }

    protected void a()
    {
        c = new m();
        e = new com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.l();
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
        Object obj;
        Object obj1;
        String as[];
        String s;
        Object obj2;
        int j;
        if (a1.f() == null)
        {
            a1 = new i();
        } else
        {
            a1 = new i(a1.f().g());
        }
        obj = StatusManager.j().e();
        obj1 = StatusManager.j().g();
        s = StatusManager.j().h();
        j = (int)MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a);
        obj2 = PanelDataCenter.a().i(((String) (obj1)));
        if (obj2 == null)
        {
            String s1 = (new StringBuilder()).append("[LipstickToolPanel][configPostApply] paletteGuid:").append(String.valueOf(obj1)).append(" patternGuid:").append(String.valueOf(obj)).append(" styleGuid:").append(String.valueOf(s)).toString();
            Globals.d().e(s1);
        }
        obj2 = ((aw) (obj2)).i();
        obj = new r(((String) (obj)), ((String) (obj1)), s, ((List) (obj2)), j);
        com.cyberlink.youcammakeup.clflurry.b.a(new n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.v));
        a1.e(((r) (obj)));
        as = new String[((List) (obj2)).size()];
        for (int i1 = 0; i1 < ((List) (obj2)).size(); i1++)
        {
            as[i1] = ((at)((List) (obj2)).get(i1)).i();
        }

        as = new YMKApplyEvent(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.t);
        YMKApplyEvent.a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.t, ((r) (obj)), as);
        com.cyberlink.youcammakeup.clflurry.b.a(as.e());
        a1.a(false);
        StatusManager.j().a(a1);
    }

    public void a(BeautyMode beautymode, String s)
    {
        e(MotionControlHelper.e().w(s));
    }

    public void a(aw aw1)
    {
        a(p, aw1.k(), aw1.a());
    }

    protected void a(aw aw1, az az1)
    {
        if (aw1 != null && az1 == null && StatusManager.j().s() == BeautyMode.v)
        {
            LipStickColorMode lipstickcolormode;
            if (aw1.b() <= 1)
            {
                lipstickcolormode = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.LipStickColorMode.a;
            } else
            {
                lipstickcolormode = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.LipStickColorMode.b;
            }
            b(lipstickcolormode);
        } else
        {
            b(LipStickColorMode.c);
        }
        super.a(aw1, az1);
    }

    public void a(aw aw1, boolean flag)
    {
        ((com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.l)e).a(aw1, flag);
        a(false, ((ch) (null)));
    }

    public void a(boolean flag, ch ch)
    {
        super.a(flag, ch);
        V();
    }

    public void a(boolean flag, boolean flag1)
    {
        super.a(flag, flag1);
        V();
    }

    protected void b(a a1)
    {
        super.b(a1);
        com.cyberlink.youcammakeup.clflurry.b.a(com.cyberlink.youcammakeup.clflurry.BaseEvent.EventName.b);
    }

    public void b(aw aw1, az az1)
    {
        if (az1 == null)
        {
            if (aw1.b() <= 1)
            {
                aw1 = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.LipStickColorMode.a;
            } else
            {
                aw1 = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.LipStickColorMode.b;
            }
            b(((LipStickColorMode) (aw1)));
            W();
            return;
        } else
        {
            b(LipStickColorMode.c);
            return;
        }
    }

    protected String g()
    {
        Object obj = StatusManager.j().s();
        i j = StatusManager.j().d();
        if (j != null && j.h() != null)
        {
            return j.h().b();
        }
        obj = PanelDataCenter.a().a(((BeautyMode) (obj)));
        if (!n && ((List) (obj)).contains("patten_lipstick_02"))
        {
            return "patten_lipstick_02";
        } else
        {
            return "patten_lipstick_02";
        }
    }

    protected void o()
    {
        String s = null;
        long l1 = StatusManager.j().l();
        Object obj = StatusManager.j().g(l1);
        if (obj != null)
        {
            if ((obj = ((com.cyberlink.youcammakeup.kernelctrl.status.d) (obj)).e()) != null)
            {
                v v1 = ((a) (obj)).f();
                if (v1 != null && v1.a() != null)
                {
                    String s1 = v1.c();
                    Object obj2 = PanelDataCenter.a().i(s1);
                    Long long1 = h.b().c(((aw) (obj2)).k());
                    Object obj1;
                    if (long1 == null)
                    {
                        if (obj2 != null && ((aw) (obj2)).b() <= 1)
                        {
                            obj1 = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.LipStickColorMode.a;
                        } else
                        {
                            obj1 = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.LipStickColorMode.b;
                        }
                        if (e != null && (e instanceof com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.l) && obj1 != J)
                        {
                            b(((LipStickColorMode) (obj1)));
                            e.a(null);
                            e.a();
                        }
                        W();
                        a(((aw) (obj2)), true);
                    }
                    V();
                    if (!a(long1, o))
                    {
                        a(long1);
                        a(long1, true);
                        if (long1 != null)
                        {
                            b(LipStickColorMode.c);
                            obj2 = e;
                            if (long1 != null)
                            {
                                obj1 = new az(o, p);
                            } else
                            {
                                obj1 = null;
                            }
                            ((d) (obj2)).a(((az) (obj1)));
                            e.a();
                        }
                        a(StatusManager.j().s());
                        b(long1);
                    }
                    if (long1 != null)
                    {
                        obj1 = new az(o, p);
                    } else
                    {
                        obj1 = null;
                    }
                    if (long1 != null)
                    {
                        s = s1;
                    }
                    a(((az) (obj1)), s);
                    a(BeautyMode.v, v1.a());
                    StatusManager.j().b(v1.a());
                } else
                {
                    List list = PanelDataCenter.a().a(BeautyMode.v);
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
        a = layoutinflater.inflate(0x7f03017a, viewgroup, false);
        d(BeautyMode.v);
        U();
        return a;
    }

    public void onStart()
    {
        super.onStart();
        com.cyberlink.youcammakeup.clflurry.b.a(new l(n));
    }

    private class LipStickColorMode extends Enum
    {

        public static final LipStickColorMode a;
        public static final LipStickColorMode b;
        public static final LipStickColorMode c;
        private static final LipStickColorMode d[];

        public static LipStickColorMode valueOf(String s)
        {
            return (LipStickColorMode)Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/LipstickToolPanel$LipStickColorMode, s);
        }

        public static LipStickColorMode[] values()
        {
            return (LipStickColorMode[])d.clone();
        }

        static 
        {
            a = new LipStickColorMode("OneColor", 0);
            b = new LipStickColorMode("MultiColor", 1);
            c = new LipStickColorMode("SkuColor", 2);
            d = (new LipStickColorMode[] {
                a, b, c
            });
        }

        private LipStickColorMode(String s, int j)
        {
            super(s, j);
        }
    }

}
