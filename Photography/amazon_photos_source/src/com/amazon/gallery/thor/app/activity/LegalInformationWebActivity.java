// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.amazon.gallery.foundation.utils.di.BeanAwareApplication;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.account.EndpointManager;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            AndroidSimpleToolbar, GallerySimpleToolbar, GalleryNavigationSetting

public class LegalInformationWebActivity extends Activity
{

    public LegalInformationWebActivity()
    {
    }

    private void setupActionBar(String s)
    {
        AndroidSimpleToolbar androidsimpletoolbar = new AndroidSimpleToolbar((Toolbar)findViewById(0x7f0c0086));
        androidsimpletoolbar.setTitle(getResources().getString(0x7f0e01c6));
        androidsimpletoolbar.setNavigationSetting(GalleryNavigationSetting.BACK);
        androidsimpletoolbar.setNavigationOnClickListener(new android.view.View.OnClickListener() {

            final LegalInformationWebActivity this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = LegalInformationWebActivity.this;
                super();
            }
        });
        if (s.equals("3p_license"))
        {
            androidsimpletoolbar.setTitle(getString(0x7f0e0011));
            return;
        }
        if (s.equals("cookies_and_internet_policy"))
        {
            androidsimpletoolbar.setTitle(getString(0x7f0e01ab));
            return;
        }
        if (s.equals("privacy_policy"))
        {
            androidsimpletoolbar.setTitle(getString(0x7f0e01d5));
            return;
        }
        if (s.equals("terms_of_use"))
        {
            androidsimpletoolbar.setTitle(getString(0x7f0e0206));
            return;
        } else
        {
            androidsimpletoolbar.setTitle(getString(0x7f0e01c6));
            return;
        }
    }

    public void onCreate(final Bundle progressBar)
    {
        WebView webview;
        Object obj;
        super.onCreate(progressBar);
        setContentView(0x7f0300a6);
        progressBar = (ProgressBar)findViewById(0x7f0c0140);
        webview = (WebView)findViewById(0x7f0c0182);
        webview.setWebViewClient(new WebViewClient() {

            final LegalInformationWebActivity this$0;
            final ProgressBar val$progressBar;

            public void onPageFinished(WebView webview1, String s)
            {
                if (progressBar != null && progressBar.isShown())
                {
                    progressBar.setVisibility(4);
                }
            }

            public void onPageStarted(WebView webview1, String s, Bitmap bitmap)
            {
                if (progressBar != null && !progressBar.isShown())
                {
                    progressBar.setVisibility(0);
                }
            }

            
            {
                this$0 = LegalInformationWebActivity.this;
                progressBar = progressbar;
                super();
            }
        });
        progressBar = getIntent();
        if (progressBar == null || progressBar.getAction() == null)
        {
            return;
        }
        setupActionBar(progressBar.getAction());
        obj = ((RestClient)((BeanAwareApplication)getApplication()).getBeanFactory().getBean(Keys.REST_CLIENT)).getEndpointManager().getCachedEndpoint().getHttpHostString();
        if (!progressBar.getAction().equals("3p_license")) goto _L2; else goto _L1
_L1:
        progressBar = "http://www.amazon.com/cd/3pl";
        setTitle(getString(0x7f0e0011));
_L4:
        webview.loadUrl(progressBar);
        return;
_L2:
        obj = (new android.net.Uri.Builder()).scheme("https").authority(((String) (obj)));
        if (!progressBar.getAction().equals("terms_of_use"))
        {
            break; /* Loop/switch isn't completed */
        }
        ((android.net.Uri.Builder) (obj)).appendEncodedPath("/cd/tou");
        setTitle(getString(0x7f0e0206));
_L5:
        ((android.net.Uri.Builder) (obj)).appendQueryParameter("pop-up", "1");
        progressBar = ((android.net.Uri.Builder) (obj)).toString();
        if (true) goto _L4; else goto _L3
_L3:
        if (progressBar.getAction().equals("privacy_policy"))
        {
            ((android.net.Uri.Builder) (obj)).appendEncodedPath("/privacy");
            setTitle(getString(0x7f0e01d5));
        } else
        if (progressBar.getAction().equals("cookies_and_internet_policy"))
        {
            ((android.net.Uri.Builder) (obj)).appendEncodedPath("/cd/cookies");
            setTitle(getString(0x7f0e01ab));
        } else
        {
            finish();
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }
}
