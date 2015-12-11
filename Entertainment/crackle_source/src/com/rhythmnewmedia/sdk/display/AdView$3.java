// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk.display;

import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.rhythmnewmedia.sdk.h;
import com.rhythmnewmedia.sdk.y;
import java.util.Iterator;

// Referenced classes of package com.rhythmnewmedia.sdk.display:
//            AdView

final class a extends WebChromeClient
{

    final AdView a;

    public final boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
    {
        webview = a.getAPIConnectors().iterator();
        boolean flag;
        if (webview.hasNext())
        {
            flag = ((h)webview.next()).a(s1, a);
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            a.handleClick(s1);
        }
        y.a("[JS LOG] %s", new Object[] {
            s1
        });
        jsresult.confirm();
        return true;
    }

    public final boolean onJsPrompt(WebView webview, String s, String s1, String s2, JsPromptResult jspromptresult)
    {
        return false;
    }

    (AdView adview)
    {
        a = adview;
        super();
    }
}
