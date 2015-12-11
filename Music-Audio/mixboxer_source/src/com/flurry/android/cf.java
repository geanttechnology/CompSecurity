// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;

// Referenced classes of package com.flurry.android:
//            db, ab, n, ee, 
//            FlurryFullscreenTakeoverActivity, h, aq

final class cf extends RelativeLayout
    implements android.view.View.OnClickListener
{

    private final String TAG = getClass().getSimpleName();
    private boolean eA;
    private WebView eq;
    private WebViewClient er;
    private WebChromeClient es;
    private boolean et;
    private ImageView eu;
    private ImageView ev;
    private ImageView ew;
    private h ex;
    private ee ey;
    private aq ez;

    public cf(Context context, String s)
    {
        super(context);
        eq = new WebView(context);
        er = new db(this);
        es = new ab(this);
        eq.getSettings().setJavaScriptEnabled(true);
        eq.getSettings().setUseWideViewPort(true);
        if (n.SDK_INT >= 7)
        {
            eq.getSettings().setLoadWithOverviewMode(true);
        }
        eq.getSettings().setBuiltInZoomControls(true);
        if (n.SDK_INT >= 11)
        {
            eq.getSettings().setDisplayZoomControls(false);
        }
        eq.setWebViewClient(er);
        eq.setWebChromeClient(es);
        eq.loadUrl(s);
        eu = new ImageView(context);
        eu.setId(0);
        eu.setImageDrawable(getResources().getDrawable(0x1080038));
        eu.setOnClickListener(this);
        ev = new ImageView(context);
        ev.setId(1);
        ev.setImageDrawable(getResources().getDrawable(0x108004c));
        ev.setOnClickListener(this);
        ew = new ImageView(context);
        ew.setId(2);
        ew.setImageDrawable(getResources().getDrawable(0x108003d));
        ew.setOnClickListener(this);
        setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        addView(eq);
        context = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        context.addRule(14);
        addView(eu, context);
        context = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        context.addRule(9);
        addView(ev, context);
        context = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        context.addRule(11);
        addView(ew, context);
    }

    static WebView a(cf cf1)
    {
        return cf1.eq;
    }

    static boolean a(cf cf1, boolean flag)
    {
        cf1.eA = flag;
        return flag;
    }

    static h b(cf cf1)
    {
        return cf1.ex;
    }

    static boolean b(cf cf1, boolean flag)
    {
        cf1.et = flag;
        return flag;
    }

    static boolean c(cf cf1)
    {
        return cf1.eA;
    }

    static aq d(cf cf1)
    {
        return cf1.ez;
    }

    public final void a(aq aq)
    {
        ez = aq;
    }

    public final void a(ee ee1)
    {
        ey = ee1;
    }

    public final void a(h h)
    {
        ex = h;
    }

    public final boolean canGoBack()
    {
        return et || eq != null && eq.canGoBack();
    }

    public final void destroy()
    {
        if (eq != null)
        {
            removeView(eq);
            eq.stopLoading();
            if (n.SDK_INT >= 11)
            {
                eq.onPause();
            }
            eq.destroy();
            eq = null;
        }
    }

    public final String getUrl()
    {
        String s = null;
        if (eq != null)
        {
            s = eq.getUrl();
        }
        return s;
    }

    public final void goBack()
    {
        if (et)
        {
            es.onHideCustomView();
        } else
        if (eq != null)
        {
            eq.goBack();
            return;
        }
    }

    public final void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 0 2: default 32
    //                   0 33
    //                   1 76
    //                   2 51;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        if (ey != null)
        {
            ey.u.finish();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (eq != null && eq.canGoForward())
        {
            eq.goForward();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (eq != null && eq.canGoBack())
        {
            eq.goBack();
            return;
        }
        if (ey != null)
        {
            ey.u.finish();
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }
}
