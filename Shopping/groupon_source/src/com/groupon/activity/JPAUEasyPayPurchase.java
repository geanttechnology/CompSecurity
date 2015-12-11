// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.groupon.http.NameValuePair;
import com.groupon.http.SharedPreferencesCookieStore;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentCountryService;
import com.groupon.util.CountryNotSupportedException;
import java.net.HttpCookie;
import java.net.URI;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            ECommercePurchase

public class JPAUEasyPayPurchase extends ECommercePurchase
{

    private static final String COOKIE_STRING_FORMAT = "%s=%s; domain=%s";
    public static final int REQUEST_CODE = 10127;
    private static final String SES_ID = "_ses_id_";
    private String USER_AGENT;
    CurrentCountryManager currentCountryManager;
    CurrentCountryService currentCountryService;
    SharedPreferencesCookieStore sharedPreferencesCookieStore;

    public JPAUEasyPayPurchase()
    {
    }

    protected String getResUrl()
    {
        return termUrl3dsecure;
    }

    protected void setCookies(String s)
    {
        CookieManager cookiemanager;
        Map map;
        map = sharedPreferencesCookieStore.getFilteredCookiesMap();
        if (map.isEmpty())
        {
            break MISSING_BLOCK_LABEL_259;
        }
        CookieSyncManager.createInstance(paymentWebView.getContext());
        cookiemanager = CookieManager.getInstance();
        cookiemanager.removeAllCookie();
        String s1 = currentCountryService.getBaseUrl(currentCountryManager.getCurrentCountry());
        s = s1;
_L2:
        s = URI.create(s).getHost();
        for (Iterator iterator = map.values().iterator(); iterator.hasNext();)
        {
            Iterator iterator2 = ((List)iterator.next()).iterator();
            while (iterator2.hasNext()) 
            {
                HttpCookie httpcookie = (HttpCookie)iterator2.next();
                cookiemanager.setCookie(s, String.format("%s=%s; domain=%s", new Object[] {
                    httpcookie.getName(), httpcookie.getValue(), httpcookie.getDomain()
                }));
                CookieSyncManager.getInstance().sync();
            }
        }

        break; /* Loop/switch isn't completed */
        CountryNotSupportedException countrynotsupportedexception;
        countrynotsupportedexception;
        Ln.e(countrynotsupportedexception);
        if (true) goto _L2; else goto _L1
_L1:
        Iterator iterator1 = nameValuePairs.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            NameValuePair namevaluepair = (NameValuePair)iterator1.next();
            if (Strings.equals(namevaluepair.name, "_ses_id_"))
            {
                cookiemanager.setCookie(s, String.format("%s=%s; domain=%s", new Object[] {
                    namevaluepair.name, namevaluepair.value, s
                }));
            }
        } while (true);
        s = USER_AGENT.replace("Android", "Android Mobile");
        paymentWebView.getSettings().setUserAgentString(s);
        return;
    }

    protected void setResUrl()
    {
        try
        {
            termUrl3dsecure = String.format("http://%s/?jb=interface-aueasypay_result", new Object[] {
                URI.create(currentCountryService.getBaseUrl(currentCountryManager.getCurrentCountry())).getHost()
            });
            return;
        }
        catch (CountryNotSupportedException countrynotsupportedexception)
        {
            return;
        }
    }
}
