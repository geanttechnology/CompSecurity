// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.bitstrips.imoji.ui:
//            AvatarBuilderActivity

class this._cls0 extends WebChromeClient
{

    final AvatarBuilderActivity this$0;

    public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
    {
        displayAlertDialog(s1);
        return true;
    }

    public boolean onJsConfirm(WebView webview, String s, String s1, JsResult jsresult)
    {
        AvatarBuilderActivity.access$000(AvatarBuilderActivity.this, s1, jsresult);
        return true;
    }

    ()
    {
        this$0 = AvatarBuilderActivity.this;
        super();
    }
}
