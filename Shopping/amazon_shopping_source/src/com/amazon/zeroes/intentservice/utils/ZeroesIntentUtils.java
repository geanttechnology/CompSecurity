// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice.utils;

import android.content.Intent;
import com.amazon.zeroes.intentservice.ZeroesService;

public final class ZeroesIntentUtils
{

    public static final String EXTRA_INVALIDATE_CACHE;
    public static final String EXTRA_RESULT;
    public static final String EXTRA_RETRIES;
    public static final String EXTRA_SUCCESS;

    private ZeroesIntentUtils()
    {
    }

    public static Intent createFailureIntent(String s, Intent intent)
    {
        return createFailureIntent(s, intent, null);
    }

    public static Intent createFailureIntent(String s, Intent intent, Object obj)
    {
        return createResponseIntent(s, intent, false, obj);
    }

    public static Intent createResponseIntent(String s, Intent intent, boolean flag, Object obj)
    {
        s = new Intent(s);
        s.putExtras(intent);
        s.putExtra(EXTRA_SUCCESS, flag);
        if (obj != null)
        {
            s.putExtra(EXTRA_RESULT, obj.toString());
        }
        return s;
    }

    public static Intent createSuccessIntent(String s, Intent intent)
    {
        return createSuccessIntent(s, intent, null);
    }

    public static Intent createSuccessIntent(String s, Intent intent, Object obj)
    {
        return createResponseIntent(s, intent, true, obj);
    }

    public static int getRetryCount(Intent intent)
    {
        return intent.getIntExtra(EXTRA_RETRIES, -1);
    }

    public static boolean shouldInvalidateCache(Intent intent)
    {
        return intent.getBooleanExtra(EXTRA_INVALIDATE_CACHE, false);
    }

    static 
    {
        EXTRA_SUCCESS = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".success").toString();
        EXTRA_RESULT = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".result").toString();
        EXTRA_RETRIES = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".retries").toString();
        EXTRA_INVALIDATE_CACHE = (new StringBuilder()).append(ZeroesService.BASE_PACKAGE_NAME).append(".invalidateCache").toString();
    }
}
