// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash.interception;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.amazon.mobile.mash.interception.UrlIntercepterConfigEntry;
import com.amazon.mobile.mash.interception.UrlInterceptionHandler;
import com.amazon.now.web.PrimeSignUpActivity;

public class PrimeSignUpInterceptionHandler extends UrlInterceptionHandler
{

    public PrimeSignUpInterceptionHandler(Context context, Uri uri, UrlIntercepterConfigEntry urlintercepterconfigentry)
    {
        super(context, uri, urlintercepterconfigentry);
    }

    public boolean handle()
    {
        if (getContext() instanceof PrimeSignUpActivity)
        {
            return false;
        } else
        {
            Intent intent = new Intent(getContext(), com/amazon/now/web/PrimeSignUpActivity);
            intent.putExtra("intentUrlKey", getUri().toString());
            getContext().startActivity(intent);
            return true;
        }
    }
}
