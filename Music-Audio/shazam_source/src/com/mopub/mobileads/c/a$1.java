// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads.c;

import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.mopub.common.c.a;

// Referenced classes of package com.mopub.mobileads.c:
//            a

public static final class ult extends WebChromeClient
{

    public final boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
    {
        a.b(s1);
        jsresult.confirm();
        return true;
    }

    public final boolean onJsBeforeUnload(WebView webview, String s, String s1, JsResult jsresult)
    {
        a.b(s1);
        jsresult.confirm();
        return true;
    }

    public final boolean onJsConfirm(WebView webview, String s, String s1, JsResult jsresult)
    {
        a.b(s1);
        jsresult.confirm();
        return true;
    }

    public final boolean onJsPrompt(WebView webview, String s, String s1, String s2, JsPromptResult jspromptresult)
    {
        a.b(s1);
        jspromptresult.confirm();
        return true;
    }

    public ult()
    {
    }
}
