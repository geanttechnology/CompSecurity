// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.detail;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.amazon.now.location.Location;
import com.amazon.now.util.AppUtils;
import com.amazon.now.util.DataStore;
import com.amazon.now.web.NowWebView;
import com.amazon.now.web.WebActivity;
import com.amazon.searchapp.retailsearch.client.SearchConfiguration;
import com.amazon.searchapp.retailsearch.client.SearchRealm;

public class DetailsActivity extends WebActivity
{

    public static final String INTENT_ASIN_PATH = "asinPath";
    public static final String PATH = "gp/aw/d/";

    public DetailsActivity()
    {
    }

    protected String getLaunchUrl()
    {
        String s = getIntent().getStringExtra("asinPath");
        if (!TextUtils.isEmpty(s))
        {
            android.net.Uri.Builder builder1 = null;
            android.net.Uri.Builder builder = builder1;
            if (AppUtils.isAppDebuggable(this))
            {
                String s1 = DataStore.getString("detail_page_service_url_key");
                builder = builder1;
                if (!TextUtils.isEmpty(s1))
                {
                    builder = Uri.parse(s1).buildUpon();
                }
            }
            builder1 = builder;
            if (builder == null)
            {
                Object obj = SearchConfiguration.getConfiguration().getRealmByObfuscatedMarketplaceId(Location.getMarketplace());
                builder1 = builder;
                if (obj != null)
                {
                    obj = ((SearchRealm) (obj)).getSecureSiteUrl();
                    builder1 = builder;
                    if (!TextUtils.isEmpty(((CharSequence) (obj))))
                    {
                        obj = Uri.parse(((String) (obj)));
                        builder1 = builder;
                        if (((Uri) (obj)).getHost() != null)
                        {
                            builder1 = builder;
                            if (((Uri) (obj)).getScheme() != null)
                            {
                                builder1 = ((Uri) (obj)).buildUpon();
                            }
                        }
                    }
                }
            }
            builder = builder1;
            if (builder1 == null)
            {
                builder = Uri.parse(AppUtils.getServiceUrl(this)).buildUpon();
            }
            builder.appendEncodedPath((new StringBuilder()).append("gp/aw/d/").append(s).toString());
            return builder.build().toString();
        } else
        {
            return super.getLaunchUrl();
        }
    }

    public void onWebViewReady(NowWebView nowwebview)
    {
        super.onWebViewReady(nowwebview);
        nowwebview.enableLongClick();
    }
}
