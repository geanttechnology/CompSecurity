// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.b;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.clflurry.YMKApplyEvent;
import com.cyberlink.youcammakeup.clflurry.n;
import com.cyberlink.youcammakeup.database.g;
import com.cyberlink.youcammakeup.jniproxy.y;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierTaskInfo;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.c.b;
import com.cyberlink.youcammakeup.kernelctrl.c.d;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.f;
import com.cyberlink.youcammakeup.kernelctrl.j;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.m;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.c;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.i;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.IntroDialogUtils;
import com.cyberlink.youcammakeup.utility.e;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.dialogs.ah;
import com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar;
import com.cyberlink.youcammakeup.widgetpool.toolbar.TopToolBar;
import com.cyberlink.youcammakeup.widgetpool.toolbar.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.b:
//            b

public class a extends Fragment
    implements f, m, com.cyberlink.youcammakeup.widgetpool.panel.a
{

    private TopToolBar a;
    private View b;
    private Globals c;
    private com.cyberlink.youcammakeup.widgetpool.panel.b.b d;
    private MakeupMenuBottomToolbar e;
    private ImageButton f;
    private ImageViewer g;
    private boolean h;
    private boolean i;
    private View j;
    private boolean k;
    private int l;
    private boolean m;
    private boolean n;
    private boolean o;
    private android.view.View.OnTouchListener p;

    public a()
    {
        c = null;
        e = null;
        f = null;
        g = null;
        h = false;
        i = true;
        j = null;
        k = false;
        m = false;
        n = false;
        o = true;
        p = new android.view.View.OnTouchListener() {

            final a a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                view = a.a(a).t();
                if (view != null) goto _L2; else goto _L1
_L1:
                return false;
_L2:
                switch (motionevent.getActionMasked())
                {
                case 2: // '\002'
                case 4: // '\004'
                default:
                    return false;

                case 0: // '\0'
                    view.b(Boolean.valueOf(false));
                    // fall through

                case 5: // '\005'
                    if (!com.cyberlink.youcammakeup.widgetpool.panel.b.a.b(a))
                    {
                        a.a(a, motionevent.getPointerId(motionevent.getActionIndex()));
                        com.cyberlink.youcammakeup.widgetpool.panel.b.a.b(a, true);
                        view.K();
                        return false;
                    }
                    break;

                case 1: // '\001'
                case 3: // '\003'
                case 6: // '\006'
                    int i1 = motionevent.getPointerId(motionevent.getActionIndex());
                    if (com.cyberlink.youcammakeup.widgetpool.panel.b.a.b(a) && i1 == com.cyberlink.youcammakeup.widgetpool.panel.b.a.c(a))
                    {
                        com.cyberlink.youcammakeup.widgetpool.panel.b.a.b(a, false);
                        view.L();
                        return false;
                    }
                    break;
                }
                if (true) goto _L1; else goto _L3
_L3:
            }

            
            {
                a = a.this;
                super();
            }
        };
    }

    static int a(a a1, int i1)
    {
        a1.l = i1;
        return i1;
    }

    static Globals a(a a1)
    {
        return a1.c;
    }

    private void a(View view)
    {
        if (f != null)
        {
            h();
            f.setSelected(h);
            n = true;
            if (Globals.d().j().a(h, i))
            {
                k();
            }
            c.t().b(Boolean.valueOf(false));
        }
    }

    static void a(a a1, View view)
    {
        a1.a(view);
    }

    static void a(a a1, boolean flag)
    {
        a1.b(flag);
    }

    private void b(View view)
    {
        if (view.isPressed())
        {
            view.setPressed(false);
        }
    }

    private void b(boolean flag)
    {
        if (f == null || j == null)
        {
            return;
        }
        ImageButton imagebutton;
        if (flag)
        {
            j.setOnTouchListener(p);
        } else
        if (!k)
        {
            j.setOnTouchListener(null);
        }
        if (!k)
        {
            j.setClickable(flag);
        }
        if (!flag || k)
        {
            b(((View) (f)));
        }
        imagebutton = f;
        if (flag && !k)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        imagebutton.setClickable(flag);
    }

    static boolean b(a a1)
    {
        return a1.k;
    }

    static boolean b(a a1, boolean flag)
    {
        a1.k = flag;
        return flag;
    }

    static int c(a a1)
    {
        return a1.l;
    }

    private void c(boolean flag)
    {
        if (g == null)
        {
            return;
        } else
        {
            com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f f1 = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f();
            f1.a = true;
            f1.c = new c(com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskRole.d);
            f1.c.f = Boolean.valueOf(flag);
            g.b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c, f1);
            return;
        }
    }

    static ImageViewer d(a a1)
    {
        return a1.g;
    }

    static boolean e(a a1)
    {
        return a1.h;
    }

    private void f()
    {
label0:
        {
            c = (Globals)getActivity().getApplicationContext();
            Object obj = getFragmentManager();
            if (obj != null)
            {
                a = (TopToolBar)((FragmentManager) (obj)).findFragmentById(0x7f0c00be);
            }
            if (a != null)
            {
                a.a(this);
                obj = new l();
                obj.a = true;
                Integer integer = com.cyberlink.youcammakeup.utility.e.a(StatusManager.j().s());
                if (integer != null)
                {
                    obj.c = c.getString(integer.intValue());
                }
                a.a(((l) (obj)));
            }
            obj = Globals.d().t();
            if (obj != null)
            {
                ((EditViewActivity) (obj)).a(null);
            }
            obj = StatusManager.j().s();
            b b1;
            byte byte0;
            boolean flag;
            if (obj == BeautyMode.e)
            {
                byte0 = 4;
            } else
            {
                byte0 = 0;
            }
            if (obj != BeautyMode.e)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            i = flag;
            StatusManager.j().a(4, 4, 0, 4, 4, 4, 4, byte0);
            d = new com.cyberlink.youcammakeup.widgetpool.panel.b.b(this);
            f = (ImageButton)b.findViewById(0x7f0c0665);
            a("Apply", Boolean.valueOf(true));
            obj = ((com.cyberlink.youcammakeup.kernelctrl.c.a)c.i.b().get()).a();
            if (obj == null)
            {
                break label0;
            }
            obj = ((ArrayList) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                b1 = (b)((WeakReference)((Iterator) (obj)).next()).get();
            } while (b1 == null || !(b1 instanceof ImageViewer));
            g = (ImageViewer)b1;
        }
        h = false;
        k = false;
        j = b.findViewById(0x7f0c0666);
        MotionControlHelper.e().B();
        n = false;
        com.cyberlink.youcammakeup.kernelctrl.j.a().a(false);
    }

    private void g()
    {
        a("Apply", Boolean.valueOf(false));
        if (a != null)
        {
            a.a(null);
        }
        b = null;
        d = null;
        g = null;
        h = false;
        if (k)
        {
            EditViewActivity editviewactivity = c.t();
            if (editviewactivity != null)
            {
                editviewactivity.L();
            }
            k = false;
        }
        EditViewActivity editviewactivity1 = c.t();
        if (editviewactivity1 != null)
        {
            editviewactivity1.b(Boolean.valueOf(false));
            editviewactivity1.m(false);
        }
        c = null;
        n = false;
        e.b(false);
        if (m)
        {
            com.cyberlink.youcammakeup.kernelctrl.j.a().d();
        }
    }

    private void h()
    {
        if (h)
        {
            h = false;
            return;
        } else
        {
            h = true;
            return;
        }
    }

    private void i()
    {
        StatusManager.j().a(d);
        StatusManager.j().a(this);
        BeautifierManager.a().a(this);
        if (f != null)
        {
            f.setOnClickListener(new android.view.View.OnClickListener() {

                final a a;

                public void onClick(View view)
                {
                    a.a(a, view);
                }

            
            {
                a = a.this;
                super();
            }
            });
        }
        if (j != null)
        {
            j.setOnTouchListener(p);
        }
    }

    private void j()
    {
        StatusManager.j().b(d);
        StatusManager.j().b(this);
        BeautifierManager.a().b(this);
        if (f != null)
        {
            f.setOnClickListener(null);
        }
        if (j != null)
        {
            j.setOnTouchListener(null);
        }
    }

    private void k()
    {
        Globals.d().i().b(Globals.d().t());
    }

    private void l()
    {
        Globals.d().i().h(Globals.d().t());
    }

    private void m()
    {
        Object obj = new l();
        obj.b = true;
        obj.a = false;
        obj.c = Globals.d().getString(0x7f0703b5);
        a.a(((l) (obj)));
        obj = new com.cyberlink.youcammakeup.widgetpool.toolbar.e();
        obj.a = true;
        obj.b = true;
        obj.c = false;
        obj.d = true;
        e.a(((com.cyberlink.youcammakeup.widgetpool.toolbar.e) (obj)));
        int i1;
        int j1;
        if (g != null && g.m != null && g.m.i != null && g.m.i.size() > 1)
        {
            i1 = 0;
        } else
        {
            i1 = 4;
        }
        if (ah.b())
        {
            j1 = 0;
        } else
        {
            j1 = 8;
        }
        StatusManager.j().a(0, i1, 8, 0, 0, 4, j1, 8);
    }

    private void n()
    {
        if (g == null)
        {
            return;
        } else
        {
            (new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f()).a = true;
            g.b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.a, new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f());
            g.b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.b, new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f());
            return;
        }
    }

    public void a()
    {
        if (e != null)
        {
            e.a(Boolean.valueOf(false));
        }
        if (a != null)
        {
            a.a(Boolean.valueOf(false));
        }
    }

    public void a(Fragment fragment)
    {
        e = (MakeupMenuBottomToolbar)fragment;
    }

    public void a(BeautifierTaskInfo beautifiertaskinfo)
    {
        c(true);
        n();
        l();
        if (m)
        {
            if (com.cyberlink.youcammakeup.kernelctrl.j.a().j())
            {
                Globals.d().t().a(false, null);
            }
            m();
        } else
        if (beautifiertaskinfo.c())
        {
            beautifiertaskinfo = Globals.d().t();
            if (beautifiertaskinfo != null)
            {
                boolean flag = beautifiertaskinfo.B();
                if (o)
                {
                    beautifiertaskinfo.e(flag, flag);
                    return;
                } else
                {
                    beautifiertaskinfo.d(flag, flag);
                    o = true;
                    return;
                }
            }
        }
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName buffername, Long long1)
    {
        if (buffername == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c && n)
        {
            n = false;
        }
    }

    public void a(Long long1, boolean flag)
    {
    }

    public void a(String s, Boolean boolean1)
    {
        if (a != null)
        {
            a.a(s, boolean1);
        }
    }

    public void a(boolean flag)
    {
        o = flag;
    }

    public void b()
    {
        k();
        long l1 = StatusManager.j().l();
        if (!com.cyberlink.youcammakeup.database.g.a(l1) && !com.cyberlink.youcammakeup.kernelctrl.viewengine.i.a(l1) || g == null)
        {
            e();
            return;
        }
        c.t().V();
        Object obj = (ImageViewer)getActivity().findViewById(0x7f0c0720);
        if (obj != null)
        {
            ((ImageViewer) (obj)).q();
        }
        obj = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.e.a().a(Long.valueOf(l1), Boolean.valueOf(true));
        ViewEngine.a().a(l1, 1.0D, ((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.DevelopSetting) (obj)), null, new com.cyberlink.youcammakeup.kernelctrl.viewengine.a(l1) {

            final long a;
            final a b;

            public void a(com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskCancelType taskcanceltype, String s, Object obj1)
            {
                b.e();
            }

            public void a(com.cyberlink.youcammakeup.kernelctrl.viewengine.q q1, Object obj1)
            {
                Object obj2;
                Object obj3;
                obj1 = StatusManager.j().f(a);
                obj2 = MotionControlHelper.e().M();
                List list = com.cyberlink.youcammakeup.kernelctrl.j.a().g();
                if (obj1 == null)
                {
                    obj1 = new com.cyberlink.youcammakeup.kernelctrl.status.a(a, com.cyberlink.youcammakeup.widgetpool.panel.b.a.d(b).m.b, com.cyberlink.youcammakeup.widgetpool.panel.b.a.d(b).m.c, com.cyberlink.youcammakeup.widgetpool.panel.b.a.d(b).m.d, com.cyberlink.youcammakeup.kernelctrl.j.a(com.cyberlink.youcammakeup.widgetpool.panel.b.a.d(b).m.i), list, ((ar)list.get(com.cyberlink.youcammakeup.widgetpool.panel.b.a.d(b).m.j)).c.b(), ((ar)list.get(com.cyberlink.youcammakeup.widgetpool.panel.b.a.d(b).m.j)).c.c(), com.cyberlink.youcammakeup.widgetpool.panel.b.a.d(b).m.j, null, ((v) (obj2)), "");
                }
                obj3 = StatusManager.j().s();
                if (((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).f() == null)
                {
                    obj2 = new com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i();
                } else
                {
                    obj2 = new com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i(((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).f().g());
                }
                if (obj2 == null) goto _L2; else goto _L1
_L1:
                if (obj3 != BeautyMode.q) goto _L4; else goto _L3
_L3:
                com.cyberlink.youcammakeup.clflurry.b.a(new n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.s));
                ((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i) (obj2)).a(Boolean.valueOf(com.cyberlink.youcammakeup.widgetpool.panel.b.a.e(b)));
                obj3 = new YMKApplyEvent(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.s);
                ((YMKApplyEvent) (obj3)).a(com.cyberlink.youcammakeup.widgetpool.panel.b.a.e(b));
                com.cyberlink.youcammakeup.clflurry.b.a(((YMKApplyEvent) (obj3)).e());
_L6:
                ((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i) (obj2)).a(false);
                StatusManager.j().a(((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i) (obj2)));
_L2:
                obj3 = MotionControlHelper.e().M();
                ((v) (obj3)).a(((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i) (obj2)));
                obj1 = new com.cyberlink.youcammakeup.kernelctrl.status.a(a, q1.a().b(), q1.a().c(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).d, com.cyberlink.youcammakeup.kernelctrl.j.a(com.cyberlink.youcammakeup.widgetpool.panel.b.a.d(b).m.i), list, ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).a(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).b(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).e, ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).c(), ((v) (obj3)), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).g());
                StatusManager.j().a(((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)), q1.a(), new com.cyberlink.youcammakeup.d(this) {

                    final _cls3 b;

                    public void a()
                    {
                        b.b.e();
                    }

                    public void b()
                    {
                        b.b.e();
                    }

                    public void c()
                    {
                        b.b.e();
                    }

            
            {
                b = _pcls3;
                super();
            }
                });
                return;
_L4:
                if (obj3 == BeautyMode.e)
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.h));
                    ((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i) (obj2)).b(Boolean.valueOf(com.cyberlink.youcammakeup.widgetpool.panel.b.a.e(b)));
                    YMKApplyEvent ymkapplyevent = new YMKApplyEvent(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.b);
                    ymkapplyevent.a(com.cyberlink.youcammakeup.widgetpool.panel.b.a.e(b));
                    com.cyberlink.youcammakeup.clflurry.b.a(ymkapplyevent.e());
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            public void a(String s, Object obj1)
            {
                b.e();
            }

            
            {
                b = a.this;
                a = l1;
                super();
            }
        });
    }

    public void c()
    {
        k();
        com.cyberlink.youcammakeup.kernelctrl.j.a().h();
        long l1 = StatusManager.j().l();
        Object obj = StatusManager.j().c(Long.valueOf(l1).longValue());
        if (obj != null && ((com.cyberlink.youcammakeup.kernelctrl.status.d) (obj)).e() != null)
        {
            if (((com.cyberlink.youcammakeup.kernelctrl.status.d) (obj)).e().f() != null && ((com.cyberlink.youcammakeup.kernelctrl.status.d) (obj)).e().f().f() != null)
            {
                BeautifierEditCenter.a().a(((com.cyberlink.youcammakeup.kernelctrl.status.d) (obj)).e().f().f());
            } else
            {
                BeautifierEditCenter.a().a(null);
            }
            BeautifierEditCenter.a().a(((ar)g.m.i.get(g.m.j)).b, ((ar)com.cyberlink.youcammakeup.kernelctrl.j.a().g().get(g.m.j)).c, false, new BeautifierTaskInfo(false));
        }
        m = true;
        BeautifierEditCenter.a().a(new BeautifierTaskInfo(true));
        c.t().V();
        obj = (ImageViewer)getActivity().findViewById(0x7f0c0720);
        if (obj != null)
        {
            ((ImageViewer) (obj)).q();
        }
    }

    public Long d()
    {
        return null;
    }

    public void e()
    {
        com.cyberlink.youcammakeup.kernelctrl.j.a().h();
        StatusManager.j().y();
        MotionControlHelper.e().c(Boolean.valueOf(true));
        l();
        m();
    }

    public void onActivityCreated(Bundle bundle)
    {
        f();
        i();
        super.onActivityCreated(bundle);
        a();
        if (!IntroDialogUtils.b(getFragmentManager(), null, null))
        {
            bundle = c.t();
            if (bundle != null)
            {
                bundle.a(false, null);
                a(false);
            }
        }
        if (f != null)
        {
            h();
            f.setSelected(h);
            n = true;
            if (Globals.d().j().a(h, i))
            {
                k();
            }
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        c = Globals.d();
        b = layoutinflater.inflate(0x7f030169, viewgroup, false);
        return b;
    }

    public void onDestroyView()
    {
        j();
        g();
        super.onDestroyView();
    }

    public void onDetach()
    {
        super.onDetach();
        a();
        e = null;
    }
}
