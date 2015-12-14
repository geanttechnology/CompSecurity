// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.Toast;
import com.amazon.gallery.foundation.utils.apilevel.Api;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.kindle.auth.mapr5.MapSharedPrefCookieUtils;
import com.amazon.gallery.framework.kindle.metrics.UIClickMetrics;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.account.EndpointManager;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.activity.ManageStorageActivity;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.lang3.StringUtils;

public class GalleryWebViewHelper
{

    private static final AtomicBoolean COOKIE_SYNC_MANAGER_CREATED = new AtomicBoolean(false);
    private static final String TAG = com/amazon/gallery/thor/GalleryWebViewHelper.getName();

    public GalleryWebViewHelper()
    {
    }

    public static String getCookieDomainFromUrl(String s)
        throws MalformedURLException
    {
        return getDomainWithoutWWW((new URL(s)).getHost());
    }

    public static String getDomainWithoutWWW(String s)
    {
        String s1;
        if (s.startsWith("www."))
        {
            s1 = s.substring("www".length());
        } else
        {
            s1 = s;
            if (!s.startsWith("."))
            {
                return (new StringBuilder()).append(".").append(s).toString();
            }
        }
        return s1;
    }

    public static Intent getManageStorageIntent(Context context)
    {
        try
        {
            context = new Intent(context, com/amazon/gallery/thor/app/activity/ManageStorageActivity);
            context.putExtra("URL_EXTRA_KEY", ((RestClient)ThorGalleryApplication.getBean(Keys.REST_CLIENT)).getEndpointManager().getEndpoint().getManageStorageUrl());
            context.putExtra("PAGE_TYPE_KEY", com.amazon.gallery.thor.app.activity.AuthenticatedWebViewActivity.PageType.MANAGE_STORAGE.name());
            context.putExtra("ADD_LEFT_PANEL", true);
            context.putExtra("ADD_ACTION_BAR", true);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            GLogger.ex(TAG, "terminal exception getting manage storage URL", context);
            return null;
        }
        return context;
    }

    public static Intent getPromotionIntent(Activity activity, Class class1, com.amazon.gallery.framework.network.http.rest.account.SubscriptionInfoCache.Promotion promotion)
    {
        activity = new Intent(activity, class1);
        activity.putExtra("URL_EXTRA_KEY", promotion.getUrl());
        activity.putExtra("CUSTOM_HEADER_TEXT_KEY", promotion.getTitle());
        activity.putExtra("PAGE_TYPE_KEY", com.amazon.gallery.thor.app.activity.AuthenticatedWebViewActivity.PageType.PROMOTION.name());
        activity.putExtra("MAKE_VISIBLE_ON_PAGE_FINISHED", false);
        return activity;
    }

    private static void initCookieSyncManager(Context context)
    {
        if (COOKIE_SYNC_MANAGER_CREATED.compareAndSet(false, true))
        {
            CookieSyncManager.createInstance(context.getApplicationContext());
        }
    }

    public static final boolean isInterceptableUrl(String s)
    {
        return !StringUtils.isEmpty(s) && s.contains("/ap/signin");
    }

    public static void setCookies(Context context, String s, String as[])
    {
        CookieManager cookiemanager = CookieManager.getInstance();
        sync(context, cookiemanager);
        (new MapSharedPrefCookieUtils(context)).putCookies(s, as);
        cookiemanager.setAcceptCookie(true);
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            cookiemanager.setCookie(s, as[i]);
        }

        sync(context, cookiemanager);
    }

    public static void startManageStorage(Activity activity)
    {
        if (!((AuthenticationManager)ThorGalleryApplication.getBean(Keys.AUTHENTICATING_MANAGER)).hasActiveAccount())
        {
            activity.startActivity(new Intent("com.amazon.dcp.sso.AddAccount"));
        } else
        if (!((NetworkConnectivity)ThorGalleryApplication.getBean(Keys.NETWORK_CONNECTIVITY)).promptIfOffline(activity))
        {
            ((UIClickMetrics)ThorGalleryApplication.getBean(Keys.UI_METRICS_PROFILER)).trackEvent(com.amazon.gallery.framework.kindle.metrics.UIClickMetrics.MetricsEvent.ManageStorageSettings);
            Intent intent = getManageStorageIntent(activity);
            if (intent == null)
            {
                Toast.makeText(activity, 0x7f0e00f7, 0).show();
                return;
            } else
            {
                activity.startActivity(intent);
                return;
            }
        }
    }

    public static void startPromotion(Activity activity, Class class1, com.amazon.gallery.framework.network.http.rest.account.SubscriptionInfoCache.Promotion promotion)
    {
        activity.startActivity(getPromotionIntent(activity, class1, promotion));
    }

    public static void sync(Context context, CookieManager cookiemanager)
    {
        if (Api.isAtLeastLollipop())
        {
            cookiemanager.flush();
            return;
        } else
        {
            syncCookieSyncManager(context);
            return;
        }
    }

    public static void syncCookieSyncManager(Context context)
    {
        initCookieSyncManager(context);
        CookieSyncManager.getInstance().sync();
    }

}
