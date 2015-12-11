// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.embeddedbrowser;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.amazon.mobile.mash.MASHApplication;
import com.amazon.mobile.mash.MASHApplicationFactory;
import com.amazon.mobile.mash.MASHWebView;

public class EmbeddedBrowserWebView extends MASHWebView
{

    public EmbeddedBrowserWebView(Context context)
    {
        super(null, context);
        initializeEmbeddedBrowser();
    }

    private void initializeEmbeddedBrowser()
    {
        setIsInEmbeddedBrowserMode(true);
        String s = MASHApplicationFactory.getInstance().getAppCustomUserAgent();
        WebSettings websettings = getSettings();
        if (!TextUtils.isEmpty(s))
        {
            websettings.setUserAgentString(s);
        }
        websettings.setJavaScriptEnabled(true);
        websettings.setSavePassword(false);
        websettings.setSaveFormData(false);
        websettings.setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
    }

    public boolean isInEmbeddedBrowserMode()
    {
        return true;
    }
}
