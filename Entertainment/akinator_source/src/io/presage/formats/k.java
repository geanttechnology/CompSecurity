// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.formats;

import android.content.Context;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import io.presage.Presage;
import io.presage.utils.e;
import io.presage.utils.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package io.presage.formats:
//            h, b

final class k
    implements Runnable
{

    final h a;
    final h b;

    k(h h1, h h2)
    {
        b = h1;
        a = h2;
        super();
    }

    public final void run()
    {
        if (b.g() != null && b.e() != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        Object obj1;
        for (Iterator iterator = ((ArrayList)b.a("zones")).iterator(); iterator.hasNext(); b.e().add(new b(((android.view.WindowManager.LayoutParams) (obj)), ((android.view.View) (obj1)))))
        {
            obj1 = (Map)iterator.next();
            WebView webview = new WebView(b.h().getApplicationContext());
            CookieSyncManager.createInstance(b.h());
            CookieManager.getInstance().removeAllCookie();
            webview.clearHistory();
            webview.clearCache(true);
            webview.clearAnimation();
            webview.resumeTimers();
            webview.getSettings().setJavaScriptEnabled(true);
            obj = b;
            ((Map) (obj1)).get("name");
            Object obj2 = a;
            b.g();
            webview.setWebViewClient(new h.a(((h) (obj))));
            webview.setWebChromeClient(new h.b(b, (String)((Map) (obj1)).get("name"), a, b.g()));
            webview.addJavascriptInterface(new h.c(b, (String)((Map) (obj1)).get("name"), webview, a, b.g()), "Presage");
            webview.setBackgroundColor(0);
            webview.setTag("webview");
            webview.setVerticalScrollBarEnabled(false);
            webview.setHorizontalScrollBarEnabled(false);
            e.b(new String[] {
                "Webviews", "[", ((Map) (obj1)).get("name").toString(), "] load url:", ((Map) (obj1)).get("url").toString()
            });
            webview.loadUrl((String)((Map) (obj1)).get("url"));
            obj = new android.view.WindowManager.LayoutParams();
            obj.width = -1;
            obj.height = -1;
            obj.x = 0;
            obj.y = 0;
            obj.gravity = 51;
            obj.type = 2003;
            obj.format = -3;
            obj.flags = 0x40028;
            ((android.view.WindowManager.LayoutParams) (obj)).setTitle("Load Average");
            obj2 = (Map)((Map) (obj1)).get("size");
            if (obj2 != null)
            {
                Double double1 = (Double)((Map) (obj2)).get("width");
                if (double1 != null && double1.doubleValue() > 0.0D)
                {
                    obj.width = m.a((int)Math.round(double1.doubleValue()));
                }
                obj2 = (Double)((Map) (obj2)).get("height");
                if (obj2 != null && ((Double) (obj2)).doubleValue() > 0.0D)
                {
                    obj.height = m.a((int)Math.round(((Double) (obj2)).doubleValue()));
                }
            }
            obj2 = (Map)((Map) (obj1)).get("position");
            if (obj2 != null)
            {
                Double double2 = (Double)((Map) (obj2)).get("x");
                if (double2 != null && double2.doubleValue() > 0.0D)
                {
                    obj.x = m.a((int)Math.round(double2.doubleValue()));
                }
                obj2 = (Double)((Map) (obj2)).get("y");
                if (obj2 != null && ((Double) (obj2)).doubleValue() > 0.0D)
                {
                    obj.y = m.a((int)Math.round(((Double) (obj2)).doubleValue()));
                }
            }
            obj1 = (ArrayList)((Map) (obj1)).get("gravity");
            if (obj1 != null)
            {
                obj.gravity = 0;
                obj1 = ((ArrayList) (obj1)).iterator();
                do
                {
                    if (!((Iterator) (obj1)).hasNext())
                    {
                        break;
                    }
                    obj2 = (String)((Iterator) (obj1)).next();
                    if (((String) (obj2)).equals("top"))
                    {
                        obj.gravity = ((android.view.WindowManager.LayoutParams) (obj)).gravity | 0x30;
                    } else
                    if (((String) (obj2)).equals("left"))
                    {
                        obj.gravity = ((android.view.WindowManager.LayoutParams) (obj)).gravity | 3;
                    } else
                    if (((String) (obj2)).equals("bottom"))
                    {
                        obj.gravity = ((android.view.WindowManager.LayoutParams) (obj)).gravity | 0x50;
                    } else
                    if (((String) (obj2)).equals("right"))
                    {
                        obj.gravity = ((android.view.WindowManager.LayoutParams) (obj)).gravity | 5;
                    }
                } while (true);
            }
            obj1 = new RelativeLayout(Presage.getInstance().getContext());
            obj2 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            obj2.bottomMargin = 0;
            obj2.leftMargin = 0;
            obj2.rightMargin = 0;
            obj2.topMargin = 0;
            ((ViewGroup) (obj1)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
            ((ViewGroup) (obj1)).addView(webview, 0, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        }

        WindowManager windowmanager = (WindowManager)b.h().getSystemService("window");
        if (b.e() != null)
        {
            Iterator iterator1 = b.e().iterator();
            while (iterator1.hasNext()) 
            {
                b b1 = (b)iterator1.next();
                windowmanager.addView(b1.b(), b1.a());
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }
}
