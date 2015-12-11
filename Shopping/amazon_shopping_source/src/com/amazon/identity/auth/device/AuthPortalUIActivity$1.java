// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import com.amazon.android.webkit.AmazonWebChromeClient;
import com.amazon.android.webkit.AmazonWebView;

// Referenced classes of package com.amazon.identity.auth.device:
//            AuthPortalUIActivity

class this._cls0 extends AmazonWebChromeClient
{

    final AuthPortalUIActivity this$0;

    public void onProgressChanged(AmazonWebView amazonwebview, int i)
    {
        AuthPortalUIActivity.access$400(AuthPortalUIActivity.this, amazonwebview, i);
    }

    ()
    {
        this$0 = AuthPortalUIActivity.this;
        super();
    }
}
