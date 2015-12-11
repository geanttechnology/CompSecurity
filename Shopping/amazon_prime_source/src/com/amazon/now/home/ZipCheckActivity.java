// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.home;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.amazon.now.location.LocaleManager;
import com.amazon.now.util.AppUtils;
import com.amazon.now.web.WebActivity;
import java.util.Locale;

public class ZipCheckActivity extends WebActivity
{

    public static final String KEY_ZIPCODE = "keyZipCode";

    public ZipCheckActivity()
    {
    }

    protected String getLaunchUrl()
    {
        Object obj = Uri.parse(AppUtils.getServiceUrl(this)).buildUpon();
        ((android.net.Uri.Builder) (obj)).appendPath("zipCheck");
        ((android.net.Uri.Builder) (obj)).appendPath(LocaleManager.getInstance().getLocale().getCountry().toUpperCase());
        String s = getIntent().getStringExtra("keyZipCode");
        if (!TextUtils.isEmpty(s))
        {
            ((android.net.Uri.Builder) (obj)).appendPath(s);
        }
        String s1 = getIntent().getStringExtra("intentKeyQueryParameters");
        s = ((android.net.Uri.Builder) (obj)).build().toString();
        obj = s;
        if (!TextUtils.isEmpty(s1))
        {
            obj = (new StringBuilder()).append(s).append("?").append(s1).toString();
        }
        return ((String) (obj));
    }
}
