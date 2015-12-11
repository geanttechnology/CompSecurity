// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.aqo;
import android.support.v7.ic;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import butterknife.ButterKnife;
import com.abtnprojects.ambatana.models.CountryLanguage;
import com.abtnprojects.ambatana.models.CountryLanguageEntity;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            b

public class HelpActivity extends b
{

    private CountryLanguageEntity n;
    ProgressBar progressBar;
    protected WebView webView;

    public HelpActivity()
    {
    }

    private String a(CountryLanguage countrylanguage)
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("http://");
        stringbuffer.append(countrylanguage.country);
        stringbuffer.append(".letgo.com/");
        stringbuffer.append(countrylanguage.language);
        stringbuffer.append("/help_app");
        return stringbuffer.toString();
    }

    protected void a(Bundle bundle, boolean flag)
    {
        if (!flag)
        {
            a(0x7f0200d1);
            ButterKnife.bind(this);
            progressBar.setVisibility(0);
            n = new CountryLanguageEntity(this);
            bundle = a(n.acquireCountryLanguage());
            aqo.a("url %s", new Object[] {
                bundle
            });
            webView.setWebViewClient(new WebViewClient() {

                final HelpActivity a;

                public void onPageFinished(WebView webview, String s)
                {
                    a.progressBar.setVisibility(8);
                }

                public void onPageStarted(WebView webview, String s, Bitmap bitmap)
                {
                    a.progressBar.setVisibility(0);
                }

            
            {
                a = HelpActivity.this;
                super();
            }
            });
            webView.loadUrl(bundle);
            webView.getSettings().setJavaScriptEnabled(true);
        }
    }

    protected void k()
    {
        setContentView(0x7f04001d);
    }

    protected boolean m()
    {
        return false;
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f110001, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x7f10016b)
        {
            x.b();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }
}
