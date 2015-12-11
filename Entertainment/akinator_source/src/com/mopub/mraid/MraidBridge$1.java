// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mraid;

import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.mopub.mraid:
//            MraidBridge

class  extends WebChromeClient
{

    final MraidBridge this$0;

    public boolean onConsoleMessage(ConsoleMessage consolemessage)
    {
        if (MraidBridge.access$000(MraidBridge.this) != null)
        {
            return MraidBridge.access$000(MraidBridge.this).onConsoleMessage(consolemessage);
        } else
        {
            return super.onConsoleMessage(consolemessage);
        }
    }

    public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
    {
        if (MraidBridge.access$000(MraidBridge.this) != null)
        {
            return MraidBridge.access$000(MraidBridge.this).onJsAlert(s1, jsresult);
        } else
        {
            return super.onJsAlert(webview, s, s1, jsresult);
        }
    }

    public void onShowCustomView(View view, android.webkit.t.CustomViewCallback customviewcallback)
    {
        super.onShowCustomView(view, customviewcallback);
    }

    .CustomViewCallback()
    {
        this$0 = MraidBridge.this;
        super();
    }
}
