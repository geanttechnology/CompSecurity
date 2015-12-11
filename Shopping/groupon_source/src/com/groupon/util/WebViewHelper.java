// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.groupon.activity.IntentFactory;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import java.util.HashMap;
import java.util.Map;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public abstract class WebViewHelper
{

    public static final String BASE_URL_US = "https://www.groupon.com";
    protected static final String HEADER_AUTHORIZATION = "Authorization";
    protected static final String HEADER_VALUE_OAUTH = "OAuth";
    private static final String IN_APP_USER_AGENT_HEADER = "app-embedded-web-view";
    protected Context context;
    protected CurrentCountryManager currentCountryManager;
    protected IntentFactory intentFactory;
    protected SharedPreferences prefs;

    public WebViewHelper(Context context1)
    {
        RoboGuice.getInjector(context1).injectMembers(this);
    }

    public static void addInAppUserAgent(WebView webview)
    {
        webview = webview.getSettings();
        String s = webview.getUserAgentString();
        webview.setUserAgentString((new StringBuilder()).append(s).append(" ").append("app-embedded-web-view").toString());
    }

    public Map createWebViewHeaders(String s, String s1)
    {
        HashMap hashmap = new HashMap(3);
        hashmap.put("Authorization", String.format("%s %s", new Object[] {
            "OAuth", s
        }));
        hashmap.put("user-id", s1);
        return hashmap;
    }

    public abstract String getUrl();

    public boolean shouldOverrideUrlLoading(String s)
    {
        return false;
    }

    public void webViewNavigatingStarting(String s)
    {
    }
}
