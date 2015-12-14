// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.database.g;
import com.cyberlink.youcammakeup.jniproxy.y;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierTaskInfo;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.e;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.featurepoints.b;
import com.cyberlink.youcammakeup.kernelctrl.j;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.PanZoomViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q;
import com.cyberlink.youcammakeup.kernelctrl.status.ImageStateChangedEvent;
import com.cyberlink.youcammakeup.kernelctrl.status.SessionState;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.kernelctrl.status.aq;
import com.cyberlink.youcammakeup.kernelctrl.status.d;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.i;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.pf.common.utility.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FineTuneToolBar extends Fragment
{

    private static final Map n = r();
    private View a;
    private View b;
    private View c;
    private View d;
    private View e;
    private View f;
    private View g;
    private View h;
    private View i;
    private boolean j;
    private boolean k;
    private b l;
    private ImageViewer m;
    private android.view.View.OnClickListener o;
    private android.view.View.OnClickListener p;
    private android.view.View.OnClickListener q;
    private android.view.View.OnClickListener r;
    private android.view.View.OnClickListener s;
    private android.view.View.OnClickListener t;
    private android.view.View.OnClickListener u;
    private android.view.View.OnClickListener v;

    public FineTuneToolBar()
    {
        j = false;
        k = false;
        o = new android.view.View.OnClickListener() {

            final FineTuneToolBar a;

            public void onClick(View view)
            {
                a.l();
            }

            
            {
                a = FineTuneToolBar.this;
                super();
            }
        };
        p = new android.view.View.OnClickListener() {

            final FineTuneToolBar a;

            public void onClick(View view)
            {
                if (com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.a(a))
                {
                    a.j();
                    return;
                } else
                {
                    a.l();
                    return;
                }
            }

            
            {
                a = FineTuneToolBar.this;
                super();
            }
        };
        q = new android.view.View.OnClickListener() {

            final FineTuneToolBar a;

            public void onClick(View view)
            {
                a.c();
                com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.b(a);
            }

            
            {
                a = FineTuneToolBar.this;
                super();
            }
        };
        r = new android.view.View.OnClickListener() {

            final FineTuneToolBar a;

            public void onClick(View view)
            {
                a.d();
                FineTuneToolBar.c(a);
            }

            
            {
                a = FineTuneToolBar.this;
                super();
            }
        };
        s = new android.view.View.OnClickListener() {

            final FineTuneToolBar a;

            public void onClick(View view)
            {
                a.e();
                com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.d(a);
            }

            
            {
                a = FineTuneToolBar.this;
                super();
            }
        };
        t = new android.view.View.OnClickListener() {

            final FineTuneToolBar a;

            public void onClick(View view)
            {
                a.f();
                com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.e(a);
            }

            
            {
                a = FineTuneToolBar.this;
                super();
            }
        };
        u = new android.view.View.OnClickListener() {

            final FineTuneToolBar a;

            public void onClick(View view)
            {
                StatusManager.j().a(Boolean.valueOf(false));
                com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.a(a, (ImageViewer)a.getActivity().findViewById(0x7f0c0720));
                long l1 = StatusManager.j().l();
                view = StatusManager.j().j(l1);
                if (!view.h())
                {
                    StatusManager.j().a(Boolean.valueOf(true));
                    return;
                } else
                {
                    FineTuneToolBar.f(a);
                    (new aq(view, new com.cyberlink.youcammakeup.e(this, view) {

                        final d a;
                        final _cls8 b;

                        public void a(ImageStateChangedEvent imagestatechangedevent)
                        {
                            if (imagestatechangedevent.c().a().e != imagestatechangedevent.b().a().e)
                            {
                                StatusManager.j().N();
                            }
                            StatusManager.j().y();
                            imagestatechangedevent = a.e();
                            if (imagestatechangedevent != null)
                            {
                                Object obj = imagestatechangedevent.f();
                                long l1;
                                if (obj != null && ((v) (obj)).h() != null)
                                {
                                    MotionControlHelper.e().a(((v) (obj)).h(), false);
                                    Globals.d().t().O();
                                } else
                                {
                                    MotionControlHelper.e().a(null, false);
                                }
                            }
                            if (com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.g(b.a) != null)
                            {
                                com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.g(b.a).k();
                            }
                            if (imagestatechangedevent != null)
                            {
                                obj = imagestatechangedevent.f();
                                if (obj != null && ((v) (obj)).f() != null)
                                {
                                    BeautifierEditCenter.a().a(((v) (obj)).f());
                                } else
                                {
                                    BeautifierEditCenter.a().a(null);
                                }
                                obj = com.cyberlink.youcammakeup.kernelctrl.j.a().g();
                                if (com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.g(b.a) != null && com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.g(b.a).m != null && com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.g(b.a).m.i != null && obj != null && ((List) (obj)).get(com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.g(b.a).m.j) != null)
                                {
                                    BeautifierEditCenter.a().a(((ar)com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.g(b.a).m.i.get(com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.g(b.a).m.j)).b, ((ar)((List) (obj)).get(com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.g(b.a).m.j)).c, false, new BeautifierTaskInfo(false));
                                }
                                if (imagestatechangedevent.f() == null)
                                {
                                    imagestatechangedevent = new com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i();
                                } else
                                {
                                    imagestatechangedevent = imagestatechangedevent.f().g();
                                }
                                StatusManager.j().a(imagestatechangedevent);
                            }
                            MotionControlHelper.e().l();
                            l1 = StatusManager.j().l();
                            imagestatechangedevent = StatusManager.j().j(l1);
                            com.cyberlink.youcammakeup.kernelctrl.j.a().a(imagestatechangedevent);
                            FineTuneToolBar.h(b.a);
                            StatusManager.j().a(Boolean.valueOf(true));
                        }

                        public volatile void a(Object obj)
                        {
                            a((ImageStateChangedEvent)obj);
                        }

                        public void a(Void void1)
                        {
                            StatusManager.j().a(Boolean.valueOf(true));
                            FineTuneToolBar.h(b.a);
                        }

                        public void b(Object obj)
                        {
                            a((Void)obj);
                        }

                        public void b(Void void1)
                        {
                            StatusManager.j().a(Boolean.valueOf(true));
                            FineTuneToolBar.h(b.a);
                        }

                        public void c(Object obj)
                        {
                            b((Void)obj);
                        }

            
            {
                b = _pcls8;
                a = d1;
                super();
            }
                    })).executeOnExecutor(view.c(), new Void[0]);
                    return;
                }
            }

            
            {
                a = FineTuneToolBar.this;
                super();
            }
        };
        v = new android.view.View.OnClickListener() {

            final FineTuneToolBar a;

            public void onClick(View view)
            {
                StatusManager.j().a(Boolean.valueOf(false));
                com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.a(a, (ImageViewer)a.getActivity().findViewById(0x7f0c0720));
                long l1 = StatusManager.j().l();
                view = StatusManager.j().j(l1);
                if (!view.j())
                {
                    StatusManager.j().a(Boolean.valueOf(true));
                    return;
                } else
                {
                    FineTuneToolBar.f(a);
                    (new com.cyberlink.youcammakeup.kernelctrl.status.b(view, new com.cyberlink.youcammakeup.e(this, view) {

                        final d a;
                        final _cls9 b;

                        public void a(ImageStateChangedEvent imagestatechangedevent)
                        {
                            if (imagestatechangedevent.c().a().e != imagestatechangedevent.b().a().e)
                            {
                                StatusManager.j().N();
                            }
                            StatusManager.j().y();
                            imagestatechangedevent = a.e();
                            if (imagestatechangedevent != null)
                            {
                                Object obj = imagestatechangedevent.f();
                                long l1;
                                if (obj != null && ((v) (obj)).h() != null)
                                {
                                    MotionControlHelper.e().a(((v) (obj)).h(), false);
                                    Globals.d().t().O();
                                } else
                                {
                                    MotionControlHelper.e().a(null, false);
                                }
                            }
                            if (com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.g(b.a) != null)
                            {
                                com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.g(b.a).k();
                            }
                            if (imagestatechangedevent != null)
                            {
                                obj = imagestatechangedevent.f();
                                if (obj != null)
                                {
                                    BeautifierEditCenter.a().a(((v) (obj)).f());
                                } else
                                {
                                    BeautifierEditCenter.a().a(null);
                                }
                                obj = com.cyberlink.youcammakeup.kernelctrl.j.a().g();
                                if (com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.g(b.a) != null && com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.g(b.a).m != null && com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.g(b.a).m.i != null && obj != null && ((List) (obj)).get(com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.g(b.a).m.j) != null)
                                {
                                    BeautifierEditCenter.a().a(((ar)com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.g(b.a).m.i.get(com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.g(b.a).m.j)).b, ((ar)((List) (obj)).get(com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.g(b.a).m.j)).c, false, new BeautifierTaskInfo(false));
                                }
                                if (imagestatechangedevent.f() == null)
                                {
                                    imagestatechangedevent = new com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i();
                                } else
                                {
                                    imagestatechangedevent = imagestatechangedevent.f().g();
                                }
                                StatusManager.j().a(imagestatechangedevent);
                            }
                            MotionControlHelper.e().l();
                            l1 = StatusManager.j().l();
                            imagestatechangedevent = StatusManager.j().j(l1);
                            com.cyberlink.youcammakeup.kernelctrl.j.a().a(imagestatechangedevent);
                            FineTuneToolBar.h(b.a);
                            StatusManager.j().a(Boolean.valueOf(true));
                        }

                        public volatile void a(Object obj)
                        {
                            a((ImageStateChangedEvent)obj);
                        }

                        public void a(Void void1)
                        {
                            StatusManager.j().a(Boolean.valueOf(true));
                            FineTuneToolBar.h(b.a);
                        }

                        public void b(Object obj)
                        {
                            a((Void)obj);
                        }

                        public void b(Void void1)
                        {
                            StatusManager.j().a(Boolean.valueOf(true));
                            FineTuneToolBar.h(b.a);
                        }

                        public void c(Object obj)
                        {
                            b((Void)obj);
                        }

            
            {
                b = _pcls9;
                a = d1;
                super();
            }
                    })).executeOnExecutor(view.c(), new Void[0]);
                    return;
                }
            }

            
            {
                a = FineTuneToolBar.this;
                super();
            }
        };
    }

    private boolean A()
    {
        long l1 = StatusManager.j().l();
        d d1 = StatusManager.j().j(l1);
        return d1.h() || d1.j();
    }

    private void B()
    {
        b.setOnClickListener(null);
        c.setOnClickListener(null);
        d.setOnClickListener(null);
        e.setOnClickListener(null);
        f.setOnClickListener(null);
        g.setOnClickListener(null);
        h.setOnClickListener(null);
        i.setOnClickListener(null);
    }

    private void C()
    {
        Globals.d().i().b(Globals.d().t());
    }

    private void D()
    {
        Globals.d().i().h(Globals.d().t());
    }

    private void E()
    {
        StatusManager.j().y();
        MotionControlHelper.e().c(Boolean.valueOf(true));
        D();
        l();
    }

    private void F()
    {
        EditViewActivity editviewactivity = Globals.d().t();
        editviewactivity.V();
        ImageViewer imageviewer = (ImageViewer)getActivity().findViewById(0x7f0c0720);
        if (imageviewer != null)
        {
            imageviewer.q();
        }
        if (StatusManager.j().o() == "editView" && editviewactivity != null)
        {
            editviewactivity.z();
        }
    }

    public static com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets a(MakeupMode makeupmode, BeautyMode beautymode)
    {
        com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets featuresets = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.h;
        Iterator iterator = ((Map)n.get(makeupmode)).entrySet().iterator();
        makeupmode = featuresets;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (((BeautyMode)entry.getKey()).equals(beautymode))
            {
                makeupmode = (com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets)entry.getValue();
            }
        } while (true);
        return makeupmode;
    }

    static ImageViewer a(FineTuneToolBar finetunetoolbar, ImageViewer imageviewer)
    {
        finetunetoolbar.m = imageviewer;
        return imageviewer;
    }

    private void a(d d1)
    {
        if (d1 != null && d1.e() != null)
        {
            if (d1.e().f() != null && d1.e().f().f() != null)
            {
                BeautifierEditCenter.a().a(d1.e().f().f());
            } else
            {
                BeautifierEditCenter.a().a(null);
            }
            m = (ImageViewer)getActivity().findViewById(0x7f0c0720);
            BeautifierEditCenter.a().a(((ar)m.m.i.get(m.m.j)).b, ((ar)com.cyberlink.youcammakeup.kernelctrl.j.a().g().get(m.m.j)).c, false, new BeautifierTaskInfo(false));
        }
    }

    static boolean a(FineTuneToolBar finetunetoolbar)
    {
        return finetunetoolbar.A();
    }

    static b b(FineTuneToolBar finetunetoolbar)
    {
        return finetunetoolbar.w();
    }

    private void b(d d1)
    {
label0:
        {
            if (d1 != null)
            {
                d1 = d1.e();
                if (d1 != null)
                {
                    d1 = d1.f();
                    if (d1 == null || d1.h() == null)
                    {
                        break label0;
                    }
                    MotionControlHelper.e().a(d1.h(), false);
                }
            }
            return;
        }
        MotionControlHelper.e().a(null, false);
    }

    static b c(FineTuneToolBar finetunetoolbar)
    {
        return finetunetoolbar.x();
    }

    static b d(FineTuneToolBar finetunetoolbar)
    {
        return finetunetoolbar.y();
    }

    static b e(FineTuneToolBar finetunetoolbar)
    {
        return finetunetoolbar.z();
    }

    private void e(boolean flag)
    {
        EditViewActivity editviewactivity = Globals.d().t();
        if (editviewactivity != null)
        {
            editviewactivity.m(flag);
        }
    }

    static void f(FineTuneToolBar finetunetoolbar)
    {
        finetunetoolbar.C();
    }

    static ImageViewer g(FineTuneToolBar finetunetoolbar)
    {
        return finetunetoolbar.m;
    }

    static void h(FineTuneToolBar finetunetoolbar)
    {
        finetunetoolbar.D();
    }

    static void i(FineTuneToolBar finetunetoolbar)
    {
        finetunetoolbar.E();
    }

    private static Map r()
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

    private void s()
    {
        b = a.findViewById(0x7f0c059d);
        c = a.findViewById(0x7f0c05a1);
        d = a.findViewById(0x7f0c059f);
        e = a.findViewById(0x7f0c05a0);
        f = a.findViewById(0x7f0c05a3);
        g = a.findViewById(0x7f0c05a5);
        h = a.findViewById(0x7f0c05a7);
        i = a.findViewById(0x7f0c05a9);
        m = (ImageViewer)getActivity().findViewById(0x7f0c0720);
        StatusManager.j().y();
    }

    private void t()
    {
        b.setOnClickListener(o);
        c.setOnClickListener(p);
        d.setOnClickListener(u);
        e.setOnClickListener(v);
        f.setOnClickListener(q);
        g.setOnClickListener(r);
        h.setOnClickListener(s);
        i.setOnClickListener(t);
    }

    private void u()
    {
        d.setEnabled(false);
        e.setEnabled(false);
    }

    private void v()
    {
        MakeupMode makeupmode = StatusManager.j().r();
        BeautyMode beautymode = StatusManager.j().s();
        class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[MakeupMode.values().length];
                try
                {
                    a[MakeupMode.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[MakeupMode.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[MakeupMode.d.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[MakeupMode.e.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (com.cyberlink.youcammakeup.widgetpool.toolbar._cls2.a[makeupmode.ordinal()])
        {
        default:
            a(0, 0, 0, 0);
            return;

        case 1: // '\001'
            a(0, 0, 0, 0);
            e(true);
            return;

        case 2: // '\002'
            if (beautymode == BeautyMode.h || beautymode == BeautyMode.f)
            {
                a(8);
                e(false);
                return;
            } else
            {
                a(0, 0, 0, 0);
                e(true);
                return;
            }

        case 3: // '\003'
            a(0, 0, 0, 8);
            return;

        case 4: // '\004'
            a(8);
            return;
        }
    }

    private b w()
    {
        return com.cyberlink.youcammakeup.kernelctrl.featurepoints.a.a((PanZoomViewer)m, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.h, null);
    }

    private b x()
    {
        return com.cyberlink.youcammakeup.kernelctrl.featurepoints.a.a((PanZoomViewer)m, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.k, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.a);
    }

    private b y()
    {
        return com.cyberlink.youcammakeup.kernelctrl.featurepoints.a.a((PanZoomViewer)m, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.k, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.f);
    }

    private b z()
    {
        return com.cyberlink.youcammakeup.kernelctrl.featurepoints.a.a((PanZoomViewer)m, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.f, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.O);
    }

    public void a()
    {
        a(true);
        u();
        a(0);
        v();
        m = (ImageViewer)getActivity().findViewById(0x7f0c0720);
    }

    public void a(int i1)
    {
        View view = a.findViewById(0x7f0c05a2);
        if (view != null)
        {
            view.setVisibility(i1);
        }
    }

    public void a(int i1, int j1, int k1, int l1)
    {
        f.setVisibility(i1);
        g.setVisibility(j1);
        h.setVisibility(k1);
        i.setVisibility(l1);
        c();
    }

    public void a(boolean flag)
    {
        k = flag;
    }

    public void b()
    {
        if (StatusManager.j().r() == MakeupMode.e)
        {
            l = z();
            return;
        } else
        {
            l = w();
            return;
        }
    }

    public void b(int i1)
    {
        a.setVisibility(i1);
    }

    public void b(boolean flag)
    {
        if (d != null)
        {
            d.setEnabled(flag);
        }
    }

    public void c()
    {
        g();
        f.setSelected(true);
    }

    public void c(boolean flag)
    {
        if (e != null)
        {
            e.setEnabled(flag);
        }
    }

    public void d()
    {
        g();
        g.setSelected(true);
    }

    public void d(boolean flag)
    {
        j = flag;
    }

    public void e()
    {
        g();
        h.setSelected(true);
    }

    public void f()
    {
        g();
        i.setSelected(true);
    }

    public void g()
    {
        if (f != null)
        {
            f.setSelected(false);
        }
        if (g != null)
        {
            g.setSelected(false);
        }
        if (h != null)
        {
            h.setSelected(false);
        }
        if (i != null)
        {
            i.setSelected(false);
        }
    }

    public boolean h()
    {
        return k;
    }

    public void i()
    {
        if (b != null)
        {
            b.performClick();
        }
    }

    public void j()
    {
        C();
        long l1 = StatusManager.j().l();
        if (!com.cyberlink.youcammakeup.database.g.a(l1) && !com.cyberlink.youcammakeup.kernelctrl.viewengine.i.a(l1) || m == null)
        {
            E();
            return;
        }
        Globals.d().t().V();
        if (m != null)
        {
            m.q();
        }
        k();
    }

    public void k()
    {
        Handler handler = new Handler();
        long l1 = StatusManager.j().l();
        com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.DevelopSetting developsetting = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.e.a().a(Long.valueOf(l1), Boolean.valueOf(true));
        ViewEngine.a().a(l1, 1.0D, developsetting, null, new com.cyberlink.youcammakeup.kernelctrl.viewengine.a(l1, handler) {

            final long a;
            final Handler b;
            final FineTuneToolBar c;

            public void a(com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskCancelType taskcanceltype, String s1, Object obj)
            {
                b.post(new Runnable(this) {

                    final _cls10 a;

                    public void run()
                    {
                        com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.i(a.c);
                    }

            
            {
                a = _pcls10;
                super();
            }
                });
            }

            public void a(com.cyberlink.youcammakeup.kernelctrl.viewengine.q q1, Object obj)
            {
                obj = StatusManager.j().l(a);
                Object obj1 = MotionControlHelper.e().M();
                List list = com.cyberlink.youcammakeup.kernelctrl.j.a().g();
                if (obj == null)
                {
                    obj = new a(a, com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.g(c).m.b, com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.g(c).m.c, com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.g(c).m.d, com.cyberlink.youcammakeup.kernelctrl.j.a(com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.g(c).m.i), list, ((ar)list.get(com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.g(c).m.j)).c.b(), ((ar)list.get(com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.g(c).m.j)).c.c(), com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.g(c).m.j, null, ((v) (obj1)), "");
                }
                StatusManager.j().s();
                v v1;
                if (((a) (obj)).f() == null)
                {
                    obj1 = new com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i();
                } else
                {
                    obj1 = new com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i(((a) (obj)).f().g());
                }
                if (obj1 != null)
                {
                    StatusManager.j().a(((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i) (obj1)));
                }
                v1 = MotionControlHelper.e().M();
                v1.a(((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i) (obj1)));
                obj = new a(a, q1.a().b(), q1.a().c(), ((a) (obj)).d, com.cyberlink.youcammakeup.kernelctrl.j.a(com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.g(c).m.i), list, ((a) (obj)).a(), ((a) (obj)).b(), ((a) (obj)).e, ((a) (obj)).c(), v1, ((a) (obj)).g());
                obj1 = new com.cyberlink.youcammakeup.d(this) {

                    final _cls10 b;

                    public void a()
                    {
                        com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.i(b.c);
                    }

                    public void b()
                    {
                        com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.i(b.c);
                    }

                    public void c()
                    {
                        com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.i(b.c);
                    }

            
            {
                b = _pcls10;
                super();
            }
                };
                if (StatusManager.j().z())
                {
                    StatusManager.j().a(((a) (obj)), q1.a(), ((com.cyberlink.youcammakeup.d) (obj1)));
                    return;
                } else
                {
                    StatusManager.j().b(((a) (obj)), q1.a(), ((com.cyberlink.youcammakeup.d) (obj1)));
                    return;
                }
            }

            public void a(String s1, Object obj)
            {
                b.post(new Runnable(this) {

                    final _cls10 a;

                    public void run()
                    {
                        com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.i(a.c);
                    }

            
            {
                a = _pcls10;
                super();
            }
                });
            }

            
            {
                c = FineTuneToolBar.this;
                a = l1;
                b = handler;
                super();
            }
        });
    }

    public boolean l()
    {
        if (Globals.d().t() == null)
        {
            return false;
        } else
        {
            p();
            return true;
        }
    }

    public void m()
    {
        StatusManager statusmanager = StatusManager.j();
        long l1 = statusmanager.l();
        if (!statusmanager.k(l1))
        {
            ImageBufferWrapper imagebufferwrapper = ViewEngine.a().a(l1, 1.0D, null);
            Object obj;
            Object obj3;
            if (statusmanager.z())
            {
                obj = statusmanager.f(l1);
            } else
            {
                obj = statusmanager.i(l1);
            }
            obj3 = (ImageViewer)getActivity().findViewById(0x7f0c0720);
            if (obj3 == null)
            {
                com.pf.common.utility.m.b("FineTuneToolBar", "Can't initialize fine tune local session. PanZoomViewer is null.");
                return;
            }
            if (imagebufferwrapper == null)
            {
                com.pf.common.utility.m.b("FineTuneToolBar", "Can't initialize fine tune local session. newSrcBuffer is null.");
                return;
            }
            Object obj1 = StatusManager.j().s();
            Object obj2;
            com.cyberlink.youcammakeup.jniproxy.z z1;
            com.cyberlink.youcammakeup.jniproxy.z z2;
            List list;
            List list1;
            int i1;
            long l2;
            long l3;
            if (obj != null)
            {
                obj1 = ((a) (obj)).f();
            } else
            {
                obj1 = new v(((BeautyMode) (obj1)));
            }
            ((v) (obj1)).a(StatusManager.j().d());
            obj2 = MotionControlHelper.e().f();
            if (obj2 != null)
            {
                ((v) (obj1)).a(((Boolean) (obj2)));
            }
            l2 = imagebufferwrapper.b();
            l3 = imagebufferwrapper.c();
            if (obj == null)
            {
                obj2 = ((ImageViewer) (obj3)).m.d;
            } else
            {
                obj2 = ((a) (obj)).d;
            }
            list = com.cyberlink.youcammakeup.kernelctrl.j.a(((ImageViewer) (obj3)).m.i);
            list1 = com.cyberlink.youcammakeup.kernelctrl.j.a().g();
            if (obj == null)
            {
                z1 = null;
            } else
            {
                z1 = ((a) (obj)).a();
            }
            if (obj == null)
            {
                z2 = null;
            } else
            {
                z2 = ((a) (obj)).b();
            }
            if (obj == null)
            {
                i1 = ((ImageViewer) (obj3)).m.j;
            } else
            {
                i1 = ((a) (obj)).e;
            }
            if (obj == null)
            {
                obj3 = null;
            } else
            {
                obj3 = ((a) (obj)).c();
            }
            if (obj == null)
            {
                obj = "";
            } else
            {
                obj = ((a) (obj)).g();
            }
            obj = new a(l1, l2, l3, ((com.cyberlink.youcammakeup.jniproxy.UIImageOrientation) (obj2)), list, list1, z1, z2, i1, ((String) (obj3)), ((v) (obj1)), ((String) (obj)));
            StatusManager.j().c(((a) (obj)), imagebufferwrapper);
            imagebufferwrapper.m();
        }
        statusmanager.y();
        d(true);
    }

    public void n()
    {
        StatusManager.j().L();
        StatusManager.j().H();
    }

    public boolean o()
    {
        return j;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        s();
        t();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        a = layoutinflater.inflate(0x7f03011b, viewgroup, false);
        return a;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        B();
    }

    public void onResume()
    {
        super.onResume();
    }

    public void p()
    {
        a(false);
        d(false);
        com.cyberlink.youcammakeup.kernelctrl.j.a().h();
        Long long1 = Long.valueOf(StatusManager.j().l());
        d d1;
        if (StatusManager.j().z())
        {
            d1 = StatusManager.j().c(long1.longValue());
        } else
        {
            d1 = StatusManager.j().g(long1.longValue());
        }
        com.cyberlink.youcammakeup.kernelctrl.j.a().a(d1);
        b(d1);
        a(d1);
        ViewEngine.a().a(long1.longValue(), d1.d().b());
        F();
    }

    public void q()
    {
        if (l != null)
        {
            com.cyberlink.youcammakeup.kernelctrl.featurepoints.a.a((PanZoomViewer)m, l);
        }
    }

}
