// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.mybby;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import cm;
import com.bestbuy.android.api.lib.models.registry.Entity;
import com.bestbuy.android.api.lib.models.registry.LoggedInUserProfile;
import com.bestbuy.android.base.BBYBaseFragment;
import fr;
import gw;
import io;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import lu;
import nb;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;

public class CIALoginFragment extends BBYBaseFragment
{

    public static boolean a = false;
    WebViewClient b;
    WebChromeClient c;
    private View g;
    private cm h;
    private String i;
    private ImageView j;
    private String k;
    private String l;
    private CookieManager m;
    private WebView n;

    public CIALoginFragment()
    {
        b = new WebViewClient() {

            final CIALoginFragment a;

            public void onFormResubmission(WebView webview, Message message, Message message1)
            {
                message1.sendToTarget();
            }

            public void onPageFinished(WebView webview, String s)
            {
                if (a.isAdded() && s.contains("bestbuy.com/cart"))
                {
                    CIALoginFragment.b(a).updateCartCount(s);
                }
                if (a.isAdded() && s.contains(a.getString(0x7f08012d)))
                {
                    CIALoginFragment.b(a).executeMainCSS();
                }
                if (a.isAdded() && s.contains("tokenInfo?authenticationDataToken="))
                {
                    webview.loadUrl("javascript:window.CIAJavaScriptInterface.showHTML('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
                    return;
                }
                if (a.isAdded() && s.contains("bestbuy.com/cart"))
                {
                    CIALoginFragment.a(a).setVisibility(0);
                    return;
                } else
                {
                    CIALoginFragment.a(a).setVisibility(8);
                    return;
                }
            }

            public void onPageStarted(WebView webview, String s, Bitmap bitmap)
            {
                CIALoginFragment.a(a).setVisibility(0);
                if (s.equals("http://www.bestbuy.com/"))
                {
                    if (!a.f.F())
                    {
                        CIALoginFragment.a(a, CIALoginFragment.b(a).a(".bestbuy.com", "ut"));
                        if (CIALoginFragment.c(a) != null && !CIALoginFragment.c(a).isEmpty())
                        {
                            CIALoginFragment.b(a, CIALoginFragment.b(a).a("https://www-ssl.bestbuy.com", "at"));
                        }
                    }
                    if (CIALoginFragment.d(a) != null && !CIALoginFragment.d(a).isEmpty())
                    {
                        a.f.d(true);
                        (new io(a.d, a, CIALoginFragment.a(a), CIALoginFragment.c(a), CIALoginFragment.d(a))).executeOnExecutor(nb.h, new Void[0]);
                    }
                }
                if (s.contains(a.d.getString(0x7f08016c)) || s.contains(a.d.getString(0x7f080288)) || s.contains(a.d.getString(0x7f08012d)) || s.contains(a.d.getString(0x7f080179)) || s.contains(a.d.getString(0x7f0800b7)) || s.contains(a.d.getString(0x7f08035e)) || s.contains(a.d.getString(0x7f080295)) || s.contains(a.d.getString(0x7f080316)) || s.contains(a.d.getString(0x7f080202)) || s.contains(a.d.getString(0x7f080319)) || s.contains(a.d.getString(0x7f0801b9)) || s.contains(a.d.getString(0x7f080355)) || s.contains(a.d.getString(0x7f080257)))
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
                    CIALoginFragment.a(a).setVisibility(8);
                }
            }

            public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
            {
                sslerrorhandler.proceed();
            }

            
            {
                a = CIALoginFragment.this;
                super();
            }
        };
        c = new WebChromeClient() {

            final CIALoginFragment a;

            public void onCloseWindow(WebView webview)
            {
                super.onCloseWindow(webview);
                webview.goBack();
            }

            public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
            {
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
                a = CIALoginFragment.this;
                super();
            }
        };
    }

    public static View a(CIALoginFragment cialoginfragment)
    {
        return cialoginfragment.g;
    }

    static String a(CIALoginFragment cialoginfragment, String s)
    {
        cialoginfragment.k = s;
        return s;
    }

    static cm b(CIALoginFragment cialoginfragment)
    {
        return cialoginfragment.h;
    }

    static String b(CIALoginFragment cialoginfragment, String s)
    {
        cialoginfragment.l = s;
        return s;
    }

    static String c(CIALoginFragment cialoginfragment)
    {
        return cialoginfragment.k;
    }

    static String d(CIALoginFragment cialoginfragment)
    {
        return cialoginfragment.l;
    }

    public static WebView e(CIALoginFragment cialoginfragment)
    {
        return cialoginfragment.n;
    }

    public void a(LoggedInUserProfile loggedinuserprofile)
    {
        if (loggedinuserprofile == null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        i = loggedinuserprofile.getRefreshToken();
        String s = ((Entity)loggedinuserprofile.getEntities().get(0)).getUsername();
        f.d(s);
        if (!i.equalsIgnoreCase(getString(0x7f080068)) && i.length() > 0)
        {
            g.setVisibility(0);
            HashMap hashmap = new HashMap();
            hashmap.put("bb.rzTier", ((Entity)loggedinuserprofile.getEntities().get(0)).getRzTierStatus());
            lu.b(lu.c, hashmap);
            loggedinuserprofile = f.g();
            a(((String) (loggedinuserprofile)));
            n.loadUrl(loggedinuserprofile);
            a = true;
        }
        return;
        loggedinuserprofile;
        loggedinuserprofile.printStackTrace();
        return;
    }

    public void a(String s)
    {
        CookieSyncManager cookiesyncmanager;
        CookieManager cookiemanager;
        Object obj;
        Cookie cookie;
        String s1;
        try
        {
            CookieSyncManager.createInstance(d);
            cookiesyncmanager = CookieSyncManager.getInstance();
            obj = gw.a().getCookieStore().getCookies();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        if (!((List) (obj)).isEmpty())
        {
            cookiemanager = CookieManager.getInstance();
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); cookiesyncmanager.sync())
            {
                cookie = (Cookie)((Iterator) (obj)).next();
                s1 = (new StringBuilder()).append(cookie.getName()).append("=").append(cookie.getValue()).append("; Domain=").append(cookie.getDomain()).toString();
                if (!cookie.getName().equals("bby_rdp"))
                {
                    cookiemanager.setCookie(s, s1);
                }
            }

        }
        m.setCookie(s, f.L());
        m.setCookie(s, f.M());
        m.setCookie(s, f.N());
        m.setCookie(s, f.O());
        if (fr.d() != null)
        {
            m.setCookie(s, f.J());
            m.setCookie(s, f.K());
        }
        cookiesyncmanager.sync();
        return;
    }

    public boolean b()
    {
        return n.canGoBack();
    }

    public void c()
    {
        n.goBack();
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        d.getActionBar().hide();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030021, viewgroup, false);
        g = layoutinflater.findViewById(0x7f0c0064);
        n = (WebView)layoutinflater.findViewById(0x7f0c00a2);
        h = new cm(this, d);
        n.addJavascriptInterface(h, "CIAJavaScriptInterface");
        n.getSettings().setJavaScriptEnabled(true);
        n.getSettings().setLoadWithOverviewMode(true);
        n.getSettings().setUseWideViewPort(false);
        n.setWebViewClient(b);
        n.setWebChromeClient(c);
        m = CookieManager.getInstance();
        m.setAcceptCookie(true);
        CookieManager.setAcceptFileSchemeCookies(true);
        g.setVisibility(0);
        n.loadUrl(f.h());
        j = (ImageView)layoutinflater.findViewById(0x7f0c00a1);
        j.setOnClickListener(new android.view.View.OnClickListener() {

            final CIALoginFragment a;

            public void onClick(View view)
            {
                a.getActivity().finish();
                a.getActivity().overridePendingTransition(0x7f040005, 0x7f040008);
            }

            
            {
                a = CIALoginFragment.this;
                super();
            }
        });
        return layoutinflater;
    }

    public void onResume()
    {
        super.onResume();
    }

}
