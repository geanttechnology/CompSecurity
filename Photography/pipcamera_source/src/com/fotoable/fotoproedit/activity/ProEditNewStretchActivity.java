// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.fotoproedit.activity.stretch.StretchNewImageView;
import com.fotoable.photocollage.view.ProEidtActionBarView;
import com.pipcamera.activity.FullscreenActivity;
import ew;
import gm;
import go;
import il;
import kf;
import ma;

public class ProEditNewStretchActivity extends FullscreenActivity
    implements ma
{

    StretchNewImageView a;
    ProEidtActionBarView b;
    FrameLayout c;
    FrameLayout d;
    FrameLayout e;
    TextView f;
    SeekBar g;
    boolean h;
    View i;
    ProgressDialog j;
    Button k;
    private Bitmap l;
    private RelativeLayout m;
    private String n;

    public ProEditNewStretchActivity()
    {
        h = true;
        n = "ProEditNewStretchActivity";
    }

    public void a()
    {
        d.setEnabled(false);
        f.setTextColor(0x7affffff);
        h = false;
        a.setDrawable(new BitmapDrawable(getResources(), l), 0, 0);
        g.setProgress(0);
        a.requestLayout();
    }

    public void d()
    {
        Log.i("clicked", "clicked");
        Bitmap bitmap;
        try
        {
            bitmap = a.getSaveBitamp();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            j.dismiss();
            return;
        }
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        if (!bitmap.isRecycled())
        {
            l = bitmap;
        }
        a.recycleImage();
        if (l != null && !l.isRecycled())
        {
            kf.b("stretch");
            j.show();
            gm.c().a(new go() {

                final ProEditNewStretchActivity a;

                public void a()
                {
                    a.setResult(-1);
                    a.j.dismiss();
                    a.finish();
                    a.overridePendingTransition(0, 0x7f040027);
                }

            
            {
                a = ProEditNewStretchActivity.this;
                super();
            }
            }, l, this);
        }
        return;
    }

    public void e()
    {
        a.recycleImage();
        setResult(0);
        finish();
        overridePendingTransition(0, 0x7f040027);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f030027);
        j = new ProgressDialog(this);
        j.setMessage(getResources().getString(0x7f0601a4));
        j.setCancelable(false);
        m = (RelativeLayout)findViewById(0x7f0c0055);
        b = (ProEidtActionBarView)findViewById(0x7f0c0088);
        bundle = getString(0x7f0602a3);
        b.setActionBarTitle(bundle);
        b.setOnAcceptListener(this);
        c = (FrameLayout)findViewById(0x7f0c0097);
        e = (FrameLayout)findViewById(0x7f0c0096);
        a = (StretchNewImageView)findViewById(0x7f0c00af);
        a.setStretchNewImageViewLisener(new il() {

            final ProEditNewStretchActivity a;

            public void a()
            {
                a.h = false;
                a.g.setProgress(0);
            }

            public void b()
            {
                a.d.setEnabled(true);
                a.f.setTextColor(-1);
            }

            
            {
                a = ProEditNewStretchActivity.this;
                super();
            }
        });
        k = (Button)findViewById(0x7f0c00c2);
        k.setOnTouchListener(new android.view.View.OnTouchListener() {

            final ProEditNewStretchActivity a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() != 0) goto _L2; else goto _L1
_L1:
                if (a.a != null)
                {
                    a.a.showPreImage();
                }
_L4:
                return false;
_L2:
                if ((motionevent.getAction() == 1 || motionevent.getAction() == 3) && a.a != null)
                {
                    a.a.hidePreImage();
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = ProEditNewStretchActivity.this;
                super();
            }
        });
        l = gm.c().k();
        a.setDrawable(new BitmapDrawable(getResources(), l), 0, 0);
        f = (TextView)findViewById(0x7f0c00c0);
        d = (FrameLayout)findViewById(0x7f0c00bf);
        d.setEnabled(false);
        f.setTextColor(0x7affffff);
        d.setOnClickListener(new android.view.View.OnClickListener() {

            final ProEditNewStretchActivity a;

            public void onClick(View view)
            {
                a.a();
            }

            
            {
                a = ProEditNewStretchActivity.this;
                super();
            }
        });
        i = (LinearLayout)findViewById(0x7f0c00be);
        g = (SeekBar)findViewById(0x7f0c00c1);
        g.setProgress(0);
        g.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            final ProEditNewStretchActivity a;

            public void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
            {
                if (a.g != null && a.h)
                {
                    a.d.setEnabled(true);
                    a.f.setTextColor(-1);
                    a.a.stretchWithSliderValue(i1 / 2);
                }
            }

            public void onStartTrackingTouch(SeekBar seekbar)
            {
                Log.e("startOnTouche", "start");
            }

            public void onStopTrackingTouch(SeekBar seekbar)
            {
            }

            
            {
                a = ProEditNewStretchActivity.this;
                super();
            }
        });
        g.setOnTouchListener(new android.view.View.OnTouchListener() {

            final ProEditNewStretchActivity a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                a.h = true;
                if (motionevent.getAction() == 1)
                {
                    a.a.resstProcessImage();
                }
                return false;
            }

            
            {
                a = ProEditNewStretchActivity.this;
                super();
            }
        });
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (a != null)
        {
            a.recycleImage();
        }
    }

    protected void onResume()
    {
        super.onResume();
        Log.v(n, (new StringBuilder()).append(n).append(" onResume").toString());
        if (!ew.n(this))
        {
            m.setVisibility(0);
            FotoAdFactory.createAdBanner(this, m);
            return;
        } else
        {
            m.setVisibility(8);
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)e.getLayoutParams();
            android.widget.FrameLayout.LayoutParams layoutparams1 = (android.widget.FrameLayout.LayoutParams)k.getLayoutParams();
            layoutparams.topMargin = ew.a(this, 50F);
            layoutparams1.topMargin = ew.a(this, 53F);
            e.setLayoutParams(layoutparams);
            k.setLayoutParams(layoutparams1);
            return;
        }
    }
}
