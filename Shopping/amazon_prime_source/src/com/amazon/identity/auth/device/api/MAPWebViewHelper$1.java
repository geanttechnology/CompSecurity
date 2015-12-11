// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import com.amazon.android.webkit.AmazonWebView;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            MAPWebViewHelper

class this._cls0
    implements Runnable
{

    final MAPWebViewHelper this$0;

    public void run()
    {
        MAPWebViewHelper.access$200(MAPWebViewHelper.this).loadUrl(MAPWebViewHelper.access$100(MAPWebViewHelper.this).returnToURL);
    }

    rameters()
    {
        this$0 = MAPWebViewHelper.this;
        super();
    }
}
