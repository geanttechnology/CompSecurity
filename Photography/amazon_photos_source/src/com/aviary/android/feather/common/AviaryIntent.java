// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public final class AviaryIntent
{

    public static final String ACTION_ALERT = "aviary.intent.action.ALERT";
    public static final String ACTION_CDS_DOWNLOAD_EXTRA_ASSETS = "aviary.intent.action.CDS_DOWNLOAD_EXTRA_ASSETS";
    public static final String ACTION_CDS_DOWNLOAD_START = "aviary.intent.action.CDS_DOWNLOAD_START";
    public static final String ACTION_CDS_RESTORE_OWNED_PACKS = "aviary.intent.action.CDS_RESTORE_OWNED_PACKS";
    public static final String ACTION_CDS_RESTORE_USER_ITEMS = "aviary.intent.action.CDS_RESTORE_USER_ITEMS";
    public static final String ACTION_COLLECT_LOGS = "aviary.intent.action.COLLECT_LOGS";
    public static final String ACTION_EDIT = "aviary.intent.action.EDIT";
    public static final String ACTION_MESSAGE = "aviary.intent.ACTION_MESSAGE";
    public static final String ACTION_SUBSCRIPTION = "aviary.intent.action.VIEW_SUBSCRIPTIONS";
    public static final String EXTRA_API_KEY_SECRET = "extra-api-key-secret";
    public static final String EXTRA_BILLING_PUBLIC_KEY = "extra-billing-public-key";
    public static final String EXTRA_DELAY = "extra-delay";
    public static final String EXTRA_DOWNLOAD_EXTRA_ASSETS = "EXTRA_DOWNLOAD_EXTRA_ASSETS";
    public static final String EXTRA_EXCEPTIONS = "EXTRA_EXCEPTIONS";
    public static final String EXTRA_EXECUTE_PLUGGED_ONLY = "EXTRA_EXECUTE_PLUGGED_ONLY";
    public static final String EXTRA_EXECUTE_WIFI_ONLY = "EXTRA_EXECUTE_WIFI_ONLY";
    public static final String EXTRA_FORCE_SYNC = "EXTRA_FORCE_SYNC";
    public static final String EXTRA_LAZY_EXECUTION = "EXTRA_LAZY_EXECUTION";
    public static final String EXTRA_MAX_ITEMS = "EXTRA_MAX_ITEMS";
    public static final String EXTRA_OUTPUT_URI = "extra-output-uri";
    public static final String EXTRA_PACK_ID = "extra-pack-id";
    public static final String EXTRA_PACK_TYPE = "extra-pack-type";
    public static final String EXTRA_PLUGGED = "plugged";
    public static final String EXTRA_WHERE_FROM = "extra-where-from";
    public static final String EXTRA_WIFI_CONNECTED = "EXTRA_WIFI_CONNECTED";
    public static final String SCHEME_TOOL = "tool";

    private AviaryIntent()
    {
    }

    public static Intent createCdsInitIntent(Context context, String s, String s1)
    {
        Intent intent = new Intent("aviary.intent.action.CDS_DOWNLOAD_START");
        intent.putExtra("extra-api-key-secret", s);
        intent.putExtra("extra-billing-public-key", s1);
        intent.setComponent(getCdsServiceComponent(context));
        return intent;
    }

    public static Intent createCdsRestoreAllIntent(Context context, String s, String s1, String s2)
    {
        Intent intent = new Intent("aviary.intent.action.CDS_RESTORE_USER_ITEMS");
        intent.setComponent(getCdsServiceComponent(context));
        intent.putExtra("extra-api-key-secret", s1);
        intent.putExtra("extra-billing-public-key", s2);
        intent.putExtra("type", s);
        return intent;
    }

    public static Intent createCdsRestoreOwnedPacks(Context context, String s, String s1, String s2)
    {
        Intent intent = new Intent("aviary.intent.action.CDS_RESTORE_OWNED_PACKS");
        intent.setComponent(getCdsServiceComponent(context));
        intent.putExtra("extra-api-key-secret", s1);
        intent.putExtra("extra-billing-public-key", s2);
        intent.putExtra("type", s);
        return intent;
    }

    public static Intent createCommonIntent(Context context, String s, Class class1)
    {
        s = new Intent(s);
        s.setComponent(new ComponentName(context, class1));
        return s;
    }

    private static ComponentName getCdsServiceComponent(Context context)
    {
        return new ComponentName(context.getPackageName(), "com.aviary.android.feather.cds.AviaryCdsService");
    }

    public static ComponentName getLogsCollectorComponent(Context context)
    {
        return new ComponentName(context.getPackageName(), "com.aviary.android.feather.services.LogsCollectorService");
    }
}
