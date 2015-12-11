// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.bbyobjects;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragmentContainer;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.activities.home.WebViewActivity;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.api.lib.models.search.SearchApi;
import com.bestbuy.android.base.BaseFragmentContainer;
import fr;
import gf;
import iu;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import kj;
import kr;
import lm;
import nb;
import nm;
import nn;
import no;
import nu;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

public class BBYWebView extends WebView
    implements android.webkit.GeolocationPermissions.Callback
{

    public android.webkit.GeolocationPermissions.Callback a;
    WebChromeClient b = new WebChromeClient() {

        final BBYWebView a;

        public void onCloseWindow(WebView webview)
        {
            super.onCloseWindow(webview);
            webview.goBack();
        }

        public void onGeolocationPermissionsShowPrompt(String s, android.webkit.GeolocationPermissions.Callback callback)
        {
            super.onGeolocationPermissionsShowPrompt(s, callback);
            a.a = callback;
            callback.invoke(s, true, false);
        }

        public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
        {
            (new android.app.AlertDialog.Builder(BBYWebView.a(a))).setTitle("BestBuy").setMessage(s1).setPositiveButton(0x104000a, new android.content.DialogInterface.OnClickListener(this, jsresult) {

                final JsResult a;
                final _cls1 b;

                public void onClick(DialogInterface dialoginterface, int i1)
                {
                    a.confirm();
                }

            
            {
                b = _pcls1;
                a = jsresult;
                super();
            }
            }).setCancelable(false).create().show();
            return true;
        }

        public void onProgressChanged(WebView webview, int i1)
        {
            super.onProgressChanged(webview, i1);
        }

        public void onReceivedTitle(WebView webview, String s)
        {
            super.onReceivedTitle(webview, s);
        }

            
            {
                a = BBYWebView.this;
                super();
            }
    };
    WebViewClient c = new WebViewClient() {

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

        public void onReceivedError(WebView webview, int i1, String s, String s1)
        {
            if (i1 == -6 || i1 == -2 || i1 == -7)
            {
                nm.a(BBYWebView.a(a), new no(this) {

                    final _cls2 a;

                    public void a()
                    {
                        if (BBYWebView.b(a.a) != null)
                        {
                            BBYWebView.b(a.a).setVisibility(0);
                            a.a.setVisibility(4);
                        }
                    }

            
            {
                a = _pcls2;
                super();
            }
                }, new nn(this) {

                    final _cls2 a;

                    public void a()
                    {
                        BBYWebView.a(a.a).onBackPressed();
                    }

            
            {
                a = _pcls2;
                super();
            }
                }, lm.a(BBYWebView.a(a)), 0);
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
                BBYWebView.a(a).runOnUiThread(new Runnable(this) {

                    final _cls2 a;

                    public void run()
                    {
                        (new Handler()).postDelayed(new Runnable(this) {

                            final _cls3 a;

                            public void run()
                            {
                                BBYWebView.a(a.a.a).finish();
                            }

            
            {
                a = _pcls3;
                super();
            }
                        }, 3000L);
                    }

            
            {
                a = _pcls2;
                super();
            }
                });
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
                a = BBYWebView.this;
                super();
            }
    };
    private Activity d;
    private kj e;
    private View f;
    private nu g;
    private Resources h;
    private MdotWebFragment i;
    private boolean j;
    private boolean k;
    private boolean l;
    private String m;
    private nb n;
    private boolean o;

    public BBYWebView(Activity activity, MdotWebFragment mdotwebfragment, View view)
    {
        super(activity);
        a = null;
        j = false;
        k = false;
        l = false;
        o = false;
        d = activity;
        i = mdotwebfragment;
        f = view;
        b();
    }

    public BBYWebView(Activity activity, MdotWebFragment mdotwebfragment, View view, boolean flag)
    {
        super(activity);
        a = null;
        j = false;
        k = false;
        l = false;
        o = false;
        d = activity;
        i = mdotwebfragment;
        f = view;
        l = flag;
        b();
    }

    static Activity a(BBYWebView bbywebview)
    {
        return bbywebview.d;
    }

    static void a(BBYWebView bbywebview, String s)
    {
        bbywebview.a(s);
    }

    private void a(String s)
    {
        loadUrl(s);
    }

    static boolean a(BBYWebView bbywebview, boolean flag)
    {
        bbywebview.j = flag;
        return flag;
    }

    static View b(BBYWebView bbywebview)
    {
        return bbywebview.f;
    }

    private void b()
    {
        String s = System.getProperty("http.agent");
        h = d.getResources();
        setScrollBarStyle(0);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        g = new nu(d, this, l);
        addJavascriptInterface(g, "BBYWebViewJavaScriptInterface");
        getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
        getSettings().setSupportMultipleWindows(false);
        getSettings().setGeolocationEnabled(true);
        getSettings().setUserAgentString((new StringBuilder()).append(s).append("Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; google_sdk Build/JB_MR1.1) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30").toString());
        setScrollBarStyle(0x2000000);
        setWebViewClient(c);
        setWebChromeClient(b);
        setVisibility(0);
        k = false;
        n = nb.a();
    }

    static void b(BBYWebView bbywebview, String s)
    {
        bbywebview.b(s);
    }

    private void b(String s)
    {
        (new kr(d, s)).a();
    }

    static boolean b(BBYWebView bbywebview, boolean flag)
    {
        bbywebview.k = flag;
        return flag;
    }

    static String c(BBYWebView bbywebview, String s)
    {
        bbywebview.m = s;
        return s;
    }

    static boolean c(BBYWebView bbywebview)
    {
        return bbywebview.l;
    }

    static boolean c(BBYWebView bbywebview, boolean flag)
    {
        bbywebview.o = flag;
        return flag;
    }

    static MdotWebFragment d(BBYWebView bbywebview)
    {
        return bbywebview.i;
    }

    static boolean e(BBYWebView bbywebview)
    {
        return bbywebview.k;
    }

    static boolean f(BBYWebView bbywebview)
    {
        return bbywebview.j;
    }

    static Resources g(BBYWebView bbywebview)
    {
        return bbywebview.h;
    }

    static nu h(BBYWebView bbywebview)
    {
        return bbywebview.g;
    }

    static nb i(BBYWebView bbywebview)
    {
        return bbywebview.n;
    }

    static boolean j(BBYWebView bbywebview)
    {
        return bbywebview.o;
    }

    static String k(BBYWebView bbywebview)
    {
        return bbywebview.m;
    }

    public View a()
    {
        return f;
    }

    public void a(SearchApi searchapi)
    {
        PLPFragmentContainer plpfragmentcontainer = new PLPFragmentContainer();
        searchapi = new PLPFragment(true, "PLP", null, searchapi.getSkuList(), null, 20);
        ((BaseTabContainer)i.getParentFragment()).a(plpfragmentcontainer, true);
        plpfragmentcontainer.a(searchapi, true);
    }

    public void invoke(String s, boolean flag, boolean flag1)
    {
    }

    protected void onOverScrolled(int i1, int j1, boolean flag, boolean flag1)
    {
        if (j1 == 0 && flag1)
        {
            e.a(i1, j1);
        }
        super.onOverScrolled(i1, j1, flag, flag1);
    }

    protected void onScrollChanged(int i1, int j1, int k1, int l1)
    {
        if (e != null)
        {
            e.a(i1, j1);
        }
        super.onScrollChanged(i1, j1, k1, l1);
    }

    public void setCartEmpty(boolean flag)
    {
        o = flag;
    }

    public void setHtmlContent(String s)
    {
        if (s.contains("You have no items in your shopping cart"))
        {
            g.executeErrorContent();
            return;
        }
        s = CookieManager.getInstance().getCookie(m);
        if (s != null)
        {
            int i1 = s.lastIndexOf("context_id=") + 11;
            if (i1 > 11)
            {
                s = s.substring(i1, i1 + 36);
                gf.a(d, s);
            }
        }
        if (f != null)
        {
            setVisibility(0);
            f.setVisibility(8);
        }
        CookieSyncManager.getInstance().sync();
    }

    public void setHtmlError(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (s != null && !s.equalsIgnoreCase(""))
        {
            stringbuilder.append(s);
            stringbuilder.replace(stringbuilder.indexOf("<strong>"), stringbuilder.indexOf("<strong>") + 8, "{{{");
            stringbuilder.replace(stringbuilder.indexOf("</strong>"), stringbuilder.indexOf("</strong>") + 9, "}}}");
            stringbuilder.replace(stringbuilder.indexOf("<br>"), stringbuilder.indexOf("<br>") + 4, "\n");
            stringbuilder.replace(stringbuilder.indexOf("{{{"), stringbuilder.indexOf("{{{") + 3, "<span class='bold'>");
            stringbuilder.replace(stringbuilder.indexOf("}}}"), stringbuilder.indexOf("}}}") + 3, "</span>");
        }
        s = CookieManager.getInstance().getCookie(m);
        if (s != null)
        {
            int i1 = s.lastIndexOf("context_id=") + 11;
            if (i1 > 11)
            {
                s = s.substring(i1, i1 + 36);
                gf.a(d, s);
            }
        }
        if (f != null)
        {
            setVisibility(0);
            f.setVisibility(8);
        }
        CookieSyncManager.getInstance().sync();
        i.b(stringbuilder.toString());
        (new Handler()).postDelayed(new Runnable() {

            final BBYWebView a;

            public void run()
            {
                BBYWebView.h(a).updateCartCount(BBYWebView.k(a));
            }

            
            {
                a = BBYWebView.this;
                super();
            }
        }, 4000L);
    }

    public void setOnScrollChangedCallback(kj kj1)
    {
        e = kj1;
    }
}
