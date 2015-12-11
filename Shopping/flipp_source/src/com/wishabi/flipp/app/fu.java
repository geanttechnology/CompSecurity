// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

// Referenced classes of package com.wishabi.flipp.app:
//            dl, fx, fv

public class fu extends dl
{

    private static final String a = com/wishabi/flipp/app/fu.getSimpleName();
    private static final Uri j = Uri.parse("https://backflipp.wishabi.com");
    private String c;
    private String d;
    private boolean e;
    private boolean f;
    private boolean g;
    private WebView h;
    private ProgressBar i;

    public fu()
    {
    }

    static WebView a(fu fu1)
    {
        return fu1.h;
    }

    static ProgressBar b(fu fu1)
    {
        return fu1.i;
    }

    public static fx b()
    {
        return new fx((byte)0);
    }

    static Uri c()
    {
        return j;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null)
        {
            bundle = getArguments();
        }
        if (bundle != null)
        {
            c = bundle.getString("url", null);
            e = bundle.getBoolean("enable_zoom");
            f = bundle.getBoolean("enable_javascript");
            g = bundle.getBoolean("fit_to_width");
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030056, viewgroup, false);
        if (layoutinflater == null)
        {
            return null;
        } else
        {
            h = (WebView)layoutinflater.findViewById(0x7f0b014b);
            i = (ProgressBar)layoutinflater.findViewById(0x7f0b014c);
            i.setVisibility(0);
            i.setAlpha(1.0F);
            h.setVisibility(8);
            h.setAlpha(0.0F);
            return layoutinflater;
        }
    }

    public void onPause()
    {
        h.onPause();
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        h.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putString("url", c);
        bundle.putBoolean("enable_zoom", e);
        bundle.putBoolean("enable_javascript", f);
        bundle.putBoolean("fit_to_width", g);
        if (h != null)
        {
            h.saveState(bundle);
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        if (getActivity() != null)
        {
            b(d);
            h.getSettings().setDisplayZoomControls(false);
            h.setBackgroundColor(getResources().getColor(0x7f090065));
            h.setWebViewClient(new fv(this));
            if (e)
            {
                h.getSettings().setBuiltInZoomControls(true);
            }
            if (f)
            {
                h.getSettings().setJavaScriptEnabled(true);
                h.setWebChromeClient(new WebChromeClient());
            }
            if (g)
            {
                h.getSettings().setLoadWithOverviewMode(true);
                h.getSettings().setUseWideViewPort(true);
            }
            if (bundle != null)
            {
                h.restoreState(bundle);
                return;
            }
            if (c != null)
            {
                view = c;
                h.loadUrl(c);
                return;
            }
        }
    }

}
