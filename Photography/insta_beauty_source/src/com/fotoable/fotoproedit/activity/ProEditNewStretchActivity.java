// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import ahx;
import ahy;
import ahz;
import aia;
import aib;
import aic;
import aif;
import aig;
import aij;
import amo;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import apq;
import azn;
import bjd;
import bje;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.fotobeauty.FullscreenActivity;
import com.fotoable.fotoproedit.activity.stretch.StretchNewImageView;
import com.fotoable.fotoproedit.view.ui.ProEidtActionBarView;
import java.util.ArrayList;
import uv;
import yp;

public class ProEditNewStretchActivity extends FullscreenActivity
    implements amo
{

    public StretchNewImageView a;
    ProEidtActionBarView b;
    FrameLayout c;
    public FrameLayout d;
    public TextView e;
    public SeekBar f;
    public boolean g;
    View h;
    public ProgressDialog i;
    FrameLayout j;
    FrameLayout k;
    RelativeLayout l;
    bjd m;
    bje n;
    private boolean o;
    private Bitmap p;

    public ProEditNewStretchActivity()
    {
        o = false;
        g = true;
        n = new aif(this);
    }

    public static Bitmap a(ProEditNewStretchActivity proeditnewstretchactivity)
    {
        return proeditnewstretchactivity.p;
    }

    public static Bitmap a(ProEditNewStretchActivity proeditnewstretchactivity, Bitmap bitmap)
    {
        proeditnewstretchactivity.p = bitmap;
        return bitmap;
    }

    private void a()
    {
        a.setDrawable(new BitmapDrawable(getResources(), p), 0, 0);
    }

    private void a(ArrayList arraylist)
    {
        try
        {
            m = new bjd();
            m.a(n);
            m.a(arraylist);
            m.b(azn.d());
            m.d(new ArrayList[] {
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

    private void b()
    {
        if (p != null && !p.isRecycled())
        {
            i.show();
            uv.c().a(p, new aij(this));
            return;
        } else
        {
            finish();
            return;
        }
    }

    public static void b(ProEditNewStretchActivity proeditnewstretchactivity)
    {
        proeditnewstretchactivity.a();
    }

    public static void c(ProEditNewStretchActivity proeditnewstretchactivity)
    {
        proeditnewstretchactivity.b();
    }

    public void d()
    {
        Log.i("clicked", "clicked");
        apq.a("Stretch");
        (new Thread(new aig(this))).start();
    }

    public void e()
    {
        a.recycleImage();
        setResult(0);
        finish();
        overridePendingTransition(0, 0x7f04001e);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f03003a);
        j = (FrameLayout)findViewById(0x7f0d0159);
        j.setVisibility(0);
        bundle = AnimationUtils.loadAnimation(this, 0x7f040030);
        j.startAnimation(bundle);
        i = new ProgressDialog(this);
        i.setMessage(getResources().getString(0x7f0601c6));
        i.setCancelable(false);
        b = (ProEidtActionBarView)findViewById(0x7f0d00ba);
        bundle = getString(0x7f060158);
        b.setActionBarTitle(bundle);
        b.setOnAcceptListener(this);
        c = (FrameLayout)findViewById(0x7f0d011f);
        l = (RelativeLayout)findViewById(0x7f0d00b0);
        k = (FrameLayout)findViewById(0x7f0d00bb);
        bundle = (android.widget.FrameLayout.LayoutParams)k.getLayoutParams();
        if (!azn.a(this))
        {
            bundle.topMargin = yp.a(this, 5F);
            l.setVisibility(8);
        }
        a = (StretchNewImageView)findViewById(0x7f0d012b);
        a.setStretchNewImageViewLisener(new ahx(this));
        ((Button)findViewById(0x7f0d0154)).setOnTouchListener(new ahy(this));
        e = (TextView)findViewById(0x7f0d015b);
        d = (FrameLayout)findViewById(0x7f0d015a);
        d.setEnabled(false);
        e.setTextColor(0x7affffff);
        d.setOnClickListener(new ahz(this));
        h = (LinearLayout)findViewById(0x7f0d0148);
        f = (SeekBar)findViewById(0x7f0d0149);
        f.setProgress(0);
        f.setOnSeekBarChangeListener(new aia(this));
        f.setOnTouchListener(new aib(this));
        bundle = getIntent();
        if (bundle != null)
        {
            o = bundle.getBooleanExtra("KISDERECTEDTOSAVE_STRING", false);
            if (o)
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
        i.show();
        if (!o)
        {
            (new Thread(new aic(this))).start();
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (a != null)
        {
            a.recycleImage();
        }
    }

    public void onResetClicked()
    {
        d.setEnabled(false);
        e.setTextColor(0x7affffff);
        g = false;
        a.setDrawable(new BitmapDrawable(getResources(), p), 0, 0);
        f.setProgress(0);
        a.requestLayout();
    }

    protected void onResume()
    {
        super.onResume();
        FlurryAgent.onPageView();
        if (azn.a(this))
        {
            FotoAdFactory.createAdBanner(this, l);
        }
    }
}
