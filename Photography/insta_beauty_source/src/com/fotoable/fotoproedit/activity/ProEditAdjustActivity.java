// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import ael;
import aem;
import aep;
import aeq;
import aer;
import aje;
import amo;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import azn;
import bjd;
import bje;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.fotobeauty.FullscreenActivity;
import com.fotoable.fotoproedit.activity.adjust.AdjustButtomItemView;
import com.fotoable.fotoproedit.activity.adjust.AdjustGLSurfaceView;
import com.fotoable.fotoproedit.view.ui.ProEidtActionBarView;
import com.wantu.utility.ui.ProcessDialogFragment;
import java.util.ArrayList;
import java.util.HashMap;
import yp;

public class ProEditAdjustActivity extends FullscreenActivity
    implements aje, amo
{

    private String A;
    private String B;
    private AdjustGLSurfaceView C;
    private Bitmap D;
    private boolean E;
    private ProcessDialogFragment F;
    private String G;
    private android.view.View.OnClickListener H;
    private android.widget.SeekBar.OnSeekBarChangeListener I;
    FrameLayout a;
    RelativeLayout b;
    bjd c;
    bje d;
    boolean e;
    private String f;
    private boolean g;
    private AdjustButtomItemView h;
    private AdjustButtomItemView i;
    private AdjustButtomItemView j;
    private AdjustButtomItemView k;
    private AdjustButtomItemView l;
    private AdjustButtomItemView m;
    private AdjustButtomItemView n;
    private AdjustButtomItemView o;
    private SeekBar p;
    private HashMap q;
    private ProEidtActionBarView r;
    private FrameLayout s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    public ProEditAdjustActivity()
    {
        f = "ProEditAdjustActivity";
        g = false;
        t = "adjust_brightness";
        u = "adjust_constrait";
        v = "adjust_Sharpness";
        w = "adjust_balance";
        x = "adjust_saturation";
        y = "adjust_highlight";
        z = "adjust_sshadow";
        A = "adjust_colortemp";
        E = false;
        H = new ael(this);
        d = new aep(this);
        I = new aeq(this);
        e = true;
    }

    public static Bitmap a(ProEditAdjustActivity proeditadjustactivity, Bitmap bitmap)
    {
        proeditadjustactivity.D = bitmap;
        return bitmap;
    }

    public static AdjustButtomItemView a(ProEditAdjustActivity proeditadjustactivity)
    {
        return proeditadjustactivity.h;
    }

    public static String a(ProEditAdjustActivity proeditadjustactivity, String s1)
    {
        proeditadjustactivity.B = s1;
        return s1;
    }

    private void a(int i1)
    {
        q.put(B, Integer.valueOf(i1));
        float f1 = (float)(i1 - 50) / 100F;
        int j1 = i1;
        if (B == w)
        {
            if (i1 > 50)
            {
                i1 -= 50;
                f1 = ((float)i1 / 50F) * 0.5F + 1.0F;
            } else
            {
                f1 = 0.7F + ((float)i1 / 50F) * 0.3F;
            }
            Log.e(f, (new StringBuilder()).append("balnace:").append(f1).toString());
            C.setWhiteblance(f1);
            j1 = i1;
        }
        i1 = j1;
        if (B == t)
        {
            if (j1 < 50)
            {
                f1 = 3F - ((float)j1 / 50F) * 2.0F;
            } else
            {
                j1 -= 50;
                f1 = 1.0F - ((float)j1 / 50F) * 0.7F;
            }
            Log.e(f, (new StringBuilder()).append("brightness:").append(f1).toString());
            C.setGamma(f1);
            i1 = j1;
        }
        if (B == x)
        {
            f1 = 0.0F + ((float)i1 / 100F) * 2.0F;
            Log.e(f, (new StringBuilder()).append("saturation:").append(f1).toString());
            C.setSaturation(f1);
        }
        if (B == v)
        {
            f1 = -1F + ((float)i1 / 100F) * 2.0F;
            Log.e(f, (new StringBuilder()).append("sharpeness:").append(f1).toString());
            C.setSharpness(f1);
        }
        if (B == u)
        {
            f1 = 0.5F + ((float)i1 / 100F) * 1.0F;
            Log.e(f, (new StringBuilder()).append("constait:").append(f1).toString());
            C.setContrast(f1);
        }
        if (B == z)
        {
            f1 = (float)i1 / 100F;
            Log.e(f, (new StringBuilder()).append("Shadow:").append(f1).toString());
            C.setShadow(f1);
        }
        if (B == y)
        {
            f1 = (float)i1 / 100F;
            Log.e(f, (new StringBuilder()).append("Highlight:").append(f1).toString());
            C.setHighlight(f1);
        }
        if (B == A)
        {
            if (i1 > 50)
            {
                f1 = ((float)(i1 - 50) / 50F) * 33400F + 6600F;
            } else
            {
                f1 = 1000F + ((float)i1 / 50F) * 5600F;
            }
            Log.e(f, (new StringBuilder()).append("Colortemprature:").append(f1).toString());
            C.setColortemprature(f1);
        }
    }

    public static void a(ProEditAdjustActivity proeditadjustactivity, int i1)
    {
        proeditadjustactivity.b(i1);
    }

    private void a(ArrayList arraylist)
    {
        try
        {
            c = new bjd();
            c.a(d);
            c.a(arraylist);
            c.b(azn.d());
            c.d(new ArrayList[] {
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

    public static boolean a(ProEditAdjustActivity proeditadjustactivity, boolean flag)
    {
        proeditadjustactivity.E = flag;
        return flag;
    }

    public static AdjustButtomItemView b(ProEditAdjustActivity proeditadjustactivity)
    {
        return proeditadjustactivity.k;
    }

    private void b(int i1)
    {
        if (i1 <= 50)
        {
            if (i1 < 50)
            {
                (new StringBuilder()).append("-").append(String.valueOf(50 - i1)).toString();
            } else
            if (i1 != 50);
        }
        if (B != y)
        {
            if (B != z);
        }
    }

    public static void b(ProEditAdjustActivity proeditadjustactivity, int i1)
    {
        proeditadjustactivity.a(i1);
    }

    public static AdjustButtomItemView c(ProEditAdjustActivity proeditadjustactivity)
    {
        return proeditadjustactivity.l;
    }

    public static AdjustButtomItemView d(ProEditAdjustActivity proeditadjustactivity)
    {
        return proeditadjustactivity.j;
    }

    public static AdjustButtomItemView e(ProEditAdjustActivity proeditadjustactivity)
    {
        return proeditadjustactivity.i;
    }

    public static AdjustButtomItemView f(ProEditAdjustActivity proeditadjustactivity)
    {
        return proeditadjustactivity.m;
    }

    private void f()
    {
        q = new HashMap();
        q.put(t, Integer.valueOf(50));
        q.put(u, Integer.valueOf(50));
        q.put(v, Integer.valueOf(50));
        q.put(w, Integer.valueOf(50));
        q.put(x, Integer.valueOf(50));
        q.put(A, Integer.valueOf(50));
        q.put(z, Integer.valueOf(0));
        q.put(y, Integer.valueOf(0));
        i.setOnClickListener(H);
        l.setOnClickListener(H);
        h.setOnClickListener(H);
        j.setOnClickListener(H);
        k.setOnClickListener(H);
        n.setOnClickListener(H);
        m.setOnClickListener(H);
        o.setOnClickListener(H);
        i.setTag(v);
        l.setTag(w);
        h.setTag(t);
        j.setTag(u);
        k.setTag(x);
        n.setTag(A);
        m.setTag(z);
        o.setTag(y);
        B = t;
        h.setSelected(true);
        k.setSelected(false);
        l.setSelected(false);
        j.setSelected(false);
        i.setSelected(false);
        n.setSelected(false);
        m.setSelected(false);
        o.setSelected(false);
        i.setData(0x7f020293, 0x7f060070);
        j.setData(0x7f02028e, 0x7f06006b);
        l.setData(0x7f020295, 0x7f060071);
        k.setData(0x7f020291, 0x7f06006e);
        h.setData(0x7f02028f, 0x7f06006c);
        n.setData(0x7f020294, 0x7f06006a);
        m.setData(0x7f020292, 0x7f06006f);
        o.setData(0x7f020290, 0x7f06006d);
        p.setMax(100);
        p.setProgress(50);
        b(50);
        p.setOnSeekBarChangeListener(I);
    }

    public static AdjustButtomItemView g(ProEditAdjustActivity proeditadjustactivity)
    {
        return proeditadjustactivity.o;
    }

    private void g()
    {
        a();
        (new Thread(new aem(this))).start();
    }

    public static AdjustButtomItemView h(ProEditAdjustActivity proeditadjustactivity)
    {
        return proeditadjustactivity.n;
    }

    private void h()
    {
        Point point = i();
        int i1 = getResources().getDisplayMetrics().heightPixels;
        int j1 = getResources().getDisplayMetrics().widthPixels;
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutparams.width = point.x;
        layoutparams.height = point.y;
        layoutparams.gravity = 51;
        layoutparams.leftMargin = (j1 - point.x) / 2;
        layoutparams.topMargin = (i1 - yp.a(this, 122F) - point.y) / 2 + yp.a(this, 12F);
        if (azn.a(this))
        {
            layoutparams.topMargin = (i1 - yp.a(this, 172F) - point.y) / 2 + yp.a(this, 12F) + yp.a(this, 50F);
        }
        s.setLayoutParams(layoutparams);
        C = new AdjustGLSurfaceView(this);
        C.setBackgroundColor(0x3f3f3f);
        C.setOriImage(D);
        C.setOperateDelegate(this);
        s.addView(C, new android.widget.FrameLayout.LayoutParams(-1, -1));
    }

    private Point i()
    {
        float f5 = getResources().getDisplayMetrics().widthPixels - yp.a(this, 16F);
        float f1 = getResources().getDisplayMetrics().heightPixels - yp.a(this, 122F);
        if (azn.a(this))
        {
            f1 = getResources().getDisplayMetrics().heightPixels - yp.a(this, 172F);
        }
        float f3 = D.getWidth();
        float f4 = D.getHeight();
        float f2 = f3 / f5;
        if (f3 / f4 < f5 / f1)
        {
            f1 = f4 / f1;
        } else
        {
            f1 = f2;
        }
        return new Point((int)(f3 / f1), (int)(f4 / f1));
    }

    public static String i(ProEditAdjustActivity proeditadjustactivity)
    {
        return proeditadjustactivity.B;
    }

    public static HashMap j(ProEditAdjustActivity proeditadjustactivity)
    {
        return proeditadjustactivity.q;
    }

    public static SeekBar k(ProEditAdjustActivity proeditadjustactivity)
    {
        return proeditadjustactivity.p;
    }

    public static Bitmap l(ProEditAdjustActivity proeditadjustactivity)
    {
        return proeditadjustactivity.D;
    }

    public static void m(ProEditAdjustActivity proeditadjustactivity)
    {
        proeditadjustactivity.h();
    }

    public static boolean n(ProEditAdjustActivity proeditadjustactivity)
    {
        return proeditadjustactivity.E;
    }

    public static boolean o(ProEditAdjustActivity proeditadjustactivity)
    {
        return proeditadjustactivity.g;
    }

    public void a()
    {
        try
        {
            if (F == null)
            {
                F = ProcessDialogFragment.a(c());
                F.setCancelable(false);
                F.show(getSupportFragmentManager(), "process");
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void a(Bitmap bitmap)
    {
        runOnUiThread(new aer(this, bitmap));
    }

    public void a(String s1)
    {
        G = s1;
    }

    public void b()
    {
        try
        {
            if (F != null)
            {
                F.dismissAllowingStateLoss();
                a(getResources().getString(0x7f0601c6));
                F = null;
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
        return G;
    }

    public void d()
    {
        C.saveImage();
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
        overridePendingTransition(0, 0x7f040038);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030033);
        a = (FrameLayout)findViewById(0x7f0d0113);
        a.setVisibility(0);
        l = (AdjustButtomItemView)findViewById(0x7f0d0115);
        h = (AdjustButtomItemView)findViewById(0x7f0d0114);
        i = (AdjustButtomItemView)findViewById(0x7f0d0118);
        k = (AdjustButtomItemView)findViewById(0x7f0d0117);
        j = (AdjustButtomItemView)findViewById(0x7f0d0116);
        o = (AdjustButtomItemView)findViewById(0x7f0d011a);
        n = (AdjustButtomItemView)findViewById(0x7f0d011b);
        m = (AdjustButtomItemView)findViewById(0x7f0d0119);
        p = (SeekBar)findViewById(0x7f0d011d);
        s = (FrameLayout)findViewById(0x7f0d0112);
        b = (RelativeLayout)findViewById(0x7f0d00b0);
        bundle = (android.widget.FrameLayout.LayoutParams)s.getLayoutParams();
        if (!azn.a(this))
        {
            bundle.topMargin = yp.a(this, 5F);
            b.setVisibility(8);
        }
        r = (ProEidtActionBarView)findViewById(0x7f0d00ba);
        r.setActionBarTitle(getResources().getText(0x7f060069).toString());
        r.setOnAcceptListener(this);
        f();
        a(getResources().getString(0x7f0601c6));
        bundle = getIntent();
        if (bundle != null)
        {
            g = bundle.getBooleanExtra("KISDERECTEDTOSAVE_STRING", false);
            if (g)
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
        if (!g)
        {
            g();
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    protected void onPause()
    {
        super.onPause();
        if (C != null)
        {
            C.onPause();
        }
    }

    protected void onResume()
    {
        super.onResume();
        FlurryAgent.onPageView();
        if (azn.a(this))
        {
            FotoAdFactory.createAdBanner(this, b);
        }
        if (e)
        {
            e = false;
            android.view.animation.Animation animation = AnimationUtils.loadAnimation(this, 0x7f040030);
            a.startAnimation(animation);
        }
        if (C != null)
        {
            C.onResume();
        }
    }
}
