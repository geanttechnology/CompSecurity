// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.newui;

import adp;
import aeb;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.flurry.android.FlurryAgent;
import ig;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import uv;
import vb;
import vc;
import vd;
import ve;
import vf;
import vg;
import vh;
import vj;
import vl;
import xb;

// Referenced classes of package com.fotoable.beautyui.newui:
//            MNewImageItemView, FlexibleThumbSeekbar

public class MNewSofterFragment extends Fragment
{

    private static String c = "MNewSofterFragment";
    ExecutorService a;
    private SoftenState b;
    private xb d;
    private com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState e;
    private ig f;
    private Bitmap g;
    private ImageView h;
    private float i;
    private float j;
    private float k;
    private FrameLayout l;
    private MNewImageItemView m;
    private MNewImageItemView n;
    private MNewImageItemView o;
    private FlexibleThumbSeekbar p;
    private ImageView q;
    private FrameLayout r;
    private android.view.View.OnTouchListener s;
    private android.widget.SeekBar.OnSeekBarChangeListener t;
    private android.view.View.OnClickListener u;

    public MNewSofterFragment()
    {
        b = SoftenState.Soften;
        i = 0.5F;
        j = 0.0F;
        k = 0.0F;
        a = Executors.newSingleThreadExecutor();
        s = new vd(this);
        t = new ve(this);
        u = new vf(this);
    }

    public static float a(MNewSofterFragment mnewsofterfragment, float f1)
    {
        mnewsofterfragment.i = f1;
        return f1;
    }

    public static Bitmap a(MNewSofterFragment mnewsofterfragment, Bitmap bitmap)
    {
        mnewsofterfragment.g = bitmap;
        return bitmap;
    }

    public static Fragment a(com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState maintoolstate)
    {
        MNewSofterFragment mnewsofterfragment = new MNewSofterFragment();
        mnewsofterfragment.e = maintoolstate;
        return mnewsofterfragment;
    }

    public static ImageView a(MNewSofterFragment mnewsofterfragment)
    {
        return mnewsofterfragment.h;
    }

    public static SoftenState a(MNewSofterFragment mnewsofterfragment, SoftenState softenstate)
    {
        mnewsofterfragment.b = softenstate;
        return softenstate;
    }

    private void a()
    {
        o.setSelected(false);
        n.setSelected(false);
        m.setSelected(false);
        if (b != SoftenState.White) goto _L2; else goto _L1
_L1:
        o.setSelected(true);
        p.setProgress((int)(j * 100F));
_L4:
        FlurryAgent.logEvent((new StringBuilder()).append("SoftenBeauty_").append(b.toString()).toString());
        return;
_L2:
        if (b == SoftenState.Soften)
        {
            n.setSelected(true);
            p.setProgress((int)(i * 100F));
        } else
        if (b == SoftenState.Skin)
        {
            m.setSelected(true);
            p.setProgress((int)(k * 100F));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(View view, int i1, int j1, long l1, boolean flag)
    {
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        if (view.getVisibility() != 0)
        {
            return;
        }
        try
        {
            TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, i1, j1);
            translateanimation.setDuration(l1);
            translateanimation.setInterpolator(new DecelerateInterpolator());
            translateanimation.setAnimationListener(new vc(this, flag, view));
            view.startAnimation(translateanimation);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
    }

    public static void a(MNewSofterFragment mnewsofterfragment, View view, int i1, int j1, long l1, boolean flag)
    {
        mnewsofterfragment.a(view, i1, j1, l1, flag);
    }

    public static float b(MNewSofterFragment mnewsofterfragment, float f1)
    {
        mnewsofterfragment.j = f1;
        return f1;
    }

    public static FrameLayout b(MNewSofterFragment mnewsofterfragment)
    {
        return mnewsofterfragment.r;
    }

    private void b()
    {
        if (k())
        {
            return;
        } else
        {
            i();
            a.execute(new vg(this));
            return;
        }
    }

    public static float c(MNewSofterFragment mnewsofterfragment, float f1)
    {
        mnewsofterfragment.k = f1;
        return f1;
    }

    public static xb c(MNewSofterFragment mnewsofterfragment)
    {
        return mnewsofterfragment.d;
    }

    private void c()
    {
        i();
        if (getActivity() == null)
        {
            return;
        } else
        {
            uv.c().a(g, new vh(this));
            return;
        }
    }

    public static Bitmap d(MNewSofterFragment mnewsofterfragment)
    {
        return mnewsofterfragment.g;
    }

    private void d()
    {
        i = 0.5F;
        j = 0.0F;
        k = 0.0F;
        f.a(adp.c, null);
        e();
    }

    public static SoftenState e(MNewSofterFragment mnewsofterfragment)
    {
        return mnewsofterfragment.b;
    }

    private void e()
    {
        f.a(i, j, k);
    }

    private void f()
    {
        aeb aeb1 = new aeb();
        f.a(aeb1);
        j = aeb1.b();
        k = aeb1.c();
    }

    public static void f(MNewSofterFragment mnewsofterfragment)
    {
        mnewsofterfragment.g();
    }

    private void g()
    {
        i();
        a.execute(new vj(this));
    }

    public static void g(MNewSofterFragment mnewsofterfragment)
    {
        mnewsofterfragment.b();
    }

    private void h()
    {
        i();
        a.execute(new vl(this));
    }

    public static void h(MNewSofterFragment mnewsofterfragment)
    {
        mnewsofterfragment.c();
    }

    private void i()
    {
        l.setVisibility(0);
    }

    public static void i(MNewSofterFragment mnewsofterfragment)
    {
        mnewsofterfragment.a();
    }

    public static com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState j(MNewSofterFragment mnewsofterfragment)
    {
        return mnewsofterfragment.e;
    }

    private void j()
    {
        l.setVisibility(4);
    }

    public static void k(MNewSofterFragment mnewsofterfragment)
    {
        mnewsofterfragment.j();
    }

    private boolean k()
    {
        return l.getVisibility() == 0;
    }

    public static void l(MNewSofterFragment mnewsofterfragment)
    {
        mnewsofterfragment.e();
    }

    public static void m(MNewSofterFragment mnewsofterfragment)
    {
        mnewsofterfragment.f();
    }

    public static ig n(MNewSofterFragment mnewsofterfragment)
    {
        return mnewsofterfragment.f;
    }

    public static void o(MNewSofterFragment mnewsofterfragment)
    {
        mnewsofterfragment.d();
    }

    public void a(int i1, KeyEvent keyevent)
    {
        if (keyevent.getKeyCode() == 4)
        {
            b();
        }
    }

    public void a(xb xb1)
    {
        d = xb1;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030062, viewgroup, false);
        layoutinflater.setClickable(true);
        r = (FrameLayout)layoutinflater.findViewById(0x7f0d00c9);
        q = (ImageView)layoutinflater.findViewById(0x7f0d00c4);
        h = (ImageView)layoutinflater.findViewById(0x7f0d020e);
        viewgroup = (ImageView)layoutinflater.findViewById(0x7f0d00cb);
        bundle = (ImageView)layoutinflater.findViewById(0x7f0d0106);
        m = (MNewImageItemView)layoutinflater.findViewById(0x7f0d0219);
        o = (MNewImageItemView)layoutinflater.findViewById(0x7f0d0218);
        n = (MNewImageItemView)layoutinflater.findViewById(0x7f0d0217);
        l = (FrameLayout)layoutinflater.findViewById(0x7f0d0060);
        p = (FlexibleThumbSeekbar)layoutinflater.findViewById(0x7f0d0214);
        p.setOnSeekBarChangeListener(t);
        l.setVisibility(8);
        l.setClickable(true);
        q.setOnTouchListener(s);
        m.setResourceID(0x7f0200dc, getResources().getColor(0x7f0c009d), getResources().getColor(0x7f0c00a6));
        n.setResourceID(0x7f0200e0, getResources().getColor(0x7f0c009d), getResources().getColor(0x7f0c00a6));
        o.setResourceID(0x7f0200e8, getResources().getColor(0x7f0c009d), getResources().getColor(0x7f0c00a6));
        viewgroup.getBackground().setColorFilter(getResources().getColor(0x7f0c00a6), android.graphics.PorterDuff.Mode.SRC_IN);
        bundle.getBackground().setColorFilter(getResources().getColor(0x7f0c009d), android.graphics.PorterDuff.Mode.SRC_IN);
        o.setOnClickListener(u);
        m.setOnClickListener(u);
        n.setOnClickListener(u);
        n.setSelected(true);
        viewgroup.setOnClickListener(u);
        bundle.setOnClickListener(u);
        h.setClickable(false);
        if (d != null)
        {
            g = d.a();
            f = d.b();
            if (g == null && f == null)
            {
                d.a(e);
                return null;
            }
            h.setImageBitmap(g);
        }
        h();
        h.getViewTreeObserver().addOnGlobalLayoutListener(new vb(this));
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onPause()
    {
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
    }


    private class SoftenState extends Enum
    {

        private static final SoftenState $VALUES[];
        public static final SoftenState Skin;
        public static final SoftenState Soften;
        public static final SoftenState White;

        public static SoftenState valueOf(String s1)
        {
            return (SoftenState)Enum.valueOf(com/fotoable/beautyui/newui/MNewSofterFragment$SoftenState, s1);
        }

        public static SoftenState[] values()
        {
            return (SoftenState[])$VALUES.clone();
        }

        static 
        {
            Soften = new SoftenState("Soften", 0);
            White = new SoftenState("White", 1);
            Skin = new SoftenState("Skin", 2);
            $VALUES = (new SoftenState[] {
                Soften, White, Skin
            });
        }

        private SoftenState(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
