// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.animation.Animator;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.SeekBar;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.ExtraDownloadActivity;
import com.cyberlink.youcammakeup.activity.ExtraDownloadCategoryActivity;
import com.cyberlink.youcammakeup.activity.SponsorConsultActivity;
import com.cyberlink.youcammakeup.activity.WebViewerExActivity;
import com.cyberlink.youcammakeup.activity.k;
import com.cyberlink.youcammakeup.clflurry.YMKApplyEvent;
import com.cyberlink.youcammakeup.clflurry.YMKClicksLipsCartEvent;
import com.cyberlink.youcammakeup.clflurry.YMKFeatures;
import com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent;
import com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent;
import com.cyberlink.youcammakeup.clflurry.s;
import com.cyberlink.youcammakeup.clflurry.w;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.flurry.PopularityOfEyeShadowPaletteEvent;
import com.cyberlink.youcammakeup.flurry.PopularityOfEyeShadowPatternEvent;
import com.cyberlink.youcammakeup.flurry.PopularityOfSkinTonerEvent;
import com.cyberlink.youcammakeup.jniproxy.y;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierTaskInfo;
import com.cyberlink.youcammakeup.kernelctrl.VenusHelper;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.c.b;
import com.cyberlink.youcammakeup.kernelctrl.c.d;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.m;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.n;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.p;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.t;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.u;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.f;
import com.cyberlink.youcammakeup.kernelctrl.j;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.g;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.ImageStateChangedEvent;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.am;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.pages.moreview.af;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.DownloadUseUtils;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.SkuTemplateUtils;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.utility.ax;
import com.cyberlink.youcammakeup.utility.az;
import com.cyberlink.youcammakeup.utility.ba;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.utility.ch;
import com.cyberlink.youcammakeup.utility.e;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;
import com.cyberlink.youcammakeup.widgetpool.common.FixedAspectRatioFrameLayout;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.common.VerticalSeekBar;
import com.cyberlink.youcammakeup.widgetpool.dialogs.ah;
import com.cyberlink.youcammakeup.widgetpool.panel.a;
import com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar;
import com.cyberlink.youcammakeup.widgetpool.toolbar.TopToolBar;
import com.cyberlink.youcammakeup.widgetpool.toolbar.c;
import com.cyberlink.youcammakeup.widgetpool.toolbar.l;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            c, BeautyToolPanelItemAdapter, r, a, 
//            k, HairDyeToolPanelMenu, e, b, 
//            p, TemplateButton

public class BeautyToolPanel extends Fragment
    implements k, f, g, am, a
{

    public android.widget.SeekBar.OnSeekBarChangeListener A;
    public android.widget.SeekBar.OnSeekBarChangeListener B;
    protected android.view.View.OnClickListener C;
    protected android.view.View.OnClickListener D;
    protected android.view.View.OnClickListener E;
    protected android.view.View.OnClickListener F;
    private PreferColorMode G;
    private TopToolBar H;
    private Globals I;
    private MakeupMenuBottomToolbar J;
    private ImageViewer K;
    private boolean L;
    private ViewGroup M;
    private ViewGroup N;
    private ViewGroup O;
    private View P;
    private View Q;
    private View R;
    private View S;
    private View T;
    private View U;
    private View V;
    private VerticalSeekBar W;
    private TextView X;
    private TextView Y;
    private VerticalSeekBar Z;
    protected View a;
    private ViewGroup aa;
    private ViewGroup ab;
    private ViewGroup ac;
    private GridView ad;
    private View ae;
    private View af;
    private float ag;
    private View ah;
    private View ai;
    private View aj;
    private View ak;
    private Animation al;
    private boolean am;
    private final android.view.View.OnClickListener an = new android.view.View.OnClickListener() {

        final BeautyToolPanel a;

        public void onClick(View view)
        {
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.t(a).setSelected(true);
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.u(a).setSelected(false);
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.c(a, false);
        }

            
            {
                a = BeautyToolPanel.this;
                super();
            }
    };
    private final android.view.View.OnClickListener ao = new android.view.View.OnClickListener() {

        final BeautyToolPanel a;

        public void onClick(View view)
        {
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.t(a).setSelected(false);
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.u(a).setSelected(true);
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.c(a, true);
        }

            
            {
                a = BeautyToolPanel.this;
                super();
            }
    };
    private final android.view.View.OnClickListener ap = new android.view.View.OnClickListener() {

        final BeautyToolPanel a;

        public void onClick(View view)
        {
            if (a.b == null)
            {
                return;
            } else
            {
                a.k(false);
                a.b.H();
                view = StatusManager.j().g();
                a.c.a(view);
                return;
            }
        }

            
            {
                a = BeautyToolPanel.this;
                super();
            }
    };
    protected EditViewActivity b;
    protected com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.k c;
    protected ag d;
    protected com.cyberlink.youcammakeup.widgetpool.common.a.d e;
    protected ViewGroup f;
    protected View g;
    protected BeautyToolPanelItemAdapter h;
    protected HorizontalGridView i;
    protected View j;
    protected View k;
    protected ViewGroup l;
    protected boolean m;
    protected boolean n;
    protected Long o;
    protected String p;
    protected String q;
    protected List r;
    protected Map s;
    protected v t;
    protected String u;
    protected List v;
    protected boolean w;
    protected ConcurrentHashMap x;
    protected BeautyMode y;
    protected android.view.View.OnClickListener z;

    public BeautyToolPanel()
    {
        b = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        G = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.PreferColorMode.b;
        I = null;
        J = null;
        K = null;
        L = false;
        M = null;
        l = null;
        N = null;
        O = null;
        P = null;
        Q = null;
        R = null;
        S = null;
        T = null;
        U = null;
        V = null;
        W = null;
        X = null;
        Y = null;
        Z = null;
        aa = null;
        ab = null;
        ac = null;
        ad = null;
        ae = null;
        af = null;
        ag = 0.0F;
        ah = null;
        aj = null;
        ak = null;
        al = null;
        m = false;
        n = false;
        o = null;
        p = null;
        q = null;
        r = null;
        s = null;
        t = null;
        u = null;
        v = null;
        w = false;
        am = false;
        x = new ConcurrentHashMap();
        z = new android.view.View.OnClickListener() {

            final BeautyToolPanel a;

            public void onClick(View view)
            {
                if (a.m)
                {
                    return;
                } else
                {
                    view = (Long)view.getTag();
                    a.a(false, new ch(this, view) {

                        final Long a;
                        final _cls1 b;

                        public void onAnimationEnd(Animator animator)
                        {
                            b.a.c(a);
                        }

            
            {
                b = _pcls1;
                a = long1;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                a = BeautyToolPanel.this;
                super();
            }
        };
        A = new android.widget.SeekBar.OnSeekBarChangeListener() {

            final BeautyToolPanel a;
            private final com.cyberlink.youcammakeup.activity.c b = new _cls1(this);

            public void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
            {
                if (a.b == null)
                {
                    return;
                }
                if (a.b.aa())
                {
                    a.b.a(b);
                    seekbar = Globals.d().j();
                    if (flag)
                    {
                        flag = false;
                    } else
                    {
                        flag = true;
                    }
                    seekbar.b(Boolean.valueOf(flag));
                    a.b.t(false);
                }
                a.b.b(Integer.toString(i1));
            }

            public void onStartTrackingTouch(SeekBar seekbar)
            {
                if (a.b == null)
                {
                    return;
                }
                seekbar = (ImageViewer)a.b.findViewById(0x7f0c0720);
                a.b.s(false);
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.f(a).a(Boolean.valueOf(true));
                a.b.v(true);
                Globals.d().j().y();
                a.a(true);
                if (a.c != null)
                {
                    a.c.b(true);
                }
                if (a.e != null)
                {
                    a.e.a(false);
                }
                a.b.a(b);
            }

            public void onStopTrackingTouch(SeekBar seekbar)
            {
                if (a.b != null)
                {
                    a.b.s(true);
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.f(a).a(Boolean.valueOf(false));
                    a.b.v(false);
                    if (Globals.d().j().b(Boolean.valueOf(true)))
                    {
                        Globals.d().i().b(a.b);
                        return;
                    }
                }
            }

            
            {
                a = BeautyToolPanel.this;
                super();
            }
        };
        B = new android.widget.SeekBar.OnSeekBarChangeListener() {

            final BeautyToolPanel a;

            public void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
            {
                if (a.b == null)
                {
                    return;
                }
                if (a.b.aa())
                {
                    seekbar = Globals.d().j();
                    if (flag)
                    {
                        flag = false;
                    } else
                    {
                        flag = true;
                    }
                    seekbar.a(Boolean.valueOf(flag));
                    a.b.t(false);
                }
                a.b.b(Integer.toString((int)com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.s(a) + i1));
            }

            public void onStartTrackingTouch(SeekBar seekbar)
            {
                if (a.b == null)
                {
                    return;
                }
                seekbar = (ImageViewer)a.b.findViewById(0x7f0c0720);
                a.b.s(false);
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.f(a).a(Boolean.valueOf(true));
                a.b.v(true);
                Globals.d().j().x();
                a.a(true);
                if (a.c != null)
                {
                    a.c.b(true);
                }
                if (a.e != null)
                {
                    a.e.a(false);
                }
                a.b.a(new com.cyberlink.youcammakeup.activity.c(this) {

                    final _cls29 a;

                    public void a()
                    {
                        if (a.a.b != null)
                        {
                            a.a.b.b(this);
                        }
                        a.a.a(false);
                        if (a.a.c != null)
                        {
                            a.a.c.b(false);
                        }
                        if (a.a.e != null)
                        {
                            a.a.e.a(true);
                        }
                    }

            
            {
                a = _pcls29;
                super();
            }
                });
            }

            public void onStopTrackingTouch(SeekBar seekbar)
            {
                if (a.b != null)
                {
                    a.b.s(true);
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.f(a).a(Boolean.valueOf(false));
                    a.b.v(false);
                    if (Globals.d().j().a(Boolean.valueOf(true)))
                    {
                        Globals.d().i().b(a.b);
                        return;
                    }
                }
            }

            
            {
                a = BeautyToolPanel.this;
                super();
            }
        };
        C = new android.view.View.OnClickListener() {

            final BeautyToolPanel a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.pages.moreview.af.a(com.cyberlink.youcammakeup.Globals.ActivityType.o);
                a.F();
            }

            
            {
                a = BeautyToolPanel.this;
                super();
            }
        };
        D = new android.view.View.OnClickListener() {

            final BeautyToolPanel a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.pages.moreview.af.a(com.cyberlink.youcammakeup.Globals.ActivityType.o);
                a.G();
            }

            
            {
                a = BeautyToolPanel.this;
                super();
            }
        };
        E = new android.view.View.OnClickListener() {

            final BeautyToolPanel a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.pages.moreview.af.a(com.cyberlink.youcammakeup.Globals.ActivityType.o);
                a.H();
            }

            
            {
                a = BeautyToolPanel.this;
                super();
            }
        };
        F = new android.view.View.OnClickListener() {

            final BeautyToolPanel a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.pages.moreview.af.a(com.cyberlink.youcammakeup.Globals.ActivityType.o);
            }

            
            {
                a = BeautyToolPanel.this;
                super();
            }
        };
    }

    private void U()
    {
        if (M != null)
        {
            int i1 = 0;
            while (i1 < M.getChildCount()) 
            {
                M.getChildAt(i1).setSelected(false);
                i1++;
            }
        }
    }

    private void V()
    {
        com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.k k1 = new com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.k(getActivity(), null);
        k1.g = false;
        k1.a(0.15F);
        d = new ag(getActivity());
        d.a(getActivity().getFragmentManager(), k1);
    }

    private void W()
    {
        if (M == null || l == null)
        {
            return;
        }
        for (int i1 = 0; i1 < M.getChildCount(); i1++)
        {
            View view = M.getChildAt(i1);
            if (view != null)
            {
                view.setOnClickListener(null);
            }
        }

        M.removeAllViews();
    }

    private void X()
    {
label0:
        {
            MotionControlHelper.e().a(true);
            I = Globals.d();
            b = I.t();
            Object obj = getFragmentManager();
            if (obj != null)
            {
                H = (TopToolBar)((FragmentManager) (obj)).findFragmentById(0x7f0c00be);
            }
            if (H != null)
            {
                H.a(this);
                obj = new l();
                obj.a = true;
                Integer integer = com.cyberlink.youcammakeup.utility.e.a(StatusManager.j().s());
                if (integer != null)
                {
                    obj.c = I.getString(integer.intValue());
                }
                H.a(((l) (obj)));
            }
            obj = ((com.cyberlink.youcammakeup.kernelctrl.c.a)I.i.b().get()).a();
            if (obj == null)
            {
                break label0;
            }
            obj = ((ArrayList) (obj)).iterator();
            b b1;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                b1 = (b)((WeakReference)((Iterator) (obj)).next()).get();
            } while (b1 == null || !(b1 instanceof ImageViewer));
            K = (ImageViewer)b1;
        }
        j = a.findViewById(0x7f0c0660);
        k = a.findViewById(0x7f0c067f);
        i = (HorizontalGridView)a.findViewById(0x7f0c0663);
        g = a.findViewById(0x7f0c0662);
        c(false);
        BeautyMode beautymode = StatusManager.j().s();
        y = beautymode;
        V();
        i(beautymode);
        a(beautymode);
        b(beautymode);
        e(beautymode);
        f(beautymode);
        s();
        g(beautymode);
        a(DownloadUseUtils.a(getActivity()));
        a(SkuTemplateUtils.a(getActivity()));
        String s2 = c(beautymode);
        String s1 = s2;
        if (s2 == null)
        {
            s1 = g();
        }
        if (s1 != null)
        {
            StatusManager.j().b(s1);
        }
        if (beautymode == BeautyMode.x)
        {
            StatusManager.j().a(0, 4, 0, 0, 0, 0, 4, 0);
        } else
        if (BeautyMode.d(beautymode))
        {
            StatusManager.j().a(0, 4, 0, 4, 4, 4, 4, 0);
        } else
        {
            StatusManager.j().a(0, 4, 0, 0, 0, 4, 4, 0);
        }
        if (b != null)
        {
            b.a(this);
        }
        a();
        MotionControlHelper.e().B();
        m = false;
        com.cyberlink.youcammakeup.kernelctrl.j.a().a(false);
    }

    private void Y()
    {
        W();
        MotionControlHelper.e().a(true);
        StatusManager.j().b(null);
        if (H != null)
        {
            H.a(null);
        }
        I = null;
        a = null;
        b = null;
        if (J != null)
        {
            J.b(false);
        }
        if (L)
        {
            com.cyberlink.youcammakeup.kernelctrl.j.a().d();
        }
        a("Apply", Boolean.valueOf(false));
        m = false;
        K = null;
        MotionControlHelper.e().h();
    }

    private void Z()
    {
        if (b != null)
        {
            b.Z().removeAllViews();
            if (W != null)
            {
                W.setOnSeekBarChangeListener(null);
                W = null;
            }
            if (Z != null)
            {
                Z.setOnSeekBarChangeListener(null);
                Z = null;
            }
            if (ai != null)
            {
                ai.setOnClickListener(null);
                ai = null;
            }
            if (aj != null)
            {
                aj.setOnClickListener(null);
                aj = null;
            }
            if (ak != null)
            {
                ak.clearAnimation();
                ak = null;
            }
            if (al != null)
            {
                al.cancel();
                al = null;
            }
            if (ad != null)
            {
                ad.setOnItemClickListener(null);
                ad.setAdapter(null);
                ad = null;
                return;
            }
        }
    }

    static float a(BeautyToolPanel beautytoolpanel, float f1)
    {
        beautytoolpanel.ag = f1;
        return f1;
    }

    static View a(BeautyToolPanel beautytoolpanel)
    {
        return beautytoolpanel.R;
    }

    static ViewGroup a(BeautyToolPanel beautytoolpanel, ViewGroup viewgroup)
    {
        beautytoolpanel.aa = viewgroup;
        return viewgroup;
    }

    static TextView a(BeautyToolPanel beautytoolpanel, TextView textview)
    {
        beautytoolpanel.X = textview;
        return textview;
    }

    static VerticalSeekBar a(BeautyToolPanel beautytoolpanel, VerticalSeekBar verticalseekbar)
    {
        beautytoolpanel.W = verticalseekbar;
        return verticalseekbar;
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
            d.a(s2, imageview);
        }
        viewgroup.addView(view);
        a(viewgroup);
    }

    private void a(com.cyberlink.youcammakeup.utility.DownloadUseUtils.UseTemplate usetemplate)
    {
_L2:
        return;
        if (usetemplate == null || com.cyberlink.youcammakeup.widgetpool.toolbar.c.a(getActivity())) goto _L2; else goto _L1
_L1:
        Object obj = usetemplate.beautyMode;
        String s1 = usetemplate.typeGUID;
        usetemplate = StatusManager.j().d();
        if (usetemplate == null)
        {
            usetemplate = new i();
        }
        DownloadUseUtils.a(true);
        DownloadUseUtils.b(getActivity());
        if (obj == BeautyMode.n)
        {
            if (e != null)
            {
                e.a();
            }
            if (h != null)
            {
                b.G();
                ((com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c)c).a(s1, new Float[0]);
                return;
            }
            Object obj1 = PanelDataCenter.a().i(s1);
            List list;
            if (((aw) (obj1)).c().size() > 0)
            {
                obj = (String)((aw) (obj1)).c().get(0);
            } else
            {
                obj = null;
            }
            list = PanelDataCenter.a().b(((String) (obj)), s1);
            obj1 = ((aw) (obj1)).i();
            for (int i1 = 0; i1 < ((List) (obj1)).size(); i1++)
            {
                if (list != null && list.size() >= i1 + 1 && list.get(i1) != null)
                {
                    ((at)((List) (obj1)).get(i1)).a(((Integer)list.get(i1)).intValue());
                }
            }

            MotionControlHelper.e().b(((List) (obj1)));
            usetemplate.a(new r(((String) (obj)), s1, null, ((List) (obj1)), ((at)((List) (obj1)).get(0)).d()));
        } else
        if (obj == BeautyMode.l || obj == BeautyMode.m || obj == BeautyMode.x || BeautyMode.d(((BeautyMode) (obj))))
        {
            if (e != null)
            {
                e.a();
            }
            if (h != null)
            {
                int j1 = c(s1);
                i.a(j1, true);
                i.a(h.getView(j1, null, i), j1, -1L);
                i.post(new Runnable(j1) {

                    final int a;
                    final BeautyToolPanel b;

                    public void run()
                    {
                        b.i.c(a);
                    }

            
            {
                b = BeautyToolPanel.this;
                a = i1;
                super();
            }
                });
                return;
            }
            Object obj2 = PanelDataCenter.a().p(s1);
            if (obj2 == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (obj == BeautyMode.l)
            {
                usetemplate.b(new r(((ax) (obj2)).a(), null, -1F));
            } else
            if (obj == BeautyMode.m)
            {
                usetemplate.c(new r(((ax) (obj2)).a(), null, -1F));
            } else
            if (obj == BeautyMode.x)
            {
                s1 = MotionControlHelper.e().k(((ax) (obj2)).a());
                obj = PanelDataCenter.a().i(s1);
                obj2 = ((ax) (obj2)).a();
                if (obj != null)
                {
                    obj = ((aw) (obj)).i();
                } else
                {
                    obj = new ArrayList();
                }
                usetemplate.a(new u(((String) (obj2)), s1, ((List) (obj)), MotionControlHelper.e().O(), (new StringBuilder()).append(MotionControlHelper.c).append("/").append(UUID.randomUUID().toString()).toString(), null, false));
            } else
            if (obj == BeautyMode.z)
            {
                usetemplate.a(new n(s1, null, false));
            } else
            if (obj == BeautyMode.A)
            {
                usetemplate.a(new p(s1, null, false));
            } else
            if (obj == BeautyMode.B)
            {
                usetemplate.a(new t(s1, null, false));
            } else
            if (obj == BeautyMode.C)
            {
                usetemplate.a(new com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.l(s1, null, null, false, false, true, true));
            }
        }
        StatusManager.j().a(usetemplate);
        return;
        if (true) goto _L2; else goto _L3
_L3:
    }

    private boolean a(BeautyMode beautymode, az az1)
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            if (beautymode != BeautyMode.l && beautymode != BeautyMode.m && beautymode != BeautyMode.x)
            {
                flag = flag1;
                if (!BeautyMode.d(beautymode))
                {
                    break label0;
                }
            }
            flag = flag1;
            if (az1 == null)
            {
                flag = true;
            }
        }
        return flag;
    }

    static boolean a(BeautyToolPanel beautytoolpanel, boolean flag)
    {
        beautytoolpanel.L = flag;
        return flag;
    }

    private void aa()
    {
        StatusManager.j().a(this);
        GestureDetector gesturedetector = new GestureDetector(getActivity(), new android.view.GestureDetector.SimpleOnGestureListener() {

            public BeautyMode a;
            final BeautyToolPanel b;

            public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f1, float f2)
            {
                if (Math.abs(f1) <= Math.abs(f2)) goto _L2; else goto _L1
_L1:
                return false;
_L2:
                if (f2 >= 0.0F)
                {
                    break; /* Loop/switch isn't completed */
                }
                if (a != BeautyMode.x || b.m() == 0)
                {
                    break MISSING_BLOCK_LABEL_118;
                }
                if (!StatusManager.j().e().equalsIgnoreCase("default_original_wig"))
                {
                    b.d(true);
                    b.a(true, false, null, null);
                    return true;
                }
                if (true) goto _L1; else goto _L3
_L3:
                if (a == BeautyMode.x && b.m() == 0)
                {
                    b.d(false);
                    b.a(false, true, null, null);
                    return true;
                }
                return true;
            }

            
            {
                b = BeautyToolPanel.this;
                super();
                a = StatusManager.j().s();
            }
        });
        i.setOnTouchListener(new android.view.View.OnTouchListener(gesturedetector) {

            final GestureDetector a;
            final BeautyToolPanel b;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (a.onTouchEvent(motionevent))
                {
                    motionevent.setAction(3);
                }
                return false;
            }

            
            {
                b = BeautyToolPanel.this;
                a = gesturedetector;
                super();
            }
        });
        a.addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener() {

            final BeautyToolPanel a;

            public void onLayoutChange(View view, int i1, int j1, int k1, int l1, int i2, int j2, 
                    int k2, int l2)
            {
                if (a.b != null && !a.b.isFinishing())
                {
                    if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.d(a) == null || a.l == null)
                    {
                        a.b.c(a.u());
                        return;
                    }
                    view = StatusManager.j().s();
                    View view1 = a.a.findViewById(0x7f0c0676);
                    i1 = a.a.findViewById(0x7f0c0677).getHeight();
                    k1 = view1.getHeight();
                    if (l2 - j2 == l1 - j1)
                    {
                        if (a.q() != 0)
                        {
                            if (view == BeautyMode.s)
                            {
                                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.d(a).setTranslationY(k1 - i1);
                                return;
                            }
                            if (a.g.getVisibility() == 0)
                            {
                                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.d(a).animate().cancel();
                                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.d(a).animate().translationY(k1 - i1);
                                a.b.c(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.d(a).getHeight() + a.u());
                                return;
                            } else
                            {
                                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.d(a).setTranslationY(k1);
                                return;
                            }
                        }
                    } else
                    {
                        a.b.c(a.u());
                        if (a.g.getVisibility() != 0)
                        {
                            i1 = 0;
                        }
                        j1 = view1.getHeight();
                        com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.d(a).setTranslationY(j1 - i1);
                        a.b.c(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.d(a).getHeight() + a.u());
                        return;
                    }
                }
            }

            
            {
                a = BeautyToolPanel.this;
                super();
            }
        });
        if (b != null && b.Z() != null)
        {
            b.Z().setOnTouchListener(new android.view.View.OnTouchListener() {

                final BeautyToolPanel a;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    motionevent.getActionMasked();
                    JVM INSTR tableswitch 0 0: default 24
                //                               0 26;
                       goto _L1 _L2
_L1:
                    return false;
_L2:
                    if (a.z() == 0)
                    {
                        a.a(false, true);
                        return true;
                    }
                    if (true) goto _L1; else goto _L3
_L3:
                }

            
            {
                a = BeautyToolPanel.this;
                super();
            }
            });
        }
        if (k != null)
        {
            k.setOnClickListener(new android.view.View.OnClickListener() {

                final BeautyToolPanel a;

                public void onClick(View view)
                {
                    a.k.setClickable(false);
                    if (a.h != null && a.h.a())
                    {
                        com.cyberlink.youcammakeup.utility.o.c();
                    }
                }

            
            {
                a = BeautyToolPanel.this;
                super();
            }
            });
            k.setClickable(false);
        }
    }

    private void ab()
    {
        StatusManager.j().b(this);
        if (b != null && b.Z() != null)
        {
            b.Z().setOnTouchListener(null);
        }
    }

    private void ac()
    {
        if (o != null)
        {
            return;
        }
        BeautyMode beautymode = StatusManager.j().s();
        String s1 = StatusManager.j().g();
        String s2 = StatusManager.j().e();
        int j1 = c(s2);
        int k1 = h.getCount();
        h.a(beautymode, s1);
        int l1 = h.getCount();
        int i1 = j1;
        if (k1 != l1)
        {
            i1 = j1;
            if (s2 != null)
            {
                i1 = j1;
                if (!s2.equals("default_original_wig"))
                {
                    h.notifyDataSetChanged();
                    i1 = j1 + (l1 - k1);
                }
            }
        }
        i.a(i1, true);
        h.d(i1);
    }

    private void ad()
    {
        if (b != null)
        {
            b.a(null);
            b.a(Boolean.valueOf(false), Boolean.valueOf(false));
            b.a(Boolean.valueOf(false), 0.0F, 100F, 0.0F);
            b.b(this);
            b.b(Boolean.valueOf(false));
            b.m(false);
        }
        l l1 = new l();
        l1.b = true;
        l1.a = false;
        l1.c = Globals.d().getString(0x7f0703b5);
        if (H != null)
        {
            H.a(l1);
        }
        int i1;
        byte byte0;
        if (b != null && J != null)
        {
            com.cyberlink.youcammakeup.widgetpool.toolbar.e e1 = new com.cyberlink.youcammakeup.widgetpool.toolbar.e();
            boolean flag;
            if (!b.p())
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
            J.a(e1);
        }
        Z();
        if (K != null && K.m != null && K.m.i != null && K.m.i.size() > 1)
        {
            i1 = 0;
        } else
        {
            i1 = 4;
        }
        if (ah.b || !com.cyberlink.youcammakeup.widgetpool.dialogs.ah.b())
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        StatusManager.j().a(0, i1, 8, 0, 0, 4, byte0, 8);
    }

    private void ae()
    {
        if (K == null)
        {
            return;
        } else
        {
            (new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f()).a = true;
            K.b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.a, new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f());
            K.b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.b, new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f());
            return;
        }
    }

    private void af()
    {
        g(true);
        f(false);
        if (!com.cyberlink.youcammakeup.kernelctrl.z.a("HAS_SHOWN_LANEIGE_BB_CUSHION_GUIDE", false, I))
        {
            View view = LayoutInflater.from(a.getContext()).inflate(0x7f03011d, null);
            if (view != null)
            {
                b.Z().addView(view);
                com.cyberlink.youcammakeup.kernelctrl.z.a("HAS_SHOWN_LANEIGE_BB_CUSHION_GUIDE", Boolean.valueOf(true), I);
                Globals.a(new Runnable(view) {

                    final View a;
                    final BeautyToolPanel b;

                    public void run()
                    {
                        b.b.Z().removeView(a);
                    }

            
            {
                b = BeautyToolPanel.this;
                a = view;
                super();
            }
                }, 2000L);
            }
        }
    }

    static View b(BeautyToolPanel beautytoolpanel)
    {
        return beautytoolpanel.Q;
    }

    static ViewGroup b(BeautyToolPanel beautytoolpanel, ViewGroup viewgroup)
    {
        beautytoolpanel.ab = viewgroup;
        return viewgroup;
    }

    static TextView b(BeautyToolPanel beautytoolpanel, TextView textview)
    {
        beautytoolpanel.Y = textview;
        return textview;
    }

    static VerticalSeekBar b(BeautyToolPanel beautytoolpanel, VerticalSeekBar verticalseekbar)
    {
        beautytoolpanel.Z = verticalseekbar;
        return verticalseekbar;
    }

    static void b(BeautyToolPanel beautytoolpanel, boolean flag)
    {
        beautytoolpanel.n(flag);
    }

    static View c(BeautyToolPanel beautytoolpanel)
    {
        return beautytoolpanel.S;
    }

    static void c(BeautyToolPanel beautytoolpanel, boolean flag)
    {
        beautytoolpanel.q(flag);
    }

    static View d(BeautyToolPanel beautytoolpanel)
    {
        return beautytoolpanel.af;
    }

    static void e(BeautyToolPanel beautytoolpanel)
    {
        beautytoolpanel.ad();
    }

    static TopToolBar f(BeautyToolPanel beautytoolpanel)
    {
        return beautytoolpanel.H;
    }

    static ImageViewer g(BeautyToolPanel beautytoolpanel)
    {
        return beautytoolpanel.K;
    }

    static void h(BeautyToolPanel beautytoolpanel)
    {
        beautytoolpanel.ac();
    }

    static ViewGroup i(BeautyToolPanel beautytoolpanel)
    {
        return beautytoolpanel.O;
    }

    private void i(BeautyMode beautymode)
    {
        P = a.findViewById(0x7f0c067a);
        Q = a.findViewById(0x7f0c067b);
        R = a.findViewById(0x7f0c067c);
        S = a.findViewById(0x7f0c067d);
        if (n)
        {
            beautymode = new android.view.View.OnClickListener() {

                final BeautyToolPanel a;

                public void onClick(View view)
                {
                    if (view.getId() == com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.a(a).getId())
                    {
                        a.G();
                    } else
                    {
                        if (view.getId() == com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.b(a).getId())
                        {
                            a.F();
                            return;
                        }
                        if (view.getId() == com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.c(a).getId())
                        {
                            a.H();
                            return;
                        }
                    }
                }

            
            {
                a = BeautyToolPanel.this;
                super();
            }
            };
            if (R != null)
            {
                R.setOnClickListener(beautymode);
            }
            if (Q != null)
            {
                Q.setOnClickListener(beautymode);
            }
            if (S != null)
            {
                S.setOnClickListener(beautymode);
                return;
            }
        }
    }

    private com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType j(String s1)
    {
        if (s1.equalsIgnoreCase("lipstick"))
        {
            return com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType.a;
        }
        if (s1.equalsIgnoreCase("eye_contact"))
        {
            return com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType.c;
        }
        if (s1.equalsIgnoreCase("eye_brow"))
        {
            return com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType.d;
        }
        if (s1.equalsIgnoreCase("eye_line"))
        {
            return com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType.e;
        }
        if (s1.equalsIgnoreCase("eye_lash"))
        {
            return com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType.f;
        }
        if (s1.equalsIgnoreCase("blush"))
        {
            return com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType.g;
        }
        if (s1.equalsIgnoreCase("skin_toner"))
        {
            return com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType.h;
        }
        if (s1.equalsIgnoreCase("wig"))
        {
            return com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType.i;
        }
        if (s1.equalsIgnoreCase("hair_dye"))
        {
            return com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType.j;
        } else
        {
            return com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType.a;
        }
    }

    static VerticalSeekBar j(BeautyToolPanel beautytoolpanel)
    {
        return beautytoolpanel.W;
    }

    static TextView k(BeautyToolPanel beautytoolpanel)
    {
        return beautytoolpanel.X;
    }

    static VerticalSeekBar l(BeautyToolPanel beautytoolpanel)
    {
        return beautytoolpanel.Z;
    }

    static TextView m(BeautyToolPanel beautytoolpanel)
    {
        return beautytoolpanel.Y;
    }

    static ViewGroup n(BeautyToolPanel beautytoolpanel)
    {
        return beautytoolpanel.ab;
    }

    private void n(boolean flag)
    {
        while (P == null || P.getVisibility() == 0 && flag) 
        {
            return;
        }
        if (flag)
        {
            P.setVisibility(0);
            P.setAlpha(0.0F);
            P.animate().alpha(1.0F);
            return;
        } else
        {
            P.setVisibility(8);
            return;
        }
    }

    static ViewGroup o(BeautyToolPanel beautytoolpanel)
    {
        return beautytoolpanel.M;
    }

    private void o(boolean flag)
    {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof EditViewActivity))
        {
            ((EditViewActivity)activity).b(flag);
        }
    }

    static GridView p(BeautyToolPanel beautytoolpanel)
    {
        return beautytoolpanel.ad;
    }

    private void p(boolean flag)
    {
        if (K == null)
        {
            return;
        } else
        {
            com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f f1 = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f();
            f1.a = true;
            f1.c = new com.cyberlink.youcammakeup.kernelctrl.viewengine.c(com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskRole.d);
            f1.c.f = Boolean.valueOf(flag);
            K.b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c, f1);
            return;
        }
    }

    static void q(BeautyToolPanel beautytoolpanel)
    {
        beautytoolpanel.af();
    }

    private void q(boolean flag)
    {
        MotionControlHelper motioncontrolhelper = MotionControlHelper.e();
        if (m() == 0)
        {
            com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode switchermode = StatusManager.j().i();
            motioncontrolhelper.a(switchermode, flag);
            motioncontrolhelper.a(null, true);
            ((com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c)c).a(switchermode, Boolean.valueOf(flag));
            ((com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c)c).a(switchermode, flag);
        } else
        {
            motioncontrolhelper.b(flag);
            motioncontrolhelper.a(null, true);
            ((com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c)c).a(Boolean.valueOf(flag));
            ((com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c)c).a(flag);
        }
        if (flag)
        {
            e.a("assets://makeup/eyeshadow/texture_eyeshadow_shine.png");
        } else
        {
            e.a("assets://makeup/eyeshadow/texture_leyeshadow.png");
        }
        k(MotionControlHelper.e().a(MotionControlHelper.e().C()));
    }

    static ViewGroup r(BeautyToolPanel beautytoolpanel)
    {
        return beautytoolpanel.ac;
    }

    static float s(BeautyToolPanel beautytoolpanel)
    {
        return beautytoolpanel.ag;
    }

    static View t(BeautyToolPanel beautytoolpanel)
    {
        return beautytoolpanel.T;
    }

    static View u(BeautyToolPanel beautytoolpanel)
    {
        return beautytoolpanel.U;
    }

    public boolean A()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (StatusManager.j().s() == BeautyMode.x)
        {
            flag = flag1;
            if (c != null)
            {
                flag = flag1;
                if (c instanceof com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.r)
                {
                    flag = ((com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.r)c).h();
                }
            }
        }
        return flag;
    }

    public boolean B()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (BeautyMode.d(StatusManager.j().s()))
        {
            flag = flag1;
            if (c != null)
            {
                flag = flag1;
                if (c instanceof com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.a)
                {
                    flag = ((com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.a)c).h();
                }
            }
        }
        return flag;
    }

    public boolean C()
    {
        return n;
    }

    public String D()
    {
        return p;
    }

    protected boolean E()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)getActivity().getSystemService("connectivity")).getActiveNetworkInfo();
        return networkinfo != null && networkinfo.isConnected();
    }

    protected void F()
    {
        if (E()) goto _L2; else goto _L1
_L1:
        a(C);
_L7:
        return;
_L2:
        Object obj = StatusManager.j().s();
        if (obj != BeautyMode.n) goto _L4; else goto _L3
_L3:
        obj = PanelDataCenter.a().i(StatusManager.j().g());
        if (obj == null) goto _L6; else goto _L5
_L5:
        obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(p, ((aw) (obj)).k(), ((aw) (obj)).a());
_L8:
        if (obj != null)
        {
            Object obj1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(p, o).d();
            if (obj1 != null && !((String) (obj1)).isEmpty())
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new s(((String) (obj1)), ((com.cyberlink.youcammakeup.database.more.i.e) (obj)).a(), "purchase"));
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKClicksLipsCartEvent(((String) (obj1)), ((com.cyberlink.youcammakeup.database.more.i.e) (obj)).a()));
            }
            com.perfectcorp.utility.u u1 = new com.perfectcorp.utility.u(((com.cyberlink.youcammakeup.database.more.i.e) (obj)).c().toString());
            u1.a("SourceType", "feature_room");
            u1.a("SkuGuid", obj1);
            u1.a("SkuItemGuid", ((com.cyberlink.youcammakeup.database.more.i.e) (obj)).a());
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
                intent.putExtra("RedirectUrl", ((com.cyberlink.youcammakeup.database.more.i.e) (obj)).c().toString());
                startActivity(intent);
                return;
            }
        }
_L6:
        if (true) goto _L7; else goto _L4
_L4:
        if (obj == BeautyMode.s)
        {
            obj = c.e();
            if (!(obj instanceof ba))
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = (ba)obj;
            obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(p, ((ba) (obj)).n(), StatusManager.j().e());
        } else
        if (BeautyMode.d(((BeautyMode) (obj))) || obj == BeautyMode.x)
        {
            obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(p, o);
            if (obj == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(p, ((com.cyberlink.youcammakeup.database.more.i.d) (obj)).d(), StatusManager.j().e());
        } else
        {
            obj = c.e();
            if (!(obj instanceof ba))
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = (ba)obj;
            obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(p, ((ba) (obj)).n(), ((ba) (obj)).h());
        }
          goto _L8
    }

    protected void G()
    {
        if (E()) goto _L2; else goto _L1
_L1:
        a(D);
_L7:
        return;
_L2:
        Object obj = StatusManager.j().s();
        if (obj != BeautyMode.n) goto _L4; else goto _L3
_L3:
        obj = PanelDataCenter.a().i(StatusManager.j().g());
        if (obj == null) goto _L6; else goto _L5
_L5:
        obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(p, ((aw) (obj)).k(), ((aw) (obj)).a());
_L8:
        if (obj != null)
        {
            Object obj1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(p, o).d();
            if (obj1 != null && !((String) (obj1)).isEmpty())
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new s(((String) (obj1)), ((com.cyberlink.youcammakeup.database.more.i.e) (obj)).a(), "free_sample"));
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKClicksLipsCartEvent(((String) (obj1)), ((com.cyberlink.youcammakeup.database.more.i.e) (obj)).a()));
            }
            com.perfectcorp.utility.u u1 = new com.perfectcorp.utility.u(((com.cyberlink.youcammakeup.database.more.i.e) (obj)).b().toString());
            u1.a("SourceType", "feature_room");
            u1.a("SkuGuid", obj1);
            u1.a("SkuItemGuid", ((com.cyberlink.youcammakeup.database.more.i.e) (obj)).a());
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
                intent.putExtra("RedirectUrl", ((com.cyberlink.youcammakeup.database.more.i.e) (obj)).b().toString());
                startActivity(intent);
                return;
            }
        }
_L6:
        if (true) goto _L7; else goto _L4
_L4:
        if (BeautyMode.d(((BeautyMode) (obj))) || obj == BeautyMode.x)
        {
            obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(p, o);
            if (obj == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(p, ((com.cyberlink.youcammakeup.database.more.i.d) (obj)).d(), StatusManager.j().e());
        } else
        {
            obj = c.e();
            if (!(obj instanceof ba))
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = (ba)obj;
            obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(p, ((ba) (obj)).n(), ((ba) (obj)).h());
        }
          goto _L8
    }

    protected void H()
    {
        Object obj3 = null;
        if (E()) goto _L2; else goto _L1
_L1:
        a(E);
_L7:
        return;
_L2:
        Object obj = StatusManager.j().s();
        if (obj != BeautyMode.n) goto _L4; else goto _L3
_L3:
        obj = PanelDataCenter.a().i(StatusManager.j().g());
        if (obj == null) goto _L6; else goto _L5
_L5:
        obj = new com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl(p, ((aw) (obj)).k(), ((aw) (obj)).a(), null);
_L8:
        Object obj1;
        Object obj2;
        com.cyberlink.youcammakeup.database.more.i.e e1;
        if (obj != null)
        {
            String s1 = ((com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl) (obj)).type;
            obj1 = ((com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl) (obj)).skuGuid;
            obj2 = ((com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl) (obj)).itemGuid;
            com.cyberlink.youcammakeup.clflurry.b.a(new com.cyberlink.youcammakeup.clflurry.i(s1, ((String) (obj1)), ((String) (obj2))));
            com.cyberlink.youcammakeup.clflurry.b.a(new w(SkuTemplateUtils.i(s1), ((String) (obj1)), ((String) (obj2))));
            com.cyberlink.youcammakeup.clflurry.b.a(new s(((String) (obj1)), ((String) (obj2)), "more_info"));
        } else
        {
            obj2 = null;
            obj1 = null;
        }
        e1 = obj3;
        if (obj1 != null)
        {
            e1 = obj3;
            if (obj2 != null)
            {
                e1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(p, ((String) (obj1)), ((String) (obj2)));
            }
        }
        if (e1 != null)
        {
            obj2 = new com.perfectcorp.utility.u(e1.d().toString());
            ((com.perfectcorp.utility.u) (obj2)).a("SourceType", "feature_room");
            ((com.perfectcorp.utility.u) (obj2)).a("SkuGuid", obj1);
            ((com.perfectcorp.utility.u) (obj2)).a("SkuItemGuid", e1.a());
            try
            {
                obj1 = Uri.parse(((com.perfectcorp.utility.u) (obj2)).c());
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
                obj1 = new Intent(getActivity(), com/cyberlink/youcammakeup/activity/SponsorConsultActivity);
                ((Intent) (obj1)).putExtra("URL_CONTENT", ((java.io.Serializable) (obj)));
                startActivity(((Intent) (obj1)));
                return;
            }
        }
_L6:
        if (true) goto _L7; else goto _L4
_L4:
        if (BeautyMode.d(((BeautyMode) (obj))) || obj == BeautyMode.x)
        {
            obj1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(p, o);
            if (obj1 == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (obj1 != null)
            {
                obj = ((com.cyberlink.youcammakeup.database.more.i.d) (obj1)).d();
            } else
            {
                obj = null;
            }
            obj1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(p, ((com.cyberlink.youcammakeup.database.more.i.d) (obj1)).d(), StatusManager.j().e());
            if (obj1 != null)
            {
                obj1 = ((com.cyberlink.youcammakeup.database.more.i.e) (obj1)).a();
            } else
            {
                obj1 = null;
            }
            obj = new com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl(p, ((String) (obj)), ((String) (obj1)), StatusManager.j().e());
        } else
        {
            obj = c.e();
            if (!(obj instanceof ba))
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = (ba)obj;
            obj = new com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl(p, ((ba) (obj)).n(), ((ba) (obj)).h(), StatusManager.j().e());
        }
          goto _L8
    }

    public ViewGroup I()
    {
        return f;
    }

    float J()
    {
        BeautyMode beautymode = StatusManager.j().s();
        class _cls38
        {

            static final int a[];

            static 
            {
                a = new int[BeautyMode.values().length];
                try
                {
                    a[BeautyMode.n.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    a[BeautyMode.s.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    a[BeautyMode.z.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    a[BeautyMode.A.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    a[BeautyMode.B.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    a[BeautyMode.C.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    a[BeautyMode.b.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    a[BeautyMode.t.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[BeautyMode.a.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[BeautyMode.m.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[BeautyMode.r.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[BeautyMode.l.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[BeautyMode.y.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[BeautyMode.x.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel._cls38.a[beautymode.ordinal()])
        {
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 12: // '\f'
        case 13: // '\r'
        default:
            return 50F;

        case 9: // '\t'
            return 25F;

        case 10: // '\n'
            return 75F;

        case 11: // '\013'
            return 10F;

        case 2: // '\002'
            return 40F;

        case 14: // '\016'
            return (float)MotionControlHelper.e().O();
        }
    }

    int K()
    {
        if (W != null)
        {
            return W.getProgress();
        } else
        {
            return 0;
        }
    }

    float L()
    {
        BeautyMode beautymode = StatusManager.j().s();
        switch (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel._cls38.a[beautymode.ordinal()])
        {
        case 2: // '\002'
        default:
            return 0.0F;

        case 11: // '\013'
            return 10F;

        case 13: // '\r'
            return 50F;
        }
    }

    public View M()
    {
        return a;
    }

    public View N()
    {
        if (a != null)
        {
            return a.findViewById(0x7f0c0646);
        } else
        {
            return null;
        }
    }

    public boolean O()
    {
        return StatusManager.j().s() != BeautyMode.y || c == null || !(c instanceof HairDyeToolPanelMenu) || ((HairDyeToolPanelMenu)c).k() != com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeToolPanelMenu.HairDyeMode.b;
    }

    public void P()
    {
        if (StatusManager.j().s() == BeautyMode.y && c != null && (c instanceof HairDyeToolPanelMenu))
        {
            ((HairDyeToolPanelMenu)c).j();
        }
    }

    public boolean Q()
    {
        return StatusManager.j().s() == BeautyMode.y && c != null && (c instanceof HairDyeToolPanelMenu) && ((HairDyeToolPanelMenu)c).k() == com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeToolPanelMenu.HairDyeMode.b;
    }

    public boolean R()
    {
        return L;
    }

    public void S()
    {
        if (StatusManager.j().s() == BeautyMode.b && W != null && b.aa())
        {
            int j1 = W.getProgress();
            int i1 = 100;
            if (j1 < 100)
            {
                if (b != null)
                {
                    Globals.d().i().b(b);
                }
                if (j1 + 20 <= 100)
                {
                    i1 = j1 + 20;
                }
                W.setProgressAndThumb(i1);
                return;
            }
        }
    }

    protected void T()
    {
        if (e != null)
        {
            e.e();
        }
    }

    protected String a(Long long1, v v1, at at1)
    {
        Object obj;
        BeautyMode beautymode;
        beautymode = StatusManager.j().s();
        obj = null;
        if (v1 == null) goto _L2; else goto _L1
_L1:
        long1 = v1.a();
_L5:
        return long1;
_L2:
        if (long1 == null || beautymode != BeautyMode.s && !BeautyMode.d(beautymode) && beautymode != BeautyMode.x) goto _L4; else goto _L3
_L3:
        long1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(p, long1).l().iterator();
        do
        {
            if (!long1.hasNext())
            {
                break MISSING_BLOCK_LABEL_229;
            }
            v1 = (com.cyberlink.youcammakeup.database.more.i.e)long1.next();
        } while (v1 == null || !bo.g(v1.a()));
        long1 = v1.a();
_L6:
        return long1;
_L4:
        if (long1 != null && beautymode == BeautyMode.l && beautymode == BeautyMode.m)
        {
            return ((ba)at1).o();
        }
        if (long1 != null && t != null)
        {
            return t.a();
        }
        if (beautymode == BeautyMode.s)
        {
            return "default_original_eye_contact";
        }
        if (beautymode == BeautyMode.x)
        {
            return "default_original_wig";
        }
        v1 = PanelDataCenter.a().a(beautymode);
        long1 = obj;
        if (v1 != null)
        {
            long1 = obj;
            if (v1.size() > 0)
            {
                return PanelDataCenter.a().p((String)v1.get(0)).a();
            }
        }
          goto _L5
        long1 = null;
          goto _L6
    }

    protected void a()
    {
        Object obj;
        Object obj1;
        if (G != null)
        {
            FragmentTransaction fragmenttransaction;
            if (G != com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.PreferColorMode.e)
            {
                obj1 = new com.cyberlink.youcammakeup.widgetpool.common.a.g();
            } else
            {
                obj1 = new com.cyberlink.youcammakeup.widgetpool.common.a.b();
            }
            if (G == com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.PreferColorMode.a)
            {
                obj = new com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.c();
            } else
            if (G == com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.PreferColorMode.b)
            {
                obj = new com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.e();
            } else
            if (G == com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.PreferColorMode.c)
            {
                obj = new com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b();
                ((com.cyberlink.youcammakeup.widgetpool.common.a.d) (obj1)).a(0x7f0300f5);
            } else
            if (G == com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.PreferColorMode.d)
            {
                obj = new com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b();
                ((com.cyberlink.youcammakeup.widgetpool.common.a.d) (obj1)).a(0x7f0300f4);
            } else
            if (G == com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.PreferColorMode.e)
            {
                obj = new com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.a();
                ((com.cyberlink.youcammakeup.widgetpool.common.a.d) (obj1)).a(0x7f0300f2);
            } else
            {
                obj = null;
            }
        } else
        {
            obj1 = null;
            obj = null;
        }
        if (obj != null)
        {
            fragmenttransaction = getFragmentManager().beginTransaction();
            if (c != null)
            {
                fragmenttransaction.add(0x7f0c0661, ((Fragment) (obj)));
            } else
            {
                fragmenttransaction.replace(0x7f0c0661, ((Fragment) (obj)));
            }
            if (G == com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.PreferColorMode.c || G == com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.PreferColorMode.d || G == com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.PreferColorMode.a || G == com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.PreferColorMode.e)
            {
                fragmenttransaction.replace(0x7f0c065f, ((Fragment) (obj1)));
                e = ((com.cyberlink.youcammakeup.widgetpool.common.a.d) (obj1));
                e.a((com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.k)obj);
                if (b != null)
                {
                    b.a(null);
                }
                f = (ViewGroup)a.findViewById(0x7f0c065f);
            } else
            {
                fragmenttransaction.replace(0x7f0c00e0, ((Fragment) (obj1)));
                e = ((com.cyberlink.youcammakeup.widgetpool.common.a.d) (obj1));
                e.a((com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.k)obj);
                if (b != null)
                {
                    b.a(e);
                }
                f = null;
            }
            c = (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.k)obj;
            c.a(this);
            if (n && o != null)
            {
                e.a(new az(o, p));
                c.a(new az(o, p));
            }
            fragmenttransaction.commitAllowingStateLoss();
        }
    }

    public void a(float f1)
    {
        if (W == null)
        {
            return;
        } else
        {
            W.setOnSeekBarChangeListener(null);
            W.setProgressAndThumb((int)f1);
            W.setOnSeekBarChangeListener(A);
            return;
        }
    }

    public void a(float f1, float f2, float f3, boolean flag, boolean flag1)
    {
        if (b == null)
        {
            return;
        }
        Runnable runnable = new Runnable(f1, f2, f3, flag) {

            final float a;
            final float b;
            final float c;
            final boolean d;
            final BeautyToolPanel e;

            public void run()
            {
                BeautyMode beautymode = StatusManager.j().s();
                Object obj = LayoutInflater.from(e.a.getContext());
                if (beautymode == BeautyMode.n || beautymode == BeautyMode.v || beautymode == BeautyMode.x || beautymode == BeautyMode.l || beautymode == BeautyMode.b || beautymode == BeautyMode.a || beautymode == BeautyMode.m || beautymode == BeautyMode.t)
                {
                    obj = ((LayoutInflater) (obj)).inflate(0x7f0301d7, null);
                    e.b.Z().addView(((View) (obj)));
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.a(e, (ViewGroup)e.b.Z().findViewById(0x7f0c0854));
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.a(e, (VerticalSeekBar)e.b.Z().findViewById(0x7f0c0855));
                } else
                if (beautymode == BeautyMode.r || beautymode == BeautyMode.s || beautymode == BeautyMode.y)
                {
                    obj = ((LayoutInflater) (obj)).inflate(0x7f0301d8, null);
                    e.b.Z().addView(((View) (obj)));
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.b(e, (ViewGroup)e.b.Z().findViewById(0x7f0c0856));
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.a(e, (VerticalSeekBar)e.b.Z().findViewById(0x7f0c0858));
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.b(e, (VerticalSeekBar)e.b.Z().findViewById(0x7f0c085a));
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.a(e, (TextView)e.b.Z().findViewById(0x7f0c0857));
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.b(e, (TextView)e.b.Z().findViewById(0x7f0c0859));
                }
                if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.j(e) != null)
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.j(e).setProgress((int)a);
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.j(e).setOnSeekBarChangeListener(e.A);
                    Globals.d().j().a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.j(e));
                    if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.k(e) != null && beautymode == BeautyMode.y)
                    {
                        com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.k(e).setText(0x7f070342);
                    }
                    if (e.b != null)
                    {
                        e.b.v();
                    }
                }
                if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.l(e) != null)
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.l(e).setProgress((int)b);
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.l(e).setOnSeekBarChangeListener(e.B);
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.a(e, c);
                    Globals.d().j().b(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.l(e));
                    if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.m(e) != null)
                    {
                        if (beautymode == BeautyMode.r)
                        {
                            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.m(e).setText(0x7f07034c);
                        } else
                        if (beautymode == BeautyMode.y)
                        {
                            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.m(e).setText(0x7f070331);
                        }
                    }
                }
                if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.n(e) != null)
                {
                    e.i(d);
                } else
                {
                    e.h(d);
                }
                e.g(null);
            }

            
            {
                e = BeautyToolPanel.this;
                a = f1;
                b = f2;
                c = f3;
                d = flag;
                super();
            }
        };
        if (flag1)
        {
            a.post(runnable);
            return;
        } else
        {
            runnable.run();
            return;
        }
    }

    public void a(int i1)
    {
        if (f != null)
        {
            if (i1 == 0)
            {
                if (m() != 0)
                {
                    f.setVisibility(0);
                    f.setAlpha(0.0F);
                    f.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F);
                    return;
                }
            } else
            {
                f.setVisibility(i1);
                return;
            }
        }
    }

    public void a(Fragment fragment)
    {
        J = (MakeupMenuBottomToolbar)fragment;
    }

    protected void a(android.view.View.OnClickListener onclicklistener)
    {
        String s1 = Globals.d().getResources().getString(0x7f070533);
        com.cyberlink.youcammakeup.pages.moreview.af.a(com.cyberlink.youcammakeup.Globals.ActivityType.o, onclicklistener, F, 0x7f0c00d1, s1);
    }

    public void a(BeautifierTaskInfo beautifiertaskinfo)
    {
        BeautifierManager.a().b(this);
        if (com.cyberlink.youcammakeup.kernelctrl.j.a().j())
        {
            Globals.d().t().a(false, null);
        }
        p(true);
        ae();
        if ((getActivity() instanceof EditViewActivity) && ah.b)
        {
            ((EditViewActivity)getActivity()).b(false, ah.c);
        }
        f();
        ad();
        l();
    }

    protected void a(v v1, String s1, Long long1, at at1)
    {
        BeautyMode beautymode = StatusManager.j().s();
        if (v1 == null)
        {
            if (long1 != null)
            {
                int l1 = at1.d();
                int i1 = l1;
                if (l1 <= 0)
                {
                    i1 = (int)J();
                }
                if (beautymode == BeautyMode.r)
                {
                    a(s1, long1);
                    return;
                }
                if (beautymode == BeautyMode.x)
                {
                    a(100 - i1);
                } else
                {
                    a(i1);
                }
                v1 = new ArrayList();
                v1.add(Integer.valueOf(i1));
                MotionControlHelper.e().c(v1);
                return;
            }
            if (beautymode == BeautyMode.r)
            {
                a(s1, long1);
                return;
            }
            int j1 = (int)J();
            float f1 = L();
            if (beautymode == BeautyMode.x)
            {
                a(100 - j1);
            } else
            {
                a(j1);
            }
            b(f1);
            v1 = new ArrayList();
            v1.add(Integer.valueOf(j1));
            MotionControlHelper.e().c(v1);
            MotionControlHelper.e().a(f1);
            return;
        }
        int k1 = 60;
        float f2 = 0.0F;
        if (beautymode == BeautyMode.a || beautymode == BeautyMode.b || beautymode == BeautyMode.l || beautymode == BeautyMode.m || beautymode == BeautyMode.r || beautymode == BeautyMode.s || beautymode == BeautyMode.v || beautymode == BeautyMode.x)
        {
            k1 = v1.b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a).intValue();
        }
        if (beautymode == BeautyMode.r || beautymode == BeautyMode.s)
        {
            f2 = v1.d().intValue();
        }
        if (beautymode == BeautyMode.x)
        {
            a(100 - k1);
        } else
        {
            a(k1);
        }
        b(f2);
        v1 = new ArrayList();
        v1.add(Integer.valueOf(k1));
        MotionControlHelper.e().c(v1);
        MotionControlHelper.e().a(f2);
    }

    public void a(ImageStateChangedEvent imagestatechangedevent)
    {
        o();
    }

    protected void a(com.cyberlink.youcammakeup.kernelctrl.status.a a1)
    {
        Object obj;
        boolean flag1;
        flag1 = true;
        obj = StatusManager.j().s();
        r r1;
        if (a1.f() == null)
        {
            a1 = new i();
        } else
        {
            a1 = new i(a1.f().g());
        }
        r1 = MotionControlHelper.e().J();
        if (obj != BeautyMode.b) goto _L2; else goto _L1
_L1:
        com.cyberlink.youcammakeup.clflurry.b.a(new com.cyberlink.youcammakeup.clflurry.n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.c));
        a1.f(r1);
        com.cyberlink.youcammakeup.flurry.a.a(new PopularityOfSkinTonerEvent(r1.e().i(), r1.g()));
        obj = new YMKApplyEvent(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.c);
        YMKApplyEvent.a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.c, r1, ((YMKApplyEvent) (obj)));
        com.cyberlink.youcammakeup.clflurry.b.a(((YMKApplyEvent) (obj)).e());
_L4:
        a1.a(false);
        StatusManager.j().a(a1);
        return;
_L2:
        Object obj1;
        boolean flag;
        if (obj == BeautyMode.t)
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new com.cyberlink.youcammakeup.clflurry.n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.t));
            Object obj2 = MotionControlHelper.e().E();
            obj = ((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.k) (obj2)).c().i();
            String s1 = ((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.k) (obj2)).a();
            float f1 = ((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.k) (obj2)).b();
            a1.a(((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.k) (obj2)));
            obj2 = new YMKApplyEvent(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.q);
            ((YMKApplyEvent) (obj2)).d(YMKApplyEvent.b(new String[] {
                obj
            }));
            ((YMKApplyEvent) (obj2)).f(s1);
            ((YMKApplyEvent) (obj2)).g(String.valueOf(f1));
            com.cyberlink.youcammakeup.clflurry.b.a(((YMKApplyEvent) (obj2)).e());
            continue; /* Loop/switch isn't completed */
        }
        if (obj == BeautyMode.z)
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new com.cyberlink.youcammakeup.clflurry.n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.z));
            obj = MotionControlHelper.e().F();
            a1.a(((n) (obj)));
            if (obj != null)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(((n) (obj)).e().e());
            }
            continue; /* Loop/switch isn't completed */
        }
        if (obj == BeautyMode.A)
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new com.cyberlink.youcammakeup.clflurry.n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.A));
            obj = MotionControlHelper.e().G();
            a1.a(((p) (obj)));
            if (obj != null)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(((p) (obj)).e().e());
            }
            continue; /* Loop/switch isn't completed */
        }
        if (obj == BeautyMode.B)
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new com.cyberlink.youcammakeup.clflurry.n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.B));
            obj = MotionControlHelper.e().H();
            a1.a(((t) (obj)));
            if (obj != null)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(((t) (obj)).e().e());
            }
            continue; /* Loop/switch isn't completed */
        }
        if (obj == BeautyMode.C)
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new com.cyberlink.youcammakeup.clflurry.n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.C));
            obj = MotionControlHelper.e().I();
            a1.a(((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.l) (obj)));
            if (obj != null)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.l) (obj)).e().e());
            }
            continue; /* Loop/switch isn't completed */
        }
        if (obj != BeautyMode.n)
        {
            continue; /* Loop/switch isn't completed */
        }
        com.cyberlink.youcammakeup.clflurry.b.a(new com.cyberlink.youcammakeup.clflurry.n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.n));
        obj = MotionControlHelper.e().C();
        if (obj != null)
        {
            a1.a(((r) (obj)));
        }
        if (o != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            YMKApplyEvent ymkapplyevent = new YMKApplyEvent(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.l);
            YMKApplyEvent.a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.l, ((r) (obj)), ymkapplyevent);
            com.cyberlink.youcammakeup.clflurry.b.a(ymkapplyevent.e());
            continue; /* Loop/switch isn't completed */
        }
        obj1 = PanelDataCenter.a().i(((r) (obj)).c());
        if (obj1 != null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
_L5:
        if (!flag)
        {
            com.cyberlink.youcammakeup.flurry.a.a(new PopularityOfEyeShadowPatternEvent(((r) (obj)).b()));
            com.cyberlink.youcammakeup.flurry.a.a(new PopularityOfEyeShadowPaletteEvent(((r) (obj)).c()));
            obj1 = new YMKApplyEvent(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.l);
            YMKApplyEvent.a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.l, ((r) (obj)), ((YMKApplyEvent) (obj1)));
            com.cyberlink.youcammakeup.clflurry.b.a(((YMKApplyEvent) (obj1)).e());
        }
        if (true) goto _L4; else goto _L3
_L3:
        flag = flag1;
        if (((aw) (obj1)).g() != com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c)
        {
            flag = flag1;
            if (!MotionControlHelper.e().a(((r) (obj))))
            {
                flag = false;
            }
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    protected void a(BeautyMode beautymode)
    {
        if (n) goto _L2; else goto _L1
_L1:
        return;
_L2:
        l = (ViewGroup)a.findViewById(0x7f0c0678);
        M = (ViewGroup)a.findViewById(0x7f0c0679);
        if (M != null && l != null)
        {
            l.setVisibility(8);
            W();
            beautymode = com.cyberlink.youcammakeup.kernelctrl.sku.h.b();
            v = null;
            if (u == null || u.equals(Globals.d().getString(0x7f0703cf)))
            {
                a(M, null, getActivity().getString(0x7f0703cf), ((String) (null)), z);
                return;
            }
            v = new ArrayList();
            for (int i1 = 0; i1 < r.size(); i1++)
            {
                Object obj = (Long)r.get(i1);
                obj = beautymode.a(p, ((Long) (obj)));
                if (obj != null && ((com.cyberlink.youcammakeup.database.more.i.d) (obj)).e() != null && ((com.cyberlink.youcammakeup.database.more.i.d) (obj)).e().equals(u))
                {
                    v.add(obj);
                }
            }

            int j1 = 0;
            while (j1 < v.size()) 
            {
                com.cyberlink.youcammakeup.database.more.i.d d1 = (com.cyberlink.youcammakeup.database.more.i.d)v.get(j1);
                a(M, Long.valueOf(d1.a()), beautymode.t(p, d1.d()), SkuTemplateUtils.b(d1.d(), j(p)), z);
                j1++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void a(BeautyMode beautymode, String s1)
    {
    }

    public void a(com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask mask, boolean flag)
    {
        e.a(mask, flag);
        a(false, ((ch) (null)));
    }

    protected void a(com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl skutryiturl)
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
                    if (h != null)
                    {
                        int k1 = c(skutryiturl);
                        if (k1 >= 0)
                        {
                            i.a(k1, true);
                            i.a(h.getView(k1, null, i), k1, -1L);
                            i.post(new Runnable(k1) {

                                final int a;
                                final BeautyToolPanel b;

                                public void run()
                                {
                                    b.i.c(a);
                                }

            
            {
                b = BeautyToolPanel.this;
                a = i1;
                super();
            }
                            });
                            return;
                        }
                    } else
                    {
                        StatusManager.j().a(i1);
                        return;
                    }
                }
            }
        }
    }

    public void a(at at1, String s1)
    {
        if (at1 instanceof ba)
        {
            if (StatusManager.j().s() == BeautyMode.s)
            {
                com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(p, o, s1);
            } else
            {
                ba ba1 = (ba)at1;
                com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(p, ba1.n(), ba1.h());
            }
            at1 = (ba)at1;
            a(p, at1.n(), s1);
            return;
        } else
        {
            a(((String) (null)), ((String) (null)), ((String) (null)));
            return;
        }
    }

    public void a(at at1, boolean flag)
    {
        e.a(at1, flag);
        a(false, ((ch) (null)));
    }

    protected void a(az az1, String s1)
    {
        if (h != null)
        {
            h.a(az1);
            h.b(s1);
            h.c(a(StatusManager.j().s(), az1));
            h.e();
        }
        if (q() != 0)
        {
            c(true);
        }
    }

    public void a(ch ch1)
    {
        int i1 = a.findViewById(0x7f0c0676).getHeight();
        af.animate().setInterpolator(new DecelerateInterpolator()).translationY(0.0F);
        l.setAlpha(0.5F);
        l.setTranslationY(i1);
        l.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F).translationY(0.0F).setListener(ch1);
    }

    public void a(PreferColorMode prefercolormode)
    {
        G = prefercolormode;
    }

    public void a(Boolean boolean1)
    {
        if (T != null && U != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (boolean1 != null)
        {
            break; /* Loop/switch isn't completed */
        }
        T.setSelected(false);
        U.setSelected(false);
        if (e != null)
        {
            e.a("assets://makeup/eyeshadow/texture_leyeshadow.png");
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (!boolean1.booleanValue())
        {
            break; /* Loop/switch isn't completed */
        }
        T.setSelected(false);
        U.setSelected(true);
        if (e != null)
        {
            e.a("assets://makeup/eyeshadow/texture_eyeshadow_shine.png");
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        T.setSelected(true);
        U.setSelected(false);
        if (e != null)
        {
            e.a("assets://makeup/eyeshadow/texture_leyeshadow.png");
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    protected void a(Long long1)
    {
        BeautyMode beautymode = StatusManager.j().s();
        h h1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b();
        if (long1 != null)
        {
            com.cyberlink.youcammakeup.database.more.i.d d1 = h1.a(p, long1);
            if (beautymode == BeautyMode.s || beautymode == BeautyMode.b || BeautyMode.d(beautymode))
            {
                b(long1);
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b b2 = (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b)c;
                b2.a(d, SkuTemplateUtils.a(d1.d(), p));
                b2.b(h1.s(p, d1.d()));
                b2.a(beautymode, long1);
                com.cyberlink.youcammakeup.clflurry.b.a(new com.cyberlink.youcammakeup.clflurry.af(d1.d(), YMKFeatures.a(beautymode)));
            }
            return;
        }
        if (beautymode != BeautyMode.n && beautymode != BeautyMode.y && beautymode != BeautyMode.t)
        {
            b(((Long) (null)));
            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b b1 = (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b)c;
            b1.a(BitmapFactory.decodeResource(getResources(), 0x7f02088f));
            b1.b(getActivity().getString(0x7f0703cf));
            b1.a(beautymode, long1);
            com.cyberlink.youcammakeup.clflurry.b.a(new com.cyberlink.youcammakeup.clflurry.af(null, YMKFeatures.a(beautymode)));
        }
        c(true);
    }

    public void a(Long long1, boolean flag)
    {
        Object obj = null;
        if (o == null || !o.equals(long1))
        {
            o = long1;
            MotionControlHelper.e().x("");
            BeautyMode beautymode;
            if (o != null)
            {
                long1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(p, o);
                if (long1 != null)
                {
                    String s1 = long1.d();
                    MotionControlHelper.e().x(s1);
                    u = long1.e();
                }
            } else
            {
                u = null;
            }
            beautymode = StatusManager.j().s();
            if (c != null)
            {
                Object obj1 = c;
                if (o == null)
                {
                    long1 = null;
                } else
                {
                    long1 = new az(o, p);
                }
                ((com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.k) (obj1)).a(long1);
            }
            if (h != null)
            {
                obj1 = h;
                if (o == null)
                {
                    long1 = obj;
                } else
                {
                    long1 = new az(o, p);
                }
                ((BeautyToolPanelItemAdapter) (obj1)).a(long1);
            }
            if (beautymode == BeautyMode.n)
            {
                if (flag)
                {
                    b(beautymode);
                }
                if (T == null || U == null || V == null)
                {
                    s();
                }
                if (o != null)
                {
                    h(false);
                    T.setVisibility(8);
                    U.setVisibility(8);
                    V.setVisibility(8);
                    return;
                } else
                {
                    T.setVisibility(0);
                    U.setVisibility(0);
                    V.setVisibility(0);
                    return;
                }
            }
        }
    }

    protected void a(String s1)
    {
        boolean flag = false;
        if (N != null)
        {
            for (int i1 = 0; i1 < N.getChildCount(); i1++)
            {
                N.getChildAt(i1).setSelected(false);
            }

            if (s1 != null)
            {
                int j1 = ((flag) ? 1 : 0);
                while (j1 < N.getChildCount()) 
                {
                    Object obj = N.getChildAt(j1).getTag();
                    if (obj instanceof String)
                    {
                        obj = (String)obj;
                        if (s1 != null && s1.compareTo(((String) (obj))) == 0)
                        {
                            N.getChildAt(j1).setSelected(true);
                            return;
                        }
                    }
                    j1++;
                }
            }
        }
    }

    public void a(String s1, Boolean boolean1)
    {
        if (H != null)
        {
            H.a(s1, boolean1);
        }
    }

    protected void a(String s1, Long long1)
    {
        if (StatusManager.j().s() == BeautyMode.r)
        {
            float f1;
            String s2;
            if (s1 != null && s1.equals("Eyebrow_general"))
            {
                if (long1 == null)
                {
                    long1 = MotionControlHelper.e().a("Eyebrow_general");
                } else
                {
                    long1 = MotionControlHelper.e().a("Eyebrow_general_sku");
                }
            } else
            if (long1 == null)
            {
                long1 = MotionControlHelper.e().a("Eyebrow_others");
            } else
            {
                long1 = MotionControlHelper.e().a("Eyebrow_others_sku");
            }
            s2 = StatusManager.j().g();
            s1 = PanelDataCenter.a().b(s1, s2);
            if (long1 != null)
            {
                f1 = ((Float)((Pair) (long1)).first).floatValue();
            } else
            {
                f1 = 0.0F;
            }
            if (s1.size() > 0)
            {
                s1 = Float.valueOf(((Integer)s1.get(0)).intValue());
            } else
            {
                s1 = Float.valueOf(f1);
            }
            if (long1 != null)
            {
                a(s1.floatValue());
                b(((Float)((Pair) (long1)).second).floatValue());
                ArrayList arraylist = new ArrayList();
                arraylist.add(Integer.valueOf(s1.intValue()));
                MotionControlHelper.e().c(arraylist);
                MotionControlHelper.e().a(((Float)((Pair) (long1)).second).floatValue());
            }
            com.cyberlink.youcammakeup.kernelctrl.j.a().e();
        }
    }

    protected void a(String s1, String s2)
    {
        if (s1 == null)
        {
            a(((String) (null)), ((String) (null)), ((String) (null)));
            return;
        } else
        {
            a(p, s1, s2);
            return;
        }
    }

    protected void a(String s1, String s2, String s3)
    {
        Q.setVisibility(8);
        R.setVisibility(8);
        S.setVisibility(8);
        if (s1 != null && s2 != null)
        {
            com.cyberlink.youcammakeup.kernelctrl.sku.h.b().w(s1, s2);
            if (StatusManager.j().s() == BeautyMode.s)
            {
                s3 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(s1, o, s3);
            } else
            {
                s3 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(s1, s2, s3);
            }
            s1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().h(s1, s2);
            if (s1 != null)
            {
                boolean flag;
                if (s3 != null && !s3.c().toString().isEmpty())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    Q.setVisibility(0);
                    return;
                }
                if (s1.equalsIgnoreCase(com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent.ActionName.b.a()))
                {
                    S.setVisibility(0);
                    return;
                }
                if (s1.equalsIgnoreCase(com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent.ActionName.c.a()))
                {
                    R.setVisibility(0);
                    return;
                }
                if (s1.equalsIgnoreCase(com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent.ActionName.a.a()))
                {
                    Q.setVisibility(0);
                    return;
                }
            }
            while (false) 
            {
                if (s3 != null)
                {
                    s2 = s3.c().toString();
                    s1 = s3.b().toString();
                    s3.d().toString();
                } else
                {
                    s1 = "";
                    s2 = "";
                }
                if (!s2.isEmpty())
                {
                    Q.setVisibility(0);
                }
                if (!s1.isEmpty())
                {
                    R.setVisibility(0);
                    return;
                }
            }
        }
    }

    public void a(String s1, boolean flag)
    {
        if (s1 == null)
        {
            return;
        } else
        {
            StatusManager.j().b(s1);
            StatusManager.j().a(s1, flag, new Float[0]);
            return;
        }
    }

    public transient void a(String s1, boolean flag, Float afloat[])
    {
        StatusManager.j().b(s1);
        break MISSING_BLOCK_LABEL_7;
_L5:
        do
        {
            return;
        } while (c == null || b == null || m);
        BeautyMode beautymode = StatusManager.j().s();
        if (BeautyMode.d(beautymode) && s1 != null)
        {
            aw aw1;
            if (e != null)
            {
                e.a();
                afloat = MotionControlHelper.e().y(s1);
            } else
            {
                afloat = null;
            }
            if (afloat == null)
            {
                afloat = PanelDataCenter.a().b(s1);
                if (afloat != null && afloat.a() > 0 && afloat.b(0) != null)
                {
                    afloat = afloat.b(0);
                    a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (afloat)), true);
                    MotionControlHelper.e().a(s1, afloat);
                }
            } else
            {
                a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (afloat)), true);
            }
            afloat = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(p, o);
            if (afloat == null)
            {
                f(((String) (null)));
            } else
            {
                a(afloat.d(), s1);
            }
        }
        afloat = MotionControlHelper.e().M().c();
        aw1 = PanelDataCenter.a().i(MotionControlHelper.e().M().c());
        if (aw1 != null && aw1.k() != null || beautymode == BeautyMode.n && aw1 != null && s1 != null)
        {
            afloat = PanelDataCenter.a().b(s1, afloat);
            if (afloat != null && afloat.size() > 0)
            {
                a(((Integer)afloat.get(0)).intValue());
            } else
            {
                afloat = new ArrayList();
                afloat.add(Integer.valueOf(K()));
            }
        } else
        {
            afloat = new ArrayList();
            afloat.add(Integer.valueOf(K()));
        }
        Globals.d().j().c(afloat);
        a(StatusManager.j().s(), s1);
        if (b == null || e == null) goto _L2; else goto _L1
_L1:
        b.a(e);
        if (!(e instanceof com.cyberlink.youcammakeup.widgetpool.common.a.j)) goto _L4; else goto _L3
_L3:
        ((com.cyberlink.youcammakeup.widgetpool.common.a.j)e).a(PanelDataCenter.a().i(MotionControlHelper.e().M().c()), true);
_L2:
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
        if (true) goto _L5; else goto _L4
_L4:
        afloat = PanelDataCenter.a().c(beautymode);
        if (afloat != null)
        {
            b.a(afloat, true);
        }
          goto _L2
    }

    public void a(boolean flag)
    {
        m = flag;
    }

    public void a(boolean flag, ch ch1)
    {
        while (!n || M == null || m || p() && !flag) 
        {
            return;
        }
        boolean flag1 = flag;
        if (M != null)
        {
            flag1 = flag;
            if (M.getChildCount() <= 0)
            {
                flag1 = false;
            }
        }
        if (o == null)
        {
            flag1 = false;
        }
        if (flag1)
        {
            if (c != null && (c instanceof com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b))
            {
                ((com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b)c).c(true);
            }
            ch1 = new ch(ch1) {

                final ch a;
                final BeautyToolPanel b;

                public void onAnimationEnd(Animator animator)
                {
                    if (a != null)
                    {
                        a.onAnimationEnd(animator);
                    }
                    if (b.b != null && !b.b.isFinishing())
                    {
                        int i1;
                        if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.d(b) != null)
                        {
                            i1 = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.d(b).getHeight();
                        } else
                        {
                            i1 = 0;
                        }
                        b.b.c(i1 + b.l.getHeight() + b.j.getHeight());
                    }
                }

            
            {
                b = BeautyToolPanel.this;
                a = ch1;
                super();
            }
            };
            BeautyMode beautymode = StatusManager.j().s();
            n(false);
            h(false);
            i(false);
            e(false);
            if (beautymode != BeautyMode.s && !BeautyMode.d(beautymode))
            {
                c(false);
            }
            if (f != null && (beautymode == BeautyMode.s || beautymode == BeautyMode.t || BeautyMode.d(beautymode) || beautymode == BeautyMode.x))
            {
                d(false);
                a(8);
            }
            l.setVisibility(0);
            a(ch1);
            return;
        }
        BeautyMode beautymode1 = StatusManager.j().s();
        ch1 = new ch(ch1) {

            final ch a;
            final BeautyToolPanel b;

            public void onAnimationEnd(Animator animator)
            {
                if (b.c != null && (b.c instanceof com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b))
                {
                    ((com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b)b.c).c(false);
                }
                b.l.setVisibility(8);
                if (a != null)
                {
                    a.onAnimationEnd(animator);
                }
                if (b.b != null && !b.b.isFinishing())
                {
                    int i1;
                    if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.d(b) != null)
                    {
                        i1 = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.d(b).getHeight();
                    } else
                    {
                        i1 = 0;
                    }
                    b.b.c(i1 + b.u());
                }
                b.e(true);
            }

            
            {
                b = BeautyToolPanel.this;
                a = ch1;
                super();
            }
        };
        n(true);
        e(true);
        if (beautymode1 == BeautyMode.r || beautymode1 == BeautyMode.s)
        {
            b(StatusManager.j().e(), ((String) (null)));
        } else
        {
            h(true);
        }
        g(((String) (null)));
        if (f != null && (beautymode1 == BeautyMode.s && !"default_original_eye_contact".equals(StatusManager.j().e()) || BeautyMode.d(beautymode1) || beautymode1 == BeautyMode.x && !"default_original_wig".equals(StatusManager.j().e())))
        {
            h(beautymode1);
            d(true);
        }
        c(true);
        b(ch1);
    }

    public void a(boolean flag, boolean flag1)
    {
        Object obj;
        int i1;
        boolean flag2;
        for (flag2 = false; m || ac == null || b == null || b.Z() == null || ad == null;)
        {
            return;
        }

        if (q() == 0)
        {
            a(false, ((ch) (null)));
        }
        if (c != null && (c instanceof com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b))
        {
            ((com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b)c).c(flag);
        }
        obj = StatusManager.j().s();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_361;
        }
        if (obj == BeautyMode.s || BeautyMode.d(((BeautyMode) (obj))) || obj == BeautyMode.x)
        {
            d(false);
        } else
        {
            c(false);
        }
        if (!flag1) goto _L2; else goto _L1
_L1:
        ad.setChoiceMode(1);
        obj = (com.cyberlink.youcammakeup.widgetpool.d.a)ad.getAdapter();
        i1 = 0;
_L3:
        if (i1 < ((com.cyberlink.youcammakeup.widgetpool.d.a) (obj)).getCount())
        {
            com.cyberlink.youcammakeup.widgetpool.d.c c1 = ((com.cyberlink.youcammakeup.widgetpool.d.a) (obj)).a(i1);
            if (u == null && c1 != null && c1.a().equals(getActivity().getString(0x7f0703cf)))
            {
                ad.setItemChecked(i1, true);
            } else
            {
label0:
                {
                    if (c1 == null || u == null || !u.equals(c1.a()))
                    {
                        break label0;
                    }
                    ad.setItemChecked(i1, true);
                }
            }
        }
_L4:
        if (K != null)
        {
            obj = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f();
            obj.a = true;
            K.b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c, ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.f) (obj)));
        }
        h(false);
        n(false);
        i(false);
        a(false, true, ((String) (null)), ((String) (null)));
        e(false);
        ac.setVisibility(0);
        c(((ch) (null)));
_L5:
        flag1 = flag2;
        if (!flag)
        {
            flag1 = true;
        }
        j(flag1);
        return;
        i1++;
          goto _L3
_L2:
        ad.setChoiceMode(0);
          goto _L4
        if (l.getVisibility() != 0)
        {
            h(true);
            n(true);
            c(true);
            a(false, false, StatusManager.j().e(), ((String) (null)));
            if (obj == BeautyMode.y && c != null && (c instanceof HairDyeToolPanelMenu))
            {
                ((HairDyeToolPanelMenu)c).h();
            } else
            {
                b(StatusManager.j().e(), ((String) (null)));
            }
        }
        d(new ch() {

            final BeautyToolPanel a;

            public void onAnimationEnd(Animator animator)
            {
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.r(a).setVisibility(8);
                a.e(true);
            }

            
            {
                a = BeautyToolPanel.this;
                super();
            }
        });
          goto _L5
    }

    public void a(boolean flag, boolean flag1, String s1, String s2)
    {
        BeautyMode beautymode = StatusManager.j().s();
        if (beautymode == BeautyMode.s || BeautyMode.d(beautymode) || beautymode == BeautyMode.x)
        {
            if (q() == 0)
            {
                flag1 = true;
            }
            if (flag)
            {
                a(0);
                return;
            }
            if (flag1)
            {
                a(8);
                return;
            }
            if (s1 != null && f != null)
            {
                if (s1.equals("default_original_eye_contact") || s1.equals("default_original_wig"))
                {
                    d(false);
                    a(8);
                    return;
                }
                if (s2 != null && s1.equals(s2))
                {
                    if (m() == 0)
                    {
                        d(false);
                        a(4);
                        return;
                    } else
                    {
                        d(true);
                        h(beautymode);
                        return;
                    }
                } else
                {
                    d(true);
                    h(beautymode);
                    return;
                }
            }
        }
    }

    protected boolean a(Long long1, Long long2)
    {
        if ((long1 != null || long2 == null) && (long1 == null || long2 != null))
        {
            if (long1 == null && long2 == null)
            {
                return true;
            }
            if (long1 != null && long2 != null)
            {
                return long1.equals(long2);
            }
        }
        return false;
    }

    public void b()
    {
        YMKSavingPageEvent.a(true);
        StatusManager.j().a(Boolean.valueOf(false));
        k();
        long l1 = StatusManager.j().l();
        if (!com.cyberlink.youcammakeup.database.g.a(l1) && !com.cyberlink.youcammakeup.kernelctrl.viewengine.i.a(l1) || K == null)
        {
            i();
            return;
        }
        b.V();
        Object obj = (ImageViewer)getActivity().findViewById(0x7f0c0720);
        if (obj != null)
        {
            ((ImageViewer) (obj)).q();
        }
        obj = StatusManager.j().s();
        if (obj == BeautyMode.x)
        {
            MotionControlHelper.e().j(true);
            MotionControlHelper.e().l(true);
            MotionControlHelper.e().V();
            MotionControlHelper.e().k();
            if (b != null)
            {
                b.q(false);
            }
            MotionControlHelper.e().a(null, false);
            return;
        }
        if (BeautyMode.d(((BeautyMode) (obj))))
        {
            MotionControlHelper.e().j(true);
            if (b != null)
            {
                b.r(false);
            }
            MotionControlHelper.e().a(null, false);
            return;
        }
        if (obj == BeautyMode.y)
        {
            MotionControlHelper.e().k(true);
            VenusHelper.a().b(false);
            VenusHelper.a().a(null);
            MotionControlHelper.e().a(null, false);
            return;
        } else
        {
            j();
            return;
        }
    }

    public void b(float f1)
    {
        if (Z == null)
        {
            return;
        } else
        {
            Z.setOnSeekBarChangeListener(null);
            Z.setProgressAndThumb((int)f1);
            Z.setOnSeekBarChangeListener(B);
            return;
        }
    }

    public void b(ImageStateChangedEvent imagestatechangedevent)
    {
        o();
    }

    protected void b(com.cyberlink.youcammakeup.kernelctrl.status.a a1)
    {
        BeautyMode beautymode;
        beautymode = StatusManager.j().s();
        i i1;
        if (a1.f() == null)
        {
            i1 = new i();
        } else
        {
            i1 = new i(a1.f().g());
        }
        if (i1 != null)
        {
            if (beautymode == BeautyMode.n)
            {
                r r1 = i1.b();
                if (r1 != null && r1.c() == null)
                {
                    BeautifierEditCenter.a().a(null);
                    a1.f().a(null);
                }
            }
            if (beautymode == BeautyMode.r)
            {
                a1 = i1.a();
                if (a1 != null && a1.b() != null)
                {
                    StatusManager.j().b(a1.b());
                    com.cyberlink.youcammakeup.kernelctrl.j.a().e();
                }
            }
            if (beautymode == BeautyMode.x)
            {
                a1 = i1.u();
                if (a1 != null)
                {
                    VenusHelper.a().h();
                    VenusHelper.a().b(a1.a());
                }
            }
            if (beautymode == BeautyMode.y)
            {
                if (i1.C() != null)
                {
                    VenusHelper.a().a(false, false, null);
                    VenusHelper.a().b(true);
                } else
                {
                    VenusHelper.a().a(false, true, null);
                    VenusHelper.a().b(false);
                }
            }
        }
        if (beautymode != BeautyMode.x) goto _L2; else goto _L1
_L1:
        MotionControlHelper.e().j(true);
        MotionControlHelper.e().l(true);
        if (b != null)
        {
            b.q(false);
        }
_L4:
        StatusManager.j().a(i1);
        return;
_L2:
        if (BeautyMode.d(beautymode))
        {
            MotionControlHelper.e().j(true);
            if (b != null)
            {
                b.r(false);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void b(BeautyMode beautymode)
    {
        if (beautymode == BeautyMode.n)
        {
            O = (ViewGroup)a.findViewById(0x7f0c0681);
            N = (ViewGroup)a.findViewById(0x7f0c0682);
            if (N != null && O != null)
            {
                beautymode = new android.view.View.OnClickListener() {

                    final BeautyToolPanel a;

                    public void onClick(View view)
                    {
                        view = (String)view.getTag();
                        a.a(view);
                        a.c.a(view, new Float[0]);
                    }

            
            {
                a = BeautyToolPanel.this;
                super();
            }
                };
                O.setVisibility(8);
                N.removeAllViews();
                n(true);
                if (o == null)
                {
                    a(((String) (null)), ((String) (null)), ((String) (null)));
                    return;
                }
                h h1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b();
                com.cyberlink.youcammakeup.database.more.i.d d1 = h1.a(p, o);
                a(N);
                Iterator iterator = d1.l().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    com.cyberlink.youcammakeup.database.more.i.e e1 = (com.cyberlink.youcammakeup.database.more.i.e)iterator.next();
                    if (e1 != null)
                    {
                        a(N, e1.a(), h1.f(p, d1.d(), e1.a()), h1.b(p, d1.d(), e1.a()), beautymode);
                    }
                } while (true);
                a(StatusManager.j().g());
                return;
            }
        }
    }

    public void b(ch ch1)
    {
        if (l.getHeight() == 0)
        {
            ch1.onAnimationEnd(null);
            return;
        }
        View view = a.findViewById(0x7f0c0677);
        int i1;
        int j1;
        if (g.getVisibility() == 0)
        {
            i1 = view.getHeight();
        } else
        {
            i1 = 0;
        }
        j1 = l.getHeight();
        af.animate().setInterpolator(new DecelerateInterpolator()).translationY(j1 - i1);
        l.animate().setInterpolator(new DecelerateInterpolator()).alpha(0.5F).translationY(j1).setListener(ch1);
    }

    protected void b(Long long1)
    {
        if (M != null)
        {
            U();
            int i1 = 0;
            while (i1 < M.getChildCount()) 
            {
                Long long2 = (Long)M.getChildAt(i1).getTag();
                if (long1 == null && long2 == null)
                {
                    M.getChildAt(i1).setSelected(true);
                    return;
                }
                if (long1 != null && long2 != null && long1.compareTo(long2) == 0)
                {
                    M.getChildAt(i1).setSelected(true);
                    return;
                }
                i1++;
            }
        }
    }

    public void b(String s1)
    {
        if (b != null && i != null && g != null)
        {
            BeautyToolPanelItemAdapter.DeletableItemPosition deletableitemposition = null;
            az az1 = deletableitemposition;
            if (n)
            {
                az1 = deletableitemposition;
                if (o != null)
                {
                    az1 = new az(o, p);
                }
            }
            BeautyMode beautymode = StatusManager.j().s();
            boolean flag = a(beautymode, az1);
            android.content.DialogInterface.OnDismissListener ondismisslistener;
            int i1;
            if (beautymode == BeautyMode.l || beautymode == BeautyMode.m || beautymode == BeautyMode.x || BeautyMode.d(beautymode))
            {
                deletableitemposition = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanelItemAdapter.DeletableItemPosition.a;
            } else
            {
                deletableitemposition = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanelItemAdapter.DeletableItemPosition.b;
            }
            ondismisslistener = new android.content.DialogInterface.OnDismissListener() {

                final BeautyToolPanel a;

                public void onDismiss(DialogInterface dialoginterface)
                {
                    if (a.h != null && (!Globals.d().i().a() || Globals.d().i().b()))
                    {
                        a.i.setChoiceMode(1);
                        a.i.a(a.h.c(), true);
                        a.h.a(false);
                        if (a.k != null)
                        {
                            a.k.setClickable(false);
                        }
                    }
                }

            
            {
                a = BeautyToolPanel.this;
                super();
            }
            };
            h = new BeautyToolPanelItemAdapter(getActivity(), beautymode, s1, flag, deletableitemposition, az1);
            h.a(new android.view.View.OnClickListener() {

                final BeautyToolPanel a;

                private void a(int j1, int k1, String s2)
                {
                    if (j1 != k1) goto _L2; else goto _L1
_L1:
                    if (s2 != null) goto _L4; else goto _L3
_L3:
                    k1 = j1;
                    if (j1 == a.h.getCount())
                    {
                        k1 = j1 - 1;
                    }
                    s2 = a.h.a(k1).c;
_L8:
                    StatusManager.j().b(s2);
                    StatusManager.j().a(s2, false, new Float[0]);
                    a.h.d(k1);
_L6:
                    return;
_L4:
                    for (j1 = 0; j1 < a.h.getCount(); j1++)
                    {
                        if (a.h.a(j1) != null && a.h.a(j1).c.equals(s2))
                        {
                            k1 = j1;
                            continue; /* Loop/switch isn't completed */
                        }
                    }

                    break; /* Loop/switch isn't completed */
_L2:
                    if (j1 > k1)
                    {
                        a.h.d(j1 - 1);
                        return;
                    }
                    if (true) goto _L6; else goto _L5
_L5:
                    k1 = 1;
                    if (true) goto _L8; else goto _L7
_L7:
                }

                static void a(_cls3 _pcls3, String s2)
                {
                    _pcls3.a(s2);
                }

                private void a(String s2)
                {
                    BeautyMode beautymode1 = StatusManager.j().s();
                    String s3 = StatusManager.j().g();
                    PanelDataCenter.a().a(s2, true);
                    int j1 = a.h.c();
                    int k1 = a.c(s2);
                    a.h.a(beautymode1, s3);
                    if (beautymode1 == BeautyMode.x && a.c != null && (a.c instanceof com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.r))
                    {
                        ((com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.r)a.c).e(s2);
                        a(j1, k1, "default_original_wig");
                    } else
                    {
                        a(j1, k1, null);
                    }
                    if (!a.h.b())
                    {
                        com.cyberlink.youcammakeup.utility.o.c();
                    }
                    a.h.notifyDataSetChanged();
                    if (beautymode1 == BeautyMode.x && a.c != null && (a.c instanceof com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.r))
                    {
                        Globals.a(new Runnable(this, s2) {

                            final String a;
                            final _cls3 b;

                            public void run()
                            {
                                ((com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.r)b.a.c).a(a, "default_original_wig");
                            }

            
            {
                b = _pcls3;
                a = s1;
                super();
            }
                        }, 300L);
                    }
                }

                public void onClick(View view)
                {
                    PanelDataCenter paneldatacenter = PanelDataCenter.a();
                    view = ((View) (view.getTag()));
                    if (!(view instanceof com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.p))
                    {
                        return;
                    }
                    view = ((com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.p)view).c;
                    if (paneldatacenter.g(view))
                    {
                        o o1 = Globals.d().i();
                        o1.c(a.getActivity());
                        o1.a(null, a.getResources().getString(0x7f070335));
                        o1.a(new com.cyberlink.youcammakeup.widgetpool.dialogs.y(true, true, true, true, a.getResources().getString(0x7f070366), a.getResources().getString(0x7f070365)));
                        o1.a(new com.cyberlink.youcammakeup.widgetpool.dialogs.w(this, o1, view) {

                            final o a;
                            final String b;
                            final _cls3 c;

                            public void a(boolean flag)
                            {
                                a.i(c.a.getActivity());
                                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel._cls3.a(c, b);
                            }

                            public void b(boolean flag)
                            {
                                a.i(c.a.getActivity());
                            }

            
            {
                c = _pcls3;
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
                a = BeautyToolPanel.this;
                super();
            }
            });
            i.setAdapter(h);
            i.setOnItemClickListener(new com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.p(beautymode) {

                final BeautyMode a;
                final BeautyToolPanel b;

                public void a(com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.AdapterView adapterview, View view, int j1, long l1)
                {
                    if (!b.m) goto _L2; else goto _L1
_L1:
                    return;
_L2:
                    if (b.h != null && b.h.a())
                    {
                        com.cyberlink.youcammakeup.utility.o.c();
                        b.i.a(b.h.c(), true);
                        return;
                    }
                    adapterview = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.TemplateButton.LayoutType.b;
                    if (view instanceof TemplateButton)
                    {
                        adapterview = ((TemplateButton)view).getLayoutType();
                    }
                    if (j1 != 0 || adapterview != com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.TemplateButton.LayoutType.a || a != BeautyMode.l && a != BeautyMode.m && a != BeautyMode.x && !BeautyMode.d(a)) goto _L4; else goto _L3
_L3:
                    String s2;
                    l1 = -1L;
                    s2 = null;
                    adapterview = CategoryType.e;
                    if (a != BeautyMode.l) goto _L6; else goto _L5
_L5:
                    l1 = CategoryType.a(CategoryType.e);
                    s2 = b.getString(0x7f07033b);
                    adapterview = CategoryType.e;
_L8:
                    if (a == BeautyMode.z)
                    {
                        view = new Intent(view.getContext(), com/cyberlink/youcammakeup/activity/ExtraDownloadCategoryActivity);
                        view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", CategoryType.a(adapterview));
                        view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", s2);
                        view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_TYPE", adapterview);
                        view.putExtra("KEY_EXTRA_DOWNLOAD_BACK_TO_MAIN", false);
                        DownloadUseUtils.a(view, true);
                        b.startActivity(view);
                        return;
                    }
                    break; /* Loop/switch isn't completed */
_L6:
                    if (a == BeautyMode.m)
                    {
                        l1 = CategoryType.a(CategoryType.f);
                        s2 = b.getString(0x7f07033a);
                        adapterview = CategoryType.f;
                    } else
                    if (a == BeautyMode.x)
                    {
                        l1 = CategoryType.a(CategoryType.o);
                        s2 = b.getString(0x7f070501);
                        adapterview = CategoryType.o;
                    } else
                    if (a == BeautyMode.z)
                    {
                        l1 = CategoryType.a(CategoryType.i);
                        s2 = b.getString(0x7f07008c);
                        adapterview = CategoryType.i;
                    } else
                    if (a == BeautyMode.A)
                    {
                        l1 = CategoryType.a(CategoryType.j);
                        s2 = b.getString(0x7f07008d);
                        adapterview = CategoryType.j;
                    } else
                    if (a == BeautyMode.B)
                    {
                        l1 = CategoryType.a(CategoryType.k);
                        s2 = b.getString(0x7f07008e);
                        adapterview = CategoryType.k;
                    } else
                    if (a == BeautyMode.C)
                    {
                        l1 = CategoryType.a(CategoryType.l);
                        s2 = b.getString(0x7f07008b);
                        adapterview = CategoryType.l;
                    } else
                    if (a == BeautyMode.t)
                    {
                        l1 = CategoryType.a(CategoryType.g);
                        s2 = b.getString(0x7f07033d);
                        adapterview = CategoryType.g;
                    }
                    if (true) goto _L8; else goto _L7
_L7:
                    if (l1 != 0x15ab1bL) goto _L10; else goto _L9
_L9:
                    YMKLooksStoreEvent.b(com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent.Source.b.a());
_L11:
                    view = new Intent(view.getContext(), com/cyberlink/youcammakeup/activity/ExtraDownloadActivity);
                    view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", l1);
                    view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", s2);
                    view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_TYPE", adapterview);
                    view.putExtra("KEY_EXTRA_DOWNLOAD_BACK_TO_MAIN", false);
                    view.putExtra("KEY_EXTRA_DOWNLOAD_HIDE_TOP_NEW_TAB", BeautyMode.d(a));
                    DownloadUseUtils.a(view, true);
                    b.startActivity(view);
                    return;
_L10:
                    if (l1 == 0x15ab1cL)
                    {
                        YMKLooksStoreEvent.b(com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent.Source.c.a());
                    }
                    if (true) goto _L11; else goto _L4
_L4:
                    adapterview = StatusManager.j().e();
                    String s3 = b.h.a(j1).c;
                    if (a == BeautyMode.x && b.c != null && (b.c instanceof com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.r))
                    {
                        ((com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.r)b.c).a(adapterview, s3);
                    }
                    if ((a == BeautyMode.s || a == BeautyMode.t || BeautyMode.d(a)) && b.c != null && (b.c instanceof com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b))
                    {
                        ((com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b)b.c).a(adapterview, s3);
                    }
                    if (adapterview == null || !adapterview.equals(s3))
                    {
                        if (BeautyMode.d(a) && PanelDataCenter.a().b(s3).a() < 2)
                        {
                            b.d(false);
                        }
                        b.i.a(j1, true);
                        b.h.d(j1);
                        StatusManager.j().a(s3, false, new Float[0]);
                        view.post(new Runnable(this, view, j1) {

                            final View a;
                            final int b;
                            final _cls4 c;

                            public void run()
                            {
                                ((TemplateButton)a).a(false);
                                c.b.h.a(b, false);
                            }

            
            {
                c = _pcls4;
                a = view;
                b = i1;
                super();
            }
                        });
                        return;
                    }
                    if (true) goto _L1; else goto _L12
_L12:
                }

            
            {
                b = BeautyToolPanel.this;
                a = beautymode;
                super();
            }
            });
            i.setOnItemLongClickListener(new com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.q(ondismisslistener) {

                final android.content.DialogInterface.OnDismissListener a;
                final BeautyToolPanel b;

                public boolean a(com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.AdapterView adapterview, View view, int j1, long l1)
                {
                    while (StatusManager.j().s() == BeautyMode.n || b.h == null || b.h.a() || !b.h.c(j1)) 
                    {
                        return false;
                    }
                    b.i.setChoiceMode(0);
                    b.h.a(true);
                    if (b.i != null)
                    {
                        com.cyberlink.youcammakeup.utility.o.a(b.getFragmentManager(), b.i, a);
                        if (b.k != null)
                        {
                            b.k.setClickable(true);
                        }
                    }
                    return true;
                }

            
            {
                b = BeautyToolPanel.this;
                a = ondismisslistener;
                super();
            }
            });
            i1 = c(StatusManager.j().e());
            h.d(i1);
            i.a(i1, true);
            i.post(new Runnable(i1) {

                final int a;
                final BeautyToolPanel b;

                public void run()
                {
                    if (a >= b.i.getLastVisiblePosition())
                    {
                        b.i.setSelection(a);
                    }
                }

            
            {
                b = BeautyToolPanel.this;
                a = i1;
                super();
            }
            });
            if (q() != 0)
            {
                c(true);
                return;
            }
        }
    }

    void b(String s1, String s2)
    {
        BeautyMode beautymode;
        beautymode = StatusManager.j().s();
        break MISSING_BLOCK_LABEL_7;
label0:
        while (ab == null || ab.getVisibility() == 0) 
        {
            do
            {
                do
                {
                    do
                    {
                        return;
                    } while (beautymode != BeautyMode.s && beautymode != BeautyMode.r || s1 != null && s2 != null && s1.equals(s2) && l != null && l.getVisibility() == 0);
                    if (s1 == null || !s1.equals("default_original_eye_contact"))
                    {
                        break;
                    }
                    if (ab != null && ab.getVisibility() == 0)
                    {
                        i(false);
                        return;
                    }
                } while (true);
                if (beautymode != BeautyMode.s || s2 == null || !s1.equals(s2))
                {
                    continue label0;
                }
                if (ab != null && ab.getVisibility() == 0)
                {
                    i(false);
                    return;
                }
            } while (ab == null || ab.getVisibility() == 0);
            i(true);
            g(((String) (null)));
            return;
        }
        i(true);
        g(((String) (null)));
        return;
    }

    public void b(boolean flag)
    {
        w = flag;
    }

    public void b(boolean flag, ch ch1)
    {
        if (b == null || b.isFinishing())
        {
            return;
        }
        if (flag)
        {
            int i1 = a.findViewById(0x7f0c0680).getHeight();
            b.c(j.getHeight() + i1);
            O.setAlpha(0.5F);
            O.setVisibility(0);
            O.setTranslationY(i1);
            O.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F).translationY(0.0F).setListener(ch1);
            n(false);
            return;
        } else
        {
            ch1 = new ch(ch1) {

                final ch a;
                final BeautyToolPanel b;

                public void onAnimationEnd(Animator animator)
                {
                    if (b.c != null && (b.c instanceof com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b))
                    {
                        ((com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b)b.c).c(false);
                    }
                    animator = new Runnable(this, animator) {

                        final Animator a;
                        final _cls17 b;

                        public void run()
                        {
                            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.i(b.b).setVisibility(8);
                            if (b.a != null)
                            {
                                b.a.onAnimationEnd(a);
                            }
                            if (b.b.b != null && !b.b.b.isFinishing())
                            {
                                b.b.b.c(b.b.j.getHeight());
                            }
                            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.b(b.b, true);
                        }

            
            {
                b = _pcls17;
                a = animator;
                super();
            }
                    };
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.i(b).post(animator);
                }

            
            {
                b = BeautyToolPanel.this;
                a = ch1;
                super();
            }
            };
            O.animate().setInterpolator(new AccelerateInterpolator()).alpha(0.5F).translationY(O.getHeight()).setListener(ch1);
            return;
        }
    }

    protected int c(String s1)
    {
        BeautyToolPanelItemAdapter beautytoolpanelitemadapter;
        int i1;
        int j1;
        beautytoolpanelitemadapter = (BeautyToolPanelItemAdapter)i.getAdapter();
        if (beautytoolpanelitemadapter == null)
        {
            return -1;
        }
        j1 = beautytoolpanelitemadapter.getCount();
        i1 = 0;
_L3:
        com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.p p1;
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        p1 = beautytoolpanelitemadapter.a(i1);
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

    public String c(BeautyMode beautymode)
    {
        Object obj = null;
        i i1 = StatusManager.j().d();
        String s1 = obj;
        if (i1 != null)
        {
            if (beautymode == BeautyMode.m && i1.f() != null && i1.f().b() != null)
            {
                s1 = i1.f().b();
            } else
            {
                if (beautymode == BeautyMode.l && i1.e() != null && i1.e().b() != null)
                {
                    return i1.e().b();
                }
                if (beautymode == BeautyMode.a && i1.g() != null && i1.g().b() != null)
                {
                    return i1.g().b();
                }
                if (beautymode == BeautyMode.r && i1.a() != null && i1.a().b() != null)
                {
                    return i1.a().b();
                }
                if (beautymode == BeautyMode.s && i1.c() != null && i1.c().b() != null)
                {
                    return i1.c().b();
                }
                if (beautymode == BeautyMode.t && i1.d() != null && i1.d().a() != null)
                {
                    return i1.d().a();
                }
                if (beautymode == BeautyMode.x && i1.u() != null && i1.u().b() != null)
                {
                    return i1.u().b();
                }
                if (beautymode == BeautyMode.z && i1.y() != null && i1.y().a() != null)
                {
                    return i1.y().a();
                }
                if (beautymode == BeautyMode.A && i1.z() != null && i1.z().a() != null)
                {
                    return i1.z().a();
                }
                if (beautymode == BeautyMode.B && i1.A() != null && i1.A().a() != null)
                {
                    return i1.A().a();
                }
                s1 = obj;
                if (beautymode == BeautyMode.C)
                {
                    s1 = obj;
                    if (i1.B() != null)
                    {
                        s1 = obj;
                        if (i1.B().a() != null)
                        {
                            return i1.B().a();
                        }
                    }
                }
            }
        }
        return s1;
    }

    public void c()
    {
        a(true);
        if (c != null)
        {
            c.b(true);
        }
        Object obj = StatusManager.j().s();
        Object obj1 = StatusManager.j().e();
        String s1 = StatusManager.j().g();
        StringBuilder stringbuilder = (new StringBuilder()).append("BeautyToolPanel onBack, BeautyMode = ");
        long l1;
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
        obj1 = stringbuilder.append(((String) (obj))).append(" , palette = ");
        if (s1 != null)
        {
            obj = s1;
        } else
        {
            obj = "null";
        }
        obj = ((StringBuilder) (obj1)).append(((String) (obj))).append(" save my look show me again = ").append(ah.b).toString();
        Globals.d().e(((String) (obj)));
        l1 = StatusManager.j().l();
        if (b.p())
        {
            obj = b.r();
        } else
        {
            obj = StatusManager.j().f(Long.valueOf(l1).longValue());
        }
        k();
        (new AsyncTask(((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj))) {

            final com.cyberlink.youcammakeup.kernelctrl.status.a a;
            final BeautyToolPanel b;

            protected transient Void a(Void avoid[])
            {
                MotionControlHelper.e().t();
                MotionControlHelper.e().r();
                MotionControlHelper.e().v();
                return null;
            }

            protected void a(Void void1)
            {
                Object obj2 = null;
                if (a != null && a.f() != null)
                {
                    BeautifierEditCenter.a().a(a.f().f());
                    if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.g(b) != null && com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.g(b).m != null)
                    {
                        y y1;
                        List list;
                        if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.g(b).m.i != null && com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.g(b).m.j >= 0 && com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.g(b).m.i.size() > com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.g(b).m.j)
                        {
                            void1 = ((ar)com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.g(b).m.i.get(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.g(b).m.j)).b;
                        } else
                        {
                            void1 = null;
                        }
                        list = com.cyberlink.youcammakeup.kernelctrl.j.a().g();
                        y1 = obj2;
                        if (list != null)
                        {
                            y1 = obj2;
                            if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.g(b).m.j >= 0)
                            {
                                y1 = obj2;
                                if (list.size() > com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.g(b).m.j)
                                {
                                    y1 = ((ar)com.cyberlink.youcammakeup.kernelctrl.j.a().g().get(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.g(b).m.j)).c;
                                }
                            }
                        }
                        if (void1 != null && y1 != null)
                        {
                            BeautifierEditCenter.a().a(void1, y1, false, new BeautifierTaskInfo(false));
                        }
                    }
                }
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.a(b, true);
                BeautifierManager.a().a(b);
                if (b.b != null && b.b.p())
                {
                    MotionControlHelper.e().n();
                    if (!MotionControlHelper.e().a(StatusManager.j().d(), new BeautifierTaskInfo(false)))
                    {
                        b.a(new BeautifierTaskInfo(false));
                    }
                } else
                {
                    BeautifierEditCenter.a().a(new BeautifierTaskInfo(true));
                }
                if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.f(b) != null)
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.f(b).a(Boolean.valueOf(false));
                }
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            protected void onPostExecute(Object obj2)
            {
                a((Void)obj2);
            }

            protected void onPreExecute()
            {
                b.b(a);
                com.cyberlink.youcammakeup.kernelctrl.j.a().h();
            }

            
            {
                b = BeautyToolPanel.this;
                a = a1;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        b.V();
        obj = (ImageViewer)getActivity().findViewById(0x7f0c0720);
        if (obj != null)
        {
            ((ImageViewer) (obj)).q();
        }
    }

    public void c(long l1)
    {
        getActivity().runOnUiThread(new Runnable() {

            final BeautyToolPanel a;

            public void run()
            {
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.h(a);
            }

            
            {
                a = BeautyToolPanel.this;
                super();
            }
        });
    }

    public void c(ch ch1)
    {
        ch1 = new Runnable(ch1) {

            final ch a;
            final BeautyToolPanel b;

            public void run()
            {
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.r(b).setAlpha(0.5F);
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.r(b).setTranslationX(-com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.r(b).getWidth());
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.r(b).animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F).translationX(0.0F).setListener(a);
            }

            
            {
                b = BeautyToolPanel.this;
                a = ch1;
                super();
            }
        };
        android.view.View.OnLayoutChangeListener onlayoutchangelistener = new android.view.View.OnLayoutChangeListener(ch1) {

            final Runnable a;
            final BeautyToolPanel b;

            public void onLayoutChange(View view, int i1, int j1, int k1, int l1, int i2, int j2, 
                    int k2, int l2)
            {
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.p(b).removeOnLayoutChangeListener(this);
                if (l1 - j1 > 0 && com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.p(b) != null)
                {
                    view = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.r(b).findViewById(0x7f0c0726);
                    j1 = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.p(b).getHeight();
                    k1 = com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.r(b).getHeight() - j1;
                    i1 = k1 - b.j.getHeight();
                    if (i1 <= 0 || com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.p(b).getAdapter().getCount() >= 9)
                    {
                        i1 = k1 / 2;
                        view.setTranslationY(0.0F);
                        view.setBackgroundColor(Color.parseColor("#BFFFFFFF"));
                    } else
                    {
                        view.setTranslationY(-b.j.getHeight());
                        if (i1 < j1 / com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.p(b).getAdapter().getCount())
                        {
                            view.setBackgroundColor(Color.parseColor("#BFFFFFFF"));
                        } else
                        {
                            view.setBackgroundColor(0);
                        }
                    }
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.p(b).getAdapter().getCount();
                    com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.p(b).setY(i1);
                }
                a.run();
            }

            
            {
                b = BeautyToolPanel.this;
                a = runnable;
                super();
            }
        };
        if (ad.getWidth() > 0)
        {
            ch1.run();
            return;
        } else
        {
            ad.addOnLayoutChangeListener(onlayoutchangelistener);
            return;
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
        } else
        {
            long1 = new Runnable(long1) {

                final Long a;
                final BeautyToolPanel b;

                public void run()
                {
                    b.a(a);
                    at at1 = new at(0);
                    BeautyMode beautymode = StatusManager.j().s();
                    Object obj;
                    v v1;
                    Object obj1;
                    Object obj2;
                    if (b.o != null)
                    {
                        b.s.put(b.o, MotionControlHelper.e().M());
                    } else
                    {
                        b.t = MotionControlHelper.e().M();
                    }
                    if (a != null)
                    {
                        az az1 = new az(a, b.p);
                        obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(b.p, a).d();
                        v v2 = (v)b.s.get(a);
                        if (v2 != null)
                        {
                            obj = v2.a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a);
                            ((at) (obj)).a(v2.b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a).intValue());
                            obj1 = az1;
                            v1 = v2;
                        } else
                        {
                            obj = SkuTemplateUtils.d(((String) (obj)));
                            if (obj != null)
                            {
                                obj2 = ((aw) (obj)).i();
                            } else
                            {
                                obj2 = null;
                            }
                            v1 = v2;
                            obj = at1;
                            obj1 = az1;
                            if (obj2 != null)
                            {
                                v1 = v2;
                                obj = at1;
                                obj1 = az1;
                                if (((List) (obj2)).size() > 0)
                                {
                                    obj = (at)((List) (obj2)).get(0);
                                    v1 = v2;
                                    obj1 = az1;
                                }
                            }
                        }
                    } else
                    {
                        v1 = b.t;
                        if (v1 == null)
                        {
                            obj = PanelDataCenter.a().c(beautymode);
                        } else
                        {
                            obj = v1.a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a);
                        }
                        obj1 = null;
                    }
                    obj2 = b.a(a, v1, ((at) (obj)));
                    if (b.h != null && (BeautyMode.d(beautymode) || beautymode == BeautyMode.x))
                    {
                        b.a(((az) (obj1)), null);
                    }
                    b.d(((String) (obj2)));
                    b.a(a, false);
                    b.e.a(((az) (obj1)));
                    b.e.a();
                    if (BeautyMode.d(beautymode))
                    {
                        obj1 = MotionControlHelper.e().y(((String) (obj2)));
                        if (obj1 == null)
                        {
                            obj1 = PanelDataCenter.a().b(((String) (obj2)));
                            if (obj1 != null && ((com.cyberlink.youcammakeup.utility.am) (obj1)).a() > 0 && ((com.cyberlink.youcammakeup.utility.am) (obj1)).b(0) != null)
                            {
                                obj1 = ((com.cyberlink.youcammakeup.utility.am) (obj1)).b(0);
                                b.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj1)), true);
                                MotionControlHelper.e().a(((String) (obj2)), ((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj1)));
                            }
                        } else
                        {
                            b.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj1)), true);
                        }
                        obj1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(b.p, b.o);
                        if (obj1 == null)
                        {
                            b.f(null);
                        } else
                        {
                            b.a(((com.cyberlink.youcammakeup.database.more.i.d) (obj1)).d(), ((String) (obj2)));
                        }
                    } else
                    if (obj != null)
                    {
                        b.a(((at) (obj)), true);
                        b.a(((at) (obj)), ((String) (obj2)));
                    }
                    if (obj2 != null && !((String) (obj2)).equals(StatusManager.j().e()))
                    {
                        StatusManager.j().b(((String) (obj2)));
                        MotionControlHelper.e().t();
                        MotionControlHelper.e().a(true);
                        b.a(beautymode, ((String) (obj2)));
                    }
                    b.a(v1, ((String) (obj2)), a, ((at) (obj)));
                    if (BeautyMode.d(beautymode))
                    {
                        StatusManager.j().a(((String) (obj2)), false, new Float[0]);
                    } else
                    {
                        b.c.a(((at) (obj)));
                    }
                    obj = new Runnable(this) {

                        final _cls12 a;

                        public void run()
                        {
                            a.b.a(false, false, StatusManager.j().e(), null);
                            a.b.b(StatusManager.j().e(), null);
                            a.b.g(null);
                            a.b.b(false);
                            a.b.e(true);
                        }

            
            {
                a = _pcls12;
                super();
            }
                    };
                    b.a.post(((Runnable) (obj)));
                }

            
            {
                b = BeautyToolPanel.this;
                a = long1;
                super();
            }
            };
            a.post(long1);
            return;
        }
    }

    protected void c(boolean flag)
    {
        if (g != null && h != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag1;
label0:
        {
            BeautyMode beautymode = StatusManager.j().s();
            flag1 = flag;
            if (h == null)
            {
                break label0;
            }
            flag1 = flag;
            if (h.getCount() > 1)
            {
                break label0;
            }
            if (beautymode != BeautyMode.a && beautymode != BeautyMode.b && beautymode != BeautyMode.l && beautymode != BeautyMode.m && beautymode != BeautyMode.r)
            {
                flag1 = flag;
                if (beautymode != BeautyMode.v)
                {
                    break label0;
                }
            }
            flag1 = false;
        }
        if (flag1)
        {
            if (g.getVisibility() != 0)
            {
                g.setVisibility(0);
                g.setAlpha(0.0F);
                g.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F);
                return;
            }
        } else
        {
            g.setVisibility(8);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public Long d()
    {
        return o;
    }

    protected void d(BeautyMode beautymode)
    {
        Object obj1 = null;
        s = new HashMap();
        p = SkuTemplateUtils.a(beautymode);
        if (p.length() != 0)
        {
            h h1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b();
            r = h1.b(p);
            Object obj;
            Object obj2;
            if (r.size() > 0)
            {
                obj2 = SkuTemplateUtils.a(getActivity());
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
                if (obj2 != null)
                {
                    String s1 = ((com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl) (obj2)).type;
                    if (p.equals(s1))
                    {
                        obj = h1.c(((com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl) (obj2)).skuGuid);
                    }
                } else
                if (DownloadUseUtils.a(getActivity()) != null)
                {
                    obj = null;
                }
                n = true;
                a.findViewById(0x7f0c0662).setVisibility(8);
            } else
            {
                n = false;
                obj = a.findViewById(0x7f0c0678);
                obj2 = a.findViewById(0x7f0c0661);
                if (obj != null)
                {
                    ((View) (obj)).setVisibility(8);
                }
                if (obj2 != null && beautymode != BeautyMode.n)
                {
                    ((View) (obj2)).setVisibility(8);
                }
                obj = null;
            }
            obj2 = StatusManager.j().d();
            if (!n || obj2 == null)
            {
                a(((Long) (obj)), false);
                return;
            }
            if (beautymode == BeautyMode.n && ((i) (obj2)).b() != null && ((i) (obj2)).b().c() != null)
            {
                beautymode = ((i) (obj2)).b().c();
                beautymode = PanelDataCenter.a().i(beautymode);
                if (beautymode != null)
                {
                    if (beautymode.k() != null && !h1.m(beautymode.k(), p))
                    {
                        a(h1.c(beautymode.k()), false);
                        return;
                    } else
                    {
                        a(((Long) (null)), false);
                        return;
                    }
                }
            } else
            {
                if (beautymode == BeautyMode.z && ((i) (obj2)).y() != null && ((i) (obj2)).y().a() != null)
                {
                    if (((i) (obj2)).y().c() != null)
                    {
                        a(h1.c(((i) (obj2)).y().c()), false);
                        return;
                    } else
                    {
                        a(((Long) (null)), false);
                        return;
                    }
                }
                if (beautymode == BeautyMode.A && ((i) (obj2)).z() != null && ((i) (obj2)).z().a() != null)
                {
                    if (((i) (obj2)).z().c() != null)
                    {
                        a(h1.c(((i) (obj2)).z().c()), false);
                        return;
                    } else
                    {
                        a(((Long) (null)), false);
                        return;
                    }
                }
                if (beautymode == BeautyMode.B && ((i) (obj2)).A() != null && ((i) (obj2)).A().a() != null)
                {
                    if (((i) (obj2)).A().c() != null)
                    {
                        a(h1.c(((i) (obj2)).A().c()), false);
                        return;
                    } else
                    {
                        a(((Long) (null)), false);
                        return;
                    }
                }
                if (beautymode == BeautyMode.C && ((i) (obj2)).B() != null && ((i) (obj2)).B().a() != null)
                {
                    if (((i) (obj2)).B().c() != null)
                    {
                        a(h1.c(((i) (obj2)).B().c()), false);
                        return;
                    } else
                    {
                        a(((Long) (null)), false);
                        return;
                    }
                }
                if (beautymode == BeautyMode.x && ((i) (obj2)).u() != null && ((i) (obj2)).u().b() != null)
                {
                    beautymode = PanelDataCenter.a().p(((i) (obj2)).u().b());
                    if (beautymode != null && beautymode.g() != null)
                    {
                        a(h1.c(beautymode.g()), false);
                        return;
                    } else
                    {
                        a(((Long) (null)), false);
                        return;
                    }
                }
                if (beautymode == BeautyMode.b && ((i) (obj2)).i() != null && ((i) (obj2)).i().e() != null)
                {
                    beautymode = ((i) (obj2)).i().e();
                } else
                {
                    beautymode = null;
                }
                if (beautymode == null)
                {
                    a(((Long) (obj)), false);
                    return;
                }
                if (!(beautymode instanceof ba))
                {
                    a(((Long) (null)), false);
                    return;
                }
                beautymode = ((ba)beautymode).n();
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
            }
        }
    }

    public void d(ch ch1)
    {
        ac.animate().setInterpolator(new DecelerateInterpolator()).alpha(0.5F).translationX(-ac.getWidth()).setListener(ch1);
    }

    public void d(String s1)
    {
        if (i == null || h == null)
        {
            return;
        } else
        {
            int i1 = c(s1);
            h.d(i1);
            i.a(i1, true);
            i.post(new Runnable(i1) {

                final int a;
                final BeautyToolPanel b;

                public void run()
                {
                    b.i.c(a);
                }

            
            {
                b = BeautyToolPanel.this;
                a = i1;
                super();
            }
            });
            return;
        }
    }

    public void d(boolean flag)
    {
        Object obj;
        int i1;
        i1 = 0;
        obj = StatusManager.j().s();
        if ((obj == BeautyMode.x || G == com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.PreferColorMode.d || G == com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.PreferColorMode.e) && h != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag1;
        flag1 = flag;
        if (flag)
        {
            flag1 = flag;
            if (BeautyMode.d(((BeautyMode) (obj))))
            {
                flag1 = flag;
                if (PanelDataCenter.a().b(StatusManager.j().e()).a() < 2)
                {
                    flag1 = false;
                }
            }
        }
        h.b(flag1);
        obj = StatusManager.j().e();
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        int j1 = i.getFirstVisiblePosition();
_L3:
        if (i1 < i.getChildCount())
        {
            if (((String) (obj)).equals(h.a(j1 + i1).c))
            {
                ((TemplateButton)i.getChildAt(i1)).e(flag1);
                return;
            }
            break MISSING_BLOCK_LABEL_177;
        }
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        com.pf.common.utility.m.b("BeautyToolPanel", "setAllowShowTopArrow", exception);
        return;
        i1++;
          goto _L3
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void e()
    {
        HashMap hashmap = new HashMap();
        HashMap hashmap1 = new HashMap();
        for (Iterator iterator = x.entrySet().iterator(); iterator.hasNext();)
        {
            Object obj = (java.util.Map.Entry)iterator.next();
            com.cyberlink.youcammakeup.widgetpool.d.c c1 = (com.cyberlink.youcammakeup.widgetpool.d.c)((java.util.Map.Entry) (obj)).getKey();
            obj = (Integer)((java.util.Map.Entry) (obj)).getValue();
            if (c1.b() != null && !c1.b().isEmpty())
            {
                hashmap.put(c1.b(), obj);
            } else
            {
                hashmap1.put(c1.a(), obj);
            }
        }

        if (!hashmap.isEmpty() || !hashmap1.isEmpty())
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new com.cyberlink.youcammakeup.clflurry.r(hashmap, hashmap1, YMKFeatures.a(y)));
        }
        x.clear();
    }

    public void e(BeautyMode beautymode)
    {
        if (b != null && beautymode != BeautyMode.n && n)
        {
            beautymode = LayoutInflater.from(a.getContext()).inflate(0x7f030198, null);
            b.Z().addView(beautymode);
            ac = (ViewGroup)beautymode.findViewById(0x7f0c0725);
            ad = (GridView)ac.findViewById(0x7f0c0727);
            if (ad != null)
            {
                ac.setVisibility(8);
                beautymode = new com.cyberlink.youcammakeup.widgetpool.d.a(com.cyberlink.youcammakeup.kernelctrl.sku.h.b().d(p));
                ad.setAdapter(beautymode);
                ad.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener(beautymode) {

                    final com.cyberlink.youcammakeup.widgetpool.d.a a;
                    final BeautyToolPanel b;

                    public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
                    {
                        adapterview = a.a(i1);
                        if (b.b != null && (b.u == null || !b.u.equals(adapterview.a())))
                        {
                            Globals.d().i().b(b.b);
                        }
                        view = new Runnable(this) {

                            final _cls19 a;

                            public void run()
                            {
                                int i1;
                                boolean flag1;
                                flag1 = true;
                                if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.o(a.b) != null && com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.o(a.b).getChildCount() <= 0)
                                {
                                    return;
                                }
                                if (a.b.o == null || a.b.v == null)
                                {
                                    break MISSING_BLOCK_LABEL_355;
                                }
                                i1 = 0;
_L3:
                                Object obj;
                                if (i1 >= a.b.v.size())
                                {
                                    break MISSING_BLOCK_LABEL_355;
                                }
                                obj = (com.cyberlink.youcammakeup.database.more.i.d)a.b.v.get(i1);
                                if (obj == null || a.b.o.longValue() != ((com.cyberlink.youcammakeup.database.more.i.d) (obj)).a()) goto _L2; else goto _L1
_L1:
                                obj = a.b.o;
_L4:
                                if (obj == null && a.b.v != null && a.b.v.size() > 0)
                                {
                                    obj = Long.valueOf(((com.cyberlink.youcammakeup.database.more.i.d)a.b.v.get(0)).a());
                                }
                                BeautyMode beautymode = StatusManager.j().s();
                                boolean flag;
                                if (a.b.c != null && (a.b.c instanceof com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b) && !BeautyMode.d(beautymode) && beautymode != BeautyMode.x)
                                {
                                    Object obj1 = (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b)a.b.c;
                                    if (obj != null)
                                    {
                                        flag = true;
                                    } else
                                    {
                                        flag = false;
                                    }
                                    ((com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b) (obj1)).d(flag);
                                }
                                a.b.b(((Long) (obj)));
                                obj1 = a.b;
                                if (obj != null && obj != a.b.o)
                                {
                                    flag = flag1;
                                } else
                                {
                                    flag = false;
                                }
                                ((BeautyToolPanel) (obj1)).b(flag);
                                a.b.c(((Long) (obj)));
                                return;
_L2:
                                i1++;
                                  goto _L3
                                obj = null;
                                  goto _L4
                            }

            
            {
                a = _pcls19;
                super();
            }
                        };
                        ch ch1 = new ch(this, view) {

                            final Runnable a;
                            final _cls19 b;

                            public void onAnimationEnd(Animator animator)
                            {
                                a.run();
                            }

            
            {
                b = _pcls19;
                a = runnable;
                super();
            }
                        };
                        com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.p(b).setItemChecked(i1, true);
                        b.u = adapterview.a();
                        b.a(false, true);
                        if (b.x.containsKey(adapterview))
                        {
                            b.x.put(adapterview, Integer.valueOf(((Integer)b.x.get(adapterview)).intValue() + 1));
                        } else
                        {
                            b.x.put(adapterview, Integer.valueOf(1));
                        }
                        b.a(StatusManager.j().s());
                        if (b.v != null && b.v.size() > 1 && !BeautyMode.d(StatusManager.j().s()))
                        {
                            b.a(true, ch1);
                        }
                        view.run();
                    }

            
            {
                b = BeautyToolPanel.this;
                a = a1;
                super();
            }
                });
                return;
            }
        }
    }

    public void e(String s1)
    {
        if (e != null)
        {
            e.a(s1);
        }
    }

    public void e(boolean flag)
    {
        int i1 = 0;
        if (ah == null)
        {
            return;
        }
        if (o == null || u == null || q() == 0 || z() == 0)
        {
            flag = false;
        }
        Object obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(p, o);
        if (obj == null || ((com.cyberlink.youcammakeup.database.more.i.d) (obj)).d() == null || !u.equalsIgnoreCase("Laneige"))
        {
            flag = false;
        }
        boolean flag2 = flag;
        if (obj != null)
        {
            boolean flag1 = flag;
            if (!"LAN_20150611_FD_01".equalsIgnoreCase(((com.cyberlink.youcammakeup.database.more.i.d) (obj)).d()))
            {
                flag1 = flag;
                if (!"LAN_20150611_FD_02".equalsIgnoreCase(((com.cyberlink.youcammakeup.database.more.i.d) (obj)).d()))
                {
                    flag1 = false;
                }
            }
            flag2 = flag1;
            if (ai != null)
            {
                flag2 = flag1;
                if (aj != null)
                {
                    if ("LAN_20150611_FD_01".equalsIgnoreCase(((com.cyberlink.youcammakeup.database.more.i.d) (obj)).d()))
                    {
                        ai.setVisibility(0);
                        aj.setVisibility(8);
                        flag2 = flag1;
                    } else
                    {
                        ai.setVisibility(8);
                        aj.setVisibility(0);
                        flag2 = flag1;
                    }
                }
            }
        }
        f(flag2);
        obj = ah;
        if (!flag2)
        {
            i1 = 8;
        }
        ((View) (obj)).setVisibility(i1);
    }

    public void f()
    {
        if (ad != null && ad.getAdapter() != null)
        {
            ((com.cyberlink.youcammakeup.widgetpool.d.a)ad.getAdapter()).a();
        }
        e();
    }

    public void f(BeautyMode beautymode)
    {
        if (b != null)
        {
            ae = a.findViewById(0x7f0c0674);
            af = a.findViewById(0x7f0c0673);
            if (ae != null && af != null)
            {
                if (!n)
                {
                    j(false);
                    return;
                } else
                {
                    ae.setOnClickListener(new android.view.View.OnClickListener() {

                        final BeautyToolPanel a;

                        public void onClick(View view)
                        {
                            a.a(true, true);
                        }

            
            {
                a = BeautyToolPanel.this;
                super();
            }
                    });
                    return;
                }
            }
        }
    }

    protected void f(String s1)
    {
        a(s1, ((String) (null)));
    }

    public void f(boolean flag)
    {
        if (ak != null)
        {
            View view;
            int i1;
            if (al != null)
            {
                if (flag)
                {
                    ak.startAnimation(al);
                } else
                {
                    ak.clearAnimation();
                }
            }
            view = ak;
            if (flag)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            view.setVisibility(i1);
        }
    }

    protected String g()
    {
        Object obj;
        Object obj1;
        obj1 = StatusManager.j().s();
        obj = PanelDataCenter.a().a(((BeautyMode) (obj1)));
        if (obj == null || ((List) (obj)).size() <= 0) goto _L2; else goto _L1
_L1:
        if (obj1 != BeautyMode.r || !((List) (obj)).contains("Eyebrow_general")) goto _L4; else goto _L3
_L3:
        obj = "Eyebrow_general";
_L11:
        if (obj != null || o == null || obj1 != BeautyMode.s && !BeautyMode.d(((BeautyMode) (obj1))) && obj1 != BeautyMode.x) goto _L6; else goto _L5
_L5:
        obj1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(p, o).l().iterator();
_L9:
        if (!((Iterator) (obj1)).hasNext()) goto _L6; else goto _L7
_L7:
        com.cyberlink.youcammakeup.database.more.i.e e1 = (com.cyberlink.youcammakeup.database.more.i.e)((Iterator) (obj1)).next();
        if (e1 == null || PanelDataCenter.a().p(e1.a()) == null) goto _L9; else goto _L8
_L8:
        return e1.a();
_L4:
        if (obj1 == BeautyMode.s)
        {
            if (o == null)
            {
                obj = "default_original_eye_contact";
                continue; /* Loop/switch isn't completed */
            }
        } else
        if (obj1 == BeautyMode.x)
        {
            if (o == null)
            {
                obj = "default_original_wig";
                continue; /* Loop/switch isn't completed */
            }
        } else
        {
            if (obj1 == BeautyMode.t)
            {
                obj = "default_original_double_eyelid";
                continue; /* Loop/switch isn't completed */
            }
            if (BeautyMode.d(((BeautyMode) (obj1))))
            {
                if (o == null)
                {
                    obj = (String)((List) (obj)).get(0);
                    continue; /* Loop/switch isn't completed */
                }
            } else
            {
                obj = (String)((List) (obj)).get(0);
                continue; /* Loop/switch isn't completed */
            }
        }
          goto _L2
_L6:
        return ((String) (obj));
_L2:
        obj = null;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public void g(BeautyMode beautymode)
    {
        if (b != null && beautymode == BeautyMode.b && n)
        {
            ah = LayoutInflater.from(a.getContext()).inflate(0x7f0301ed, null);
            if (ah != null)
            {
                b.Z().addView(ah);
                ak = ah.findViewById(0x7f0c088c);
                al = AnimationUtils.loadAnimation(I, 0x7f040014);
                f(true);
                ai = ah.findViewById(0x7f0c088a);
                aj = ah.findViewById(0x7f0c088b);
                if (ai != null)
                {
                    ai.setOnClickListener(new android.view.View.OnClickListener() {

                        final BeautyToolPanel a;

                        public void onClick(View view)
                        {
                            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.q(a);
                        }

            
            {
                a = BeautyToolPanel.this;
                super();
            }
                    });
                }
                if (aj != null)
                {
                    aj.setOnClickListener(new android.view.View.OnClickListener() {

                        final BeautyToolPanel a;

                        public void onClick(View view)
                        {
                            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.q(a);
                        }

            
            {
                a = BeautyToolPanel.this;
                super();
            }
                    });
                }
                e(true);
                return;
            }
        }
    }

    protected void g(String s1)
    {
label0:
        {
            BeautyMode beautymode = StatusManager.j().s();
            Object obj;
            h h1;
            String s2;
            if (beautymode == BeautyMode.s || beautymode == BeautyMode.x)
            {
                if (s1 == null)
                {
                    s1 = StatusManager.j().e();
                }
            } else
            {
                s1 = StatusManager.j().g();
            }
            obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(p, o);
            h1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b();
            s2 = p;
            if (obj != null)
            {
                obj = ((com.cyberlink.youcammakeup.database.more.i.d) (obj)).d();
            } else
            {
                obj = null;
            }
            if (h1.e(s2, ((String) (obj)), s1))
            {
                if (beautymode != BeautyMode.s && beautymode != BeautyMode.r && beautymode != BeautyMode.y)
                {
                    break label0;
                }
                i(false);
            }
            return;
        }
        h(false);
    }

    public void g(boolean flag)
    {
        am = flag;
    }

    public void h()
    {
        if (J != null)
        {
            J.a(Boolean.valueOf(false));
        }
        if (H != null)
        {
            H.a(Boolean.valueOf(false));
        }
    }

    void h(BeautyMode beautymode)
    {
        if (BeautyMode.d(beautymode))
        {
            if (o == null)
            {
                a(4);
                return;
            }
            if (PanelDataCenter.a().b(StatusManager.j().e()).a() < 2)
            {
                a(4);
                return;
            } else
            {
                a(0);
                return;
            }
        } else
        {
            a(0);
            return;
        }
    }

    public void h(String s1)
    {
        if (q != null && q.equals(s1))
        {
            return;
        } else
        {
            q = s1;
            a(s1);
            return;
        }
    }

    public void h(boolean flag)
    {
        if (aa != null && (aa.getVisibility() != 0 || !flag))
        {
            ViewGroup viewgroup = aa;
            int i1;
            if (flag)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            viewgroup.setVisibility(i1);
            if (flag && W != null)
            {
                W.setAlpha(0.0F);
                W.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F);
                return;
            }
        }
    }

    public void i()
    {
        com.cyberlink.youcammakeup.kernelctrl.j.a().h();
        StatusManager.j().y();
        MotionControlHelper.e().c(Boolean.valueOf(true));
        (new AsyncTask() {

            final BeautyToolPanel a;

            protected transient Void a(Void avoid[])
            {
                MotionControlHelper.e().q();
                MotionControlHelper.e().t();
                MotionControlHelper.e().r();
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
                a.f();
                com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.e(a);
                a.l();
                Globals.d(new Runnable(this) {

                    final _cls10 a;

                    public void run()
                    {
                        if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.f(a.a) != null)
                        {
                            com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.f(a.a).a(Boolean.valueOf(false));
                        }
                    }

            
            {
                a = _pcls10;
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
                a = BeautyToolPanel.this;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void i(boolean flag)
    {
        if (ab != null && (ab.getVisibility() != 0 || !flag))
        {
            ViewGroup viewgroup = ab;
            int i1;
            if (flag)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            viewgroup.setVisibility(i1);
            if (flag && X != null && Y != null && W != null && Z != null)
            {
                X.setAlpha(0.0F);
                Y.setAlpha(0.0F);
                X.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F);
                Y.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F);
                W.setAlpha(0.0F);
                W.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F);
                Z.setAlpha(0.0F);
                Z.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F);
                return;
            }
        }
    }

    public boolean i(String s1)
    {
        if (h != null)
        {
            return h.a(s1);
        } else
        {
            return false;
        }
    }

    public void j()
    {
        long l1 = StatusManager.j().l();
        com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.DevelopSetting developsetting = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.e.a().a(Long.valueOf(l1), Boolean.valueOf(true));
        ViewEngine.a().a(l1, 1.0D, developsetting, null, new com.cyberlink.youcammakeup.kernelctrl.viewengine.a(l1) {

            final long a;
            final BeautyToolPanel b;

            public void a(com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskCancelType taskcanceltype, String s1, Object obj)
            {
                b.i();
            }

            public void a(com.cyberlink.youcammakeup.kernelctrl.viewengine.q q1, Object obj)
            {
                if (b.b == null || q1 == null || q1 != null && q1.a() == null)
                {
                    b.i();
                } else
                {
                    Object obj1;
                    v v1;
                    List list;
                    if (b.b.p())
                    {
                        obj = b.b.r();
                    } else
                    {
                        obj = StatusManager.j().f(a);
                    }
                    v1 = MotionControlHelper.e().M();
                    list = com.cyberlink.youcammakeup.kernelctrl.j.a().g();
                    obj1 = obj;
                    if (obj == null)
                    {
                        obj1 = new com.cyberlink.youcammakeup.kernelctrl.status.a(a, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.g(b).m.b, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.g(b).m.c, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.g(b).m.d, com.cyberlink.youcammakeup.kernelctrl.j.a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.g(b).m.i), list, ((ar)list.get(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.g(b).m.j)).c.b(), ((ar)list.get(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.g(b).m.j)).c.c(), com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.g(b).m.j, null, v1, "");
                    }
                    b.a(((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)));
                    obj = MotionControlHelper.e().M();
                    ((v) (obj)).a(StatusManager.j().d());
                    if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.g(b) != null && com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.g(b).m != null)
                    {
                        obj = new com.cyberlink.youcammakeup.kernelctrl.status.a(a, q1.a().b(), q1.a().c(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).d, com.cyberlink.youcammakeup.kernelctrl.j.a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.g(b).m.i), com.cyberlink.youcammakeup.kernelctrl.j.a().g(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).a(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).b(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).e, ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).c(), ((v) (obj)), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).g());
                        if (b.b.p() && StatusManager.j().s() != BeautyMode.x)
                        {
                            b.b.a(((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)));
                            b.b.runOnUiThread(new Runnable(this) {

                                final _cls11 a;

                                public void run()
                                {
                                    a.b.i();
                                }

            
            {
                a = _pcls11;
                super();
            }
                            });
                            return;
                        } else
                        {
                            StatusManager.j().a(((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)), q1.a(), new com.cyberlink.youcammakeup.d(this) {

                                final _cls11 b;

                                public void a()
                                {
                                    b.b.i();
                                }

                                public void b()
                                {
                                    b.b.i();
                                }

                                public void c()
                                {
                                    b.b.i();
                                }

            
            {
                b = _pcls11;
                super();
            }
                            });
                            return;
                        }
                    }
                }
            }

            public void a(String s1, Object obj)
            {
                b.i();
            }

            
            {
                b = BeautyToolPanel.this;
                a = l1;
                super();
            }
        });
    }

    public void j(boolean flag)
    {
        if (af == null)
        {
            return;
        }
        if (flag)
        {
            af.setVisibility(0);
            return;
        } else
        {
            af.setVisibility(8);
            return;
        }
    }

    protected void k()
    {
        Globals.d().i().a(Globals.d().t(), 1500L);
    }

    public void k(boolean flag)
    {
        if (V != null)
        {
            V.setEnabled(flag);
        }
    }

    protected void l()
    {
        Globals.d().i().h(Globals.d().t());
    }

    public void l(boolean flag)
    {
        if (g != null && (g instanceof FixedAspectRatioFrameLayout))
        {
            ((FixedAspectRatioFrameLayout)g).setInterceptTouchEvent(flag);
        }
    }

    public int m()
    {
        if (f == null)
        {
            return 8;
        } else
        {
            return f.getVisibility();
        }
    }

    public void m(boolean flag)
    {
        boolean flag1 = false;
        if (a != null)
        {
            View view = a.findViewById(0x7f0c0687);
            View view1 = a.findViewById(0x7f0c0688);
            if (view != null && view1 != null)
            {
                int i1;
                if (flag)
                {
                    i1 = 8;
                } else
                {
                    i1 = 0;
                }
                view.setVisibility(i1);
                if (flag)
                {
                    i1 = ((flag1) ? 1 : 0);
                } else
                {
                    i1 = 8;
                }
                view1.setVisibility(i1);
            }
        }
    }

    public void n()
    {
        if (i != null)
        {
            for (int i1 = 0; i1 < i.getCount(); i1++)
            {
                i.a(i1, false);
            }

            i.c(0);
            h.d(-1);
        }
    }

    protected void o()
    {
        az az1 = null;
        long l1 = StatusManager.j().l();
        Object obj = (EditViewActivity)getActivity();
        boolean flag1;
        if (obj != null)
        {
            flag1 = ((EditViewActivity) (obj)).A();
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            obj = StatusManager.j().j(l1);
        } else
        {
            obj = StatusManager.j().g(l1);
        }
        if (obj != null)
        {
            obj = ((com.cyberlink.youcammakeup.kernelctrl.status.d) (obj)).e();
            if (obj != null)
            {
                BeautyMode beautymode = StatusManager.j().s();
                v v1 = ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)).f();
                if (v1 != null && (v1.a() != null || beautymode == BeautyMode.b))
                {
                    if (beautymode == BeautyMode.b)
                    {
                        obj = v1.a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a);
                        boolean flag;
                        if (obj instanceof ba)
                        {
                            obj = ((ba)obj).n();
                            obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().c(((String) (obj)));
                        } else
                        {
                            obj = null;
                        }
                        if (obj != o || obj != null && !((Long) (obj)).equals(o))
                        {
                            a(((Long) (obj)));
                            a(((Long) (obj)), true);
                            com.cyberlink.youcammakeup.widgetpool.common.a.d d1 = e;
                            if (obj != null)
                            {
                                az1 = new az(o, p);
                            }
                            d1.a(az1);
                            e.a();
                            a(beautymode);
                            b(((Long) (obj)));
                        }
                    }
                    a(beautymode, v1.a());
                    if (beautymode == BeautyMode.n)
                    {
                        n();
                        flag = false;
                    } else
                    {
                        StatusManager.j().b(v1.a());
                        flag = true;
                    }
                } else
                {
                    obj = PanelDataCenter.a().a(beautymode);
                    if (obj != null && ((List) (obj)).size() > 0)
                    {
                        StatusManager.j().b((String)((List) (obj)).get(0));
                    }
                    flag = true;
                }
                if (flag)
                {
                    d(v1.a());
                }
            }
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        X();
        aa();
        if (b != null)
        {
            b.a(this);
        }
        super.onActivityCreated(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        I = Globals.d();
        bundle = StatusManager.j().s();
        com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel._cls38.a[bundle.ordinal()];
        JVM INSTR tableswitch 1 8: default 68
    //                   1 95
    //                   2 103
    //                   3 103
    //                   4 103
    //                   5 103
    //                   6 103
    //                   7 111
    //                   8 119;
           goto _L1 _L2 _L3 _L3 _L3 _L3 _L3 _L4 _L5
_L1:
        int i1 = 0x7f030174;
_L7:
        a = layoutinflater.inflate(i1, viewgroup, false);
        d(bundle);
        return a;
_L2:
        i1 = 0x7f030177;
        continue; /* Loop/switch isn't completed */
_L3:
        i1 = 0x7f03017b;
        continue; /* Loop/switch isn't completed */
_L4:
        i1 = 0x7f030175;
        continue; /* Loop/switch isn't completed */
_L5:
        i1 = 0x7f030176;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void onDestroyView()
    {
        ab();
        Y();
        super.onDestroyView();
    }

    public void onDetach()
    {
        super.onDetach();
        if (J != null)
        {
            J.a(Boolean.valueOf(false));
            J = null;
        }
    }

    public void onPause()
    {
        f();
        super.onPause();
    }

    public void onStart()
    {
        super.onStart();
        if (h != null)
        {
            ac();
        }
        a(DownloadUseUtils.a(getActivity()));
        a(SkuTemplateUtils.a(getActivity()));
        o(true);
    }

    public boolean p()
    {
        return w;
    }

    public int q()
    {
        if (l != null)
        {
            return l.getVisibility();
        } else
        {
            return 8;
        }
    }

    public int r()
    {
        if (O != null)
        {
            return O.getVisibility();
        } else
        {
            return 8;
        }
    }

    public void s()
    {
        T = a.findViewById(0x7f0c0684);
        U = a.findViewById(0x7f0c0685);
        V = a.findViewById(0x7f0c0686);
        if (T != null)
        {
            T.setOnClickListener(an);
        }
        if (U != null)
        {
            U.setOnClickListener(ao);
        }
        if (V != null)
        {
            V.setEnabled(false);
            V.setOnClickListener(ap);
        }
    }

    public boolean t()
    {
        return am;
    }

    public int u()
    {
        int i1;
        boolean flag;
        i1 = 0;
        flag = false;
        if (StatusManager.j().s() != BeautyMode.n) goto _L2; else goto _L1
_L1:
        int j1;
        int k1;
        if (o == null)
        {
            i1 = a.findViewById(0x7f0c0683).getHeight();
        } else
        {
            i1 = 0;
        }
        if (f.getVisibility() == 0)
        {
            j1 = f.getHeight();
        } else
        {
            j1 = 0;
        }
        k1 = ((flag) ? 1 : 0);
        if (O != null)
        {
            k1 = ((flag) ? 1 : 0);
            if (O.getVisibility() == 0)
            {
                k1 = O.getHeight();
            }
        }
        i1 = k1 + (i1 + j1);
_L4:
        return j.getHeight() + i1;
_L2:
        if (g.getVisibility() == 0)
        {
            i1 = g.getHeight();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public View v()
    {
        return aa;
    }

    public VerticalSeekBar w()
    {
        return W;
    }

    public VerticalSeekBar x()
    {
        return Z;
    }

    public ViewGroup y()
    {
        return ab;
    }

    public int z()
    {
        if (ac == null)
        {
            return 8;
        } else
        {
            return ac.getVisibility();
        }
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/BeautyToolPanel$28$1

/* anonymous class */
    class _cls1
        implements com.cyberlink.youcammakeup.activity.c
    {

        final _cls28 a;

        public void a()
        {
            if (a.a.b != null)
            {
                a.a.b.b(this);
                a.a.a(false);
                if (a.a.c != null)
                {
                    a.a.c.b(false);
                }
                if (a.a.e != null)
                {
                    a.a.e.a(true);
                }
                if (StatusManager.j().s() == BeautyMode.n)
                {
                    a.a.k(MotionControlHelper.e().a(MotionControlHelper.e().C()));
                    return;
                }
            }
        }

            
            {
                a = _pcls28;
                super();
            }
    }


    private class PreferColorMode extends Enum
    {

        public static final PreferColorMode a;
        public static final PreferColorMode b;
        public static final PreferColorMode c;
        public static final PreferColorMode d;
        public static final PreferColorMode e;
        private static final PreferColorMode f[];

        public static PreferColorMode valueOf(String s1)
        {
            return (PreferColorMode)Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/BeautyToolPanel$PreferColorMode, s1);
        }

        public static PreferColorMode[] values()
        {
            return (PreferColorMode[])f.clone();
        }

        static 
        {
            a = new PreferColorMode("SWITCHER", 0);
            b = new PreferColorMode("MAKEUP_TOOL", 1);
            c = new PreferColorMode("MENU", 2);
            d = new PreferColorMode("MENU_PATTERN", 3);
            e = new PreferColorMode("ACCESSORY_MENU", 4);
            f = (new PreferColorMode[] {
                a, b, c, d, e
            });
        }

        private PreferColorMode(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
