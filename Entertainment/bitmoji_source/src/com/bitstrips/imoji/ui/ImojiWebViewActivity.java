// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.content.Intent;
import android.net.MailTo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bitstrips.imoji.InjectorApplication;
import com.bitstrips.imoji.auth.FacebookService;
import java.util.Locale;

public class ImojiWebViewActivity extends AppCompatActivity
{

    private static final String TAG = "ImojiWebViewActivity";
    FacebookService facebookService;
    private Toolbar toolbar;
    WebView webView;

    public ImojiWebViewActivity()
    {
    }

    private void workAroundInconsistentWebViewLoad(final Intent intent)
    {
        (new Handler()).postDelayed(new Runnable() {

            final ImojiWebViewActivity this$0;
            final Intent val$intent;

            public void run()
            {
                webView.loadUrl(intent.getData().toString());
            }

            
            {
                this$0 = ImojiWebViewActivity.this;
                intent = intent1;
                super();
            }
        }, 0L);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ((InjectorApplication)getApplication()).inject(this);
        setContentView(0x7f03003f);
        bundle = getIntent();
        toolbar = (Toolbar)findViewById(0x7f0b0074);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(bundle.getStringExtra("android.intent.extra.TITLE"));
        if (bundle.getData() == null)
        {
            throw new NullPointerException("Data URI must be provided");
        } else
        {
            webView = (WebView)findViewById(0x7f0b00ab);
            webView.setWebViewClient(new WebViewClient() {

                final ImojiWebViewActivity this$0;

                private Intent createEmailIntent(MailTo mailto)
                {
                    Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", mailto.getTo(), null));
                    intent.putExtra("android.intent.extra.SUBJECT", mailto.getSubject());
                    intent.putExtra("android.intent.extra.TEXT", String.format(Locale.US, "Device: %s %s %s\nOS: %d\nImoji Android v%s\n\n%s:\n", new Object[] {
                        Build.MANUFACTURER, Build.MODEL, Build.PRODUCT, Integer.valueOf(android.os.Build.VERSION.SDK_INT), "2.1.390", getString(0x7f060064)
                    }));
                    return intent;
                }

                public boolean shouldOverrideUrlLoading(WebView webview, String s)
                {
                    if (MailTo.isMailTo(s))
                    {
                        webview = createEmailIntent(MailTo.parse(s));
                        startActivity(webview);
                        return true;
                    } else
                    {
                        return super.shouldOverrideUrlLoading(webview, s);
                    }
                }

            
            {
                this$0 = ImojiWebViewActivity.this;
                super();
            }
            });
            workAroundInconsistentWebViewLoad(bundle);
            return;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            finish();
            break;
        }
        return true;
    }

    protected void onPause()
    {
        super.onPause();
        facebookService.logDeactivate(this);
    }

    public void onResume()
    {
        super.onResume();
        facebookService.logActivate(this);
    }
}
