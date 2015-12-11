// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.ofw;

import android.app.ProgressDialog;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.sponsorpay.publisher.ofw:
//            SPOfferWallActivity

class this._cls0 extends WebChromeClient
{

    final SPOfferWallActivity this$0;

    public void onProgressChanged(WebView webview, int i)
    {
        if (i > 50 && SPOfferWallActivity.access$0(SPOfferWallActivity.this) != null)
        {
            SPOfferWallActivity.access$0(SPOfferWallActivity.this).dismiss();
            SPOfferWallActivity.access$1(SPOfferWallActivity.this, null);
        }
        super.onProgressChanged(webview, i);
    }

    ()
    {
        this$0 = SPOfferWallActivity.this;
        super();
    }
}
