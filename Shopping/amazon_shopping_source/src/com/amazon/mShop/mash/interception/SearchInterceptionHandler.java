// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.interception;

import android.content.Context;
import android.net.Uri;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.search.SearchActivity;
import com.amazon.mShop.search.SearchIntentBuilder;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mobile.mash.interception.UrlIntercepterConfigEntry;
import com.amazon.mobile.mash.interception.UrlInterceptionHandler;
import com.amazon.mobile.mash.util.MASHUtil;

public class SearchInterceptionHandler extends UrlInterceptionHandler
{

    public SearchInterceptionHandler(Context context, Uri uri, UrlIntercepterConfigEntry urlintercepterconfigentry)
    {
        super(context, uri, urlintercepterconfigentry);
    }

    public boolean handle()
    {
        if (getContext() instanceof SearchActivity)
        {
            return false;
        } else
        {
            Object obj = MASHUtil.canonicalizeUri(getUri(), Uri.parse("https://www.amazon.com/s"), getRefmarker());
            obj = (new SearchIntentBuilder((AmazonActivity)getContext())).dataUrl(((Uri) (obj)).toString()).build();
            return ActivityUtils.startSearchActivity((AmazonActivity)getContext(), ((android.content.Intent) (obj)));
        }
    }
}
