// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.webkit.WebView;
import com.groupon.util.CustomerServiceWebViewHelper;
import com.groupon.util.WebViewHelper;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            BaseWebViewActivity

public class CustomerService extends BaseWebViewActivity
{

    public CustomerService()
    {
    }

    public WebViewHelper createHelper()
    {
        return new CustomerServiceWebViewHelper(this);
    }

    protected void navigationFinished(String s)
    {
        super.navigationFinished(s);
        if (Strings.notEmpty(webView.getTitle()) && webView.getTitle().contains("504"))
        {
            webView.loadUrl("about:blank");
            showRetryDialog();
        }
    }
}
