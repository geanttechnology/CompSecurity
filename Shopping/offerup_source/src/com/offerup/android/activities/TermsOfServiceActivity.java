// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import com.b.a.a.g;
import com.offerup.android.network.ToSService;
import com.offerup.android.network.b;
import com.offerup.android.network.o;
import java.util.concurrent.Executors;

// Referenced classes of package com.offerup.android.activities:
//            hv, ht, hu

public class TermsOfServiceActivity extends AppCompatActivity
{

    private WebView a;
    private ProgressDialog b;

    public TermsOfServiceActivity()
    {
    }

    private void a()
    {
        try
        {
            if (b != null && b.isShowing())
            {
                b.dismiss();
            }
            return;
        }
        catch (Exception exception)
        {
            g.a(this, exception);
        }
    }

    static void a(TermsOfServiceActivity termsofserviceactivity)
    {
        termsofserviceactivity.b();
        o.c(o.c(Executors.newCachedThreadPool())).acceptTermsOfService(new hv(termsofserviceactivity, (byte)0));
    }

    private void b()
    {
        try
        {
            a();
            b = ProgressDialog.show(this, "", "Loading ...");
            b.setCancelable(false);
            return;
        }
        catch (Exception exception)
        {
            g.c(com/offerup/android/activities/TermsOfServiceActivity.getSimpleName(), Log.getStackTraceString(exception));
        }
    }

    static void b(TermsOfServiceActivity termsofserviceactivity)
    {
        termsofserviceactivity.a();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f04003d);
        bundle = (Button)findViewById(0x7f100144);
        a = (WebView)findViewById(0x7f100143);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setLogo(0x7f02001a);
        actionbar.setDisplayUseLogoEnabled(true);
        actionbar.setDisplayShowHomeEnabled(true);
        actionbar.setDisplayShowTitleEnabled(false);
        bundle.setOnClickListener(new ht(this));
        bundle = new hu(this, this);
        a.setWebViewClient(bundle);
        a.setWebChromeClient(new WebChromeClient());
        bundle = a.getSettings();
        bundle.setJavaScriptEnabled(true);
        bundle.setDefaultTextEncodingName("utf-8");
        bundle = (new StringBuilder("https://offerupnow.com/")).append("terms-of-service/?flavour=app").toString();
        g.a(com/offerup/android/activities/TermsOfServiceActivity.getSimpleName(), (new StringBuilder("Url Load ")).append(bundle).toString());
        b();
        a.loadUrl(bundle, com.offerup.android.network.b.c(getApplicationContext()));
        a.setBackgroundColor(0);
    }
}
