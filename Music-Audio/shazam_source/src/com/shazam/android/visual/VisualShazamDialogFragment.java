// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.visual;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.PointF;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import at.markushi.ui.RevealColorView;
import com.google.c.a.a.i;
import com.shazam.android.analytics.TaggingOrigin;
import com.shazam.android.analytics.TaggingStatus;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.session.SessionConfigurable;
import com.shazam.android.analytics.session.SessionManager;
import com.shazam.android.analytics.session.page.Page;
import com.shazam.android.analytics.session.page.VisualShazamPage;
import com.shazam.android.aspects.c.b.a;
import com.shazam.android.fragment.TransitionParams;
import com.shazam.android.k.f.p;
import com.shazam.android.k.f.t;
import com.shazam.android.p.m;
import com.shazam.android.persistence.p.j;
import com.shazam.android.util.o;
import com.shazam.android.util.s;
import com.shazam.android.visual.a.e;
import com.shazam.android.visual.a.f;
import com.shazam.android.visual.a.g;
import com.shazam.android.visual.a.h;
import com.shazam.android.widget.image.LargeBitmapImageView;
import com.shazam.i.b.au.d;
import com.shazam.i.b.aw.b;
import com.shazam.i.b.c;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.model.configuration.visual.VisualShazamConfiguration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.shazam.android.visual:
//            v, y, o, a, 
//            p, r, w, x, 
//            VisualShazamSurfaceViewContainer, t, n, s, 
//            u

public class VisualShazamDialogFragment extends a
    implements SessionConfigurable, v
{

    public static final String aj = (new StringBuilder()).append(com/shazam/android/visual/VisualShazamDialogFragment.getName()).append(".TAG").toString();
    private final s aA = com.shazam.i.b.au.d.a();
    private final Map aB;
    private final com.shazam.android.widget.c.f aC = com.shazam.i.b.ay.a.a.b();
    private final t aD = new p();
    private final j aE = com.shazam.i.b.ah.h.a.a();
    private final Handler aF = com.shazam.i.b.z.a.a();
    private final com.shazam.android.persistence.n.b aG = com.shazam.i.b.ah.f.a();
    private final m aH = new com.shazam.android.p.c();
    private final TaggingStatus aI = com.shazam.i.b.g.b.b();
    private final com.shazam.android.p.e aJ = com.shazam.i.b.r.b.a();
    private final SessionManager aK = com.shazam.i.b.g.c.b.a();
    private final EventAnalytics aL = com.shazam.i.b.g.b.a.a();
    private final VisualShazamConfiguration aM = com.shazam.i.b.n.b.N();
    private final SoundPool aN;
    private final Vibrator aO = com.shazam.i.b.e.a();
    private Toolbar aP;
    private TextView aQ;
    private TextView aR;
    private boolean aS;
    private VisualShazamPage aT;
    private int aU;
    private TextView aV;
    private com.shazam.android.visual.p aW;
    private com.shazam.android.visual.s aX;
    protected RevealColorView ak;
    protected VisualShazamSurfaceViewContainer al;
    protected View am;
    protected ViewFlipper an;
    protected View ao;
    protected View ap;
    protected View aq;
    protected View ar;
    protected View as;
    protected View at;
    protected Button au;
    protected ImageView av;
    protected ImageView aw;
    protected LargeBitmapImageView ax;
    protected View ay;
    private final w az = com.shazam.i.b.aw.b.a();

    public VisualShazamDialogFragment()
    {
        aB = com.shazam.b.a.b.a(com.shazam.android.visual.y.a).a(com.shazam.android.visual.x.b.a, new e(com.shazam.i.b.au.d.a(), com.shazam.i.b.g.b.a.a(), com.shazam.b.a.b.a(com.shazam.i.b.aw.a.b.a(new f())).a(i.c, new com.shazam.android.visual.a.b(com.shazam.i.b.au.e.a(), com.shazam.i.b.c.a().getContentResolver(), new p(), com.shazam.i.b.ay.a.a.b(), com.shazam.i.b.ah.f.e.a(), com.shazam.i.b.aw.a.a.a())).a(i.a, com.shazam.i.b.aw.a.b.a(new h(com.shazam.i.b.c.a(), com.shazam.i.b.au.e.a()))).a(i.g, com.shazam.i.b.aw.a.b.a(new g())))).a(com.shazam.android.visual.x.b.b, new com.shazam.android.visual.o(com.shazam.i.b.an.b.a.a(com.shazam.i.b.g.b.b(), TaggingOrigin.VISUAL_SHAZAM), com.shazam.i.b.au.e.a(), com.shazam.i.o.a.a())).a(com.shazam.android.visual.x.b.c, new com.shazam.android.visual.a(com.shazam.i.b.au.d.a(), com.shazam.i.b.g.b.a.a()));
        SoundPool soundpool;
        if ((new com.shazam.android.p.c()).d())
        {
            soundpool = (new android.media.SoundPool.Builder()).setMaxStreams(1).setAudioAttributes((new android.media.AudioAttributes.Builder()).setContentType(2).setLegacyStreamType(3).build()).build();
        } else
        {
            soundpool = new SoundPool(1, 3, 0);
        }
        aN = soundpool;
        aU = -1;
        aW = com.shazam.android.visual.p.b;
    }

    public static VisualShazamDialogFragment a(TransitionParams transitionparams)
    {
        VisualShazamDialogFragment visualshazamdialogfragment = new VisualShazamDialogFragment();
        visualshazamdialogfragment.setArguments(new Bundle());
        if (visualshazamdialogfragment.aH.e())
        {
            transitionparams.a.offset(0.0F, com.shazam.android.util.o.a());
        }
        visualshazamdialogfragment.getArguments().putParcelable("param_transition_params", transitionparams);
        return visualshazamdialogfragment;
    }

    static void a(VisualShazamDialogFragment visualshazamdialogfragment)
    {
        visualshazamdialogfragment.k().setVisible(true);
    /* block-local class not found */
    class d {}

        visualshazamdialogfragment.ap.setOnClickListener(new d(visualshazamdialogfragment, (byte)0));
    }

    static void a(VisualShazamDialogFragment visualshazamdialogfragment, String s1)
    {
        visualshazamdialogfragment.aL.logEvent(com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_EVENT).withParameters(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, s1).build()).build());
    }

    static j b(VisualShazamDialogFragment visualshazamdialogfragment)
    {
        return visualshazamdialogfragment.aE;
    }

    static t c(VisualShazamDialogFragment visualshazamdialogfragment)
    {
        return visualshazamdialogfragment.aD;
    }

    static com.shazam.android.widget.c.f d(VisualShazamDialogFragment visualshazamdialogfragment)
    {
        return visualshazamdialogfragment.aC;
    }

    static TaggingStatus e(VisualShazamDialogFragment visualshazamdialogfragment)
    {
        return visualshazamdialogfragment.aI;
    }

    static TextView f(VisualShazamDialogFragment visualshazamdialogfragment)
    {
        return visualshazamdialogfragment.aR;
    }

    private void f()
    {
        s s1 = aA;
        com.shazam.android.util.q.a a1 = new com.shazam.android.util.q.a();
        a1.c = 0;
        a1.a = 0x7f090127;
        s1.a(a1.a());
        h();
    }

    static TextView g(VisualShazamDialogFragment visualshazamdialogfragment)
    {
        return visualshazamdialogfragment.aQ;
    }

    private r g()
    {
        return new r(this, j(), getResources());
    }

    static TextView h(VisualShazamDialogFragment visualshazamdialogfragment)
    {
        return visualshazamdialogfragment.aV;
    }

    private void h()
    {
        d();
        a();
    }

    static com.shazam.android.p.e i(VisualShazamDialogFragment visualshazamdialogfragment)
    {
        return visualshazamdialogfragment.aJ;
    }

    private void i()
    {
        MenuItem menuitem = k();
        menuitem.setIcon(aW.d);
        menuitem.setTitle(aW.e);
    }

    static MenuItem j(VisualShazamDialogFragment visualshazamdialogfragment)
    {
        return visualshazamdialogfragment.k();
    }

    private TransitionParams j()
    {
        return (TransitionParams)getArguments().getParcelable("param_transition_params");
    }

    static Handler k(VisualShazamDialogFragment visualshazamdialogfragment)
    {
        return visualshazamdialogfragment.aF;
    }

    private MenuItem k()
    {
        return aP.getMenu().findItem(0x7f110292);
    }

    static EventAnalytics l(VisualShazamDialogFragment visualshazamdialogfragment)
    {
        return visualshazamdialogfragment.aL;
    }

    static void m(VisualShazamDialogFragment visualshazamdialogfragment)
    {
        visualshazamdialogfragment = visualshazamdialogfragment.g();
        visualshazamdialogfragment.b = true;
        visualshazamdialogfragment.a();
    }

    static com.shazam.android.visual.p n(VisualShazamDialogFragment visualshazamdialogfragment)
    {
        return visualshazamdialogfragment.aW;
    }

    static void o(VisualShazamDialogFragment visualshazamdialogfragment)
    {
        visualshazamdialogfragment.aW = visualshazamdialogfragment.az.m_();
        visualshazamdialogfragment.i();
    }

    static w p(VisualShazamDialogFragment visualshazamdialogfragment)
    {
        return visualshazamdialogfragment.az;
    }

    public final void a(x x1)
    {
        y y1 = (y)aB.get(x1.c);
    /* block-local class not found */
    class f {}

        f f1 = new f(getActivity(), x1);
        if (!aS && y1.a(f1, f1, x1, getActivity()))
        {
            aO.vibrate(30L);
            if (aU != -1)
            {
                aN.play(aU, 1.0F, 1.0F, 1, 0, 1.0F);
            }
            a("recognition");
            aS = true;
            x1 = g();
            x1.b = false;
            x1.a();
        }
    }

    protected final void a(String s1)
    {
        if (aT != null)
        {
            aT.setPageEndCause(s1);
        }
        aK.stopSession(this);
    }

    public volatile void configureWith(Page page)
    {
        aT = (VisualShazamPage)page;
    }

    protected final void d()
    {
        az.d();
        al.removeAllViews();
    }

    protected final void e()
    {
        android.support.v4.app.i i1 = getActivity();
        if (i1 == null)
        {
            return;
        }
        try
        {
            az.a(i1, al, this);
            az.l_();
            az.a(new _cls1());
            az.a(new n(ap));
            return;
        }
        catch (com.shazam.android.visual.t t1)
        {
            f();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a(0x7f0c0135);
        b(false);
        try
        {
            aU = aN.load(getActivity(), 0x7f080025, 1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030060, viewgroup, false);
        ak = (RevealColorView)layoutinflater.findViewById(0x7f1101a2);
        am = layoutinflater.findViewById(0x7f1101ba);
        an = (ViewFlipper)layoutinflater.findViewById(0x7f1101bb);
        TextView textview;
        for (viewgroup = aM.b().iterator(); viewgroup.hasNext(); an.addView(textview, new android.view.ViewGroup.LayoutParams(-1, -1)))
        {
            bundle = (String)viewgroup.next();
            textview = new TextView(an.getContext(), null, 0x7f010005);
            textview.setText(bundle);
        }

        al = (VisualShazamSurfaceViewContainer)layoutinflater.findViewById(0x7f1101b8);
    /* block-local class not found */
    class c {}

        al.setOnTouchListener(new c((byte)0));
        ao = layoutinflater.findViewById(0x7f110150);
        ap = layoutinflater.findViewById(0x7f1101bc);
        ar = layoutinflater.findViewById(0x7f1101b9);
        ax = (LargeBitmapImageView)layoutinflater.findViewById(0x7f110136);
        ax.a(0x7f0200cf, 0x7f0f007b);
        aq = layoutinflater.findViewById(0x7f1101be);
        aq.setVisibility(4);
        aq.setBackgroundResource(0x7f020047);
        aP = (Toolbar)layoutinflater.findViewById(0x7f1100b0);
        aP.setNavigationIcon(0x7f020192);
        aP.setBackgroundResource(0x7f0f0098);
    /* block-local class not found */
    class b {}

        aP.setNavigationOnClickListener(new b((byte)0));
        aP.a(0x7f13000c);
    /* block-local class not found */
    class e {}

        aP.setOnMenuItemClickListener(new e((byte)0));
        aW = com.shazam.android.visual.p.b;
        k().setVisible(false);
        ap.setOnClickListener(null);
        i();
        as = layoutinflater.findViewById(0x7f110135);
        av = (ImageView)layoutinflater.findViewById(0x7f110139);
        aw = (ImageView)layoutinflater.findViewById(0x7f11013a);
        at = layoutinflater.findViewById(0x7f11013b);
        au = (Button)layoutinflater.findViewById(0x7f11013c);
        ay = layoutinflater.findViewById(0x7f110283);
        aR = (TextView)layoutinflater.findViewById(0x7f110284);
        aQ = (TextView)layoutinflater.findViewById(0x7f110285);
        aV = (TextView)layoutinflater.findViewById(0x7f110286);
        return layoutinflater;
    }

    public void onPause()
    {
        super.onPause();
        if (aX != null)
        {
            com.shazam.android.visual.s s1 = aX;
            s1.b();
            s1.c();
        }
        h();
    }

    public void onResume()
    {
        super.onResume();
    /* block-local class not found */
    class a {}

        super.f.setOnKeyListener(new a((byte)0));
        aX = new com.shazam.android.visual.s(this, j(), getResources(), aG, aK);
        aX.a();
    }

    public void onStart()
    {
        super.onStart();
        com.shazam.android.activities.c.a.a(getActivity());
    }

    public void onStop()
    {
        super.onStop();
        aN.release();
        android.support.v4.app.i i1 = getActivity();
        i1.setRequestedOrientation(-1);
        if (i1 instanceof u)
        {
            ((u)i1).a();
        }
    }

    public final void u_()
    {
        aL.logEvent(com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.ERROR).withParameters(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "visualshazam").putNotEmptyOrNullParameter(DefinedEventParameterKey.REASON, "camerafailed").build()).build());
        f();
    }


    /* member class not found */
    class _cls1 {}

}
