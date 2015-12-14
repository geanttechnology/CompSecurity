// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.ToggleButton;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.fotoproedit.activity.adjust.AdjustButtomItemView;
import com.fotoable.fotoproedit.activity.adjust.AdjustGLSurfaceView;
import com.fotoable.photocollage.view.ProEidtActionBarView;
import com.pipcamera.activity.FullscreenActivity;
import com.wantu.utility.ui.ProcessDialogFragment;
import ew;
import gm;
import go;
import gt;
import java.util.HashMap;
import kf;
import ma;

public class ProEditAdjustActivity extends FullscreenActivity
    implements gt, ma
{

    private String A;
    private ToggleButton B;
    private RelativeLayout C;
    private android.view.View.OnClickListener D;
    private android.widget.SeekBar.OnSeekBarChangeListener E;
    private String a;
    private AdjustButtomItemView b;
    private AdjustButtomItemView c;
    private AdjustButtomItemView d;
    private AdjustButtomItemView e;
    private AdjustButtomItemView f;
    private AdjustButtomItemView g;
    private AdjustButtomItemView h;
    private AdjustButtomItemView i;
    private SeekBar j;
    private HashMap k;
    private ProEidtActionBarView l;
    private FrameLayout m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private AdjustGLSurfaceView w;
    private Bitmap x;
    private boolean y;
    private ProcessDialogFragment z;

    public ProEditAdjustActivity()
    {
        a = "ProEditAdjustActivity";
        n = "adjust_brightness";
        o = "adjust_constrait";
        p = "adjust_Sharpness";
        q = "adjust_balance";
        r = "adjust_saturation";
        s = "adjust_highlight";
        t = "adjust_sshadow";
        u = "adjust_colortemp";
        y = false;
        D = new android.view.View.OnClickListener() {

            final ProEditAdjustActivity a;

            public void onClick(View view)
            {
                ProEditAdjustActivity.a(a).setSelected(false);
                ProEditAdjustActivity.b(a).setSelected(false);
                ProEditAdjustActivity.c(a).setSelected(false);
                ProEditAdjustActivity.d(a).setSelected(false);
                ProEditAdjustActivity.e(a).setSelected(false);
                ProEditAdjustActivity.f(a).setSelected(false);
                ProEditAdjustActivity.g(a).setSelected(false);
                ProEditAdjustActivity.h(a).setSelected(false);
                view.setSelected(true);
                ProEditAdjustActivity.a(a, view.getTag().toString());
                int i1 = ((Integer)ProEditAdjustActivity.j(a).get(ProEditAdjustActivity.i(a))).intValue();
                ProEditAdjustActivity.a(a, true);
                ProEditAdjustActivity.k(a).setProgress(i1);
            }

            
            {
                a = ProEditAdjustActivity.this;
                super();
            }
        };
        E = new android.widget.SeekBar.OnSeekBarChangeListener() {

            final ProEditAdjustActivity a;

            public void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
            {
                ProEditAdjustActivity.a(a, i1);
                if (ProEditAdjustActivity.l(a))
                {
                    ProEditAdjustActivity.a(a, false);
                    return;
                } else
                {
                    ProEditAdjustActivity.b(a, i1);
                    return;
                }
            }

            public void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public void onStopTrackingTouch(SeekBar seekbar)
            {
            }

            
            {
                a = ProEditAdjustActivity.this;
                super();
            }
        };
    }

    static AdjustButtomItemView a(ProEditAdjustActivity proeditadjustactivity)
    {
        return proeditadjustactivity.b;
    }

    static String a(ProEditAdjustActivity proeditadjustactivity, String s1)
    {
        proeditadjustactivity.v = s1;
        return s1;
    }

    private void a(int i1)
    {
        k.put(v, Integer.valueOf(i1));
        float f1 = (float)(i1 - 50) / 100F;
        int j1 = i1;
        if (v == q)
        {
            if (i1 > 50)
            {
                i1 -= 50;
                f1 = ((float)i1 / 50F) * 0.5F + 1.0F;
            } else
            {
                f1 = 0.7F + ((float)i1 / 50F) * 0.3F;
            }
            Log.e(a, (new StringBuilder()).append("balnace:").append(f1).toString());
            w.setWhiteblance(f1);
            j1 = i1;
        }
        i1 = j1;
        if (v == n)
        {
            if (j1 < 50)
            {
                f1 = 3F - ((float)j1 / 50F) * 2.0F;
            } else
            {
                j1 -= 50;
                f1 = 1.0F - ((float)j1 / 50F) * 0.7F;
            }
            Log.e(a, (new StringBuilder()).append("brightness:").append(f1).toString());
            w.setGamma(f1);
            i1 = j1;
        }
        if (v == r)
        {
            f1 = 0.0F + ((float)i1 / 100F) * 2.0F;
            Log.e(a, (new StringBuilder()).append("saturation:").append(f1).toString());
            w.setSaturation(f1);
        }
        if (v == p)
        {
            f1 = -1F + ((float)i1 / 100F) * 2.0F;
            Log.e(a, (new StringBuilder()).append("sharpeness:").append(f1).toString());
            w.setSharpness(f1);
        }
        if (v == o)
        {
            f1 = 0.5F + ((float)i1 / 100F) * 1.0F;
            Log.e(a, (new StringBuilder()).append("constait:").append(f1).toString());
            w.setContrast(f1);
        }
        if (v == t)
        {
            f1 = (float)i1 / 100F;
            Log.e(a, (new StringBuilder()).append("Shadow:").append(f1).toString());
            w.setShadow(f1);
        }
        if (v == s)
        {
            f1 = (float)i1 / 100F;
            Log.e(a, (new StringBuilder()).append("Highlight:").append(f1).toString());
            w.setHighlight(f1);
        }
        if (v == u)
        {
            if (i1 > 50)
            {
                f1 = ((float)(i1 - 50) / 50F) * 33400F + 6600F;
            } else
            {
                f1 = 1000F + ((float)i1 / 50F) * 5600F;
            }
            Log.e(a, (new StringBuilder()).append("Colortemprature:").append(f1).toString());
            w.setColortemprature(f1);
        }
    }

    static void a(ProEditAdjustActivity proeditadjustactivity, int i1)
    {
        proeditadjustactivity.b(i1);
    }

    static boolean a(ProEditAdjustActivity proeditadjustactivity, boolean flag)
    {
        proeditadjustactivity.y = flag;
        return flag;
    }

    static AdjustButtomItemView b(ProEditAdjustActivity proeditadjustactivity)
    {
        return proeditadjustactivity.e;
    }

    private void b(int i1)
    {
        String s1 = "";
        if (i1 <= 50) goto _L2; else goto _L1
_L1:
        s1 = String.valueOf(i1 - 50);
_L4:
        if (v == s || v == t)
        {
            s1 = String.valueOf(i1);
        }
        B.setText(s1);
        B.setTextOff(s1);
        B.setTextOn(s1);
        return;
_L2:
        if (i1 < 50)
        {
            s1 = (new StringBuilder()).append("-").append(String.valueOf(50 - i1)).toString();
        } else
        if (i1 == 50)
        {
            s1 = "0";
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static void b(ProEditAdjustActivity proeditadjustactivity, int i1)
    {
        proeditadjustactivity.a(i1);
    }

    static AdjustButtomItemView c(ProEditAdjustActivity proeditadjustactivity)
    {
        return proeditadjustactivity.f;
    }

    static AdjustButtomItemView d(ProEditAdjustActivity proeditadjustactivity)
    {
        return proeditadjustactivity.d;
    }

    static AdjustButtomItemView e(ProEditAdjustActivity proeditadjustactivity)
    {
        return proeditadjustactivity.c;
    }

    static AdjustButtomItemView f(ProEditAdjustActivity proeditadjustactivity)
    {
        return proeditadjustactivity.g;
    }

    private void f()
    {
        k = new HashMap();
        k.put(n, Integer.valueOf(50));
        k.put(o, Integer.valueOf(50));
        k.put(p, Integer.valueOf(50));
        k.put(q, Integer.valueOf(50));
        k.put(r, Integer.valueOf(50));
        k.put(u, Integer.valueOf(50));
        k.put(t, Integer.valueOf(0));
        k.put(s, Integer.valueOf(0));
        c.setOnClickListener(D);
        f.setOnClickListener(D);
        b.setOnClickListener(D);
        d.setOnClickListener(D);
        e.setOnClickListener(D);
        h.setOnClickListener(D);
        g.setOnClickListener(D);
        i.setOnClickListener(D);
        c.setTag(p);
        f.setTag(q);
        b.setTag(n);
        d.setTag(o);
        e.setTag(r);
        h.setTag(u);
        g.setTag(t);
        i.setTag(s);
        v = n;
        b.setSelected(true);
        e.setSelected(false);
        f.setSelected(false);
        d.setSelected(false);
        c.setSelected(false);
        h.setSelected(false);
        g.setSelected(false);
        i.setSelected(false);
        c.setData(0x7f020183, 0x7f060074);
        d.setData(0x7f02017e, 0x7f06006f);
        f.setData(0x7f020185, 0x7f060075);
        e.setData(0x7f020181, 0x7f060072);
        b.setData(0x7f02017f, 0x7f060070);
        h.setData(0x7f020184, 0x7f06006e);
        g.setData(0x7f020182, 0x7f060073);
        i.setData(0x7f020180, 0x7f060071);
        j.setMax(100);
        j.setProgress(50);
        b(50);
        j.setOnSeekBarChangeListener(E);
    }

    static AdjustButtomItemView g(ProEditAdjustActivity proeditadjustactivity)
    {
        return proeditadjustactivity.i;
    }

    private void g()
    {
        x = gm.c().k();
        if (x == null)
        {
            b();
            finish();
            return;
        } else
        {
            Point point = h();
            int i1 = getResources().getDisplayMetrics().heightPixels;
            i1 = getResources().getDisplayMetrics().widthPixels;
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
            layoutparams.width = point.x;
            layoutparams.height = point.y;
            layoutparams.gravity = 51;
            layoutparams.leftMargin = (i1 - point.x) / 2;
            layoutparams.topMargin = ew.a(this, 108F);
            m.setLayoutParams(layoutparams);
            w = new AdjustGLSurfaceView(this);
            w.setOriImage(x);
            w.setOperateDelegate(this);
            m.addView(w, new android.widget.FrameLayout.LayoutParams(-1, -1));
            return;
        }
    }

    private Point h()
    {
        float f4 = getResources().getDisplayMetrics().widthPixels - ew.a(this, 16F);
        float f5 = getResources().getDisplayMetrics().heightPixels - ew.a(this, 122F) - ew.a(this, 50F);
        float f2 = x.getWidth();
        float f3 = x.getHeight();
        float f1 = f2 / f4;
        if (f2 / f3 < f4 / f5)
        {
            f1 = f3 / f5;
        }
        return new Point((int)(f2 / f1), (int)(f3 / f1));
    }

    static AdjustButtomItemView h(ProEditAdjustActivity proeditadjustactivity)
    {
        return proeditadjustactivity.h;
    }

    static String i(ProEditAdjustActivity proeditadjustactivity)
    {
        return proeditadjustactivity.v;
    }

    static HashMap j(ProEditAdjustActivity proeditadjustactivity)
    {
        return proeditadjustactivity.k;
    }

    static SeekBar k(ProEditAdjustActivity proeditadjustactivity)
    {
        return proeditadjustactivity.j;
    }

    static boolean l(ProEditAdjustActivity proeditadjustactivity)
    {
        return proeditadjustactivity.y;
    }

    static Bitmap m(ProEditAdjustActivity proeditadjustactivity)
    {
        return proeditadjustactivity.x;
    }

    public void a()
    {
        try
        {
            if (z == null)
            {
                z = ProcessDialogFragment.a(c());
                z.setCancelable(false);
                z.show(getSupportFragmentManager(), "process");
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
        runOnUiThread(new Runnable(bitmap) {

            final Bitmap a;
            final ProEditAdjustActivity b;

            public void run()
            {
                if (a == null || a == ProEditAdjustActivity.m(b))
                {
                    b.b();
                    b.finish();
                    b.overridePendingTransition(0, 0x7f040027);
                } else
                if (a != null)
                {
                    kf.b("adjust");
                    b.a();
                    gm.c().a(new go(this) {

                        final _cls3 a;

                        public void a()
                        {
                            a.b.setResult(-1);
                            a.b.b();
                            a.b.finish();
                            a.b.overridePendingTransition(0, 0x7f040027);
                        }

            
            {
                a = _pcls3;
                super();
            }
                    }, a, b);
                    return;
                }
            }

            
            {
                b = ProEditAdjustActivity.this;
                a = bitmap;
                super();
            }
        });
    }

    public void a(String s1)
    {
        A = s1;
    }

    public void b()
    {
        try
        {
            if (z != null)
            {
                z.dismissAllowingStateLoss();
                a(getResources().getString(0x7f0601a4));
                z = null;
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
        return A;
    }

    public void d()
    {
        w.saveImage();
    }

    public void e()
    {
        b();
        finish();
        overridePendingTransition(0, 0x7f040027);
    }

    public void onBackPressed()
    {
        b();
        finish();
        overridePendingTransition(0, 0x7f040027);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030022);
        f = (AdjustButtomItemView)findViewById(0x7f0c008b);
        b = (AdjustButtomItemView)findViewById(0x7f0c008a);
        c = (AdjustButtomItemView)findViewById(0x7f0c008e);
        e = (AdjustButtomItemView)findViewById(0x7f0c008d);
        d = (AdjustButtomItemView)findViewById(0x7f0c008c);
        i = (AdjustButtomItemView)findViewById(0x7f0c0090);
        h = (AdjustButtomItemView)findViewById(0x7f0c0091);
        g = (AdjustButtomItemView)findViewById(0x7f0c008f);
        C = (RelativeLayout)findViewById(0x7f0c0055);
        j = (SeekBar)findViewById(0x7f0c0093);
        m = (FrameLayout)findViewById(0x7f0c0089);
        B = (ToggleButton)findViewById(0x7f0c0094);
        l = (ProEidtActionBarView)findViewById(0x7f0c0088);
        l.setActionBarTitle(getResources().getText(0x7f060297).toString());
        l.setOnAcceptListener(this);
        f();
        a(getResources().getString(0x7f0601a4));
        g();
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    protected void onPause()
    {
        super.onPause();
        w.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        w.onResume();
        Log.v(a, (new StringBuilder()).append(a).append(" onResume").toString());
        if (!ew.n(this))
        {
            FotoAdFactory.createAdBanner(this, C);
            return;
        } else
        {
            C.setVisibility(8);
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)m.getLayoutParams();
            layoutparams.topMargin = ew.a(this, 58F);
            m.setLayoutParams(layoutparams);
            return;
        }
    }
}
