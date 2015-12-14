// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.animation.Animator;
import android.app.Activity;
import android.app.Fragment;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.i;
import com.cyberlink.youcammakeup.clflurry.YMKMainFeaturesClicksEvent;
import com.cyberlink.youcammakeup.clflurry.YMKManualEvent;
import com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent;
import com.cyberlink.youcammakeup.clflurry.aa;
import com.cyberlink.youcammakeup.clflurry.ab;
import com.cyberlink.youcammakeup.clflurry.ac;
import com.cyberlink.youcammakeup.clflurry.ad;
import com.cyberlink.youcammakeup.clflurry.am;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.o;
import com.cyberlink.youcammakeup.clflurry.z;
import com.cyberlink.youcammakeup.flurry.UsageOfAccessoryFeatureEvent;
import com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent;
import com.cyberlink.youcammakeup.flurry.UsageOfCategoryEvent;
import com.cyberlink.youcammakeup.flurry.UsageOfEyeFeatureEvent;
import com.cyberlink.youcammakeup.flurry.UsageOfFaceFeatureEvent;
import com.cyberlink.youcammakeup.flurry.UsageOfHairFeatureEvent;
import com.cyberlink.youcammakeup.flurry.UsageOfMouthFeatureEvent;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.PanZoomViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.DownloadUseUtils;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.SkuTemplateUtils;
import com.cyberlink.youcammakeup.utility.ax;
import com.cyberlink.youcammakeup.utility.ch;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.LipstickToolPanel;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.h;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.j;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.n;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.q;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            c, NewIconCtrl, k, j, 
//            h, i

public class MakeupMenuBottomToolbar extends c
{

    private static final Map p = e();
    private FrameLayout d;
    private NewIconCtrl e;
    private View f;
    private View g;
    private View h;
    private View i;
    private View j;
    private View k;
    private HorizontalScrollView l;
    private ViewTreeObserver m;
    private boolean n;
    private boolean o;
    private android.view.ViewTreeObserver.OnScrollChangedListener q;

    public MakeupMenuBottomToolbar()
    {
        o = false;
        q = new android.view.ViewTreeObserver.OnScrollChangedListener() {

            final MakeupMenuBottomToolbar a;

            public void onScrollChanged()
            {
                MakeupMode makeupmode = StatusManager.j().r();
                for (BeautyMode beautymode = StatusManager.j().s(); makeupmode == MakeupMode.g || beautymode != null || !MakeupMenuBottomToolbar.c(a);)
                {
                    return;
                }

                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.a(a, true);
                a.c();
                StatusManager.j().a(MakeupMode.g);
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super();
            }
        };
    }

    static NewIconCtrl a(MakeupMenuBottomToolbar makeupmenubottomtoolbar)
    {
        return makeupmenubottomtoolbar.e;
    }

    static void a(MakeupMenuBottomToolbar makeupmenubottomtoolbar, MakeupMode makeupmode)
    {
        makeupmenubottomtoolbar.b(makeupmode);
    }

    static void a(MakeupMenuBottomToolbar makeupmenubottomtoolbar, boolean flag)
    {
        makeupmenubottomtoolbar.c(flag);
    }

    static void a(MakeupMenuBottomToolbar makeupmenubottomtoolbar, boolean flag, View view)
    {
        makeupmenubottomtoolbar.a(flag, view);
    }

    private void a(boolean flag, View view)
    {
        if (view != f)
        {
            f.setClickable(flag);
        }
        if (view != g)
        {
            g.setClickable(flag);
        }
        if (view != h)
        {
            h.setClickable(flag);
        }
        if (view != i)
        {
            i.setClickable(flag);
        }
        if (view != j)
        {
            j.setClickable(flag);
        }
        if (view != k)
        {
            k.setClickable(flag);
        }
        ViewGroup viewgroup = (ViewGroup)d.findViewById(0x7f0c072b);
        if (viewgroup != null)
        {
            for (int i1 = 0; i1 < viewgroup.getChildCount(); i1++)
            {
                View view1 = viewgroup.getChildAt(i1);
                if (view != view1)
                {
                    view1.setClickable(flag);
                }
            }

        }
    }

    private void b(MakeupMode makeupmode)
    {
        class _cls37
        {

            static final int a[];

            static 
            {
                a = new int[MakeupMode.values().length];
                try
                {
                    a[MakeupMode.c.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[MakeupMode.d.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[MakeupMode.e.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[MakeupMode.b.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[MakeupMode.f.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[MakeupMode.g.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[MakeupMode.a.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.cyberlink.youcammakeup.widgetpool.toolbar._cls37.a[makeupmode.ordinal()];
        JVM INSTR tableswitch 1 5: default 44
    //                   1 174
    //                   2 45
    //                   3 180
    //                   4 192
    //                   5 186;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L5:
        break MISSING_BLOCK_LABEL_192;
_L1:
        return;
_L3:
        int i1 = 0x7f03019c;
_L7:
        d.removeAllViews();
        getActivity().getLayoutInflater().inflate(i1, d, true);
        e.a();
        switch (com.cyberlink.youcammakeup.widgetpool.toolbar._cls37.a[makeupmode.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            n();
            l.requestChildRectangleOnScreen(h, new Rect(g.getLeft(), h.getTop(), h.getRight(), h.getBottom()), false);
            return;

        case 2: // '\002'
            m();
            l.requestChildRectangleOnScreen(h, new Rect(h.getLeft(), h.getTop(), h.getRight(), h.getBottom()), false);
            return;

        case 3: // '\003'
            o();
            l.requestChildRectangleOnScreen(h, new Rect(i.getLeft(), h.getTop(), h.getRight(), h.getBottom()), false);
            return;

        case 5: // '\005'
            p();
            l.requestChildRectangleOnScreen(k, new Rect(k.getLeft(), k.getTop(), k.getRight(), k.getBottom()), false);
            return;

        case 4: // '\004'
            q();
            l.requestChildRectangleOnScreen(j, new Rect(j.getLeft(), j.getTop(), j.getRight(), j.getBottom()), false);
            return;
        }
_L2:
        i1 = 0x7f03019d;
          goto _L7
_L4:
        i1 = 0x7f03019f;
          goto _L7
_L6:
        i1 = 0x7f03019b;
          goto _L7
        i1 = 0x7f03019e;
          goto _L7
    }

    static void b(MakeupMenuBottomToolbar makeupmenubottomtoolbar)
    {
        makeupmenubottomtoolbar.r();
    }

    static boolean b(MakeupMenuBottomToolbar makeupmenubottomtoolbar, boolean flag)
    {
        makeupmenubottomtoolbar.o = flag;
        return flag;
    }

    private void c(boolean flag)
    {
        a(flag, ((View) (null)));
    }

    static boolean c(MakeupMenuBottomToolbar makeupmenubottomtoolbar)
    {
        return makeupmenubottomtoolbar.n;
    }

    static boolean c(MakeupMenuBottomToolbar makeupmenubottomtoolbar, boolean flag)
    {
        makeupmenubottomtoolbar.n = flag;
        return flag;
    }

    private void d(boolean flag)
    {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof EditViewActivity))
        {
            ((EditViewActivity)activity).b(flag);
        }
    }

    static boolean d(MakeupMenuBottomToolbar makeupmenubottomtoolbar)
    {
        return makeupmenubottomtoolbar.o;
    }

    static FrameLayout e(MakeupMenuBottomToolbar makeupmenubottomtoolbar)
    {
        return makeupmenubottomtoolbar.d;
    }

    private static Map e()
    {
        HashMap hashmap = new HashMap();
        HashMap hashmap1 = new HashMap();
        hashmap1.put(BeautyMode.D, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.h);
        hashmap.put(MakeupMode.a, hashmap1);
        hashmap1 = new HashMap();
        hashmap1.put(BeautyMode.a, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.a);
        hashmap1.put(BeautyMode.f, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.e);
        hashmap1.put(BeautyMode.g, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.a);
        hashmap1.put(BeautyMode.h, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.b);
        hashmap1.put(BeautyMode.d, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.a);
        hashmap1.put(BeautyMode.b, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.a);
        hashmap1.put(BeautyMode.c, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.a);
        hashmap1.put(BeautyMode.e, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.c);
        hashmap1.put(BeautyMode.j, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.i);
        hashmap1.put(BeautyMode.k, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.i);
        hashmap.put(MakeupMode.c, hashmap1);
        hashmap1 = new HashMap();
        hashmap1.put(BeautyMode.l, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.k);
        hashmap1.put(BeautyMode.m, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.k);
        hashmap1.put(BeautyMode.n, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.k);
        hashmap1.put(BeautyMode.t, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.k);
        hashmap1.put(BeautyMode.s, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.d);
        hashmap1.put(BeautyMode.o, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.d);
        hashmap1.put(BeautyMode.u, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.d);
        hashmap1.put(BeautyMode.p, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.d);
        hashmap1.put(BeautyMode.q, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.d);
        hashmap1.put(BeautyMode.r, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.g);
        hashmap.put(MakeupMode.d, hashmap1);
        hashmap1 = new HashMap();
        hashmap1.put(BeautyMode.v, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.f);
        hashmap1.put(BeautyMode.w, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.f);
        hashmap.put(MakeupMode.e, hashmap1);
        hashmap1 = new HashMap();
        hashmap1.put(BeautyMode.x, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.j);
        hashmap1.put(BeautyMode.y, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.j);
        hashmap.put(MakeupMode.b, hashmap1);
        hashmap1 = new HashMap();
        hashmap1.put(BeautyMode.z, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.l);
        hashmap1.put(BeautyMode.A, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.l);
        hashmap1.put(BeautyMode.B, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.l);
        hashmap1.put(BeautyMode.C, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.l);
        hashmap.put(MakeupMode.f, hashmap1);
        return hashmap;
    }

    private void j()
    {
        e = new NewIconCtrl(getActivity().getWindow().getDecorView());
        View view = getView();
        d = (FrameLayout)view.findViewById(0x7f0c051a);
        l = (HorizontalScrollView)view.findViewById(0x7f0c0512);
        f = view.findViewById(0x7f0c0513);
        g = view.findViewById(0x7f0c0515);
        h = view.findViewById(0x7f0c0516);
        i = view.findViewById(0x7f0c0517);
        j = view.findViewById(0x7f0c0518);
        k = view.findViewById(0x7f0c0519);
        m = l.getViewTreeObserver();
    }

    private void k()
    {
        k k1 = new k(this);
        f.setOnTouchListener(k1);
        f.setOnClickListener(new android.view.View.OnClickListener() {

            final MakeupMenuBottomToolbar a;

            public void onClick(View view)
            {
                if (!StatusManager.j().E().booleanValue())
                {
                    return;
                } else
                {
                    com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.a(a).a(view);
                    com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.a(a, false);
                    StatusManager.j().a(Boolean.valueOf(false));
                    StatusManager.j().a(-1, -1, -1, -1, -1, -1, 4, -1);
                    a.c(new ch(this) {

                        final _cls40 a;

                        public void onAnimationEnd(Animator animator)
                        {
                            com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.a));
                            com.cyberlink.youcammakeup.flurry.a.a(new UsageOfCategoryEvent(MakeupMode.a));
                            com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.a));
                            com.cyberlink.youcammakeup.clflurry.b.a(new YMKMainFeaturesClicksEvent(com.cyberlink.youcammakeup.clflurry.YMKMainFeaturesClicksEvent.FeatureName.a));
                            com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.a));
                            a.a.d();
                            com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a.a);
                            StatusManager.j().a(Boolean.valueOf(true));
                        }

            
            {
                a = _pcls40;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super();
            }
        });
        g.setOnTouchListener(k1);
        g.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.i() {

            final MakeupMenuBottomToolbar a;

            public MakeupMode a()
            {
                return MakeupMode.c;
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        h.setOnTouchListener(k1);
        h.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.i() {

            final MakeupMenuBottomToolbar a;

            public MakeupMode a()
            {
                return MakeupMode.d;
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        i.setOnTouchListener(k1);
        i.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.i() {

            final MakeupMenuBottomToolbar a;

            public MakeupMode a()
            {
                return MakeupMode.e;
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        j.setOnTouchListener(k1);
        j.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.i() {

            final MakeupMenuBottomToolbar a;

            public MakeupMode a()
            {
                return MakeupMode.b;
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        k.setOnTouchListener(k1);
        k.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.i() {

            final MakeupMenuBottomToolbar a;

            public MakeupMode a()
            {
                return MakeupMode.f;
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        l.setOnTouchListener(k1);
        if (m != null && m.isAlive())
        {
            m.addOnScrollChangedListener(q);
        }
    }

    private void l()
    {
        i.setOnClickListener(null);
        h.setOnClickListener(null);
        g.setOnClickListener(null);
        j.setOnClickListener(null);
        k.setOnClickListener(null);
        f.setOnClickListener(null);
        ViewGroup viewgroup = (ViewGroup)d.findViewById(0x7f0c072b);
        if (viewgroup != null)
        {
            for (int i1 = 0; i1 < viewgroup.getChildCount(); i1++)
            {
                viewgroup.getChildAt(i1).setOnClickListener(null);
            }

        }
        if (m != null && m.isAlive())
        {
            m.removeOnScrollChangedListener(q);
        }
    }

    private void m()
    {
        com.cyberlink.youcammakeup.widgetpool.toolbar.j j1 = new com.cyberlink.youcammakeup.widgetpool.toolbar.j(this);
        d.findViewById(0x7f0c0730).setOnTouchListener(j1);
        View view = d.findViewById(0x7f0c0731);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfEyeFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfEyeFeatureEvent.FeatureName.a));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.l));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.l));
                com.cyberlink.youcammakeup.clflurry.b.a(new aa(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.l));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.l));
                StatusManager.j().a(BeautyMode.l);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
                n n1 = new n();
                ((BeautyToolPanel)n1).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.PreferColorMode.c);
                return n1;
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        view = d.findViewById(0x7f0c0732);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfEyeFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfEyeFeatureEvent.FeatureName.b));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.m));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.m));
                com.cyberlink.youcammakeup.clflurry.b.a(new aa(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.m));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.m));
                StatusManager.j().a(BeautyMode.m);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
                n n1 = new n();
                ((BeautyToolPanel)n1).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.PreferColorMode.c);
                return n1;
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        view = d.findViewById(0x7f0c0733);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfEyeFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfEyeFeatureEvent.FeatureName.c));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.n));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.n));
                com.cyberlink.youcammakeup.clflurry.b.a(new aa(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.n));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.n));
                StatusManager.j().a(BeautyMode.n);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
                BeautyToolPanel beautytoolpanel = new BeautyToolPanel();
                ((BeautyToolPanel)beautytoolpanel).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.PreferColorMode.a);
                return beautytoolpanel;
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        view = d.findViewById(0x7f0c0734);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfEyeFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfEyeFeatureEvent.FeatureName.d));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.o));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.o));
                com.cyberlink.youcammakeup.clflurry.b.a(new aa(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.o));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.o));
                StatusManager.j().a(BeautyMode.r);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
                h h1 = new h();
                ((BeautyToolPanel)h1).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.PreferColorMode.c);
                return h1;
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        view = d.findViewById(0x7f0c0735);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfEyeFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfEyeFeatureEvent.FeatureName.e));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.p));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.p));
                com.cyberlink.youcammakeup.clflurry.b.a(new aa(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.p));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.p));
                StatusManager.j().a(BeautyMode.s);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.f f1 = new com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.f();
                ((BeautyToolPanel)f1).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.PreferColorMode.d);
                return f1;
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        view = d.findViewById(0x7f0c0736);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfEyeFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfEyeFeatureEvent.FeatureName.f));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.q));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.q));
                com.cyberlink.youcammakeup.clflurry.b.a(new aa(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.q));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.q));
                StatusManager.j().a(BeautyMode.p);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
                return new com.cyberlink.youcammakeup.widgetpool.panel.a.a();
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        view = d.findViewById(0x7f0c0737);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfEyeFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfEyeFeatureEvent.FeatureName.g));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.r));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.r));
                com.cyberlink.youcammakeup.clflurry.b.a(new aa(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.r));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.r));
                StatusManager.j().a(BeautyMode.o);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
                return new com.cyberlink.youcammakeup.widgetpool.panel.a.a();
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        view = d.findViewById(0x7f0c073a);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfEyeFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfEyeFeatureEvent.FeatureName.h));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.u));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.s));
                com.cyberlink.youcammakeup.clflurry.b.a(new aa(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.s));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.s));
                StatusManager.j().a(BeautyMode.q);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
                return new com.cyberlink.youcammakeup.widgetpool.panel.b.a();
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        view = d.findViewById(0x7f0c0739);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfEyeFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfEyeFeatureEvent.FeatureName.j));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.t));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.t));
                com.cyberlink.youcammakeup.clflurry.b.a(new aa(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.t));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.t));
                StatusManager.j().a(BeautyMode.t);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
                BeautyToolPanel beautytoolpanel = new BeautyToolPanel();
                beautytoolpanel.a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.PreferColorMode.d);
                return beautytoolpanel;
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        view = d.findViewById(0x7f0c0738);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfEyeFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfEyeFeatureEvent.FeatureName.i));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.s));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.u));
                com.cyberlink.youcammakeup.clflurry.b.a(new aa(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.u));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.u));
                StatusManager.j().a(BeautyMode.u);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
                return new com.cyberlink.youcammakeup.widgetpool.panel.a.a();
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
    }

    private void n()
    {
        com.cyberlink.youcammakeup.widgetpool.toolbar.j j1 = new com.cyberlink.youcammakeup.widgetpool.toolbar.j(this);
        d.findViewById(0x7f0c0730).setOnTouchListener(j1);
        View view = d.findViewById(0x7f0c073d);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfFaceFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfFaceFeatureEvent.FeatureName.c));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.d));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.d));
                com.cyberlink.youcammakeup.clflurry.b.a(new ab(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.d));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.d));
                StatusManager.j().a(BeautyMode.a);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
                n n1 = new n();
                ((BeautyToolPanel)n1).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.PreferColorMode.c);
                return n1;
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        view = d.findViewById(0x7f0c0741);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfFaceFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfFaceFeatureEvent.FeatureName.e));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.f));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.f));
                com.cyberlink.youcammakeup.clflurry.b.a(new ab(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.f));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.f));
                StatusManager.j().a(BeautyMode.g);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
                return new com.cyberlink.youcammakeup.widgetpool.panel.a.a();
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        view = d.findViewById(0x7f0c0742);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfFaceFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfFaceFeatureEvent.FeatureName.f));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.g));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.g));
                com.cyberlink.youcammakeup.clflurry.b.a(new ab(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.g));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.g));
                StatusManager.j().a(BeautyMode.f);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
                return new com.cyberlink.youcammakeup.widgetpool.panel.a.a();
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        view = d.findViewById(0x7f0c0740);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfFaceFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfFaceFeatureEvent.FeatureName.d));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.e));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.e));
                com.cyberlink.youcammakeup.clflurry.b.a(new ab(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.e));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.e));
                StatusManager.j().a(BeautyMode.h);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
                return new com.cyberlink.youcammakeup.widgetpool.panel.a.a();
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        view = d.findViewById(0x7f0c073b);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfFaceFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfFaceFeatureEvent.FeatureName.a));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.b));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.b));
                com.cyberlink.youcammakeup.clflurry.b.a(new ab(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.b));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.b));
                StatusManager.j().a(BeautyMode.d);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
                return new com.cyberlink.youcammakeup.widgetpool.panel.a.a();
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        view = d.findViewById(0x7f0c073c);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfFaceFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfFaceFeatureEvent.FeatureName.b));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.c));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.c));
                com.cyberlink.youcammakeup.clflurry.b.a(new ab(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.c));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.c));
                StatusManager.j().a(BeautyMode.b);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
                BeautyToolPanel beautytoolpanel = new BeautyToolPanel();
                ((BeautyToolPanel)beautytoolpanel).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.PreferColorMode.c);
                return beautytoolpanel;
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        view = d.findViewById(0x7f0c0744);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfFaceFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfFaceFeatureEvent.FeatureName.h));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.i));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.i));
                com.cyberlink.youcammakeup.clflurry.b.a(new ab(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.i));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.i));
                StatusManager.j().a(BeautyMode.c);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
                return new com.cyberlink.youcammakeup.widgetpool.panel.a.a();
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        view = d.findViewById(0x7f0c0743);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfFaceFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfFaceFeatureEvent.FeatureName.g));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.h));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.h));
                com.cyberlink.youcammakeup.clflurry.b.a(new ab(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.h));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.h));
                StatusManager.j().a(BeautyMode.e);
                return new com.cyberlink.youcammakeup.widgetpool.panel.b.a();
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        view = d.findViewById(0x7f0c073e);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfFaceFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfFaceFeatureEvent.FeatureName.i));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.j));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.j));
                com.cyberlink.youcammakeup.clflurry.b.a(new ab(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.j));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.j));
                StatusManager.j().a(BeautyMode.j);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
                return new com.cyberlink.youcammakeup.widgetpool.panel.d.a();
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        view = d.findViewById(0x7f0c073f);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfFaceFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfFaceFeatureEvent.FeatureName.j));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.k));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.k));
                com.cyberlink.youcammakeup.clflurry.b.a(new ab(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.k));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.k));
                StatusManager.j().a(BeautyMode.k);
                return new com.cyberlink.youcammakeup.widgetpool.panel.d.f();
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        view.setVisibility(8);
    }

    private void o()
    {
        com.cyberlink.youcammakeup.widgetpool.toolbar.j j1 = new com.cyberlink.youcammakeup.widgetpool.toolbar.j(this);
        d.findViewById(0x7f0c0730).setOnTouchListener(j1);
        View view = d.findViewById(0x7f0c0746);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfMouthFeatureEvent(BeautyMode.v));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.v));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.v));
                com.cyberlink.youcammakeup.clflurry.b.a(new ad(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.v));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.v));
                StatusManager.j().a(BeautyMode.v);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
                LipstickToolPanel lipsticktoolpanel = new LipstickToolPanel();
                ((BeautyToolPanel)lipsticktoolpanel).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.PreferColorMode.c);
                return lipsticktoolpanel;
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        view = d.findViewById(0x7f0c0748);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfMouthFeatureEvent(BeautyMode.w));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.w));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.w));
                com.cyberlink.youcammakeup.clflurry.b.a(new ad(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.w));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.w));
                StatusManager.j().a(BeautyMode.w);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
                return new com.cyberlink.youcammakeup.widgetpool.panel.a.a();
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
    }

    private void p()
    {
        com.cyberlink.youcammakeup.widgetpool.toolbar.j j1 = new com.cyberlink.youcammakeup.widgetpool.toolbar.j(this);
        View view = d.findViewById(0x7f0c072c);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAccessoryFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfAccessoryFeatureEvent.FeatureName.d));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.z));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.z));
                com.cyberlink.youcammakeup.clflurry.b.a(new z(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.z));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.z));
                StatusManager.j().a(BeautyMode.z);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
                BeautyToolPanel beautytoolpanel = new BeautyToolPanel();
                ((BeautyToolPanel)beautytoolpanel).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.PreferColorMode.e);
                return beautytoolpanel;
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        view = d.findViewById(0x7f0c072d);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAccessoryFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfAccessoryFeatureEvent.FeatureName.b));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.A));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.A));
                com.cyberlink.youcammakeup.clflurry.b.a(new z(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.A));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.A));
                StatusManager.j().a(BeautyMode.A);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
                BeautyToolPanel beautytoolpanel = new BeautyToolPanel();
                ((BeautyToolPanel)beautytoolpanel).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.PreferColorMode.e);
                return beautytoolpanel;
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        view = d.findViewById(0x7f0c072e);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAccessoryFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfAccessoryFeatureEvent.FeatureName.c));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.B));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.B));
                com.cyberlink.youcammakeup.clflurry.b.a(new z(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.B));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.B));
                StatusManager.j().a(BeautyMode.B);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
                BeautyToolPanel beautytoolpanel = new BeautyToolPanel();
                ((BeautyToolPanel)beautytoolpanel).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.PreferColorMode.e);
                return beautytoolpanel;
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        view = d.findViewById(0x7f0c072f);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAccessoryFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfAccessoryFeatureEvent.FeatureName.a));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.C));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.C));
                com.cyberlink.youcammakeup.clflurry.b.a(new z(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.C));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.C));
                StatusManager.j().a(BeautyMode.C);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
                BeautyToolPanel beautytoolpanel = new BeautyToolPanel();
                ((BeautyToolPanel)beautytoolpanel).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.PreferColorMode.e);
                return beautytoolpanel;
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
    }

    private void q()
    {
        com.cyberlink.youcammakeup.widgetpool.toolbar.j j1 = new com.cyberlink.youcammakeup.widgetpool.toolbar.j(this);
        View view = d.findViewById(0x7f0c0745);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfHairFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfHairFeatureEvent.FeatureName.a));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.x));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.x));
                com.cyberlink.youcammakeup.clflurry.b.a(new ac(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.x));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.x));
                StatusManager.j().a(BeautyMode.x);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
                return new q();
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
        view = d.findViewById(0x7f0c0747);
        view.setOnTouchListener(j1);
        view.setOnClickListener(new com.cyberlink.youcammakeup.widgetpool.toolbar.h() {

            final MakeupMenuBottomToolbar a;

            public Fragment a()
            {
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfHairFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfHairFeatureEvent.FeatureName.b));
                com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.D));
                com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.y));
                com.cyberlink.youcammakeup.clflurry.b.a(new ac(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.y));
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.y));
                StatusManager.j().a(BeautyMode.y);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
                return new j();
            }

            
            {
                a = MakeupMenuBottomToolbar.this;
                super(MakeupMenuBottomToolbar.this);
            }
        });
    }

    private void r()
    {
label0:
        {
            EditViewActivity editviewactivity = (EditViewActivity)getActivity();
            if (editviewactivity != null)
            {
                if (((EditViewActivity)editviewactivity).ac() != 0)
                {
                    break label0;
                }
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKManualEvent(com.cyberlink.youcammakeup.clflurry.YMKManualEvent.HintButton.a, com.cyberlink.youcammakeup.clflurry.YMKManualEvent.Operation.a));
            }
            return;
        }
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKManualEvent(com.cyberlink.youcammakeup.clflurry.YMKManualEvent.HintButton.b, com.cyberlink.youcammakeup.clflurry.YMKManualEvent.Operation.a));
    }

    public void a()
    {
        Object obj = (EditViewActivity)getActivity();
        if (obj != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj1;
        com.cyberlink.youcammakeup.utility.DownloadUseUtils.UseTemplate usetemplate = DownloadUseUtils.a(getActivity());
        if (com.cyberlink.youcammakeup.widgetpool.toolbar.c.a(getActivity()))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (usetemplate != null && usetemplate.makeupMode == MakeupMode.f && usetemplate.beautyMode == BeautyMode.D)
        {
            usetemplate.beautyMode = PanelDataCenter.a().p(usetemplate.typeGUID).b();
        }
        com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl skutryiturl;
        if (StatusManager.j().s() == BeautyMode.D)
        {
            skutryiturl = SkuTemplateUtils.a(getActivity());
        } else
        {
            skutryiturl = null;
        }
        obj1 = StatusManager.j().f(StatusManager.j().l());
        if (usetemplate == null && skutryiturl == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj1 == null || ((a) (obj1)).e == -2)
        {
            ((EditViewActivity) (obj)).a(new i(((EditViewActivity) (obj)), usetemplate, skutryiturl) {

                final EditViewActivity a;
                final com.cyberlink.youcammakeup.utility.DownloadUseUtils.UseTemplate b;
                final com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl c;
                final MakeupMenuBottomToolbar d;

                public void a(a a1)
                {
                    a.b(this);
                    if (a1 == null)
                    {
                        return;
                    }
                    if (b != null)
                    {
                        d.b(b.makeupMode, b.beautyMode);
                        return;
                    } else
                    {
                        d.b(SkuTemplateUtils.g(c.type), SkuTemplateUtils.h(c.type));
                        return;
                    }
                }

            
            {
                d = MakeupMenuBottomToolbar.this;
                a = editviewactivity;
                b = usetemplate;
                c = skutryiturl;
                super();
            }
            });
            return;
        }
        obj = StatusManager.j().r();
        obj1 = StatusManager.j().s();
        if (usetemplate != null)
        {
            if (obj != usetemplate.makeupMode || usetemplate.beautyMode != obj1)
            {
                b(usetemplate.makeupMode, usetemplate.beautyMode);
                return;
            }
        } else
        {
            MakeupMode makeupmode = SkuTemplateUtils.g(skutryiturl.type);
            BeautyMode beautymode = SkuTemplateUtils.h(skutryiturl.type);
            if (obj != makeupmode || obj1 != beautymode)
            {
                b(SkuTemplateUtils.g(skutryiturl.type), SkuTemplateUtils.h(skutryiturl.type));
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (obj1 == null || ((a) (obj1)).e == -2)
        {
            ((EditViewActivity) (obj)).a(new i(((EditViewActivity) (obj))) {

                final EditViewActivity a;
                final MakeupMenuBottomToolbar b;

                public void a(a a1)
                {
                    a.b(this);
                    while (a1 == null || StatusManager.j().P()) 
                    {
                        return;
                    }
                    b.d();
                }

            
            {
                b = MakeupMenuBottomToolbar.this;
                a = editviewactivity;
                super();
            }
            });
            return;
        }
        if (!StatusManager.j().P())
        {
            d();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void a(MakeupMode makeupmode)
    {
        boolean flag;
        if (makeupmode != MakeupMode.a)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            c(true);
            b(((ch) (null)));
            a(false);
        } else
        {
            c(false);
            a(true);
        }
        if (makeupmode != MakeupMode.g && flag)
        {
            b(makeupmode);
            d.setVisibility(0);
            getActivity().findViewById(0x7f0c00cb).setVisibility(4);
            return;
        } else
        {
            d.setVisibility(8);
            d.removeAllViews();
            getActivity().findViewById(0x7f0c00cb).setVisibility(0);
            return;
        }
    }

    public void b()
    {
        i = null;
        h = null;
        g = null;
        f = null;
        j = null;
        k = null;
        l = null;
        m = null;
        d.removeAllViews();
        d = null;
    }

    public void b(MakeupMode makeupmode, BeautyMode beautymode)
    {
        c(false);
        d(false);
        MakeupMode makeupmode1 = StatusManager.j().r();
        BeautyMode beautymode1 = StatusManager.j().s();
        if (makeupmode == MakeupMode.a)
        {
            if (makeupmode1 != MakeupMode.a)
            {
                StatusManager.j().a(-1, -1, -1, -1, -1, 4, 4, -1);
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.a));
                d();
            }
        } else
        if (makeupmode == MakeupMode.b)
        {
            (new com.cyberlink.youcammakeup.widgetpool.toolbar.h(beautymode, beautymode1, makeupmode) {

                final BeautyMode a;
                final BeautyMode b;
                final MakeupMode c;
                final MakeupMenuBottomToolbar d;

                public Fragment a()
                {
                    Object obj;
                    if (a == BeautyMode.x && b != BeautyMode.x)
                    {
                        obj = new q();
                        StatusManager.j().a(BeautyMode.x);
                        com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.x));
                    } else
                    if (a == BeautyMode.y && b != BeautyMode.y)
                    {
                        obj = new j();
                        StatusManager.j().a(BeautyMode.y);
                        com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.y));
                    } else
                    {
                        obj = null;
                    }
                    if (obj != null)
                    {
                        StatusManager.j().a(c, false);
                    }
                    return ((Fragment) (obj));
                }

            
            {
                d = MakeupMenuBottomToolbar.this;
                a = beautymode;
                b = beautymode1;
                c = makeupmode;
                super(MakeupMenuBottomToolbar.this);
            }
            }).onClick(null);
        } else
        if (makeupmode == MakeupMode.f)
        {
            (new com.cyberlink.youcammakeup.widgetpool.toolbar.h(beautymode, beautymode1, makeupmode) {

                final BeautyMode a;
                final BeautyMode b;
                final MakeupMode c;
                final MakeupMenuBottomToolbar d;

                public Fragment a()
                {
                    BeautyToolPanel beautytoolpanel = new BeautyToolPanel();
                    ((BeautyToolPanel)beautytoolpanel).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.PreferColorMode.e);
                    if (a == BeautyMode.z && b != BeautyMode.z)
                    {
                        com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAccessoryFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfAccessoryFeatureEvent.FeatureName.d));
                        com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.z));
                        com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.z));
                        com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.z));
                        com.cyberlink.youcammakeup.clflurry.b.a(new z(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.z));
                        StatusManager.j().a(BeautyMode.z);
                    } else
                    if (a == BeautyMode.A && b != BeautyMode.A)
                    {
                        com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAccessoryFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfAccessoryFeatureEvent.FeatureName.b));
                        com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.A));
                        com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.A));
                        com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.A));
                        com.cyberlink.youcammakeup.clflurry.b.a(new z(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.A));
                        StatusManager.j().a(BeautyMode.A);
                    } else
                    if (a == BeautyMode.B && b != BeautyMode.B)
                    {
                        com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAccessoryFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfAccessoryFeatureEvent.FeatureName.c));
                        com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.B));
                        com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.B));
                        com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.B));
                        com.cyberlink.youcammakeup.clflurry.b.a(new z(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.B));
                        StatusManager.j().a(BeautyMode.B);
                    } else
                    if (a == BeautyMode.C && b != BeautyMode.C)
                    {
                        com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAccessoryFeatureEvent(com.cyberlink.youcammakeup.flurry.UsageOfAccessoryFeatureEvent.FeatureName.a));
                        com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent.FeatureName.C));
                        com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.C));
                        com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.C));
                        com.cyberlink.youcammakeup.clflurry.b.a(new z(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.C));
                        StatusManager.j().a(BeautyMode.C);
                    } else
                    {
                        beautytoolpanel = null;
                    }
                    if (beautytoolpanel != null)
                    {
                        StatusManager.j().a(c, false);
                    }
                    return beautytoolpanel;
                }

            
            {
                d = MakeupMenuBottomToolbar.this;
                a = beautymode;
                b = beautymode1;
                c = makeupmode;
                super(MakeupMenuBottomToolbar.this);
            }
            }).onClick(null);
        } else
        if (beautymode == BeautyMode.j || beautymode == BeautyMode.k)
        {
            (new com.cyberlink.youcammakeup.widgetpool.toolbar.h(beautymode, beautymode1, makeupmode) {

                final BeautyMode a;
                final BeautyMode b;
                final MakeupMode c;
                final MakeupMenuBottomToolbar d;

                public Fragment a()
                {
                    Object obj1 = null;
                    if (a != BeautyMode.j || b == BeautyMode.j) goto _L2; else goto _L1
_L1:
                    Object obj;
                    obj = new com.cyberlink.youcammakeup.widgetpool.panel.d.a();
                    StatusManager.j().a(BeautyMode.j);
                    com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.j));
_L4:
                    if (obj != null)
                    {
                        StatusManager.j().a(c, false);
                    }
                    return ((Fragment) (obj));
_L2:
                    obj = obj1;
                    if (a == BeautyMode.k)
                    {
                        obj = obj1;
                        if (b != BeautyMode.k)
                        {
                            obj = new com.cyberlink.youcammakeup.widgetpool.panel.d.f();
                            StatusManager.j().a(BeautyMode.k);
                            com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.k));
                        }
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

            
            {
                d = MakeupMenuBottomToolbar.this;
                a = beautymode;
                b = beautymode1;
                c = makeupmode;
                super(MakeupMenuBottomToolbar.this);
            }
            }).onClick(null);
        } else
        {
            (new com.cyberlink.youcammakeup.widgetpool.toolbar.h(beautymode, beautymode1, makeupmode) {

                final BeautyMode a;
                final BeautyMode b;
                final MakeupMode c;
                final MakeupMenuBottomToolbar d;

                public Fragment a()
                {
                    Object obj1 = null;
                    if (a != BeautyMode.n || b == BeautyMode.n) goto _L2; else goto _L1
_L1:
                    Object obj;
                    StatusManager.j().a(BeautyMode.n);
                    obj = new BeautyToolPanel();
                    ((BeautyToolPanel) (obj)).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.PreferColorMode.a);
                    com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.n));
_L4:
                    if (obj != null)
                    {
                        StatusManager.j().a(c, false);
                    }
                    return ((Fragment) (obj));
_L2:
                    if (a == BeautyMode.m && b != BeautyMode.m)
                    {
                        StatusManager.j().a(BeautyMode.m);
                        obj = new n();
                        ((BeautyToolPanel) (obj)).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.PreferColorMode.c);
                        com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.m));
                    } else
                    if (a == BeautyMode.l && b != BeautyMode.l)
                    {
                        StatusManager.j().a(BeautyMode.l);
                        obj = new n();
                        ((BeautyToolPanel) (obj)).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.PreferColorMode.c);
                        com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.l));
                    } else
                    if (a == BeautyMode.r && b != BeautyMode.r)
                    {
                        StatusManager.j().a(BeautyMode.r);
                        obj = new h();
                        ((BeautyToolPanel) (obj)).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.PreferColorMode.c);
                        com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.o));
                    } else
                    if (a == BeautyMode.s && b != BeautyMode.s)
                    {
                        StatusManager.j().a(BeautyMode.s);
                        obj = new com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.f();
                        ((BeautyToolPanel) (obj)).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.PreferColorMode.d);
                        com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.p));
                    } else
                    if (a == BeautyMode.a && b != BeautyMode.a)
                    {
                        StatusManager.j().a(BeautyMode.a);
                        obj = new n();
                        ((BeautyToolPanel) (obj)).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.PreferColorMode.c);
                        com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.d));
                    } else
                    if (a == BeautyMode.t && b != BeautyMode.t)
                    {
                        StatusManager.j().a(BeautyMode.t);
                        obj = new BeautyToolPanel();
                        ((BeautyToolPanel) (obj)).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.PreferColorMode.d);
                        com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.t));
                    } else
                    if (a == BeautyMode.v && b != BeautyMode.v)
                    {
                        StatusManager.j().a(BeautyMode.v);
                        obj = new LipstickToolPanel();
                        ((BeautyToolPanel) (obj)).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.PreferColorMode.c);
                        com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.v));
                    } else
                    {
                        obj = obj1;
                        if (a == BeautyMode.b)
                        {
                            obj = obj1;
                            if (b != BeautyMode.b)
                            {
                                StatusManager.j().a(BeautyMode.b);
                                obj = new BeautyToolPanel();
                                ((BeautyToolPanel) (obj)).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.PreferColorMode.c);
                                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.c));
                            }
                        }
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

            
            {
                d = MakeupMenuBottomToolbar.this;
                a = beautymode;
                b = beautymode1;
                c = makeupmode;
                super(MakeupMenuBottomToolbar.this);
            }
            }).onClick(null);
        }
_L7:
        com.cyberlink.youcammakeup.widgetpool.toolbar._cls37.a[makeupmode.ordinal()];
        JVM INSTR tableswitch 1 7: default 120
    //                   1 244
    //                   2 244
    //                   3 244
    //                   4 244
    //                   5 244
    //                   6 120
    //                   7 262;
           goto _L1 _L2 _L2 _L2 _L2 _L2 _L1 _L3
_L1:
        if (YMKSavingPageEvent.f())
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.PageType.b));
        }
_L5:
        return;
_L2:
        getActivity().findViewById(0x7f0c00cb).setVisibility(8);
          goto _L1
_L3:
        if (!YMKSavingPageEvent.e()) goto _L5; else goto _L4
_L4:
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.PageType.a));
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void b(boolean flag)
    {
        if (getActivity() == null)
        {
            return;
        } else
        {
            Object obj = (ImageViewer)getActivity().findViewById(0x7f0c0720);
            ((PanZoomViewer)obj).u();
            f f1 = new f();
            f1.a = true;
            ((ImageViewer) (obj)).b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c, f1);
            obj = getActivity().findViewById(0x7f0c00c9);
            ((View) (obj)).setVisibility(0);
            ((View) (obj)).animate().alpha(1.0F).setDuration(300L).start();
            c(true);
            ((EditViewActivity)getActivity()).o();
            return;
        }
    }

    public void c()
    {
        f.setSelected(false);
        g.setSelected(false);
        h.setSelected(false);
        i.setSelected(false);
        j.setSelected(false);
        k.setSelected(false);
    }

    public void d()
    {
        if (YMKSavingPageEvent.e())
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.PageType.a));
        }
        c();
        d.setVisibility(8);
        StatusManager.j().a(MakeupMode.a);
    }

    protected int f()
    {
        return 0x7f0300e5;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        j();
        k();
    }

    public void onDestroyView()
    {
        l();
        b();
        super.onDestroyView();
    }

    public void onStart()
    {
        super.onStart();
    }

}
