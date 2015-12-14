// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.packageupdate;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import java.util.List;

public class ApplicationStore
{
    public static final class Store extends Enum
    {

        private static final Store $VALUES[];
        public static final Store AMAZON_APP_STORE;
        public static final Store GOOGLE_PLAY;
        public static final Store UNKNOWN;

        public static Store valueOf(String s)
        {
            return (Store)Enum.valueOf(com/amazon/gallery/thor/packageupdate/ApplicationStore$Store, s);
        }

        public static Store[] values()
        {
            return (Store[])$VALUES.clone();
        }

        static 
        {
            AMAZON_APP_STORE = new Store("AMAZON_APP_STORE", 0);
            GOOGLE_PLAY = new Store("GOOGLE_PLAY", 1);
            UNKNOWN = new Store("UNKNOWN", 2);
            $VALUES = (new Store[] {
                AMAZON_APP_STORE, GOOGLE_PLAY, UNKNOWN
            });
        }

        private Store(String s, int i)
        {
            super(s, i);
        }
    }


    private final String packageName;
    private final String versionName;

    public ApplicationStore(String s, String s1)
    {
        packageName = s;
        versionName = s1;
    }

    public Intent getInstallIntentFor(Context context, String s, Store store)
    {
        if (store.equals(Store.AMAZON_APP_STORE))
        {
            return newInstallFromAmazonAppStoreIntent(context, s);
        } else
        {
            return newInstallFromGooglePlayIntent(s);
        }
    }

    public Store getStoreAppWasInstalledFrom()
    {
        if (versionName.endsWith("1"))
        {
            return Store.AMAZON_APP_STORE;
        }
        if (versionName.endsWith("g"))
        {
            return Store.GOOGLE_PLAY;
        } else
        {
            return Store.UNKNOWN;
        }
    }

    public Intent getUpdateIntent(Context context)
    {
        Store store = getStoreAppWasInstalledFrom();
        return getInstallIntentFor(context, packageName, store);
    }

    public Intent newInstallFromAmazonAppStoreIntent(Context context, String s)
    {
        context = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("amzn://apps/android?p=").append(s).toString()));
        if (!context.queryIntentActivities(intent, 0).isEmpty())
        {
            return intent;
        } else
        {
            return new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://www.amazon.com/gp/mas/dl/android?p=").append(s).toString()));
        }
    }

    public Intent newInstallFromGooglePlayIntent(String s)
    {
        return new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(s).toString()));
    }
}
