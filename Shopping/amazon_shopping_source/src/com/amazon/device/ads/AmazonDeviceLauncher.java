// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

class AmazonDeviceLauncher
{

    AmazonDeviceLauncher()
    {
    }

    static boolean isWindowshopPresent(Context context)
    {
        return context.getPackageManager().getLaunchIntentForPackage("com.amazon.windowshop") != null;
    }

    static void launchWindowshopDetailPage(Context context, String s)
    {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.amazon.windowshop");
        if (intent != null)
        {
            intent.putExtra("com.amazon.windowshop.refinement.asin", s);
            context.startActivity(intent);
        }
    }

    static void launchWindowshopSearchPage(Context context, String s)
    {
        Intent intent = new Intent("android.intent.action.SEARCH");
        intent.setComponent(new ComponentName("com.amazon.windowshop", "com.amazon.windowshop.search.SearchResultsGridActivity"));
        intent.putExtra("query", s);
        try
        {
            context.startActivity(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }
}
