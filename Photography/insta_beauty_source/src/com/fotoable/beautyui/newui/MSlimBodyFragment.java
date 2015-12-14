// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.newui;

import ade;
import adg;
import adi;
import adj;
import adn;
import ado;
import adp;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.flurry.android.FlurryAgent;
import com.fotoable.beautyui.FotoBeautyHelpHint;
import com.fotoable.beautyui.ImageDetailView;
import com.fotoable.beautyui.NewOneBeautyToolBar;
import com.fotoable.beautyui.NewSecBeautyToolBar;
import com.fotoable.beautyui.NewTouchImageView;
import com.fotoable.beautyui.SlimFaceLineView;
import com.instabeauty.application.InstaBeautyApplication;
import ig;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import jk;
import jv;
import pt;
import uv;
import wh;
import wi;
import wj;
import wk;
import wm;
import wn;
import wq;
import wt;
import wu;
import wv;
import ww;
import wx;
import wy;
import wz;
import xa;
import xb;
import xc;
import yp;

// Referenced classes of package com.fotoable.beautyui.newui:
//            FlexibleThumbSeekbar, MNewTextItemView

public class MSlimBodyFragment extends Fragment
{

    private static String c = "MSlimBodyFragment";
    private adj A;
    private ExecutorService B;
    private ade C;
    private Point D;
    private Point E;
    private adi F;
    private adi G;
    private ImageDetailView H;
    private FrameLayout I;
    private ImageView J;
    private FrameLayout K;
    private boolean L;
    private boolean M;
    private boolean N;
    private android.view.View.OnTouchListener O;
    private android.widget.SeekBar.OnSeekBarChangeListener P;
    private jv Q;
    private jk R;
    private boolean S;
    private android.view.View.OnClickListener T;
    private android.view.View.OnTouchListener U;
    public boolean a;
    float b;
    private com.fotoable.beautyui.NewTouchImageView.TouchState d;
    private xb e;
    private com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState f;
    private ig g;
    private Bitmap h;
    private ado i;
    private NewTouchImageView j;
    private NewTouchImageView k;
    private SlimFaceLineView l;
    private ImageView m;
    private NewSecBeautyToolBar n;
    private NewOneBeautyToolBar o;
    private RelativeLayout p;
    private FlexibleThumbSeekbar q;
    private FotoBeautyHelpHint r;
    private FrameLayout s;
    private MNewTextItemView t;
    private MNewTextItemView u;
    private float v;
    private float w;
    private adg x;
    private ado y;
    private adn z;

    public MSlimBodyFragment()
    {
        i = new ado();
        x = new adg();
        y = new ado();
        z = new adn();
        A = new adj();
        B = Executors.newSingleThreadExecutor();
        C = new ade();
        D = new Point();
        E = new Point();
        F = new adi();
        G = new adi();
        L = false;
        M = false;
        N = false;
        O = new wu(this);
        P = new wv(this);
        Q = new ww(this);
        R = new wx(this);
        S = false;
        T = new wi(this);
        U = new wm(this);
    }

    public static adi A(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.F;
    }

    private void A()
    {
        I.setVisibility(4);
        M = false;
    }

    private boolean B()
    {
        return I.getVisibility() == 0;
    }

    public static boolean B(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.g();
    }

    public static ade C(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.C;
    }

    public static boolean D(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.h();
    }

    public static boolean E(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.i();
    }

    public static Point F(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.E;
    }

    public static com.fotoable.beautyui.NewTouchImageView.TouchState G(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.d;
    }

    public static adi H(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.G;
    }

    public static float I(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.w;
    }

    public static void J(MSlimBodyFragment mslimbodyfragment)
    {
        mslimbodyfragment.l();
    }

    public static void K(MSlimBodyFragment mslimbodyfragment)
    {
        mslimbodyfragment.n();
    }

    public static void L(MSlimBodyFragment mslimbodyfragment)
    {
        mslimbodyfragment.p();
    }

    public static void M(MSlimBodyFragment mslimbodyfragment)
    {
        mslimbodyfragment.r();
    }

    public static void N(MSlimBodyFragment mslimbodyfragment)
    {
        mslimbodyfragment.t();
    }

    public static void O(MSlimBodyFragment mslimbodyfragment)
    {
        mslimbodyfragment.v();
    }

    public static void P(MSlimBodyFragment mslimbodyfragment)
    {
        mslimbodyfragment.x();
    }

    public static ig Q(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.g;
    }

    public static boolean R(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.N;
    }

    public static void S(MSlimBodyFragment mslimbodyfragment)
    {
        mslimbodyfragment.A();
    }

    public static void T(MSlimBodyFragment mslimbodyfragment)
    {
        mslimbodyfragment.k();
    }

    public static void U(MSlimBodyFragment mslimbodyfragment)
    {
        mslimbodyfragment.m();
    }

    public static void V(MSlimBodyFragment mslimbodyfragment)
    {
        mslimbodyfragment.o();
    }

    public static void W(MSlimBodyFragment mslimbodyfragment)
    {
        mslimbodyfragment.q();
    }

    public static void X(MSlimBodyFragment mslimbodyfragment)
    {
        mslimbodyfragment.s();
    }

    public static void Y(MSlimBodyFragment mslimbodyfragment)
    {
        mslimbodyfragment.u();
    }

    public static void Z(MSlimBodyFragment mslimbodyfragment)
    {
        mslimbodyfragment.w();
    }

    public static float a(MSlimBodyFragment mslimbodyfragment, float f1)
    {
        mslimbodyfragment.v = f1;
        return f1;
    }

    public static adg a(MSlimBodyFragment mslimbodyfragment, adg adg1)
    {
        mslimbodyfragment.x = adg1;
        return adg1;
    }

    public static adi a(MSlimBodyFragment mslimbodyfragment, adi adi1)
    {
        mslimbodyfragment.F = adi1;
        return adi1;
    }

    public static adj a(MSlimBodyFragment mslimbodyfragment, adj adj1)
    {
        mslimbodyfragment.A = adj1;
        return adj1;
    }

    public static adn a(MSlimBodyFragment mslimbodyfragment, adn adn1)
    {
        mslimbodyfragment.z = adn1;
        return adn1;
    }

    public static ado a(MSlimBodyFragment mslimbodyfragment, ado ado1)
    {
        mslimbodyfragment.y = ado1;
        return ado1;
    }

    public static Bitmap a(MSlimBodyFragment mslimbodyfragment, Bitmap bitmap)
    {
        mslimbodyfragment.h = bitmap;
        return bitmap;
    }

    public static Fragment a(com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState maintoolstate)
    {
        MSlimBodyFragment mslimbodyfragment = new MSlimBodyFragment();
        mslimbodyfragment.f = maintoolstate;
        return mslimbodyfragment;
    }

    public static FotoBeautyHelpHint a(MSlimBodyFragment mslimbodyfragment, FotoBeautyHelpHint fotobeautyhelphint)
    {
        mslimbodyfragment.r = fotobeautyhelphint;
        return fotobeautyhelphint;
    }

    public static com.fotoable.beautyui.NewTouchImageView.TouchState a(MSlimBodyFragment mslimbodyfragment, com.fotoable.beautyui.NewTouchImageView.TouchState touchstate)
    {
        mslimbodyfragment.d = touchstate;
        return touchstate;
    }

    public static NewTouchImageView a(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.j;
    }

    public static String a()
    {
        return c;
    }

    private void a(int i1, int j1)
    {
        if (r != null && getView() == null)
        {
            return;
        } else
        {
            S = false;
            ViewGroup viewgroup = (ViewGroup)getView();
            r = new FotoBeautyHelpHint(InstaBeautyApplication.a, null);
            r.setCallback(new wz(this));
            r.setText(i1);
            r.setImage(j1);
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            layoutparams.addRule(12);
            layoutparams.addRule(10);
            viewgroup.addView(r, 0, layoutparams);
            xc.a().a(0, 1, 100, r, null);
            r.bringToFront();
            return;
        }
    }

    private void a(int i1, boolean flag)
    {
        int j1;
        int k1;
        k1 = (int)((float)yp.a(getActivity(), 30F) * w);
        j1 = k1 / 2;
        if (f != com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.QuBan) goto _L2; else goto _L1
_L1:
        i1;
        JVM INSTR tableswitch 1 3: default 64
    //                   1 205
    //                   2 215
    //                   3 225;
           goto _L3 _L4 _L5 _L6
_L3:
        FlurryAgent.logEvent((new StringBuilder()).append("qudoubar_pensize").append(w).append("clicked").toString());
        j1 = (int)((float)yp.a(getActivity(), 20F) * w);
        k1 = j1;
_L11:
        H.setTragetArea(j1);
        l.setBmpSize(w);
        if (flag)
        {
            J.setVisibility(0);
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)J.getLayoutParams();
            layoutparams.width = k1;
            layoutparams.height = k1;
            J.setLayoutParams(layoutparams);
            xc.a().a(0x7f04001e, J, new wy(this));
        }
        return;
_L4:
        w = 0.6F;
          goto _L3
_L5:
        w = 0.8F;
          goto _L3
_L6:
        w = 1.0F;
          goto _L3
_L2:
        if (f != com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.BigEye)
        {
            break MISSING_BLOCK_LABEL_359;
        }
        i1;
        JVM INSTR tableswitch 1 3: default 272
    //                   1 331
    //                   2 341
    //                   3 351;
           goto _L7 _L8 _L9 _L10
_L7:
        break; /* Loop/switch isn't completed */
_L10:
        break MISSING_BLOCK_LABEL_351;
_L12:
        FlurryAgent.logEvent((new StringBuilder()).append("bigeyebar_pensize").append(w).append("_clicked").toString());
        j1 = (int)((float)yp.a(getActivity(), 20F) * w);
        k1 = j1;
          goto _L11
_L8:
        w = 0.4F;
          goto _L12
_L9:
        w = 0.7F;
          goto _L12
        w = 1.0F;
          goto _L12
        if (f != com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.SlimFace)
        {
            break MISSING_BLOCK_LABEL_485;
        }
        i1;
        JVM INSTR tableswitch 1 3: default 396
    //                   1 457
    //                   2 467
    //                   3 475;
           goto _L13 _L14 _L15 _L16
_L13:
        break; /* Loop/switch isn't completed */
_L16:
        break MISSING_BLOCK_LABEL_475;
_L17:
        FlurryAgent.logEvent((new StringBuilder()).append("slimfacebar_pensize").append(w).append("_clicked").toString());
        k1 = (int)((float)yp.a(getActivity(), 40F) * w);
        j1 = k1 / 2;
          goto _L11
_L14:
        w = 0.7F;
          goto _L17
_L15:
        w = 1.0F;
          goto _L17
        w = 1.4F;
          goto _L17
        if (f != com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.SlimNose) goto _L19; else goto _L18
_L18:
        i1;
        JVM INSTR tableswitch 1 3: default 524
    //                   1 583
    //                   2 593
    //                   3 603;
           goto _L20 _L21 _L22 _L23
_L20:
        break; /* Loop/switch isn't completed */
_L23:
        break MISSING_BLOCK_LABEL_603;
_L24:
        FlurryAgent.logEvent((new StringBuilder()).append("slimnosebar_pensize").append(w).append("_clicked").toString());
        j1 = (int)((float)yp.a(getActivity(), 40F) * w);
        k1 = j1;
          goto _L11
_L21:
        w = 0.4F;
          goto _L24
_L22:
        w = 0.7F;
          goto _L24
        w = 1.0F;
          goto _L24
_L19:
        if (f != com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.EyeBag) goto _L11; else goto _L25
_L25:
        i1;
        JVM INSTR tableswitch 1 3: default 648
    //                   1 707
    //                   2 717
    //                   3 727;
           goto _L26 _L27 _L28 _L29
_L26:
        break; /* Loop/switch isn't completed */
_L29:
        break MISSING_BLOCK_LABEL_727;
_L30:
        FlurryAgent.logEvent((new StringBuilder()).append("eyebagbar_pensize").append(w).append("_clicked").toString());
        j1 = (int)((float)yp.a(getActivity(), 30F) * w);
        k1 = j1;
          goto _L11
_L27:
        w = 0.4F;
          goto _L30
_L28:
        w = 0.7F;
          goto _L30
        w = 1.0F;
          goto _L30
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
            translateanimation.setAnimationListener(new wt(this, flag, view));
            view.startAnimation(translateanimation);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
    }

    public static void a(MSlimBodyFragment mslimbodyfragment, int i1, int j1)
    {
        mslimbodyfragment.a(i1, j1);
    }

    public static void a(MSlimBodyFragment mslimbodyfragment, int i1, boolean flag)
    {
        mslimbodyfragment.a(i1, flag);
    }

    public static void a(MSlimBodyFragment mslimbodyfragment, View view, int i1, int j1, long l1, boolean flag)
    {
        mslimbodyfragment.a(view, i1, j1, l1, flag);
    }

    public static boolean a(MSlimBodyFragment mslimbodyfragment, boolean flag)
    {
        mslimbodyfragment.L = flag;
        return flag;
    }

    public static float aa(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.v;
    }

    public static FlexibleThumbSeekbar ab(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.q;
    }

    public static adi b(MSlimBodyFragment mslimbodyfragment, adi adi1)
    {
        mslimbodyfragment.G = adi1;
        return adi1;
    }

    public static FrameLayout b(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.K;
    }

    private void b()
    {
        if (S)
        {
            return;
        } else
        {
            S = true;
            xc.a().a(1, 0, 100, r, new xa(this));
            return;
        }
    }

    public static boolean b(MSlimBodyFragment mslimbodyfragment, boolean flag)
    {
        mslimbodyfragment.N = flag;
        return flag;
    }

    public static ImageDetailView c(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.H;
    }

    private void c()
    {
        if (B())
        {
            return;
        } else
        {
            z();
            B.execute(new wj(this));
            return;
        }
    }

    public static xb d(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.e;
    }

    private void d()
    {
        z();
        uv.c().a(h, new wk(this));
    }

    public static com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState e(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.f;
    }

    private boolean e()
    {
        return g != null && g.a() > 0;
    }

    public static Bitmap f(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.h;
    }

    private boolean f()
    {
        return L && f == com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.QuBan;
    }

    public static void g(MSlimBodyFragment mslimbodyfragment)
    {
        mslimbodyfragment.j();
    }

    private boolean g()
    {
        return L && (f == com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.SlimFace || f == com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.SlimNose);
    }

    public static adg h(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.x;
    }

    private boolean h()
    {
        return L && f == com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.BigEye;
    }

    public static NewSecBeautyToolBar i(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.n;
    }

    private boolean i()
    {
        return L && f == com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.EyeBag;
    }

    public static ado j(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.y;
    }

    private void j()
    {
        z();
        B.execute(new wn(this));
    }

    public static NewOneBeautyToolBar k(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.o;
    }

    private void k()
    {
        b = 0.4F;
        x.d();
        g.a(adp.b, null);
        l();
    }

    public static adn l(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.z;
    }

    private void l()
    {
        g.a(Boolean.valueOf(a), x);
    }

    public static adj m(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.A;
    }

    private void m()
    {
        b = 0.4F;
        v = 0.5F;
        z.d();
        g.a(adp.e, null);
        n();
    }

    public static ImageView n(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.J;
    }

    private void n()
    {
        g.a(v, z);
    }

    private void o()
    {
        b = 0.4F;
        v = 0.5F;
        y.d();
        g.a(adp.f, null);
        p();
    }

    public static void o(MSlimBodyFragment mslimbodyfragment)
    {
        mslimbodyfragment.b();
    }

    public static FotoBeautyHelpHint p(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.r;
    }

    private void p()
    {
        g.a(v, y);
    }

    private void q()
    {
        b = 0.4F;
        v = 0.5F;
        y.d();
        g.a(adp.g, null);
        r();
    }

    public static boolean q(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.e();
    }

    public static MNewTextItemView r(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.u;
    }

    private void r()
    {
        g.b(v, y);
    }

    public static MNewTextItemView s(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.t;
    }

    private void s()
    {
        v = 0.5F;
        g.a(adp.d, null);
        t();
    }

    private void t()
    {
        g.b(v);
    }

    public static void t(MSlimBodyFragment mslimbodyfragment)
    {
        mslimbodyfragment.c();
    }

    private void u()
    {
        v = 0.5F;
        g.a(adp.i, null);
        v();
    }

    public static void u(MSlimBodyFragment mslimbodyfragment)
    {
        mslimbodyfragment.d();
    }

    public static FrameLayout v(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.s;
    }

    private void v()
    {
        g.c(v);
    }

    public static Point w(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.D;
    }

    private void w()
    {
        v = 0.5F;
        g.a(adp.h, null);
        A.d();
        x();
    }

    public static NewTouchImageView x(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.k;
    }

    private void x()
    {
        g.a(v, A);
    }

    public static SlimFaceLineView y(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.l;
    }

    private void y()
    {
        z();
        B.execute(new wq(this));
    }

    private void z()
    {
        I.setVisibility(0);
        M = true;
    }

    public static boolean z(MSlimBodyFragment mslimbodyfragment)
    {
        return mslimbodyfragment.f();
    }

    public void a(int i1, KeyEvent keyevent)
    {
label0:
        {
            if (keyevent.getKeyCode() == 4)
            {
                if (r == null)
                {
                    break label0;
                }
                b();
            }
            return;
        }
        c();
    }

    public void a(xb xb1)
    {
        e = xb1;
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
label0:
        {
            layoutinflater = layoutinflater.inflate(0x7f030061, viewgroup, false);
            layoutinflater.setClickable(true);
            K = (FrameLayout)layoutinflater.findViewById(0x7f0d00c9);
            J = (ImageView)layoutinflater.findViewById(0x7f0d020f);
            m = (ImageView)layoutinflater.findViewById(0x7f0d00c4);
            j = (NewTouchImageView)layoutinflater.findViewById(0x7f0d020e);
            k = (NewTouchImageView)layoutinflater.findViewById(0x7f0d020d);
            o = (NewOneBeautyToolBar)layoutinflater.findViewById(0x7f0d0210);
            n = (NewSecBeautyToolBar)layoutinflater.findViewById(0x7f0d0211);
            H = (ImageDetailView)layoutinflater.findViewById(0x7f0d01c0);
            p = (RelativeLayout)layoutinflater.findViewById(0x7f0d0212);
            q = (FlexibleThumbSeekbar)layoutinflater.findViewById(0x7f0d0214);
            s = (FrameLayout)layoutinflater.findViewById(0x7f0d00c6);
            l = (SlimFaceLineView)layoutinflater.findViewById(0x7f0d0153);
            viewgroup = (ImageView)layoutinflater.findViewById(0x7f0d00cb);
            bundle = (ImageView)layoutinflater.findViewById(0x7f0d0106);
            TextView textview = (TextView)layoutinflater.findViewById(0x7f0d01e5);
            t = (MNewTextItemView)layoutinflater.findViewById(0x7f0d0216);
            u = (MNewTextItemView)layoutinflater.findViewById(0x7f0d0215);
            I = (FrameLayout)layoutinflater.findViewById(0x7f0d0060);
            J.setVisibility(8);
            t.setResourceID(getResources().getString(0x7f060080), getActivity().getResources().getColor(0x7f0c009d), getActivity().getResources().getColor(0x7f0c00a6));
            u.setResourceID(getResources().getString(0x7f06016b), getActivity().getResources().getColor(0x7f0c009d), getActivity().getResources().getColor(0x7f0c00a6));
            viewgroup.getBackground().setColorFilter(getResources().getColor(0x7f0c00a6), android.graphics.PorterDuff.Mode.SRC_IN);
            bundle.getBackground().setColorFilter(getResources().getColor(0x7f0c009d), android.graphics.PorterDuff.Mode.SRC_IN);
            t.setVisibility(0);
            u.setVisibility(0);
            p.setVisibility(4);
            n.setVisibility(4);
            o.setVisibility(4);
            textview.setVisibility(4);
            I.setVisibility(8);
            I.setClickable(true);
            viewgroup.setOnClickListener(T);
            bundle.setOnClickListener(T);
            t.setOnClickListener(T);
            m.setOnTouchListener(O);
            u.setOnClickListener(T);
            o.setListener(R);
            n.setListener(Q);
            q.setOnSeekBarChangeListener(P);
            j.setClickable(false);
            l.setClickable(false);
            k.setClickable(false);
            s.setOnTouchListener(U);
            if (e != null)
            {
                h = e.a();
                g = e.b();
                if (h == null || g == null)
                {
                    break label0;
                }
                k.setImageBitmap(h);
                j.setImageBitmap(h);
                H.setImage(h);
            }
            boolean flag;
            if (f == com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.QuBan)
            {
                a = pt.b(pt.e, getActivity(), true);
                n.setVisibility(0);
                n.updateUiSwitch(a);
                n.setUITitle(InstaBeautyApplication.a.getText(0x7f060032).toString(), "\u75D8\u75D8\u5927\u5C0F");
                l.setLineType(com.fotoable.beautyui.SlimFaceLineView.LineType.QUBAN);
            } else
            if (f == com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.EyeBag)
            {
                o.setVisibility(0);
                l.setLineType(com.fotoable.beautyui.SlimFaceLineView.LineType.EYEBAG);
            } else
            if (f == com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.BigEye)
            {
                o.setVisibility(0);
                o.setUITitle("\u5927\u773C\u7A0B\u5EA6", "\u5927\u773C\u8303\u56F4");
                l.setLineType(com.fotoable.beautyui.SlimFaceLineView.LineType.QUBAN);
            } else
            if (f == com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.SlimFace)
            {
                o.setVisibility(0);
                o.setUITitle("\u5F3A\u5EA6", "\u7626\u8138\u7A0B\u5EA6");
                l.setLineType(com.fotoable.beautyui.SlimFaceLineView.LineType.SLIMFACE);
            } else
            if (f == com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.SlimNose)
            {
                o.setVisibility(0);
                o.setUITitle("\u5F3A\u5EA6", "\u7626\u9F3B\u7A0B\u5EA6");
                l.setLineType(com.fotoable.beautyui.SlimFaceLineView.LineType.SLIMFACE);
            } else
            if (f == com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.ClearEye)
            {
                p.setVisibility(0);
                t.setVisibility(4);
                u.setVisibility(4);
                textview.setText(0x7f060039);
                textview.setVisibility(0);
            } else
            if (f == com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.EnhanceNose)
            {
                p.setVisibility(0);
                t.setVisibility(4);
                u.setVisibility(4);
                textview.setText(0x7f0600f3);
                textview.setVisibility(0);
            }
            if (!e())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            L = flag;
            viewgroup = t;
            if (!L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            viewgroup.setSelected(flag);
            u.setSelected(L);
            o.initManual(L);
            n.initManual(L);
            y();
            j.getViewTreeObserver().addOnGlobalLayoutListener(new wh(this));
            return layoutinflater;
        }
        return null;
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

}
