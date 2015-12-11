// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.mopub.common.d.n;
import com.mopub.common.d.o;

public class j extends WebView
{

    private static boolean a = false;
    protected boolean b;

    public j(Context context)
    {
        super(context.getApplicationContext());
        a(false);
        setWebChromeClient(new com.mopub.mobileads.c.a._cls1());
        if (!a)
        {
            context = getContext();
            if (android.os.Build.VERSION.SDK_INT == 19)
            {
                WebView webview = new WebView(context.getApplicationContext());
                webview.setBackgroundColor(0);
                webview.loadDataWithBaseURL(null, "", "text/html", "UTF-8", null);
                android.view.WindowManager.LayoutParams layoutparams = new android.view.WindowManager.LayoutParams();
                layoutparams.width = 1;
                layoutparams.height = 1;
                layoutparams.type = 2005;
                layoutparams.flags = 0x1000018;
                layoutparams.format = -2;
                layoutparams.gravity = 0x800033;
                ((WindowManager)context.getSystemService("window")).addView(webview, layoutparams);
            }
            a = true;
        }
    }

    protected final void a(boolean flag)
    {
        if (n.a().a(n.r))
        {
            return;
        }
        if (flag)
        {
            getSettings().setPluginState(android.webkit.WebSettings.PluginState.ON);
            return;
        } else
        {
            getSettings().setPluginState(android.webkit.WebSettings.PluginState.OFF);
            return;
        }
    }

    public void destroy()
    {
        b = true;
        o.a(this);
        removeAllViews();
        super.destroy();
    }

    void setIsDestroyed(boolean flag)
    {
        b = flag;
    }

}
