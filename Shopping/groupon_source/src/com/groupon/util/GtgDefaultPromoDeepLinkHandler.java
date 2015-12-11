// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.os.Bundle;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.service.DeepLinkManager;
import com.groupon.service.gdt.GdtService;
import roboguice.util.Strings;

public class GtgDefaultPromoDeepLinkHandler
{

    protected Context context;
    protected DeepLinkManager deepLinkManager;
    protected DeepLinkUtil deepLinkUtil;
    protected GdtService gdtService;
    protected IntentFactory intentFactory;

    public GtgDefaultPromoDeepLinkHandler()
    {
    }

    public void handle(String s)
    {
        if (Strings.isEmpty(s))
        {
            navigateToDefaultGtgWebView();
            return;
        }
        try
        {
            s = deepLinkUtil.getDeepLink(s);
            Bundle bundle = new Bundle();
            bundle.putParcelable("originating_channel", Channel.FEATURED);
            deepLinkManager.followDeepLink(context, s, bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            navigateToDefaultGtgWebView();
        }
    }

    protected void navigateToDefaultGtgWebView()
    {
        context.startActivity(intentFactory.newGrouponWebViewIntent(gdtService.getGtgEntryUrl(), false, true, true, true, false));
    }
}
