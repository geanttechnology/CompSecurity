// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.ebay.common.Preferences;
import com.ebay.common.content.EbayCguid;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsHelper;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.activities:
//            ShowWebViewActivity, LinkHandlerActivity

public class HybridWebLandingActivity extends ShowWebViewActivity
{

    public static String EXTRA_FLAG_EXTERNAL = "external";
    public static final String LANDING_PAGE = "webview";
    private static final String TAG = "HybridWeb";
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo log = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("HybridWeb", 3, "Hybrid WebView-based Landing Page");

    public HybridWebLandingActivity()
    {
        urlRewriter = LinkHandlerActivity.SITE_MAPPER;
    }

    static boolean isTrustedLanding(String s)
    {
        Uri uri = Uri.parse(s);
        if (uri != null)
        {
            if (log.isLoggable)
            {
                log.log((new StringBuilder()).append("Validating URL trust: ").append(s).toString());
            }
            s = uri.getScheme();
            if (!TextUtils.isEmpty(s) && s.toLowerCase(Locale.getDefault()).equals("ebay"))
            {
                if (log.isLoggable)
                {
                    log.log("... native deep link (trusted)");
                }
                return true;
            }
            s = uri.getHost();
            if (!TextUtils.isEmpty(s) && s.toLowerCase(Locale.getDefault()).equals("pages.ebay.com") && uri.getPath().toLowerCase(Locale.getDefault()).startsWith("/link/"))
            {
                if (log.isLoggable)
                {
                    log.log("... public deep link (trusted)");
                }
                return true;
            }
            if (s == null)
            {
                if (log.isLoggable)
                {
                    log.log("... relative URL (trust implied from current site)");
                    return false;
                }
            } else
            {
                Object obj = MyApp.getDeviceConfiguration().getWebviewLandingDomainWhitelist();
                s = s.toLowerCase(Locale.getDefault());
                obj = ((List) (obj)).iterator();
                String s1;
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        continue;
                    }
                    s1 = (String)((Iterator) (obj)).next();
                } while (!s.equals(s1) && !s.endsWith((new StringBuilder()).append(".").append(s1).toString()));
                if (log.isLoggable)
                {
                    log.log("... matches DCS-supplied trusted domain, or an eBay Inc domain");
                }
                return true;
            }
        }
        do
        {
            return false;
        } while (!log.isLoggable);
        log.log("... UNTRUSTED");
        return false;
    }

    private void launchInExternalBrowser(Uri uri)
    {
        Uri uri1 = uri;
        if (TextUtils.isEmpty(uri.getScheme()))
        {
            uri1 = Uri.parse((new StringBuilder()).append(Uri.parse(url).getScheme()).append("://").append(uri.toString()).toString());
        }
        if (log.isLoggable)
        {
            log.log((new StringBuilder()).append("Untrusted URL is being launched in an external browser: ").append(uri1.toString()).toString());
        }
        startActivity(new Intent("android.intent.action.VIEW", uri1));
    }

    public void onResume()
    {
        super.onResume();
        TrackingData trackingdata = new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION);
        trackingdata.addKeyValuePair("url", url);
        Object obj = MyApp.getPrefs();
        obj = ((Preferences) (obj)).getCguid(((Preferences) (obj)).isSignedIn());
        if (obj != null)
        {
            trackingdata.addKeyValuePair("asguid", ((EbayCguid) (obj)).toString());
        }
    }

    protected void readIntent()
    {
        super.readIntent();
        impression = "WebViewLandingPage";
        if (getIntent().hasExtra(EXTRA_FLAG_EXTERNAL))
        {
            launchInExternalBrowser(Uri.parse(url));
            finish();
        }
    }

    protected boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (log.isLoggable)
        {
            log.log((new StringBuilder()).append("Loading: ").append(s).toString());
        }
        webview = Uri.parse(s);
        if (webview.getScheme().matches("http[s]?") && !isTrustedLanding(s))
        {
            launchInExternalBrowser(webview);
            return true;
        } else
        {
            return false;
        }
    }

}
