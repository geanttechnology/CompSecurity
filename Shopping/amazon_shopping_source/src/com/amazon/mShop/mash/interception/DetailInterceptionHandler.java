// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.interception;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import com.amazon.mShop.details.web.WebProductDetailsActivity;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.publicurl.PublicURLActivity;
import com.amazon.mShop.util.AttributionUtils;
import com.amazon.mShop.util.Util;
import com.amazon.mobile.mash.constants.WebConstants;
import com.amazon.mobile.mash.interception.UrlIntercepterConfigEntry;
import com.amazon.mobile.mash.interception.UrlInterceptionHandler;
import com.amazon.mobile.mash.util.MASHUtil;

public class DetailInterceptionHandler extends UrlInterceptionHandler
{

    public DetailInterceptionHandler(Context context, Uri uri, UrlIntercepterConfigEntry urlintercepterconfigentry)
    {
        super(context, uri, urlintercepterconfigentry);
    }

    public boolean handle()
    {
        if (getContext() instanceof WebProductDetailsActivity)
        {
            return false;
        }
        Object obj = getContext().getResources().getString(com.amazon.mShop.android.lib.R.string.product_details_web_page_url);
        Object obj1;
        String s;
        if (Uri.parse(((String) (obj))).getPath().equals(getUri().getPath()))
        {
            obj = getUri();
        } else
        {
            obj = (new StringBuilder()).append(((String) (obj))).append(getParam("asin")).toString();
            obj = MASHUtil.canonicalizeUri(getUri(), Uri.parse(((String) (obj))), getRefmarker());
        }
        s = AttributionUtils.getAssociatesTag(AndroidPlatform.getInstance().getApplicationContext());
        obj1 = obj;
        if (!Util.isEmpty(s))
        {
            obj = ((Uri) (obj)).buildUpon();
            ((android.net.Uri.Builder) (obj)).appendQueryParameter("tag", s);
            obj1 = ((android.net.Uri.Builder) (obj)).build();
        }
        obj = new Intent(getContext(), com/amazon/mShop/details/web/WebProductDetailsActivity);
        ((Intent) (obj)).setAction("intentActionStartActivity");
        ((Intent) (obj)).putExtra(WebConstants.getWebViewUrlKey(), ((Uri) (obj1)).toString());
        ((Intent) (obj)).putExtra("Launch_From_Public_Url", getContext() instanceof PublicURLActivity);
        ((Intent) (obj)).putExtra("isFromDetailInterception", true);
        ((Intent) (obj)).putExtra("interceptedAsin", getParam("asin"));
        getContext().startActivity(((Intent) (obj)));
        return true;
    }
}
