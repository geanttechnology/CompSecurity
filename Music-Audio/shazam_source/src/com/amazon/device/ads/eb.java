// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;

// Referenced classes of package com.amazon.device.ads:
//            cm, co, bc, as, 
//            at, cn, bg, dt, 
//            cz

final class eb
{
    static final class a
    {

        boolean a;

        public final void a(Context context)
        {
            if (!a)
            {
                CookieSyncManager.createInstance(context);
                a = true;
            }
        }

        a()
        {
            a = false;
        }
    }

    static final class b
    {

        b()
        {
        }
    }

    static final class c
    {

        c()
        {
        }
    }


    private static eb a = new eb();
    private boolean b;
    private final cm c;
    private final co d;
    private final bc e;
    private final a f;
    private final as g;
    private final c h;
    private final b i;

    protected eb()
    {
        this(cm.a(), new co(), bc.a(), new a(), new as(), new c(), new b());
    }

    private eb(cm cm1, co co1, bc bc1, a a1, as as1, c c1, b b1)
    {
        b = false;
        c = cm1;
        d = co1;
        e = bc1;
        f = a1;
        g = as1;
        h = c1;
        i = b1;
        if (e.a("debug.webViews", Boolean.valueOf(false)).booleanValue())
        {
            at.b();
        }
    }

    public static final eb a()
    {
        return a;
    }

    public static boolean a(WebView webview, String s)
    {
        try
        {
            webview.getSettings().setJavaScriptEnabled(true);
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            co.a(s).c("Could not set JavaScriptEnabled because a NullPointerException was encountered.", null);
            return false;
        }
        return true;
    }

    public final WebView a(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        WebView webview;
        webview = new WebView(context);
        obj = c.b;
        String s = webview.getSettings().getUserAgentString();
        ((bg) (obj)).d.a(s);
        webview.getSettings().setUserAgentString(c.b.i());
        f.a(context);
        if (!f.a)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        context = c.c;
        obj = cz.a();
        context = ((Context) (obj));
        if (obj == null)
        {
            context = "";
        }
        context = (new StringBuilder("ad-id=")).append(context).append("; Domain=.amazon-adsystem.com").toString();
        CookieManager.getInstance().setCookie("http://amazon-adsystem.com", context);
        this;
        JVM INSTR monitorexit ;
        return webview;
        context;
        throw context;
    }

    public final boolean b(Context context)
    {
        if (!at.b(g, 8) || b) goto _L2; else goto _L1
_L1:
        if (WebViewDatabase.getInstance(context) != null) goto _L4; else goto _L3
_L3:
        return false;
_L4:
        context = context.openOrCreateDatabase("webviewCache.db", 0, null);
        if (context != null)
        {
            context.close();
        }
        b = true;
_L2:
        return true;
        context;
        if (at.a(g, 11))
        {
            return at.a(context);
        }
        if (context.getMessage() == null) goto _L3; else goto _L5
_L5:
        boolean flag = context.getMessage().contains("database is locked");
        return flag;
        context;
        throw context;
    }

}
