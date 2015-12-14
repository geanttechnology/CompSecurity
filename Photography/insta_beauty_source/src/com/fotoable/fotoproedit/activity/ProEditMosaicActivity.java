// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import ahd;
import ahe;
import ahf;
import ahg;
import ahh;
import ahi;
import ahj;
import ahm;
import ahn;
import aho;
import ahp;
import ahq;
import ahr;
import ahu;
import ahv;
import ahw;
import alh;
import ali;
import amo;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import aqx;
import azn;
import bjd;
import bje;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.fotobeauty.FullscreenActivity;
import com.fotoable.fotoproedit.activity.mosaic.MosaicGLSurfaceView;
import com.fotoable.fotoproedit.activity.mosaic.MosaicIconScrollView;
import com.fotoable.fotoproedit.activity.mosaic.MosaicInfo;
import com.fotoable.fotoproedit.view.ui.ProEidtActionBarView;
import com.fotoable.fotoproedit.view.ui.color.ColorSelectView;
import com.wantu.utility.ui.ProcessDialogFragment;
import yp;

public class ProEditMosaicActivity extends FullscreenActivity
    implements ali, amo
{

    public static String a = "proedit_mosaic_mode";
    private LinearLayout A;
    private ProcessDialogFragment B;
    private String C;
    private ImageView D;
    private FrameLayout E;
    private android.view.View.OnClickListener F;
    private android.view.View.OnClickListener G;
    private android.view.View.OnClickListener H;
    private android.view.View.OnClickListener I;
    private android.view.View.OnClickListener J;
    private android.view.View.OnClickListener K;
    FrameLayout b;
    RelativeLayout c;
    int d;
    boolean e;
    bjd f;
    bje g;
    private String h;
    private String i;
    private boolean j;
    private ProEidtActionBarView k;
    private ImageButton l;
    private ImageButton m;
    private ImageButton n;
    private ImageButton o;
    private ImageButton p;
    private Bitmap q;
    private boolean r;
    private MosaicGLSurfaceView s;
    private FrameLayout t;
    private MosaicIconScrollView u;
    private int v;
    private MosaicInfo w;
    private ColorSelectView x;
    private ImageButton y;
    private ImageButton z;

    public ProEditMosaicActivity()
    {
        h = "ProEditMosaicActivity";
        i = "mosaic_first_tip";
        j = false;
        r = true;
        v = 64;
        d = 0;
        e = true;
        F = new ahn(this);
        G = new aho(this);
        g = new ahu(this);
        H = new ahw(this);
        I = new ahe(this);
        J = new ahf(this);
        K = new ahg(this);
    }

    public static Bitmap a(ProEditMosaicActivity proeditmosaicactivity, Bitmap bitmap)
    {
        proeditmosaicactivity.q = bitmap;
        return bitmap;
    }

    public static FrameLayout a(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.E;
    }

    private void a(View view, boolean flag)
    {
        view.setVisibility(0);
        Animation animation;
        if (flag)
        {
            animation = AnimationUtils.loadAnimation(this, 0x7f040029);
        } else
        {
            animation = AnimationUtils.loadAnimation(this, 0x7f04002a);
        }
        animation.setAnimationListener(new ahh(this, flag, view));
        view.startAnimation(animation);
    }

    private void a(ImageButton imagebutton, boolean flag)
    {
        imagebutton.setSelected(flag);
        if (flag)
        {
            imagebutton.getDrawable().setColorFilter(getResources().getColor(0x7f0c009d), android.graphics.PorterDuff.Mode.SRC_IN);
            return;
        } else
        {
            imagebutton.getDrawable().clearColorFilter();
            return;
        }
    }

    public static void a(ProEditMosaicActivity proeditmosaicactivity, ImageButton imagebutton, boolean flag)
    {
        proeditmosaicactivity.a(imagebutton, flag);
    }

    public static void a(ProEditMosaicActivity proeditmosaicactivity, MosaicInfo mosaicinfo)
    {
        proeditmosaicactivity.a(mosaicinfo);
    }

    public static void a(ProEditMosaicActivity proeditmosaicactivity, boolean flag)
    {
        proeditmosaicactivity.a(flag);
    }

    private void a(MosaicInfo mosaicinfo)
    {
        w = mosaicinfo;
        a(p, false);
        switch (ahm.a[mosaicinfo.a.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            s.shiftNormalMosaic();
            s.setBrushImagePath("mosaicRes/paintBrush/paintBrush0.png");
            s.setMosaicImagePath(mosaicinfo.c);
            Log.e(h, (new StringBuilder()).append("mosaicImageStr:").append(mosaicinfo.c).toString());
            return;

        case 2: // '\002'
            s.shiftNormalMosaic();
            s.setBrushImagePath("mosaicRes/paintBrush/paintBrush0.png");
            s.setMosaicImagePath("maoboli");
            return;

        case 3: // '\003'
            s.shiftNormalMosaic();
            s.setBrushImagePath("mosaicRes/paintBrush/paintBrush0.png");
            s.setMosaicImagePath("mosaic");
            return;

        case 4: // '\004'
            s.shiftRandomMosaic();
            s.setBrushImagePath(mosaicinfo.b);
            Log.e(h, (new StringBuilder()).append("mosaicImageStr:").append(mosaicinfo.b).toString());
            return;

        case 5: // '\005'
            s.shift3DPen();
            s.setBrushImagePath(mosaicinfo.e);
            Log.e(h, (new StringBuilder()).append("mosaicImageStr:").append(mosaicinfo.e).toString());
            return;

        case 6: // '\006'
            s.shiftColorPen();
            break;
        }
        s.setBrushImagePath(mosaicinfo.d);
        Log.e(h, (new StringBuilder()).append("mosaicImageStr:").append(mosaicinfo.d).toString());
    }

    private void a(boolean flag)
    {
        a(((View) (A)), flag);
    }

    public static String b(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.i;
    }

    public static ImageButton c(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.z;
    }

    public static MosaicGLSurfaceView d(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.s;
    }

    public static ImageButton e(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.y;
    }

    public static MosaicInfo f(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.w;
    }

    private void f()
    {
        s = new MosaicGLSurfaceView(this);
        r = getIntent().getBooleanExtra(a, true);
        j = getIntent().getBooleanExtra("KISDERECTEDTOSAVE_STRING", false);
        if (r)
        {
            w = new MosaicInfo();
            w.a = com.fotoable.fotoproedit.activity.mosaic.MosaicInfo.MosaicMode.Mosaic_Maoboli;
            k.setActionBarTitle("");
            alh alh1 = new alh();
            u.fillIconScroll(alh1.a());
            x.setVisibility(8);
        } else
        {
            w = new MosaicInfo();
            w.d = "mosaicRes/paintBrush/paintBrush0.png";
            w.a = com.fotoable.fotoproedit.activity.mosaic.MosaicInfo.MosaicMode.Paint_Normal;
            k.setActionBarTitle("");
            alh alh2 = new alh();
            u.fillIconScroll(alh2.b());
            x.setMaxSizeWithDoubleLine(getResources().getDisplayMetrics().widthPixels, yp.a(this, 36F));
            x.setVisibility(0);
            x.setOnColorSelectorListener(new ahp(this));
        }
        k.setOnAcceptListener(this);
        u.setListener(new ahq(this));
        a();
        (new Thread(new ahr(this))).start();
    }

    public static ImageView g(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.D;
    }

    private void g()
    {
        Log.i("ProEditMosaicActivity", "refreshUI");
        MosaicGLSurfaceView mosaicglsurfaceview = s;
        double d1;
        if (r)
        {
            d1 = (double)v * 1.5D;
        } else
        {
            d1 = v;
        }
        mosaicglsurfaceview.setBrushSize((int)d1);
        s.setPenColor(-256);
        s.setBrushImagePath("mosaicRes/paintBrush/paintBrush0.png");
        s.setMosaicImagePath("maoboli");
        s.setOperateDelegate(this);
        s.setMinPenSize(v);
        a();
        s.setOriImage(q, r, new ahv(this));
    }

    private void h()
    {
        l.setTag(Integer.valueOf(1024));
        m.setTag(Integer.valueOf(1025));
        n.setTag(Integer.valueOf(1026));
        o.setTag(Integer.valueOf(1027));
        p.setTag("btnErase");
        p.setOnClickListener(J);
        l.setOnClickListener(H);
        m.setOnClickListener(H);
        n.setOnClickListener(H);
        o.setOnClickListener(H);
        a(m, true);
        a(l, false);
        a(n, false);
        a(o, false);
        a(p, false);
    }

    public static boolean h(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.r;
    }

    public static Bitmap i(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.q;
    }

    public static void j(ProEditMosaicActivity proeditmosaicactivity)
    {
        proeditmosaicactivity.g();
    }

    public static FrameLayout k(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.t;
    }

    public static ImageButton l(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.l;
    }

    public static ImageButton m(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.m;
    }

    public static ImageButton n(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.n;
    }

    public static ImageButton o(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.o;
    }

    public static int p(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.v;
    }

    public static ImageButton q(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.p;
    }

    public Bitmap a(int i1)
    {
        Bitmap bitmap = Bitmap.createBitmap(50, 50, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(i1);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(4F);
        canvas.drawCircle(((float)50 - 1.0F) / 2.0F, ((float)50 - 1.0F) / 2.0F, Math.min(50, 50) / 2.0F, paint);
        return bitmap;
    }

    public void a()
    {
        try
        {
            if (B != null)
            {
                return;
            }
        }
        catch (Exception exception)
        {
            return;
        }
        B = ProcessDialogFragment.a(c());
        B.setCancelable(false);
        B.show(getSupportFragmentManager(), "process");
        return;
    }

    public void a(Bitmap bitmap)
    {
        runOnUiThread(new ahj(this, bitmap));
    }

    public void a(String s1)
    {
        C = s1;
    }

    public void a(boolean flag, boolean flag1)
    {
        Log.e(h, (new StringBuilder()).append("canPre:").append(flag).append("canNext:").append(flag1).toString());
        runOnUiThread(new ahi(this, flag, flag1));
    }

    public void b()
    {
        try
        {
            if (B != null)
            {
                B.dismissAllowingStateLoss();
                a(getResources().getString(0x7f0601c6));
                B = null;
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public String c()
    {
        return C;
    }

    public void d()
    {
        s.saveImage();
    }

    public void e()
    {
        b();
        finish();
        overridePendingTransition(0, 0x7f04001e);
    }

    public void onBackPressed()
    {
        b();
        finish();
        overridePendingTransition(0, 0x7f04001e);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030037);
        t = (FrameLayout)findViewById(0x7f0d00bb);
        c = (RelativeLayout)findViewById(0x7f0d00b0);
        bundle = (android.widget.FrameLayout.LayoutParams)t.getLayoutParams();
        if (!azn.a(this))
        {
            bundle.topMargin = yp.a(this, 8F);
            c.setVisibility(8);
        }
        b = (FrameLayout)findViewById(0x7f0d013d);
        b.setVisibility(0);
        bundle = AnimationUtils.loadAnimation(this, 0x7f040030);
        b.startAnimation(bundle);
        k = (ProEidtActionBarView)findViewById(0x7f0d00ba);
        l = (ImageButton)findViewById(0x7f0d0143);
        m = (ImageButton)findViewById(0x7f0d0144);
        n = (ImageButton)findViewById(0x7f0d0145);
        o = (ImageButton)findViewById(0x7f0d0146);
        p = (ImageButton)findViewById(0x7f0d0142);
        u = (MosaicIconScrollView)findViewById(0x7f0d0140);
        A = (LinearLayout)findViewById(0x7f0d013e);
        x = (ColorSelectView)findViewById(0x7f0d013f);
        D = (ImageView)findViewById(0x7f0d013c);
        D.setVisibility(4);
        E = (FrameLayout)findViewById(0x7f0d0147);
        z = (ImageButton)findViewById(0x7f0d013b);
        y = (ImageButton)findViewById(0x7f0d013a);
        y.setOnClickListener(G);
        z.setOnClickListener(F);
        y.setEnabled(false);
        z.setEnabled(false);
        v = yp.a(this, 16F);
        h();
        f();
        a(getResources().getString(0x7f0601c6));
        if (r)
        {
            bundle = "mosaic_first_tip";
        } else
        {
            bundle = "paint_first_tip";
        }
        i = bundle;
        if (!aqx.a(this, i, true))
        {
            E.setVisibility(8);
        }
        E.setOnClickListener(new ahd(this));
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (f != null)
        {
            f.a(null);
        }
    }

    protected void onPause()
    {
        super.onPause();
        if (s != null)
        {
            s.onPause();
        }
    }

    protected void onResume()
    {
        super.onResume();
        FlurryAgent.onPageView();
        if (azn.a(this))
        {
            FotoAdFactory.createAdBanner(this, c);
        }
        if (e)
        {
            e = false;
        }
        if (s != null)
        {
            s.onResume();
            s.bringToFront();
        }
    }

}
