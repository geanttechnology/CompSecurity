// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.groupon.util.DialogManager;
import com.groupon.util.GrouponDialogFragment;

// Referenced classes of package com.groupon.activity:
//            OktaAuthentication, IntentFactory

private class <init> extends WebViewClient
{

    final OktaAuthentication this$0;

    private void showErrorDialog()
    {
        GrouponDialogFragment.show(getFragmentManager(), OktaAuthentication.access$200(OktaAuthentication.this).getDialogFragment(Integer.valueOf(0x7f080165)), "http_error_dialog");
    }

    public void onPageFinished(WebView webview, String s)
    {
        if (s.startsWith("https://groupon.okta.com/app/UserHome"))
        {
            startActivity(OktaAuthentication.access$100(OktaAuthentication.this).newSecretAdminSettingsIntent());
            finish();
        }
        super.onPageFinished(webview, s);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        webView.loadUrl("about:blank");
        showErrorDialog();
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        return super.shouldOverrideUrlLoading(webview, s);
    }

    private ()
    {
        this$0 = OktaAuthentication.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
