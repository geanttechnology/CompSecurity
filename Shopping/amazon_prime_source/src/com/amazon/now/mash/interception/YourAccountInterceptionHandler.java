// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash.interception;

import android.content.Context;
import android.net.Uri;
import com.amazon.mobile.mash.interception.UrlIntercepterConfigEntry;
import com.amazon.mobile.mash.interception.UrlInterceptionHandler;
import com.amazon.now.mash.NavManager;

public class YourAccountInterceptionHandler extends UrlInterceptionHandler
{

    public YourAccountInterceptionHandler(Context context, Uri uri, UrlIntercepterConfigEntry urlintercepterconfigentry)
    {
        super(context, uri, urlintercepterconfigentry);
    }

    public boolean handle()
    {
        return NavManager.getInstance().navigate(getUri().toString(), getContext());
    }
}
