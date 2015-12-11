// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247;

import android.webkit.ValueCallback;
import android.webkit.WebView;

// Referenced classes of package com.inc247:
//            ChatSDKWebChromeClient, ChatSDKWebView

class lient extends ChatSDKWebChromeClient
{

    final ChatSDKWebView this$0;

    public boolean onShowFileChooser(WebView webview, ValueCallback valuecallback, android.webkit.ileChooserParams ilechooserparams)
    {
        openFileInput(null, valuecallback);
        return true;
    }

    public void openFileChooser(ValueCallback valuecallback)
    {
        openFileChooser(valuecallback, null);
    }

    public void openFileChooser(ValueCallback valuecallback, String s)
    {
        openFileChooser(valuecallback, s, null);
    }

    public void openFileChooser(ValueCallback valuecallback, String s, String s1)
    {
        openFileInput(valuecallback, null);
    }

    ()
    {
        this$0 = ChatSDKWebView.this;
        super();
    }
}
