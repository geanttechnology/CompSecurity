// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.os.Bundle;
import android.webkit.WebView;

// Referenced classes of package com.groupon.activity:
//            AbstractThirdPartyDealWebViewActivity

public class GeneralThirdPartyDealWebViewActivity extends AbstractThirdPartyDealWebViewActivity
{

    public GeneralThirdPartyDealWebViewActivity()
    {
    }

    protected int getLayoutResId()
    {
        return 0x7f0300f4;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    protected void setupWebViewClient()
    {
        webView.setWebViewClient(new AbstractThirdPartyDealWebViewActivity.GeneralThirdPartyDealWebViewClient(this, helper));
    }
}
