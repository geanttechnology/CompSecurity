// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.os.Bundle;
import android.webkit.WebView;
import com.groupon.ConsumerDeviceSettings;
import com.groupon.service.LocationService;
import com.groupon.util.GiaWebViewHelper;
import com.groupon.util.WebViewHelper;
import com.groupon.util.WebViewHelperProvider;

// Referenced classes of package com.groupon.activity:
//            BaseWebViewActivity, IntentFactory

public class GrouponInventoryWebApp extends BaseWebViewActivity
    implements WebViewHelperProvider
{

    private ConsumerDeviceSettings consumerDeviceSettings;
    String dealId;
    private IntentFactory intentFactory;
    private LocationService locationService;
    private boolean supportsTitle;

    public GrouponInventoryWebApp()
    {
        supportsTitle = false;
    }

    public WebViewHelper createHelper()
    {
        return new GiaWebViewHelper(this, dealId, locationService.getBestGuessForLocation(), consumerDeviceSettings.getBcookie());
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setDisplayToolbarTitle(true);
        supportsTitle = true;
    }

    protected void navigationFinished(String s)
    {
        if (supportsTitle)
        {
            setToolbarTitle(webView.getTitle());
        }
    }

    protected void navigationStarted(String s)
    {
        if (((GiaWebViewHelper)helper).isCheckoutComplete(s))
        {
            startActivity(intentFactory.newThanksIntentWithNoMyGrouponsLink(dealId));
        }
    }
}
