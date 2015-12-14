// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.animation.Animator;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.j;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.kernelctrl.status.aa;
import com.cyberlink.youcammakeup.kernelctrl.status.aj;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.DownloadUseUtils;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.ax;
import com.cyberlink.youcammakeup.utility.ch;
import com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl;
import com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryView;
import com.cyberlink.youcammakeup.widgetpool.foundationtouchview.FoundationView;
import com.cyberlink.youcammakeup.widgetpool.wigpreviewview.WigView;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            d, e

public abstract class c extends Fragment
{

    public static final MakeupMode a;
    protected Fragment b;
    protected int c;
    private aj d;
    private aa e;
    private ArrayList f;
    private boolean g;
    private Handler h;

    public c()
    {
        f = new ArrayList();
        c = 0x7f0c00c8;
        h = new Handler();
    }

    private void a()
    {
    }

    static void a(c c1)
    {
        c1.e();
    }

    public static boolean a(Activity activity)
    {
        MakeupMode makeupmode = StatusManager.j().r();
        BeautyMode beautymode = StatusManager.j().s();
        activity = DownloadUseUtils.a(activity);
        if (activity != null && ((com.cyberlink.youcammakeup.utility.DownloadUseUtils.UseTemplate) (activity)).makeupMode == MakeupMode.f && ((com.cyberlink.youcammakeup.utility.DownloadUseUtils.UseTemplate) (activity)).beautyMode == BeautyMode.D)
        {
            activity.beautyMode = PanelDataCenter.a().p(((com.cyberlink.youcammakeup.utility.DownloadUseUtils.UseTemplate) (activity)).typeGUID).b();
        }
        return activity != null && a(makeupmode, beautymode) && (((com.cyberlink.youcammakeup.utility.DownloadUseUtils.UseTemplate) (activity)).makeupMode != makeupmode || ((com.cyberlink.youcammakeup.utility.DownloadUseUtils.UseTemplate) (activity)).beautyMode != beautymode);
    }

    public static boolean a(MakeupMode makeupmode, BeautyMode beautymode)
    {
        while (makeupmode != MakeupMode.g && beautymode != BeautyMode.D || makeupmode == MakeupMode.a) 
        {
            return true;
        }
        return false;
    }

    static boolean a(c c1, boolean flag)
    {
        c1.g = flag;
        return flag;
    }

    static ArrayList b(c c1)
    {
        return c1.f;
    }

    private void b()
    {
    }

    private void c()
    {
        d = new aj() {

            final c a;

            public void b(MakeupMode makeupmode)
            {
                if (makeupmode == MakeupMode.g);
                a.a(makeupmode);
            }

            
            {
                a = c.this;
                super();
            }
        };
        StatusManager.j().a(d);
        e = new aa() {

            final c a;

            public void a()
            {
                if (a.h())
                {
                    a.a(true);
                }
            }

            
            {
                a = c.this;
                super();
            }
        };
        StatusManager.j().a(e);
    }

    private void d()
    {
        StatusManager.j().b(e);
        e = null;
        StatusManager.j().b(d);
        d = null;
    }

    private void e()
    {
        h.post(new Runnable() {

            final c a;

            public void run()
            {
                for (Iterator iterator = ((ArrayList)c.b(a).clone()).iterator(); iterator.hasNext(); ((d)iterator.next()).a()) { }
            }

            
            {
                a = c.this;
                super();
            }
        });
    }

    protected void a(Fragment fragment)
    {
        b = fragment;
        getActivity().findViewById(c).setVisibility(0);
        FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
        fragmenttransaction.setCustomAnimations(0x7f040024, 0);
        fragmenttransaction.replace(c, fragment);
        fragmenttransaction.commit();
        ((EditViewActivity)getActivity()).a(b);
    }

    protected abstract void a(MakeupMode makeupmode);

    protected void a(ch ch1)
    {
        FrameLayout framelayout = (FrameLayout)getActivity().findViewById(c);
        ch1 = new ch(framelayout, ch1) {

            final FrameLayout a;
            final ch b;
            final c c;

            public void onAnimationEnd(Animator animator)
            {
                Object obj;
                a.setVisibility(8);
                a.removeAllViews();
                a.setAlpha(1.0F);
                if (c.b != null && c.getFragmentManager() != null)
                {
                    FragmentTransaction fragmenttransaction = c.getFragmentManager().beginTransaction();
                    fragmenttransaction.remove(c.b);
                    fragmenttransaction.commitAllowingStateLoss();
                    c.b = null;
                }
                StatusManager.j().K();
                obj = StatusManager.j().s();
                if (obj != BeautyMode.x) goto _L2; else goto _L1
_L1:
                for (obj = (FrameLayout)c.getActivity().findViewById(0x7f0c00c0); ((FrameLayout) (obj)).getChildCount() > 0; ((FrameLayout) (obj)).removeViewAt(0))
                {
                    View view = ((FrameLayout) (obj)).getChildAt(0);
                    if (view instanceof WigView)
                    {
                        ((WigView)view).b();
                    }
                }

                com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c.h().a(null);
_L4:
                StatusManager.j().a(BeautyMode.D);
                StatusManager.j().y();
                if (b != null)
                {
                    b.onAnimationEnd(animator);
                }
                return;
_L2:
                if (!BeautyMode.d(((BeautyMode) (obj))))
                {
                    break; /* Loop/switch isn't completed */
                }
                for (obj = (FrameLayout)c.getActivity().findViewById(0x7f0c00c0); ((FrameLayout) (obj)).getChildCount() > 0; ((FrameLayout) (obj)).removeViewAt(0))
                {
                    View view1 = ((FrameLayout) (obj)).getChildAt(0);
                    if (view1 instanceof AccessoryView)
                    {
                        ((AccessoryView)view1).c();
                    }
                }

                AccessoryDrawingCtrl.a(null);
                if (true) goto _L4; else goto _L3
_L3:
                if (obj == BeautyMode.b)
                {
                    FrameLayout framelayout1 = (FrameLayout)c.getActivity().findViewById(0x7f0c00c0);
                    while (framelayout1.getChildCount() > 0) 
                    {
                        View view2 = framelayout1.getChildAt(0);
                        if (view2 instanceof FoundationView)
                        {
                            ((FoundationView)view2).a();
                        }
                        framelayout1.removeViewAt(0);
                    }
                }
                if (true) goto _L4; else goto _L5
_L5:
            }

            
            {
                c = c.this;
                a = framelayout;
                b = ch1;
                super();
            }
        };
        framelayout.animate().alpha(0.0F).setDuration(300L).setListener(ch1).start();
    }

    public void a(d d1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!f.contains(d1))
        {
            f.add(d1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        d1;
        this;
        JVM INSTR monitorexit ;
        throw d1;
    }

    public void a(e e1)
    {
        g = true;
        h.post(new Runnable(e1) {

            final e a;
            final c b;

            public void run()
            {
                ch ch1 = new ch(this) {

                    final _cls7 a;

                    public void onAnimationEnd(Animator animator)
                    {
                        if (a.a.a)
                        {
                            a.b.b(null);
                            a.b.a(false);
                            return;
                        } else
                        {
                            a.b.a(true);
                            return;
                        }
                    }

            
            {
                a = _pcls7;
                super();
            }
                };
                if (a.b)
                {
                    b.a(ch1);
                    return;
                } else
                {
                    ch1.onAnimationEnd(null);
                    return;
                }
            }

            
            {
                b = c.this;
                a = e1;
                super();
            }
        });
    }

    public void a(Boolean boolean1)
    {
        StatusManager statusmanager = StatusManager.j();
        boolean flag;
        if (!boolean1.booleanValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        statusmanager.a(Boolean.valueOf(flag));
    }

    protected void a(boolean flag)
    {
        byte byte0;
        if (flag)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        getView().setVisibility(byte0);
    }

    public void b(ch ch1)
    {
        View view = getView();
        if (view.getVisibility() == 0)
        {
            if (ch1 != null)
            {
                ch1.onAnimationEnd(null);
            }
            return;
        } else
        {
            g = true;
            StatusManager.j().a(Boolean.valueOf(false));
            view.addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener(view, new ch(ch1) {

                final ch a;
                final c b;

                public void onAnimationEnd(Animator animator)
                {
                    if (a != null)
                    {
                        a.onAnimationEnd(animator);
                    }
                    com.cyberlink.youcammakeup.widgetpool.toolbar.c.a(b, false);
                    com.cyberlink.youcammakeup.widgetpool.toolbar.c.a(b);
                    StatusManager.j().a(Boolean.valueOf(true));
                }

            
            {
                b = c.this;
                a = ch1;
                super();
            }
            }) {

                final View a;
                final ch b;
                final c c;

                public void onLayoutChange(View view1, int k, int l, int i1, int j1, int k1, int l1, 
                        int i2, int j2)
                {
                    a.removeOnLayoutChangeListener(this);
                    float f1 = a.getY();
                    a.setY((float)a.getHeight() + f1);
                    a.animate().alphaBy(0.5F).alpha(1.0F).y(f1).setDuration(300L).setListener(b);
                }

            
            {
                c = c.this;
                a = view;
                b = ch1;
                super();
            }
            });
            return;
        }
    }

    public void b(d d1)
    {
        this;
        JVM INSTR monitorenter ;
        if (f.contains(d1))
        {
            f.remove(d1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        d1;
        this;
        JVM INSTR monitorexit ;
        throw d1;
    }

    public void c(ch ch1)
    {
        g = true;
        StatusManager.j().a(Boolean.valueOf(false));
        View view = getView();
        ch1 = new ch(ch1) {

            final ch a;
            final c b;

            public void onAnimationEnd(Animator animator)
            {
                if (a != null)
                {
                    a.onAnimationEnd(animator);
                }
                com.cyberlink.youcammakeup.widgetpool.toolbar.c.a(b, false);
                com.cyberlink.youcammakeup.widgetpool.toolbar.c.a(b);
                StatusManager.j().a(Boolean.valueOf(true));
            }

            
            {
                b = c.this;
                a = ch1;
                super();
            }
        };
        view.animate().alpha(0.0F).setDuration(300L).setListener(ch1);
    }

    protected abstract int f();

    protected void g()
    {
        EditViewActivity editviewactivity = Globals.d().t();
        if (editviewactivity != null)
        {
            editviewactivity.i(true);
        }
        StatusManager statusmanager = StatusManager.j();
        long l = statusmanager.l();
        if (!statusmanager.h(l))
        {
            ImageBufferWrapper imagebufferwrapper = ViewEngine.a().a(l, 1.0D, null);
            Object obj2 = statusmanager.f(l);
            Object obj1 = (ImageViewer)getActivity().findViewById(0x7f0c0720);
            if (obj1 == null)
            {
                m.e("MakeupBottomToolBar", "Can't initialize local session. PanZoomViewer is null.");
                return;
            }
            if (imagebufferwrapper == null)
            {
                m.e("MakeupBottomToolBar", "Can't initialize local session. newSrcBuffer is null.");
                return;
            }
            Object obj;
            com.cyberlink.youcammakeup.jniproxy.UIImageOrientation uiimageorientation;
            com.cyberlink.youcammakeup.jniproxy.z z;
            com.cyberlink.youcammakeup.jniproxy.z z1;
            java.util.List list;
            java.util.List list1;
            int k;
            long l1;
            long l2;
            if (StatusManager.j().r() == MakeupMode.a && ((a) (obj2)).f() != null)
            {
                obj = ((a) (obj2)).f();
            } else
            {
                obj = new v(BeautyMode.D);
            }
            ((v) (obj)).a(StatusManager.j().d());
            l1 = imagebufferwrapper.b();
            l2 = imagebufferwrapper.c();
            if (obj2 == null)
            {
                uiimageorientation = ((ImageViewer) (obj1)).m.d;
            } else
            {
                uiimageorientation = ((a) (obj2)).d;
            }
            list = j.a(((ImageViewer) (obj1)).m.i);
            list1 = j.a().g();
            if (obj2 == null)
            {
                z = null;
            } else
            {
                z = ((a) (obj2)).a();
            }
            if (obj2 == null)
            {
                z1 = null;
            } else
            {
                z1 = ((a) (obj2)).b();
            }
            if (obj2 == null)
            {
                k = ((ImageViewer) (obj1)).m.j;
            } else
            {
                k = ((a) (obj2)).e;
            }
            if (obj2 == null)
            {
                obj1 = null;
            } else
            {
                obj1 = ((a) (obj2)).c();
            }
            if (obj2 == null)
            {
                obj2 = "";
            } else
            {
                obj2 = ((a) (obj2)).g();
            }
            obj = new a(l, l1, l2, uiimageorientation, list, list1, z, z1, k, ((String) (obj1)), ((v) (obj)), ((String) (obj2)));
            StatusManager.j().b(((a) (obj)), imagebufferwrapper);
            imagebufferwrapper.m();
        }
        statusmanager.y();
    }

    protected boolean h()
    {
        return true;
    }

    public boolean i()
    {
        return g;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        a();
        c();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(f(), viewgroup, false);
    }

    public void onDestroyView()
    {
        d();
        b();
        super.onDestroyView();
    }

    public void onPause()
    {
        getView().animate().cancel();
        getActivity().findViewById(c).animate().cancel();
        super.onPause();
    }

    static 
    {
        a = MakeupMode.g;
    }
}
