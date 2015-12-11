// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.amazon.identity.auth.device:
//            AuthPortalUIActivity

class this._cls0 extends WebChromeClient
{

    final AuthPortalUIActivity this$0;

    public void onProgressChanged(WebView webview, int i)
    {
        AuthPortalUIActivity.access$600(AuthPortalUIActivity.this, webview, i);
    }

    ()
    {
        this$0 = AuthPortalUIActivity.this;
        super();
    }
}
