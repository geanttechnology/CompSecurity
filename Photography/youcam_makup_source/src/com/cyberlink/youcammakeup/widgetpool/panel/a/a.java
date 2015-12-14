// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.a;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
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
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
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
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.IntroDialogUtils;
import com.cyberlink.youcammakeup.utility.e;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.common.SliderValueText;
import com.cyberlink.youcammakeup.widgetpool.dialogs.ah;
import com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar;
import com.cyberlink.youcammakeup.widgetpool.toolbar.TopToolBar;
import com.cyberlink.youcammakeup.widgetpool.toolbar.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.a:
//            b

public class a extends Fragment
    implements f, m, com.cyberlink.youcammakeup.widgetpool.panel.a
{

    protected TopToolBar a;
    protected View b;
    protected ImageViewer c;
    private Globals d;
    private com.cyberlink.youcammakeup.widgetpool.panel.a.b e;
    private MakeupMenuBottomToolbar f;
    private SeekBar g;
    private SliderValueText h;
    private View i;
    private boolean j;
    private boolean k;
    private final Integer l = Integer.valueOf(50);
    private Boolean m;
    private int n;
    private boolean o;
    private int p;
    private boolean q;
    private final android.content.DialogInterface.OnDismissListener r = new android.content.DialogInterface.OnDismissListener() {

        final a a;

        public void onDismiss(DialogInterface dialoginterface)
        {
            a.a(a);
        }

            
            {
                a = a.this;
                super();
            }
    };
    private final android.view.View.OnTouchListener s = new android.view.View.OnTouchListener() {

        final a a;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            view = com.cyberlink.youcammakeup.widgetpool.panel.a.a.c(a).t();
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
                if (!com.cyberlink.youcammakeup.widgetpool.panel.a.a.f(a).booleanValue())
                {
                    a.a(a, motionevent.getPointerId(motionevent.getActionIndex()));
                    a.a(a, Boolean.valueOf(true));
                    view.K();
                    return false;
                }
                break;

            case 1: // '\001'
            case 3: // '\003'
            case 6: // '\006'
                int i1 = motionevent.getPointerId(motionevent.getActionIndex());
                if (com.cyberlink.youcammakeup.widgetpool.panel.a.a.f(a).booleanValue() && i1 == com.cyberlink.youcammakeup.widgetpool.panel.a.a.g(a))
                {
                    a.a(a, Boolean.valueOf(false));
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

    public a()
    {
        d = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = true;
        k = true;
        m = Boolean.valueOf(false);
        o = false;
        p = 0;
        q = true;
    }

    static int a(a a1, int i1)
    {
        a1.n = i1;
        return i1;
    }

    static Boolean a(a a1, Boolean boolean1)
    {
        a1.m = boolean1;
        return boolean1;
    }

    private void a(View view)
    {
        if (view.isPressed())
        {
            view.setPressed(false);
        }
    }

    static void a(a a1)
    {
        a1.f();
    }

    static void a(a a1, boolean flag)
    {
        a1.b(flag);
    }

    static void b(a a1)
    {
        a1.m();
    }

    private void b(boolean flag)
    {
        if (g == null || i == null)
        {
            return;
        }
        if (flag)
        {
            i.setOnTouchListener(s);
        } else
        if (!m.booleanValue())
        {
            i.setOnTouchListener(null);
        }
        if (!m.booleanValue())
        {
            i.setClickable(flag);
        }
        if (flag && !m.booleanValue())
        {
            g.setOnTouchListener(null);
            return;
        } else
        {
            a(g);
            k = true;
            g.setOnTouchListener(new android.view.View.OnTouchListener() {

                final a a;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    return true;
                }

            
            {
                a = a.this;
                super();
            }
            });
            return;
        }
    }

    static boolean b(a a1, boolean flag)
    {
        a1.k = flag;
        return flag;
    }

    static Globals c(a a1)
    {
        return a1.d;
    }

    private void c(boolean flag)
    {
        if (c == null)
        {
            return;
        } else
        {
            com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f f1 = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f();
            f1.a = true;
            f1.c = new c(com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskRole.d);
            f1.c.f = Boolean.valueOf(flag);
            c.b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c, f1);
            return;
        }
    }

    static boolean c(a a1, boolean flag)
    {
        a1.j = flag;
        return flag;
    }

    static boolean d(a a1)
    {
        return a1.j;
    }

    static SliderValueText e(a a1)
    {
        return a1.h;
    }

    static Boolean f(a a1)
    {
        return a1.m;
    }

    private void f()
    {
        if (g != null && Globals.d().j().b(Boolean.valueOf(true)))
        {
            m();
        }
    }

    static int g(a a1)
    {
        return a1.n;
    }

    private void g()
    {
        float f1;
        float f2;
        p = 0;
        d = (Globals)getActivity().getApplicationContext();
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
                obj.c = d.getString(integer.intValue());
            }
            a.a(((l) (obj)));
        }
        obj = Globals.d().t();
        if (obj != null)
        {
            ((EditViewActivity) (obj)).a(null);
        }
        StatusManager.j().a(4, 4, 0, 4, 4, 4, 4, 0);
        e = new com.cyberlink.youcammakeup.widgetpool.panel.a.b(this);
        g = (SeekBar)b.findViewById(0x7f0c00df);
        f1 = l.intValue();
        f2 = f1;
        if (g == null) goto _L2; else goto _L1
_L1:
        Object obj1;
        Object obj2;
        obj1 = StatusManager.j().d();
        obj2 = StatusManager.j().s();
        if (obj2 != BeautyMode.o) goto _L4; else goto _L3
_L3:
        if (obj1 != null && ((i) (obj1)).j() != -1F)
        {
            f1 = ((i) (obj1)).j();
        } else
        {
            f1 = 35F;
        }
_L6:
        Globals.d().j().a(g);
        g.setProgress((int)f1);
        obj1 = new ArrayList();
        ((List) (obj1)).add(Integer.valueOf((int)f1));
        Globals.d().j().c(((List) (obj1)));
        f2 = f1;
_L2:
label0:
        {
            h = (SliderValueText)b.findViewById(0x7f0c00de);
            if (h != null)
            {
                h.setDoubleTapAble(Boolean.valueOf(false));
                h.setText(Integer.toString((int)f2));
            }
            a("Apply", Boolean.valueOf(true));
            obj1 = ((com.cyberlink.youcammakeup.kernelctrl.c.a)d.i.b().get()).a();
            if (obj1 == null)
            {
                break label0;
            }
            obj1 = ((ArrayList) (obj1)).iterator();
            do
            {
                if (!((Iterator) (obj1)).hasNext())
                {
                    break label0;
                }
                obj2 = (b)((WeakReference)((Iterator) (obj1)).next()).get();
            } while (obj2 == null || !(obj2 instanceof ImageViewer));
            c = (ImageViewer)obj2;
        }
        m = Boolean.valueOf(false);
        i = b.findViewById(0x7f0c0637);
        MotionControlHelper.e().B();
        j = true;
        com.cyberlink.youcammakeup.kernelctrl.j.a().a(false);
        return;
_L4:
        if (obj2 == BeautyMode.p)
        {
            if (obj1 != null && ((i) (obj1)).k() != -1F)
            {
                f1 = ((i) (obj1)).k();
            } else
            {
                f1 = 35F;
            }
        } else
        if (obj2 == BeautyMode.c)
        {
            if (obj1 != null && ((i) (obj1)).l() != -1F)
            {
                f1 = ((i) (obj1)).l();
            } else
            {
                f1 = 35F;
            }
        } else
        if (obj2 == BeautyMode.d)
        {
            if (obj1 != null && ((i) (obj1)).m() != -1F)
            {
                f1 = ((i) (obj1)).m();
            } else
            {
                f1 = 35F;
            }
        } else
        if (obj2 == BeautyMode.g)
        {
            if (obj1 != null && ((i) (obj1)).n() != -1F)
            {
                f1 = ((i) (obj1)).n();
            } else
            {
                f1 = 50F;
            }
        } else
        if (obj2 == BeautyMode.u)
        {
            if (obj1 != null && ((i) (obj1)).r() != -1F)
            {
                f1 = ((i) (obj1)).r();
            } else
            {
                f1 = 45F;
            }
        } else
        if (obj2 == BeautyMode.f)
        {
            if (obj1 != null && ((i) (obj1)).o() != -1F)
            {
                f1 = ((i) (obj1)).o();
            } else
            {
                f1 = 35F;
            }
        } else
        if (obj2 == BeautyMode.h)
        {
            if (obj1 != null && ((i) (obj1)).p() != -1F)
            {
                f1 = ((i) (obj1)).p();
            } else
            {
                f1 = 35F;
            }
        } else
        if (obj2 == BeautyMode.w)
        {
            if (obj1 != null && ((i) (obj1)).q() != -1F)
            {
                f1 = ((i) (obj1)).q();
            } else
            {
                f1 = 50F;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    static SeekBar h(a a1)
    {
        return a1.g;
    }

    private void h()
    {
        p = 0;
        a("Apply", Boolean.valueOf(false));
        if (a != null)
        {
            a.a(null);
        }
        Globals.d().j().a(null);
        b = null;
        e = null;
        c = null;
        EditViewActivity editviewactivity = d.t();
        if (m.booleanValue())
        {
            if (editviewactivity != null)
            {
                editviewactivity.L();
            }
            m = Boolean.valueOf(false);
        }
        if (editviewactivity != null)
        {
            editviewactivity.b(Boolean.valueOf(false));
            editviewactivity.m(false);
        }
        d = null;
        f.b(false);
        if (o)
        {
            com.cyberlink.youcammakeup.kernelctrl.j.a().d();
        }
    }

    private void i()
    {
        StatusManager.j().a(e);
        StatusManager.j().a(this);
        BeautifierManager.a().a(this);
        if (g != null)
        {
            g.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

                final a a;

                public void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
                {
                    if (com.cyberlink.youcammakeup.widgetpool.panel.a.a.d(a))
                    {
                        Globals.d().j().b(Boolean.valueOf(false));
                        com.cyberlink.youcammakeup.widgetpool.panel.a.a.c(a, false);
                    }
                    com.cyberlink.youcammakeup.widgetpool.panel.a.a.e(a).setText(Integer.toString(i1));
                }

                public void onStartTrackingTouch(SeekBar seekbar)
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.a.a.b(a, false);
                    com.cyberlink.youcammakeup.widgetpool.panel.a.a.c(a).t().b(Boolean.valueOf(false));
                    Globals.d().j().y();
                    if (a.a != null)
                    {
                        a.a.a(Boolean.valueOf(true));
                    }
                }

                public void onStopTrackingTouch(SeekBar seekbar)
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.a.a.b(a, true);
                    if (a.a != null)
                    {
                        a.a.a(Boolean.valueOf(false));
                    }
                    if (Globals.d().j().b(Boolean.valueOf(true)))
                    {
                        com.cyberlink.youcammakeup.widgetpool.panel.a.a.b(a);
                    }
                }

            
            {
                a = a.this;
                super();
            }
            });
        }
        if (i != null)
        {
            i.setOnTouchListener(s);
        }
    }

    private void j()
    {
        StatusManager.j().b(e);
        StatusManager.j().b(this);
        if (g != null)
        {
            g.setOnSeekBarChangeListener(null);
        }
        if (i != null)
        {
            i.setOnTouchListener(null);
        }
        BeautifierManager.a().b(this);
    }

    private void k()
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
        f.a(((com.cyberlink.youcammakeup.widgetpool.toolbar.e) (obj)));
        int i1;
        int j1;
        if (c != null && c.m != null && c.m.i != null && c.m.i.size() > 1)
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

    private void l()
    {
        if (c == null)
        {
            return;
        } else
        {
            (new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f()).a = true;
            c.b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.a, new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f());
            c.b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.b, new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f());
            return;
        }
    }

    private void m()
    {
        Globals.d().i().b(Globals.d().t());
    }

    private void n()
    {
        Globals.d().i().h(Globals.d().t());
    }

    public void a()
    {
        if (f != null)
        {
            f.a(Boolean.valueOf(false));
        }
        if (a != null)
        {
            a.a(Boolean.valueOf(false));
        }
    }

    public void a(Fragment fragment)
    {
        f = (MakeupMenuBottomToolbar)fragment;
    }

    public void a(BeautifierTaskInfo beautifiertaskinfo)
    {
        boolean flag = false;
        com.pf.common.utility.m.b("update_undo", "[BeautySliderPanel] - onBeautifierTaskComplete");
        if (o)
        {
            if (com.cyberlink.youcammakeup.kernelctrl.j.a().j())
            {
                Globals.d().t().a(false, null);
            }
            c(true);
            l();
            k();
            n();
            return;
        }
        if (beautifiertaskinfo.a())
        {
            if (!k)
            {
                flag = true;
            }
            c(flag);
            if (k)
            {
                l();
            }
        }
        if (beautifiertaskinfo.c())
        {
            beautifiertaskinfo = Globals.d().t();
            if (beautifiertaskinfo != null)
            {
                boolean flag1 = beautifiertaskinfo.B();
                if (q)
                {
                    beautifiertaskinfo.e(flag1, flag1);
                } else
                {
                    beautifiertaskinfo.d(flag1, flag1);
                    q = true;
                }
            }
            n();
        }
        n();
        p = g.getProgress();
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName buffername, Long long1)
    {
label0:
        {
            if (buffername == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c)
            {
                j = true;
                if (k)
                {
                    break label0;
                }
                if (g != null && g.getProgress() != p)
                {
                    Globals.d().j().b(Boolean.valueOf(false));
                    j = false;
                }
            }
            return;
        }
        p = g.getProgress();
    }

    public void a(Long long1, boolean flag)
    {
    }

    public void a(String s1, Boolean boolean1)
    {
        if (a != null)
        {
            a.a(s1, boolean1);
        }
    }

    public void a(boolean flag)
    {
        q = flag;
    }

    public void b()
    {
        m();
        long l1 = StatusManager.j().l();
        if (!com.cyberlink.youcammakeup.database.g.a(l1) && !com.cyberlink.youcammakeup.kernelctrl.viewengine.i.a(l1) || c == null)
        {
            e();
            return;
        }
        d.t().V();
        Object obj = (ImageViewer)getActivity().findViewById(0x7f0c0720);
        if (obj != null)
        {
            ((ImageViewer) (obj)).q();
        }
        obj = new Handler();
        com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.DevelopSetting developsetting = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.e.a().a(Long.valueOf(l1), Boolean.valueOf(true));
        ViewEngine.a().a(l1, 1.0D, developsetting, null, new com.cyberlink.youcammakeup.kernelctrl.viewengine.a(l1, ((Handler) (obj))) {

            final long a;
            final Handler b;
            final a c;

            public void a(com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskCancelType taskcanceltype, String s1, Object obj1)
            {
                b.post(new Runnable(this) {

                    final _cls5 a;

                    public void run()
                    {
                        a.c.e();
                    }

            
            {
                a = _pcls5;
                super();
            }
                });
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
                    obj1 = new com.cyberlink.youcammakeup.kernelctrl.status.a(a, c.c.m.b, c.c.m.c, c.c.m.d, com.cyberlink.youcammakeup.kernelctrl.j.a(c.c.m.i), list, ((ar)list.get(c.c.m.j)).c.b(), ((ar)list.get(c.c.m.j)).c.c(), c.c.m.j, null, ((v) (obj2)), "");
                }
                obj3 = StatusManager.j().s();
                if (((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).f() == null)
                {
                    obj2 = new i();
                } else
                {
                    obj2 = new i(((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).f().g());
                }
                if (obj2 == null) goto _L2; else goto _L1
_L1:
                if (obj3 != BeautyMode.o) goto _L4; else goto _L3
_L3:
                com.cyberlink.youcammakeup.clflurry.b.a(new n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.r));
                ((i) (obj2)).a(a.h(c).getProgress());
                obj3 = new YMKApplyEvent(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.p);
                ((YMKApplyEvent) (obj3)).g(String.valueOf(a.h(c).getProgress()));
                com.cyberlink.youcammakeup.clflurry.b.a(((YMKApplyEvent) (obj3)).e());
_L6:
                ((i) (obj2)).a(false);
                StatusManager.j().a(((i) (obj2)));
_L2:
                obj3 = MotionControlHelper.e().M();
                ((v) (obj3)).a(((i) (obj2)));
                obj1 = new com.cyberlink.youcammakeup.kernelctrl.status.a(a, q1.a().b(), q1.a().c(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).d, com.cyberlink.youcammakeup.kernelctrl.j.a(c.c.m.i), list, ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).a(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).b(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).e, ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).c(), ((v) (obj3)), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).g());
                StatusManager.j().a(((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)), q1.a(), new com.cyberlink.youcammakeup.d(this) {

                    final _cls5 b;

                    public void a()
                    {
                        b.c.e();
                    }

                    public void b()
                    {
                        b.c.e();
                    }

                    public void c()
                    {
                        b.c.e();
                    }

            
            {
                b = _pcls5;
                super();
            }
                });
                return;
_L4:
                if (obj3 == BeautyMode.p)
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.q));
                    ((i) (obj2)).b(a.h(c).getProgress());
                    obj3 = new YMKApplyEvent(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.o);
                    ((YMKApplyEvent) (obj3)).g(String.valueOf(a.h(c).getProgress()));
                    com.cyberlink.youcammakeup.clflurry.b.a(((YMKApplyEvent) (obj3)).e());
                } else
                if (obj3 == BeautyMode.c)
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.i));
                    ((i) (obj2)).c(a.h(c).getProgress());
                    obj3 = new YMKApplyEvent(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.i);
                    ((YMKApplyEvent) (obj3)).g(String.valueOf(a.h(c).getProgress()));
                    com.cyberlink.youcammakeup.clflurry.b.a(((YMKApplyEvent) (obj3)).e());
                } else
                if (obj3 == BeautyMode.d)
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.b));
                    ((i) (obj2)).d(a.h(c).getProgress());
                    obj3 = new YMKApplyEvent(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.b);
                    ((YMKApplyEvent) (obj3)).g(String.valueOf(a.h(c).getProgress()));
                    com.cyberlink.youcammakeup.clflurry.b.a(((YMKApplyEvent) (obj3)).e());
                } else
                if (obj3 == BeautyMode.g)
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.f));
                    ((i) (obj2)).e(a.h(c).getProgress());
                    obj3 = new YMKApplyEvent(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.f);
                    ((YMKApplyEvent) (obj3)).g(String.valueOf(a.h(c).getProgress()));
                    com.cyberlink.youcammakeup.clflurry.b.a(((YMKApplyEvent) (obj3)).e());
                } else
                if (obj3 == BeautyMode.u)
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.u));
                    ((i) (obj2)).h(a.h(c).getProgress());
                    obj3 = new YMKApplyEvent(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.r);
                    ((YMKApplyEvent) (obj3)).g(String.valueOf(a.h(c).getProgress()));
                    com.cyberlink.youcammakeup.clflurry.b.a(((YMKApplyEvent) (obj3)).e());
                } else
                if (obj3 == BeautyMode.f)
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.g));
                    ((i) (obj2)).f(a.h(c).getProgress());
                    obj3 = new YMKApplyEvent(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.g);
                    ((YMKApplyEvent) (obj3)).g(String.valueOf(a.h(c).getProgress()));
                    com.cyberlink.youcammakeup.clflurry.b.a(((YMKApplyEvent) (obj3)).e());
                } else
                if (obj3 == BeautyMode.h)
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.e));
                    ((i) (obj2)).g(a.h(c).getProgress());
                    obj3 = new YMKApplyEvent(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.e);
                    ((YMKApplyEvent) (obj3)).g(String.valueOf(a.h(c).getProgress()));
                    com.cyberlink.youcammakeup.clflurry.b.a(((YMKApplyEvent) (obj3)).e());
                } else
                if (obj3 == BeautyMode.w)
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.w));
                    ((i) (obj2)).i(a.h(c).getProgress());
                    YMKApplyEvent ymkapplyevent = new YMKApplyEvent(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.u);
                    ymkapplyevent.g(String.valueOf(a.h(c).getProgress()));
                    com.cyberlink.youcammakeup.clflurry.b.a(ymkapplyevent.e());
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            public void a(String s1, Object obj1)
            {
                b.post(new Runnable(this) {

                    final _cls5 a;

                    public void run()
                    {
                        a.c.e();
                    }

            
            {
                a = _pcls5;
                super();
            }
                });
            }

            
            {
                c = a.this;
                a = l1;
                b = handler;
                super();
            }
        });
    }

    public void c()
    {
        m();
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
            BeautifierEditCenter.a().a(((ar)c.m.i.get(c.m.j)).b, ((ar)com.cyberlink.youcammakeup.kernelctrl.j.a().g().get(c.m.j)).c, false, new BeautifierTaskInfo(false));
        }
        o = true;
        BeautifierEditCenter.a().a(new BeautifierTaskInfo(true));
        d.t().V();
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
        n();
        k();
    }

    public void onActivityCreated(Bundle bundle)
    {
        g();
        i();
        super.onActivityCreated(bundle);
        a();
        if (!IntroDialogUtils.b(getFragmentManager(), r, null))
        {
            f();
            bundle = d.t();
            if (bundle != null)
            {
                bundle.a(false, null);
                a(false);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        d = Globals.d();
        b = layoutinflater.inflate(0x7f030161, viewgroup, false);
        return b;
    }

    public void onDestroyView()
    {
        j();
        h();
        super.onDestroyView();
    }

    public void onDetach()
    {
        super.onDetach();
        a();
        f = null;
    }
}
