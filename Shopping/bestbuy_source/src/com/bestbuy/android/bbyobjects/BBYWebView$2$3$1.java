// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.bbyobjects;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieSyncManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.activities.home.WebViewActivity;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import fr;
import iu;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import kr;
import lm;
import nb;
import nm;
import nn;
import no;
import nu;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

// Referenced classes of package com.bestbuy.android.bbyobjects:
//            BBYWebView

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        BBYWebView.a(a.a.a).finish();
    }

    ent(ent ent)
    {
        a = ent;
        super();
    }

    // Unreferenced inner class com/bestbuy/android/bbyobjects/BBYWebView$2

/* anonymous class */
    class BBYWebView._cls2 extends WebViewClient
    {

        final BBYWebView a;

        public void onFormResubmission(WebView webview, Message message, Message message1)
        {
            message1.sendToTarget();
        }

        public void onPageFinished(WebView webview, String s)
        {
            BBYWebView.h(a).eventBusRegister();
            BBYWebView.h(a).orderEventBusRegister();
            BBYWebView.h(a).executeMainCSS();
            if (s.contains("profile/orders"))
            {
                BBYWebView.h(a).orderStatusCSS();
            }
            if (s.contains("deals.bestbuy.com/"))
            {
                BBYWebView.h(a).weeklyAdCSS();
            }
            if (BBYWebView.d(a) != null && BBYWebView.d(a).isAdded() && !BBYWebView.d(a).j())
            {
                String s1 = BBYWebView.h(a).a(".bestbuy.com", "ut");
                if (s1 != null && !s1.isEmpty())
                {
                    String s2 = BBYWebView.h(a).a("https://www-ssl.bestbuy.com/identity/status", "at");
                    if (s2 != null && !s2.isEmpty())
                    {
                        String s3 = fr.b();
                        if (s3 == null || !s3.equals(s2))
                        {
                            BBYWebView.i(a).d(true);
                            if (s3 == null)
                            {
                                BBYWebView.h(a).updateCartCount(".bestbuy.com");
                            }
                            BBYWebView.d(a).a(s1, s2);
                            BBYWebView.d(a).a(true);
                        }
                    }
                }
            }
            if (BBYWebView.j(a))
            {
                BBYWebView.h(a).updateCartCount(".bestbuy.com");
                BBYWebView.c(a, false);
            }
            super.onPageFinished(webview, s);
            if (s.endsWith("#"))
            {
                return;
            }
            if (s.startsWith(BBYWebView.a(a).getString(0x7f080238)) || s.startsWith(BBYWebView.a(a).getString(0x7f0800f6)) || s.startsWith(BBYWebView.a(a).getString(0x7f0801e6)) || s.equals(BBYWebView.a(a).getString(0x7f0801da)) || s.equals(BBYWebView.a(a).getString(0x7f08037e)))
            {
                a.getSettings().setLoadWithOverviewMode(true);
                a.getSettings().setUseWideViewPort(true);
                a.getSettings().setBuiltInZoomControls(true);
                a.getSettings().setSupportZoom(true);
            }
            if (s.equals(BBYWebView.a(a).getString(0x7f08030d)))
            {
                a.getSettings().setLoadWithOverviewMode(true);
                a.getSettings().setUseWideViewPort(true);
                a.getSettings().setBuiltInZoomControls(true);
                a.getSettings().setSupportZoom(true);
            }
            BBYWebView.c(a, s);
            CookieSyncManager.getInstance().sync();
            BBYWebView.h(a).executeHtmlContent();
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            super.onPageStarted(webview, s, bitmap);
            if (BBYWebView.b(a) != null)
            {
                BBYWebView.b(a).setVisibility(0);
                a.setVisibility(4);
                BBYWebView.d(a).k().setVisibility(8);
            }
            bitmap = (InputMethodManager)BBYWebView.a(a).getSystemService("input_method");
            if (BBYWebView.a(a).getCurrentFocus() != null && BBYWebView.a(a).getCurrentFocus().getWindowToken() != null)
            {
                bitmap.hideSoftInputFromWindow(BBYWebView.a(a).getCurrentFocus().getWindowToken(), 0);
            }
            if (s.contains(BBYWebView.a(a).getString(0x7f08016c)) || s.contains(BBYWebView.a(a).getString(0x7f08012d)) || s.contains(BBYWebView.a(a).getString(0x7f080288)) && !s.contains("fastTrack=true") && !s.contains("visaCheckout=true") || s.contains(BBYWebView.a(a).getString(0x7f080179)) || s.contains(BBYWebView.a(a).getString(0x7f0800b7)) || s.contains(BBYWebView.a(a).getString(0x7f08035e)) || s.contains(BBYWebView.a(a).getString(0x7f080295)) || s.contains(BBYWebView.a(a).getString(0x7f080316)) || s.contains(BBYWebView.a(a).getString(0x7f080202)) || s.contains(BBYWebView.a(a).getString(0x7f080319)) || s.contains(BBYWebView.a(a).getString(0x7f0801b9)) || s.contains(BBYWebView.a(a).getString(0x7f080355)) || s.contains(BBYWebView.a(a).getString(0x7f080257)))
            {
                webview.getSettings().setLoadWithOverviewMode(true);
                webview.getSettings().setUseWideViewPort(true);
                webview.getSettings().setBuiltInZoomControls(true);
                webview.getSettings().setSupportZoom(true);
                webview.setInitialScale(50);
            }
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            if (i == -6 || i == -2 || i == -7)
            {
                nm.a(BBYWebView.a(a), new BBYWebView._cls2._cls1(), new BBYWebView._cls2._cls2(), lm.a(BBYWebView.a(a)), 0);
            }
        }

        public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
        {
            sslerrorhandler.proceed();
        }

        public WebResourceResponse shouldInterceptRequest(WebView webview, String s)
        {
            if (s.contains("https://secure.opinionlab.com/rate40.asp") && (BBYWebView.a(a) instanceof WebViewActivity))
            {
                BBYWebView.a(a).runOnUiThread(new BBYWebView._cls2._cls3(this));
            }
            return super.shouldInterceptRequest(webview, s);
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            if (s.startsWith("https://adclick.g.doubleclick.net"))
            {
                return false;
            }
            BBYWebView.a(a, false);
            BBYWebView.b(a, false);
            if (s.contains(".pdf"))
            {
                (new kr(BBYWebView.a(a), s)).b();
                return true;
            }
            if (s.equals(BBYWebView.a(a).getString(0x7f080244)))
            {
                BBYWebView.a(a, true);
            }
            if (s.contains(BBYWebView.a(a).getString(0x7f080289)))
            {
                BBYWebView.b(a, true);
            }
            if (s.startsWith("tel:"))
            {
                webview.stopLoading();
                webview = new Intent();
                webview.setAction("android.intent.action.CALL");
                webview.setData(Uri.parse(s));
                BBYWebView.a(a).startActivity(webview);
                return true;
            }
            if ((s.startsWith(BBYWebView.a(a).getString(0x7f0802f3)) || s.startsWith(BBYWebView.a(a).getString(0x7f0800ef)) || s.startsWith(BBYWebView.a(a).getString(0x7f0802f2))) && (s.contains("Current+Offers") || s.contains("All+Categories")))
            {
                webview = "";
                if (s.startsWith(BBYWebView.a(a).getString(0x7f0802f3)))
                {
                    webview = s.substring(s.indexOf("st=") + 3, s.indexOf("_mpromo"));
                } else
                if (s.startsWith(BBYWebView.a(a).getString(0x7f0800ef)) || s.startsWith(BBYWebView.a(a).getString(0x7f0801c9)) || s.startsWith(BBYWebView.a(a).getString(0x7f0802f2)))
                {
                    (new StringBuilder()).append(s).append("&appvi=").append(nb.a().r()).toString();
                    return false;
                }
                if (BBYWebView.c(a))
                {
                    (new iu(BBYWebView.a(a), BBYWebView.d(a), webview, BBYWebView.b(a), a)).executeOnExecutor(nb.h, new Void[0]);
                    return true;
                }
                if (!s.startsWith("file:///android_asset/"))
                {
                    (new StringBuilder()).append(s).append("&appvi=").append(nb.a().r()).toString();
                }
                return false;
            }
            if (s.startsWith("mailto:"))
            {
                webview = new Intent("android.intent.action.VIEW", Uri.parse(s));
                BBYWebView.a(a).startActivity(webview);
                return true;
            }
            if (s.startsWith("market://"))
            {
                webview = new Intent("android.intent.action.VIEW", Uri.parse(s));
                BBYWebView.a(a).startActivity(webview);
                return true;
            }
            if (s.contains("youtube.com") && s.contains("watch?"))
            {
                webview = s.substring(s.indexOf("v=") + 2, s.indexOf("v=") + 13);
                webview = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("vnd.youtube:").append(webview).toString()));
                BBYWebView.a(a).startActivity(webview);
                BBYWebView.a(a).finish();
                return true;
            }
            if (s.startsWith("geo:"))
            {
                webview = new Intent("android.intent.action.VIEW", Uri.parse(s));
                BBYWebView.a(a).startActivity(webview);
                return true;
            }
            if (s.startsWith("http://wiki.github.com"))
            {
                webview = new Intent("android.intent.action.VIEW", Uri.parse(s));
                BBYWebView.a(a).startActivity(webview);
                return true;
            }
            if (s.contains(".jsp"));
            if (s.contains("index.jsp"))
            {
                webview.stopLoading();
                return true;
            }
            if (s.contains("browse.jsp?refreshSearch=true&id"))
            {
                BBYWebView.a(a, s.replace("browse.jsp?refreshSearch=true&id", "browse.jsp?refreshSearch=true&catid"));
                return true;
            }
            if (!s.contains(BBYWebView.a(a).getString(0x7f08021d)) && !s.contains(BBYWebView.a(a).getString(0x7f080176)) && (!s.contains(BBYWebView.a(a).getString(0x7f080175)) && !s.contains(".p?") || !s.contains("skuId") || s.contains("olstemplatemapper.jsp"))) goto _L2; else goto _L1
_L1:
            webview = URLEncodedUtils.parse(URI.create(s), "UTF-8");
            if (s.contains("olspage.jsp") && s.contains("listflag=true&pageMode=searchmode"))
            {
                return false;
            }
            if (!BBYWebView.e(a)) goto _L4; else goto _L3
_L3:
            BBYWebView.b(a, false);
            ((BaseTabContainer)BBYWebView.d(a).getParentFragment()).a_();
_L5:
            return true;
_L4:
            if (s.contains("dnmId") && s.contains("dt"))
            {
                return false;
            }
            webview = webview.iterator();
            do
            {
                if (!webview.hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
                s = (NameValuePair)webview.next();
            } while (!s.getName().equals("skuId"));
            webview = s.getValue();
            ((HomeActivity)BBYWebView.a(a)).openPDP(webview, "", true);
            if (true) goto _L5; else goto _L2
_L2:
            if (s.equals(BBYWebView.a(a).getString(0x7f080286)))
            {
                BBYWebView.d(a).a(webview);
                webview.reload();
                return true;
            }
            if (s.contains(BBYWebView.a(a).getString(0x7f080123)))
            {
                BBYWebView.b(a, s);
                return true;
            }
            if (s.contains(BBYWebView.a(a).getString(0x7f08021b)))
            {
                ((HomeActivity)BBYWebView.a(a)).popCurrentFragment();
                return true;
            }
            if (s.contains(BBYWebView.a(a).getString(0x7f08022e)) && !s.contains(BBYWebView.a(a).getString(0x7f0802a3)) && !s.contains(BBYWebView.a(a).getString(0x7f0802a4)))
            {
                if (BBYWebView.f(a))
                {
                    BBYWebView.a(a, false);
                    a.goBack();
                    return true;
                }
                webview = ((HomeActivity)BBYWebView.a(a)).getSupportFragmentManager().findFragmentById(0x7f0c0033);
                if (webview instanceof HomeTabFragment)
                {
                    ((HomeTabFragment)webview).a(0);
                } else
                {
                    ((HomeActivity)BBYWebView.a(a)).popCurrentFragment();
                }
                return true;
            }
            if (s.contains(BBYWebView.g(a).getString(0x7f08001d)) && !s.contains("_requestid="))
            {
                webview.reload();
                return true;
            }
            if (!s.startsWith("file:///android_asset/") && !s.contains("appvi="))
            {
                if (s.contains("?"))
                {
                    (new StringBuilder()).append(s).append("&appvi=").append(nb.a().r()).toString();
                } else
                {
                    (new StringBuilder()).append(s).append("?appvi=").append(nb.a().r()).toString();
                }
            }
            return false;
        }

            
            {
                a = bbywebview;
                super();
            }

        // Unreferenced inner class com/bestbuy/android/bbyobjects/BBYWebView$2$1

/* anonymous class */
        class BBYWebView._cls2._cls1
            implements no
        {

            final BBYWebView._cls2 a;

            public void a()
            {
                if (BBYWebView.b(a.a) != null)
                {
                    BBYWebView.b(a.a).setVisibility(0);
                    a.a.setVisibility(4);
                }
            }

                    
                    {
                        a = BBYWebView._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/bestbuy/android/bbyobjects/BBYWebView$2$2

/* anonymous class */
        class BBYWebView._cls2._cls2
            implements nn
        {

            final BBYWebView._cls2 a;

            public void a()
            {
                BBYWebView.a(a.a).onBackPressed();
            }

                    
                    {
                        a = BBYWebView._cls2.this;
                        super();
                    }
        }

    }


    // Unreferenced inner class com/bestbuy/android/bbyobjects/BBYWebView$2$3

/* anonymous class */
    class BBYWebView._cls2._cls3
        implements Runnable
    {

        final BBYWebView._cls2 a;

        public void run()
        {
            (new Handler()).postDelayed(new BBYWebView._cls2._cls3._cls1(this), 3000L);
        }

            
            {
                a = _pcls2;
                super();
            }
    }

}
