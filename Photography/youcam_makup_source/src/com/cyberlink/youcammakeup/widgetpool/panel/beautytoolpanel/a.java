// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.animation.Animator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.c;
import com.cyberlink.youcammakeup.clflurry.YMKFeatures;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.q;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierTaskInfo;
import com.cyberlink.youcammakeup.kernelctrl.VenusHelper;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.l;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.n;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.p;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.t;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.am;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.az;
import com.cyberlink.youcammakeup.utility.ch;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            b, k, BeautyToolPanel

public class a extends com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b
    implements k
{

    public static String a = "AccessoryToolPanelMenu";
    private static float r = 40F;
    private int s;

    public a()
    {
        s = -1;
    }

    private void a(BeautyMode beautymode)
    {
        Object obj = null;
        class _cls3
        {

            static final int a[];

            static 
            {
                a = new int[BeautyMode.values().length];
                try
                {
                    a[BeautyMode.z.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[BeautyMode.A.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[BeautyMode.B.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[BeautyMode.C.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls3.a[beautymode.ordinal()];
        JVM INSTR tableswitch 1 4: default 40
    //                   1 82
    //                   2 88
    //                   3 94
    //                   4 100;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        beautymode = obj;
_L7:
        if (beautymode != null)
        {
            StatusManager.j().b(beautymode);
            beautymode = new BeautifierTaskInfo(false);
            beautymode.a(a, com.cyberlink.youcammakeup.kernelctrl.BeautifierTaskInfo.ResultBufferType.b);
            MotionControlHelper.e().a(beautymode, true);
        }
        return;
_L2:
        beautymode = "default_original_eye_wear";
        continue; /* Loop/switch isn't completed */
_L3:
        beautymode = "default_original_hair_band";
        continue; /* Loop/switch isn't completed */
_L4:
        beautymode = "default_original_necklace";
        continue; /* Loop/switch isn't completed */
_L5:
        beautymode = "default_original_earrings";
        if (true) goto _L7; else goto _L6
_L6:
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
        Globals.d().i().b(Globals.d().t());
    }

    protected void a()
    {
        k = Globals.d().t();
        b = (ImageView)g.findViewById(0x7f0c064b);
        c = (ImageView)g.findViewById(0x7f0c064c);
        d = (TextView)g.findViewById(0x7f0c064e);
        e = g.findViewById(0x7f0c064d);
        h = g.findViewById(0x7f0c064a);
        if (h != null)
        {
            h.setOnClickListener(new android.view.View.OnClickListener() {

                final a a;

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
                a = a.this;
                super();
            }
            });
            h.setClickable(false);
        }
        e.setVisibility(4);
        o = false;
        j();
        Globals.d().i().b(true);
        a_(false);
        i i1 = StatusManager.j().d();
        BeautyMode beautymode = StatusManager.j().s();
        float f1 = r;
        Object obj = MotionControlHelper.e();
        Object obj2;
        if (beautymode == BeautyMode.z)
        {
            ((MotionControlHelper) (obj)).ab();
            ((MotionControlHelper) (obj)).aa();
        } else
        if (beautymode == BeautyMode.A)
        {
            ((MotionControlHelper) (obj)).ae();
            ((MotionControlHelper) (obj)).ad();
        } else
        if (beautymode == BeautyMode.B)
        {
            ((MotionControlHelper) (obj)).aj();
            ((MotionControlHelper) (obj)).ah();
        } else
        if (beautymode == BeautyMode.C)
        {
            ((MotionControlHelper) (obj)).am();
            ((MotionControlHelper) (obj)).al();
            ((MotionControlHelper) (obj)).au();
        }
        ((MotionControlHelper) (obj)).g(false);
        q = true;
        MotionControlHelper.e().aA();
        MotionControlHelper.e().m();
        if (i1 != null)
        {
            Object obj1;
            Object obj3;
            if (beautymode == BeautyMode.z && i1.y() != null)
            {
                obj3 = i1.y().a();
                obj1 = i1.y().b();
                boolean flag = i1.y().g();
                q = true;
                MotionControlHelper.e().d(((String) (obj3)), flag);
                MotionControlHelper.e().g(true);
            } else
            {
                obj1 = null;
                obj3 = null;
            }
            obj2 = obj1;
            obj = obj3;
            if (beautymode == BeautyMode.A)
            {
                obj2 = obj1;
                obj = obj3;
                if (i1.z() != null)
                {
                    obj = i1.z().a();
                    obj2 = i1.z().b();
                    boolean flag1 = i1.z().g();
                    q = true;
                    MotionControlHelper.e().e(((String) (obj)), flag1);
                    MotionControlHelper.e().g(true);
                }
            }
            obj3 = obj2;
            obj1 = obj;
            if (beautymode == BeautyMode.B)
            {
                obj3 = obj2;
                obj1 = obj;
                if (i1.A() != null)
                {
                    obj1 = i1.A().a();
                    obj3 = i1.A().b();
                    boolean flag2 = i1.A().g();
                    q = true;
                    MotionControlHelper.e().h(flag2);
                    MotionControlHelper.e().g(true);
                }
            }
            obj = obj3;
            obj2 = obj1;
            if (beautymode == BeautyMode.C)
            {
                obj = obj3;
                obj2 = obj1;
                if (i1.B() != null)
                {
                    obj2 = i1.B().a();
                    obj = i1.B().b();
                    boolean flag3 = i1.B().h();
                    boolean flag4 = i1.B().i();
                    boolean flag5 = i1.B().j();
                    boolean flag6 = i1.B().k();
                    q = true;
                    obj1 = MotionControlHelper.z(((String) (obj2)));
                    MotionControlHelper.e().f(((String) (obj1)), flag3);
                    MotionControlHelper.e().g(((String) (obj1)), flag4);
                    MotionControlHelper.e().h(((String) (obj1)), flag5);
                    MotionControlHelper.e().i(((String) (obj1)), flag6);
                    MotionControlHelper.e().g(true);
                }
            }
            obj1 = obj2;
            obj2 = obj;
            obj = obj1;
        } else
        {
            obj2 = null;
            obj = null;
        }
        obj1 = obj;
        if (obj == null)
        {
            obj1 = StatusManager.j().e();
        }
        if (obj2 == null)
        {
            if (m != null && obj1 != null)
            {
                obj = PanelDataCenter.a().b(((String) (obj1)));
                if (((am) (obj)).a() > 0)
                {
                    m.a(((am) (obj)).b(0), true);
                    MotionControlHelper.e().a(((String) (obj1)), ((am) (obj)).b(0));
                }
            }
        } else
        if (m != null && obj1 != null)
        {
            m.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)), true);
            MotionControlHelper.e().a(((String) (obj1)), ((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)));
        }
        obj = m.d();
        obj2 = m.D();
        obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(((String) (obj2)), ((Long) (obj)));
        if (obj == null)
        {
            m.f(null);
        } else
        {
            m.a(((d) (obj)).d(), ((String) (obj1)));
        }
        if (k != null)
        {
            k.a(this);
            if (obj1 == null)
            {
                k.a(Boolean.valueOf(false), Boolean.valueOf(false));
                a(false);
            }
        }
        p = f1;
        o = false;
        if (m != null)
        {
            m.a("Apply", Boolean.valueOf(true));
            m.h(beautymode);
        }
        if (beautymode != BeautyMode.z) goto _L2; else goto _L1
_L1:
        MotionControlHelper.e().j(false);
        AccessoryDrawingCtrl.b(beautymode).l();
        AccessoryDrawingCtrl.b(beautymode).a(false);
        MotionControlHelper.e().d(true);
        if (k != null)
        {
            k.r(true);
        }
_L4:
        return;
_L2:
        if (beautymode != BeautyMode.A)
        {
            break; /* Loop/switch isn't completed */
        }
        MotionControlHelper.e().j(false);
        AccessoryDrawingCtrl.b(beautymode).l();
        AccessoryDrawingCtrl.b(beautymode).a(false);
        MotionControlHelper.e().e(true);
        if (k != null)
        {
            k.r(true);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (beautymode != BeautyMode.B)
        {
            continue; /* Loop/switch isn't completed */
        }
        MotionControlHelper.e().j(false);
        AccessoryDrawingCtrl.b(beautymode).l();
        AccessoryDrawingCtrl.b(beautymode).a(false);
        MotionControlHelper.e().f(true);
        if (k != null)
        {
            k.r(true);
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (beautymode != BeautyMode.C) goto _L4; else goto _L5
_L5:
        MotionControlHelper.e().j(false);
        for (obj = AccessoryDrawingCtrl.a(beautymode).iterator(); ((Iterator) (obj)).hasNext(); AccessoryDrawingCtrl.a(((com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType) (obj1))).a(false))
        {
            obj1 = (com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType)((Iterator) (obj)).next();
            AccessoryDrawingCtrl.a(((com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType) (obj1))).l();
        }

        MotionControlHelper.e().i(true);
        if (k != null)
        {
            k.r(true);
            return;
        }
        if (true) goto _L4; else goto _L6
_L6:
    }

    public void a(at at1)
    {
        MotionControlHelper.e().d(true);
        MotionControlHelper.e().e(true);
        MotionControlHelper.e().f(true);
        MotionControlHelper.e().i(true);
        MotionControlHelper.e().A();
    }

    public void a(az az)
    {
        f = az;
    }

    public void a(String s1)
    {
    }

    public void a(String s1, String s2)
    {
        if (m == null)
        {
            return;
        }
        int i1;
        if (s1 == null || s1 != null && !s1.equals(s2))
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            i1 = s;
            int j1 = PanelDataCenter.a().b(s2).a();
            if (i1 < 2 || j1 < 2)
            {
                m.T();
                s = j1;
            }
        }
        m.a(false, false, s2, s1);
    }

    public void a(String s1, boolean flag)
    {
        com.cyberlink.youcammakeup.jniproxy.bi bi;
        MotionControlHelper motioncontrolhelper;
        Object obj1;
        Object obj2;
        BeautyMode beautymode;
        obj1 = null;
        obj2 = null;
        motioncontrolhelper = null;
        bi = null;
        beautymode = StatusManager.j().s();
        if (beautymode != BeautyMode.z) goto _L2; else goto _L1
_L1:
        MotionControlHelper.e().d(true);
        motioncontrolhelper = MotionControlHelper.e();
        if (VenusHelper.a().m() != null)
        {
            bi = AccessoryDrawingCtrl.b(beautymode).f();
        }
        motioncontrolhelper.b(bi);
        AccessoryDrawingCtrl.b(beautymode).l();
        if (s1 == "default_original_eye_wear")
        {
            AccessoryDrawingCtrl.n();
        }
_L4:
        return;
_L2:
        if (beautymode != BeautyMode.A)
        {
            break; /* Loop/switch isn't completed */
        }
        MotionControlHelper.e().e(true);
        motioncontrolhelper = MotionControlHelper.e();
        com.cyberlink.youcammakeup.jniproxy.bi bi1;
        if (VenusHelper.a().q() == null)
        {
            bi1 = obj1;
        } else
        {
            bi1 = AccessoryDrawingCtrl.b(beautymode).f();
        }
        motioncontrolhelper.c(bi1);
        AccessoryDrawingCtrl.b(beautymode).l();
        if (s1 == "default_original_hair_band")
        {
            AccessoryDrawingCtrl.n();
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (beautymode != BeautyMode.B)
        {
            continue; /* Loop/switch isn't completed */
        }
        MotionControlHelper.e().f(true);
        motioncontrolhelper = MotionControlHelper.e();
        com.cyberlink.youcammakeup.jniproxy.bi bi2;
        if (VenusHelper.a().u() == null)
        {
            bi2 = obj2;
        } else
        {
            bi2 = AccessoryDrawingCtrl.b(beautymode).f();
        }
        motioncontrolhelper.d(bi2);
        AccessoryDrawingCtrl.b(beautymode).l();
        if (s1 != "default_original_necklace") goto _L4; else goto _L5
_L5:
        AccessoryDrawingCtrl.n();
        return;
        if (beautymode != BeautyMode.C) goto _L4; else goto _L6
_L6:
        Object obj = MotionControlHelper.z(s1);
        MotionControlHelper.e().h(((String) (obj)), true);
        MotionControlHelper.e().i(((String) (obj)), true);
        MotionControlHelper.e().i(true);
        MotionControlHelper motioncontrolhelper1 = MotionControlHelper.e();
        if (VenusHelper.a().x() == null)
        {
            obj = null;
        } else
        {
            obj = AccessoryDrawingCtrl.a(com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType.d).f();
        }
        motioncontrolhelper1.e(((com.cyberlink.youcammakeup.jniproxy.bi) (obj)));
        motioncontrolhelper1 = MotionControlHelper.e();
        if (VenusHelper.a().y() == null)
        {
            obj = motioncontrolhelper;
        } else
        {
            obj = AccessoryDrawingCtrl.a(com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType.e).f();
        }
        motioncontrolhelper1.f(((com.cyberlink.youcammakeup.jniproxy.bi) (obj)));
        AccessoryDrawingCtrl.a(com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType.d).l();
        AccessoryDrawingCtrl.a(com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType.e).l();
        if (s1 == "default_original_earrings")
        {
            AccessoryDrawingCtrl.n();
            return;
        } else
        {
            AccessoryDrawingCtrl.o();
            return;
        }
    }

    public transient void a(String s1, Float afloat[])
    {
    }

    public void a(boolean flag)
    {
        if (m != null)
        {
            m.h(flag);
        }
    }

    protected boolean a(BeautyMode beautymode, i i1)
    {
        Object obj;
        int j1;
        int k1;
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
        if (j1 < i1.size() && ((at)i1.get(j1)).equals(beautymode.get(j1))) goto _L2; else goto _L1
_L1:
        if (k1 == i1.size())
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
_L5:
        if (j1 != 0)
        {
            return false;
        }
        do
        {
            return true;
        } while (obj == null || ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)).f() == null || ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)).f().g() == null || ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)).f().g().a(beautymode) == null);
        obj = ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)).f().g();
        i1 = i1.a(beautymode);
        beautymode = ((i) (obj)).a(beautymode);
        i1 = i1.f();
        beautymode = beautymode.f();
        if (i1 == null || beautymode == null || i1.size() != beautymode.size())
        {
            break MISSING_BLOCK_LABEL_218;
        }
        j1 = 0;
        k1 = 0;
          goto _L3
_L2:
        k1++;
        j1++;
          goto _L3
        j1 = 0;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void a_(boolean flag)
    {
        j = flag;
        e(flag);
    }

    protected void b()
    {
    }

    protected void c()
    {
        if (k != null) goto _L2; else goto _L1
_L1:
        BeautyMode beautymode;
        return;
_L2:
        if (!BeautyMode.d(beautymode = StatusManager.j().s()) || StatusManager.j().e() == null) goto _L1; else goto _L3
_L3:
        MotionControlHelper motioncontrolhelper;
        k.j(true);
        motioncontrolhelper = MotionControlHelper.e();
        _cls3.a[beautymode.ordinal()];
        JVM INSTR tableswitch 1 4: default 80
    //                   1 180
    //                   2 193
    //                   3 206
    //                   4 219;
           goto _L4 _L5 _L6 _L7 _L8
_L4:
        break; /* Loop/switch isn't completed */
_L8:
        break MISSING_BLOCK_LABEL_219;
_L9:
        k.a(new c() {

            final a a;

            public void a()
            {
                a.k.b(this);
                a.i();
            }

            
            {
                a = a.this;
                super();
            }
        });
        BeautifierTaskInfo beautifiertaskinfo = new BeautifierTaskInfo(false);
        beautifiertaskinfo.a(a, com.cyberlink.youcammakeup.kernelctrl.BeautifierTaskInfo.ResultBufferType.b);
        if (!MotionControlHelper.e().a(beautifiertaskinfo, false))
        {
            a(beautymode);
        }
        switch (_cls3.a[beautymode.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            motioncontrolhelper.m(true);
            motioncontrolhelper.j(false);
            return;

        case 2: // '\002'
            motioncontrolhelper.n(true);
            motioncontrolhelper.j(false);
            return;

        case 3: // '\003'
            motioncontrolhelper.o(true);
            motioncontrolhelper.j(false);
            return;

        case 4: // '\004'
            motioncontrolhelper.p(true);
            break;
        }
        break MISSING_BLOCK_LABEL_259;
_L5:
        motioncontrolhelper.m(false);
        motioncontrolhelper.j(true);
          goto _L9
_L6:
        motioncontrolhelper.n(false);
        motioncontrolhelper.j(true);
          goto _L9
_L7:
        motioncontrolhelper.o(false);
        motioncontrolhelper.j(true);
          goto _L9
        motioncontrolhelper.p(false);
        motioncontrolhelper.j(true);
          goto _L9
        motioncontrolhelper.j(false);
        return;
    }

    protected void d()
    {
        if (k != null)
        {
            Object obj = StatusManager.j().s();
            long l1 = StatusManager.j().l();
            MotionControlHelper.e().t();
            Object obj1 = StatusManager.j().g(l1);
            if (obj1 != null)
            {
                obj1 = ((com.cyberlink.youcammakeup.kernelctrl.status.d) (obj1)).e();
                if (obj1 != null)
                {
                    obj1 = ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).f();
                    if (obj1 != null && ((v) (obj1)).a() != null)
                    {
                        m.a(((v) (obj1)).b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a).intValue());
                        obj = new ArrayList();
                        ((List) (obj)).add(((v) (obj1)).b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a));
                        MotionControlHelper.e().c(((List) (obj)));
                        obj = ((v) (obj1)).a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a);
                    } else
                    {
                        m.a(0.0F);
                        ArrayList arraylist = new ArrayList();
                        arraylist.add(Integer.valueOf(0));
                        MotionControlHelper.e().c(arraylist);
                        obj = PanelDataCenter.a().c(((BeautyMode) (obj)));
                    }
                    if (obj != null)
                    {
                        Globals.d().j().a(((at) (obj)));
                        n = ((at) (obj));
                        m.a(((at) (obj)), true);
                        m.a(((at) (obj)), ((v) (obj1)).a());
                        return;
                    }
                }
            }
        }
    }

    public at e()
    {
        return null;
    }

    public void f()
    {
        g();
    }

    protected void g()
    {
        Object obj;
        if (k != null)
        {
            k.b(this);
        }
        a_(false);
        o = false;
        p = -1F;
        obj = StatusManager.j().s();
        if (obj != BeautyMode.z) goto _L2; else goto _L1
_L1:
        if (k != null)
        {
            k.r(false);
            k.a(null);
        }
        AccessoryDrawingCtrl.b(((BeautyMode) (obj))).l();
        MotionControlHelper.e().d(true);
_L4:
        MotionControlHelper.e().aB();
        k = null;
        return;
_L2:
        if (obj == BeautyMode.A)
        {
            if (k != null)
            {
                k.r(false);
                k.a(null);
            }
            AccessoryDrawingCtrl.b(((BeautyMode) (obj))).l();
            MotionControlHelper.e().e(true);
        } else
        if (obj == BeautyMode.B)
        {
            if (k != null)
            {
                k.r(false);
                k.a(null);
            }
            AccessoryDrawingCtrl.b(((BeautyMode) (obj))).l();
            MotionControlHelper.e().f(true);
        } else
        if (obj == BeautyMode.C)
        {
            if (k != null)
            {
                k.r(false);
                k.a(null);
            }
            for (obj = AccessoryDrawingCtrl.a(((BeautyMode) (obj))).iterator(); ((Iterator) (obj)).hasNext(); AccessoryDrawingCtrl.a((com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType)((Iterator) (obj)).next()).l()) { }
            MotionControlHelper.e().i(true);
        }
        if (true) goto _L4; else goto _L3
_L3:
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
            MotionControlHelper.e().A();
            q = false;
            flag = true;
        }
        return flag;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        g = layoutinflater.inflate(0x7f030164, viewgroup, false);
        return g;
    }

    public void onDestroyView()
    {
        g();
        super.onDestroyView();
    }

}
