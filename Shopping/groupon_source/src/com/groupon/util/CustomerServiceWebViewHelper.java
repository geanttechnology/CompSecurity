// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;

// Referenced classes of package com.groupon.util:
//            WebViewHelper

public class CustomerServiceWebViewHelper extends WebViewHelper
{

    private static final String ANDROID_CLIENT_PARAM = "AndroidClient=true";
    private static final String CUSTOMER_SUPPORT_PATH = "/customer_support";

    public CustomerServiceWebViewHelper(Context context)
    {
        super(context);
    }

    public String getUrl()
    {
        if (currentCountryManager.getCurrentCountry().url != null)
        {
            String s;
            if (currentCountryManager.getCurrentCountry().url.contains("https"))
            {
                s = currentCountryManager.getCurrentCountry().url;
            } else
            {
                s = currentCountryManager.getCurrentCountry().url.replace("http", "https");
            }
            return (new StringBuilder()).append(s).append("/customer_support").append("?").append("AndroidClient=true").toString();
        } else
        {
            return (new StringBuilder()).append(prefs.getString("webview_base_url", "https://www.groupon.com")).append("/customer_support").append("?").append("AndroidClient=true").toString();
        }
    }
}
