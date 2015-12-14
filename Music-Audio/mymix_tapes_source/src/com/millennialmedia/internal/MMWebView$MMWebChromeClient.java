// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;
import com.millennialmedia.internal.utils.EnvironmentUtils;

// Referenced classes of package com.millennialmedia.internal:
//            MMWebView

class this._cls0 extends WebChromeClient
{

    final MMWebView this$0;

    public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
    {
        if (webview.getContext() != EnvironmentUtils.getApplicationContext())
        {
            return super.onJsAlert(webview, s, s1, jsresult);
        } else
        {
            Toast.makeText(webview.getContext(), s1, 0).show();
            jsresult.confirm();
            return true;
        }
    }

    public boolean onJsBeforeUnload(WebView webview, String s, String s1, JsResult jsresult)
    {
        if (webview.getContext() != EnvironmentUtils.getApplicationContext())
        {
            return super.onJsBeforeUnload(webview, s, s1, jsresult);
        } else
        {
            Toast.makeText(webview.getContext(), s1, 0).show();
            jsresult.confirm();
            return true;
        }
    }

    public boolean onJsConfirm(WebView webview, String s, String s1, JsResult jsresult)
    {
        if (webview.getContext() != EnvironmentUtils.getApplicationContext())
        {
            return super.onJsConfirm(webview, s, s1, jsresult);
        } else
        {
            Toast.makeText(webview.getContext(), s1, 0).show();
            jsresult.confirm();
            return true;
        }
    }

    public boolean onJsPrompt(WebView webview, String s, String s1, String s2, JsPromptResult jspromptresult)
    {
        if (webview.getContext() != EnvironmentUtils.getApplicationContext())
        {
            return super.onJsPrompt(webview, s, s1, s2, jspromptresult);
        } else
        {
            Toast.makeText(webview.getContext(), s1, 0).show();
            jspromptresult.confirm(s2);
            return true;
        }
    }

    ()
    {
        this$0 = MMWebView.this;
        super();
    }
}
