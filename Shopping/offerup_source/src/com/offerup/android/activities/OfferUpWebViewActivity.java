// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.b.a.a.g;
import com.offerup.android.network.b;
import com.offerup.android.utils.as;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.activities:
//            k, er, eq, ep, 
//            a, en, eo

public class OfferUpWebViewActivity extends k
{

    boolean a;
    boolean b;
    String c;
    private WebView d;
    private View j;
    private boolean k;
    private String l;
    private Handler m;
    private er n;
    private String o;

    public OfferUpWebViewActivity()
    {
        m = new Handler();
        n = new er(this);
    }

    static void a(OfferUpWebViewActivity offerupwebviewactivity)
    {
        offerupwebviewactivity.f();
    }

    static void a(OfferUpWebViewActivity offerupwebviewactivity, WebView webview)
    {
        webview.setLayerType(1, null);
    }

    static void a(OfferUpWebViewActivity offerupwebviewactivity, String s, JsResult jsresult)
    {
        (new android.app.AlertDialog.Builder(offerupwebviewactivity)).setNegativeButton("Cancel", new eq(offerupwebviewactivity, jsresult)).setPositiveButton("Ok", new ep(offerupwebviewactivity, jsresult)).setMessage(s).create().show();
    }

    private boolean a(WebView webview, String s)
    {
        try
        {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(s));
            startActivity(intent);
            g();
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            Log.e("OfferUpWebViewActivity", (new StringBuilder("Could not load url ")).append(s).toString());
            webview.loadUrl(s);
            return false;
        }
        return true;
    }

    static boolean a(OfferUpWebViewActivity offerupwebviewactivity, WebView webview, String s)
    {
        return offerupwebviewactivity.a(webview, s);
    }

    static void b(OfferUpWebViewActivity offerupwebviewactivity)
    {
        offerupwebviewactivity.g();
    }

    private void f()
    {
        com.b.a.a.g.a("OfferUpWebViewActivity", "Show webview progress");
        if (m != null)
        {
            m.removeCallbacks(n);
        }
        try
        {
            if (g == null || !g.isShowing())
            {
                g = ProgressDialog.show(this, "", "Loading ...");
                g.setCancelable(true);
            }
            return;
        }
        catch (Exception exception)
        {
            com.b.a.a.g.c("OfferUpWebViewActivity", Log.getStackTraceString(exception));
        }
    }

    private void g()
    {
        com.b.a.a.g.a("OfferUpWebViewActivity", "Hiding webview progress");
        try
        {
            m.postDelayed(n, 1000L);
            return;
        }
        catch (Exception exception)
        {
            com.b.a.a.g.c("OfferUpWebViewActivity", Log.getStackTraceString(exception));
        }
    }

    public int a()
    {
        return 0x7f040041;
    }

    protected void a(ActionBar actionbar)
    {
        super.a(actionbar);
        if (actionbar != null && StringUtils.isNotEmpty(l))
        {
            actionbar.setTitle(l);
            actionbar.setDisplayUseLogoEnabled(false);
            actionbar.setDisplayShowTitleEnabled(true);
        }
    }

    final String b()
    {
        if (StringUtils.isNotEmpty(o))
        {
            return o;
        } else
        {
            return "webview";
        }
    }

    public void finish()
    {
        if (k)
        {
            f.d();
        }
        super.finish();
    }

    protected final boolean j()
    {
        return false;
    }

    public void onBackPressed()
    {
        g();
        if (b && d != null && d.canGoBack())
        {
            d.goBack();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(a());
        Object obj;
        Intent intent;
        boolean flag;
        boolean flag1;
        try
        {
            c = (new URL("https://offerupnow.com/")).getHost();
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            com.b.a.a.g.a("OfferUpWebViewActivity", bundle);
        }
        j = findViewById(0x7f100151);
        d = (WebView)findViewById(0x7f100152);
        intent = getIntent();
        b = intent.getBooleanExtra("allowBrowserBack", true);
        a = intent.getBooleanExtra("hideMenuOptions", false);
        flag = intent.getBooleanExtra("whiteBackground", false);
        o = intent.getStringExtra("webviewScreenName");
        k = intent.getBooleanExtra("activity_started_externally", false);
        obj = (Uri)intent.getParcelableExtra("uri");
        bundle = ((Bundle) (obj));
        if (obj == null)
        {
            Object obj1 = intent.getData();
            bundle = ((Bundle) (obj));
            if (obj1 != null)
            {
                bundle = ((Bundle) (obj));
                if ("ouwww".equalsIgnoreCase(((Uri) (obj1)).getScheme()))
                {
                    obj1 = ((Uri) (obj1)).getSchemeSpecificPart();
                    bundle = ((Bundle) (obj));
                    if (StringUtils.isNotEmpty(((CharSequence) (obj1))))
                    {
                        bundle = as.b(((String) (obj1)));
                        b = false;
                        a = true;
                    }
                }
            }
        }
        flag1 = intent.getBooleanExtra("use_title", false);
        l = intent.getStringExtra("title");
        if (StringUtils.isNotEmpty(l) && flag1)
        {
            a(getSupportActionBar());
        }
        if (flag)
        {
            j.setBackgroundResource(0x7f0e0137);
        } else
        {
            j.setBackgroundResource(0x7f020190);
        }
        d.setWebViewClient(new en(this));
        d.setWebChromeClient(new eo(this));
        obj = d.getSettings();
        ((WebSettings) (obj)).setJavaScriptEnabled(true);
        ((WebSettings) (obj)).setDefaultTextEncodingName("utf-8");
        com.b.a.a.g.a(com/offerup/android/activities/OfferUpWebViewActivity.getSimpleName(), (new StringBuilder("Url Load ")).append(bundle).toString());
        f();
        d.loadUrl(bundle.toString(), com.offerup.android.network.b.c(getApplicationContext()));
        d.setBackgroundColor(0);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        if (a)
        {
            getMenuInflater().inflate(0x7f110014, menu);
            return true;
        } else
        {
            return super.onCreateOptionsMenu(menu);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131755393: 
            finish();
            break;
        }
        return true;
    }
}
