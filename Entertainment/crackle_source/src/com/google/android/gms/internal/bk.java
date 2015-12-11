// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

// Referenced classes of package com.google.android.gms.internal:
//            cw, bm, bn, cu, 
//            ct, cp, cx, bo, 
//            bp, q, bh, co

public final class bk extends bs.a
{
    private static final class a extends Exception
    {

        public a(String s)
        {
            super(s);
        }
    }

    private static final class b
    {

        public final android.view.ViewGroup.LayoutParams gE;
        public final ViewGroup gF;
        public final int index;

        public b(cw cw1)
            throws a
        {
            gE = cw1.getLayoutParams();
            android.view.ViewParent viewparent = cw1.getParent();
            if (viewparent instanceof ViewGroup)
            {
                gF = (ViewGroup)viewparent;
                index = gF.indexOfChild(cw1);
                gF.removeView(cw1);
                cw1.l(true);
                return;
            } else
            {
                throw new a("Could not get the parent of the WebView for an overlay.");
            }
        }
    }


    private boolean gA;
    private boolean gB;
    private RelativeLayout gC;
    private final Activity gs;
    private bm gt;
    private bo gu;
    private cw gv;
    private b gw;
    private bp gx;
    private FrameLayout gy;
    private android.webkit.WebChromeClient.CustomViewCallback gz;

    public bk(Activity activity)
    {
        gA = false;
        gB = false;
        gs = activity;
    }

    private void Z()
    {
        if (gs.isFinishing() && !gB)
        {
            gB = true;
            if (gs.isFinishing())
            {
                if (gv != null)
                {
                    gv.az();
                    gC.removeView(gv);
                    if (gw != null)
                    {
                        gv.l(false);
                        gw.gF.addView(gv, gw.index, gw.gE);
                    }
                }
                if (gt != null && gt.gI != null)
                {
                    gt.gI.A();
                    return;
                }
            }
        }
    }

    private static android.widget.RelativeLayout.LayoutParams a(int i, int j, int k, int l)
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(k, l);
        layoutparams.setMargins(i, j, 0, 0);
        layoutparams.addRule(10);
        layoutparams.addRule(9);
        return layoutparams;
    }

    public static void a(Context context, bm bm1)
    {
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", bm1.ej.iM);
        bm.a(intent, bm1);
        intent.addFlags(0x80000);
        context.startActivity(intent);
    }

    private void h(boolean flag)
        throws a
    {
        gs.requestWindowFeature(1);
        Window window = gs.getWindow();
        window.setFlags(1024, 1024);
        setRequestedOrientation(gt.orientation);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            ct.r("Enabling hardware acceleration on the AdActivity window.");
            cp.a(window);
        }
        gC = new RelativeLayout(gs);
        gC.setBackgroundColor(0xff000000);
        gs.setContentView(gC);
        boolean flag1 = gt.gJ.aC().aJ();
        if (flag)
        {
            gv = cw.a(gs, gt.gJ.y(), true, flag1, null, gt.ej);
            gv.aC().a(null, null, gt.gK, gt.gO, true);
            gv.aC().a(new cx.a() {

                final bk gD;

                public void a(cw cw1)
                {
                    cw1.aA();
                }

            
            {
                gD = bk.this;
                super();
            }
            });
            if (gt.go != null)
            {
                gv.loadUrl(gt.go);
            } else
            if (gt.gN != null)
            {
                gv.loadDataWithBaseURL(gt.gL, gt.gN, "text/html", "UTF-8", null);
            } else
            {
                throw new a("No URL or HTML to display in ad overlay.");
            }
        } else
        {
            gv = gt.gJ;
            gv.setContext(gs);
        }
        gv.a(this);
        gC.addView(gv, -1, -1);
        if (!flag)
        {
            gv.aA();
        }
        f(flag1);
    }

    public bo W()
    {
        return gu;
    }

    public void X()
    {
        if (gt != null)
        {
            setRequestedOrientation(gt.orientation);
        }
        if (gy != null)
        {
            gs.setContentView(gC);
            gy.removeAllViews();
            gy = null;
        }
        if (gz != null)
        {
            gz.onCustomViewHidden();
            gz = null;
        }
    }

    public void Y()
    {
        gC.removeView(gx);
        f(true);
    }

    public void a(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        gy = new FrameLayout(gs);
        gy.setBackgroundColor(0xff000000);
        gy.addView(view, -1, -1);
        gs.setContentView(gy);
        gz = customviewcallback;
    }

    public void b(int i, int j, int k, int l)
    {
        if (gu != null)
        {
            gu.setLayoutParams(a(i, j, k, l));
        }
    }

    public void c(int i, int j, int k, int l)
    {
        if (gu == null)
        {
            gu = new bo(gs, gv);
            gC.addView(gu, 0, a(i, j, k, l));
            gv.aC().m(false);
        }
    }

    public void close()
    {
        gs.finish();
    }

    public void f(boolean flag)
    {
        android.widget.RelativeLayout.LayoutParams layoutparams;
        byte byte0;
        if (flag)
        {
            byte0 = 50;
        } else
        {
            byte0 = 32;
        }
        gx = new bp(gs, byte0);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(10);
        if (flag)
        {
            byte0 = 11;
        } else
        {
            byte0 = 9;
        }
        layoutparams.addRule(byte0);
        gx.g(gt.gM);
        gC.addView(gx, layoutparams);
    }

    public void g(boolean flag)
    {
        if (gx != null)
        {
            gx.g(flag);
        }
    }

    public void onCreate(Bundle bundle)
    {
        boolean flag = false;
        if (bundle != null)
        {
            flag = bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        gA = flag;
        gt = bm.a(gs.getIntent());
        if (gt == null)
        {
            throw new a("Could not get info for ad overlay.");
        }
          goto _L1
_L7:
        return;
_L1:
        if (bundle != null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        if (gt.gI != null)
        {
            gt.gI.B();
        }
        if (gt.gP != 1 && gt.gH != null)
        {
            gt.gH.w();
        }
        gt.gP;
        JVM INSTR tableswitch 1 4: default 258
    //                   1 175
    //                   2 181
    //                   3 205
    //                   4 211;
           goto _L2 _L3 _L4 _L5 _L6
_L2:
        throw new a("Could not determine ad overlay type.");
_L3:
        h(false);
        return;
_L4:
        try
        {
            gw = new b(gt.gJ);
            h(false);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            ct.v(bundle.getMessage());
            gs.finish();
        }
          goto _L7
_L5:
        h(true);
        return;
_L6:
        if (gA)
        {
            gs.finish();
            return;
        }
        if (bh.a(gs, gt.gG, gt.gO)) goto _L7; else goto _L8
_L8:
        gs.finish();
        return;
    }

    public void onDestroy()
    {
        if (gu != null)
        {
            gu.destroy();
        }
        if (gv != null)
        {
            gC.removeView(gv);
        }
        Z();
    }

    public void onPause()
    {
        if (gu != null)
        {
            gu.pause();
        }
        X();
        if (gv != null && (!gs.isFinishing() || gw == null))
        {
            co.a(gv);
        }
        Z();
    }

    public void onRestart()
    {
    }

    public void onResume()
    {
        if (gt != null && gt.gP == 4)
        {
            if (gA)
            {
                gs.finish();
            } else
            {
                gA = true;
            }
        }
        if (gv != null)
        {
            co.b(gv);
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", gA);
    }

    public void onStart()
    {
    }

    public void onStop()
    {
        Z();
    }

    public void setRequestedOrientation(int i)
    {
        gs.setRequestedOrientation(i);
    }
}
