// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.metrics.customer;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.amazon.gallery.foundation.metrics.customer.CustomerMetricsInfo;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.network.http.adrive.operations.StorageInformation;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.thor.packageupdate.ApplicationStore;

public abstract class KindleCustomerMetricsInfo
    implements CustomerMetricsInfo
{

    private String appVersionName;
    protected Context context;
    private String customerId;
    private final RestClient restClient;
    private com.amazon.gallery.thor.packageupdate.ApplicationStore.Store store;

    public KindleCustomerMetricsInfo(Context context1, RestClient restclient)
    {
        context = context1;
        restClient = restclient;
    }

    public boolean getAppFirstStartRecorded()
    {
        return context.getSharedPreferences("galleryKindleSharedPrefs", 0).getBoolean("AppFirstStartRecorded", false);
    }

    public String getAppVersionName()
    {
        if (appVersionName == null)
        {
            try
            {
                appVersionName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            }
            catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
            {
                GLogger.ix(TAG, "Could not get package name", namenotfoundexception);
            }
            if (appVersionName == null)
            {
                appVersionName = "0";
            }
        }
        return appVersionName;
    }

    public String getClientTag()
    {
        if (store == null)
        {
            store = (new ApplicationStore(context.getPackageName(), getAppVersionName())).getStoreAppWasInstalledFrom();
        }
        return store.name();
    }

    public String getCustomerId()
    {
        if (customerId == null)
        {
            try
            {
                customerId = ((StorageInformation)restClient.getUserStorageInformation().get()).customerId;
            }
            catch (Exception exception)
            {
                GLogger.i(TAG, "Can't retrieve encoded customer id: %s", new Object[] {
                    exception
                });
            }
            if (customerId == null)
            {
                customerId = "";
            }
        }
        if ("".equals(customerId))
        {
            return null;
        } else
        {
            return customerId;
        }
    }

    public String getDSN()
    {
        return Build.SERIAL;
    }

    public String getModel()
    {
        return Build.PRODUCT;
    }

    public String getPlatform()
    {
        if (BuildFlavors.isAosp())
        {
            return "Android";
        } else
        {
            return "Kindle";
        }
    }

    public String getPlatformVersionName()
    {
        return android.os.Build.VERSION.INCREMENTAL;
    }

    public void reset()
    {
        customerId = null;
    }

    public void setAppFirstStartRecorded()
    {
        context.getSharedPreferences("galleryKindleSharedPrefs", 0).edit().putBoolean("AppFirstStartRecorded", true).apply();
    }
}
