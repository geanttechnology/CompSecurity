// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.interception;

import android.content.Context;
import android.net.Uri;
import com.amazon.mShop.categoryBrowse.CategoryBrowseActivity;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mobile.mash.interception.UrlIntercepterConfigEntry;
import com.amazon.mobile.mash.interception.UrlInterceptionHandler;
import com.amazon.mobile.mash.util.MASHUtil;

public class BrowseInterceptionHandler extends UrlInterceptionHandler
{

    public BrowseInterceptionHandler(Context context, Uri uri, UrlIntercepterConfigEntry urlintercepterconfigentry)
    {
        super(context, uri, urlintercepterconfigentry);
    }

    public boolean handle()
    {
        Uri uri = MASHUtil.canonicalizeUri(getUri(), Uri.parse("https://www.amazon.com/s/browse"), getRefmarker());
        if (uri.getPath().equals(getUri().getPath()) && (getContext() instanceof CategoryBrowseActivity))
        {
            if (ActivityUtils.shouldBrowseRedirect(getContext(), getUri()))
            {
                return true;
            } else
            {
                ((CategoryBrowseActivity)getContext()).getSearchMetadata(getUri().toString());
                return false;
            }
        } else
        {
            return ActivityUtils.startCategoryBrowseActivity(getContext(), uri);
        }
    }
}
