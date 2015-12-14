// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.d;

import android.animation.Animator;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.SeekBar;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.WebViewerExActivity;
import com.cyberlink.youcammakeup.activity.k;
import com.cyberlink.youcammakeup.clflurry.YMKClicksLipsCartEvent;
import com.cyberlink.youcammakeup.clflurry.w;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierTaskInfo;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.f;
import com.cyberlink.youcammakeup.kernelctrl.j;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.g;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.ImageStateChangedEvent;
import com.cyberlink.youcammakeup.kernelctrl.status.SessionState;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.an;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.c;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.DownloadUseUtils;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.SkuTemplateUtils;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.ax;
import com.cyberlink.youcammakeup.utility.az;
import com.cyberlink.youcammakeup.utility.ba;
import com.cyberlink.youcammakeup.utility.ch;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.AdapterView;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;
import com.cyberlink.youcammakeup.widgetpool.common.FixedAspectRatioFrameLayout;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.common.VerticalSeekBar;
import com.cyberlink.youcammakeup.widgetpool.dialogs.ah;
import com.cyberlink.youcammakeup.widgetpool.dialogs.y;
import com.cyberlink.youcammakeup.widgetpool.panel.a;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanelItemAdapter;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.TemplateButton;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.p;
import com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar;
import com.cyberlink.youcammakeup.widgetpool.toolbar.TopToolBar;
import com.cyberlink.youcammakeup.widgetpool.toolbar.e;
import com.cyberlink.youcammakeup.widgetpool.toolbar.l;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.d:
//            c

public abstract class d extends Fragment
    implements k, f, g, an, a
{

    private VerticalSeekBar A;
    private ViewGroup B;
    private ag C;
    private boolean D;
    private boolean E;
    private Long F;
    private String G;
    private String H;
    private List I;
    private Map J;
    private v K;
    private com.cyberlink.youcammakeup.widgetpool.panel.d.c L;
    public android.widget.SeekBar.OnSeekBarChangeListener a;
    android.view.View.OnClickListener b;
    android.view.View.OnClickListener c;
    android.view.View.OnClickListener d;
    private TopToolBar e;
    private View f;
    private Globals g;
    private MakeupMenuBottomToolbar h;
    private EditViewActivity i;
    private com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.k j;
    private com.cyberlink.youcammakeup.widgetpool.common.a.g k;
    private ImageViewer l;
    private boolean m;
    private View n;
    private HorizontalGridView o;
    private View p;
    private ViewGroup q;
    private ViewGroup r;
    private final ViewGroup s = null;
    private final ViewGroup t = null;
    private ViewGroup u;
    private View v;
    private View w;
    private View x;
    private View y;
    private BeautyToolPanelItemAdapter z;

    public d()
    {
        g = null;
        h = null;
        i = null;
        l = null;
        m = false;
        n = null;
        o = null;
        p = null;
        q = null;
        r = null;
        u = null;
        v = null;
        w = null;
        x = null;
        y = null;
        z = null;
        A = null;
        B = null;
        D = false;
        E = false;
        F = null;
        G = null;
        H = null;
        I = null;
        J = null;
        K = null;
        L = null;
        a = new android.widget.SeekBar.OnSeekBarChangeListener() {

            final d a;
            private final com.cyberlink.youcammakeup.activity.c b = new _cls1(this);

            public void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
            {
                if (com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(a) == null)
                {
                    return;
                }
                if (com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(a).aa())
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(a).a(b);
                    seekbar = Globals.d().j();
                    if (flag)
                    {
                        flag = false;
                    } else
                    {
                        flag = true;
                    }
                    seekbar.b(Boolean.valueOf(flag));
                    com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(a).t(false);
                }
                com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(a).b(Integer.toString(i1));
            }

            public void onStartTrackingTouch(SeekBar seekbar)
            {
                if (com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(a) == null)
                {
                    return;
                }
                com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(a).s(false);
                com.cyberlink.youcammakeup.widgetpool.panel.d.d.p(a).a(Boolean.valueOf(true));
                com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(a).v(true);
                Globals.d().j().y();
                a.a(true);
                if (com.cyberlink.youcammakeup.widgetpool.panel.d.d.g(a) != null)
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.d.d.g(a).b(true);
                }
                if (com.cyberlink.youcammakeup.widgetpool.panel.d.d.f(a) != null)
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.d.d.f(a).a(false);
                }
                com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(a).a(b);
            }

            public void onStopTrackingTouch(SeekBar seekbar)
            {
                if (com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(a) != null)
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(a).s(true);
                    com.cyberlink.youcammakeup.widgetpool.panel.d.d.p(a).a(Boolean.valueOf(false));
                    com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(a).v(false);
                    if (Globals.d().j().b(Boolean.valueOf(true)))
                    {
                        Globals.d().i().b(com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(a));
                        return;
                    }
                }
            }

            
            {
                a = d.this;
                super();
            }
        };
        b = new android.view.View.OnClickListener() {

            final d a;

            public void onClick(View view)
            {
                view = com.cyberlink.youcammakeup.widgetpool.panel.d.d.g(a).e();
                if (view instanceof ba)
                {
                    view = (ba)view;
                    view = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(com.cyberlink.youcammakeup.widgetpool.panel.d.d.c(a), view.n(), view.h());
                    if (view != null)
                    {
                        Object obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(com.cyberlink.youcammakeup.widgetpool.panel.d.d.c(a), com.cyberlink.youcammakeup.widgetpool.panel.d.d.a(a)).d();
                        if (obj != null && !((String) (obj)).isEmpty())
                        {
                            com.cyberlink.youcammakeup.clflurry.b.a(new YMKClicksLipsCartEvent(((String) (obj)), view.a()));
                        }
                        obj = new Intent(a.getActivity(), com/cyberlink/youcammakeup/activity/WebViewerExActivity);
                        ((Intent) (obj)).putExtra("RedirectUrl", view.c().toString());
                        a.startActivity(((Intent) (obj)));
                        return;
                    }
                }
            }

            
            {
                a = d.this;
                super();
            }
        };
        c = new android.view.View.OnClickListener() {

            final d a;

            public void onClick(View view)
            {
                view = com.cyberlink.youcammakeup.widgetpool.panel.d.d.g(a).e();
                if (view instanceof ba)
                {
                    view = (ba)view;
                    view = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(com.cyberlink.youcammakeup.widgetpool.panel.d.d.c(a), view.n(), view.h());
                    if (view != null)
                    {
                        Object obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(com.cyberlink.youcammakeup.widgetpool.panel.d.d.c(a), com.cyberlink.youcammakeup.widgetpool.panel.d.d.a(a)).d();
                        if (obj != null && !((String) (obj)).isEmpty())
                        {
                            com.cyberlink.youcammakeup.clflurry.b.a(new YMKClicksLipsCartEvent(((String) (obj)), view.a()));
                        }
                        obj = new Intent(a.getActivity(), com/cyberlink/youcammakeup/activity/WebViewerExActivity);
                        ((Intent) (obj)).putExtra("RedirectUrl", view.b().toString());
                        a.startActivity(((Intent) (obj)));
                        return;
                    }
                }
            }

            
            {
                a = d.this;
                super();
            }
        };
        d = new android.view.View.OnClickListener() {

            final d a;

            public void onClick(View view)
            {
                view = com.cyberlink.youcammakeup.widgetpool.panel.d.d.g(a).e();
                if (!(view instanceof ba))
                {
                    return;
                }
                view = (ba)view;
                view = new com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl(com.cyberlink.youcammakeup.widgetpool.panel.d.d.c(a), view.n(), view.h(), StatusManager.j().e());
                if (view != null)
                {
                    String s1 = ((com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl) (view)).type;
                    String s2 = ((com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl) (view)).skuGuid;
                    String s3 = ((com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl) (view)).itemGuid;
                    com.cyberlink.youcammakeup.clflurry.b.a(new com.cyberlink.youcammakeup.clflurry.i(s1, s2, s3));
                    com.cyberlink.youcammakeup.clflurry.b.a(new w(SkuTemplateUtils.i(s1), s2, s3));
                }
                Intent intent = new Intent(a.getActivity(), com/cyberlink/youcammakeup/activity/WebViewerExActivity);
                intent.putExtra("RedirectUrl", view);
                a.startActivity(intent);
            }

            
            {
                a = d.this;
                super();
            }
        };
    }

    private void B()
    {
        Fragment fragment = e();
        com.cyberlink.youcammakeup.widgetpool.common.a.g g1 = new com.cyberlink.youcammakeup.widgetpool.common.a.g();
        g1.a(f());
        if (fragment != null)
        {
            FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
            if (j != null)
            {
                fragmenttransaction.add(0x7f0c0661, fragment);
            } else
            {
                fragmenttransaction.replace(0x7f0c0661, fragment);
            }
            fragmenttransaction.replace(0x7f0c065f, g1);
            k = g1;
            k.a((com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.k)fragment);
            k.b(true);
            if (i != null)
            {
                i.a(null);
            }
            u = (ViewGroup)f.findViewById(0x7f0c065f);
            j = (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.k)fragment;
            j.a(this);
            if (E && F != null)
            {
                k.a(new az(F, G));
                j.a(new az(F, G));
            }
            fragmenttransaction.commitAllowingStateLoss();
        }
    }

    private void C()
    {
        if (q != null)
        {
            int i1 = 0;
            while (i1 < q.getChildCount()) 
            {
                q.getChildAt(i1).setSelected(false);
                i1++;
            }
        }
    }

    private void D()
    {
        com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.k k1 = new com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.k(getActivity(), null);
        k1.g = false;
        k1.a(0.15F);
        C = new ag(getActivity());
        C.a(getActivity().getFragmentManager(), k1);
    }

    private void E()
    {
        if (E)
        {
            r = (ViewGroup)f.findViewById(0x7f0c0678);
            q = (ViewGroup)f.findViewById(0x7f0c0679);
            if (q != null && r != null)
            {
                android.view.View.OnClickListener onclicklistener = new android.view.View.OnClickListener() {

                    final d a;

                    public void onClick(View view)
                    {
                        view = (Long)view.getTag();
                        a.a(false, null);
                        while (view == com.cyberlink.youcammakeup.widgetpool.panel.d.d.a(a) || view != null && view.equals(com.cyberlink.youcammakeup.widgetpool.panel.d.d.a(a))) 
                        {
                            return;
                        }
                        view = new Runnable(this, view) {

                            final Long a;
                            final _cls1 b;

                            public void run()
                            {
                                com.cyberlink.youcammakeup.widgetpool.panel.d.d.a(b.a, a);
                                Object obj;
                                Object obj1;
                                v v1;
                                az az1;
                                if (com.cyberlink.youcammakeup.widgetpool.panel.d.d.a(b.a) != null)
                                {
                                    com.cyberlink.youcammakeup.widgetpool.panel.d.d.b(b.a).put(com.cyberlink.youcammakeup.widgetpool.panel.d.d.a(b.a), MotionControlHelper.e().M());
                                } else
                                {
                                    com.cyberlink.youcammakeup.widgetpool.panel.d.d.a(b.a, MotionControlHelper.e().M());
                                }
                                if (a != null)
                                {
                                    az1 = new az(a, com.cyberlink.youcammakeup.widgetpool.panel.d.d.c(b.a));
                                    obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(com.cyberlink.youcammakeup.widgetpool.panel.d.d.c(b.a), a).d();
                                    v1 = (v)com.cyberlink.youcammakeup.widgetpool.panel.d.d.b(b.a).get(a);
                                    if (v1 == null)
                                    {
                                        obj = SkuTemplateUtils.c(((String) (obj)));
                                    } else
                                    {
                                        obj = v1.a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a);
                                    }
                                    obj1 = obj;
                                } else
                                {
                                    v1 = d.d(b.a);
                                    if (v1 == null)
                                    {
                                        obj = PanelDataCenter.a().c(b.a.a());
                                    } else
                                    {
                                        obj = v1.a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a);
                                    }
                                    az1 = null;
                                    obj1 = obj;
                                }
                                if (v1 != null)
                                {
                                    obj = v1.a();
                                } else
                                if (a != null && d.d(b.a) != null)
                                {
                                    obj = d.d(b.a).a();
                                } else
                                {
                                    obj = PanelDataCenter.a().a(b.a.a());
                                    if (obj != null && ((List) (obj)).size() > 0)
                                    {
                                        obj = PanelDataCenter.a().p((String)((List) (obj)).get(0)).a();
                                    } else
                                    {
                                        obj = null;
                                    }
                                }
                                if (com.cyberlink.youcammakeup.widgetpool.panel.d.d.e(b.a) == null);
                                b.a.a(a, false);
                                com.cyberlink.youcammakeup.widgetpool.panel.d.d.f(b.a).a(az1);
                                com.cyberlink.youcammakeup.widgetpool.panel.d.d.f(b.a).a();
                                if (obj1 != null)
                                {
                                    b.a.a(((at) (obj1)), true);
                                    b.a.a(((at) (obj1)), ((String) (obj)));
                                }
                                if (obj != null && !((String) (obj)).equals(StatusManager.j().e()))
                                {
                                    StatusManager.j().b(((String) (obj)));
                                    MotionControlHelper.e().t();
                                    MotionControlHelper.e().a(true);
                                }
                                com.cyberlink.youcammakeup.widgetpool.panel.d.d.a(b.a, v1, ((String) (obj)), a, ((at) (obj1)));
                                com.cyberlink.youcammakeup.widgetpool.panel.d.d.g(b.a).a(((at) (obj1)));
                                obj = new Runnable(this) {

                                    final _cls1 a;

                                    public void run()
                                    {
                                        boolean flag = false;
                                        a.b.a.a(false, StatusManager.j().e(), null);
                                        d d1 = a.b.a;
                                        if (a.b.a.z() == 0)
                                        {
                                            flag = true;
                                        }
                                        d1.c(flag);
                                    }

            
            {
                a = _pcls1;
                super();
            }
                                };
                                com.cyberlink.youcammakeup.widgetpool.panel.d.d.h(b.a).post(((Runnable) (obj)));
                            }

            
            {
                b = _pcls1;
                a = long1;
                super();
            }
                        };
                        com.cyberlink.youcammakeup.widgetpool.panel.d.d.h(a).post(view);
                    }

            
            {
                a = d.this;
                super();
            }
                };
                r.setVisibility(8);
                q.removeAllViews();
                h h1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b();
                for (int i1 = 0; i1 < I.size(); i1++)
                {
                    Long long1 = (Long)I.get(i1);
                    com.cyberlink.youcammakeup.database.more.i.d d1 = h1.a(G, long1);
                    if (d1 != null)
                    {
                        a(q, long1, h1.t(G, d1.d()), SkuTemplateUtils.b(d1.d(), a(G)), onclicklistener);
                    }
                }

                a(q, null, g.getString(0x7f0703cf), ((String) (null)), onclicklistener);
                return;
            }
        }
    }

    private void F()
    {
        v = f.findViewById(0x7f0c067a);
        w = f.findViewById(0x7f0c067b);
        x = f.findViewById(0x7f0c067c);
        y = f.findViewById(0x7f0c067d);
        if (E)
        {
            if (x != null)
            {
                x.setOnClickListener(c);
            }
            if (w != null)
            {
                w.setOnClickListener(b);
            }
            if (y != null)
            {
                y.setOnClickListener(d);
                return;
            }
        }
    }

    private void G()
    {
        if (i != null)
        {
            i.Z().removeAllViews();
            if (A != null)
            {
                A.setOnSeekBarChangeListener(null);
                A = null;
                return;
            }
        }
    }

    private void H()
    {
        Object obj = L.c();
        ArrayList arraylist = new ArrayList();
        int i1 = L.getCount();
        L.a();
        int j1 = L.getCount();
        if (i1 != j1 && l() != null && StatusManager.j().f().size() > 0 && !l().equals(StatusManager.j().f().get(0)))
        {
            L.notifyDataSetChanged();
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(Integer.valueOf(Integer.valueOf(((Integer)((Iterator) (obj)).next()).intValue() + (j1 - i1)).intValue()))) { }
        } else
        {
            arraylist.addAll(((Collection) (obj)));
        }
        L.a(arraylist);
    }

    private void I()
    {
        Globals.d().i().a(Globals.d().t(), 0L);
    }

    private void J()
    {
        Globals.d().i().h(Globals.d().t());
    }

    private void K()
    {
        if (i != null)
        {
            i.a(null);
            i.a(Boolean.valueOf(false), Boolean.valueOf(false));
            i.a(Boolean.valueOf(false), 0.0F, 100F, 0.0F);
            i.b(this);
            i.b(Boolean.valueOf(false));
            i.m(false);
        }
        l l1 = new l();
        l1.b = true;
        l1.a = false;
        l1.c = Globals.d().getString(0x7f0703b5);
        if (e != null)
        {
            e.a(l1);
        }
        int i1;
        byte byte0;
        if (i != null && h != null)
        {
            e e1 = new e();
            boolean flag;
            if (!i.p())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            e1.a = flag;
            e1.b = true;
            e1.c = false;
            e1.d = false;
            h.a(e1);
        }
        G();
        if (l != null && l.m != null && l.m.i != null && l.m.i.size() > 1)
        {
            i1 = 0;
        } else
        {
            i1 = 4;
        }
        if (ah.b || !ah.b())
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        StatusManager.j().a(0, i1, 8, 0, 0, 4, byte0, 8);
    }

    private void L()
    {
        if (l == null)
        {
            return;
        } else
        {
            (new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f()).a = true;
            l.b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.a, new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f());
            l.b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.b, new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f());
            return;
        }
    }

    static int a(d d1, String s1)
    {
        return d1.b(s1);
    }

    static ViewGroup a(d d1, ViewGroup viewgroup)
    {
        d1.B = viewgroup;
        return viewgroup;
    }

    static v a(d d1, v v1)
    {
        d1.K = v1;
        return v1;
    }

    static VerticalSeekBar a(d d1, VerticalSeekBar verticalseekbar)
    {
        d1.A = verticalseekbar;
        return verticalseekbar;
    }

    static Long a(d d1)
    {
        return d1.F;
    }

    private void a(ViewGroup viewgroup)
    {
        FixedAspectRatioFrameLayout fixedaspectratioframelayout = new FixedAspectRatioFrameLayout(viewgroup.getContext());
        fixedaspectratioframelayout.setTag(Long.valueOf(0x8000000000000000L));
        fixedaspectratioframelayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(0, -1));
        fixedaspectratioframelayout.a(15, 249);
        viewgroup.addView(fixedaspectratioframelayout);
    }

    private void a(ViewGroup viewgroup, Object obj, String s1, String s2, android.view.View.OnClickListener onclicklistener)
    {
        View view = LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0301f1, viewgroup, false);
        ImageView imageview = (ImageView)view.findViewById(0x7f0c0896);
        TextView textview = (TextView)view.findViewById(0x7f0c0897);
        if (textview == null || imageview == null)
        {
            return;
        }
        view.setTag(obj);
        view.setOnClickListener(onclicklistener);
        textview.setText(s1);
        if (s2 != null)
        {
            C.a(s2, imageview);
        }
        viewgroup.addView(view);
        a(viewgroup);
    }

    private void a(v v1, String s1, Long long1, at at1)
    {
        if (v1 == null)
        {
            if (long1 != null)
            {
                float f3 = at1.d();
                float f1 = f3;
                if (f3 <= 0.0F)
                {
                    f1 = p();
                }
                a(f1);
                v1 = new ArrayList();
                v1.add(Integer.valueOf((int)f1));
                MotionControlHelper.e().c(v1);
                return;
            } else
            {
                float f2 = p();
                a(f2);
                v1 = new ArrayList();
                v1.add(Integer.valueOf((int)f2));
                MotionControlHelper.e().c(v1);
                return;
            }
        } else
        {
            a(60F);
            v1 = new ArrayList();
            v1.add(Integer.valueOf((int)60F));
            MotionControlHelper.e().c(v1);
            MotionControlHelper.e().a(0.0F);
            return;
        }
    }

    private void a(BeautyMode beautymode)
    {
        Object obj;
        Object obj1;
        obj = null;
        J = new HashMap();
        G = h();
        if (G == null)
        {
            return;
        }
        obj1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b();
        I = ((h) (obj1)).b(G);
        if (I.size() <= 0) goto _L2; else goto _L1
_L1:
        com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl skutryiturl;
        skutryiturl = SkuTemplateUtils.a(getActivity());
        beautymode = (Long)I.get(0);
        if (skutryiturl == null) goto _L4; else goto _L3
_L3:
        String s1 = skutryiturl.type;
        if (G.equals(s1))
        {
            beautymode = ((h) (obj1)).c(skutryiturl.skuGuid);
        }
_L8:
        E = true;
        f.findViewById(0x7f0c0662).setVisibility(8);
_L6:
        i i1 = StatusManager.j().d();
        if (!E || i1 == null)
        {
            a(((Long) (beautymode)), false);
            return;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (DownloadUseUtils.a(getActivity()) != null)
        {
            beautymode = null;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        E = false;
        beautymode = f.findViewById(0x7f0c0678);
        View view = f.findViewById(0x7f0c0661);
        if (beautymode != null)
        {
            beautymode.setVisibility(8);
        }
        if (view != null)
        {
            view.setVisibility(8);
        }
        beautymode = null;
        if (true) goto _L6; else goto _L5
_L5:
        at at1 = j();
        if (at1 == null)
        {
            a(((Long) (beautymode)), false);
            return;
        }
        if (!(at1 instanceof ba))
        {
            a(((Long) (null)), false);
            return;
        }
        beautymode = ((ba)at1).n();
        obj1 = ((h) (obj1)).b(G, beautymode);
        beautymode = obj;
        if (obj1 != null)
        {
            beautymode = obj;
            if (I.contains(Long.valueOf(((com.cyberlink.youcammakeup.database.more.i.d) (obj1)).a())))
            {
                beautymode = Long.valueOf(((com.cyberlink.youcammakeup.database.more.i.d) (obj1)).a());
            }
        }
        a(((Long) (beautymode)), false);
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void a(com.cyberlink.youcammakeup.utility.DownloadUseUtils.UseTemplate usetemplate)
    {
        if (usetemplate == null)
        {
            return;
        }
        i i1 = StatusManager.j().d();
        usetemplate = i1;
        if (i1 == null)
        {
            usetemplate = new i();
        }
        DownloadUseUtils.a(true);
        DownloadUseUtils.b(getActivity());
        StatusManager.j().a(usetemplate);
    }

    private void a(com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl skutryiturl)
    {
        if (skutryiturl != null)
        {
            BeautyMode beautymode = SkuTemplateUtils.h(skutryiturl.type);
            BeautyMode beautymode1 = StatusManager.j().s();
            i j1 = StatusManager.j().d();
            i i1 = j1;
            if (j1 == null)
            {
                i1 = new i();
            }
            if (beautymode == beautymode1 && (beautymode != BeautyMode.s || i1.c() == null) && (beautymode != BeautyMode.b || i1.i() == null))
            {
                skutryiturl = SkuTemplateUtils.f(skutryiturl.itemGuid);
                if (skutryiturl != null)
                {
                    skutryiturl = skutryiturl.o();
                    if (z != null)
                    {
                        int k1 = b(skutryiturl);
                        o.a(k1, true);
                        o.a(z.getView(k1, null, o), k1, -1L);
                        o.post(new Runnable(k1) {

                            final int a;
                            final d b;

                            public void run()
                            {
                                d.m(b).c(a);
                            }

            
            {
                b = d.this;
                a = i1;
                super();
            }
                        });
                        return;
                    } else
                    {
                        StatusManager.j().a(i1);
                        return;
                    }
                }
            }
        }
    }

    static void a(d d1, v v1, String s1, Long long1, at at1)
    {
        d1.a(v1, s1, long1, at1);
    }

    static void a(d d1, Long long1)
    {
        d1.a(long1);
    }

    private void a(Long long1)
    {
        h h1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b();
        if (long1 != null)
        {
            com.cyberlink.youcammakeup.database.more.i.d d1 = h1.a(G, long1);
            b(long1);
            long1 = (b)j;
            long1.a(C, SkuTemplateUtils.a(d1.d(), G));
            long1.b(h1.s(G, d1.d()));
            p.setVisibility(0);
            p.setAlpha(0.0F);
            p.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F);
            return;
        } else
        {
            b(((Long) (null)));
            long1 = (b)j;
            long1.a(BitmapFactory.decodeResource(getResources(), 0x7f02088f));
            long1.b(getActivity().getString(0x7f0703cf));
            p.setVisibility(0);
            p.setAlpha(0.0F);
            p.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F);
            return;
        }
    }

    private void a(String s1, String s2, String s3, at at1)
    {
        w.setVisibility(8);
        x.setVisibility(8);
        y.setVisibility(8);
        if (s1 != null && s2 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        s2 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().h(s1, s2);
        if (s2 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s2.equalsIgnoreCase(com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent.ActionName.b.a()))
        {
            y.setVisibility(0);
            return;
        }
        if (s2.equalsIgnoreCase(com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent.ActionName.c.a()))
        {
            x.setVisibility(0);
            return;
        }
        if (s2.equalsIgnoreCase(com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent.ActionName.a.a()))
        {
            w.setVisibility(0);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        s2 = (ba)at1;
        s3 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(s1, s2.n(), s2.h());
        s2 = "";
        s1 = "";
        if (s3 != null)
        {
            s2 = s3.c().toString();
            s1 = s3.b().toString();
            s3.d().toString();
        }
        if (!s2.equals(""))
        {
            w.setVisibility(0);
        }
        if (!s1.equals(""))
        {
            x.setVisibility(0);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    static boolean a(d d1, boolean flag)
    {
        d1.m = flag;
        return flag;
    }

    private int b(String s1)
    {
        ListAdapter listadapter;
        int i1;
        int j1;
        listadapter = o.getAdapter();
        if (listadapter == null)
        {
            return -1;
        }
        j1 = listadapter.getCount();
        i1 = 0;
_L3:
        p p1;
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        p1 = (p)listadapter.getItem(i1);
          goto _L1
_L5:
        i1++;
        if (true) goto _L3; else goto _L2
_L1:
        if (p1 == null || !p1.c.equals(s1)) goto _L5; else goto _L4
_L4:
        return i1;
_L2:
        i1 = -1;
        if (true) goto _L4; else goto _L6
_L6:
    }

    static Map b(d d1)
    {
        return d1.J;
    }

    private void b(Long long1)
    {
        if (q != null)
        {
            C();
            int i1 = 0;
            while (i1 < q.getChildCount()) 
            {
                Long long2 = (Long)q.getChildAt(i1).getTag();
                if (long1 == null && long2 == null)
                {
                    q.getChildAt(i1).setSelected(true);
                    return;
                }
                if (long1 != null && long2 != null && long1.compareTo(long2) == 0)
                {
                    q.getChildAt(i1).setSelected(true);
                    return;
                }
                i1++;
            }
        }
    }

    static String c(d d1)
    {
        return d1.G;
    }

    private void c(ImageStateChangedEvent imagestatechangedevent)
    {
        Object obj = null;
        imagestatechangedevent = imagestatechangedevent.b();
        v v1;
        if (imagestatechangedevent != null)
        {
            if ((imagestatechangedevent = imagestatechangedevent.a()) != null && (v1 = imagestatechangedevent.f()) != null)
            {
label0:
                {
                    {
                        if (v1.b().size() <= 0)
                        {
                            break label0;
                        }
                        imagestatechangedevent = v1.a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a);
                        ArrayList arraylist;
                        if (imagestatechangedevent instanceof ba)
                        {
                            imagestatechangedevent = ((ba)imagestatechangedevent).n();
                            imagestatechangedevent = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().c(imagestatechangedevent);
                        } else
                        {
                            imagestatechangedevent = null;
                        }
                        if (imagestatechangedevent != F || imagestatechangedevent != null && !imagestatechangedevent.equals(F))
                        {
                            a(imagestatechangedevent);
                            a(imagestatechangedevent, true);
                            if (z != null && a() == BeautyMode.s)
                            {
                                Object obj1 = z;
                                az az1;
                                if (imagestatechangedevent != null)
                                {
                                    az1 = new az(F, G);
                                } else
                                {
                                    az1 = null;
                                }
                                ((BeautyToolPanelItemAdapter) (obj1)).a(az1);
                                z.e();
                            }
                            obj1 = k;
                            az1 = obj;
                            if (imagestatechangedevent != null)
                            {
                                az1 = new az(F, G);
                            }
                            ((com.cyberlink.youcammakeup.widgetpool.common.a.g) (obj1)).a(az1);
                            k.a();
                        }
                        StatusManager.j().b(v1.b());
                    }
                    a(StatusManager.j().f());
                    return;
                }
                imagestatechangedevent = PanelDataCenter.a().a(a());
                if (imagestatechangedevent != null && imagestatechangedevent.size() > 0)
                {
                    arraylist = new ArrayList();
                    arraylist.add(imagestatechangedevent.get(0));
                    StatusManager.j().b(arraylist);
                }
                if (false)
                {
                } else
                {
                    break MISSING_BLOCK_LABEL_219;
                }
            }
        }
    }

    static v d(d d1)
    {
        return d1.K;
    }

    static com.cyberlink.youcammakeup.widgetpool.panel.d.c e(d d1)
    {
        return d1.L;
    }

    private void e(boolean flag)
    {
        if (v == null)
        {
            return;
        }
        if (flag)
        {
            v.setVisibility(0);
            v.setAlpha(0.0F);
            v.animate().alpha(1.0F);
            return;
        } else
        {
            v.setVisibility(8);
            return;
        }
    }

    static com.cyberlink.youcammakeup.widgetpool.common.a.g f(d d1)
    {
        return d1.k;
    }

    private void f(boolean flag)
    {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof EditViewActivity))
        {
            ((EditViewActivity)activity).b(flag);
        }
    }

    static com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.k g(d d1)
    {
        return d1.j;
    }

    private void g(boolean flag)
    {
        if (l == null)
        {
            return;
        } else
        {
            com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f f1 = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f();
            f1.a = true;
            f1.c = new c(com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskRole.d);
            f1.c.f = Boolean.valueOf(flag);
            l.b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c, f1);
            return;
        }
    }

    static View h(d d1)
    {
        return d1.f;
    }

    static EditViewActivity i(d d1)
    {
        return d1.i;
    }

    static View j(d d1)
    {
        return d1.p;
    }

    static BeautyToolPanelItemAdapter k(d d1)
    {
        return d1.z;
    }

    static boolean l(d d1)
    {
        return d1.D;
    }

    static HorizontalGridView m(d d1)
    {
        return d1.o;
    }

    static void n(d d1)
    {
        d1.K();
    }

    static void o(d d1)
    {
        d1.J();
    }

    static TopToolBar p(d d1)
    {
        return d1.e;
    }

    static ImageViewer q(d d1)
    {
        return d1.l;
    }

    static void r(d d1)
    {
        d1.H();
    }

    static ViewGroup s(d d1)
    {
        return d1.r;
    }

    static View t(d d1)
    {
        return d1.n;
    }

    static VerticalSeekBar u(d d1)
    {
        return d1.A;
    }

    public int A()
    {
        if (r != null)
        {
            return r.getVisibility();
        } else
        {
            return 8;
        }
    }

    protected abstract BeautyMode a();

    protected abstract com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType a(String s1);

    public void a(float f1)
    {
        if (A == null)
        {
            return;
        } else
        {
            A.setOnSeekBarChangeListener(null);
            A.setProgressAndThumb((int)f1);
            A.setOnSeekBarChangeListener(a);
            return;
        }
    }

    public void a(float f1, boolean flag, boolean flag1)
    {
        if (i == null)
        {
            return;
        }
        Runnable runnable = new Runnable(f1, flag) {

            final float a;
            final boolean b;
            final d c;

            public void run()
            {
                LayoutInflater.from(com.cyberlink.youcammakeup.widgetpool.panel.d.d.h(c).getContext()).inflate(0x7f0301d7, com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(c).Z());
                com.cyberlink.youcammakeup.widgetpool.panel.d.d.a(c, (ViewGroup)com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(c).Z().findViewById(0x7f0c0854));
                com.cyberlink.youcammakeup.widgetpool.panel.d.d.a(c, (VerticalSeekBar)com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(c).Z().findViewById(0x7f0c0855));
                if (d.u(c) != null)
                {
                    d.u(c).setProgress((int)a);
                    d.u(c).setOnSeekBarChangeListener(c.a);
                    Globals.d().j().a(d.u(c));
                    if (com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(c) != null)
                    {
                        com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(c).v();
                    }
                }
                c.c(b);
            }

            
            {
                c = d.this;
                a = f1;
                b = flag;
                super();
            }
        };
        if (flag1)
        {
            f.post(runnable);
            return;
        } else
        {
            runnable.run();
            return;
        }
    }

    public void a(int i1)
    {
        if (u == null)
        {
            return;
        } else
        {
            u.setVisibility(i1);
            return;
        }
    }

    public void a(Fragment fragment)
    {
        h = (MakeupMenuBottomToolbar)fragment;
    }

    public void a(BeautifierTaskInfo beautifiertaskinfo)
    {
        BeautifierManager.a().b(this);
        if (com.cyberlink.youcammakeup.kernelctrl.j.a().j())
        {
            Globals.d().t().a(false, null);
        }
        g(true);
        L();
        if ((getActivity() instanceof EditViewActivity) && ah.b)
        {
            ((EditViewActivity)getActivity()).b(false, ah.c);
        }
        K();
        J();
    }

    protected abstract void a(i i1);

    public void a(ImageStateChangedEvent imagestatechangedevent)
    {
        c(imagestatechangedevent);
    }

    public void a(at at1, String s1)
    {
        if (at1 instanceof ba)
        {
            ba ba1 = (ba)at1;
            com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(G, ba1.n(), ba1.h());
            a(G, ba1.n(), s1, at1);
            return;
        } else
        {
            a(((String) (null)), null, ((String) (null)), null);
            return;
        }
    }

    public void a(at at1, boolean flag)
    {
        k.a(at1, flag);
        if (A() == 0)
        {
            a(false, ((ch) (null)));
        }
    }

    public void a(Long long1, boolean flag)
    {
        if (F == null || !F.equals(long1))
        {
            F = long1;
            if (j != null)
            {
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.k k1 = j;
                if (F == null)
                {
                    long1 = null;
                } else
                {
                    long1 = new az(F, G);
                }
                k1.a(long1);
                return;
            }
        }
    }

    public void a(String s1, Boolean boolean1)
    {
        if (e != null)
        {
            e.a(s1, boolean1);
        }
    }

    public void a(List list)
    {
        if (o == null)
        {
            return;
        }
        int i1 = -1;
        o.b();
        L.a(null);
        for (list = list.iterator(); list.hasNext(); L.e(i1))
        {
            i1 = b((String)list.next());
            o.a(i1, true);
        }

        o.post(new Runnable(i1) {

            final int a;
            final d b;

            public void run()
            {
                d.m(b).c(a);
            }

            
            {
                b = d.this;
                a = i1;
                super();
            }
        });
    }

    public void a(List list, boolean flag)
    {
        boolean flag1;
        flag1 = StatusManager.j().f().equals(list);
        StatusManager.j().b(list);
        break MISSING_BLOCK_LABEL_20;
        if (j != null && i != null && !D)
        {
            if (j != null && list.size() > 0)
            {
                j.a((String)list.get(0), flag);
            }
            if (!flag1 && MotionControlHelper.e().A())
            {
                i.j(true);
                if (!Globals.d().i().a())
                {
                    I();
                    return;
                }
            } else
            {
                J();
                return;
            }
        }
        return;
    }

    public void a(boolean flag)
    {
        D = flag;
    }

    public void a(boolean flag, ch ch)
    {
        if (flag)
        {
            if (j != null && (j instanceof b))
            {
                ((b)j).c(true);
            }
            ch = new ch(ch) {

                final ch a;
                final d b;

                public void onAnimationEnd(Animator animator)
                {
                    if (a != null)
                    {
                        a.onAnimationEnd(animator);
                    }
                }

            
            {
                b = d.this;
                a = ch1;
                super();
            }
            };
            android.view.View.OnLayoutChangeListener onlayoutchangelistener = new android.view.View.OnLayoutChangeListener() {

                final d a;

                public void onLayoutChange(View view, int i1, int j1, int k1, int l1, int i2, int j2, 
                        int k2, int l2)
                {
                    view.removeOnLayoutChangeListener(this);
                    if (com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(a) != null && !com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(a).isFinishing())
                    {
                        com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(a).c(d.s(a).getHeight() + d.t(a).getHeight());
                    }
                }

            
            {
                a = d.this;
                super();
            }
            };
            e(false);
            c(false);
            r.addOnLayoutChangeListener(onlayoutchangelistener);
            r.setAlpha(0.5F);
            r.setX(-q.getWidth() - q.getLeft());
            r.setVisibility(0);
            r.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F).x(0.0F).setListener(ch);
            return;
        } else
        {
            ch = new ch(ch) {

                final ch a;
                final d b;

                public void onAnimationEnd(Animator animator)
                {
                    if (com.cyberlink.youcammakeup.widgetpool.panel.d.d.g(b) != null && (com.cyberlink.youcammakeup.widgetpool.panel.d.d.g(b) instanceof b))
                    {
                        ((b)com.cyberlink.youcammakeup.widgetpool.panel.d.d.g(b)).c(false);
                    }
                    d.s(b).setVisibility(8);
                    if (a != null)
                    {
                        a.onAnimationEnd(animator);
                    }
                    if (com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(b) != null && !com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(b).isFinishing())
                    {
                        com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(b).c(com.cyberlink.youcammakeup.widgetpool.panel.d.d.j(b).getHeight() + d.t(b).getHeight());
                    }
                }

            
            {
                b = d.this;
                a = ch1;
                super();
            }
            };
            p.setVisibility(0);
            p.setAlpha(0.0F);
            p.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F);
            e(true);
            c(true);
            r.animate().setInterpolator(new DecelerateInterpolator()).alpha(0.5F).x(-q.getWidth() - q.getLeft()).setListener(ch);
            return;
        }
    }

    public void a(boolean flag, String s1, String s2)
    {
        if (flag)
        {
            u.setVisibility(0);
        } else
        if ((s1 == null || s2 == null || !s1.equals(s2) || r == null || r.getVisibility() != 0) && s1 != null && u != null)
        {
            if (s2 != null && s1.equals(s2))
            {
                if (u.getVisibility() == 0)
                {
                    b(false);
                    u.setVisibility(8);
                    return;
                } else
                {
                    b(true);
                    u.setVisibility(0);
                    return;
                }
            } else
            {
                b(true);
                u.setVisibility(0);
                return;
            }
        }
    }

    protected abstract List b(i i1);

    public void b()
    {
        StatusManager.j().a(Boolean.valueOf(false));
        I();
        long l1 = StatusManager.j().l();
        if (!com.cyberlink.youcammakeup.database.g.a(l1) && !com.cyberlink.youcammakeup.kernelctrl.viewengine.i.a(l1) || l == null)
        {
            x();
            return;
        }
        i.V();
        ImageViewer imageviewer = (ImageViewer)getActivity().findViewById(0x7f0c0720);
        if (imageviewer != null)
        {
            imageviewer.q();
        }
        y();
    }

    public void b(ImageStateChangedEvent imagestatechangedevent)
    {
        c(imagestatechangedevent);
    }

    public void b(boolean flag)
    {
        if (StatusManager.j().f().size() > 0)
        {
            L.b(flag);
            L.notifyDataSetChanged();
        }
    }

    public void c()
    {
        long l1 = StatusManager.j().l();
        Object obj;
        if (i.p())
        {
            obj = i.r();
        } else
        {
            obj = StatusManager.j().f(Long.valueOf(l1).longValue());
        }
        I();
        (new AsyncTask(((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj))) {

            final com.cyberlink.youcammakeup.kernelctrl.status.a a;
            final d b;

            protected transient Void a(Void avoid[])
            {
                MotionControlHelper.e().t();
                MotionControlHelper.e().r();
                MotionControlHelper.e().a(b.a(), false);
                MotionControlHelper.e().v();
                return null;
            }

            protected void a(Void void1)
            {
                if (a != null && a.f() != null)
                {
                    BeautifierEditCenter.a().a(a.f().f());
                    BeautifierEditCenter.a().a(((ar)com.cyberlink.youcammakeup.widgetpool.panel.d.d.q(b).m.i.get(com.cyberlink.youcammakeup.widgetpool.panel.d.d.q(b).m.j)).b, ((ar)com.cyberlink.youcammakeup.kernelctrl.j.a().g().get(com.cyberlink.youcammakeup.widgetpool.panel.d.d.q(b).m.j)).c, false, new BeautifierTaskInfo(false));
                }
                com.cyberlink.youcammakeup.widgetpool.panel.d.d.a(b, true);
                BeautifierManager.a().a(b);
                if (com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(b).p())
                {
                    MotionControlHelper.e().n();
                    void1 = new BeautifierTaskInfo(false, true, false, false);
                    MotionControlHelper.e().a(StatusManager.j().d(), void1);
                } else
                {
                    BeautifierEditCenter.a().a(new BeautifierTaskInfo(true));
                }
                if (com.cyberlink.youcammakeup.widgetpool.panel.d.d.p(b) != null)
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.d.d.p(b).a(Boolean.valueOf(false));
                }
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            protected void onPostExecute(Object obj1)
            {
                a((Void)obj1);
            }

            protected void onPreExecute()
            {
                i i1;
                if (a.f() == null)
                {
                    i1 = new i();
                } else
                {
                    i1 = new i(a.f().g());
                }
                StatusManager.j().a(i1);
                com.cyberlink.youcammakeup.kernelctrl.j.a().h();
            }

            
            {
                b = d.this;
                a = a1;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        i.V();
        obj = (ImageViewer)getActivity().findViewById(0x7f0c0720);
        if (obj != null)
        {
            ((ImageViewer) (obj)).q();
        }
    }

    public void c(long l1)
    {
        getActivity().runOnUiThread(new Runnable() {

            final d a;

            public void run()
            {
                d.r(a);
            }

            
            {
                a = d.this;
                super();
            }
        });
    }

    public void c(boolean flag)
    {
        if (B != null)
        {
            ViewGroup viewgroup = B;
            int i1;
            if (flag)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            viewgroup.setVisibility(i1);
            if (flag)
            {
                A.setAlpha(0.0F);
                A.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F);
                return;
            }
        }
    }

    public Long d()
    {
        return F;
    }

    public void d(boolean flag)
    {
        if (p != null && (p instanceof FixedAspectRatioFrameLayout))
        {
            ((FixedAspectRatioFrameLayout)p).setInterceptTouchEvent(flag);
        }
    }

    protected abstract Fragment e();

    protected abstract int f();

    protected abstract int g();

    protected abstract String h();

    protected abstract List i();

    protected abstract at j();

    protected abstract int k();

    protected abstract String l();

    protected void m()
    {
    }

    protected abstract int n();

    protected abstract boolean o();

    public void onActivityCreated(Bundle bundle)
    {
        q();
        s();
        if (i != null)
        {
            i.a(this);
        }
        super.onActivityCreated(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        g = Globals.d();
        f = layoutinflater.inflate(g(), viewgroup, false);
        a(a());
        return f;
    }

    public void onDestroyView()
    {
        t();
        r();
        super.onDestroyView();
    }

    public void onDetach()
    {
        super.onDetach();
        if (h != null)
        {
            h.a(Boolean.valueOf(false));
            h = null;
        }
    }

    public void onStart()
    {
        super.onStart();
        if (L != null)
        {
            H();
        }
        a(DownloadUseUtils.a(getActivity()));
        a(SkuTemplateUtils.a(getActivity()));
        f(true);
    }

    protected float p()
    {
        return 50F;
    }

    protected void q()
    {
label0:
        {
            MotionControlHelper.e().a(true);
            g = Globals.d();
            Object obj = getFragmentManager();
            if (obj != null)
            {
                e = (TopToolBar)((FragmentManager) (obj)).findFragmentById(0x7f0c00be);
            }
            if (e != null)
            {
                e.a(this);
                obj = new l();
                obj.a = true;
                obj.c = g.getString(n());
                e.a(((l) (obj)));
            }
            obj = ((com.cyberlink.youcammakeup.kernelctrl.c.a)g.i.b().get()).a();
            if (obj == null)
            {
                break label0;
            }
            obj = ((ArrayList) (obj)).iterator();
            com.cyberlink.youcammakeup.kernelctrl.c.b b1;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                b1 = (com.cyberlink.youcammakeup.kernelctrl.c.b)((WeakReference)((Iterator) (obj)).next()).get();
            } while (b1 == null || !(b1 instanceof ImageViewer));
            l = (ImageViewer)b1;
        }
        ArrayList arraylist;
label1:
        {
            n = f.findViewById(0x7f0c0660);
            o = (HorizontalGridView)f.findViewById(0x7f0c0663);
            p = f.findViewById(0x7f0c0662);
            D();
            E();
            F();
            a(DownloadUseUtils.a(getActivity()));
            a(SkuTemplateUtils.a(getActivity()));
            arraylist = new ArrayList();
            Object obj1 = StatusManager.j().d();
            if (obj1 != null)
            {
                obj1 = b(((i) (obj1))).iterator();
                do
                {
                    if (!((Iterator) (obj1)).hasNext())
                    {
                        break;
                    }
                    String s1 = (String)((Iterator) (obj1)).next();
                    if (PanelDataCenter.a().p(s1) != null)
                    {
                        arraylist.add(s1);
                    }
                } while (true);
            }
            if (arraylist.size() <= 0)
            {
                obj1 = i().iterator();
                do
                {
                    if (!((Iterator) (obj1)).hasNext())
                    {
                        break;
                    }
                    String s2 = (String)((Iterator) (obj1)).next();
                    if (PanelDataCenter.a().p(s2) != null)
                    {
                        arraylist.add(s2);
                    }
                } while (true);
            }
            if (arraylist.size() <= 0)
            {
                obj1 = PanelDataCenter.a().a(a());
                if (obj1 != null && ((List) (obj1)).size() > 0 && PanelDataCenter.a().p((String)((List) (obj1)).get(0)) != null)
                {
                    arraylist.add(((List) (obj1)).get(0));
                }
            }
            if (arraylist.size() > 0 || !E)
            {
                break label1;
            }
            obj1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(G, F).l().iterator();
            com.cyberlink.youcammakeup.database.more.i.e e1;
            do
            {
                if (!((Iterator) (obj1)).hasNext())
                {
                    break label1;
                }
                e1 = (com.cyberlink.youcammakeup.database.more.i.e)((Iterator) (obj1)).next();
            } while (e1 == null || PanelDataCenter.a().p(e1.a()) == null);
            arraylist.add(e1.a());
        }
        if (arraylist.size() > 0)
        {
            StatusManager.j().b(arraylist);
        } else
        {
            StatusManager.j().b(null);
        }
        StatusManager.j().a(0, 4, 0, 0, 0, 4, 4, 0);
        i = g.t();
        if (i != null)
        {
            i.a(this);
        }
        B();
        a(8);
        c(false);
        MotionControlHelper.e().B();
        D = false;
        com.cyberlink.youcammakeup.kernelctrl.j.a().a(false);
    }

    protected void r()
    {
        MotionControlHelper.e().a(true);
        StatusManager.j().b(null);
        if (e != null)
        {
            e.a(null);
        }
        g = null;
        f = null;
        i = null;
        if (h != null)
        {
            h.b(false);
        }
        if (m)
        {
            com.cyberlink.youcammakeup.kernelctrl.j.a().d();
        }
        a("Apply", Boolean.valueOf(false));
        D = false;
        l = null;
        MotionControlHelper.e().h();
    }

    protected void s()
    {
        StatusManager.j().a(this);
        GestureDetector gesturedetector = new GestureDetector(getActivity(), new android.view.GestureDetector.SimpleOnGestureListener() {

            final d a;

            public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f1, float f2)
            {
                if (Math.abs(f1) > Math.abs(f2))
                {
                    return false;
                }
                if (f2 < 0.0F)
                {
                    if (a.z() != 0)
                    {
                        a.b(true);
                        a.a(0);
                        a.c(true);
                        return true;
                    }
                } else
                if (a.z() == 0)
                {
                    a.b(false);
                    a.a(4);
                    a.c(false);
                    return true;
                }
                return true;
            }

            
            {
                a = d.this;
                super();
            }
        });
        o.setOnTouchListener(new android.view.View.OnTouchListener(gesturedetector) {

            final GestureDetector a;
            final d b;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                view = com.cyberlink.youcammakeup.widgetpool.panel.d.d.e(b);
                if (b.o() && !view.g(view.f()) && a.onTouchEvent(motionevent))
                {
                    motionevent.setAction(3);
                }
                return false;
            }

            
            {
                b = d.this;
                a = gesturedetector;
                super();
            }
        });
        n.addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener() {

            final d a;

            public void onLayoutChange(View view, int i1, int j1, int k1, int l1, int i2, int j2, 
                    int k2, int l2)
            {
                while (com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(a) == null || com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(a).isFinishing() || l2 - j2 == l1 - j1) 
                {
                    return;
                }
                com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(a).c(view.getHeight() + com.cyberlink.youcammakeup.widgetpool.panel.d.d.j(a).getHeight());
            }

            
            {
                a = d.this;
                super();
            }
        });
    }

    protected void t()
    {
        o.setOnTouchListener(null);
        StatusManager.j().b(this);
    }

    protected void u()
    {
        com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanelItemAdapter.DeletableItemPosition deletableitemposition;
        if (i == null || o == null)
        {
            return;
        }
        class _cls15
        {

            static final int a[];

            static 
            {
                a = new int[BeautyMode.values().length];
                try
                {
                    a[BeautyMode.j.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (com.cyberlink.youcammakeup.widgetpool.panel.d._cls15.a[a().ordinal()])
        {
        default:
            deletableitemposition = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanelItemAdapter.DeletableItemPosition.b;
            break;

        case 1: // '\001'
            break MISSING_BLOCK_LABEL_199;
        }
_L1:
        az az1;
        if (E && F != null && a() == BeautyMode.s)
        {
            az1 = new az(F, G);
        } else
        {
            az1 = null;
        }
        L = new com.cyberlink.youcammakeup.widgetpool.panel.d.c(getActivity(), a(), l(), false, deletableitemposition, az1);
        z = new BeautyToolPanelItemAdapter(getActivity(), a(), null, false, deletableitemposition, az1);
        z.a(new android.view.View.OnClickListener() {

            final d a;

            private void a(int i1, int j1, String s1)
            {
                if (i1 != j1) goto _L2; else goto _L1
_L1:
                if (s1 != null) goto _L4; else goto _L3
_L3:
                j1 = i1;
                if (i1 == com.cyberlink.youcammakeup.widgetpool.panel.d.d.k(a).getCount())
                {
                    j1 = i1 - 1;
                }
                s1 = com.cyberlink.youcammakeup.widgetpool.panel.d.d.k(a).a(j1).c;
_L8:
                StatusManager.j().b(s1);
                StatusManager.j().a(com.cyberlink.youcammakeup.widgetpool.panel.d.d.e(a).d(), false);
                com.cyberlink.youcammakeup.widgetpool.panel.d.d.k(a).d(j1);
_L6:
                return;
_L4:
                for (i1 = 0; i1 < com.cyberlink.youcammakeup.widgetpool.panel.d.d.k(a).getCount(); i1++)
                {
                    if (com.cyberlink.youcammakeup.widgetpool.panel.d.d.k(a).a(i1) != null && com.cyberlink.youcammakeup.widgetpool.panel.d.d.k(a).a(i1).c.equals(s1))
                    {
                        j1 = i1;
                        continue; /* Loop/switch isn't completed */
                    }
                }

                break; /* Loop/switch isn't completed */
_L2:
                if (i1 > j1)
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.d.d.k(a).d(i1 - 1);
                    return;
                }
                if (true) goto _L6; else goto _L5
_L5:
                j1 = 1;
                if (true) goto _L8; else goto _L7
_L7:
            }

            static void a(_cls18 _pcls18, String s1)
            {
                _pcls18.a(s1);
            }

            private void a(String s1)
            {
                String s2 = StatusManager.j().g();
                PanelDataCenter.a().a(s1, true);
                int i1 = com.cyberlink.youcammakeup.widgetpool.panel.d.d.k(a).c();
                int j1 = com.cyberlink.youcammakeup.widgetpool.panel.d.d.a(a, s1);
                com.cyberlink.youcammakeup.widgetpool.panel.d.d.k(a).a(a.a(), s2);
                a(i1, j1, null);
                if (!com.cyberlink.youcammakeup.widgetpool.panel.d.d.k(a).b())
                {
                    com.cyberlink.youcammakeup.utility.o.c();
                }
                com.cyberlink.youcammakeup.widgetpool.panel.d.d.k(a).notifyDataSetChanged();
            }

            public void onClick(View view)
            {
                PanelDataCenter paneldatacenter = PanelDataCenter.a();
                view = ((View) (view.getTag()));
                if (!(view instanceof p))
                {
                    return;
                }
                view = ((p)view).c;
                if (paneldatacenter.g(view))
                {
                    o o1 = Globals.d().i();
                    o1.c(a.getActivity());
                    o1.a(null, a.getResources().getString(0x7f070335));
                    o1.a(new y(true, true, true, true, a.getResources().getString(0x7f070366), a.getResources().getString(0x7f070365)));
                    o1.a(new com.cyberlink.youcammakeup.widgetpool.dialogs.w(this, o1, view) {

                        final o a;
                        final String b;
                        final _cls18 c;

                        public void a(boolean flag)
                        {
                            a.i(c.a.getActivity());
                            com.cyberlink.youcammakeup.widgetpool.panel.d._cls18.a(c, b);
                        }

                        public void b(boolean flag)
                        {
                            a.i(c.a.getActivity());
                        }

            
            {
                c = _pcls18;
                a = o1;
                b = s1;
                super();
            }
                    });
                    return;
                } else
                {
                    a(view);
                    return;
                }
            }

            
            {
                a = d.this;
                super();
            }
        });
        if (k() > 1)
        {
            o.setChoiceMode(2);
        } else
        {
            o.setChoiceMode(1);
        }
        o.setOnItemClickListener(new com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.p() {

            final d a;

            public void a(AdapterView adapterview, View view, int i1, long l1)
            {
                if (!com.cyberlink.youcammakeup.widgetpool.panel.d.d.l(a)) goto _L2; else goto _L1
_L1:
                return;
_L2:
                adapterview = com.cyberlink.youcammakeup.widgetpool.panel.d.d.e(a);
                if (adapterview != null && adapterview.b())
                {
                    com.cyberlink.youcammakeup.utility.o.c();
                    return;
                }
                if (i1 == 0 && adapterview.h()) goto _L1; else goto _L3
_L3:
                int j1 = adapterview.f();
                if (i1 != j1) goto _L5; else goto _L4
_L4:
                adapterview.d(i1);
                d.m(a).b();
                d.m(a).a(i1, true);
_L7:
                StatusManager.j().a(com.cyberlink.youcammakeup.widgetpool.panel.d.d.e(a).d(), false);
                view.post(new Runnable(this, view, adapterview, i1) {

                    final View a;
                    final com.cyberlink.youcammakeup.widgetpool.panel.d.c b;
                    final int c;
                    final _cls19 d;

                    public void run()
                    {
                        ((TemplateButton)a).a(false);
                        b.a(c, false);
                    }

            
            {
                d = _pcls19;
                a = view;
                b = c1;
                c = i1;
                super();
            }
                });
                return;
_L5:
                int k1 = a.k();
                if (adapterview.g(i1))
                {
                    if (k1 > 1)
                    {
                        adapterview.f(i1);
                        if (j1 >= 0 && adapterview.e() == 0)
                        {
                            adapterview.d(j1);
                            d.m(a).b();
                            d.m(a).a(j1, true);
                        }
                    }
                } else
                if (k1 > 1)
                {
                    if (adapterview.e() >= k1)
                    {
                        d.m(a).a(i1, false);
                        a.m();
                        return;
                    }
                    adapterview.e(i1);
                    if (j1 >= 0)
                    {
                        adapterview.f(j1);
                        d.m(a).a(j1, false);
                    }
                } else
                {
                    adapterview.d(i1);
                }
                if (true) goto _L7; else goto _L6
_L6:
            }

            
            {
                a = d.this;
                super();
            }
        });
        o.setOnItemLongClickListener(new com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.q() {

            final d a;
            private final android.content.DialogInterface.OnDismissListener b = new _cls1(this);

            public boolean a(AdapterView adapterview, View view, int i1, long l1)
            {
                adapterview = com.cyberlink.youcammakeup.widgetpool.panel.d.d.e(a);
                if (adapterview != null && !adapterview.b() && adapterview.c(i1))
                {
                    d.m(a).setChoiceMode(0);
                    adapterview.a(true);
                    if (d.m(a) != null)
                    {
                        com.cyberlink.youcammakeup.utility.o.a(a.getFragmentManager(), d.m(a), b);
                    }
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                a = d.this;
                super();
            }
        });
        return;
        deletableitemposition = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanelItemAdapter.DeletableItemPosition.a;
          goto _L1
    }

    protected void v()
    {
        u();
        o.setAdapter(L);
        a(StatusManager.j().f());
    }

    public void w()
    {
        if (h != null)
        {
            h.a(Boolean.valueOf(false));
        }
        if (e != null)
        {
            e.a(Boolean.valueOf(false));
        }
    }

    public void x()
    {
        com.cyberlink.youcammakeup.kernelctrl.j.a().h();
        StatusManager.j().y();
        MotionControlHelper.e().c(Boolean.valueOf(true));
        (new AsyncTask() {

            final d a;

            protected transient Void a(Void avoid[])
            {
                MotionControlHelper.e().q();
                MotionControlHelper.e().t();
                MotionControlHelper.e().r();
                MotionControlHelper.e().a(a.a(), true);
                MotionControlHelper.e().v();
                return null;
            }

            protected void a(Void void1)
            {
                StatusManager.j().a(Boolean.valueOf(true));
                if ((a.getActivity() instanceof EditViewActivity) && ah.b)
                {
                    ((EditViewActivity)a.getActivity()).b(false, true);
                }
                d.n(a);
                com.cyberlink.youcammakeup.widgetpool.panel.d.d.o(a);
                Globals.d(new Runnable(this) {

                    final _cls2 a;

                    public void run()
                    {
                        if (com.cyberlink.youcammakeup.widgetpool.panel.d.d.p(a.a) != null)
                        {
                            com.cyberlink.youcammakeup.widgetpool.panel.d.d.p(a.a).a(Boolean.valueOf(false));
                        }
                    }

            
            {
                a = _pcls2;
                super();
            }
                });
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            protected void onPostExecute(Object obj)
            {
                a((Void)obj);
            }

            
            {
                a = d.this;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void y()
    {
        long l1 = StatusManager.j().l();
        com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.DevelopSetting developsetting = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.e.a().a(Long.valueOf(l1), Boolean.valueOf(true));
        ViewEngine.a().a(l1, 1.0D, developsetting, null, new com.cyberlink.youcammakeup.kernelctrl.viewengine.a(l1) {

            final long a;
            final d b;

            public void a(com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskCancelType taskcanceltype, String s1, Object obj)
            {
                b.x();
            }

            public void a(com.cyberlink.youcammakeup.kernelctrl.viewengine.q q1, Object obj)
            {
                Object obj1;
                v v1;
                List list;
                if (com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(b).p())
                {
                    obj = com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(b).r();
                } else
                {
                    obj = StatusManager.j().f(a);
                }
                v1 = MotionControlHelper.e().M();
                list = com.cyberlink.youcammakeup.kernelctrl.j.a().g();
                obj1 = obj;
                if (obj == null)
                {
                    obj1 = new com.cyberlink.youcammakeup.kernelctrl.status.a(a, com.cyberlink.youcammakeup.widgetpool.panel.d.d.q(b).m.b, com.cyberlink.youcammakeup.widgetpool.panel.d.d.q(b).m.c, com.cyberlink.youcammakeup.widgetpool.panel.d.d.q(b).m.d, com.cyberlink.youcammakeup.kernelctrl.j.a(com.cyberlink.youcammakeup.widgetpool.panel.d.d.q(b).m.i), list, ((ar)list.get(com.cyberlink.youcammakeup.widgetpool.panel.d.d.q(b).m.j)).c.b(), ((ar)list.get(com.cyberlink.youcammakeup.widgetpool.panel.d.d.q(b).m.j)).c.c(), com.cyberlink.youcammakeup.widgetpool.panel.d.d.q(b).m.j, null, v1, "");
                }
                if (((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).f() == null)
                {
                    obj = new i();
                } else
                {
                    obj = new i(((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).f().g());
                }
                b.a(((i) (obj)));
                ((i) (obj)).a(false);
                StatusManager.j().a(((i) (obj)));
                v1 = MotionControlHelper.e().M();
                v1.a(((i) (obj)));
                obj = new com.cyberlink.youcammakeup.kernelctrl.status.a(a, q1.a().b(), q1.a().c(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).d, com.cyberlink.youcammakeup.kernelctrl.j.a(com.cyberlink.youcammakeup.widgetpool.panel.d.d.q(b).m.i), com.cyberlink.youcammakeup.kernelctrl.j.a().g(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).a(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).b(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).e, ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).c(), v1, ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).g());
                if (com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(b).p())
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(b).a(((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)));
                    com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(b).runOnUiThread(new Runnable(this) {

                        final _cls3 a;

                        public void run()
                        {
                            a.b.x();
                        }

            
            {
                a = _pcls3;
                super();
            }
                    });
                    return;
                } else
                {
                    StatusManager.j().a(((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)), q1.a(), new com.cyberlink.youcammakeup.d(this) {

                        final _cls3 b;

                        public void a()
                        {
                            b.b.x();
                        }

                        public void b()
                        {
                            b.b.x();
                        }

                        public void c()
                        {
                            b.b.x();
                        }

            
            {
                b = _pcls3;
                super();
            }
                    });
                    return;
                }
            }

            public void a(String s1, Object obj)
            {
                b.x();
            }

            
            {
                b = d.this;
                a = l1;
                super();
            }
        });
    }

    public int z()
    {
        if (u == null)
        {
            return 8;
        } else
        {
            return u.getVisibility();
        }
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/d/d$11$1

/* anonymous class */
    class _cls1
        implements com.cyberlink.youcammakeup.activity.c
    {

        final _cls11 a;

        public void a()
        {
            if (com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(a.a) != null)
            {
                com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(a.a).b(this);
                a.a.a(false);
                if (com.cyberlink.youcammakeup.widgetpool.panel.d.d.g(a.a) != null)
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.d.d.g(a.a).b(false);
                }
                if (com.cyberlink.youcammakeup.widgetpool.panel.d.d.f(a.a) != null)
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.d.d.f(a.a).a(true);
                    return;
                }
            }
        }

            
            {
                a = _pcls11;
                super();
            }
    }


    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/d/d$20$1

/* anonymous class */
    class _cls1
        implements android.content.DialogInterface.OnDismissListener
    {

        final _cls20 a;

        public void onDismiss(DialogInterface dialoginterface)
        {
            dialoginterface = com.cyberlink.youcammakeup.widgetpool.panel.d.d.e(a.a);
            if (dialoginterface != null && !Globals.d().i().a())
            {
                if (a.a.k() > 1)
                {
                    d.m(a.a).setChoiceMode(2);
                } else
                {
                    d.m(a.a).setChoiceMode(1);
                }
                dialoginterface.a(false);
            }
        }

            
            {
                a = _pcls20;
                super();
            }
    }

}
