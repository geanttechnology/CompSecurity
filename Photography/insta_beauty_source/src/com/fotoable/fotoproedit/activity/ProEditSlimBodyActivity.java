// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import adi;
import ado;
import adp;
import ail;
import aim;
import aio;
import aip;
import ais;
import aiu;
import aiv;
import aix;
import aiy;
import aiz;
import aja;
import ajb;
import ajc;
import amo;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import apq;
import aqx;
import azn;
import bjd;
import bje;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.beautyui.FotoBeautyHelpHint;
import com.fotoable.beautyui.ImageDetailView;
import com.fotoable.beautyui.NewTouchImageView;
import com.fotoable.beautyui.SlimFaceLineView;
import com.fotoable.fotobeauty.FullscreenActivity;
import com.fotoable.fotoproedit.view.ui.ProEidtActionBarView;
import ig;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import uv;

public class ProEditSlimBodyActivity extends FullscreenActivity
    implements amo
{

    private NewTouchImageView A;
    private float B;
    private ExecutorService C;
    private ado D;
    private Point E;
    private Point F;
    private adi G;
    private adi H;
    private FrameLayout I;
    private ImageDetailView J;
    private SlimFaceLineView K;
    private com.fotoable.beautyui.NewTouchImageView.TouchState L;
    private NewTouchImageView M;
    private boolean N;
    private android.view.View.OnClickListener O;
    private android.view.View.OnClickListener P;
    private android.view.View.OnClickListener Q;
    private android.view.View.OnTouchListener R;
    RelativeLayout a;
    bjd b;
    bje c;
    public ArrayList d;
    private final float e = 0.4F;
    private final float f = 0.8F;
    private final float g = 1.2F;
    private final float h = 1.6F;
    private final float i = 2.0F;
    private boolean j;
    private ProEidtActionBarView k;
    private Button l;
    private Button m;
    private Button n;
    private ImageButton o;
    private ImageButton p;
    private ImageButton q;
    private ImageButton r;
    private ImageButton s;
    private View t;
    private Bitmap u;
    private Bitmap v;
    private FotoBeautyHelpHint w;
    private FrameLayout x;
    private ig y;
    private RelativeLayout z;

    public ProEditSlimBodyActivity()
    {
        j = false;
        B = 1.2F;
        C = Executors.newSingleThreadExecutor();
        D = new ado();
        E = new Point();
        F = new Point();
        G = new adi();
        H = new adi();
        N = false;
        c = new aix(this);
        O = new aja(this);
        d = new ArrayList();
        P = new ajb(this);
        Q = new ajc(this);
        R = new aio(this);
    }

    public static float A(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        return proeditslimbodyactivity.B;
    }

    public static ig B(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        return proeditslimbodyactivity.y;
    }

    public static void C(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        proeditslimbodyactivity.i();
    }

    public static boolean D(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        return proeditslimbodyactivity.N;
    }

    public static void E(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        proeditslimbodyactivity.l();
    }

    public static void F(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        proeditslimbodyactivity.h();
    }

    public static float a(ProEditSlimBodyActivity proeditslimbodyactivity, float f1)
    {
        proeditslimbodyactivity.B = f1;
        return f1;
    }

    public static adi a(ProEditSlimBodyActivity proeditslimbodyactivity, adi adi1)
    {
        proeditslimbodyactivity.G = adi1;
        return adi1;
    }

    public static ado a(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        return proeditslimbodyactivity.D;
    }

    public static ado a(ProEditSlimBodyActivity proeditslimbodyactivity, ado ado1)
    {
        proeditslimbodyactivity.D = ado1;
        return ado1;
    }

    public static Bitmap a(ProEditSlimBodyActivity proeditslimbodyactivity, Bitmap bitmap)
    {
        proeditslimbodyactivity.v = bitmap;
        return bitmap;
    }

    public static FotoBeautyHelpHint a(ProEditSlimBodyActivity proeditslimbodyactivity, FotoBeautyHelpHint fotobeautyhelphint)
    {
        proeditslimbodyactivity.w = fotobeautyhelphint;
        return fotobeautyhelphint;
    }

    public static com.fotoable.beautyui.NewTouchImageView.TouchState a(ProEditSlimBodyActivity proeditslimbodyactivity, com.fotoable.beautyui.NewTouchImageView.TouchState touchstate)
    {
        proeditslimbodyactivity.L = touchstate;
        return touchstate;
    }

    public static ig a(ProEditSlimBodyActivity proeditslimbodyactivity, ig ig1)
    {
        proeditslimbodyactivity.y = ig1;
        return ig1;
    }

    private void a(ImageButton imagebutton, boolean flag)
    {
        imagebutton.setSelected(flag);
        if (flag)
        {
            imagebutton.getDrawable().setColorFilter(getResources().getColor(0x7f0c009d), android.graphics.PorterDuff.Mode.MULTIPLY);
            return;
        } else
        {
            imagebutton.getDrawable().clearColorFilter();
            return;
        }
    }

    public static void a(ProEditSlimBodyActivity proeditslimbodyactivity, ImageButton imagebutton, boolean flag)
    {
        proeditslimbodyactivity.a(imagebutton, flag);
    }

    private void a(ArrayList arraylist)
    {
        try
        {
            b = new bjd();
            b.a(c);
            b.a(arraylist);
            b.b(azn.d());
            b.d(new ArrayList[] {
                arraylist
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ArrayList arraylist)
        {
            arraylist.printStackTrace();
        }
    }

    public static boolean a(ProEditSlimBodyActivity proeditslimbodyactivity, boolean flag)
    {
        proeditslimbodyactivity.N = flag;
        return flag;
    }

    public static adi b(ProEditSlimBodyActivity proeditslimbodyactivity, adi adi1)
    {
        proeditslimbodyactivity.H = adi1;
        return adi1;
    }

    public static Bitmap b(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        return proeditslimbodyactivity.v;
    }

    public static Bitmap b(ProEditSlimBodyActivity proeditslimbodyactivity, Bitmap bitmap)
    {
        proeditslimbodyactivity.u = bitmap;
        return bitmap;
    }

    public static NewTouchImageView c(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        return proeditslimbodyactivity.A;
    }

    private void c()
    {
        if (w == null)
        {
            x.setVisibility(0);
            w = new FotoBeautyHelpHint(this, null);
            w.setCallback(new aiy(this));
            w.setText(0x7f060307);
            w.setImage(0x7f02032e);
            Object obj = new android.widget.FrameLayout.LayoutParams(-1, -1);
            x.addView(w, 0, ((android.view.ViewGroup.LayoutParams) (obj)));
            w.bringToFront();
            obj = AnimationUtils.loadAnimation(this, 0x7f04001d);
            if (x != null)
            {
                x.startAnimation(((Animation) (obj)));
                return;
            }
        }
    }

    public static Bitmap d(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        return proeditslimbodyactivity.u;
    }

    public static void e(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        proeditslimbodyactivity.c();
    }

    private void f()
    {
        Animation animation = AnimationUtils.loadAnimation(this, 0x7f04001e);
        if (x != null)
        {
            x.startAnimation(animation);
        }
        (new Handler()).postDelayed(new aiz(this), animation.getDuration());
    }

    public static void f(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        proeditslimbodyactivity.k();
    }

    private void g()
    {
        o.setTag(Integer.valueOf(1024));
        p.setTag(Integer.valueOf(1025));
        q.setTag(Integer.valueOf(1026));
        r.setTag(Integer.valueOf(1027));
        s.setTag(Integer.valueOf(1028));
        o.setOnClickListener(Q);
        p.setOnClickListener(Q);
        q.setOnClickListener(Q);
        r.setOnClickListener(Q);
        s.setOnClickListener(Q);
        a(o, false);
        a(p, false);
        a(q, true);
        a(r, false);
        a(s, false);
        B = 1.2F;
    }

    public static void g(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        proeditslimbodyactivity.f();
    }

    public static FrameLayout h(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        return proeditslimbodyactivity.x;
    }

    private void h()
    {
        D.d();
        y.a(adp.f, null);
        i();
    }

    public static FotoBeautyHelpHint i(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        return proeditslimbodyactivity.w;
    }

    private void i()
    {
        y.a(0.0F, D);
    }

    private void j()
    {
        a();
        C.execute(new aip(this));
    }

    public static void j(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        proeditslimbodyactivity.j();
    }

    public static Button k(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        return proeditslimbodyactivity.m;
    }

    private void k()
    {
        a();
        A.setImageBitmap(v);
        M.setImageBitmap(v);
        J.setImage(v);
        C.execute(new ais(this));
    }

    public static Button l(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        return proeditslimbodyactivity.n;
    }

    private void l()
    {
        android.content.SharedPreferences.Editor editor;
        Object obj;
        int i1;
        obj = getSharedPreferences("setting", 0);
        editor = ((SharedPreferences) (obj)).edit();
        i1 = ((SharedPreferences) (obj)).getInt("checkcount", 0);
        if (i1 >= 100)
        {
            return;
        }
        long l1;
        if (((SharedPreferences) (obj)).getBoolean("isfastphone", false))
        {
            break MISSING_BLOCK_LABEL_203;
        }
        obj = Bitmap.createBitmap(200, 200, android.graphics.Bitmap.Config.ARGB_8888);
        (new Canvas(((Bitmap) (obj)))).drawColor(0xff888888);
        ig ig1 = new ig();
        ig1.a(getAssets(), ((Bitmap) (obj)));
        ig1.a(true);
        l1 = Debug.threadCpuTimeNanos();
        ig1.a(adp.c, null);
        ig1.b();
        l1 = (Debug.threadCpuTimeNanos() - l1) / 0xf4240L;
        if (l1 >= 105L)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        editor.putBoolean("isfastphone", true);
        editor.putInt("checkcount", i1);
        editor.apply();
        Log.e("ProEditSlimBodyActivity", (new StringBuilder()).append(l1).append("ms").toString());
        return;
        Exception exception;
        exception;
        exception.printStackTrace();
        Crashlytics.logException(exception);
    }

    public static ImageButton m(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        return proeditslimbodyactivity.o;
    }

    public static ImageButton n(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        return proeditslimbodyactivity.p;
    }

    public static ImageButton o(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        return proeditslimbodyactivity.q;
    }

    public static ImageButton p(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        return proeditslimbodyactivity.r;
    }

    public static ImageButton q(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        return proeditslimbodyactivity.s;
    }

    public static FrameLayout r(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        return proeditslimbodyactivity.I;
    }

    public static Point s(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        return proeditslimbodyactivity.E;
    }

    public static NewTouchImageView t(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        return proeditslimbodyactivity.M;
    }

    public static SlimFaceLineView u(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        return proeditslimbodyactivity.K;
    }

    public static ImageDetailView v(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        return proeditslimbodyactivity.J;
    }

    public static adi w(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        return proeditslimbodyactivity.G;
    }

    public static Point x(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        return proeditslimbodyactivity.F;
    }

    public static com.fotoable.beautyui.NewTouchImageView.TouchState y(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        return proeditslimbodyactivity.L;
    }

    public static adi z(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        return proeditslimbodyactivity.H;
    }

    public void a()
    {
        t.setVisibility(0);
    }

    public void b()
    {
        t.setVisibility(4);
    }

    public void d()
    {
        apq.a("slimbody");
        apq.b((int)D.b());
        a();
        if (u != null && !u.isRecycled())
        {
            uv.c().a(u, new aim(this));
            return;
        }
        try
        {
            b();
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        b();
        return;
    }

    public void e()
    {
        setResult(0);
        finish();
        overridePendingTransition(0, 0x7f04001e);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f030039);
        A = (NewTouchImageView)findViewById(0x7f0d0152);
        M = (NewTouchImageView)findViewById(0x7f0d0151);
        I = (FrameLayout)findViewById(0x7f0d0150);
        a = (RelativeLayout)findViewById(0x7f0d00b0);
        a.setVisibility(8);
        if (!azn.a(this))
        {
            a.setVisibility(8);
        }
        J = (ImageDetailView)findViewById(0x7f0d0156);
        K = (SlimFaceLineView)findViewById(0x7f0d0153);
        A.setClickable(false);
        M.setClickable(false);
        K.setClickable(false);
        I.setOnTouchListener(R);
        z = (RelativeLayout)findViewById(0x7f0d014e);
        z.setVisibility(0);
        k = (ProEidtActionBarView)findViewById(0x7f0d00ba);
        bundle = getString(0x7f0602e1);
        k.setActionBarTitle(bundle);
        k.setOnAcceptListener(this);
        l = (Button)findViewById(0x7f0d0154);
        l.setOnTouchListener(new ail(this));
        x = (FrameLayout)findViewById(0x7f0d0158);
        ((Button)findViewById(0x7f0d0155)).setOnClickListener(new aiu(this));
        n = (Button)findViewById(0x7f0d013b);
        n.setOnClickListener(O);
        n.setEnabled(false);
        m = (Button)findViewById(0x7f0d013a);
        m.setOnClickListener(P);
        m.setEnabled(false);
        o = (ImageButton)findViewById(0x7f0d0143);
        p = (ImageButton)findViewById(0x7f0d0144);
        q = (ImageButton)findViewById(0x7f0d0145);
        r = (ImageButton)findViewById(0x7f0d0146);
        s = (ImageButton)findViewById(0x7f0d014f);
        g();
        t = findViewById(0x7f0d0157);
        bundle = getIntent();
        if (bundle != null)
        {
            j = bundle.getBooleanExtra("KISDERECTEDTOSAVE_STRING", false);
            if (j)
            {
                bundle = bundle.getStringExtra("KIMAGEURI");
                if (bundle != null)
                {
                    ArrayList arraylist = new ArrayList();
                    arraylist.add(Uri.parse(bundle));
                    a(arraylist);
                }
            }
        }
        if (!j)
        {
            (new Thread(new aiv(this))).start();
        }
    }

    protected void onResume()
    {
        super.onResume();
        FlurryAgent.onPageView();
        if (azn.a(this))
        {
            FotoAdFactory.createAdBanner(this, a);
        }
        Animation animation = AnimationUtils.loadAnimation(this, 0x7f040030);
        z.startAnimation(animation);
        if (!aqx.a(this, "hasInSlimBody", false))
        {
            aqx.b(this, "hasInSlimBody", true);
            c();
        }
    }

    static 
    {
        new ig();
    }
}
