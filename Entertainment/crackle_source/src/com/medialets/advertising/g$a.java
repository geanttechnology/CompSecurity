// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.medialets.advertising:
//            g, a

final class  extends WebChromeClient
{

    public final boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
    {
        com.medialets.advertising.a.b((new StringBuilder()).append("Javascript Alert Message: ").append(s1).toString());
        return super.onJsAlert(webview, s, s1, jsresult);
    }

    (g g1)
    {
    }
}
